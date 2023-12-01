package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveHostFinishDetailLayoutBinding;
import com.blued.android.module.live_china.model.LiveFinishTabData;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailFragment.class */
public final class LiveHostFinishDetailFragment extends MVVMBaseFragment<LiveHostFinishDetailViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f12965c;
    private LiveHostFinishDetailViewModel.ApiState d;
    private List<LiveFinishTabData> e;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(LiveHostFinishDetailFragment.class, "vb", "getVb()Lcom/blued/android/module/live_china/databinding/LiveHostFinishDetailLayoutBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12964a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveHostFinishDetailFragment a(LiveHostFinishDetailViewModel.ApiState apiState) {
            LiveHostFinishDetailFragment liveHostFinishDetailFragment = new LiveHostFinishDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("state", apiState);
            liveHostFinishDetailFragment.setArguments(bundle);
            return liveHostFinishDetailFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailFragment$MyAdapter.class */
    public static final class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private FragmentManager f12966a;
        private List<LiveFinishTabData> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fm, List<LiveFinishTabData> tabs) {
            super(fm, 1);
            Intrinsics.e(fm, "fm");
            Intrinsics.e(tabs, "tabs");
            this.f12966a = fm;
            this.b = tabs;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            super.destroyItem(container, i, object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return LiveHostFinishDetailItemFragment.f12967a.a(this.b.get(i).getState());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            Log.i("==xpmm:", Intrinsics.a("getPageTitle:", (Object) this.b.get(i).getName()));
            return this.b.get(i).getName();
        }
    }

    public LiveHostFinishDetailFragment() {
        super(R.layout.live_host_finish_detail_layout);
        this.f12965c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LiveHostFinishDetailFragment, LiveHostFinishDetailLayoutBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveHostFinishDetailLayoutBinding invoke(LiveHostFinishDetailFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveHostFinishDetailLayoutBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveHostFinishDetailFragment, LiveHostFinishDetailLayoutBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveHostFinishDetailLayoutBinding invoke(LiveHostFinishDetailFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveHostFinishDetailLayoutBinding.a(fragment.requireView());
            }
        });
        this.e = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveHostFinishDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveHostFinishDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
    }

    public final void a(LiveHostFinishDetailViewModel.ApiState apiState) {
        this.d = apiState;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        TextView textView;
        TextView textView2;
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        ShapeTextView shapeTextView3;
        ShapeTextView shapeTextView4;
        ShapeTextView shapeTextView5;
        TextView textView3;
        TextView textView4;
        ShapeTextView shapeTextView6;
        ShapeLinearLayout shapeLinearLayout;
        TextView textView5;
        ShapeTextView shapeTextView7;
        TextView textView6;
        TextView textView7;
        ShapeTextView shapeTextView8;
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        TextView textView8;
        TextView textView9;
        LiveHostFinishDetailLayoutBinding p;
        TabPageIndicatorWithDot tabPageIndicatorWithDot2;
        TabPageIndicatorWithDot tabPageIndicatorWithDot3;
        TabPageIndicatorWithDot tabPageIndicatorWithDot4;
        TabPageIndicatorWithDot tabPageIndicatorWithDot5;
        TabPageIndicatorWithDot tabPageIndicatorWithDot6;
        TabPageIndicatorWithDot tabPageIndicatorWithDot7;
        TabPageIndicatorWithDot tabPageIndicatorWithDot8;
        TextView textView10;
        ViewPager viewPager;
        TextView textView11;
        TextView textView12;
        ShapeTextView shapeTextView9;
        Serializable serializable;
        this.e.clear();
        Bundle arguments = getArguments();
        if (arguments != null && (serializable = arguments.getSerializable("state")) != null && (serializable instanceof LiveHostFinishDetailViewModel.ApiState)) {
            a((LiveHostFinishDetailViewModel.ApiState) serializable);
        }
        if (this.d == null) {
            return;
        }
        LiveHostFinishDetailViewModel.ApiState q = q();
        if (Intrinsics.a(q, LiveHostFinishDetailViewModel.ApiState.ApiContributors.f15466a)) {
            List<LiveFinishTabData> r = r();
            String string = getString(R.string.live_host_finish_look_rank);
            Intrinsics.c(string, "getString(R.string.live_host_finish_look_rank)");
            r.add(new LiveFinishTabData(string, "", LiveHostFinishDetailViewModel.ApiState.ApiContributors.f15466a));
            LiveHostFinishDetailLayoutBinding p2 = p();
            if (p2 != null && (shapeTextView9 = p2.f12248c) != null) {
                BluedViewExKt.a(shapeTextView9);
            }
            LiveHostFinishDetailLayoutBinding p3 = p();
            if (p3 != null && (textView12 = p3.e) != null) {
                BluedViewExKt.b(textView12);
            }
            LiveHostFinishDetailLayoutBinding p4 = p();
            if (p4 != null && (textView11 = p4.e) != null) {
                textView11.setText(getString(R.string.live_host_finish_look_rank_tip));
            }
        } else if (Intrinsics.a(q, LiveHostFinishDetailViewModel.ApiState.ApiAudiences.f15464a)) {
            List<LiveFinishTabData> r2 = r();
            String string2 = getString(R.string.live_host_finish_look);
            Intrinsics.c(string2, "getString(R.string.live_host_finish_look)");
            r2.add(new LiveFinishTabData(string2, "", LiveHostFinishDetailViewModel.ApiState.ApiAudiences.f15464a));
            LiveHostFinishDetailLayoutBinding p5 = p();
            if (p5 != null && (shapeTextView8 = p5.f12248c) != null) {
                BluedViewExKt.a(shapeTextView8);
            }
            LiveHostFinishDetailLayoutBinding p6 = p();
            if (p6 != null && (textView7 = p6.e) != null) {
                BluedViewExKt.b(textView7);
            }
            LiveHostFinishDetailLayoutBinding p7 = p();
            if (p7 != null && (textView6 = p7.e) != null) {
                textView6.setText(getString(R.string.live_host_finish_look_tip));
            }
        } else if (Intrinsics.a(q, LiveHostFinishDetailViewModel.ApiState.ApiGiverFrom.f15467a)) {
            List<LiveFinishTabData> r3 = r();
            String string3 = getString(R.string.live_host_finish_au_from);
            Intrinsics.c(string3, "getString(R.string.live_host_finish_au_from)");
            r3.add(new LiveFinishTabData(string3, "", LiveHostFinishDetailViewModel.ApiState.ApiGiverFrom.f15467a));
            LiveHostFinishDetailLayoutBinding p8 = p();
            if (p8 != null && (shapeTextView7 = p8.f12248c) != null) {
                BluedViewExKt.a(shapeTextView7);
            }
            LiveHostFinishDetailLayoutBinding p9 = p();
            if (p9 != null && (textView5 = p9.f) != null) {
                BluedViewExKt.b(textView5);
            }
            LiveHostFinishDetailLayoutBinding p10 = p();
            if (p10 != null && (shapeLinearLayout = p10.b) != null) {
                BluedViewExKt.c(shapeLinearLayout);
            }
        } else if (Intrinsics.a(q, LiveHostFinishDetailViewModel.ApiState.ApiLikes.f15468a)) {
            List<LiveFinishTabData> r4 = r();
            String string4 = getString(R.string.live_host_finish_comment);
            Intrinsics.c(string4, "getString(R.string.live_host_finish_comment)");
            r4.add(new LiveFinishTabData(string4, "", LiveHostFinishDetailViewModel.ApiState.ApiLikes.f15468a));
            LiveHostFinishDetailLayoutBinding p11 = p();
            if (p11 != null && (shapeTextView6 = p11.f12248c) != null) {
                BluedViewExKt.a(shapeTextView6);
            }
            LiveHostFinishDetailLayoutBinding p12 = p();
            if (p12 != null && (textView4 = p12.e) != null) {
                BluedViewExKt.b(textView4);
            }
            LiveHostFinishDetailLayoutBinding p13 = p();
            if (p13 != null && (textView3 = p13.e) != null) {
                textView3.setText(getString(R.string.live_host_finish_like_tip));
            }
        } else if (Intrinsics.a(q, LiveHostFinishDetailViewModel.ApiState.ApiNewFans.f15469a)) {
            List<LiveFinishTabData> r5 = r();
            String string5 = getString(R.string.live_host_finish_fans_add_number_people);
            Intrinsics.c(string5, "getString(R.string.live_…h_fans_add_number_people)");
            r5.add(new LiveFinishTabData(string5, "", LiveHostFinishDetailViewModel.ApiState.ApiNewFans.f15469a));
            LiveHostFinishDetailLayoutBinding p14 = p();
            if (p14 != null && (shapeTextView5 = p14.f12248c) != null) {
                BluedViewExKt.b(shapeTextView5);
            }
            LiveHostFinishDetailLayoutBinding p15 = p();
            if (p15 != null && (shapeTextView4 = p15.f12248c) != null) {
                shapeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDetailFragment$dXUEbLN6HdQ25sTjVRA7MKAOibk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveHostFinishDetailFragment.a(LiveHostFinishDetailFragment.this, view);
                    }
                });
            }
        } else if (Intrinsics.a(q, LiveHostFinishDetailViewModel.ApiState.ApiNewFollowers.f15470a)) {
            List<LiveFinishTabData> r6 = r();
            String string6 = getString(R.string.live_host_finish_att_add);
            Intrinsics.c(string6, "getString(R.string.live_host_finish_att_add)");
            r6.add(new LiveFinishTabData(string6, "", LiveHostFinishDetailViewModel.ApiState.ApiNewFollowers.f15470a));
            LiveHostFinishDetailLayoutBinding p16 = p();
            if (p16 != null && (shapeTextView3 = p16.f12248c) != null) {
                BluedViewExKt.b(shapeTextView3);
            }
            LiveHostFinishDetailLayoutBinding p17 = p();
            if (p17 != null && (shapeTextView2 = p17.f12248c) != null) {
                shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDetailFragment$RK-BPlZb6Wmtp-Ex-lhjaknaug0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveHostFinishDetailFragment.b(LiveHostFinishDetailFragment.this, view);
                    }
                });
            }
        } else if (Intrinsics.a(q, LiveHostFinishDetailViewModel.ApiState.ApiComments.f15465a)) {
            List<LiveFinishTabData> r7 = r();
            String string7 = getString(R.string.live_host_finish_comment);
            Intrinsics.c(string7, "getString(R.string.live_host_finish_comment)");
            r7.add(new LiveFinishTabData(string7, "", LiveHostFinishDetailViewModel.ApiState.ApiComments.f15465a));
            LiveHostFinishDetailLayoutBinding p18 = p();
            if (p18 != null && (shapeTextView = p18.f12248c) != null) {
                BluedViewExKt.a(shapeTextView);
            }
            LiveHostFinishDetailLayoutBinding p19 = p();
            if (p19 != null && (textView2 = p19.e) != null) {
                BluedViewExKt.b(textView2);
            }
            LiveHostFinishDetailLayoutBinding p20 = p();
            if (p20 != null && (textView = p20.e) != null) {
                textView.setText(getString(R.string.live_host_finish_comment_tip));
            }
        }
        LiveHostFinishDetailLayoutBinding p21 = p();
        ViewPager viewPager2 = p21 == null ? null : p21.g;
        if (viewPager2 != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            viewPager2.setAdapter(new MyAdapter(childFragmentManager, r()));
        }
        LiveHostFinishDetailLayoutBinding p22 = p();
        if (p22 != null && (viewPager = p22.g) != null) {
            viewPager.setCurrentItem(0);
        }
        if (r().size() <= 1) {
            if (r().size() == 1) {
                LiveHostFinishDetailLayoutBinding p23 = p();
                if (p23 != null && (textView9 = p23.d) != null) {
                    BluedViewExKt.b(textView9);
                }
                LiveHostFinishDetailLayoutBinding p24 = p();
                if (p24 != null && (textView8 = p24.d) != null) {
                    textView8.setText(r().get(0).getName());
                }
                LiveHostFinishDetailLayoutBinding p25 = p();
                if (p25 == null || (tabPageIndicatorWithDot = p25.f12247a) == null) {
                    return;
                }
                BluedViewExKt.a(tabPageIndicatorWithDot);
                return;
            }
            return;
        }
        LiveHostFinishDetailLayoutBinding p26 = p();
        if (p26 != null && (textView10 = p26.d) != null) {
            BluedViewExKt.a(textView10);
        }
        LiveHostFinishDetailLayoutBinding p27 = p();
        if (p27 != null && (tabPageIndicatorWithDot8 = p27.f12247a) != null) {
            BluedViewExKt.b(tabPageIndicatorWithDot8);
        }
        LiveHostFinishDetailLayoutBinding p28 = p();
        if (p28 != null && (tabPageIndicatorWithDot7 = p28.f12247a) != null) {
            LiveHostFinishDetailLayoutBinding p29 = p();
            tabPageIndicatorWithDot7.setViewPager(p29 == null ? null : p29.g);
        }
        LiveHostFinishDetailLayoutBinding p30 = p();
        if (p30 != null && (tabPageIndicatorWithDot6 = p30.f12247a) != null) {
            tabPageIndicatorWithDot6.setIndicatorHeight(DensityUtils.a(getContext(), 2.0f));
        }
        LiveHostFinishDetailLayoutBinding p31 = p();
        TabPageIndicatorWithDot tabPageIndicatorWithDot9 = p31 == null ? null : p31.f12247a;
        if (tabPageIndicatorWithDot9 != null) {
            tabPageIndicatorWithDot9.w = DensityUtils.d(getContext(), 16.0f);
        }
        LiveHostFinishDetailLayoutBinding p32 = p();
        TabPageIndicatorWithDot tabPageIndicatorWithDot10 = p32 == null ? null : p32.f12247a;
        if (tabPageIndicatorWithDot10 != null) {
            tabPageIndicatorWithDot10.x = DensityUtils.d(getContext(), 14.0f);
        }
        LiveHostFinishDetailLayoutBinding p33 = p();
        if (p33 != null && (tabPageIndicatorWithDot5 = p33.f12247a) != null) {
            tabPageIndicatorWithDot5.setTextColor(R.color.syc_dark_EAEAEA);
        }
        LiveHostFinishDetailLayoutBinding p34 = p();
        if (p34 != null && (tabPageIndicatorWithDot4 = p34.f12247a) != null) {
            tabPageIndicatorWithDot4.setTabTextColorUnfocused(R.color.syc_dark_777777);
        }
        LiveHostFinishDetailLayoutBinding p35 = p();
        if (p35 != null && (tabPageIndicatorWithDot3 = p35.f12247a) != null) {
            tabPageIndicatorWithDot3.setHorizontalShade(true);
        }
        Context context = getContext();
        if (context == null || (p = p()) == null || (tabPageIndicatorWithDot2 = p.f12247a) == null) {
            return;
        }
        tabPageIndicatorWithDot2.a(ContextCompat.getColor(context, R.color.syc_dark_2B72FF), ContextCompat.getColor(context, R.color.syc_dark_2B72FF));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    public final LiveHostFinishDetailLayoutBinding p() {
        return (LiveHostFinishDetailLayoutBinding) this.f12965c.b(this, b[0]);
    }

    public final LiveHostFinishDetailViewModel.ApiState q() {
        return this.d;
    }

    public final List<LiveFinishTabData> r() {
        return this.e;
    }

    public final void s() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.c(fragments, "childFragmentManager.fragments");
        if (fragments.size() == 1) {
            Fragment fragment = fragments.get(0);
            if (fragment instanceof LiveHostFinishDetailItemFragment) {
                ((LiveHostFinishDetailItemFragment) fragment).r();
            }
        }
    }
}
