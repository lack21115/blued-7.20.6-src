package com.anythink.expressad.exoplayer.k;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/p.class */
public final class p {
    public static final int b = 255;
    private static final String d = "NalUnitUtil";
    private static final int e = 6;
    private static final int f = 7;
    private static final int g = 39;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4825a = {0, 0, 0, 1};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f4826c = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object h = new Object();
    private static int[] i = new int[10];

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/p$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4827a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4828c;

        public a(int i, int i2, boolean z) {
            this.f4827a = i;
            this.b = i2;
            this.f4828c = z;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/p$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4829a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4830c;
        public final float d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f4829a = i;
            this.b = i2;
            this.f4830c = i3;
            this.d = f;
            this.e = z;
            this.f = z2;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = z3;
        }
    }

    private p() {
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        int i4;
        synchronized (h) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < i2) {
                while (true) {
                    if (i5 >= i2 - 2) {
                        i4 = i2;
                        break;
                    } else if (bArr[i5] == 0 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 3) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
                i5 = i4;
                if (i4 < i2) {
                    if (i.length <= i6) {
                        int[] iArr = i;
                        i = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    i[i6] = i4;
                    i5 = i4 + 3;
                    i6++;
                }
            }
            i3 = i2 - i6;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = i[i9] - i8;
                System.arraycopy(bArr, i8, bArr, i7, i10);
                int i11 = i7 + i10;
                int i12 = i11 + 1;
                bArr[i11] = 0;
                i7 = i12 + 1;
                bArr[i12] = 0;
                i8 += i10 + 3;
            }
            System.arraycopy(bArr, i8, bArr, i7, i3 - i7);
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0119, code lost:
        r11 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(byte[] r4, int r5, int r6, boolean[] r7) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.p.a(byte[], int, int, boolean[]):int");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static b a(byte[] bArr, int i2, int i3) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static void a(t tVar, int i2) {
        int i3 = 8;
        int i4 = 8;
        int i5 = 0;
        while (i5 < i2) {
            int i6 = i3;
            if (i3 != 0) {
                i6 = ((tVar.d() + i4) + 256) % 256;
            }
            if (i6 != 0) {
                i4 = i6;
            }
            i5++;
            i3 = i6;
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        int i2;
        int position = byteBuffer.position();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i3 + 1;
            if (i5 >= position) {
                byteBuffer.clear();
                return;
            }
            int i6 = byteBuffer.get(i3) & 255;
            if (i4 == 3) {
                i2 = i4;
                if (i6 == 1) {
                    i2 = i4;
                    if ((byteBuffer.get(i5) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i3 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                }
            } else {
                i2 = i4;
                if (i6 == 0) {
                    i2 = i4 + 1;
                }
            }
            i4 = i2;
            if (i6 != 0) {
                i4 = 0;
            }
            i3 = i5;
        }
    }

    private static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean a(String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
    }

    private static int b(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    private static a b(byte[] bArr, int i2, int i3) {
        t tVar = new t(bArr, i2, i3);
        tVar.a(8);
        int c2 = tVar.c();
        int c3 = tVar.c();
        tVar.a();
        return new a(c2, c3, tVar.b());
    }

    private static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    private static int c(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}
