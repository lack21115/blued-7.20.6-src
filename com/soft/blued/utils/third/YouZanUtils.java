package com.soft.blued.utils.third;

import com.blued.android.core.AppInfo;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.youzan.androidsdk.YouzanSDK;
import com.youzan.androidsdkx5.YouZanSDKX5Adapter;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/YouZanUtils.class */
public class YouZanUtils {
    public static void a() {
        if (YouzanSDK.isReady()) {
            return;
        }
        String str = BluedHttpUrl.h() ? "edf395742e546a9610" : "eff6092c04035280dc";
        String str2 = BluedHttpUrl.h() ? "2649fdcf02a343afb844ce82af30b843" : "2c4ca0f390c444a9c13bcd4982239499";
        if (AppInfo.m()) {
            YouzanSDK.isDebug(true);
        }
        YouzanSDK.init(AppInfo.d(), str, str2, new YouZanSDKX5Adapter());
    }

    public static void b() {
        if (YouzanSDK.isReady()) {
            YouzanSDK.userLogout(AppInfo.d());
        }
    }
}
