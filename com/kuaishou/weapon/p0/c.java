package com.kuaishou.weapon.p0;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10160a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f10161c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    static final /* synthetic */ boolean g = !c.class.desiredAssertionStatus();
    private static final Pattern h = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/c$a.class */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f10162a;
        public int b;

        a() {
        }

        public abstract int a(int i);

        public abstract boolean a(byte[] bArr, int i, int i2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/c$b.class */
    public static class b extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final int[] f10163c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int e = -1;
        private static final int f = -2;
        private int g;
        private int h;
        private final int[] i;

        public b(int i, byte[] bArr) {
            this.f10162a = bArr;
            this.i = (i & 8) == 0 ? f10163c : d;
            this.g = 0;
            this.h = 0;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x01c7, code lost:
            r5.g = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x01ce, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0251, code lost:
            if (r9 != false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0254, code lost:
            r5.g = r11;
            r5.h = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0260, code lost:
            r5.b = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0267, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x026b, code lost:
            if (r11 == 1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0271, code lost:
            if (r11 == 2) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0277, code lost:
            if (r11 == 3) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x027d, code lost:
            if (r11 == 4) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0283, code lost:
            r0 = r12 + 1;
            r0[r12] = (byte) (r13 >> 10);
            r12 = r0 + 1;
            r0[r0] = (byte) (r13 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x02a4, code lost:
            r0[r12] = (byte) (r13 >> 4);
            r12 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x02b4, code lost:
            r5.g = r11;
         */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r6, int r7, int r8, boolean r9) {
            /*
                Method dump skipped, instructions count: 701
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.b.a(byte[], int, int, boolean):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kuaishou.weapon.p0.c$c  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/c$c.class */
    public static class C0294c extends a {

        /* renamed from: c  reason: collision with root package name */
        public static final int f10164c = 19;
        static final /* synthetic */ boolean h = !c.class.desiredAssertionStatus();
        private static final byte[] i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        int d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        private final byte[] k;
        private int l;
        private final byte[] m;

        public C0294c(int i2, byte[] bArr) {
            this.f10162a = bArr;
            this.e = (i2 & 1) == 0;
            this.f = (i2 & 2) == 0;
            this.g = (i2 & 4) != 0;
            this.m = (i2 & 8) == 0 ? i : j;
            this.k = new byte[2];
            this.d = 0;
            this.l = this.f ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i2) {
            return ((i2 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:106:0x01cf A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x03fb  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x01b9 -> B:23:0x011c). Please submit an issue!!! */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r7, int r8, int r9, boolean r10) {
            /*
                Method dump skipped, instructions count: 1161
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.C0294c.a(byte[], int, int, boolean):boolean");
        }
    }

    private c() {
    }

    public static String a(byte[] bArr, String str) {
        try {
            return new String(c(bArr, 0), str);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            try {
                if (str.equals("")) {
                    return false;
                }
                return h.matcher(str).matches();
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    public static byte[] a(String str, int i) {
        return a(str.getBytes(), i);
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length, 0);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, new byte[(i2 * 3) / 4]);
        if (bVar.a(bArr, i, i2, true)) {
            if (bVar.b == bVar.f10162a.length) {
                return bVar.f10162a;
            }
            byte[] bArr2 = new byte[bVar.b];
            System.arraycopy(bVar.f10162a, 0, bArr2, 0, bVar.b);
            return bArr2;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String b(String str, int i) {
        try {
            return new String(a(str.getBytes(), i));
        } catch (Throwable th) {
            return "";
        }
    }

    public static String b(byte[] bArr, int i) {
        try {
            return new String(c(bArr, i), com.anythink.expressad.exoplayer.b.i);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String b(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(c(bArr, i, i2, i3), com.anythink.expressad.exoplayer.b.i);
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public static byte[] c(byte[] bArr, int i) {
        try {
            return c(bArr, 0, bArr.length, i);
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        C0294c c0294c = new C0294c(i3, null);
        int i5 = (i2 / 3) * 4;
        if (c0294c.e) {
            i4 = i5;
            if (i2 % 3 > 0) {
                i4 = i5 + 4;
            }
        } else {
            int i6 = i2 % 3;
            i4 = i6 != 1 ? i6 != 2 ? i5 : i5 + 3 : i5 + 2;
        }
        int i7 = i4;
        if (c0294c.f) {
            i7 = i4;
            if (i2 > 0) {
                i7 = i4 + ((((i2 - 1) / 57) + 1) * (c0294c.g ? 2 : 1));
            }
        }
        c0294c.f10162a = new byte[i7];
        c0294c.a(bArr, i, i2, true);
        if (g || c0294c.b == i7) {
            return c0294c.f10162a;
        }
        throw new AssertionError();
    }
}
