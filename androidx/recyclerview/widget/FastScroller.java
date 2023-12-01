package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/FastScroller.class */
public class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int[] k = {16842919};
    private static final int[] l = new int[0];

    /* renamed from: a  reason: collision with root package name */
    final StateListDrawable f3261a;
    final Drawable b;

    /* renamed from: c  reason: collision with root package name */
    int f3262c;
    int d;
    float e;
    int f;
    int g;
    float h;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final StateListDrawable q;
    private final Drawable r;
    private final int s;
    private final int t;
    private RecyclerView w;
    private int u = 0;
    private int v = 0;
    private boolean x = false;
    private boolean y = false;
    private int z = 0;
    private int A = 0;
    private final int[] B = new int[2];
    private final int[] C = new int[2];
    final ValueAnimator i = ValueAnimator.ofFloat(0.0f, 1.0f);
    int j = 0;
    private final Runnable D = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.b(500);
        }
    };
    private final RecyclerView.OnScrollListener E = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FastScroller.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/FastScroller$AnimatorListener.class */
    class AnimatorListener extends AnimatorListenerAdapter {
        private boolean b = false;

        AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.b) {
                this.b = false;
            } else if (((Float) FastScroller.this.i.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller.this.j = 0;
                FastScroller.this.a(0);
            } else {
                FastScroller.this.j = 2;
                FastScroller.this.a();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/FastScroller$AnimatorUpdater.class */
    class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f3261a.setAlpha(floatValue);
            FastScroller.this.b.setAlpha(floatValue);
            FastScroller.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f3261a = stateListDrawable;
        this.b = drawable;
        this.q = stateListDrawable2;
        this.r = drawable2;
        this.o = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.p = Math.max(i, drawable.getIntrinsicWidth());
        this.s = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.t = Math.max(i, drawable2.getIntrinsicWidth());
        this.m = i2;
        this.n = i3;
        this.f3261a.setAlpha(255);
        this.b.setAlpha(255);
        this.i.addListener(new AnimatorListener());
        this.i.addUpdateListener(new AnimatorUpdater());
        attachToRecyclerView(recyclerView);
    }

    private int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        float f3 = (f2 - f) / i4;
        int i5 = i - i3;
        int i6 = (int) (f3 * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    private void a(float f) {
        int[] f2 = f();
        float max = Math.max(f2[0], Math.min(f2[1], f));
        if (Math.abs(this.d - max) < 2.0f) {
            return;
        }
        int a2 = a(this.e, max, f2, this.w.computeVerticalScrollRange(), this.w.computeVerticalScrollOffset(), this.v);
        if (a2 != 0) {
            this.w.scrollBy(0, a2);
        }
        this.e = max;
    }

    private void a(Canvas canvas) {
        int i = this.u;
        int i2 = this.o;
        int i3 = i - i2;
        int i4 = this.d;
        int i5 = this.f3262c;
        int i6 = i4 - (i5 / 2);
        this.f3261a.setBounds(0, 0, i2, i5);
        this.b.setBounds(0, 0, this.p, this.v);
        if (!d()) {
            canvas.translate(i3, 0.0f);
            this.b.draw(canvas);
            canvas.translate(0.0f, i6);
            this.f3261a.draw(canvas);
            canvas.translate(-i3, -i6);
            return;
        }
        this.b.draw(canvas);
        canvas.translate(this.o, i6);
        canvas.scale(-1.0f, 1.0f);
        this.f3261a.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.o, -i6);
    }

    private void b() {
        this.w.addItemDecoration(this);
        this.w.addOnItemTouchListener(this);
        this.w.addOnScrollListener(this.E);
    }

    private void b(float f) {
        int[] g = g();
        float max = Math.max(g[0], Math.min(g[1], f));
        if (Math.abs(this.g - max) < 2.0f) {
            return;
        }
        int a2 = a(this.h, max, g, this.w.computeHorizontalScrollRange(), this.w.computeHorizontalScrollOffset(), this.u);
        if (a2 != 0) {
            this.w.scrollBy(a2, 0);
        }
        this.h = max;
    }

    private void b(Canvas canvas) {
        int i = this.v;
        int i2 = this.s;
        int i3 = i - i2;
        int i4 = this.g;
        int i5 = this.f;
        int i6 = i4 - (i5 / 2);
        this.q.setBounds(0, 0, i5, i2);
        this.r.setBounds(0, 0, this.u, this.t);
        canvas.translate(0.0f, i3);
        this.r.draw(canvas);
        canvas.translate(i6, 0.0f);
        this.q.draw(canvas);
        canvas.translate(-i6, -i3);
    }

    private void c() {
        this.w.removeItemDecoration(this);
        this.w.removeOnItemTouchListener(this);
        this.w.removeOnScrollListener(this.E);
        e();
    }

    private void c(int i) {
        e();
        this.w.postDelayed(this.D, i);
    }

    private boolean d() {
        return ViewCompat.getLayoutDirection(this.w) == 1;
    }

    private void e() {
        this.w.removeCallbacks(this.D);
    }

    private int[] f() {
        int[] iArr = this.B;
        int i = this.n;
        iArr[0] = i;
        iArr[1] = this.v - i;
        return iArr;
    }

    private int[] g() {
        int[] iArr = this.C;
        int i = this.n;
        iArr[0] = i;
        iArr[1] = this.u - i;
        return iArr;
    }

    void a() {
        this.w.invalidate();
    }

    void a(int i) {
        if (i == 2 && this.z != 2) {
            this.f3261a.setState(k);
            e();
        }
        if (i == 0) {
            a();
        } else {
            show();
        }
        if (this.z == 2 && i != 2) {
            this.f3261a.setState(l);
            c(1200);
        } else if (i == 1) {
            c(1500);
        }
        this.z = i;
    }

    void a(int i, int i2) {
        int computeVerticalScrollRange = this.w.computeVerticalScrollRange();
        int i3 = this.v;
        this.x = computeVerticalScrollRange - i3 > 0 && i3 >= this.m;
        int computeHorizontalScrollRange = this.w.computeHorizontalScrollRange();
        int i4 = this.u;
        boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= this.m;
        this.y = z;
        if (!this.x && !z) {
            if (this.z != 0) {
                a(0);
                return;
            }
            return;
        }
        if (this.x) {
            float f = i3;
            this.d = (int) ((f * (i2 + (f / 2.0f))) / computeVerticalScrollRange);
            this.f3262c = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (this.y) {
            float f2 = i4;
            this.g = (int) ((f2 * (i + (f2 / 2.0f))) / computeHorizontalScrollRange);
            this.f = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
        }
        int i5 = this.z;
        if (i5 == 0 || i5 == 1) {
            a(1);
        }
    }

    boolean a(float f, float f2) {
        if (d()) {
            if (f > this.o / 2) {
                return false;
            }
        } else if (f < this.u - this.o) {
            return false;
        }
        int i = this.d;
        int i2 = this.f3262c;
        return f2 >= ((float) (i - (i2 / 2))) && f2 <= ((float) (i + (i2 / 2)));
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.w;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            c();
        }
        this.w = recyclerView;
        if (recyclerView != null) {
            b();
        }
    }

    void b(int i) {
        int i2 = this.j;
        if (i2 == 1) {
            this.i.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.j = 3;
        ValueAnimator valueAnimator = this.i;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.i.setDuration(i);
        this.i.start();
    }

    boolean b(float f, float f2) {
        if (f2 >= this.v - this.s) {
            int i = this.g;
            int i2 = this.f;
            return f >= ((float) (i - (i2 / 2))) && f <= ((float) (i + (i2 / 2)));
        }
        return false;
    }

    public boolean isDragging() {
        return this.z == 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.u != this.w.getWidth() || this.v != this.w.getHeight()) {
            this.u = this.w.getWidth();
            this.v = this.w.getHeight();
            a(0);
        } else if (this.j != 0) {
            if (this.x) {
                a(canvas);
            }
            if (this.y) {
                b(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        if (r0 == 2) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
        if (r0 != false) goto L9;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            r0 = r4
            int r0 = r0.z
            r7 = r0
            r0 = 0
            r9 = r0
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L75
            r0 = r4
            r1 = r6
            float r1 = r1.getX()
            r2 = r6
            float r2 = r2.getY()
            boolean r0 = r0.a(r1, r2)
            r10 = r0
            r0 = r4
            r1 = r6
            float r1 = r1.getX()
            r2 = r6
            float r2 = r2.getY()
            boolean r0 = r0.b(r1, r2)
            r11 = r0
            r0 = r9
            r8 = r0
            r0 = r6
            int r0 = r0.getAction()
            if (r0 != 0) goto L81
            r0 = r10
            if (r0 != 0) goto L42
            r0 = r9
            r8 = r0
            r0 = r11
            if (r0 == 0) goto L81
        L42:
            r0 = r11
            if (r0 == 0) goto L59
            r0 = r4
            r1 = 1
            r0.A = r1
            r0 = r4
            r1 = r6
            float r1 = r1.getX()
            int r1 = (int) r1
            float r1 = (float) r1
            r0.h = r1
            goto L6d
        L59:
            r0 = r10
            if (r0 == 0) goto L6d
            r0 = r4
            r1 = 2
            r0.A = r1
            r0 = r4
            r1 = r6
            float r1 = r1.getY()
            int r1 = (int) r1
            float r1 = (float) r1
            r0.e = r1
        L6d:
            r0 = r4
            r1 = 2
            r0.a(r1)
            goto L7e
        L75:
            r0 = r9
            r8 = r0
            r0 = r7
            r1 = 2
            if (r0 != r1) goto L81
        L7e:
            r0 = 1
            r8 = r0
        L81:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.FastScroller.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.z == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            boolean b = b(motionEvent.getX(), motionEvent.getY());
            if (a2 || b) {
                if (b) {
                    this.A = 1;
                    this.h = (int) motionEvent.getX();
                } else if (a2) {
                    this.A = 2;
                    this.e = (int) motionEvent.getY();
                }
                a(2);
            }
        } else if (motionEvent.getAction() == 1 && this.z == 2) {
            this.e = 0.0f;
            this.h = 0.0f;
            a(1);
            this.A = 0;
        } else if (motionEvent.getAction() == 2 && this.z == 2) {
            show();
            if (this.A == 1) {
                b(motionEvent.getX());
            }
            if (this.A == 2) {
                a(motionEvent.getY());
            }
        }
    }

    public void show() {
        int i = this.j;
        if (i != 0) {
            if (i != 3) {
                return;
            }
            this.i.cancel();
        }
        this.j = 1;
        ValueAnimator valueAnimator = this.i;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.i.setDuration(500L);
        this.i.setStartDelay(0L);
        this.i.start();
    }
}
