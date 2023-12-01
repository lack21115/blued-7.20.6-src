package com.umeng.analytics.pro;

import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cv.class */
public final class cv extends cj {

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cv$a.class */
    public static class a implements cr {
        @Override // com.umeng.analytics.pro.cr
        public cp a(dd ddVar) {
            return new cv(ddVar);
        }
    }

    public cv(dd ddVar) {
        super(ddVar);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length * 8) {
                return bitSet;
            }
            if ((bArr[(bArr.length - (i2 / 8)) - 1] & (1 << (i2 % 8))) > 0) {
                bitSet.set(i2);
            }
            i = i2 + 1;
        }
    }

    public static byte[] b(BitSet bitSet, int i) {
        int ceil = (int) Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bitSet.length()) {
                return bArr;
            }
            if (bitSet.get(i3)) {
                int i4 = (ceil - (i3 / 8)) - 1;
                bArr[i4] = (byte) ((1 << (i3 % 8)) | bArr[i4]);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public Class<? extends cx> D() {
        return da.class;
    }

    public void a(BitSet bitSet, int i) throws bw {
        byte[] b = b(bitSet, i);
        int length = b.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(b[i3]);
            i2 = i3 + 1;
        }
    }

    public BitSet b(int i) throws bw {
        int ceil = (int) Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= ceil) {
                return a(bArr);
            }
            bArr[i3] = u();
            i2 = i3 + 1;
        }
    }
}
