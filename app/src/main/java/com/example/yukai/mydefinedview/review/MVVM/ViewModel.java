package com.example.yukai.mydefinedview.review.MVVM;

import android.app.Application;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.yukai.mydefinedview.BR;
import com.example.yukai.mydefinedview.databinding.ActivityMvvmBinding;

public class ViewModel extends BaseObservable {

    private MvvmModel model;
    private String result;
    private String editString;
    private ActivityMvvmBinding binding;

    public ViewModel(Application application){
        model = new MvvmModel();
    }

    public ViewModel(Application application, ActivityMvvmBinding binding){
        model = new MvvmModel();
        this.binding = binding;
    }

    public void getData(){
        model.getAccountData(editString, new MvvmCallback() {
            @Override
            public void onSuccess(Account account) {
                String info = account.getInfo() + "after";
                setResult(info);
            }

            @Override
            public void onFail() {
                setResult("fail");
            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getEditString() {
        return editString;
    }

    public void setEditString(String editString) {
        this.editString = editString;
        notifyPropertyChanged(BR.editString);
    }

    public void changeEt(){
        setEditString("after change");
    }
}
