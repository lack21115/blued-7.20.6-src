package com.sina.weibo.sdk.component.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/AppProgressDialog.class */
public class AppProgressDialog extends Dialog {
    private TextView info;
    private ProgressBar myBar;

    public AppProgressDialog(Context context) {
        super(context);
        setCanceledOnTouchOutside(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ResourceManager.dp2px(context, 100), ResourceManager.dp2px(context, 100)));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(-1);
        this.myBar = new ProgressBar(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dp2px = ResourceManager.dp2px(context, 20);
        layoutParams.bottomMargin = dp2px;
        layoutParams.topMargin = dp2px;
        layoutParams.leftMargin = dp2px;
        this.myBar.setLayoutParams(layoutParams);
        linearLayout.addView(this.myBar);
        this.info = new TextView(context);
        setTitle("提示");
        this.info.setTextSize(2, 17.0f);
        this.info.setText("正在处理...");
        this.info.setTextColor(-11382190);
        this.info.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ResourceManager.dp2px(context, 20);
        layoutParams2.rightMargin = ResourceManager.dp2px(context, 20);
        this.info.setLayoutParams(layoutParams2);
        linearLayout.addView(this.info);
        setContentView(linearLayout);
    }

    public void setMessage(String str) {
        this.info.setText(str);
    }
}
