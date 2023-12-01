package android.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/widget/SlidingDrawer.class */
public class SlidingDrawer extends ViewGroup {
    private static final int ANIMATION_FRAME_DURATION = 16;
    private static final int COLLAPSED_FULL_CLOSED = -10002;
    private static final int EXPANDED_FULL_OPEN = -10001;
    private static final float MAXIMUM_ACCELERATION = 2000.0f;
    private static final float MAXIMUM_MAJOR_VELOCITY = 200.0f;
    private static final float MAXIMUM_MINOR_VELOCITY = 150.0f;
    private static final float MAXIMUM_TAP_VELOCITY = 100.0f;
    private static final int MSG_ANIMATE = 1000;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private static final int TAP_THRESHOLD = 6;
    private static final int VELOCITY_UNITS = 1000;
    private boolean mAllowSingleTap;
    private boolean mAnimateOnClick;
    private float mAnimatedAcceleration;
    private float mAnimatedVelocity;
    private boolean mAnimating;
    private long mAnimationLastTime;
    private float mAnimationPosition;
    private int mBottomOffset;
    private View mContent;
    private final int mContentId;
    private long mCurrentAnimationTime;
    private boolean mExpanded;
    private final Rect mFrame;
    private View mHandle;
    private int mHandleHeight;
    private final int mHandleId;
    private int mHandleWidth;
    private final Handler mHandler;
    private final Rect mInvalidate;
    private boolean mLocked;
    private final int mMaximumAcceleration;
    private final int mMaximumMajorVelocity;
    private final int mMaximumMinorVelocity;
    private final int mMaximumTapVelocity;
    private OnDrawerCloseListener mOnDrawerCloseListener;
    private OnDrawerOpenListener mOnDrawerOpenListener;
    private OnDrawerScrollListener mOnDrawerScrollListener;
    private final int mTapThreshold;
    private int mTopOffset;
    private int mTouchDelta;
    private boolean mTracking;
    private VelocityTracker mVelocityTracker;
    private final int mVelocityUnits;
    private boolean mVertical;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SlidingDrawer$DrawerToggler.class */
    private class DrawerToggler implements View.OnClickListener {
        private DrawerToggler() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingDrawer.this.mLocked) {
                return;
            }
            if (SlidingDrawer.this.mAnimateOnClick) {
                SlidingDrawer.this.animateToggle();
            } else {
                SlidingDrawer.this.toggle();
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SlidingDrawer$OnDrawerCloseListener.class */
    public interface OnDrawerCloseListener {
        void onDrawerClosed();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SlidingDrawer$OnDrawerOpenListener.class */
    public interface OnDrawerOpenListener {
        void onDrawerOpened();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SlidingDrawer$OnDrawerScrollListener.class */
    public interface OnDrawerScrollListener {
        void onScrollEnded();

        void onScrollStarted();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SlidingDrawer$SlidingHandler.class */
    private class SlidingHandler extends Handler {
        private SlidingHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    SlidingDrawer.this.doAnimation();
                    return;
                default:
                    return;
            }
        }
    }

    public SlidingDrawer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingDrawer(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SlidingDrawer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mFrame = new Rect();
        this.mInvalidate = new Rect();
        this.mHandler = new SlidingHandler();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingDrawer, i, i2);
        this.mVertical = obtainStyledAttributes.getInt(0, 1) == 1;
        this.mBottomOffset = (int) obtainStyledAttributes.getDimension(1, 0.0f);
        this.mTopOffset = (int) obtainStyledAttributes.getDimension(2, 0.0f);
        this.mAllowSingleTap = obtainStyledAttributes.getBoolean(3, true);
        this.mAnimateOnClick = obtainStyledAttributes.getBoolean(6, true);
        int resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId == 0) {
            throw new IllegalArgumentException("The handle attribute is required and must refer to a valid child.");
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId2 == 0) {
            throw new IllegalArgumentException("The content attribute is required and must refer to a valid child.");
        }
        if (resourceId == resourceId2) {
            throw new IllegalArgumentException("The content and handle attributes must refer to different children.");
        }
        this.mHandleId = resourceId;
        this.mContentId = resourceId2;
        float f = getResources().getDisplayMetrics().density;
        this.mTapThreshold = (int) ((6.0f * f) + 0.5f);
        this.mMaximumTapVelocity = (int) ((100.0f * f) + 0.5f);
        this.mMaximumMinorVelocity = (int) ((MAXIMUM_MINOR_VELOCITY * f) + 0.5f);
        this.mMaximumMajorVelocity = (int) ((200.0f * f) + 0.5f);
        this.mMaximumAcceleration = (int) ((2000.0f * f) + 0.5f);
        this.mVelocityUnits = (int) ((1000.0f * f) + 0.5f);
        obtainStyledAttributes.recycle();
        setAlwaysDrawnWithCacheEnabled(false);
    }

    private void animateClose(int i) {
        prepareTracking(i);
        performFling(i, this.mMaximumAcceleration, true);
    }

    private void animateOpen(int i) {
        prepareTracking(i);
        performFling(i, -this.mMaximumAcceleration, true);
    }

    private void closeDrawer() {
        moveHandle(-10002);
        this.mContent.setVisibility(8);
        this.mContent.destroyDrawingCache();
        if (this.mExpanded) {
            this.mExpanded = false;
            if (this.mOnDrawerCloseListener != null) {
                this.mOnDrawerCloseListener.onDrawerClosed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAnimation() {
        if (this.mAnimating) {
            incrementAnimation();
            if (this.mAnimationPosition >= ((this.mVertical ? getHeight() : getWidth()) + this.mBottomOffset) - 1) {
                this.mAnimating = false;
                closeDrawer();
            } else if (this.mAnimationPosition < this.mTopOffset) {
                this.mAnimating = false;
                openDrawer();
            } else {
                moveHandle((int) this.mAnimationPosition);
                this.mCurrentAnimationTime += 16;
                this.mHandler.sendMessageAtTime(this.mHandler.obtainMessage(1000), this.mCurrentAnimationTime);
            }
        }
    }

    private void incrementAnimation() {
        long uptimeMillis = SystemClock.uptimeMillis();
        float f = ((float) (uptimeMillis - this.mAnimationLastTime)) / 1000.0f;
        float f2 = this.mAnimationPosition;
        float f3 = this.mAnimatedVelocity;
        float f4 = this.mAnimatedAcceleration;
        this.mAnimationPosition = (f3 * f) + f2 + (0.5f * f4 * f * f);
        this.mAnimatedVelocity = (f4 * f) + f3;
        this.mAnimationLastTime = uptimeMillis;
    }

    private void moveHandle(int i) {
        int i2;
        int i3;
        View view = this.mHandle;
        if (this.mVertical) {
            if (i == -10001) {
                view.offsetTopAndBottom(this.mTopOffset - view.getTop());
                invalidate();
            } else if (i == -10002) {
                view.offsetTopAndBottom((((this.mBottomOffset + this.mBottom) - this.mTop) - this.mHandleHeight) - view.getTop());
                invalidate();
            } else {
                int top = view.getTop();
                int i4 = i - top;
                if (i < this.mTopOffset) {
                    i3 = this.mTopOffset - top;
                } else {
                    i3 = i4;
                    if (i4 > (((this.mBottomOffset + this.mBottom) - this.mTop) - this.mHandleHeight) - top) {
                        i3 = (((this.mBottomOffset + this.mBottom) - this.mTop) - this.mHandleHeight) - top;
                    }
                }
                view.offsetTopAndBottom(i3);
                Rect rect = this.mFrame;
                Rect rect2 = this.mInvalidate;
                view.getHitRect(rect);
                rect2.set(rect);
                rect2.union(rect.left, rect.top - i3, rect.right, rect.bottom - i3);
                rect2.union(0, rect.bottom - i3, getWidth(), (rect.bottom - i3) + this.mContent.getHeight());
                invalidate(rect2);
            }
        } else if (i == -10001) {
            view.offsetLeftAndRight(this.mTopOffset - view.getLeft());
            invalidate();
        } else if (i == -10002) {
            view.offsetLeftAndRight((((this.mBottomOffset + this.mRight) - this.mLeft) - this.mHandleWidth) - view.getLeft());
            invalidate();
        } else {
            int left = view.getLeft();
            int i5 = i - left;
            if (i < this.mTopOffset) {
                i2 = this.mTopOffset - left;
            } else {
                i2 = i5;
                if (i5 > (((this.mBottomOffset + this.mRight) - this.mLeft) - this.mHandleWidth) - left) {
                    i2 = (((this.mBottomOffset + this.mRight) - this.mLeft) - this.mHandleWidth) - left;
                }
            }
            view.offsetLeftAndRight(i2);
            Rect rect3 = this.mFrame;
            Rect rect4 = this.mInvalidate;
            view.getHitRect(rect3);
            rect4.set(rect3);
            rect4.union(rect3.left - i2, rect3.top, rect3.right - i2, rect3.bottom);
            rect4.union(rect3.right - i2, 0, (rect3.right - i2) + this.mContent.getWidth(), getHeight());
            invalidate(rect4);
        }
    }

    private void openDrawer() {
        moveHandle(-10001);
        this.mContent.setVisibility(0);
        if (this.mExpanded) {
            return;
        }
        this.mExpanded = true;
        if (this.mOnDrawerOpenListener != null) {
            this.mOnDrawerOpenListener.onDrawerOpened();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e6, code lost:
        if (r8 > (-r6.mMaximumMajorVelocity)) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void performFling(int r7, float r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.SlidingDrawer.performFling(int, float, boolean):void");
    }

    private void prepareContent() {
        if (this.mAnimating) {
            return;
        }
        View view = this.mContent;
        if (view.isLayoutRequested()) {
            if (this.mVertical) {
                int i = this.mHandleHeight;
                int i2 = this.mBottom;
                int i3 = this.mTop;
                view.measure(View.MeasureSpec.makeMeasureSpec(this.mRight - this.mLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(((i2 - i3) - i) - this.mTopOffset, 1073741824));
                view.layout(0, this.mTopOffset + i, view.getMeasuredWidth(), this.mTopOffset + i + view.getMeasuredHeight());
            } else {
                int width = this.mHandle.getWidth();
                view.measure(View.MeasureSpec.makeMeasureSpec(((this.mRight - this.mLeft) - width) - this.mTopOffset, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mBottom - this.mTop, 1073741824));
                view.layout(this.mTopOffset + width, 0, this.mTopOffset + width + view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        view.getViewTreeObserver().dispatchOnPreDraw();
        if (!view.isHardwareAccelerated()) {
            view.buildDrawingCache();
        }
        view.setVisibility(8);
    }

    private void prepareTracking(int i) {
        this.mTracking = true;
        this.mVelocityTracker = VelocityTracker.obtain();
        if (!(!this.mExpanded)) {
            if (this.mAnimating) {
                this.mAnimating = false;
                this.mHandler.removeMessages(1000);
            }
            moveHandle(i);
            return;
        }
        this.mAnimatedAcceleration = this.mMaximumAcceleration;
        this.mAnimatedVelocity = this.mMaximumMajorVelocity;
        this.mAnimationPosition = (this.mVertical ? getHeight() - this.mHandleHeight : getWidth() - this.mHandleWidth) + this.mBottomOffset;
        moveHandle((int) this.mAnimationPosition);
        this.mAnimating = true;
        this.mHandler.removeMessages(1000);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mAnimationLastTime = uptimeMillis;
        this.mCurrentAnimationTime = 16 + uptimeMillis;
        this.mAnimating = true;
    }

    private void stopTracking() {
        this.mHandle.setPressed(false);
        this.mTracking = false;
        if (this.mOnDrawerScrollListener != null) {
            this.mOnDrawerScrollListener.onScrollEnded();
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void animateClose() {
        prepareContent();
        OnDrawerScrollListener onDrawerScrollListener = this.mOnDrawerScrollListener;
        if (onDrawerScrollListener != null) {
            onDrawerScrollListener.onScrollStarted();
        }
        animateClose(this.mVertical ? this.mHandle.getTop() : this.mHandle.getLeft());
        if (onDrawerScrollListener != null) {
            onDrawerScrollListener.onScrollEnded();
        }
    }

    public void animateOpen() {
        prepareContent();
        OnDrawerScrollListener onDrawerScrollListener = this.mOnDrawerScrollListener;
        if (onDrawerScrollListener != null) {
            onDrawerScrollListener.onScrollStarted();
        }
        animateOpen(this.mVertical ? this.mHandle.getTop() : this.mHandle.getLeft());
        sendAccessibilityEvent(32);
        if (onDrawerScrollListener != null) {
            onDrawerScrollListener.onScrollEnded();
        }
    }

    public void animateToggle() {
        if (this.mExpanded) {
            animateClose();
        } else {
            animateOpen();
        }
    }

    public void close() {
        closeDrawer();
        invalidate();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f = 0.0f;
        long drawingTime = getDrawingTime();
        View view = this.mHandle;
        boolean z = this.mVertical;
        drawChild(canvas, view, drawingTime);
        if (!this.mTracking && !this.mAnimating) {
            if (this.mExpanded) {
                drawChild(canvas, this.mContent, drawingTime);
                return;
            }
            return;
        }
        Bitmap drawingCache = this.mContent.getDrawingCache();
        if (drawingCache != null) {
            if (z) {
                canvas.drawBitmap(drawingCache, 0.0f, view.getBottom(), (Paint) null);
                return;
            } else {
                canvas.drawBitmap(drawingCache, view.getRight(), 0.0f, (Paint) null);
                return;
            }
        }
        canvas.save();
        float left = z ? 0.0f : view.getLeft() - this.mTopOffset;
        if (z) {
            f = view.getTop() - this.mTopOffset;
        }
        canvas.translate(left, f);
        drawChild(canvas, this.mContent, drawingTime);
        canvas.restore();
    }

    public View getContent() {
        return this.mContent;
    }

    public View getHandle() {
        return this.mHandle;
    }

    public boolean isMoving() {
        return this.mTracking || this.mAnimating;
    }

    public boolean isOpened() {
        return this.mExpanded;
    }

    public void lock() {
        this.mLocked = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        this.mHandle = findViewById(this.mHandleId);
        if (this.mHandle == null) {
            throw new IllegalArgumentException("The handle attribute is must refer to an existing child.");
        }
        this.mHandle.setOnClickListener(new DrawerToggler());
        this.mContent = findViewById(this.mContentId);
        if (this.mContent == null) {
            throw new IllegalArgumentException("The content attribute is must refer to an existing child.");
        }
        this.mContent.setVisibility(8);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SlidingDrawer.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SlidingDrawer.class.getName());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mLocked) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = this.mFrame;
        View view = this.mHandle;
        view.getHitRect(rect);
        if (this.mTracking || rect.contains((int) x, (int) y)) {
            if (action == 0) {
                this.mTracking = true;
                view.setPressed(true);
                prepareContent();
                if (this.mOnDrawerScrollListener != null) {
                    this.mOnDrawerScrollListener.onScrollStarted();
                }
                if (this.mVertical) {
                    int top = this.mHandle.getTop();
                    this.mTouchDelta = ((int) y) - top;
                    prepareTracking(top);
                } else {
                    int left = this.mHandle.getLeft();
                    this.mTouchDelta = ((int) x) - left;
                    prepareTracking(left);
                }
                this.mVelocityTracker.addMovement(motionEvent);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.mTracking) {
            return;
        }
        int i7 = i3 - i;
        int i8 = i4 - i2;
        View view = this.mHandle;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        View view2 = this.mContent;
        if (this.mVertical) {
            int i9 = (i7 - measuredWidth) / 2;
            int i10 = this.mExpanded ? this.mTopOffset : (i8 - measuredHeight) + this.mBottomOffset;
            view2.layout(0, this.mTopOffset + measuredHeight, view2.getMeasuredWidth(), this.mTopOffset + measuredHeight + view2.getMeasuredHeight());
            i6 = i10;
            i5 = i9;
        } else {
            i5 = this.mExpanded ? this.mTopOffset : (i7 - measuredWidth) + this.mBottomOffset;
            i6 = (i8 - measuredHeight) / 2;
            view2.layout(this.mTopOffset + measuredWidth, 0, this.mTopOffset + measuredWidth + view2.getMeasuredWidth(), view2.getMeasuredHeight());
        }
        view.layout(i5, i6, i5 + measuredWidth, i6 + measuredHeight);
        this.mHandleHeight = view.getHeight();
        this.mHandleWidth = view.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        }
        View view = this.mHandle;
        measureChild(view, i, i2);
        if (this.mVertical) {
            int measuredHeight = view.getMeasuredHeight();
            this.mContent.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - measuredHeight) - this.mTopOffset, 1073741824));
        } else {
            int measuredWidth = view.getMeasuredWidth();
            this.mContent.measure(View.MeasureSpec.makeMeasureSpec((size - measuredWidth) - this.mTopOffset, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x014a, code lost:
        if (r5.mAllowSingleTap == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x014d, code lost:
        playSoundEffect(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0156, code lost:
        if (r5.mExpanded == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015b, code lost:
        if (r0 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015e, code lost:
        animateClose(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01fb, code lost:
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0204, code lost:
        if (r0 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0207, code lost:
        animateOpen(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0210, code lost:
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0219, code lost:
        if (r0 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x021c, code lost:
        performFling(r12, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0227, code lost:
        r12 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x022e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.SlidingDrawer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void open() {
        openDrawer();
        invalidate();
        requestLayout();
        sendAccessibilityEvent(32);
    }

    public void setOnDrawerCloseListener(OnDrawerCloseListener onDrawerCloseListener) {
        this.mOnDrawerCloseListener = onDrawerCloseListener;
    }

    public void setOnDrawerOpenListener(OnDrawerOpenListener onDrawerOpenListener) {
        this.mOnDrawerOpenListener = onDrawerOpenListener;
    }

    public void setOnDrawerScrollListener(OnDrawerScrollListener onDrawerScrollListener) {
        this.mOnDrawerScrollListener = onDrawerScrollListener;
    }

    public void toggle() {
        if (this.mExpanded) {
            closeDrawer();
        } else {
            openDrawer();
        }
        invalidate();
        requestLayout();
    }

    public void unlock() {
        this.mLocked = false;
    }
}
