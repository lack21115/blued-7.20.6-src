package android.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RemoteViews;
import com.android.internal.R;
import java.io.IOException;
import java.io.InputStream;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/ImageView.class */
public class ImageView extends View {
    private boolean mAdjustViewBounds;
    private boolean mAdjustViewBoundsCompat;
    private int mAlpha;
    private int mBaseline;
    private boolean mBaselineAlignBottom;
    private ColorFilter mColorFilter;
    private boolean mColorMod;
    private boolean mCropToPadding;
    private Matrix mDrawMatrix;
    private Drawable mDrawable;
    private int mDrawableHeight;
    private ColorStateList mDrawableTintList;
    private PorterDuff.Mode mDrawableTintMode;
    private int mDrawableWidth;
    private boolean mHasColorFilter;
    private boolean mHasDrawableTint;
    private boolean mHasDrawableTintMode;
    private boolean mHaveFrame;
    private int mLevel;
    private Matrix mMatrix;
    private int mMaxHeight;
    private int mMaxWidth;
    private boolean mMergeState;
    private int mResource;
    private ScaleType mScaleType;
    private int[] mState;
    private RectF mTempDst;
    private RectF mTempSrc;
    private Uri mUri;
    private int mViewAlphaScale;
    private Xfermode mXfermode;
    private static final ScaleType[] sScaleTypeArray = {ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
    private static final Matrix.ScaleToFit[] sS2FArray = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ImageView$ScaleType.class */
    public enum ScaleType {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int nativeInt;

        ScaleType(int i) {
            this.nativeInt = i;
        }
    }

    public ImageView(Context context) {
        super(context);
        this.mResource = 0;
        this.mHaveFrame = false;
        this.mAdjustViewBounds = false;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mColorFilter = null;
        this.mHasColorFilter = false;
        this.mAlpha = 255;
        this.mViewAlphaScale = 256;
        this.mColorMod = false;
        this.mDrawable = null;
        this.mDrawableTintList = null;
        this.mDrawableTintMode = null;
        this.mHasDrawableTint = false;
        this.mHasDrawableTintMode = false;
        this.mState = null;
        this.mMergeState = false;
        this.mLevel = 0;
        this.mDrawMatrix = null;
        this.mTempSrc = new RectF();
        this.mTempDst = new RectF();
        this.mBaseline = -1;
        this.mBaselineAlignBottom = false;
        this.mAdjustViewBoundsCompat = false;
        initImageView();
    }

    public ImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mResource = 0;
        this.mHaveFrame = false;
        this.mAdjustViewBounds = false;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mColorFilter = null;
        this.mHasColorFilter = false;
        this.mAlpha = 255;
        this.mViewAlphaScale = 256;
        this.mColorMod = false;
        this.mDrawable = null;
        this.mDrawableTintList = null;
        this.mDrawableTintMode = null;
        this.mHasDrawableTint = false;
        this.mHasDrawableTintMode = false;
        this.mState = null;
        this.mMergeState = false;
        this.mLevel = 0;
        this.mDrawMatrix = null;
        this.mTempSrc = new RectF();
        this.mTempDst = new RectF();
        this.mBaseline = -1;
        this.mBaselineAlignBottom = false;
        this.mAdjustViewBoundsCompat = false;
        initImageView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageView, i, i2);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setImageDrawable(drawable);
        }
        this.mBaselineAlignBottom = obtainStyledAttributes.getBoolean(6, false);
        this.mBaseline = obtainStyledAttributes.getDimensionPixelSize(8, -1);
        setAdjustViewBounds(obtainStyledAttributes.getBoolean(2, false));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(3, Integer.MAX_VALUE));
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(4, Integer.MAX_VALUE));
        int i3 = obtainStyledAttributes.getInt(1, -1);
        if (i3 >= 0) {
            setScaleType(sScaleTypeArray[i3]);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.mDrawableTintList = obtainStyledAttributes.getColorStateList(5);
            this.mHasDrawableTint = true;
            this.mDrawableTintMode = PorterDuff.Mode.SRC_ATOP;
            this.mHasDrawableTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.mDrawableTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(9, -1), this.mDrawableTintMode);
            this.mHasDrawableTintMode = true;
        }
        applyImageTint();
        int i4 = obtainStyledAttributes.getInt(10, 255);
        if (i4 != 255) {
            setAlpha(i4);
        }
        this.mCropToPadding = obtainStyledAttributes.getBoolean(7, false);
        obtainStyledAttributes.recycle();
    }

    private void applyColorMod() {
        if (this.mDrawable == null || !this.mColorMod) {
            return;
        }
        this.mDrawable = this.mDrawable.mutate();
        if (this.mHasColorFilter) {
            this.mDrawable.setColorFilter(this.mColorFilter);
        }
        this.mDrawable.setXfermode(this.mXfermode);
        this.mDrawable.setAlpha((this.mAlpha * this.mViewAlphaScale) >> 8);
    }

    private void applyImageTint() {
        if (this.mDrawable != null) {
            if (this.mHasDrawableTint || this.mHasDrawableTintMode) {
                this.mDrawable = this.mDrawable.mutate();
                if (this.mHasDrawableTint) {
                    this.mDrawable.setTintList(this.mDrawableTintList);
                }
                if (this.mHasDrawableTintMode) {
                    this.mDrawable.setTintMode(this.mDrawableTintMode);
                }
                if (this.mDrawable.isStateful()) {
                    this.mDrawable.setState(getDrawableState());
                }
            }
        }
    }

    private void configureBounds() {
        float f;
        if (this.mDrawable == null || !this.mHaveFrame) {
            return;
        }
        int i = this.mDrawableWidth;
        int i2 = this.mDrawableHeight;
        int width = (getWidth() - this.mPaddingLeft) - this.mPaddingRight;
        int height = (getHeight() - this.mPaddingTop) - this.mPaddingBottom;
        boolean z = (i < 0 || width == i) && (i2 < 0 || height == i2);
        if (i <= 0 || i2 <= 0 || ScaleType.FIT_XY == this.mScaleType) {
            this.mDrawable.setBounds(0, 0, width, height);
            this.mDrawMatrix = null;
            return;
        }
        this.mDrawable.setBounds(0, 0, i, i2);
        if (ScaleType.MATRIX == this.mScaleType) {
            if (this.mMatrix.isIdentity()) {
                this.mDrawMatrix = null;
            } else {
                this.mDrawMatrix = this.mMatrix;
            }
        } else if (z) {
            this.mDrawMatrix = null;
        } else if (ScaleType.CENTER == this.mScaleType) {
            this.mDrawMatrix = this.mMatrix;
            this.mDrawMatrix.setTranslate((int) (((width - i) * 0.5f) + 0.5f), (int) (((height - i2) * 0.5f) + 0.5f));
        } else if (ScaleType.CENTER_CROP == this.mScaleType) {
            this.mDrawMatrix = this.mMatrix;
            float f2 = 0.0f;
            float f3 = 0.0f;
            if (i * height > width * i2) {
                f = height / i2;
                f2 = (width - (i * f)) * 0.5f;
            } else {
                f = width / i;
                f3 = (height - (i2 * f)) * 0.5f;
            }
            this.mDrawMatrix.setScale(f, f);
            this.mDrawMatrix.postTranslate((int) (f2 + 0.5f), (int) (f3 + 0.5f));
        } else if (ScaleType.CENTER_INSIDE == this.mScaleType) {
            this.mDrawMatrix = this.mMatrix;
            float min = (i > width || i2 > height) ? Math.min(width / i, height / i2) : 1.0f;
            this.mDrawMatrix.setScale(min, min);
            this.mDrawMatrix.postTranslate((int) (((width - (i * min)) * 0.5f) + 0.5f), (int) (((height - (i2 * min)) * 0.5f) + 0.5f));
        } else {
            this.mTempSrc.set(0.0f, 0.0f, i, i2);
            this.mTempDst.set(0.0f, 0.0f, width, height);
            this.mDrawMatrix = this.mMatrix;
            this.mDrawMatrix.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(this.mScaleType));
        }
    }

    private void initImageView() {
        this.mMatrix = new Matrix();
        this.mScaleType = ScaleType.FIT_CENTER;
        this.mAdjustViewBoundsCompat = this.mContext.getApplicationInfo().targetSdkVersion <= 17;
    }

    private boolean isFilledByImage() {
        boolean z = true;
        if (this.mDrawable == null) {
            return false;
        }
        Rect bounds = this.mDrawable.getBounds();
        Matrix matrix = this.mDrawMatrix;
        if (matrix == null) {
            if (bounds.left > 0 || bounds.top > 0 || bounds.right < getWidth() || bounds.bottom < getHeight()) {
                z = false;
            }
            return z;
        } else if (matrix.rectStaysRect()) {
            RectF rectF = this.mTempSrc;
            RectF rectF2 = this.mTempDst;
            rectF.set(bounds);
            matrix.mapRect(rectF2, rectF);
            return rectF2.left <= 0.0f && rectF2.top <= 0.0f && rectF2.right >= ((float) getWidth()) && rectF2.bottom >= ((float) getHeight());
        } else {
            return false;
        }
    }

    private void resizeFromDrawable() {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int i = intrinsicWidth;
            if (intrinsicWidth < 0) {
                i = this.mDrawableWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = intrinsicHeight;
            if (intrinsicHeight < 0) {
                i2 = this.mDrawableHeight;
            }
            if (i == this.mDrawableWidth && i2 == this.mDrawableHeight) {
                return;
            }
            this.mDrawableWidth = i;
            this.mDrawableHeight = i2;
            requestLayout();
        }
    }

    private int resolveAdjustedSize(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, size), i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private void resolveUri() {
        Drawable drawable;
        if (this.mDrawable == null && getResources() != null) {
            Drawable drawable2 = null;
            if (this.mResource != 0) {
                try {
                    drawable2 = this.mContext.getDrawable(this.mResource);
                } catch (Exception e) {
                    Log.w("ImageView", "Unable to find resource: " + this.mResource, e);
                    this.mUri = null;
                }
            } else if (this.mUri == null) {
                return;
            } else {
                String scheme = this.mUri.getScheme();
                if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme)) {
                    try {
                        ContentResolver.OpenResourceIdResult resourceId = this.mContext.getContentResolver().getResourceId(this.mUri);
                        drawable = resourceId.r.getDrawable(resourceId.id, this.mContext.getTheme());
                    } catch (Exception e2) {
                        Log.w("ImageView", "Unable to open content: " + this.mUri, e2);
                        drawable = null;
                    }
                } else if ("content".equals(scheme) || ContentResolver.SCHEME_FILE.equals(scheme)) {
                    InputStream inputStream = null;
                    InputStream inputStream2 = null;
                    try {
                        try {
                            InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.mUri);
                            inputStream2 = openInputStream;
                            inputStream = openInputStream;
                            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                            drawable = createFromStream;
                            if (openInputStream != null) {
                                try {
                                    openInputStream.close();
                                    drawable = createFromStream;
                                } catch (IOException e3) {
                                    Log.w("ImageView", "Unable to close content: " + this.mUri, e3);
                                    drawable = createFromStream;
                                }
                            }
                        } catch (Exception e4) {
                            inputStream = inputStream2;
                            Log.w("ImageView", "Unable to open content: " + this.mUri, e4);
                            drawable = null;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                    drawable = null;
                                } catch (IOException e5) {
                                    Log.w("ImageView", "Unable to close content: " + this.mUri, e5);
                                    drawable = null;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                Log.w("ImageView", "Unable to close content: " + this.mUri, e6);
                            }
                        }
                        throw th;
                    }
                } else {
                    drawable = Drawable.createFromPath(this.mUri.toString());
                }
                drawable2 = drawable;
                if (drawable == null) {
                    System.out.println("resolveUri failed on bad bitmap uri: " + this.mUri);
                    this.mUri = null;
                    drawable2 = drawable;
                }
            }
            updateDrawable(drawable2);
        }
    }

    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType scaleType) {
        return sS2FArray[scaleType.nativeInt - 1];
    }

    private void updateDrawable(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable == null) {
            this.mDrawableHeight = -1;
            this.mDrawableWidth = -1;
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        if (drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        drawable.setVisible(getVisibility() == 0, true);
        drawable.setLevel(this.mLevel);
        this.mDrawableWidth = drawable.getIntrinsicWidth();
        this.mDrawableHeight = drawable.getIntrinsicHeight();
        applyImageTint();
        applyColorMod();
        configureBounds();
    }

    public void animateTransform(Matrix matrix) {
        if (this.mDrawable == null) {
            return;
        }
        if (matrix == null) {
            this.mDrawable.setBounds(0, 0, getWidth(), getHeight());
        } else {
            this.mDrawable.setBounds(0, 0, this.mDrawableWidth, this.mDrawableHeight);
            if (this.mDrawMatrix == null) {
                this.mDrawMatrix = new Matrix();
            }
            this.mDrawMatrix.set(matrix);
        }
        invalidate();
    }

    public final void clearColorFilter() {
        setColorFilter((ColorFilter) null);
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.mDrawable != null) {
            this.mDrawable.setHotspot(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public boolean getAdjustViewBounds() {
        return this.mAdjustViewBounds;
    }

    @Override // android.view.View
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        return this.mBaselineAlignBottom ? getMeasuredHeight() : this.mBaseline;
    }

    public boolean getBaselineAlignBottom() {
        return this.mBaselineAlignBottom;
    }

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    public boolean getCropToPadding() {
        return this.mCropToPadding;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public int getImageAlpha() {
        return this.mAlpha;
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix == null ? new Matrix(Matrix.IDENTITY_MATRIX) : this.mDrawMatrix;
    }

    public ColorStateList getImageTintList() {
        return this.mDrawableTintList;
    }

    public PorterDuff.Mode getImageTintMode() {
        return this.mDrawableTintMode;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return (getBackground() == null || getBackground().getCurrent() == null) ? false : true;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    public boolean isOpaque() {
        if (super.isOpaque()) {
            return true;
        }
        return this.mDrawable != null && this.mXfermode == null && this.mDrawable.getOpacity() == -1 && ((this.mAlpha * this.mViewAlphaScale) >> 8) == 255 && isFilledByImage();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mDrawable != null) {
            this.mDrawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDrawable != null) {
            this.mDrawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public int[] onCreateDrawableState(int i) {
        return this.mState == null ? super.onCreateDrawableState(i) : !this.mMergeState ? this.mState : mergeDrawableStates(super.onCreateDrawableState(this.mState.length + i), this.mState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mDrawable != null) {
            this.mDrawable.setVisible(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawable == null || this.mDrawableWidth == 0 || this.mDrawableHeight == 0) {
            return;
        }
        if (this.mDrawMatrix == null && this.mPaddingTop == 0 && this.mPaddingLeft == 0) {
            this.mDrawable.draw(canvas);
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (this.mCropToPadding) {
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            canvas.clipRect(this.mPaddingLeft + i, this.mPaddingTop + i2, ((this.mRight + i) - this.mLeft) - this.mPaddingRight, ((this.mBottom + i2) - this.mTop) - this.mPaddingBottom);
        }
        canvas.translate(this.mPaddingLeft, this.mPaddingTop);
        if (this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
        this.mDrawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ImageView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ImageView.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        resolveUri();
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mDrawable == null) {
            this.mDrawableWidth = -1;
            this.mDrawableHeight = -1;
            i3 = 0;
            i4 = 0;
        } else {
            int i7 = this.mDrawableWidth;
            int i8 = this.mDrawableHeight;
            int i9 = i7;
            if (i7 <= 0) {
                i9 = 1;
            }
            int i10 = i8;
            if (i8 <= 0) {
                i10 = 1;
            }
            i3 = i10;
            i4 = i9;
            if (this.mAdjustViewBounds) {
                boolean z3 = mode != 1073741824;
                f = i9 / i10;
                i3 = i10;
                z2 = mode2 != 1073741824;
                z = z3;
                i4 = i9;
            }
        }
        int i11 = this.mPaddingLeft;
        int i12 = this.mPaddingRight;
        int i13 = this.mPaddingTop;
        int i14 = this.mPaddingBottom;
        if (z || z2) {
            int resolveAdjustedSize = resolveAdjustedSize(i4 + i11 + i12, this.mMaxWidth, i);
            int resolveAdjustedSize2 = resolveAdjustedSize(i3 + i13 + i14, this.mMaxHeight, i2);
            i5 = resolveAdjustedSize2;
            i6 = resolveAdjustedSize;
            if (f != 0.0f) {
                i5 = resolveAdjustedSize2;
                i6 = resolveAdjustedSize;
                if (Math.abs((((resolveAdjustedSize - i11) - i12) / ((resolveAdjustedSize2 - i13) - i14)) - f) > 1.0E-7d) {
                    boolean z4 = false;
                    int i15 = resolveAdjustedSize;
                    if (z) {
                        int i16 = ((int) (((resolveAdjustedSize2 - i13) - i14) * f)) + i11 + i12;
                        int i17 = resolveAdjustedSize;
                        if (!z2) {
                            i17 = resolveAdjustedSize;
                            if (!this.mAdjustViewBoundsCompat) {
                                i17 = resolveAdjustedSize(i16, this.mMaxWidth, i);
                            }
                        }
                        z4 = false;
                        i15 = i17;
                        if (i16 <= i17) {
                            i15 = i16;
                            z4 = true;
                        }
                    }
                    i5 = resolveAdjustedSize2;
                    i6 = i15;
                    if (!z4) {
                        i5 = resolveAdjustedSize2;
                        i6 = i15;
                        if (z2) {
                            int i18 = ((int) (((i15 - i11) - i12) / f)) + i13 + i14;
                            int i19 = resolveAdjustedSize2;
                            if (!z) {
                                i19 = resolveAdjustedSize2;
                                if (!this.mAdjustViewBoundsCompat) {
                                    i19 = resolveAdjustedSize(i18, this.mMaxHeight, i2);
                                }
                            }
                            i5 = i19;
                            i6 = i15;
                            if (i18 <= i19) {
                                i5 = i18;
                                i6 = i15;
                            }
                        }
                    }
                }
            }
        } else {
            int max = Math.max(i4 + i11 + i12, getSuggestedMinimumWidth());
            int max2 = Math.max(i3 + i13 + i14, getSuggestedMinimumHeight());
            i6 = resolveSizeAndState(max, i, 0);
            i5 = resolveSizeAndState(max2, i2, 0);
        }
        setMeasuredDimension(i6, i5);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence contentDescription = getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            return;
        }
        accessibilityEvent.getText().add(contentDescription);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.mDrawable != null) {
            this.mDrawable.setLayoutDirection(i);
        }
    }

    @RemotableViewMethod
    public void setAdjustViewBounds(boolean z) {
        this.mAdjustViewBounds = z;
        if (z) {
            setScaleType(ScaleType.FIT_CENTER);
        }
    }

    @RemotableViewMethod
    @Deprecated
    public void setAlpha(int i) {
        int i2 = i & 255;
        if (this.mAlpha != i2) {
            this.mAlpha = i2;
            this.mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    public void setBaseline(int i) {
        if (this.mBaseline != i) {
            this.mBaseline = i;
            requestLayout();
        }
    }

    public void setBaselineAlignBottom(boolean z) {
        if (this.mBaselineAlignBottom != z) {
            this.mBaselineAlignBottom = z;
            requestLayout();
        }
    }

    @RemotableViewMethod
    public final void setColorFilter(int i) {
        setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    public final void setColorFilter(int i, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(i, mode));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mColorFilter != colorFilter) {
            this.mColorFilter = colorFilter;
            this.mHasColorFilter = true;
            this.mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    public void setCropToPadding(boolean z) {
        if (this.mCropToPadding != z) {
            this.mCropToPadding = z;
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.mHaveFrame = true;
        configureBounds();
        return frame;
    }

    @RemotableViewMethod
    public void setImageAlpha(int i) {
        setAlpha(i);
    }

    @RemotableViewMethod
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            this.mResource = 0;
            this.mUri = null;
            int i = this.mDrawableWidth;
            int i2 = this.mDrawableHeight;
            updateDrawable(drawable);
            if (i != this.mDrawableWidth || i2 != this.mDrawableHeight) {
                requestLayout();
            }
            invalidate();
        }
    }

    @RemotableViewMethod
    public void setImageLevel(int i) {
        this.mLevel = i;
        if (this.mDrawable != null) {
            this.mDrawable.setLevel(i);
            resizeFromDrawable();
        }
    }

    public void setImageMatrix(Matrix matrix) {
        Matrix matrix2 = matrix;
        if (matrix != null) {
            matrix2 = matrix;
            if (matrix.isIdentity()) {
                matrix2 = null;
            }
        }
        if ((matrix2 != null || this.mMatrix.isIdentity()) && (matrix2 == null || this.mMatrix.equals(matrix2))) {
            return;
        }
        this.mMatrix.set(matrix2);
        configureBounds();
        invalidate();
    }

    @RemotableViewMethod
    public void setImageResource(int i) {
        int i2 = this.mDrawableWidth;
        int i3 = this.mDrawableHeight;
        updateDrawable(null);
        this.mResource = i;
        this.mUri = null;
        resolveUri();
        if (i2 != this.mDrawableWidth || i3 != this.mDrawableHeight) {
            requestLayout();
        }
        invalidate();
    }

    public void setImageState(int[] iArr, boolean z) {
        this.mState = iArr;
        this.mMergeState = z;
        if (this.mDrawable != null) {
            refreshDrawableState();
            resizeFromDrawable();
        }
    }

    public void setImageTintList(ColorStateList colorStateList) {
        this.mDrawableTintList = colorStateList;
        this.mHasDrawableTint = true;
        applyImageTint();
    }

    public void setImageTintMode(PorterDuff.Mode mode) {
        this.mDrawableTintMode = mode;
        this.mHasDrawableTintMode = true;
        applyImageTint();
    }

    @RemotableViewMethod
    public void setImageURI(Uri uri) {
        if (this.mResource == 0) {
            if (this.mUri == uri) {
                return;
            }
            if (uri != null && this.mUri != null && uri.equals(this.mUri)) {
                return;
            }
        }
        updateDrawable(null);
        this.mResource = 0;
        this.mUri = uri;
        int i = this.mDrawableWidth;
        int i2 = this.mDrawableHeight;
        resolveUri();
        if (i != this.mDrawableWidth || i2 != this.mDrawableHeight) {
            requestLayout();
        }
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    @RemotableViewMethod
    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            setWillNotCacheDrawing(this.mScaleType == ScaleType.CENTER);
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        resizeFromDrawable();
    }

    @Override // android.view.View
    @RemotableViewMethod
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mDrawable != null) {
            this.mDrawable.setVisible(i == 0, false);
        }
    }

    public final void setXfermode(Xfermode xfermode) {
        if (this.mXfermode != xfermode) {
            this.mXfermode = xfermode;
            this.mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.mDrawable == drawable || super.verifyDrawable(drawable);
    }
}
