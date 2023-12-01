package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/swiperefreshlayout/widget/SwipeRefreshLayout.class */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final int LARGE = 0;
    private boolean A;
    private int B;
    private boolean C;
    private final DecelerateInterpolator D;
    private int F;
    private Animation G;
    private Animation H;
    private Animation I;
    private Animation J;
    private Animation K;
    private int L;
    private OnChildScrollUpCallback M;
    private Animation.AnimationListener N;
    private final Animation O;
    private final Animation P;

    /* renamed from: a  reason: collision with root package name */
    OnRefreshListener f3392a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    int f3393c;
    boolean d;
    CircleImageView e;
    protected int f;
    float g;
    protected int h;
    int i;
    int j;
    CircularProgressDrawable k;
    boolean l;
    boolean m;
    private View o;
    private int p;
    private float q;
    private float r;
    private final NestedScrollingParentHelper s;
    private final NestedScrollingChildHelper t;
    private final int[] u;
    private final int[] v;
    private boolean w;
    private int x;
    private float y;
    private float z;
    private static final String n = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] E = {16842766};

    /* loaded from: source-8756600-dex2jar.jar:androidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnChildScrollUpCallback.class */
    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener.class */
    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.q = -1.0f;
        this.u = new int[2];
        this.v = new int[2];
        this.B = -1;
        this.F = -1;
        this.N = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (!SwipeRefreshLayout.this.b) {
                    SwipeRefreshLayout.this.a();
                    return;
                }
                SwipeRefreshLayout.this.k.setAlpha(255);
                SwipeRefreshLayout.this.k.start();
                if (SwipeRefreshLayout.this.l && SwipeRefreshLayout.this.f3392a != null) {
                    SwipeRefreshLayout.this.f3392a.onRefresh();
                }
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                swipeRefreshLayout.f3393c = swipeRefreshLayout.e.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.O = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                int abs = !SwipeRefreshLayout.this.m ? SwipeRefreshLayout.this.i - Math.abs(SwipeRefreshLayout.this.h) : SwipeRefreshLayout.this.i;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.f + ((int) ((abs - SwipeRefreshLayout.this.f) * f))) - SwipeRefreshLayout.this.e.getTop());
                SwipeRefreshLayout.this.k.setArrowScale(1.0f - f);
            }
        };
        this.P = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.p = ViewConfiguration.get(context).getScaledTouchSlop();
        this.x = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.D = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.L = (int) (displayMetrics.density * 40.0f);
        b();
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.i = i;
        this.q = i;
        this.s = new NestedScrollingParentHelper(this);
        this.t = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.L;
        this.f3393c = i2;
        this.h = i2;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private Animation a(final int i, final int i2) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.k;
                int i3 = i;
                circularProgressDrawable.setAlpha((int) (i3 + ((i2 - i3) * f)));
            }
        };
        animation.setDuration(300L);
        this.e.setAnimationListener(null);
        this.e.clearAnimation();
        this.e.startAnimation(animation);
        return animation;
    }

    private void a(int i, Animation.AnimationListener animationListener) {
        this.f = i;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.D);
        if (animationListener != null) {
            this.e.setAnimationListener(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.O);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.B) {
            this.B = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void a(boolean z, boolean z2) {
        if (this.b != z) {
            this.l = z2;
            e();
            this.b = z;
            if (z) {
                a(this.f3393c, this.N);
            } else {
                a(this.N);
            }
        }
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void b() {
        this.e = new CircleImageView(getContext(), -328966);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.k = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        this.e.setImageDrawable(this.k);
        this.e.setVisibility(8);
        addView(this.e);
    }

    private void b(float f) {
        this.k.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f / this.q));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f);
        float f2 = this.q;
        int i = this.j;
        if (i <= 0) {
            i = this.m ? this.i - this.h : this.i;
        }
        float f3 = i;
        double max2 = Math.max(0.0f, Math.min(abs - f2, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i2 = this.h;
        int i3 = (int) ((f3 * min) + (f3 * pow * 2.0f));
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (!this.d) {
            this.e.setScaleX(1.0f);
            this.e.setScaleY(1.0f);
        }
        if (this.d) {
            setAnimationProgress(Math.min(1.0f, f / this.q));
        }
        if (f < this.q) {
            if (this.k.getAlpha() > 76 && !a(this.I)) {
                c();
            }
        } else if (this.k.getAlpha() < 255 && !a(this.J)) {
            d();
        }
        this.k.setStartEndTrim(0.0f, Math.min(0.8f, max * 0.8f));
        this.k.setArrowScale(Math.min(1.0f, max));
        this.k.setProgressRotation((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom((i2 + i3) - this.f3393c);
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        if (this.d) {
            c(i, animationListener);
            return;
        }
        this.f = i;
        this.P.reset();
        this.P.setDuration(200L);
        this.P.setInterpolator(this.D);
        if (animationListener != null) {
            this.e.setAnimationListener(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.P);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.e.setVisibility(0);
        this.k.setAlpha(255);
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.G = animation;
        animation.setDuration(this.x);
        if (animationListener != null) {
            this.e.setAnimationListener(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.G);
    }

    private void c() {
        this.I = a(this.k.getAlpha(), 76);
    }

    private void c(float f) {
        if (f > this.q) {
            a(true, true);
            return;
        }
        this.b = false;
        this.k.setStartEndTrim(0.0f, 0.0f);
        Animation.AnimationListener animationListener = null;
        if (!this.d) {
            animationListener = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (SwipeRefreshLayout.this.d) {
                        return;
                    }
                    SwipeRefreshLayout.this.a((Animation.AnimationListener) null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            };
        }
        b(this.f3393c, animationListener);
        this.k.setArrowEnabled(false);
    }

    private void c(int i, Animation.AnimationListener animationListener) {
        this.f = i;
        this.g = this.e.getScaleX();
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.g + ((-SwipeRefreshLayout.this.g) * f));
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.K = animation;
        animation.setDuration(150L);
        if (animationListener != null) {
            this.e.setAnimationListener(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.K);
    }

    private void d() {
        this.J = a(this.k.getAlpha(), 255);
    }

    private void d(float f) {
        float f2 = this.z;
        int i = this.p;
        if (f - f2 <= i || this.A) {
            return;
        }
        this.y = f2 + i;
        this.A = true;
        this.k.setAlpha(76);
    }

    private void e() {
        if (this.o != null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.e)) {
                this.o = childAt;
                return;
            }
            i = i2 + 1;
        }
    }

    private void setColorViewAlpha(int i) {
        this.e.getBackground().setAlpha(i);
        this.k.setAlpha(i);
    }

    void a() {
        this.e.clearAnimation();
        this.k.stop();
        this.e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.h - this.f3393c);
        }
        this.f3393c = this.e.getTop();
    }

    void a(float f) {
        int i = this.f;
        setTargetOffsetTopAndBottom((i + ((int) ((this.h - i) * f))) - this.e.getTop());
    }

    void a(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.H = animation;
        animation.setDuration(150L);
        this.e.setAnimationListener(animationListener);
        this.e.clearAnimation();
        this.e.startAnimation(this.H);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.M;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.o);
        }
        View view = this.o;
        return view instanceof ListView ? ListViewCompat.canScrollList((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.t.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.t.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.t.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.t.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.F;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return i3;
        }
        int i4 = i2;
        if (i2 >= i3) {
            i4 = i2 + 1;
        }
        return i4;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.s.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.L;
    }

    public int getProgressViewEndOffset() {
        return this.i;
    }

    public int getProgressViewStartOffset() {
        return this.h;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.t.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.t.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e();
        int actionMasked = motionEvent.getActionMasked();
        if (this.C && actionMasked == 0) {
            this.C = false;
        }
        if (!isEnabled() || this.C || canChildScrollUp() || this.b || this.w) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.B;
                    if (i == -1) {
                        Log.e(n, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.A = false;
            this.B = -1;
        } else {
            setTargetOffsetTopAndBottom(this.h - this.e.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.B = pointerId;
            this.A = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.z = motionEvent.getY(findPointerIndex2);
        }
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.o == null) {
            e();
        }
        View view = this.o;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.e.getMeasuredWidth();
        int measuredHeight2 = this.e.getMeasuredHeight();
        CircleImageView circleImageView = this.e;
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.f3393c;
        circleImageView.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.o == null) {
            e();
        }
        View view = this.o;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.e.measure(View.MeasureSpec.makeMeasureSpec(this.L, 1073741824), View.MeasureSpec.makeMeasureSpec(this.L, 1073741824));
        this.F = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= getChildCount()) {
                return;
            }
            if (getChildAt(i4) == this.e) {
                this.F = i4;
                return;
            }
            i3 = i4 + 1;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.r;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.r = 0.0f;
                } else {
                    this.r = f - f2;
                    iArr[1] = i2;
                }
                b(this.r);
            }
        }
        if (this.m && i2 > 0 && this.r == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.e.setVisibility(8);
        }
        int[] iArr2 = this.u;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.v);
        int i5 = i4 + this.v[1];
        if (i5 >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.r + Math.abs(i5);
        this.r = abs;
        b(abs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.s.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.r = 0.0f;
        this.w = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.C || this.b || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.s.onStopNestedScroll(view);
        this.w = false;
        float f = this.r;
        if (f > 0.0f) {
            c(f);
            this.r = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.C && actionMasked == 0) {
            this.C = false;
        }
        if (!isEnabled() || this.C || canChildScrollUp() || this.b || this.w) {
            return false;
        }
        if (actionMasked == 0) {
            this.B = motionEvent.getPointerId(0);
            this.A = false;
            return true;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.B);
            if (findPointerIndex < 0) {
                Log.e(n, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.A) {
                float y = motionEvent.getY(findPointerIndex);
                float f = this.y;
                this.A = false;
                c((y - f) * 0.5f);
            }
            this.B = -1;
            return false;
        } else if (actionMasked != 2) {
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return true;
                    }
                    a(motionEvent);
                    return true;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(n, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.B = motionEvent.getPointerId(actionIndex);
                return true;
            }
            return false;
        } else {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.B);
            if (findPointerIndex2 < 0) {
                Log.e(n, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            d(y2);
            if (this.A) {
                float f2 = (y2 - this.y) * 0.5f;
                if (f2 > 0.0f) {
                    b(f2);
                    return true;
                }
                return false;
            }
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.o instanceof AbsListView)) {
            View view = this.o;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    void setAnimationProgress(float f) {
        this.e.setScaleX(f);
        this.e.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        e();
        this.k.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                setColorSchemeColors(iArr2);
                return;
            } else {
                iArr2[i2] = ContextCompat.getColor(context, iArr[i2]);
                i = i2 + 1;
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.q = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        a();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.t.setNestedScrollingEnabled(z);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.M = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f3392a = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.e.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.i = i;
        this.d = z;
        this.e.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.d = z;
        this.h = i;
        this.i = i2;
        this.m = true;
        a();
        this.b = false;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.b == z) {
            a(z, false);
            return;
        }
        this.b = z;
        setTargetOffsetTopAndBottom((!this.m ? this.i + this.h : this.i) - this.f3393c);
        this.l = false;
        b(this.N);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.L = (int) (displayMetrics.density * 56.0f);
            } else {
                this.L = (int) (displayMetrics.density * 40.0f);
            }
            this.e.setImageDrawable(null);
            this.k.setStyle(i);
            this.e.setImageDrawable(this.k);
        }
    }

    public void setSlingshotDistance(int i) {
        this.j = i;
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.e.bringToFront();
        ViewCompat.offsetTopAndBottom(this.e, i);
        this.f3393c = this.e.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.t.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.t.stopNestedScroll();
    }
}
