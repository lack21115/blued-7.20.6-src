package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ColorTrackView.class */
public class ColorTrackView extends View {
    private int a;
    private int b;
    private int c;
    private String d;
    private Paint e;
    private int f;
    private int g;
    private int h;
    private Rect i;
    private int j;
    private int k;
    private float l;
    private boolean m;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ColorTrackView$Direction.class */
    public enum Direction {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    public ColorTrackView(Context context) {
        super(context, null);
        this.c = 0;
        this.d = "张鸿洋";
        this.f = a(15.0f);
        this.g = View.MEASURED_STATE_MASK;
        this.h = -65536;
        this.i = new Rect();
        this.m = false;
        a();
    }

    public ColorTrackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = "张鸿洋";
        this.f = a(15.0f);
        this.g = View.MEASURED_STATE_MASK;
        this.h = -65536;
        this.i = new Rect();
        this.m = false;
        a();
    }

    private int a(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int height = (mode == Integer.MIN_VALUE || mode == 0) ? this.i.height() + getPaddingTop() + getPaddingBottom() : mode != 1073741824 ? 0 : size;
        int i2 = height;
        if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(height, size);
        }
        return i2;
    }

    private void a() {
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setTextSize(this.f);
        this.g = getResources().getColor(R.color.nafio_k);
        this.h = getResources().getColor(R.color.nafio_a);
    }

    private void a(Canvas canvas, int i) {
        int i2 = this.h;
        int i3 = this.a;
        a(canvas, i2, i3, (int) (i3 + (this.l * this.j)));
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        this.e.setColor(i);
        if (this.m) {
            this.e.setStyle(Paint.Style.STROKE);
            canvas.drawRect(i2, 0.0f, i3, getMeasuredHeight(), this.e);
        }
        canvas.save();
        canvas.clipRect(i2, 0, i3, getMeasuredHeight());
        canvas.drawText(this.d, this.a, (getMeasuredHeight() / 2) - ((this.e.descent() + this.e.ascent()) / 2.0f), this.e);
        canvas.restore();
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (mode == Integer.MIN_VALUE || mode == 0) ? this.j + getPaddingLeft() + getPaddingRight() : mode != 1073741824 ? 0 : size;
        int i2 = paddingLeft;
        if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(paddingLeft, size);
        }
        return i2;
    }

    private void b() {
        this.j = (int) this.e.measureText(this.d);
        Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
        this.k = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
        Paint paint = this.e;
        String str = this.d;
        paint.getTextBounds(str, 0, str.length(), this.i);
        this.k = this.i.height();
    }

    private void b(Canvas canvas, int i) {
        int i2 = this.g;
        int i3 = this.a;
        float f = i3;
        float f2 = this.l;
        int i4 = this.j;
        a(canvas, i2, (int) (f + (f2 * i4)), i3 + i4);
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        this.e.setColor(i);
        if (this.m) {
            this.e.setStyle(Paint.Style.STROKE);
            canvas.drawRect(0.0f, i2, getMeasuredWidth(), i3, this.e);
        }
        canvas.save();
        canvas.clipRect(0, i2, getMeasuredWidth(), i3);
        canvas.drawText(this.d, this.a, (getMeasuredHeight() / 2) - ((this.e.descent() + this.e.ascent()) / 2.0f), this.e);
        canvas.restore();
    }

    private void c(Canvas canvas, int i) {
        int i2 = this.h;
        int i3 = this.a;
        float f = i3;
        float f2 = this.l;
        int i4 = this.j;
        a(canvas, i2, (int) (f + ((1.0f - f2) * i4)), i3 + i4);
    }

    private void d(Canvas canvas, int i) {
        int i2 = this.g;
        int i3 = this.a;
        a(canvas, i2, i3, (int) (i3 + ((1.0f - this.l) * this.j)));
    }

    private void e(Canvas canvas, int i) {
        int i2 = this.h;
        int i3 = this.b;
        b(canvas, i2, i3, (int) (i3 + (this.l * this.k)));
    }

    private void f(Canvas canvas, int i) {
        int i2 = this.g;
        int i3 = this.b;
        float f = i3;
        float f2 = this.l;
        int i4 = this.k;
        b(canvas, i2, (int) (f + (f2 * i4)), i3 + i4);
    }

    private void g(Canvas canvas, int i) {
        int i2 = this.h;
        int i3 = this.b;
        float f = i3;
        float f2 = this.l;
        int i4 = this.k;
        b(canvas, i2, (int) (f + ((1.0f - f2) * i4)), i3 + i4);
    }

    private void h(Canvas canvas, int i) {
        int i2 = this.g;
        int i3 = this.b;
        b(canvas, i2, i3, (int) (i3 + ((1.0f - this.l) * this.k)));
    }

    public float getProgress() {
        return this.l;
    }

    public int getTextChangeColor() {
        return this.h;
    }

    public int getTextOriginColor() {
        return this.g;
    }

    public int getTextSize() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.l;
        int i = (int) ((this.j * f) + this.a);
        int i2 = (int) ((f * this.k) + this.b);
        int i3 = this.c;
        if (i3 == 0) {
            a(canvas, i);
            b(canvas, i);
        } else if (i3 == 1) {
            d(canvas, i);
            c(canvas, i);
        } else if (i3 == 2) {
            f(canvas, i2);
            e(canvas, i2);
        } else {
            h(canvas, i2);
            g(canvas, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        b();
        setMeasuredDimension(b(i), a(i2));
        this.a = (getMeasuredWidth() / 2) - (this.j / 2);
        this.b = (getMeasuredHeight() / 2) - (this.k / 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.l = bundle.getFloat("key_progress");
        super.onRestoreInstanceState(bundle.getParcelable("key_default_state"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putFloat("key_progress", this.l);
        bundle.putParcelable("key_default_state", super.onSaveInstanceState());
        return bundle;
    }

    public void setDirection(int i) {
        this.c = i;
    }

    public void setProgress(float f) {
        this.l = f;
        invalidate();
    }

    public void setText(String str) {
        this.d = str;
        requestLayout();
        invalidate();
    }

    public void setTextChangeColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setTextOriginColor(int i) {
        this.g = i;
        invalidate();
    }

    public void setTextSize(int i) {
        this.f = i;
        this.e.setTextSize(i);
        requestLayout();
        invalidate();
    }
}
