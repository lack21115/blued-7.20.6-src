package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/BulletListItemSpan.class */
public class BulletListItemSpan implements LeadingMarginSpan {
    private static final boolean IS_NOUGAT;
    private final int level;
    private MarkwonTheme theme;
    private final Paint paint = ObjectsPool.paint();
    private final RectF circle = ObjectsPool.rectF();
    private final Rect rectangle = ObjectsPool.rect();

    static {
        int i = Build.VERSION.SDK_INT;
        IS_NOUGAT = 24 == i || 25 == i;
    }

    public BulletListItemSpan(MarkwonTheme markwonTheme, int i) {
        this.theme = markwonTheme;
        this.level = i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int i9;
        if (z && LeadingMarginUtils.selfStart(i6, charSequence, this)) {
            this.paint.set(paint);
            this.theme.applyListItemStyle(this.paint);
            int save = canvas.save();
            try {
                int blockMargin = this.theme.getBlockMargin();
                int bulletWidth = this.theme.getBulletWidth((int) ((this.paint.descent() - this.paint.ascent()) + 0.5f));
                int i10 = (blockMargin - bulletWidth) / 2;
                if (IS_NOUGAT) {
                    int width = i2 < 0 ? i - (layout.getWidth() - (blockMargin * this.level)) : (blockMargin * this.level) - i;
                    int i11 = i + (i10 * i2);
                    int i12 = (i2 * bulletWidth) + i11;
                    int min = Math.min(i11, i12);
                    int i13 = i2 * width;
                    i8 = min + i13;
                    i9 = Math.max(i11, i12) + i13;
                } else {
                    if (i2 <= 0) {
                        i -= blockMargin;
                    }
                    i8 = i + i10;
                    i9 = i8 + bulletWidth;
                }
                int descent = (i4 + ((int) (((this.paint.descent() + this.paint.ascent()) / 2.0f) + 0.5f))) - (bulletWidth / 2);
                int i14 = bulletWidth + descent;
                if (this.level != 0 && this.level != 1) {
                    this.rectangle.set(i8, descent, i9, i14);
                    this.paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.rectangle, this.paint);
                }
                this.circle.set(i8, descent, i9, i14);
                this.paint.setStyle(this.level == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                canvas.drawOval(this.circle, this.paint);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.theme.getBlockMargin();
    }
}
