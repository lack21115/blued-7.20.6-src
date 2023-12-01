package com.tencent.youtu.liveness;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/liveness/YTCommonInterface.class */
public class YTCommonInterface {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f40467a = !YTCommonInterface.class.desiredAssertionStatus();
    private static String b = "YTCommon";

    /* renamed from: c  reason: collision with root package name */
    private static int f40468c = 1;

    public static int a(String str, String str2) {
        if (f40467a || str != null) {
            String str3 = str2;
            if (str2 == null) {
                str3 = "";
            }
            return nativeInitAuthByString(str, str3);
        }
        throw new AssertionError();
    }

    public static native long getEndTime();

    public static native int[] getSDKList();

    public static native String getSDKNameByID(int i);

    public static native String getVersion();

    private static native int nativeGetDeviceInfo(YTDeviceInfo yTDeviceInfo);

    private static native int nativeInitAuthByAssets(String str, String str2);

    private static native int nativeInitAuthByString(String str, String str2);

    private static native int nativeInitAuthForQQ();

    private static native void nativePrintAuthResult(int i);

    private static native void nativeSetEnableLog(int i);
}
