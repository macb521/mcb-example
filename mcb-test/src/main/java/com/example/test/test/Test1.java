package com.example.test.test;

import com.example.test.domain.entity.VtsAttachment;

/**
 * @author chunbo.ma.o
 * @since 2023/12/7
 */
public class Test1 {
    public static void main(String[] args) {
        VtsAttachment vtsAttachment = new VtsAttachment();

        vtsAttachment.setSource(12);
        vtsAttachment.setName("asa");


        System.out.println(vtsAttachment);
    }
}
