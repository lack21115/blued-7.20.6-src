package com.getui.gtc.dim.e;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/e/a.class */
public final class a {
    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (i <= 0) {
                bArr[0] = (byte) (bArr[0] ^ 23);
                return bArr;
            }
            bArr[i] = (byte) (bArr[i] ^ bArr[i - 1]);
            length = i;
        }
    }
}
