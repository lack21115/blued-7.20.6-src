package android.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pools;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup.class */
public abstract class ViewGroup extends View implements ViewParent, ViewManager {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final int ARRAY_INITIAL_CAPACITY = 12;
    private static final int CHILD_LEFT_INDEX = 0;
    private static final int CHILD_TOP_INDEX = 1;
    protected static final int CLIP_TO_PADDING_MASK = 34;
    private static final boolean DBG = false;
    private static final int FLAG_ADD_STATES_FROM_CHILDREN = 8192;
    static final int FLAG_ALWAYS_DRAWN_WITH_CACHE = 16384;
    private static final int FLAG_ANIMATION_CACHE = 64;
    static final int FLAG_ANIMATION_DONE = 16;
    static final int FLAG_CHILDREN_DRAWN_WITH_CACHE = 32768;
    static final int FLAG_CLEAR_TRANSFORMATION = 256;
    static final int FLAG_CLIP_CHILDREN = 1;
    private static final int FLAG_CLIP_TO_PADDING = 2;
    protected static final int FLAG_DISALLOW_INTERCEPT = 524288;
    static final int FLAG_INVALIDATE_REQUIRED = 4;
    static final int FLAG_IS_TRANSITION_GROUP = 16777216;
    static final int FLAG_IS_TRANSITION_GROUP_SET = 33554432;
    private static final int FLAG_LAYOUT_MODE_WAS_EXPLICITLY_SET = 8388608;
    private static final int FLAG_MASK_FOCUSABILITY = 393216;
    private static final int FLAG_NOTIFY_ANIMATION_LISTENER = 512;
    private static final int FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE = 65536;
    static final int FLAG_OPTIMIZE_INVALIDATE = 128;
    private static final int FLAG_PADDING_NOT_NULL = 32;
    private static final int FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW = 4194304;
    private static final int FLAG_RUN_ANIMATION = 8;
    private static final int FLAG_SPLIT_MOTION_EVENTS = 2097152;
    protected static final int FLAG_SUPPORT_STATIC_TRANSFORMATIONS = 2048;
    static final int FLAG_TOUCHSCREEN_BLOCKS_FOCUS = 67108864;
    protected static final int FLAG_USE_CHILD_DRAWING_ORDER = 1024;
    public static final int FOCUS_AFTER_DESCENDANTS = 262144;
    public static final int FOCUS_BEFORE_DESCENDANTS = 131072;
    public static final int FOCUS_BLOCK_DESCENDANTS = 393216;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    private static final int LAYOUT_MODE_UNDEFINED = -1;
    public static final int PERSISTENT_ALL_CACHES = 3;
    public static final int PERSISTENT_ANIMATION_CACHE = 1;
    public static final int PERSISTENT_NO_CACHE = 0;
    public static final int PERSISTENT_SCROLLING_CACHE = 2;
    private static final String TAG = "ViewGroup";
    private static float[] sDebugLines;
    private static Paint sDebugPaint;
    private Animation.AnimationListener mAnimationListener;
    Paint mCachePaint;
    private boolean mChildAcceptsDrag;
    @ViewDebug.ExportedProperty(category = "layout")
    private int mChildCountWithTransientState;
    private Transformation mChildTransformation;
    private View[] mChildren;
    private int mChildrenCount;
    private DragEvent mCurrentDrag;
    private View mCurrentDragView;
    protected ArrayList<View> mDisappearingChildren;
    private HashSet<View> mDragNotifiedChildren;
    private HoverTarget mFirstHoverTarget;
    private TouchTarget mFirstTouchTarget;
    private View mFocused;
    @ViewDebug.ExportedProperty(flagMapping = {@ViewDebug.FlagToString(equals = 1, mask = 1, name = "CLIP_CHILDREN"), @ViewDebug.FlagToString(equals = 2, mask = 2, name = "CLIP_TO_PADDING"), @ViewDebug.FlagToString(equals = 32, mask = 32, name = "PADDING_NOT_NULL")}, formatToHexString = true)
    protected int mGroupFlags;
    private boolean mHoveredSelf;
    RectF mInvalidateRegion;
    Transformation mInvalidationTransformation;
    @ViewDebug.ExportedProperty(category = d.f40716ar)
    private int mLastTouchDownIndex;
    @ViewDebug.ExportedProperty(category = d.f40716ar)
    private long mLastTouchDownTime;
    @ViewDebug.ExportedProperty(category = d.f40716ar)
    private float mLastTouchDownX;
    @ViewDebug.ExportedProperty(category = d.f40716ar)
    private float mLastTouchDownY;
    private LayoutAnimationController mLayoutAnimationController;
    private boolean mLayoutCalledWhileSuppressed;
    private int mLayoutMode;
    private LayoutTransition.TransitionListener mLayoutTransitionListener;
    private PointF mLocalPoint;
    private int mNestedScrollAxes;
    protected OnHierarchyChangeListener mOnHierarchyChangeListener;
    protected int mPersistentDrawingCache;
    private ArrayList<View> mPreSortedChildren;
    boolean mSuppressLayout;
    private float[] mTempPoint;
    private LayoutTransition mTransition;
    private ArrayList<View> mTransitioningViews;
    private ArrayList<View> mVisibilityChangingChildren;
    public static boolean DEBUG_DRAW = false;
    private static final int[] DESCENDANT_FOCUSABILITY_FLAGS = {131072, 262144, 393216};
    public static int LAYOUT_MODE_DEFAULT = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup$ChildListForAccessibility.class */
    public static class ChildListForAccessibility {
        private static final int MAX_POOL_SIZE = 32;
        private static final Pools.SynchronizedPool<ChildListForAccessibility> sPool = new Pools.SynchronizedPool<>(32);
        private final ArrayList<View> mChildren = new ArrayList<>();
        private final ArrayList<ViewLocationHolder> mHolders = new ArrayList<>();

        ChildListForAccessibility() {
        }

        private void clear() {
            this.mChildren.clear();
        }

        private void init(ViewGroup viewGroup, boolean z) {
            ArrayList<View> arrayList = this.mChildren;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                arrayList.add(viewGroup.getChildAt(i2));
                i = i2 + 1;
            }
            if (!z) {
                return;
            }
            ArrayList<ViewLocationHolder> arrayList2 = this.mHolders;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= childCount) {
                    break;
                }
                arrayList2.add(ViewLocationHolder.obtain(viewGroup, arrayList.get(i4)));
                i3 = i4 + 1;
            }
            sort(arrayList2);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= childCount) {
                    arrayList2.clear();
                    return;
                }
                ViewLocationHolder viewLocationHolder = arrayList2.get(i6);
                arrayList.set(i6, viewLocationHolder.mView);
                viewLocationHolder.recycle();
                i5 = i6 + 1;
            }
        }

        public static ChildListForAccessibility obtain(ViewGroup viewGroup, boolean z) {
            ChildListForAccessibility acquire = sPool.acquire();
            ChildListForAccessibility childListForAccessibility = acquire;
            if (acquire == null) {
                childListForAccessibility = new ChildListForAccessibility();
            }
            childListForAccessibility.init(viewGroup, z);
            return childListForAccessibility;
        }

        private void sort(ArrayList<ViewLocationHolder> arrayList) {
            try {
                ViewLocationHolder.setComparisonStrategy(1);
                Collections.sort(arrayList);
            } catch (IllegalArgumentException e) {
                ViewLocationHolder.setComparisonStrategy(2);
                Collections.sort(arrayList);
            }
        }

        public View getChildAt(int i) {
            return this.mChildren.get(i);
        }

        public int getChildCount() {
            return this.mChildren.size();
        }

        public int getChildIndex(View view) {
            return this.mChildren.indexOf(view);
        }

        public void recycle() {
            clear();
            sPool.release(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup$HoverTarget.class */
    public static final class HoverTarget {
        private static final int MAX_RECYCLED = 32;
        private static HoverTarget sRecycleBin;
        private static final Object sRecycleLock = new Object[0];
        private static int sRecycledCount;
        public View child;
        public HoverTarget next;

        private HoverTarget() {
        }

        public static HoverTarget obtain(View view) {
            HoverTarget hoverTarget;
            synchronized (sRecycleLock) {
                if (sRecycleBin == null) {
                    hoverTarget = new HoverTarget();
                } else {
                    hoverTarget = sRecycleBin;
                    sRecycleBin = hoverTarget.next;
                    sRecycledCount--;
                    hoverTarget.next = null;
                }
            }
            hoverTarget.child = view;
            return hoverTarget;
        }

        public void recycle() {
            synchronized (sRecycleLock) {
                if (sRecycledCount < 32) {
                    this.next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount++;
                } else {
                    this.next = null;
                }
                this.child = null;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup$LayoutParams.class */
    public static class LayoutParams {
        @Deprecated
        public static final int FILL_PARENT = -1;
        public static final int MATCH_PARENT = -1;
        public static final int WRAP_CONTENT = -2;
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = -1, to = "MATCH_PARENT"), @ViewDebug.IntToString(from = -2, to = "WRAP_CONTENT")})
        public int height;
        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = -1, to = "MATCH_PARENT"), @ViewDebug.IntToString(from = -2, to = "WRAP_CONTENT")})
        public int width;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LayoutParams() {
        }

        public LayoutParams(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewGroup_Layout);
            setBaseAttributes(obtainStyledAttributes, 0, 1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            this.width = layoutParams.width;
            this.height = layoutParams.height;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static String sizeToString(int i) {
            return i == -2 ? "wrap-content" : i == -1 ? "match-parent" : String.valueOf(i);
        }

        public String debug(String str) {
            return str + "ViewGroup.LayoutParams={ width=" + sizeToString(this.width) + ", height=" + sizeToString(this.height) + " }";
        }

        public void onDebugDraw(View view, Canvas canvas, Paint paint) {
        }

        public void resolveLayoutDirection(int i) {
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, "layout_width");
            this.height = typedArray.getLayoutDimension(i2, "layout_height");
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup$MarginLayoutParams.class */
    public static class MarginLayoutParams extends LayoutParams {
        public static final int DEFAULT_MARGIN_RELATIVE = Integer.MIN_VALUE;
        private static final int DEFAULT_MARGIN_RESOLVED = 0;
        private static final int LAYOUT_DIRECTION_MASK = 3;
        private static final int LEFT_MARGIN_UNDEFINED_MASK = 4;
        private static final int NEED_RESOLUTION_MASK = 32;
        private static final int RIGHT_MARGIN_UNDEFINED_MASK = 8;
        private static final int RTL_COMPATIBILITY_MODE_MASK = 16;
        private static final int UNDEFINED_MARGIN = Integer.MIN_VALUE;
        @ViewDebug.ExportedProperty(category = "layout")
        public int bottomMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        private int endMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        public int leftMargin;
        @ViewDebug.ExportedProperty(category = "layout", flagMapping = {@ViewDebug.FlagToString(equals = 3, mask = 3, name = "LAYOUT_DIRECTION"), @ViewDebug.FlagToString(equals = 4, mask = 4, name = "LEFT_MARGIN_UNDEFINED_MASK"), @ViewDebug.FlagToString(equals = 8, mask = 8, name = "RIGHT_MARGIN_UNDEFINED_MASK"), @ViewDebug.FlagToString(equals = 16, mask = 16, name = "RTL_COMPATIBILITY_MODE_MASK"), @ViewDebug.FlagToString(equals = 32, mask = 32, name = "NEED_RESOLUTION_MASK")}, formatToHexString = true)
        byte mMarginFlags;
        @ViewDebug.ExportedProperty(category = "layout")
        public int rightMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        private int startMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        public int topMargin;

        public MarginLayoutParams(int i, int i2) {
            super(i, i2);
            this.startMargin = Integer.MIN_VALUE;
            this.endMargin = Integer.MIN_VALUE;
            this.mMarginFlags = (byte) (this.mMarginFlags | 4);
            this.mMarginFlags = (byte) (this.mMarginFlags | 8);
            this.mMarginFlags = (byte) (this.mMarginFlags & (-33));
            this.mMarginFlags = (byte) (this.mMarginFlags & (-17));
        }

        public MarginLayoutParams(Context context, AttributeSet attributeSet) {
            boolean z = true;
            this.startMargin = Integer.MIN_VALUE;
            this.endMargin = Integer.MIN_VALUE;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewGroup_MarginLayout);
            setBaseAttributes(obtainStyledAttributes, 0, 1);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, -1);
            if (dimensionPixelSize >= 0) {
                this.leftMargin = dimensionPixelSize;
                this.topMargin = dimensionPixelSize;
                this.rightMargin = dimensionPixelSize;
                this.bottomMargin = dimensionPixelSize;
            } else {
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(3, Integer.MIN_VALUE);
                if (this.leftMargin == Integer.MIN_VALUE) {
                    this.mMarginFlags = (byte) (this.mMarginFlags | 4);
                    this.leftMargin = 0;
                }
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(5, Integer.MIN_VALUE);
                if (this.rightMargin == Integer.MIN_VALUE) {
                    this.mMarginFlags = (byte) (this.mMarginFlags | 8);
                    this.rightMargin = 0;
                }
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(4, 0);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                this.startMargin = obtainStyledAttributes.getDimensionPixelSize(7, Integer.MIN_VALUE);
                this.endMargin = obtainStyledAttributes.getDimensionPixelSize(8, Integer.MIN_VALUE);
                if (isMarginRelative()) {
                    this.mMarginFlags = (byte) (this.mMarginFlags | 32);
                }
            }
            boolean hasRtlSupport = context.getApplicationInfo().hasRtlSupport();
            z = (context.getApplicationInfo().flags & 1) == 0 ? false : z;
            if ((context.getApplicationInfo().targetSdkVersion < 17 && !z) || !hasRtlSupport) {
                this.mMarginFlags = (byte) (this.mMarginFlags | 16);
            }
            this.mMarginFlags = (byte) (this.mMarginFlags | 0);
            obtainStyledAttributes.recycle();
        }

        public MarginLayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.startMargin = Integer.MIN_VALUE;
            this.endMargin = Integer.MIN_VALUE;
            this.mMarginFlags = (byte) (this.mMarginFlags | 4);
            this.mMarginFlags = (byte) (this.mMarginFlags | 8);
            this.mMarginFlags = (byte) (this.mMarginFlags & (-33));
            this.mMarginFlags = (byte) (this.mMarginFlags & (-17));
        }

        public MarginLayoutParams(MarginLayoutParams marginLayoutParams) {
            this.startMargin = Integer.MIN_VALUE;
            this.endMargin = Integer.MIN_VALUE;
            this.width = marginLayoutParams.width;
            this.height = marginLayoutParams.height;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
            this.startMargin = marginLayoutParams.startMargin;
            this.endMargin = marginLayoutParams.endMargin;
            this.mMarginFlags = marginLayoutParams.mMarginFlags;
        }

        private void doResolveMargins() {
            if ((this.mMarginFlags & 16) != 16) {
                switch (this.mMarginFlags & 3) {
                    case 1:
                        this.leftMargin = this.endMargin > Integer.MIN_VALUE ? this.endMargin : 0;
                        int i = 0;
                        if (this.startMargin > Integer.MIN_VALUE) {
                            i = this.startMargin;
                        }
                        this.rightMargin = i;
                        break;
                    default:
                        this.leftMargin = this.startMargin > Integer.MIN_VALUE ? this.startMargin : 0;
                        int i2 = 0;
                        if (this.endMargin > Integer.MIN_VALUE) {
                            i2 = this.endMargin;
                        }
                        this.rightMargin = i2;
                        break;
                }
            } else {
                if ((this.mMarginFlags & 4) == 4 && this.startMargin > Integer.MIN_VALUE) {
                    this.leftMargin = this.startMargin;
                }
                if ((this.mMarginFlags & 8) == 8 && this.endMargin > Integer.MIN_VALUE) {
                    this.rightMargin = this.endMargin;
                }
            }
            this.mMarginFlags = (byte) (this.mMarginFlags & (-33));
        }

        public final void copyMarginsFrom(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
            this.startMargin = marginLayoutParams.startMargin;
            this.endMargin = marginLayoutParams.endMargin;
            this.mMarginFlags = marginLayoutParams.mMarginFlags;
        }

        public int getLayoutDirection() {
            return this.mMarginFlags & 3;
        }

        public int getMarginEnd() {
            if (this.endMargin != Integer.MIN_VALUE) {
                return this.endMargin;
            }
            if ((this.mMarginFlags & 32) == 32) {
                doResolveMargins();
            }
            switch (this.mMarginFlags & 3) {
                case 1:
                    return this.leftMargin;
                default:
                    return this.rightMargin;
            }
        }

        public int getMarginStart() {
            if (this.startMargin != Integer.MIN_VALUE) {
                return this.startMargin;
            }
            if ((this.mMarginFlags & 32) == 32) {
                doResolveMargins();
            }
            switch (this.mMarginFlags & 3) {
                case 1:
                    return this.rightMargin;
                default:
                    return this.leftMargin;
            }
        }

        public boolean isLayoutRtl() {
            return (this.mMarginFlags & 3) == 1;
        }

        public boolean isMarginRelative() {
            return (this.startMargin == Integer.MIN_VALUE && this.endMargin == Integer.MIN_VALUE) ? false : true;
        }

        @Override // android.view.ViewGroup.LayoutParams
        public void onDebugDraw(View view, Canvas canvas, Paint paint) {
            Insets opticalInsets = View.isLayoutModeOptical(view.mParent) ? view.getOpticalInsets() : Insets.NONE;
            ViewGroup.fillDifference(canvas, opticalInsets.left + view.getLeft(), opticalInsets.top + view.getTop(), view.getRight() - opticalInsets.right, view.getBottom() - opticalInsets.bottom, this.leftMargin, this.topMargin, this.rightMargin, this.bottomMargin, paint);
        }

        @Override // android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int i) {
            setLayoutDirection(i);
            if (isMarginRelative() && (this.mMarginFlags & 32) == 32) {
                doResolveMargins();
            }
        }

        public void setLayoutDirection(int i) {
            if ((i == 0 || i == 1) && i != (this.mMarginFlags & 3)) {
                this.mMarginFlags = (byte) (this.mMarginFlags & (-4));
                this.mMarginFlags = (byte) (this.mMarginFlags | (i & 3));
                if (isMarginRelative()) {
                    this.mMarginFlags = (byte) (this.mMarginFlags | 32);
                } else {
                    this.mMarginFlags = (byte) (this.mMarginFlags & (-33));
                }
            }
        }

        public void setMarginEnd(int i) {
            this.endMargin = i;
            this.mMarginFlags = (byte) (this.mMarginFlags | 32);
        }

        public void setMarginStart(int i) {
            this.startMargin = i;
            this.mMarginFlags = (byte) (this.mMarginFlags | 32);
        }

        public void setMargins(int i, int i2, int i3, int i4) {
            this.leftMargin = i;
            this.topMargin = i2;
            this.rightMargin = i3;
            this.bottomMargin = i4;
            this.mMarginFlags = (byte) (this.mMarginFlags & (-5));
            this.mMarginFlags = (byte) (this.mMarginFlags & (-9));
            if (isMarginRelative()) {
                this.mMarginFlags = (byte) (this.mMarginFlags | 32);
            } else {
                this.mMarginFlags = (byte) (this.mMarginFlags & (-33));
            }
        }

        public void setMarginsRelative(int i, int i2, int i3, int i4) {
            this.startMargin = i;
            this.topMargin = i2;
            this.endMargin = i3;
            this.bottomMargin = i4;
            this.mMarginFlags = (byte) (this.mMarginFlags | 32);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup$OnHierarchyChangeListener.class */
    public interface OnHierarchyChangeListener {
        void onChildViewAdded(View view, View view2);

        void onChildViewRemoved(View view, View view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup$TouchTarget.class */
    public static final class TouchTarget {
        public static final int ALL_POINTER_IDS = -1;
        private static final int MAX_RECYCLED = 32;
        private static TouchTarget sRecycleBin;
        private static final Object sRecycleLock = new Object[0];
        private static int sRecycledCount;
        public View child;
        public TouchTarget next;
        public int pointerIdBits;

        private TouchTarget() {
        }

        public static TouchTarget obtain(View view, int i) {
            TouchTarget touchTarget;
            synchronized (sRecycleLock) {
                if (sRecycleBin == null) {
                    touchTarget = new TouchTarget();
                } else {
                    touchTarget = sRecycleBin;
                    sRecycleBin = touchTarget.next;
                    sRecycledCount--;
                    touchTarget.next = null;
                }
            }
            touchTarget.child = view;
            touchTarget.pointerIdBits = i;
            return touchTarget;
        }

        public void recycle() {
            synchronized (sRecycleLock) {
                if (sRecycledCount < 32) {
                    this.next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount++;
                } else {
                    this.next = null;
                }
                this.child = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroup$ViewLocationHolder.class */
    public static class ViewLocationHolder implements Comparable<ViewLocationHolder> {
        public static final int COMPARISON_STRATEGY_LOCATION = 2;
        public static final int COMPARISON_STRATEGY_STRIPE = 1;
        private static final int MAX_POOL_SIZE = 32;
        private int mLayoutDirection;
        private final Rect mLocation = new Rect();
        public View mView;
        private static final Pools.SynchronizedPool<ViewLocationHolder> sPool = new Pools.SynchronizedPool<>(32);
        private static int sComparisonStrategy = 1;

        ViewLocationHolder() {
        }

        private void clear() {
            this.mView = null;
            this.mLocation.set(0, 0, 0, 0);
        }

        private void init(ViewGroup viewGroup, View view) {
            Rect rect = this.mLocation;
            view.getDrawingRect(rect);
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            this.mView = view;
            this.mLayoutDirection = viewGroup.getLayoutDirection();
        }

        public static ViewLocationHolder obtain(ViewGroup viewGroup, View view) {
            ViewLocationHolder acquire = sPool.acquire();
            ViewLocationHolder viewLocationHolder = acquire;
            if (acquire == null) {
                viewLocationHolder = new ViewLocationHolder();
            }
            viewLocationHolder.init(viewGroup, view);
            return viewLocationHolder;
        }

        public static void setComparisonStrategy(int i) {
            sComparisonStrategy = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
            if ((r3.mLocation.top - r4.mLocation.bottom) < 0) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
            if (r0 == 0) goto L17;
         */
        @Override // java.lang.Comparable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int compareTo(android.view.ViewGroup.ViewLocationHolder r4) {
            /*
                Method dump skipped, instructions count: 189
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.view.ViewGroup.ViewLocationHolder.compareTo(android.view.ViewGroup$ViewLocationHolder):int");
        }

        public void recycle() {
            clear();
            sPool.release(this);
        }
    }

    public ViewGroup(Context context) {
        this(context, null);
    }

    public ViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mLastTouchDownIndex = -1;
        this.mLayoutMode = -1;
        this.mSuppressLayout = false;
        this.mLayoutCalledWhileSuppressed = false;
        this.mChildCountWithTransientState = 0;
        this.mLayoutTransitionListener = new LayoutTransition.TransitionListener() { // from class: android.view.ViewGroup.3
            @Override // android.animation.LayoutTransition.TransitionListener
            public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i3) {
                if (ViewGroup.this.mLayoutCalledWhileSuppressed && !layoutTransition.isChangingLayout()) {
                    ViewGroup.this.requestLayout();
                    ViewGroup.this.mLayoutCalledWhileSuppressed = false;
                }
                if (i3 != 3 || ViewGroup.this.mTransitioningViews == null) {
                    return;
                }
                ViewGroup.this.endViewTransition(view);
            }

            @Override // android.animation.LayoutTransition.TransitionListener
            public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i3) {
                if (i3 == 3) {
                    ViewGroup.this.startViewTransition(view);
                }
            }
        };
        initViewGroup();
        initFromAttributes(context, attributeSet, i, i2);
    }

    private void addDisappearingView(View view) {
        ArrayList<View> arrayList = this.mDisappearingChildren;
        ArrayList<View> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList<>();
            this.mDisappearingChildren = arrayList2;
        }
        arrayList2.add(view);
    }

    private void addInArray(View view, int i) {
        View[] viewArr = this.mChildren;
        int i2 = this.mChildrenCount;
        int length = viewArr.length;
        if (i == i2) {
            View[] viewArr2 = viewArr;
            if (length == i2) {
                this.mChildren = new View[length + 12];
                System.arraycopy(viewArr, 0, this.mChildren, 0, length);
                viewArr2 = this.mChildren;
            }
            int i3 = this.mChildrenCount;
            this.mChildrenCount = i3 + 1;
            viewArr2[i3] = view;
        } else if (i >= i2) {
            throw new IndexOutOfBoundsException("index=" + i + " count=" + i2);
        } else {
            if (length == i2) {
                this.mChildren = new View[length + 12];
                System.arraycopy(viewArr, 0, this.mChildren, 0, i);
                System.arraycopy(viewArr, i, this.mChildren, i + 1, i2 - i);
                viewArr = this.mChildren;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.mChildrenCount++;
            if (this.mLastTouchDownIndex >= i) {
                this.mLastTouchDownIndex++;
            }
        }
    }

    private TouchTarget addTouchTarget(View view, int i) {
        TouchTarget obtain = TouchTarget.obtain(view, i);
        obtain.next = this.mFirstTouchTarget;
        this.mFirstTouchTarget = obtain;
        return obtain;
    }

    private void addViewInner(View view, int i, LayoutParams layoutParams, boolean z) {
        if (this.mTransition != null) {
            this.mTransition.cancel(3);
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The specified child already has a parent. You must call removeView() on the child's parent first.");
        }
        if (this.mTransition != null) {
            this.mTransition.addChild(this, view);
        }
        LayoutParams layoutParams2 = layoutParams;
        if (!checkLayoutParams(layoutParams)) {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        if (z) {
            view.mLayoutParams = layoutParams2;
        } else {
            view.setLayoutParams(layoutParams2);
        }
        int i2 = i;
        if (i < 0) {
            i2 = this.mChildrenCount;
        }
        addInArray(view, i2);
        if (z) {
            view.assignParent(this);
        } else {
            view.mParent = this;
        }
        if (view.hasFocus()) {
            requestChildFocus(view, view.findFocus());
        }
        View.AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null && (this.mGroupFlags & 4194304) == 0) {
            boolean z2 = attachInfo.mKeepScreenOn;
            attachInfo.mKeepScreenOn = false;
            view.dispatchAttachedToWindow(this.mAttachInfo, this.mViewFlags & 12);
            if (attachInfo.mKeepScreenOn) {
                needGlobalAttributesUpdate(true);
            }
            attachInfo.mKeepScreenOn = z2;
        }
        if (view.isLayoutDirectionInherited()) {
            view.resetRtlProperties();
        }
        onViewAdded(view);
        if ((view.mViewFlags & 4194304) == 4194304) {
            this.mGroupFlags |= 65536;
        }
        if (view.hasTransientState()) {
            childHasTransientStateChanged(view, true);
        }
        if (view.getVisibility() != 8) {
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    private void bindLayoutAnimation(View view) {
        view.setAnimation(this.mLayoutAnimationController.getAnimationForView(view));
    }

    private static boolean canViewReceivePointerEvents(View view) {
        return (view.mViewFlags & 12) == 0 || view.getAnimation() != null;
    }

    private void cancelAndClearTouchTargets(MotionEvent motionEvent) {
        if (this.mFirstTouchTarget != null) {
            boolean z = false;
            MotionEvent motionEvent2 = motionEvent;
            if (motionEvent == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                motionEvent2.setSource(4098);
                z = true;
            }
            TouchTarget touchTarget = this.mFirstTouchTarget;
            while (true) {
                TouchTarget touchTarget2 = touchTarget;
                if (touchTarget2 == null) {
                    break;
                }
                resetCancelNextUpFlag(touchTarget2.child);
                dispatchTransformedTouchEvent(motionEvent2, true, touchTarget2.child, touchTarget2.pointerIdBits);
                touchTarget = touchTarget2.next;
            }
            clearTouchTargets();
            if (z) {
                motionEvent2.recycle();
            }
        }
    }

    private void cancelHoverTarget(View view) {
        HoverTarget hoverTarget = null;
        HoverTarget hoverTarget2 = this.mFirstHoverTarget;
        while (true) {
            HoverTarget hoverTarget3 = hoverTarget2;
            if (hoverTarget3 == null) {
                return;
            }
            HoverTarget hoverTarget4 = hoverTarget3.next;
            if (hoverTarget3.child == view) {
                if (hoverTarget == null) {
                    this.mFirstHoverTarget = hoverTarget4;
                } else {
                    hoverTarget.next = hoverTarget4;
                }
                hoverTarget3.recycle();
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 10, 0.0f, 0.0f, 0);
                obtain.setSource(4098);
                view.dispatchHoverEvent(obtain);
                obtain.recycle();
                return;
            }
            hoverTarget = hoverTarget3;
            hoverTarget2 = hoverTarget4;
        }
    }

    private void cancelTouchTarget(View view) {
        TouchTarget touchTarget = null;
        TouchTarget touchTarget2 = this.mFirstTouchTarget;
        while (true) {
            TouchTarget touchTarget3 = touchTarget2;
            if (touchTarget3 == null) {
                return;
            }
            TouchTarget touchTarget4 = touchTarget3.next;
            if (touchTarget3.child == view) {
                if (touchTarget == null) {
                    this.mFirstTouchTarget = touchTarget4;
                } else {
                    touchTarget.next = touchTarget4;
                }
                touchTarget3.recycle();
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                obtain.setSource(4098);
                view.dispatchTouchEvent(obtain);
                obtain.recycle();
                return;
            }
            touchTarget = touchTarget3;
            touchTarget2 = touchTarget4;
        }
    }

    private void clearCachedLayoutMode() {
        if (hasBooleanFlag(8388608)) {
            return;
        }
        this.mLayoutMode = -1;
    }

    private void clearTouchTargets() {
        TouchTarget touchTarget;
        TouchTarget touchTarget2 = this.mFirstTouchTarget;
        if (touchTarget2 != null) {
            do {
                touchTarget = touchTarget2.next;
                touchTarget2.recycle();
                touchTarget2 = touchTarget;
            } while (touchTarget != null);
            this.mFirstTouchTarget = null;
        }
    }

    private boolean debugDraw() {
        if (DEBUG_DRAW) {
            return true;
        }
        return this.mAttachInfo != null && this.mAttachInfo.mDebugLayout;
    }

    private int dipsToPixels(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        float f = this.mScrollX - view.mLeft;
        float f2 = this.mScrollY - view.mTop;
        if (view.hasIdentityMatrix()) {
            motionEvent.offsetLocation(f, f2);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEvent);
            motionEvent.offsetLocation(-f, -f2);
            return dispatchGenericMotionEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f, f2);
        obtain.transform(view.getInverseMatrix());
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(obtain);
        obtain.recycle();
        return dispatchGenericMotionEvent2;
    }

    private boolean dispatchTransformedTouchEvent(MotionEvent motionEvent, boolean z, View view, int i) {
        MotionEvent split;
        boolean dispatchTouchEvent;
        int action = motionEvent.getAction();
        if (z || action == 3) {
            motionEvent.setAction(3);
            boolean dispatchTouchEvent2 = view == null ? super.dispatchTouchEvent(motionEvent) : view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            return dispatchTouchEvent2;
        }
        int pointerIdBits = motionEvent.getPointerIdBits();
        int i2 = pointerIdBits & i;
        if (i2 == 0) {
            return false;
        }
        if (i2 != pointerIdBits) {
            split = motionEvent.split(i2);
        } else if (view == null || view.hasIdentityMatrix()) {
            if (view == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            float f = this.mScrollX - view.mLeft;
            float f2 = this.mScrollY - view.mTop;
            motionEvent.offsetLocation(f, f2);
            boolean dispatchTouchEvent3 = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f, -f2);
            return dispatchTouchEvent3;
        } else {
            split = MotionEvent.obtain(motionEvent);
        }
        if (view == null) {
            dispatchTouchEvent = super.dispatchTouchEvent(split);
        } else {
            split.offsetLocation(this.mScrollX - view.mLeft, this.mScrollY - view.mTop);
            if (!view.hasIdentityMatrix()) {
                split.transform(view.getInverseMatrix());
            }
            dispatchTouchEvent = view.dispatchTouchEvent(split);
        }
        split.recycle();
        return dispatchTouchEvent;
    }

    private static void drawCorner(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5) {
        fillRect(canvas, paint, i, i2, i + i3, i2 + (sign(i4) * i5));
        fillRect(canvas, paint, i, i2, i + (sign(i3) * i5), i2 + i4);
    }

    private static void drawRect(Canvas canvas, Paint paint, int i, int i2, int i3, int i4) {
        if (sDebugLines == null) {
            sDebugLines = new float[16];
        }
        sDebugLines[0] = i;
        sDebugLines[1] = i2;
        sDebugLines[2] = i3;
        sDebugLines[3] = i2;
        sDebugLines[4] = i3;
        sDebugLines[5] = i2;
        sDebugLines[6] = i3;
        sDebugLines[7] = i4;
        sDebugLines[8] = i3;
        sDebugLines[9] = i4;
        sDebugLines[10] = i;
        sDebugLines[11] = i4;
        sDebugLines[12] = i;
        sDebugLines[13] = i4;
        sDebugLines[14] = i;
        sDebugLines[15] = i2;
        canvas.drawLines(sDebugLines, paint);
    }

    private static void drawRectCorners(Canvas canvas, int i, int i2, int i3, int i4, Paint paint, int i5, int i6) {
        drawCorner(canvas, paint, i, i2, i5, i5, i6);
        drawCorner(canvas, paint, i, i4, i5, -i5, i6);
        drawCorner(canvas, paint, i3, i2, -i5, i5, i6);
        drawCorner(canvas, paint, i3, i4, -i5, -i5, i6);
    }

    private void exitHoverTargets() {
        if (this.mHoveredSelf || this.mFirstHoverTarget != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 10, 0.0f, 0.0f, 0);
            obtain.setSource(4098);
            dispatchHoverEvent(obtain);
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fillDifference(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Paint paint) {
        int i9 = i - i5;
        int i10 = i3 + i7;
        fillRect(canvas, paint, i9, i2 - i6, i10, i2);
        fillRect(canvas, paint, i9, i2, i, i4);
        fillRect(canvas, paint, i3, i2, i10, i4);
        fillRect(canvas, paint, i9, i4, i10, i4 + i8);
    }

    private static void fillRect(Canvas canvas, Paint paint, int i, int i2, int i3, int i4) {
        if (i == i3 || i2 == i4) {
            return;
        }
        int i5 = i;
        int i6 = i3;
        if (i > i3) {
            i6 = i;
            i5 = i3;
        }
        int i7 = i2;
        int i8 = i4;
        if (i2 > i4) {
            i8 = i2;
            i7 = i4;
        }
        canvas.drawRect(i5, i7, i6, i8, paint);
    }

    private View findChildWithAccessibilityFocus() {
        View accessibilityFocusedHost;
        ViewRootImpl viewRootImpl = getViewRootImpl();
        if (viewRootImpl == null) {
            accessibilityFocusedHost = null;
        } else {
            accessibilityFocusedHost = viewRootImpl.getAccessibilityFocusedHost();
            if (accessibilityFocusedHost == null) {
                return null;
            }
            ViewParent parent = accessibilityFocusedHost.getParent();
            while (true) {
                ViewParent viewParent = parent;
                if (!(viewParent instanceof View)) {
                    return null;
                }
                if (viewParent == this) {
                    break;
                }
                accessibilityFocusedHost = (View) viewParent;
                parent = accessibilityFocusedHost.getParent();
            }
        }
        return accessibilityFocusedHost;
    }

    public static int getChildMeasureSpec(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int max = Math.max(0, View.MeasureSpec.getSize(i) - i2);
        int i4 = 0;
        int i5 = 0;
        switch (mode) {
            case Integer.MIN_VALUE:
                if (i3 < 0) {
                    if (i3 != -1) {
                        if (i3 == -2) {
                            i4 = max;
                            i5 = Integer.MIN_VALUE;
                            break;
                        }
                    } else {
                        i4 = max;
                        i5 = Integer.MIN_VALUE;
                        break;
                    }
                } else {
                    i4 = i3;
                    i5 = 1073741824;
                    break;
                }
                break;
            case 0:
                if (i3 < 0) {
                    if (i3 != -1) {
                        if (i3 == -2) {
                            i4 = 0;
                            i5 = 0;
                            break;
                        }
                    } else {
                        i4 = 0;
                        i5 = 0;
                        break;
                    }
                } else {
                    i4 = i3;
                    i5 = 1073741824;
                    break;
                }
                break;
            case 1073741824:
                if (i3 < 0) {
                    if (i3 != -1) {
                        if (i3 == -2) {
                            i4 = max;
                            i5 = Integer.MIN_VALUE;
                            break;
                        }
                    } else {
                        i4 = max;
                        i5 = 1073741824;
                        break;
                    }
                } else {
                    i4 = i3;
                    i5 = 1073741824;
                    break;
                }
                break;
        }
        return View.MeasureSpec.makeMeasureSpec(i4, i5);
    }

    private static Paint getDebugPaint() {
        if (sDebugPaint == null) {
            sDebugPaint = new Paint();
            sDebugPaint.setAntiAlias(false);
        }
        return sDebugPaint;
    }

    private PointF getLocalPoint() {
        if (this.mLocalPoint == null) {
            this.mLocalPoint = new PointF();
        }
        return this.mLocalPoint;
    }

    private float[] getTempPoint() {
        if (this.mTempPoint == null) {
            this.mTempPoint = new float[2];
        }
        return this.mTempPoint;
    }

    private TouchTarget getTouchTarget(View view) {
        TouchTarget touchTarget = this.mFirstTouchTarget;
        while (true) {
            TouchTarget touchTarget2 = touchTarget;
            if (touchTarget2 == null) {
                return null;
            }
            if (touchTarget2.child == view) {
                return touchTarget2;
            }
            touchTarget = touchTarget2.next;
        }
    }

    private boolean hasBooleanFlag(int i) {
        return (this.mGroupFlags & i) == i;
    }

    private boolean hasChildWithZ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mChildrenCount) {
                return false;
            }
            if (this.mChildren[i2].getZ() != 0.0f) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewGroup, i, i2);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i4);
            switch (index) {
                case 0:
                    setClipChildren(obtainStyledAttributes.getBoolean(index, true));
                    break;
                case 1:
                    setClipToPadding(obtainStyledAttributes.getBoolean(index, true));
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId <= 0) {
                        break;
                    } else {
                        setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this.mContext, resourceId));
                        break;
                    }
                case 3:
                    setAnimationCacheEnabled(obtainStyledAttributes.getBoolean(index, true));
                    break;
                case 4:
                    setPersistentDrawingCache(obtainStyledAttributes.getInt(index, 2));
                    break;
                case 5:
                    setAlwaysDrawnWithCacheEnabled(obtainStyledAttributes.getBoolean(index, true));
                    break;
                case 6:
                    setAddStatesFromChildren(obtainStyledAttributes.getBoolean(index, false));
                    break;
                case 7:
                    setDescendantFocusability(DESCENDANT_FOCUSABILITY_FLAGS[obtainStyledAttributes.getInt(index, 0)]);
                    break;
                case 8:
                    setMotionEventSplittingEnabled(obtainStyledAttributes.getBoolean(index, false));
                    break;
                case 9:
                    if (!obtainStyledAttributes.getBoolean(index, false)) {
                        break;
                    } else {
                        setLayoutTransition(new LayoutTransition());
                        break;
                    }
                case 10:
                    setLayoutMode(obtainStyledAttributes.getInt(index, -1));
                    break;
                case 11:
                    setTransitionGroup(obtainStyledAttributes.getBoolean(index, false));
                    break;
                case 12:
                    setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(index, false));
                    break;
            }
            i3 = i4 + 1;
        }
    }

    private void initViewGroup() {
        if (!debugDraw()) {
            setFlags(128, 128);
        }
        this.mGroupFlags |= 1;
        this.mGroupFlags |= 2;
        this.mGroupFlags |= 16;
        this.mGroupFlags |= 64;
        this.mGroupFlags |= 16384;
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 11) {
            this.mGroupFlags |= 2097152;
        }
        setDescendantFocusability(131072);
        this.mChildren = new View[12];
        this.mChildrenCount = 0;
        this.mPersistentDrawingCache = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAnimationListener() {
        this.mGroupFlags &= -513;
        this.mGroupFlags |= 16;
        if (this.mAnimationListener != null) {
            post(new Runnable() { // from class: android.view.ViewGroup.2
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.this.mAnimationListener.onAnimationEnd(ViewGroup.this.mLayoutAnimationController.getAnimation());
                }
            });
        }
        if ((this.mGroupFlags & 64) == 64) {
            this.mGroupFlags &= -32769;
            if ((this.mPersistentDrawingCache & 1) == 0) {
                setChildrenDrawingCacheEnabled(false);
            }
        }
        invalidate(true);
    }

    private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent motionEvent) {
        return motionEvent.getHistorySize() == 0 ? motionEvent : MotionEvent.obtainNoHistory(motionEvent);
    }

    private void recreateChildDisplayList(View view) {
        view.mRecreateDisplayList = (view.mPrivateFlags & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        view.mPrivateFlags &= Integer.MAX_VALUE;
        view.getDisplayList();
        view.mRecreateDisplayList = false;
    }

    private void removeFromArray(int i) {
        View[] viewArr = this.mChildren;
        if (this.mTransitioningViews == null || !this.mTransitioningViews.contains(viewArr[i])) {
            viewArr[i].mParent = null;
        }
        int i2 = this.mChildrenCount;
        if (i == i2 - 1) {
            int i3 = this.mChildrenCount - 1;
            this.mChildrenCount = i3;
            viewArr[i3] = null;
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i + 1, viewArr, i, (i2 - i) - 1);
            int i4 = this.mChildrenCount - 1;
            this.mChildrenCount = i4;
            viewArr[i4] = null;
        }
        if (this.mLastTouchDownIndex == i) {
            this.mLastTouchDownTime = 0L;
            this.mLastTouchDownIndex = -1;
        } else if (this.mLastTouchDownIndex > i) {
            this.mLastTouchDownIndex--;
        }
    }

    private void removeFromArray(int i, int i2) {
        View[] viewArr = this.mChildren;
        int i3 = this.mChildrenCount;
        int max = Math.max(0, i);
        int min = Math.min(i3, max + i2);
        if (max == min) {
            return;
        }
        if (min != i3) {
            int i4 = max;
            while (true) {
                int i5 = i4;
                if (i5 >= min) {
                    break;
                }
                viewArr[i5].mParent = null;
                i4 = i5 + 1;
            }
            System.arraycopy(viewArr, min, viewArr, max, i3 - min);
            int i6 = i3 - (min - max);
            while (true) {
                int i7 = i6;
                if (i7 >= i3) {
                    break;
                }
                viewArr[i7] = null;
                i6 = i7 + 1;
            }
        } else {
            int i8 = max;
            while (true) {
                int i9 = i8;
                if (i9 >= min) {
                    break;
                }
                viewArr[i9].mParent = null;
                viewArr[i9] = null;
                i8 = i9 + 1;
            }
        }
        this.mChildrenCount -= min - max;
    }

    private void removePointersFromTouchTargets(int i) {
        TouchTarget touchTarget = null;
        TouchTarget touchTarget2 = this.mFirstTouchTarget;
        while (true) {
            TouchTarget touchTarget3 = touchTarget2;
            if (touchTarget3 == null) {
                return;
            }
            TouchTarget touchTarget4 = touchTarget3.next;
            if ((touchTarget3.pointerIdBits & i) != 0) {
                touchTarget3.pointerIdBits &= i ^ (-1);
                if (touchTarget3.pointerIdBits == 0) {
                    if (touchTarget == null) {
                        this.mFirstTouchTarget = touchTarget4;
                    } else {
                        touchTarget.next = touchTarget4;
                    }
                    touchTarget3.recycle();
                    touchTarget2 = touchTarget4;
                }
            }
            touchTarget = touchTarget3;
            touchTarget2 = touchTarget4;
        }
    }

    private void removeViewInternal(int i, View view) {
        if (this.mTransition != null) {
            this.mTransition.removeChild(this, view);
        }
        boolean z = false;
        if (view == this.mFocused) {
            view.unFocus(null);
            z = true;
        }
        view.clearAccessibilityFocus();
        cancelTouchTarget(view);
        cancelHoverTarget(view);
        if (view.getAnimation() != null || (this.mTransitioningViews != null && this.mTransitioningViews.contains(view))) {
            addDisappearingView(view);
        } else if (view.mAttachInfo != null) {
            view.dispatchDetachedFromWindow();
        }
        if (view.hasTransientState()) {
            childHasTransientStateChanged(view, false);
        }
        needGlobalAttributesUpdate(false);
        removeFromArray(i);
        if (z) {
            clearChildFocus(view);
            if (!rootViewRequestFocus()) {
                notifyGlobalFocusCleared(this);
            }
        }
        onViewRemoved(view);
        if (view.getVisibility() != 8) {
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    private boolean removeViewInternal(View view) {
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            removeViewInternal(indexOfChild, view);
            return true;
        }
        return false;
    }

    private void removeViewsInternal(int i, int i2) {
        View view = this.mFocused;
        boolean z = this.mAttachInfo != null;
        boolean z2 = false;
        View[] viewArr = this.mChildren;
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                break;
            }
            View view2 = viewArr[i4];
            if (this.mTransition != null) {
                this.mTransition.removeChild(this, view2);
            }
            if (view2 == view) {
                view2.unFocus(null);
                z2 = true;
            }
            view2.clearAccessibilityFocus();
            cancelTouchTarget(view2);
            cancelHoverTarget(view2);
            if (view2.getAnimation() != null || (this.mTransitioningViews != null && this.mTransitioningViews.contains(view2))) {
                addDisappearingView(view2);
            } else if (z) {
                view2.dispatchDetachedFromWindow();
            }
            if (view2.hasTransientState()) {
                childHasTransientStateChanged(view2, false);
            }
            needGlobalAttributesUpdate(false);
            onViewRemoved(view2);
            i3 = i4 + 1;
        }
        removeFromArray(i, i2);
        if (z2) {
            clearChildFocus(view);
            if (rootViewRequestFocus()) {
                return;
            }
            notifyGlobalFocusCleared(view);
        }
    }

    private static boolean resetCancelNextUpFlag(View view) {
        if ((view.mPrivateFlags & 67108864) != 0) {
            view.mPrivateFlags &= -67108865;
            return true;
        }
        return false;
    }

    private void resetTouchState() {
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        this.mGroupFlags &= -524289;
        this.mNestedScrollAxes = 0;
    }

    private void setBooleanFlag(int i, boolean z) {
        if (z) {
            this.mGroupFlags |= i;
        } else {
            this.mGroupFlags &= i ^ (-1);
        }
    }

    private void setLayoutMode(int i, boolean z) {
        this.mLayoutMode = i;
        setBooleanFlag(8388608, z);
    }

    private static int sign(int i) {
        return i >= 0 ? 1 : -1;
    }

    @Override // android.view.View
    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
        ChildListForAccessibility obtain = ChildListForAccessibility.obtain(this, true);
        try {
            int childCount = obtain.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    return;
                }
                View childAt = obtain.getChildAt(i2);
                if ((childAt.mViewFlags & 12) == 0) {
                    if (childAt.includeForAccessibility()) {
                        arrayList.add(childAt);
                    } else {
                        childAt.addChildrenForAccessibility(arrayList);
                    }
                }
                i = i2 + 1;
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        int i3 = i2;
        if (descendantFocusability != 393216) {
            int i4 = i2;
            if (shouldBlockFocusForTouchscreen()) {
                i4 = i2 | 1;
            }
            int i5 = this.mChildrenCount;
            View[] viewArr = this.mChildren;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                i3 = i4;
                if (i7 >= i5) {
                    break;
                }
                View view = viewArr[i7];
                if ((view.mViewFlags & 12) == 0) {
                    view.addFocusables(arrayList, i, i4);
                }
                i6 = i7 + 1;
            }
        }
        if (descendantFocusability != 262144 || size == arrayList.size()) {
            if (isFocusableInTouchMode() || !shouldBlockFocusForTouchscreen()) {
                super.addFocusables(arrayList, i, i3);
            }
        }
    }

    public boolean addStatesFromChildren() {
        return (this.mGroupFlags & 8192) != 0;
    }

    @Override // android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        super.addTouchables(arrayList);
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            View view = viewArr[i3];
            if ((view.mViewFlags & 12) == 0) {
                view.addTouchables(arrayList);
            }
            i2 = i3 + 1;
        }
    }

    public void addView(View view) {
        addView(view, -1);
    }

    public void addView(View view, int i) {
        if (view == null) {
            throw new IllegalArgumentException("Cannot add a null child view to a ViewGroup");
        }
        LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParams2 = generateDefaultLayoutParams;
            if (generateDefaultLayoutParams == null) {
                throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            }
        }
        addView(view, i, layoutParams2);
    }

    public void addView(View view, int i, int i2) {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = i;
        generateDefaultLayoutParams.height = i2;
        addView(view, -1, generateDefaultLayoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("Cannot add a null child view to a ViewGroup");
        }
        requestLayout();
        invalidate(true);
        addViewInner(view, i, layoutParams, false);
    }

    @Override // android.view.ViewManager
    public void addView(View view, LayoutParams layoutParams) {
        addView(view, -1, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        return addViewInLayout(view, i, layoutParams, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("Cannot add a null child view to a ViewGroup");
        }
        view.mParent = null;
        addViewInner(view, i, layoutParams, z);
        view.mPrivateFlags = (view.mPrivateFlags & (-6291457)) | 32;
        return true;
    }

    protected void attachLayoutAnimationParameters(View view, LayoutParams layoutParams, int i, int i2) {
        LayoutAnimationController.AnimationParameters animationParameters = layoutParams.layoutAnimationParameters;
        LayoutAnimationController.AnimationParameters animationParameters2 = animationParameters;
        if (animationParameters == null) {
            animationParameters2 = new LayoutAnimationController.AnimationParameters();
            layoutParams.layoutAnimationParameters = animationParameters2;
        }
        animationParameters2.count = i2;
        animationParameters2.index = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        view.mLayoutParams = layoutParams;
        int i2 = i;
        if (i < 0) {
            i2 = this.mChildrenCount;
        }
        addInArray(view, i2);
        view.mParent = this;
        view.mPrivateFlags = (view.mPrivateFlags & (-6291457) & (-32769)) | 32 | Integer.MIN_VALUE;
        this.mPrivateFlags |= Integer.MIN_VALUE;
        if (view.hasFocus()) {
            requestChildFocus(view, view.findFocus());
        }
    }

    @Override // android.view.ViewParent
    public void bringChildToFront(View view) {
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            removeFromArray(indexOfChild);
            addInArray(view, this.mChildrenCount);
            view.mParent = this;
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<View> buildOrderedChildList() {
        int i;
        int i2 = this.mChildrenCount;
        if (i2 <= 1 || !hasChildWithZ()) {
            return null;
        }
        if (this.mPreSortedChildren == null) {
            this.mPreSortedChildren = new ArrayList<>(i2);
        } else {
            this.mPreSortedChildren.ensureCapacity(i2);
        }
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mChildrenCount) {
                return this.mPreSortedChildren;
            }
            View view = this.mChildren[isChildrenDrawingOrderEnabled ? getChildDrawingOrder(this.mChildrenCount, i4) : i4];
            float z = view.getZ();
            int i5 = i4;
            while (true) {
                i = i5;
                if (i > 0 && this.mPreSortedChildren.get(i - 1).getZ() > z) {
                    i5 = i - 1;
                }
            }
            this.mPreSortedChildren.add(i, view);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canAnimate() {
        return this.mLayoutAnimationController != null;
    }

    @Override // android.view.View
    public void captureTransitioningViews(List<View> list) {
        if (getVisibility() != 0) {
            return;
        }
        if (isTransitionGroup()) {
            list.add(this);
            return;
        }
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            getChildAt(i2).captureTransitioningViews(list);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    @Override // android.view.ViewParent
    public void childDrawableStateChanged(View view) {
        if ((this.mGroupFlags & 8192) != 0) {
            refreshDrawableState();
        }
    }

    @Override // android.view.ViewParent
    public void childHasTransientStateChanged(View view, boolean z) {
        boolean hasTransientState = hasTransientState();
        if (z) {
            this.mChildCountWithTransientState++;
        } else {
            this.mChildCountWithTransientState--;
        }
        boolean hasTransientState2 = hasTransientState();
        if (this.mParent == null || hasTransientState == hasTransientState2) {
            return;
        }
        try {
            this.mParent.childHasTransientStateChanged(this, hasTransientState2);
        } catch (AbstractMethodError e) {
            Log.e(TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cleanupLayoutState(View view) {
        view.mPrivateFlags &= -4097;
    }

    @Override // android.view.ViewParent
    public void clearChildFocus(View view) {
        this.mFocused = null;
        if (this.mParent != null) {
            this.mParent.clearChildFocus(this);
        }
    }

    public void clearDisappearingChildren() {
        ArrayList<View> arrayList = this.mDisappearingChildren;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                arrayList.clear();
                invalidate();
                return;
            }
            View view = arrayList.get(i2);
            if (view.mAttachInfo != null) {
                view.dispatchDetachedFromWindow();
            }
            view.clearAnimation();
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void clearFocus() {
        if (this.mFocused == null) {
            super.clearFocus();
            return;
        }
        View view = this.mFocused;
        this.mFocused = null;
        view.clearFocus();
    }

    @Override // android.view.View
    Insets computeOpticalInsets() {
        if (isLayoutModeOptical()) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i5 < this.mChildrenCount) {
                View childAt = getChildAt(i5);
                int i6 = i4;
                int i7 = i;
                int i8 = i3;
                int i9 = i2;
                if (childAt.getVisibility() == 0) {
                    Insets opticalInsets = childAt.getOpticalInsets();
                    i7 = Math.max(i, opticalInsets.left);
                    i9 = Math.max(i2, opticalInsets.top);
                    i8 = Math.max(i3, opticalInsets.right);
                    i6 = Math.max(i4, opticalInsets.bottom);
                }
                i5++;
                i4 = i6;
                i = i7;
                i3 = i8;
                i2 = i9;
            }
            return Insets.of(i, i2, i3, i4);
        }
        return Insets.NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public Bitmap createSnapshot(Bitmap.Config config, int i, boolean z) {
        int i2 = this.mChildrenCount;
        int[] iArr = null;
        if (z) {
            int[] iArr2 = new int[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                iArr = iArr2;
                if (i4 >= i2) {
                    break;
                }
                View childAt = getChildAt(i4);
                iArr2[i4] = childAt.getVisibility();
                if (iArr2[i4] == 0) {
                    childAt.setVisibility(4);
                }
                i3 = i4 + 1;
            }
        }
        Bitmap createSnapshot = super.createSnapshot(config, i, z);
        if (z) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= i2) {
                    break;
                }
                getChildAt(i6).setVisibility(iArr[i6]);
                i5 = i6 + 1;
            }
        }
        return createSnapshot;
    }

    public void damageChild(View view, Rect rect) {
        View.AttachInfo attachInfo;
        ViewGroup invalidateChildInParent;
        if (damageChildDeferred(view) || (attachInfo = this.mAttachInfo) == null) {
            return;
        }
        int i = view.mLeft;
        int i2 = view.mTop;
        int i3 = i;
        ViewGroup viewGroup = this;
        int i4 = i2;
        if (!view.getMatrix().isIdentity()) {
            view.transformRect(rect);
            i4 = i2;
            viewGroup = this;
            i3 = i;
        }
        do {
            if (viewGroup instanceof ViewGroup) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2.mLayerType != 0) {
                    viewGroup2.invalidate();
                    invalidateChildInParent = null;
                } else {
                    invalidateChildInParent = viewGroup2.damageChildInParent(i3, i4, rect);
                    i3 = viewGroup2.mLeft;
                    i4 = viewGroup2.mTop;
                }
            } else {
                int[] iArr = attachInfo.mInvalidateChildLocation;
                iArr[0] = i3;
                iArr[1] = i4;
                invalidateChildInParent = viewGroup.invalidateChildInParent(iArr, rect);
            }
            viewGroup = invalidateChildInParent;
        } while (invalidateChildInParent != null);
    }

    public boolean damageChildDeferred(View view) {
        ViewParent parent = getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (viewParent == null) {
                return false;
            }
            if (viewParent instanceof ViewGroup) {
                parent = viewParent.getParent();
            } else if (viewParent instanceof ViewRootImpl) {
                ((ViewRootImpl) viewParent).invalidate();
                return true;
            } else {
                parent = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewParent damageChildInParent(int i, int i2, Rect rect) {
        if ((this.mPrivateFlags & 32) == 0 && (this.mPrivateFlags & 32768) == 0) {
            return null;
        }
        rect.offset(i - this.mScrollX, i2 - this.mScrollY);
        if ((this.mGroupFlags & 1) == 0) {
            rect.union(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop);
        }
        if ((this.mGroupFlags & 1) == 0 || rect.intersect(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop)) {
            if (!getMatrix().isIdentity()) {
                transformRect(rect);
            }
            return this.mParent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void debug(int i) {
        super.debug(i);
        if (this.mFocused != null) {
            Log.d("View", debugIndent(i) + "mFocused");
        }
        if (this.mChildrenCount != 0) {
            Log.d("View", debugIndent(i) + "{");
        }
        int i2 = this.mChildrenCount;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            this.mChildren[i4].debug(i + 1);
            i3 = i4 + 1;
        }
        if (this.mChildrenCount != 0) {
            Log.d("View", debugIndent(i) + i.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void detachAllViewsFromParent() {
        int i = this.mChildrenCount;
        if (i <= 0) {
            return;
        }
        View[] viewArr = this.mChildren;
        this.mChildrenCount = 0;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            viewArr[i].mParent = null;
            viewArr[i] = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void detachViewFromParent(int i) {
        removeFromArray(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void detachViewFromParent(View view) {
        removeFromArray(indexOfChild(view));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void detachViewsFromParent(int i, int i2) {
        removeFromArray(i, i2);
    }

    @Override // android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets dispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        WindowInsets windowInsets2 = dispatchApplyWindowInsets;
        if (!dispatchApplyWindowInsets.isConsumed()) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                windowInsets2 = dispatchApplyWindowInsets;
                if (i >= childCount) {
                    break;
                }
                windowInsets2 = getChildAt(i).dispatchApplyWindowInsets(dispatchApplyWindowInsets);
                if (windowInsets2.isConsumed()) {
                    break;
                }
                i++;
                dispatchApplyWindowInsets = windowInsets2;
            }
        }
        return windowInsets2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void dispatchAttachedToWindow(View.AttachInfo attachInfo, int i) {
        this.mGroupFlags |= 4194304;
        super.dispatchAttachedToWindow(attachInfo, i);
        this.mGroupFlags &= -4194305;
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            View view = viewArr[i4];
            view.dispatchAttachedToWindow(attachInfo, (view.mViewFlags & 12) | i);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void dispatchCancelPendingInputEvents() {
        super.dispatchCancelPendingInputEvents();
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].dispatchCancelPendingInputEvents();
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void dispatchCollectViewAttributes(View.AttachInfo attachInfo, int i) {
        if ((i & 12) != 0) {
            return;
        }
        super.dispatchCollectViewAttributes(attachInfo, i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            View view = viewArr[i4];
            view.dispatchCollectViewAttributes(attachInfo, (view.mViewFlags & 12) | i);
            i3 = i4 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchConfigurationChanged(Configuration configuration) {
        super.dispatchConfigurationChanged(configuration);
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].dispatchConfigurationChanged(configuration);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void dispatchDetachedFromWindow() {
        cancelAndClearTouchTargets(null);
        exitHoverTargets();
        this.mLayoutCalledWhileSuppressed = false;
        this.mDragNotifiedChildren = null;
        if (this.mCurrentDrag != null) {
            this.mCurrentDrag.recycle();
            this.mCurrentDrag = null;
        }
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                clearDisappearingChildren();
                super.dispatchDetachedFromWindow();
                return;
            }
            viewArr[i3].dispatchDetachedFromWindow();
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchDisplayHint(int i) {
        super.dispatchDisplayHint(i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            viewArr[i4].dispatchDisplayHint(i);
            i3 = i4 + 1;
        }
    }

    @Override // android.view.View
    public boolean dispatchDragEvent(DragEvent dragEvent) {
        float f = dragEvent.mX;
        float f2 = dragEvent.mY;
        ViewRootImpl viewRootImpl = getViewRootImpl();
        PointF localPoint = getLocalPoint();
        boolean z = false;
        switch (dragEvent.mAction) {
            case 1:
                this.mCurrentDragView = null;
                this.mCurrentDrag = DragEvent.obtain(dragEvent);
                if (this.mDragNotifiedChildren == null) {
                    this.mDragNotifiedChildren = new HashSet<>();
                } else {
                    this.mDragNotifiedChildren.clear();
                }
                this.mChildAcceptsDrag = false;
                int i = this.mChildrenCount;
                View[] viewArr = this.mChildren;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        z = false;
                        if (this.mChildAcceptsDrag) {
                            z = true;
                            break;
                        }
                    } else {
                        View view = viewArr[i3];
                        view.mPrivateFlags2 &= -4;
                        if (view.getVisibility() == 0 && notifyChildOfDrag(viewArr[i3])) {
                            this.mChildAcceptsDrag = true;
                        }
                        i2 = i3 + 1;
                    }
                }
                break;
            case 2:
                View findFrontmostDroppableChildAt = findFrontmostDroppableChildAt(dragEvent.mX, dragEvent.mY, localPoint);
                if (this.mCurrentDragView != findFrontmostDroppableChildAt) {
                    viewRootImpl.setDragFocus(findFrontmostDroppableChildAt);
                    int i4 = dragEvent.mAction;
                    if (this.mCurrentDragView != null) {
                        View view2 = this.mCurrentDragView;
                        dragEvent.mAction = 6;
                        view2.dispatchDragEvent(dragEvent);
                        view2.mPrivateFlags2 &= -3;
                        view2.refreshDrawableState();
                    }
                    this.mCurrentDragView = findFrontmostDroppableChildAt;
                    if (findFrontmostDroppableChildAt != null) {
                        dragEvent.mAction = 5;
                        findFrontmostDroppableChildAt.dispatchDragEvent(dragEvent);
                        findFrontmostDroppableChildAt.mPrivateFlags2 |= 2;
                        findFrontmostDroppableChildAt.refreshDrawableState();
                    }
                    dragEvent.mAction = i4;
                }
                z = false;
                if (findFrontmostDroppableChildAt != null) {
                    dragEvent.mX = localPoint.x;
                    dragEvent.mY = localPoint.y;
                    z = findFrontmostDroppableChildAt.dispatchDragEvent(dragEvent);
                    dragEvent.mX = f;
                    dragEvent.mY = f2;
                    break;
                }
                break;
            case 3:
                View findFrontmostDroppableChildAt2 = findFrontmostDroppableChildAt(dragEvent.mX, dragEvent.mY, localPoint);
                z = false;
                if (findFrontmostDroppableChildAt2 != null) {
                    dragEvent.mX = localPoint.x;
                    dragEvent.mY = localPoint.y;
                    z = findFrontmostDroppableChildAt2.dispatchDragEvent(dragEvent);
                    dragEvent.mX = f;
                    dragEvent.mY = f2;
                    break;
                }
                break;
            case 4:
                if (this.mDragNotifiedChildren != null) {
                    Iterator<View> it = this.mDragNotifiedChildren.iterator();
                    while (it.hasNext()) {
                        View next = it.next();
                        next.dispatchDragEvent(dragEvent);
                        next.mPrivateFlags2 &= -4;
                        next.refreshDrawableState();
                    }
                    this.mDragNotifiedChildren.clear();
                    if (this.mCurrentDrag != null) {
                        this.mCurrentDrag.recycle();
                        this.mCurrentDrag = null;
                    }
                }
                z = false;
                if (this.mChildAcceptsDrag) {
                    z = true;
                    break;
                }
                break;
            case 5:
                break;
            case 6:
                z = false;
                if (this.mCurrentDragView != null) {
                    View view3 = this.mCurrentDragView;
                    view3.dispatchDragEvent(dragEvent);
                    view3.mPrivateFlags2 &= -3;
                    view3.refreshDrawableState();
                    this.mCurrentDragView = null;
                    z = false;
                    break;
                }
                break;
            default:
                z = false;
                break;
        }
        boolean z2 = z;
        if (!z) {
            z2 = super.dispatchDragEvent(dragEvent);
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean drawChild;
        boolean isRecordingFor = canvas.isRecordingFor(this.mRenderNode);
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = this.mGroupFlags;
        if ((i2 & 8) != 0 && canAnimate()) {
            boolean z = (this.mGroupFlags & 64) == 64;
            boolean z2 = !isHardwareAccelerated();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i) {
                    break;
                }
                View view = viewArr[i4];
                if ((view.mViewFlags & 12) == 0) {
                    attachLayoutAnimationParameters(view, view.getLayoutParams(), i4, i);
                    bindLayoutAnimation(view);
                    if (z) {
                        view.setDrawingCacheEnabled(true);
                        if (z2) {
                            view.buildDrawingCache(true);
                        }
                    }
                }
                i3 = i4 + 1;
            }
            LayoutAnimationController layoutAnimationController = this.mLayoutAnimationController;
            if (layoutAnimationController.willOverlap()) {
                this.mGroupFlags |= 128;
            }
            layoutAnimationController.start();
            this.mGroupFlags &= -9;
            this.mGroupFlags &= -17;
            if (z) {
                this.mGroupFlags |= 32768;
            }
            if (this.mAnimationListener != null) {
                this.mAnimationListener.onAnimationStart(layoutAnimationController.getAnimation());
            }
        }
        int i5 = 0;
        boolean z3 = (i2 & 34) == 34;
        if (z3) {
            i5 = canvas.save();
            canvas.clipRect(this.mScrollX + this.mPaddingLeft, this.mScrollY + this.mPaddingTop, ((this.mScrollX + this.mRight) - this.mLeft) - this.mPaddingRight, ((this.mScrollY + this.mBottom) - this.mTop) - this.mPaddingBottom);
        }
        this.mPrivateFlags &= -65;
        this.mGroupFlags &= -5;
        boolean z4 = false;
        long drawingTime = getDrawingTime();
        if (isRecordingFor) {
            canvas.insertReorderBarrier();
        }
        ArrayList<View> buildOrderedChildList = isRecordingFor ? null : buildOrderedChildList();
        boolean z5 = buildOrderedChildList == null && isChildrenDrawingOrderEnabled();
        int i6 = 0;
        while (i6 < i) {
            int childDrawingOrder = z5 ? getChildDrawingOrder(i, i6) : i6;
            View view2 = buildOrderedChildList == null ? viewArr[childDrawingOrder] : buildOrderedChildList.get(childDrawingOrder);
            if ((view2.mViewFlags & 12) != 0) {
                drawChild = z4;
                if (view2.getAnimation() == null) {
                    i6++;
                    z4 = drawChild;
                }
            }
            drawChild = z4 | drawChild(canvas, view2, drawingTime);
            i6++;
            z4 = drawChild;
        }
        if (buildOrderedChildList != null) {
            buildOrderedChildList.clear();
        }
        boolean z6 = z4;
        if (this.mDisappearingChildren != null) {
            ArrayList<View> arrayList = this.mDisappearingChildren;
            int size = arrayList.size();
            while (true) {
                int i7 = size - 1;
                z6 = z4;
                if (i7 < 0) {
                    break;
                }
                z4 |= drawChild(canvas, arrayList.get(i7), drawingTime);
                size = i7;
            }
        }
        if (isRecordingFor) {
            canvas.insertInorderBarrier();
        }
        if (debugDraw()) {
            onDebugDraw(canvas);
        }
        if (z3) {
            canvas.restoreToCount(i5);
        }
        int i8 = this.mGroupFlags;
        if ((i8 & 4) == 4) {
            invalidate(true);
        }
        if ((i8 & 16) == 0 && (i8 & 512) == 0 && this.mLayoutAnimationController.isDone() && !z6) {
            this.mGroupFlags |= 512;
            post(new Runnable() { // from class: android.view.ViewGroup.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.this.notifyAnimationListener();
                }
            });
        }
    }

    @Override // android.view.View
    public void dispatchDrawableHotspotChanged(float f, float f2) {
        int i = this.mChildrenCount;
        if (i == 0) {
            return;
        }
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            View view = viewArr[i3];
            boolean z = (view.isClickable() || view.isLongClickable()) ? false : true;
            boolean z2 = (view.mViewFlags & 4194304) != 0;
            if (z || z2) {
                float[] tempPoint = getTempPoint();
                tempPoint[0] = f;
                tempPoint[1] = f2;
                transformPointToViewLocal(tempPoint, view);
                view.drawableHotspotChanged(tempPoint[0], tempPoint[1]);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].dispatchFinishTemporaryDetach();
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchFreezeSelfOnly(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        if ((this.mPrivateFlags & 18) == 18) {
            return super.dispatchGenericFocusedEvent(motionEvent);
        }
        if (this.mFocused == null || (this.mFocused.mPrivateFlags & 16) != 16) {
            return false;
        }
        return this.mFocused.dispatchGenericMotionEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean dispatchGenericPointerEvent(MotionEvent motionEvent) {
        int i = this.mChildrenCount;
        if (i != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            ArrayList<View> buildOrderedChildList = buildOrderedChildList();
            boolean z = buildOrderedChildList == null && isChildrenDrawingOrderEnabled();
            View[] viewArr = this.mChildren;
            int i2 = i;
            while (true) {
                int i3 = i2 - 1;
                if (i3 >= 0) {
                    int childDrawingOrder = z ? getChildDrawingOrder(i, i3) : i3;
                    View view = buildOrderedChildList == null ? viewArr[childDrawingOrder] : buildOrderedChildList.get(childDrawingOrder);
                    if (canViewReceivePointerEvents(view) && isTransformedTouchPointInView(x, y, view, null) && dispatchTransformedGenericPointerEvent(motionEvent, view)) {
                        if (buildOrderedChildList != null) {
                            buildOrderedChildList.clear();
                            return true;
                        }
                        return true;
                    }
                    i2 = i3;
                } else if (buildOrderedChildList != null) {
                    buildOrderedChildList.clear();
                }
            }
        }
        return super.dispatchGenericPointerEvent(motionEvent);
    }

    @Override // android.view.View
    protected void dispatchGetDisplayList() {
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            View view = viewArr[i3];
            if (((view.mViewFlags & 12) == 0 || view.getAnimation() != null) && view.hasStaticLayer()) {
                recreateChildDisplayList(view);
            }
            i2 = i3 + 1;
        }
        if (this.mOverlay != null) {
            recreateChildDisplayList(this.mOverlay.getOverlayView());
        }
        if (this.mDisappearingChildren == null) {
            return;
        }
        ArrayList<View> arrayList = this.mDisappearingChildren;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                return;
            }
            recreateChildDisplayList(arrayList.get(i5));
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        boolean z;
        MotionEvent motionEvent3;
        HoverTarget hoverTarget;
        boolean z2;
        boolean z3;
        boolean z4;
        int action = motionEvent.getAction();
        boolean onInterceptHoverEvent = onInterceptHoverEvent(motionEvent);
        motionEvent.setAction(action);
        boolean z5 = false;
        HoverTarget hoverTarget2 = this.mFirstHoverTarget;
        this.mFirstHoverTarget = null;
        MotionEvent motionEvent4 = motionEvent;
        HoverTarget hoverTarget3 = hoverTarget2;
        boolean z6 = false;
        if (!onInterceptHoverEvent) {
            motionEvent4 = motionEvent;
            hoverTarget3 = hoverTarget2;
            z6 = false;
            if (action != 10) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = this.mChildrenCount;
                motionEvent4 = motionEvent;
                hoverTarget3 = hoverTarget2;
                z6 = false;
                if (i != 0) {
                    ArrayList<View> buildOrderedChildList = buildOrderedChildList();
                    boolean z7 = buildOrderedChildList == null && isChildrenDrawingOrderEnabled();
                    View[] viewArr = this.mChildren;
                    HoverTarget hoverTarget4 = null;
                    int i2 = i - 1;
                    HoverTarget hoverTarget5 = hoverTarget2;
                    MotionEvent motionEvent5 = motionEvent;
                    while (true) {
                        motionEvent3 = motionEvent5;
                        hoverTarget = hoverTarget5;
                        z2 = z5;
                        if (i2 < 0) {
                            break;
                        }
                        int childDrawingOrder = z7 ? getChildDrawingOrder(i, i2) : i2;
                        View view = buildOrderedChildList == null ? viewArr[childDrawingOrder] : buildOrderedChildList.get(childDrawingOrder);
                        MotionEvent motionEvent6 = motionEvent5;
                        HoverTarget hoverTarget6 = hoverTarget5;
                        boolean z8 = z5;
                        HoverTarget hoverTarget7 = hoverTarget4;
                        if (canViewReceivePointerEvents(view)) {
                            if (isTransformedTouchPointInView(x, y, view, null)) {
                                HoverTarget hoverTarget8 = hoverTarget5;
                                HoverTarget hoverTarget9 = null;
                                while (true) {
                                    if (hoverTarget8 == null) {
                                        hoverTarget8 = HoverTarget.obtain(view);
                                        z3 = false;
                                        break;
                                    } else if (hoverTarget8.child == view) {
                                        if (hoverTarget9 != null) {
                                            hoverTarget9.next = hoverTarget8.next;
                                        } else {
                                            hoverTarget5 = hoverTarget8.next;
                                        }
                                        hoverTarget8.next = null;
                                        z3 = true;
                                    } else {
                                        hoverTarget9 = hoverTarget8;
                                        hoverTarget8 = hoverTarget8.next;
                                    }
                                }
                                if (hoverTarget4 != null) {
                                    hoverTarget4.next = hoverTarget8;
                                } else {
                                    this.mFirstHoverTarget = hoverTarget8;
                                }
                                hoverTarget7 = hoverTarget8;
                                if (action == 9) {
                                    motionEvent3 = motionEvent5;
                                    z4 = z5;
                                    if (!z3) {
                                        z4 = z5 | dispatchTransformedGenericPointerEvent(motionEvent, view);
                                        motionEvent3 = motionEvent5;
                                    }
                                } else {
                                    motionEvent3 = motionEvent5;
                                    z4 = z5;
                                    if (action == 7) {
                                        if (z3) {
                                            z4 = z5 | dispatchTransformedGenericPointerEvent(motionEvent, view);
                                            motionEvent3 = motionEvent5;
                                        } else {
                                            motionEvent3 = obtainMotionEventNoHistoryOrSelf(motionEvent5);
                                            motionEvent3.setAction(9);
                                            boolean dispatchTransformedGenericPointerEvent = dispatchTransformedGenericPointerEvent(motionEvent3, view);
                                            motionEvent3.setAction(action);
                                            z4 = z5 | dispatchTransformedGenericPointerEvent | dispatchTransformedGenericPointerEvent(motionEvent3, view);
                                        }
                                    }
                                }
                                motionEvent6 = motionEvent3;
                                hoverTarget6 = hoverTarget5;
                                z8 = z4;
                                if (z4) {
                                    z2 = z4;
                                    hoverTarget = hoverTarget5;
                                    break;
                                }
                            } else {
                                hoverTarget7 = hoverTarget4;
                                z8 = z5;
                                hoverTarget6 = hoverTarget5;
                                motionEvent6 = motionEvent5;
                            }
                        }
                        i2--;
                        motionEvent5 = motionEvent6;
                        hoverTarget5 = hoverTarget6;
                        z5 = z8;
                        hoverTarget4 = hoverTarget7;
                    }
                    motionEvent4 = motionEvent3;
                    hoverTarget3 = hoverTarget;
                    z6 = z2;
                    if (buildOrderedChildList != null) {
                        buildOrderedChildList.clear();
                        z6 = z2;
                        hoverTarget3 = hoverTarget;
                        motionEvent4 = motionEvent3;
                    }
                }
            }
        }
        while (hoverTarget3 != null) {
            View view2 = hoverTarget3.child;
            if (action == 10) {
                z6 |= dispatchTransformedGenericPointerEvent(motionEvent, view2);
            } else {
                if (action == 7) {
                    dispatchTransformedGenericPointerEvent(motionEvent, view2);
                }
                motionEvent4 = obtainMotionEventNoHistoryOrSelf(motionEvent4);
                motionEvent4.setAction(10);
                dispatchTransformedGenericPointerEvent(motionEvent4, view2);
                motionEvent4.setAction(action);
            }
            HoverTarget hoverTarget10 = hoverTarget3.next;
            hoverTarget3.recycle();
            hoverTarget3 = hoverTarget10;
        }
        boolean z9 = !z6;
        if (z9 == this.mHoveredSelf) {
            motionEvent2 = motionEvent4;
            z = z6;
            if (z9) {
                z = z6 | super.dispatchHoverEvent(motionEvent);
                motionEvent2 = motionEvent4;
            }
        } else {
            MotionEvent motionEvent7 = motionEvent4;
            boolean z10 = z6;
            if (this.mHoveredSelf) {
                if (action == 10) {
                    z6 |= super.dispatchHoverEvent(motionEvent);
                } else {
                    if (action == 7) {
                        super.dispatchHoverEvent(motionEvent);
                    }
                    motionEvent4 = obtainMotionEventNoHistoryOrSelf(motionEvent4);
                    motionEvent4.setAction(10);
                    super.dispatchHoverEvent(motionEvent4);
                    motionEvent4.setAction(action);
                }
                this.mHoveredSelf = false;
                z10 = z6;
                motionEvent7 = motionEvent4;
            }
            motionEvent2 = motionEvent7;
            z = z10;
            if (z9) {
                if (action == 9) {
                    z = z10 | super.dispatchHoverEvent(motionEvent);
                    this.mHoveredSelf = true;
                    motionEvent2 = motionEvent7;
                } else {
                    motionEvent2 = motionEvent7;
                    z = z10;
                    if (action == 7) {
                        motionEvent2 = obtainMotionEventNoHistoryOrSelf(motionEvent7);
                        motionEvent2.setAction(9);
                        boolean dispatchHoverEvent = super.dispatchHoverEvent(motionEvent2);
                        motionEvent2.setAction(action);
                        z = z10 | dispatchHoverEvent | super.dispatchHoverEvent(motionEvent2);
                        this.mHoveredSelf = true;
                    }
                }
            }
        }
        if (motionEvent2 != motionEvent) {
            motionEvent2.recycle();
        }
        return z;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onKeyEvent(keyEvent, 1);
        }
        if ((this.mPrivateFlags & 18) == 18) {
            if (super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
        } else if (this.mFocused != null && (this.mFocused.mPrivateFlags & 16) == 16 && this.mFocused.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onUnhandledEvent(keyEvent, 1);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if ((this.mPrivateFlags & 18) == 18) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        if (this.mFocused == null || (this.mFocused.mPrivateFlags & 16) != 16) {
            return false;
        }
        return this.mFocused.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if ((this.mPrivateFlags & 18) == 18) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        if (this.mFocused == null || (this.mFocused.mPrivateFlags & 16) != 16) {
            return false;
        }
        return this.mFocused.dispatchKeyShortcutEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent accessibilityEvent) {
        boolean dispatchPopulateAccessibilityEvent;
        boolean dispatchPopulateAccessibilityEventInternal;
        if (includeForAccessibility() && (dispatchPopulateAccessibilityEventInternal = super.dispatchPopulateAccessibilityEventInternal(accessibilityEvent))) {
            return dispatchPopulateAccessibilityEventInternal;
        }
        ChildListForAccessibility obtain = ChildListForAccessibility.obtain(this, true);
        try {
            int childCount = obtain.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    obtain.recycle();
                    return false;
                }
                View childAt = obtain.getChildAt(i2);
                if ((childAt.mViewFlags & 12) == 0 && (dispatchPopulateAccessibilityEvent = childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent))) {
                    return dispatchPopulateAccessibilityEvent;
                }
                i = i2 + 1;
            }
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchRestoreInstanceState(sparseArray);
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            View view = viewArr[i3];
            if ((view.mViewFlags & 536870912) != 536870912) {
                view.dispatchRestoreInstanceState(sparseArray);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            View view = viewArr[i3];
            if ((view.mViewFlags & 536870912) != 536870912) {
                view.dispatchSaveInstanceState(sparseArray);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void dispatchScreenStateChanged(int i) {
        super.dispatchScreenStateChanged(i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            viewArr[i4].dispatchScreenStateChanged(i);
            i3 = i4 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchSetActivated(boolean z) {
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].setActivated(z);
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    protected void dispatchSetPressed(boolean z) {
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            View view = viewArr[i3];
            if (!z || (!view.isClickable() && !view.isLongClickable())) {
                view.setPressed(z);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchSetSelected(boolean z) {
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].setSelected(z);
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].dispatchStartTemporaryDetach();
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchSystemUiVisibilityChanged(int i) {
        super.dispatchSystemUiVisibilityChanged(i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            viewArr[i4].dispatchSystemUiVisibilityChanged(i);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchThawSelfOnly(SparseArray<Parcelable> sparseArray) {
        super.dispatchRestoreInstanceState(sparseArray);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fb, code lost:
        if (r0 == 7) goto L46;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewGroup.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onTrackballEvent(motionEvent, 1);
        }
        if ((this.mPrivateFlags & 18) == 18) {
            if (super.dispatchTrackballEvent(motionEvent)) {
                return true;
            }
        } else if (this.mFocused != null && (this.mFocused.mPrivateFlags & 16) == 16 && this.mFocused.dispatchTrackballEvent(motionEvent)) {
            return true;
        }
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onUnhandledEvent(motionEvent, 1);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        return this.mFocused != null && this.mFocused.dispatchUnhandledMove(view, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void dispatchVisibilityChanged(View view, int i) {
        super.dispatchVisibilityChanged(view, i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            viewArr[i4].dispatchVisibilityChanged(view, i);
            i3 = i4 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        super.dispatchWindowFocusChanged(z);
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].dispatchWindowFocusChanged(z);
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchWindowSystemUiVisiblityChanged(int i) {
        super.dispatchWindowSystemUiVisiblityChanged(i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            viewArr[i4].dispatchWindowSystemUiVisiblityChanged(i);
            i3 = i4 + 1;
        }
    }

    @Override // android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        super.dispatchWindowVisibilityChanged(i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            viewArr[i4].dispatchWindowVisibilityChanged(i);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        return view.draw(canvas, this, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.mGroupFlags & 65536) == 0) {
            return;
        }
        if ((this.mGroupFlags & 8192) != 0) {
            throw new IllegalStateException("addStateFromChildren cannot be enabled if a child has duplicateParentState set to true");
        }
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            View view = viewArr[i3];
            if ((view.mViewFlags & 4194304) != 0) {
                view.refreshDrawableState();
            }
            i2 = i3 + 1;
        }
    }

    public void endViewTransition(View view) {
        if (this.mTransitioningViews != null) {
            this.mTransitioningViews.remove(view);
            ArrayList<View> arrayList = this.mDisappearingChildren;
            if (arrayList == null || !arrayList.contains(view)) {
                return;
            }
            arrayList.remove(view);
            if (this.mVisibilityChangingChildren == null || !this.mVisibilityChangingChildren.contains(view)) {
                if (view.mAttachInfo != null) {
                    view.dispatchDetachedFromWindow();
                }
                if (view.mParent != null) {
                    view.mParent = null;
                }
            } else {
                this.mVisibilityChangingChildren.remove(view);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public View findFocus() {
        if (isFocused()) {
            return this;
        }
        if (this.mFocused != null) {
            return this.mFocused.findFocus();
        }
        return null;
    }

    View findFrontmostDroppableChildAt(float f, float f2, PointF pointF) {
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        while (true) {
            i--;
            if (i < 0) {
                return null;
            }
            View view = viewArr[i];
            if (view.canAcceptDrag() && isTransformedTouchPointInView(f, f2, view, pointF)) {
                return view;
            }
        }
    }

    @Override // android.view.View
    public void findNamedViews(Map<String, View> map) {
        if (getVisibility() != 0 && this.mGhostView == null) {
            return;
        }
        super.findNamedViews(map);
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            getChildAt(i2).findNamedViews(map);
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public View findViewByAccessibilityIdTraversal(int i) {
        View findViewByAccessibilityIdTraversal = super.findViewByAccessibilityIdTraversal(i);
        if (findViewByAccessibilityIdTraversal != null) {
            return findViewByAccessibilityIdTraversal;
        }
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return null;
            }
            View findViewByAccessibilityIdTraversal2 = viewArr[i4].findViewByAccessibilityIdTraversal(i);
            if (findViewByAccessibilityIdTraversal2 != null) {
                return findViewByAccessibilityIdTraversal2;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public View findViewByPredicateTraversal(Predicate<View> predicate, View view) {
        View findViewByPredicate;
        if (predicate.apply(this)) {
            return this;
        }
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return null;
            }
            View view2 = viewArr[i3];
            if (view2 != view && (view2.mPrivateFlags & 8) == 0 && (findViewByPredicate = view2.findViewByPredicate(predicate)) != null) {
                return findViewByPredicate;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public View findViewTraversal(int i) {
        View findViewById;
        if (i == this.mID) {
            return this;
        }
        View[] viewArr = this.mChildren;
        int i2 = this.mChildrenCount;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return null;
            }
            View view = viewArr[i4];
            if ((view.mPrivateFlags & 8) == 0 && (findViewById = view.findViewById(i)) != null) {
                return findViewById;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public View findViewWithTagTraversal(Object obj) {
        View findViewWithTag;
        if (obj != null && obj.equals(this.mTag)) {
            return this;
        }
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return null;
            }
            View view = viewArr[i3];
            if ((view.mPrivateFlags & 8) == 0 && (findViewWithTag = view.findViewWithTag(obj)) != null) {
                return findViewWithTag;
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public void findViewsWithText(ArrayList<View> arrayList, CharSequence charSequence, int i) {
        super.findViewsWithText(arrayList, charSequence, i);
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            View view = viewArr[i4];
            if ((view.mViewFlags & 12) == 0 && (view.mPrivateFlags & 8) == 0) {
                view.findViewsWithText(arrayList, charSequence, i);
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishAnimatingView(View view, Animation animation) {
        ArrayList<View> arrayList = this.mDisappearingChildren;
        if (arrayList != null && arrayList.contains(view)) {
            arrayList.remove(view);
            if (view.mAttachInfo != null) {
                view.dispatchDetachedFromWindow();
            }
            view.clearAnimation();
            this.mGroupFlags |= 4;
        }
        if (animation != null && !animation.getFillAfter()) {
            view.clearAnimation();
        }
        if ((view.mPrivateFlags & 65536) == 65536) {
            view.onAnimationEnd();
            view.mPrivateFlags &= -65537;
            this.mGroupFlags |= 4;
        }
    }

    @Override // android.view.ViewParent
    public View focusSearch(View view, int i) {
        if (isRootNamespace()) {
            return FocusFinder.getInstance().findNextFocus(this, view, i);
        }
        if (this.mParent != null) {
            return this.mParent.focusSearch(view, i);
        }
        return null;
    }

    @Override // android.view.ViewParent
    public void focusableViewAvailable(View view) {
        if (this.mParent == null || getDescendantFocusability() == 393216) {
            return;
        }
        if (isFocusableInTouchMode() || !shouldBlockFocusForTouchscreen()) {
            if (!isFocused() || getDescendantFocusability() == 262144) {
                this.mParent.focusableViewAvailable(view);
            }
        }
    }

    @Override // android.view.View
    public boolean gatherTransparentRegion(Region region) {
        boolean z;
        boolean z2 = false;
        boolean z3 = (this.mPrivateFlags & 512) == 0;
        if (z3 && region == null) {
            return true;
        }
        super.gatherTransparentRegion(region);
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        boolean z4 = true;
        int i2 = 0;
        while (i2 < i) {
            View view = viewArr[i2];
            if ((view.mViewFlags & 12) != 0) {
                z = z4;
                if (view.getAnimation() == null) {
                    i2++;
                    z4 = z;
                }
            }
            z = z4;
            if (!view.gatherTransparentRegion(region)) {
                z = false;
            }
            i2++;
            z4 = z;
        }
        if (z3 || z4) {
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams;
    }

    public View getChildAt(int i) {
        if (i < 0 || i >= this.mChildrenCount) {
            return null;
        }
        return this.mChildren[i];
    }

    public int getChildCount() {
        return this.mChildrenCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getChildStaticTransformation(View view, Transformation transformation) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transformation getChildTransformation() {
        if (this.mChildTransformation == null) {
            this.mChildTransformation = new Transformation();
        }
        return this.mChildTransformation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ea, code lost:
        if (((android.view.ViewGroup) r7.mParent).getClipChildren() != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a6  */
    @Override // android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getChildVisibleRect(android.view.View r8, android.graphics.Rect r9, android.graphics.Point r10) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewGroup.getChildVisibleRect(android.view.View, android.graphics.Rect, android.graphics.Point):boolean");
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean getClipChildren() {
        return (this.mGroupFlags & 1) != 0;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean getClipToPadding() {
        return hasBooleanFlag(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    View getDeepestFocusedChild() {
        View view = this;
        while (true) {
            ViewGroup viewGroup = view;
            if (viewGroup == null) {
                return null;
            }
            if (viewGroup.isFocused()) {
                return viewGroup;
            }
            view = viewGroup instanceof ViewGroup ? viewGroup.getFocusedChild() : 0;
        }
    }

    @ViewDebug.ExportedProperty(category = "focus", mapping = {@ViewDebug.IntToString(from = 131072, to = "FOCUS_BEFORE_DESCENDANTS"), @ViewDebug.IntToString(from = 262144, to = "FOCUS_AFTER_DESCENDANTS"), @ViewDebug.IntToString(from = 393216, to = "FOCUS_BLOCK_DESCENDANTS")})
    public int getDescendantFocusability() {
        return this.mGroupFlags & 393216;
    }

    public View getFocusedChild() {
        return this.mFocused;
    }

    public LayoutAnimationController getLayoutAnimation() {
        return this.mLayoutAnimationController;
    }

    public Animation.AnimationListener getLayoutAnimationListener() {
        return this.mAnimationListener;
    }

    public int getLayoutMode() {
        if (this.mLayoutMode == -1) {
            setLayoutMode(this.mParent instanceof ViewGroup ? ((ViewGroup) this.mParent).getLayoutMode() : LAYOUT_MODE_DEFAULT, false);
        }
        return this.mLayoutMode;
    }

    public LayoutTransition getLayoutTransition() {
        return this.mTransition;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    @Override // android.view.View
    public ViewGroupOverlay getOverlay() {
        if (this.mOverlay == null) {
            this.mOverlay = new ViewGroupOverlay(this.mContext, this);
        }
        return (ViewGroupOverlay) this.mOverlay;
    }

    @ViewDebug.ExportedProperty(category = "drawing", mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 1, to = "ANIMATION"), @ViewDebug.IntToString(from = 2, to = "SCROLLING"), @ViewDebug.IntToString(from = 3, to = Rule.ALL)})
    public int getPersistentDrawingCache() {
        return this.mPersistentDrawingCache;
    }

    public boolean getTouchscreenBlocksFocus() {
        return (this.mGroupFlags & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void handleFocusGainInternal(int i, Rect rect) {
        if (this.mFocused != null) {
            this.mFocused.unFocus(this);
            this.mFocused = null;
        }
        super.handleFocusGainInternal(i, rect);
    }

    @Override // android.view.View
    public boolean hasFocus() {
        return ((this.mPrivateFlags & 2) == 0 && this.mFocused == null) ? false : true;
    }

    @Override // android.view.View
    public boolean hasFocusable() {
        if ((this.mViewFlags & 12) != 0) {
            return false;
        }
        if (isFocusable()) {
            return true;
        }
        if (getDescendantFocusability() == 393216) {
            return false;
        }
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return false;
            }
            if (viewArr[i3].hasFocusable()) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    protected boolean hasHoveredChild() {
        return this.mFirstHoverTarget != null;
    }

    @Override // android.view.View
    public boolean hasTransientState() {
        return this.mChildCountWithTransientState > 0 || super.hasTransientState();
    }

    public int indexOfChild(View view) {
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return -1;
            }
            if (viewArr[i3] == view) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void internalSetPadding(int i, int i2, int i3, int i4) {
        super.internalSetPadding(i, i2, i3, i4);
        if ((this.mPaddingLeft | this.mPaddingTop | this.mPaddingRight | this.mPaddingBottom) != 0) {
            this.mGroupFlags |= 32;
        } else {
            this.mGroupFlags &= -33;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
        if ((r7.mGroupFlags & 2048) != 0) goto L57;
     */
    @Override // android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invalidateChild(android.view.View r8, android.graphics.Rect r9) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewGroup.invalidateChild(android.view.View, android.graphics.Rect):void");
    }

    @Override // android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if ((this.mPrivateFlags & 32) == 32 || (this.mPrivateFlags & 32768) == 32768) {
            if ((this.mGroupFlags & 144) == 128) {
                this.mPrivateFlags &= -32801;
                iArr[0] = this.mLeft;
                iArr[1] = this.mTop;
                if ((this.mGroupFlags & 1) == 1) {
                    rect.set(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop);
                } else {
                    rect.union(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop);
                }
                if (this.mLayerType != 0) {
                    this.mPrivateFlags |= Integer.MIN_VALUE;
                }
                return this.mParent;
            }
            rect.offset(iArr[0] - this.mScrollX, iArr[1] - this.mScrollY);
            if ((this.mGroupFlags & 1) == 0) {
                rect.union(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop);
            }
            int i = this.mLeft;
            int i2 = this.mTop;
            if ((this.mGroupFlags & 1) == 1 && !rect.intersect(0, 0, this.mRight - i, this.mBottom - i2)) {
                rect.setEmpty();
            }
            this.mPrivateFlags &= -32769;
            iArr[0] = i;
            iArr[1] = i2;
            if (this.mLayerType != 0) {
                this.mPrivateFlags |= Integer.MIN_VALUE;
            }
            return this.mParent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void invalidateInheritedLayoutMode(int i) {
        if (this.mLayoutMode == -1 || this.mLayoutMode == i || hasBooleanFlag(8388608)) {
            return;
        }
        setLayoutMode(-1, false);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).invalidateInheritedLayoutMode(i);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isAlwaysDrawnWithCacheEnabled() {
        return (this.mGroupFlags & 16384) == 16384;
    }

    @ViewDebug.ExportedProperty
    public boolean isAnimationCacheEnabled() {
        return (this.mGroupFlags & 64) == 64;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isChildrenDrawingOrderEnabled() {
        return (this.mGroupFlags & 1024) == 1024;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawnWithCacheEnabled() {
        return (this.mGroupFlags & 32768) == 32768;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLayoutModeOptical() {
        return this.mLayoutMode == 1;
    }

    public boolean isLayoutSuppressed() {
        return this.mSuppressLayout;
    }

    public boolean isMotionEventSplittingEnabled() {
        return (this.mGroupFlags & 2097152) == 2097152;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTransformedTouchPointInView(float f, float f2, View view, PointF pointF) {
        float[] tempPoint = getTempPoint();
        tempPoint[0] = f;
        tempPoint[1] = f2;
        transformPointToViewLocal(tempPoint, view);
        boolean pointInView = view.pointInView(tempPoint[0], tempPoint[1]);
        if (pointInView && pointF != null) {
            pointF.set(tempPoint[0], tempPoint[1]);
        }
        return pointInView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0 != android.view.ViewOutlineProvider.BACKGROUND) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isTransitionGroup() {
        /*
            r3 = this;
            r0 = 0
            r5 = r0
            r0 = r3
            int r0 = r0.mGroupFlags
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L1a
            r0 = r3
            int r0 = r0.mGroupFlags
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L18
            r0 = 1
            return r0
        L18:
            r0 = 0
            return r0
        L1a:
            r0 = r3
            android.view.ViewOutlineProvider r0 = r0.getOutlineProvider()
            r6 = r0
            r0 = r3
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 != 0) goto L3c
            r0 = r3
            java.lang.String r0 = r0.getTransitionName()
            if (r0 != 0) goto L3c
            r0 = r5
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L3e
            r0 = r5
            r4 = r0
            r0 = r6
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 == r1) goto L3e
        L3c:
            r0 = 1
            r4 = r0
        L3e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewGroup.isTransitionGroup():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isViewTransitioning(View view) {
        return this.mTransitioningViews != null && this.mTransitioningViews.contains(view);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].jumpDrawablesToCurrentState();
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    public final void layout(int i, int i2, int i3, int i4) {
        if (this.mSuppressLayout || (this.mTransition != null && this.mTransition.isChangingLayout())) {
            this.mLayoutCalledWhileSuppressed = true;
            return;
        }
        if (this.mTransition != null) {
            this.mTransition.layoutChange(this);
        }
        super.layout(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void makeOptionalFitsSystemWindows() {
        super.makeOptionalFitsSystemWindows();
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].makeOptionalFitsSystemWindows();
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, this.mPaddingLeft + this.mPaddingRight, layoutParams.width), getChildMeasureSpec(i2, this.mPaddingTop + this.mPaddingBottom, layoutParams.height));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, this.mPaddingLeft + this.mPaddingRight + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), getChildMeasureSpec(i3, this.mPaddingTop + this.mPaddingBottom + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureChildren(int i, int i2) {
        int i3 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                return;
            }
            View view = viewArr[i5];
            if ((view.mViewFlags & 12) != 8) {
                measureChild(view, i, i2);
            }
            i4 = i5 + 1;
        }
    }

    boolean notifyChildOfDrag(View view) {
        boolean z = false;
        if (!this.mDragNotifiedChildren.contains(view)) {
            this.mDragNotifiedChildren.add(view);
            boolean dispatchDragEvent = view.dispatchDragEvent(this.mCurrentDrag);
            z = dispatchDragEvent;
            if (dispatchDragEvent) {
                z = dispatchDragEvent;
                if (!view.canAcceptDrag()) {
                    view.mPrivateFlags2 |= 1;
                    view.refreshDrawableState();
                    z = dispatchDragEvent;
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewParent
    public void notifySubtreeAccessibilityStateChanged(View view, View view2, int i) {
        if (getAccessibilityLiveRegion() != 0) {
            notifyViewAccessibilityStateChangedIfNeeded(i);
        } else if (this.mParent != null) {
            try {
                this.mParent.notifySubtreeAccessibilityStateChanged(this, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("View", this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
            }
        }
    }

    public void offsetChildrenTopAndBottom(int i) {
        int i2 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            View view = viewArr[i4];
            view.mTop += i;
            view.mBottom += i;
            if (view.mRenderNode != null) {
                z = true;
                view.mRenderNode.offsetTopAndBottom(i);
            }
            i3 = i4 + 1;
        }
        if (z) {
            invalidateViewProperty(false, false);
        }
        notifySubtreeAccessibilityStateChangedIfNeeded();
    }

    public final void offsetDescendantRectToMyCoords(View view, Rect rect) {
        offsetRectBetweenParentAndChild(view, rect, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void offsetRectBetweenParentAndChild(View view, Rect rect, boolean z, boolean z2) {
        ViewParent viewParent;
        if (view == this) {
            return;
        }
        View view2 = view;
        ViewParent viewParent2 = view.mParent;
        while (true) {
            viewParent = viewParent2;
            if (viewParent == null || !(viewParent instanceof View) || viewParent == this) {
                break;
            }
            if (z) {
                rect.offset(view2.mLeft - view2.mScrollX, view2.mTop - view2.mScrollY);
                if (z2) {
                    View view3 = (View) viewParent;
                    rect.intersect(0, 0, view3.mRight - view3.mLeft, view3.mBottom - view3.mTop);
                }
            } else {
                if (z2) {
                    View view4 = (View) viewParent;
                    rect.intersect(0, 0, view4.mRight - view4.mLeft, view4.mBottom - view4.mTop);
                }
                rect.offset(view2.mScrollX - view2.mLeft, view2.mScrollY - view2.mTop);
            }
            view2 = (View) viewParent;
            viewParent2 = view2.mParent;
        }
        if (viewParent != this) {
            throw new IllegalArgumentException("parameter must be a descendant of this view");
        }
        if (z) {
            rect.offset(view2.mLeft - view2.mScrollX, view2.mTop - view2.mScrollY);
        } else {
            rect.offset(view2.mScrollX - view2.mLeft, view2.mScrollY - view2.mTop);
        }
    }

    public final void offsetRectIntoDescendantCoords(View view, Rect rect) {
        offsetRectBetweenParentAndChild(view, rect, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if ((this.mGroupFlags & 64) == 64) {
            this.mGroupFlags &= -32769;
            if ((this.mPersistentDrawingCache & 1) == 0) {
                setChildrenDrawingCacheEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        if ((this.mGroupFlags & 64) != 64) {
            return;
        }
        int i = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        boolean z = !isHardwareAccelerated();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.mGroupFlags |= 32768;
                return;
            }
            View view = viewArr[i3];
            if ((view.mViewFlags & 12) == 0) {
                view.setDrawingCacheEnabled(true);
                if (z) {
                    view.buildDrawingCache(true);
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        clearCachedLayoutMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChildVisibilityChanged(View view, int i, int i2) {
        if (this.mTransition != null) {
            if (i2 == 0) {
                this.mTransition.showChild(this, view, i);
            } else {
                this.mTransition.hideChild(this, view, i2);
                if (this.mTransitioningViews != null && this.mTransitioningViews.contains(view)) {
                    if (this.mVisibilityChangingChildren == null) {
                        this.mVisibilityChangingChildren = new ArrayList<>();
                    }
                    this.mVisibilityChangingChildren.add(view);
                    addDisappearingView(view);
                }
            }
        }
        if (this.mCurrentDrag == null || i2 != 0) {
            return;
        }
        notifyChildOfDrag(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArr;
        if ((this.mGroupFlags & 8192) != 0) {
            int i2 = 0;
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                int[] drawableState = getChildAt(i3).getDrawableState();
                int i4 = i2;
                if (drawableState != null) {
                    i4 = i2 + drawableState.length;
                }
                i3++;
                i2 = i4;
            }
            int[] onCreateDrawableState = super.onCreateDrawableState(i + i2);
            int i5 = 0;
            while (true) {
                iArr = onCreateDrawableState;
                if (i5 >= childCount) {
                    break;
                }
                int[] drawableState2 = getChildAt(i5).getDrawableState();
                int[] iArr2 = onCreateDrawableState;
                if (drawableState2 != null) {
                    iArr2 = mergeDrawableStates(onCreateDrawableState, drawableState2);
                }
                i5++;
                onCreateDrawableState = iArr2;
            }
        } else {
            iArr = super.onCreateDrawableState(i);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDebugDraw(Canvas canvas) {
        Paint debugPaint = getDebugPaint();
        debugPaint.setColor(-65536);
        debugPaint.setStyle(Paint.Style.STROKE);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i2);
            Insets opticalInsets = childAt.getOpticalInsets();
            int left = childAt.getLeft();
            drawRect(canvas, debugPaint, opticalInsets.left + left, opticalInsets.top + childAt.getTop(), (childAt.getRight() - opticalInsets.right) - 1, (childAt.getBottom() - opticalInsets.bottom) - 1);
            i = i2 + 1;
        }
        debugPaint.setColor(Color.argb(63, 255, 0, 255));
        debugPaint.setStyle(Paint.Style.FILL);
        onDebugDrawMargins(canvas, debugPaint);
        debugPaint.setColor(Color.rgb(63, 127, 255));
        debugPaint.setStyle(Paint.Style.FILL);
        int dipsToPixels = dipsToPixels(8);
        int dipsToPixels2 = dipsToPixels(1);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= getChildCount()) {
                return;
            }
            View childAt2 = getChildAt(i4);
            drawRectCorners(canvas, childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getBottom(), debugPaint, dipsToPixels, dipsToPixels2);
            i3 = i4 + 1;
        }
    }

    protected void onDebugDrawMargins(Canvas canvas, Paint paint) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(i2);
            childAt.getLayoutParams().onDebugDraw(childAt, canvas, paint);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearCachedLayoutMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void onInitializeAccessibilityEventInternal(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEventInternal(accessibilityEvent);
        accessibilityEvent.setClassName(ViewGroup.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfoInternal(accessibilityNodeInfo);
        if (getAccessibilityNodeProvider() != null || this.mAttachInfo == null) {
            return;
        }
        ArrayList<View> arrayList = this.mAttachInfo.mTempArrayList;
        arrayList.clear();
        addChildrenForAccessibility(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                arrayList.clear();
                return;
            } else {
                accessibilityNodeInfo.addChildUnchecked(arrayList.get(i2));
                i = i2 + 1;
            }
        }
    }

    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public abstract void onLayout(boolean z, int i, int i2, int i3, int i4);

    @Override // android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewParent
    public boolean onNestedPrePerformAccessibilityAction(View view, int i, Bundle bundle) {
        return false;
    }

    @Override // android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollAxes = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4 = this.mChildrenCount;
        if ((i & 2) != 0) {
            i2 = 0;
            i3 = 1;
        } else {
            i2 = i4 - 1;
            i3 = -1;
            i4 = -1;
        }
        View[] viewArr = this.mChildren;
        while (i2 != i4) {
            View view = viewArr[i2];
            if ((view.mViewFlags & 12) == 0 && view.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mAccessibilityDelegate != null ? this.mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, view, accessibilityEvent) : onRequestSendAccessibilityEventInternal(view, accessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onRequestSendAccessibilityEventInternal(View view, AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetLayoutParams(View view, LayoutParams layoutParams) {
    }

    @Override // android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return false;
    }

    @Override // android.view.ViewParent
    public void onStopNestedScroll(View view) {
        stopNestedScroll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewAdded(View view) {
        if (this.mOnHierarchyChangeListener != null) {
            this.mOnHierarchyChangeListener.onChildViewAdded(this, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewRemoved(View view) {
        if (this.mOnHierarchyChangeListener != null) {
            this.mOnHierarchyChangeListener.onChildViewRemoved(this, view);
        }
    }

    @Override // android.view.ViewParent
    public void recomputeViewAttributes(View view) {
        ViewParent viewParent;
        if (this.mAttachInfo == null || this.mAttachInfo.mRecomputeGlobalAttributes || (viewParent = this.mParent) == null) {
            return;
        }
        viewParent.recomputeViewAttributes(this);
    }

    public void removeAllViews() {
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
    }

    public void removeAllViewsInLayout() {
        int i = this.mChildrenCount;
        if (i <= 0) {
            return;
        }
        View[] viewArr = this.mChildren;
        this.mChildrenCount = 0;
        View view = this.mFocused;
        boolean z = this.mAttachInfo != null;
        boolean z2 = false;
        needGlobalAttributesUpdate(false);
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            View view2 = viewArr[i];
            if (this.mTransition != null) {
                this.mTransition.removeChild(this, view2);
            }
            if (view2 == view) {
                view2.unFocus(null);
                z2 = true;
            }
            view2.clearAccessibilityFocus();
            cancelTouchTarget(view2);
            cancelHoverTarget(view2);
            if (view2.getAnimation() != null || (this.mTransitioningViews != null && this.mTransitioningViews.contains(view2))) {
                addDisappearingView(view2);
            } else if (z) {
                view2.dispatchDetachedFromWindow();
            }
            if (view2.hasTransientState()) {
                childHasTransientStateChanged(view2, false);
            }
            onViewRemoved(view2);
            view2.mParent = null;
            viewArr[i] = null;
        }
        if (z2) {
            clearChildFocus(view);
            if (rootViewRequestFocus()) {
                return;
            }
            notifyGlobalFocusCleared(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        if (this.mTransition != null) {
            this.mTransition.removeChild(this, view);
        }
        if (view == this.mFocused) {
            view.clearFocus();
        }
        view.clearAccessibilityFocus();
        cancelTouchTarget(view);
        cancelHoverTarget(view);
        if ((z && view.getAnimation() != null) || (this.mTransitioningViews != null && this.mTransitioningViews.contains(view))) {
            addDisappearingView(view);
        } else if (view.mAttachInfo != null) {
            view.dispatchDetachedFromWindow();
        }
        if (view.hasTransientState()) {
            childHasTransientStateChanged(view, false);
        }
        onViewRemoved(view);
    }

    @Override // android.view.ViewManager
    public void removeView(View view) {
        if (removeViewInternal(view)) {
            requestLayout();
            invalidate(true);
        }
    }

    public void removeViewAt(int i) {
        removeViewInternal(i, getChildAt(i));
        requestLayout();
        invalidate(true);
    }

    public void removeViewInLayout(View view) {
        removeViewInternal(view);
    }

    public void removeViews(int i, int i2) {
        removeViewsInternal(i, i2);
        requestLayout();
        invalidate(true);
    }

    public void removeViewsInLayout(int i, int i2) {
        removeViewsInternal(i, i2);
    }

    @Override // android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        super.unFocus(view2);
        if (this.mFocused != view) {
            if (this.mFocused != null) {
                this.mFocused.unFocus(view2);
            }
            this.mFocused = view;
        }
        if (this.mParent != null) {
            this.mParent.requestChildFocus(this, view2);
        }
    }

    @Override // android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return false;
    }

    @Override // android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z == ((this.mGroupFlags & 524288) != 0)) {
            return;
        }
        if (z) {
            this.mGroupFlags |= 524288;
        } else {
            this.mGroupFlags &= -524289;
        }
        if (this.mParent != null) {
            this.mParent.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.View
    public boolean requestFocus(int i, Rect rect) {
        boolean z;
        int descendantFocusability = getDescendantFocusability();
        switch (descendantFocusability) {
            case 131072:
                boolean requestFocus = super.requestFocus(i, rect);
                z = requestFocus;
                if (!requestFocus) {
                    return onRequestFocusInDescendants(i, rect);
                }
                break;
            case 262144:
                boolean onRequestFocusInDescendants = onRequestFocusInDescendants(i, rect);
                z = onRequestFocusInDescendants;
                if (!onRequestFocusInDescendants) {
                    return super.requestFocus(i, rect);
                }
                break;
            case 393216:
                z = super.requestFocus(i, rect);
                break;
            default:
                throw new IllegalStateException("descendant focusability must be one of FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS but is " + descendantFocusability);
        }
        return z;
    }

    @Override // android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ViewParent viewParent = this.mParent;
        if (viewParent != null && onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            return viewParent.requestSendAccessibilityEvent(this, accessibilityEvent);
        }
        return false;
    }

    public void requestTransitionStart(LayoutTransition layoutTransition) {
        ViewRootImpl viewRootImpl = getViewRootImpl();
        if (viewRootImpl != null) {
            viewRootImpl.requestTransitionStart(layoutTransition);
        }
    }

    @Override // android.view.ViewParent
    public void requestTransparentRegion(View view) {
        if (view != null) {
            view.mPrivateFlags |= 512;
            if (this.mParent != null) {
                this.mParent.requestTransparentRegion(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void resetResolvedDrawables() {
        super.resetResolvedDrawables();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.isLayoutDirectionInherited()) {
                childAt.resetResolvedDrawables();
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.isLayoutDirectionInherited()) {
                childAt.resetResolvedLayoutDirection();
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void resetResolvedPadding() {
        super.resetResolvedPadding();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.isLayoutDirectionInherited()) {
                childAt.resetResolvedPadding();
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void resetResolvedTextAlignment() {
        super.resetResolvedTextAlignment();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.isTextAlignmentInherited()) {
                childAt.resetResolvedTextAlignment();
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void resetResolvedTextDirection() {
        super.resetResolvedTextDirection();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.isTextDirectionInherited()) {
                childAt.resetResolvedTextDirection();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void resetSubtreeAccessibilityStateChanged() {
        super.resetSubtreeAccessibilityStateChanged();
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].resetSubtreeAccessibilityStateChanged();
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void resolveDrawables() {
        super.resolveDrawables();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.isLayoutDirectionInherited() && !childAt.areDrawablesResolved()) {
                childAt.resolveDrawables();
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public boolean resolveLayoutDirection() {
        boolean resolveLayoutDirection = super.resolveLayoutDirection();
        if (resolveLayoutDirection) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt.isLayoutDirectionInherited()) {
                    childAt.resolveLayoutDirection();
                }
                i = i2 + 1;
            }
        }
        return resolveLayoutDirection;
    }

    @Override // android.view.View
    public void resolveLayoutParams() {
        super.resolveLayoutParams();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            getChildAt(i2).resolveLayoutParams();
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void resolvePadding() {
        super.resolvePadding();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.isLayoutDirectionInherited() && !childAt.isPaddingResolved()) {
                childAt.resolvePadding();
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public boolean resolveRtlPropertiesIfNeeded() {
        boolean resolveRtlPropertiesIfNeeded = super.resolveRtlPropertiesIfNeeded();
        if (resolveRtlPropertiesIfNeeded) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt.isLayoutDirectionInherited()) {
                    childAt.resolveRtlPropertiesIfNeeded();
                }
                i = i2 + 1;
            }
        }
        return resolveRtlPropertiesIfNeeded;
    }

    @Override // android.view.View
    public boolean resolveTextAlignment() {
        boolean resolveTextAlignment = super.resolveTextAlignment();
        if (resolveTextAlignment) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt.isTextAlignmentInherited()) {
                    childAt.resolveTextAlignment();
                }
                i = i2 + 1;
            }
        }
        return resolveTextAlignment;
    }

    @Override // android.view.View
    public boolean resolveTextDirection() {
        boolean resolveTextDirection = super.resolveTextDirection();
        if (resolveTextDirection) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt.isTextDirectionInherited()) {
                    childAt.resolveTextDirection();
                }
                i = i2 + 1;
            }
        }
        return resolveTextDirection;
    }

    public void scheduleLayoutAnimation() {
        this.mGroupFlags |= 8;
    }

    public void setAddStatesFromChildren(boolean z) {
        if (z) {
            this.mGroupFlags |= 8192;
        } else {
            this.mGroupFlags &= -8193;
        }
        refreshDrawableState();
    }

    public void setAlwaysDrawnWithCacheEnabled(boolean z) {
        setBooleanFlag(16384, z);
    }

    public void setAnimationCacheEnabled(boolean z) {
        setBooleanFlag(64, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setChildrenDrawingCacheEnabled(boolean z) {
        if (!z && (this.mPersistentDrawingCache & 3) == 3) {
            return;
        }
        View[] viewArr = this.mChildren;
        int i = this.mChildrenCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            viewArr[i3].setDrawingCacheEnabled(z);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setChildrenDrawingOrderEnabled(boolean z) {
        setBooleanFlag(1024, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setChildrenDrawnWithCacheEnabled(boolean z) {
        setBooleanFlag(32768, z);
    }

    public void setClipChildren(boolean z) {
        if (z == ((this.mGroupFlags & 1) == 1)) {
            return;
        }
        setBooleanFlag(1, z);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mChildrenCount) {
                invalidate(true);
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.mRenderNode != null) {
                childAt.mRenderNode.setClipToBounds(z);
            }
            i = i2 + 1;
        }
    }

    public void setClipToPadding(boolean z) {
        if (hasBooleanFlag(2) != z) {
            setBooleanFlag(2, z);
            invalidate(true);
        }
    }

    public void setDescendantFocusability(int i) {
        switch (i) {
            case 131072:
            case 262144:
            case 393216:
                this.mGroupFlags &= -393217;
                this.mGroupFlags |= 393216 & i;
                return;
            default:
                throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        }
    }

    public void setLayoutAnimation(LayoutAnimationController layoutAnimationController) {
        this.mLayoutAnimationController = layoutAnimationController;
        if (this.mLayoutAnimationController != null) {
            this.mGroupFlags |= 8;
        }
    }

    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        this.mAnimationListener = animationListener;
    }

    public void setLayoutMode(int i) {
        if (this.mLayoutMode != i) {
            invalidateInheritedLayoutMode(i);
            setLayoutMode(i, i != -1);
            requestLayout();
        }
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (this.mTransition != null) {
            LayoutTransition layoutTransition2 = this.mTransition;
            layoutTransition2.cancel();
            layoutTransition2.removeTransitionListener(this.mLayoutTransitionListener);
        }
        this.mTransition = layoutTransition;
        if (this.mTransition != null) {
            this.mTransition.addTransitionListener(this.mLayoutTransitionListener);
        }
    }

    public void setMotionEventSplittingEnabled(boolean z) {
        if (z) {
            this.mGroupFlags |= 2097152;
        } else {
            this.mGroupFlags &= -2097153;
        }
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setPersistentDrawingCache(int i) {
        this.mPersistentDrawingCache = i & 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStaticTransformationsEnabled(boolean z) {
        setBooleanFlag(2048, z);
    }

    public void setTouchscreenBlocksFocus(boolean z) {
        View focusSearch;
        if (!z) {
            this.mGroupFlags &= -67108865;
            return;
        }
        this.mGroupFlags |= 67108864;
        if (!hasFocus() || getDeepestFocusedChild().isFocusableInTouchMode() || (focusSearch = focusSearch(2)) == null) {
            return;
        }
        focusSearch.requestFocus();
    }

    public void setTransitionGroup(boolean z) {
        this.mGroupFlags |= 33554432;
        if (z) {
            this.mGroupFlags |= 16777216;
        } else {
            this.mGroupFlags &= -16777217;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldBlockFocusForTouchscreen() {
        return getTouchscreenBlocksFocus() && this.mContext.getPackageManager().hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN);
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        return this.mParent != null && this.mParent.showContextMenuForChild(view);
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        if (this.mParent != null) {
            return this.mParent.startActionModeForChild(view, callback);
        }
        return null;
    }

    public void startLayoutAnimation() {
        if (this.mLayoutAnimationController != null) {
            this.mGroupFlags |= 8;
            requestLayout();
        }
    }

    public void startViewTransition(View view) {
        if (view.mParent == this) {
            if (this.mTransitioningViews == null) {
                this.mTransitioningViews = new ArrayList<>();
            }
            this.mTransitioningViews.add(view);
        }
    }

    public void suppressLayout(boolean z) {
        this.mSuppressLayout = z;
        if (z || !this.mLayoutCalledWhileSuppressed) {
            return;
        }
        requestLayout();
        this.mLayoutCalledWhileSuppressed = false;
    }

    public void transformPointToViewLocal(float[] fArr, View view) {
        fArr[0] = fArr[0] + (this.mScrollX - view.mLeft);
        fArr[1] = fArr[1] + (this.mScrollY - view.mTop);
        if (view.hasIdentityMatrix()) {
            return;
        }
        view.getInverseMatrix().mapPoints(fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public void unFocus(View view) {
        if (this.mFocused == null) {
            super.unFocus(view);
            return;
        }
        this.mFocused.unFocus(view);
        this.mFocused = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.View
    public boolean updateLocalSystemUiVisibility(int i, int i2) {
        boolean updateLocalSystemUiVisibility = super.updateLocalSystemUiVisibility(i, i2);
        int i3 = this.mChildrenCount;
        View[] viewArr = this.mChildren;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                return updateLocalSystemUiVisibility;
            }
            updateLocalSystemUiVisibility |= viewArr[i5].updateLocalSystemUiVisibility(i, i2);
            i4 = i5 + 1;
        }
    }

    @Override // android.view.ViewManager
    public void updateViewLayout(View view, LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
        }
        if (view.mParent != this) {
            throw new IllegalArgumentException("Given view not a child of " + this);
        }
        view.setLayoutParams(layoutParams);
    }
}
