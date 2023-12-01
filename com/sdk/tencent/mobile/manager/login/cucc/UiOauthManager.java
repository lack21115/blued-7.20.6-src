package com.sdk.tencent.mobile.manager.login.cucc;

import android.content.Context;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.v.a;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/mobile/manager/login/cucc/UiOauthManager.class */
public class UiOauthManager extends SDKManager {
    private static volatile UiOauthManager manager;
    private Context mContext;

    private UiOauthManager(Context context) {
        this.mContext = context;
    }

    public static UiOauthManager getInstance(Context context) {
        if (manager == null) {
            synchronized (UiOauthManager.class) {
                try {
                    if (manager == null) {
                        manager = new UiOauthManager(context);
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
