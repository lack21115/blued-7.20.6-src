package com.bytedance.sdk.openadsdk.api.plugin.ox;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/ox/b.class */
public class b {
    private static final char[] mb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String mb(byte[] bArr) {
        if (bArr != null) {
            return mb(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String mb(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = bArr[i5 + i] & 255;
                int i7 = i4 + 1;
                char[] cArr2 = mb;
                cArr[i4] = cArr2[i6 >> 4];
                i4 = i7 + 1;
                cArr[i7] = cArr2[i6 & 15];
            }
            return new String(cArr, 0, i3);
        }
        throw new NullPointerException("bytes is null");
    }
}
