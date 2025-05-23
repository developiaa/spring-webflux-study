package study.developia.reactivestreamImpl.reactor.mono;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import study.developia.reactivestreamImpl.reactor.flux.SimpleSubscriber;

import java.util.List;

@Slf4j
public class MonoToFluxExample {
    public static void main(String[] args) {
        log.info("start main");
        getItems().flux()
                .subscribe(new SimpleSubscriber<>(Integer.MAX_VALUE));
        log.info("end main");
    }

    private static Mono<List<Integer>> getItems() {
        return Mono.just(List.of(1, 2, 3, 4, 5));
    }
}
