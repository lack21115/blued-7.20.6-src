package com.tencent.mapsdk.internal;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f37539a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] b = new byte[0];

    public static byte a(char c2) {
        int i;
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return (byte) 0;
                }
            }
            i = (c2 - c3) + 10;
        } else {
            i = c2 - '0';
        }
        return (byte) i;
    }

    public static byte a(String str) {
        if (str == null || str.length() != 1) {
            return (byte) 0;
        }
        return a(str.charAt(0));
    }

    public static String a(byte b2) {
        char[] cArr = f37539a;
        return new String(new char[]{cArr[((byte) (b2 >>> 4)) & 15], cArr[b2 & 15]});
    }

    public static String a(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.flip();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        return a(bArr);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(cArr);
            }
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f37539a;
            cArr[i3 + 1] = cArr2[b2 & 15];
            cArr[i3 + 0] = cArr2[((byte) (b2 >>> 4)) & 15];
            i = i2 + 1;
        }
    }

    public static byte[] b(String str) {
        if (str == null || str.equals("")) {
            return b;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((a(str.charAt(i3)) * 16) + a(str.charAt(i3 + 1)));
            i = i2 + 1;
        }
    }
}
