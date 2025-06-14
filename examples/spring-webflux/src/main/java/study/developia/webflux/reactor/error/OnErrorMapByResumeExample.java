package study.developia.webflux.reactor.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Slf4j
public class OnErrorMapByResumeExample {
    private static class CustomBusinessException extends RuntimeException {
        public CustomBusinessException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        log.info("start main");
        Flux.error(new IOException("fail to read file"))
                .onErrorResume(e ->
                        Flux.error(new CustomBusinessException("custom")))
                .subscribe(value -> {
                            log.info("value: " + value);
                        }, e -> {
                            log.info("error: " + e);
                        }
                );
        log.info("end main");
    }
}
