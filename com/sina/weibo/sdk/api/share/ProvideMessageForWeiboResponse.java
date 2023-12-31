package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMessage;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/ProvideMessageForWeiboResponse.class */
public class ProvideMessageForWeiboResponse extends BaseResponse {
    public WeiboMessage message;

    public ProvideMessageForWeiboResponse() {
    }

    public ProvideMessageForWeiboResponse(Bundle bundle) {
        fromBundle(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.BaseResponse
    public final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        if (this.message == null) {
            return false;
        }
        if (versionCheckHandler == null || versionCheckHandler.checkResponse(context, this.reqPackageName, this.message)) {
            return this.message.checkArgs();
        }
        return false;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseResponse, com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.message = new WeiboMessage(bundle);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 2;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseResponse, com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(this.message.toBundle(bundle));
    }
}
