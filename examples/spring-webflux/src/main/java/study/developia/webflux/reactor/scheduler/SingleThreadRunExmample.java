package study.developia.webflux.reactor.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@Slf4j
public class SingleThreadRunExmample {
    public static void main(String[] args) {
        log.info("start main");
        var executor = Executors.newSingleThreadExecutor();
        try {
            executor.submit(() -> {
                Flux.create(sink -> {
                    for (int i = 1; i <= 5; i++) {
                        log.info("next: {}", i);
                        sink.next(i);
                    }
                }).subscribe(value -> {
                    log.info("value: " + value);
                });
            });
        } finally {
            executor.shutdown();
        }
        log.info("end main");


    }
}
