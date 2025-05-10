package study.developia.reactivestreamImpl.reactor.mono;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import study.developia.reactivestreamImpl.reactor.flux.SimpleSubscriber;

import java.util.List;

@Slf4j
public class FluxToMonoExample {
    public static void main(String[] args) {
        log.info("start main");
        // Flux를 Mono로 바꾸고 첫번째 값만 전달
        Mono.from(getItems())
                .subscribe(new SimpleSubscriber<>(Integer.MAX_VALUE));
        log.info("end main");
    }

    private static Flux<Integer> getItems() {
        return Flux.fromIterable(List.of(1, 2, 3, 4, 5));
    }
}
