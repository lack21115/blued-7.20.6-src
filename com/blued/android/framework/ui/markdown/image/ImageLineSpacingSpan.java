package com.blued.android.framework.ui.markdown.image;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/image/ImageLineSpacingSpan.class */
public class ImageLineSpacingSpan implements LineHeightSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f9908a;

    public ImageLineSpacingSpan(int i) {
        this.f9908a = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        fontMetricsInt.top -= this.f9908a;
        fontMetricsInt.ascent -= this.f9908a;
        fontMetricsInt.descent += this.f9908a;
        fontMetricsInt.bottom += this.f9908a;
    }
}
