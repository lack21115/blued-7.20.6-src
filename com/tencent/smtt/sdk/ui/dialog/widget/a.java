package com.tencent.smtt.sdk.ui.dialog.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/ui/dialog/widget/a.class */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f25215a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f25216c;
    private Paint d;
    private Path e;
    private Path f;
    private RectF g;
    private float[] h;
    private float i;
    private float j;

    public a(Context context, float f, float f2, float f3) {
        super(context, null, 0);
        a(context, f, f2, f3);
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(100, size);
        }
        return 100;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(Context context, float f, float f2, float f3) {
        this.i = f2;
        this.j = f3;
        int parseColor = Color.parseColor("#989DB4");
        float a2 = a(context, 6.0f);
        this.f25216c = new Paint();
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(-1);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setAntiAlias(true);
        this.f25216c.setColor(parseColor);
        this.f25216c.setStyle(Paint.Style.STROKE);
        this.f25216c.setAntiAlias(true);
        this.f25216c.setStrokeWidth(a2);
        this.f25216c.setStrokeJoin(Paint.Join.ROUND);
        this.g = new RectF();
        this.h = new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, 0.0f);
        canvas.rotate(0.0f);
        if (this.f == null) {
            this.f = new Path();
        }
        this.f.reset();
        this.f.addRoundRect(this.g, this.h, Path.Direction.CCW);
        this.f.close();
        canvas.drawPath(this.f, this.d);
        canvas.translate(this.f25215a / 2.0f, (this.b / 2.0f) + (this.j / 2.0f));
        if (this.e == null) {
            this.e = new Path();
        }
        this.e.reset();
        this.e.moveTo(0.0f, 0.0f);
        this.e.lineTo((-this.i) / 2.0f, (-this.j) / 2.0f);
        this.e.close();
        canvas.drawPath(this.e, this.f25216c);
        this.e.reset();
        this.e.moveTo(0.0f, 0.0f);
        this.e.lineTo(this.i / 2.0f, (-this.j) / 2.0f);
        this.e.close();
        canvas.drawPath(this.e, this.f25216c);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(a(i), a(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25215a = i;
        this.b = i2;
        this.g.left = 0.0f;
        this.g.top = 0.0f;
        this.g.right = this.f25215a;
        this.g.bottom = this.b;
    }
}
