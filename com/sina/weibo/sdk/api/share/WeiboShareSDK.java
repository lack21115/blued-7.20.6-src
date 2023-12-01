package com.sina.weibo.sdk.api.share;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/WeiboShareSDK.class */
public class WeiboShareSDK {
    public static IWeiboShareAPI createWeiboAPI(Context context, String str) {
        return createWeiboAPI(context, str, false);
    }

    public static IWeiboShareAPI createWeiboAPI(Context context, String str, boolean z) {
        return new WeiboShareAPIImpl(context, str, false);
    }
}
