package com.sina.weibo.sdk.api.share;

import android.content.Context;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/IVersionCheckHandler.class */
interface IVersionCheckHandler {
    boolean checkRequest(Context context, WeiboAppManager.WeiboInfo weiboInfo, WeiboMessage weiboMessage);

    boolean checkRequest(Context context, WeiboAppManager.WeiboInfo weiboInfo, WeiboMultiMessage weiboMultiMessage);

    boolean checkResponse(Context context, String str, WeiboMessage weiboMessage);

    boolean checkResponse(Context context, String str, WeiboMultiMessage weiboMultiMessage);
}
