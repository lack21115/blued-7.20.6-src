package com.blued.android.module.live_china.utils.dslspannable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/dslspannable/MiddleIMarginImageSpan.class */
public class MiddleIMarginImageSpan extends VerticalCenterImageSpan {
    private int a;
    private int b;
    private int c;

    public MiddleIMarginImageSpan(Drawable drawable, int i, int i2, int i3, int i4, VerticalCenterImageSpan.SpanDrawCallback spanDrawCallback) {
        super(drawable, i, spanDrawCallback);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    public MiddleIMarginImageSpan(Drawable drawable, int i, int i2, VerticalCenterImageSpan.SpanDrawCallback spanDrawCallback) {
        this(drawable, 2, i, i2, 0, spanDrawCallback);
    }

    @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.c);
        super.draw(canvas, charSequence, i, i2, f + this.a, i3, i4, i5, paint);
        canvas.restore();
    }

    @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt) + this.a + this.b;
    }
}
