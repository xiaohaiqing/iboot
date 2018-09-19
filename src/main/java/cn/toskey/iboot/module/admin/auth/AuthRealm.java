package cn.toskey.iboot.module.admin.auth;

import cn.toskey.iboot.module.admin.model.Resource;
import cn.toskey.iboot.module.admin.model.Role;
import cn.toskey.iboot.module.admin.model.User;
import cn.toskey.iboot.module.admin.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> resourceList = Lists.newArrayList();
        Set<String> roleSet = Sets.newHashSet();

        Set<Role> roles = user.getRoles();
        if(CollectionUtils.isNotEmpty(roles)) {
            for(Role role : roles) {
                roleSet.add(role.getRoleName());
                Set<Resource> resouces = role.getResources();
                if(CollectionUtils.isNotEmpty(resouces)) {
                    for(Resource resource : resouces) {
                        resourceList.add(resource.getPermission());
                    }
                }
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(resourceList);
        info.addRoles(roleSet);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userName = usernamePasswordToken.getUsername();

        User user = userService.getByUserName(userName);

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
