package com.soft.blued.customview.swipecard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/FlingCardListener.class */
public class FlingCardListener implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f28657a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28658c;
    private final int d;
    private final int e;
    private final FlingListener f;
    private final Object g;
    private final float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private View o;
    private float r;
    private int n = -1;
    private boolean p = false;
    private int q = 200;
    private Runnable s = new Runnable() { // from class: com.soft.blued.customview.swipecard.FlingCardListener.1
        @Override // java.lang.Runnable
        public void run() {
            FlingCardListener.this.f.a(FlingCardListener.this.r, 0.0f);
            if (FlingCardListener.this.r > 0.0f) {
                FlingCardListener.this.r -= 0.1f;
                if (FlingCardListener.this.r < 0.0f) {
                    FlingCardListener.this.r = 0.0f;
                }
                FlingCardListener.this.o.postDelayed(this, FlingCardListener.this.q / 20);
            } else if (FlingCardListener.this.r < 0.0f) {
                FlingCardListener.this.r += 0.1f;
                if (FlingCardListener.this.r > 0.0f) {
                    FlingCardListener.this.r = 0.0f;
                }
                FlingCardListener.this.o.postDelayed(this, FlingCardListener.this.q / 20);
            }
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/FlingCardListener$FlingListener.class */
    public interface FlingListener {
        void a();

        void a(float f, float f2);

        void a(MotionEvent motionEvent, View view, Object obj);

        void a(Object obj);

        void b(Object obj);
    }

    public FlingCardListener(View view, Object obj, float f, FlingListener flingListener) {
        this.o = null;
        this.o = view;
        this.f28657a = view.getX();
        this.b = view.getY();
        this.f28658c = view.getHeight();
        int width = view.getWidth();
        this.d = width;
        this.h = width / 2.0f;
        this.g = obj;
        this.e = ((ViewGroup) view.getParent()).getWidth();
        this.i = f;
        this.f = flingListener;
    }

    private boolean a(MotionEvent motionEvent) {
        if (g()) {
            c();
            this.f.a(-1.0f, -1.0f);
            return false;
        } else if (h()) {
            d();
            this.f.a(1.0f, 1.0f);
            return false;
        } else {
            float abs = Math.abs(this.j - this.f28657a);
            float abs2 = Math.abs(this.k - this.b);
            if (abs >= 4.0f || abs2 >= 4.0f) {
                this.o.animate().setDuration(this.q).setInterpolator(new OvershootInterpolator(1.5f)).x(this.f28657a).y(this.b).rotation(0.0f).start();
                this.r = e();
                this.o.postDelayed(this.s, 0L);
            } else {
                this.f.a(motionEvent, this.o, this.g);
            }
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            return false;
        }
    }

    private float e() {
        float f = this.j - this.f28657a;
        float abs = Math.abs(f) / 3.5f;
        return (f > 0.0f ? Math.min(abs, a()) : -Math.min(abs, a())) / a();
    }

    private float f() {
        if (g()) {
            return -1.0f;
        }
        if (h()) {
            return 1.0f;
        }
        return ((((this.j + this.h) - a()) / (b() - a())) * 2.0f) - 1.0f;
    }

    private boolean g() {
        int intValue = this.o.getTag(R.id.current_index) == null ? 0 : ((Integer) this.o.getTag(R.id.current_index)).intValue();
        int intValue2 = this.o.getTag(R.id.total_szie) == null ? 0 : ((Integer) this.o.getTag(R.id.total_szie)).intValue();
        boolean z = false;
        if (this.j - this.f28657a < (-a())) {
            z = false;
            if (intValue < intValue2 - 1) {
                z = true;
            }
        }
        return z;
    }

    private boolean h() {
        int intValue = this.o.getTag(R.id.current_index) == null ? 0 : ((Integer) this.o.getTag(R.id.current_index)).intValue();
        boolean z = false;
        if (this.j - this.f28657a > b()) {
            z = false;
            if (intValue >= 1) {
                z = true;
            }
        }
        return z;
    }

    public float a() {
        return this.e / 5.0f;
    }

    public void a(long j) {
        if (this.p) {
            return;
        }
        a(true, this.b, j);
    }

    public void a(final boolean z, float f, long j) {
        float floatValue;
        float floatValue2;
        this.p = true;
        if (z) {
            floatValue = ((Float) this.o.getTag(R.id.left_x)).floatValue();
            floatValue2 = ((Float) this.o.getTag(R.id.left_y)).floatValue();
        } else {
            floatValue = ((Float) this.o.getTag(R.id.right_x)).floatValue();
            floatValue2 = ((Float) this.o.getTag(R.id.right_y)).floatValue();
        }
        this.o.animate().setDuration(j).setInterpolator(new DecelerateInterpolator()).scaleX(((Float) this.o.getTag(R.id.scale_x)).floatValue()).scaleY(((Float) this.o.getTag(R.id.scale_Y)).floatValue()).x(floatValue).y(floatValue2).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.customview.swipecard.FlingCardListener.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    FlingCardListener.this.f.a();
                    FlingCardListener.this.f.a(FlingCardListener.this.g);
                } else {
                    FlingCardListener.this.f.a();
                    FlingCardListener.this.f.b(FlingCardListener.this.g);
                }
                FlingCardListener.this.p = false;
            }
        }).start();
    }

    public float b() {
        return this.e / 5.0f;
    }

    public void b(long j) {
        if (this.p) {
            return;
        }
        a(false, this.b, j);
    }

    public void c() {
        if (this.p) {
            return;
        }
        a(this.q);
    }

    public void d() {
        if (this.p) {
            return;
        }
        b(this.q);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0111 A[Catch: Exception -> 0x0150, TRY_ENTER, TryCatch #0 {Exception -> 0x0150, blocks: (B:2:0x0000, B:15:0x0030, B:20:0x0051, B:22:0x005d, B:24:0x00c8, B:26:0x00df, B:28:0x00ed, B:30:0x00f4, B:36:0x0111, B:38:0x0125, B:40:0x0131, B:42:0x0139, B:44:0x0145), top: B:54:0x0000 }] */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.swipecard.FlingCardListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
