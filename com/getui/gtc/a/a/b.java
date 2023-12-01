package com.getui.gtc.a.a;

import com.tencent.qcloud.core.util.IOUtils;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f21871a = !b.class.desiredAssertionStatus();

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/b$a.class */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f21872a;
        public int b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.getui.gtc.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/b$b.class */
    public static final class C0339b extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final int[] f21873c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int e;
        private int f;
        private final int[] g;

        public C0339b(byte[] bArr) {
            this.f21872a = bArr;
            this.g = f21873c;
            this.e = 0;
            this.f = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x01b7, code lost:
            r5.e = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x01be, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0244, code lost:
            if (r11 == 1) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x024a, code lost:
            if (r11 == 2) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0250, code lost:
            if (r11 == 3) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0256, code lost:
            if (r11 == 4) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x025c, code lost:
            r0 = r12 + 1;
            r0[r12] = (byte) (r13 >> 10);
            r12 = r0 + 1;
            r0[r0] = (byte) (r13 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x027d, code lost:
            r0[r12] = (byte) (r13 >> 4);
            r12 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x028d, code lost:
            r5.e = r11;
            r5.b = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x029a, code lost:
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a(byte[] r6, int r7) {
            /*
                Method dump skipped, instructions count: 667
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.a.a.b.C0339b.a(byte[], int):boolean");
        }
    }

    private b() {
    }

    public static String a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < 3 && i2 < bArr.length) {
                i6 |= (bArr[i2] & 255) << (16 - (i5 << 3));
                i5++;
                i2++;
            }
            int i7 = i4;
            if (i4 == 102400) {
                sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                i7 = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 14) >>> 26);
            char c2 = '=';
            char charAt3 = i5 < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 20) >>> 26);
            if (i5 >= 3) {
                c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 26) >>> 26);
            }
            sb.append(charAt);
            sb.append(charAt2);
            sb.append(charAt3);
            sb.append(c2);
            i3 = i7 + 4;
        }
    }

    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        return b(bytes, bytes.length);
    }

    public static byte[] a(byte[] bArr) {
        return b(bArr, bArr.length);
    }

    private static byte[] b(byte[] bArr, int i) {
        C0339b c0339b = new C0339b(new byte[(i * 3) / 4]);
        if (c0339b.a(bArr, i)) {
            if (c0339b.b == c0339b.f21872a.length) {
                return c0339b.f21872a;
            }
            byte[] bArr2 = new byte[c0339b.b];
            System.arraycopy((Object) c0339b.f21872a, 0, (Object) bArr2, 0, c0339b.b);
            return bArr2;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
