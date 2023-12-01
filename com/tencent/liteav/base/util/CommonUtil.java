package com.tencent.liteav.base.util;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/CommonUtil.class */
public class CommonUtil {
    private static long mNativeNtpServiceDelegate;
    private static a sCallback;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/CommonUtil$a.class */
    public interface a {
        void a(int i, String str);
    }

    static {
        o.a();
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String getFileExtension(String str) {
        int lastIndexOf;
        if (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static long getNetworkTimestamp() {
        if (nativeNtpServiceDelegateHasBeenCreated()) {
            return nativeGetNetworkTimestamp(mNativeNtpServiceDelegate);
        }
        return 0L;
    }

    public static String getSDKVersionStr() {
        return nativeGetSDKVersion();
    }

    private static native long nativeCreate();

    private static native long nativeGetNetworkTimestamp(long j);

    public static native String nativeGetSDKVersion();

    private static boolean nativeNtpServiceDelegateHasBeenCreated() {
        return sCallback != null;
    }

    private static native int nativeSetGlobalEnv(String str);

    private static native boolean nativeSetSocks5Proxy(String str, int i, String str2, String str3);

    private static native int nativeUpdateNetworkTime(long j);

    public static void onUpdateNetworkTime(int i, String str) {
        a aVar = sCallback;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    public static int setGlobalEnv(String str) {
        return nativeSetGlobalEnv(str);
    }

    public static boolean setSocks5Proxy(String str, int i, String str2, String str3) {
        return nativeSetSocks5Proxy(str, i, str2, str3);
    }

    public static void setUpdateNetworkTimeCallback(a aVar) {
        if (nativeNtpServiceDelegateHasBeenCreated()) {
            return;
        }
        mNativeNtpServiceDelegate = nativeCreate();
        sCallback = aVar;
    }

    public static int updateNetworkTime() {
        if (nativeNtpServiceDelegateHasBeenCreated()) {
            return nativeUpdateNetworkTime(mNativeNtpServiceDelegate);
        }
        return -1;
    }
}
