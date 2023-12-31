package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.utils.ResourceManager;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/CommentComponentView.class */
public class CommentComponentView extends FrameLayout {
    private static final String ALREADY_COMMENT_EN = "Comment";
    private static final String ALREADY_COMMENT_ZH_CN = "微博热评";
    private static final String ALREADY_COMMENT_ZH_TW = "微博熱評";
    private static final String COMMENT_H5 = "http://widget.weibo.com/distribution/socail_comments_sdk.php";
    private RequestParam mCommentParam;
    private LinearLayout mContentLy;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/CommentComponentView$Category.class */
    public enum Category {
        MOVIE("1001"),
        TRAVEL("1002");
        
        private String mVal;

        Category(String str) {
            this.mVal = str;
        }

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Category[] valuesCustom() {
            Category[] valuesCustom = values();
            int length = valuesCustom.length;
            Category[] categoryArr = new Category[length];
            System.arraycopy(valuesCustom, 0, categoryArr, 0, length);
            return categoryArr;
        }

        public String getValue() {
            return this.mVal;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/CommentComponentView$RequestParam.class */
    public static class RequestParam {
        private String mAccessToken;
        private String mAppKey;
        private WeiboAuthListener mAuthlistener;
        private Category mCategory;
        private String mContent;
        private String mTopic;

        private RequestParam() {
        }

        public static RequestParam createRequestParam(String str, String str2, String str3, Category category, WeiboAuthListener weiboAuthListener) {
            RequestParam requestParam = new RequestParam();
            requestParam.mAppKey = str;
            requestParam.mTopic = str2;
            requestParam.mContent = str3;
            requestParam.mCategory = category;
            requestParam.mAuthlistener = weiboAuthListener;
            return requestParam;
        }

        public static RequestParam createRequestParam(String str, String str2, String str3, String str4, Category category, WeiboAuthListener weiboAuthListener) {
            RequestParam requestParam = new RequestParam();
            requestParam.mAppKey = str;
            requestParam.mAccessToken = str2;
            requestParam.mTopic = str3;
            requestParam.mContent = str4;
            requestParam.mCategory = category;
            requestParam.mAuthlistener = weiboAuthListener;
            return requestParam;
        }
    }

    public CommentComponentView(Context context) {
        super(context);
        init(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execAttented() {
        WbAppActivator.getInstance(getContext(), this.mCommentParam.mAppKey).activateApp();
        WidgetRequestParam widgetRequestParam = new WidgetRequestParam(getContext());
        widgetRequestParam.setUrl(COMMENT_H5);
        widgetRequestParam.setSpecifyTitle(ResourceManager.getString(getContext(), ALREADY_COMMENT_EN, ALREADY_COMMENT_ZH_CN, ALREADY_COMMENT_ZH_TW));
        widgetRequestParam.setAppKey(this.mCommentParam.mAppKey);
        widgetRequestParam.setCommentTopic(this.mCommentParam.mTopic);
        widgetRequestParam.setCommentContent(this.mCommentParam.mContent);
        widgetRequestParam.setCommentCategory(this.mCommentParam.mCategory.getValue());
        widgetRequestParam.setAuthListener(this.mCommentParam.mAuthlistener);
        widgetRequestParam.setToken(this.mCommentParam.mAccessToken);
        Bundle createRequestParamBundle = widgetRequestParam.createRequestParamBundle();
        Intent intent = new Intent(getContext(), WeiboSdkBrowser.class);
        intent.putExtras(createRequestParamBundle);
        getContext().startActivity(intent);
    }

    private void init(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.mContentLy = linearLayout;
        linearLayout.setOrientation(0);
        this.mContentLy.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(ResourceManager.getDrawable(context, "sdk_weibo_logo.png"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ResourceManager.dp2px(getContext(), 20), ResourceManager.dp2px(getContext(), 20));
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setText(ResourceManager.getString(context, ALREADY_COMMENT_EN, ALREADY_COMMENT_ZH_CN, ALREADY_COMMENT_ZH_TW));
        textView.setTextColor(-32256);
        textView.setTextSize(2, 15.0f);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = ResourceManager.dp2px(getContext(), 4);
        textView.setLayoutParams(layoutParams2);
        this.mContentLy.addView(imageView);
        this.mContentLy.addView(textView);
        addView(this.mContentLy);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.component.view.CommentComponentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommentComponentView.this.execAttented();
            }
        });
    }

    public void setCommentParam(RequestParam requestParam) {
        this.mCommentParam = requestParam;
    }
}
