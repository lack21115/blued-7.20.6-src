package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/c.class */
public class c extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f26602a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f26603c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Bitmap l;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f26604a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26605c;

        public a(int i, int i2, int i3) {
            this.f26604a = i;
            this.b = i2;
            this.f26605c = i3;
        }
    }

    public c(Context context, a aVar) {
        super(context);
        setBackgroundColor(-1);
        this.b = aVar.f26604a;
        Paint paint = new Paint();
        this.f26603c = paint;
        paint.setAntiAlias(true);
        this.f26603c.setStyle(Paint.Style.FILL);
        this.f26603c.setColor(486539264);
        this.d = com.opos.cmn.an.h.f.a.a(getContext(), aVar.b / 2);
        this.e = com.opos.cmn.an.h.f.a.a(getContext(), aVar.f26605c / 2);
        this.f26602a = com.opos.cmn.an.h.f.a.a(getContext(), this.b);
        this.f = (com.opos.cmn.an.h.f.a.a(getContext(), aVar.b) - this.f26602a) / 2;
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), aVar.f26605c);
        int i = this.f26602a;
        int i2 = (a2 - i) / 2;
        this.g = i2;
        this.h = this.f + i;
        this.i = i2 + i;
        this.j = i + com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i2, i3);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static c a(Context context) {
        return new c(context, new a(121, 258, 169));
    }

    private void a(Canvas canvas) {
        if (this.l == null) {
            com.opos.cmn.an.f.a.a("cell icon", "not set bitmap");
            return;
        }
        int save = canvas.save();
        canvas.rotate(-45.0f, this.d, this.e);
        Rect rect = new Rect(0, 0, this.l.getWidth(), this.l.getHeight());
        int i = this.f;
        int i2 = this.j;
        RectF rectF = new RectF(i - i2, this.g - i2, this.h - i2, this.i - i2);
        int i3 = this.k;
        canvas.drawRoundRect(rectF, i3, i3, this.f26603c);
        a(canvas, this.l, rect, rectF);
        float f = this.f;
        int i4 = this.g;
        int i5 = this.j;
        RectF rectF2 = new RectF(f, i4 - i5, this.h, this.i - i5);
        int i6 = this.k;
        canvas.drawRoundRect(rectF2, i6, i6, this.f26603c);
        a(canvas, this.l, rect, rectF2);
        int i7 = this.f;
        int i8 = this.j;
        RectF rectF3 = new RectF(i7 - i8, this.g, this.h - i8, this.i);
        int i9 = this.k;
        canvas.drawRoundRect(rectF3, i9, i9, this.f26603c);
        a(canvas, this.l, rect, rectF3);
        RectF rectF4 = new RectF(this.f, this.g, this.h, this.i);
        int i10 = this.k;
        canvas.drawRoundRect(rectF4, i10, i10, this.f26603c);
        a(canvas, this.l, rect, rectF4);
        int i11 = this.f;
        int i12 = this.j;
        RectF rectF5 = new RectF(i11 + i12, this.g, this.h + i12, this.i);
        int i13 = this.k;
        canvas.drawRoundRect(rectF5, i13, i13, this.f26603c);
        a(canvas, this.l, rect, rectF5);
        float f2 = this.f;
        int i14 = this.g;
        int i15 = this.j;
        RectF rectF6 = new RectF(f2, i14 + i15, this.h, this.i + i15);
        int i16 = this.k;
        canvas.drawRoundRect(rectF6, i16, i16, this.f26603c);
        a(canvas, this.l, rect, rectF6);
        int i17 = this.f;
        int i18 = this.j;
        RectF rectF7 = new RectF(i17 + i18, this.g + i18, this.h + i18, this.i + i18);
        int i19 = this.k;
        canvas.drawRoundRect(rectF7, i19, i19, this.f26603c);
        a(canvas, this.l, rect, rectF7);
        canvas.restoreToCount(save);
    }

    private void a(Canvas canvas, Bitmap bitmap, Rect rect, RectF rectF) {
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, rect, rectF, (Paint) null);
        }
    }

    public static c b(Context context) {
        return new c(context, new a(128, 272, 179));
    }

    public void a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            com.opos.cmn.an.f.a.b("", "null bitmap");
        }
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), i);
        this.k = a2;
        int i2 = this.f26602a;
        this.l = a(bitmap, a2, i2, i2);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        a(canvas);
        super.onDraw(canvas);
    }
}
