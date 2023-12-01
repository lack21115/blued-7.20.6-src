package com.blued.android.module.live_china.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveLuckyBagBinding;
import com.blued.android.module.live_china.fitem.FitemLuckyBagTab;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LuckyBagLuckyComeModel;
import com.blued.android.module.live_china.model.LuckyBagModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLuckyBagDialogFragment.class */
public final class LiveLuckyBagDialogFragment extends BaseDialogFragment implements OnClickCallback {
    public static final Companion a = new Companion(null);
    private List<LuckyBagModel> d;
    private LuckyBagViewPagerAdapter e;
    private FreedomAdapter g;
    private FitemLuckyBagTab h;
    private int i;
    private float j;
    private float k;
    private ValueAnimator m;
    private ObjectAnimator o;
    private ObjectAnimator p;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveLuckyBagBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveLuckyBagDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveLuckyBagBinding invoke() {
            return DialogLiveLuckyBagBinding.a(LayoutInflater.from(LiveLuckyBagDialogFragment.this.getContext()));
        }
    });
    private int c = -1;
    private final ArrayList<FitemLuckyBagTab> f = new ArrayList<>();
    private final DecelerateInterpolator l = new DecelerateInterpolator(1.5f);
    private float n = -1.0f;
    private final Observer<Boolean> q = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$KHIanFDIKFnFMgxKbAvPIm_4eZA
        public final void onChanged(Object obj) {
            LiveLuckyBagDialogFragment.a(LiveLuckyBagDialogFragment.this, (Boolean) obj);
        }
    };
    private final Observer<Integer> r = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$DmiYJEUGkr-tz5cO3EAbvr0VR0s
        public final void onChanged(Object obj) {
            LiveLuckyBagDialogFragment.a(LiveLuckyBagDialogFragment.this, (Integer) obj);
        }
    };

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLuckyBagDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveLuckyBagDialogFragment a(FragmentManager manager, int i) {
            Intrinsics.e(manager, "manager");
            LiveLuckyBagDialogFragment liveLuckyBagDialogFragment = new LiveLuckyBagDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("goods_id", i);
            liveLuckyBagDialogFragment.setArguments(bundle);
            liveLuckyBagDialogFragment.show(manager, LiveLuckyBagDialogFragment.class.getSimpleName());
            return liveLuckyBagDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLuckyBagDialogFragment$LuckyBagViewPagerAdapter.class */
    public static final class LuckyBagViewPagerAdapter extends FragmentPagerAdapter {
        private final Context a;
        private List<LuckyBagModel> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LuckyBagViewPagerAdapter(FragmentManager fm, Context mContext, List<LuckyBagModel> mData) {
            super(fm);
            Intrinsics.e(fm, "fm");
            Intrinsics.e(mContext, "mContext");
            Intrinsics.e(mData, "mData");
            this.a = mContext;
            this.b = mData;
        }

        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
        }

        public int getCount() {
            return this.b.size();
        }

        public Fragment getItem(int i) {
            return new LiveLuckyBagFragment(this.b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        LuckyBagModel luckyBagModel;
        FitemLuckyBagTab fitemLuckyBagTab = this.h;
        if (fitemLuckyBagTab != null) {
            fitemLuckyBagTab.f();
        }
        FitemLuckyBagTab fitemLuckyBagTab2 = this.f.get(i);
        this.h = fitemLuckyBagTab2;
        if (fitemLuckyBagTab2 != null) {
            fitemLuckyBagTab2.e();
        }
        LinearLayoutManager layoutManager = d().m.getLayoutManager();
        if (layoutManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        int g = this.f.get(findFirstVisibleItemPosition).g();
        int i2 = this.i;
        int max = Math.max(0, (this.f.size() * this.i) - d().m.getWidth());
        int i3 = this.i;
        d().m.smoothScrollBy(Math.min(max, (i * i3) - ((int) (i3 * 0.65f))) - ((findFirstVisibleItemPosition * i2) - g), 0, this.l, 500);
        List<LuckyBagModel> list = this.d;
        if (list == null || (luckyBagModel = (LuckyBagModel) CollectionsKt.c((List<? extends Object>) list, i)) == null) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_BLIND_BOX_TAB_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(luckyBagModel.getGoods_id()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveSetDataObserver.a().b(LiveRoomInfo.a().j() ? "https://app.blued.cn/home/blind-box" : "https://app-testenv.blued.cn/home/blind-box", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d().a.setExpanded(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, AccelerateInterpolator scaleInterpolator, float f, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(scaleInterpolator, "$scaleInterpolator");
        Intrinsics.e(animation, "animation");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.n = floatValue;
        float interpolation = (scaleInterpolator.getInterpolation(floatValue) / 2.0f) + 0.5f;
        this$0.d().c.setScaleX(interpolation);
        this$0.d().c.setScaleY(interpolation);
        this$0.d().c.setTranslationY((1 - this$0.l.getInterpolation(floatValue)) * f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, AccelerateInterpolator scaleInterpolator, AppBarLayout appBarLayout, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(scaleInterpolator, "$scaleInterpolator");
        float f = 1;
        float height = f - ((0.0f - i) / this$0.d().e.getHeight());
        float interpolation = (scaleInterpolator.getInterpolation(height) / 3.0f) + 0.6666667f;
        this$0.d().b.setScaleX(interpolation);
        this$0.d().b.setScaleY(interpolation);
        this$0.d().b.setTranslationY((f - this$0.l.getInterpolation(height)) * this$0.d().e.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, LuckyBagModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, model.getGoods_image()).a(this$0.d().j);
        this$0.d().j.setTranslationX(-this$0.d().j.getTranslationX());
        this$0.d().j.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, Boolean isShow) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(isShow, "isShow");
        this$0.a(isShow.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagDialogFragment this$0, Ref.IntRef position) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(position, "$position");
        this$0.a(position.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final List<LuckyBagModel> list) {
        this.d = list;
        Iterator<LuckyBagModel> it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                m();
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.c(childFragmentManager, "childFragmentManager");
                Context requireContext = requireContext();
                Intrinsics.c(requireContext, "requireContext()");
                this.e = new LuckyBagViewPagerAdapter(childFragmentManager, requireContext, list);
                d().s.setAdapter(this.e);
                d().c.setClickable(true);
                d().m.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$oAUEpndMu6mRJ-rIPACXipJTWLk
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveLuckyBagDialogFragment.c(LiveLuckyBagDialogFragment.this, list);
                    }
                });
                return;
            }
            LuckyBagModel next = it.next();
            ArrayList<FitemLuckyBagTab> arrayList = this.f;
            int goods_id = next.getGoods_id();
            String goods_name = next.getGoods_name();
            boolean has_tips = next.getHas_tips();
            if (next.getBreak_even() != null) {
                LuckyBagLuckyComeModel break_even = next.getBreak_even();
                Intrinsics.a(break_even);
                if (break_even.is_enable()) {
                    arrayList.add(new FitemLuckyBagTab(goods_id, goods_name, has_tips, z));
                }
            }
            z = false;
            arrayList.add(new FitemLuckyBagTab(goods_id, goods_name, has_tips, z));
        }
    }

    private final void a(boolean z) {
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.m;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.m = null;
        final AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
        final float a2 = DensityUtils.a(requireContext(), 84.0f);
        float f = this.n;
        float f2 = 1.0f;
        float f3 = f;
        if (f < 0.0f) {
            f3 = z ? 0.0f : 1.0f;
        }
        if (!z) {
            f2 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, f2);
        this.m = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(360L);
        }
        ValueAnimator valueAnimator3 = this.m;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(this.l);
        }
        ValueAnimator valueAnimator4 = this.m;
        if (valueAnimator4 != null) {
            valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$XJz0Yb0RHK37_WawqaxcY6UuOCU
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                    LiveLuckyBagDialogFragment.a(LiveLuckyBagDialogFragment.this, accelerateInterpolator, a2, valueAnimator5);
                }
            });
        }
        ValueAnimator valueAnimator5 = this.m;
        if (valueAnimator5 == null) {
            return;
        }
        valueAnimator5.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        List<LuckyBagModel> list = this.d;
        if ((list == null || list.isEmpty()) || i < 0) {
            return;
        }
        List<LuckyBagModel> list2 = this.d;
        Intrinsics.a(list2);
        if (i >= list2.size()) {
            return;
        }
        List<LuckyBagModel> list3 = this.d;
        Intrinsics.a(list3);
        final LuckyBagModel luckyBagModel = list3.get(i);
        float a2 = DensityUtils.a(requireContext(), 45.0f);
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
        float f = -a2;
        ViewPropertyAnimator startDelay = d().j.animate().alpha(0.0f).translationX(f).setDuration(360L).setStartDelay(0L);
        AccelerateInterpolator accelerateInterpolator2 = accelerateInterpolator;
        startDelay.setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$Xc0khP8Q-55qyObHmPgzVMf2yMw
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.a(LiveLuckyBagDialogFragment.this, luckyBagModel);
            }
        });
        d().r.animate().alpha(0.0f).translationX(f).setDuration(395L).setStartDelay(25L).setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$V37Z4LW771v4Vyz2kT2e1p3VHtU
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.b(LiveLuckyBagDialogFragment.this, luckyBagModel);
            }
        });
        ViewPropertyAnimator translationX = d().n.animate().alpha(0.0f).translationX(f);
        long j = 2;
        translationX.setDuration((j * 35) + 360).setStartDelay(j * 25).setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$ByUW86BL3Uy52wjWtMaJe4GaiLQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.c(LiveLuckyBagDialogFragment.this, luckyBagModel);
            }
        });
        ViewPropertyAnimator translationX2 = d().f.animate().alpha(0.0f).translationX(f);
        long j2 = 3;
        translationX2.setDuration((j2 * 35) + 360).setStartDelay(j2 * 25).setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$4fnX-o5iFl_cuKxxH3PWGc0Dt2o
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.e(LiveLuckyBagDialogFragment.this);
            }
        });
        ViewPropertyAnimator translationX3 = d().o.animate().alpha(0.0f).translationX(f);
        long j3 = 4;
        translationX3.setDuration((35 * j3) + 360).setStartDelay(j3 * 25).setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$heV9cHXMDtUvTKELYTg5By5wOso
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.d(LiveLuckyBagDialogFragment.this, luckyBagModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LiveLuckyBagDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        final List<LuckyBagModel> list = this$0.d;
        if (list == null) {
            return;
        }
        this$0.d().l.b();
        this$0.d().l.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$f3oJsB49CVfqfS9wA9xl6xeO41w
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.b(LiveLuckyBagDialogFragment.this, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveLuckyBagDialogFragment this$0, LuckyBagModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.isDetached() || this$0.getHost() == null || this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        this$0.d().r.setVisibility(model.hasLuckyCome() ? 0 : 8);
        this$0.d().r.setTranslationX(-this$0.d().r.getTranslationX());
        this$0.d().r.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveLuckyBagDialogFragment this$0, List it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        if (this$0.d().s.getCurrentItem() >= it.size()) {
            return;
        }
        int goods_id = ((LuckyBagModel) it.get(this$0.d().s.getCurrentItem())).getGoods_id();
        EventTrackLive.b(LiveProtos.Event.LIVE_BLIND_BOX_TAB_SEND_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(goods_id));
        LiveEventBusUtil.g(goods_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveLuckyBagDialogFragment this$0, Ref.IntRef position) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(position, "$position");
        this$0.b(position.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i) {
        List<LuckyBagModel> list = this.d;
        if ((list == null || list.isEmpty()) || i < 0) {
            return;
        }
        List<LuckyBagModel> list2 = this.d;
        Intrinsics.a(list2);
        if (i >= list2.size()) {
            return;
        }
        List<LuckyBagModel> list3 = this.d;
        Intrinsics.a(list3);
        final LuckyBagModel luckyBagModel = list3.get(i);
        float a2 = DensityUtils.a(requireContext(), 20.0f);
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
        float f = -a2;
        ViewPropertyAnimator startDelay = d().p.animate().alpha(0.0f).translationX(f).setDuration(360L).setStartDelay(0L);
        AccelerateInterpolator accelerateInterpolator2 = accelerateInterpolator;
        startDelay.setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$f10nOuZdSbKOeCyazidgQuYXfmo
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.e(LiveLuckyBagDialogFragment.this, luckyBagModel);
            }
        });
        d().i.animate().alpha(0.0f).translationX(f).setDuration(395L).setStartDelay(25L).setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$aqBVUrG222Lu8LuWF6ZLk6_kU3s
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.f(LiveLuckyBagDialogFragment.this);
            }
        });
        ViewPropertyAnimator translationX = d().q.animate().alpha(0.0f).translationX(f);
        long j = 2;
        translationX.setDuration((35 * j) + 360).setStartDelay(j * 25).setInterpolator(accelerateInterpolator2).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$eopMSt3RSQkzQV9z8pSCp-1OSnI
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.f(LiveLuckyBagDialogFragment.this, luckyBagModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveLuckyBagDialogFragment this$0, LuckyBagModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        this$0.d().n.setText(model.getGoods_name());
        this$0.d().n.setTranslationX(-this$0.d().n.getTranslationX());
        this$0.d().n.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final LiveLuckyBagDialogFragment this$0, List data) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        final Ref.IntRef intRef = new Ref.IntRef();
        if (this$0.c > 0) {
            int i = 0;
            int size = data.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this$0.c == ((LuckyBagModel) data.get(i)).getGoods_id()) {
                    intRef.a = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        if (intRef.a > 0) {
            this$0.d().s.setCurrentItem(intRef.a);
            return;
        }
        this$0.d().m.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$NAUdZp5hvE4fld5hSrrYM0sWw9E
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.a(LiveLuckyBagDialogFragment.this, intRef);
            }
        });
        this$0.d().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$-XG3ND80f0q2_xyHffyAKg9J7Fo
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.b(LiveLuckyBagDialogFragment.this, intRef);
            }
        });
        this$0.d().c.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$4jxdL3hRbTyh64RNYQI43bF-LYo
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.c(LiveLuckyBagDialogFragment.this, intRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveLuckyBagDialogFragment this$0, Ref.IntRef position) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(position, "$position");
        this$0.c(position.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveLuckyBagBinding d() {
        return (DialogLiveLuckyBagBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveLuckyBagDialogFragment this$0, LuckyBagModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        TextView textView = this$0.d().o;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Long.valueOf(model.getGoods_beans())}, 1));
        Intrinsics.c(format, "format(this, *args)");
        textView.setText(format);
        this$0.d().o.setTranslationX(-this$0.d().o.getTranslationX());
        this$0.d().o.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    private final void e() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get(LiveEventBusUtil.T, Boolean.TYPE).observe(lifecycleOwner, this.q);
        LiveEventBus.get(LiveEventBusUtil.W, Integer.TYPE).observe(lifecycleOwner, this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveLuckyBagDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        this$0.d().f.setTranslationX(-this$0.d().f.getTranslationX());
        this$0.d().f.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveLuckyBagDialogFragment this$0, LuckyBagModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        this$0.d().p.setText(model.getGoods_name());
        this$0.d().p.setTranslationX(-this$0.d().p.getTranslationX());
        this$0.d().p.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    private final void f() {
        LiveEventBus.get(LiveEventBusUtil.T, Boolean.TYPE).removeObserver(this.q);
        LiveEventBus.get(LiveEventBusUtil.W, Integer.TYPE).removeObserver(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveLuckyBagDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        this$0.d().i.setTranslationX(-this$0.d().i.getTranslationX());
        this$0.d().i.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveLuckyBagDialogFragment this$0, LuckyBagModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.isDetached() || this$0.getHost() == null) {
            return;
        }
        TextView textView = this$0.d().q;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Long.valueOf(model.getGoods_beans())}, 1));
        Intrinsics.c(format, "format(this, *args)");
        textView.setText(format);
        this$0.d().q.setTranslationX(-this$0.d().q.getTranslationX());
        this$0.d().q.animate().alpha(1.0f).translationX(0.0f).setInterpolator(this$0.l).start();
    }

    private final void g() {
        d().r.getPaint().setFakeBoldText(true);
        d().p.getPaint().setFakeBoldText(true);
        this.i = DensityUtils.a(getContext(), 100.0f);
        d().c.setClickable(false);
        h();
        i();
        j();
        d().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$TxIRDLjOGdCaHgfbG3g2JB6nku0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveLuckyBagDialogFragment.a(LiveLuckyBagDialogFragment.this, view);
            }
        });
        o();
        d().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$hU3WXvgs11NBhhiix2o-T7Y6H-k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveLuckyBagDialogFragment.b(LiveLuckyBagDialogFragment.this, view);
            }
        });
        d().k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$v73m2RQ6jNzRQr_Tdn3uiwSU8Xk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveLuckyBagDialogFragment.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LiveLuckyBagDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.d().d, "scaleX", 1.0f, 1.05f);
        this$0.o = ofFloat;
        if (ofFloat != null) {
            ofFloat.setRepeatCount(-1);
        }
        ObjectAnimator objectAnimator = this$0.o;
        if (objectAnimator != null) {
            objectAnimator.setRepeatMode(2);
        }
        ObjectAnimator objectAnimator2 = this$0.o;
        if (objectAnimator2 != null) {
            objectAnimator2.setDuration(1080L);
        }
        ObjectAnimator objectAnimator3 = this$0.o;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.d().d, "scaleY", 1.0f, 1.05f);
        this$0.p = ofFloat2;
        if (ofFloat2 != null) {
            ofFloat2.setRepeatCount(-1);
        }
        ObjectAnimator objectAnimator4 = this$0.p;
        if (objectAnimator4 != null) {
            objectAnimator4.setRepeatMode(2);
        }
        ObjectAnimator objectAnimator5 = this$0.p;
        if (objectAnimator5 != null) {
            objectAnimator5.setDuration(1080L);
        }
        ObjectAnimator objectAnimator6 = this$0.p;
        if (objectAnimator6 == null) {
            return;
        }
        objectAnimator6.start();
    }

    private final void h() {
        final AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
        d().a.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$Kyhu4-U3bxtxHiGAkYuNlflaN_A
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                LiveLuckyBagDialogFragment.a(LiveLuckyBagDialogFragment.this, accelerateInterpolator, appBarLayout, i);
            }
        });
    }

    private final void i() {
        d().s.addOnPageChangeListener(new LiveLuckyBagDialogFragment$initViewPagerListener$1(this));
    }

    private final void j() {
        RecyclerView recyclerView;
        DialogLiveLuckyBagBinding d = d();
        if (d == null || (recyclerView = d.m) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.fragment.LiveLuckyBagDialogFragment$initRecyclerScrollListener$1
            public void onScrolled(RecyclerView recycler, int i, int i2) {
                float f;
                Intrinsics.e(recycler, "recycler");
                super.onScrolled(recycler, i, i2);
                LiveLuckyBagDialogFragment liveLuckyBagDialogFragment = LiveLuckyBagDialogFragment.this;
                f = liveLuckyBagDialogFragment.j;
                liveLuckyBagDialogFragment.j = f - i;
                LiveLuckyBagDialogFragment.this.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        d().g.setTranslationX(this.j + this.k);
    }

    private final void l() {
        d().l.b();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.K(new BluedUIHttpResponse<BluedEntity<LuckyBagModel, ?>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveLuckyBagDialogFragment$getData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogLiveLuckyBagBinding d;
                super.onUIFinish();
                d = LiveLuckyBagDialogFragment.this.d();
                d.l.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LuckyBagModel, ?> entity) {
                Intrinsics.e(entity, "entity");
                List<LuckyBagModel> list = entity.data;
                if (list == null || list.isEmpty()) {
                    return;
                }
                LiveLuckyBagDialogFragment liveLuckyBagDialogFragment = LiveLuckyBagDialogFragment.this;
                List<LuckyBagModel> list2 = entity.data;
                Intrinsics.c(list2, "entity.data");
                liveLuckyBagDialogFragment.a(list2);
            }
        }, a());
    }

    private final void m() {
        FreedomAdapter freedomAdapter = this.g;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.g = new FreedomAdapter(getContext(), a(), this.f, this);
        DialogLiveLuckyBagBinding d = d();
        RecyclerView recyclerView = d == null ? null : d.m;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        DialogLiveLuckyBagBinding d2 = d();
        RecyclerView recyclerView2 = d2 == null ? null : d2.m;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        DialogLiveLuckyBagBinding d3 = d();
        RecyclerView recyclerView3 = d3 == null ? null : d3.m;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.g);
    }

    private final void n() {
        ObjectAnimator objectAnimator = this.o;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.o;
        if (objectAnimator2 != null) {
            objectAnimator2.clone();
        }
        this.o = null;
        ObjectAnimator objectAnimator3 = this.p;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ObjectAnimator objectAnimator4 = this.p;
        if (objectAnimator4 != null) {
            objectAnimator4.clone();
        }
        this.p = null;
    }

    private final void o() {
        d().d.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagDialogFragment$OF5-BAjg-866c-sqaCYw3sEKx_M
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagDialogFragment.g(LiveLuckyBagDialogFragment.this);
            }
        });
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        d().s.setCurrentItem(i);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 579.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        f();
        n();
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        dismissAllowingStateLoss();
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.c = arguments.getInt("goods_id", -1);
        }
        e();
        g();
        l();
    }
}
