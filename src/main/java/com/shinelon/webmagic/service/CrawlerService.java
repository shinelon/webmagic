package com.shinelon.webmagic.service;

import java.util.List;

/***
 * 爬虫入口
 *
 * @author syq
 *
 */
public interface CrawlerService {
    /***
     * 抓取卡惠数据
     * 
     * @param urls
     */
    void executeKahui(List<String> urls);
}
