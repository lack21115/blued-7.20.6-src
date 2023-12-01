package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/BlankView.class */
public class BlankView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f10031a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f10032c;
    private Paint d;
    private RectF e;

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Paint();
        this.e = null;
        this.f10031a = 0;
        this.b = -1;
        this.f10032c = Color.parseColor("#DDDDDD");
        a();
    }

    public BlankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Paint();
        this.e = null;
        this.f10031a = 0;
        this.b = -1;
        this.f10032c = Color.parseColor("#DDDDDD");
        a();
    }

    private void a() {
        this.d.setAntiAlias(true);
        this.d.setStrokeWidth(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.d.setColor(this.b);
        RectF rectF = this.e;
        int i = this.f10031a;
        canvas.drawRoundRect(rectF, i, i, this.d);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(this.f10032c);
        RectF rectF2 = this.e;
        int i2 = this.f10031a;
        canvas.drawRoundRect(rectF2, i2, i2, this.d);
        this.d.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
