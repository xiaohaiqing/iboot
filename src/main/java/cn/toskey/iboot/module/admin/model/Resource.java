package cn.toskey.iboot.module.admin.model;

import cn.toskey.iboot.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_resource")
public class Resource extends BaseEntity {

    private String parentId;

    private String parentIds;

    private String name;

    private String href;

    private String target;

    private String icon;

    private String type;

    private String show;

    private String permission;

}
