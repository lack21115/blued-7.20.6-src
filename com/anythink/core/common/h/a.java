package com.anythink.core.common.h;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Character, Character> f6750a;
    private static char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: c  reason: collision with root package name */
    private static char[] f6751c = {'5', 'P', 'V', 'u', '3', 'J', 'j', 'l', 'e', 'Q', 'b', 'H', '9', 'A', 'v', 'h', 't', 's', 'g', 'W', 'I', 'C', 'U', 'i', 'F', '2', 'a', 'd', 'M', '8', 'D', 'y', 'Z', 'O', 'N', 'k', '/', '4', 'R', '7', '0', 'f', 'n', '+', 'z', 'G', 'Y', 'L', 'X', 'p', 'm', '1', 'E', 'K', 'S', 'T', 'o', 'x', '6', 'q', 'w', 'r', 'c', 'B'};
    private static byte[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: protected */
    public static b a(String str, String str2) {
        b bVar = new b();
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 2)));
            int i = 0;
            if (generatePublic instanceof RSAPublicKey) {
                i = ((RSAPublicKey) generatePublic).getModulus().bitLength();
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            int i2 = (i / 8) - 11;
            bVar.a(new String(Base64.encode(i2 > 0 ? a(cipher, str2.getBytes(), i2) : cipher.doFinal(str2.getBytes()), 2)));
            return bVar;
        } catch (Throwable th) {
            bVar.b(th.getMessage());
            return bVar;
        }
    }

    private static Character a(char c2) {
        if (f6750a == null) {
            f6750a = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b.length) {
                    break;
                }
                f6750a.put(Character.valueOf(f6751c[i2]), Character.valueOf(b[i2]));
                i = i2 + 1;
            }
        }
        return f6750a.containsKey(Character.valueOf(c2)) ? f6750a.get(Character.valueOf(c2)) : Character.valueOf(c2);
    }

    public static String a(String str) {
        String str2 = "";
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                char[] charArray = str.toCharArray();
                String str4 = "";
                if (charArray != null) {
                    str4 = "";
                    if (charArray.length > 0) {
                        char[] cArr = new char[charArray.length];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= charArray.length) {
                                break;
                            }
                            char c2 = charArray[i2];
                            if (f6750a == null) {
                                f6750a = new HashMap();
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= b.length) {
                                        break;
                                    }
                                    f6750a.put(Character.valueOf(f6751c[i4]), Character.valueOf(b[i4]));
                                    i3 = i4 + 1;
                                }
                            }
                            cArr[i2] = (f6750a.containsKey(Character.valueOf(c2)) ? f6750a.get(Character.valueOf(c2)) : Character.valueOf(c2)).charValue();
                            i = i2 + 1;
                        }
                        str4 = new String(cArr);
                    }
                }
                str2 = str4;
                return new String(b(str4));
            }
        } catch (Exception e) {
            e.printStackTrace();
            str3 = str2;
        }
        return str3;
    }

    private static byte[] a(Cipher cipher, byte[] bArr, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = length - i2;
            if (i4 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byte[] doFinal = i4 > i ? cipher.doFinal(bArr, i2, i) : cipher.doFinal(bArr, i2, i4);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i3++;
            i2 = i3 * i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
        if (r0 == (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r0.write(((r0 & 15) << 4) | ((r0 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ce, code lost:
        r0 = r6;
        r6 = r0 + 1;
        r0 = r0[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d9, code lost:
        if (r0 != 61) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
        return r0.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
        r0 = com.anythink.core.common.h.a.d[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
        if (r6 >= r0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
        if (r0 == (-1)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fc, code lost:
        if (r0 == (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
        r0.write(r0 | ((r0 & 3) << 6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] b(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.h.a.b(java.lang.String):byte[]");
    }
}
