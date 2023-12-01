package com.huawei.android.hms.pps;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/android/hms/pps/AdvertisingIdClient.class */
public class AdvertisingIdClient {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/android/hms/pps/AdvertisingIdClient$Info.class */
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public final native String getId();

        public final native boolean isLimitAdTrackingEnabled();
    }

    public static native Info getAdvertisingIdInfo(Context context);

    private static native String getTag();
}
