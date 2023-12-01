package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.PopWindowRankingHourCardBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingHourCardView.class */
public final class PopRankingHourCardView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f15126a = new Companion(null);
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final AttributeSet f15127c;
    private final int d;
    private BaseFragment e;
    private IRequestHost f;
    private boolean g;
    private int h;
    private HourPagerAdapter i;
    private TextView j;
    private final Lazy k;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingHourCardView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingHourCardView$HourPagerAdapter.class */
    public static final class HourPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15128a;
        private final BaseFragment b;

        /* renamed from: c  reason: collision with root package name */
        private final IRequestHost f15129c;
        private boolean d;
        private int e;
        private final Map<String, View> f;

        public HourPagerAdapter(Context mContext, BaseFragment fragment, IRequestHost requestHost, boolean z, int i) {
            Intrinsics.e(mContext, "mContext");
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(requestHost, "requestHost");
            this.f15128a = mContext;
            this.b = fragment;
            this.f15129c = requestHost;
            this.d = z;
            this.e = i;
            this.f = new HashMap();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            container.removeView((View) object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.e;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            View view = this.f.get(String.valueOf(i));
            PopRankingHourPreviousView popRankingHourPreviousView = view;
            if (view == null) {
                popRankingHourPreviousView = i != 0 ? i != 1 ? i != 2 ? new PopRankingHourPreviousView(this.f15128a, this.b, this.f15129c) : new PopRankingHourPreviousView(this.f15128a, this.b, this.f15129c) : new PopRankingHourTopPotentialRoadView(this.f15128a, this.b, this.f15129c, 2, this.d) : new PopRankingHourTopPotentialRoadView(this.f15128a, this.b, this.f15129c, 1, this.d);
                this.f.put(String.valueOf(i), popRankingHourPreviousView);
            }
            if (popRankingHourPreviousView.getParent() != null) {
                ViewParent parent = popRankingHourPreviousView.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(popRankingHourPreviousView);
            }
            container.addView(popRankingHourPreviousView);
            return popRankingHourPreviousView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.e(view, "view");
            Intrinsics.e(object, "object");
            return view == object;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopRankingHourCardView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopRankingHourCardView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopRankingHourCardView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.b = mContext;
        this.f15127c = attributeSet;
        this.d = i;
        this.g = true;
        this.h = 3;
        this.k = LazyKt.a(new Function0<PopWindowRankingHourCardBinding>() { // from class: com.blued.android.module.live_china.view.PopRankingHourCardView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final PopWindowRankingHourCardBinding invoke() {
                PopWindowRankingHourCardBinding a2 = PopWindowRankingHourCardBinding.a(LayoutInflater.from(PopRankingHourCardView.this.getMContext()).inflate(R.layout.pop_window_ranking_hour_card, PopRankingHourCardView.this));
                Intrinsics.c(a2, "bind(\n            Layout…our_card, this)\n        )");
                return a2;
            }
        });
    }

    public /* synthetic */ PopRankingHourCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopRankingHourCardView this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        CustomViewPager customViewPager = this$0.getVb().f12495c;
        int i2 = i;
        if (i >= this$0.h) {
            i2 = 0;
        }
        customViewPager.setCurrentItem(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopRankingHourCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12495c.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.blued.android.module.live_china.view.PopRankingHourCardView, T] */
    public static final void a(PopRankingHourCardView this$0, BaseFragment fragment, IRequestHost requestHost, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(fragment, "$fragment");
        Intrinsics.e(requestHost, "$requestHost");
        EventTrackLive.a(LiveProtos.Event.LIVE_HOUR_LIST_LAST_HOUR_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = new PopRankingHourCardView(this$0.b, null, 0, 6, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int a2 = DensityUtils.a(this$0.getContext(), 5.0f);
        layoutParams.leftMargin = a2;
        layoutParams.rightMargin = a2;
        ((PopRankingHourCardView) objectRef.f42545a).setLayoutParams(layoutParams);
        ((PopRankingHourCardView) objectRef.f42545a).setTranslationX(this$0.getWidth());
        ViewParent parent = this$0.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup) parent).addView((View) objectRef.f42545a);
        ((PopRankingHourCardView) objectRef.f42545a).a(fragment, requestHost, false, this$0.getVb().f12495c.getCurrentItem());
        ((PopRankingHourCardView) objectRef.f42545a).post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourCardView$uS0NtgFqfrQAtk8TP1yeLqWK-KQ
            @Override // java.lang.Runnable
            public final void run() {
                PopRankingHourCardView.m4268setInfo$lambda5$lambda4(Ref.ObjectRef.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final PopRankingHourCardView this$0, final Ref.ObjectRef view, View view2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(view, "$view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0, "translationX", this$0.getTranslationX(), this$0.getWidth() + DensityUtils.a(this$0.getContext(), 5.0f));
        ofFloat.setDuration(700L);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.3f));
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.PopRankingHourCardView$setInfo$7$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewParent parent = PopRankingHourCardView.this.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(view.f42545a);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopRankingHourCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12495c.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopRankingHourCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().f12495c.setCurrentItem(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopWindowRankingHourCardBinding getVb() {
        return (PopWindowRankingHourCardBinding) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setInfo$lambda-5$lambda-4  reason: not valid java name */
    public static final void m4268setInfo$lambda5$lambda4(Ref.ObjectRef previous) {
        Intrinsics.e(previous, "$previous");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(previous.f42545a, "translationX", ((PopRankingHourCardView) previous.f42545a).getTranslationX(), 0.0f);
        ofFloat.setDuration(700L);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.5f));
        ofFloat.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final BaseFragment fragment, final IRequestHost requestHost, boolean z, final int i) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(requestHost, "requestHost");
        this.e = fragment;
        this.f = requestHost;
        this.g = z;
        if (!z) {
            getVb().b.setVisibility(0);
            int color = ContextCompat.getColor(getContext(), R.color.syc_dark_777777);
            getVb().h.setTextColor(color);
            getVb().f.setTextColor(color);
            getVb().g.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = getVb().f12494a.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(14, -1);
            getVb().f12494a.setLayoutParams(layoutParams2);
            getVb().d.setVisibility(8);
            this.h = 2;
        }
        ShapeModel shapeModel = getVb().i.getShapeModel();
        shapeModel.k = ContextCompat.getColor(getContext(), z ? R.color.syc_dark_h : R.color.white);
        shapeModel.l = shapeModel.k;
        getVb().i.setShapeModel(shapeModel);
        final int color2 = ContextCompat.getColor(getContext(), z ? R.color.syc_dark_b : R.color.syc_dark_h);
        final int color3 = ContextCompat.getColor(getContext(), z ? R.color.syc_dark_0a0a0a : R.color.syc_dark_777777);
        this.j = getVb().h;
        getVb().h.setTextColor(color2);
        getVb().h.getPaint().setFakeBoldText(true);
        this.i = new HourPagerAdapter(this.b, fragment, requestHost, z, this.h);
        getVb().f12495c.setAdapter(this.i);
        getVb().f12495c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.view.PopRankingHourCardView$setInfo$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                TextView textView;
                PopWindowRankingHourCardBinding vb;
                TextView textView2;
                PopWindowRankingHourCardBinding vb2;
                PopWindowRankingHourCardBinding vb3;
                PopWindowRankingHourCardBinding vb4;
                PopWindowRankingHourCardBinding vb5;
                PopWindowRankingHourCardBinding vb6;
                PopWindowRankingHourCardBinding vb7;
                PopWindowRankingHourCardBinding vb8;
                PopWindowRankingHourCardBinding vb9;
                PopWindowRankingHourCardBinding vb10;
                textView = PopRankingHourCardView.this.j;
                if (textView != null) {
                    ObjectAnimator.ofArgb(textView, "TextColor", color2, color3).setDuration(200L).start();
                    textView.getPaint().setFakeBoldText(false);
                }
                if (i2 == 0) {
                    vb = PopRankingHourCardView.this.getVb();
                    textView2 = vb.h;
                } else if (i2 == 1) {
                    vb9 = PopRankingHourCardView.this.getVb();
                    textView2 = vb9.f;
                } else if (i2 != 2) {
                    textView2 = null;
                } else {
                    vb10 = PopRankingHourCardView.this.getVb();
                    textView2 = vb10.g;
                }
                if (textView2 != null) {
                    int i3 = color3;
                    int i4 = color2;
                    PopRankingHourCardView popRankingHourCardView = PopRankingHourCardView.this;
                    ObjectAnimator.ofArgb(textView2, "TextColor", i3, i4).setDuration(200L).start();
                    textView2.getPaint().setFakeBoldText(true);
                    popRankingHourCardView.j = textView2;
                }
                vb2 = PopRankingHourCardView.this.getVb();
                vb2.i.animate().translationX(DensityUtils.a(PopRankingHourCardView.this.getContext(), 69.0f) * i2).setDuration(500L).setInterpolator(new OvershootInterpolator()).start();
                if (i2 == 2) {
                    vb6 = PopRankingHourCardView.this.getVb();
                    if (vb6.d.isClickable()) {
                        vb7 = PopRankingHourCardView.this.getVb();
                        vb7.d.setClickable(false);
                        vb8 = PopRankingHourCardView.this.getVb();
                        vb8.d.animate().alpha(0.0f).setDuration(150L).start();
                        return;
                    }
                    return;
                }
                vb3 = PopRankingHourCardView.this.getVb();
                if (vb3.d.isClickable()) {
                    return;
                }
                vb4 = PopRankingHourCardView.this.getVb();
                vb4.d.setClickable(true);
                vb5 = PopRankingHourCardView.this.getVb();
                vb5.d.animate().alpha(1.0f).setDuration(150L).start();
            }
        });
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourCardView$AKEDsuTUz49EMQIS0BQlBFGHT44
            @Override // java.lang.Runnable
            public final void run() {
                PopRankingHourCardView.a(PopRankingHourCardView.this, i);
            }
        }, z ? 200L : 0L);
        getVb().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourCardView$21_O4X6NK4c3zDqlInEFaJ7oNYc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHourCardView.a(PopRankingHourCardView.this, view);
            }
        });
        getVb().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourCardView$cJNtZZB_e8sZPF9G5_OvPhm-jbk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHourCardView.b(PopRankingHourCardView.this, view);
            }
        });
        getVb().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourCardView$2MG4Z7LXikHRTo6o0u3f4Ijfgyg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHourCardView.c(PopRankingHourCardView.this, view);
            }
        });
        getVb().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourCardView$CLAbQQSwJtpojiOeEMrsnvUmX7g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHourCardView.a(PopRankingHourCardView.this, fragment, requestHost, view);
            }
        });
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = this;
        getVb().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourCardView$JQSqj0D2uJkvfYFfidyiwL2ybiE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopRankingHourCardView.a(PopRankingHourCardView.this, objectRef, view);
            }
        });
    }

    public final AttributeSet getAttrs() {
        return this.f15127c;
    }

    public final int getDefStyleAttr() {
        return this.d;
    }

    public final Context getMContext() {
        return this.b;
    }
}
