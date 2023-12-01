package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.live.base.music.MusicLoadMoreView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFinishDetailAdapter;
import com.blued.android.module.live_china.databinding.LiveHostFinishDetailItemLayoutBinding;
import com.blued.android.module.live_china.model.LiveFinishData;
import com.blued.android.module.live_china.model.LiveFinishPageData;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailItemFragment.class */
public final class LiveHostFinishDetailItemFragment extends MVVMBaseFragment<LiveHostFinishDetailViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f12968c;
    private LiveHostFinishDetailViewModel.ApiState d;
    private BaseQuickAdapter<LiveFinishData, BaseViewHolder> e;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(LiveHostFinishDetailItemFragment.class, "vb", "getVb()Lcom/blued/android/module/live_china/databinding/LiveHostFinishDetailItemLayoutBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12967a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailItemFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveHostFinishDetailItemFragment a(LiveHostFinishDetailViewModel.ApiState apiState) {
            LiveHostFinishDetailItemFragment liveHostFinishDetailItemFragment = new LiveHostFinishDetailItemFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("state", apiState);
            liveHostFinishDetailItemFragment.setArguments(bundle);
            return liveHostFinishDetailItemFragment;
        }
    }

    public LiveHostFinishDetailItemFragment() {
        super(R.layout.live_host_finish_detail_item_layout);
        this.f12968c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LiveHostFinishDetailItemFragment, LiveHostFinishDetailItemLayoutBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailItemFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveHostFinishDetailItemLayoutBinding invoke(LiveHostFinishDetailItemFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveHostFinishDetailItemLayoutBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveHostFinishDetailItemFragment, LiveHostFinishDetailItemLayoutBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailItemFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LiveHostFinishDetailItemLayoutBinding invoke(LiveHostFinishDetailItemFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return LiveHostFinishDetailItemLayoutBinding.a(fragment.requireView());
            }
        });
    }

    public final void a(LiveHostFinishDetailViewModel.ApiState apiState) {
        this.d = apiState;
    }

    public final void a(BaseQuickAdapter<LiveFinishData, BaseViewHolder> baseQuickAdapter) {
        this.e = baseQuickAdapter;
    }

    public final void b(boolean z) {
        LiveHostFinishDetailViewModel.ApiState apiState = this.d;
        if (apiState == null) {
            return;
        }
        if (z) {
            a().a(apiState);
        } else {
            a().b(apiState);
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        Serializable serializable;
        Bundle arguments = getArguments();
        if (arguments != null && (serializable = arguments.getSerializable("state")) != null && (serializable instanceof LiveHostFinishDetailViewModel.ApiState)) {
            a((LiveHostFinishDetailViewModel.ApiState) serializable);
        }
        LiveHostFinishDetailViewModel.ApiState apiState = this.d;
        if (apiState != null) {
            LiveHostFinishDetailItemLayoutBinding p = p();
            RecyclerView recyclerView = p == null ? null : p.f12246c;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
            Context requireContext = requireContext();
            Intrinsics.c(requireContext, "requireContext()");
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            a(new LiveFinishDetailAdapter(requireContext, fragmentActive, apiState));
            LiveHostFinishDetailItemLayoutBinding p2 = p();
            RecyclerView recyclerView2 = p2 == null ? null : p2.f12246c;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(q());
            }
        }
        LiveHostFinishDetailItemLayoutBinding p3 = p();
        if (p3 != null && (smartRefreshLayout2 = p3.b) != null) {
            smartRefreshLayout2.a(new MusicLoadMoreView(getContext()));
        }
        LiveHostFinishDetailItemLayoutBinding p4 = p();
        if (p4 == null || (smartRefreshLayout = p4.b) == null) {
            return;
        }
        smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailItemFragment$initView$3
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                LiveHostFinishDetailItemFragment.this.b(false);
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                LiveHostFinishDetailItemFragment.this.b(true);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        SmartRefreshLayout smartRefreshLayout;
        if (!Intrinsics.a(this.d, LiveHostFinishDetailViewModel.ApiState.ApiGiverFrom.f15467a)) {
            b(true);
            return;
        }
        LiveHostFinishDetailItemLayoutBinding p = p();
        if (p == null || (smartRefreshLayout = p.b) == null) {
            return;
        }
        BluedViewExKt.a(smartRefreshLayout);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleExtKt.a(this, a().g(), new Function1<List<? extends LiveFinishData>, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailItemFragment$liveDataObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(List<LiveFinishData> list) {
                LinearLayout linearLayout;
                RecyclerView recyclerView;
                RecyclerView recyclerView2;
                LinearLayout linearLayout2;
                SmartRefreshLayout smartRefreshLayout;
                SmartRefreshLayout smartRefreshLayout2;
                SmartRefreshLayout smartRefreshLayout3;
                LiveFinishPageData e = LiveHostFinishDetailItemFragment.this.a().e();
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                BaseQuickAdapter<LiveFinishData, BaseViewHolder> q = LiveHostFinishDetailItemFragment.this.q();
                if (q != null) {
                    q.setNewData(arrayList);
                }
                LiveHostFinishDetailItemLayoutBinding p = LiveHostFinishDetailItemFragment.this.p();
                if (p != null && (smartRefreshLayout3 = p.b) != null) {
                    smartRefreshLayout3.h();
                }
                LiveHostFinishDetailItemLayoutBinding p2 = LiveHostFinishDetailItemFragment.this.p();
                if (p2 != null && (smartRefreshLayout2 = p2.b) != null) {
                    smartRefreshLayout2.j();
                }
                LiveHostFinishDetailItemLayoutBinding p3 = LiveHostFinishDetailItemFragment.this.p();
                if (p3 != null && (smartRefreshLayout = p3.b) != null) {
                    smartRefreshLayout.l(e.getHasMore());
                }
                if (list.size() == 0) {
                    LiveHostFinishDetailItemLayoutBinding p4 = LiveHostFinishDetailItemFragment.this.p();
                    if (p4 != null && (linearLayout2 = p4.f12245a) != null) {
                        BluedViewExKt.b(linearLayout2);
                    }
                    LiveHostFinishDetailItemLayoutBinding p5 = LiveHostFinishDetailItemFragment.this.p();
                    if (p5 == null || (recyclerView2 = p5.f12246c) == null) {
                        return;
                    }
                    BluedViewExKt.a(recyclerView2);
                    return;
                }
                LiveHostFinishDetailItemLayoutBinding p6 = LiveHostFinishDetailItemFragment.this.p();
                if (p6 != null && (recyclerView = p6.f12246c) != null) {
                    BluedViewExKt.b(recyclerView);
                }
                LiveHostFinishDetailItemLayoutBinding p7 = LiveHostFinishDetailItemFragment.this.p();
                if (p7 == null || (linearLayout = p7.f12245a) == null) {
                    return;
                }
                BluedViewExKt.a(linearLayout);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(List<? extends LiveFinishData> list) {
                a(list);
                return Unit.f42314a;
            }
        });
    }

    public final LiveHostFinishDetailItemLayoutBinding p() {
        return (LiveHostFinishDetailItemLayoutBinding) this.f12968c.b(this, b[0]);
    }

    public final BaseQuickAdapter<LiveFinishData, BaseViewHolder> q() {
        return this.e;
    }

    public final void r() {
        BaseQuickAdapter<LiveFinishData, BaseViewHolder> baseQuickAdapter = this.e;
        if (baseQuickAdapter instanceof LiveFinishDetailAdapter) {
            if (baseQuickAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.adapter.LiveFinishDetailAdapter");
            }
            ((LiveFinishDetailAdapter) baseQuickAdapter).c();
        }
    }
}
