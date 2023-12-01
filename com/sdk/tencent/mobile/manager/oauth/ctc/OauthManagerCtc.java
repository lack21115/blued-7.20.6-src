package com.sdk.tencent.mobile.manager.oauth.ctc;

import android.content.Context;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.mobile.manager.oauth.cucc.OauthManager;
import com.sdk.tencent.n.b;
import com.sdk.tencent.w.a;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/mobile/manager/oauth/ctc/OauthManagerCtc.class */
public class OauthManagerCtc extends SDKManager {
    private static volatile OauthManagerCtc manager;
    private Context mContext;

    private OauthManagerCtc(Context context) {
        this.mContext = context;
    }

    public static OauthManagerCtc getInstance(Context context) {
        if (manager == null) {
            synchronized (OauthManager.class) {
                try {
                    if (manager == null) {
                        manager = new OauthManagerCtc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return manager;
    }

    public <T> void getAuthoriseCode(int i, CallBack<T> callBack) {
        new a(this.mContext, i, callBack).a(1);
    }

    public <T> void getMobileForCode(String str, int i, CallBack<T> callBack) {
        if (b.a(str).booleanValue()) {
            SDKManager.toFailed(callBack, 101001, "授权码不能为空");
        } else {
            new a(this.mContext, i, callBack).a(str, null);
        }
    }

    public <T> void getMobileForCode(String str, String str2, int i, CallBack<T> callBack) {
        if (b.a(str).booleanValue()) {
            SDKManager.toFailed(callBack, 101001, "授权码不能为空");
        } else if (b.a(str2).booleanValue()) {
            SDKManager.toFailed(callBack, 101002, "认证的手机号不能为空");
        } else {
            new a(this.mContext, i, callBack).a(str, str2);
        }
    }
}
