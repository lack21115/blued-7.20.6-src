package com.ta.utdid2.a.a;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/a/a/f.class */
public class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/a/a/f$a.class */
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

    public static byte[] a(byte[] bArr) {
        a a2;
        if (bArr == null || (a2 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, a2);
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
}
