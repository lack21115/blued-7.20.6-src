package android.text.style;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/IconMarginSpan.class */
public class IconMarginSpan implements LeadingMarginSpan, LineHeightSpan {
    private Bitmap mBitmap;
    private int mPad;

    public IconMarginSpan(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public IconMarginSpan(Bitmap bitmap, int i) {
        this.mBitmap = bitmap;
        this.mPad = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (i2 == ((Spanned) charSequence).getSpanEnd(this)) {
            int height = this.mBitmap.getHeight();
            int i5 = height - (((fontMetricsInt.descent + i4) - fontMetricsInt.ascent) - i3);
            if (i5 > 0) {
                fontMetricsInt.descent += i5;
            }
            int i6 = height - (((fontMetricsInt.bottom + i4) - fontMetricsInt.top) - i3);
            if (i6 > 0) {
                fontMetricsInt.bottom += i6;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int lineTop = layout.getLineTop(layout.getLineForOffset(((Spanned) charSequence).getSpanStart(this)));
        int i8 = i;
        if (i2 < 0) {
            i8 = i - this.mBitmap.getWidth();
        }
        canvas.drawBitmap(this.mBitmap, i8, lineTop, paint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.mBitmap.getWidth() + this.mPad;
    }
}
