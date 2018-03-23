package com.shinelon.webmagic.kahui.page;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.shinelon.webmagic.kahui.model.Special;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.HtmlNode;

/***
 * 51kahui 今日特惠
 *
 * @author syq
 *
 */
public class TodaySpecialPageProcessor implements PageProcessor {
    private static final String listUrl = "http://www\\.51kahui\\.com/Youhui/ftodayspecial(_)?\\d*\\.html";

    private static final String targetUrl = "http://www\\.51kahui\\.com/Youhui/fbdetails-\\d+-?\\d*\\.html";

    private static final String urlPrefix = "http://www.51kahui.com/Youhui/fbdetails-";
    private static final String urlSuffix = ".html";
    private static final String urlSplit = "-";

    private static final Site site = Site.me().setTimeOut(10 * 1000).setRetryTimes(3).setSleepTime(1000).setUserAgent(
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(listUrl).match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@class=\"GG-logoBox\"]").links().regex(targetUrl).all());
            page.addTargetRequests(page.getHtml().links().regex(targetUrl).all());
        } else {
            Special newSpecial = new Special();
            initSpecial(newSpecial, page);
            page.putField("Special", newSpecial);
        }
    }

    private Integer getBankCode(String url) {
        String code = null;
        code = StringUtils.remove(url, urlPrefix);
        code = StringUtils.remove(code, urlSuffix);
        code = StringUtils.split(code, urlSplit)[2];
        if (StringUtils.isNumeric(code)) {
            return Integer.valueOf(code);
        }
        return 0;
    }

    private int getBankIndex(Page page) {
        HtmlNode bankNames = (HtmlNode) (page.getHtml().xpath("//div[@class='bankNameNav']/ol/div/div").xpath("//li"));
        List<String> list = bankNames.all();
        for (int i = 0; i < list.size(); i++) {
            String tmp = list.get(i);
            if (StringUtils.contains(tmp, "class=\"current\"")) {
                return i;
            }
        }
        return 0;
    }

    private Integer getBrandCode(String url) {
        String code = null;
        code = StringUtils.remove(url, urlPrefix);
        code = StringUtils.remove(code, urlSuffix);
        code = StringUtils.split(code, urlSplit)[0];
        if (StringUtils.isNumeric(code)) {
            return Integer.valueOf(code);
        }
        return 0;
    }

    private String getStars(Document doc, int index) {
        Elements stars = doc.select(".titl").get(index).select(".star em");
        double starsNum = stars.stream().mapToDouble(e -> {
            if (e.hasClass("one")) {
                return 1;
            }
            if (e.hasClass("half")) {
                return 0.5;
            }
            return 0;
        }).sum();
        return String.valueOf(starsNum);
    }

    private void initSpecial(Special newSpecial, Page page) {
        int index = getBankIndex(page);
        Document doc = Jsoup.parse(page.getRawText());
        newSpecial.setBankName(doc.select(".bankNameNav").select(".current").text());
        newSpecial.setBankCode(getBankCode(doc.select(".bankNameNav").select(".current a").attr("href")));
        newSpecial.setBrandCode(getBrandCode(page.getRequest().getUrl()));
        newSpecial.setBrandName(doc.select(".jieShao h3").text());
        newSpecial.setTitle(doc.select(".titl").get(index).select("h2").text());
        newSpecial.setStars(getStars(doc, index));
        newSpecial.setDetails(doc.select(".info").get(index).select("p").text());
        newSpecial.setLabels(doc.select(".nRFoot").get(index).select("div div").stream().map(e -> e.text())
                .collect(Collectors.toList()));
        newSpecial.setUrl(page.getRequest().getUrl());
        // newSpecial.setSite(getSite().toString());
        newSpecial.setDate(new Date());
    }
}
