package com.example.yukai.mydefinedview.MyView.MyDanmuView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.Utils.CommonUtils;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;
import com.example.yukai.mydefinedview.Utils.ThreadPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by yukai on 2018/2/22.
 */

public class MyDanmuView extends RelativeLayout{

    private final static int DEFAULT_ROW_NUMBER = 6;
    private final static int INITIAL_TIME_STAMP = -1;
    private final static String MESSAGE_DATA = "message_data";
    private int mScreenWidth;
    private Context mContext;
    private int mRowNum;
    private Random mRandom;
    private HashMap<String, View> mHashMap;
    private long timeStamp;
    private ArrayList<String> mData;
    private volatile boolean isStart;
    private volatile boolean cancleFlag;
    private SendFastTip mSendFastTip;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String text = null;
            if (bundle != null){
                text = bundle.getString(MESSAGE_DATA);
            }
            if (text == null){
                return;
            }
            addItemView(text, INPUT_TYPE.TYPE_OTHERS);
        }
    };

    public MyDanmuView(Context context){
        super(context);
        init(context);
    }

    public MyDanmuView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init(context);
    }

    public MyDanmuView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init(context);
    }

    private void init(Context context){
        mScreenWidth = DeviceUtils.getScreenWidth();
        mContext = context;
        mRowNum = DEFAULT_ROW_NUMBER;
        mHashMap = new HashMap<>();
        setBackgroundColor(Color.parseColor("#00000000"));
        isStart = false;
        timeStamp = INITIAL_TIME_STAMP;
        cancleFlag = false;
        mSendFastTip = new SendFastTip() {
            @Override
            public void showTip() {
                CommonUtils.showToast("发送弹幕过快");
            }
        };
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++){
            final View view = getChildAt(i);
            if (view == null){
                continue;
            }
            RelativeLayout.LayoutParams lp = (LayoutParams) view.getLayoutParams();
            view.layout(mScreenWidth, lp.topMargin, mScreenWidth + view.getMeasuredWidth(), lp.topMargin + view.getMeasuredHeight());
        }
    }

    public void addItemView(String text, int type){
        if (type == INPUT_TYPE.TYPE_USER){
            long currentTime = System.currentTimeMillis();
            if (timeStamp == INITIAL_TIME_STAMP || currentTime - timeStamp > 1000){
                timeStamp = currentTime;
            }else{
                if (mSendFastTip != null){
                    mSendFastTip.showTip();
                }
                return;
            }
        }
        createDanmuItemView(text, type);
    }

    private void createDanmuItemView(String text, int type){
        if (mContext == null){
            return;
        }
        final TextView textView = new TextView(mContext);
        int color = type == INPUT_TYPE.TYPE_USER ? Color.parseColor("#ff0000") : Color.parseColor("#000000");
        textView.setTextColor(color);
        textView.setTextSize(15);
        textView.setText(text);
        int measureWidth  = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int measureHeight = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        textView.measure(measureWidth, measureHeight);
        int width = textView.getMeasuredWidth();
        int height = textView.getMeasuredHeight();
        int row = 0;
        synchronized (this){
            row = getRandomNumber();
            while (!isRowLegal(row, textView)){
                row = getRandomNumber();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = row * (height + DeviceUtils.getPixelFromDp(10));
        textView.setLayoutParams(layoutParams);
        textView.setPadding(DeviceUtils.getPixelFromDp(15), DeviceUtils.getPixelFromDp(2), DeviceUtils.getPixelFromDp(15), DeviceUtils.getPixelFromDp(2));
        addView(textView);
        ViewPropertyAnimator animator = textView.animate().translationXBy(-(mScreenWidth + width + 100));
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                MyDanmuView.this.removeView(textView);
            }
        });
        animator.start();
    }

    private Random getRandomInstance(){
        if (mRandom == null){
            mRandom = new Random();
        }
        return mRandom;
    }

    private int getRandomNumber(){
        return getRandomInstance().nextInt(100) % mRowNum;
    }

    private boolean isRowLegal(int row, View view){
        if (mHashMap == null){
            return false;
        }
        if (row < 0 && row >= mRowNum){
            return false;
        }
        String index = String.valueOf(row);
        View formerView = mHashMap.get(index);
        if (mHashMap.containsKey(index) && formerView != null){
            if (formerView.getX() + formerView.getMeasuredWidth() < mScreenWidth){
                mHashMap.remove(index);
                mHashMap.put(index, view);
                return true;
            }else{
                return false;
            }
        }else{
            mHashMap.put(index, view);
            return true;
        }
    }

    public void setData(ArrayList<String> data){
        if (data == null || isStart){
            return;
        }
        if (mData == null){
            mData = new ArrayList<String>();
        }
        mData.clear();
        mData.addAll(data);
    }

    public void start(){
        if (isStart){
            return;
        }
        isStart = true;
        cancleFlag = false;
        ThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                if (mData == null){
                    return;
                }
                int count = mData.size();
                int index = 0;
                while (!cancleFlag && index < count){
                    Message message = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(MESSAGE_DATA, mData.get(index));
                    message.setData(bundle);
                    mHandler.sendMessage(message);
                    index++;
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void onDestroy(){
        if (mHandler != null){
            mHandler.removeCallbacksAndMessages(null);
        }
        cancleFlag = true;
    }

    public void setRowNumber(int rowNumber){
        mRowNum = rowNumber;
    }

    public void cancel(){
        cancleFlag = true;
        isStart = false;
    }

    public void setSendFastTip(SendFastTip sendFastTip){
        mSendFastTip = sendFastTip;
    }

    public interface INPUT_TYPE{
        int TYPE_OTHERS = 0;
        int TYPE_USER = 1;
    }

    public interface SendFastTip{
        void showTip();
    }

}
