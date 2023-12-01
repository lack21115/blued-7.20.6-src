package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
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
import com.blued.community.databinding.FragmentCircleTypeListBinding;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.adapter.CircleNewListAdapter;
import com.blued.community.ui.circle.adapter.CircleTypeListAdapter;
import com.blued.community.ui.circle.model.CircleTypeListModel;
import com.blued.community.ui.circle.model.CircleTypeModel;
import com.blued.community.ui.circle.vm.CircleTypeListViewModel;
import com.blued.community.utils.ViewUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
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
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTypeListFragment.class */
public final class CircleTypeListFragment extends MVVMBaseFragment<CircleTypeListViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19308c;
    private NoDataAndLoadFailView d;
    private CircleNewListAdapter e;
    private CircleTypeListAdapter f;
    private List<? extends CircleTypeModel.DataBean> g;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(CircleTypeListFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentCircleTypeListBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19307a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTypeListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i, FeedProtos.SourcePage circleFromPage) {
            Intrinsics.e(context, "context");
            Intrinsics.e(circleFromPage, "circleFromPage");
            Bundle bundle = new Bundle();
            bundle.putSerializable("circle_list_type", Integer.valueOf(i));
            bundle.putSerializable("circle_new_list_from_page", circleFromPage);
            TerminalActivity.d(context, CircleTypeListFragment.class, bundle);
        }

        public final void a(Context context, FeedProtos.SourcePage circleFromPage) {
            Intrinsics.e(context, "context");
            Intrinsics.e(circleFromPage, "circleFromPage");
            a(context, Integer.MIN_VALUE, circleFromPage);
        }
    }

    public CircleTypeListFragment() {
        super(R.layout.fragment_circle_type_list);
        this.f19308c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<CircleTypeListFragment, FragmentCircleTypeListBinding>() { // from class: com.blued.community.ui.circle.fragment.CircleTypeListFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCircleTypeListBinding invoke(CircleTypeListFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCircleTypeListBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<CircleTypeListFragment, FragmentCircleTypeListBinding>() { // from class: com.blued.community.ui.circle.fragment.CircleTypeListFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCircleTypeListBinding invoke(CircleTypeListFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCircleTypeListBinding.a(fragment.requireView());
            }
        });
        this.g = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleTypeListFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        CircleTypeListViewModel j = this$0.j();
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.b(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleTypeListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.a(activity);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleTypeListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(this$0, "this$0");
        CircleTypeListAdapter circleTypeListAdapter = this$0.f;
        CircleTypeListAdapter circleTypeListAdapter2 = circleTypeListAdapter;
        if (circleTypeListAdapter == null) {
            Intrinsics.c("circleTypeListAdapter");
            circleTypeListAdapter2 = null;
        }
        if (circleTypeListAdapter2.b(i) == null) {
            return;
        }
        CircleTypeListAdapter circleTypeListAdapter3 = this$0.f;
        CircleTypeListAdapter circleTypeListAdapter4 = circleTypeListAdapter3;
        if (circleTypeListAdapter3 == null) {
            Intrinsics.c("circleTypeListAdapter");
            circleTypeListAdapter4 = null;
        }
        circleTypeListAdapter4.a(i);
        this$0.q();
        CircleTypeListViewModel j = this$0.j();
        CircleTypeListAdapter circleTypeListAdapter5 = this$0.f;
        CircleTypeListAdapter circleTypeListAdapter6 = circleTypeListAdapter5;
        if (circleTypeListAdapter5 == null) {
            Intrinsics.c("circleTypeListAdapter");
            circleTypeListAdapter6 = null;
        }
        CircleTypeModel.DataBean b2 = circleTypeListAdapter6.b(i);
        j.a(b2 == null ? -1 : b2.id);
        this$0.o();
        if (this$0.j().l()) {
            this$0.j().c(true);
            this$0.j().m();
        } else {
            NoDataAndLoadFailView noDataAndLoadFailView = this$0.d;
            NoDataAndLoadFailView noDataAndLoadFailView2 = noDataAndLoadFailView;
            if (noDataAndLoadFailView == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView2 = null;
            }
            noDataAndLoadFailView2.d();
            CircleNewListAdapter circleNewListAdapter = this$0.e;
            CircleNewListAdapter circleNewListAdapter2 = circleNewListAdapter;
            if (circleNewListAdapter == null) {
                Intrinsics.c("circleListAdapter");
                circleNewListAdapter2 = null;
            }
            circleNewListAdapter2.setNewData(null);
            FragmentCircleTypeListBinding p = this$0.p();
            if (p != null && (smartRefreshLayout = p.f18842c) != null) {
                smartRefreshLayout.i();
            }
        }
        CircleNewListAdapter circleNewListAdapter3 = this$0.e;
        CircleNewListAdapter circleNewListAdapter4 = circleNewListAdapter3;
        if (circleNewListAdapter3 == null) {
            Intrinsics.c("circleListAdapter");
            circleNewListAdapter4 = null;
        }
        CircleTypeListAdapter circleTypeListAdapter7 = this$0.f;
        CircleTypeListAdapter circleTypeListAdapter8 = circleTypeListAdapter7;
        if (circleTypeListAdapter7 == null) {
            Intrinsics.c("circleTypeListAdapter");
            circleTypeListAdapter8 = null;
        }
        CircleTypeModel.DataBean b3 = circleTypeListAdapter8.b(i);
        Integer valueOf = b3 == null ? null : Integer.valueOf(b3.id);
        circleNewListAdapter4.a(valueOf == null ? -1 : valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleTypeListFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        CircleTypeListViewModel j = this$0.j();
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(CircleTypeListModel circleTypeListModel) {
        CircleNewListAdapter circleNewListAdapter = this.e;
        CircleNewListAdapter circleNewListAdapter2 = circleNewListAdapter;
        if (circleNewListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleNewListAdapter2 = null;
        }
        circleNewListAdapter2.setNewData(circleTypeListModel.getCircleList());
        if (j().k()) {
            r();
            j().c(false);
        }
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_MORE_LIST_SHOW, j().d(), j().i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends CircleTypeModel.DataBean> list) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        if (list.isEmpty()) {
            FragmentCircleTypeListBinding p = p();
            if (p == null || (noDataAndLoadFailView = p.b) == null) {
                return;
            }
            noDataAndLoadFailView.a();
            return;
        }
        CircleTypeListAdapter circleTypeListAdapter = this.f;
        CircleTypeListAdapter circleTypeListAdapter2 = circleTypeListAdapter;
        if (circleTypeListAdapter == null) {
            Intrinsics.c("circleTypeListAdapter");
            circleTypeListAdapter2 = null;
        }
        circleTypeListAdapter2.setNewData(list);
        this.g = list;
        int i = 0;
        j().a(list.get(0).id);
        for (CircleTypeModel.DataBean dataBean : this.g) {
            if (i < 0) {
                CollectionsKt.c();
            }
            CircleTypeModel.DataBean dataBean2 = dataBean;
            if (dataBean2.id == j().e()) {
                j().a(dataBean2.id);
                CircleTypeListAdapter circleTypeListAdapter3 = this.f;
                CircleTypeListAdapter circleTypeListAdapter4 = circleTypeListAdapter3;
                if (circleTypeListAdapter3 == null) {
                    Intrinsics.c("circleTypeListAdapter");
                    circleTypeListAdapter4 = null;
                }
                circleTypeListAdapter4.a(i);
                CircleTypeListAdapter circleTypeListAdapter5 = this.f;
                CircleTypeListAdapter circleTypeListAdapter6 = circleTypeListAdapter5;
                if (circleTypeListAdapter5 == null) {
                    Intrinsics.c("circleTypeListAdapter");
                    circleTypeListAdapter6 = null;
                }
                circleTypeListAdapter6.notifyDataSetChanged();
            }
            i++;
        }
        CircleTypeListViewModel j = j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CircleTypeListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.j().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        if (z) {
            FragmentCircleTypeListBinding p = p();
            if (p == null || (noDataAndLoadFailView = p.b) == null) {
                return;
            }
            noDataAndLoadFailView.d();
            return;
        }
        FragmentCircleTypeListBinding p2 = p();
        if (p2 == null || (noDataAndLoadFailView2 = p2.b) == null) {
            return;
        }
        noDataAndLoadFailView2.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CircleTypeListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.j().n();
    }

    private final FragmentCircleTypeListBinding p() {
        return (FragmentCircleTypeListBinding) this.f19308c.b(this, b[0]);
    }

    private final void q() {
        FragmentCircleTypeListBinding p = p();
        j().p().setRvLocation(ViewUtils.a(p == null ? null : p.f18841a));
    }

    private final void r() {
        FragmentCircleTypeListBinding p = p();
        ViewUtils.a(p == null ? null : p.f18841a, j().p().getRvLocation());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void a(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentCircleTypeListBinding p = p();
        if (p != null && (smartRefreshLayout = p.f18842c) != null) {
            smartRefreshLayout.j();
        }
        CircleNewListAdapter circleNewListAdapter = this.e;
        CircleNewListAdapter circleNewListAdapter2 = circleNewListAdapter;
        if (circleNewListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleNewListAdapter2 = null;
        }
        circleNewListAdapter2.loadMoreComplete();
        if (z) {
            NoDataAndLoadFailView noDataAndLoadFailView = this.d;
            if (noDataAndLoadFailView == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView = null;
            }
            noDataAndLoadFailView.a();
            return;
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.d;
        if (noDataAndLoadFailView2 == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView2 = null;
        }
        noDataAndLoadFailView2.b();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FragmentCircleTypeListBinding p = p();
        if (p != null) {
            p.d.a();
            CommonTopTitleNoTrans commonTopTitleNoTrans = p.d;
            Context context = getContext();
            Intrinsics.a(context);
            commonTopTitleNoTrans.setCenterText(context.getResources().getString(R.string.more_circle_title));
            p.d.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleTypeListFragment$0u3rXQUFfecZlL-R9E0B1hTaG6E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleTypeListFragment.a(CircleTypeListFragment.this, view);
                }
            });
            Context context2 = getContext();
            Intrinsics.a(context2);
            Intrinsics.c(context2, "context!!");
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            this.e = new CircleNewListAdapter(context2, fragmentActive);
            NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
            this.d = noDataAndLoadFailView;
            NoDataAndLoadFailView noDataAndLoadFailView2 = noDataAndLoadFailView;
            if (noDataAndLoadFailView == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView2 = null;
            }
            noDataAndLoadFailView2.setNoDataImg(R.drawable.icon_no_circle);
            NoDataAndLoadFailView noDataAndLoadFailView3 = this.d;
            NoDataAndLoadFailView noDataAndLoadFailView4 = noDataAndLoadFailView3;
            if (noDataAndLoadFailView3 == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView4 = null;
            }
            noDataAndLoadFailView4.setNoDataStr(R.string.no_new_circle_yet);
            NoDataAndLoadFailView noDataAndLoadFailView5 = this.d;
            NoDataAndLoadFailView noDataAndLoadFailView6 = noDataAndLoadFailView5;
            if (noDataAndLoadFailView5 == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView6 = null;
            }
            noDataAndLoadFailView6.setBtnStr(R.string.community_retry);
            NoDataAndLoadFailView noDataAndLoadFailView7 = this.d;
            NoDataAndLoadFailView noDataAndLoadFailView8 = noDataAndLoadFailView7;
            if (noDataAndLoadFailView7 == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView8 = null;
            }
            noDataAndLoadFailView8.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleTypeListFragment$4heZs2ZUkjQLYCpxxMlhvyWQIH4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleTypeListFragment.b(CircleTypeListFragment.this, view);
                }
            });
            NoDataAndLoadFailView noDataAndLoadFailView9 = this.d;
            NoDataAndLoadFailView noDataAndLoadFailView10 = noDataAndLoadFailView9;
            if (noDataAndLoadFailView9 == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView10 = null;
            }
            noDataAndLoadFailView10.d();
            CircleNewListAdapter circleNewListAdapter = this.e;
            CircleNewListAdapter circleNewListAdapter2 = circleNewListAdapter;
            if (circleNewListAdapter == null) {
                Intrinsics.c("circleListAdapter");
                circleNewListAdapter2 = null;
            }
            NoDataAndLoadFailView noDataAndLoadFailView11 = this.d;
            NoDataAndLoadFailView noDataAndLoadFailView12 = noDataAndLoadFailView11;
            if (noDataAndLoadFailView11 == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView12 = null;
            }
            circleNewListAdapter2.setEmptyView(noDataAndLoadFailView12);
            p.f18842c.l(false);
            p.f18842c.a(new OnRefreshListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleTypeListFragment$pSWZ8gRdIXJpw58hrAV56G2am1I
                @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
                public final void onRefresh(RefreshLayout refreshLayout) {
                    CircleTypeListFragment.a(CircleTypeListFragment.this, refreshLayout);
                }
            });
            CircleNewListAdapter circleNewListAdapter3 = this.e;
            CircleNewListAdapter circleNewListAdapter4 = circleNewListAdapter3;
            if (circleNewListAdapter3 == null) {
                Intrinsics.c("circleListAdapter");
                circleNewListAdapter4 = null;
            }
            circleNewListAdapter4.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleTypeListFragment$9gc7hgsIIaxnXdTFQpuB3Lri-78
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
                public final void onLoadMoreRequested() {
                    CircleTypeListFragment.a(CircleTypeListFragment.this);
                }
            }, p.f18841a);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            RecyclerView recyclerView = p.f18841a;
            CircleNewListAdapter circleNewListAdapter5 = this.e;
            CircleNewListAdapter circleNewListAdapter6 = circleNewListAdapter5;
            if (circleNewListAdapter5 == null) {
                Intrinsics.c("circleListAdapter");
                circleNewListAdapter6 = null;
            }
            recyclerView.setAdapter(circleNewListAdapter6);
            p.f18841a.setLayoutManager(linearLayoutManager);
            Context context3 = getContext();
            Intrinsics.a(context3);
            Intrinsics.c(context3, "context!!");
            ActivityFragmentActive fragmentActive2 = getFragmentActive();
            Intrinsics.c(fragmentActive2, "fragmentActive");
            this.f = new CircleTypeListAdapter(context3, fragmentActive2);
            p.b.setNoDataImg(R.drawable.icon_no_circle);
            p.b.setNoDataStr(R.string.no_new_circle_yet);
            p.b.setBtnStr(R.string.community_retry);
            p.b.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleTypeListFragment$Rt1wt-ebNPeMMIfx68mXOTsDWRY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleTypeListFragment.c(CircleTypeListFragment.this, view);
                }
            });
            p.b.d();
            RecyclerView recyclerView2 = p.e;
            CircleTypeListAdapter circleTypeListAdapter = this.f;
            CircleTypeListAdapter circleTypeListAdapter2 = circleTypeListAdapter;
            if (circleTypeListAdapter == null) {
                Intrinsics.c("circleTypeListAdapter");
                circleTypeListAdapter2 = null;
            }
            recyclerView2.setAdapter(circleTypeListAdapter2);
            p.e.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        CircleTypeListAdapter circleTypeListAdapter3 = this.f;
        if (circleTypeListAdapter3 == null) {
            Intrinsics.c("circleTypeListAdapter");
            circleTypeListAdapter3 = null;
        }
        circleTypeListAdapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleTypeListFragment$cJr5AkhkEbbgRUJgl2VZplpEtXs
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CircleTypeListFragment.a(CircleTypeListFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        CircleTypeListFragment circleTypeListFragment = this;
        LifecycleExtKt.a(circleTypeListFragment, j().f(), new CircleTypeListFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(circleTypeListFragment, j().g(), new CircleTypeListFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(circleTypeListFragment, j().h(), new CircleTypeListFragment$liveDataObserver$3(this));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void n() {
        CircleNewListAdapter circleNewListAdapter = this.e;
        CircleNewListAdapter circleNewListAdapter2 = circleNewListAdapter;
        if (circleNewListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleNewListAdapter2 = null;
        }
        circleNewListAdapter2.setEnableLoadMore(true);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void o() {
        CircleNewListAdapter circleNewListAdapter = this.e;
        CircleNewListAdapter circleNewListAdapter2 = circleNewListAdapter;
        if (circleNewListAdapter == null) {
            Intrinsics.c("circleListAdapter");
            circleNewListAdapter2 = null;
        }
        circleNewListAdapter2.setEnableLoadMore(false);
    }
}
