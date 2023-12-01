package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb/u.class */
public class u {
    private int[] mb;
    private int[] ox;

    private u() {
    }

    private static final int mb(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }

    public static u mb(hj hjVar) throws IOException {
        ox.mb(hjVar, 1835009);
        int ox = hjVar.ox();
        int ox2 = hjVar.ox();
        int ox3 = hjVar.ox();
        hjVar.ox();
        int ox4 = hjVar.ox();
        int ox5 = hjVar.ox();
        u uVar = new u();
        uVar.mb = hjVar.ox(ox2);
        if (ox3 != 0) {
            hjVar.ox(ox3);
        }
        int i = (ox5 == 0 ? ox : ox5) - ox4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        uVar.ox = hjVar.ox(i / 4);
        if (ox5 != 0) {
            int i2 = ox - ox5;
            if (i2 % 4 == 0) {
                hjVar.ox(i2 / 4);
                return uVar;
            }
            throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
        }
        return uVar;
    }

    public String mb(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.mb) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int mb = mb(this.ox, i2);
        StringBuilder sb = new StringBuilder(mb);
        while (mb != 0) {
            i2 += 2;
            sb.append((char) mb(this.ox, i2));
            mb--;
        }
        return sb.toString();
    }
}
