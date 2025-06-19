package study.developia.webflux.reactor.subscribe;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.util.context.Context;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class SubscribeFunctionInterfaceExample {
    public static void main(String[] args) {
        log.info("start main");
        Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        if (integer == 6) {
                            throw new RuntimeException();
                        }
                        log.info("consumer value: " + integer);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        log.error("error consumer error: " + throwable);
                    }
                }, new Runnable() {
                    @Override
                    public void run() {
                        log.info("complete");
                    }
                }, Context.empty());
        log.info("end main");
    }
}
