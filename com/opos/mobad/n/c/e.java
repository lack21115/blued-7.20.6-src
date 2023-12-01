package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.widget.ImageView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/e.class */
public class e extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private float f12920a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f12921c;

    public e(Context context) {
        super(context);
        this.f12920a = 0.0f;
        this.b = 0.0f;
    }

    public void a(int i) {
        this.f12920a = i;
        invalidate();
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap createBitmap;
        Canvas canvas2;
        float f = this.f12920a;
        if (f <= 0.0f) {
            super.onDraw(canvas);
        } else if (f * 2.0f >= getWidth() || this.f12920a * 2.0f >= getHeight()) {
        } else {
            Bitmap bitmap = this.f12921c;
            if (bitmap != null && bitmap.getWidth() == getWidth() && this.f12921c.getHeight() == getHeight()) {
                createBitmap = this.f12921c;
                canvas2 = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                paint.setColor(0);
                canvas2.drawPaint(paint);
            } else {
                Bitmap bitmap2 = this.f12921c;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.f12921c = null;
                }
                createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                this.f12921c = createBitmap;
                canvas2 = new Canvas(createBitmap);
            }
            super.onDraw(canvas2);
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setShader(new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            float f2 = this.f12920a;
            float width = getWidth();
            float f3 = this.f12920a;
            float height = getHeight();
            float f4 = this.f12920a;
            float f5 = this.b;
            canvas.drawRoundRect(f2, f2, width - f3, height - f4, f5, f5, paint2);
        }
    }
}
