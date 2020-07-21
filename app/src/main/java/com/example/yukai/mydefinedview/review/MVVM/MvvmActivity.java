package com.example.yukai.mydefinedview.review.MVVM;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {

    private ActivityMvvmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        ViewModel viewModel = new ViewModel(getApplication(), binding);
        binding.setViewModel(viewModel);
    }

//    public void onClick(View view){
//        Log.e("yk", "databinding onclick");
//        account.setInfo("after click");
////        binding.setAccount(account);
//    }
}
