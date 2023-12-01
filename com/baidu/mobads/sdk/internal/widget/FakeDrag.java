package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/widget/FakeDrag.class */
final class FakeDrag {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPager2 f9449a;
    private final ScrollEventAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f9450c;
    private VelocityTracker d;
    private int e;
    private float f;
    private int g;
    private long h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f9449a = viewPager2;
        this.b = scrollEventAdapter;
        this.f9450c = recyclerView;
    }

    private void a(long j, int i, float f, float f2) {
        MotionEvent obtain = MotionEvent.obtain(this.h, j, i, f, f2, 0);
        this.d.addMovement(obtain);
        obtain.recycle();
    }

    private void d() {
        VelocityTracker velocityTracker = this.d;
        if (velocityTracker != null) {
            velocityTracker.clear();
            return;
        }
        this.d = VelocityTracker.obtain();
        this.e = ViewConfiguration.get(this.f9449a.getContext()).getScaledMaximumFlingVelocity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.b.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(float f) {
        if (this.b.g()) {
            float f2 = this.f - f;
            this.f = f2;
            int round = Math.round(f2 - this.g);
            this.g += round;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z = this.f9449a.getOrientation() == 0;
            int i = z ? round : 0;
            if (z) {
                round = 0;
            }
            float f3 = z ? this.f : 0.0f;
            float f4 = z ? 0.0f : this.f;
            this.f9450c.scrollBy(i, round);
            a(uptimeMillis, 2, f3, f4);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        if (this.b.f()) {
            return false;
        }
        this.g = 0;
        this.f = 0;
        this.h = SystemClock.uptimeMillis();
        d();
        this.b.b();
        if (!this.b.e()) {
            this.f9450c.stopScroll();
        }
        a(this.h, 0, 0.0f, 0.0f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        if (this.b.g()) {
            this.b.c();
            VelocityTracker velocityTracker = this.d;
            velocityTracker.computeCurrentVelocity(1000, this.e);
            if (this.f9450c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                return true;
            }
            this.f9449a.d();
            return true;
        }
        return false;
    }
}
