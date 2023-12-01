package com.xiaomi.push;

import android.text.TextUtils;
import com.youzan.androidsdk.tool.AppSigning;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bn.class */
public class bn {
    public static String a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return stringBuffer.toString();
            }
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
            i2 = i3 + 1;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(m11549a(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r0 < r5) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r4, int r5) {
        /*
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto La
            java.lang.String r0 = ""
            return r0
        La:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r4
            int r0 = r0.length()
            r8 = r0
            r0 = r5
            if (r0 <= 0) goto L25
            r0 = r5
            r6 = r0
            r0 = r8
            r1 = r5
            if (r0 >= r1) goto L3d
        L25:
            r0 = r8
            r1 = 3
            int r0 = r0 / r1
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 <= r1) goto L32
            goto L34
        L32:
            r0 = 1
            r5 = r0
        L34:
            r0 = r5
            r6 = r0
            r0 = r5
            r1 = 3
            if (r0 <= r1) goto L3d
            r0 = 3
            r6 = r0
        L3d:
            r0 = 0
            r5 = r0
        L3f:
            r0 = r5
            r1 = r8
            if (r0 >= r1) goto L6a
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            r0 = r7
            r1 = r6
            int r0 = r0 % r1
            if (r0 != 0) goto L5a
            r0 = r9
            java.lang.String r1 = "*"
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L65
        L5a:
            r0 = r9
            r1 = r4
            r2 = r5
            char r1 = r1.charAt(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
        L65:
            r0 = r7
            r5 = r0
            goto L3f
        L6a:
            r0 = r9
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bn.a(java.lang.String, int):java.lang.String");
    }

    public static String a(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return a(collection.iterator(), str);
    }

    public static String a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                StringBuffer stringBuffer = new StringBuffer(256);
                if (next != null) {
                    stringBuffer.append(next);
                }
                while (it.hasNext()) {
                    if (str != null) {
                        stringBuffer.append(str);
                    }
                    Object next2 = it.next();
                    if (next2 != null) {
                        stringBuffer.append(next2);
                    }
                }
                return stringBuffer.toString();
            }
            return next.toString();
        }
        return "";
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (Exception e) {
            str = "";
        }
        return str.toLowerCase();
    }

    public static String a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return a(objArr, str, 0, objArr.length);
    }

    public static String a(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(i3 * ((objArr[i] == null ? 16 : objArr[i].toString().length()) + str2.length()));
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                return stringBuffer.toString();
            }
            if (i5 > i) {
                stringBuffer.append(str2);
            }
            if (objArr[i5] != null) {
                stringBuffer.append(objArr[i5]);
            }
            i4 = i5 + 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m11548a(String str) {
        if (str == null) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return true;
            }
            char charAt = str.charAt(i2);
            if (charAt < 0 || charAt > 127) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m11549a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public static String b(String str) {
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(AppSigning.SHA1);
                messageDigest.update(m11549a(str));
                return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException e) {
                return str;
            }
        }
        return null;
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }
}
