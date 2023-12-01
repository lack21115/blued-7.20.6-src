package com.sina.weibo.sdk.api.share;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/IWeiboHandler.class */
public interface IWeiboHandler {

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/IWeiboHandler$Request.class */
    public interface Request {
        void onRequest(BaseRequest baseRequest);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/IWeiboHandler$Response.class */
    public interface Response {
        void onResponse(BaseResponse baseResponse);
    }
}
