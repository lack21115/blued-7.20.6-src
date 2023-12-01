package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/utils/RootKeyUtil.class */
public class RootKeyUtil {
    private static final String b = "RootKeyUtil";

    /* renamed from: a  reason: collision with root package name */
    private byte[] f9482a = null;

    private RootKeyUtil() {
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    private void a(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            b.c(b, "initRootKey: sha1");
            this.f9482a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, false);
            return;
        }
        b.c(b, "initRootKey: sha256");
        this.f9482a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, bArr);
        return rootKeyUtil;
    }

    public byte[] getRootKey() {
        return (byte[]) this.f9482a.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.f9482a);
    }
}
