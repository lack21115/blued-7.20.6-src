package com.tencent.mapsdk.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/zf.class */
public class zf extends Drawable {
    private static final int d = -2829100;
    private static final int e = -10066330;
    private static final int f = 16777215;

    /* renamed from: a  reason: collision with root package name */
    private boolean f38162a = false;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f38163c;

    public zf() {
        Paint paint = new Paint();
        this.f38163c = paint;
        paint.setAntiAlias(true);
        this.f38163c.setStrokeJoin(Paint.Join.BEVEL);
    }

    public void a(float f2) {
        this.f38163c.setStrokeWidth(f2);
    }

    public void a(boolean z) {
        this.f38162a = z;
    }

    public void b(boolean z) {
        this.b = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f38162a) {
            this.f38163c.setColor(this.b ? e : d);
        } else {
            this.f38163c.setColor(16777215);
        }
        canvas.drawLines(new float[]{0.0f, getBounds().height(), getBounds().width() / 2.0f, 0.0f, getBounds().width() / 2.0f, 0.0f, getBounds().width(), getBounds().height()}, this.f38163c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f38163c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f38163c.setColorFilter(colorFilter);
    }
}
