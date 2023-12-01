package com.alibaba.mtl.log.e;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/n.class */
public class n {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/n$a.class */
    public static class a {
        public int[] d;
        public int x;
        public int y;

        private a() {
            this.d = new int[256];
        }
    }

    private static a a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                break;
            }
            aVar.d[i2] = i2;
            i = i2 + 1;
        }
        aVar.x = 0;
        aVar.y = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 256) {
                return aVar;
            }
            try {
                i4 = ((str.charAt(i3) + aVar.d[i6]) + i4) % 256;
                int i7 = aVar.d[i6];
                aVar.d[i6] = aVar.d[i4];
                aVar.d[i4] = i7;
                i3 = (i3 + 1) % str.length();
                i5 = i6 + 1;
            } catch (Exception e) {
                return null;
            }
        }
    }

    private static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i = aVar.x;
        int i2 = aVar.y;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= bArr.length) {
                aVar.x = i;
                aVar.y = i2;
                return bArr;
            }
            i = (i + 1) % 256;
            i2 = (aVar.d[i] + i2) % 256;
            int i5 = aVar.d[i];
            aVar.d[i] = aVar.d[i2];
            aVar.d[i2] = i5;
            int i6 = aVar.d[i];
            int i7 = aVar.d[i2];
            bArr[i4] = (byte) (aVar.d[(i6 + i7) % 256] ^ bArr[i4]);
            i3 = i4 + 1;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        a a2;
        if (bArr == null || str == null || (a2 = a(str)) == null) {
            return null;
        }
        return a(bArr, a2);
    }
}
