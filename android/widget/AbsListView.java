package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.os.Trace;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.StateSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.RemoteViews;
import android.widget.RemoteViewsAdapter;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView.class */
public abstract class AbsListView extends AdapterView<ListAdapter> implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, ViewTreeObserver.OnTouchModeChangeListener, RemoteViewsAdapter.RemoteAdapterConnectionCallback {
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    private static final int INVALID_POINTER = -1;
    static final int LAYOUT_FORCE_BOTTOM = 3;
    static final int LAYOUT_FORCE_TOP = 1;
    static final int LAYOUT_MOVE_SELECTION = 6;
    static final int LAYOUT_NORMAL = 0;
    static final int LAYOUT_SET_SELECTION = 2;
    static final int LAYOUT_SPECIFIC = 4;
    static final int LAYOUT_SYNC = 5;
    static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    private static final boolean PROFILE_FLINGING = false;
    private static final boolean PROFILE_SCROLLING = false;
    private static final String TAG = "AbsListView";
    static final int TOUCH_MODE_DONE_WAITING = 2;
    static final int TOUCH_MODE_DOWN = 0;
    static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_OFF = 1;
    private static final int TOUCH_MODE_ON = 0;
    static final int TOUCH_MODE_OVERFLING = 6;
    static final int TOUCH_MODE_OVERSCROLL = 5;
    static final int TOUCH_MODE_REST = -1;
    static final int TOUCH_MODE_SCROLL = 3;
    static final int TOUCH_MODE_TAP = 1;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    static final Interpolator sLinearInterpolator = new LinearInterpolator();
    final Handler Inverse;
    private ListItemAccessibilityDelegate mAccessibilityDelegate;
    private int mActivePointerId;
    ListAdapter mAdapter;
    boolean mAdapterHasStableIds;
    private int mCacheColorHint;
    boolean mCachingActive;
    boolean mCachingStarted;
    SparseBooleanArray mCheckStates;
    LongSparseArray<Integer> mCheckedIdStates;
    int mCheckedItemCount;
    ActionMode mChoiceActionMode;
    int mChoiceMode;
    private Runnable mClearScrollingCache;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    AdapterDataSetObserver mDataSetObserver;
    private int mDecacheThreshold;
    private InputConnection mDefInputConnection;
    private boolean mDeferNotifyDataSetChanged;
    private float mDensityScale;
    private int mDirection;
    boolean mDrawSelectorOnTop;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private FastScroller mFastScroll;
    boolean mFastScrollAlwaysVisible;
    boolean mFastScrollEnabled;
    private int mFastScrollStyle;
    private boolean mFiltered;
    private int mFirstPositionDistanceGuess;
    private boolean mFlingProfilingStarted;
    private FlingRunnable mFlingRunnable;
    private StrictMode.Span mFlingStrictSpan;
    private boolean mForceTranscriptScroll;
    private boolean mGlobalLayoutListenerAddedFilter;
    private int mGlowPaddingLeft;
    private int mGlowPaddingRight;
    int mHeight;
    private boolean mIsChildViewEnabled;
    private boolean mIsDetaching;
    boolean mIsGridView;
    final boolean[] mIsScrap;
    boolean mIsScrolling;
    boolean mIsTap;
    boolean mIsWidget;
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private int mLastHandledItemCount;
    private int mLastPositionDistanceGuess;
    private int mLastScrollState;
    private int mLastTouchMode;
    int mLastY;
    int mLayoutMode;
    Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    int mMotionPosition;
    int mMotionViewNewTop;
    int mMotionViewOriginalTop;
    int mMotionX;
    int mMotionY;
    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    private int mNestedYOffset;
    private OnScrollListener mOnScrollListener;
    int mOverflingDistance;
    int mOverscrollDistance;
    int mOverscrollMax;
    private final Thread mOwnerThread;
    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private SavedState mPendingSync;
    private PerformClick mPerformClick;
    PopupWindow mPopup;
    private boolean mPopupHidden;
    Runnable mPositionScrollAfterLayout;
    AbsPositionScroller mPositionScroller;
    private InputConnectionWrapper mPublicInputConnection;
    final RecycleBin mRecycler;
    private RemoteViewsAdapter mRemoteAdapter;
    int mResurrectToPosition;
    private final int[] mScrollConsumed;
    View mScrollDown;
    private final int[] mScrollOffset;
    private boolean mScrollProfilingStarted;
    private StrictMode.Span mScrollStrictSpan;
    View mScrollUp;
    boolean mScrollingCacheEnabled;
    int mSelectedTop;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    int mSelectorPosition;
    Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    boolean mStackFromBottom;
    EditText mTextFilter;
    private boolean mTextFilterEnabled;
    private final float[] mTmpPoint;
    private Rect mTouchFrame;
    int mTouchMode;
    private Runnable mTouchModeReset;
    private int mTouchSlop;
    private int mTranscriptMode;
    private float mVelocityScale;
    private VelocityTracker mVelocityTracker;
    int mWidth;
    int mWidthMeasureSpec;
    int mvPosition;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$AbsPositionScroller.class */
    public static abstract class AbsPositionScroller {
        AbsPositionScroller() {
        }

        public abstract void start(int i);

        public abstract void start(int i, int i2);

        public abstract void startWithOffset(int i, int i2);

        public abstract void startWithOffset(int i, int i2, int i3);

        public abstract void stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$AdapterDataSetObserver.class */
    public class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AdapterDataSetObserver() {
            super();
        }

        @Override // android.widget.AdapterView.AdapterDataSetObserver, android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            if (AbsListView.this.mFastScroll != null) {
                AbsListView.this.mFastScroll.onSectionsChanged();
            }
        }

        @Override // android.widget.AdapterView.AdapterDataSetObserver, android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            if (AbsListView.this.mFastScroll != null) {
                AbsListView.this.mFastScroll.onSectionsChanged();
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$CheckForKeyLongPress.class */
    private class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        private CheckForKeyLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AbsListView.this.isPressed() || AbsListView.this.mSelectedPosition < 0) {
                return;
            }
            View childAt = AbsListView.this.getChildAt(AbsListView.this.mSelectedPosition - AbsListView.this.mFirstPosition);
            if (AbsListView.this.mDataChanged) {
                AbsListView.this.setPressed(false);
                if (childAt != null) {
                    childAt.setPressed(false);
                    return;
                }
                return;
            }
            boolean z = false;
            if (sameWindow()) {
                z = AbsListView.this.performLongPress(childAt, AbsListView.this.mSelectedPosition, AbsListView.this.mSelectedRowId);
            }
            if (z) {
                AbsListView.this.setPressed(false);
                childAt.setPressed(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$CheckForLongPress.class */
    public class CheckForLongPress extends WindowRunnnable implements Runnable {
        private CheckForLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt = AbsListView.this.getChildAt(AbsListView.this.mMotionPosition - AbsListView.this.mFirstPosition);
            if (childAt != null) {
                int i = AbsListView.this.mMotionPosition;
                long itemId = AbsListView.this.mAdapter.getItemId(AbsListView.this.mMotionPosition);
                boolean z = false;
                if (sameWindow()) {
                    z = false;
                    if (!AbsListView.this.mDataChanged) {
                        z = AbsListView.this.performLongPress(childAt, i, itemId);
                    }
                }
                if (!z) {
                    AbsListView.this.mTouchMode = 2;
                    return;
                }
                AbsListView.this.mTouchMode = -1;
                AbsListView.this.setPressed(false);
                childAt.setPressed(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$CheckForTap.class */
    public final class CheckForTap implements Runnable {
        float x;
        float y;

        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbsListView.this.mTouchMode == 0) {
                AbsListView.this.mTouchMode = 1;
                View childAt = AbsListView.this.getChildAt(AbsListView.this.mMotionPosition - AbsListView.this.mFirstPosition);
                if (childAt == null || childAt.hasFocusable()) {
                    return;
                }
                AbsListView.this.mLayoutMode = 0;
                if (AbsListView.this.mDataChanged) {
                    AbsListView.this.mTouchMode = 2;
                    return;
                }
                float[] fArr = AbsListView.this.mTmpPoint;
                fArr[0] = this.x;
                fArr[1] = this.y;
                AbsListView.this.transformPointToViewLocal(fArr, childAt);
                childAt.drawableHotspotChanged(fArr[0], fArr[1]);
                childAt.setPressed(true);
                AbsListView.this.setPressed(true);
                AbsListView.this.layoutChildren();
                AbsListView.this.positionSelector(AbsListView.this.mMotionPosition, childAt);
                AbsListView.this.refreshDrawableState();
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                boolean isLongClickable = AbsListView.this.isLongClickable();
                if (AbsListView.this.mSelector != null) {
                    Drawable current = AbsListView.this.mSelector.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(longPressTimeout);
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    AbsListView.this.mSelector.setHotspot(this.x, this.y);
                }
                if (!isLongClickable) {
                    AbsListView.this.mTouchMode = 2;
                    return;
                }
                if (AbsListView.this.mPendingCheckForLongPress == null) {
                    AbsListView.this.mPendingCheckForLongPress = new CheckForLongPress();
                }
                AbsListView.this.mPendingCheckForLongPress.rememberWindowAttachCount();
                AbsListView.this.postDelayed(AbsListView.this.mPendingCheckForLongPress, longPressTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$FlingRunnable.class */
    public class FlingRunnable implements Runnable {
        private static final int FLYWHEEL_TIMEOUT = 40;
        private final Runnable mCheckFlywheel = new Runnable() { // from class: android.widget.AbsListView.FlingRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                int i = AbsListView.this.mActivePointerId;
                VelocityTracker velocityTracker = AbsListView.this.mVelocityTracker;
                OverScroller overScroller = FlingRunnable.this.mScroller;
                if (velocityTracker == null || i == -1) {
                    return;
                }
                velocityTracker.computeCurrentVelocity(1000, AbsListView.this.mMaximumVelocity);
                float f = -velocityTracker.getYVelocity(i);
                if (Math.abs(f) >= AbsListView.this.mMinimumVelocity && overScroller.isScrollingInDirection(0.0f, f)) {
                    AbsListView.this.postDelayed(this, 40L);
                    return;
                }
                FlingRunnable.this.endFling(false);
                AbsListView.this.mTouchMode = 3;
                AbsListView.this.reportScrollStateChange(1);
            }
        };
        private int mLastFlingY;
        private final OverScroller mScroller;

        FlingRunnable() {
            this.mScroller = new OverScroller(AbsListView.this.getContext());
        }

        void edgeReached(int i) {
            this.mScroller.notifyVerticalEdgeReached(AbsListView.this.mScrollY, 0, AbsListView.this.mOverflingDistance);
            int overScrollMode = AbsListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsListView.this.contentFits())) {
                AbsListView.this.mTouchMode = 6;
                int currVelocity = (int) this.mScroller.getCurrVelocity();
                if (i > 0) {
                    AbsListView.this.mEdgeGlowTop.onAbsorb(currVelocity);
                } else {
                    AbsListView.this.mEdgeGlowBottom.onAbsorb(currVelocity);
                }
            } else {
                AbsListView.this.mTouchMode = -1;
                if (AbsListView.this.mPositionScroller != null) {
                    AbsListView.this.mPositionScroller.stop();
                }
            }
            AbsListView.this.invalidate();
            AbsListView.this.postOnAnimation(this);
        }

        void endFling() {
            endFling(true);
        }

        void endFling(boolean z) {
            AbsListView.this.mTouchMode = -1;
            AbsListView.this.removeCallbacks(this);
            AbsListView.this.removeCallbacks(this.mCheckFlywheel);
            AbsListView.this.reportScrollStateChange(0);
            if (z) {
                AbsListView.this.clearScrollingCache();
            }
            this.mScroller.abortAnimation();
            if (AbsListView.this.mFlingStrictSpan != null) {
                AbsListView.this.mFlingStrictSpan.finish();
                AbsListView.this.mFlingStrictSpan = null;
            }
        }

        void flywheelTouch() {
            AbsListView.this.postDelayed(this.mCheckFlywheel, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            switch (AbsListView.this.mTouchMode) {
                case 3:
                    if (this.mScroller.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    endFling();
                    return;
                case 6:
                    OverScroller overScroller = this.mScroller;
                    if (!overScroller.computeScrollOffset()) {
                        endFling();
                        return;
                    }
                    int i = AbsListView.this.mScrollY;
                    int currY = overScroller.getCurrY();
                    if (!AbsListView.this.overScrollBy(0, currY - i, 0, i, 0, 0, 0, AbsListView.this.mOverflingDistance, false)) {
                        AbsListView.this.invalidate();
                        AbsListView.this.postOnAnimation(this);
                        return;
                    }
                    boolean z = i <= 0 && currY > 0;
                    boolean z2 = i >= 0 && currY < 0;
                    if (!z && !z2) {
                        startSpringback();
                        return;
                    }
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i2 = currVelocity;
                    if (z2) {
                        i2 = -currVelocity;
                    }
                    overScroller.abortAnimation();
                    start(i2);
                    return;
            }
            if (AbsListView.this.mDataChanged) {
                AbsListView.this.layoutChildren();
            }
            if (AbsListView.this.mItemCount == 0 || AbsListView.this.getChildCount() == 0) {
                endFling();
                return;
            }
            OverScroller overScroller2 = this.mScroller;
            boolean computeScrollOffset = overScroller2.computeScrollOffset();
            int currY2 = overScroller2.getCurrY();
            int i3 = this.mLastFlingY - currY2;
            if (i3 > 0) {
                AbsListView.this.mMotionPosition = AbsListView.this.mFirstPosition;
                AbsListView.this.mMotionViewOriginalTop = AbsListView.this.getChildAt(0).getTop();
                max = Math.min(((AbsListView.this.getHeight() - AbsListView.this.mPaddingBottom) - AbsListView.this.mPaddingTop) - 1, i3);
            } else {
                int childCount = AbsListView.this.getChildCount() - 1;
                AbsListView.this.mMotionPosition = AbsListView.this.mFirstPosition + childCount;
                AbsListView.this.mMotionViewOriginalTop = AbsListView.this.getChildAt(childCount).getTop();
                max = Math.max(-(((AbsListView.this.getHeight() - AbsListView.this.mPaddingBottom) - AbsListView.this.mPaddingTop) - 1), i3);
            }
            View childAt = AbsListView.this.getChildAt(AbsListView.this.mMotionPosition - AbsListView.this.mFirstPosition);
            int i4 = 0;
            if (childAt != null) {
                i4 = childAt.getTop();
            }
            boolean trackMotionScroll = AbsListView.this.trackMotionScroll(max, max);
            boolean z3 = trackMotionScroll && max != 0;
            if (z3) {
                if (childAt != null) {
                    AbsListView.this.overScrollBy(0, -(max - (childAt.getTop() - i4)), 0, AbsListView.this.mScrollY, 0, 0, 0, AbsListView.this.mOverflingDistance, false);
                }
                if (computeScrollOffset) {
                    edgeReached(max);
                }
            } else if (!computeScrollOffset || z3) {
                endFling();
            } else {
                if (trackMotionScroll) {
                    AbsListView.this.invalidate();
                }
                this.mLastFlingY = currY2;
                AbsListView.this.postOnAnimation(this);
            }
        }

        void start(int i) {
            if (Math.abs(i) > AbsListView.this.mDecacheThreshold) {
                AbsListView.this.clearScrollingCache();
            }
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingY = i2;
            this.mScroller.setInterpolator(null);
            this.mScroller.fling(0, i2, 0, i, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsListView.this.mTouchMode = 4;
            AbsListView.this.postOnAnimation(this);
            if (AbsListView.this.mFlingStrictSpan == null) {
                AbsListView.this.mFlingStrictSpan = StrictMode.enterCriticalSpan("AbsListView-fling");
            }
        }

        void startOverfling(int i) {
            this.mScroller.setInterpolator(null);
            this.mScroller.fling(0, AbsListView.this.mScrollY, 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, AbsListView.this.getHeight());
            AbsListView.this.mTouchMode = 6;
            AbsListView.this.invalidate();
            AbsListView.this.postOnAnimation(this);
        }

        void startScroll(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingY = i3;
            this.mScroller.setInterpolator(z ? AbsListView.sLinearInterpolator : null);
            this.mScroller.startScroll(0, i3, 0, i, i2);
            AbsListView.this.mTouchMode = 4;
            AbsListView.this.postOnAnimation(this);
        }

        void startSpringback() {
            if (!this.mScroller.springBack(0, AbsListView.this.mScrollY, 0, 0, 0, 0)) {
                AbsListView.this.mTouchMode = -1;
                AbsListView.this.reportScrollStateChange(0);
                return;
            }
            AbsListView.this.mTouchMode = 6;
            AbsListView.this.invalidate();
            AbsListView.this.postOnAnimation(this);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$InputConnectionWrapper.class */
    private class InputConnectionWrapper implements InputConnection {
        private final EditorInfo mOutAttrs;
        private InputConnection mTarget;

        public InputConnectionWrapper(EditorInfo editorInfo) {
            this.mOutAttrs = editorInfo;
        }

        private InputConnection getTarget() {
            if (this.mTarget == null) {
                this.mTarget = AbsListView.this.getTextFilterInput().onCreateInputConnection(this.mOutAttrs);
            }
            return this.mTarget;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean beginBatchEdit() {
            return getTarget().beginBatchEdit();
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean clearMetaKeyStates(int i) {
            return getTarget().clearMetaKeyStates(i);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean commitCompletion(CompletionInfo completionInfo) {
            return getTarget().commitCompletion(completionInfo);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean commitCorrection(CorrectionInfo correctionInfo) {
            return getTarget().commitCorrection(correctionInfo);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i) {
            return getTarget().commitText(charSequence, i);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return getTarget().deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean endBatchEdit() {
            return getTarget().endBatchEdit();
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean finishComposingText() {
            return this.mTarget == null || this.mTarget.finishComposingText();
        }

        @Override // android.view.inputmethod.InputConnection
        public int getCursorCapsMode(int i) {
            if (this.mTarget == null) {
                return 16384;
            }
            return this.mTarget.getCursorCapsMode(i);
        }

        @Override // android.view.inputmethod.InputConnection
        public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
            return getTarget().getExtractedText(extractedTextRequest, i);
        }

        @Override // android.view.inputmethod.InputConnection
        public CharSequence getSelectedText(int i) {
            return this.mTarget == null ? "" : this.mTarget.getSelectedText(i);
        }

        @Override // android.view.inputmethod.InputConnection
        public CharSequence getTextAfterCursor(int i, int i2) {
            return this.mTarget == null ? "" : this.mTarget.getTextAfterCursor(i, i2);
        }

        @Override // android.view.inputmethod.InputConnection
        public CharSequence getTextBeforeCursor(int i, int i2) {
            return this.mTarget == null ? "" : this.mTarget.getTextBeforeCursor(i, i2);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean performContextMenuAction(int i) {
            return getTarget().performContextMenuAction(i);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean performEditorAction(int i) {
            boolean z = false;
            if (i == 6) {
                InputMethodManager inputMethodManager = (InputMethodManager) AbsListView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(AbsListView.this.getWindowToken(), 0);
                }
                z = true;
            }
            return z;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            return getTarget().performPrivateCommand(str, bundle);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean reportFullscreenMode(boolean z) {
            return AbsListView.this.mDefInputConnection.reportFullscreenMode(z);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean requestCursorUpdates(int i) {
            return getTarget().requestCursorUpdates(i);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            return AbsListView.this.mDefInputConnection.sendKeyEvent(keyEvent);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean setComposingRegion(int i, int i2) {
            return getTarget().setComposingRegion(i, i2);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean setComposingText(CharSequence charSequence, int i) {
            return getTarget().setComposingText(charSequence, i);
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean setSelection(int i, int i2) {
            return getTarget().setSelection(i, i2);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @ViewDebug.ExportedProperty(category = "list")
        boolean forceAdd;
        long itemId;
        @ViewDebug.ExportedProperty(category = "list")
        boolean recycledHeaderFooter;
        int scrappedFromPosition;
        @ViewDebug.ExportedProperty(category = "list", mapping = {@ViewDebug.IntToString(from = -1, to = "ITEM_VIEW_TYPE_IGNORE"), @ViewDebug.IntToString(from = -2, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")})
        int viewType;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.itemId = -1L;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.itemId = -1L;
            this.viewType = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.itemId = -1L;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.itemId = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$ListItemAccessibilityDelegate.class */
    public class ListItemAccessibilityDelegate extends View.AccessibilityDelegate {
        ListItemAccessibilityDelegate() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeInfo createAccessibilityNodeInfo(View view) {
            if (AbsListView.this.mDataChanged) {
                return null;
            }
            return super.createAccessibilityNodeInfo(view);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AbsListView.this.onInitializeAccessibilityNodeInfoForItem(view, AbsListView.this.getPositionForView(view), accessibilityNodeInfo);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            int positionForView = AbsListView.this.getPositionForView(view);
            ListAdapter adapter = AbsListView.this.getAdapter();
            if (positionForView == -1 || adapter == null || !AbsListView.this.isEnabled() || !adapter.isEnabled(positionForView)) {
                return false;
            }
            long itemIdAtPosition = AbsListView.this.getItemIdAtPosition(positionForView);
            switch (i) {
                case 4:
                    if (AbsListView.this.getSelectedItemPosition() != positionForView) {
                        AbsListView.this.setSelection(positionForView);
                        return true;
                    }
                    return false;
                case 8:
                    if (AbsListView.this.getSelectedItemPosition() == positionForView) {
                        AbsListView.this.setSelection(-1);
                        return true;
                    }
                    return false;
                case 16:
                    if (AbsListView.this.isClickable()) {
                        return AbsListView.this.performItemClick(view, positionForView, itemIdAtPosition);
                    }
                    return false;
                case 32:
                    if (AbsListView.this.isLongClickable()) {
                        return AbsListView.this.performLongPress(view, positionForView, itemIdAtPosition);
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$MultiChoiceModeListener.class */
    public interface MultiChoiceModeListener extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$MultiChoiceModeWrapper.class */
    public class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        private MultiChoiceModeListener mWrapped;

        MultiChoiceModeWrapper() {
        }

        public boolean hasWrappedCallback() {
            return this.mWrapped != null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            boolean z = false;
            if (this.mWrapped.onCreateActionMode(actionMode, menu)) {
                AbsListView.this.setLongClickable(false);
                z = true;
            }
            return z;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            AbsListView.this.mChoiceActionMode = null;
            AbsListView.this.clearChoices();
            AbsListView.this.mDataChanged = true;
            AbsListView.this.rememberSyncState();
            AbsListView.this.requestLayout();
            AbsListView.this.setLongClickable(true);
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            this.mWrapped.onItemCheckedStateChanged(actionMode, i, j, z);
            if (AbsListView.this.getCheckedItemCount() == 0) {
                actionMode.finish();
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }

        public void setWrapped(MultiChoiceModeListener multiChoiceModeListener) {
            this.mWrapped = multiChoiceModeListener;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$OnScrollListener.class */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScroll(AbsListView absListView, int i, int i2, int i3);

        void onScrollStateChanged(AbsListView absListView, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$PerformClick.class */
    public class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;

        private PerformClick() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (AbsListView.this.mDataChanged) {
                return;
            }
            ListAdapter listAdapter = AbsListView.this.mAdapter;
            int i = this.mClickMotionPosition;
            if (listAdapter == null || AbsListView.this.mItemCount <= 0 || i == -1 || i >= listAdapter.getCount() || !sameWindow() || (childAt = AbsListView.this.getChildAt(i - AbsListView.this.mFirstPosition)) == null) {
                return;
            }
            AbsListView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$PositionScroller.class */
    public class PositionScroller extends AbsPositionScroller implements Runnable {
        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_OFFSET = 5;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_UP_POS = 2;
        private static final int SCROLL_DURATION = 200;
        private int mBoundPos;
        private final int mExtraScroll;
        private int mLastSeenPos;
        private int mMode;
        private int mOffsetFromTop;
        private int mScrollDuration;
        private int mTargetPos;

        PositionScroller() {
            this.mExtraScroll = ViewConfiguration.get(AbsListView.this.mContext).getScaledFadingEdgeLength();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0081, code lost:
            if (r6 > r0) goto L33;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void scrollToVisible(int r5, int r6, int r7) {
            /*
                Method dump skipped, instructions count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.AbsListView.PositionScroller.scrollToVisible(int, int, int):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            int top;
            int height = AbsListView.this.getHeight();
            int i = AbsListView.this.mFirstPosition;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsListView.this.getChildCount() - 1;
                    int i2 = i + childCount;
                    if (childCount >= 0) {
                        if (i2 == this.mLastSeenPos) {
                            AbsListView.this.postOnAnimation(this);
                            return;
                        }
                        View childAt = AbsListView.this.getChildAt(childCount);
                        AbsListView.this.smoothScrollBy((childAt.getHeight() - (height - childAt.getTop())) + (i2 < AbsListView.this.mItemCount - 1 ? Math.max(AbsListView.this.mListPadding.bottom, this.mExtraScroll) : AbsListView.this.mListPadding.bottom), this.mScrollDuration, true);
                        this.mLastSeenPos = i2;
                        if (i2 < this.mTargetPos) {
                            AbsListView.this.postOnAnimation(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i == this.mLastSeenPos) {
                        AbsListView.this.postOnAnimation(this);
                        return;
                    }
                    View childAt2 = AbsListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsListView.this.smoothScrollBy(childAt2.getTop() - (i > 0 ? Math.max(this.mExtraScroll, AbsListView.this.mListPadding.top) : AbsListView.this.mListPadding.top), this.mScrollDuration, true);
                        this.mLastSeenPos = i;
                        if (i > this.mTargetPos) {
                            AbsListView.this.postOnAnimation(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsListView.this.getChildCount();
                    if (i == this.mBoundPos || childCount2 <= 1 || i + childCount2 >= AbsListView.this.mItemCount) {
                        return;
                    }
                    int i3 = i + 1;
                    if (i3 == this.mLastSeenPos) {
                        AbsListView.this.postOnAnimation(this);
                        return;
                    }
                    View childAt3 = AbsListView.this.getChildAt(1);
                    int height2 = childAt3.getHeight();
                    int top2 = childAt3.getTop();
                    int max = Math.max(AbsListView.this.mListPadding.bottom, this.mExtraScroll);
                    if (i3 < this.mBoundPos) {
                        AbsListView.this.smoothScrollBy(Math.max(0, (height2 + top2) - max), this.mScrollDuration, true);
                        this.mLastSeenPos = i3;
                        AbsListView.this.postOnAnimation(this);
                        return;
                    } else if (top2 > max) {
                        AbsListView.this.smoothScrollBy(top2 - max, this.mScrollDuration, true);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    int childCount3 = AbsListView.this.getChildCount() - 2;
                    if (childCount3 >= 0) {
                        int i4 = i + childCount3;
                        if (i4 == this.mLastSeenPos) {
                            AbsListView.this.postOnAnimation(this);
                            return;
                        }
                        View childAt4 = AbsListView.this.getChildAt(childCount3);
                        int height3 = childAt4.getHeight();
                        int top3 = childAt4.getTop();
                        int max2 = Math.max(AbsListView.this.mListPadding.top, this.mExtraScroll);
                        this.mLastSeenPos = i4;
                        if (i4 > this.mBoundPos) {
                            AbsListView.this.smoothScrollBy(-((height - top3) - max2), this.mScrollDuration, true);
                            AbsListView.this.postOnAnimation(this);
                            return;
                        }
                        int i5 = height - max2;
                        int i6 = top3 + height3;
                        if (i5 > i6) {
                            AbsListView.this.smoothScrollBy(-(i5 - i6), this.mScrollDuration, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.mLastSeenPos == i) {
                        AbsListView.this.postOnAnimation(this);
                        return;
                    }
                    this.mLastSeenPos = i;
                    int childCount4 = AbsListView.this.getChildCount();
                    int i7 = this.mTargetPos;
                    int i8 = (i + childCount4) - 1;
                    int i9 = 0;
                    if (i7 < i) {
                        i9 = (i - i7) + 1;
                    } else if (i7 > i8) {
                        i9 = i7 - i8;
                    }
                    float min = Math.min(Math.abs(i9 / childCount4), 1.0f);
                    if (i7 < i) {
                        AbsListView.this.smoothScrollBy((int) ((-AbsListView.this.getHeight()) * min), (int) (this.mScrollDuration * min), true);
                        AbsListView.this.postOnAnimation(this);
                        return;
                    } else if (i7 > i8) {
                        AbsListView.this.smoothScrollBy((int) (AbsListView.this.getHeight() * min), (int) (this.mScrollDuration * min), true);
                        AbsListView.this.postOnAnimation(this);
                        return;
                    } else {
                        AbsListView.this.smoothScrollBy(AbsListView.this.getChildAt(i7 - i).getTop() - this.mOffsetFromTop, (int) (this.mScrollDuration * (Math.abs(top) / AbsListView.this.getHeight())), true);
                        return;
                    }
                default:
                    return;
            }
        }

        @Override // android.widget.AbsListView.AbsPositionScroller
        public void start(final int i) {
            int i2;
            stop();
            if (AbsListView.this.mDataChanged) {
                AbsListView.this.mPositionScrollAfterLayout = new Runnable() { // from class: android.widget.AbsListView.PositionScroller.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PositionScroller.this.start(i);
                    }
                };
                return;
            }
            int childCount = AbsListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsListView.this.mFirstPosition;
                int i4 = (i3 + childCount) - 1;
                int max = Math.max(0, Math.min(AbsListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max <= i4) {
                    scrollToVisible(max, -1, 200);
                    return;
                } else {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                }
                if (i2 > 0) {
                    this.mScrollDuration = 200 / i2;
                } else {
                    this.mScrollDuration = 200;
                }
                this.mTargetPos = max;
                this.mBoundPos = -1;
                this.mLastSeenPos = -1;
                AbsListView.this.postOnAnimation(this);
            }
        }

        @Override // android.widget.AbsListView.AbsPositionScroller
        public void start(final int i, final int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                start(i);
            } else if (AbsListView.this.mDataChanged) {
                AbsListView.this.mPositionScrollAfterLayout = new Runnable() { // from class: android.widget.AbsListView.PositionScroller.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PositionScroller.this.start(i, i2);
                    }
                };
            } else {
                int childCount = AbsListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsListView.this.mFirstPosition;
                    int i5 = (i4 + childCount) - 1;
                    int max = Math.max(0, Math.min(AbsListView.this.getCount() - 1, i));
                    if (max < i4) {
                        int i6 = i5 - i2;
                        if (i6 < 1) {
                            return;
                        }
                        i3 = (i4 - max) + 1;
                        int i7 = i6 - 1;
                        if (i7 < i3) {
                            i3 = i7;
                            this.mMode = 4;
                        } else {
                            this.mMode = 2;
                        }
                    } else if (max <= i5) {
                        scrollToVisible(max, i2, 200);
                        return;
                    } else {
                        int i8 = i2 - i4;
                        if (i8 < 1) {
                            return;
                        }
                        i3 = (max - i5) + 1;
                        int i9 = i8 - 1;
                        if (i9 < i3) {
                            i3 = i9;
                            this.mMode = 3;
                        } else {
                            this.mMode = 1;
                        }
                    }
                    if (i3 > 0) {
                        this.mScrollDuration = 200 / i3;
                    } else {
                        this.mScrollDuration = 200;
                    }
                    this.mTargetPos = max;
                    this.mBoundPos = i2;
                    this.mLastSeenPos = -1;
                    AbsListView.this.postOnAnimation(this);
                }
            }
        }

        @Override // android.widget.AbsListView.AbsPositionScroller
        public void startWithOffset(int i, int i2) {
            startWithOffset(i, i2, 200);
        }

        @Override // android.widget.AbsListView.AbsPositionScroller
        public void startWithOffset(final int i, final int i2, final int i3) {
            int i4;
            stop();
            if (AbsListView.this.mDataChanged) {
                AbsListView.this.mPositionScrollAfterLayout = new Runnable() { // from class: android.widget.AbsListView.PositionScroller.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PositionScroller.this.startWithOffset(i, i2, i3);
                    }
                };
                return;
            }
            int childCount = AbsListView.this.getChildCount();
            if (childCount != 0) {
                int paddingTop = i2 + AbsListView.this.getPaddingTop();
                this.mTargetPos = Math.max(0, Math.min(AbsListView.this.getCount() - 1, i));
                this.mOffsetFromTop = paddingTop;
                this.mBoundPos = -1;
                this.mLastSeenPos = -1;
                this.mMode = 5;
                int i5 = AbsListView.this.mFirstPosition;
                int i6 = (i5 + childCount) - 1;
                if (this.mTargetPos < i5) {
                    i4 = i5 - this.mTargetPos;
                } else if (this.mTargetPos <= i6) {
                    AbsListView.this.smoothScrollBy(AbsListView.this.getChildAt(this.mTargetPos - i5).getTop() - paddingTop, i3, true);
                    return;
                } else {
                    i4 = this.mTargetPos - i6;
                }
                float f = i4 / childCount;
                if (f >= 1.0f) {
                    i3 = (int) (i3 / f);
                }
                this.mScrollDuration = i3;
                this.mLastSeenPos = -1;
                AbsListView.this.postOnAnimation(this);
            }
        }

        @Override // android.widget.AbsListView.AbsPositionScroller
        public void stop() {
            AbsListView.this.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$RecycleBin.class */
    public class RecycleBin {
        private View[] mActiveViews = new View[0];
        private ArrayList<View> mCurrentScrap;
        private int mFirstActivePosition;
        private RecyclerListener mRecyclerListener;
        private ArrayList<View>[] mScrapViews;
        private ArrayList<View> mSkippedScrap;
        private SparseArray<View> mTransientStateViews;
        private LongSparseArray<View> mTransientStateViewsById;
        private int mViewTypeCount;

        RecycleBin() {
        }

        private void clearAccessibilityFromScrap(View view) {
            view.clearAccessibilityFocus();
            view.setAccessibilityDelegate(null);
        }

        private void clearScrap(ArrayList<View> arrayList) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                removeDetachedView(arrayList.remove((size - 1) - i2), false);
                i = i2 + 1;
            }
        }

        private void pruneScrapViews() {
            int length = this.mActiveViews.length;
            int i = this.mViewTypeCount;
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                ArrayList<View> arrayList = arrayListArr[i3];
                int size = arrayList.size();
                int i4 = 0;
                int i5 = size;
                while (true) {
                    int i6 = i5 - 1;
                    if (i4 < size - length) {
                        removeDetachedView(arrayList.remove(i6), false);
                        i4++;
                        i5 = i6;
                    }
                }
                i2 = i3 + 1;
            }
            SparseArray<View> sparseArray = this.mTransientStateViews;
            if (sparseArray != null) {
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= sparseArray.size()) {
                        break;
                    }
                    View valueAt = sparseArray.valueAt(i8);
                    int i9 = i8;
                    if (!valueAt.hasTransientState()) {
                        removeDetachedView(valueAt, false);
                        sparseArray.removeAt(i8);
                        i9 = i8 - 1;
                    }
                    i7 = i9 + 1;
                }
            }
            LongSparseArray<View> longSparseArray = this.mTransientStateViewsById;
            if (longSparseArray == null) {
                return;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= longSparseArray.size()) {
                    return;
                }
                View valueAt2 = longSparseArray.valueAt(i11);
                int i12 = i11;
                if (!valueAt2.hasTransientState()) {
                    removeDetachedView(valueAt2, false);
                    longSparseArray.removeAt(i11);
                    i12 = i11 - 1;
                }
                i10 = i12 + 1;
            }
        }

        private void removeDetachedView(View view, boolean z) {
            view.setAccessibilityDelegate(null);
            AbsListView.this.removeDetachedView(view, z);
        }

        private View retrieveFromScrap(ArrayList<View> arrayList, int i) {
            int size = arrayList.size();
            if (size <= 0) {
                return null;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    View remove = arrayList.remove(size - 1);
                    clearAccessibilityFromScrap(remove);
                    return remove;
                }
                LayoutParams layoutParams = (LayoutParams) arrayList.get(i3).getLayoutParams();
                if (AbsListView.this.mAdapterHasStableIds) {
                    if (AbsListView.this.mAdapter.getItemId(i) == layoutParams.itemId) {
                        return arrayList.remove(i3);
                    }
                } else if (layoutParams.scrappedFromPosition == i) {
                    View remove2 = arrayList.remove(i3);
                    clearAccessibilityFromScrap(remove2);
                    return remove2;
                }
                i2 = i3 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addScrapView(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.scrappedFromPosition = i;
            int i2 = layoutParams.viewType;
            if (shouldRecycleViewType(i2)) {
                view.dispatchStartTemporaryDetach();
                AbsListView.this.notifyViewAccessibilityStateChangedIfNeeded(1);
                if (!view.hasTransientState()) {
                    if (this.mViewTypeCount == 1) {
                        this.mCurrentScrap.add(view);
                    } else {
                        this.mScrapViews[i2].add(view);
                    }
                    if (this.mRecyclerListener != null) {
                        this.mRecyclerListener.onMovedToScrapHeap(view);
                    }
                } else if (AbsListView.this.mAdapter != null && AbsListView.this.mAdapterHasStableIds) {
                    if (this.mTransientStateViewsById == null) {
                        this.mTransientStateViewsById = new LongSparseArray<>();
                    }
                    this.mTransientStateViewsById.put(layoutParams.itemId, view);
                } else if (AbsListView.this.mDataChanged) {
                    if (this.mSkippedScrap == null) {
                        this.mSkippedScrap = new ArrayList<>();
                    }
                    this.mSkippedScrap.add(view);
                } else {
                    if (this.mTransientStateViews == null) {
                        this.mTransientStateViews = new SparseArray<>();
                    }
                    this.mTransientStateViews.put(i, view);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            if (this.mViewTypeCount != 1) {
                int i = this.mViewTypeCount;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        break;
                    }
                    clearScrap(this.mScrapViews[i3]);
                    i2 = i3 + 1;
                }
            } else {
                clearScrap(this.mCurrentScrap);
            }
            clearTransientStateViews();
        }

        void clearTransientStateViews() {
            SparseArray<View> sparseArray = this.mTransientStateViews;
            if (sparseArray != null) {
                int size = sparseArray.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    removeDetachedView(sparseArray.valueAt(i2), false);
                    i = i2 + 1;
                }
                sparseArray.clear();
            }
            LongSparseArray<View> longSparseArray = this.mTransientStateViewsById;
            if (longSparseArray == null) {
                return;
            }
            int size2 = longSparseArray.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    longSparseArray.clear();
                    return;
                } else {
                    removeDetachedView(longSparseArray.valueAt(i4), false);
                    i3 = i4 + 1;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void fillActiveViews(int i, int i2) {
            if (this.mActiveViews.length < i) {
                this.mActiveViews = new View[i];
            }
            this.mFirstActivePosition = i2;
            View[] viewArr = this.mActiveViews;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i) {
                    return;
                }
                View childAt = AbsListView.this.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.viewType != -2) {
                    viewArr[i4] = childAt;
                    layoutParams.scrappedFromPosition = i2 + i4;
                }
                i3 = i4 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View getActiveView(int i) {
            int i2 = i - this.mFirstActivePosition;
            View[] viewArr = this.mActiveViews;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View getScrapView(int i) {
            if (this.mViewTypeCount == 1) {
                return retrieveFromScrap(this.mCurrentScrap, i);
            }
            int itemViewType = AbsListView.this.mAdapter.getItemViewType(i);
            if (itemViewType < 0 || itemViewType >= this.mScrapViews.length) {
                return null;
            }
            return retrieveFromScrap(this.mScrapViews[itemViewType], i);
        }

        View getTransientStateView(int i) {
            int indexOfKey;
            if (AbsListView.this.mAdapter != null && AbsListView.this.mAdapterHasStableIds && this.mTransientStateViewsById != null) {
                long itemId = AbsListView.this.mAdapter.getItemId(i);
                View view = this.mTransientStateViewsById.get(itemId);
                this.mTransientStateViewsById.remove(itemId);
                return view;
            } else if (this.mTransientStateViews == null || (indexOfKey = this.mTransientStateViews.indexOfKey(i)) < 0) {
                return null;
            } else {
                View valueAt = this.mTransientStateViews.valueAt(indexOfKey);
                this.mTransientStateViews.removeAt(indexOfKey);
                return valueAt;
            }
        }

        public void markChildrenDirty() {
            if (this.mViewTypeCount != 1) {
                int i = this.mViewTypeCount;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        break;
                    }
                    ArrayList<View> arrayList = this.mScrapViews[i3];
                    int size = arrayList.size();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < size) {
                            arrayList.get(i5).forceLayout();
                            i4 = i5 + 1;
                        }
                    }
                    i2 = i3 + 1;
                }
            } else {
                ArrayList<View> arrayList2 = this.mCurrentScrap;
                int size2 = arrayList2.size();
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= size2) {
                        break;
                    }
                    arrayList2.get(i7).forceLayout();
                    i6 = i7 + 1;
                }
            }
            if (this.mTransientStateViews != null) {
                int size3 = this.mTransientStateViews.size();
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i9 >= size3) {
                        break;
                    }
                    this.mTransientStateViews.valueAt(i9).forceLayout();
                    i8 = i9 + 1;
                }
            }
            if (this.mTransientStateViewsById == null) {
                return;
            }
            int size4 = this.mTransientStateViewsById.size();
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= size4) {
                    return;
                }
                this.mTransientStateViewsById.valueAt(i11).forceLayout();
                i10 = i11 + 1;
            }
        }

        void reclaimScrapViews(List<View> list) {
            if (this.mViewTypeCount == 1) {
                list.addAll(this.mCurrentScrap);
                return;
            }
            int i = this.mViewTypeCount;
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return;
                }
                list.addAll(arrayListArr[i3]);
                i2 = i3 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void removeSkippedScrap() {
            if (this.mSkippedScrap == null) {
                return;
            }
            int size = this.mSkippedScrap.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.mSkippedScrap.clear();
                    return;
                } else {
                    removeDetachedView(this.mSkippedScrap.get(i2), false);
                    i = i2 + 1;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void scrapActiveViews() {
            View[] viewArr = this.mActiveViews;
            boolean z = this.mRecyclerListener != null;
            boolean z2 = this.mViewTypeCount > 1;
            ArrayList<View> arrayList = this.mCurrentScrap;
            int length = viewArr.length - 1;
            while (length >= 0) {
                View view = viewArr[length];
                ArrayList<View> arrayList2 = arrayList;
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i = layoutParams.viewType;
                    viewArr[length] = null;
                    if (view.hasTransientState()) {
                        view.dispatchStartTemporaryDetach();
                        if (AbsListView.this.mAdapter != null && AbsListView.this.mAdapterHasStableIds) {
                            if (this.mTransientStateViewsById == null) {
                                this.mTransientStateViewsById = new LongSparseArray<>();
                            }
                            this.mTransientStateViewsById.put(AbsListView.this.mAdapter.getItemId(this.mFirstActivePosition + length), view);
                            arrayList2 = arrayList;
                        } else if (AbsListView.this.mDataChanged) {
                            arrayList2 = arrayList;
                            if (i != -2) {
                                removeDetachedView(view, false);
                                arrayList2 = arrayList;
                            }
                        } else {
                            if (this.mTransientStateViews == null) {
                                this.mTransientStateViews = new SparseArray<>();
                            }
                            this.mTransientStateViews.put(this.mFirstActivePosition + length, view);
                            arrayList2 = arrayList;
                        }
                    } else if (shouldRecycleViewType(i)) {
                        if (z2) {
                            arrayList = this.mScrapViews[i];
                        }
                        view.dispatchStartTemporaryDetach();
                        layoutParams.scrappedFromPosition = this.mFirstActivePosition + length;
                        arrayList.add(view);
                        arrayList2 = arrayList;
                        if (z) {
                            this.mRecyclerListener.onMovedToScrapHeap(view);
                            arrayList2 = arrayList;
                        }
                    } else {
                        arrayList2 = arrayList;
                        if (i != -2) {
                            removeDetachedView(view, false);
                            arrayList2 = arrayList;
                        }
                    }
                }
                length--;
                arrayList = arrayList2;
            }
            pruneScrapViews();
        }

        void setCacheColorHint(int i) {
            if (this.mViewTypeCount != 1) {
                int i2 = this.mViewTypeCount;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= i2) {
                        break;
                    }
                    ArrayList<View> arrayList = this.mScrapViews[i4];
                    int size = arrayList.size();
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < size) {
                            arrayList.get(i6).setDrawingCacheBackgroundColor(i);
                            i5 = i6 + 1;
                        }
                    }
                    i3 = i4 + 1;
                }
            } else {
                ArrayList<View> arrayList2 = this.mCurrentScrap;
                int size2 = arrayList2.size();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= size2) {
                        break;
                    }
                    arrayList2.get(i8).setDrawingCacheBackgroundColor(i);
                    i7 = i8 + 1;
                }
            }
            View[] viewArr = this.mActiveViews;
            int length = viewArr.length;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= length) {
                    return;
                }
                View view = viewArr[i10];
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i);
                }
                i9 = i10 + 1;
            }
        }

        public void setViewTypeCount(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.mViewTypeCount = i;
                    this.mCurrentScrap = arrayListArr[0];
                    this.mScrapViews = arrayListArr;
                    return;
                }
                arrayListArr[i3] = new ArrayList<>();
                i2 = i3 + 1;
            }
        }

        public boolean shouldRecycleViewType(int i) {
            return i >= 0;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$RecyclerListener.class */
    public interface RecyclerListener {
        void onMovedToScrapHeap(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.AbsListView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        LongSparseArray<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        String filter;
        long firstId;
        int height;
        boolean inActionMode;
        int position;
        long selectedId;
        int viewTop;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.firstId = parcel.readLong();
            this.viewTop = parcel.readInt();
            this.position = parcel.readInt();
            this.height = parcel.readInt();
            this.filter = parcel.readString();
            this.inActionMode = parcel.readByte() != 0;
            this.checkedItemCount = parcel.readInt();
            this.checkState = parcel.readSparseBooleanArray();
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return;
            }
            this.checkIdState = new LongSparseArray<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return;
                }
                this.checkIdState.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i = i2 + 1;
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.firstId + " viewTop=" + this.viewTop + " position=" + this.position + " height=" + this.height + " filter=" + this.filter + " checkState=" + this.checkState + i.d;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeLong(this.firstId);
            parcel.writeInt(this.viewTop);
            parcel.writeInt(this.position);
            parcel.writeInt(this.height);
            parcel.writeString(this.filter);
            parcel.writeByte((byte) (this.inActionMode ? 1 : 0));
            parcel.writeInt(this.checkedItemCount);
            parcel.writeSparseBooleanArray(this.checkState);
            int size = this.checkIdState != null ? this.checkIdState.size() : 0;
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                parcel.writeLong(this.checkIdState.keyAt(i3));
                parcel.writeInt(this.checkIdState.valueAt(i3).intValue());
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$SelectionBoundsAdjuster.class */
    public interface SelectionBoundsAdjuster {
        void adjustListItemSelectionBounds(Rect rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsListView$WindowRunnnable.class */
    public class WindowRunnnable {
        private int mOriginalAttachCount;

        private WindowRunnnable() {
        }

        public void rememberWindowAttachCount() {
            this.mOriginalAttachCount = AbsListView.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return AbsListView.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }
    }

    public AbsListView(Context context) {
        super(context);
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDeferNotifyDataSetChanged = false;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new RecycleBin();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mWidthMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedTop = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mScrollProfilingStarted = false;
        this.mFlingProfilingStarted = false;
        this.mScrollStrictSpan = null;
        this.mFlingStrictSpan = null;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mTmpPoint = new float[2];
        this.mNestedYOffset = 0;
        this.mActivePointerId = -1;
        this.mDirection = 0;
        this.mHeight = 0;
        this.mIsTap = false;
        this.mIsGridView = false;
        this.Inverse = new Handler() { // from class: android.widget.AbsListView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AbsListView.this.mIsTap = !AbsListView.this.mIsTap;
            }
        };
        initAbsListView();
        this.mOwnerThread = Thread.currentThread();
        setVerticalScrollBarEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.View);
        initializeScrollbarsInternal(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public AbsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.absListViewStyle);
    }

    public AbsListView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AbsListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDeferNotifyDataSetChanged = false;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new RecycleBin();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mWidthMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedTop = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mScrollProfilingStarted = false;
        this.mFlingProfilingStarted = false;
        this.mScrollStrictSpan = null;
        this.mFlingStrictSpan = null;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mTmpPoint = new float[2];
        this.mNestedYOffset = 0;
        this.mActivePointerId = -1;
        this.mDirection = 0;
        this.mHeight = 0;
        this.mIsTap = false;
        this.mIsGridView = false;
        this.Inverse = new Handler() { // from class: android.widget.AbsListView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AbsListView.this.mIsTap = !AbsListView.this.mIsTap;
            }
        };
        initAbsListView();
        this.mOwnerThread = Thread.currentThread();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AbsListView, i, i2);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = obtainStyledAttributes.getBoolean(1, false);
        setStackFromBottom(obtainStyledAttributes.getBoolean(2, false));
        setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(3, true));
        setTextFilterEnabled(obtainStyledAttributes.getBoolean(4, false));
        setTranscriptMode(obtainStyledAttributes.getInt(5, 0));
        setCacheColorHint(obtainStyledAttributes.getColor(6, 0));
        setFastScrollEnabled(obtainStyledAttributes.getBoolean(8, false));
        setFastScrollStyle(obtainStyledAttributes.getResourceId(11, 0));
        setSmoothScrollbarEnabled(obtainStyledAttributes.getBoolean(9, true));
        setChoiceMode(obtainStyledAttributes.getInt(7, 0));
        setFastScrollAlwaysVisible(obtainStyledAttributes.getBoolean(10, false));
        obtainStyledAttributes.recycle();
    }

    private boolean acceptFilter() {
        return this.mTextFilterEnabled && (getAdapter() instanceof Filterable) && ((Filterable) getAdapter()).getFilter() != null;
    }

    private boolean canScrollDown() {
        int childCount = getChildCount();
        boolean z = this.mFirstPosition + childCount < this.mItemCount;
        boolean z2 = z;
        if (!z) {
            z2 = z;
            if (childCount > 0) {
                if (getChildAt(childCount - 1).getBottom() <= this.mBottom - this.mListPadding.bottom) {
                    return false;
                }
                z2 = true;
            }
        }
        return z2;
    }

    private boolean canScrollUp() {
        boolean z = this.mFirstPosition > 0;
        boolean z2 = z;
        if (!z) {
            z2 = z;
            if (getChildCount() > 0) {
                if (getChildAt(0).getTop() >= this.mListPadding.top) {
                    return false;
                }
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (isHardwareAccelerated()) {
            return;
        }
        if (this.mClearScrollingCache == null) {
            this.mClearScrollingCache = new Runnable() { // from class: android.widget.AbsListView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AbsListView.this.mCachingStarted) {
                        AbsListView absListView = AbsListView.this;
                        AbsListView.this.mCachingActive = false;
                        absListView.mCachingStarted = false;
                        AbsListView.this.setChildrenDrawnWithCacheEnabled(false);
                        if ((AbsListView.this.mPersistentDrawingCache & 2) == 0) {
                            AbsListView.this.setChildrenDrawingCacheEnabled(false);
                        }
                        if (AbsListView.this.isAlwaysDrawnWithCacheEnabled()) {
                            return;
                        }
                        AbsListView.this.invalidate();
                    }
                }
            };
        }
        post(this.mClearScrollingCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean contentFits() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        return childCount == this.mItemCount && getChildAt(0).getTop() >= this.mListPadding.top && getChildAt(childCount - 1).getBottom() <= getHeight() - this.mListPadding.bottom;
    }

    private void createScrollingCache() {
        if (!this.mScrollingCacheEnabled || this.mCachingStarted || isHardwareAccelerated()) {
            return;
        }
        setChildrenDrawnWithCacheEnabled(true);
        setChildrenDrawingCacheEnabled(true);
        this.mCachingActive = true;
        this.mCachingStarted = true;
    }

    private void createTextFilter(boolean z) {
        if (this.mPopup == null) {
            PopupWindow popupWindow = new PopupWindow(getContext());
            popupWindow.setFocusable(false);
            popupWindow.setTouchable(false);
            popupWindow.setInputMethodMode(2);
            popupWindow.setContentView(getTextFilterInput());
            popupWindow.setWidth(-2);
            popupWindow.setHeight(-2);
            popupWindow.setBackgroundDrawable(null);
            this.mPopup = popupWindow;
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.mGlobalLayoutListenerAddedFilter = true;
        }
        if (z) {
            this.mPopup.setAnimationStyle(R.style.Animation_TypingFilter);
        } else {
            this.mPopup.setAnimationStyle(R.style.Animation_TypingFilterRestore);
        }
    }

    private void dismissPopup() {
        if (this.mPopup != null) {
            this.mPopup.dismiss();
        }
    }

    private void drawSelector(Canvas canvas) {
        if (this.mSelectorRect.isEmpty()) {
            return;
        }
        Drawable drawable = this.mSelector;
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(canvas);
    }

    private void finishGlows() {
        if (this.mEdgeGlowTop != null) {
            this.mEdgeGlowTop.finish();
            this.mEdgeGlowBottom.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDistance(Rect rect, Rect rect2, int i) {
        int width;
        int height;
        int width2;
        int height2;
        switch (i) {
            case 1:
            case 2:
                width = rect.right + (rect.width() / 2);
                height = rect.top + (rect.height() / 2);
                width2 = rect2.left + (rect2.width() / 2);
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 17:
                width = rect.left;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.right;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 33:
                width = rect.left + (rect.width() / 2);
                height = rect.top;
                width2 = rect2.left + (rect2.width() / 2);
                height2 = rect2.bottom;
                break;
            case 66:
                width = rect.right;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 130:
                width = rect.left + (rect.width() / 2);
                height = rect.bottom;
                width2 = rect2.left + (rect2.width() / 2);
                height2 = rect2.top;
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        int i2 = width2 - width;
        int i3 = height2 - height;
        return (i3 * i3) + (i2 * i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getTextFilterInput() {
        if (this.mTextFilter == null) {
            this.mTextFilter = (EditText) LayoutInflater.from(getContext()).inflate(R.layout.typing_filter, (ViewGroup) null);
            this.mTextFilter.setRawInputType(177);
            this.mTextFilter.setImeOptions(268435456);
            this.mTextFilter.addTextChangedListener(this);
        }
        return this.mTextFilter;
    }

    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mContext);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mDecacheThreshold = this.mMaximumVelocity / 2;
        this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
        this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
        this.mDensityScale = getContext().getResources().getDisplayMetrics().density;
        setPersistentDrawingCache(3);
    }

    private void initOrResetVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOwnerThread() {
        return this.mOwnerThread == Thread.currentThread();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i = action == 0 ? 1 : 0;
            this.mMotionX = (int) motionEvent.getX(i);
            this.mMotionY = (int) motionEvent.getY(i);
            this.mMotionCorrection = 0;
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    private void onTouchCancel() {
        switch (this.mTouchMode) {
            case 5:
                if (this.mFlingRunnable == null) {
                    this.mFlingRunnable = new FlingRunnable();
                }
                this.mFlingRunnable.startSpringback();
                break;
            case 6:
                break;
            default:
                this.mTouchMode = -1;
                setPressed(false);
                View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                if (childAt != null) {
                    childAt.setPressed(false);
                }
                clearScrollingCache();
                removeCallbacks(this.mPendingCheckForLongPress);
                recycleVelocityTracker();
                break;
        }
        if (this.mEdgeGlowTop != null) {
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        this.mActivePointerId = -1;
    }

    private void onTouchDown(MotionEvent motionEvent) {
        this.mActivePointerId = motionEvent.getPointerId(0);
        if (this.mTouchMode == 6) {
            this.mFlingRunnable.endFling();
            if (this.mPositionScroller != null) {
                this.mPositionScroller.stop();
            }
            this.mTouchMode = 5;
            this.mMotionX = (int) motionEvent.getX();
            this.mMotionY = (int) motionEvent.getY();
            this.mLastY = this.mMotionY;
            this.mMotionCorrection = 0;
            this.mDirection = 0;
        } else {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int pointToPosition = pointToPosition(x, y);
            int i = pointToPosition;
            if (!this.mDataChanged) {
                if (this.mTouchMode == 4) {
                    createScrollingCache();
                    this.mTouchMode = 3;
                    this.mMotionCorrection = 0;
                    i = findMotionRow(y);
                    this.mFlingRunnable.flywheelTouch();
                } else {
                    i = pointToPosition;
                    if (pointToPosition >= 0) {
                        i = pointToPosition;
                        if (getAdapter().isEnabled(pointToPosition)) {
                            this.mTouchMode = 0;
                            if (this.mPendingCheckForTap == null) {
                                this.mPendingCheckForTap = new CheckForTap();
                            }
                            this.mPendingCheckForTap.x = motionEvent.getX();
                            this.mPendingCheckForTap.y = motionEvent.getY();
                            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                            i = pointToPosition;
                        }
                    }
                }
            }
            if (i >= 0) {
                this.mMotionViewOriginalTop = getChildAt(i - this.mFirstPosition).getTop();
            }
            this.mMotionX = x;
            this.mMotionY = y;
            this.mMotionPosition = i;
            this.mLastY = Integer.MIN_VALUE;
        }
        if (this.mTouchMode == 0 && this.mMotionPosition != -1 && performButtonActionOnTouchDown(motionEvent)) {
            removeCallbacks(this.mPendingCheckForTap);
        }
    }

    private void onTouchMove(MotionEvent motionEvent, MotionEvent motionEvent2) {
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        int i = findPointerIndex;
        if (findPointerIndex == -1) {
            i = 0;
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        if (this.mDataChanged) {
            layoutChildren();
        }
        int y = (int) motionEvent.getY(i);
        switch (this.mTouchMode) {
            case 0:
            case 1:
            case 2:
                if (startScrollIfNeeded((int) motionEvent.getX(i), y, motionEvent2)) {
                    return;
                }
                View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                float x = motionEvent.getX(i);
                if (!pointInView(x, y, this.mTouchSlop)) {
                    setPressed(false);
                    if (childAt != null) {
                        childAt.setPressed(false);
                    }
                    removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.mPendingCheckForLongPress);
                    this.mTouchMode = 2;
                    updateSelectorState();
                    return;
                } else if (childAt != null) {
                    float[] fArr = this.mTmpPoint;
                    fArr[0] = x;
                    fArr[1] = y;
                    transformPointToViewLocal(fArr, childAt);
                    childAt.drawableHotspotChanged(fArr[0], fArr[1]);
                    return;
                } else {
                    return;
                }
            case 3:
            case 5:
                scrollIfNeeded((int) motionEvent.getX(i), y, motionEvent2);
                return;
            case 4:
            default:
                return;
        }
    }

    private void onTouchUp(MotionEvent motionEvent) {
        switch (this.mTouchMode) {
            case 0:
            case 1:
            case 2:
                int i = this.mMotionPosition;
                final View childAt = getChildAt(i - this.mFirstPosition);
                if (childAt != null) {
                    if (this.mTouchMode != 0) {
                        childAt.setPressed(false);
                    }
                    float x = motionEvent.getX();
                    if ((x > ((float) this.mListPadding.left) && x < ((float) (getWidth() - this.mListPadding.right))) && !childAt.hasFocusable()) {
                        if (this.mPerformClick == null) {
                            this.mPerformClick = new PerformClick();
                        }
                        final PerformClick performClick = this.mPerformClick;
                        performClick.mClickMotionPosition = i;
                        performClick.rememberWindowAttachCount();
                        this.mResurrectToPosition = i;
                        if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                            removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.mPendingCheckForLongPress);
                            this.mLayoutMode = 0;
                            if (this.mDataChanged || !this.mAdapter.isEnabled(i)) {
                                this.mTouchMode = -1;
                                updateSelectorState();
                                return;
                            }
                            this.mTouchMode = 1;
                            setSelectedPositionInt(this.mMotionPosition);
                            layoutChildren();
                            childAt.setPressed(true);
                            positionSelector(this.mMotionPosition, childAt);
                            setPressed(true);
                            if (this.mSelector != null) {
                                Drawable current = this.mSelector.getCurrent();
                                if (current != null && (current instanceof TransitionDrawable)) {
                                    ((TransitionDrawable) current).resetTransition();
                                }
                                this.mSelector.setHotspot(x, motionEvent.getY());
                            }
                            if (this.mTouchModeReset != null) {
                                removeCallbacks(this.mTouchModeReset);
                            }
                            this.mTouchModeReset = new Runnable() { // from class: android.widget.AbsListView.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    AbsListView.this.mTouchModeReset = null;
                                    AbsListView.this.mTouchMode = -1;
                                    childAt.setPressed(false);
                                    AbsListView.this.setPressed(false);
                                    if (AbsListView.this.mDataChanged || AbsListView.this.mIsDetaching || !AbsListView.this.isAttachedToWindow()) {
                                        return;
                                    }
                                    performClick.run();
                                }
                            };
                            postDelayed(this.mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                            return;
                        } else if (!this.mDataChanged && this.mAdapter.isEnabled(i)) {
                            performClick.run();
                        }
                    }
                }
                this.mTouchMode = -1;
                updateSelectorState();
                break;
            case 3:
                int childCount = getChildCount();
                if (childCount <= 0) {
                    this.mTouchMode = -1;
                    reportScrollStateChange(0);
                    break;
                } else {
                    int top = getChildAt(0).getTop();
                    int bottom = getChildAt(childCount - 1).getBottom();
                    int i2 = this.mListPadding.top;
                    int height = getHeight() - this.mListPadding.bottom;
                    if (this.mFirstPosition == 0 && top >= i2 && this.mFirstPosition + childCount < this.mItemCount && bottom <= getHeight() - height) {
                        this.mTouchMode = -1;
                        reportScrollStateChange(0);
                        break;
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        int yVelocity = (int) (velocityTracker.getYVelocity(this.mActivePointerId) * this.mVelocityScale);
                        boolean z = Math.abs(yVelocity) > this.mMinimumVelocity;
                        if (z && ((this.mFirstPosition != 0 || top != i2 - this.mOverscrollDistance) && (this.mFirstPosition + childCount != this.mItemCount || bottom != this.mOverscrollDistance + height))) {
                            if (!dispatchNestedPreFling(0.0f, -yVelocity)) {
                                if (this.mFlingRunnable == null) {
                                    this.mFlingRunnable = new FlingRunnable();
                                }
                                reportScrollStateChange(2);
                                this.mFlingRunnable.start(-yVelocity);
                                dispatchNestedFling(0.0f, -yVelocity, true);
                                break;
                            } else {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                                break;
                            }
                        } else {
                            this.mTouchMode = -1;
                            reportScrollStateChange(0);
                            if (this.mFlingRunnable != null) {
                                this.mFlingRunnable.endFling();
                            }
                            if (this.mPositionScroller != null) {
                                this.mPositionScroller.stop();
                            }
                            if (z && !dispatchNestedPreFling(0.0f, -yVelocity)) {
                                dispatchNestedFling(0.0f, -yVelocity, false);
                                break;
                            }
                        }
                    }
                }
                break;
            case 5:
                if (this.mFlingRunnable == null) {
                    this.mFlingRunnable = new FlingRunnable();
                }
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity2 = (int) velocityTracker2.getYVelocity(this.mActivePointerId);
                reportScrollStateChange(2);
                if (Math.abs(yVelocity2) <= this.mMinimumVelocity) {
                    this.mFlingRunnable.startSpringback();
                    break;
                } else {
                    this.mFlingRunnable.startOverfling(-yVelocity2);
                    break;
                }
        }
        setPressed(false);
        if (this.mEdgeGlowTop != null) {
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        invalidate();
        removeCallbacks(this.mPendingCheckForLongPress);
        recycleVelocityTracker();
        this.mActivePointerId = -1;
        if (this.mScrollStrictSpan != null) {
            this.mScrollStrictSpan.finish();
            this.mScrollStrictSpan = null;
        }
    }

    private void positionPopup() {
        int i = getResources().getDisplayMetrics().heightPixels;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int height = ((i - iArr[1]) - getHeight()) + ((int) (this.mDensityScale * 20.0f));
        if (this.mPopup.isShowing()) {
            this.mPopup.update(iArr[0], height, -1, -1);
        } else {
            this.mPopup.showAtLocation(this, 81, iArr[0], height);
        }
    }

    private void positionSelector(int i, View view, boolean z, float f, float f2) {
        boolean z2 = i != this.mSelectorPosition;
        if (i != -1) {
            this.mSelectorPosition = i;
        }
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof SelectionBoundsAdjuster) {
            ((SelectionBoundsAdjuster) view).adjustListItemSelectionBounds(rect);
        }
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        Drawable drawable = this.mSelector;
        if (drawable != null) {
            if (z2) {
                drawable.setVisible(false, false);
                drawable.setState(StateSet.NOTHING);
            }
            drawable.setBounds(rect);
            if (z2) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                updateSelectorState();
            }
            if (z) {
                drawable.setHotspot(f, f2);
            }
        }
        boolean z3 = this.mIsChildViewEnabled;
        if (view.isEnabled() != z3) {
            this.mIsChildViewEnabled = !z3;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void recycleVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x022b, code lost:
        if (contentFits() == false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void scrollIfNeeded(int r12, int r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.AbsListView.scrollIfNeeded(int, int, android.view.MotionEvent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFastScrollerAlwaysVisibleUiThread(boolean z) {
        if (this.mFastScroll != null) {
            this.mFastScroll.setAlwaysShow(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFastScrollerEnabledUiThread(boolean z) {
        if (this.mFastScroll != null) {
            this.mFastScroll.setEnabled(z);
        } else if (z) {
            this.mFastScroll = new FastScroller(this, this.mFastScrollStyle);
            this.mFastScroll.setEnabled(true);
        }
        resolvePadding();
        if (this.mFastScroll != null) {
            this.mFastScroll.updateLayout();
        }
    }

    private void setItemViewLayoutParams(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams == null ? (LayoutParams) generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? (LayoutParams) generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        if (this.mAdapterHasStableIds) {
            layoutParams2.itemId = this.mAdapter.getItemId(i);
        }
        layoutParams2.viewType = this.mAdapter.getItemViewType(i);
        view.setLayoutParams(layoutParams2);
    }

    private void showPopup() {
        if (getWindowVisibility() == 0) {
            createTextFilter(true);
            positionPopup();
            checkFocus();
        }
    }

    private boolean startScrollIfNeeded(int i, int i2, MotionEvent motionEvent) {
        int i3 = i2 - this.mMotionY;
        int abs = Math.abs(i3);
        boolean z = this.mScrollY != 0;
        if ((z || abs > this.mTouchSlop) && (getNestedScrollAxes() & 2) == 0) {
            createScrollingCache();
            if (z) {
                this.mTouchMode = 5;
                this.mMotionCorrection = 0;
            } else {
                this.mTouchMode = 3;
                this.mMotionCorrection = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            removeCallbacks(this.mPendingCheckForLongPress);
            setPressed(false);
            View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            reportScrollStateChange(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            scrollIfNeeded(i, i2, motionEvent);
            return true;
        }
        return false;
    }

    private void updateOnScreenCheckedViews() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        boolean z = getContext().getApplicationInfo().targetSdkVersion >= 11;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            View childAt = getChildAt(i3);
            int i4 = i + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.mCheckStates.get(i4));
            } else if (z) {
                childAt.setActivated(this.mCheckStates.get(i4));
            }
            i2 = i3 + 1;
        }
    }

    private void useDefaultSelector() {
        setSelector(getContext().getDrawable(R.drawable.list_selector_background));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i = this.mFirstPosition;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            View childAt = getChildAt(i3);
            if (listAdapter.isEnabled(i + i3)) {
                arrayList.add(childAt);
            }
            childAt.addTouchables(arrayList);
            i2 = i3 + 1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean canScrollList(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        int i2 = this.mFirstPosition;
        Rect rect = this.mListPadding;
        if (i > 0) {
            return i2 + childCount < this.mItemCount || getChildAt(childCount - 1).getBottom() > getHeight() - rect.bottom;
        }
        return i2 > 0 || getChildAt(0).getTop() < rect.top;
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return view == this.mTextFilter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearChoices() {
        if (this.mCheckStates != null) {
            this.mCheckStates.clear();
        }
        if (this.mCheckedIdStates != null) {
            this.mCheckedIdStates.clear();
        }
        this.mCheckedItemCount = 0;
    }

    public void clearTextFilter() {
        if (this.mFiltered) {
            getTextFilterInput().setText("");
            this.mFiltered = false;
            if (this.mPopup == null || !this.mPopup.isShowing()) {
                return;
            }
            dismissPopup();
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mSmoothScrollbarEnabled) {
                int i = childCount * 100;
                View childAt = getChildAt(0);
                int top = childAt.getTop();
                int height = childAt.getHeight();
                int i2 = i;
                if (height > 0) {
                    i2 = i + ((top * 100) / height);
                }
                View childAt2 = getChildAt(childCount - 1);
                int bottom = childAt2.getBottom();
                int height2 = childAt2.getHeight();
                int i3 = i2;
                if (height2 > 0) {
                    i3 = i2 - (((bottom - getHeight()) * 100) / height2);
                }
                return i3;
            }
            return 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        int i2 = 0;
        if (i >= 0) {
            i2 = 0;
            if (childCount > 0) {
                if (!this.mSmoothScrollbarEnabled) {
                    int i3 = this.mItemCount;
                    return (int) (i + (childCount * ((i == 0 ? 0 : i + childCount == i3 ? i3 : i + (childCount / 2)) / i3)));
                }
                View childAt = getChildAt(0);
                int top = childAt.getTop();
                int height = childAt.getHeight();
                i2 = 0;
                if (height > 0) {
                    i2 = Math.max(((i * 100) - ((top * 100) / height)) + ((int) ((this.mScrollY / getHeight()) * this.mItemCount * 100.0f)), 0);
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeVerticalScrollRange() {
        if (this.mSmoothScrollbarEnabled) {
            int max = Math.max(this.mItemCount * 100, 0);
            int i = max;
            if (this.mScrollY != 0) {
                i = max + Math.abs((int) ((this.mScrollY / getHeight()) * this.mItemCount * 100.0f));
            }
            return i;
        }
        return this.mItemCount;
    }

    void confirmCheckedPositionsById() {
        int i;
        boolean z;
        this.mCheckStates.clear();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mCheckedIdStates.size()) {
                break;
            }
            long keyAt = this.mCheckedIdStates.keyAt(i3);
            int intValue = this.mCheckedIdStates.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    z = false;
                    if (max >= min) {
                        break;
                    } else if (keyAt == this.mAdapter.getItemId(max)) {
                        z = true;
                        this.mCheckStates.put(max, true);
                        this.mCheckedIdStates.setValueAt(i3, Integer.valueOf(max));
                        break;
                    } else {
                        max++;
                    }
                }
                i = i3;
                if (!z) {
                    this.mCheckedIdStates.delete(keyAt);
                    int i4 = i3 - 1;
                    this.mCheckedItemCount--;
                    z2 = true;
                    i = i4;
                    if (this.mChoiceActionMode != null) {
                        z2 = true;
                        i = i4;
                        if (this.mMultiChoiceModeCallback != null) {
                            this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, intValue, keyAt, false);
                            i = i4;
                            z2 = true;
                        }
                    }
                }
            } else {
                this.mCheckStates.put(intValue, true);
                i = i3;
            }
            i2 = i + 1;
        }
        if (!z2 || this.mChoiceActionMode == null) {
            return;
        }
        this.mChoiceActionMode.invalidate();
    }

    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        return new AdapterView.AdapterContextMenuInfo(view, i, j);
    }

    AbsPositionScroller createPositionScroller() {
        return new PositionScroller();
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public void deferNotifyDataSetChanged() {
        this.mDeferNotifyDataSetChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i = 0;
        boolean z = (this.mGroupFlags & 34) == 34;
        if (z) {
            i = canvas.save();
            int i2 = this.mScrollX;
            int i3 = this.mScrollY;
            canvas.clipRect(this.mPaddingLeft + i2, this.mPaddingTop + i3, ((this.mRight + i2) - this.mLeft) - this.mPaddingRight, ((this.mBottom + i3) - this.mTop) - this.mPaddingBottom);
            this.mGroupFlags &= -35;
        }
        boolean z2 = this.mDrawSelectorOnTop;
        if (!z2) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (z2) {
            drawSelector(canvas);
        }
        if (z) {
            canvas.restoreToCount(i);
            this.mGroupFlags |= 34;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDrawableHotspotChanged(float f, float f2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int i = this.mScrollY;
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                canvas.translate(0.0f, Math.min(0, this.mFirstPositionDistanceGuess + i));
                this.mEdgeGlowTop.setSize(width, getHeight());
                if (this.mEdgeGlowTop.draw(canvas)) {
                    invalidate(0, 0, getWidth(), this.mEdgeGlowTop.getMaxHeight() + getPaddingTop());
                }
                canvas.restoreToCount(save);
            }
            if (this.mEdgeGlowBottom.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = getWidth();
            int height = getHeight();
            canvas.translate(-width2, Math.max(height, this.mLastPositionDistanceGuess + i));
            canvas.rotate(180.0f, width2, 0.0f);
            this.mEdgeGlowBottom.setSize(width2, height);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                invalidate(0, (getHeight() - getPaddingBottom()) - this.mEdgeGlowBottom.getMaxHeight(), getWidth(), getHeight());
            }
            canvas.restoreToCount(save2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
    }

    abstract void fillGap(boolean z);

    int findClosestMotionRow(int i) {
        int i2;
        int childCount = getChildCount();
        if (childCount == 0) {
            i2 = -1;
        } else {
            int findMotionRow = findMotionRow(i);
            i2 = findMotionRow;
            if (findMotionRow == -1) {
                return (this.mFirstPosition + childCount) - 1;
            }
        }
        return i2;
    }

    abstract int findMotionRow(int i);

    @Override // android.view.ViewGroup, android.view.View
    public View findViewByAccessibilityIdTraversal(int i) {
        if (i == getAccessibilityViewId()) {
            return this;
        }
        if (this.mDataChanged) {
            return null;
        }
        return super.findViewByAccessibilityIdTraversal(i);
    }

    public void fling(int i) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        reportScrollStateChange(2);
        this.mFlingRunnable.start(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getAccessibilityFocusedChild(View view) {
        ViewParent viewParent;
        ViewParent parent = view.getParent();
        while (true) {
            viewParent = parent;
            if (!(viewParent instanceof View) || viewParent == this) {
                break;
            }
            view = (View) viewParent;
            parent = viewParent.getParent();
        }
        if (!(viewParent instanceof View)) {
            view = null;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        int childCount = getChildCount();
        float bottomFadingEdgeStrength = super.getBottomFadingEdgeStrength();
        if (childCount != 0) {
            if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                return 1.0f;
            }
            int bottom = getChildAt(childCount - 1).getBottom();
            int height = getHeight();
            float verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            if (bottom > height - this.mPaddingBottom) {
                return ((bottom - height) + this.mPaddingBottom) / verticalFadingEdgeLength;
            }
        }
        return bottomFadingEdgeStrength;
    }

    @Override // android.view.View
    protected int getBottomPaddingOffset() {
        if ((this.mGroupFlags & 34) == 34) {
            return 0;
        }
        return this.mPaddingBottom;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.mCacheColorHint;
    }

    public int getCheckedItemCount() {
        return this.mCheckedItemCount;
    }

    public long[] getCheckedItemIds() {
        long[] jArr;
        if (this.mChoiceMode != 0 && this.mCheckedIdStates != null && this.mAdapter != null) {
            LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
            int size = longSparseArray.size();
            long[] jArr2 = new long[size];
            int i = 0;
            while (true) {
                int i2 = i;
                jArr = jArr2;
                if (i2 >= size) {
                    break;
                }
                jArr2[i2] = longSparseArray.keyAt(i2);
                i = i2 + 1;
            }
        } else {
            jArr = new long[0];
        }
        return jArr;
    }

    public int getCheckedItemPosition() {
        if (this.mChoiceMode == 1 && this.mCheckStates != null && this.mCheckStates.size() == 1) {
            return this.mCheckStates.keyAt(0);
        }
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.mChoiceMode != 0) {
            return this.mCheckStates;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.mChoiceMode;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView == null || selectedView.getParent() != this) {
            super.getFocusedRect(rect);
            return;
        }
        selectedView.getFocusedRect(rect);
        offsetDescendantRectToMyCoords(selectedView, rect);
    }

    int getFooterViewsCount() {
        return 0;
    }

    int getHeaderViewsCount() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeightForPosition(int i) {
        int firstVisiblePosition = getFirstVisiblePosition();
        int childCount = getChildCount();
        int i2 = i - firstVisiblePosition;
        if (i2 < 0 || i2 >= childCount) {
            View obtainView = obtainView(i, this.mIsScrap);
            obtainView.measure(this.mWidthMeasureSpec, 0);
            int measuredHeight = obtainView.getMeasuredHeight();
            this.mRecycler.addScrapView(obtainView, i);
            return measuredHeight;
        }
        return getChildAt(i2).getHeight();
    }

    @Override // android.view.View
    protected int getLeftPaddingOffset() {
        if ((this.mGroupFlags & 34) == 34) {
            return 0;
        }
        return -this.mPaddingLeft;
    }

    public int getListPaddingBottom() {
        return this.mListPadding.bottom;
    }

    public int getListPaddingLeft() {
        return this.mListPadding.left;
    }

    public int getListPaddingRight() {
        return this.mListPadding.right;
    }

    public int getListPaddingTop() {
        return this.mListPadding.top;
    }

    @Override // android.view.View
    protected int getRightPaddingOffset() {
        if ((this.mGroupFlags & 34) == 34) {
            return 0;
        }
        return this.mPaddingRight;
    }

    @Override // android.widget.AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSelectionModeForAccessibility() {
        switch (getChoiceMode()) {
            case 0:
            default:
                return 0;
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
        }
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.mCacheColorHint;
    }

    public CharSequence getTextFilter() {
        if (!this.mTextFilterEnabled || this.mTextFilter == null) {
            return null;
        }
        return this.mTextFilter.getText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        int childCount = getChildCount();
        float topFadingEdgeStrength = super.getTopFadingEdgeStrength();
        if (childCount != 0) {
            if (this.mFirstPosition > 0) {
                return 1.0f;
            }
            int top = getChildAt(0).getTop();
            float verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            if (top < this.mPaddingTop) {
                return (-(top - this.mPaddingTop)) / verticalFadingEdgeLength;
            }
        }
        return topFadingEdgeStrength;
    }

    @Override // android.view.View
    protected int getTopPaddingOffset() {
        if ((this.mGroupFlags & 34) == 34) {
            return 0;
        }
        return -this.mPaddingTop;
    }

    public int getTranscriptMode() {
        return this.mTranscriptMode;
    }

    @Override // android.view.View
    public int getVerticalScrollbarWidth() {
        return (this.mFastScroll == null || !this.mFastScroll.isEnabled()) ? super.getVerticalScrollbarWidth() : Math.max(super.getVerticalScrollbarWidth(), this.mFastScroll.getWidth());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView
    public void handleDataChanged() {
        this.mIsWidget = true;
        int i = this.mItemCount;
        int i2 = this.mLastHandledItemCount;
        this.mLastHandledItemCount = this.mItemCount;
        if (this.mChoiceMode != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        this.mRecycler.clearTransientStateViews();
        if (i > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.mPendingSync = null;
                if (this.mTranscriptMode != 2) {
                    if (this.mTranscriptMode == 1) {
                        if (this.mForceTranscriptScroll) {
                            this.mForceTranscriptScroll = false;
                            this.mLayoutMode = 3;
                            return;
                        }
                        int childCount = getChildCount();
                        int height = getHeight() - getPaddingBottom();
                        View childAt = getChildAt(childCount - 1);
                        int bottom = childAt != null ? childAt.getBottom() : height;
                        if (this.mFirstPosition + childCount >= i2 && bottom <= height) {
                            this.mLayoutMode = 3;
                            return;
                        }
                        awakenScrollBars();
                    }
                    switch (this.mSyncMode) {
                        case 1:
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i - 1);
                            return;
                        case 0:
                            if (isInTouchMode()) {
                                this.mLayoutMode = 5;
                                this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i - 1);
                                return;
                            }
                            int findSyncPosition = findSyncPosition();
                            if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                                this.mSyncPosition = findSyncPosition;
                                if (this.mSyncHeight == getHeight()) {
                                    this.mLayoutMode = 5;
                                } else {
                                    this.mLayoutMode = 2;
                                }
                                setNextSelectedPositionInt(findSyncPosition);
                                return;
                            }
                            break;
                    }
                } else {
                    this.mLayoutMode = 3;
                    return;
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                int i3 = selectedItemPosition;
                if (selectedItemPosition >= i) {
                    i3 = i - 1;
                }
                int i4 = i3;
                if (i3 < 0) {
                    i4 = 0;
                }
                int lookForSelectablePosition = lookForSelectablePosition(i4, true);
                if (lookForSelectablePosition >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition);
                    return;
                }
                int lookForSelectablePosition2 = lookForSelectablePosition(i4, false);
                if (lookForSelectablePosition2 >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition2);
                    return;
                }
            } else if (this.mResurrectToPosition >= 0) {
                return;
            }
        }
        this.mLayoutMode = this.mStackFromBottom ? 3 : 1;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mSelectorPosition = -1;
        checkSelectionChanged();
    }

    public boolean hasTextFilter() {
        return this.mFiltered;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideSelector() {
        if (this.mSelectedPosition != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
            if (this.mNextSelectedPosition >= 0 && this.mNextSelectedPosition != this.mSelectedPosition) {
                this.mResurrectToPosition = this.mNextSelectedPosition;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedTop = 0;
        }
    }

    public void invalidateViews() {
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeOnItemScrollListener() {
        if (this.mFastScroll != null) {
            this.mFastScroll.onScroll(this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public boolean isFastScrollAlwaysVisible() {
        return this.mFastScroll == null ? this.mFastScrollEnabled && this.mFastScrollAlwaysVisible : this.mFastScroll.isEnabled() && this.mFastScroll.isAlwaysShowEnabled();
    }

    @ViewDebug.ExportedProperty
    public boolean isFastScrollEnabled() {
        return this.mFastScroll == null ? this.mFastScrollEnabled : this.mFastScroll.isEnabled();
    }

    @Override // android.widget.AdapterView
    protected boolean isInFilterMode() {
        return this.mFiltered;
    }

    public boolean isItemChecked(int i) {
        if (this.mChoiceMode == 0 || this.mCheckStates == null) {
            return false;
        }
        return this.mCheckStates.get(i);
    }

    @Override // android.view.View
    protected boolean isPaddingOffsetRequired() {
        return (this.mGroupFlags & 34) != 34;
    }

    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        return this.mScrollingCacheEnabled;
    }

    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        return this.mStackFromBottom;
    }

    @ViewDebug.ExportedProperty
    public boolean isTextFilterEnabled() {
        return this.mTextFilterEnabled;
    }

    @Override // android.view.View
    protected boolean isVerticalScrollBarHidden() {
        return isFastScrollEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mSelector != null) {
            this.mSelector.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void keyPressed() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (childAt.hasFocusable()) {
                            return;
                        }
                        childAt.setPressed(true);
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (!isLongClickable || this.mDataChanged) {
                        return;
                    }
                    if (this.mPendingCheckForKeyLongPress == null) {
                        this.mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
                    }
                    this.mPendingCheckForKeyLongPress.rememberWindowAttachCount();
                    postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View obtainView(int i, boolean[] zArr) {
        View view;
        Trace.traceBegin(8L, "obtainView");
        zArr[0] = false;
        View transientStateView = this.mRecycler.getTransientStateView(i);
        if (transientStateView != null) {
            if (((LayoutParams) transientStateView.getLayoutParams()).viewType == this.mAdapter.getItemViewType(i) && (view = this.mAdapter.getView(i, transientStateView, this)) != transientStateView) {
                setItemViewLayoutParams(view, i);
                this.mRecycler.addScrapView(view, i);
            }
            zArr[0] = true;
            return transientStateView;
        }
        View scrapView = this.mRecycler.getScrapView(i);
        View view2 = this.mAdapter.getView(i, scrapView, this);
        View view3 = view2;
        if (scrapView != null) {
            view3 = view2;
            if (this.mIsScrolling) {
                view3 = view2;
                if (!this.mIsWidget) {
                    view3 = setAnimation(view2);
                }
            }
            if (view3 != scrapView) {
                this.mRecycler.addScrapView(scrapView, i);
            } else {
                zArr[0] = true;
                view3.dispatchFinishTemporaryDetach();
            }
        }
        if (this.mCacheColorHint != 0) {
            view3.setDrawingCacheBackgroundColor(this.mCacheColorHint);
        }
        if (view3.getImportantForAccessibility() == 0) {
            view3.setImportantForAccessibility(1);
        }
        setItemViewLayoutParams(view3, i);
        if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
            if (this.mAccessibilityDelegate == null) {
                this.mAccessibilityDelegate = new ListItemAccessibilityDelegate();
            }
            if (view3.getAccessibilityDelegate() == null) {
                view3.setAccessibilityDelegate(this.mAccessibilityDelegate);
            }
        }
        Trace.traceEnd(8L);
        return view3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnTouchModeChangeListener(this);
        if (this.mTextFilterEnabled && this.mPopup != null && !this.mGlobalLayoutListenerAddedFilter) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.mAdapter != null && this.mDataSetObserver == null) {
            this.mDataSetObserver = new AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        if (!isLayoutRtl() || this.mFastScroll == null) {
            return;
        }
        this.mFastScroll.setScrollbarPosition(getVerticalScrollbarPosition());
    }

    @Override // android.view.View
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
        if (this.mPerformClick != null) {
            removeCallbacks(this.mPerformClick);
        }
        if (this.mPendingCheckForTap != null) {
            removeCallbacks(this.mPendingCheckForTap);
        }
        if (this.mPendingCheckForLongPress != null) {
            removeCallbacks(this.mPendingCheckForLongPress);
        }
        if (this.mPendingCheckForKeyLongPress != null) {
            removeCallbacks(this.mPendingCheckForKeyLongPress);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int i2;
        int[] iArr;
        if (this.mIsChildViewEnabled) {
            iArr = super.onCreateDrawableState(i);
        } else {
            int i3 = ENABLED_STATE_SET[0];
            int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
            int length = onCreateDrawableState.length;
            while (true) {
                int i4 = length - 1;
                i2 = -1;
                if (i4 < 0) {
                    break;
                } else if (onCreateDrawableState[i4] == i3) {
                    i2 = i4;
                    break;
                } else {
                    length = i4;
                }
            }
            iArr = onCreateDrawableState;
            if (i2 >= 0) {
                System.arraycopy(onCreateDrawableState, i2 + 1, onCreateDrawableState, i2, (onCreateDrawableState.length - i2) - 1);
                return onCreateDrawableState;
            }
        }
        return iArr;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (isTextFilterEnabled()) {
            if (this.mPublicInputConnection == null) {
                this.mDefInputConnection = new BaseInputConnection((View) this, false);
                this.mPublicInputConnection = new InputConnectionWrapper(editorInfo);
            }
            editorInfo.inputType = 177;
            editorInfo.imeOptions = 6;
            return this.mPublicInputConnection;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsDetaching = true;
        dismissPopup();
        this.mRecycler.clear();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.removeOnTouchModeChangeListener(this);
        if (this.mTextFilterEnabled && this.mPopup != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            this.mGlobalLayoutListenerAddedFilter = false;
        }
        if (this.mAdapter != null && this.mDataSetObserver != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            this.mDataSetObserver = null;
        }
        if (this.mScrollStrictSpan != null) {
            this.mScrollStrictSpan.finish();
            this.mScrollStrictSpan = null;
        }
        if (this.mFlingStrictSpan != null) {
            this.mFlingStrictSpan.finish();
            this.mFlingStrictSpan = null;
        }
        if (this.mFlingRunnable != null) {
            removeCallbacks(this.mFlingRunnable);
        }
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
        if (this.mClearScrollingCache != null) {
            removeCallbacks(this.mClearScrollingCache);
        }
        if (this.mPerformClick != null) {
            removeCallbacks(this.mPerformClick);
        }
        if (this.mTouchModeReset != null) {
            removeCallbacks(this.mTouchModeReset);
            this.mTouchModeReset.run();
        }
        this.mIsDetaching = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDisplayHint(int i) {
        super.onDisplayHint(i);
        switch (i) {
            case 0:
                if (this.mFiltered && this.mPopup != null && !this.mPopup.isShowing()) {
                    showPopup();
                    break;
                }
                break;
            case 4:
                if (this.mPopup != null && this.mPopup.isShowing()) {
                    dismissPopup();
                    break;
                }
                break;
        }
        this.mPopupHidden = i == 4;
    }

    @Override // android.widget.Filter.FilterListener
    public void onFilterComplete(int i) {
        if (this.mSelectedPosition >= 0 || i <= 0) {
            return;
        }
        this.mResurrectToPosition = -1;
        resurrectSelection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z || this.mSelectedPosition >= 0 || isInTouchMode()) {
            return;
        }
        if (!isAttachedToWindow() && this.mAdapter != null) {
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        resurrectSelection();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.mTouchMode == -1) {
                        float axisValue = motionEvent.getAxisValue(9);
                        if (axisValue != 0.0f) {
                            int verticalScrollFactor = (int) (getVerticalScrollFactor() * axisValue);
                            if (!trackMotionScroll(verticalScrollFactor, verticalScrollFactor)) {
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!isShown()) {
            if (this.mPopup == null || !this.mPopup.isShowing()) {
                return;
            }
            dismissPopup();
        } else if (!this.mFiltered || this.mPopup == null || this.mPopup.isShowing() || this.mPopupHidden) {
        } else {
            showPopup();
        }
    }

    @Override // android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsListView.class.getName());
    }

    @Override // android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsListView.class.getName());
        if (isEnabled()) {
            if (canScrollUp()) {
                accessibilityNodeInfo.addAction(8192);
                accessibilityNodeInfo.setScrollable(true);
            }
            if (canScrollDown()) {
                accessibilityNodeInfo.addAction(4096);
                accessibilityNodeInfo.setScrollable(true);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(View view, int i, AccessibilityNodeInfo accessibilityNodeInfo) {
        ListAdapter adapter = getAdapter();
        if (i == -1 || adapter == null) {
            return;
        }
        if (!isEnabled() || !adapter.isEnabled(i)) {
            accessibilityNodeInfo.setEnabled(false);
            return;
        }
        if (i == getSelectedItemPosition()) {
            accessibilityNodeInfo.setSelected(true);
            accessibilityNodeInfo.addAction(8);
        } else {
            accessibilityNodeInfo.addAction(4);
        }
        if (isClickable()) {
            accessibilityNodeInfo.addAction(16);
            accessibilityNodeInfo.setClickable(true);
        }
        if (isLongClickable()) {
            accessibilityNodeInfo.addAction(32);
            accessibilityNodeInfo.setLongClickable(true);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        if (this.mFastScroll == null || !this.mFastScroll.onInterceptHoverEvent(motionEvent)) {
            return super.onInterceptHoverEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
        if (this.mIsDetaching || !isAttachedToWindow()) {
            z = false;
        } else if (this.mFastScroll == null || !this.mFastScroll.onInterceptTouchEvent(motionEvent)) {
            switch (actionMasked) {
                case 0:
                    int i = this.mTouchMode;
                    if (i == 6 || i == 5) {
                        this.mMotionCorrection = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int findMotionRow = findMotionRow(y);
                    if (i != 4 && findMotionRow >= 0) {
                        this.mMotionViewOriginalTop = getChildAt(findMotionRow - this.mFirstPosition).getTop();
                        this.mMotionX = x;
                        this.mMotionY = y;
                        this.mMotionPosition = findMotionRow;
                        this.mTouchMode = 0;
                        clearScrollingCache();
                    }
                    this.mLastY = Integer.MIN_VALUE;
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mNestedYOffset = 0;
                    startNestedScroll(2);
                    return i == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    recycleVelocityTracker();
                    reportScrollStateChange(0);
                    stopNestedScroll();
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            int i2 = findPointerIndex;
                            if (findPointerIndex == -1) {
                                i2 = 0;
                                this.mActivePointerId = motionEvent.getPointerId(0);
                            }
                            int y2 = (int) motionEvent.getY(i2);
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return startScrollIfNeeded((int) motionEvent.getX(i2), y2, null);
                        default:
                            return false;
                    }
                case 4:
                case 5:
                default:
                    return false;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    return false;
            }
        }
        return z;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (KeyEvent.isConfirmKey(i)) {
            if (!isEnabled()) {
                return true;
            }
            if (isClickable() && isPressed() && this.mSelectedPosition >= 0 && this.mAdapter != null && this.mSelectedPosition < this.mAdapter.getCount()) {
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                if (childAt != null) {
                    performItemClick(childAt, this.mSelectedPosition, this.mSelectedRowId);
                    childAt.setPressed(false);
                }
                setPressed(false);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        int childCount = getChildCount();
        if (z) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= childCount) {
                    break;
                }
                getChildAt(i6).forceLayout();
                i5 = i6 + 1;
            }
            this.mRecycler.markChildrenDirty();
        }
        layoutChildren();
        this.mInLayout = false;
        this.mOverscrollMax = (i4 - i2) / 3;
        this.mHeight = getHeight();
        this.mWidth = getWidth();
        if (this.mFastScroll != null) {
            this.mFastScroll.onItemCountChanged(getChildCount(), this.mItemCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z = true;
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        Rect rect = this.mListPadding;
        rect.left = this.mSelectionLeftPadding + this.mPaddingLeft;
        rect.top = this.mSelectionTopPadding + this.mPaddingTop;
        rect.right = this.mSelectionRightPadding + this.mPaddingRight;
        rect.bottom = this.mSelectionBottomPadding + this.mPaddingBottom;
        if (this.mTranscriptMode == 1) {
            int childCount = getChildCount();
            int height = getHeight() - getPaddingBottom();
            View childAt = getChildAt(childCount - 1);
            int bottom = childAt != null ? childAt.getBottom() : height;
            if (this.mFirstPosition + childCount < this.mLastHandledItemCount || bottom > height) {
                z = false;
            }
            this.mForceTranscriptScroll = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        if (z || childCount <= 0 || !canScrollList((int) f2) || Math.abs(f2) <= this.mMinimumVelocity) {
            return dispatchNestedFling(f, f2, z);
        }
        reportScrollStateChange(2);
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        if (dispatchNestedPreFling(0.0f, f2)) {
            return true;
        }
        this.mFlingRunnable.start((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(getChildCount() / 2);
        int top = childAt != null ? childAt.getTop() : 0;
        if (childAt == null || trackMotionScroll(-i4, -i4)) {
            int i5 = 0;
            int i6 = i4;
            if (childAt != null) {
                i5 = childAt.getTop() - top;
                i6 = i4 - i5;
            }
            dispatchNestedScroll(0, i5, 0, i6, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(2);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.mScrollY != i2) {
            onScrollChanged(this.mScrollX, i2, this.mScrollX, this.mScrollY);
            this.mScrollY = i2;
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public boolean onRemoteAdapterConnected() {
        if (this.mRemoteAdapter == this.mAdapter) {
            if (this.mRemoteAdapter != null) {
                this.mRemoteAdapter.superNotifyDataSetChanged();
                return true;
            }
            return false;
        }
        setAdapter((ListAdapter) this.mRemoteAdapter);
        if (this.mDeferNotifyDataSetChanged) {
            this.mRemoteAdapter.notifyDataSetChanged();
            this.mDeferNotifyDataSetChanged = false;
            return false;
        }
        return false;
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public void onRemoteAdapterDisconnected() {
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.mSyncHeight = savedState.height;
        if (savedState.selectedId >= 0) {
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncRowId = savedState.selectedId;
            this.mSyncPosition = savedState.position;
            this.mSpecificTop = savedState.viewTop;
            this.mSyncMode = 0;
        } else if (savedState.firstId >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectorPosition = -1;
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncRowId = savedState.firstId;
            this.mSyncPosition = savedState.position;
            this.mSpecificTop = savedState.viewTop;
            this.mSyncMode = 1;
        }
        setFilterText(savedState.filter);
        if (savedState.checkState != null) {
            this.mCheckStates = savedState.checkState;
        }
        if (savedState.checkIdState != null) {
            this.mCheckedIdStates = savedState.checkIdState;
        }
        this.mCheckedItemCount = savedState.checkedItemCount;
        if (savedState.inActionMode && this.mChoiceMode == 3 && this.mMultiChoiceModeCallback != null) {
            this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
        }
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.mFastScroll != null) {
            this.mFastScroll.setScrollbarPosition(getVerticalScrollbarPosition());
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        EditText editText;
        Editable text;
        dismissPopup();
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.mPendingSync != null) {
            savedState.selectedId = this.mPendingSync.selectedId;
            savedState.firstId = this.mPendingSync.firstId;
            savedState.viewTop = this.mPendingSync.viewTop;
            savedState.position = this.mPendingSync.position;
            savedState.height = this.mPendingSync.height;
            savedState.filter = this.mPendingSync.filter;
            savedState.inActionMode = this.mPendingSync.inActionMode;
            savedState.checkedItemCount = this.mPendingSync.checkedItemCount;
            savedState.checkState = this.mPendingSync.checkState;
            savedState.checkIdState = this.mPendingSync.checkIdState;
        } else {
            boolean z = getChildCount() > 0 && this.mItemCount > 0;
            long selectedItemId = getSelectedItemId();
            savedState.selectedId = selectedItemId;
            savedState.height = getHeight();
            if (selectedItemId >= 0) {
                savedState.viewTop = this.mSelectedTop;
                savedState.position = getSelectedItemPosition();
                savedState.firstId = -1L;
            } else if (!z || this.mFirstPosition <= 0) {
                savedState.viewTop = 0;
                savedState.firstId = -1L;
                savedState.position = 0;
            } else {
                savedState.viewTop = getChildAt(0).getTop();
                int i = this.mFirstPosition;
                int i2 = i;
                if (i >= this.mItemCount) {
                    i2 = this.mItemCount - 1;
                }
                savedState.position = i2;
                savedState.firstId = this.mAdapter.getItemId(i2);
            }
            savedState.filter = null;
            if (this.mFiltered && (editText = this.mTextFilter) != null && (text = editText.getText()) != null) {
                savedState.filter = text.toString();
            }
            savedState.inActionMode = this.mChoiceMode == 3 && this.mChoiceActionMode != null;
            if (this.mCheckStates != null) {
                savedState.checkState = this.mCheckStates.clone();
            }
            if (this.mCheckedIdStates != null) {
                LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
                int size = this.mCheckedIdStates.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        break;
                    }
                    longSparseArray.put(this.mCheckedIdStates.keyAt(i4), this.mCheckedIdStates.valueAt(i4));
                    i3 = i4 + 1;
                }
                savedState.checkIdState = longSparseArray;
            }
            savedState.checkedItemCount = this.mCheckedItemCount;
            if (this.mRemoteAdapter != null) {
                this.mRemoteAdapter.saveRemoteViewsCache();
                return savedState;
            }
        }
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            this.mDataChanged = true;
            rememberSyncState();
        }
        if (this.mFastScroll != null) {
            this.mFastScroll.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (isTextFilterEnabled()) {
            createTextFilter(true);
            int length = charSequence.length();
            boolean isShowing = this.mPopup.isShowing();
            if (!isShowing && length > 0) {
                showPopup();
                this.mFiltered = true;
            } else if (isShowing && length == 0) {
                dismissPopup();
                this.mFiltered = false;
            }
            if (this.mAdapter instanceof Filterable) {
                Filter filter = ((Filterable) this.mAdapter).getFilter();
                if (filter == null) {
                    throw new IllegalStateException("You cannot call onTextChanged with a non filterable adapter");
                }
                filter.filter(charSequence, this);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (isLongClickable() != false) goto L10;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.AbsListView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            hideSelector();
            if (getHeight() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            updateSelectorState();
            return;
        }
        int i = this.mTouchMode;
        if (i == 5 || i == 6) {
            if (this.mFlingRunnable != null) {
                this.mFlingRunnable.endFling();
            }
            if (this.mPositionScroller != null) {
                this.mPositionScroller.stop();
            }
            if (this.mScrollY != 0) {
                this.mScrollY = 0;
                invalidateParentCaches();
                finishGlows();
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i = isInTouchMode() ? 0 : 1;
        if (z) {
            if (this.mFiltered && !this.mPopupHidden) {
                showPopup();
            }
            if (i != this.mLastTouchMode && this.mLastTouchMode != -1) {
                if (i == 1) {
                    resurrectSelection();
                } else {
                    hideSelector();
                    this.mLayoutMode = 0;
                    layoutChildren();
                }
            }
        } else {
            setChildrenDrawingCacheEnabled(false);
            if (this.mFlingRunnable != null) {
                removeCallbacks(this.mFlingRunnable);
                this.mFlingRunnable.endFling();
                if (this.mPositionScroller != null) {
                    this.mPositionScroller.stop();
                }
                if (this.mScrollY != 0) {
                    this.mScrollY = 0;
                    invalidateParentCaches();
                    finishGlows();
                    invalidate();
                }
            }
            dismissPopup();
            if (i == 1) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
        }
        this.mLastTouchMode = i;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!isEnabled() || getLastVisiblePosition() >= getCount() - 1) {
                    return false;
                }
                smoothScrollBy((getHeight() - this.mListPadding.top) - this.mListPadding.bottom, 200);
                return true;
            case 8192:
                if (!isEnabled() || this.mFirstPosition <= 0) {
                    return false;
                }
                smoothScrollBy(-((getHeight() - this.mListPadding.top) - this.mListPadding.bottom), 200);
                return true;
            default:
                return false;
        }
    }

    @Override // android.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        boolean z = false;
        boolean z2 = true;
        boolean z3 = true;
        if (this.mChoiceMode != 0) {
            boolean z4 = false;
            if (this.mChoiceMode == 2 || (this.mChoiceMode == 3 && this.mChoiceActionMode != null)) {
                boolean z5 = !this.mCheckStates.get(i, false);
                this.mCheckStates.put(i, z5);
                if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.mCheckedIdStates.delete(this.mAdapter.getItemId(i));
                    }
                }
                if (z5) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
                if (this.mChoiceActionMode != null) {
                    this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, i, j, z5);
                    z3 = false;
                }
                z4 = true;
            } else {
                z3 = true;
                if (this.mChoiceMode == 1) {
                    if (!this.mCheckStates.get(i, false)) {
                        this.mCheckStates.clear();
                        this.mCheckStates.put(i, true);
                        if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                            this.mCheckedIdStates.clear();
                            this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                        }
                        this.mCheckedItemCount = 1;
                    } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                        this.mCheckedItemCount = 0;
                    }
                    z4 = true;
                    z3 = true;
                }
            }
            z2 = z3;
            z = true;
            if (z4) {
                updateOnScreenCheckedViews();
                z = true;
                z2 = z3;
            }
        }
        boolean z6 = z;
        if (z2) {
            z6 = z | super.performItemClick(view, i, j);
        }
        return z6;
    }

    boolean performLongPress(View view, int i, long j) {
        boolean z;
        if (this.mChoiceMode == 3) {
            z = true;
            if (this.mChoiceActionMode == null) {
                ActionMode startActionMode = startActionMode(this.mMultiChoiceModeCallback);
                this.mChoiceActionMode = startActionMode;
                z = true;
                if (startActionMode != null) {
                    setItemChecked(i, true);
                    performHapticFeedback(0);
                    z = true;
                }
            }
        } else {
            boolean z2 = false;
            if (this.mOnItemLongClickListener != null) {
                z2 = this.mOnItemLongClickListener.onItemLongClick(this, view, i, j);
            }
            boolean z3 = z2;
            if (!z2) {
                this.mContextMenuInfo = createContextMenuInfo(view, i, j);
                z3 = super.showContextMenuForChild(this);
            }
            z = z3;
            if (z3) {
                performHapticFeedback(0);
                return z3;
            }
        }
        return z;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        Rect rect2 = rect;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect2 = this.mTouchFrame;
        }
        int childCount = getChildCount();
        while (true) {
            int i3 = childCount - 1;
            if (i3 < 0) {
                return -1;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect2);
                if (rect2.contains(i, i2)) {
                    return this.mFirstPosition + i3;
                }
            }
            childCount = i3;
        }
    }

    public long pointToRowId(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            return this.mAdapter.getItemId(pointToPosition);
        }
        return Long.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void positionSelector(int i, View view) {
        positionSelector(i, view, false, -1.0f, -1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void positionSelectorLikeFocus(int i, View view) {
        if (this.mSelector == null || this.mSelectorPosition == i || i == -1) {
            positionSelector(i, view);
            return;
        }
        Rect rect = this.mSelectorRect;
        positionSelector(i, view, true, rect.exactCenterX(), rect.exactCenterY());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void positionSelectorLikeTouch(int i, View view, float f, float f2) {
        positionSelector(i, view, true, f, f2);
    }

    public void reclaimViews(List<View> list) {
        int childCount = getChildCount();
        RecyclerListener recyclerListener = this.mRecycler.mRecyclerListener;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                this.mRecycler.reclaimScrapViews(list);
                removeAllViewsInLayout();
                return;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null && this.mRecycler.shouldRecycleViewType(layoutParams.viewType)) {
                list.add(childAt);
                childAt.setAccessibilityDelegate(null);
                if (recyclerListener != null) {
                    recyclerListener.onMovedToScrapHeap(childAt);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int reconcileSelectedPosition() {
        int i = this.mSelectedPosition;
        int i2 = i;
        if (i < 0) {
            i2 = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i2), this.mItemCount - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportScrollStateChange(int i) {
        if (i != this.mLastScrollState) {
            this.mIsScrolling = i != 0;
            if (this.mOnScrollListener != null) {
                this.mLastScrollState = i;
                this.mOnScrollListener.onScrollStateChanged(this, i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mBlockLayoutRequests || this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetList() {
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.mPositionScrollAfterLayout = null;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.mSelectedTop = 0;
        this.mSelectorPosition = -1;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x013c, code lost:
        if (r5 < r10) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01c6, code lost:
        if (r0 > r9) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean resurrectSelection() {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.AbsListView.resurrectSelection():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean resurrectSelectionIfNeeded() {
        if (this.mSelectedPosition >= 0 || !resurrectSelection()) {
            return false;
        }
        updateSelectorState();
        return true;
    }

    public void scrollListBy(int i) {
        trackMotionScroll(-i, -i);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        if (i == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.mLastAccessibilityScrollEventFromIndex == firstVisiblePosition && this.mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                return;
            }
            this.mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
            this.mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
        }
        super.sendAccessibilityEvent(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sendToTextFilter(int i, int i2, KeyEvent keyEvent) {
        boolean z;
        if (acceptFilter()) {
            boolean z2 = false;
            boolean z3 = true;
            switch (i) {
                case 4:
                    boolean z4 = false;
                    if (this.mFiltered) {
                        z4 = false;
                        if (this.mPopup != null) {
                            z4 = false;
                            if (this.mPopup.isShowing()) {
                                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                                    if (keyDispatcherState != null) {
                                        keyDispatcherState.startTracking(keyEvent, this);
                                    }
                                    z4 = true;
                                } else {
                                    z4 = false;
                                    if (keyEvent.getAction() == 1) {
                                        z4 = false;
                                        if (keyEvent.isTracking()) {
                                            z4 = false;
                                            if (!keyEvent.isCanceled()) {
                                                z4 = true;
                                                this.mTextFilter.setText("");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z2 = z4;
                    z3 = false;
                    break;
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 66:
                    z3 = false;
                    break;
                case 62:
                    z3 = this.mFiltered;
                    break;
            }
            z = z2;
            if (z3) {
                createTextFilter(true);
                KeyEvent keyEvent2 = keyEvent;
                if (keyEvent.getRepeatCount() > 0) {
                    keyEvent2 = KeyEvent.changeTimeRepeat(keyEvent, keyEvent.getEventTime(), 0);
                }
                switch (keyEvent.getAction()) {
                    case 0:
                        return this.mTextFilter.onKeyDown(i, keyEvent2);
                    case 1:
                        return this.mTextFilter.onKeyUp(i, keyEvent2);
                    case 2:
                        return this.mTextFilter.onKeyMultiple(i, i2, keyEvent);
                    default:
                        return z2;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.mAdapterHasStableIds = this.mAdapter.hasStableIds();
            if (this.mChoiceMode != 0 && this.mAdapterHasStableIds && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
        if (this.mCheckStates != null) {
            this.mCheckStates.clear();
        }
        if (this.mCheckedIdStates != null) {
            this.mCheckedIdStates.clear();
        }
    }

    View setAnimation(View view) {
        int i;
        int i2 = Settings.System.getInt(this.mContext.getContentResolver(), "listview_animation", 1);
        boolean z = false;
        try {
            i = computeVerticalScrollOffset();
        } catch (NullPointerException e) {
            i = this.mvPosition;
        }
        if (i2 != 0) {
            if (this.mvPosition < i) {
                z = true;
            }
            this.mvPosition = i;
            ScaleAnimation scaleAnimation = null;
            switch (i2) {
                case 1:
                    scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f);
                    break;
                case 2:
                    scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 1.0f, 1, 1.0f);
                    break;
                case 3:
                    scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
                    break;
                case 4:
                    scaleAnimation = new AlphaAnimation(0.0f, 1.0f);
                    break;
                case 5:
                    scaleAnimation = new TranslateAnimation(0.0f, 0.0f, -this.mHeight, 0.0f);
                    break;
                case 6:
                    scaleAnimation = new TranslateAnimation(0.0f, 0.0f, this.mHeight, 0.0f);
                    break;
                case 7:
                    if (!z) {
                        scaleAnimation = new TranslateAnimation(0.0f, 0.0f, this.mHeight, 0.0f);
                        break;
                    } else {
                        scaleAnimation = new TranslateAnimation(0.0f, 0.0f, -this.mHeight, 0.0f);
                        break;
                    }
                case 8:
                    if (!z) {
                        scaleAnimation = new TranslateAnimation(0.0f, 0.0f, -this.mHeight, 0.0f);
                        break;
                    } else {
                        scaleAnimation = new TranslateAnimation(0.0f, 0.0f, this.mHeight, 0.0f);
                        break;
                    }
                case 9:
                    scaleAnimation = new TranslateAnimation(-this.mWidth, 0.0f, 0.0f, 0.0f);
                    break;
                case 10:
                    scaleAnimation = new TranslateAnimation(this.mWidth, 0.0f, 0.0f, 0.0f);
                    break;
                case 11:
                    scaleAnimation = new RotateAnimation(180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    break;
            }
            scaleAnimation.setDuration(500L);
            switch (Settings.System.getInt(this.mContext.getContentResolver(), "listview_interpolator", 0)) {
                case 1:
                    scaleAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.accelerate_interpolator));
                    break;
                case 2:
                    scaleAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.decelerate_interpolator));
                    break;
                case 3:
                    scaleAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.accelerate_decelerate_interpolator));
                    break;
                case 4:
                    scaleAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.anticipate_interpolator));
                    break;
                case 5:
                    scaleAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.overshoot_interpolator));
                    break;
                case 6:
                    scaleAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.anticipate_overshoot_interpolator));
                    break;
                case 7:
                    scaleAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.bounce_interpolator));
                    break;
            }
            if (view != null) {
                view.startAnimation(scaleAnimation);
                return view;
            }
        }
        return view;
    }

    public void setCacheColorHint(int i) {
        if (i == this.mCacheColorHint) {
            return;
        }
        this.mCacheColorHint = i;
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                this.mRecycler.setCacheColorHint(i);
                return;
            } else {
                getChildAt(i3).setDrawingCacheBackgroundColor(i);
                i2 = i3 + 1;
            }
        }
    }

    public void setChoiceMode(int i) {
        this.mChoiceMode = i;
        if (this.mChoiceActionMode != null) {
            this.mChoiceActionMode.finish();
            this.mChoiceActionMode = null;
        }
        if (this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseBooleanArray(0);
            }
            if (this.mCheckedIdStates == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>(0);
            }
            if (this.mChoiceMode == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setFastScrollAlwaysVisible(final boolean z) {
        if (this.mFastScrollAlwaysVisible != z) {
            if (z && !this.mFastScrollEnabled) {
                setFastScrollEnabled(true);
            }
            this.mFastScrollAlwaysVisible = z;
            if (isOwnerThread()) {
                setFastScrollerAlwaysVisibleUiThread(z);
            } else {
                post(new Runnable() { // from class: android.widget.AbsListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AbsListView.this.setFastScrollerAlwaysVisibleUiThread(z);
                    }
                });
            }
        }
    }

    public void setFastScrollEnabled(final boolean z) {
        if (this.mFastScrollEnabled != z) {
            this.mFastScrollEnabled = z;
            if (isOwnerThread()) {
                setFastScrollerEnabledUiThread(z);
            } else {
                post(new Runnable() { // from class: android.widget.AbsListView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbsListView.this.setFastScrollerEnabledUiThread(z);
                    }
                });
            }
        }
    }

    public void setFastScrollStyle(int i) {
        if (this.mFastScroll == null) {
            this.mFastScrollStyle = i;
        } else {
            this.mFastScroll.setStyle(i);
        }
    }

    public void setFilterText(String str) {
        if (!this.mTextFilterEnabled || TextUtils.isEmpty(str)) {
            return;
        }
        createTextFilter(false);
        this.mTextFilter.setText(str);
        this.mTextFilter.setSelection(str.length());
        if (this.mAdapter instanceof Filterable) {
            if (this.mPopup == null) {
                ((Filterable) this.mAdapter).getFilter().filter(str);
            }
            this.mFiltered = true;
            this.mDataSetObserver.clearSavedState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            boolean z = getWindowVisibility() == 0;
            if (this.mFiltered && z && this.mPopup != null && this.mPopup.isShowing()) {
                positionPopup();
            }
        }
        return frame;
    }

    public void setFriction(float f) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        this.mFlingRunnable.mScroller.setFriction(f);
    }

    public void setGridView(boolean z) {
        this.mIsGridView = z;
    }

    public void setItemChecked(int i, boolean z) {
        if (this.mChoiceMode == 0) {
            return;
        }
        if (z && this.mChoiceMode == 3 && this.mChoiceActionMode == null) {
            if (this.mMultiChoiceModeCallback == null || !this.mMultiChoiceModeCallback.hasWrappedCallback()) {
                throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
            this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
        }
        if (this.mChoiceMode == 2 || this.mChoiceMode == 3) {
            boolean z2 = this.mCheckStates.get(i);
            this.mCheckStates.put(i, z);
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                if (z) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                } else {
                    this.mCheckedIdStates.delete(this.mAdapter.getItemId(i));
                }
            }
            if (z2 != z) {
                if (z) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
            }
            if (this.mChoiceActionMode != null) {
                this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, i, this.mAdapter.getItemId(i), z);
            }
        } else {
            boolean z3 = this.mCheckedIdStates != null && this.mAdapter.hasStableIds();
            if (z || isItemChecked(i)) {
                this.mCheckStates.clear();
                if (z3) {
                    this.mCheckedIdStates.clear();
                }
            }
            if (z) {
                this.mCheckStates.put(i, true);
                if (z3) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                }
                this.mCheckedItemCount = 1;
            } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                this.mCheckedItemCount = 0;
            }
        }
        if (this.mInLayout || this.mBlockLayoutRequests) {
            return;
        }
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        if (this.mMultiChoiceModeCallback == null) {
            this.mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        }
        this.mMultiChoiceModeCallback.setWrapped(multiChoiceModeListener);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
        invokeOnItemScrollListener();
    }

    public void setOverScrollEffectPadding(int i, int i2) {
        this.mGlowPaddingLeft = i;
        this.mGlowPaddingRight = i2;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        if (i == 2) {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        } else if (this.mEdgeGlowTop == null) {
            Context context = getContext();
            this.mEdgeGlowTop = new EdgeEffect(context);
            this.mEdgeGlowBottom = new EdgeEffect(context);
        }
        super.setOverScrollMode(i);
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecycler.mRecyclerListener = recyclerListener;
    }

    public void setRemoteViewsAdapter(Intent intent) {
        if (this.mRemoteAdapter == null || !new Intent.FilterComparison(intent).equals(new Intent.FilterComparison(this.mRemoteAdapter.getRemoteViewsServiceIntent()))) {
            this.mDeferNotifyDataSetChanged = false;
            this.mRemoteAdapter = new RemoteViewsAdapter(getContext(), intent, this);
            if (this.mRemoteAdapter.isDataReady()) {
                setAdapter((ListAdapter) this.mRemoteAdapter);
            }
        }
    }

    public void setRemoteViewsOnClickHandler(RemoteViews.OnClickHandler onClickHandler) {
        if (this.mRemoteAdapter != null) {
            this.mRemoteAdapter.setRemoteViewsOnClickHandler(onClickHandler);
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        super.setScrollBarStyle(i);
        if (this.mFastScroll != null) {
            this.mFastScroll.setScrollBarStyle(i);
        }
    }

    public void setScrollIndicators(View view, View view2) {
        this.mScrollUp = view;
        this.mScrollDown = view2;
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled && !z) {
            clearScrollingCache();
        }
        this.mScrollingCacheEnabled = z;
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mAdapter == null) {
            return;
        }
        if (isInTouchMode()) {
            this.mResurrectToPosition = i;
        } else {
            int lookForSelectablePosition = lookForSelectablePosition(i, true);
            i = lookForSelectablePosition;
            if (lookForSelectablePosition >= 0) {
                setNextSelectedPositionInt(lookForSelectablePosition);
                i = lookForSelectablePosition;
            }
        }
        if (i >= 0) {
            this.mLayoutMode = 4;
            this.mSpecificTop = this.mListPadding.top + i2;
            if (this.mNeedSync) {
                this.mSyncPosition = i;
                this.mSyncRowId = this.mAdapter.getItemId(i);
            }
            if (this.mPositionScroller != null) {
                this.mPositionScroller.stop();
            }
            requestLayout();
        }
    }

    abstract void setSelectionInt(int i);

    public void setSelector(int i) {
        setSelector(getContext().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        if (this.mSelector != null) {
            this.mSelector.setCallback(null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromBottom(boolean z) {
        if (this.mStackFromBottom != z) {
            this.mStackFromBottom = z;
            requestLayoutIfNecessary();
        }
    }

    public void setTextFilterEnabled(boolean z) {
        this.mTextFilterEnabled = z;
    }

    public void setTranscriptMode(int i) {
        this.mTranscriptMode = i;
    }

    public void setVelocityScale(float f) {
        this.mVelocityScale = f;
    }

    @Override // android.view.View
    public void setVerticalScrollbarPosition(int i) {
        super.setVerticalScrollbarPosition(i);
        if (this.mFastScroll != null) {
            this.mFastScroll.setScrollbarPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVisibleRangeHint(int i, int i2) {
        if (this.mRemoteAdapter != null) {
            this.mRemoteAdapter.setVisibleRangeHint(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldShowSelector() {
        if (!isFocused() || isInTouchMode()) {
            return touchModeDrawsInPressedState() && isPressed();
        }
        return true;
    }

    @Override // android.view.View
    public boolean showContextMenu(float f, float f2, int i) {
        int pointToPosition = pointToPosition((int) f, (int) f2);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            if (childAt != null) {
                this.mContextMenuInfo = createContextMenuInfo(childAt, pointToPosition, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return super.showContextMenu(f, f2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.mAdapter.getItemId(positionForView);
            boolean z = false;
            if (this.mOnItemLongClickListener != null) {
                z = this.mOnItemLongClickListener.onItemLongClick(this, view, positionForView, itemId);
            }
            boolean z2 = z;
            if (!z) {
                this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
                z2 = super.showContextMenuForChild(view);
            }
            return z2;
        }
        return false;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, false);
    }

    void smoothScrollBy(int i, int i2, boolean z) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        int i3 = this.mFirstPosition;
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int height = getHeight();
        int paddingBottom = getPaddingBottom();
        if (i != 0 && this.mItemCount != 0 && childCount != 0 && ((i3 != 0 || getChildAt(0).getTop() != paddingTop || i >= 0) && (i3 + childCount != this.mItemCount || getChildAt(childCount - 1).getBottom() != height - paddingBottom || i <= 0))) {
            reportScrollStateChange(2);
            this.mFlingRunnable.startScroll(i, i2, z);
            return;
        }
        this.mFlingRunnable.endFling();
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void smoothScrollByOffset(int i) {
        View childAt;
        Rect rect;
        int i2 = -1;
        if (i < 0) {
            i2 = getFirstVisiblePosition();
        } else if (i > 0) {
            i2 = getLastVisiblePosition();
        }
        if (i2 <= -1 || (childAt = getChildAt(i2 - getFirstVisiblePosition())) == null) {
            return;
        }
        int i3 = i2;
        if (childAt.getGlobalVisibleRect(new Rect())) {
            float width = (rect.width() * rect.height()) / (childAt.getWidth() * childAt.getHeight());
            if (i >= 0 || width >= 0.75f) {
                i3 = i2;
                if (i > 0) {
                    i3 = i2;
                    if (width < 0.75f) {
                        i3 = i2 - 1;
                    }
                }
            } else {
                i3 = i2 + 1;
            }
        }
        smoothScrollToPosition(Math.max(0, Math.min(getCount(), i3 + i)));
    }

    public void smoothScrollToPosition(int i) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = createPositionScroller();
        }
        this.mPositionScroller.start(i);
    }

    public void smoothScrollToPosition(int i, int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = createPositionScroller();
        }
        this.mPositionScroller.start(i, i2);
    }

    public void smoothScrollToPositionFromTop(int i, int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = createPositionScroller();
        }
        this.mPositionScroller.startWithOffset(i, i2);
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = createPositionScroller();
        }
        this.mPositionScroller.startWithOffset(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean touchModeDrawsInPressedState() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    boolean trackMotionScroll(int i, int i2) {
        int i3;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int top = getChildAt(0).getTop();
        int bottom = getChildAt(childCount - 1).getBottom();
        Rect rect = this.mListPadding;
        int i5 = 0;
        int i6 = 0;
        if ((this.mGroupFlags & 34) == 34) {
            i5 = rect.top;
            i6 = rect.bottom;
        }
        int height = getHeight();
        int height2 = (getHeight() - this.mPaddingBottom) - this.mPaddingTop;
        int max = i < 0 ? Math.max(-(height2 - 1), i) : Math.min(height2 - 1, i);
        int max2 = i2 < 0 ? Math.max(-(height2 - 1), i2) : Math.min(height2 - 1, i2);
        int i7 = this.mFirstPosition;
        if (i7 == 0) {
            this.mFirstPositionDistanceGuess = top - rect.top;
        } else {
            this.mFirstPositionDistanceGuess += max2;
        }
        if (i7 + childCount == this.mItemCount) {
            this.mLastPositionDistanceGuess = rect.bottom + bottom;
        } else {
            this.mLastPositionDistanceGuess += max2;
        }
        boolean z = i7 == 0 && top >= rect.top && max2 >= 0;
        boolean z2 = i7 + childCount == this.mItemCount && bottom <= getHeight() - rect.bottom && max2 <= 0;
        if (z || z2) {
            return max2 != 0;
        }
        boolean z3 = max2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            hideSelector();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.mItemCount - getFooterViewsCount();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        if (!z3) {
            int height3 = getHeight() - max2;
            int i11 = height3;
            if ((this.mGroupFlags & 34) == 34) {
                i11 = height3 - rect.bottom;
            }
            int i12 = childCount;
            while (true) {
                int i13 = i12 - 1;
                i3 = i9;
                i4 = i8;
                if (i13 < 0) {
                    break;
                }
                View childAt = getChildAt(i13);
                i3 = i9;
                i4 = i8;
                if (childAt.getTop() <= i11) {
                    break;
                }
                i8 = i13;
                i9++;
                int i14 = i7 + i13;
                if (i14 >= headerViewsCount && i14 < footerViewsCount) {
                    childAt.clearAccessibilityFocus();
                    this.mRecycler.addScrapView(childAt, i14);
                }
                i12 = i13;
            }
        } else {
            int i15 = -max2;
            int i16 = i15;
            if ((this.mGroupFlags & 34) == 34) {
                i16 = i15 + rect.top;
            }
            int i17 = 0;
            while (true) {
                int i18 = i17;
                i3 = i10;
                i4 = 0;
                if (i18 >= childCount) {
                    break;
                }
                View childAt2 = getChildAt(i18);
                if (childAt2.getBottom() >= i16) {
                    i4 = 0;
                    i3 = i10;
                    break;
                }
                i10++;
                int i19 = i7 + i18;
                if (i19 >= headerViewsCount && i19 < footerViewsCount) {
                    childAt2.clearAccessibilityFocus();
                    this.mRecycler.addScrapView(childAt2, i19);
                }
                i17 = i18 + 1;
            }
        }
        this.mMotionViewNewTop = this.mMotionViewOriginalTop + max;
        this.mBlockLayoutRequests = true;
        if (i3 > 0) {
            detachViewsFromParent(i4, i3);
            this.mRecycler.removeSkippedScrap();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        offsetChildrenTopAndBottom(max2);
        if (z3) {
            this.mFirstPosition += i3;
        }
        int abs = Math.abs(max2);
        if (i5 - top < abs || bottom - (height - i6) < abs) {
            fillGap(z3);
        }
        if (!isInTouchMode && this.mSelectedPosition != -1) {
            int i20 = this.mSelectedPosition - this.mFirstPosition;
            if (i20 >= 0 && i20 < getChildCount()) {
                positionSelector(this.mSelectedPosition, getChildAt(i20));
            }
        } else if (this.mSelectorPosition != -1) {
            int i21 = this.mSelectorPosition - this.mFirstPosition;
            if (i21 >= 0 && i21 < getChildCount()) {
                positionSelector(-1, getChildAt(i21));
            }
        } else {
            this.mSelectorRect.setEmpty();
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateScrollIndicators() {
        if (this.mScrollUp != null) {
            this.mScrollUp.setVisibility(canScrollUp() ? 0 : 4);
        }
        if (this.mScrollDown != null) {
            this.mScrollDown.setVisibility(canScrollDown() ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateSelectorState() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(StateSet.NOTHING);
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.mSelector == drawable || super.verifyDrawable(drawable);
    }
}
