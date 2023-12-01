package com.sdk.tencent.q;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/q/e.class */
public class e extends com.sdk.tencent.i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28075a = "com.sdk.tencent.q.e";
    public static boolean b = com.sdk.tencent.f.c.b;

    public static String a(String str) {
        if (com.sdk.tencent.n.b.a(str).booleanValue()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(Charset.defaultCharset()));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return sb.toString();
                }
                String hexString = Integer.toHexString(digest[i2] & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.sdk.tencent.i.a.logError(f28075a, "encrypt", e.getMessage(), b);
            return null;
        }
    }
}
