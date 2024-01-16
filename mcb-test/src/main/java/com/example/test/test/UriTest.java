package com.example.test.test;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author chunbo.ma.o
 * @since 2023/12/29
 */
public class UriTest {

    public static void main(String[] args) {

        dataTest();
    }


    private static void dataTest() {
        ArrayList<String> list = Lists.newArrayList("aa",
                "aa aa", "https://wideniu「『s.nioint.com/sql_query/sqlquery/",
                "https://wideniu    s.nioint.com/sql_query/sqlquery/");
        for (String s : list) {

            if (!uriCheck(s)) {
                System.out.println("uri -- error:" + s);
            }

            if (!urlCheck(s)) {
                System.out.println("url -- error:" + s);
            }

            if (!regexCheck(s)) {
                System.out.println("regx -- error:" + s);
            }
        }
    }

    private static boolean uriCheck(String s) {
        try {
            new URI(s);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    private static boolean urlCheck(String s) {
        try {
            new URL(s);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    private static boolean regexCheck(String s) {
        if (StringUtils.isBlank(s)) {
            return false;
        }
        String regex = "^(http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
        return s.matches(regex);
    }
}
