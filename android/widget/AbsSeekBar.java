package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AbsSeekBar.class */
public abstract class AbsSeekBar extends ProgressBar {
    private static final int NO_ALPHA = 255;
    private float mDisabledAlpha;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mIsDragging;
    boolean mIsUserSeekable;
    private int mKeyProgressIncrement;
    private int mScaledTouchSlop;
    private boolean mSplitTrack;
    private final Rect mTempRect;
    private Drawable mThumb;
    private int mThumbOffset;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private float mTouchDownX;
    float mTouchProgressOffset;

    public AbsSeekBar(Context context) {
        super(context);
        this.mTempRect = new Rect();
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mIsUserSeekable = true;
        this.mKeyProgressIncrement = 1;
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempRect = new Rect();
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mIsUserSeekable = true;
        this.mKeyProgressIncrement = 1;
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTempRect = new Rect();
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mIsUserSeekable = true;
        this.mKeyProgressIncrement = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBar, i, i2);
        setThumb(obtainStyledAttributes.getDrawable(0));
        if (obtainStyledAttributes.hasValue(4)) {
            this.mThumbTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(4, -1), this.mThumbTintMode);
            this.mHasThumbTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.mThumbTintList = obtainStyledAttributes.getColorStateList(3);
            this.mHasThumbTint = true;
        }
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(1, getThumbOffset()));
        this.mSplitTrack = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Theme, 0, 0);
        this.mDisabledAlpha = obtainStyledAttributes2.getFloat(3, 0.5f);
        obtainStyledAttributes2.recycle();
        applyThumbTint();
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void applyThumbTint() {
        if (this.mThumb != null) {
            if (this.mHasThumbTint || this.mHasThumbTintMode) {
                this.mThumb = this.mThumb.mutate();
                if (this.mHasThumbTint) {
                    this.mThumb.setTintList(this.mThumbTintList);
                }
                if (this.mHasThumbTintMode) {
                    this.mThumb.setTintMode(this.mThumbTintMode);
                }
                if (this.mThumb.isStateful()) {
                    this.mThumb.setState(getDrawableState());
                }
            }
        }
    }

    private void attemptClaimDrag() {
        if (this.mParent != null) {
            this.mParent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private float getScale() {
        int max = getMax();
        if (max > 0) {
            return getProgress() / max;
        }
        return 0.0f;
    }

    private void setHotspot(float f, float f2) {
        Drawable background = getBackground();
        if (background != null) {
            background.setHotspot(f, f2);
        }
    }

    private void setThumbPos(int i, Drawable drawable, float f, int i2) {
        int i3;
        int i4;
        int i5 = this.mPaddingLeft;
        int i6 = this.mPaddingRight;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i7 = (((i - i5) - i6) - intrinsicWidth) + (this.mThumbOffset * 2);
        int i8 = (int) ((i7 * f) + 0.5f);
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i4 = bounds.top;
            i3 = bounds.bottom;
        } else {
            i3 = i2 + intrinsicHeight;
            i4 = i2;
        }
        int i9 = (isLayoutRtl() && this.mMirrorForRtl) ? i7 - i8 : i8;
        int i10 = i9 + intrinsicWidth;
        Drawable background = getBackground();
        if (background != null) {
            drawable.getBounds();
            int i11 = this.mPaddingLeft - this.mThumbOffset;
            int i12 = this.mPaddingTop;
            background.setHotspotBounds(i9 + i11, i4 + i12, i10 + i11, i3 + i12);
        }
        drawable.setBounds(i9, i4, i10, i3);
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        float f;
        int width = getWidth();
        int i = (width - this.mPaddingLeft) - this.mPaddingRight;
        int x = (int) motionEvent.getX();
        float f2 = 0.0f;
        if (isLayoutRtl() && this.mMirrorForRtl) {
            if (x > width - this.mPaddingRight) {
                f = 0.0f;
            } else if (x < this.mPaddingLeft) {
                f = 1.0f;
            } else {
                f = ((i - x) + this.mPaddingLeft) / i;
                f2 = this.mTouchProgressOffset;
            }
        } else if (x < this.mPaddingLeft) {
            f = 0.0f;
        } else if (x > width - this.mPaddingRight) {
            f = 1.0f;
        } else {
            f = (x - this.mPaddingLeft) / i;
            f2 = this.mTouchProgressOffset;
        }
        setHotspot(x, (int) motionEvent.getY());
        setProgress(updateTouchProgress(getProgress(), (int) (f2 + (getMax() * f))), true);
    }

    private void updateThumbAndTrackPos(int i, int i2) {
        int i3;
        int i4;
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.mThumb;
        int min = Math.min(this.mMaxHeight, (i2 - this.mPaddingTop) - this.mPaddingBottom);
        int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
        if (intrinsicHeight > min) {
            i3 = (intrinsicHeight - min) / 2;
            i4 = 0;
        } else {
            i3 = 0;
            i4 = (min - intrinsicHeight) / 2;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, i3, (i - this.mPaddingRight) - this.mPaddingLeft, ((i2 - this.mPaddingBottom) - i3) - this.mPaddingTop);
        }
        if (drawable != null) {
            setThumbPos(i, drawable, getScale(), i4);
        }
    }

    void drawThumb(Canvas canvas) {
        if (this.mThumb != null) {
            canvas.save();
            canvas.translate(this.mPaddingLeft - this.mThumbOffset, this.mPaddingTop);
            this.mThumb.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.ProgressBar
    public void drawTrack(Canvas canvas) {
        Drawable drawable = this.mThumb;
        if (drawable == null || !this.mSplitTrack) {
            super.drawTrack(canvas);
            return;
        }
        Insets opticalInsets = drawable.getOpticalInsets();
        Rect rect = this.mTempRect;
        drawable.copyBounds(rect);
        rect.offset(this.mPaddingLeft - this.mThumbOffset, this.mPaddingTop);
        rect.left += opticalInsets.left;
        rect.right -= opticalInsets.right;
        int save = canvas.save();
        canvas.clipRect(rect, Region.Op.DIFFERENCE);
        super.drawTrack(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.mThumb != null) {
            this.mThumb.setHotspot(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (255.0f * this.mDisabledAlpha));
        }
        Drawable drawable = this.mThumb;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public int getKeyProgressIncrement() {
        return this.mKeyProgressIncrement;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public Drawable getThumb() {
        return this.mThumb;
    }

    public int getThumbOffset() {
        return this.mThumbOffset;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mThumb != null) {
            this.mThumb.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this) {
            super.onDraw(canvas);
            drawThumb(canvas);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsSeekBar.class.getName());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsSeekBar.class.getName());
        if (isEnabled()) {
            int progress = getProgress();
            if (progress > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (progress < getMax()) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onKeyChange() {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            int progress = getProgress();
            switch (i) {
                case 21:
                    if (progress > 0) {
                        setProgress(progress - this.mKeyProgressIncrement, true);
                        onKeyChange();
                        return true;
                    }
                    break;
                case 22:
                    if (progress < getMax()) {
                        setProgress(this.mKeyProgressIncrement + progress, true);
                        onKeyChange();
                        return true;
                    }
                    break;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = 0;
        synchronized (this) {
            Drawable currentDrawable = getCurrentDrawable();
            if (this.mThumb != null) {
                i3 = this.mThumb.getIntrinsicHeight();
            }
            int i4 = 0;
            int i5 = 0;
            if (currentDrawable != null) {
                i4 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, currentDrawable.getIntrinsicWidth()));
                i5 = Math.max(i3, Math.max(this.mMinHeight, Math.min(this.mMaxHeight, currentDrawable.getIntrinsicHeight())));
            }
            setMeasuredDimension(resolveSizeAndState(i4 + this.mPaddingLeft + this.mPaddingRight, i, 0), resolveSizeAndState(i5 + this.mPaddingTop + this.mPaddingBottom, i2, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.ProgressBar
    public void onProgressRefresh(float f, boolean z) {
        super.onProgressRefresh(f, z);
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onResolveDrawables(int i) {
        super.onResolveDrawables(i);
        if (this.mThumb != null) {
            this.mThumb.setLayoutDirection(i);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, getScale(), Integer.MIN_VALUE);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateThumbAndTrackPos(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStartTrackingTouch() {
        this.mIsDragging = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStopTrackingTouch() {
        this.mIsDragging = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (this.mIsUserSeekable && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (isInScrollingContainer()) {
                        this.mTouchDownX = motionEvent.getX();
                        return true;
                    }
                    setPressed(true);
                    if (this.mThumb != null) {
                        invalidate(this.mThumb.getBounds());
                    }
                    onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    attemptClaimDrag();
                    return true;
                case 1:
                    if (this.mIsDragging) {
                        trackTouchEvent(motionEvent);
                        onStopTrackingTouch();
                        setPressed(false);
                    } else {
                        onStartTrackingTouch();
                        trackTouchEvent(motionEvent);
                        onStopTrackingTouch();
                    }
                    invalidate();
                    return true;
                case 2:
                    if (this.mIsDragging) {
                        trackTouchEvent(motionEvent);
                        return true;
                    } else if (Math.abs(motionEvent.getX() - this.mTouchDownX) > this.mScaledTouchSlop) {
                        setPressed(true);
                        if (this.mThumb != null) {
                            invalidate(this.mThumb.getBounds());
                        }
                        onStartTrackingTouch();
                        trackTouchEvent(motionEvent);
                        attemptClaimDrag();
                        return true;
                    }
                    break;
                case 3:
                    if (this.mIsDragging) {
                        onStopTrackingTouch();
                        setPressed(false);
                    }
                    invalidate();
                    return true;
                default:
                    return true;
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (isEnabled()) {
            int progress = getProgress();
            int max = Math.max(1, Math.round(getMax() / 5.0f));
            switch (i) {
                case 4096:
                    if (progress >= getMax()) {
                        return false;
                    }
                    setProgress(progress + max, true);
                    onKeyChange();
                    return true;
                case 8192:
                    if (progress <= 0) {
                        return false;
                    }
                    setProgress(progress - max, true);
                    onKeyChange();
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public void setKeyProgressIncrement(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = -i;
        }
        this.mKeyProgressIncrement = i2;
    }

    @Override // android.widget.ProgressBar
    public void setMax(int i) {
        synchronized (this) {
            super.setMax(i);
            if (this.mKeyProgressIncrement == 0 || getMax() / this.mKeyProgressIncrement > 20) {
                setKeyProgressIncrement(Math.max(1, Math.round(getMax() / 20.0f)));
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.mSplitTrack = z;
        invalidate();
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        if (this.mThumb == null || drawable == this.mThumb) {
            z = false;
        } else {
            this.mThumb.setCallback(null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (canResolveLayoutDirection()) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            this.mThumbOffset = drawable.getIntrinsicWidth() / 2;
            if (z && (drawable.getIntrinsicWidth() != this.mThumb.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
        }
        this.mThumb = drawable;
        applyThumbTint();
        invalidate();
        if (z) {
            updateThumbAndTrackPos(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    public void setThumbOffset(int i) {
        this.mThumbOffset = i;
        invalidate();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    protected int updateTouchProgress(int i, int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mThumb || super.verifyDrawable(drawable);
    }
}
