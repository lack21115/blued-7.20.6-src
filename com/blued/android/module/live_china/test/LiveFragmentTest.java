package com.blued.android.module.live_china.test;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
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
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveFragmentLayoutTestBinding;
import com.blued.android.module.live_china.fragment.LiveMainFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.login.test.LoginFragment;
import com.bytedance.applog.tracker.Tracker;
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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveFragmentTest.class */
public final class LiveFragmentTest extends MVVMBaseFragment<EmptyViewModel> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f14137c;
    private MyAdapter d;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(LiveFragmentTest.class, "viewBinding", "getViewBinding()Lcom/blued/android/module/live_china/databinding/LiveFragmentLayoutTestBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14136a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveFragmentTest$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, LiveFragmentTest.class, null);
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveFragmentTest$MyAdapter.class */
    public static final class MyAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f14138a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fm) {
            super(fm);
            Intrinsics.e(fm, "fm");
            this.f14138a = CollectionsKt.b("热门", "关注");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return i == 0 ? new LiveMainFragment() : new LiveHomeFramentTest(1);
        }
    }

    public LiveFragmentTest() {
        super(R.layout.live_fragment_layout_test);
        this.f14137c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LiveFragmentTest, LiveFragmentLayoutTestBinding>() { // from class: com.blued.android.module.live_china.test.LiveFragmentTest$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveFragmentLayoutTestBinding invoke(LiveFragmentTest fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveFragmentLayoutTestBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveFragmentTest, LiveFragmentLayoutTestBinding>() { // from class: com.blued.android.module.live_china.test.LiveFragmentTest$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveFragmentLayoutTestBinding invoke(LiveFragmentTest fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveFragmentLayoutTestBinding.a(fragment.requireView());
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.d = new MyAdapter(childFragmentManager);
        final LiveFragmentLayoutTestBinding p = p();
        if (p == null) {
            return;
        }
        p.h.setAdapter(q());
        p.b.setText(LiveRoomInfo.a().c());
        p.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.test.LiveFragmentTest$initView$1$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 0) {
                    TextView textView = LiveFragmentLayoutTestBinding.this.g;
                    Context context = this.getContext();
                    Intrinsics.a(context);
                    Resources resources = context.getResources();
                    Intrinsics.a(resources);
                    textView.setTextColor(resources.getColor(R.color.syc_dark_a));
                    TextView textView2 = LiveFragmentLayoutTestBinding.this.f;
                    Context context2 = this.getContext();
                    Intrinsics.a(context2);
                    Resources resources2 = context2.getResources();
                    Intrinsics.a(resources2);
                    textView2.setTextColor(resources2.getColor(R.color.syc_dark_2A2A2E));
                    return;
                }
                TextView textView3 = LiveFragmentLayoutTestBinding.this.g;
                Context context3 = this.getContext();
                Intrinsics.a(context3);
                Resources resources3 = context3.getResources();
                Intrinsics.a(resources3);
                textView3.setTextColor(resources3.getColor(R.color.syc_dark_2A2A2E));
                TextView textView4 = LiveFragmentLayoutTestBinding.this.f;
                Context context4 = this.getContext();
                Intrinsics.a(context4);
                Resources resources4 = context4.getResources();
                Intrinsics.a(resources4);
                textView4.setTextColor(resources4.getColor(R.color.syc_dark_a));
            }
        });
        TextView textView = p.e;
        LiveFragmentTest liveFragmentTest = this;
        textView.setOnClickListener(liveFragmentTest);
        p.g.setOnClickListener(liveFragmentTest);
        p.f.setOnClickListener(liveFragmentTest);
        p.f12215c.setOnClickListener(liveFragmentTest);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        ViewPager viewPager;
        ViewPager viewPager2;
        Tracker.onClick(v);
        Intrinsics.e(v, "v");
        int id = v.getId();
        if (id == R.id.tv_exit) {
            LoginFragment.f20569a.a(getContext());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        } else if (id == R.id.tv_hot) {
            LiveFragmentLayoutTestBinding p = p();
            if (p == null || (viewPager2 = p.h) == null) {
                return;
            }
            viewPager2.setCurrentItem(0);
        } else if (id != R.id.tv_follow) {
            if (id == R.id.open_live) {
                RecordingOnliveFragment.a(getContext(), 1);
            }
        } else {
            LiveFragmentLayoutTestBinding p2 = p();
            if (p2 == null || (viewPager = p2.h) == null) {
                return;
            }
            viewPager.setCurrentItem(1);
        }
    }

    public final LiveFragmentLayoutTestBinding p() {
        return (LiveFragmentLayoutTestBinding) this.f14137c.b(this, b[0]);
    }

    public final MyAdapter q() {
        return this.d;
    }
}
