package com.sdk.tencent.mobile.manager.login.ctc;

import android.content.Context;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.w.a;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/mobile/manager/login/ctc/UiOauthManagerCtc.class */
public class UiOauthManagerCtc extends SDKManager {
    private static volatile UiOauthManagerCtc manager;
    private Context mContext;

    private UiOauthManagerCtc(Context context) {
        this.mContext = context;
    }

    public static UiOauthManagerCtc getInstance(Context context) {
        if (manager == null) {
            synchronized (UiOauthManagerCtc.class) {
                try {
                    if (manager == null) {
                        manager = new UiOauthManagerCtc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return manager;
    }

    public <T> void login(int i, CallBack<T> callBack) {
        new a(this.mContext, i, callBack).a(0);
    }
}
