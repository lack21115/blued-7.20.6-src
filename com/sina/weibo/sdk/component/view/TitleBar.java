package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.utils.ResourceManager;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/TitleBar.class */
public class TitleBar extends RelativeLayout {
    public static final int TITLE_BAR_HEIGHT = 45;
    private ListenerOnTitleBtnClicked mClickListener;
    private TextView mLeftBtn;
    private TextView mTitleText;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/TitleBar$ListenerOnTitleBtnClicked.class */
    public interface ListenerOnTitleBtnClicked {
        void onLeftBtnClicked();
    }

    public TitleBar(Context context) {
        super(context);
        initViews();
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }

    private void initViews() {
        TextView textView = new TextView(getContext());
        this.mLeftBtn = textView;
        textView.setClickable(true);
        this.mLeftBtn.setTextSize(2, 17.0f);
        this.mLeftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 1728020992));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        layoutParams.leftMargin = ResourceManager.dp2px(getContext(), 10);
        layoutParams.rightMargin = ResourceManager.dp2px(getContext(), 10);
        this.mLeftBtn.setLayoutParams(layoutParams);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.component.view.TitleBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TitleBar.this.mClickListener != null) {
                    TitleBar.this.mClickListener.onLeftBtnClicked();
                }
            }
        });
        addView(this.mLeftBtn);
        TextView textView2 = new TextView(getContext());
        this.mTitleText = textView2;
        textView2.setTextSize(2, 18.0f);
        this.mTitleText.setTextColor(-11382190);
        this.mTitleText.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleText.setSingleLine(true);
        this.mTitleText.setGravity(17);
        this.mTitleText.setMaxWidth(ResourceManager.dp2px(getContext(), 160));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mTitleText.setLayoutParams(layoutParams2);
        addView(this.mTitleText);
        setLayoutParams(new ViewGroup.LayoutParams(-1, ResourceManager.dp2px(getContext(), 45)));
        setBackgroundDrawable(ResourceManager.getNinePatchDrawable(getContext(), "weibosdk_navigationbar_background.9.png"));
    }

    public void setLeftBtnBg(Drawable drawable) {
        this.mLeftBtn.setBackgroundDrawable(drawable);
    }

    public void setLeftBtnText(String str) {
        this.mLeftBtn.setText(str);
    }

    public void setTitleBarClickListener(ListenerOnTitleBtnClicked listenerOnTitleBtnClicked) {
        this.mClickListener = listenerOnTitleBtnClicked;
    }

    public void setTitleBarText(String str) {
        this.mTitleText.setText(str);
    }
}
