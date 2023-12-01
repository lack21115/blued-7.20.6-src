package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/BlockQuoteSpan.class */
public class BlockQuoteSpan implements LeadingMarginSpan {
    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public BlockQuoteSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int blockQuoteWidth = this.theme.getBlockQuoteWidth();
        this.paint.set(paint);
        this.theme.applyBlockQuoteStyle(this.paint);
        int i8 = i2 * blockQuoteWidth;
        int i9 = i + i8;
        int i10 = i8 + i9;
        this.rect.set(Math.min(i9, i10), i3, Math.max(i9, i10), i5);
        canvas.drawRect(this.rect, this.paint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.theme.getBlockMargin();
    }
}
