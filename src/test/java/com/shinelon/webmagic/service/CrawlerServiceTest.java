package com.shinelon.webmagic.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shinelon.webmagic.WebmagicApplicationTests;

public class CrawlerServiceTest extends WebmagicApplicationTests {
    @Autowired
    private CrawlerService crawlerService;

    @Test
    public void test() {
        List<String> urls = new ArrayList<>();
        urls.add("http://www.51kahui.com/Youhui/ftodayspecial.html");
        urls.add("http://www.51kahui.com/Youhui/ftodayspecial_2.html");
        urls.add("http://www.51kahui.com/Youhui/ftodayspecial_3.html");
        urls.add("http://www.51kahui.com/Youhui/ftodayspecial_4.html");
        urls.add("http://www.51kahui.com/Youhui/ftodayspecial_5.html");

        crawlerService.executeKahui(urls);
    }
}
