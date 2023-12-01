package com.android.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SlidingTab.class */
public class SlidingTab extends ViewGroup {
    private static final int ANIM_DURATION = 250;
    private static final int ANIM_TARGET_TIME = 500;
    private static final boolean DBG = false;
    private static final int HORIZONTAL = 0;
    private static final String LOG_TAG = "SlidingTab";
    private static final float THRESHOLD = 0.6666667f;
    private static final int TRACKING_MARGIN = 50;
    private static final int VERTICAL = 1;
    private static final long VIBRATE_LONG = 40;
    private static final long VIBRATE_SHORT = 30;
    private static final AudioAttributes VIBRATION_ATTRIBUTES = new AudioAttributes.Builder().setContentType(4).setUsage(13).build();
    private boolean mAnimating;
    private final Animation.AnimationListener mAnimationDoneListener;
    private Slider mCurrentSlider;
    private final float mDensity;
    private int mGrabbedState;
    private boolean mHoldLeftOnTransition;
    private boolean mHoldRightOnTransition;
    private final Slider mLeftSlider;
    private OnTriggerListener mOnTriggerListener;
    private final int mOrientation;
    private Slider mOtherSlider;
    private final Slider mRightSlider;
    private float mThreshold;
    private final Rect mTmpRect;
    private boolean mTracking;
    private boolean mTriggered;
    private Vibrator mVibrator;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SlidingTab$OnTriggerListener.class */
    public interface OnTriggerListener {
        public static final int LEFT_HANDLE = 1;
        public static final int NO_HANDLE = 0;
        public static final int RIGHT_HANDLE = 2;

        void onGrabbedStateChange(View view, int i);

        void onTrigger(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SlidingTab$Slider.class */
    public static class Slider {
        public static final int ALIGN_BOTTOM = 3;
        public static final int ALIGN_LEFT = 0;
        public static final int ALIGN_RIGHT = 1;
        public static final int ALIGN_TOP = 2;
        public static final int ALIGN_UNKNOWN = 4;
        private static final int STATE_ACTIVE = 2;
        private static final int STATE_NORMAL = 0;
        private static final int STATE_PRESSED = 1;
        private int alignment_value;
        private final ImageView tab;
        private final ImageView target;
        private final TextView text;
        private int currentState = 0;
        private int alignment = 4;

        Slider(ViewGroup viewGroup, int i, int i2, int i3) {
            this.tab = new ImageView(viewGroup.getContext());
            this.tab.setBackgroundResource(i);
            this.tab.setScaleType(ImageView.ScaleType.CENTER);
            this.tab.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.text = new TextView(viewGroup.getContext());
            this.text.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            this.text.setBackgroundResource(i2);
            this.text.setTextAppearance(viewGroup.getContext(), R.style.TextAppearance_SlidingTabNormal);
            this.target = new ImageView(viewGroup.getContext());
            this.target.setImageResource(i3);
            this.target.setScaleType(ImageView.ScaleType.CENTER);
            this.target.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.target.setVisibility(4);
            viewGroup.addView(this.target);
            viewGroup.addView(this.tab);
            viewGroup.addView(this.text);
        }

        public int getTabHeight() {
            return this.tab.getMeasuredHeight();
        }

        public int getTabWidth() {
            return this.tab.getMeasuredWidth();
        }

        void hide() {
            boolean z = this.alignment == 0 || this.alignment == 1;
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, z ? this.alignment == 0 ? this.alignment_value - this.tab.getRight() : this.alignment_value - this.tab.getLeft() : 0, 0.0f, z ? 0 : this.alignment == 2 ? this.alignment_value - this.tab.getBottom() : this.alignment_value - this.tab.getTop());
            translateAnimation.setDuration(250L);
            translateAnimation.setFillAfter(true);
            this.tab.startAnimation(translateAnimation);
            this.text.startAnimation(translateAnimation);
            this.target.setVisibility(4);
        }

        public void hideTarget() {
            this.target.clearAnimation();
            this.target.setVisibility(4);
        }

        void layout(int i, int i2, int i3, int i4, int i5) {
            this.alignment = i5;
            Drawable background = this.tab.getBackground();
            int intrinsicWidth = background.getIntrinsicWidth();
            int intrinsicHeight = background.getIntrinsicHeight();
            Drawable drawable = this.target.getDrawable();
            int intrinsicWidth2 = drawable.getIntrinsicWidth();
            int intrinsicHeight2 = drawable.getIntrinsicHeight();
            int i6 = i3 - i;
            int i7 = i4 - i2;
            int i8 = (((int) (SlidingTab.THRESHOLD * i6)) - intrinsicWidth2) + (intrinsicWidth / 2);
            int i9 = ((int) (0.3333333f * i6)) - (intrinsicWidth / 2);
            int i10 = (i6 - intrinsicWidth) / 2;
            int i11 = i10 + intrinsicWidth;
            if (i5 != 0 && i5 != 1) {
                int i12 = (i6 - intrinsicWidth2) / 2;
                int i13 = (i6 + intrinsicWidth2) / 2;
                int i14 = (((int) (SlidingTab.THRESHOLD * i7)) + (intrinsicHeight / 2)) - intrinsicHeight2;
                int i15 = ((int) (0.3333333f * i7)) - (intrinsicHeight / 2);
                if (i5 == 2) {
                    this.tab.layout(i10, 0, i11, intrinsicHeight);
                    this.text.layout(i10, 0 - i7, i11, 0);
                    this.target.layout(i12, i14, i13, i14 + intrinsicHeight2);
                    this.alignment_value = i2;
                    return;
                }
                this.tab.layout(i10, i7 - intrinsicHeight, i11, i7);
                this.text.layout(i10, i7, i11, i7 + i7);
                this.target.layout(i12, i15, i13, i15 + intrinsicHeight2);
                this.alignment_value = i4;
                return;
            }
            int i16 = (i7 - intrinsicHeight2) / 2;
            int i17 = i16 + intrinsicHeight2;
            int i18 = (i7 - intrinsicHeight) / 2;
            int i19 = (i7 + intrinsicHeight) / 2;
            if (i5 == 0) {
                this.tab.layout(0, i18, intrinsicWidth, i19);
                this.text.layout(0 - i6, i18, 0, i19);
                this.text.setGravity(5);
                this.target.layout(i8, i16, i8 + intrinsicWidth2, i17);
                this.alignment_value = i;
                return;
            }
            this.tab.layout(i6 - intrinsicWidth, i18, i6, i19);
            this.text.layout(i6, i18, i6 + i6, i19);
            this.target.layout(i9, i16, i9 + intrinsicWidth2, i17);
            this.text.setGravity(48);
            this.alignment_value = i3;
        }

        public void measure() {
            this.tab.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.text.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }

        void reset(boolean z) {
            setState(0);
            this.text.setVisibility(0);
            this.text.setTextAppearance(this.text.getContext(), R.style.TextAppearance_SlidingTabNormal);
            this.tab.setVisibility(0);
            this.target.setVisibility(4);
            boolean z2 = true;
            if (this.alignment != 0) {
                z2 = this.alignment == 1;
            }
            int left = z2 ? this.alignment == 0 ? this.alignment_value - this.tab.getLeft() : this.alignment_value - this.tab.getRight() : 0;
            int top = z2 ? 0 : this.alignment == 2 ? this.alignment_value - this.tab.getTop() : this.alignment_value - this.tab.getBottom();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, left, 0.0f, top);
                translateAnimation.setDuration(250L);
                translateAnimation.setFillAfter(false);
                this.text.startAnimation(translateAnimation);
                this.tab.startAnimation(translateAnimation);
                return;
            }
            if (z2) {
                this.text.offsetLeftAndRight(left);
                this.tab.offsetLeftAndRight(left);
            } else {
                this.text.offsetTopAndBottom(top);
                this.tab.offsetTopAndBottom(top);
            }
            this.text.clearAnimation();
            this.tab.clearAnimation();
            this.target.clearAnimation();
        }

        void setBarBackgroundResource(int i) {
            this.text.setBackgroundResource(i);
        }

        void setHintText(int i) {
            this.text.setText(i);
        }

        void setIcon(int i) {
            this.tab.setImageResource(i);
        }

        void setState(int i) {
            this.text.setPressed(i == 1);
            this.tab.setPressed(i == 1);
            if (i == 2) {
                int[] iArr = {R.attr.state_active};
                if (this.text.getBackground().isStateful()) {
                    this.text.getBackground().setState(iArr);
                }
                if (this.tab.getBackground().isStateful()) {
                    this.tab.getBackground().setState(iArr);
                }
                this.text.setTextAppearance(this.text.getContext(), R.style.TextAppearance_SlidingTabActive);
            } else {
                this.text.setTextAppearance(this.text.getContext(), R.style.TextAppearance_SlidingTabNormal);
            }
            this.currentState = i;
        }

        void setTabBackgroundResource(int i) {
            this.tab.setBackgroundResource(i);
        }

        void setTarget(int i) {
            this.target.setImageResource(i);
        }

        void show(boolean z) {
            this.text.setVisibility(0);
            this.tab.setVisibility(0);
            if (z) {
                boolean z2 = true;
                if (this.alignment != 0) {
                    z2 = this.alignment == 1;
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(-(z2 ? this.alignment == 0 ? this.tab.getWidth() : -this.tab.getWidth() : 0), 0.0f, -(z2 ? 0 : this.alignment == 2 ? this.tab.getHeight() : -this.tab.getHeight()), 0.0f);
                translateAnimation.setDuration(250L);
                this.tab.startAnimation(translateAnimation);
                this.text.startAnimation(translateAnimation);
            }
        }

        void showTarget() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            this.target.startAnimation(alphaAnimation);
            this.target.setVisibility(0);
        }

        public void startAnimation(Animation animation, Animation animation2) {
            this.tab.startAnimation(animation);
            this.text.startAnimation(animation2);
        }

        public void updateDrawableStates() {
            setState(this.currentState);
        }
    }

    public SlidingTab(Context context) {
        this(context, null);
    }

    public SlidingTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHoldLeftOnTransition = true;
        this.mHoldRightOnTransition = true;
        this.mGrabbedState = 0;
        this.mTriggered = false;
        this.mAnimationDoneListener = new Animation.AnimationListener() { // from class: com.android.internal.widget.SlidingTab.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SlidingTab.this.onAnimationDone();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.mTmpRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTab);
        this.mOrientation = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mLeftSlider = new Slider(this, R.drawable.jog_tab_left_generic, R.drawable.jog_tab_bar_left_generic, R.drawable.jog_tab_target_gray);
        this.mRightSlider = new Slider(this, R.drawable.jog_tab_right_generic, R.drawable.jog_tab_bar_right_generic, R.drawable.jog_tab_target_gray);
    }

    private void cancelGrab() {
        this.mTracking = false;
        this.mTriggered = false;
        this.mOtherSlider.show(true);
        this.mCurrentSlider.reset(false);
        this.mCurrentSlider.hideTarget();
        this.mCurrentSlider = null;
        this.mOtherSlider = null;
        setGrabbedState(0);
    }

    private void dispatchTriggerEvent(int i) {
        vibrate(VIBRATE_LONG);
        if (this.mOnTriggerListener != null) {
            this.mOnTriggerListener.onTrigger(this, i);
        }
    }

    private boolean isHorizontal() {
        return this.mOrientation == 0;
    }

    private void log(String str) {
        Log.d(LOG_TAG, str);
    }

    private void moveHandle(float f, float f2) {
        ImageView imageView = this.mCurrentSlider.tab;
        TextView textView = this.mCurrentSlider.text;
        if (isHorizontal()) {
            int left = (((int) f) - imageView.getLeft()) - (imageView.getWidth() / 2);
            imageView.offsetLeftAndRight(left);
            textView.offsetLeftAndRight(left);
        } else {
            int top = (((int) f2) - imageView.getTop()) - (imageView.getHeight() / 2);
            imageView.offsetTopAndBottom(top);
            textView.offsetTopAndBottom(top);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimationDone() {
        resetView();
        this.mAnimating = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetView() {
        this.mLeftSlider.reset(false);
        this.mRightSlider.reset(false);
    }

    private void setGrabbedState(int i) {
        if (i != this.mGrabbedState) {
            this.mGrabbedState = i;
            if (this.mOnTriggerListener != null) {
                this.mOnTriggerListener.onGrabbedStateChange(this, this.mGrabbedState);
            }
        }
    }

    private void vibrate(long j) {
        boolean z = true;
        synchronized (this) {
            if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "haptic_feedback_enabled", 1, -2) == 0) {
                z = false;
            }
            if (z) {
                if (this.mVibrator == null) {
                    this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
                }
                this.mVibrator.vibrate(j, VIBRATION_ATTRIBUTES);
            }
        }
    }

    private boolean withinView(float f, float f2, View view) {
        if (!isHorizontal() || f2 <= -50.0f || f2 >= view.getHeight() + 50) {
            return !isHorizontal() && f > -50.0f && f < ((float) (view.getWidth() + 50));
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f = 0.6666667f;
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.mAnimating) {
            return false;
        }
        this.mLeftSlider.tab.getHitRect(this.mTmpRect);
        boolean contains = this.mTmpRect.contains((int) x, (int) y);
        this.mRightSlider.tab.getHitRect(this.mTmpRect);
        boolean contains2 = this.mTmpRect.contains((int) x, (int) y);
        if (this.mTracking || contains || contains2) {
            switch (action) {
                case 0:
                    this.mTracking = true;
                    this.mTriggered = false;
                    vibrate(VIBRATE_SHORT);
                    if (contains) {
                        this.mCurrentSlider = this.mLeftSlider;
                        this.mOtherSlider = this.mRightSlider;
                        if (!isHorizontal()) {
                            f = 0.3333333f;
                        }
                        this.mThreshold = f;
                        setGrabbedState(1);
                    } else {
                        this.mCurrentSlider = this.mRightSlider;
                        this.mOtherSlider = this.mLeftSlider;
                        this.mThreshold = isHorizontal() ? 0.3333333f : 0.6666667f;
                        setGrabbedState(2);
                    }
                    this.mCurrentSlider.setState(1);
                    this.mCurrentSlider.showTarget();
                    this.mOtherSlider.hide();
                    return true;
                default:
                    return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mLeftSlider.layout(i, i2, i3, i4, isHorizontal() ? 0 : 3);
            this.mRightSlider.layout(i, i2, i3, i4, isHorizontal() ? 1 : 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int max;
        int max2;
        View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mLeftSlider.measure();
        this.mRightSlider.measure();
        int tabWidth = this.mLeftSlider.getTabWidth();
        int tabWidth2 = this.mRightSlider.getTabWidth();
        int tabHeight = this.mLeftSlider.getTabHeight();
        int tabHeight2 = this.mRightSlider.getTabHeight();
        if (isHorizontal()) {
            max = Math.max(size, tabWidth + tabWidth2);
            max2 = Math.max(tabHeight, tabHeight2);
        } else {
            max = Math.max(tabWidth, tabHeight2);
            max2 = Math.max(size2, tabHeight + tabHeight2);
        }
        setMeasuredDimension(max, max2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
        if (super.onTouchEvent(r6) != false) goto L61;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.widget.SlidingTab.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view != this || i == 0 || this.mGrabbedState == 0) {
            return;
        }
        cancelGrab();
    }

    public void reset(boolean z) {
        this.mLeftSlider.reset(z);
        this.mRightSlider.reset(z);
        if (z) {
            return;
        }
        this.mAnimating = false;
    }

    public void setHoldAfterTrigger(boolean z, boolean z2) {
        this.mHoldLeftOnTransition = z;
        this.mHoldRightOnTransition = z2;
    }

    public void setLeftHintText(int i) {
        if (isHorizontal()) {
            this.mLeftSlider.setHintText(i);
        }
    }

    public void setLeftTabResources(int i, int i2, int i3, int i4) {
        this.mLeftSlider.setIcon(i);
        this.mLeftSlider.setTarget(i2);
        this.mLeftSlider.setBarBackgroundResource(i3);
        this.mLeftSlider.setTabBackgroundResource(i4);
        this.mLeftSlider.updateDrawableStates();
    }

    public void setOnTriggerListener(OnTriggerListener onTriggerListener) {
        this.mOnTriggerListener = onTriggerListener;
    }

    public void setRightHintText(int i) {
        if (isHorizontal()) {
            this.mRightSlider.setHintText(i);
        }
    }

    public void setRightTabResources(int i, int i2, int i3, int i4) {
        this.mRightSlider.setIcon(i);
        this.mRightSlider.setTarget(i2);
        this.mRightSlider.setBarBackgroundResource(i3);
        this.mRightSlider.setTabBackgroundResource(i4);
        this.mRightSlider.updateDrawableStates();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility() && i == 4) {
            reset(false);
        }
        super.setVisibility(i);
    }

    void startAnimating(final boolean z) {
        int i;
        int i2;
        this.mAnimating = true;
        Slider slider = this.mCurrentSlider;
        Slider slider2 = this.mOtherSlider;
        if (isHorizontal()) {
            int right = slider.tab.getRight();
            int width = slider.tab.getWidth();
            int left = slider.tab.getLeft();
            int width2 = getWidth();
            if (z) {
                width = 0;
            }
            i2 = 0;
            i = slider == this.mRightSlider ? -((right + width2) - width) : ((width2 - left) + width2) - width;
        } else {
            int top = slider.tab.getTop();
            int bottom = slider.tab.getBottom();
            int height = slider.tab.getHeight();
            int height2 = getHeight();
            if (z) {
                height = 0;
            }
            i = 0;
            i2 = slider == this.mRightSlider ? (top + height2) - height : -(((height2 - bottom) + height2) - height);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i, 0.0f, i2);
        translateAnimation.setDuration(250L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setFillAfter(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, i, 0.0f, i2);
        translateAnimation2.setDuration(250L);
        translateAnimation2.setInterpolator(new LinearInterpolator());
        translateAnimation2.setFillAfter(true);
        final int i3 = i;
        final int i4 = i2;
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.android.internal.widget.SlidingTab.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Animation alphaAnimation;
                if (z) {
                    alphaAnimation = new TranslateAnimation(i3, i3, i4, i4);
                    alphaAnimation.setDuration(1000L);
                    SlidingTab.this.mAnimating = false;
                } else {
                    alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                    alphaAnimation.setDuration(250L);
                    SlidingTab.this.resetView();
                }
                alphaAnimation.setAnimationListener(SlidingTab.this.mAnimationDoneListener);
                SlidingTab.this.mLeftSlider.startAnimation(alphaAnimation, alphaAnimation);
                SlidingTab.this.mRightSlider.startAnimation(alphaAnimation, alphaAnimation);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        slider.hideTarget();
        slider.startAnimation(translateAnimation, translateAnimation2);
    }
}
