package com.cdo.oaps.ad;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f21529a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static int a(char c2, int i) {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new d("Illegal hexadecimal charcter " + c2 + " at index " + i);
    }

    public static byte[] a(char[] cArr) {
        int i;
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new d("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return bArr;
            }
            int a2 = a(cArr[i2], i2);
            i2 = i2 + 1 + 1;
            bArr[i4] = (byte) (((a2 << 4) | a(cArr[i], i)) & 255);
            i3 = i4 + 1;
        }
    }

    public static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = f21529a;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return cArr;
    }

    public Object a(Object obj) {
        try {
            return a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e) {
            throw new d(e.getMessage());
        }
    }

    public Object b(Object obj) {
        try {
            return a(obj instanceof String ? ((String) obj).getBytes() : (byte[]) obj);
        } catch (ClassCastException e) {
            throw new e(e.getMessage());
        }
    }

    public byte[] b(byte[] bArr) {
        return a(new String(bArr).toCharArray());
    }

    public byte[] c(byte[] bArr) {
        return new String(a(bArr)).getBytes();
    }
}
