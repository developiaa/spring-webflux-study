package study.developia.reactivestreamImpl.rxjava.single;

import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleExample {
    public static void main(String[] args) {
        getItem()
                .subscribe(new SimpleSingleObserver<>());
    }

    private static Single<Integer> getItem() {
        return Single.create(singleEmitter -> {
            singleEmitter.onSuccess(1);
        });
    }
}
