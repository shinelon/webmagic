package com.shinelon.webmagic.page;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class CallableTest {
    @Test
    public void test() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Callable<String>> list = Arrays.asList((Callable<String>) () -> "Hello", (Callable<String>) () -> "world",
                (Callable<String>) () -> "test");
        List<Future<String>> futures;
        try {
            futures = executor.invokeAll(list);
            for (Future<String> future : futures) {
                System.out.println((future).get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
