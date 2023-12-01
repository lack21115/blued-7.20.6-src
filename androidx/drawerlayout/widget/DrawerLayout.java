package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout.class */
public class DrawerLayout extends ViewGroup implements Openable {
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static boolean O = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    static final boolean b;
    private static final boolean d;
    private Drawable A;
    private Drawable B;
    private Drawable C;
    private CharSequence D;
    private CharSequence E;
    private Object F;
    private boolean G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private final ArrayList<View> L;
    private Rect M;
    private Matrix N;
    private final AccessibilityViewCommand P;
    private final ChildAccessibilityDelegate e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final ViewDragHelper k;
    private final ViewDragHelper l;
    private final ViewDragCallback m;
    private final ViewDragCallback n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private DrawerListener w;
    private List<DrawerListener> x;
    private float y;
    private float z;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2734c = {R.attr.colorPrimaryDark};

    /* renamed from: a  reason: collision with root package name */
    static final int[] f2733a = {R.attr.layout_gravity};

    /* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout$AccessibilityDelegate.class */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect b = new Rect();

        AccessibilityDelegate() {
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    return;
                }
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.g(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
                i = i2 + 1;
            }
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.b;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View b = DrawerLayout.this.b();
                if (b != null) {
                    CharSequence drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.d(b));
                    if (drawerTitle != null) {
                        text.add(drawerTitle);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.b) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                accessibilityNodeInfoCompat.setSource(view);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                a(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.b || DrawerLayout.g(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout$ChildAccessibilityDelegate.class */
    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (DrawerLayout.g(view)) {
                return;
            }
            accessibilityNodeInfoCompat.setParent(null);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout$DrawerListener.class */
    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        float f2738a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        int f2739c;
        public int gravity;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2733a);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout$SavedState.class */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f2740a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f2741c;
        int d;
        int e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2740a = 0;
            this.f2740a = parcel.readInt();
            this.b = parcel.readInt();
            this.f2741c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f2740a = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2740a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.f2741c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout$SimpleDrawerListener.class */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View view, float f) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/drawerlayout/widget/DrawerLayout$ViewDragCallback.class */
    public class ViewDragCallback extends ViewDragHelper.Callback {
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private ViewDragHelper f2743c;
        private final Runnable d = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public void run() {
                ViewDragCallback.this.a();
            }
        };

        ViewDragCallback(int i) {
            this.b = i;
        }

        private void b() {
            int i = 3;
            if (this.b == 3) {
                i = 5;
            }
            View a2 = DrawerLayout.this.a(i);
            if (a2 != null) {
                DrawerLayout.this.closeDrawer(a2);
            }
        }

        void a() {
            View a2;
            int width;
            int edgeSize = this.f2743c.getEdgeSize();
            int i = 0;
            boolean z = this.b == 3;
            if (z) {
                a2 = DrawerLayout.this.a(3);
                if (a2 != null) {
                    i = -a2.getWidth();
                }
                width = i + edgeSize;
            } else {
                a2 = DrawerLayout.this.a(5);
                width = DrawerLayout.this.getWidth() - edgeSize;
            }
            if (a2 != null) {
                if (((!z || a2.getLeft() >= width) && (z || a2.getLeft() <= width)) || DrawerLayout.this.getDrawerLockMode(a2) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
                this.f2743c.smoothSlideViewTo(a2, width, a2.getTop());
                layoutParams.b = true;
                DrawerLayout.this.invalidate();
                b();
                DrawerLayout.this.c();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.f(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            View a2 = (i & 1) == 1 ? DrawerLayout.this.a(3) : DrawerLayout.this.a(5);
            if (a2 == null || DrawerLayout.this.getDrawerLockMode(a2) != 0) {
                return;
            }
            this.f2743c.captureChildView(a2, i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int i) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.d, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).b = false;
            b();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.a(i, this.f2743c.getCapturedView());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.a(view, 3) ? i + width : DrawerLayout.this.getWidth() - i) / width;
            DrawerLayout.this.b(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
            if (r0 > 0.5f) goto L20;
         */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onViewReleased(android.view.View r5, float r6, float r7) {
            /*
                r4 = this;
                r0 = r4
                androidx.drawerlayout.widget.DrawerLayout r0 = androidx.drawerlayout.widget.DrawerLayout.this
                r1 = r5
                float r0 = r0.c(r1)
                r7 = r0
                r0 = r5
                int r0 = r0.getWidth()
                r10 = r0
                r0 = r4
                androidx.drawerlayout.widget.DrawerLayout r0 = androidx.drawerlayout.widget.DrawerLayout.this
                r1 = r5
                r2 = 3
                boolean r0 = r0.a(r1, r2)
                if (r0 == 0) goto L42
                r0 = r6
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                r8 = r0
                r0 = r8
                if (r0 > 0) goto L3c
                r0 = r8
                if (r0 != 0) goto L34
                r0 = r7
                r1 = 1056964608(0x3f000000, float:0.5)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L34
                goto L3c
            L34:
                r0 = r10
                int r0 = -r0
                r8 = r0
                goto L6d
            L3c:
                r0 = 0
                r8 = r0
                goto L6d
            L42:
                r0 = r4
                androidx.drawerlayout.widget.DrawerLayout r0 = androidx.drawerlayout.widget.DrawerLayout.this
                int r0 = r0.getWidth()
                r9 = r0
                r0 = r6
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L66
                r0 = r9
                r8 = r0
                r0 = r6
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L6d
                r0 = r9
                r8 = r0
                r0 = r7
                r1 = 1056964608(0x3f000000, float:0.5)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L6d
            L66:
                r0 = r9
                r1 = r10
                int r0 = r0 - r1
                r8 = r0
            L6d:
                r0 = r4
                androidx.customview.widget.ViewDragHelper r0 = r0.f2743c
                r1 = r8
                r2 = r5
                int r2 = r2.getTop()
                boolean r0 = r0.settleCapturedViewAt(r1, r2)
                r0 = r4
                androidx.drawerlayout.widget.DrawerLayout r0 = androidx.drawerlayout.widget.DrawerLayout.this
                r0.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.onViewReleased(android.view.View, float, float):void");
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.d);
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            this.f2743c = viewDragHelper;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.f(view) && DrawerLayout.this.a(view, this.b) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 19;
        d = Build.VERSION.SDK_INT >= 21;
        O = Build.VERSION.SDK_INT >= 29;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new ChildAccessibilityDelegate();
        this.h = -1728053248;
        this.j = new Paint();
        this.q = true;
        this.r = 3;
        this.s = 3;
        this.t = 3;
        this.u = 3;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.P = new AccessibilityViewCommand() { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                if (!DrawerLayout.this.isDrawerOpen(view) || DrawerLayout.this.getDrawerLockMode(view) == 2) {
                    return false;
                }
                DrawerLayout.this.closeDrawer(view);
                return true;
            }
        };
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.g = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        this.m = new ViewDragCallback(3);
        this.n = new ViewDragCallback(5);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, this.m);
        this.k = create;
        create.setEdgeTrackingEnabled(1);
        this.k.setMinVelocity(f2);
        this.m.setDragger(this.k);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, this.n);
        this.l = create2;
        create2.setEdgeTrackingEnabled(2);
        this.l.setMinVelocity(f2);
        this.n.setDragger(this.l);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f2734c);
                try {
                    this.A = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.A = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i, 0);
        try {
            if (obtainStyledAttributes2.hasValue(androidx.drawerlayout.R.styleable.DrawerLayout_elevation)) {
                this.f = obtainStyledAttributes2.getDimension(androidx.drawerlayout.R.styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.f = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.L = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void a(Drawable drawable, int i) {
        if (drawable == null || !DrawableCompat.isAutoMirrored(drawable)) {
            return;
        }
        DrawableCompat.setLayoutDirection(drawable, i);
    }

    private void a(View view, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if ((z || f(childAt)) && !(z && childAt == view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
            i = i2 + 1;
        }
    }

    private boolean a(float f, float f2, View view) {
        if (this.M == null) {
            this.M = new Rect();
        }
        view.getHitRect(this.M);
        return this.M.contains((int) f, (int) f2);
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent b2 = b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(b2);
            b2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent b(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.N == null) {
                this.N = new Matrix();
            }
            matrix.invert(this.N);
            obtain.transform(this.N);
        }
        return obtain;
    }

    static String b(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private void d() {
        if (d) {
            return;
        }
        this.B = e();
        this.C = f();
    }

    private Drawable e() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.H;
            if (drawable != null) {
                a(drawable, layoutDirection);
                return this.H;
            }
        } else {
            Drawable drawable2 = this.I;
            if (drawable2 != null) {
                a(drawable2, layoutDirection);
                return this.I;
            }
        }
        return this.J;
    }

    private Drawable f() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.I;
            if (drawable != null) {
                a(drawable, layoutDirection);
                return this.I;
            }
        } else {
            Drawable drawable2 = this.H;
            if (drawable2 != null) {
                a(drawable2, layoutDirection);
                return this.H;
            }
        }
        return this.K;
    }

    private boolean g() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return false;
            }
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).b) {
                return true;
            }
            i = i2 + 1;
        }
    }

    static boolean g(View view) {
        return (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true;
    }

    private void h(View view) {
        ViewCompat.removeAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS.getId());
        if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
            return;
        }
        ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, this.P);
    }

    private boolean h() {
        return b() != null;
    }

    private static boolean i(View view) {
        Drawable background = view.getBackground();
        boolean z = false;
        if (background != null) {
            z = false;
            if (background.getOpacity() == -1) {
                z = true;
            }
        }
        return z;
    }

    View a() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return null;
            }
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).f2739c & 1) == 1) {
                return childAt;
            }
            i = i2 + 1;
        }
    }

    View a(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return null;
            }
            View childAt = getChildAt(i3);
            if ((d(childAt) & 7) == (absoluteGravity & 7)) {
                return childAt;
            }
            i2 = i3 + 1;
        }
    }

    void a(int i, View view) {
        int i2;
        int viewDragState = this.k.getViewDragState();
        int viewDragState2 = this.l.getViewDragState();
        if (viewDragState == 1 || viewDragState2 == 1) {
            i2 = 1;
        } else {
            i2 = 2;
            if (viewDragState != 2) {
                i2 = viewDragState2 == 2 ? 2 : 0;
            }
        }
        if (view != null && i == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f2738a == 0.0f) {
                a(view);
            } else if (layoutParams.f2738a == 1.0f) {
                b(view);
            }
        }
        if (i2 == this.o) {
            return;
        }
        this.o = i2;
        List<DrawerListener> list = this.x;
        if (list == null) {
            return;
        }
        int size = list.size();
        while (true) {
            int i3 = size - 1;
            if (i3 < 0) {
                return;
            }
            this.x.get(i3).onDrawerStateChanged(i2);
            size = i3;
        }
    }

    void a(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2739c & 1) == 1) {
            layoutParams.f2739c = 0;
            List<DrawerListener> list = this.x;
            if (list != null) {
                int size = list.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        break;
                    }
                    this.x.get(i).onDrawerClosed(view);
                    size = i;
                }
            }
            a(view, false);
            h(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void a(View view, float f) {
        List<DrawerListener> list = this.x;
        if (list == null) {
            return;
        }
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.x.get(i).onDrawerSlide(view, f);
            size = i;
        }
    }

    void a(boolean z) {
        boolean z2;
        int childCount = getChildCount();
        int i = 0;
        boolean z3 = false;
        while (true) {
            z2 = z3;
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            boolean z4 = z2;
            if (f(childAt)) {
                if (!z || layoutParams.b) {
                    z4 = z2 | (a(childAt, 3) ? this.k.smoothSlideViewTo(childAt, -childAt.getWidth(), childAt.getTop()) : this.l.smoothSlideViewTo(childAt, getWidth(), childAt.getTop()));
                    layoutParams.b = false;
                } else {
                    z4 = z2;
                }
            }
            i++;
            z3 = z4;
        }
        this.m.removeCallbacks();
        this.n.removeCallbacks();
        if (z2) {
            invalidate();
        }
    }

    boolean a(View view, int i) {
        return (d(view) & i) == i;
    }

    public void addDrawerListener(DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.add(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!f(childAt)) {
                this.L.add(childAt);
            } else if (isDrawerOpen(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.L.size();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size) {
                    break;
                }
                View view = this.L.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
                i4 = i5 + 1;
            }
        }
        this.L.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (a() != null || f(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (b) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(view, this.e);
    }

    View b() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return null;
            }
            View childAt = getChildAt(i2);
            if (f(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
            i = i2 + 1;
        }
    }

    void b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2739c & 1) == 0) {
            layoutParams.f2739c = 1;
            List<DrawerListener> list = this.x;
            if (list != null) {
                int size = list.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        break;
                    }
                    this.x.get(i).onDrawerOpened(view);
                    size = i;
                }
            }
            a(view, true);
            h(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.f2738a) {
            return;
        }
        layoutParams.f2738a = f;
        a(view, f);
    }

    float c(View view) {
        return ((LayoutParams) view.getLayoutParams()).f2738a;
    }

    void c() {
        if (this.v) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                obtain.recycle();
                this.v = true;
                return;
            }
            getChildAt(i2).dispatchTouchEvent(obtain);
            i = i2 + 1;
        }
    }

    void c(View view, float f) {
        float c2 = c(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (c2 * width));
        if (!a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        b(view, f);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(8388611);
    }

    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public void closeDrawer(int i, boolean z) {
        View a2 = a(i);
        if (a2 != null) {
            closeDrawer(a2, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + b(i));
    }

    public void closeDrawer(View view) {
        closeDrawer(view, true);
    }

    public void closeDrawer(View view, boolean z) {
        if (!f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.q) {
            layoutParams.f2738a = 0.0f;
            layoutParams.f2739c = 0;
        } else if (z) {
            layoutParams.f2739c |= 4;
            if (a(view, 3)) {
                this.k.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
            } else {
                this.l.smoothSlideViewTo(view, getWidth(), view.getTop());
            }
        } else {
            c(view, 0.0f);
            a(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void closeDrawers() {
        a(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                break;
            }
            f = Math.max(f, ((LayoutParams) getChildAt(i2).getLayoutParams()).f2738a);
            i = i2 + 1;
        }
        this.i = f;
        boolean continueSettling = this.k.continueSettling(true);
        boolean continueSettling2 = this.l.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int d(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return false;
            }
            View childAt = getChildAt(childCount);
            if (a(x, y, childAt) && !e(childAt) && a(motionEvent, childAt)) {
                return true;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int i2;
        int height = getHeight();
        boolean e = e(view);
        int width = getWidth();
        int save = canvas.save();
        int i3 = 0;
        int i4 = width;
        if (e) {
            int childCount = getChildCount();
            int i5 = 0;
            int i6 = 0;
            while (true) {
                i2 = i6;
                if (i5 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i5);
                int i7 = width;
                int i8 = i2;
                if (childAt != view) {
                    i7 = width;
                    i8 = i2;
                    if (childAt.getVisibility() == 0) {
                        i7 = width;
                        i8 = i2;
                        if (i(childAt)) {
                            i7 = width;
                            i8 = i2;
                            if (f(childAt)) {
                                if (childAt.getHeight() < height) {
                                    i7 = width;
                                    i8 = i2;
                                } else if (a(childAt, 3)) {
                                    int right = childAt.getRight();
                                    i7 = width;
                                    i8 = i2;
                                    if (right > i2) {
                                        i8 = right;
                                        i7 = width;
                                    }
                                } else {
                                    int left = childAt.getLeft();
                                    i7 = width;
                                    i8 = i2;
                                    if (left < width) {
                                        i7 = left;
                                        i8 = i2;
                                    }
                                }
                            }
                        }
                    }
                }
                i5++;
                width = i7;
                i6 = i8;
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i3 = i2;
            i4 = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.i;
        if (f > 0.0f && e) {
            this.j.setColor((this.h & 16777215) | (((int) ((((-16777216) & i) >>> 24) * f)) << 24));
            canvas.drawRect(i3, 0.0f, i4, getHeight(), this.j);
            return drawChild;
        } else if (this.B != null && a(view, 3)) {
            int intrinsicWidth = this.B.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.k.getEdgeSize(), 1.0f));
            this.B.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.B.setAlpha((int) (max * 255.0f));
            this.B.draw(canvas);
            return drawChild;
        } else {
            if (this.C != null && a(view, 5)) {
                int intrinsicWidth2 = this.C.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.l.getEdgeSize(), 1.0f));
                this.C.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.C.setAlpha((int) (max2 * 255.0f));
                this.C.draw(canvas);
            }
            return drawChild;
        }
    }

    boolean e(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    boolean f(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (d) {
            return this.f;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i == 3) {
            int i2 = this.r;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.t : this.u;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i == 5) {
            int i4 = this.s;
            if (i4 != 3) {
                return i4;
            }
            int i5 = layoutDirection == 0 ? this.u : this.t;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        } else if (i == 8388611) {
            int i6 = this.t;
            if (i6 != 3) {
                return i6;
            }
            int i7 = layoutDirection == 0 ? this.r : this.s;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i != 8388613) {
            return 0;
        } else {
            int i8 = this.u;
            if (i8 != 3) {
                return i8;
            }
            int i9 = layoutDirection == 0 ? this.s : this.r;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        }
    }

    public int getDrawerLockMode(View view) {
        if (f(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).gravity);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.D;
        }
        if (absoluteGravity == 5) {
            return this.E;
        }
        return null;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.A;
    }

    public boolean isDrawerOpen(int i) {
        View a2 = a(i);
        if (a2 != null) {
            return isDrawerOpen(a2);
        }
        return false;
    }

    public boolean isDrawerOpen(View view) {
        if (f(view)) {
            return (((LayoutParams) view.getLayoutParams()).f2739c & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(int i) {
        View a2 = a(i);
        if (a2 != null) {
            return isDrawerVisible(a2);
        }
        return false;
    }

    public boolean isDrawerVisible(View view) {
        if (f(view)) {
            return ((LayoutParams) view.getLayoutParams()).f2738a > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(8388611);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.G || this.A == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.F) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.A.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.A.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && h()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View b2 = b();
            if (b2 != null && getDrawerLockMode(b2) == 0) {
                closeDrawers();
            }
            return b2 != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        int i5;
        float f;
        int i6;
        this.p = true;
        int i7 = i3 - i;
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (e(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        int i10 = -measuredWidth;
                        float f2 = measuredWidth;
                        i5 = i10 + ((int) (layoutParams.f2738a * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        i5 = i7 - ((int) (layoutParams.f2738a * f3));
                        f = (i7 - i5) / f3;
                    }
                    boolean z2 = f != layoutParams.f2738a;
                    int i11 = layoutParams.gravity & 112;
                    if (i11 == 16) {
                        int i12 = i4 - i2;
                        int i13 = (i12 - measuredHeight) / 2;
                        if (i13 < layoutParams.topMargin) {
                            i6 = layoutParams.topMargin;
                        } else {
                            i6 = i13;
                            if (i13 + measuredHeight > i12 - layoutParams.bottomMargin) {
                                i6 = (i12 - layoutParams.bottomMargin) - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
                    } else if (i11 != 80) {
                        childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i14 = i4 - i2;
                        childAt.layout(i5, (i14 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i14 - layoutParams.bottomMargin);
                    }
                    if (z2) {
                        b(childAt, f);
                    }
                    int i15 = layoutParams.f2738a > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i15) {
                        childAt.setVisibility(i15);
                    }
                }
            }
            i8 = i9 + 1;
        }
        if (O && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = this.k;
            viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.left));
            ViewDragHelper viewDragHelper2 = this.l;
            viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets.right));
        }
        this.p = false;
        this.q = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002d, code lost:
        if (r0 != 1073741824) goto L79;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View a2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f2740a != 0 && (a2 = a(savedState.f2740a)) != null) {
            openDrawer(a2);
        }
        if (savedState.b != 3) {
            setDrawerLockMode(savedState.b, 3);
        }
        if (savedState.f2741c != 3) {
            setDrawerLockMode(savedState.f2741c, 5);
        }
        if (savedState.d != 3) {
            setDrawerLockMode(savedState.d, 8388611);
        }
        if (savedState.e != 3) {
            setDrawerLockMode(savedState.e, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        r0.f2740a = r0.gravity;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.os.Parcelable onSaveInstanceState() {
        /*
            r4 = this;
            androidx.drawerlayout.widget.DrawerLayout$SavedState r0 = new androidx.drawerlayout.widget.DrawerLayout$SavedState
            r1 = r0
            r2 = r4
            android.os.Parcelable r2 = super.onSaveInstanceState()
            r1.<init>(r2)
            r9 = r0
            r0 = r4
            int r0 = r0.getChildCount()
            r8 = r0
            r0 = 0
            r5 = r0
        L15:
            r0 = r5
            r1 = r8
            if (r0 >= r1) goto L66
            r0 = r4
            r1 = r5
            android.view.View r0 = r0.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r0 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r0
            r10 = r0
            r0 = r10
            int r0 = r0.f2739c
            r6 = r0
            r0 = 1
            r7 = r0
            r0 = r6
            r1 = 1
            if (r0 != r1) goto L3a
            r0 = 1
            r6 = r0
            goto L3c
        L3a:
            r0 = 0
            r6 = r0
        L3c:
            r0 = r10
            int r0 = r0.f2739c
            r1 = 2
            if (r0 != r1) goto L48
            goto L4a
        L48:
            r0 = 0
            r7 = r0
        L4a:
            r0 = r6
            if (r0 != 0) goto L5c
            r0 = r7
            if (r0 == 0) goto L55
            goto L5c
        L55:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L15
        L5c:
            r0 = r9
            r1 = r10
            int r1 = r1.gravity
            r0.f2740a = r1
        L66:
            r0 = r9
            r1 = r4
            int r1 = r1.r
            r0.b = r1
            r0 = r9
            r1 = r4
            int r1 = r1.s
            r0.f2741c = r1
            r0 = r9
            r1 = r4
            int r1 = r1.t
            r0.d = r1
            r0 = r9
            r1 = r4
            int r1 = r1.u
            r0.e = r1
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onSaveInstanceState():android.os.Parcelable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
        if (getDrawerLockMode(r0) != 2) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            Method dump skipped, instructions count: 190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(8388611);
    }

    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void openDrawer(int i, boolean z) {
        View a2 = a(i);
        if (a2 != null) {
            openDrawer(a2, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + b(i));
    }

    public void openDrawer(View view) {
        openDrawer(view, true);
    }

    public void openDrawer(View view, boolean z) {
        if (!f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.q) {
            layoutParams.f2738a = 1.0f;
            layoutParams.f2739c = 1;
            a(view, true);
            h(view);
        } else if (z) {
            layoutParams.f2739c |= 2;
            if (a(view, 3)) {
                this.k.smoothSlideViewTo(view, 0, view.getTop());
            } else {
                this.l.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            c(view, 1.0f);
            a(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void removeDrawerListener(DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener == null || (list = this.x) == null) {
            return;
        }
        list.remove(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            a(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.p) {
            return;
        }
        super.requestLayout();
    }

    public void setChildInsets(Object obj, boolean z) {
        this.F = obj;
        this.G = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f = f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(i2);
            if (f(childAt)) {
                ViewCompat.setElevation(childAt, this.f);
            }
            i = i2 + 1;
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.w;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.w = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        View a2;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (i2 == 3) {
            this.r = i;
        } else if (i2 == 5) {
            this.s = i;
        } else if (i2 == 8388611) {
            this.t = i;
        } else if (i2 == 8388613) {
            this.u = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.k : this.l).cancel();
        }
        if (i != 1) {
            if (i == 2 && (a2 = a(absoluteGravity)) != null) {
                openDrawer(a2);
                return;
            }
            return;
        }
        View a3 = a(absoluteGravity);
        if (a3 != null) {
            closeDrawer(a3);
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (f(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).gravity);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), i), i2);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (d) {
            return;
        }
        if ((i & 8388611) == 8388611) {
            this.H = drawable;
        } else if ((i & 8388613) == 8388613) {
            this.I = drawable;
        } else if ((i & 3) == 3) {
            this.J = drawable;
        } else if ((i & 5) != 5) {
            return;
        } else {
            this.K = drawable;
        }
        d();
        invalidate();
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.D = charSequence;
        } else if (absoluteGravity == 5) {
            this.E = charSequence;
        }
    }

    public void setScrimColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.A = i != 0 ? ContextCompat.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.A = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.A = new ColorDrawable(i);
        invalidate();
    }
}
