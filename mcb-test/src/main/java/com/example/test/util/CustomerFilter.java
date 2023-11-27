package com.example.test.util;

import com.example.test.req.TestReq;

/**
 * @author chunbo.ma.o
 * @since 2023/11/27
 */
public class CustomerFilter {

    private static final int NUM = 8;

    private final byte[] map;

    private final int size;

    public CustomerFilter(int size) {
        this.size = size;
        this.map = new byte[size / NUM];
    }

    public void add(Object obj) {
        int i = obj.hashCode();
        int index = i / NUM;
        int bitIndex = i % 8;
        this.map[index] = (byte) (this.map[index] | 1 << bitIndex);
    }

    public boolean contains (Object obj){
        int i = obj.hashCode();
        int index = i / NUM;
        int bitIndex = i % 8;
        System.out.println(this.map[index]);
        return (this.map[index] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        CustomerFilter customerFilter = new CustomerFilter(8);
        TestReq testReq = new TestReq();
        testReq.setId(12L);
        System.out.println(customerFilter.contains(7));
        customerFilter.add(7);
        System.out.println(customerFilter.contains(7));


    }
}
