package com.example.yukai.mydefinedview.WorkTest.MedalTypeDemoTest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedalTypeDemoActivity extends Activity {

    private TextView textView;
    private MedalView medalView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medal_type_layout);
        textView = (TextView) findViewById(R.id.medal_text);
        //medalView = (MedalView) findViewById(R.id.medal_view);
        SpannableStringBuilder result = new SpannableStringBuilder();
        CharSequence firstLineTextSpan = "asdfasdfasdfasdfasdf";
        result.append(firstLineTextSpan);
        appendMedalData(result);
        result.append("asdfasdfasdfasdf");
        textView.setText(result);
        //medalView.setText(result);
        String url = "tel:" + "123456";

        Intent intent = new Intent();

        intent.setData(Uri.parse(url));

        intent.setAction(Intent.ACTION_DIAL);

// 是否可以处理跳转到拨号的 Intent

        boolean canResolveIntent = intent.resolveActivity(getApplicationContext().getPackageManager()) != null;


        boolean result12 = Build.FINGERPRINT.startsWith("generic")

                || Build.FINGERPRINT.toLowerCase().contains("vbox")

                || Build.FINGERPRINT.toLowerCase().contains("test-keys")

                || Build.MODEL.contains("google_sdk")

                || Build.MODEL.contains("Emulator")

                || Build.SERIAL.equalsIgnoreCase("unknown")

                || Build.SERIAL.equalsIgnoreCase("android")

                || Build.MODEL.contains("Android SDK built for x86")

                || Build.MANUFACTURER.contains("Genymotion")

                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))

                || "google_sdk".equals(Build.PRODUCT)

                || ((TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE))

                .getNetworkOperatorName().toLowerCase().equals("android");

        textView.setText(canResolveIntent+ "   " + result12);
    }

    private void appendMedalData(SpannableStringBuilder result){
        Drawable medalDrawable = getResources().getDrawable(R.drawable.bubble);
        ImageSpan medalImageSpan = null;
        if (medalDrawable != null){
            medalDrawable.setBounds(0, 0, DeviceUtils.getPixelFromDp(14), DeviceUtils.getPixelFromDp(14));
            medalImageSpan = new ImageSpan(medalDrawable);
        }
        String styleTag = "◈";
        result.append(" ");
        result.append(styleTag);
        Pattern patternTag = Pattern.compile(styleTag);
        Matcher matcherTag = patternTag.matcher(result);
        while (matcherTag.find()){
            result.setSpan(medalImageSpan, matcherTag.start(), matcherTag.end(), SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}
