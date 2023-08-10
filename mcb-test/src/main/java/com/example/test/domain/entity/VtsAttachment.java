package com.example.test.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.test.base.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 附件表
 * </p>
 *
 * @author chunbo.ma
 * @since 2023-08-10
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("ps_vts_attachment")
public class VtsAttachment extends BaseModel {

    /**
     * 类型: 1. 基础vts test_procedure_attachment
     */
    @TableField("type")
    private Byte type;

    /**
     * 日志对应主表的数据记录id, 不同类型对应不同的relationId，
     */
    @TableField("relation_id")
    private Long relationId;

    /**
     * 文件name
     */
    @TableField("name")
    private String name;

    /**
     * 文件大小
     */
    @TableField("file_size")
    private Long fileSize;

    /**
     * 文件mode
     */
    @TableField("file_mode")
    private String fileMode;

    /**
     * 10：输入的url；20: ps-storage数据url
     */
    @TableField("content")
    private String content;

    /**
     * 10. 手动输入的数据；20. ps-storage的数据
     */
    @TableField("source")
    private Byte source;
}
