package com.opos.exoplayer.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.opos.exoplayer.core.i.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/e.class */
public final class e {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private StaticLayout G;
    private int H;
    private int I;
    private int J;
    private Rect K;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f24998a = new RectF();
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f24999c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final TextPaint h;
    private final Paint i;
    private CharSequence j;
    private Layout.Alignment k;
    private Bitmap l;
    private float m;
    private int n;
    private int o;
    private float p;
    private int q;
    private float r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public e(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.b = round;
        this.f24999c = round;
        this.d = round;
        this.e = round;
        TextPaint textPaint = new TextPaint();
        this.h = textPaint;
        textPaint.setAntiAlias(true);
        this.h.setSubpixelText(true);
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.i.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02bc  */
    /* JADX WARN: Type inference failed for: r0v190, types: [java.lang.CharSequence] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.e.a():void");
    }

    private void a(Canvas canvas) {
        StaticLayout staticLayout = this.G;
        if (staticLayout == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.H, this.I);
        if (Color.alpha(this.x) > 0) {
            this.i.setColor(this.x);
            canvas.drawRect(-this.J, 0.0f, staticLayout.getWidth() + this.J, staticLayout.getHeight(), this.i);
        }
        if (Color.alpha(this.w) > 0) {
            this.i.setColor(this.w);
            float lineTop = staticLayout.getLineTop(0);
            int lineCount = staticLayout.getLineCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= lineCount) {
                    break;
                }
                this.f24998a.left = staticLayout.getLineLeft(i2) - this.J;
                this.f24998a.right = staticLayout.getLineRight(i2) + this.J;
                this.f24998a.top = lineTop;
                this.f24998a.bottom = staticLayout.getLineBottom(i2);
                lineTop = this.f24998a.bottom;
                RectF rectF = this.f24998a;
                float f = this.b;
                canvas.drawRoundRect(rectF, f, f, this.i);
                i = i2 + 1;
            }
        }
        int i3 = this.z;
        boolean z = true;
        if (i3 == 1) {
            this.h.setStrokeJoin(Paint.Join.ROUND);
            this.h.setStrokeWidth(this.f24999c);
            this.h.setColor(this.y);
            this.h.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout.draw(canvas);
        } else if (i3 == 2) {
            TextPaint textPaint = this.h;
            float f2 = this.d;
            float f3 = this.e;
            textPaint.setShadowLayer(f2, f3, f3, this.y);
        } else if (i3 == 3 || i3 == 4) {
            if (this.z != 3) {
                z = false;
            }
            int i4 = -1;
            int i5 = z ? -1 : this.y;
            if (z) {
                i4 = this.y;
            }
            float f4 = this.d / 2.0f;
            this.h.setColor(this.v);
            this.h.setStyle(Paint.Style.FILL);
            float f5 = -f4;
            this.h.setShadowLayer(this.d, f5, f5, i5);
            staticLayout.draw(canvas);
            this.h.setShadowLayer(this.d, f4, f4, i4);
        }
        this.h.setColor(this.v);
        this.h.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != charSequence2) {
            return charSequence != null && charSequence.equals(charSequence2);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.e.b():void");
    }

    private void b(Canvas canvas) {
        canvas.drawBitmap(this.l, (Rect) null, this.K, (Paint) null);
    }

    public void a(com.opos.exoplayer.core.f.b bVar, boolean z, boolean z2, com.opos.exoplayer.core.f.a aVar, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        boolean z3 = bVar.f25345c == null;
        int i5 = -16777216;
        if (z3) {
            if (TextUtils.isEmpty(bVar.f25344a)) {
                return;
            }
            i5 = (bVar.k && z) ? bVar.l : aVar.d;
        }
        if (!a(this.j, bVar.f25344a) || !u.a(this.k, bVar.b) || this.l != bVar.f25345c || this.m != bVar.d || this.n != bVar.e || !u.a(Integer.valueOf(this.o), Integer.valueOf(bVar.f)) || this.p != bVar.g || !u.a(Integer.valueOf(this.q), Integer.valueOf(bVar.h)) || this.r != bVar.i || this.s != bVar.j || this.t != z || this.u != z2 || this.v != aVar.b || this.w != aVar.f25326c || this.x != i5 || this.z != aVar.e || this.y != aVar.f || !u.a(this.h.getTypeface(), aVar.g) || this.A != f || this.B != f2 || this.C != i || this.D != i2 || this.E != i3 || this.F != i4) {
            this.j = bVar.f25344a;
            this.k = bVar.b;
            this.l = bVar.f25345c;
            this.m = bVar.d;
            this.n = bVar.e;
            this.o = bVar.f;
            this.p = bVar.g;
            this.q = bVar.h;
            this.r = bVar.i;
            this.s = bVar.j;
            this.t = z;
            this.u = z2;
            this.v = aVar.b;
            this.w = aVar.f25326c;
            this.x = i5;
            this.z = aVar.e;
            this.y = aVar.f;
            this.h.setTypeface(aVar.g);
            this.A = f;
            this.B = f2;
            this.C = i;
            this.D = i2;
            this.E = i3;
            this.F = i4;
            if (z3) {
                a();
            } else {
                b();
            }
        }
        a(canvas, z3);
    }
}
