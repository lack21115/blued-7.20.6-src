package com.blued.android.module.live_china.liveForMsg.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/ui/VerticalCenterImageSpan.class */
public class VerticalCenterImageSpan extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    private SpanDrawCallback f13564a;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/ui/VerticalCenterImageSpan$SpanDrawCallback.class */
    public interface SpanDrawCallback {
        void drawFinish(int i, int i2);
    }

    public VerticalCenterImageSpan(Drawable drawable, int i) {
        super(drawable, i);
    }

    public VerticalCenterImageSpan(Drawable drawable, int i, SpanDrawCallback spanDrawCallback) {
        super(drawable, i);
        this.f13564a = spanDrawCallback;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        try {
            Drawable drawable = getDrawable();
            canvas.save();
            int i6 = (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3;
            canvas.translate(f, i6);
            drawable.draw(canvas);
            canvas.restore();
            if (this.f13564a != null) {
                this.f13564a.drawFinish((int) f, i6);
                this.f13564a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom;
            int i4 = fontMetricsInt2.top;
            int i5 = (bounds.bottom - bounds.top) / 2;
            int i6 = (i3 - i4) / 4;
            int i7 = i5 - i6;
            int i8 = -(i5 + i6);
            fontMetricsInt.ascent = i8;
            fontMetricsInt.top = i8;
            fontMetricsInt.bottom = i7;
            fontMetricsInt.descent = i7;
        }
        return bounds.right;
    }
}
