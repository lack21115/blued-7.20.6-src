package com.tencent.map.geolocation;

import android.text.TextUtils;
import c.t.m.g.z5;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentLocationManagerOptions.class */
public class TencentLocationManagerOptions {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f37254a = true;
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f37255c = "";

    public static String getExtraKey() {
        return f37255c;
    }

    public static String getKey() {
        return b;
    }

    public static boolean isLoadLibraryEnabled() {
        return f37254a;
    }

    public static void setDebuggable(boolean z) {
        z5.f4076a = z;
    }

    public static boolean setExtraKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        f37255c = str;
        return true;
    }

    public static boolean setKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b = str;
        return true;
    }

    public static void setLoadLibraryEnabled(boolean z) {
        f37254a = z;
    }
}
