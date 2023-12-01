package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/widget/KSCouponLabelTextView.class */
public class KSCouponLabelTextView extends TextView implements d {
    private final RectF Ab;
    private float Ad;
    private float Ae;
    private float Af;
    private final RectF Ag;
    private final RectF Ah;
    private final Path Ai;
    private Path Aj;
    private Path Ak;
    private boolean Al;
    private final Paint mPaint;
    private int strokeColor;
    private final Rect zX;
    private final RectF zY;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.zX = new Rect();
        this.zY = new RectF();
        this.Ag = new RectF();
        this.Ah = new RectF();
        this.Ai = new Path();
        this.Ab = new RectF();
        this.Al = true;
        init(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.zX = new Rect();
        this.zY = new RectF();
        this.Ag = new RectF();
        this.Ah = new RectF();
        this.Ai = new Path();
        this.Ab = new RectF();
        this.Al = true;
        init(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.zX = new Rect();
        this.zY = new RectF();
        this.Ag = new RectF();
        this.Ah = new RectF();
        this.Ai = new Path();
        this.Ab = new RectF();
        this.Al = true;
        init(context, attributeSet, i);
    }

    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.Ad;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.Aj, Path.Op.DIFFERENCE);
        path.op(this.Ak, Path.Op.DIFFERENCE);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.left -= this.Af;
        rectF2.right = rectF2.left + (this.Af * 2.0f);
        rectF2.top += (rectF.height() - (this.Af * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.Af * 2.0f);
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.Ad);
        this.Ab.set(rectF);
        RectF rectF4 = this.Ab;
        rectF4.bottom = rectF4.top + (this.Ad * 2.0f);
        RectF rectF5 = this.Ab;
        rectF5.right = rectF5.left + (this.Ad * 2.0f);
        path.arcTo(this.Ab, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.Ad, rectF.top);
        this.Ab.set(rectF);
        RectF rectF6 = this.Ab;
        rectF6.left = rectF6.right - (this.Ad * 2.0f);
        RectF rectF7 = this.Ab;
        rectF7.bottom = rectF7.top + (this.Ad * 2.0f);
        path.arcTo(this.Ab, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.Ad);
        this.Ab.set(rectF);
        RectF rectF8 = this.Ab;
        rectF8.left = rectF8.right - (this.Ad * 2.0f);
        RectF rectF9 = this.Ab;
        rectF9.top = rectF9.bottom - (this.Ad * 2.0f);
        path.arcTo(this.Ab, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Ad, rectF.bottom);
        this.Ab.set(rectF);
        RectF rectF10 = this.Ab;
        rectF10.right = rectF10.left + (this.Ad * 2.0f);
        RectF rectF11 = this.Ab;
        rectF11.top = rectF11.bottom - (this.Ad * 2.0f);
        path.arcTo(this.Ab, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.right += this.Af;
        rectF2.left = rectF2.right - (this.Af * 2.0f);
        rectF2.top += (rectF.height() - (this.Af * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.Af * 2.0f);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Ad = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.Ae = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.Af = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        ka();
    }

    private void ka() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.Ae);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        ka();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.zX.setEmpty();
        getDrawingRect(this.zX);
        float f = this.Ae / 2.0f;
        this.zY.set(this.zX);
        this.zY.left += f;
        this.zY.top += f;
        this.zY.right -= f;
        this.zY.bottom -= f;
        a(this.zY, this.Ag);
        b(this.zY, this.Ah);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.Aj;
            if (path == null) {
                this.Aj = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.Ak;
            if (path2 == null) {
                this.Ak = new Path();
            } else {
                path2.reset();
            }
            a(this.Ai, this.Aj, this.Ak, this.zY, this.Ag, this.Ah);
        } else {
            b(this.Ai, this.zY, this.Ag, this.Ah);
        }
        canvas.drawPath(this.Ai, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Al) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }
}
