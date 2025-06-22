package study.developia.webflux.reactor.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class OnErrorReturnAfterExecuteExample {
    public static void main(String[] args) {
        log.info("start main");
        Flux.just(1)
                .onErrorReturn(shouldDoOnError())
                .subscribe(value -> {
                    log.info("value: " + value);
                });
        log.info("end main");
    }

    private static int shouldDoOnError() {
        // 에러가 발생하지 않더라도 함수가 실행됨
        log.info("shouldDoOnError");
        return 0;
    }
}
