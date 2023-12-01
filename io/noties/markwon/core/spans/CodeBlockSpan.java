package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/CodeBlockSpan.class */
public class CodeBlockSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public CodeBlockSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    private void apply(TextPaint textPaint) {
        this.theme.applyCodeBlockTextStyle(textPaint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int width;
        int i8;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.theme.getCodeBlockBackgroundColor(paint));
        if (i2 > 0) {
            i8 = canvas.getWidth();
            width = i;
        } else {
            width = i - canvas.getWidth();
            i8 = i;
        }
        this.rect.set(width, i3, i8, i5);
        canvas.drawRect(this.rect, this.paint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.theme.getCodeBlockMargin();
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }
}
