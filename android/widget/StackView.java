package android.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.TableMaskFilter;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.RemotableViewMethod;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.RemoteViews;
import com.android.internal.R;
import java.lang.ref.WeakReference;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/StackView.class */
public class StackView extends AdapterViewAnimator {
    private static final int DEFAULT_ANIMATION_DURATION = 400;
    private static final int FRAME_PADDING = 4;
    private static final int GESTURE_NONE = 0;
    private static final int GESTURE_SLIDE_DOWN = 2;
    private static final int GESTURE_SLIDE_UP = 1;
    private static final int INVALID_POINTER = -1;
    private static final int ITEMS_SLIDE_DOWN = 1;
    private static final int ITEMS_SLIDE_UP = 0;
    private static final int MINIMUM_ANIMATION_DURATION = 50;
    private static final int MIN_TIME_BETWEEN_INTERACTION_AND_AUTOADVANCE = 5000;
    private static final long MIN_TIME_BETWEEN_SCROLLS = 100;
    private static final int NUM_ACTIVE_VIEWS = 5;
    private static final float PERSPECTIVE_SCALE_FACTOR = 0.0f;
    private static final float PERSPECTIVE_SHIFT_FACTOR_X = 0.1f;
    private static final float PERSPECTIVE_SHIFT_FACTOR_Y = 0.1f;
    private static final float SLIDE_UP_RATIO = 0.7f;
    private static final int STACK_RELAYOUT_DURATION = 100;
    private static final float SWIPE_THRESHOLD_RATIO = 0.2f;
    private static HolographicHelper sHolographicHelper;
    private final String TAG;
    private int mActivePointerId;
    private int mClickColor;
    private ImageView mClickFeedback;
    private boolean mClickFeedbackIsValid;
    private boolean mFirstLayoutHappened;
    private int mFramePadding;
    private ImageView mHighlight;
    private float mInitialX;
    private float mInitialY;
    private long mLastInteractionTime;
    private long mLastScrollTime;
    private int mMaximumVelocity;
    private float mNewPerspectiveShiftX;
    private float mNewPerspectiveShiftY;
    private float mPerspectiveShiftX;
    private float mPerspectiveShiftY;
    private int mResOutColor;
    private int mSlideAmount;
    private int mStackMode;
    private StackSlider mStackSlider;
    private int mSwipeGestureType;
    private int mSwipeThreshold;
    private final Rect mTouchRect;
    private int mTouchSlop;
    private boolean mTransitionIsSetup;
    private VelocityTracker mVelocityTracker;
    private int mYVelocity;
    private final Rect stackInvalidateRect;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/StackView$HolographicHelper.class */
    public static class HolographicHelper {
        private static final int CLICK_FEEDBACK = 1;
        private static final int RES_OUT = 0;
        private float mDensity;
        private BlurMaskFilter mLargeBlurMaskFilter;
        private BlurMaskFilter mSmallBlurMaskFilter;
        private final Paint mHolographicPaint = new Paint();
        private final Paint mErasePaint = new Paint();
        private final Paint mBlurPaint = new Paint();
        private final Canvas mCanvas = new Canvas();
        private final Canvas mMaskCanvas = new Canvas();
        private final int[] mTmpXY = new int[2];
        private final Matrix mIdentityMatrix = new Matrix();

        HolographicHelper(Context context) {
            this.mDensity = context.getResources().getDisplayMetrics().density;
            this.mHolographicPaint.setFilterBitmap(true);
            this.mHolographicPaint.setMaskFilter(TableMaskFilter.CreateClipTable(0, 30));
            this.mErasePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.mErasePaint.setFilterBitmap(true);
            this.mSmallBlurMaskFilter = new BlurMaskFilter(2.0f * this.mDensity, BlurMaskFilter.Blur.NORMAL);
            this.mLargeBlurMaskFilter = new BlurMaskFilter(4.0f * this.mDensity, BlurMaskFilter.Blur.NORMAL);
        }

        Bitmap createClickOutline(View view, int i) {
            return createOutline(view, 1, i);
        }

        Bitmap createOutline(View view, int i, int i2) {
            this.mHolographicPaint.setColor(i2);
            if (i == 0) {
                this.mBlurPaint.setMaskFilter(this.mSmallBlurMaskFilter);
            } else if (i == 1) {
                this.mBlurPaint.setMaskFilter(this.mLargeBlurMaskFilter);
            }
            if (view.getMeasuredWidth() == 0 || view.getMeasuredHeight() == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getResources().getDisplayMetrics(), view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            this.mCanvas.setBitmap(createBitmap);
            float rotationX = view.getRotationX();
            float rotation = view.getRotation();
            float translationY = view.getTranslationY();
            float translationX = view.getTranslationX();
            view.setRotationX(0.0f);
            view.setRotation(0.0f);
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            view.draw(this.mCanvas);
            view.setRotationX(rotationX);
            view.setRotation(rotation);
            view.setTranslationY(translationY);
            view.setTranslationX(translationX);
            drawOutline(this.mCanvas, createBitmap);
            this.mCanvas.setBitmap(null);
            return createBitmap;
        }

        Bitmap createResOutline(View view, int i) {
            return createOutline(view, 0, i);
        }

        void drawOutline(Canvas canvas, Bitmap bitmap) {
            int[] iArr = this.mTmpXY;
            Bitmap extractAlpha = bitmap.extractAlpha(this.mBlurPaint, iArr);
            this.mMaskCanvas.setBitmap(extractAlpha);
            this.mMaskCanvas.drawBitmap(bitmap, -iArr[0], -iArr[1], this.mErasePaint);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.setMatrix(this.mIdentityMatrix);
            canvas.drawBitmap(extractAlpha, iArr[0], iArr[1], this.mHolographicPaint);
            this.mMaskCanvas.setBitmap(null);
            extractAlpha.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/StackView$LayoutParams.class */
    public class LayoutParams extends ViewGroup.LayoutParams {
        private final Rect globalInvalidateRect;
        int horizontalOffset;
        private final Rect invalidateRect;
        private final RectF invalidateRectf;
        View mView;
        private final Rect parentRect;
        int verticalOffset;

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.parentRect = new Rect();
            this.invalidateRect = new Rect();
            this.invalidateRectf = new RectF();
            this.globalInvalidateRect = new Rect();
            this.horizontalOffset = 0;
            this.verticalOffset = 0;
            this.width = 0;
            this.height = 0;
        }

        LayoutParams(View view) {
            super(0, 0);
            this.parentRect = new Rect();
            this.invalidateRect = new Rect();
            this.invalidateRectf = new RectF();
            this.globalInvalidateRect = new Rect();
            this.width = 0;
            this.height = 0;
            this.horizontalOffset = 0;
            this.verticalOffset = 0;
            this.mView = view;
        }

        Rect getInvalidateRect() {
            return this.invalidateRect;
        }

        void invalidateGlobalRegion(View view, Rect rect) {
            this.globalInvalidateRect.set(rect);
            this.globalInvalidateRect.union(0, 0, StackView.this.getWidth(), StackView.this.getHeight());
            View view2 = view;
            if (view.getParent() == null || !(view.getParent() instanceof View)) {
                return;
            }
            boolean z = true;
            this.parentRect.set(0, 0, 0, 0);
            while (view2.getParent() != null && (view2.getParent() instanceof View) && !this.parentRect.contains(this.globalInvalidateRect)) {
                if (!z) {
                    this.globalInvalidateRect.offset(view2.getLeft() - view2.getScrollX(), view2.getTop() - view2.getScrollY());
                }
                z = false;
                view2 = (View) view2.getParent();
                this.parentRect.set(view2.getScrollX(), view2.getScrollY(), view2.getWidth() + view2.getScrollX(), view2.getHeight() + view2.getScrollY());
                view2.invalidate(this.globalInvalidateRect.left, this.globalInvalidateRect.top, this.globalInvalidateRect.right, this.globalInvalidateRect.bottom);
            }
            view2.invalidate(this.globalInvalidateRect.left, this.globalInvalidateRect.top, this.globalInvalidateRect.right, this.globalInvalidateRect.bottom);
        }

        void resetInvalidateRect() {
            this.invalidateRect.set(0, 0, 0, 0);
        }

        public void setHorizontalOffset(int i) {
            setOffsets(i, this.verticalOffset);
        }

        public void setOffsets(int i, int i2) {
            int i3 = i - this.horizontalOffset;
            this.horizontalOffset = i;
            int i4 = i2 - this.verticalOffset;
            this.verticalOffset = i2;
            if (this.mView != null) {
                this.mView.requestLayout();
                int min = Math.min(this.mView.getLeft() + i3, this.mView.getLeft());
                int max = Math.max(this.mView.getRight() + i3, this.mView.getRight());
                this.invalidateRectf.set(min, Math.min(this.mView.getTop() + i4, this.mView.getTop()), max, Math.max(this.mView.getBottom() + i4, this.mView.getBottom()));
                float f = -this.invalidateRectf.left;
                float f2 = -this.invalidateRectf.top;
                this.invalidateRectf.offset(f, f2);
                this.mView.getMatrix().mapRect(this.invalidateRectf);
                this.invalidateRectf.offset(-f, -f2);
                this.invalidateRect.set((int) Math.floor(this.invalidateRectf.left), (int) Math.floor(this.invalidateRectf.top), (int) Math.ceil(this.invalidateRectf.right), (int) Math.ceil(this.invalidateRectf.bottom));
                invalidateGlobalRegion(this.mView, this.invalidateRect);
            }
        }

        public void setVerticalOffset(int i) {
            setOffsets(this.horizontalOffset, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/StackView$StackFrame.class */
    public static class StackFrame extends FrameLayout {
        WeakReference<ObjectAnimator> sliderAnimator;
        WeakReference<ObjectAnimator> transformAnimator;

        public StackFrame(Context context) {
            super(context);
        }

        boolean cancelSliderAnimator() {
            ObjectAnimator objectAnimator;
            if (this.sliderAnimator == null || (objectAnimator = this.sliderAnimator.get()) == null) {
                return false;
            }
            objectAnimator.cancel();
            return true;
        }

        boolean cancelTransformAnimator() {
            ObjectAnimator objectAnimator;
            if (this.transformAnimator == null || (objectAnimator = this.transformAnimator.get()) == null) {
                return false;
            }
            objectAnimator.cancel();
            return true;
        }

        void setSliderAnimator(ObjectAnimator objectAnimator) {
            this.sliderAnimator = new WeakReference<>(objectAnimator);
        }

        void setTransformAnimator(ObjectAnimator objectAnimator) {
            this.transformAnimator = new WeakReference<>(objectAnimator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/StackView$StackSlider.class */
    public class StackSlider {
        static final int BEGINNING_OF_STACK_MODE = 1;
        static final int END_OF_STACK_MODE = 2;
        static final int NORMAL_MODE = 0;
        int mMode;
        View mView;
        float mXProgress;
        float mYProgress;

        public StackSlider() {
            this.mMode = 0;
        }

        public StackSlider(StackSlider stackSlider) {
            this.mMode = 0;
            this.mView = stackSlider.mView;
            this.mYProgress = stackSlider.mYProgress;
            this.mXProgress = stackSlider.mXProgress;
            this.mMode = stackSlider.mMode;
        }

        private float cubic(float f) {
            return ((float) (Math.pow((2.0f * f) - 1.0f, 3.0d) + 1.0d)) / 2.0f;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0090, code lost:
            if (r9 > 400.0f) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private float getDuration(boolean r8, float r9) {
            /*
                r7 = this;
                r0 = r7
                android.view.View r0 = r0.mView
                if (r0 == 0) goto La7
                r0 = r7
                android.view.View r0 = r0.mView
                android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
                android.widget.StackView$LayoutParams r0 = (android.widget.StackView.LayoutParams) r0
                r12 = r0
                r0 = r12
                int r0 = r0.horizontalOffset
                double r0 = (double) r0
                r1 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r0 = java.lang.Math.pow(r0, r1)
                r1 = r12
                int r1 = r1.verticalOffset
                double r1 = (double) r1
                r2 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r1 = java.lang.Math.pow(r1, r2)
                double r0 = r0 + r1
                double r0 = java.lang.Math.sqrt(r0)
                float r0 = (float) r0
                r10 = r0
                r0 = r7
                android.widget.StackView r0 = android.widget.StackView.this
                int r0 = android.widget.StackView.access$200(r0)
                double r0 = (double) r0
                r1 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r0 = java.lang.Math.pow(r0, r1)
                r1 = 1053609165(0x3ecccccd, float:0.4)
                r2 = r7
                android.widget.StackView r2 = android.widget.StackView.this
                int r2 = android.widget.StackView.access$200(r2)
                float r2 = (float) r2
                float r1 = r1 * r2
                double r1 = (double) r1
                r2 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r1 = java.lang.Math.pow(r1, r2)
                double r0 = r0 + r1
                double r0 = java.lang.Math.sqrt(r0)
                float r0 = (float) r0
                r11 = r0
                r0 = r9
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L78
                r0 = r8
                if (r0 == 0) goto L70
                r0 = 1065353216(0x3f800000, float:1.0)
                r1 = r10
                r2 = r11
                float r1 = r1 / r2
                float r0 = r0 - r1
                r9 = r0
            L69:
                r0 = r9
                r1 = 1137180672(0x43c80000, float:400.0)
                float r0 = r0 * r1
                r10 = r0
            L6e:
                r0 = r10
                return r0
            L70:
                r0 = r10
                r1 = r11
                float r0 = r0 / r1
                r9 = r0
                goto L69
            L78:
                r0 = r8
                if (r0 == 0) goto L9a
                r0 = r10
                r1 = r9
                float r1 = java.lang.Math.abs(r1)
                float r0 = r0 / r1
                r9 = r0
            L83:
                r0 = r9
                r1 = 1112014848(0x42480000, float:50.0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L93
                r0 = r9
                r10 = r0
                r0 = r9
                r1 = 1137180672(0x43c80000, float:400.0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L6e
            L93:
                r0 = r7
                r1 = r8
                r2 = 0
                float r0 = r0.getDuration(r1, r2)
                return r0
            L9a:
                r0 = r11
                r1 = r10
                float r0 = r0 - r1
                r1 = r9
                float r1 = java.lang.Math.abs(r1)
                float r0 = r0 / r1
                r9 = r0
                goto L83
            La7:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.StackView.StackSlider.getDuration(boolean, float):float");
        }

        private float highlightAlphaInterpolator(float f) {
            return f < 0.4f ? cubic(f / 0.4f) * 0.85f : cubic(1.0f - ((f - 0.4f) / (1.0f - 0.4f))) * 0.85f;
        }

        private float rotationInterpolator(float f) {
            if (f < StackView.SWIPE_THRESHOLD_RATIO) {
                return 0.0f;
            }
            return (f - StackView.SWIPE_THRESHOLD_RATIO) / (1.0f - StackView.SWIPE_THRESHOLD_RATIO);
        }

        private float viewAlphaInterpolator(float f) {
            if (f > 0.3f) {
                return (f - 0.3f) / (1.0f - 0.3f);
            }
            return 0.0f;
        }

        float getDurationForNeutralPosition() {
            return getDuration(false, 0.0f);
        }

        float getDurationForNeutralPosition(float f) {
            return getDuration(false, f);
        }

        float getDurationForOffscreenPosition() {
            return getDuration(true, 0.0f);
        }

        float getDurationForOffscreenPosition(float f) {
            return getDuration(true, f);
        }

        public float getXProgress() {
            return this.mXProgress;
        }

        public float getYProgress() {
            return this.mYProgress;
        }

        void setMode(int i) {
            this.mMode = i;
        }

        void setView(View view) {
            this.mView = view;
        }

        public void setXProgress(float f) {
            float max = Math.max(-2.0f, Math.min(2.0f, f));
            this.mXProgress = max;
            if (this.mView == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) this.mView.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) StackView.this.mHighlight.getLayoutParams();
            float f2 = max * StackView.SWIPE_THRESHOLD_RATIO;
            layoutParams.setHorizontalOffset(Math.round(StackView.this.mSlideAmount * f2));
            layoutParams2.setHorizontalOffset(Math.round(StackView.this.mSlideAmount * f2));
        }

        public void setYProgress(float f) {
            float max = Math.max(0.0f, Math.min(1.0f, f));
            this.mYProgress = max;
            if (this.mView == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) this.mView.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) StackView.this.mHighlight.getLayoutParams();
            int i = StackView.this.mStackMode == 0 ? 1 : -1;
            if (Float.compare(0.0f, this.mYProgress) == 0 || Float.compare(1.0f, this.mYProgress) == 0) {
                if (this.mView.getLayerType() != 0) {
                    this.mView.setLayerType(0, null);
                }
            } else if (this.mView.getLayerType() == 0) {
                this.mView.setLayerType(2, null);
            }
            switch (this.mMode) {
                case 0:
                    layoutParams.setVerticalOffset(Math.round((-max) * i * StackView.this.mSlideAmount));
                    layoutParams2.setVerticalOffset(Math.round((-max) * i * StackView.this.mSlideAmount));
                    StackView.this.mHighlight.setAlpha(highlightAlphaInterpolator(max));
                    float viewAlphaInterpolator = viewAlphaInterpolator(1.0f - max);
                    if (this.mView.getAlpha() == 0.0f && viewAlphaInterpolator != 0.0f && this.mView.getVisibility() != 0) {
                        this.mView.setVisibility(0);
                    } else if (viewAlphaInterpolator == 0.0f && this.mView.getAlpha() != 0.0f && this.mView.getVisibility() == 0) {
                        this.mView.setVisibility(4);
                    }
                    this.mView.setAlpha(viewAlphaInterpolator);
                    this.mView.setRotationX(i * 90.0f * rotationInterpolator(max));
                    StackView.this.mHighlight.setRotationX(i * 90.0f * rotationInterpolator(max));
                    return;
                case 1:
                    float f2 = (1.0f - max) * StackView.SWIPE_THRESHOLD_RATIO;
                    layoutParams.setVerticalOffset(Math.round(i * f2 * StackView.this.mSlideAmount));
                    layoutParams2.setVerticalOffset(Math.round(i * f2 * StackView.this.mSlideAmount));
                    StackView.this.mHighlight.setAlpha(highlightAlphaInterpolator(f2));
                    return;
                case 2:
                    float f3 = max * StackView.SWIPE_THRESHOLD_RATIO;
                    layoutParams.setVerticalOffset(Math.round((-i) * f3 * StackView.this.mSlideAmount));
                    layoutParams2.setVerticalOffset(Math.round((-i) * f3 * StackView.this.mSlideAmount));
                    StackView.this.mHighlight.setAlpha(highlightAlphaInterpolator(f3));
                    return;
                default:
                    return;
            }
        }
    }

    public StackView(Context context) {
        this(context, null);
    }

    public StackView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.stackViewStyle);
    }

    public StackView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public StackView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.TAG = "StackView";
        this.mTouchRect = new Rect();
        this.mYVelocity = 0;
        this.mSwipeGestureType = 0;
        this.mTransitionIsSetup = false;
        this.mClickFeedbackIsValid = false;
        this.mFirstLayoutHappened = false;
        this.mLastInteractionTime = 0L;
        this.stackInvalidateRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StackView, i, i2);
        this.mResOutColor = obtainStyledAttributes.getColor(0, 0);
        this.mClickColor = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        initStackView();
    }

    private void beginGestureIfNeeded(float f) {
        int i;
        boolean z = true;
        if (((int) Math.abs(f)) <= this.mTouchSlop || this.mSwipeGestureType != 0) {
            return;
        }
        int i2 = f < 0.0f ? 1 : 2;
        cancelLongPress();
        requestDisallowInterceptTouchEvent(true);
        if (this.mAdapter == null) {
            return;
        }
        int count = getCount();
        int i3 = this.mStackMode == 0 ? i2 == 2 ? 0 : 1 : i2 == 2 ? 1 : 0;
        boolean z2 = this.mLoopViews && count == 1 && ((this.mStackMode == 0 && i2 == 1) || (this.mStackMode == 1 && i2 == 2));
        boolean z3 = this.mLoopViews && count == 1 && ((this.mStackMode == 1 && i2 == 1) || (this.mStackMode == 0 && i2 == 2));
        if (this.mLoopViews && !z3 && !z2) {
            i = 0;
        } else if (this.mCurrentWindowStartUnbounded + i3 == -1 || z3) {
            i3++;
            i = 1;
        } else {
            i = (this.mCurrentWindowStartUnbounded + i3 == count - 1 || z2) ? 2 : 0;
        }
        if (i != 0) {
            z = false;
        }
        this.mTransitionIsSetup = z;
        View viewAtRelativeIndex = getViewAtRelativeIndex(i3);
        if (viewAtRelativeIndex != null) {
            setupStackSlider(viewAtRelativeIndex, i);
            this.mSwipeGestureType = i2;
            cancelHandleClick();
        }
    }

    private void handlePointerUp(MotionEvent motionEvent) {
        int y = (int) (motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialY);
        this.mLastInteractionTime = System.currentTimeMillis();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            this.mYVelocity = (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (y > this.mSwipeThreshold && this.mSwipeGestureType == 2 && this.mStackSlider.mMode == 0) {
            this.mSwipeGestureType = 0;
            if (this.mStackMode == 0) {
                showPrevious();
            } else {
                showNext();
            }
            this.mHighlight.bringToFront();
        } else if (y < (-this.mSwipeThreshold) && this.mSwipeGestureType == 1 && this.mStackSlider.mMode == 0) {
            this.mSwipeGestureType = 0;
            if (this.mStackMode == 0) {
                showNext();
            } else {
                showPrevious();
            }
            this.mHighlight.bringToFront();
        } else if (this.mSwipeGestureType == 1) {
            float f = this.mStackMode == 1 ? 1.0f : 0.0f;
            int round = (this.mStackMode == 0 || this.mStackSlider.mMode != 0) ? Math.round(this.mStackSlider.getDurationForNeutralPosition()) : Math.round(this.mStackSlider.getDurationForOffscreenPosition());
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new StackSlider(this.mStackSlider), PropertyValuesHolder.ofFloat("XProgress", 0.0f), PropertyValuesHolder.ofFloat("YProgress", f));
            ofPropertyValuesHolder.setDuration(round);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder.start();
        } else if (this.mSwipeGestureType == 2) {
            float f2 = this.mStackMode == 1 ? 0.0f : 1.0f;
            int round2 = (this.mStackMode == 1 || this.mStackSlider.mMode != 0) ? Math.round(this.mStackSlider.getDurationForNeutralPosition()) : Math.round(this.mStackSlider.getDurationForOffscreenPosition());
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(new StackSlider(this.mStackSlider), PropertyValuesHolder.ofFloat("XProgress", 0.0f), PropertyValuesHolder.ofFloat("YProgress", f2));
            ofPropertyValuesHolder2.setDuration(round2);
            ofPropertyValuesHolder2.start();
        }
        this.mActivePointerId = -1;
        this.mSwipeGestureType = 0;
    }

    private void initStackView() {
        configureViewAnimator(5, 1);
        setStaticTransformationsEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mActivePointerId = -1;
        this.mHighlight = new ImageView(getContext());
        this.mHighlight.setLayoutParams(new LayoutParams(this.mHighlight));
        addViewInLayout(this.mHighlight, -1, new LayoutParams(this.mHighlight));
        this.mClickFeedback = new ImageView(getContext());
        this.mClickFeedback.setLayoutParams(new LayoutParams(this.mClickFeedback));
        addViewInLayout(this.mClickFeedback, -1, new LayoutParams(this.mClickFeedback));
        this.mClickFeedback.setVisibility(4);
        this.mStackSlider = new StackSlider();
        if (sHolographicHelper == null) {
            sHolographicHelper = new HolographicHelper(this.mContext);
        }
        setClipChildren(false);
        setClipToPadding(false);
        this.mStackMode = 1;
        this.mWhichChild = -1;
        this.mFramePadding = (int) Math.ceil(4.0f * this.mContext.getResources().getDisplayMetrics().density);
    }

    private void measureChildren() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int round = (Math.round(measuredWidth * 0.9f) - this.mPaddingLeft) - this.mPaddingRight;
        int round2 = (Math.round(measuredHeight * 0.9f) - this.mPaddingTop) - this.mPaddingBottom;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(round, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(round2, Integer.MIN_VALUE));
            int i4 = i2;
            int i5 = i;
            if (childAt != this.mHighlight) {
                i4 = i2;
                i5 = i;
                if (childAt != this.mClickFeedback) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    int i6 = i;
                    if (measuredWidth2 > i) {
                        i6 = measuredWidth2;
                    }
                    i4 = i2;
                    i5 = i6;
                    if (measuredHeight2 > i2) {
                        i4 = measuredHeight2;
                        i5 = i6;
                    }
                }
            }
            i3++;
            i2 = i4;
            i = i5;
        }
        this.mNewPerspectiveShiftX = 0.1f * measuredWidth;
        this.mNewPerspectiveShiftY = 0.1f * measuredHeight;
        if (i > 0 && childCount > 0 && i < round) {
            this.mNewPerspectiveShiftX = measuredWidth - i;
        }
        if (i2 <= 0 || childCount <= 0 || i2 >= round2) {
            return;
        }
        this.mNewPerspectiveShiftY = measuredHeight - i2;
    }

    private void onLayout() {
        if (!this.mFirstLayoutHappened) {
            this.mFirstLayoutHappened = true;
            updateChildTransforms();
        }
        int round = Math.round(SLIDE_UP_RATIO * getMeasuredHeight());
        if (this.mSlideAmount != round) {
            this.mSlideAmount = round;
            this.mSwipeThreshold = Math.round(SWIPE_THRESHOLD_RATIO * round);
        }
        if (Float.compare(this.mPerspectiveShiftY, this.mNewPerspectiveShiftY) == 0 && Float.compare(this.mPerspectiveShiftX, this.mNewPerspectiveShiftX) == 0) {
            return;
        }
        this.mPerspectiveShiftY = this.mNewPerspectiveShiftY;
        this.mPerspectiveShiftX = this.mNewPerspectiveShiftX;
        updateChildTransforms();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) != this.mActivePointerId) {
            return;
        }
        View viewAtRelativeIndex = getViewAtRelativeIndex(this.mSwipeGestureType == 2 ? 0 : 1);
        if (viewAtRelativeIndex == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= motionEvent.getPointerCount()) {
                handlePointerUp(motionEvent);
                return;
            }
            if (i2 != actionIndex) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.mTouchRect.set(viewAtRelativeIndex.getLeft(), viewAtRelativeIndex.getTop(), viewAtRelativeIndex.getRight(), viewAtRelativeIndex.getBottom());
                if (this.mTouchRect.contains(Math.round(x), Math.round(y))) {
                    float x2 = motionEvent.getX(actionIndex);
                    this.mInitialY += y - motionEvent.getY(actionIndex);
                    this.mInitialX += x - x2;
                    this.mActivePointerId = motionEvent.getPointerId(i2);
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.clear();
                        return;
                    }
                    return;
                }
            }
            i = i2 + 1;
        }
    }

    private void pacedScroll(boolean z) {
        if (System.currentTimeMillis() - this.mLastScrollTime > MIN_TIME_BETWEEN_SCROLLS) {
            if (z) {
                showPrevious();
            } else {
                showNext();
            }
            this.mLastScrollTime = System.currentTimeMillis();
        }
    }

    private void setupStackSlider(View view, int i) {
        this.mStackSlider.setMode(i);
        if (view != null) {
            this.mHighlight.setImageBitmap(sHolographicHelper.createResOutline(view, this.mResOutColor));
            this.mHighlight.setRotation(view.getRotation());
            this.mHighlight.setTranslationY(view.getTranslationY());
            this.mHighlight.setTranslationX(view.getTranslationX());
            this.mHighlight.bringToFront();
            view.bringToFront();
            this.mStackSlider.setView(view);
            view.setVisibility(0);
        }
    }

    private void transformViewAtIndex(int i, View view, boolean z) {
        int i2;
        float f = this.mPerspectiveShiftY;
        float f2 = this.mPerspectiveShiftX;
        if (this.mStackMode == 1) {
            int i3 = (this.mMaxNumActiveViews - i) - 1;
            i2 = i3;
            if (i3 == this.mMaxNumActiveViews - 1) {
                i2 = i3 - 1;
            }
        } else {
            int i4 = i - 1;
            i2 = i4;
            if (i4 < 0) {
                i2 = i4 + 1;
            }
        }
        float f3 = (i2 * 1.0f) / (this.mMaxNumActiveViews - 2);
        float f4 = 1.0f - (0.0f * (1.0f - f3));
        float measuredHeight = (f3 * f) + ((f4 - 1.0f) * ((getMeasuredHeight() * 0.9f) / 2.0f));
        float measuredWidth = ((1.0f - f3) * f2) + ((1.0f - f4) * ((getMeasuredWidth() * 0.9f) / 2.0f));
        if (view instanceof StackFrame) {
            ((StackFrame) view).cancelTransformAnimator();
        }
        if (!z) {
            view.setTranslationX(measuredWidth);
            view.setTranslationY(measuredHeight);
            view.setScaleX(f4);
            view.setScaleY(f4);
            return;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", f4), PropertyValuesHolder.ofFloat("scaleY", f4), PropertyValuesHolder.ofFloat("translationY", measuredHeight), PropertyValuesHolder.ofFloat("translationX", measuredWidth));
        ofPropertyValuesHolder.setDuration(MIN_TIME_BETWEEN_SCROLLS);
        if (view instanceof StackFrame) {
            ((StackFrame) view).setTransformAnimator(ofPropertyValuesHolder);
        }
        ofPropertyValuesHolder.start();
    }

    private void updateChildTransforms() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getNumActiveViews()) {
                return;
            }
            View viewAtRelativeIndex = getViewAtRelativeIndex(i2);
            if (viewAtRelativeIndex != null) {
                transformViewAtIndex(i2, viewAtRelativeIndex, false);
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.AdapterViewAnimator, android.widget.Advanceable
    public void advance() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastInteractionTime;
        if (this.mAdapter == null) {
            return;
        }
        if (!(getCount() == 1 && this.mLoopViews) && this.mSwipeGestureType == 0 && currentTimeMillis - j > 5000) {
            showNext();
        }
    }

    @Override // android.widget.AdapterViewAnimator
    void applyTransformForChildAtIndex(View view, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AdapterViewAnimator
    public LayoutParams createOrReuseLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            layoutParams2.setHorizontalOffset(0);
            layoutParams2.setVerticalOffset(0);
            layoutParams2.width = 0;
            layoutParams2.width = 0;
            return layoutParams2;
        }
        return new LayoutParams(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = false;
        canvas.getClipBounds(this.stackInvalidateRect);
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if ((layoutParams.horizontalOffset == 0 && layoutParams.verticalOffset == 0) || childAt.getAlpha() == 0.0f || childAt.getVisibility() != 0) {
                layoutParams.resetInvalidateRect();
            }
            Rect invalidateRect = layoutParams.getInvalidateRect();
            if (!invalidateRect.isEmpty()) {
                z = true;
                this.stackInvalidateRect.union(invalidateRect);
            }
            i = i2 + 1;
        }
        if (!z) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save(2);
        canvas.clipRect(this.stackInvalidateRect, Region.Op.UNION);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.widget.AdapterViewAnimator
    FrameLayout getFrameForChild() {
        StackFrame stackFrame = new StackFrame(this.mContext);
        stackFrame.setPadding(this.mFramePadding, this.mFramePadding, this.mFramePadding, this.mFramePadding);
        return stackFrame;
    }

    @Override // android.widget.AdapterViewAnimator
    void hideTapFeedback(View view) {
        this.mClickFeedback.setVisibility(4);
        invalidate();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    float axisValue = motionEvent.getAxisValue(9);
                    if (axisValue < 0.0f) {
                        pacedScroll(false);
                        return true;
                    } else if (axisValue > 0.0f) {
                        pacedScroll(true);
                        return true;
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.widget.AdapterViewAnimator, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(StackView.class.getName());
    }

    @Override // android.widget.AdapterViewAnimator, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z = true;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(StackView.class.getName());
        if (getChildCount() <= 1) {
            z = false;
        }
        accessibilityNodeInfo.setScrollable(z);
        if (isEnabled()) {
            if (getDisplayedChild() < getChildCount() - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            if (getDisplayedChild() > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.mActivePointerId == -1) {
                    this.mInitialX = motionEvent.getX();
                    this.mInitialY = motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    break;
                }
                break;
            case 1:
            case 3:
                this.mActivePointerId = -1;
                this.mSwipeGestureType = 0;
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    beginGestureIfNeeded(motionEvent.getY(findPointerIndex) - this.mInitialY);
                    break;
                } else {
                    Log.d("StackView", "Error: No data for our primary pointer.");
                    return false;
                }
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mSwipeGestureType != 0) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterViewAnimator, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        checkForAndHandleDataChanged();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= childCount) {
                onLayout();
                return;
            }
            View childAt = getChildAt(i6);
            int i7 = this.mPaddingLeft;
            int measuredWidth = childAt.getMeasuredWidth();
            int i8 = this.mPaddingTop;
            int measuredHeight = childAt.getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(this.mPaddingLeft + layoutParams.horizontalOffset, this.mPaddingTop + layoutParams.verticalOffset, layoutParams.horizontalOffset + i7 + measuredWidth, layoutParams.verticalOffset + i8 + measuredHeight);
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterViewAnimator, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z = (this.mReferenceChildWidth == -1 || this.mReferenceChildHeight == -1) ? false : true;
        if (mode2 == 0) {
            i3 = z ? Math.round(this.mReferenceChildHeight * (1.0f + 1.1111112f)) + this.mPaddingTop + this.mPaddingBottom : 0;
        } else {
            i3 = size2;
            if (mode2 == Integer.MIN_VALUE) {
                if (z) {
                    i3 = Math.round(this.mReferenceChildHeight * (1.0f + 1.1111112f)) + this.mPaddingTop + this.mPaddingBottom;
                    if (i3 > size2) {
                        i3 = size2 | 16777216;
                    }
                } else {
                    i3 = 0;
                }
            }
        }
        if (mode == 0) {
            i4 = z ? Math.round(this.mReferenceChildWidth * (1.0f + 1.1111112f)) + this.mPaddingLeft + this.mPaddingRight : 0;
        } else {
            i4 = size;
            if (mode2 == Integer.MIN_VALUE) {
                if (z) {
                    i4 = this.mReferenceChildWidth + this.mPaddingLeft + this.mPaddingRight;
                    if (i4 > size) {
                        i4 = size | 16777216;
                    }
                } else {
                    i4 = 0;
                }
            }
        }
        setMeasuredDimension(i4, i3);
        measureChildren();
    }

    @Override // android.widget.AdapterViewAnimator, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        if (findPointerIndex == -1) {
            Log.d("StackView", "Error: No data for our primary pointer.");
            return false;
        }
        float y = motionEvent.getY(findPointerIndex);
        float x = motionEvent.getX(findPointerIndex);
        float f = y - this.mInitialY;
        float f2 = this.mInitialX;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (action & 255) {
            case 1:
                handlePointerUp(motionEvent);
                return true;
            case 2:
                beginGestureIfNeeded(f);
                float f3 = (x - f2) / (this.mSlideAmount * 1.0f);
                if (this.mSwipeGestureType == 2) {
                    float f4 = ((f - (this.mTouchSlop * 1.0f)) / this.mSlideAmount) * 1.0f;
                    float f5 = f4;
                    if (this.mStackMode == 1) {
                        f5 = 1.0f - f4;
                    }
                    this.mStackSlider.setYProgress(1.0f - f5);
                    this.mStackSlider.setXProgress(f3);
                    return true;
                } else if (this.mSwipeGestureType == 1) {
                    float f6 = ((-((this.mTouchSlop * 1.0f) + f)) / this.mSlideAmount) * 1.0f;
                    float f7 = f6;
                    if (this.mStackMode == 1) {
                        f7 = 1.0f - f6;
                    }
                    this.mStackSlider.setYProgress(f7);
                    this.mStackSlider.setXProgress(f3);
                    return true;
                } else {
                    return true;
                }
            case 3:
                this.mActivePointerId = -1;
                this.mSwipeGestureType = 0;
                return true;
            case 4:
            case 5:
            default:
                return true;
            case 6:
                onSecondaryPointerUp(motionEvent);
                return true;
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (isEnabled()) {
            switch (i) {
                case 4096:
                    if (getDisplayedChild() < getChildCount() - 1) {
                        showNext();
                        return true;
                    }
                    return false;
                case 8192:
                    if (getDisplayedChild() > 0) {
                        showPrevious();
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    @Override // android.widget.AdapterViewAnimator
    @RemotableViewMethod
    public void showNext() {
        View viewAtRelativeIndex;
        if (this.mSwipeGestureType != 0) {
            return;
        }
        if (!this.mTransitionIsSetup && (viewAtRelativeIndex = getViewAtRelativeIndex(1)) != null) {
            setupStackSlider(viewAtRelativeIndex, 0);
            this.mStackSlider.setYProgress(0.0f);
            this.mStackSlider.setXProgress(0.0f);
        }
        super.showNext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AdapterViewAnimator
    public void showOnly(int i, boolean z) {
        View view;
        super.showOnly(i, z);
        int i2 = this.mCurrentWindowEnd;
        while (true) {
            int i3 = i2;
            if (i3 < this.mCurrentWindowStart) {
                break;
            }
            int modulo = modulo(i3, getWindowSize());
            if (this.mViewsMap.get(Integer.valueOf(modulo)) != null && (view = this.mViewsMap.get(Integer.valueOf(modulo)).view) != null) {
                view.bringToFront();
            }
            i2 = i3 - 1;
        }
        if (this.mHighlight != null) {
            this.mHighlight.bringToFront();
        }
        this.mTransitionIsSetup = false;
        this.mClickFeedbackIsValid = false;
    }

    @Override // android.widget.AdapterViewAnimator
    @RemotableViewMethod
    public void showPrevious() {
        View viewAtRelativeIndex;
        if (this.mSwipeGestureType != 0) {
            return;
        }
        if (!this.mTransitionIsSetup && (viewAtRelativeIndex = getViewAtRelativeIndex(0)) != null) {
            setupStackSlider(viewAtRelativeIndex, 0);
            this.mStackSlider.setYProgress(1.0f);
            this.mStackSlider.setXProgress(0.0f);
        }
        super.showPrevious();
    }

    @Override // android.widget.AdapterViewAnimator
    void showTapFeedback(View view) {
        updateClickFeedback();
        this.mClickFeedback.setVisibility(0);
        this.mClickFeedback.bringToFront();
        invalidate();
    }

    @Override // android.widget.AdapterViewAnimator
    void transformViewForTransition(int i, int i2, final View view, boolean z) {
        if (!z) {
            ((StackFrame) view).cancelSliderAnimator();
            view.setRotationX(0.0f);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.setVerticalOffset(0);
            layoutParams.setHorizontalOffset(0);
        }
        if (i == -1 && i2 == getNumActiveViews() - 1) {
            transformViewAtIndex(i2, view, false);
            view.setVisibility(0);
            view.setAlpha(1.0f);
        } else if (i == 0 && i2 == 1) {
            ((StackFrame) view).cancelSliderAnimator();
            view.setVisibility(0);
            int round = Math.round(this.mStackSlider.getDurationForNeutralPosition(this.mYVelocity));
            StackSlider stackSlider = new StackSlider(this.mStackSlider);
            stackSlider.setView(view);
            if (z) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(stackSlider, PropertyValuesHolder.ofFloat("XProgress", 0.0f), PropertyValuesHolder.ofFloat("YProgress", 0.0f));
                ofPropertyValuesHolder.setDuration(round);
                ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
                ((StackFrame) view).setSliderAnimator(ofPropertyValuesHolder);
                ofPropertyValuesHolder.start();
            } else {
                stackSlider.setYProgress(0.0f);
                stackSlider.setXProgress(0.0f);
            }
        } else if (i == 1 && i2 == 0) {
            ((StackFrame) view).cancelSliderAnimator();
            int round2 = Math.round(this.mStackSlider.getDurationForOffscreenPosition(this.mYVelocity));
            StackSlider stackSlider2 = new StackSlider(this.mStackSlider);
            stackSlider2.setView(view);
            if (z) {
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(stackSlider2, PropertyValuesHolder.ofFloat("XProgress", 0.0f), PropertyValuesHolder.ofFloat("YProgress", 1.0f));
                ofPropertyValuesHolder2.setDuration(round2);
                ofPropertyValuesHolder2.setInterpolator(new LinearInterpolator());
                ((StackFrame) view).setSliderAnimator(ofPropertyValuesHolder2);
                ofPropertyValuesHolder2.start();
            } else {
                stackSlider2.setYProgress(1.0f);
                stackSlider2.setXProgress(0.0f);
            }
        } else if (i2 == 0) {
            view.setAlpha(0.0f);
            view.setVisibility(4);
        } else if ((i == 0 || i == 1) && i2 > 1) {
            view.setVisibility(0);
            view.setAlpha(1.0f);
            view.setRotationX(0.0f);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.setVerticalOffset(0);
            layoutParams2.setHorizontalOffset(0);
        } else if (i == -1) {
            view.setAlpha(1.0f);
            view.setVisibility(0);
        } else if (i2 == -1) {
            if (z) {
                postDelayed(new Runnable() { // from class: android.widget.StackView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setAlpha(0.0f);
                    }
                }, MIN_TIME_BETWEEN_SCROLLS);
            } else {
                view.setAlpha(0.0f);
            }
        }
        if (i2 != -1) {
            transformViewAtIndex(i2, view, z);
        }
    }

    void updateClickFeedback() {
        if (this.mClickFeedbackIsValid) {
            return;
        }
        View viewAtRelativeIndex = getViewAtRelativeIndex(1);
        if (viewAtRelativeIndex != null) {
            this.mClickFeedback.setImageBitmap(sHolographicHelper.createClickOutline(viewAtRelativeIndex, this.mClickColor));
            this.mClickFeedback.setTranslationX(viewAtRelativeIndex.getTranslationX());
            this.mClickFeedback.setTranslationY(viewAtRelativeIndex.getTranslationY());
        }
        this.mClickFeedbackIsValid = true;
    }
}
