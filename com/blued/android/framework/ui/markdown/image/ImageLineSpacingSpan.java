package com.blued.android.framework.ui.markdown.image;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/image/ImageLineSpacingSpan.class */
public class ImageLineSpacingSpan implements LineHeightSpan {
    private final int a;

    public ImageLineSpacingSpan(int i) {
        this.a = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        fontMetricsInt.top -= this.a;
        fontMetricsInt.ascent -= this.a;
        fontMetricsInt.descent += this.a;
        fontMetricsInt.bottom += this.a;
    }
}
