package com.example.test.controller;

import com.example.mcbcommon.result.RespResult;
import com.example.test.domain.entity.VtsAttachment;
import com.example.test.service.VtsAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 附件表 前端控制器
 * </p>
 *
 * @author chunbo.ma
 * @since 2023-08-10
 */
@RestController
@RequestMapping("/vtsAttachment")
public class VtsAttachmentController {
    @Autowired
    private VtsAttachmentService vtsAttachmentService;

    @GetMapping("/selectById")
    public RespResult<VtsAttachment> selectById (@RequestParam("id") Long id){
        return RespResult.success(vtsAttachmentService.getById(id));
    }

    @PostMapping("/save")
    public RespResult<Long> save (){
        return RespResult.success(vtsAttachmentService.saveTest());
    }

    @GetMapping("/async_test")
    public RespResult<Void> asyncTest (){
        vtsAttachmentService.asyncTest();
        return RespResult.success();
    }

}
