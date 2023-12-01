package com.blued.android.module.live_china.test;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveHotFragmentLayoutTestBinding;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveHomeFramentTest.class */
public final class LiveHomeFramentTest extends MVVMBaseFragment<LiveHomeViewModelTest> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f14140a = {Reflection.a(new PropertyReference1Impl(LiveHomeFramentTest.class, "viewBinding", "getViewBinding()Lcom/blued/android/module/live_china/databinding/LiveHotFragmentLayoutTestBinding;", 0))};
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f14141c;
    private LiveAdapterTest d;

    public LiveHomeFramentTest() {
        this(0);
    }

    public LiveHomeFramentTest(int i) {
        super(R.layout.live_hot_fragment_layout_test);
        this.b = i;
        this.f14141c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LiveHomeFramentTest, LiveHotFragmentLayoutTestBinding>() { // from class: com.blued.android.module.live_china.test.LiveHomeFramentTest$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveHotFragmentLayoutTestBinding invoke(LiveHomeFramentTest fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveHotFragmentLayoutTestBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveHomeFramentTest, LiveHotFragmentLayoutTestBinding>() { // from class: com.blued.android.module.live_china.test.LiveHomeFramentTest$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveHotFragmentLayoutTestBinding invoke(LiveHomeFramentTest fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveHotFragmentLayoutTestBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveHotFragmentLayoutTestBinding it) {
        Intrinsics.e(it, "$it");
        it.b.i();
    }

    public final void a(List<? extends BluedLiveListDataTest> datas) {
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(datas, "datas");
        LiveAdapterTest liveAdapterTest = this.d;
        if (liveAdapterTest != null) {
            liveAdapterTest.setNewData(datas);
        }
        LiveHotFragmentLayoutTestBinding p = p();
        if (p == null || (smartRefreshLayout = p.b) == null) {
            return;
        }
        smartRefreshLayout.j();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        this.d = new LiveAdapterTest();
        final LiveHotFragmentLayoutTestBinding p = p();
        if (p == null) {
            return;
        }
        p.f12253a.setLayoutManager(new GridLayoutManager(getContext(), 2));
        p.f12253a.setAdapter(q());
        p.b.c(true);
        p.b.l(false);
        p.b.a(new OnRefreshListener() { // from class: com.blued.android.module.live_china.test.LiveHomeFramentTest$initView$1$1
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                LiveHomeFramentTest.this.r();
            }
        });
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.test.-$$Lambda$LiveHomeFramentTest$4qGv6Paf3dslALVGWEEvfBXkR9g
            @Override // java.lang.Runnable
            public final void run() {
                LiveHomeFramentTest.a(LiveHotFragmentLayoutTestBinding.this);
            }
        }, 500L);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleExtKt.a(this, a().d(), new LiveHomeFramentTest$liveDataObserver$1(this));
    }

    public final LiveHotFragmentLayoutTestBinding p() {
        return (LiveHotFragmentLayoutTestBinding) this.f14141c.b(this, f14140a[0]);
    }

    public final LiveAdapterTest q() {
        return this.d;
    }

    public final void r() {
        if (this.b == 0) {
            a().e();
        } else {
            a().f();
        }
    }
}
