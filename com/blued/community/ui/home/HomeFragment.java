package com.blued.community.ui.home;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.community.R;
import com.blued.community.databinding.FragmentHomeBinding;
import com.blued.community.ui.circle.fragment.CircleNewFragment;
import com.blued.community.ui.event.fragment.EventListFragment;
import com.blued.community.ui.send.fragment.EventScoreAddPostFragment;
import com.blued.community.ui.square.fragment.AttentionFeedFragment;
import com.blued.community.ui.square.fragment.NearbyFeedFragment;
import com.blued.community.ui.square.fragment.RecommendFeedFragment;
import com.blued.login.test.LoginFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/home/HomeFragment.class */
public final class HomeFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19884c;
    private MyAdapter d;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(HomeFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentHomeBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19883a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/home/HomeFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, HomeFragment.class, null);
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/home/HomeFragment$MyAdapter.class */
    static final class MyAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f19885a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fm) {
            super(fm);
            Intrinsics.e(fm, "fm");
            this.f19885a = CollectionsKt.b("推荐", "同城", "关注", "圈子", "活动");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f19885a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? new RecommendFeedFragment() : new EventListFragment() : new CircleNewFragment() : new AttentionFeedFragment() : new NearbyFeedFragment() : new RecommendFeedFragment();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f19885a.get(i);
        }
    }

    public HomeFragment() {
        super(R.layout.fragment_home);
        this.f19884c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<HomeFragment, FragmentHomeBinding>() { // from class: com.blued.community.ui.home.HomeFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentHomeBinding invoke(HomeFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentHomeBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<HomeFragment, FragmentHomeBinding>() { // from class: com.blued.community.ui.home.HomeFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentHomeBinding invoke(HomeFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentHomeBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HomeFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LoginFragment.f20569a.a(this$0.getContext());
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HomeFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getFragmentManager() == null) {
            return;
        }
        EventScoreAddPostFragment.Companion companion = EventScoreAddPostFragment.b;
        Context requireContext = this$0.requireContext();
        Intrinsics.c(requireContext, "requireContext()");
        companion.a(requireContext, "12", 3, "");
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.d = new MyAdapter(childFragmentManager);
        FragmentHomeBinding p = p();
        CustomViewPager customViewPager = p == null ? null : p.d;
        if (customViewPager != null) {
            customViewPager.setAdapter(this.d);
        }
        FragmentHomeBinding p2 = p();
        if (p2 != null && (tabPageIndicatorWithDot = p2.e) != null) {
            FragmentHomeBinding p3 = p();
            tabPageIndicatorWithDot.setViewPager(p3 == null ? null : p3.d);
        }
        FragmentHomeBinding p4 = p();
        if (p4 != null && (shapeTextView2 = p4.b) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.home.-$$Lambda$HomeFragment$FMoMe-Xgoo_FXYmfKlQuCme0BYI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.a(HomeFragment.this, view);
                }
            });
        }
        FragmentHomeBinding p5 = p();
        if (p5 == null || (shapeTextView = p5.f18887c) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.home.-$$Lambda$HomeFragment$vgZPopeLzJSYLEhqKjALHrXnYi0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.b(HomeFragment.this, view);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    public final FragmentHomeBinding p() {
        return (FragmentHomeBinding) this.f19884c.b(this, b[0]);
    }
}
