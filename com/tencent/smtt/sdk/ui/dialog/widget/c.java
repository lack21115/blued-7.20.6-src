package com.tencent.smtt.sdk.ui.dialog.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/ui/dialog/widget/c.class */
public class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f25219a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f25220c;
    private float d;
    private Path e;
    private Paint f;
    private RectF g;

    public c(int i, float f, float f2, float f3, float f4) {
        this.f25219a = f;
        this.b = f2;
        this.d = f3;
        this.f25220c = f4;
        Paint paint = new Paint();
        this.f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
        this.f.setColor(i);
        this.g = new RectF();
    }

    public void a(int i, int i2) {
        this.g.left = 0.0f;
        this.g.top = 0.0f;
        this.g.right = i;
        this.g.bottom = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.e == null) {
            this.e = new Path();
        }
        this.e.reset();
        Path path = this.e;
        RectF rectF = this.g;
        float f = this.f25219a;
        float f2 = this.b;
        float f3 = this.d;
        float f4 = this.f25220c;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CCW);
        this.e.close();
        canvas.drawPath(this.e, this.f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
