package com.blued.android.module.yy_china.trtc_audio.model;

import android.util.Base64;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/model/GenerateTestUserSig.class */
public class GenerateTestUserSig {
    public static int a() {
        return YYRoomInfoManager.e().c().d() ? 1400437701 : 1400437703;
    }

    private static String a(long j, String str, long j2, long j3, String str2, String str3) {
        String str4 = "TLS.identifier:" + str + "\nTLS.sdkappid:" + j + "\nTLS.time:" + j2 + "\nTLS.expire:" + j3 + "\n";
        String str5 = str4;
        if (str3 != null) {
            str5 = str4 + "TLS.userbuf:" + str3 + "\n";
        }
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
            return new String(Base64.encode(mac.doFinal(str5.getBytes("UTF-8")), 2));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(long r10, java.lang.String r12, long r13, byte[] r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig.a(long, java.lang.String, long, byte[], java.lang.String):java.lang.String");
    }

    public static String a(String str) {
        return a(a(), str, 604800L, null, b());
    }

    private static byte[] a(byte[] bArr) {
        byte[] bytes = new String(Base64.encode(bArr, 2)).getBytes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bytes.length) {
                return bytes;
            }
            byte b = bytes[i2];
            if (b == 43) {
                bytes[i2] = 42;
            } else if (b == 47) {
                bytes[i2] = 45;
            } else if (b == 61) {
                bytes[i2] = 95;
            }
            i = i2 + 1;
        }
    }

    public static String b() {
        return YYRoomInfoManager.e().c().d() ? "82373b52872bb32aa0217ab03803388c8d63a3fa3d690100a99a95b6d1bbb171" : "d6fafd2e28ee82e8ef5c207843fe18c0f3540b7386426025e3e29b8c9c9aec36";
    }

    public static int c() {
        YYRoomInfoManager.e().c().d();
        return 84981;
    }

    public static int d() {
        return 1;
    }

    public static int e() {
        return 44100;
    }
}
