package com.blued.android.module.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CustomVerticalCenterSpan.class */
public final class CustomVerticalCenterSpan extends ReplacementSpan {
    private int a;

    public CustomVerticalCenterSpan(int i) {
        this.a = i;
    }

    private final TextPaint a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize(DensityUtils.d(AppInfo.d(), this.a));
        return textPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(text, "text");
        Intrinsics.e(paint, "paint");
        CharSequence subSequence = text.subSequence(i, i2);
        TextPaint a = a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), a);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.e(paint, "paint");
        Intrinsics.e(text, "text");
        return (int) a(paint).measureText(text.subSequence(i, i2).toString());
    }
}
