package com.blued.android.module.live_china.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.live_china.databinding.DialogLiveLuckyBagBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLuckyBagDialogFragment$initViewPagerListener$1.class */
public final class LiveLuckyBagDialogFragment$initViewPagerListener$1 implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveLuckyBagDialogFragment f13013a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveLuckyBagDialogFragment$initViewPagerListener$1(LiveLuckyBagDialogFragment liveLuckyBagDialogFragment) {
        this.f13013a = liveLuckyBagDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveLuckyBagDialogFragment this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveLuckyBagDialogFragment this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.c(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        int i3;
        int i4;
        LiveLuckyBagDialogFragment liveLuckyBagDialogFragment = this.f13013a;
        i3 = liveLuckyBagDialogFragment.i;
        i4 = this.f13013a.i;
        liveLuckyBagDialogFragment.k = (i3 * i) + (i4 * f);
        this.f13013a.k();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(final int i) {
        DialogLiveLuckyBagBinding d;
        DialogLiveLuckyBagBinding d2;
        DialogLiveLuckyBagBinding d3;
        d = this.f13013a.d();
        RecyclerView recyclerView = d.m;
        final LiveLuckyBagDialogFragment liveLuckyBagDialogFragment = this.f13013a;
        recyclerView.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$initViewPagerListener$1$HkEimHSxk_PqFvV3B5WouejK5I8
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment$initViewPagerListener$1.a(LiveLuckyBagDialogFragment.this, i);
            }
        });
        d2 = this.f13013a.d();
        ConstraintLayout constraintLayout = d2.b;
        final LiveLuckyBagDialogFragment liveLuckyBagDialogFragment2 = this.f13013a;
        constraintLayout.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$initViewPagerListener$1$JmwtBEWWrWGhtHsD-KuwsLJD2Tw
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment$initViewPagerListener$1.b(LiveLuckyBagDialogFragment.this, i);
            }
        });
        d3 = this.f13013a.d();
        ConstraintLayout constraintLayout2 = d3.f11780c;
        final LiveLuckyBagDialogFragment liveLuckyBagDialogFragment3 = this.f13013a;
        constraintLayout2.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$initViewPagerListener$1$tbfmXHXBy3bTaf2WsD7fxEiNsuY
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment$initViewPagerListener$1.c(LiveLuckyBagDialogFragment.this, i);
            }
        });
    }
}
