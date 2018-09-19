package cn.toskey.iboot.module.admin.dao;

import cn.toskey.iboot.module.admin.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BaseMapper<User> {

    List<User> selectAllList();

    User findByUserName(@Param("userName") String userName);

}
