package com.sdk.tencent.q;

import com.anythink.expressad.foundation.d.l;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/q/a.class */
public class a extends com.sdk.tencent.i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28071a = "com.sdk.tencent.q.a";
    public static boolean b = com.sdk.tencent.f.c.b;

    /* renamed from: c  reason: collision with root package name */
    public static String f28072c = "a6Hy5Hb8IfX46D1f";

    public static String a(int i) {
        String str;
        Random random = new Random();
        String str2 = "";
        int i2 = 0;
        while (i2 < i) {
            String str3 = random.nextInt(2) % 2 == 0 ? "char" : l.d;
            if ("char".equalsIgnoreCase(str3)) {
                int i3 = random.nextInt(2) % 2 == 0 ? 65 : 97;
                str = str2 + ((char) (random.nextInt(26) + i3));
            } else {
                str = str2;
                if (l.d.equalsIgnoreCase(str3)) {
                    str = str2 + String.valueOf(random.nextInt(10));
                }
            }
            i2++;
            str2 = str;
        }
        return str2;
    }

    public static String a(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (str.length() != 0 && str.trim().length() != 0) {
                    if (str2 != null) {
                        if (str2.length() == 16) {
                            if (str3.length() == 16) {
                                byte[] a2 = c.a(str);
                                Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
                                cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                                return new String(cipher.doFinal(a2), "utf-8");
                            }
                            throw new Exception(" iv decrypt key length error");
                        }
                        throw new Exception("decrypt key length error");
                    }
                    throw new Exception("decrypt key is null");
                }
                return null;
            } catch (Exception e) {
                throw new Exception("decrypt errot", e);
            }
        }
        return null;
    }
}
