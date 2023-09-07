package com.example.test.service.impl;

import com.example.test.domain.entity.VtsAttachment;
import com.example.test.domain.mapper.VtsAttachmentMapper;
import com.example.test.service.VtsAttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 附件表 服务实现类
 * </p>
 *
 * @author chunbo.ma
 * @since 2023-08-10
 */
@Service
public class VtsAttachmentServiceImpl extends ServiceImpl<VtsAttachmentMapper, VtsAttachment> implements VtsAttachmentService {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveTest() {
        VtsAttachment vtsAttachment = new VtsAttachment();
        vtsAttachment.setType(1);
        vtsAttachment.setRelationId(1111L);
        vtsAttachment.setName("11");
        vtsAttachment.setContent("1111");
        vtsAttachment.setSource(1);

        save(vtsAttachment);

        System.out.println(saveTestInner());
        return vtsAttachment.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void asyncTest() {
        VtsAttachmentServiceImpl bean = applicationContext.getBean(VtsAttachmentServiceImpl.class);
        for (int i = 0; i < 10; i++) {
            bean.asyncSave(i);
        }
    }

    public void asyncSave(int i){
        VtsAttachment vtsAttachment = new VtsAttachment();
        vtsAttachment.setType(i);
        vtsAttachment.setRelationId(1111L);
        vtsAttachment.setName("11");
        vtsAttachment.setContent(Thread.currentThread().getName());
        vtsAttachment.setSource(1);

        save(vtsAttachment);

        if (i == 9){
            throw new RuntimeException();
        }
    }


    private Long saveTestInner (){
        VtsAttachment vtsAttachment = new VtsAttachment();
        vtsAttachment.setType(2);
        vtsAttachment.setRelationId(2222L);
        vtsAttachment.setName("22");
        vtsAttachment.setContent("2222");
        vtsAttachment.setSource(2);

        save(vtsAttachment);

        return vtsAttachment.getId();
    }
}
