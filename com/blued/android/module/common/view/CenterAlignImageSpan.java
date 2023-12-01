package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CenterAlignImageSpan.class */
public class CenterAlignImageSpan extends ImageSpan {
    public CenterAlignImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    public CenterAlignImageSpan(Drawable drawable) {
        super(drawable);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.translate(f, ((i4 + fontMetricsInt.descent) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.descent;
            int i4 = fontMetricsInt2.ascent;
            int i5 = bounds.bottom;
            int i6 = bounds.top;
            int i7 = fontMetricsInt2.ascent + ((i3 - i4) / 2);
            int i8 = (i5 - i6) / 2;
            fontMetricsInt.ascent = i7 - i8;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = i7 + i8;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
        return bounds.right;
    }
}
