package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/widget/RatingBar.class */
public class RatingBar extends AbsSeekBar {
    private int mNumStars;
    private OnRatingBarChangeListener mOnRatingBarChangeListener;
    private int mProgressOnStartTracking;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RatingBar$OnRatingBarChangeListener.class */
    public interface OnRatingBarChangeListener {
        void onRatingChanged(RatingBar ratingBar, float f, boolean z);
    }

    public RatingBar(Context context) {
        this(context, null);
    }

    public RatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842876);
    }

    public RatingBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        boolean z = false;
        this.mNumStars = 5;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatingBar, i, i2);
        int i3 = obtainStyledAttributes.getInt(0, this.mNumStars);
        setIsIndicator(obtainStyledAttributes.getBoolean(3, this.mIsUserSeekable ? z : true));
        float f = obtainStyledAttributes.getFloat(1, -1.0f);
        float f2 = obtainStyledAttributes.getFloat(2, -1.0f);
        obtainStyledAttributes.recycle();
        if (i3 > 0 && i3 != this.mNumStars) {
            setNumStars(i3);
        }
        if (f2 >= 0.0f) {
            setStepSize(f2);
        } else {
            setStepSize(0.5f);
        }
        if (f >= 0.0f) {
            setRating(f);
        }
        this.mTouchProgressOffset = 1.1f;
    }

    private float getProgressPerStar() {
        float f = 1.0f;
        if (this.mNumStars > 0) {
            f = (1.0f * getMax()) / this.mNumStars;
        }
        return f;
    }

    private void updateSecondaryProgress(int i) {
        float progressPerStar = getProgressPerStar();
        if (progressPerStar > 0.0f) {
            setSecondaryProgress((int) (Math.ceil(i / progressPerStar) * progressPerStar));
        }
    }

    void dispatchRatingChange(boolean z) {
        if (this.mOnRatingBarChangeListener != null) {
            this.mOnRatingBarChangeListener.onRatingChanged(this, getRating(), z);
        }
    }

    @Override // android.widget.ProgressBar
    Shape getDrawableShape() {
        return new RectShape();
    }

    public int getNumStars() {
        return this.mNumStars;
    }

    public OnRatingBarChangeListener getOnRatingBarChangeListener() {
        return this.mOnRatingBarChangeListener;
    }

    public float getRating() {
        return getProgress() / getProgressPerStar();
    }

    public float getStepSize() {
        return getNumStars() / getMax();
    }

    public boolean isIndicator() {
        return !this.mIsUserSeekable;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(RatingBar.class.getName());
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(RatingBar.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AbsSeekBar
    public void onKeyChange() {
        super.onKeyChange();
        dispatchRatingChange(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onMeasure(int i, int i2) {
        synchronized (this) {
            super.onMeasure(i, i2);
            if (this.mSampleTile != null) {
                setMeasuredDimension(resolveSizeAndState(this.mSampleTile.getWidth() * this.mNumStars, i, 0), getMeasuredHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar
    public void onProgressRefresh(float f, boolean z) {
        super.onProgressRefresh(f, z);
        updateSecondaryProgress(getProgress());
        if (z) {
            return;
        }
        dispatchRatingChange(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AbsSeekBar
    public void onStartTrackingTouch() {
        this.mProgressOnStartTracking = getProgress();
        super.onStartTrackingTouch();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AbsSeekBar
    public void onStopTrackingTouch() {
        super.onStopTrackingTouch();
        if (getProgress() != this.mProgressOnStartTracking) {
            dispatchRatingChange(true);
        }
    }

    public void setIsIndicator(boolean z) {
        this.mIsUserSeekable = !z;
        setFocusable(!z);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar
    public void setMax(int i) {
        synchronized (this) {
            if (i > 0) {
                super.setMax(i);
            }
        }
    }

    public void setNumStars(int i) {
        if (i <= 0) {
            return;
        }
        this.mNumStars = i;
        requestLayout();
    }

    public void setOnRatingBarChangeListener(OnRatingBarChangeListener onRatingBarChangeListener) {
        this.mOnRatingBarChangeListener = onRatingBarChangeListener;
    }

    public void setRating(float f) {
        setProgress(Math.round(getProgressPerStar() * f));
    }

    public void setStepSize(float f) {
        if (f <= 0.0f) {
            return;
        }
        float f2 = this.mNumStars / f;
        setMax((int) f2);
        setProgress((int) ((f2 / getMax()) * getProgress()));
    }
}
