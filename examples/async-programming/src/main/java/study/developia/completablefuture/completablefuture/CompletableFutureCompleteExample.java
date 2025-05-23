package study.developia.completablefuture.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCompleteExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        assert !future.isDone();

        var triggered = future.complete(1);
        assert future.isDone();
        assert triggered;
        assert future.get() == 1;

        triggered = future.complete(2);
        assert future.isDone();
        assert !triggered;
        assert future.get() == 1;
    }
}
