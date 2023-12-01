package com.danlan.android.security.obfuscator;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/security/obfuscator/Base64.class */
public final class Base64 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/danlan/android/security/obfuscator/Base64$Coder.class */
    public static abstract class Coder {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f21716a;
        public int b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/danlan/android/security/obfuscator/Base64$Decoder.class */
    public static class Decoder extends Coder {

        /* renamed from: c  reason: collision with root package name */
        private static final int[] f21717c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int e;
        private int f;
        private final int[] g;

        private Decoder(int i, byte[] bArr) {
            this.f21716a = bArr;
            this.g = (i & 8) == 0 ? f21717c : d;
            this.e = 0;
            this.f = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0135, code lost:
            r5.e = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x013c, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x024f, code lost:
            if (r9 != false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0252, code lost:
            r5.e = r11;
            r5.f = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x025e, code lost:
            r5.b = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0265, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0269, code lost:
            if (r11 == 1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x026f, code lost:
            if (r11 == 2) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0275, code lost:
            if (r11 == 3) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x027b, code lost:
            if (r11 == 4) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0281, code lost:
            r0 = r12 + 1;
            r0[r12] = (byte) (r13 >> 10);
            r12 = r0 + 1;
            r0[r0] = (byte) (r13 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x02a2, code lost:
            r0[r12] = (byte) (r13 >> 4);
            r12 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x02b2, code lost:
            r5.e = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r6, int r7, int r8, boolean r9) {
            /*
                Method dump skipped, instructions count: 699
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.security.obfuscator.Base64.Decoder.a(byte[], int, int, boolean):boolean");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/danlan/android/security/obfuscator/Base64$Encoder.class */
    static class Encoder extends Coder {

        /* renamed from: c  reason: collision with root package name */
        private static final byte[] f21718c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    }

    private Base64() {
    }

    public static byte[] a(String str, int i) {
        return a(str.getBytes(), i);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    private static byte[] a(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[(i2 * 3) / 4]);
        if (decoder.a(bArr, i, i2, true)) {
            int i4 = decoder.b;
            byte[] bArr2 = decoder.f21716a;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
