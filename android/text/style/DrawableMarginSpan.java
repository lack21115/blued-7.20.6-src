package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/DrawableMarginSpan.class */
public class DrawableMarginSpan implements LeadingMarginSpan, LineHeightSpan {
    private Drawable mDrawable;
    private int mPad;

    public DrawableMarginSpan(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public DrawableMarginSpan(Drawable drawable, int i) {
        this.mDrawable = drawable;
        this.mPad = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (i2 == ((Spanned) charSequence).getSpanEnd(this)) {
            int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
            int i5 = intrinsicHeight - (((fontMetricsInt.descent + i4) - fontMetricsInt.ascent) - i3);
            if (i5 > 0) {
                fontMetricsInt.descent += i5;
            }
            int i6 = intrinsicHeight - (((fontMetricsInt.bottom + i4) - fontMetricsInt.top) - i3);
            if (i6 > 0) {
                fontMetricsInt.bottom += i6;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int lineTop = layout.getLineTop(layout.getLineForOffset(((Spanned) charSequence).getSpanStart(this)));
        this.mDrawable.setBounds(i, lineTop, i + this.mDrawable.getIntrinsicWidth(), lineTop + this.mDrawable.getIntrinsicHeight());
        this.mDrawable.draw(canvas);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.mDrawable.getIntrinsicWidth() + this.mPad;
    }
}
