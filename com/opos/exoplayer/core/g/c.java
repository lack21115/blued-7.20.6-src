package com.opos.exoplayer.core.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.g.f;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/c.class */
public class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f25421a = new int[0];
    private final f.a b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<a> f25422c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f25423a = new a();
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final String f25424c;
        public final boolean d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;

        private a() {
            this(null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        private a(String str, String str2, boolean z, int i, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, boolean z5, boolean z6, int i5, int i6, boolean z7) {
            this.b = u.b(str);
            this.f25424c = u.b(str2);
            this.d = z;
            this.e = i;
            this.m = z2;
            this.n = z3;
            this.o = z4;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.i = z5;
            this.p = z6;
            this.j = i5;
            this.k = i6;
            this.l = z7;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this != obj) {
                z = false;
                if (obj != null) {
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    a aVar = (a) obj;
                    z = false;
                    if (this.d == aVar.d) {
                        z = false;
                        if (this.e == aVar.e) {
                            z = false;
                            if (this.m == aVar.m) {
                                z = false;
                                if (this.n == aVar.n) {
                                    z = false;
                                    if (this.o == aVar.o) {
                                        z = false;
                                        if (this.f == aVar.f) {
                                            z = false;
                                            if (this.g == aVar.g) {
                                                z = false;
                                                if (this.i == aVar.i) {
                                                    z = false;
                                                    if (this.p == aVar.p) {
                                                        z = false;
                                                        if (this.l == aVar.l) {
                                                            z = false;
                                                            if (this.j == aVar.j) {
                                                                z = false;
                                                                if (this.k == aVar.k) {
                                                                    z = false;
                                                                    if (this.h == aVar.h) {
                                                                        z = false;
                                                                        if (TextUtils.equals(this.b, aVar.b)) {
                                                                            if (!TextUtils.equals(this.f25424c, aVar.f25424c)) {
                                                                                return false;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return z;
            }
            z = true;
            return z;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public int hashCode() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/c$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f25425a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final String f25426c;

        public b(int i, int i2, String str) {
            this.f25425a = i;
            this.b = i2;
            this.f25426c = str;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this != obj) {
                z = false;
                if (obj != null) {
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    b bVar = (b) obj;
                    z = false;
                    if (this.f25425a == bVar.f25425a) {
                        z = false;
                        if (this.b == bVar.b) {
                            if (!TextUtils.equals(this.f25426c, bVar.f25426c)) {
                                return false;
                            }
                        }
                    }
                }
                return z;
            }
            z = true;
            return z;
        }

        public int hashCode() {
            int i = this.f25425a;
            int i2 = this.b;
            String str = this.f25426c;
            return (str != null ? str.hashCode() : 0) + (((i * 31) + i2) * 31);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.g.c$c  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/c$c.class */
    public static final class C0666c implements Comparable<C0666c> {

        /* renamed from: a  reason: collision with root package name */
        private final a f25427a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f25428c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public C0666c(Format format, a aVar, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0666c c0666c) {
            int c2;
            int i = this.b;
            int i2 = c0666c.b;
            if (i == i2) {
                i = this.f25428c;
                i2 = c0666c.f25428c;
                if (i == i2) {
                    i = this.d;
                    i2 = c0666c.d;
                    if (i == i2) {
                        if (this.f25427a.m) {
                            return c.c(c0666c.g, this.g);
                        }
                        int i3 = 1;
                        if (this.b != 1) {
                            i3 = -1;
                        }
                        int i4 = this.e;
                        int i5 = c0666c.e;
                        if (i4 == i5) {
                            i4 = this.f;
                            i5 = c0666c.f;
                            if (i4 == i5) {
                                c2 = c.c(this.g, c0666c.g);
                                return c2 * i3;
                            }
                        }
                        c2 = c.c(i4, i5);
                        return c2 * i3;
                    }
                }
            }
            return c.c(i, i2);
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this != obj) {
                z = false;
                if (obj != null) {
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    C0666c c0666c = (C0666c) obj;
                    z = false;
                    if (this.b == c0666c.b) {
                        z = false;
                        if (this.f25428c == c0666c.f25428c) {
                            z = false;
                            if (this.d == c0666c.d) {
                                z = false;
                                if (this.e == c0666c.e) {
                                    z = false;
                                    if (this.f == c0666c.f) {
                                        if (this.g != c0666c.g) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return z;
            }
            z = true;
            return z;
        }

        public int hashCode() {
            return (((((((((this.b * 31) + this.f25428c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        this.b = aVar;
        this.f25422c = new AtomicReference<>(a.f25423a);
    }

    private static int a(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i5 >= list.size()) {
                return i7;
            }
            int intValue = list.get(i5).intValue();
            int i8 = i7;
            if (a(lVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i8 = i7 + 1;
            }
            i5++;
            i6 = i8;
        }
    }

    private static int a(l lVar, int[] iArr, b bVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= lVar.f25309a) {
                return i3;
            }
            int i4 = i3;
            if (a(lVar.a(i), iArr[i], bVar)) {
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r11 != r12) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Point a(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r0 = r6
            if (r0 == 0) goto L28
            r0 = 0
            r12 = r0
            r0 = r9
            r1 = r10
            if (r0 <= r1) goto L13
            r0 = 1
            r11 = r0
            goto L16
        L13:
            r0 = 0
            r11 = r0
        L16:
            r0 = r7
            r1 = r8
            if (r0 <= r1) goto L1e
            r0 = 1
            r12 = r0
        L1e:
            r0 = r11
            r1 = r12
            if (r0 == r1) goto L28
            goto L30
        L28:
            r0 = r8
            r11 = r0
            r0 = r7
            r8 = r0
            r0 = r11
            r7 = r0
        L30:
            r0 = r9
            r1 = r7
            int r0 = r0 * r1
            r11 = r0
            r0 = r10
            r1 = r8
            int r0 = r0 * r1
            r12 = r0
            r0 = r11
            r1 = r12
            if (r0 < r1) goto L51
            android.graphics.Point r0 = new android.graphics.Point
            r1 = r0
            r2 = r8
            r3 = r12
            r4 = r9
            int r3 = com.opos.exoplayer.core.i.u.a(r3, r4)
            r1.<init>(r2, r3)
            return r0
        L51:
            android.graphics.Point r0 = new android.graphics.Point
            r1 = r0
            r2 = r11
            r3 = r10
            int r2 = com.opos.exoplayer.core.i.u.a(r2, r3)
            r3 = r7
            r1.<init>(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.g.c.a(boolean, int, int, int, int):android.graphics.Point");
    }

    private static List<Integer> a(l lVar, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(lVar.f25309a);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= lVar.f25309a) {
                break;
            }
            arrayList.add(Integer.valueOf(i6));
            i5 = i6 + 1;
        }
        if (i != Integer.MAX_VALUE) {
            if (i2 == Integer.MAX_VALUE) {
                return arrayList;
            }
            int i7 = Integer.MAX_VALUE;
            while (true) {
                i3 = i7;
                if (i4 >= lVar.f25309a) {
                    break;
                }
                Format a2 = lVar.a(i4);
                int i8 = i3;
                if (a2.j > 0) {
                    i8 = i3;
                    if (a2.k > 0) {
                        Point a3 = a(z, i, i2, a2.j, a2.k);
                        int i9 = a2.j * a2.k;
                        i8 = i3;
                        if (a2.j >= ((int) (a3.x * 0.98f))) {
                            i8 = i3;
                            if (a2.k >= ((int) (a3.y * 0.98f))) {
                                i8 = i3;
                                if (i9 < i3) {
                                    i8 = i9;
                                }
                            }
                        }
                    }
                }
                i4++;
                i7 = i8;
            }
            if (i3 != Integer.MAX_VALUE) {
                int size = arrayList.size();
                while (true) {
                    int i10 = size - 1;
                    if (i10 < 0) {
                        break;
                    }
                    int a4 = lVar.a(((Integer) arrayList.get(i10)).intValue()).a();
                    if (a4 == -1 || a4 > i3) {
                        arrayList.remove(i10);
                    }
                    size = i10;
                }
            }
        }
        return arrayList;
    }

    protected static boolean a(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    protected static boolean a(Format format) {
        return TextUtils.isEmpty(format.y) || a(format, com.anythink.expressad.exoplayer.b.f7166ar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (android.text.TextUtils.equals(r5.f25426c, r3.f) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.opos.exoplayer.core.Format r3, int r4, com.opos.exoplayer.core.g.c.b r5) {
        /*
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r4
            r1 = 0
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto L44
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.r
            r1 = r5
            int r1 = r1.f25425a
            if (r0 != r1) goto L44
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.s
            r1 = r5
            int r1 = r1.b
            if (r0 != r1) goto L44
            r0 = r5
            java.lang.String r0 = r0.f25426c
            if (r0 == 0) goto L42
            r0 = r7
            r6 = r0
            r0 = r5
            java.lang.String r0 = r0.f25426c
            r1 = r3
            java.lang.String r1 = r1.f
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L44
        L42:
            r0 = 1
            r6 = r0
        L44:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.g.c.a(com.opos.exoplayer.core.Format, int, com.opos.exoplayer.core.g.c$b):boolean");
    }

    protected static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, u.b(format.y));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (r3.j <= r7) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (r3.k <= r8) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (r3.b <= r9) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (com.opos.exoplayer.core.i.u.a(r3.f, r4) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.opos.exoplayer.core.Format r3, java.lang.String r4, int r5, int r6, int r7, int r8, int r9) {
        /*
            r0 = 0
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r5
            r1 = 0
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto L6e
            r0 = r11
            r10 = r0
            r0 = r5
            r1 = r6
            r0 = r0 & r1
            if (r0 == 0) goto L6e
            r0 = r4
            if (r0 == 0) goto L2c
            r0 = r11
            r10 = r0
            r0 = r3
            java.lang.String r0 = r0.f
            r1 = r4
            boolean r0 = com.opos.exoplayer.core.i.u.a(r0, r1)
            if (r0 == 0) goto L6e
        L2c:
            r0 = r3
            int r0 = r0.j
            r1 = -1
            if (r0 == r1) goto L41
            r0 = r11
            r10 = r0
            r0 = r3
            int r0 = r0.j
            r1 = r7
            if (r0 > r1) goto L6e
        L41:
            r0 = r3
            int r0 = r0.k
            r1 = -1
            if (r0 == r1) goto L56
            r0 = r11
            r10 = r0
            r0 = r3
            int r0 = r0.k
            r1 = r8
            if (r0 > r1) goto L6e
        L56:
            r0 = r3
            int r0 = r0.b
            r1 = -1
            if (r0 == r1) goto L6b
            r0 = r11
            r10 = r0
            r0 = r3
            int r0 = r0.b
            r1 = r9
            if (r0 > r1) goto L6e
        L6b:
            r0 = 1
            r10 = r0
        L6e:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.g.c.a(com.opos.exoplayer.core.Format, java.lang.String, int, int, int, int, int):boolean");
    }

    private static int[] a(l lVar, int[] iArr, boolean z) {
        int[] iArr2;
        HashSet hashSet = new HashSet();
        b bVar = null;
        int i = 0;
        int i2 = 0;
        while (i < lVar.f25309a) {
            Format a2 = lVar.a(i);
            b bVar2 = new b(a2.r, a2.s, z ? null : a2.f);
            int i3 = i2;
            b bVar3 = bVar;
            if (hashSet.add(bVar2)) {
                int a3 = a(lVar, iArr, bVar2);
                i3 = i2;
                bVar3 = bVar;
                if (a3 > i2) {
                    i3 = a3;
                    bVar3 = bVar2;
                }
            }
            i++;
            i2 = i3;
            bVar = bVar3;
        }
        if (i2 > 1) {
            int[] iArr3 = new int[i2];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                iArr2 = iArr3;
                if (i5 >= lVar.f25309a) {
                    break;
                }
                int i6 = i4;
                if (a(lVar.a(i5), iArr[i5], bVar)) {
                    iArr3[i4] = i5;
                    i6 = i4 + 1;
                }
                i5++;
                i4 = i6;
            }
        } else {
            iArr2 = f25421a;
        }
        return iArr2;
    }

    private static int[] a(l lVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        if (lVar.f25309a >= 2) {
            List<Integer> a2 = a(lVar, i5, i6, z2);
            if (a2.size() >= 2) {
                if (!z) {
                    HashSet hashSet = new HashSet();
                    str = null;
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i7 >= a2.size()) {
                            break;
                        }
                        String str2 = lVar.a(a2.get(i7).intValue()).f;
                        String str3 = str;
                        int i10 = i9;
                        if (hashSet.add(str2)) {
                            int a3 = a(lVar, iArr, i, str2, i2, i3, i4, a2);
                            str3 = str;
                            i10 = i9;
                            if (a3 > i9) {
                                i10 = a3;
                                str3 = str2;
                            }
                        }
                        i7++;
                        str = str3;
                        i8 = i10;
                    }
                } else {
                    str = null;
                }
                b(lVar, iArr, i, str, i2, i3, i4, a2);
                if (a2.size() >= 2) {
                    return u.a(a2);
                }
            }
        }
        return f25421a;
    }

    private static int b(int i, int i2) {
        int i3;
        if (i == -1) {
            i3 = -1;
            if (i2 == -1) {
                return 0;
            }
        } else if (i2 == -1) {
            return 1;
        } else {
            i3 = i - i2;
        }
        return i3;
    }

    private static f b(m mVar, int[][] iArr, a aVar) {
        l lVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < mVar.b; i5++) {
            l a2 = mVar.a(i5);
            List<Integer> a3 = a(a2, aVar.j, aVar.k, aVar.l);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < a2.f25309a) {
                l lVar2 = lVar;
                int i7 = i;
                int i8 = i2;
                int i9 = i3;
                int i10 = i4;
                if (a(iArr2[i6], aVar.p)) {
                    Format a4 = a2.a(i6);
                    boolean z = a3.contains(Integer.valueOf(i6)) && (a4.j == -1 || a4.j <= aVar.f) && ((a4.k == -1 || a4.k <= aVar.g) && (a4.b == -1 || a4.b <= aVar.h));
                    if (z || aVar.i) {
                        int i11 = z ? 2 : 1;
                        boolean a5 = a(iArr2[i6], false);
                        int i12 = i11;
                        if (a5) {
                            i12 = i11 + 1000;
                        }
                        boolean z2 = i12 > i2;
                        if (i12 == i2) {
                            if (aVar.m) {
                                if (b(a4.b, i3) < 0) {
                                    z2 = true;
                                }
                                z2 = false;
                            } else {
                                int a6 = a4.a();
                                int b2 = a6 != i4 ? b(a6, i4) : b(a4.b, i3);
                                if (a5 && z) {
                                    if (b2 > 0) {
                                        z2 = true;
                                    }
                                    z2 = false;
                                } else {
                                    if (b2 < 0) {
                                        z2 = true;
                                    }
                                    z2 = false;
                                }
                            }
                        }
                        lVar2 = lVar;
                        i7 = i;
                        i8 = i2;
                        i9 = i3;
                        i10 = i4;
                        if (z2) {
                            i9 = a4.b;
                            i10 = a4.a();
                            lVar2 = a2;
                            i7 = i6;
                            i8 = i12;
                        }
                    } else {
                        lVar2 = lVar;
                        i7 = i;
                        i8 = i2;
                        i9 = i3;
                        i10 = i4;
                    }
                }
                i6++;
                lVar = lVar2;
                i = i7;
                i2 = i8;
                i3 = i9;
                i4 = i10;
            }
        }
        if (lVar == null) {
            return null;
        }
        return new d(lVar, i);
    }

    private static f b(t tVar, m mVar, int[][] iArr, a aVar, f.a aVar2) {
        int i = aVar.o ? 24 : 16;
        boolean z = aVar.n && (tVar.m() & i) != 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= mVar.b) {
                return null;
            }
            l a2 = mVar.a(i3);
            int[] a3 = a(a2, iArr[i3], z, i, aVar.f, aVar.g, aVar.h, aVar.j, aVar.k, aVar.l);
            if (a3.length > 0) {
                return aVar2.b(a2, a3);
            }
            i2 = i3 + 1;
        }
    }

    private static void b(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int size = list.size();
        while (true) {
            int i5 = size - 1;
            if (i5 < 0) {
                return;
            }
            int intValue = list.get(i5).intValue();
            if (!a(lVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(i5);
            }
            size = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    protected f a(int i, m mVar, int[][] iArr, a aVar) {
        l lVar = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < mVar.b; i4++) {
            l a2 = mVar.a(i4);
            int[] iArr2 = iArr[i4];
            int i5 = 0;
            while (i5 < a2.f25309a) {
                l lVar2 = lVar;
                int i6 = i2;
                int i7 = i3;
                if (a(iArr2[i5], aVar.p)) {
                    int i8 = (a2.a(i5).x & 1) != 0 ? 2 : 1;
                    int i9 = i8;
                    if (a(iArr2[i5], false)) {
                        i9 = i8 + 1000;
                    }
                    lVar2 = lVar;
                    i6 = i2;
                    i7 = i3;
                    if (i9 > i3) {
                        lVar2 = a2;
                        i6 = i5;
                        i7 = i9;
                    }
                }
                i5++;
                lVar = lVar2;
                i2 = i6;
                i3 = i7;
            }
        }
        if (lVar == null) {
            return null;
        }
        return new d(lVar, i2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    protected f a(m mVar, int[][] iArr, a aVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    protected f a(m mVar, int[][] iArr, a aVar, f.a aVar2) {
        C0666c c0666c = null;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < mVar.b; i3++) {
            l a2 = mVar.a(i3);
            int[] iArr2 = iArr[i3];
            int i4 = 0;
            while (i4 < a2.f25309a) {
                int i5 = i;
                int i6 = i2;
                C0666c c0666c2 = c0666c;
                if (a(iArr2[i4], aVar.p)) {
                    C0666c c0666c3 = new C0666c(a2.a(i4), aVar, iArr2[i4]);
                    if (c0666c != null) {
                        i5 = i;
                        i6 = i2;
                        c0666c2 = c0666c;
                        if (c0666c3.compareTo(c0666c) <= 0) {
                        }
                    }
                    i5 = i3;
                    i6 = i4;
                    c0666c2 = c0666c3;
                }
                i4++;
                i = i5;
                i2 = i6;
                c0666c = c0666c2;
            }
        }
        if (i == -1) {
            return null;
        }
        l a3 = mVar.a(i);
        if (!aVar.m && aVar2 != null) {
            int[] a4 = a(a3, iArr[i], aVar.n);
            if (a4.length > 0) {
                return aVar2.b(a3, a4);
            }
        }
        return new d(a3, i2);
    }

    protected f a(t tVar, m mVar, int[][] iArr, a aVar, f.a aVar2) {
        f b2 = (aVar.m || aVar2 == null) ? null : b(tVar, mVar, iArr, aVar, aVar2);
        f fVar = b2;
        if (b2 == null) {
            fVar = b(mVar, iArr, aVar);
        }
        return fVar;
    }

    @Override // com.opos.exoplayer.core.g.e
    protected f[] a(t[] tVarArr, m[] mVarArr, int[][][] iArr) {
        boolean z;
        boolean z2;
        boolean z3;
        int length = tVarArr.length;
        f[] fVarArr = new f[length];
        a aVar = this.f25422c.get();
        boolean z4 = false;
        int i = 0;
        boolean z5 = false;
        while (true) {
            z = z5;
            if (i >= length) {
                break;
            }
            boolean z6 = z4;
            boolean z7 = z;
            if (2 == tVarArr[i].a()) {
                z6 = z4;
                if (!z4) {
                    fVarArr[i] = a(tVarArr[i], mVarArr[i], iArr[i], aVar, this.b);
                    z6 = fVarArr[i] != null;
                }
                z7 = z | (mVarArr[i].b > 0);
            }
            i++;
            z4 = z6;
            z5 = z7;
        }
        int i2 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (true) {
            boolean z10 = z9;
            if (i2 >= length) {
                return fVarArr;
            }
            int a2 = tVarArr[i2].a();
            if (a2 != 1) {
                z2 = z8;
                z3 = z10;
                if (a2 != 2) {
                    if (a2 != 3) {
                        fVarArr[i2] = a(tVarArr[i2].a(), mVarArr[i2], iArr[i2], aVar);
                        z2 = z8;
                        z3 = z10;
                    } else {
                        z2 = z8;
                        z3 = z10;
                        if (!z8) {
                            fVarArr[i2] = a(mVarArr[i2], iArr[i2], aVar);
                            if (fVarArr[i2] != null) {
                                z2 = true;
                                z3 = z10;
                            } else {
                                z2 = false;
                                z3 = z10;
                            }
                        }
                    }
                }
            } else {
                z2 = z8;
                z3 = z10;
                if (!z10) {
                    fVarArr[i2] = a(mVarArr[i2], iArr[i2], aVar, z ? null : this.b);
                    if (fVarArr[i2] != null) {
                        z3 = true;
                        z2 = z8;
                    } else {
                        z3 = false;
                        z2 = z8;
                    }
                }
            }
            i2++;
            z8 = z2;
            z9 = z3;
        }
    }
}
