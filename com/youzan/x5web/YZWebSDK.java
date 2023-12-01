package com.youzan.x5web;

import android.content.Context;
import com.youzan.spiderman.cache.SpiderCacheCallback;
import com.youzan.spiderman.cache.SpiderMan;
import com.youzan.spiderman.html.HtmlCacheStrategy;
import com.youzan.spiderman.utils.StringUtils;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/YZWebSDK.class */
public class YZWebSDK {
    private static String sProjectImgDir;

    public static String getProjectImgDir() {
        return sProjectImgDir;
    }

    public static void init(Context context, String str) {
        init(context, str, null);
    }

    public static void init(Context context, String str, SpiderCacheCallback spiderCacheCallback) {
        if (context == null || StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params should be valid when init web sdk");
        }
        SpiderMan.getInstance().init(context, str, spiderCacheCallback);
    }

    public static void preInitX5(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context should not be null when pre-init x5 core");
        }
        X5Util.preinitX5Environment(context);
    }

    public static void preloadCacheFromAsset(Context context, String str) {
        SpiderMan.getInstance().preloadZipFromAsset(context, str);
    }

    public static void preloadHtml(Context context, String str) {
        SpiderMan.getInstance().fetchHtml(context, str, null);
    }

    public static void preloadModifyFromRemote(Context context) {
        SpiderMan.getInstance().preloadModifyFromRemote(context);
    }

    public static void setCacheCallback(SpiderCacheCallback spiderCacheCallback) {
        SpiderMan.getInstance().setWeakRefCacheCallback(spiderCacheCallback);
    }

    public static void setCacheEnable(boolean z) {
        SpiderMan.setEnable(z);
    }

    public static void setHtmlCacheStrategy(HtmlCacheStrategy htmlCacheStrategy) {
        SpiderMan.getInstance().setHtmlCacheStrategy(htmlCacheStrategy);
    }

    public static void setProjectImgDir(String str) {
        sProjectImgDir = str;
    }

    public static void syncToken(String str) {
        SpiderMan.getInstance().sync(str);
    }
}
