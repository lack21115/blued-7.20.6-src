package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/rangebar/Thumb.class */
class Thumb {

    /* renamed from: a  reason: collision with root package name */
    private final float f28626a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f28627c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private boolean h = false;
    private final float i;
    private float j;
    private Paint k;
    private Paint l;
    private float m;
    private boolean n;
    private int o;
    private int p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Thumb(Context context, float f, int i, int i2, float f2, int i3, int i4) {
        Resources resources = context.getResources();
        this.b = BitmapFactory.decodeResource(resources, i3);
        this.f28627c = BitmapFactory.decodeResource(resources, i4);
        int i5 = (f2 > (-1.0f) ? 1 : (f2 == (-1.0f) ? 0 : -1));
        if (i5 == 0 && i == -1 && i2 == -1) {
            this.n = true;
        } else {
            this.n = false;
            if (i5 == 0) {
                this.m = TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
            } else {
                this.m = TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
            }
            if (i == -1) {
                this.o = -13388315;
            } else {
                this.o = i;
            }
            if (i2 == -1) {
                this.p = -13388315;
            } else {
                this.p = i2;
            }
            Paint paint = new Paint();
            this.k = paint;
            paint.setColor(this.o);
            this.k.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.l = paint2;
            paint2.setColor(this.p);
            this.l.setAntiAlias(true);
        }
        this.d = this.b.getWidth() / 2.0f;
        this.e = this.b.getHeight() / 2.0f;
        this.f = this.f28627c.getWidth() / 2.0f;
        this.g = this.f28627c.getHeight() / 2.0f;
        this.f28626a = TypedValue.applyDimension(1, (int) Math.max(24.0f, f2), resources.getDisplayMetrics());
        this.j = this.d;
        this.i = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        this.j = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (!this.n) {
            if (this.h) {
                canvas.drawCircle(this.j, this.i, this.m, this.l);
                return;
            } else {
                canvas.drawCircle(this.j, this.i, this.m, this.k);
                return;
            }
        }
        Bitmap bitmap = this.h ? this.f28627c : this.b;
        if (this.h) {
            canvas.drawBitmap(bitmap, this.j - this.f, this.i - this.g, (Paint) null);
        } else {
            canvas.drawBitmap(bitmap, this.j - this.d, this.i - this.e, (Paint) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(float f, float f2) {
        return Math.abs(f - this.j) <= this.f28626a && Math.abs(f2 - this.i) <= this.f28626a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.h = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.h = false;
    }
}
