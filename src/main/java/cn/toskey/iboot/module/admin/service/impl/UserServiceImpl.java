package cn.toskey.iboot.module.admin.service.impl;

import cn.toskey.iboot.module.admin.dao.UserDao;
import cn.toskey.iboot.module.admin.model.User;
import cn.toskey.iboot.module.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    @Override
    public List<User> findAllUser() {
        return baseMapper.selectAllList();
    }

    @Override
    public User getByUserName(String userName) {
        return baseMapper.findByUserName(userName);
    }

}
