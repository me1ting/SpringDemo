package com.example.mysqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    CreditService creditService;

    @Override
    public void run(String... args) throws Exception {
        test();
        System.exit(0);
    }

    public void test() throws InterruptedException {
        final var latch = new CountDownLatch(10);
        var executors = Executors.newFixedThreadPool(10);
        for (var i = 0; i < 10; i++) {
            executors.submit(() -> {
                try {
                    //creditService.updateCredit1();
                    creditService.updateCredit2();
                    //creditService.updateCredit3();
                    //creditService.transTest();
                } catch (Exception e) {
                    System.out.println(e);
                }
                latch.countDown();
            });
        }
        latch.await();
    }
}
