package com.blued.community.ui.event.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.community.R;
import com.blued.community.databinding.FragmentMineEventBinding;
import com.blued.community.ui.event.vm.MineEventViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/MineEventFragment.class */
public final class MineEventFragment extends MVVMBaseFragment<MineEventViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19567c;
    private MyAdapter d;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(MineEventFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentMineEventBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19566a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/MineEventFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, MineEventFragment.class, null);
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/MineEventFragment$MyAdapter.class */
    public static final class MyAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final FragmentManager f19568a;
        private final List<String> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fm, List<String> tabs) {
            super(fm, 1);
            Intrinsics.e(fm, "fm");
            Intrinsics.e(tabs, "tabs");
            this.f19568a = fm;
            this.b = tabs;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            super.destroyItem(container, i, object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1 && i == 2) {
                    return new EventPostedListFragment();
                }
                return new EventJoinedListFragment();
            }
            return new EventSubscribeFragment();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.b.get(i);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            Object instantiateItem = super.instantiateItem(container, i);
            Intrinsics.c(instantiateItem, "super.instantiateItem(container, position)");
            return instantiateItem;
        }
    }

    public MineEventFragment() {
        super(R.layout.fragment_mine_event);
        this.f19567c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<MineEventFragment, FragmentMineEventBinding>() { // from class: com.blued.community.ui.event.fragment.MineEventFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentMineEventBinding invoke(MineEventFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentMineEventBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<MineEventFragment, FragmentMineEventBinding>() { // from class: com.blued.community.ui.event.fragment.MineEventFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentMineEventBinding invoke(MineEventFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentMineEventBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineEventFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MineEventFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FragmentMineEventBinding p() {
        return (FragmentMineEventBinding) this.f19567c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        Resources resources;
        FragmentMineEventBinding p = p();
        if (p == null) {
            return;
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans = p.d;
        Context context = getContext();
        commonTopTitleNoTrans.setCenterText((context == null || (resources = context.getResources()) == null) ? null : resources.getString(R.string.event_mine_events));
        p.d.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$MineEventFragment$GAZPVGGQEMa1YX7O4-1cbC4UxHg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineEventFragment.a(MineEventFragment.this, view);
            }
        });
        p.f18895a.setVisibility(0);
        p.d.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$MineEventFragment$Y8xnBcJaOudBpuzeyrkXFEiMUUg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineEventFragment.b(MineEventFragment.this, view);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.d = new MyAdapter(childFragmentManager, j().d());
        CustomViewPager customViewPager = p.e;
        MyAdapter myAdapter = this.d;
        if (myAdapter == null) {
            Intrinsics.c("tabAdapter");
            myAdapter = null;
        }
        customViewPager.setAdapter(myAdapter);
        p.f18896c.setupWithViewPager(p.e);
        p.e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.community.ui.event.fragment.MineEventFragment$initView$1$3
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
