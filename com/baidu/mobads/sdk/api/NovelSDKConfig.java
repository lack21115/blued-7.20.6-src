package com.baidu.mobads.sdk.api;

import android.app.Application;
import com.baidu.mobads.sdk.internal.an;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NovelSDKConfig.class */
public class NovelSDKConfig {
    public static void attachBaseContext(Application application, String str, String str2) {
        an.a(application, str, str2);
    }

    public static boolean isInitNovelSDK() {
        return an.f();
    }
}
