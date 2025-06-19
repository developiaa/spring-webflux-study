package study.developia.webflux.reactor.subscribe;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class NoSubscribeExample {
    public static void main(String[] args) {
        log.info("start main");
        // subscribe 하지 않으면 아무것도 실행되지 않음
        Flux.fromIterable(List.of(1, 2, 3, 4, 5))
                .doOnNext(value -> {
                    log.info("value: " + value);
                });
        log.info("end main");
    }
}
