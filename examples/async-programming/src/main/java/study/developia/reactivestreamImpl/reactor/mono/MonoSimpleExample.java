package study.developia.reactivestreamImpl.reactor.mono;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import study.developia.reactivestreamImpl.reactor.flux.SimpleSubscriber;

@Slf4j
public class MonoSimpleExample {
    @SneakyThrows
    public static void main(String[] args) {
        log.info("start main");
        getItems()
                .subscribe(new SimpleSubscriber<>(Integer.MAX_VALUE));
        log.info("end main");

        Thread.sleep(1000);
    }

    private static Mono<Integer> getItems() {
        return Mono.create(monoSink -> {
            monoSink.success(1);
        });
    }
}
