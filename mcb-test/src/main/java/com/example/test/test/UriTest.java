package com.example.test.test;

import com.google.common.collect.Lists;

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


    private static void dataTest (){
        ArrayList<String> list = Lists.newArrayList("aa","aa aa","www.baidu.com","https://widenius.nioint.com/sql_query/sqlquery/");
        for (String s : list) {
            try {
                uriCheck(s);
            } catch (URISyntaxException e) {
                System.out.println("uri -- error:" + s);
            }
            try {
                urlCheck(s);
            } catch (MalformedURLException e) {
                System.out.println("url -- error:" + s);
            }
        }
    }

    private static void uriCheck (String s) throws URISyntaxException {
        new URI(s);
    }
    private static void urlCheck (String s) throws MalformedURLException {
        new URL(s);
    }
}
