package study.developia.reactivestreamImpl.rxjava.flowable;

import io.reactivex.rxjava3.core.Flowable;
import lombok.extern.slf4j.Slf4j;
import study.developia.reactivestreamImpl.reactor.flux.SimpleSubscriber;

import java.util.List;

@Slf4j
public class FlowableExample {
    public static void main(String[] args) {
        log.info("start main");
        getItems()
                .subscribe(new SimpleSubscriber<>(Integer.MAX_VALUE));
        log.info("end main");
    }

    private static Flowable<Integer> getItems() {
        return Flowable.fromIterable(List.of(1, 2, 3, 4, 5));
    }
}
