package com.weimob.library.groups.imageloader.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/drawable/ImageLoaderRoundedBitmapDrawable.class */
public class ImageLoaderRoundedBitmapDrawable extends Drawable {
    private final Drawable mDelegate;
    private final RectF mRootBounds = new RectF();
    private float topLeftRadius = 20.0f;
    private float topRightRadius = 20.0f;
    private float bottomLeftRadius = 20.0f;
    private float bottomRightRadius = 20.0f;
    private Paint roundPaint = new Paint();
    private Paint imagePaint = new Paint();

    public ImageLoaderRoundedBitmapDrawable(Drawable drawable) {
        this.mDelegate = drawable;
        this.roundPaint.setColor(-1);
        this.roundPaint.setAntiAlias(true);
        this.roundPaint.setStyle(Paint.Style.FILL);
        this.roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.imagePaint.setXfermode(null);
    }

    private void drawBottomLeft(Canvas canvas) {
        if (this.bottomLeftRadius > 0.0f) {
            int intrinsicHeight = getIntrinsicHeight();
            Path path = new Path();
            float f = intrinsicHeight;
            path.moveTo(0.0f, f - this.bottomLeftRadius);
            path.lineTo(0.0f, f);
            path.lineTo(this.bottomLeftRadius, f);
            float f2 = this.bottomLeftRadius;
            path.arcTo(new RectF(0.0f, f - (f2 * 2.0f), f2 * 2.0f, f), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void drawBottomRight(Canvas canvas) {
        if (this.bottomRightRadius > 0.0f) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Path path = new Path();
            float f = intrinsicHeight;
            float f2 = intrinsicWidth;
            path.moveTo(f - this.bottomRightRadius, f2);
            path.lineTo(f, f2);
            path.lineTo(f, f2 - this.bottomRightRadius);
            float f3 = this.bottomRightRadius;
            path.arcTo(new RectF(f - (f3 * 2.0f), f2 - (f3 * 2.0f), f, f2), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void drawTopLeft(Canvas canvas) {
        if (this.topLeftRadius > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.topLeftRadius);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.topLeftRadius, 0.0f);
            float f = this.topLeftRadius;
            path.arcTo(new RectF(0.0f, 0.0f, f * 2.0f, f * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void drawTopRight(Canvas canvas) {
        if (this.topRightRadius > 0.0f) {
            int intrinsicWidth = getIntrinsicWidth();
            Path path = new Path();
            float f = intrinsicWidth;
            path.moveTo(f - this.topRightRadius, 0.0f);
            path.lineTo(f, 0.0f);
            path.lineTo(f, this.topRightRadius);
            float f2 = this.topRightRadius;
            path.arcTo(new RectF(f - (f2 * 2.0f), 0.0f, f, f2 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mDelegate.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.imagePaint, 31);
        this.mDelegate.draw(canvas);
        drawTopLeft(canvas);
        drawTopRight(canvas);
        drawBottomRight(canvas);
        drawBottomLeft(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mDelegate.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mDelegate.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDelegate.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDelegate.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDelegate.getOpacity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.mDelegate.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mDelegate.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.mDelegate.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDelegate.setColorFilter(colorFilter);
    }
}
