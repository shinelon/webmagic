package com.shinelon.webmagic.service.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.shinelon.webmagic.kahui.model.Special;
import com.shinelon.webmagic.kahui.page.TodaySpecialPageProcessor;
import com.shinelon.webmagic.kahui.pipeline.SpecialPipeline;
import com.shinelon.webmagic.kahui.spider.KahuiSpider;
import com.shinelon.webmagic.service.CrawlerService;

import us.codecraft.webmagic.downloader.HttpClientDownloader;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerServiceImpl.class);

    @Autowired
    @Qualifier("spiderTaskExecutor")
    private ExecutorService executor;
    @Autowired
    @Qualifier("spiderHttpClientDownloader")
    private HttpClientDownloader httpClientDownloader;

    @Override
    public void executeKahui(List<String> urls) {
        if (CollectionUtils.isEmpty(urls)) {
            throw new RuntimeException("urls is empty");
        }
        KahuiSpider spider = new KahuiSpider(new TodaySpecialPageProcessor());
        urls.forEach(e -> {
            spider.addUrl(e);
        });
        spider.thread(executor, 16);
        spider.setDownloader(httpClientDownloader);
        spider.addPipeline(new SpecialPipeline());
        spider.run();

        SpecialPipeline sp = spider.getSpecialPipeline();
        List<Special> list = sp.getCollected();

        logger.info("list:{}", JSON.toJSONString(list));

    }

}
