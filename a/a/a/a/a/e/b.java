package a.a.a.a.a.e;

import java.io.UnsupportedEncodingException;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f1303a = !b.class.desiredAssertionStatus();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/b$a.class */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f1304a;
        public int b;
    }

    /* renamed from: a.a.a.a.a.e.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/b$b.class */
    public static class C0008b extends a {
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final byte[] i;
        public final byte[] j;
        public int k;
        public int l;
        public static final /* synthetic */ boolean e = !b.class.desiredAssertionStatus();

        /* renamed from: c  reason: collision with root package name */
        public static final byte[] f1305c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        public static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        public C0008b(int i, byte[] bArr) {
            this.f1304a = bArr;
            this.f = (i & 1) == 0;
            this.g = (i & 2) == 0;
            this.h = (i & 4) != 0;
            this.j = (i & 8) == 0 ? f1305c : d;
            this.i = new byte[2];
            this.k = 0;
            this.l = this.g ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:106:0x01cf A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x03e3  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x03ff  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x01b9 -> B:23:0x011c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r7, int r8, int r9, boolean r10) {
            /*
                Method dump skipped, instructions count: 1165
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.e.b.C0008b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static String a(byte[] bArr, int i) {
        try {
            return new String(b(bArr, i), com.anythink.expressad.exoplayer.b.i);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        int i4;
        C0008b c0008b = new C0008b(i3, null);
        int i5 = (i2 / 3) * 4;
        if (c0008b.f) {
            i4 = i5;
            if (i2 % 3 > 0) {
                i4 = i5 + 4;
            }
        } else {
            int i6 = i2 % 3;
            i4 = i6 != 1 ? i6 != 2 ? i5 : i5 + 3 : i5 + 2;
        }
        int i7 = i4;
        if (c0008b.g) {
            i7 = i4;
            if (i2 > 0) {
                i7 = i4 + ((((i2 - 1) / 57) + 1) * (c0008b.h ? 2 : 1));
            }
        }
        c0008b.f1304a = new byte[i7];
        c0008b.a(bArr, i, i2, true);
        if (f1303a || c0008b.b == i7) {
            return c0008b.f1304a;
        }
        throw new AssertionError();
    }

    public static byte[] b(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }
}
