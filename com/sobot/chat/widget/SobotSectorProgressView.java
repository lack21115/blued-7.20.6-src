package com.sobot.chat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotSectorProgressView.class */
public class SobotSectorProgressView extends ImageView {
    private static final float maxConstant = 100.0f;
    private RectF dstRect;
    private int fgColor;
    private Paint fgPaint;
    private float mMax;
    private Paint mPaint;
    private Xfermode mXfermode;
    private RectF oval;
    private float progress;
    private float rangePercent;
    private float startAngle;

    public SobotSectorProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rangePercent = 1.0f;
        this.mMax = 100.0f;
        this.mPaint = new Paint(3);
        this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        init();
    }

    private void init() {
        this.startAngle = 270.0f;
        this.fgPaint = new Paint();
        int color = getContext().getResources().getColor(ResourceUtils.getIdByName(getContext(), "color", "sobot_sectorProgressView_fgColor"));
        this.fgColor = color;
        this.fgPaint.setColor(color);
    }

    public float getProgress() {
        return this.progress;
    }

    public float getStartAngle() {
        return this.startAngle;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(this.dstRect, this.mPaint, 31);
        this.mPaint.setXfermode(this.mXfermode);
        canvas.drawArc(this.oval, this.startAngle, (-this.progress) * 3.6f, true, this.fgPaint);
        this.mPaint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float paddingLeft = getPaddingLeft() + getPaddingRight();
        float paddingBottom = getPaddingBottom() + getPaddingTop();
        float f = i;
        float f2 = i2;
        int i5 = (int) ((f + paddingLeft) / 2.0f);
        int i6 = (int) ((f2 + paddingBottom) / 2.0f);
        this.oval = new RectF(i5 - i, i6 - i2, i5 + i, i6 + i2);
        this.dstRect = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (f - paddingLeft), getPaddingTop() + (f2 - paddingBottom));
    }

    public void setMax(int i) {
        if (i < 0) {
            return;
        }
        float f = i;
        this.rangePercent = 100.0f / f;
        this.mMax = f;
    }

    public void setProgress(float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = this.mMax;
        float f4 = f2;
        if (f2 > f3) {
            f4 = f3;
        }
        this.progress = (this.mMax - f4) * this.rangePercent;
        postInvalidate();
    }

    public void setStartAngle(float f) {
        this.startAngle = f + 270.0f;
        postInvalidate();
    }
}
