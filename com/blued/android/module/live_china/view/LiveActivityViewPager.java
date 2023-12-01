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
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActivityViewPager.class */
public class LiveActivityViewPager extends ViewPager {
    private long a;
    private int b;
    private boolean c;
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

    /* renamed from: com.blued.android.module.live_china.view.LiveActivityViewPager$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActivityViewPager$1.class */
    class AnonymousClass1 implements Animation.AnimationListener {
        final /* synthetic */ int a;
        final /* synthetic */ LiveActivityViewPager b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.b.setCurrentItem(this.a, false);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setInterpolator(new LinearInterpolator());
            scaleAnimation.setDuration(150L);
            this.b.startAnimation(scaleAnimation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActivityViewPager$MyHandler.class */
    public static class MyHandler extends Handler {
        private final WeakReference<LiveActivityViewPager> a;

        public MyHandler(LiveActivityViewPager liveActivityViewPager) {
            this.a = new WeakReference<>(liveActivityViewPager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LiveActivityViewPager liveActivityViewPager;
            super.handleMessage(message);
            if (message.what == 0 && (liveActivityViewPager = this.a.get()) != null) {
                liveActivityViewPager.n.a(liveActivityViewPager.g);
                liveActivityViewPager.c();
                liveActivityViewPager.n.a(liveActivityViewPager.h);
                liveActivityViewPager.a(liveActivityViewPager.a + liveActivityViewPager.n.getDuration());
            }
        }
    }

    public LiveActivityViewPager(Context context) {
        super(context);
        this.a = 1500L;
        this.b = 1;
        this.c = true;
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

    public LiveActivityViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1500L;
        this.b = 1;
        this.c = true;
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
        a((long) (this.a + ((this.n.getDuration() / this.g) * this.h)));
    }

    public void b() {
        this.j = false;
        this.i.removeMessages(0);
    }

    public void c() {
        int count;
        int i;
        boolean z;
        PagerAdapter adapter = getAdapter();
        int currentItem = getCurrentItem();
        if (adapter == null || (count = adapter.getCount()) <= 1) {
            return;
        }
        int i2 = this.b == 0 ? currentItem - 1 : currentItem + 1;
        if (i2 < 0) {
            i = i2;
            z = true;
            if (this.c) {
                i = count - 1;
                z = this.f;
            }
        } else {
            i = i2;
            z = true;
            if (i2 == count) {
                i = i2;
                z = true;
                if (this.c) {
                    i = 0;
                    z = this.f;
                }
            }
        }
        setCurrentItem(i, z);
    }

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
        PagerAdapter adapter = getAdapter();
        if (adapter == null || adapter.getCount() < 1) {
            int i = this.e;
            if (i == 2 || i == 1) {
                this.l = motionEvent.getX();
                if (motionEvent.getAction() == 0) {
                    this.m = this.l;
                }
                int currentItem = getCurrentItem();
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
                }
            }
        } else if (motionEvent.getAction() == 0) {
            this.m = motionEvent.getX();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 1) {
            this.l = motionEvent.getX();
            int currentItem2 = getCurrentItem();
            int count2 = adapter.getCount();
            if (Math.abs(this.l - this.m) > DisplayUtil.a(getContext(), 10.0f) && adapter.getCount() > 1) {
                int i2 = this.l > this.m ? currentItem2 - 1 : currentItem2 + 1;
                if (i2 < 0 && this.c) {
                    setCurrentItem(count2 - 1, false);
                    return true;
                } else if (i2 == count2 && this.c) {
                    setCurrentItem(0, false);
                    return true;
                } else {
                    setCurrentItem(i2, true);
                    return true;
                }
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getDirection() {
        return this.b == 0 ? 0 : 1;
    }

    public long getInterval() {
        return this.a;
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
        this.c = z;
    }

    public void setDirection(int i) {
        this.b = i;
    }

    public void setInterval(long j) {
        this.a = j;
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
