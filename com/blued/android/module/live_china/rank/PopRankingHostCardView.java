package com.blued.android.module.live_china.rank;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.PopWindowRankingHostCardBinding;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.rank.LiveRankTipsDialogFragment;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/PopRankingHostCardView.class */
public final class PopRankingHostCardView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14078a = new Companion(null);
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final AttributeSet f14079c;
    private final int d;
    private FragmentManager e;
    private IRequestHost f;
    private HashMap<String, String> g;
    private final HashMap<Integer, LiveProtos.Status> h;
    private int i;
    private LiveProtos.Event j;
    private final Observer<Pair<?, ?>> k;
    private int l;
    private HourPagerAdapter m;
    private TextView n;
    private String o;
    private final Lazy p;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/PopRankingHostCardView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/PopRankingHostCardView$HourPagerAdapter.class */
    public static final class HourPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f14080a;
        private final IRequestHost b;

        /* renamed from: c  reason: collision with root package name */
        private String f14081c;
        private int d;
        private final Map<String, View> e;

        public HourPagerAdapter(Context mContext, IRequestHost requestHost, String str, int i) {
            Intrinsics.e(mContext, "mContext");
            Intrinsics.e(requestHost, "requestHost");
            this.f14080a = mContext;
            this.b = requestHost;
            this.f14081c = str;
            this.d = i;
            this.e = new HashMap();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            container.removeView((View) object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.d;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            View view = this.e.get(String.valueOf(i));
            PopRankingHostTopView popRankingHostTopView = view;
            if (view == null) {
                popRankingHostTopView = new PopRankingHostTopView(this.f14080a, i, this.b, this.f14081c);
                this.e.put(String.valueOf(i), popRankingHostTopView);
            }
            if (popRankingHostTopView.getParent() != null) {
                ViewParent parent = popRankingHostTopView.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(popRankingHostTopView);
            }
            container.addView(popRankingHostTopView);
            return popRankingHostTopView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.e(view, "view");
            Intrinsics.e(object, "object");
            return view == object;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopRankingHostCardView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopRankingHostCardView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopRankingHostCardView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.b = mContext;
        this.f14079c = attributeSet;
        this.d = i;
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.j = LiveProtos.Event.LIVE_SHOW_PAGE_LIVER_PAGE_SHOW;
        this.k = new Observer() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingHostCardView$Y8SroDljm9geek5fFUhj_c7EM3s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PopRankingHostCardView.a(PopRankingHostCardView.this, (Pair) obj);
            }
        };
        this.l = 3;
        this.p = LazyKt.a(new Function0<PopWindowRankingHostCardBinding>() { // from class: com.blued.android.module.live_china.rank.PopRankingHostCardView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final PopWindowRankingHostCardBinding invoke() {
                PopWindowRankingHostCardBinding a2 = PopWindowRankingHostCardBinding.a(LayoutInflater.from(PopRankingHostCardView.this.getMContext()).inflate(R.layout.pop_window_ranking_host_card, PopRankingHostCardView.this));
                Intrinsics.c(a2, "bind(\n            Layout…ost_card, this)\n        )");
                return a2;
            }
        });
    }

    public /* synthetic */ PopRankingHostCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopRankingHostCardView this$0, Pair pair) {
        Intrinsics.e(this$0, "this$0");
        HashMap<String, String> hashMap = this$0.g;
        F f = pair.first;
        if (f == 0) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) f;
        S s = pair.second;
        if (s == 0) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        hashMap.put(str, (String) s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopRankingHostCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12492c.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopRankingHostCardView this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        CustomViewPager customViewPager = this$0.getVb().f12492c;
        int i2 = i;
        if (i >= this$0.l) {
            i2 = 0;
        }
        customViewPager.setCurrentItem(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopRankingHostCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12492c.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopRankingHostCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12492c.setCurrentItem(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PopRankingHostCardView this$0, View view) {
        String str;
        Intrinsics.e(this$0, "this$0");
        if (this$0.e == null || (str = this$0.g.get(this$0.o)) == null) {
            return;
        }
        LiveRankTipsDialogFragment.Companion companion = LiveRankTipsDialogFragment.f14073a;
        FragmentManager fragmentManager = this$0.e;
        Intrinsics.a(fragmentManager);
        companion.a(fragmentManager, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopWindowRankingHostCardBinding getVb() {
        return (PopWindowRankingHostCardBinding) this.p.getValue();
    }

    public final void a(IRequestHost requestHost, FragmentManager fragmentManager, String str, final int i) {
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(fragmentManager, "fragmentManager");
        this.e = fragmentManager;
        this.f = requestHost;
        this.o = str;
        this.h.put(0, LiveProtos.Status.DAILY);
        this.h.put(1, LiveProtos.Status.WEEKLY);
        this.h.put(2, LiveProtos.Status.MONTHLY);
        ShapeModel shapeModel = getVb().g.getShapeModel();
        shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_tran30_FFFFFF);
        shapeModel.n = ContextCompat.getColor(getContext(), R.color.syc_tran50_FFFFFF);
        shapeModel.q = DensityUtils.a(getContext(), 0.5f);
        shapeModel.l = shapeModel.k;
        getVb().g.setShapeModel(shapeModel);
        final int color = ContextCompat.getColor(getContext(), R.color.white);
        final int color2 = ContextCompat.getColor(getContext(), R.color.syc_tran70_FFFFFF);
        ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1689735382_35637.webp").a(getVb().b);
        this.n = getVb().f;
        getVb().f.setTextColor(color);
        getVb().f.getPaint().setFakeBoldText(true);
        this.m = new HourPagerAdapter(this.b, requestHost, str, this.l);
        getVb().f12492c.setAdapter(this.m);
        getVb().f12492c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.rank.PopRankingHostCardView$setInfo$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                TextView textView;
                String str2;
                HashMap hashMap;
                HashMap hashMap2;
                PopWindowRankingHostCardBinding vb;
                TextView textView2;
                PopWindowRankingHostCardBinding vb2;
                PopWindowRankingHostCardBinding vb3;
                PopWindowRankingHostCardBinding vb4;
                HashMap hashMap3;
                HashMap hashMap4;
                textView = PopRankingHostCardView.this.n;
                if (textView != null) {
                    ObjectAnimator.ofArgb(textView, "TextColor", color, color2).setDuration(200L).start();
                    textView.getPaint().setFakeBoldText(false);
                }
                str2 = PopRankingHostCardView.this.o;
                if (Intrinsics.a((Object) str2, (Object) "anchor")) {
                    LiveProtos.Event event = LiveProtos.Event.LIVE_SHOW_PAGE_LIVER_PAGE_SHOW;
                    hashMap3 = PopRankingHostCardView.this.h;
                    EventTrackLive.a(event, (LiveProtos.Status) hashMap3.get(Integer.valueOf(i2)));
                    PopRankingHostCardView.this.j = LiveProtos.Event.LIVE_SHOW_PAGE_LIVER_PAGE_SHOW;
                    PopRankingHostCardView.this.i = i2;
                    hashMap4 = PopRankingHostCardView.this.h;
                    LiveEventBusUtil.a("anchor", (LiveProtos.Status) hashMap4.get(Integer.valueOf(i2)));
                } else {
                    LiveProtos.Event event2 = LiveProtos.Event.LIVE_SHOW_PAGE_USER_PAGE_SHOW;
                    hashMap = PopRankingHostCardView.this.h;
                    EventTrackLive.a(event2, (LiveProtos.Status) hashMap.get(Integer.valueOf(i2)));
                    PopRankingHostCardView.this.j = LiveProtos.Event.LIVE_SHOW_PAGE_USER_PAGE_SHOW;
                    PopRankingHostCardView.this.i = i2;
                    hashMap2 = PopRankingHostCardView.this.h;
                    LiveEventBusUtil.a("fans", (LiveProtos.Status) hashMap2.get(Integer.valueOf(i2)));
                }
                if (i2 == 0) {
                    vb = PopRankingHostCardView.this.getVb();
                    textView2 = vb.f;
                } else if (i2 == 1) {
                    vb3 = PopRankingHostCardView.this.getVb();
                    textView2 = vb3.d;
                } else if (i2 != 2) {
                    textView2 = null;
                } else {
                    vb4 = PopRankingHostCardView.this.getVb();
                    textView2 = vb4.e;
                }
                if (textView2 != null) {
                    int i3 = color2;
                    int i4 = color;
                    PopRankingHostCardView popRankingHostCardView = PopRankingHostCardView.this;
                    ObjectAnimator.ofArgb(textView2, "TextColor", i3, i4).setDuration(200L).start();
                    textView2.getPaint().setFakeBoldText(true);
                    popRankingHostCardView.n = textView2;
                }
                vb2 = PopRankingHostCardView.this.getVb();
                vb2.g.animate().translationX(i2 * DensityUtils.a(PopRankingHostCardView.this.getContext(), 62.0f)).setDuration(500L).setInterpolator(new OvershootInterpolator()).start();
            }
        });
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingHostCardView$4xzvF6Ko2UC8aWHj9ZXVn-7lsDM
            @Override // java.lang.Runnable
            public final void run() {
                PopRankingHostCardView.b(PopRankingHostCardView.this, i);
            }
        }, 200L);
        getVb().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingHostCardView$lYY6uqqT2GwLnMEcqQWpUZ-tRew
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHostCardView.a(PopRankingHostCardView.this, view);
            }
        });
        getVb().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingHostCardView$e2wNRIy-5f6RFWkytsKGHDd5Oss
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHostCardView.b(PopRankingHostCardView.this, view);
            }
        });
        getVb().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingHostCardView$IM1MhaUl0tPtTxEv2jewTctgYYY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHostCardView.c(PopRankingHostCardView.this, view);
            }
        });
        getVb().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingHostCardView$BfnKq9eOUD2wAMy7fVkeEA_mJzQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHostCardView.d(PopRankingHostCardView.this, view);
            }
        });
    }

    public final AttributeSet getAttrs() {
        return this.f14079c;
    }

    public final int getDefStyleAttr() {
        return this.d;
    }

    public final Context getMContext() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LiveEventBus.get(LiveEventBusUtil.ab, Pair.class).observeForever(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LiveEventBus.get(LiveEventBusUtil.ab, Pair.class).removeObserver(this.k);
    }
}
