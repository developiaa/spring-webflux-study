package study.developia.webflux.reactor.sequence;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class SequenceEmptyExample {
    public static void main(String[] args) {
        log.info("start main");
        Mono.empty()
                .subscribe(value -> {
                    log.info("mono value: " + value);
                }, null, () -> {
                    log.info("mono complete");
                });
        Flux.empty()
                .subscribe(value -> {
                    log.info("flux value: " + value);
                }, null, () -> {
                    log.info("flux complete");
                });
        log.info("end main");
    }
}
