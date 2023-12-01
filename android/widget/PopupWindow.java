package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.android.internal.R;
import java.lang.ref.WeakReference;

/* loaded from: source-4181928-dex2jar.jar:android/widget/PopupWindow.class */
public class PopupWindow {
    private static final int[] ABOVE_ANCHOR_STATE_SET = {16842922};
    private static final int DEFAULT_ANCHORED_GRAVITY = 8388659;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    private boolean mAboveAnchor;
    private Drawable mAboveAnchorBackgroundDrawable;
    private boolean mAllowScrollingAnchorParent;
    private WeakReference<View> mAnchor;
    private int mAnchorRelativeX;
    private int mAnchorRelativeY;
    private int mAnchorXoff;
    private int mAnchorYoff;
    private int mAnchoredGravity;
    private int mAnimationStyle;
    private boolean mAttachedInDecor;
    private boolean mAttachedInDecorSet;
    private Drawable mBackground;
    private Drawable mBelowAnchorBackgroundDrawable;
    private boolean mClipToScreen;
    private boolean mClippingEnabled;
    private View mContentView;
    private Context mContext;
    private int[] mDrawingLocation;
    private float mElevation;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private boolean mIgnoreCheekPress;
    private int mInputMethodMode;
    private boolean mIsDropdown;
    private boolean mIsShowing;
    private int mLastHeight;
    private int mLastWidth;
    private boolean mLayoutInScreen;
    private boolean mLayoutInsetDecor;
    private boolean mNotTouchModal;
    private OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private boolean mOutsideTouchable;
    private boolean mOverlapAnchor;
    private int mPopupHeight;
    private View mPopupView;
    private boolean mPopupViewInitialLayoutDirectionInherited;
    private int mPopupWidth;
    private int[] mScreenLocation;
    private int mSoftInputMode;
    private int mSplitTouchEnabled;
    private Rect mTempRect;
    private View.OnTouchListener mTouchInterceptor;
    private boolean mTouchable;
    private int mWidth;
    private int mWidthMode;
    private int mWindowLayoutType;
    private WindowManager mWindowManager;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/PopupWindow$OnDismissListener.class */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/PopupWindow$PopupViewContainer.class */
    public class PopupViewContainer extends FrameLayout {
        private static final String TAG = "PopupWindow.PopupViewContainer";

        public PopupViewContainer(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            boolean z = true;
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    z = super.dispatchKeyEvent(keyEvent);
                } else if (keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
                    if (keyEvent.getAction() != 1 || (keyDispatcherState = getKeyDispatcherState()) == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled()) {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    PopupWindow.this.dismiss();
                    return true;
                } else {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                        return true;
                    }
                }
                return z;
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (PopupWindow.this.mTouchInterceptor == null || !PopupWindow.this.mTouchInterceptor.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.mAboveAnchor) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.ABOVE_ANCHOR_STATE_SET);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                PopupWindow.this.dismiss();
                return true;
            } else if (motionEvent.getAction() == 4) {
                PopupWindow.this.dismiss();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            if (PopupWindow.this.mContentView != null) {
                PopupWindow.this.mContentView.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(int i, int i2) {
        this((View) null, i, i2);
    }

    public PopupWindow(Context context) {
        this(context, (AttributeSet) null);
    }

    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mInputMethodMode = 0;
        this.mSoftInputMode = 1;
        this.mTouchable = true;
        this.mOutsideTouchable = false;
        this.mClippingEnabled = true;
        this.mSplitTouchEnabled = -1;
        this.mAllowScrollingAnchorParent = true;
        this.mLayoutInsetDecor = false;
        this.mAttachedInDecor = true;
        this.mAttachedInDecorSet = false;
        this.mDrawingLocation = new int[2];
        this.mScreenLocation = new int[2];
        this.mTempRect = new Rect();
        this.mWindowLayoutType = 1000;
        this.mIgnoreCheekPress = false;
        this.mAnimationStyle = -1;
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: android.widget.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view = PopupWindow.this.mAnchor != null ? (View) PopupWindow.this.mAnchor.get() : null;
                if (view == null || PopupWindow.this.mPopupView == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.mPopupView.getLayoutParams();
                PopupWindow.this.updateAboveAnchor(PopupWindow.this.findDropDownPosition(view, layoutParams, PopupWindow.this.mAnchorXoff, PopupWindow.this.mAnchorYoff, PopupWindow.this.mAnchoredGravity));
                PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PopupWindow, i, i2);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.mElevation = obtainStyledAttributes.getDimension(3, 0.0f);
        this.mOverlapAnchor = obtainStyledAttributes.getBoolean(2, false);
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        this.mAnimationStyle = resourceId == 16974567 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
        setBackgroundDrawable(drawable);
    }

    public PopupWindow(View view) {
        this(view, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.mInputMethodMode = 0;
        this.mSoftInputMode = 1;
        this.mTouchable = true;
        this.mOutsideTouchable = false;
        this.mClippingEnabled = true;
        this.mSplitTouchEnabled = -1;
        this.mAllowScrollingAnchorParent = true;
        this.mLayoutInsetDecor = false;
        this.mAttachedInDecor = true;
        this.mAttachedInDecorSet = false;
        this.mDrawingLocation = new int[2];
        this.mScreenLocation = new int[2];
        this.mTempRect = new Rect();
        this.mWindowLayoutType = 1000;
        this.mIgnoreCheekPress = false;
        this.mAnimationStyle = -1;
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: android.widget.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2 = PopupWindow.this.mAnchor != null ? (View) PopupWindow.this.mAnchor.get() : null;
                if (view2 == null || PopupWindow.this.mPopupView == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.mPopupView.getLayoutParams();
                PopupWindow.this.updateAboveAnchor(PopupWindow.this.findDropDownPosition(view2, layoutParams, PopupWindow.this.mAnchorXoff, PopupWindow.this.mAnchorYoff, PopupWindow.this.mAnchoredGravity));
                PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        };
        if (view != null) {
            this.mContext = view.getContext();
            this.mWindowManager = (WindowManager) this.mContext.getSystemService(Context.WINDOW_SERVICE);
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int computeAnimationResource() {
        if (this.mAnimationStyle == -1) {
            if (this.mIsDropdown) {
                return this.mAboveAnchor ? R.style.Animation_DropDownUp : R.style.Animation_DropDownDown;
            }
            return 0;
        }
        return this.mAnimationStyle;
    }

    private int computeFlags(int i) {
        int i2;
        int i3 = i & (-8815129);
        int i4 = i3;
        if (this.mIgnoreCheekPress) {
            i4 = i3 | 32768;
        }
        if (this.mFocusable) {
            i2 = i4;
            if (this.mInputMethodMode == 2) {
                i2 = i4 | 131072;
            }
        } else {
            int i5 = i4 | 8;
            i2 = i5;
            if (this.mInputMethodMode == 1) {
                i2 = i5 | 131072;
            }
        }
        int i6 = i2;
        if (!this.mTouchable) {
            i6 = i2 | 16;
        }
        int i7 = i6;
        if (this.mOutsideTouchable) {
            i7 = i6 | 262144;
        }
        int i8 = i7;
        if (!this.mClippingEnabled) {
            i8 = i7 | 512;
        }
        int i9 = i8;
        if (isSplitTouchEnabled()) {
            i9 = i8 | 8388608;
        }
        int i10 = i9;
        if (this.mLayoutInScreen) {
            i10 = i9 | 256;
        }
        int i11 = i10;
        if (this.mLayoutInsetDecor) {
            i11 = i10 | 65536;
        }
        int i12 = i11;
        if (this.mNotTouchModal) {
            i12 = i11 | 32;
        }
        int i13 = i12;
        if (this.mAttachedInDecor) {
            i13 = i12 | 1073741824;
        }
        return i13;
    }

    private WindowManager.LayoutParams createPopupLayout(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        int i = this.mWidth;
        this.mLastWidth = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.mLastHeight = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = computeFlags(layoutParams.flags);
        layoutParams.type = this.mWindowLayoutType;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.mSoftInputMode;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean findDropDownPosition(View view, WindowManager.LayoutParams layoutParams, int i, int i2, int i3) {
        int height = view.getHeight();
        int width = view.getWidth();
        int i4 = i2;
        if (this.mOverlapAnchor) {
            i4 = i2 - height;
        }
        view.getLocationInWindow(this.mDrawingLocation);
        layoutParams.x = this.mDrawingLocation[0] + i;
        layoutParams.y = this.mDrawingLocation[1] + height + i4;
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, view.getLayoutDirection()) & 7;
        if (absoluteGravity == 5) {
            layoutParams.x -= this.mPopupWidth - width;
        }
        boolean z = false;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.mScreenLocation);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i5 = this.mScreenLocation[1];
        View rootView = view.getRootView();
        if (this.mPopupHeight + i5 + height + i4 > rect.bottom || (layoutParams.x + this.mPopupWidth) - rootView.getWidth() > 0) {
            if (this.mAllowScrollingAnchorParent) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.mPopupWidth + scrollX + i, this.mPopupHeight + scrollY + height + i4), true);
            }
            view.getLocationInWindow(this.mDrawingLocation);
            layoutParams.x = this.mDrawingLocation[0] + i;
            layoutParams.y = this.mDrawingLocation[1] + height + i4;
            if (absoluteGravity == 5) {
                layoutParams.x -= this.mPopupWidth - width;
            }
            view.getLocationOnScreen(this.mScreenLocation);
            z = ((rect.bottom - this.mScreenLocation[1]) - height) - i4 < (this.mScreenLocation[1] - i4) - rect.top;
            if (z) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.mDrawingLocation[1]) + i4;
            } else {
                layoutParams.y = this.mDrawingLocation[1] + height + i4;
            }
        }
        if (this.mClipToScreen) {
            int i6 = rect.right - rect.left;
            int i7 = layoutParams.x + layoutParams.width;
            if (i7 > i6) {
                layoutParams.x -= i7 - i6;
            }
            if (layoutParams.x < rect.left) {
                layoutParams.x = rect.left;
                layoutParams.width = Math.min(layoutParams.width, i6);
            }
            if (z) {
                int i8 = (this.mScreenLocation[1] + i4) - this.mPopupHeight;
                if (i8 < 0) {
                    layoutParams.y += i8;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= 268435456;
        this.mAnchorRelativeX = (this.mDrawingLocation[0] - layoutParams.x) + (height / 2);
        this.mAnchorRelativeY = (this.mDrawingLocation[1] - layoutParams.y) + (width / 2);
        return z;
    }

    private void invokePopup(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mPopupView.setFitsSystemWindows(this.mLayoutInsetDecor);
        setLayoutDirectionFromAnchor();
        this.mWindowManager.addView(this.mPopupView, layoutParams);
    }

    private void preparePopup(WindowManager.LayoutParams layoutParams) {
        if (this.mContentView == null || this.mContext == null || this.mWindowManager == null) {
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
        if (this.mBackground != null) {
            ViewGroup.LayoutParams layoutParams2 = this.mContentView.getLayoutParams();
            int i = -1;
            if (layoutParams2 != null) {
                i = -1;
                if (layoutParams2.height == -2) {
                    i = -2;
                }
            }
            PopupViewContainer popupViewContainer = new PopupViewContainer(this.mContext);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            popupViewContainer.setBackground(this.mBackground);
            popupViewContainer.addView(this.mContentView, layoutParams3);
            this.mPopupView = popupViewContainer;
        } else {
            this.mPopupView = this.mContentView;
        }
        this.mPopupView.setElevation(this.mElevation);
        this.mPopupViewInitialLayoutDirectionInherited = this.mPopupView.getRawLayoutDirection() == 2;
        this.mPopupWidth = layoutParams.width;
        this.mPopupHeight = layoutParams.height;
    }

    private void registerForScrollChanged(View view, int i, int i2, int i3) {
        unregisterForScrollChanged();
        this.mAnchor = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.mOnScrollChangedListener);
        }
        this.mAnchorXoff = i;
        this.mAnchorYoff = i2;
        this.mAnchoredGravity = i3;
    }

    private void setLayoutDirectionFromAnchor() {
        View view;
        if (this.mAnchor == null || (view = this.mAnchor.get()) == null || !this.mPopupViewInitialLayoutDirectionInherited) {
            return;
        }
        this.mPopupView.setLayoutDirection(view.getLayoutDirection());
    }

    private void unregisterForScrollChanged() {
        WeakReference<View> weakReference = this.mAnchor;
        View view = null;
        if (weakReference != null) {
            view = weakReference.get();
        }
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
        }
        this.mAnchor = null;
    }

    private void update(View view, boolean z, int i, int i2, boolean z2, int i3, int i4, int i5) {
        if (!isShowing() || this.mContentView == null) {
            return;
        }
        WeakReference<View> weakReference = this.mAnchor;
        boolean z3 = z && !(this.mAnchorXoff == i && this.mAnchorYoff == i2);
        if (weakReference == null || weakReference.get() != view || (z3 && !this.mIsDropdown)) {
            registerForScrollChanged(view, i, i2, i5);
        } else if (z3) {
            this.mAnchorXoff = i;
            this.mAnchorYoff = i2;
            this.mAnchoredGravity = i5;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        int i6 = i3;
        int i7 = i4;
        if (z2) {
            if (i3 == -1) {
                i3 = this.mPopupWidth;
            } else {
                this.mPopupWidth = i3;
            }
            if (i4 == -1) {
                i7 = this.mPopupHeight;
                i6 = i3;
            } else {
                this.mPopupHeight = i4;
                i6 = i3;
                i7 = i4;
            }
        }
        int i8 = layoutParams.x;
        int i9 = layoutParams.y;
        if (z) {
            updateAboveAnchor(findDropDownPosition(view, layoutParams, i, i2, i5));
        } else {
            updateAboveAnchor(findDropDownPosition(view, layoutParams, this.mAnchorXoff, this.mAnchorYoff, this.mAnchoredGravity));
        }
        update(layoutParams.x, layoutParams.y, i6, i7, (i8 == layoutParams.x && i9 == layoutParams.y) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAboveAnchor(boolean z) {
        if (z != this.mAboveAnchor) {
            this.mAboveAnchor = z;
            if (this.mBackground != null) {
                if (this.mAboveAnchorBackgroundDrawable == null) {
                    this.mPopupView.refreshDrawableState();
                } else if (this.mAboveAnchor) {
                    this.mPopupView.setBackground(this.mAboveAnchorBackgroundDrawable);
                } else {
                    this.mPopupView.setBackground(this.mBelowAnchorBackgroundDrawable);
                }
            }
        }
    }

    public void dismiss() {
        if (!isShowing() || this.mPopupView == null) {
            return;
        }
        this.mIsShowing = false;
        unregisterForScrollChanged();
        try {
            this.mWindowManager.removeViewImmediate(this.mPopupView);
        } finally {
            if (this.mPopupView != this.mContentView && (this.mPopupView instanceof ViewGroup)) {
                ((ViewGroup) this.mPopupView).removeView(this.mContentView);
            }
            this.mPopupView = null;
            if (this.mOnDismissListener != null) {
                this.mOnDismissListener.onDismiss();
            }
        }
    }

    public int getAnimationStyle() {
        return this.mAnimationStyle;
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public float getElevation() {
        return this.mElevation;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getInputMethodMode() {
        return this.mInputMethodMode;
    }

    public int getMaxAvailableHeight(View view) {
        return getMaxAvailableHeight(view, 0);
    }

    public int getMaxAvailableHeight(View view, int i) {
        return getMaxAvailableHeight(view, i, false);
    }

    public int getMaxAvailableHeight(View view, int i, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = this.mDrawingLocation;
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int max = Math.max((i2 - (iArr[1] + view.getHeight())) - i, (iArr[1] - rect.top) + i);
        int i3 = max;
        if (this.mBackground != null) {
            this.mBackground.getPadding(this.mTempRect);
            i3 = max - (this.mTempRect.top + this.mTempRect.bottom);
        }
        return i3;
    }

    public int getSoftInputMode() {
        return this.mSoftInputMode;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getWindowLayoutType() {
        return this.mWindowLayoutType;
    }

    public boolean isAboveAnchor() {
        return this.mAboveAnchor;
    }

    public boolean isAttachedInDecor() {
        return this.mAttachedInDecor;
    }

    public boolean isClippingEnabled() {
        return this.mClippingEnabled;
    }

    public boolean isFocusable() {
        return this.mFocusable;
    }

    public boolean isLayoutInScreenEnabled() {
        return this.mLayoutInScreen;
    }

    public boolean isOutsideTouchable() {
        return this.mOutsideTouchable;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public boolean isSplitTouchEnabled() {
        return (this.mSplitTouchEnabled >= 0 || this.mContext == null) ? this.mSplitTouchEnabled == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public boolean isTouchable() {
        return this.mTouchable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAllowScrollingAnchorParent(boolean z) {
        this.mAllowScrollingAnchorParent = z;
    }

    public void setAnimationStyle(int i) {
        this.mAnimationStyle = i;
    }

    public void setAttachedInDecor(boolean z) {
        this.mAttachedInDecor = z;
        this.mAttachedInDecorSet = true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        int i;
        this.mBackground = drawable;
        if (this.mBackground instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.mBackground;
            int stateDrawableIndex = stateListDrawable.getStateDrawableIndex(ABOVE_ANCHOR_STATE_SET);
            int stateCount = stateListDrawable.getStateCount();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = -1;
                if (i3 >= stateCount) {
                    break;
                } else if (i3 != stateDrawableIndex) {
                    i = i3;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (stateDrawableIndex == -1 || i == -1) {
                this.mBelowAnchorBackgroundDrawable = null;
                this.mAboveAnchorBackgroundDrawable = null;
                return;
            }
            this.mAboveAnchorBackgroundDrawable = stateListDrawable.getStateDrawable(stateDrawableIndex);
            this.mBelowAnchorBackgroundDrawable = stateListDrawable.getStateDrawable(i);
        }
    }

    public void setClipToScreenEnabled(boolean z) {
        this.mClipToScreen = z;
        setClippingEnabled(!z);
    }

    public void setClippingEnabled(boolean z) {
        this.mClippingEnabled = z;
    }

    public void setContentView(View view) {
        if (isShowing()) {
            return;
        }
        this.mContentView = view;
        if (this.mContext == null && this.mContentView != null) {
            this.mContext = this.mContentView.getContext();
        }
        if (this.mWindowManager == null && this.mContentView != null) {
            this.mWindowManager = (WindowManager) this.mContext.getSystemService(Context.WINDOW_SERVICE);
        }
        if (this.mContext == null || this.mAttachedInDecorSet) {
            return;
        }
        setAttachedInDecor(this.mContext.getApplicationInfo().targetSdkVersion >= 22);
    }

    public void setElevation(float f) {
        this.mElevation = f;
    }

    public void setFocusable(boolean z) {
        this.mFocusable = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setIgnoreCheekPress() {
        this.mIgnoreCheekPress = true;
    }

    public void setInputMethodMode(int i) {
        this.mInputMethodMode = i;
    }

    public void setLayoutInScreenEnabled(boolean z) {
        this.mLayoutInScreen = z;
    }

    public void setLayoutInsetDecor(boolean z) {
        this.mLayoutInsetDecor = z;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOutsideTouchable(boolean z) {
        this.mOutsideTouchable = z;
    }

    public void setSoftInputMode(int i) {
        this.mSoftInputMode = i;
    }

    public void setSplitTouchEnabled(boolean z) {
        this.mSplitTouchEnabled = z ? 1 : 0;
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.mTouchInterceptor = onTouchListener;
    }

    public void setTouchModal(boolean z) {
        this.mNotTouchModal = !z;
    }

    public void setTouchable(boolean z) {
        this.mTouchable = z;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setWindowLayoutMode(int i, int i2) {
        this.mWidthMode = i;
        this.mHeightMode = i2;
    }

    public void setWindowLayoutType(int i) {
        this.mWindowLayoutType = i;
    }

    public void showAsDropDown(View view) {
        showAsDropDown(view, 0, 0);
    }

    public void showAsDropDown(View view, int i, int i2) {
        showAsDropDown(view, i, i2, 8388659);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (isShowing() || this.mContentView == null) {
            return;
        }
        registerForScrollChanged(view, i, i2, i3);
        this.mIsShowing = true;
        this.mIsDropdown = true;
        WindowManager.LayoutParams createPopupLayout = createPopupLayout(view.getWindowToken());
        preparePopup(createPopupLayout);
        updateAboveAnchor(findDropDownPosition(view, createPopupLayout, i, i2, i3));
        if (this.mHeightMode < 0) {
            int i4 = this.mHeightMode;
            this.mLastHeight = i4;
            createPopupLayout.height = i4;
        }
        if (this.mWidthMode < 0) {
            int i5 = this.mWidthMode;
            this.mLastWidth = i5;
            createPopupLayout.width = i5;
        }
        createPopupLayout.windowAnimations = computeAnimationResource();
        invokePopup(createPopupLayout);
    }

    public void showAtLocation(IBinder iBinder, int i, int i2, int i3) {
        if (isShowing() || this.mContentView == null) {
            return;
        }
        unregisterForScrollChanged();
        this.mIsShowing = true;
        this.mIsDropdown = false;
        WindowManager.LayoutParams createPopupLayout = createPopupLayout(iBinder);
        createPopupLayout.windowAnimations = computeAnimationResource();
        preparePopup(createPopupLayout);
        int i4 = i;
        if (i == 0) {
            i4 = 8388659;
        }
        createPopupLayout.gravity = i4;
        createPopupLayout.x = i2;
        createPopupLayout.y = i3;
        if (this.mHeightMode < 0) {
            int i5 = this.mHeightMode;
            this.mLastHeight = i5;
            createPopupLayout.height = i5;
        }
        if (this.mWidthMode < 0) {
            int i6 = this.mWidthMode;
            this.mLastWidth = i6;
            createPopupLayout.width = i6;
        }
        invokePopup(createPopupLayout);
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        showAtLocation(view.getWindowToken(), i, i2, i3);
    }

    public void update() {
        if (!isShowing() || this.mContentView == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        boolean z = false;
        int computeAnimationResource = computeAnimationResource();
        if (computeAnimationResource != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = computeAnimationResource;
            z = true;
        }
        int computeFlags = computeFlags(layoutParams.flags);
        if (computeFlags != layoutParams.flags) {
            layoutParams.flags = computeFlags;
            z = true;
        }
        if (z) {
            setLayoutDirectionFromAnchor();
            this.mWindowManager.updateViewLayout(this.mPopupView, layoutParams);
        }
    }

    public void update(int i, int i2) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        update(layoutParams.x, layoutParams.y, i, i2, false);
    }

    public void update(int i, int i2, int i3, int i4) {
        update(i, i2, i3, i4, false);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        if (i3 != -1) {
            this.mLastWidth = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.mLastHeight = i4;
            setHeight(i4);
        }
        if (!isShowing() || this.mContentView == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.mLastWidth;
        boolean z2 = z;
        if (i3 != -1) {
            z2 = z;
            if (layoutParams.width != i5) {
                this.mLastWidth = i5;
                layoutParams.width = i5;
                z2 = true;
            }
        }
        int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.mLastHeight;
        boolean z3 = z2;
        if (i4 != -1) {
            z3 = z2;
            if (layoutParams.height != i6) {
                this.mLastHeight = i6;
                layoutParams.height = i6;
                z3 = true;
            }
        }
        if (layoutParams.x != i) {
            layoutParams.x = i;
            z3 = true;
        }
        if (layoutParams.y != i2) {
            layoutParams.y = i2;
            z3 = true;
        }
        int computeAnimationResource = computeAnimationResource();
        if (computeAnimationResource != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = computeAnimationResource;
            z3 = true;
        }
        int computeFlags = computeFlags(layoutParams.flags);
        if (computeFlags != layoutParams.flags) {
            layoutParams.flags = computeFlags;
            z3 = true;
        }
        if (z3) {
            setLayoutDirectionFromAnchor();
            this.mWindowManager.updateViewLayout(this.mPopupView, layoutParams);
        }
    }

    public void update(View view, int i, int i2) {
        update(view, false, 0, 0, true, i, i2, this.mAnchoredGravity);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        update(view, true, i, i2, true, i3, i4, this.mAnchoredGravity);
    }
}
