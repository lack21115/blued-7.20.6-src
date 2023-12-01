package com.unikuwei.mianmi.account.shield.tencent.a;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f40983a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            int digit = Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4);
            int i4 = digit;
            if (digit > 127) {
                i4 = digit - 256;
            }
            bArr[i2] = (byte) i4;
            i = i2 + 1;
        }
    }
}
