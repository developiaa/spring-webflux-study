package study.developia.completablefuture.completablefuture;

import lombok.extern.slf4j.Slf4j;
import study.developia.completablefuture.completionstage.Helper;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableFutureAnyOfExample {
    public static void main(String[] args) throws InterruptedException {
        var startTime = System.currentTimeMillis();
        var firstFuture = Helper.waitAndReturn(100, 1);
        var secondFuture = Helper.waitAndReturn(500, 2);
        var thirdFuture = Helper.waitAndReturn(1000, 3);

        CompletableFuture.anyOf(firstFuture, secondFuture, thirdFuture)
                .thenAcceptAsync(v -> {
                    log.info("after anyOf");
                    log.info("first value: {}", v);
                }).join();

        var endTime = System.currentTimeMillis();
        log.info("elapsed: {}ms", endTime - startTime);
    }
}
