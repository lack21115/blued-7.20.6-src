package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/HwAds.class */
public class HwAds {
    private HwAds() {
    }

    public static int getAppActivateStyle() {
        return j.Code().C();
    }

    public static RequestOptions getRequestOptions() {
        return j.Code().I();
    }

    public static String getSDKVersion() {
        return j.Code().V();
    }

    public static void init(Context context) {
        init(context, null);
    }

    public static void init(Context context, String str) {
        j.Code().Code(context, str);
    }

    public static boolean isAppInstalledNotify() {
        return j.Code().B();
    }

    public static void setAppActivateStyle(int i) {
        j.Code().V(i);
    }

    public static void setAppInstalledNotify(boolean z) {
        j.Code().V(z);
    }

    public static void setBrand(int i) {
        j.Code().Code(i);
    }

    public static void setConsent(String str) {
        j.Code().Code(str);
    }

    public static void setRequestOptions(RequestOptions requestOptions) {
        j.Code().Code(requestOptions);
    }

    public static void setVideoMuted(boolean z) {
        j.Code().Code(z);
    }

    public static void setVideoVolume(float f) {
        j.Code().Code(f);
    }
}
