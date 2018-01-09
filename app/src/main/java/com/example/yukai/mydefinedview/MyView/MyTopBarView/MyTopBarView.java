package com.example.yukai.mydefinedview.MyView.MyTopBarView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.CommonUtils;

/**
 * Created by yukai on 2017/10/16.
 */

public class MyTopBarView extends RelativeLayout{

    private Context mContext;
    private AttributeSet mAttributeSet;

    private String mTitle;
    private float mTitleTextSize;
    private int mTitleColor;

    private String mLeftText;
    private Drawable mLeftBackground;
    private int mLeftTextColor;

    private String mRightText;
    private Drawable mRightBackground;
    private int mRightTextColor;

    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleView;

    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;

    private MyTopbarClickListener mMyTopbarClickListener;

    public MyTopBarView(Context context){
        super(context);
        mContext = context;
    }

    public MyTopBarView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        mContext = context;
        mAttributeSet = attributeSet;
        initAttrs();
    }

    public MyTopBarView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        mContext = context;
        mAttributeSet = attributeSet;
        initAttrs();
    }

    private void initAttrs(){
        if (mContext == null || mAttributeSet == null){
            return;
        }

        TypedArray ta = mContext.obtainStyledAttributes(mAttributeSet, R.styleable.TopBar);
        mTitle = ta.getString(R.styleable.TopBar_title);
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 0);
        mTitleColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);

        mLeftText = ta.getString(R.styleable.TopBar_leftText);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackGround);
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);

        mRightText = ta.getString(R.styleable.TopBar_rightText);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);

        ta.recycle();
        initView();
    }

    private void initView(){
        mLeftButton = new Button(mContext);
        mRightButton = new Button(mContext);
        mTitleView = new TextView(mContext);

        mLeftButton.setText(mLeftText);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setTextColor(mLeftTextColor);

        mRightButton.setText(mRightText);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setTextColor(mRightTextColor);

        mTitleView.setText(mTitle);
        mTitleView.setTextSize(CommonUtils.px2dip(mContext, mTitleTextSize));
        mTitleView.setTextColor(mTitleColor);

        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyTopbarClickListener.leftClick();
            }
        });
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyTopbarClickListener.rightClick();
            }
        });
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);
    }

    public interface MyTopbarClickListener{
        public void leftClick();
        public void rightClick();
    }

    public void setMyTopBarClicklistener(MyTopbarClickListener myTopBarClicklistener){
        this.mMyTopbarClickListener = myTopBarClicklistener;
    }
}
