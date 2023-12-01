package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.databinding.FragmentCircleMyManagementBinding;
import com.blued.community.ui.circle.adapter.CircleListAdapter;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.vm.CircleMyManagementViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMyManagementFragment.class */
public final class CircleMyManagementFragment extends MVVMBaseFragment<CircleMyManagementViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19221c;
    private CircleListAdapter d;
    private NoDataAndLoadFailView e;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(CircleMyManagementFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentCircleMyManagementBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19220a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMyManagementFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, CircleMyManagementFragment.class, null);
        }
    }

    public CircleMyManagementFragment() {
        super(R.layout.fragment_circle_my_management);
        this.f19221c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<CircleMyManagementFragment, FragmentCircleMyManagementBinding>() { // from class: com.blued.community.ui.circle.fragment.CircleMyManagementFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCircleMyManagementBinding invoke(CircleMyManagementFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCircleMyManagementBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<CircleMyManagementFragment, FragmentCircleMyManagementBinding>() { // from class: com.blued.community.ui.circle.fragment.CircleMyManagementFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCircleMyManagementBinding invoke(CircleMyManagementFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCircleMyManagementBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleMyManagementFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        CircleMyManagementViewModel j = this$0.j();
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.b(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleMyManagementFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleMyManagementFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        CircleMyManagementViewModel j = this$0.j();
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends MyCircleModel> list) {
        CircleListAdapter circleListAdapter = null;
        if (j().e() == 1) {
            CircleListAdapter circleListAdapter2 = this.d;
            if (circleListAdapter2 == null) {
                Intrinsics.c("circleListAdapter");
            } else {
                circleListAdapter = circleListAdapter2;
            }
            circleListAdapter.setNewData(list);
            return;
        }
        CircleListAdapter circleListAdapter3 = this.d;
        if (circleListAdapter3 == null) {
            Intrinsics.c("circleListAdapter");
            circleListAdapter3 = null;
        }
        circleListAdapter3.addData((Collection) list);
    }

    private final FragmentCircleMyManagementBinding p() {
        return (FragmentCircleMyManagementBinding) this.f19221c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void a(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentCircleMyManagementBinding p = p();
        if (p != null && (smartRefreshLayout = p.b) != null) {
            smartRefreshLayout.j();
        }
        CircleListAdapter circleListAdapter = this.d;
        CircleListAdapter circleListAdapter2 = circleListAdapter;
        if (circleListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleListAdapter2 = null;
        }
        circleListAdapter2.loadMoreComplete();
        if (z) {
            NoDataAndLoadFailView noDataAndLoadFailView = this.e;
            if (noDataAndLoadFailView == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView = null;
            }
            noDataAndLoadFailView.a();
            return;
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.e;
        if (noDataAndLoadFailView2 == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView2 = null;
        }
        noDataAndLoadFailView2.b();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        Resources resources;
        FragmentCircleMyManagementBinding p = p();
        if (p == null) {
            return;
        }
        p.f18835c.a();
        CommonTopTitleNoTrans commonTopTitleNoTrans = p.f18835c;
        Context context = getContext();
        commonTopTitleNoTrans.setCenterText((context == null || (resources = context.getResources()) == null) ? null : resources.getString(R.string.managed_circle));
        p.f18835c.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleMyManagementFragment$A6aWkoAc4LvZw3-PDX4tC-ApcG0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleMyManagementFragment.a(CircleMyManagementFragment.this, view);
            }
        });
        this.d = new CircleListAdapter(getContext(), CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE, getFragmentActive(), null);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.e = noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2 = noDataAndLoadFailView;
        if (noDataAndLoadFailView == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView2 = null;
        }
        noDataAndLoadFailView2.setNoDataImg(R.drawable.icon_no_circle);
        NoDataAndLoadFailView noDataAndLoadFailView3 = this.e;
        NoDataAndLoadFailView noDataAndLoadFailView4 = noDataAndLoadFailView3;
        if (noDataAndLoadFailView3 == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView4 = null;
        }
        noDataAndLoadFailView4.setNoDataStr(R.string.no_circle_yet);
        NoDataAndLoadFailView noDataAndLoadFailView5 = this.e;
        NoDataAndLoadFailView noDataAndLoadFailView6 = noDataAndLoadFailView5;
        if (noDataAndLoadFailView5 == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView6 = null;
        }
        noDataAndLoadFailView6.d();
        CircleListAdapter circleListAdapter = this.d;
        CircleListAdapter circleListAdapter2 = circleListAdapter;
        if (circleListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleListAdapter2 = null;
        }
        NoDataAndLoadFailView noDataAndLoadFailView7 = this.e;
        NoDataAndLoadFailView noDataAndLoadFailView8 = noDataAndLoadFailView7;
        if (noDataAndLoadFailView7 == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView8 = null;
        }
        circleListAdapter2.setEmptyView(noDataAndLoadFailView8);
        p.b.l(false);
        p.b.a(new OnRefreshListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleMyManagementFragment$kapakDpqNqmS7AYpa-uEATEAfV0
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                CircleMyManagementFragment.a(CircleMyManagementFragment.this, refreshLayout);
            }
        });
        CircleListAdapter circleListAdapter3 = this.d;
        CircleListAdapter circleListAdapter4 = circleListAdapter3;
        if (circleListAdapter3 == null) {
            Intrinsics.c("circleListAdapter");
            circleListAdapter4 = null;
        }
        circleListAdapter4.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleMyManagementFragment$rqjse5CLJxME6bXRx_rLjXpLeJc
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public final void onLoadMoreRequested() {
                CircleMyManagementFragment.a(CircleMyManagementFragment.this);
            }
        }, p.f18834a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = p.f18834a;
        CircleListAdapter circleListAdapter5 = this.d;
        if (circleListAdapter5 == null) {
            Intrinsics.c("circleListAdapter");
            circleListAdapter5 = null;
        }
        recyclerView.setAdapter(circleListAdapter5);
        p.f18834a.setLayoutManager(linearLayoutManager);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        CircleMyManagementViewModel j = j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleExtKt.a(this, j().d(), new CircleMyManagementFragment$liveDataObserver$1(this));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void n() {
        CircleListAdapter circleListAdapter = this.d;
        CircleListAdapter circleListAdapter2 = circleListAdapter;
        if (circleListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleListAdapter2 = null;
        }
        circleListAdapter2.setEnableLoadMore(true);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void o() {
        CircleListAdapter circleListAdapter = this.d;
        CircleListAdapter circleListAdapter2 = circleListAdapter;
        if (circleListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleListAdapter2 = null;
        }
        circleListAdapter2.setEnableLoadMore(false);
    }
}
