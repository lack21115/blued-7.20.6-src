package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.igexin.push.config.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoScrollViewPager.class */
public class LiveAutoScrollViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private long f14380a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14381c;
    private boolean d;
    private int e;
    private boolean f;
    private double g;
    private double h;
    private boolean i;
    private Handler j;
    private boolean k;
    private boolean l;
    private float m;
    private float n;
    private CustomDurationScroller o;
    private ScrollAnimationListener p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoScrollViewPager$MyHandler.class */
    public static class MyHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<LiveAutoScrollViewPager> f14383a;

        public MyHandler(LiveAutoScrollViewPager liveAutoScrollViewPager) {
            this.f14383a = new WeakReference<>(liveAutoScrollViewPager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LiveAutoScrollViewPager liveAutoScrollViewPager;
            super.handleMessage(message);
            if (message.what == 0 && (liveAutoScrollViewPager = this.f14383a.get()) != null) {
                liveAutoScrollViewPager.o.a(liveAutoScrollViewPager.g);
                liveAutoScrollViewPager.c();
                liveAutoScrollViewPager.o.a(liveAutoScrollViewPager.h);
                liveAutoScrollViewPager.a(liveAutoScrollViewPager.f14380a + liveAutoScrollViewPager.o.getDuration());
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoScrollViewPager$ScrollAnimationListener.class */
    public interface ScrollAnimationListener {
        void a(int i);

        boolean a(int i, int i2);
    }

    public LiveAutoScrollViewPager(Context context) {
        super(context);
        this.f14380a = c.j;
        this.b = 1;
        this.f14381c = true;
        this.d = true;
        this.e = 0;
        this.f = true;
        this.g = 1.0d;
        this.h = 1.0d;
        this.i = false;
        this.k = false;
        this.l = false;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = null;
        d();
    }

    public LiveAutoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14380a = c.j;
        this.b = 1;
        this.f14381c = true;
        this.d = true;
        this.e = 0;
        this.f = true;
        this.g = 1.0d;
        this.h = 1.0d;
        this.i = false;
        this.k = false;
        this.l = false;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = null;
        d();
    }

    private void a(final int i) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(150L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveAutoScrollViewPager.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveAutoScrollViewPager.this.setCurrentItem(i, false);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setInterpolator(new LinearInterpolator());
                scaleAnimation2.setDuration(150L);
                LiveAutoScrollViewPager.this.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.j.removeMessages(0);
        this.j.sendEmptyMessageDelayed(0, j);
    }

    private void d() {
        this.j = new MyHandler(this);
        e();
    }

    private void e() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            CustomDurationScroller customDurationScroller = new CustomDurationScroller(getContext(), (Interpolator) declaredField2.get(null));
            this.o = customDurationScroller;
            declaredField.set(this, customDurationScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.k = true;
        a((long) (this.f14380a + ((this.o.getDuration() / this.g) * this.h)));
    }

    public void b() {
        this.k = false;
        this.j.removeMessages(0);
    }

    public void c() {
        int count;
        boolean z;
        int i;
        ScrollAnimationListener scrollAnimationListener;
        PagerAdapter adapter = getAdapter();
        int currentItem = getCurrentItem();
        if (adapter == null || (count = adapter.getCount()) <= 1) {
            return;
        }
        int i2 = this.b == 0 ? currentItem - 1 : currentItem + 1;
        if (i2 < 0) {
            z = true;
            i = i2;
            if (this.f14381c) {
                i = count - 1;
                z = this.f;
            }
        } else {
            z = true;
            i = i2;
            if (i2 == count) {
                z = true;
                i = i2;
                if (this.f14381c) {
                    i = 0;
                    z = this.f;
                }
            }
        }
        if (this.i && (scrollAnimationListener = this.p) != null && scrollAnimationListener.a(currentItem, i)) {
            a(i);
        } else {
            setCurrentItem(i, z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.d) {
            if (actionMasked == 0 && this.k) {
                this.l = true;
                b();
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.l) {
                a();
            }
        }
        PagerAdapter adapter = getAdapter();
        if (!this.i || adapter == null || adapter.getCount() < 1) {
            int i = this.e;
            if (i == 2 || i == 1) {
                this.m = motionEvent.getX();
                if (motionEvent.getAction() == 0) {
                    this.n = this.m;
                }
                int currentItem = getCurrentItem();
                int count = adapter == null ? 0 : adapter.getCount();
                if ((currentItem == 0 && this.n <= this.m) || (currentItem == count - 1 && this.n >= this.m)) {
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
        } else if (motionEvent.getAction() == 0) {
            this.n = motionEvent.getX();
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        } else if (motionEvent.getAction() == 1) {
            this.m = motionEvent.getX();
            int currentItem2 = getCurrentItem();
            int count2 = adapter.getCount();
            if (Math.abs(this.m - this.n) < DisplayUtil.a(getContext(), 10.0f) || adapter.getCount() == 1) {
                ScrollAnimationListener scrollAnimationListener = this.p;
                if (scrollAnimationListener != null) {
                    scrollAnimationListener.a(currentItem2);
                    return true;
                }
                return true;
            }
            int i2 = this.m > this.n ? currentItem2 - 1 : currentItem2 + 1;
            if (i2 < 0 && this.f14381c) {
                i2 = count2 - 1;
            } else if (i2 == count2 && this.f14381c) {
                i2 = 0;
            }
            ScrollAnimationListener scrollAnimationListener2 = this.p;
            if (scrollAnimationListener2 == null || !scrollAnimationListener2.a(currentItem2, i2)) {
                setCurrentItem(i2, true);
                return true;
            }
            a(i2);
            return true;
        } else {
            return true;
        }
    }

    public int getDirection() {
        return this.b == 0 ? 0 : 1;
    }

    public long getInterval() {
        return this.f14380a;
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
        this.f14381c = z;
    }

    public void setDirection(int i) {
        this.b = i;
    }

    public void setInterval(long j) {
        this.f14380a = j;
    }

    public void setScrollAnimationFlag(boolean z) {
        this.i = z;
    }

    public void setScrollAnimationListener(ScrollAnimationListener scrollAnimationListener) {
        this.p = scrollAnimationListener;
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
