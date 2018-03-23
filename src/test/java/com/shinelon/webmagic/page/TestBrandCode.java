package com.shinelon.webmagic.page;

import org.apache.commons.lang3.StringUtils;

public class TestBrandCode {
    public static void main(String[] args) {
        String b = "http://www.51kahui.com/Youhui/fbdetails-5706399-12.html";
        String a = "http://www.51kahui.com/Youhui/fbdetails-5706399.html";
        // b = StringUtils.remove(b, "http://www.51kahui.com/Youhui/fbdetails-");
        // b = StringUtils.remove(b, ".html");
        // System.out.println(b);
        // b = StringUtils.split(b, "-")[0];
        // System.out.println(b);
        a = StringUtils.remove(a, "http://www.51kahui.com/Youhui/fbdetails-");
        a = StringUtils.remove(a, ".html");
        System.out.println(a);
        a = StringUtils.split(a, "-")[0];
        System.out.println(a);

    }
}
