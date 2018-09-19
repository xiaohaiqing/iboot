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
@TableName("sys_user")
public class User extends BaseEntity {

    private String userName;
    private String password;
    private String name;
    private String mobile;
    private String gender;

    private Set<Role> roles = new HashSet<Role>();

}
