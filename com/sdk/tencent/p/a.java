package com.sdk.tencent.p;

import com.sdk.tencent.f.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PushbackInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/p/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28069a = "a";
    public static Boolean b = Boolean.valueOf(c.b);

    public static PublicKey a(String str) {
        int i;
        int i2;
        try {
            com.sdk.tencent.h.a aVar = new com.sdk.tencent.h.a();
            byte[] bArr = new byte[str.length()];
            str.getBytes(0, str.length(), bArr, 0);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
            while (true) {
                int i3 = 0;
                while (true) {
                    i = i3;
                    i2 = i + 4;
                    if (i2 >= 72) {
                        break;
                    }
                    try {
                        aVar.a(pushbackInputStream, byteArrayOutputStream, 4);
                        i3 = i2;
                    } catch (com.sdk.tencent.h.c e) {
                        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(byteArrayOutputStream.toByteArray()));
                    }
                }
                aVar.a(pushbackInputStream, byteArrayOutputStream, i2 == 72 ? 4 : 72 - i);
            }
        } catch (Exception e2) {
            com.sdk.tencent.n.b.a(f28069a, e2.toString(), b);
            return null;
        }
    }
}
