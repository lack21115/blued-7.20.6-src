package com.tencent.tencentmap.lbssdk.service;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/lbssdk/service/TxRtkSvr.class */
public class TxRtkSvr {
    public static native String jni_get_version();

    public static native int jni_getnav();

    public static native int jni_getsol(double[] dArr);

    public static native int jni_getsol_bds(double[] dArr);

    public static native int jni_init_txgpos();

    public static native void jni_set_city(String str);

    public static native void jni_set_ntrip_ip(String str, int i);

    public static native void jni_set_ntrip_mntpnt(String str);

    public static native int jni_set_ntrip_mode(int i);

    public static native int jni_set_ntrip_nmea_cycle(int i);

    public static native void jni_set_ntrip_user(String str, String str2);

    public static native void jni_set_phone_mdl(String str);

    public static native void jni_setlogger_path(String str);

    public static native void jni_setsol_path(String str);

    public static native void jni_settrace_path(int i, String str);

    public static native int jni_stop_txgpos();

    public static native int jni_upd_android_data(int i, byte[] bArr, GnssRaw gnssRaw, int i2);

    public static native int jni_upd_rtcm_data(int i, byte[] bArr);
}
