package com.blued.android.module.yy_china.view;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/GradientFontSpan.class */
public final class GradientFontSpan extends ReplacementSpan {

    /* renamed from: a  reason: collision with root package name */
    private int f17941a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f17942c;

    public GradientFontSpan(int i, int i2) {
        this.b = i;
        this.f17942c = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.f17942c;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(text, "text");
        Intrinsics.e(paint, "paint");
        paint.setShader(new LinearGradient(f, 0.0f, f + (this.f17941a * 1.0f), 0.0f, this.b, this.f17942c, Shader.TileMode.CLAMP));
        canvas.drawText(text.toString(), i, i2, f, i4, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.e(paint, "paint");
        this.f17941a = Math.round(paint.measureText(charSequence, i, i2));
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        if (fontMetricsInt != null) {
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return this.f17941a;
    }
}
