package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LineHeightSpan;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/LastLineSpacingSpan.class */
public class LastLineSpacingSpan implements LineHeightSpan {
    private final int spacing;

    public LastLineSpacingSpan(int i) {
        this.spacing = i;
    }

    public static LastLineSpacingSpan create(int i) {
        return new LastLineSpacingSpan(i);
    }

    private static boolean selfEnd(int i, CharSequence charSequence, Object obj) {
        int spanEnd = ((Spanned) charSequence).getSpanEnd(obj);
        boolean z = true;
        if (spanEnd != i) {
            if (spanEnd == i - 1) {
                return true;
            }
            z = false;
        }
        return z;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (selfEnd(i2, charSequence, this)) {
            fontMetricsInt.descent += this.spacing;
            fontMetricsInt.bottom += this.spacing;
        }
    }
}
