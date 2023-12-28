package com.example.test.test;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author chunbo.ma.o
 * @since 2023/12/7
 */
public class Test1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {

        System.out.println(predictNo(Lists.newArrayList("0000", "00", "000")));
        System.out.println(predictNo(Lists.newArrayList("0")));
        System.out.println(predictNo(Lists.newArrayList("099", "0099", "88")));
        System.out.println(predictNo(Lists.newArrayList("0999", "999", "88")));
        System.out.println(predictNo(Lists.newArrayList("0999", "0099", "88")));
    }

    /**
     * list -> 最大四位，数字前边可以填0，取最大值（相等时，取前边0少的为准）
     *
     * @param list list
     * @return string
     */
    private static String predictNo(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        Integer max = null;
        int temp;
        String pre = "";
        for (String s : list) {
            if (Objects.isNull(max)) {
                max = Integer.valueOf(s);
                pre = StringUtils.replace(s, max.toString(), "", 1);
                continue;
            }
            temp = Integer.parseInt(s);

            if (temp < max) {
                //挑战失败
                continue;
            }

            String tempPre = StringUtils.replace(s, max.toString(), "", 1);
            if (temp > max) {
                //挑战成功
                max = temp;
                pre = tempPre;
                continue;
            }

            //此时数字相等，比较前缀位数
            if (pre.length() <= tempPre.length()) {
                //挑战失败
                continue;
            }
            max = temp;
            pre = tempPre;
        }

        if (Objects.isNull(max)) {
            return null;
        }

        String result = pre + (max + 1);
        //最大长度为4
        return result.length() > 4 ? null : result;
    }
}
