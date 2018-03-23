package com.shinelon.webmagic.kahui.bank;

import java.util.HashMap;
import java.util.Map;

public class BankMap {

    private static final Map<Integer, String> BANK_MAP = new HashMap<>();
    // private static final Multimap<Integer, String> BANK_MAP =
    // ArrayListMultimap.create();

    static {
        BANK_MAP.put(1, "工行");
        BANK_MAP.put(2, "招行");
        BANK_MAP.put(3, "中行");
        BANK_MAP.put(4, "广发");
        BANK_MAP.put(5, "交行");
        BANK_MAP.put(6, "华夏");
        BANK_MAP.put(7, "农行");
        BANK_MAP.put(8, "兴业");
        BANK_MAP.put(9, "建行");
        BANK_MAP.put(10, "浦发");
        BANK_MAP.put(11, "民生");
        BANK_MAP.put(12, "北京银行");
        BANK_MAP.put(13, "光大");
        BANK_MAP.put(14, "平安");
        BANK_MAP.put(15, "中信");
        BANK_MAP.put(16, "上海农商");
        BANK_MAP.put(19, "杭州银行");
        BANK_MAP.put(20, "江苏银行");
        BANK_MAP.put(23, "上海银行");
        BANK_MAP.put(24, "花旗");
        BANK_MAP.put(1024, "银联");
        BANK_MAP.put(1026, "邮储");
        BANK_MAP.put(3026, "天津银行");
        BANK_MAP.put(4026, "广州银行");
        BANK_MAP.put(3026, "天津银行");
        BANK_MAP.put(6026, "visa");
        BANK_MAP.put(6027, "万事达");
        BANK_MAP.put(6028, "jcb");
        BANK_MAP.put(6029, "浙商");
        BANK_MAP.put(7026, "北京农商");
        BANK_MAP.put(8026, "汇丰");
        BANK_MAP.put(9026, "美国运通");
        BANK_MAP.put(9027, "广州农商");
        BANK_MAP.put(9028, "渤海银行");
        BANK_MAP.put(9029, "南京银行");

    }

}
