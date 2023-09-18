package com.example.test.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Data
public class BaseModel implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户编号
     */
    @TableField("lessee_code")
    private String lesseeCode;

    /**
     * 删除状态，0未删除，1已删除
     */
    @TableField("delete_status")
    private Integer deleteStatus;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 创建人域账号
     */
    @TableField("create_account")
    private String createAccount;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 更新人域账号
     */
    @TableField("update_account")
    private String updateAccount;
}
