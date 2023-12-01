package com.tencent.smtt.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/Base64.class */
public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f25225a = !Base64.class.desiredAssertionStatus();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/Base64$a.class */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f25226a;
        public int b;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/Base64$b.class */
    public static class b extends a {
        static final /* synthetic */ boolean g = !Base64.class.desiredAssertionStatus();
        private static final byte[] h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: c  reason: collision with root package name */
        int f25227c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        private final byte[] j;
        private int k;
        private final byte[] l;

        public b(int i2, byte[] bArr) {
            this.f25226a = bArr;
            this.d = (i2 & 1) == 0;
            this.e = (i2 & 2) == 0;
            this.f = (i2 & 4) != 0;
            this.l = (i2 & 8) == 0 ? h : i;
            this.j = new byte[2];
            this.f25227c = 0;
            this.k = this.e ? 19 : -1;
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r7, int r8, int r9, boolean r10) {
            /*
                Method dump skipped, instructions count: 1161
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Base64.b.a(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        int i4;
        b bVar = new b(i3, null);
        int i5 = (i2 / 3) * 4;
        if (bVar.d) {
            i4 = i5;
            if (i2 % 3 > 0) {
                i4 = i5 + 4;
            }
        } else {
            int i6 = i2 % 3;
            i4 = i6 != 1 ? i6 != 2 ? i5 : i5 + 3 : i5 + 2;
        }
        int i7 = i4;
        if (bVar.e) {
            i7 = i4;
            if (i2 > 0) {
                i7 = i4 + ((((i2 - 1) / 57) + 1) * (bVar.f ? 2 : 1));
            }
        }
        bVar.f25226a = new byte[i7];
        bVar.a(bArr, i, i2, true);
        if (f25225a || bVar.b == i7) {
            return bVar.f25226a;
        }
        throw new AssertionError();
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(a(bArr, i), com.anythink.expressad.exoplayer.b.i);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
