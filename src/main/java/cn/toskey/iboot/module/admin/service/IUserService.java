package cn.toskey.iboot.module.admin.service;

import cn.toskey.iboot.module.admin.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {

    List<User> findAllUser();

    User getByUserName(String userName);

}
