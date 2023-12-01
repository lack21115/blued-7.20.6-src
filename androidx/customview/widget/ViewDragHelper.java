package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/customview/widget/ViewDragHelper.class */
public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final Interpolator w = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f2774a;
    private int b;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private final int p;
    private int q;
    private OverScroller r;
    private final Callback s;
    private View t;
    private boolean u;
    private final ViewGroup v;

    /* renamed from: c  reason: collision with root package name */
    private int f2775c = -1;
    private final Runnable x = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.a(0);
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:androidx/customview/widget/ViewDragHelper$Callback.class */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.v = viewGroup;
        this.s = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.p = i;
        this.o = i;
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, w);
    }

    private float a(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private int a(int i, int i2) {
        int i3 = i < this.v.getLeft() + this.o ? 1 : 0;
        int i4 = i3;
        if (i2 < this.v.getTop() + this.o) {
            i4 = i3 | 4;
        }
        int i5 = i4;
        if (i > this.v.getRight() - this.o) {
            i5 = i4 | 2;
        }
        int i6 = i5;
        if (i2 > this.v.getBottom() - this.o) {
            i6 = i5 | 8;
        }
        return i6;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f = width / 2;
        float a2 = a(Math.min(1.0f, Math.abs(i) / width));
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs((f + (a2 * f)) / abs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int b = b(i3, (int) this.n, (int) this.m);
        int b2 = b(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (b != 0) {
            f = abs3;
            f2 = i5;
        } else {
            f = abs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (b2 != 0) {
            f3 = abs4;
            f4 = i5;
        } else {
            f3 = abs2;
            f4 = i6;
        }
        return (int) ((a(i, b, this.s.getViewHorizontalDragRange(view)) * f5) + (a(i2, b2, this.s.getViewVerticalDragRange(view)) * (f3 / f4)));
    }

    private void a() {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void a(float f, float f2) {
        this.u = true;
        this.s.onViewReleased(this.t, f, f2);
        this.u = false;
        if (this.f2774a == 1) {
            a(0);
        }
    }

    private void a(float f, float f2, int i) {
        c(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = a((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private void a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pointerCount) {
                return;
            }
            int pointerId = motionEvent.getPointerId(i2);
            if (d(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
            i = i2 + 1;
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        boolean z = false;
        if ((this.h[i] & i2) == i2) {
            z = false;
            if ((this.q & i2) != 0) {
                z = false;
                if ((this.j[i] & i2) != i2) {
                    z = false;
                    if ((this.i[i] & i2) != i2) {
                        int i3 = this.b;
                        if (abs <= i3 && abs2 <= i3) {
                            return false;
                        }
                        if (abs < abs2 * 0.5f && this.s.onEdgeLock(i2)) {
                            int[] iArr = this.j;
                            iArr[i] = iArr[i] | i2;
                            return false;
                        }
                        z = false;
                        if ((this.i[i] & i2) == 0) {
                            z = false;
                            if (abs > this.b) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.r.abortAnimation();
            a(0);
            return false;
        }
        this.r.startScroll(left, top, i5, i6, a(this.t, i5, i6, i3, i4));
        a(2);
        return true;
    }

    private boolean a(View view, float f, float f2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        boolean z2 = this.s.getViewHorizontalDragRange(view) > 0;
        boolean z3 = this.s.getViewVerticalDragRange(view) > 0;
        if (z2 && z3) {
            int i = this.b;
            if ((f * f) + (f2 * f2) > i * i) {
                z = true;
            }
            return z;
        } else if (z2) {
            boolean z4 = false;
            if (Math.abs(f) > this.b) {
                z4 = true;
            }
            return z4;
        } else {
            boolean z5 = false;
            if (z3) {
                z5 = false;
                if (Math.abs(f2) > this.b) {
                    z5 = true;
                }
            }
            return z5;
        }
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private void b() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.f2775c), this.n, this.m), a(this.l.getYVelocity(this.f2775c), this.n, this.m));
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        int i3 = i2;
        if (a(f2, f, i, 4)) {
            i3 = i2 | 4;
        }
        int i4 = i3;
        if (a(f, f2, i, 2)) {
            i4 = i3 | 2;
        }
        int i5 = i4;
        if (a(f2, f, i, 8)) {
            i5 = i4 | 8;
        }
        if (i5 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i5;
            this.s.onEdgeDragStarted(i5, i);
        }
    }

    private void b(int i) {
        if (this.d == null || !isPointerDown(i)) {
            return;
        }
        this.d[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (1 << i) & this.k;
    }

    private void b(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i5 = i;
        if (i3 != 0) {
            i5 = this.s.clampViewPositionHorizontal(this.t, i, i3);
            ViewCompat.offsetLeftAndRight(this.t, i5 - left);
        }
        int i6 = i2;
        if (i4 != 0) {
            i6 = this.s.clampViewPositionVertical(this.t, i2, i4);
            ViewCompat.offsetTopAndBottom(this.t, i6 - top);
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.s.onViewPositionChanged(this.t, i5, i6, i5 - left, i6 - top);
    }

    private void c(int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.d;
            if (fArr6 != null) {
                System.arraycopy((Object) fArr6, 0, (Object) fArr2, 0, fArr6.length);
                float[] fArr7 = this.e;
                System.arraycopy((Object) fArr7, 0, (Object) fArr3, 0, fArr7.length);
                float[] fArr8 = this.f;
                System.arraycopy((Object) fArr8, 0, (Object) fArr4, 0, fArr8.length);
                float[] fArr9 = this.g;
                System.arraycopy((Object) fArr9, 0, (Object) fArr5, 0, fArr9.length);
                int[] iArr4 = this.h;
                System.arraycopy((Object) iArr4, 0, (Object) iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy((Object) iArr5, 0, (Object) iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy((Object) iArr6, 0, (Object) iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.b = (int) (create.b * (1.0f / f));
        return create;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private boolean d(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void a(int i) {
        this.v.removeCallbacks(this.x);
        if (this.f2774a != i) {
            this.f2774a = i;
            this.s.onViewDragStateChanged(i);
            if (this.f2774a == 0) {
                this.t = null;
            }
        }
    }

    boolean a(View view, int i) {
        if (view == this.t && this.f2775c == i) {
            return true;
        }
        if (view == null || !this.s.tryCaptureView(view, i)) {
            return false;
        }
        this.f2775c = i;
        captureChildView(view, i);
        return true;
    }

    public void abort() {
        cancel();
        if (this.f2774a == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.onViewPositionChanged(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        a(0);
    }

    public void cancel() {
        this.f2775c = -1;
        a();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.f2775c = i;
            this.s.onViewCaptured(view, i);
            a(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public boolean checkTouchSlop(int i) {
        int length = this.d.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (checkTouchSlop(i, i3)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public boolean checkTouchSlop(int i, int i2) {
        boolean z = false;
        if (isPointerDown(i2)) {
            boolean z2 = (i & 1) == 1;
            boolean z3 = (i & 2) == 2;
            float f = this.f[i2] - this.d[i2];
            float f2 = this.g[i2] - this.e[i2];
            if (z2 && z3) {
                int i3 = this.b;
                if ((f * f) + (f2 * f2) > i3 * i3) {
                    z = true;
                }
                return z;
            } else if (z2) {
                boolean z4 = false;
                if (Math.abs(f) > this.b) {
                    z4 = true;
                }
                return z4;
            } else {
                boolean z5 = false;
                if (z3) {
                    z5 = false;
                    if (Math.abs(f2) > this.b) {
                        z5 = true;
                    }
                }
                return z5;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        if (this.f2774a == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.t, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.t, top);
            }
            if (left != 0 || top != 0) {
                this.s.onViewPositionChanged(this.t, currX, currY, left, top);
            }
            boolean z2 = computeScrollOffset;
            if (computeScrollOffset) {
                z2 = computeScrollOffset;
                if (currX == this.r.getFinalX()) {
                    z2 = computeScrollOffset;
                    if (currY == this.r.getFinalY()) {
                        this.r.abortAnimation();
                        z2 = false;
                    }
                }
            }
            if (!z2) {
                if (z) {
                    this.v.post(this.x);
                } else {
                    a(0);
                }
            }
        }
        boolean z3 = false;
        if (this.f2774a == 2) {
            z3 = true;
        }
        return z3;
    }

    public View findTopChildUnder(int i, int i2) {
        int childCount = this.v.getChildCount();
        while (true) {
            int i3 = childCount - 1;
            if (i3 < 0) {
                return null;
            }
            View childAt = this.v.getChildAt(this.s.getOrderedChildIndex(i3));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
            childCount = i3;
        }
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (!this.u) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.r.fling(this.t.getLeft(), this.t.getTop(), (int) this.l.getXVelocity(this.f2775c), (int) this.l.getYVelocity(this.f2775c), i, i3, i2, i4);
        a(2);
    }

    public int getActivePointerId() {
        return this.f2775c;
    }

    public View getCapturedView() {
        return this.t;
    }

    public int getDefaultEdgeSize() {
        return this.p;
    }

    public int getEdgeSize() {
        return this.o;
    }

    public float getMinVelocity() {
        return this.n;
    }

    public int getTouchSlop() {
        return this.b;
    }

    public int getViewDragState() {
        return this.f2774a;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.t, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.h.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (isEdgeTouched(i, i3)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.h[i2]) != 0;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.k) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        boolean z = false;
        if (i >= view.getLeft()) {
            z = false;
            if (i < view.getRight()) {
                z = false;
                if (i2 >= view.getTop()) {
                    z = false;
                    if (i2 < view.getBottom()) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            a(x, y, pointerId);
            a(findTopChildUnder, pointerId);
            int i3 = this.h[pointerId];
            int i4 = this.q;
            if ((i3 & i4) != 0) {
                this.s.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f2774a == 1) {
                b();
            }
            cancel();
        } else if (actionMasked == 2) {
            if (this.f2774a == 1) {
                if (d(this.f2775c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2775c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f;
                    int i5 = this.f2775c;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.g[i5]);
                    b(this.t.getLeft() + i6, this.t.getTop() + i7, i6, i7);
                    a(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= pointerCount) {
                    break;
                }
                int pointerId2 = motionEvent.getPointerId(i9);
                if (d(pointerId2)) {
                    float x3 = motionEvent.getX(i9);
                    float y3 = motionEvent.getY(i9);
                    float f = x3 - this.d[pointerId2];
                    float f2 = y3 - this.e[pointerId2];
                    b(f, f2, pointerId2);
                    if (this.f2774a != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                        if (a(findTopChildUnder2, f, f2) && a(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i8 = i9 + 1;
            }
            a(motionEvent);
        } else if (actionMasked == 3) {
            if (this.f2774a == 1) {
                a(0.0f, 0.0f);
            }
            cancel();
        } else if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            a(x4, y4, pointerId3);
            if (this.f2774a != 0) {
                if (isCapturedViewUnder((int) x4, (int) y4)) {
                    a(this.t, pointerId3);
                    return;
                }
                return;
            }
            a(findTopChildUnder((int) x4, (int) y4), pointerId3);
            int i10 = this.h[pointerId3];
            int i11 = this.q;
            if ((i10 & i11) != 0) {
                this.s.onEdgeTouched(i10 & i11, pointerId3);
            }
        } else if (actionMasked != 6) {
        } else {
            int pointerId4 = motionEvent.getPointerId(actionIndex);
            if (this.f2774a == 1 && pointerId4 == this.f2775c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId5 = motionEvent.getPointerId(i2);
                    if (pointerId5 != this.f2775c) {
                        View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view = this.t;
                        if (findTopChildUnder3 == view && a(view, pointerId5)) {
                            i = this.f2775c;
                            break;
                        }
                    }
                    i2++;
                }
                if (i == -1) {
                    b();
                }
            }
            b(pointerId4);
        }
    }

    public void setEdgeSize(int i) {
        this.o = i;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.q = i;
    }

    public void setMinVelocity(float f) {
        this.n = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.u) {
            return a(i, i2, (int) this.l.getXVelocity(this.f2775c), (int) this.l.getYVelocity(this.f2775c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01b5, code lost:
        if (r0 != r0) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.t = view;
        this.f2775c = -1;
        boolean a2 = a(i, i2, 0, 0);
        if (!a2 && this.f2774a == 0 && this.t != null) {
            this.t = null;
        }
        return a2;
    }
}
