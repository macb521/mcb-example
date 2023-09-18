package com.example.test.req;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author chunbo.ma.o
 * @since 2023/8/14
 */
@Data
public class VtsAttachmentReq {
    /**
     * 类型: 1. 基础vts test_procedure_attachment
     */
    private Integer type;

    /**
     * 日志对应主表的数据记录id, 不同类型对应不同的relationId，
     */
    private Long relationId;

    /**
     * 文件name
     */
    private String name;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 文件mode
     */
    private String fileMode;

    /**
     * 10：输入的url；20: ps-storage数据url
     */
    private String content;

    /**
     * 10. 手动输入的数据；20. ps-storage的数据
     */
    private Integer source;
}
