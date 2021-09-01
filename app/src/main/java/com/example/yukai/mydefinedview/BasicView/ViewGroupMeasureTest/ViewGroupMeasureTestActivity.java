package com.example.yukai.mydefinedview.BasicView.ViewGroupMeasureTest;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/2/26.
 */

public class ViewGroupMeasureTestActivity extends Activity implements View.OnClickListener{

    private Button mChangeButton;
    private View mMeasureDisplayView;
    private TextView mTextView1;
    private TextView mTextView2;
    private EditText mEditText1;
    private EditText mEditText2;
    private LinearLayout mTextViewRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_group_measure_test_activity_layout);
        mChangeButton = (Button) findViewById(R.id.change_btn);
        mChangeButton.setOnClickListener(this);
        mMeasureDisplayView = findViewById(R.id.measure_view);
        mTextView1 = (TextView) findViewById(R.id.text_view_1);
        mTextView2 = (TextView) findViewById(R.id.text_view_2);
        mEditText1 = (EditText) findViewById(R.id.edit_text_1);
        mEditText2 = (EditText) findViewById(R.id.edit_text_2);
        mTextViewRoot = (LinearLayout) findViewById(R.id.test_root_view);
    }

    @Override
    public void onClick(View v) {
        String string1 = mEditText1.getText().toString();
        String string2 = mEditText2.getText().toString();
        mTextView1.setText(string1);
        mTextView2.setText(string2);
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mTextViewRoot.measure(w, h);
        int measuredWidth = mTextViewRoot.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams = mMeasureDisplayView.getLayoutParams();
        layoutParams.width = measuredWidth;
        mMeasureDisplayView.setLayoutParams(layoutParams);
    }
}
