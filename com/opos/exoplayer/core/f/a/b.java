package com.opos.exoplayer.core.f.a;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.opos.exoplayer.core.f.h;
import com.opos.exoplayer.core.f.i;
import com.opos.exoplayer.core.i.l;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/b.class */
public final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    private final m f11645a = new m();
    private final l b = new l();

    /* renamed from: c  reason: collision with root package name */
    private final int f11646c;
    private final a[] d;
    private a e;
    private List<com.opos.exoplayer.core.f.b> f;
    private List<com.opos.exoplayer.core.f.b> g;
    private C0491b h;
    private int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f11647a = a(2, 2, 2, 0);
        public static final int b = a(0, 0, 0, 0);

        /* renamed from: c  reason: collision with root package name */
        public static final int f11648c;
        private static final int[] d;
        private static final int[] e;
        private static final int[] f;
        private static final boolean[] g;
        private static final int[] h;
        private static final int[] i;
        private static final int[] j;
        private static final int[] k;
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private final List<SpannableString> l = new LinkedList();
        private final SpannableStringBuilder m = new SpannableStringBuilder();
        private boolean n;
        private boolean o;
        private int p;
        private boolean q;
        private int r;
        private int s;
        private int t;
        private int u;
        private boolean v;
        private int w;
        private int x;
        private int y;
        private int z;

        static {
            int a2 = a(0, 0, 0, 3);
            f11648c = a2;
            d = new int[]{0, 0, 0, 0, 0, 2, 0};
            e = new int[]{0, 0, 0, 0, 0, 0, 2};
            f = new int[]{3, 3, 3, 3, 3, 3, 1};
            g = new boolean[]{false, false, false, true, true, true, false};
            int i2 = b;
            h = new int[]{i2, a2, i2, i2, a2, i2, i2};
            i = new int[]{0, 1, 2, 3, 4, 3, 4};
            j = new int[]{0, 0, 0, 0, 0, 3, 3};
            k = new int[]{i2, i2, i2, i2, i2, a2, a2};
        }

        public a() {
            b();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int a(int r5, int r6, int r7, int r8) {
            /*
                r0 = 0
                r9 = r0
                r0 = r5
                r1 = 0
                r2 = 4
                int r0 = com.opos.exoplayer.core.i.a.a(r0, r1, r2)
                r0 = r6
                r1 = 0
                r2 = 4
                int r0 = com.opos.exoplayer.core.i.a.a(r0, r1, r2)
                r0 = r7
                r1 = 0
                r2 = 4
                int r0 = com.opos.exoplayer.core.i.a.a(r0, r1, r2)
                r0 = r8
                r1 = 0
                r2 = 4
                int r0 = com.opos.exoplayer.core.i.a.a(r0, r1, r2)
                r0 = r8
                if (r0 == 0) goto L40
                r0 = r8
                r1 = 1
                if (r0 == r1) goto L40
                r0 = r8
                r1 = 2
                if (r0 == r1) goto L3a
                r0 = r8
                r1 = 3
                if (r0 == r1) goto L35
                goto L40
            L35:
                r0 = 0
                r8 = r0
                goto L44
            L3a:
                r0 = 127(0x7f, float:1.78E-43)
                r8 = r0
                goto L44
            L40:
                r0 = 255(0xff, float:3.57E-43)
                r8 = r0
            L44:
                r0 = r5
                r1 = 1
                if (r0 <= r1) goto L50
                r0 = 255(0xff, float:3.57E-43)
                r5 = r0
                goto L52
            L50:
                r0 = 0
                r5 = r0
            L52:
                r0 = r6
                r1 = 1
                if (r0 <= r1) goto L5e
                r0 = 255(0xff, float:3.57E-43)
                r6 = r0
                goto L60
            L5e:
                r0 = 0
                r6 = r0
            L60:
                r0 = r7
                r1 = 1
                if (r0 <= r1) goto L6a
                r0 = 255(0xff, float:3.57E-43)
                r9 = r0
            L6a:
                r0 = r8
                r1 = r5
                r2 = r6
                r3 = r9
                int r0 = android.graphics.Color.argb(r0, r1, r2, r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.a.b.a.a(int, int, int, int):int");
        }

        public static int b(int i2, int i3, int i4) {
            return a(i2, i3, i4, 0);
        }

        public void a(char c2) {
            if (c2 != '\n') {
                this.m.append(c2);
                return;
            }
            this.l.add(g());
            this.m.clear();
            if (this.A != -1) {
                this.A = 0;
            }
            if (this.B != -1) {
                this.B = 0;
            }
            if (this.C != -1) {
                this.C = 0;
            }
            if (this.E != -1) {
                this.E = 0;
            }
            while (true) {
                if ((!this.v || this.l.size() < this.u) && this.l.size() < 15) {
                    return;
                }
                this.l.remove(0);
            }
        }

        public void a(int i2, int i3) {
            if (this.G != i2) {
                a('\n');
            }
            this.G = i2;
        }

        public void a(int i2, int i3, int i4) {
            if (this.C != -1 && this.D != i2) {
                this.m.setSpan(new ForegroundColorSpan(this.D), this.C, this.m.length(), 33);
            }
            if (i2 != f11647a) {
                this.C = this.m.length();
                this.D = i2;
            }
            if (this.E != -1 && this.F != i3) {
                this.m.setSpan(new BackgroundColorSpan(this.F), this.E, this.m.length(), 33);
            }
            if (i3 != b) {
                this.E = this.m.length();
                this.F = i3;
            }
        }

        public void a(int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
            if (this.A != -1) {
                if (!z) {
                    this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
                    this.A = -1;
                }
            } else if (z) {
                this.A = this.m.length();
            }
            if (this.B == -1) {
                if (z2) {
                    this.B = this.m.length();
                }
            } else if (z2) {
            } else {
                this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
                this.B = -1;
            }
        }

        public void a(int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
            this.z = i2;
            this.w = i7;
        }

        public void a(boolean z) {
            this.o = z;
        }

        public void a(boolean z, boolean z2, boolean z3, int i2, boolean z4, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.n = true;
            this.o = z;
            this.v = z2;
            this.p = i2;
            this.q = z4;
            this.r = i3;
            this.s = i4;
            this.t = i7;
            int i10 = i5 + 1;
            if (this.u != i10) {
                this.u = i10;
                while (true) {
                    if ((!z2 || this.l.size() < this.u) && this.l.size() < 15) {
                        break;
                    }
                    this.l.remove(0);
                }
            }
            if (i8 != 0 && this.x != i8) {
                this.x = i8;
                int i11 = i8 - 1;
                a(h[i11], f11648c, g[i11], 0, e[i11], f[i11], d[i11]);
            }
            if (i9 == 0 || this.y == i9) {
                return;
            }
            this.y = i9;
            int i12 = i9 - 1;
            a(0, 1, 1, false, false, j[i12], i[i12]);
            a(f11647a, k[i12], b);
        }

        public boolean a() {
            if (d()) {
                return this.l.isEmpty() && this.m.length() == 0;
            }
            return true;
        }

        public void b() {
            c();
            this.n = false;
            this.o = false;
            this.p = 4;
            this.q = false;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 15;
            this.v = true;
            this.w = 0;
            this.x = 0;
            this.y = 0;
            int i2 = b;
            this.z = i2;
            this.D = f11647a;
            this.F = i2;
        }

        public void c() {
            this.l.clear();
            this.m.clear();
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.E = -1;
            this.G = 0;
        }

        public boolean d() {
            return this.n;
        }

        public boolean e() {
            return this.o;
        }

        public void f() {
            int length = this.m.length();
            if (length > 0) {
                this.m.delete(length - 1, length);
            }
        }

        public SpannableString g() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
                }
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
                }
                if (this.E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0129  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.opos.exoplayer.core.f.a.d h() {
            /*
                Method dump skipped, instructions count: 347
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.a.b.a.h():com.opos.exoplayer.core.f.a.d");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/b$b.class */
    public static final class C0491b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11649a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11650c;
        int d = 0;

        public C0491b(int i, int i2) {
            this.f11649a = i;
            this.b = i2;
            this.f11650c = new byte[(i2 * 2) - 1];
        }
    }

    public b(int i) {
        this.f11646c = i == -1 ? 1 : i;
        this.d = new a[8];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 8) {
                this.e = this.d[0];
                p();
                return;
            }
            this.d[i3] = new a();
            i2 = i3 + 1;
        }
    }

    private void a(int i) {
        l lVar;
        int i2;
        if (i != 0) {
            if (i == 3) {
                this.f = o();
            } else if (i == 8) {
                this.e.f();
            } else {
                switch (i) {
                    case 12:
                        p();
                        return;
                    case 13:
                        this.e.a('\n');
                        return;
                    case 14:
                        return;
                    default:
                        if (i >= 17 && i <= 23) {
                            com.opos.cmn.an.f.a.c("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                            lVar = this.b;
                            i2 = 8;
                        } else if (i < 24 || i > 31) {
                            com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid C0 command: " + i);
                            return;
                        } else {
                            com.opos.cmn.an.f.a.c("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                            lVar = this.b;
                            i2 = 16;
                        }
                        lVar.b(i2);
                        return;
                }
            }
        }
    }

    private void b(int i) {
        a aVar;
        a aVar2;
        l lVar;
        int i2;
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i3 = i - 128;
                if (this.i != i3) {
                    this.i = i3;
                    aVar = this.d[i3];
                    this.e = aVar;
                    return;
                }
                return;
            case 136:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.b.e()) {
                        this.d[8 - i4].c();
                    }
                }
                return;
            case 137:
                int i5 = 1;
                while (true) {
                    int i6 = i5;
                    if (i6 > 8) {
                        return;
                    }
                    if (this.b.e()) {
                        this.d[8 - i6].a(true);
                    }
                    i5 = i6 + 1;
                }
            case 138:
                for (int i7 = 1; i7 <= 8; i7++) {
                    if (this.b.e()) {
                        this.d[8 - i7].a(false);
                    }
                }
                return;
            case 139:
                int i8 = 1;
                while (true) {
                    int i9 = i8;
                    if (i9 > 8) {
                        return;
                    }
                    if (this.b.e()) {
                        this.d[8 - i9].a(!aVar2.e());
                    }
                    i8 = i9 + 1;
                }
            case 140:
                for (int i10 = 1; i10 <= 8; i10++) {
                    if (this.b.e()) {
                        this.d[8 - i10].b();
                    }
                }
                return;
            case 141:
                this.b.b(8);
                return;
            case 142:
                return;
            case 143:
                p();
                return;
            case 144:
                if (this.e.d()) {
                    k();
                    return;
                }
                lVar = this.b;
                i2 = 16;
                lVar.b(i2);
                return;
            case 145:
                if (this.e.d()) {
                    l();
                    return;
                }
                lVar = this.b;
                i2 = 24;
                lVar.b(i2);
                return;
            case 146:
                if (this.e.d()) {
                    m();
                    return;
                }
                lVar = this.b;
                i2 = 16;
                lVar.b(i2);
                return;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid C1 command: " + i);
                return;
            case 151:
                if (this.e.d()) {
                    n();
                    return;
                }
                lVar = this.b;
                i2 = 32;
                lVar.b(i2);
                return;
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i11 = i - 152;
                i(i11);
                if (this.i != i11) {
                    this.i = i11;
                    aVar = this.d[i11];
                    this.e = aVar;
                    return;
                }
                return;
        }
    }

    private void c(int i) {
        l lVar;
        int i2;
        if (i <= 7) {
            return;
        }
        if (i <= 15) {
            lVar = this.b;
            i2 = 8;
        } else if (i <= 23) {
            lVar = this.b;
            i2 = 16;
        } else if (i > 31) {
            return;
        } else {
            lVar = this.b;
            i2 = 24;
        }
        lVar.b(i2);
    }

    private void d(int i) {
        l lVar;
        int i2;
        if (i <= 135) {
            lVar = this.b;
            i2 = 32;
        } else if (i > 143) {
            if (i <= 159) {
                this.b.b(2);
                this.b.b(this.b.c(6) * 8);
                return;
            }
            return;
        } else {
            lVar = this.b;
            i2 = 40;
        }
        lVar.b(i2);
    }

    private void e(int i) {
        if (i == 127) {
            this.e.a((char) 9835);
        } else {
            this.e.a((char) (i & 255));
        }
    }

    private void f(int i) {
        this.e.a((char) (i & 255));
    }

    private void g(int i) {
        a aVar;
        char c2 = ' ';
        if (i == 32) {
            aVar = this.e;
        } else if (i == 33) {
            aVar = this.e;
            c2 = 160;
        } else if (i == 37) {
            aVar = this.e;
            c2 = 8230;
        } else if (i == 42) {
            aVar = this.e;
            c2 = 352;
        } else if (i == 44) {
            aVar = this.e;
            c2 = 338;
        } else if (i == 63) {
            aVar = this.e;
            c2 = 376;
        } else if (i == 57) {
            aVar = this.e;
            c2 = 8482;
        } else if (i == 58) {
            aVar = this.e;
            c2 = 353;
        } else if (i == 60) {
            aVar = this.e;
            c2 = 339;
        } else if (i != 61) {
            switch (i) {
                case 48:
                    aVar = this.e;
                    c2 = 9608;
                    break;
                case 49:
                    aVar = this.e;
                    c2 = 8216;
                    break;
                case 50:
                    aVar = this.e;
                    c2 = 8217;
                    break;
                case 51:
                    aVar = this.e;
                    c2 = 8220;
                    break;
                case 52:
                    aVar = this.e;
                    c2 = 8221;
                    break;
                case 53:
                    aVar = this.e;
                    c2 = 8226;
                    break;
                default:
                    switch (i) {
                        case 118:
                            aVar = this.e;
                            c2 = 8539;
                            break;
                        case 119:
                            aVar = this.e;
                            c2 = 8540;
                            break;
                        case 120:
                            aVar = this.e;
                            c2 = 8541;
                            break;
                        case 121:
                            aVar = this.e;
                            c2 = 8542;
                            break;
                        case 122:
                            aVar = this.e;
                            c2 = 9474;
                            break;
                        case 123:
                            aVar = this.e;
                            c2 = 9488;
                            break;
                        case 124:
                            aVar = this.e;
                            c2 = 9492;
                            break;
                        case 125:
                            aVar = this.e;
                            c2 = 9472;
                            break;
                        case 126:
                            aVar = this.e;
                            c2 = 9496;
                            break;
                        case 127:
                            aVar = this.e;
                            c2 = 9484;
                            break;
                        default:
                            com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid G2 character: " + i);
                            return;
                    }
            }
        } else {
            aVar = this.e;
            c2 = 8480;
        }
        aVar.a(c2);
    }

    private void h(int i) {
        a aVar;
        char c2;
        if (i == 160) {
            aVar = this.e;
            c2 = 13252;
        } else {
            com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid G3 character: " + i);
            aVar = this.e;
            c2 = '_';
        }
        aVar.a(c2);
    }

    private void i() {
        if (this.h == null) {
            return;
        }
        j();
        this.h = null;
    }

    private void i(int i) {
        a aVar = this.d[i];
        this.b.b(2);
        boolean e = this.b.e();
        boolean e2 = this.b.e();
        boolean e3 = this.b.e();
        int c2 = this.b.c(3);
        boolean e4 = this.b.e();
        int c3 = this.b.c(7);
        int c4 = this.b.c(8);
        int c5 = this.b.c(4);
        int c6 = this.b.c(4);
        this.b.b(2);
        int c7 = this.b.c(6);
        this.b.b(2);
        aVar.a(e, e2, e3, c2, e4, c3, c4, c6, c7, c5, this.b.c(3), this.b.c(3));
    }

    private void j() {
        StringBuilder sb;
        String str;
        String str2;
        if (this.h.d != (this.h.b * 2) - 1) {
            str2 = "DtvCcPacket ended prematurely; size is " + ((this.h.b * 2) - 1) + ", but current index is " + this.h.d + " (sequence number " + this.h.f11649a + "); ignoring packet";
        } else {
            this.b.a(this.h.f11650c, this.h.d);
            int c2 = this.b.c(3);
            int c3 = this.b.c(5);
            int i = c2;
            if (c2 == 7) {
                this.b.b(2);
                i = c2 + this.b.c(6);
            }
            if (c3 != 0) {
                if (i == this.f11646c) {
                    boolean z = false;
                    while (this.b.a() > 0) {
                        int c4 = this.b.c(8);
                        if (c4 == 16) {
                            c4 = this.b.c(8);
                            if (c4 <= 31) {
                                c(c4);
                            } else {
                                if (c4 <= 127) {
                                    g(c4);
                                } else if (c4 <= 159) {
                                    d(c4);
                                } else if (c4 <= 255) {
                                    h(c4);
                                } else {
                                    sb = new StringBuilder();
                                    str = "Invalid extended command: ";
                                    sb.append(str);
                                    sb.append(c4);
                                    com.opos.cmn.an.f.a.c("Cea708Decoder", sb.toString());
                                }
                                z = true;
                            }
                        } else if (c4 <= 31) {
                            a(c4);
                        } else {
                            if (c4 <= 127) {
                                e(c4);
                            } else if (c4 <= 159) {
                                b(c4);
                            } else if (c4 <= 255) {
                                f(c4);
                            } else {
                                sb = new StringBuilder();
                                str = "Invalid base command: ";
                                sb.append(str);
                                sb.append(c4);
                                com.opos.cmn.an.f.a.c("Cea708Decoder", sb.toString());
                            }
                            z = true;
                        }
                    }
                    if (z) {
                        this.f = o();
                        return;
                    }
                    return;
                }
                return;
            } else if (i == 0) {
                return;
            } else {
                str2 = "serviceNumber is non-zero (" + i + ") when blockSize is 0";
            }
        }
        com.opos.cmn.an.f.a.c("Cea708Decoder", str2);
    }

    private void k() {
        this.e.a(this.b.c(4), this.b.c(2), this.b.c(2), this.b.e(), this.b.e(), this.b.c(3), this.b.c(3));
    }

    private void l() {
        int a2 = a.a(this.b.c(2), this.b.c(2), this.b.c(2), this.b.c(2));
        int a3 = a.a(this.b.c(2), this.b.c(2), this.b.c(2), this.b.c(2));
        this.b.b(2);
        this.e.a(a2, a3, a.b(this.b.c(2), this.b.c(2), this.b.c(2)));
    }

    private void m() {
        this.b.b(4);
        int c2 = this.b.c(4);
        this.b.b(2);
        this.e.a(c2, this.b.c(6));
    }

    private void n() {
        int a2 = a.a(this.b.c(2), this.b.c(2), this.b.c(2), this.b.c(2));
        int c2 = this.b.c(2);
        int b = a.b(this.b.c(2), this.b.c(2), this.b.c(2));
        int i = c2;
        if (this.b.e()) {
            i = c2 | 4;
        }
        boolean e = this.b.e();
        int c3 = this.b.c(2);
        int c4 = this.b.c(2);
        int c5 = this.b.c(2);
        this.b.b(8);
        this.e.a(a2, b, e, i, c3, c4, c5);
    }

    private List<com.opos.exoplayer.core.f.b> o() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                Collections.sort(arrayList);
                return Collections.unmodifiableList(arrayList);
            }
            if (!this.d[i2].a() && this.d[i2].e()) {
                arrayList.add(this.d[i2].h());
            }
            i = i2 + 1;
        }
    }

    private void p() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return;
            }
            this.d[i2].b();
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.f.e
    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected void a(h hVar) {
        this.f11645a.a(hVar.b.array(), hVar.b.limit());
        while (this.f11645a.b() >= 3) {
            int g = this.f11645a.g() & 7;
            int i = g & 3;
            boolean z = false;
            boolean z2 = (g & 4) == 4;
            byte g2 = (byte) this.f11645a.g();
            byte g3 = (byte) this.f11645a.g();
            if (i == 2 || i == 3) {
                if (z2) {
                    if (i == 3) {
                        i();
                        int i2 = g2 & 63;
                        int i3 = i2;
                        if (i2 == 0) {
                            i3 = 64;
                        }
                        C0491b c0491b = new C0491b((g2 & 192) >> 6, i3);
                        this.h = c0491b;
                        byte[] bArr = c0491b.f11650c;
                        C0491b c0491b2 = this.h;
                        int i4 = c0491b2.d;
                        c0491b2.d = i4 + 1;
                        bArr[i4] = g3;
                    } else {
                        if (i == 2) {
                            z = true;
                        }
                        com.opos.exoplayer.core.i.a.a(z);
                        C0491b c0491b3 = this.h;
                        if (c0491b3 == null) {
                            com.opos.cmn.an.f.a.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0491b3.f11650c;
                            C0491b c0491b4 = this.h;
                            int i5 = c0491b4.d;
                            c0491b4.d = i5 + 1;
                            bArr2[i5] = g2;
                            byte[] bArr3 = this.h.f11650c;
                            C0491b c0491b5 = this.h;
                            int i6 = c0491b5.d;
                            c0491b5.d = i6 + 1;
                            bArr3[i6] = g3;
                        }
                    }
                    if (this.h.d == (this.h.b * 2) - 1) {
                        i();
                    }
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.f.a.e
    public /* bridge */ /* synthetic */ void b(h hVar) {
        super.a(hVar);
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.b.c
    public void c() {
        super.c();
        this.f = null;
        this.g = null;
        this.i = 0;
        this.e = this.d[0];
        p();
        this.h = null;
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.b.c
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected boolean e() {
        return this.f != this.g;
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected com.opos.exoplayer.core.f.d f() {
        List<com.opos.exoplayer.core.f.b> list = this.f;
        this.g = list;
        return new f(list);
    }

    @Override // com.opos.exoplayer.core.f.a.e
    public /* bridge */ /* synthetic */ i g() {
        return super.b();
    }

    @Override // com.opos.exoplayer.core.f.a.e
    public /* bridge */ /* synthetic */ h h() {
        return super.a();
    }
}
