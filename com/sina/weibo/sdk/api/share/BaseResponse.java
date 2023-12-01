package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/BaseResponse.class */
public abstract class BaseResponse extends Base {
    public int errCode;
    public String errMsg;
    public String reqPackageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean check(Context context, VersionCheckHandler versionCheckHandler);

    @Override // com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        this.errCode = bundle.getInt(WBConstants.Response.ERRCODE);
        this.errMsg = bundle.getString(WBConstants.Response.ERRMSG);
        this.transaction = bundle.getString(WBConstants.TRAN);
        this.reqPackageName = bundle.getString(WBConstants.Base.APP_PKG);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        bundle.putInt(WBConstants.COMMAND_TYPE_KEY, getType());
        bundle.putInt(WBConstants.Response.ERRCODE, this.errCode);
        bundle.putString(WBConstants.Response.ERRMSG, this.errMsg);
        bundle.putString(WBConstants.TRAN, this.transaction);
    }
}
