package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/DynamicDrawableSpan.class */
public abstract class DynamicDrawableSpan extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    private static final String TAG = "DynamicDrawableSpan";
    private WeakReference<Drawable> mDrawableRef;
    protected final int mVerticalAlignment;

    public DynamicDrawableSpan() {
        this.mVerticalAlignment = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DynamicDrawableSpan(int i) {
        this.mVerticalAlignment = i;
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        Drawable drawable2 = drawable;
        if (drawable == null) {
            drawable2 = getDrawable();
            this.mDrawableRef = new WeakReference<>(drawable2);
        }
        return drawable2;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        int i6 = i5 - cachedDrawable.getBounds().bottom;
        int i7 = i6;
        if (this.mVerticalAlignment == 1) {
            i7 = i6 - paint.getFontMetricsInt().descent;
        }
        canvas.translate(f, i7);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    public abstract Drawable getDrawable();

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getCachedDrawable().getBounds();
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -bounds.bottom;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }

    public int getVerticalAlignment() {
        return this.mVerticalAlignment;
    }
}
