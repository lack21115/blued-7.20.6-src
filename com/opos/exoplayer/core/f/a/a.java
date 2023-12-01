package com.opos.exoplayer.core.f.a;

import android.graphics.Color;
import android.mtp.MtpConstants;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.anythink.expressad.exoplayer.k.o;
import com.opos.exoplayer.core.f.h;
import com.opos.exoplayer.core.f.i;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/a.class */
public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f25327a = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] b = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f25328c = {-1, Color.GREEN, Color.BLUE, Color.CYAN, -65536, -256, Color.MAGENTA};
    private static final int[] d = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] e = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] f = {193, 201, 211, 218, 220, 252, MtpConstants.RESPONSE_CAPTURE_ALREADY_TERMINATED, 161, 42, 39, 8212, 169, 8480, 8226, MtpConstants.RESPONSE_INVALID_DEVICE_PROP_VALUE, MtpConstants.RESPONSE_INVALID_PARAMETER, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] g = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final int i;
    private final int j;
    private List<com.opos.exoplayer.core.f.b> m;
    private List<com.opos.exoplayer.core.f.b> n;
    private int o;
    private int p;
    private boolean q;
    private byte r;
    private byte s;
    private final m h = new m();
    private final ArrayList<C0659a> k = new ArrayList<>();
    private C0659a l = new C0659a(0, 4);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/a$a.class */
    public static class C0659a {

        /* renamed from: a  reason: collision with root package name */
        private final List<CharacterStyle> f25329a = new ArrayList();
        private final List<C0660a> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<SpannableString> f25330c = new ArrayList();
        private final SpannableStringBuilder d = new SpannableStringBuilder();
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.opos.exoplayer.core.f.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/a$a$a.class */
        public static class C0660a {

            /* renamed from: a  reason: collision with root package name */
            public final CharacterStyle f25331a;
            public final int b;

            /* renamed from: c  reason: collision with root package name */
            public final int f25332c;

            public C0660a(CharacterStyle characterStyle, int i, int i2) {
                this.f25331a = characterStyle;
                this.b = i;
                this.f25332c = i2;
            }
        }

        public C0659a(int i, int i2) {
            a(i);
            b(i2);
        }

        public void a(char c2) {
            this.d.append(c2);
        }

        public void a(int i) {
            this.h = i;
            this.f25329a.clear();
            this.b.clear();
            this.f25330c.clear();
            this.d.clear();
            this.e = 15;
            this.f = 0;
            this.g = 0;
            this.j = -1;
        }

        public void a(CharacterStyle characterStyle) {
            this.f25329a.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i) {
            this.b.add(new C0660a(characterStyle, this.d.length(), i));
        }

        public void a(boolean z) {
            if (z) {
                this.j = this.d.length();
            } else if (this.j != -1) {
                this.d.setSpan(new UnderlineSpan(), this.j, this.d.length(), 33);
                this.j = -1;
            }
        }

        public boolean a() {
            return this.f25329a.isEmpty() && this.b.isEmpty() && this.f25330c.isEmpty() && this.d.length() == 0;
        }

        public void b() {
            int length = this.d.length();
            if (length > 0) {
                this.d.delete(length - 1, length);
            }
        }

        public void b(int i) {
            this.i = i;
        }

        public int c() {
            return this.e;
        }

        public void c(int i) {
            this.e = i;
        }

        public void d() {
            this.f25330c.add(e());
            this.d.clear();
            this.f25329a.clear();
            this.b.clear();
            this.j = -1;
            int min = Math.min(this.i, this.e);
            while (this.f25330c.size() >= min) {
                this.f25330c.remove(0);
            }
        }

        public void d(int i) {
            this.f = i;
        }

        public SpannableString e() {
            int i;
            int length = this.d.length();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = 0;
                if (i3 >= this.f25329a.size()) {
                    break;
                }
                this.d.setSpan(this.f25329a.get(i3), 0, length, 33);
                i2 = i3 + 1;
            }
            while (i < this.b.size()) {
                C0660a c0660a = this.b.get(i);
                this.d.setSpan(c0660a.f25331a, c0660a.b, i < this.b.size() - c0660a.f25332c ? this.b.get(c0660a.f25332c + i).b : length, 33);
                i++;
            }
            if (this.j != -1) {
                this.d.setSpan(new UnderlineSpan(), this.j, length, 33);
            }
            return new SpannableString(this.d);
        }

        public void e(int i) {
            this.g = i;
        }

        public com.opos.exoplayer.core.f.b f() {
            float f;
            int i;
            int i2;
            int i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.f25330c.size()) {
                    break;
                }
                spannableStringBuilder.append((CharSequence) this.f25330c.get(i5));
                spannableStringBuilder.append('\n');
                i4 = i5 + 1;
            }
            spannableStringBuilder.append((CharSequence) e());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i6 = this.f + this.g;
            int length = (32 - i6) - spannableStringBuilder.length();
            int i7 = i6 - length;
            if (this.h == 2 && (Math.abs(i7) < 3 || length < 0)) {
                f = 0.5f;
                i = 1;
            } else if (this.h != 2 || i7 <= 0) {
                f = ((i6 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            } else {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            }
            if (this.h != 1) {
                i2 = this.e;
                if (i2 <= 7) {
                    i3 = 0;
                    return new com.opos.exoplayer.core.f.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
                }
            }
            i2 = (this.e - 15) - 2;
            i3 = 2;
            return new com.opos.exoplayer.core.f.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.d.toString();
        }
    }

    public a(String str, int i) {
        this.i = o.ac.equals(str) ? 2 : 3;
        if (i == 3 || i == 4) {
            this.j = 2;
        } else {
            this.j = 1;
        }
        a(0);
        j();
    }

    private void a(byte b2) {
        this.l.a((b2 & 1) == 1);
        int i = (b2 >> 1) & 15;
        if (i != 7) {
            this.l.a(new ForegroundColorSpan(f25328c[i]), 1);
            return;
        }
        this.l.a(new StyleSpan(2), 2);
        this.l.a(new ForegroundColorSpan(-1), 1);
    }

    private void a(int i) {
        int i2 = this.o;
        if (i2 == i) {
            return;
        }
        this.o = i;
        j();
        if (i2 == 3 || i == 1 || i == 0) {
            this.m = null;
        }
    }

    private boolean a(byte b2, byte b3) {
        boolean g2 = g(b2);
        if (g2) {
            if (this.q && this.r == b2 && this.s == b3) {
                this.q = false;
                return true;
            }
            this.q = true;
            this.r = b2;
            this.s = b3;
        }
        if (c(b2, b3)) {
            a(b3);
            return g2;
        } else if (d(b2, b3)) {
            b(b2, b3);
            return g2;
        } else if (e(b2, b3)) {
            this.l.e(b3 - 32);
            return g2;
        } else {
            if (f(b2, b3)) {
                b(b3);
            }
            return g2;
        }
    }

    private void b(byte b2) {
        if (b2 == 32) {
            a(2);
        } else if (b2 == 41) {
            a(3);
        } else {
            switch (b2) {
                case 37:
                    a(1);
                    b(2);
                    return;
                case 38:
                    a(1);
                    b(3);
                    return;
                case 39:
                    a(1);
                    b(4);
                    return;
                default:
                    int i = this.o;
                    if (i == 0) {
                        return;
                    }
                    if (b2 == 33) {
                        this.l.b();
                        return;
                    }
                    switch (b2) {
                        case 44:
                            this.m = null;
                            if (i != 1 && i != 3) {
                                return;
                            }
                            break;
                        case 45:
                            if (i != 1 || this.l.a()) {
                                return;
                            }
                            this.l.d();
                            return;
                        case 46:
                            break;
                        case 47:
                            this.m = i();
                            break;
                        default:
                            return;
                    }
                    j();
                    return;
            }
        }
    }

    private void b(byte b2, byte b3) {
        int i = f25327a[b2 & 7];
        int i2 = i;
        if ((b3 & 32) != 0) {
            i2 = i + 1;
        }
        if (i2 != this.l.c()) {
            if (this.o != 1 && !this.l.a()) {
                C0659a c0659a = new C0659a(this.o, this.p);
                this.l = c0659a;
                this.k.add(c0659a);
            }
            this.l.c(i2);
        }
        if ((b3 & 1) == 1) {
            this.l.a(new UnderlineSpan());
        }
        int i3 = (b3 >> 1) & 15;
        if (i3 > 7) {
            this.l.d(b[i3 & 7]);
        } else if (i3 != 7) {
            this.l.a(new ForegroundColorSpan(f25328c[i3]));
        } else {
            this.l.a(new StyleSpan(2));
            this.l.a(new ForegroundColorSpan(-1));
        }
    }

    private void b(int i) {
        this.p = i;
        this.l.b(i);
    }

    private static char c(byte b2) {
        return (char) d[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static boolean c(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static char d(byte b2) {
        return (char) e[b2 & 15];
    }

    private static boolean d(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static char e(byte b2) {
        return (char) f[b2 & 31];
    }

    private static boolean e(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static char f(byte b2) {
        return (char) g[b2 & 31];
    }

    private static boolean f(byte b2, byte b3) {
        return (b2 & 247) == 20 && (b3 & 240) == 32;
    }

    private static boolean g(byte b2) {
        return (b2 & 240) == 16;
    }

    private List<com.opos.exoplayer.core.f.b> i() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k.size()) {
                return arrayList;
            }
            com.opos.exoplayer.core.f.b f2 = this.k.get(i2).f();
            if (f2 != null) {
                arrayList.add(f2);
            }
            i = i2 + 1;
        }
    }

    private void j() {
        this.l.a(this.o);
        this.k.clear();
        this.k.add(this.l);
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.f.e
    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected void a(h hVar) {
        boolean z;
        C0659a c0659a;
        char c2;
        this.h.a(hVar.b.array(), hVar.b.limit());
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int b2 = this.h.b();
            int i = this.i;
            if (b2 < i) {
                break;
            }
            byte g2 = i == 2 ? (byte) -4 : (byte) this.h.g();
            byte g3 = (byte) (this.h.g() & 127);
            byte g4 = (byte) (this.h.g() & 127);
            if ((g2 & 6) == 4 && (this.j != 1 || (g2 & 1) == 0)) {
                if (this.j != 2 || (g2 & 1) == 1) {
                    if (g3 != 0 || g4 != 0) {
                        if ((g3 & 247) == 17 && (g4 & 240) == 48) {
                            c0659a = this.l;
                            c2 = d(g4);
                        } else if ((g3 & 246) == 18 && (g4 & 224) == 32) {
                            this.l.b();
                            if ((g3 & 1) == 0) {
                                c0659a = this.l;
                                c2 = e(g4);
                            } else {
                                c0659a = this.l;
                                c2 = f(g4);
                            }
                        } else {
                            if ((g3 & 224) == 0) {
                                z = a(g3, g4);
                            } else {
                                this.l.a(c(g3));
                                z = z3;
                                if ((g4 & 224) != 0) {
                                    c0659a = this.l;
                                    c2 = c(g4);
                                }
                            }
                            z2 = true;
                            z3 = z;
                        }
                        c0659a.a(c2);
                        z = z3;
                        z2 = true;
                        z3 = z;
                    }
                }
            }
        }
        if (z2) {
            if (!z3) {
                this.q = false;
            }
            int i2 = this.o;
            if (i2 == 1 || i2 == 3) {
                this.m = i();
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
        this.m = null;
        this.n = null;
        a(0);
        b(4);
        j();
        this.q = false;
        byte b2 = (byte) 0;
        this.r = b2;
        this.s = b2;
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.b.c
    public void d() {
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected boolean e() {
        return this.m != this.n;
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected com.opos.exoplayer.core.f.d f() {
        List<com.opos.exoplayer.core.f.b> list = this.m;
        this.n = list;
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
