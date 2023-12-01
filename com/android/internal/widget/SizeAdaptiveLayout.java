package com.android.internal.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import com.alipay.sdk.util.i;
import com.android.internal.R;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SizeAdaptiveLayout.class */
public class SizeAdaptiveLayout extends ViewGroup {
    private static final long CROSSFADE_TIME = 250;
    private static final boolean DEBUG = false;
    private static final int MAX_VALID_HEIGHT = 0;
    private static final int MIN_VALID_HEIGHT = 1;
    private static final boolean REPORT_BAD_BOUNDS = true;
    private static final String TAG = "SizeAdaptiveLayout";
    private View mActiveChild;
    private Animator.AnimatorListener mAnimatorListener;
    private int mCanceledAnimationCount;
    private View mEnteringView;
    private ObjectAnimator mFadePanel;
    private ObjectAnimator mFadeView;
    private View mLastActive;
    private View mLeavingView;
    private View mModestyPanel;
    private int mModestyPanelTop;
    private AnimatorSet mTransitionAnimation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SizeAdaptiveLayout$BringToFrontOnEnd.class */
    public class BringToFrontOnEnd implements Animator.AnimatorListener {
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !SizeAdaptiveLayout.class.desiredAssertionStatus();
        }

        BringToFrontOnEnd() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SizeAdaptiveLayout.access$008(SizeAdaptiveLayout.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SizeAdaptiveLayout.this.mCanceledAnimationCount != 0) {
                SizeAdaptiveLayout.access$010(SizeAdaptiveLayout.this);
                return;
            }
            SizeAdaptiveLayout.this.mLeavingView.setVisibility(8);
            SizeAdaptiveLayout.this.mModestyPanel.setVisibility(8);
            SizeAdaptiveLayout.this.mEnteringView.bringToFront();
            SizeAdaptiveLayout.this.mEnteringView = null;
            SizeAdaptiveLayout.this.mLeavingView = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SizeAdaptiveLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static final int UNBOUNDED = -1;
        @ViewDebug.ExportedProperty(category = "layout")
        public int maxHeight;
        @ViewDebug.ExportedProperty(category = "layout")
        public int minHeight;

        public LayoutParams() {
            this(0, 0);
        }

        public LayoutParams(int i, int i2) {
            this(i, i2, -1, -1);
        }

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.minHeight = i3;
            this.maxHeight = i4;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SizeAdaptiveLayout_Layout);
            this.minHeight = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            try {
                this.maxHeight = obtainStyledAttributes.getLayoutDimension(0, -1);
            } catch (Exception e) {
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.minHeight = -1;
            this.maxHeight = -1;
        }

        @Override // android.view.ViewGroup.LayoutParams
        public String debug(String str) {
            return str + "SizeAdaptiveLayout.LayoutParams={, max=" + this.maxHeight + ", max=" + this.minHeight + i.d;
        }
    }

    public SizeAdaptiveLayout(Context context) {
        this(context, null);
    }

    public SizeAdaptiveLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SizeAdaptiveLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SizeAdaptiveLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initialize();
    }

    static /* synthetic */ int access$008(SizeAdaptiveLayout sizeAdaptiveLayout) {
        int i = sizeAdaptiveLayout.mCanceledAnimationCount;
        sizeAdaptiveLayout.mCanceledAnimationCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(SizeAdaptiveLayout sizeAdaptiveLayout) {
        int i = sizeAdaptiveLayout.mCanceledAnimationCount;
        sizeAdaptiveLayout.mCanceledAnimationCount = i - 1;
        return i;
    }

    private int clampSizeToBounds(int i, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = 16777215 & i;
        int max = Math.max(i2, layoutParams.minHeight);
        int i3 = max;
        if (layoutParams.maxHeight != -1) {
            i3 = Math.min(max, layoutParams.maxHeight);
        }
        if (i2 != i3) {
            Log.d(TAG, this + "child view " + view + " measured out of bounds at " + i2 + "px clamped to " + i3 + "px");
        }
        return i3;
    }

    private void initialize() {
        this.mModestyPanel = new View(getContext());
        Drawable background = getBackground();
        Drawable drawable = background;
        if (background instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) background;
            stateListDrawable.setState(StateSet.WILD_CARD);
            drawable = stateListDrawable.getCurrent();
        }
        if (drawable instanceof ColorDrawable) {
            this.mModestyPanel.setBackgroundDrawable(drawable);
        }
        this.mModestyPanel.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.mModestyPanel);
        this.mFadePanel = ObjectAnimator.ofFloat(this.mModestyPanel, "alpha", 0.0f);
        this.mFadeView = ObjectAnimator.ofFloat((Object) null, "alpha", 0.0f);
        this.mAnimatorListener = new BringToFrontOnEnd();
        this.mTransitionAnimation = new AnimatorSet();
        this.mTransitionAnimation.play(this.mFadeView).with(this.mFadePanel);
        this.mTransitionAnimation.setDuration(CROSSFADE_TIME);
        this.mTransitionAnimation.addListener(this.mAnimatorListener);
    }

    private View selectActiveChild(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        View view = null;
        View view2 = null;
        int i2 = 0;
        View view3 = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (i4 < getChildCount()) {
            View childAt = getChildAt(i4);
            View view4 = view3;
            int i5 = i3;
            View view5 = view2;
            int i6 = i2;
            View view6 = view;
            if (childAt != this.mModestyPanel) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                View view7 = view;
                if (layoutParams.maxHeight == -1) {
                    view7 = view;
                    if (view == null) {
                        view7 = childAt;
                    }
                }
                int i7 = i2;
                if (layoutParams.maxHeight > i2) {
                    i7 = layoutParams.maxHeight;
                    view2 = childAt;
                }
                int i8 = i3;
                if (layoutParams.minHeight < i3) {
                    i8 = layoutParams.minHeight;
                    view3 = childAt;
                }
                view4 = view3;
                i5 = i8;
                view5 = view2;
                i6 = i7;
                view6 = view7;
                if (mode != 0) {
                    view4 = view3;
                    i5 = i8;
                    view5 = view2;
                    i6 = i7;
                    view6 = view7;
                    if (size >= layoutParams.minHeight) {
                        view4 = view3;
                        i5 = i8;
                        view5 = view2;
                        i6 = i7;
                        view6 = view7;
                        if (size <= layoutParams.maxHeight) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            i4++;
            view3 = view4;
            i3 = i5;
            view2 = view5;
            i2 = i6;
            view = view6;
        }
        if (view != null) {
            view2 = view;
        }
        return (mode == 0 || size > i2) ? view2 : view3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public View getModestyPanel() {
        return this.mModestyPanel;
    }

    public Animator getTransitionAnimation() {
        return this.mTransitionAnimation;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.mLastActive = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            getChildAt(i2).setVisibility(8);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mLastActive = this.mActiveChild;
        this.mActiveChild = selectActiveChild(View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        if (this.mActiveChild == null) {
            return;
        }
        this.mActiveChild.setVisibility(0);
        if (this.mLastActive != this.mActiveChild && this.mLastActive != null) {
            this.mEnteringView = this.mActiveChild;
            this.mLeavingView = this.mLastActive;
            this.mEnteringView.setAlpha(1.0f);
            this.mModestyPanel.setAlpha(1.0f);
            this.mModestyPanel.bringToFront();
            this.mModestyPanelTop = this.mLeavingView.getHeight();
            this.mModestyPanel.setVisibility(0);
            this.mLeavingView.bringToFront();
            if (this.mTransitionAnimation.isRunning()) {
                this.mTransitionAnimation.cancel();
            }
            this.mFadeView.setTarget(this.mLeavingView);
            this.mFadeView.setFloatValues(0.0f);
            this.mFadePanel.setFloatValues(0.0f);
            this.mTransitionAnimation.setupStartValues();
            this.mTransitionAnimation.start();
        }
        int measuredWidth = this.mActiveChild.getMeasuredWidth();
        int measuredHeight = this.mActiveChild.getMeasuredHeight();
        this.mActiveChild.layout(0, 0, measuredWidth, measuredHeight);
        this.mModestyPanel.layout(0, this.mModestyPanelTop, measuredWidth, this.mModestyPanelTop + measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        View selectActiveChild = selectActiveChild(i2);
        if (selectActiveChild == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) selectActiveChild.getLayoutParams();
        measureChild(selectActiveChild, i, i2);
        int measuredHeight = selectActiveChild.getMeasuredHeight();
        int measuredHeight2 = selectActiveChild.getMeasuredHeight();
        int combineMeasuredStates = combineMeasuredStates(0, selectActiveChild.getMeasuredState());
        setMeasuredDimension(resolveSizeAndState(measuredHeight2, i, combineMeasuredStates), clampSizeToBounds(resolveSizeAndState(measuredHeight, i2, combineMeasuredStates), selectActiveChild));
    }
}
