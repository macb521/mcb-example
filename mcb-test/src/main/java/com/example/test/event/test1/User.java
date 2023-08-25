package com.example.test.event.test1;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Data
public class User {

    private String name;
    private Integer age;
    private Date birthday;

    private List<Integer> list;

    public void setList(List<Integer> list) {
        if (CollectionUtils.isEmpty(this.getList())) {
            this.list = list;
        }
    }
}
