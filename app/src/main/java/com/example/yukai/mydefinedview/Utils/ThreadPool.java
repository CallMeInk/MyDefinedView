package com.example.yukai.mydefinedview.Utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by yukai on 2018/2/22.
 */

public class ThreadPool {

    private Executor executor;

    private ThreadPool(){
        executor = Executors.newFixedThreadPool(10);
    }

    public static ThreadPool getInstance(){
        return ThreadPoolHolder.INSTANCE;
    }

    private static class ThreadPoolHolder{
        private static final ThreadPool INSTANCE = new ThreadPool();
    }

    public void execute(Runnable runnable){
        executor.execute(runnable);
    }

}
