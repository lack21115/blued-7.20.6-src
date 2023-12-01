package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/widget/JinniuCouponLayout.class */
public class JinniuCouponLayout extends LinearLayout {
    private RectF Aa;
    private RectF Ab;
    private Path Ac;
    private int endColor;
    private Paint mPaint;
    private float mRadius;
    private int startColor;
    private float zW;
    private Rect zX;
    private RectF zY;
    private RectF zZ;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.zW = 4.0f;
        this.mRadius = 10.0f;
        this.zX = new Rect();
        this.zY = new RectF();
        this.zZ = new RectF();
        this.Aa = new RectF();
        this.Ab = new RectF();
        this.Ac = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, null, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.zW = 4.0f;
        this.mRadius = 10.0f;
        this.zX = new Rect();
        this.zY = new RectF();
        this.zZ = new RectF();
        this.Aa = new RectF();
        this.Ab = new RectF();
        this.Ac = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.zW = 4.0f;
        this.mRadius = 10.0f;
        this.zX = new Rect();
        this.zY = new RectF();
        this.zZ = new RectF();
        this.Aa = new RectF();
        this.Ab = new RectF();
        this.Ac = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, attributeSet, i);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.zW = 4.0f;
        this.mRadius = 10.0f;
        this.zX = new Rect();
        this.zY = new RectF();
        this.zZ = new RectF();
        this.Aa = new RectF();
        this.Ab = new RectF();
        this.Ac = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, attributeSet, i);
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(this.zY.left, this.zY.top + this.mRadius);
        this.Ab.set(rectF);
        RectF rectF4 = this.Ab;
        rectF4.bottom = rectF4.top + (this.mRadius * 2.0f);
        RectF rectF5 = this.Ab;
        rectF5.right = rectF5.left + (this.mRadius * 2.0f);
        path.arcTo(this.Ab, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.Ab.set(rectF);
        RectF rectF6 = this.Ab;
        rectF6.left = rectF6.right - (this.mRadius * 2.0f);
        RectF rectF7 = this.Ab;
        rectF7.bottom = rectF7.top + (this.mRadius * 2.0f);
        path.arcTo(this.Ab, 270.0f, 90.0f);
        this.Ab.set(rectF);
        RectF rectF8 = this.Ab;
        rectF8.left = rectF8.right - (this.mRadius * 2.0f);
        RectF rectF9 = this.Ab;
        rectF9.top = rectF9.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.Ab, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.Ab.set(rectF);
        RectF rectF10 = this.Ab;
        rectF10.right = rectF10.left + (this.mRadius * 2.0f);
        RectF rectF11 = this.Ab;
        rectF11.top = rectF11.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.Ab, 90.0f, 90.0f);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i, 0);
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.zW = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        obtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.zX.setEmpty();
        getDrawingRect(this.zX);
        this.zY.set(this.zX);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.zZ;
            if (rectF == null) {
                this.zZ = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.Aa;
            if (rectF2 == null) {
                this.Aa = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = this.zX.left + childAt.getMeasuredWidth();
            RectF rectF3 = this.zZ;
            float f = this.zX.top;
            float f2 = this.zW;
            rectF3.set(measuredWidth, f - f2, (f2 * 2.0f) + measuredWidth, this.zX.top + this.zW);
            this.Aa.set(this.zZ.left, this.zX.bottom - this.zW, this.zZ.right, this.zX.bottom + this.zW);
            a(this.Ac, this.zY, this.zZ, this.Aa);
            setGradientPaint(this.zY);
            canvas.drawPath(this.Ac, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }
}
