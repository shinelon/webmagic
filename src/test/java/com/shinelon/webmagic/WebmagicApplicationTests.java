package com.shinelon.webmagic;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebmagicApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class WebmagicApplicationTests {

    protected static final Logger logger = LoggerFactory.getLogger(WebmagicApplicationTests.class);
}
