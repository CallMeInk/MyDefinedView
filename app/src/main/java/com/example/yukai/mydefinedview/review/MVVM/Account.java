package com.example.yukai.mydefinedview.review.MVVM;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class Account extends BaseObservable {

    private String info;

    @Bindable
    public String getInfo(){
        return this.info;
    }

    public void setInfo(String info){
        this.info = info;
        notifyPropertyChanged(BR.info);
    }

}
