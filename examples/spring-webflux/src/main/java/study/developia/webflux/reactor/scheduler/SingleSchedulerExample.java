package study.developia.webflux.reactor.scheduler;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class SingleSchedulerExample {
    @SneakyThrows
    public static void main(String[] args) {
        log.info("start main");
        for (int i = 0; i < 100; i++) {
            final int idx = i;
            Flux.create(sink -> {
                log.info("next: {}", idx);
                sink.next(idx);
            }).subscribeOn(
                    Schedulers.single()
            ).subscribe(value -> {
                log.info("value: " + value);
            });
        }
        Thread.sleep(1000);
        log.info("end main");
    }
}
