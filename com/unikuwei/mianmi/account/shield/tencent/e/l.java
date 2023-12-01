package com.unikuwei.mianmi.account.shield.tencent.e;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/l.class */
public class l {
    public static byte[] a() {
        try {
            byte[] bArr = new byte[15416];
            int[] iArr = new int[3854];
            int i = 0;
            for (int i2 = 0; i2 < 1; i2++) {
                int[] iArr2 = (int[]) com.unikuwei.mianmi.account.shield.tencent.b.a.a(i2);
                System.arraycopy((Object) iArr2, 0, (Object) iArr, i, iArr2.length);
                i += iArr2.length;
            }
            byte[] a2 = m.a(iArr);
            System.arraycopy((Object) a2, 0, (Object) bArr, 0, a2.length);
            return bArr;
        } catch (Exception e) {
            return null;
        }
    }
}
