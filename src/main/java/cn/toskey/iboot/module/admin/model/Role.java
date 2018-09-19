package cn.toskey.iboot.module.admin.model;

import cn.toskey.iboot.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role extends BaseEntity {

    private String roleName;

    private Set<Resource> resources = new HashSet<Resource>();
    private Set<User> users = new HashSet<User>();

}
