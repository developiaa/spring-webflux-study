package study.developia.webflux.reactor.sequence;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class SequenceGenerateTwiceExample {
    public static void main(String[] args) {
        log.info("start main");
        Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next(state);
                    sink.next(state); // 에러 발생, generate에서 next는 한번만 가능
                    if (state == 9) {
                        sink.complete();
                    }
                    return state + 1;
                }
        ).subscribe(value -> {
            log.info("value: " + value);
        }, error -> {
            log.error("error: " + error);
        }, () -> {
            log.info("complete");
        });
    }
}
