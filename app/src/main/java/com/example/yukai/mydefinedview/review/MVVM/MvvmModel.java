package com.example.yukai.mydefinedview.review.MVVM;

import java.util.Random;

public class MvvmModel {

    public void getAccountData(String accountName, MvvmCallback mvvmCallback){
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess){
            Account account = new Account();
            account.setInfo(accountName);
            mvvmCallback.onSuccess(account);
        }else{
            mvvmCallback.onFail();
        }
    }

}
