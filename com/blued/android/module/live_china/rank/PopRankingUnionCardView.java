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
import com.blued.android.module.live_china.databinding.PopWindowRankingUnionCardBinding;
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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/PopRankingUnionCardView.class */
public final class PopRankingUnionCardView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14091a = new Companion(null);
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final AttributeSet f14092c;
    private final int d;
    private FragmentManager e;
    private IRequestHost f;
    private int g;
    private HourPagerAdapter h;
    private TextView i;
    private String j;
    private HashMap<String, String> k;
    private final Lazy l;
    private final Observer<Pair<?, ?>> m;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/PopRankingUnionCardView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/PopRankingUnionCardView$HourPagerAdapter.class */
    public static final class HourPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f14093a;
        private final IRequestHost b;

        /* renamed from: c  reason: collision with root package name */
        private String f14094c;
        private int d;
        private final Map<String, View> e;

        public HourPagerAdapter(Context mContext, IRequestHost requestHost, String str, int i) {
            Intrinsics.e(mContext, "mContext");
            Intrinsics.e(requestHost, "requestHost");
            this.f14093a = mContext;
            this.b = requestHost;
            this.f14094c = str;
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
                popRankingHostTopView = new PopRankingHostTopView(this.f14093a, i, this.b, this.f14094c);
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
    public PopRankingUnionCardView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopRankingUnionCardView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopRankingUnionCardView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.b = mContext;
        this.f14092c = attributeSet;
        this.d = i;
        this.g = 2;
        this.k = new HashMap<>();
        this.l = LazyKt.a(new Function0<PopWindowRankingUnionCardBinding>() { // from class: com.blued.android.module.live_china.rank.PopRankingUnionCardView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final PopWindowRankingUnionCardBinding invoke() {
                PopWindowRankingUnionCardBinding a2 = PopWindowRankingUnionCardBinding.a(LayoutInflater.from(PopRankingUnionCardView.this.getMContext()).inflate(R.layout.pop_window_ranking_union_card, PopRankingUnionCardView.this));
                Intrinsics.c(a2, "bind(\n            Layout…ion_card, this)\n        )");
                return a2;
            }
        });
        this.m = new Observer() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingUnionCardView$c1EN-YLcLIPxNJTv4AG08RPZgYU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PopRankingUnionCardView.a(PopRankingUnionCardView.this, (Pair) obj);
            }
        };
    }

    public /* synthetic */ PopRankingUnionCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopRankingUnionCardView this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        CustomViewPager customViewPager = this$0.getVb().f12505c;
        int i2 = i;
        if (i >= this$0.g) {
            i2 = 0;
        }
        customViewPager.setCurrentItem(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopRankingUnionCardView this$0, Pair pair) {
        Intrinsics.e(this$0, "this$0");
        HashMap<String, String> hashMap = this$0.k;
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
    public static final void a(PopRankingUnionCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12505c.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopRankingUnionCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12505c.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopRankingUnionCardView this$0, View view) {
        String str;
        Intrinsics.e(this$0, "this$0");
        if (this$0.e == null || (str = this$0.k.get(this$0.j)) == null) {
            return;
        }
        LiveRankTipsDialogFragment.Companion companion = LiveRankTipsDialogFragment.f14073a;
        FragmentManager fragmentManager = this$0.e;
        Intrinsics.a(fragmentManager);
        companion.a(fragmentManager, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopWindowRankingUnionCardBinding getVb() {
        return (PopWindowRankingUnionCardBinding) this.l.getValue();
    }

    public final void a(IRequestHost requestHost, FragmentManager fragmentManager, String str, final int i) {
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(fragmentManager, "fragmentManager");
        this.f = requestHost;
        this.j = str;
        this.e = fragmentManager;
        ShapeModel shapeModel = getVb().f.getShapeModel();
        shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_tran30_FFFFFF);
        shapeModel.n = ContextCompat.getColor(getContext(), R.color.syc_tran50_FFFFFF);
        shapeModel.q = DensityUtils.a(getContext(), 0.5f);
        shapeModel.l = shapeModel.k;
        getVb().f.setShapeModel(shapeModel);
        final int color = ContextCompat.getColor(getContext(), R.color.white);
        final int color2 = ContextCompat.getColor(getContext(), R.color.syc_tran70_FFFFFF);
        ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1689735382_35637.webp").a(getVb().b);
        this.i = getVb().e;
        getVb().e.setTextColor(color);
        getVb().e.getPaint().setFakeBoldText(true);
        this.h = new HourPagerAdapter(this.b, requestHost, str, this.g);
        getVb().f12505c.setAdapter(this.h);
        getVb().f12505c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.rank.PopRankingUnionCardView$setInfo$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                TextView textView;
                PopWindowRankingUnionCardBinding vb;
                TextView textView2;
                PopWindowRankingUnionCardBinding vb2;
                PopWindowRankingUnionCardBinding vb3;
                textView = PopRankingUnionCardView.this.i;
                if (textView != null) {
                    ObjectAnimator.ofArgb(textView, "TextColor", color, color2).setDuration(200L).start();
                    textView.getPaint().setFakeBoldText(false);
                }
                if (i2 == 0) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_SHOW_PAGE_GUILD_PAGE_SHOW);
                } else {
                    EventTrackLive.a(LiveProtos.Event.LIVE_SHOW_PAGE_GUILD_LADDER_SHOW);
                }
                LiveEventBusUtil.a("union", LiveProtos.Status.WEEKLY);
                if (i2 == 0) {
                    vb = PopRankingUnionCardView.this.getVb();
                    textView2 = vb.e;
                } else if (i2 != 1) {
                    textView2 = null;
                } else {
                    vb3 = PopRankingUnionCardView.this.getVb();
                    textView2 = vb3.d;
                }
                if (textView2 != null) {
                    int i3 = color2;
                    int i4 = color;
                    PopRankingUnionCardView popRankingUnionCardView = PopRankingUnionCardView.this;
                    ObjectAnimator.ofArgb(textView2, "TextColor", i3, i4).setDuration(200L).start();
                    textView2.getPaint().setFakeBoldText(true);
                    popRankingUnionCardView.i = textView2;
                }
                vb2 = PopRankingUnionCardView.this.getVb();
                vb2.f.animate().translationX(i2 * DensityUtils.a(PopRankingUnionCardView.this.getContext(), 93.0f)).setDuration(500L).setInterpolator(new OvershootInterpolator()).start();
            }
        });
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingUnionCardView$9gxrS4rnoZEQhkWr0EK2OVhhGmQ
            @Override // java.lang.Runnable
            public final void run() {
                PopRankingUnionCardView.a(PopRankingUnionCardView.this, i);
            }
        }, 200L);
        getVb().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingUnionCardView$R_KdCcqML0OWDByOZgXGwZ8hsfk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingUnionCardView.a(PopRankingUnionCardView.this, view);
            }
        });
        getVb().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingUnionCardView$xrz_wm05KA5sejvoJG24tY-x8Fs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingUnionCardView.b(PopRankingUnionCardView.this, view);
            }
        });
        getVb().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingUnionCardView$eQyKb_Rro4lv8Qip7Jw616J_waE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingUnionCardView.c(PopRankingUnionCardView.this, view);
            }
        });
    }

    public final AttributeSet getAttrs() {
        return this.f14092c;
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
        LiveEventBus.get(LiveEventBusUtil.ab, Pair.class).observeForever(this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LiveEventBus.get(LiveEventBusUtil.ab, Pair.class).removeObserver(this.m);
    }
}
