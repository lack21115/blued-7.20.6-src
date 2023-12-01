package com.sobot.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotImageView.class */
public class SobotImageView extends ImageView {
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private int mCornerRadius;
    private int mDefaultImageId;
    private boolean mIsCircle;
    private boolean mIsSquare;
    private OnDrawableChangedCallback mOnDrawableChangedCallback;
    private RectF mRect;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotImageView$OnDrawableChangedCallback.class */
    public interface OnDrawableChangedCallback {
        void onDrawableChanged(Drawable drawable);
    }

    public SobotImageView(Context context) {
        this(context, null);
    }

    public SobotImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SobotImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCornerRadius = 0;
        this.mIsCircle = false;
        this.mIsSquare = false;
        this.mBorderWidth = 0;
        this.mBorderColor = -1;
        initCustomAttrs(context, attributeSet);
        initBorderPaint();
        setDefaultImage();
        this.mRect = new RectF();
    }

    private int dip2px(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static RoundedBitmapDrawable getCircleDrawable(Context context, int i) {
        return getCircleDrawable(context, BitmapFactory.decodeResource(context.getResources(), i));
    }

    public static RoundedBitmapDrawable getCircleDrawable(Context context, Bitmap bitmap) {
        Bitmap createBitmap = bitmap.getWidth() >= bitmap.getHeight() ? Bitmap.createBitmap(bitmap, (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2), 0, bitmap.getHeight(), bitmap.getHeight()) : Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() / 2) - (bitmap.getWidth() / 2), bitmap.getWidth(), bitmap.getWidth());
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(context.getResources(), createBitmap);
        create.setAntiAlias(true);
        create.setCornerRadius(Math.min(createBitmap.getWidth(), createBitmap.getHeight()) / 2.0f);
        return create;
    }

    public static RoundedBitmapDrawable getRoundedDrawable(Context context, int i, float f) {
        return getRoundedDrawable(context, BitmapFactory.decodeResource(context.getResources(), i), f);
    }

    public static RoundedBitmapDrawable getRoundedDrawable(Context context, Bitmap bitmap, float f) {
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
        create.setAntiAlias(true);
        create.setCornerRadius(f);
        return create;
    }

    private void initBorderPaint() {
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    }

    private void initCustomAttr(int i, TypedArray typedArray) {
    }

    private void initCustomAttrs(Context context, AttributeSet attributeSet) {
        this.mDefaultImageId = 0;
    }

    private void notifyDrawableChanged(Drawable drawable) {
        OnDrawableChangedCallback onDrawableChangedCallback = this.mOnDrawableChangedCallback;
        if (onDrawableChangedCallback != null) {
            onDrawableChangedCallback.onDrawableChanged(drawable);
        }
    }

    private void setDefaultImage() {
        int i = this.mDefaultImageId;
        if (i != 0) {
            setImageResource(i);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            canvas.save();
            canvas.restore();
            if (this.mBorderWidth > 0) {
                if (this.mIsCircle) {
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.mBorderWidth / 2), this.mBorderPaint);
                    return;
                }
                this.mRect.left = 0.0f;
                this.mRect.top = 0.0f;
                this.mRect.right = getWidth();
                this.mRect.bottom = getHeight();
                canvas.drawRoundRect(this.mRect, this.mCornerRadius, this.mCornerRadius, this.mBorderPaint);
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r5.mIsSquare != false) goto L8;
     */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.mIsCircle
            if (r0 != 0) goto L13
            r0 = r6
            r9 = r0
            r0 = r7
            r8 = r0
            r0 = r5
            boolean r0 = r0.mIsSquare
            if (r0 == 0) goto L2f
        L13:
            r0 = r5
            r1 = 0
            r2 = r6
            int r1 = getDefaultSize(r1, r2)
            r2 = 0
            r3 = r7
            int r2 = getDefaultSize(r2, r3)
            r0.setMeasuredDimension(r1, r2)
            r0 = r5
            int r0 = r0.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r9 = r0
            r0 = r9
            r8 = r0
        L2f:
            r0 = r5
            r1 = r9
            r2 = r8
            super.onMeasure(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.SobotImageView.onMeasure(int, int):void");
    }

    public void setCornerRadius(int i) {
        this.mCornerRadius = dip2px(i);
        invalidate();
    }

    public void setDrawableChangedCallback(OnDrawableChangedCallback onDrawableChangedCallback) {
        this.mOnDrawableChangedCallback = onDrawableChangedCallback;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        boolean z = drawable instanceof BitmapDrawable;
        if (z && this.mCornerRadius > 0) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                super.setImageDrawable(getRoundedDrawable(getContext(), bitmap, this.mCornerRadius));
            } else {
                super.setImageDrawable(drawable);
            }
        } else if (z && this.mIsCircle) {
            Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap2 != null) {
                super.setImageDrawable(getCircleDrawable(getContext(), bitmap2));
            } else {
                super.setImageDrawable(drawable);
            }
        } else {
            super.setImageDrawable(drawable);
        }
        notifyDrawableChanged(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(getResources().getDrawable(i));
    }

    public void setIsCircle(boolean z) {
        this.mIsCircle = z;
        invalidate();
    }
}
