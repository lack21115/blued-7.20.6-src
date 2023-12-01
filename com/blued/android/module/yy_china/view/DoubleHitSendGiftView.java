package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DoubleHitSendGiftView.class */
public class DoubleHitSendGiftView extends AppCompatTextView {
    private float a;
    private Matrix b;
    private float c;
    private Paint d;
    private Paint e;
    private Paint f;
    private PorterDuffXfermode g;
    private long h;
    private long i;
    private int j;
    private boolean k;
    private long l;

    public DoubleHitSendGiftView(Context context) {
        this(context, null);
    }

    public DoubleHitSendGiftView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleHitSendGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.6f;
        this.b = new Matrix();
        this.c = 360.0f;
        this.h = 0L;
        this.i = 0L;
        this.j = 0;
        this.k = false;
        b();
    }

    private void a(Canvas canvas, float f, float f2) {
        float cos = (((float) Math.cos(Math.toRadians(this.c))) * 0.08f) + 0.92f;
        SweepGradient sweepGradient = new SweepGradient(f, f2, new int[]{-63405059, -67051349, -67051349, -63405059, -63405059}, (float[]) null);
        this.b.setRotate(this.c, f, f2);
        sweepGradient.setLocalMatrix(this.b);
        this.d.setShader(sweepGradient);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.e.setStrokeWidth(getHeight() * cos);
        canvas.drawLine(f2, f2, getWidth() - f2, f2, this.e);
        this.d.setXfermode(this.g);
        canvas.drawCircle(f, f2, getWidth(), this.d);
        this.d.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        this.f.setTextSize(50.0f * cos);
        this.f.setStrokeWidth(cos * 20.0f);
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = this.f.getFontMetricsInt();
        int i = (fontMetricsInt.bottom - fontMetricsInt.top) / 2;
        int i2 = fontMetricsInt.descent;
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawText("连击", 0.0f, i - i2, this.f);
        canvas.restore();
    }

    private void b() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.d.setDither(true);
        this.d.setFilterBitmap(true);
        this.d.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.e.setDither(true);
        this.e.setFilterBitmap(true);
        this.e.setColor(-1);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        this.g = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        Paint paint3 = new Paint();
        this.f = paint3;
        paint3.setColor(-1);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setTextAlign(Paint.Align.CENTER);
    }

    public void a() {
        this.l = 0L;
        this.a = 0.63f;
        this.k = false;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long j = this.l;
        if (j <= 0) {
            setVisibility(4);
            this.a = 0.63f;
            this.k = false;
            return;
        }
        if (j < 200 && this.k) {
            this.a += 0.003f;
        }
        a(canvas, getWidth() / 2, getHeight() / 2);
        long j2 = this.i;
        if (j2 != 0) {
            this.c = (this.c + (((float) ((j2 * 6) / 18)) / this.a)) % 360.0f;
        } else {
            this.c = (this.c + (6.0f / this.a)) % 360.0f;
        }
        if (this.j <= 5) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs((currentTimeMillis - this.h) - this.i) <= 4) {
                this.j++;
            }
            long j3 = currentTimeMillis - this.h;
            this.i = j3;
            this.h = currentTimeMillis;
            if (this.j > 5 && j3 != 0) {
                this.l = 260.0f / ((((float) j3) * 1.0f) / 18.0f);
            }
        } else {
            this.l--;
        }
        invalidate();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.l = 301L;
            float f = this.a;
            if (f > 0.55f) {
                this.a = f - 0.002f;
            } else if (f > 0.2f) {
                this.k = true;
                this.a = f - 0.01f;
            } else if (f > 0.15f) {
                this.a = f - 5.0E-4f;
            } else if (f > 0.1f) {
                this.a = f - 5.0E-5f;
            }
            this.h = 0L;
            this.j = 0;
        }
        super.setVisibility(i);
    }
}
