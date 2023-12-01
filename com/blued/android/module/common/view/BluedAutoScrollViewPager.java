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

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedAutoScrollViewPager.class */
public class BluedAutoScrollViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private long f10945a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10946c;
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
    private BluedDurationScroller n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedAutoScrollViewPager$MyHandler.class */
    public static class MyHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<BluedAutoScrollViewPager> f10947a;

        public MyHandler(BluedAutoScrollViewPager bluedAutoScrollViewPager) {
            this.f10947a = new WeakReference<>(bluedAutoScrollViewPager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BluedAutoScrollViewPager bluedAutoScrollViewPager;
            super.handleMessage(message);
            if (message.what == 0 && (bluedAutoScrollViewPager = this.f10947a.get()) != null) {
                bluedAutoScrollViewPager.n.a(bluedAutoScrollViewPager.g);
                bluedAutoScrollViewPager.c();
                bluedAutoScrollViewPager.n.a(bluedAutoScrollViewPager.h);
                bluedAutoScrollViewPager.a(bluedAutoScrollViewPager.f10945a + bluedAutoScrollViewPager.n.getDuration());
            }
        }
    }

    public BluedAutoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10945a = c.j;
        this.b = 1;
        this.f10946c = true;
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
            BluedDurationScroller bluedDurationScroller = new BluedDurationScroller(getContext(), (Interpolator) declaredField2.get(null));
            this.n = bluedDurationScroller;
            declaredField.set(this, bluedDurationScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.j = true;
        a((long) (this.f10945a + ((this.n.getDuration() / this.g) * this.h)));
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
            if (this.f10946c) {
                setCurrentItem(count - 1, this.f);
            }
        } else if (i != count) {
            setCurrentItem(i, true);
        } else if (this.f10946c) {
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
        return this.f10945a;
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
        this.f10946c = z;
    }

    public void setDirection(int i) {
        this.b = i;
    }

    public void setInterval(long j) {
        this.f10945a = j;
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
