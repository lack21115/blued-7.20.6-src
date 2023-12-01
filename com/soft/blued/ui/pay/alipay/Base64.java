package com.soft.blued.ui.pay.alipay;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/alipay/Base64.class */
public final class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f19303a = new byte[128];
    private static final char[] b = new char[64];

    static {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 128) {
                break;
            }
            f19303a[i5] = -1;
            i4 = i5 + 1;
        }
        int i6 = 90;
        while (true) {
            int i7 = i6;
            if (i7 < 65) {
                break;
            }
            f19303a[i7] = (byte) (i7 - 65);
            i6 = i7 - 1;
        }
        int i8 = 122;
        while (true) {
            int i9 = i8;
            i = 26;
            if (i9 < 97) {
                break;
            }
            f19303a[i9] = (byte) ((i9 - 97) + 26);
            i8 = i9 - 1;
        }
        int i10 = 57;
        while (true) {
            int i11 = i10;
            if (i11 < 48) {
                break;
            }
            f19303a[i11] = (byte) ((i11 - 48) + 52);
            i10 = i11 - 1;
        }
        byte[] bArr = f19303a;
        bArr[43] = 62;
        bArr[47] = 63;
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 > 25) {
                break;
            }
            b[i13] = (char) (i13 + 65);
            i12 = i13 + 1;
        }
        int i14 = 0;
        while (true) {
            int i15 = i14;
            i2 = 0;
            i3 = 52;
            if (i > 51) {
                break;
            }
            b[i] = (char) (i15 + 97);
            i++;
            i14 = i15 + 1;
        }
        while (i3 <= 61) {
            b[i3] = (char) (i2 + 48);
            i3++;
            i2++;
        }
        char[] cArr = b;
        cArr[62] = '+';
        cArr[63] = '/';
    }
}
