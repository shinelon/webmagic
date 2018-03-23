package com.shinelon.webmagic.kahui.spider;

import java.util.List;
import java.util.Optional;

import com.shinelon.webmagic.kahui.pipeline.SpecialPipeline;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class KahuiSpider extends Spider {

    public KahuiSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }

    public SpecialPipeline getSpecialPipeline() {
        List<Pipeline> list = super.pipelines;
        Optional<SpecialPipeline> opt = list.stream().filter(e -> e instanceof SpecialPipeline)
                .map(e -> (SpecialPipeline) e).findFirst();
        return opt.orElseThrow(() -> new RuntimeException("SpecialPipeline is null"));
    }

}
