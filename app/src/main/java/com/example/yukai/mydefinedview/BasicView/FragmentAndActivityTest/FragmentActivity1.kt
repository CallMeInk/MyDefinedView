package com.example.yukai.mydefinedview.BasicView.FragmentAndActivityTest

import android.os.Bundle
import android.view.View
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/4/2.
 */
class FragmentActivity1 : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity1_layout)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, Fragment1.newInstance(""), "fragment1")
                    .commitAllowingStateLoss()
        }
        findViewById(R.id.remove_btn).setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val fragment = supportFragmentManager.findFragmentByTag("fragment1")
                fragment ?: return
                supportFragmentManager.beginTransaction()
                        .remove(fragment).commitAllowingStateLoss()
            }
        })
    }

}