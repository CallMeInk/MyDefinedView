package com.example.yukai.mydefinedview.rxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yukai.mydefinedview.R;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class RxjavaActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
//        rxjavaTest1();
//        rxjavaTest2();
//        rxjavaTest3();
        rxjavaTest4();
    }

    private void rxjavaTest1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                Log.e("yk", "onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                if (value == 2) {
                    disposable.dispose();
                }
                Log.e("yk", "onNext::" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("yk", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("yk", "onComplete");
            }
        });
    }

    private void rxjavaTest2() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("yk", "subscribe");
                Log.e("yk", "curThread::" + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onComplete();
            }
        });

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e("yk", "accept::value::" + integer);
                Log.e("yk", "curThread::" + Thread.currentThread().getName());
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("yk", "do on next");
                        Log.e("yk", "curThread::" + Thread.currentThread().getName());
                    }
                })
                .subscribe(consumer);
    }

    private void rxjavaTest3() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("yk", "observable1 onNext 1");
                e.onNext(1);
                Log.e("yk", "observable1 onNext 2");
                e.onNext(2);
                Log.e("yk", "observable1 onNext 3");
                e.onNext(3);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.e("yk", "observable2 onNext A");
                e.onNext("A");
                Log.e("yk", "observable2 onNext B");
                e.onNext("B");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("yk", "onSubscribe");
            }

            @Override
            public void onNext(String value) {
                Log.e("yk", "onNext::" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("yk", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("yk", "onComplete");
            }
        });
    }

    private void rxjavaTest4() {
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                s.request(Long.MAX_VALUE);
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.e("yk", "onError");
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }
}
