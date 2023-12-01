package com.opos.exoplayer.core.i;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f25488a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f25489c = new Object();
    private static int[] d = new int[10];

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25490a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f25491c;

        public a(int i, int i2, boolean z) {
            this.f25490a = i;
            this.b = i2;
            this.f25491c = z;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/k$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f25492a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25493c;
        public final float d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f25492a = i;
            this.b = i2;
            this.f25493c = i3;
            this.d = f;
            this.e = z;
            this.f = z2;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = z3;
        }
    }

    public static int a(byte[] bArr, int i) {
        int i2;
        synchronized (f25489c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                int c2 = c(bArr, i3, i);
                i3 = c2;
                if (c2 < i) {
                    if (d.length <= i4) {
                        d = Arrays.copyOf(d, d.length * 2);
                    }
                    d[i4] = c2;
                    i3 = c2 + 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i5 < i4) {
                    int i9 = d[i5] - i6;
                    System.arraycopy((Object) bArr, i6, (Object) bArr, i8, i9);
                    int i10 = i8 + i9;
                    int i11 = i10 + 1;
                    byte b2 = (byte) 0;
                    bArr[i10] = b2;
                    bArr[i11] = b2;
                    i6 += i9 + 3;
                    i5++;
                    i7 = i11 + 1;
                } else {
                    System.arraycopy((Object) bArr, i6, (Object) bArr, i8, i2 - i8);
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
        if (r7 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0113, code lost:
        r10 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(byte[] r4, int r5, int r6, boolean[] r7) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.i.k.a(byte[], int, int, boolean[]):int");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static b a(byte[] bArr, int i, int i2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static void a(n nVar, int i) {
        int i2 = 8;
        int i3 = 8;
        int i4 = 0;
        while (i4 < i) {
            int i5 = i2;
            if (i2 != 0) {
                i5 = ((nVar.e() + i3) + 256) % 256;
            }
            if (i5 != 0) {
                i3 = i5;
            }
            i4++;
            i2 = i5;
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 >= position) {
                byteBuffer.clear();
                return;
            }
            int i5 = byteBuffer.get(i2) & 255;
            if (i3 == 3) {
                i = i3;
                if (i5 == 1) {
                    i = i3;
                    if ((byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                }
            } else {
                i = i3;
                if (i5 == 0) {
                    i = i3 + 1;
                }
            }
            i3 = i;
            if (i5 != 0) {
                i3 = 0;
            }
            i2 = i4;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean a(String str, byte b2) {
        boolean z = true;
        if (!"video/avc".equals(str) || (b2 & 31) != 6) {
            if ("video/hevc".equals(str) && ((b2 & 126) >> 1) == 39) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static int b(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static a b(byte[] bArr, int i, int i2) {
        n nVar = new n(bArr, i, i2);
        nVar.a(8);
        int d2 = nVar.d();
        int d3 = nVar.d();
        nVar.a();
        return new a(d2, d3, nVar.b());
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    private static int c(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }
}
