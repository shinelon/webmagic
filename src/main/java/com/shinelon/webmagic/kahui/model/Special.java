package com.shinelon.webmagic.kahui.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Special {

    // 银行名称
    private String bankName;
    // 银行代码
    private Integer bankCode;
    // 品牌名称
    private String brandName;
    // 品牌code
    private Integer brandCode;
    // 优惠标题
    private String title;
    // 优惠详情
    private String details;
    // 优惠备注
    private List<String> labels;
    // 优惠星级
    private String stars;
    // 抓取日期
    private Date date;
    // 抓取网页
    private String url;
    // 抓取网址
    private String site;

    public Integer getBankCode() {
        return bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public Integer getBrandCode() {
        return brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getSite() {
        return site;
    }

    public String getStars() {
        return stars;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBrandCode(Integer brandCode) {
        this.brandCode = brandCode;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this).toString();
    }
}
