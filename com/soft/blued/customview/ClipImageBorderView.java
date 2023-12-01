package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ClipImageBorderView.class */
public class ClipImageBorderView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f14698a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14699c;
    private int d;
    private int e;
    private Paint f;

    public ClipImageBorderView(Context context) {
        this(context, null);
    }

    public ClipImageBorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipImageBorderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = Color.parseColor("#FFFFFF");
        this.e = 1;
        this.e = (int) TypedValue.applyDimension(1, 1, getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f14699c = getWidth() - (this.f14698a * 2);
        if (this.b == 0) {
            this.b = (getHeight() - this.f14699c) / 2;
        }
        this.f.setColor(Color.parseColor("#aa000000"));
        this.f.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, this.f14698a, getHeight(), this.f);
        canvas.drawRect(getWidth() - this.f14698a, 0.0f, getWidth(), getHeight(), this.f);
        canvas.drawRect(this.f14698a, 0.0f, getWidth() - this.f14698a, this.b, this.f);
        canvas.drawRect(this.f14698a, getHeight() - this.b, getWidth() - this.f14698a, getHeight(), this.f);
        this.f.setColor(this.d);
        this.f.setStrokeWidth(this.e);
        this.f.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.f14698a, this.b, getWidth() - this.f14698a, getHeight() - this.b, this.f);
    }

    public void setHorizontalPadding(int i) {
        this.f14698a = i;
    }

    public void setVerticalPadding(int i) {
        this.b = i;
    }
}
