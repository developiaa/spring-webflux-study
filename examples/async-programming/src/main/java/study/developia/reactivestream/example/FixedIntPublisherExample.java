package study.developia.reactivestream.example;

import lombok.SneakyThrows;

import java.util.concurrent.Flow;

public class FixedIntPublisherExample {
    @SneakyThrows
    public static void main(String[] args) {
        Flow.Publisher publisher = new FixedIntPublisher();
        Flow.Subscriber subscriber = new RequestNSubscriber<>(3);
        publisher.subscribe(subscriber);

        Thread.sleep(100);
    }
}

/**
 * n == 3
 * 11:16:30.399 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- item: value=1, requestCount=1
 * 11:16:30.403 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- send request
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- item: value=2, requestCount=2
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- item: value=3, requestCount=2
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- item: value=4, requestCount=2
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- send request
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- item: value=5, requestCount=3
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- item: value=6, requestCount=3
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- item: value=7, requestCount=3
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- send request
 * 11:16:30.404 [pool-1-thread-1] INFO study.developia.reactivestream.example.RequestNSubscriber -- complete
 */
