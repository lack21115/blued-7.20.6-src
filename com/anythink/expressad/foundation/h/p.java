package com.anythink.expressad.foundation.h;

import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/p.class */
public final class p implements com.anythink.expressad.e.b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7967a = "MD5";

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            o.a("MD5", str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString().toLowerCase(Locale.US);
                }
                byte b = digest[i2];
                sb.append(Integer.toHexString((b & 240) >>> 4));
                sb.append(Integer.toHexString(b & 15));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int length = bArr.length * 2;
        byte[] bArr2 = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                byte[] bArr3 = new byte[bArr.length + 1];
                bArr3[0] = 0;
                System.arraycopy((Object) bArr, 0, (Object) bArr3, 1, bArr.length);
                byte[] bytes = new BigInteger(bArr3).toString(16).getBytes();
                System.arraycopy((Object) bytes, 0, (Object) bArr2, length - bytes.length, bytes.length);
                return new String(bArr2);
            }
            bArr2[i2] = 48;
            i = i2 + 1;
        }
    }

    private static String b(String str) {
        try {
            o.a("MD5", str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString().toUpperCase(Locale.US);
                }
                byte b = digest[i2];
                sb.append(Integer.toHexString((b & 240) >>> 4));
                sb.append(Integer.toHexString(b & 15));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString().toLowerCase(Locale.US);
            }
            byte b = bArr[i2];
            sb.append(Integer.toHexString((b & 240) >>> 4));
            sb.append(Integer.toHexString(b & 15));
            i = i2 + 1;
        }
    }

    private static String c(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes(CharEncoding.UTF_16LE);
            o.b(com.anythink.expressad.exoplayer.g.b.i.f7358a, "b = " + a(bytes));
            byte[] bArr = new byte[length];
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= bytes.length) {
                    break;
                }
                int i4 = i3;
                if (bytes[i] != -1) {
                    i4 = i3;
                    if (bytes[i] != -2) {
                        bArr[i3] = bytes[i];
                        i4 = i3 + 1;
                        if (i4 == length) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i += 2;
                i2 = i4;
            }
            o.b(com.anythink.expressad.exoplayer.g.b.i.f7358a, "source = " + a(bArr));
            char[] cArr = new char[16];
            cArr[0] = '0';
            cArr[1] = '1';
            cArr[2] = '2';
            cArr[3] = '3';
            cArr[4] = '4';
            cArr[5] = '5';
            cArr[6] = '6';
            cArr[7] = '7';
            cArr[8] = '8';
            cArr[9] = '9';
            cArr[10] = 'a';
            cArr[11] = 'b';
            cArr[12] = 'c';
            cArr[13] = 'd';
            cArr[14] = 'e';
            cArr[15] = 'f';
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            int length2 = digest.length;
            char[] cArr2 = new char[length2 * 2];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= length2) {
                    return new String(cArr2);
                }
                byte b = digest[i7];
                int i8 = i5 + 1;
                cArr2[i5] = cArr[(b >>> 4) & 15];
                i5 = i8 + 1;
                cArr2[i8] = cArr[b & 15];
                i6 = i7 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString().toUpperCase(Locale.US);
            }
            byte b = bArr[i2];
            sb.append(Integer.toHexString((b & 240) >>> 4));
            sb.append(Integer.toHexString(b & 15));
            i = i2 + 1;
        }
    }

    private static byte[] d(String str) {
        int length = str.length();
        byte[] bytes = str.getBytes(CharEncoding.UTF_16LE);
        o.b(com.anythink.expressad.exoplayer.g.b.i.f7358a, "b = " + a(bytes));
        byte[] bArr = new byte[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= bytes.length) {
                break;
            }
            int i4 = i3;
            if (bytes[i] != -1) {
                i4 = i3;
                if (bytes[i] != -2) {
                    bArr[i3] = bytes[i];
                    i4 = i3 + 1;
                    if (i4 == length) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            i += 2;
            i2 = i4;
        }
        o.b(com.anythink.expressad.exoplayer.g.b.i.f7358a, "source = " + a(bArr));
        return bArr;
    }
}
