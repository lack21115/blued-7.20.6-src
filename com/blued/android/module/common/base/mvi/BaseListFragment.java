package com.blued.android.module.common.base.mvi;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BaseListFragment.class */
public abstract class BaseListFragment<VM extends BaseListViewModel<M>, M> extends MVIBaseFragment<VM> {
    private SmartRefreshLayout b;
    private RecyclerView c;
    private CommonTopTitleNoTrans d;
    private NoDataAndLoadFailView e;
    private FrameLayout f;
    private final Lazy g;
    private final Lazy h;

    public BaseListFragment() {
        super(R.layout.fm_base_list);
        this.g = LazyKt.a(new Function0<ListConfig>(this) { // from class: com.blued.android.module.common.base.mvi.BaseListFragment$mListConfig$2
            final /* synthetic */ BaseListFragment<VM, M> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.a = this;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final ListConfig invoke() {
                return this.a.h();
            }
        });
        this.h = LazyKt.a(new Function0<BaseQuickAdapter<M, BaseViewHolder>>(this) { // from class: com.blued.android.module.common.base.mvi.BaseListFragment$mAdapter$2
            final /* synthetic */ BaseListFragment<VM, M> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.a = this;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final BaseQuickAdapter<M, BaseViewHolder> invoke() {
                return this.a.i();
            }
        });
    }

    public BaseListFragment(int i) {
        super(i);
        this.g = LazyKt.a(new Function0<ListConfig>(this) { // from class: com.blued.android.module.common.base.mvi.BaseListFragment$mListConfig$2
            final /* synthetic */ BaseListFragment<VM, M> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.a = this;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final ListConfig invoke() {
                return this.a.h();
            }
        });
        this.h = LazyKt.a(new Function0<BaseQuickAdapter<M, BaseViewHolder>>(this) { // from class: com.blued.android.module.common.base.mvi.BaseListFragment$mAdapter$2
            final /* synthetic */ BaseListFragment<VM, M> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.a = this;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final BaseQuickAdapter<M, BaseViewHolder> invoke() {
                return this.a.i();
            }
        });
    }

    private final void C() {
        this.b = requireView().findViewById(R.id.refreshLayout);
        this.c = requireView().findViewById(R.id.recyclerView);
        this.d = (CommonTopTitleNoTrans) requireView().findViewById(R.id.title);
        this.e = (NoDataAndLoadFailView) requireView().findViewById(R.id.noDataView);
        this.f = (FrameLayout) requireView().findViewById(R.id.frame_layout);
    }

    private final void D() {
        RecyclerView recyclerView = this.c;
        RecyclerView.ItemAnimator itemAnimator = recyclerView == null ? null : recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
        }
        RecyclerView recyclerView2 = this.c;
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView2 == null ? null : recyclerView2.getItemAnimator();
        if (itemAnimator2 != null) {
            itemAnimator2.setChangeDuration(0L);
        }
        RecyclerView recyclerView3 = this.c;
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView3 == null ? null : recyclerView3.getItemAnimator();
        if (itemAnimator3 != null) {
            itemAnimator3.setMoveDuration(0L);
        }
        RecyclerView recyclerView4 = this.c;
        RecyclerView.ItemAnimator itemAnimator4 = recyclerView4 == null ? null : recyclerView4.getItemAnimator();
        if (itemAnimator4 != null) {
            itemAnimator4.setRemoveDuration(0L);
        }
        RecyclerView recyclerView5 = this.c;
        RecyclerView.ItemAnimator itemAnimator5 = recyclerView5 == null ? null : recyclerView5.getItemAnimator();
        if (itemAnimator5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        }
        itemAnimator5.setSupportsChangeAnimations(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseListFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().setUpFetching(true);
        BluedStructureExtKt.a(this$0, BaseListAction.LoadMoreData.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseListFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        BluedStructureExtKt.a(this$0, BaseListAction.RefreshData.a);
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseListFragment this$0, List it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        this$0.f().addData(0, it);
    }

    private final void a(final List<? extends M> list) {
        boolean z = false;
        if (((BaseListViewModel) y()).getMPage() != 1) {
            List<? extends M> list2 = list;
            boolean z2 = true;
            if (list2 != null) {
                z2 = list2.isEmpty();
            }
            if (z2) {
                q();
                return;
            } else if (e().f() == ListConfig.LoadMoreModel.PULL_UP) {
                f().addData(list2);
                return;
            } else {
                RecyclerView recyclerView = this.c;
                if (recyclerView == null) {
                    return;
                }
                if (recyclerView.isComputingLayout()) {
                    recyclerView.post(new Runnable() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$LOJh43PjJIWr1s73gg1MIb-YAjE
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseListFragment.a(BaseListFragment.this, list);
                        }
                    });
                    return;
                } else {
                    f().addData(0, list2);
                    return;
                }
            }
        }
        f().setNewData(list);
        List data = f().getData();
        if (data == null || data.isEmpty()) {
            z = true;
        }
        if (z) {
            s();
        } else if (e().f() == ListConfig.LoadMoreModel.PULL_UP) {
            if (e().c()) {
                f().disableLoadMoreIfNotFullPage();
            }
        } else {
            RecyclerView recyclerView2 = this.c;
            if (recyclerView2 != null) {
                recyclerView2.scrollToPosition(f().getData().size() - 1);
            }
            if (e().c()) {
                f().setUpFetchEnable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BaseListFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        BluedStructureExtKt.a(this$0, BaseListAction.LoadMoreData.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BaseListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        BluedStructureExtKt.a(this$0, BaseListAction.RefreshData.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(BaseListFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().loadMoreEnd(true);
    }

    public final RecyclerView a() {
        return this.c;
    }

    protected final void a(RecyclerView recyclerView) {
        this.c = recyclerView;
    }

    protected final void a(NoDataAndLoadFailView noDataAndLoadFailView) {
        this.e = noDataAndLoadFailView;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void a(boolean z, boolean z2) {
        if (e().g()) {
            DialogUtils.b(t());
        }
        NoDataAndLoadFailView noDataAndLoadFailView = this.e;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.d();
        }
        SmartRefreshLayout smartRefreshLayout = this.b;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.g();
        }
        f().setUpFetching(false);
        if (z) {
            if (e().f() == ListConfig.LoadMoreModel.PULL_UP && e().c()) {
                f().loadMoreComplete();
            }
            s();
            if (z2) {
                p();
            } else {
                q();
            }
        } else if (((BaseListViewModel) y()).getMPage() > 1) {
            if (e().f() == ListConfig.LoadMoreModel.PULL_UP) {
                f().loadMoreFail();
            }
            BaseListViewModel baseListViewModel = (BaseListViewModel) y();
            baseListViewModel.setMPage(baseListViewModel.getMPage() - 1);
        } else {
            NoDataAndLoadFailView noDataAndLoadFailView2 = this.e;
            if (noDataAndLoadFailView2 == null) {
                return;
            }
            noDataAndLoadFailView2.b();
        }
    }

    public final CommonTopTitleNoTrans b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final NoDataAndLoadFailView c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FrameLayout d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ListConfig e() {
        return (ListConfig) this.g.getValue();
    }

    public final BaseQuickAdapter<M, BaseViewHolder> f() {
        return (BaseQuickAdapter) this.h.getValue();
    }

    protected LinearLayoutManager g() {
        return new LinearLayoutManager(getContext());
    }

    public ListConfig h() {
        return new ListConfig();
    }

    public abstract BaseQuickAdapter<M, BaseViewHolder> i();

    public void j() {
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    protected void k() {
        if (e().a()) {
            BluedStructureExtKt.a(this, BaseListAction.RefreshData.a);
        }
    }

    public void l() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        C();
        j();
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(g());
        }
        D();
        CommonTopTitleNoTrans commonTopTitleNoTrans = this.d;
        if (commonTopTitleNoTrans != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$607EoX2OiKHXtLDF5Zg8GgzfRhI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseListFragment.a(BaseListFragment.this, view);
                }
            });
        }
        NoDataAndLoadFailView noDataAndLoadFailView = this.e;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$cnXSnIsTHavcFaTQKmA4z2d-bV8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseListFragment.b(BaseListFragment.this, view);
                }
            });
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.e;
        if (noDataAndLoadFailView2 != null) {
            noDataAndLoadFailView2.d();
        }
        if (e().e()) {
            CommonTopTitleNoTrans commonTopTitleNoTrans2 = this.d;
            if (commonTopTitleNoTrans2 != null) {
                commonTopTitleNoTrans2.setVisibility(0);
            }
        } else {
            CommonTopTitleNoTrans commonTopTitleNoTrans3 = this.d;
            if (commonTopTitleNoTrans3 != null) {
                commonTopTitleNoTrans3.setVisibility(8);
            }
        }
        f().registerAdapterDataObserver(new BaseListFragment$initView$3(this));
        SmartRefreshLayout smartRefreshLayout = this.b;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.b(false);
        }
        f().bindToRecyclerView(this.c);
        if (e().f() == ListConfig.LoadMoreModel.PULL_DOWN) {
            SmartRefreshLayout smartRefreshLayout2 = this.b;
            if (smartRefreshLayout2 != null) {
                smartRefreshLayout2.c(false);
            }
            f().setEnableLoadMore(false);
            f().setUpFetchListener(new BaseQuickAdapter.UpFetchListener() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$BJwYUaie34WpfqFXxFXGO-VrS9Y
                public final void onUpFetch() {
                    BaseListFragment.a(BaseListFragment.this);
                }
            });
        } else {
            SmartRefreshLayout smartRefreshLayout3 = this.b;
            if (smartRefreshLayout3 != null) {
                smartRefreshLayout3.c(e().b());
            }
            SmartRefreshLayout smartRefreshLayout4 = this.b;
            if (smartRefreshLayout4 != null) {
                smartRefreshLayout4.a(new OnRefreshListener() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$yszLUnPX5O7JdwKop3sqm8H_vVE
                    public final void onRefresh(RefreshLayout refreshLayout) {
                        BaseListFragment.a(BaseListFragment.this, refreshLayout);
                    }
                });
            }
            f().setLoadMoreView(new BluedAdapterLoadMoreView());
            if (e().c()) {
                f().setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$z2JtNIFceH3exnVs2aSV8mXdnmY
                    public final void onLoadMoreRequested() {
                        BaseListFragment.b(BaseListFragment.this);
                    }
                }, this.c);
            }
            f().setEnableLoadMore(e().c());
        }
        ((BaseListViewModel) y()).setMPage(e().d());
        RecyclerView recyclerView2 = this.c;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(f());
    }

    public void n() {
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void onEvent(UiEvent event) {
        Intrinsics.e(event, "event");
        super.onEvent(event);
        if (event instanceof MviEvent.LoadData) {
            List<? extends M> a = ((MviEvent.LoadData) event).a();
            if (a == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<M of com.blued.android.module.common.base.mvi.BaseListFragment>");
            }
            a(a);
        }
    }

    public void p() {
        if (e().c()) {
            if (e().f() == ListConfig.LoadMoreModel.PULL_UP) {
                f().setEnableLoadMore(true);
            } else {
                f().setUpFetchEnable(true);
            }
        }
    }

    public void q() {
        if (e().c()) {
            if (e().f() == ListConfig.LoadMoreModel.PULL_UP) {
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$6Ri__XYgl8eKpVunsD8PeLpiZcs
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseListFragment.c(BaseListFragment.this);
                    }
                }, 60L);
            } else {
                f().setUpFetchEnable(false);
            }
        }
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void r() {
        if (e().g()) {
            DialogUtils.a(t());
        }
    }

    public void s() {
        NoDataAndLoadFailView noDataAndLoadFailView;
        List data = f().getData();
        if (!(data == null || data.isEmpty()) || (noDataAndLoadFailView = this.e) == null) {
            return;
        }
        noDataAndLoadFailView.a();
    }
}
