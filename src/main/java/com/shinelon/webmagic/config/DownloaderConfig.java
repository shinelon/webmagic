package com.shinelon.webmagic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import us.codecraft.webmagic.downloader.HttpClientDownloader;

@Configuration
public class DownloaderConfig {

    @Bean(name = "spiderHttpClientDownloader")
    public HttpClientDownloader config() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setThread(8);
        // httpClientDownloader.setProxyProvider(proxyProvider);
        return httpClientDownloader;
    }
}
