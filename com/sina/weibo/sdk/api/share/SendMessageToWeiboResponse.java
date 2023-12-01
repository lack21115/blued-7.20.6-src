package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/SendMessageToWeiboResponse.class */
public class SendMessageToWeiboResponse extends BaseResponse {
    public SendMessageToWeiboResponse() {
    }

    public SendMessageToWeiboResponse(Bundle bundle) {
        fromBundle(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.BaseResponse
    public final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        return true;
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 1;
    }
}
