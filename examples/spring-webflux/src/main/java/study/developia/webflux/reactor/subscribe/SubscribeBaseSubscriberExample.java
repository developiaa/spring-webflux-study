package study.developia.webflux.reactor.subscribe;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class SubscribeBaseSubscriberExample {
    public static void main(String[] args) {
        log.info("start main");

        var subscriber = new BaseSubscriber<Integer>() {
            /**
             * hookOnSubscribe 를 구현하지 않으면 기본적으로 unbounded request
             * @param value
             */
            @Override
            protected void hookOnNext(Integer value) {
                log.info("value: " + value);
            }

            @Override
            protected void hookOnComplete() {
                log.info("complete");
            }
        };

        Flux.fromIterable(List.of(1, 2, 3, 4, 5))
                .subscribe(subscriber);

        subscriber.request(1);
        subscriber.cancel();
        log.info("end main");
    }
}
