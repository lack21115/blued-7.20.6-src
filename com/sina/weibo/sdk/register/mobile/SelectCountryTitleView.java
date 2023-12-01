package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/SelectCountryTitleView.class */
public class SelectCountryTitleView extends RelativeLayout {
    private TextView mTitleTv;

    public SelectCountryTitleView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setLayoutParams(new AbsListView.LayoutParams(-1, ResourceManager.dp2px(getContext(), 24)));
        setBackgroundDrawable(ResourceManager.getDrawable(getContext(), "tableview_sectionheader_background.png"));
        TextView textView = new TextView(getContext());
        this.mTitleTv = textView;
        textView.setTextSize(14.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = ResourceManager.dp2px(getContext(), 10);
        this.mTitleTv.setLayoutParams(layoutParams);
        this.mTitleTv.setGravity(3);
        this.mTitleTv.setTextColor(-7171438);
        this.mTitleTv.setGravity(16);
        addView(this.mTitleTv);
    }

    public void setTitle(String str) {
        this.mTitleTv.setText(str);
    }

    public void update(String str) {
        setTitle(str);
    }
}
