package study.developia.webflux.reactor.sequence;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class SequenceErrorExample {
    public static void main(String[] args) {
        log.info("start main");
        Mono.error(new RuntimeException("mono error"))
                .subscribe(value -> {
                    log.info("mono value: " + value);
                }, error -> {
                    log.error("mono error: " + error);
                });

        Flux.error(new RuntimeException("flux error"))
                .subscribe(value -> {
                    log.info("flux value: " + value);
                }, error -> {
                    log.error("flux error: " + error);
                });
        log.info("end main");
    }
}
