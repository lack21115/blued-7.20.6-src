package com.soft.blued.ui.setting.View;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.anythink.expressad.foundation.h.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/View/LeftIconSpan.class */
public final class LeftIconSpan extends ImageSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeftIconSpan(Drawable drawable) {
        super(drawable);
        Intrinsics.e(drawable, i.f5112c);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(charSequence, "text");
        Intrinsics.e(paint, "paint");
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        Intrinsics.c(fontMetricsInt, "paint.getFontMetricsInt()");
        canvas.save();
        canvas.translate(f, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (getDrawable().getBounds().bottom / 2));
        getDrawable().draw(canvas);
        canvas.restore();
    }
}
