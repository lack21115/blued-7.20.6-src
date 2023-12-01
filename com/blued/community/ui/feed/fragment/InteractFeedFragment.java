package com.blued.community.ui.feed.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.community.R;
import com.blued.community.databinding.FragmentInteractFeedBinding;
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
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/InteractFeedFragment.class */
public final class InteractFeedFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19803c;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(InteractFeedFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentInteractFeedBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19802a = new Companion(null);

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/InteractFeedFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            TerminalActivity.d(context, InteractFeedFragment.class, null);
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/InteractFeedFragment$MyAdapter.class */
    static final class MyAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f19804a;
        private final List<Integer> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(Context context, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(fm, "fm");
            this.f19804a = context;
            this.b = CollectionsKt.b(Integer.valueOf(R.string.feed_liked_page_title), Integer.valueOf(R.string.feed_commented_page_title));
        }

        public final Context getContext() {
            return this.f19804a;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return i == 0 ? new LikedFeedFragment() : new CommentedFeedFragment();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            Context context = this.f19804a;
            return context == null ? null : context.getString(this.b.get(i).intValue());
        }
    }

    public InteractFeedFragment() {
        super(R.layout.fragment_interact_feed);
        this.f19803c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<InteractFeedFragment, FragmentInteractFeedBinding>() { // from class: com.blued.community.ui.feed.fragment.InteractFeedFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentInteractFeedBinding invoke(InteractFeedFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentInteractFeedBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<InteractFeedFragment, FragmentInteractFeedBinding>() { // from class: com.blued.community.ui.feed.fragment.InteractFeedFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentInteractFeedBinding invoke(InteractFeedFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentInteractFeedBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InteractFeedFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FragmentInteractFeedBinding p() {
        return (FragmentInteractFeedBinding) this.f19803c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        CustomViewPager customViewPager;
        PageTabLayout pageTabLayout;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        FragmentInteractFeedBinding p = p();
        if (p != null && (commonTopTitleNoTrans = p.d) != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$InteractFeedFragment$THKgGsfroJkcolDDG3zna3tHGE4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InteractFeedFragment.a(InteractFeedFragment.this, view);
                }
            });
        }
        FragmentInteractFeedBinding p2 = p();
        CustomViewPager customViewPager2 = p2 == null ? null : p2.e;
        if (customViewPager2 != null) {
            Context context = getContext();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            customViewPager2.setAdapter(new MyAdapter(context, childFragmentManager));
        }
        FragmentInteractFeedBinding p3 = p();
        if (p3 != null && (pageTabLayout = p3.f18893c) != null) {
            FragmentInteractFeedBinding p4 = p();
            pageTabLayout.setupWithViewPager(p4 == null ? null : p4.e);
        }
        FragmentInteractFeedBinding p5 = p();
        if (p5 == null || (customViewPager = p5.e) == null) {
            return;
        }
        customViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.community.ui.feed.fragment.InteractFeedFragment$initView$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }
}
