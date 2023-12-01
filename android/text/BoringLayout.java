package android.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.TextUtils;
import android.util.FloatMath;

/* loaded from: source-9557208-dex2jar.jar:android/text/BoringLayout.class */
public class BoringLayout extends Layout implements TextUtils.EllipsizeCallback {
    private static final char FIRST_RIGHT_TO_LEFT = 1424;
    private static final TextPaint sTemp = new TextPaint();
    int mBottom;
    private int mBottomPadding;
    int mDesc;
    private String mDirect;
    private int mEllipsizedCount;
    private int mEllipsizedStart;
    private int mEllipsizedWidth;
    private float mMax;
    private Paint mPaint;
    private int mTopPadding;

    /* loaded from: source-9557208-dex2jar.jar:android/text/BoringLayout$Metrics.class */
    public static class Metrics extends Paint.FontMetricsInt {
        public int width;

        @Override // android.graphics.Paint.FontMetricsInt
        public String toString() {
            return super.toString() + " width=" + this.width;
        }
    }

    public BoringLayout(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, Metrics metrics, boolean z) {
        super(charSequence, textPaint, i, alignment, f, f2);
        this.mEllipsizedWidth = i;
        this.mEllipsizedStart = 0;
        this.mEllipsizedCount = 0;
        init(charSequence, textPaint, i, alignment, f, f2, metrics, z, true);
    }

    public BoringLayout(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int i2) {
        super(charSequence, textPaint, i, alignment, f, f2);
        boolean z2;
        if (truncateAt == null || truncateAt == TextUtils.TruncateAt.MARQUEE) {
            this.mEllipsizedWidth = i;
            this.mEllipsizedStart = 0;
            this.mEllipsizedCount = 0;
            z2 = true;
        } else {
            replaceWith(TextUtils.ellipsize(charSequence, textPaint, i2, truncateAt, true, this), textPaint, i, alignment, f, f2);
            this.mEllipsizedWidth = i2;
            z2 = false;
        }
        init(getText(), textPaint, i, alignment, f, f2, metrics, z, z2);
    }

    public static Metrics isBoring(CharSequence charSequence, TextPaint textPaint) {
        return isBoring(charSequence, textPaint, TextDirectionHeuristics.FIRSTSTRONG_LTR, null);
    }

    public static Metrics isBoring(CharSequence charSequence, TextPaint textPaint, Metrics metrics) {
        return isBoring(charSequence, textPaint, TextDirectionHeuristics.FIRSTSTRONG_LTR, metrics);
    }

    public static Metrics isBoring(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        return isBoring(charSequence, textPaint, textDirectionHeuristic, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ea, code lost:
        if (r12 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f8, code lost:
        if (r12.isRtl(r0, 0, r0) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fb, code lost:
        r14 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.text.BoringLayout.Metrics isBoring(java.lang.CharSequence r10, android.text.TextPaint r11, android.text.TextDirectionHeuristic r12, android.text.BoringLayout.Metrics r13) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.BoringLayout.isBoring(java.lang.CharSequence, android.text.TextPaint, android.text.TextDirectionHeuristic, android.text.BoringLayout$Metrics):android.text.BoringLayout$Metrics");
    }

    public static BoringLayout make(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, Metrics metrics, boolean z) {
        return new BoringLayout(charSequence, textPaint, i, alignment, f, f2, metrics, z);
    }

    public static BoringLayout make(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int i2) {
        return new BoringLayout(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2);
    }

    @Override // android.text.Layout
    public void draw(Canvas canvas, Path path, Paint paint, int i) {
        if (this.mDirect == null || path != null) {
            super.draw(canvas, path, paint, i);
        } else {
            canvas.drawText(this.mDirect, 0.0f, this.mBottom - this.mDesc, this.mPaint);
        }
    }

    @Override // android.text.TextUtils.EllipsizeCallback
    public void ellipsized(int i, int i2) {
        this.mEllipsizedStart = i;
        this.mEllipsizedCount = i2 - i;
    }

    @Override // android.text.Layout
    public int getBottomPadding() {
        return this.mBottomPadding;
    }

    @Override // android.text.Layout
    public int getEllipsisCount(int i) {
        return this.mEllipsizedCount;
    }

    @Override // android.text.Layout
    public int getEllipsisStart(int i) {
        return this.mEllipsizedStart;
    }

    @Override // android.text.Layout
    public int getEllipsizedWidth() {
        return this.mEllipsizedWidth;
    }

    @Override // android.text.Layout
    public int getHeight() {
        return this.mBottom;
    }

    @Override // android.text.Layout
    public boolean getLineContainsTab(int i) {
        return false;
    }

    @Override // android.text.Layout
    public int getLineCount() {
        return 1;
    }

    @Override // android.text.Layout
    public int getLineDescent(int i) {
        return this.mDesc;
    }

    @Override // android.text.Layout
    public final Layout.Directions getLineDirections(int i) {
        return Layout.DIRS_ALL_LEFT_TO_RIGHT;
    }

    @Override // android.text.Layout
    public float getLineMax(int i) {
        return this.mMax;
    }

    @Override // android.text.Layout
    public int getLineStart(int i) {
        if (i == 0) {
            return 0;
        }
        return getText().length();
    }

    @Override // android.text.Layout
    public int getLineTop(int i) {
        if (i == 0) {
            return 0;
        }
        return this.mBottom;
    }

    @Override // android.text.Layout
    public int getParagraphDirection(int i) {
        return 1;
    }

    @Override // android.text.Layout
    public int getTopPadding() {
        return this.mTopPadding;
    }

    void init(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, Metrics metrics, boolean z, boolean z2) {
        if ((charSequence instanceof String) && alignment == Layout.Alignment.ALIGN_NORMAL) {
            this.mDirect = charSequence.toString();
        } else {
            this.mDirect = null;
        }
        this.mPaint = textPaint;
        int i2 = z ? metrics.bottom - metrics.top : metrics.descent - metrics.ascent;
        this.mBottom = i2;
        if (z) {
            this.mDesc = metrics.top + i2;
        } else {
            this.mDesc = metrics.ascent + i2;
        }
        if (z2) {
            this.mMax = metrics.width;
        } else {
            TextLine obtain = TextLine.obtain();
            obtain.set(textPaint, charSequence, 0, charSequence.length(), 1, Layout.DIRS_ALL_LEFT_TO_RIGHT, false, null);
            this.mMax = (int) FloatMath.ceil(obtain.metrics(null));
            TextLine.recycle(obtain);
        }
        if (z) {
            this.mTopPadding = metrics.top - metrics.ascent;
            this.mBottomPadding = metrics.bottom - metrics.descent;
        }
    }

    public BoringLayout replaceOrMake(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, Metrics metrics, boolean z) {
        replaceWith(charSequence, textPaint, i, alignment, f, f2);
        this.mEllipsizedWidth = i;
        this.mEllipsizedStart = 0;
        this.mEllipsizedCount = 0;
        init(charSequence, textPaint, i, alignment, f, f2, metrics, z, true);
        return this;
    }

    public BoringLayout replaceOrMake(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int i2) {
        boolean z2;
        if (truncateAt == null || truncateAt == TextUtils.TruncateAt.MARQUEE) {
            replaceWith(charSequence, textPaint, i, alignment, f, f2);
            this.mEllipsizedWidth = i;
            this.mEllipsizedStart = 0;
            this.mEllipsizedCount = 0;
            z2 = true;
        } else {
            replaceWith(TextUtils.ellipsize(charSequence, textPaint, i2, truncateAt, true, this), textPaint, i, alignment, f, f2);
            this.mEllipsizedWidth = i2;
            z2 = false;
        }
        init(getText(), textPaint, i, alignment, f, f2, metrics, z, z2);
        return this;
    }
}
