package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/SelectCountryItemView.class */
public class SelectCountryItemView extends RelativeLayout {
    private TextView mCountryCode;
    private TextView mCountryName;

    public SelectCountryItemView(Context context, String str, String str2) {
        super(context);
        initView(str, str2);
    }

    private void initView(String str, String str2) {
        setLayoutParams(new AbsListView.LayoutParams(-1, ResourceManager.dp2px(getContext(), 40)));
        TextView textView = new TextView(getContext());
        this.mCountryName = textView;
        textView.setTextSize(16.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ResourceManager.dp2px(getContext(), 15);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.mCountryName.setGravity(16);
        this.mCountryName.setLayoutParams(layoutParams);
        this.mCountryName.setText(str);
        this.mCountryName.setTextColor(-13421773);
        addView(this.mCountryName);
        TextView textView2 = new TextView(getContext());
        this.mCountryCode = textView2;
        textView2.setTextSize(16.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = ResourceManager.dp2px(getContext(), 40);
        this.mCountryCode.setLayoutParams(layoutParams2);
        this.mCountryCode.setText(str2);
        this.mCountryCode.setTextColor(-11502161);
        this.mCountryCode.setGravity(16);
        addView(this.mCountryCode);
        setContent(str, str2);
    }

    private void setContent(String str, String str2) {
        this.mCountryName.setText(str);
        this.mCountryCode.setText(str2);
    }

    public void updateContent(String str, String str2) {
        setContent(str, str2);
    }
}
