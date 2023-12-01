package com.blued.android.module.common.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.igexin.push.config.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/AutoScrollViewPager.class */
public class AutoScrollViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private long f10940a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10941c;
    private boolean d;
    private int e;
    private boolean f;
    private double g;
    private double h;
    private Handler i;
    private boolean j;
    private boolean k;
    private float l;
    private float m;
    private CustomDurationScroller n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/AutoScrollViewPager$MyHandler.class */
    public static class MyHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<AutoScrollViewPager> f10942a;

        public MyHandler(AutoScrollViewPager autoScrollViewPager) {
            this.f10942a = new WeakReference<>(autoScrollViewPager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AutoScrollViewPager autoScrollViewPager;
            super.handleMessage(message);
            if (message.what == 0 && (autoScrollViewPager = this.f10942a.get()) != null) {
                autoScrollViewPager.n.a(autoScrollViewPager.g);
                autoScrollViewPager.c();
                autoScrollViewPager.n.a(autoScrollViewPager.h);
                autoScrollViewPager.a(autoScrollViewPager.f10940a + autoScrollViewPager.n.getDuration());
            }
        }
    }

    public AutoScrollViewPager(Context context) {
        super(context);
        this.f10940a = c.j;
        this.b = 1;
        this.f10941c = true;
        this.d = true;
        this.e = 0;
        this.f = true;
        this.g = 1.0d;
        this.h = 1.0d;
        this.j = false;
        this.k = false;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        d();
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10940a = c.j;
        this.b = 1;
        this.f10941c = true;
        this.d = true;
        this.e = 0;
        this.f = true;
        this.g = 1.0d;
        this.h = 1.0d;
        this.j = false;
        this.k = false;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.i.removeMessages(0);
        this.i.sendEmptyMessageDelayed(0, j);
    }

    private void d() {
        this.i = new MyHandler(this);
        e();
    }

    private void e() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            CustomDurationScroller customDurationScroller = new CustomDurationScroller(getContext(), (Interpolator) declaredField2.get(null));
            this.n = customDurationScroller;
            declaredField.set(this, customDurationScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.j = true;
        a((long) (this.f10940a + ((this.n.getDuration() / this.g) * this.h)));
    }

    public void a(int i) {
        this.j = true;
        a(i);
    }

    public void b() {
        this.j = false;
        this.i.removeMessages(0);
    }

    public void c() {
        int count;
        PagerAdapter adapter = getAdapter();
        int currentItem = getCurrentItem();
        if (adapter == null || (count = adapter.getCount()) <= 1) {
            return;
        }
        int i = this.b == 0 ? currentItem - 1 : currentItem + 1;
        if (i < 0) {
            if (this.f10941c) {
                setCurrentItem(count - 1, this.f);
            }
        } else if (i != count) {
            setCurrentItem(i, true);
        } else if (this.f10941c) {
            setCurrentItem(0, this.f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.d) {
            if (actionMasked == 0 && this.j) {
                this.k = true;
                b();
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.k) {
                a();
            }
        }
        int i = this.e;
        if (i == 2 || i == 1) {
            this.l = motionEvent.getX();
            if (motionEvent.getAction() == 0) {
                this.m = this.l;
            }
            int currentItem = getCurrentItem();
            PagerAdapter adapter = getAdapter();
            int count = adapter == null ? 0 : adapter.getCount();
            if ((currentItem == 0 && this.m <= this.l) || (currentItem == count - 1 && this.m >= this.l)) {
                if (this.e == 2) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    if (count > 1) {
                        setCurrentItem((count - currentItem) - 1, this.f);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getDirection() {
        return this.b == 0 ? 0 : 1;
    }

    public long getInterval() {
        return this.f10940a;
    }

    public int getSlideBorderMode() {
        return this.e;
    }

    public void setAutoScrollDurationFactor(double d) {
        this.g = d;
    }

    public void setBorderAnimation(boolean z) {
        this.f = z;
    }

    public void setCycle(boolean z) {
        this.f10941c = z;
    }

    public void setDirection(int i) {
        this.b = i;
    }

    public void setInterval(long j) {
        this.f10940a = j;
    }

    public void setSlideBorderMode(int i) {
        this.e = i;
    }

    public void setStopScrollWhenTouch(boolean z) {
        this.d = z;
    }

    public void setSwipeScrollDurationFactor(double d) {
        this.h = d;
    }
}
