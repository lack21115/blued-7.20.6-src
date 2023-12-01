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
    private int f28388a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28389c;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f28389c = getWidth() - (this.f28388a * 2);
        if (this.b == 0) {
            this.b = (getHeight() - this.f28389c) / 2;
        }
        this.f.setColor(Color.parseColor("#aa000000"));
        this.f.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, this.f28388a, getHeight(), this.f);
        canvas.drawRect(getWidth() - this.f28388a, 0.0f, getWidth(), getHeight(), this.f);
        canvas.drawRect(this.f28388a, 0.0f, getWidth() - this.f28388a, this.b, this.f);
        canvas.drawRect(this.f28388a, getHeight() - this.b, getWidth() - this.f28388a, getHeight(), this.f);
        this.f.setColor(this.d);
        this.f.setStrokeWidth(this.e);
        this.f.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.f28388a, this.b, getWidth() - this.f28388a, getHeight() - this.b, this.f);
    }

    public void setHorizontalPadding(int i) {
        this.f28388a = i;
    }

    public void setVerticalPadding(int i) {
        this.b = i;
    }
}
