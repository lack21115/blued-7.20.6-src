package com.soft.blued.customview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.video.module.a.a.m;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/AutoSlideViewpager.class */
public class AutoSlideViewpager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14627a;
    private PagerIndicator b;

    /* renamed from: c  reason: collision with root package name */
    private int f14628c;
    private Handler d;
    private Runnable e;
    private Boolean f;
    private Context g;
    private BroadcastReceiver h;

    public AutoSlideViewpager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14627a = false;
        this.f14628c = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.e = new Runnable() { // from class: com.soft.blued.customview.AutoSlideViewpager.1
            @Override // java.lang.Runnable
            public void run() {
                if (AutoSlideViewpager.this.f.booleanValue() && AutoSlideViewpager.this.getAdapter() != null) {
                    int count = AutoSlideViewpager.this.getAdapter().getCount();
                    AutoSlideViewpager.b(AutoSlideViewpager.this);
                    if (AutoSlideViewpager.this.f14628c >= count) {
                        AutoSlideViewpager.this.f14628c = 0;
                    }
                    AutoSlideViewpager autoSlideViewpager = AutoSlideViewpager.this;
                    autoSlideViewpager.setCurrentItem(autoSlideViewpager.f14628c);
                }
            }
        };
        this.f = true;
        this.h = new BroadcastReceiver() { // from class: com.soft.blued.customview.AutoSlideViewpager.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (AutoSlideViewpager.this.f.booleanValue()) {
                    if (intent.getAction().equals("slide_pause_listener")) {
                        AutoSlideViewpager.this.d.removeCallbacks(AutoSlideViewpager.this.e);
                    } else if (intent.getAction().equals("slide_start_listener")) {
                        AutoSlideViewpager.this.a();
                    }
                }
            }
        };
        b();
        this.g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.d.removeCallbacks(this.e);
        this.d.postDelayed(this.e, m.ag);
    }

    static /* synthetic */ int b(AutoSlideViewpager autoSlideViewpager) {
        int i = autoSlideViewpager.f14628c;
        autoSlideViewpager.f14628c = i + 1;
        return i;
    }

    private void b() {
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.customview.AutoSlideViewpager.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                AutoSlidePagerAdapter autoSlidePagerAdapter;
                int i2;
                if (i != 0 || (autoSlidePagerAdapter = (AutoSlidePagerAdapter) AutoSlideViewpager.this.getAdapter()) == null || autoSlidePagerAdapter.a() <= 1) {
                    return;
                }
                int a2 = autoSlidePagerAdapter.a();
                int count = autoSlidePagerAdapter.getCount();
                if (AutoSlideViewpager.this.f14628c < a2) {
                    int i3 = AutoSlideViewpager.this.f14628c + a2;
                    AutoSlideViewpager.this.setCurrentItem(i3, false);
                    AutoSlideViewpager.this.f14628c = i3;
                } else if (AutoSlideViewpager.this.f14628c >= a2 * 2) {
                    if (count < a2 * 3) {
                        i2 = a2 == 0 ? AutoSlideViewpager.this.f14628c : AutoSlideViewpager.this.f14628c % a2;
                    } else {
                        i2 = (a2 == 0 ? AutoSlideViewpager.this.f14628c : AutoSlideViewpager.this.f14628c % a2) + a2;
                    }
                    AutoSlideViewpager.this.setCurrentItem(i2, false);
                    AutoSlideViewpager.this.f14628c = i2;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (AutoSlideViewpager.this.b != null) {
                    AutoSlideViewpager.this.b.setCurrentPage(i);
                }
                AutoSlideViewpager.this.f14628c = i;
                AutoSlidePagerAdapter autoSlidePagerAdapter = (AutoSlidePagerAdapter) AutoSlideViewpager.this.getAdapter();
                if (autoSlidePagerAdapter == null || autoSlidePagerAdapter.getCount() <= 1 || !AutoSlideViewpager.this.f.booleanValue()) {
                    return;
                }
                AutoSlideViewpager.this.a();
            }
        });
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void dataSetChanged() {
        AutoSlidePagerAdapter autoSlidePagerAdapter = (AutoSlidePagerAdapter) getAdapter();
        if (autoSlidePagerAdapter == null || autoSlidePagerAdapter.a() <= 1) {
            this.f14627a = false;
            return;
        }
        this.f14627a = true;
        int a2 = autoSlidePagerAdapter.a();
        this.f14628c = a2;
        setCurrentItem(a2, false);
        if (this.f.booleanValue()) {
            a();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("slide_pause_listener");
        intentFilter.addAction("slide_start_listener");
        try {
            this.g.registerReceiver(this.h, intentFilter);
        } catch (Exception e) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.g.unregisterReceiver(this.h);
        } catch (Exception e) {
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f14627a) {
            if (i != 0) {
                this.d.removeCallbacks(this.e);
            } else if (this.f.booleanValue()) {
                a();
            }
        }
    }

    public void setPagerIndicator(PagerIndicator pagerIndicator) {
        this.b = pagerIndicator;
    }
}
