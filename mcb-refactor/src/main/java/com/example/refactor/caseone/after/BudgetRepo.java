package com.example.refactor.caseone.after;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.time.YearMonth;
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/6/2
 */
public class BudgetRepo {
    public List<Budget> findAll() {
        return Lists.newArrayList(
                new Budget(YearMonth.of(2023,4),30L),
                new Budget(YearMonth.of(2023,5),310L),
                new Budget(YearMonth.of(2023,6),3000L),
                new Budget(YearMonth.of(2023,7),3100L),
                new Budget(YearMonth.of(2023,8),3100L),
                new Budget(YearMonth.of(2023,9),3000L)
        );
    }
    public static void main(String[] args) {
        testtt(Lists.newArrayList(),1);
        testtt(Lists.newArrayList(),0);
        testtt(Lists.newArrayList("aaa"),1);
        testtt(Lists.newArrayList("aaa"),2);
        testtt(Lists.newArrayList("aaa","bbb","ccc","eee","dddd"),1);
        testtt(Lists.newArrayList("aaa","bbb","ccc","eee","dddd"),2);
        testtt(Lists.newArrayList("aaa","bbb","ccc","eee","dddd"),3);
        testtt(Lists.newArrayList("aaa","bbb","ccc","eee","dddd"),4);
    }

    private static void testtt (List<String> list,int pageNum){
        List<List<String>> partition = Lists.partition(list, 2);
        List<String> rows =  pageNum > partition.size() || pageNum < 1 ?   Lists.newArrayList() : partition.get(pageNum - 1);
        System.out.println(JSON.toJSONString(rows));
    }
}
