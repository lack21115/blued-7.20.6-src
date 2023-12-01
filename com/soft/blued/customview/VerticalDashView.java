package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/VerticalDashView.class */
public class VerticalDashView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f28533a;
    private Rect b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28534c;
    private float d;
    private float e;
    private float f;
    private int g;

    public VerticalDashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28534c = context;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        float applyDimension3 = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f28534c.obtainStyledAttributes(attributeSet, R.styleable.VerticalDashView);
            this.d = obtainStyledAttributes.getDimension(1, (int) applyDimension2);
            this.e = obtainStyledAttributes.getDimension(2, (int) applyDimension);
            this.f = obtainStyledAttributes.getDimension(3, (int) applyDimension3);
            this.g = obtainStyledAttributes.getColor(0, this.f28534c.getResources().getColor(2131101766));
            obtainStyledAttributes.recycle();
        }
        this.f28533a = new Paint();
        a();
    }

    protected void a() {
        this.f28533a.setColor(this.g);
        this.f28533a.setStyle(Paint.Style.STROKE);
        this.f28533a.setStrokeWidth(this.f);
        this.f28533a.setAntiAlias(true);
        this.f28533a.setPathEffect(new DashPathEffect(new float[]{this.d, this.e}, 0.0f));
        this.b = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f = (this.b.right - this.b.left) / 2.0f;
        canvas.drawLine(f, 0.0f, f, (this.b.bottom + 0.0f) - this.b.top, this.f28533a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.left = i;
        this.b.top = i2;
        this.b.right = i3;
        this.b.bottom = i4;
    }

    public void setDashColor(int i) {
        this.g = this.f28534c.getResources().getColor(i);
        a();
        postInvalidate();
    }

    public void setDashColor(String str) {
        this.g = Color.parseColor(str);
        a();
        postInvalidate();
    }
}
