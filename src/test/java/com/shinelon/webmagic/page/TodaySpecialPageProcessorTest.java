package com.shinelon.webmagic.page;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.shinelon.webmagic.kahui.model.Special;
import com.shinelon.webmagic.kahui.page.TodaySpecialPageProcessor;
import com.shinelon.webmagic.kahui.pipeline.SpecialPipeline;
import com.shinelon.webmagic.kahui.spider.KahuiSpider;

public class TodaySpecialPageProcessorTest {

    private static final Logger logger = LoggerFactory.getLogger(TodaySpecialPageProcessorTest.class);

    @Test
    public void test() {
        KahuiSpider spider = new KahuiSpider(new TodaySpecialPageProcessor());
        spider.addUrl("http://www.51kahui.com/Youhui/ftodayspecial.html");
        // spider.addUrl("http://www.51kahui.com/Youhui/ftodayspecial_2.html");
        spider.thread(1);
        spider.addPipeline(new SpecialPipeline());
        spider.run();

        SpecialPipeline sp = spider.getSpecialPipeline();
        List<Special> list = sp.getCollected();

        logger.info("list:{}", JSON.toJSONString(list));
    };
}
