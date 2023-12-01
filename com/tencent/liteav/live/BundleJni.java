package com.tencent.liteav.live;

import android.os.Bundle;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/BundleJni.class */
public class BundleJni {
    public static Bundle appendBoolean(Bundle bundle, String str, boolean z) {
        bundle.putBoolean(str, z);
        return bundle;
    }

    public static Bundle appendBundle(Bundle bundle, String str, Bundle bundle2) {
        bundle.putBundle(str, bundle2);
        return bundle;
    }

    public static Bundle appendByteArray(Bundle bundle, String str, byte[] bArr) {
        bundle.putByteArray(str, bArr);
        return bundle;
    }

    public static Bundle appendDouble(Bundle bundle, String str, double d) {
        bundle.putDouble(str, d);
        return bundle;
    }

    public static Bundle appendFloat(Bundle bundle, String str, float f) {
        bundle.putFloat(str, f);
        return bundle;
    }

    public static Bundle appendInt(Bundle bundle, String str, int i) {
        bundle.putInt(str, i);
        return bundle;
    }

    public static Bundle appendLong(Bundle bundle, String str, long j) {
        bundle.putLong(str, j);
        return bundle;
    }

    public static Bundle appendString(Bundle bundle, String str, String str2) {
        bundle.putString(str, str2);
        return bundle;
    }

    public static Bundle getBundle() {
        return new Bundle();
    }
}
