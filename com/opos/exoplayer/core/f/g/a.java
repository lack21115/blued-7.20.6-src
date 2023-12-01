package com.opos.exoplayer.core.f.g;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.f.d;
import com.opos.exoplayer.core.f.f;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/g/a.class */
public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f25388a = u.f("styl");
    private static final int b = u.f("tbox");

    /* renamed from: c  reason: collision with root package name */
    private final m f25389c;
    private boolean d;
    private int e;
    private int f;
    private String g;
    private float h;
    private int i;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f25389c = new m();
        a(list);
    }

    private static String a(m mVar) {
        char f;
        a(mVar.b() >= 2);
        int h = mVar.h();
        if (h == 0) {
            return "";
        }
        return mVar.a(h, Charset.forName((mVar.b() < 2 || !((f = mVar.f()) == 65279 || f == 65534)) ? "UTF-8" : "UTF-16"));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.text.SpannableStringBuilder r6, int r7, int r8, int r9, int r10, int r11) {
        /*
            r0 = r7
            r1 = r8
            if (r0 == r1) goto La8
            r0 = r11
            r1 = 33
            r0 = r0 | r1
            r13 = r0
            r0 = 1
            r12 = r0
            r0 = r7
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L1a
            r0 = 1
            r8 = r0
            goto L1c
        L1a:
            r0 = 0
            r8 = r0
        L1c:
            r0 = r7
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L28
            r0 = 1
            r11 = r0
            goto L2b
        L28:
            r0 = 0
            r11 = r0
        L2b:
            r0 = r8
            if (r0 == 0) goto L4e
            r0 = r11
            if (r0 == 0) goto L41
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r1 = r0
            r2 = 3
            r1.<init>(r2)
            r14 = r0
            goto L5d
        L41:
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r1 = r0
            r2 = 1
            r1.<init>(r2)
            r14 = r0
            goto L5d
        L4e:
            r0 = r11
            if (r0 == 0) goto L68
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r1 = r0
            r2 = 2
            r1.<init>(r2)
            r14 = r0
        L5d:
            r0 = r6
            r1 = r14
            r2 = r9
            r3 = r10
            r4 = r13
            r0.setSpan(r1, r2, r3, r4)
        L68:
            r0 = r7
            r1 = 4
            r0 = r0 & r1
            if (r0 == 0) goto L74
            r0 = r12
            r7 = r0
            goto L76
        L74:
            r0 = 0
            r7 = r0
        L76:
            r0 = r7
            if (r0 == 0) goto L8a
            r0 = r6
            android.text.style.UnderlineSpan r1 = new android.text.style.UnderlineSpan
            r2 = r1
            r2.<init>()
            r2 = r9
            r3 = r10
            r4 = r13
            r0.setSpan(r1, r2, r3, r4)
        L8a:
            r0 = r7
            if (r0 != 0) goto La8
            r0 = r8
            if (r0 != 0) goto La8
            r0 = r11
            if (r0 != 0) goto La8
            r0 = r6
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r2 = r1
            r3 = 0
            r2.<init>(r3)
            r2 = r9
            r3 = r10
            r4 = r13
            r0.setSpan(r1, r2, r3, r4)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.g.a.a(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    private void a(m mVar, SpannableStringBuilder spannableStringBuilder) {
        a(mVar.b() >= 12);
        int h = mVar.h();
        int h2 = mVar.h();
        mVar.d(2);
        int g = mVar.g();
        mVar.d(1);
        int o = mVar.o();
        a(spannableStringBuilder, g, this.e, h, h2, 0);
        b(spannableStringBuilder, o, this.f, h, h2, 0);
    }

    private void a(List<byte[]> list) {
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.e = bArr[24];
            this.f = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            String str = com.anythink.expressad.exoplayer.b.m;
            if ("Serif".equals(new String(bArr, 43, bArr.length - 43))) {
                str = com.anythink.expressad.exoplayer.b.l;
            }
            this.g = str;
            this.i = bArr[25] * 20;
            if ((bArr[0] & 32) != 0) {
                z = true;
            }
            this.d = z;
            if (z) {
                float f = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / this.i;
                this.h = f;
                this.h = u.a(f, 0.0f, 0.95f);
                return;
            }
        } else {
            this.e = 0;
            this.f = -1;
            this.g = com.anythink.expressad.exoplayer.b.m;
            this.d = false;
        }
        this.h = 0.85f;
    }

    private static void a(boolean z) {
        if (!z) {
            throw new f("Unexpected subtitle format.");
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    @Override // com.opos.exoplayer.core.f.c
    public d a(byte[] bArr, int i, boolean z) {
        float f;
        this.f25389c.a(bArr, i);
        String a2 = a(this.f25389c);
        if (a2.isEmpty()) {
            return b.f25390a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
        a(spannableStringBuilder, this.e, 0, 0, spannableStringBuilder.length(), (int) Spanned.SPAN_PRIORITY);
        b(spannableStringBuilder, this.f, -1, 0, spannableStringBuilder.length(), Spanned.SPAN_PRIORITY);
        a(spannableStringBuilder, this.g, com.anythink.expressad.exoplayer.b.m, 0, spannableStringBuilder.length(), (int) Spanned.SPAN_PRIORITY);
        float f2 = this.h;
        while (true) {
            float f3 = f2;
            if (this.f25389c.b() < 8) {
                return new b(new com.opos.exoplayer.core.f.b(spannableStringBuilder, null, f3, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
            }
            int d = this.f25389c.d();
            int o = this.f25389c.o();
            int o2 = this.f25389c.o();
            boolean z2 = true;
            int i2 = 0;
            if (o2 == f25388a) {
                if (this.f25389c.b() < 2) {
                    z2 = false;
                }
                a(z2);
                int h = this.f25389c.h();
                while (true) {
                    f = f3;
                    if (i2 < h) {
                        a(this.f25389c, spannableStringBuilder);
                        i2++;
                    }
                }
            } else {
                f = f3;
                if (o2 == b) {
                    f = f3;
                    if (this.d) {
                        a(this.f25389c.b() >= 2);
                        f = u.a(this.f25389c.h() / this.i, 0.0f, 0.95f);
                    }
                }
            }
            this.f25389c.c(d + o);
            f2 = f;
        }
    }
}
