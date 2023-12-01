package com.youzan.androidsdkx5;

import android.content.Context;
import com.youzan.spiderman.html.HtmlCacheStrategy;
import com.youzan.x5web.YZWebSDK;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanPreloader.class */
public class YouzanPreloader {
    public static void preloadCacheFromAsset(Context context, String str) {
        YZWebSDK.preloadCacheFromAsset(context, str);
    }

    public static void preloadHtml(Context context, String str) {
        YZWebSDK.preloadHtml(context, str);
    }

    public static void setHtmlCacheStrategy(HtmlCacheStrategy htmlCacheStrategy) {
        YZWebSDK.setHtmlCacheStrategy(htmlCacheStrategy);
    }
}
