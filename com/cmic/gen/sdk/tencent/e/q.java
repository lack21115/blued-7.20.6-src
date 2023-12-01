package com.cmic.gen.sdk.tencent.e;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import com.xiaomi.mipush.sdk.Constants;
import java.security.SecureRandom;
import java.util.UUID;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f8069a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f8069a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static void a(com.cmic.gen.sdk.tencent.a aVar, String str) {
        if (!TextUtils.isEmpty(aVar.b("interfaceType", ""))) {
            str = aVar.b("interfaceType") + t.aE + str;
        }
        aVar.a("interfaceType", str);
    }

    public static boolean a(com.cmic.gen.sdk.tencent.a.a aVar) {
        return k.a("logCloseTime", 0L) + ((long) (((aVar.l() * 60) * 60) * 1000)) >= System.currentTimeMillis();
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static String b() {
        return UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static void b(com.cmic.gen.sdk.tencent.a aVar, String str) {
        if (!TextUtils.isEmpty(aVar.b("interfaceCode", ""))) {
            str = aVar.b("interfaceCode") + t.aE + str;
        }
        aVar.a("interfaceCode", str);
    }

    public static String c() {
        return d().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static void c(com.cmic.gen.sdk.tencent.a aVar, String str) {
        if (!TextUtils.isEmpty(aVar.b("interfaceElasped", ""))) {
            str = aVar.b("interfaceElasped") + t.aE + str;
        }
        aVar.a("interfaceElasped", str);
    }

    private static String d() {
        return UUID.randomUUID().toString();
    }
}
