package io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.SpanUtils;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawableSpan.class */
public class AsyncDrawableSpan extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    private final int alignment;
    private final AsyncDrawable drawable;
    private final boolean replacementTextIsLink;
    private final MarkwonTheme theme;

    public AsyncDrawableSpan(MarkwonTheme markwonTheme, AsyncDrawable asyncDrawable, int i, boolean z) {
        this.theme = markwonTheme;
        this.drawable = asyncDrawable;
        this.alignment = i;
        this.replacementTextIsLink = z;
    }

    private static float textCenterY(int i, int i2, Paint paint) {
        return (int) ((i + ((i2 - i) / 2)) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        int i7;
        this.drawable.initWithKnownDimensions(SpanUtils.width(canvas, charSequence), paint.getTextSize());
        AsyncDrawable asyncDrawable = this.drawable;
        if (!asyncDrawable.hasResult()) {
            float textCenterY = textCenterY(i3, i5, paint);
            if (this.replacementTextIsLink) {
                this.theme.applyLinkStyle(paint);
            }
            canvas.drawText(charSequence, i, i2, f, textCenterY, paint);
            return;
        }
        int i8 = i5 - asyncDrawable.getBounds().bottom;
        int save = canvas.save();
        try {
            if (2 != this.alignment) {
                i6 = i8;
                if (1 == this.alignment) {
                    i7 = paint.getFontMetricsInt().descent;
                }
                canvas.translate(f, i6);
                asyncDrawable.draw(canvas);
            }
            i7 = ((i5 - i3) - asyncDrawable.getBounds().height()) / 2;
            i6 = i8 - i7;
            canvas.translate(f, i6);
            asyncDrawable.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public AsyncDrawable getDrawable() {
        return this.drawable;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (!this.drawable.hasResult()) {
            if (this.replacementTextIsLink) {
                this.theme.applyLinkStyle(paint);
            }
            return (int) (paint.measureText(charSequence, i, i2) + 0.5f);
        }
        Rect bounds = this.drawable.getBounds();
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -bounds.bottom;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
