package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ShapeTextFontSpan.class */
public final class ShapeTextFontSpan extends ReplacementSpan {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private float i;

    public ShapeTextFontSpan(Context mContext, int i, int i2) {
        Intrinsics.e(mContext, "mContext");
        this.b = mContext.getResources().getColor(i);
        this.c = mContext.getResources().getColor(i2);
        this.d = mContext.getResources().getDimensionPixelOffset(R.dimen.dp_16);
        this.e = mContext.getResources().getDimensionPixelOffset(R.dimen.dp_4);
        this.f = mContext.getResources().getDimensionPixelOffset(R.dimen.dp_4);
        this.i = mContext.getResources().getDimensionPixelOffset(R.dimen.sp_10);
    }

    public final int a(String mess) {
        Intrinsics.e(mess, "mess");
        Paint paint = new Paint();
        paint.setTextSize(this.i);
        return ((int) paint.measureText(mess)) + this.e + this.f + 1;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(text, "text");
        Intrinsics.e(paint, "paint");
        paint.setShader(new LinearGradient(0.0f, 0.0f, this.a * 1.0f, 0.0f, this.c, this.b, Shader.TileMode.CLAMP));
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = fontMetricsInt.descent;
        int i7 = fontMetricsInt.ascent;
        int i8 = fontMetricsInt.descent;
        int i9 = (i6 - i7) / 2;
        this.h = paint.getTextSize();
        paint.setTextSize(this.i);
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        float f2 = (i4 + i8) - i9;
        int i10 = this.d;
        float f3 = i10 / 2.0f;
        float f4 = this.a;
        float f5 = i10 / 2.0f;
        int i11 = this.g;
        float f6 = i11;
        float f7 = 2;
        canvas.drawRoundRect(f, f2 - f3, f + f4, f2 + f5, f6 / f7, i11 / f7, paint);
        paint.setShader(null);
        canvas.drawText(text.toString(), i, i2, f + this.e, (f2 + ((fontMetricsInt2.bottom - fontMetricsInt2.top) / 2.0f)) - fontMetricsInt2.bottom, paint);
        paint.setTextSize(this.h);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.e(paint, "paint");
        Intrinsics.e(text, "text");
        this.a = a(text.subSequence(i, i2).toString());
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        if (fontMetricsInt != null) {
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        this.g = fontMetricsInt2.bottom - fontMetricsInt2.top;
        return this.a;
    }
}
