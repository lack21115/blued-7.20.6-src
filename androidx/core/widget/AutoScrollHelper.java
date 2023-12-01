package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/AutoScrollHelper.class */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int r = ViewConfiguration.getTapTimeout();
    final View b;

    /* renamed from: c  reason: collision with root package name */
    boolean f2743c;
    boolean d;
    boolean e;
    private Runnable g;
    private int j;
    private int k;
    private boolean o;
    private boolean p;
    private boolean q;

    /* renamed from: a  reason: collision with root package name */
    final ClampedScroller f2742a = new ClampedScroller();
    private final Interpolator f = new AccelerateInterpolator();
    private float[] h = {0.0f, 0.0f};
    private float[] i = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] l = {0.0f, 0.0f};
    private float[] m = {0.0f, 0.0f};
    private float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/AutoScrollHelper$ClampedScroller.class */
    public static class ClampedScroller {

        /* renamed from: a  reason: collision with root package name */
        private int f2744a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private float f2745c;
        private float d;
        private float j;
        private int k;
        private long e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        ClampedScroller() {
        }

        private float a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        private float a(long j) {
            if (j < this.e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 < 0 || j < j2) {
                return AutoScrollHelper.a(((float) (j - this.e)) / this.f2744a, 0.0f, 1.0f) * 0.5f;
            }
            float f = this.j;
            return (1.0f - f) + (f * AutoScrollHelper.a(((float) (j - j2)) / this.k, 0.0f, 1.0f));
        }

        public void computeScrollDelta() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a2 = a(a(currentAnimationTimeMillis));
            long j = this.f;
            this.f = currentAnimationTimeMillis;
            float f = ((float) (currentAnimationTimeMillis - j)) * a2;
            this.g = (int) (this.f2745c * f);
            this.h = (int) (f * this.d);
        }

        public int getDeltaX() {
            return this.g;
        }

        public int getDeltaY() {
            return this.h;
        }

        public int getHorizontalDirection() {
            float f = this.f2745c;
            return (int) (f / Math.abs(f));
        }

        public int getVerticalDirection() {
            float f = this.d;
            return (int) (f / Math.abs(f));
        }

        public boolean isFinished() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = AutoScrollHelper.a((int) (currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i) {
            this.b = i;
        }

        public void setRampUpDuration(int i) {
            this.f2744a = i;
        }

        public void setTargetVelocity(float f, float f2) {
            this.f2745c = f;
            this.d = f2;
        }

        public void start() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.e = currentAnimationTimeMillis;
            this.i = -1L;
            this.f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/AutoScrollHelper$ScrollAnimationRunnable.class */
    public class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AutoScrollHelper.this.e) {
                if (AutoScrollHelper.this.f2743c) {
                    AutoScrollHelper.this.f2743c = false;
                    AutoScrollHelper.this.f2742a.start();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.f2742a;
                if (clampedScroller.isFinished() || !AutoScrollHelper.this.a()) {
                    AutoScrollHelper.this.e = false;
                    return;
                }
                if (AutoScrollHelper.this.d) {
                    AutoScrollHelper.this.d = false;
                    AutoScrollHelper.this.b();
                }
                clampedScroller.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.b, this);
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = i;
        setMaximumVelocity(f, f);
        float f2 = i2;
        setMinimumVelocity(f2, f2);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(r);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float a(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.j;
        if (i == 0 || i == 1) {
            if (f < f2) {
                return f >= 0.0f ? 1.0f - (f / f2) : (this.e && this.j == 1) ? 1.0f : 0.0f;
            }
            return 0.0f;
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        } else {
            return 0.0f;
        }
    }

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float a2 = a(f * f2, 0.0f, f3);
        float a3 = a(f2 - f4, a2) - a(f4, a2);
        if (a3 < 0.0f) {
            interpolation = -this.f.getInterpolation(-a3);
        } else if (a3 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f.getInterpolation(a3);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    private float a(int i, float f, float f2, float f3) {
        float a2 = a(this.h[i], f2, this.i[i], f);
        int i2 = (a2 > 0.0f ? 1 : (a2 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return 0.0f;
        }
        float f4 = this.l[i];
        float f5 = this.m[i];
        float f6 = this.n[i];
        float f7 = f4 * f3;
        return i2 > 0 ? a(a2 * f7, f5, f6) : -a((-a2) * f7, f5, f6);
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void c() {
        int i;
        if (this.g == null) {
            this.g = new ScrollAnimationRunnable();
        }
        this.e = true;
        this.f2743c = true;
        if (this.o || (i = this.k) <= 0) {
            this.g.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.b, this.g, i);
        }
        this.o = true;
    }

    private void d() {
        if (this.f2743c) {
            this.e = false;
        } else {
            this.f2742a.requestStop();
        }
    }

    boolean a() {
        ClampedScroller clampedScroller = this.f2742a;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        if (verticalDirection == 0 || !canTargetScrollVertically(verticalDirection)) {
            return horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection);
        }
        return true;
    }

    void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.b.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    public boolean isEnabled() {
        return this.p;
    }

    public boolean isExclusive() {
        return this.q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r0 != 3) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            r0 = r6
            boolean r0 = r0.p
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r12
            if (r0 != 0) goto L10
            r0 = 0
            return r0
        L10:
            r0 = r8
            int r0 = r0.getActionMasked()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L37
            r0 = r11
            r1 = 1
            if (r0 == r1) goto L30
            r0 = r11
            r1 = 2
            if (r0 == r1) goto L41
            r0 = r11
            r1 = 3
            if (r0 == r1) goto L30
            goto L8c
        L30:
            r0 = r6
            r0.d()
            goto L8c
        L37:
            r0 = r6
            r1 = 1
            r0.d = r1
            r0 = r6
            r1 = 0
            r0.o = r1
        L41:
            r0 = r6
            r1 = 0
            r2 = r8
            float r2 = r2.getX()
            r3 = r7
            int r3 = r3.getWidth()
            float r3 = (float) r3
            r4 = r6
            android.view.View r4 = r4.b
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r0.a(r1, r2, r3, r4)
            r9 = r0
            r0 = r6
            r1 = 1
            r2 = r8
            float r2 = r2.getY()
            r3 = r7
            int r3 = r3.getHeight()
            float r3 = (float) r3
            r4 = r6
            android.view.View r4 = r4.b
            int r4 = r4.getHeight()
            float r4 = (float) r4
            float r0 = r0.a(r1, r2, r3, r4)
            r10 = r0
            r0 = r6
            androidx.core.widget.AutoScrollHelper$ClampedScroller r0 = r0.f2742a
            r1 = r9
            r2 = r10
            r0.setTargetVelocity(r1, r2)
            r0 = r6
            boolean r0 = r0.e
            if (r0 != 0) goto L8c
            r0 = r6
            boolean r0 = r0.a()
            if (r0 == 0) goto L8c
            r0 = r6
            r0.c()
        L8c:
            r0 = r13
            r12 = r0
            r0 = r6
            boolean r0 = r0.q
            if (r0 == 0) goto La5
            r0 = r13
            r12 = r0
            r0 = r6
            boolean r0 = r0.e
            if (r0 == 0) goto La5
            r0 = 1
            r12 = r0
        La5:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i, int i2);

    public AutoScrollHelper setActivationDelay(int i) {
        this.k = i;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i) {
        this.j = i;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.q = z;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        float[] fArr = this.n;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        float[] fArr = this.m;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i) {
        this.f2742a.setRampDownDuration(i);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i) {
        this.f2742a.setRampUpDuration(i);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        float[] fArr = this.h;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        float[] fArr = this.l;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }
}
