package com.tencent.turingcam;

import java.io.ByteArrayOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/fi6GY.class */
public final class fi6GY {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f39821a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static final byte[] a(String str) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i = 0;
        while (i < length) {
            while (true) {
                int i2 = i;
                i = i2 + 1;
                b = f39821a[bytes[i2]];
                if (i >= length || b != -1) {
                    break;
                }
            }
            int i3 = i;
            if (b == -1) {
                break;
            }
            while (true) {
                i = i3 + 1;
                b2 = f39821a[bytes[i3]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i3 = i;
            }
            if (b2 == -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
            while (true) {
                int i4 = i;
                i = i4 + 1;
                byte b5 = bytes[i4];
                if (b5 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b3 = f39821a[b5];
                if (i >= length || b3 != -1) {
                    break;
                }
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b2 & 15) << 4) | ((b3 & 60) >>> 2));
            while (true) {
                int i5 = i;
                i = i5 + 1;
                byte b6 = bytes[i5];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b4 = f39821a[b6];
                if (i >= length || b4 != -1) {
                    break;
                }
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(b4 | ((b3 & 3) << 6));
        }
        return byteArrayOutputStream.toByteArray();
    }
}
