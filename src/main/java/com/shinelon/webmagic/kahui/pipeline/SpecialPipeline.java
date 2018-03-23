package com.shinelon.webmagic.kahui.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shinelon.webmagic.kahui.model.Special;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.CollectorPipeline;

public class SpecialPipeline implements CollectorPipeline<Special> {

    private static final Logger logger = LoggerFactory.getLogger(SpecialPipeline.class);

    private List<Special> list = new ArrayList<>();

    @Override
    public List<Special> getCollected() {
        return list;
    }

    @Override
    public synchronized void process(ResultItems resultItems, Task task) {
        Map<String, Object> map = resultItems.getAll();
        if (map.isEmpty()) {
            return;
        }
        Object obj = resultItems.get("Special");
        list.add((Special) obj);
    }

}
