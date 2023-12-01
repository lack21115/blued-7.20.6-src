package com.blued.community.ui.square.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.databinding.FragmentHotFeedBinding;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.square.vm.HotFeedViewModel;
import com.blued.community.view.FloatFooterView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/HotFeedFragment.class */
public final class HotFeedFragment extends MVVMBaseFragment<HotFeedViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20142c;
    private final Lazy d;
    private final Lazy e;
    private View f;
    private final RecyclerView.OnScrollListener g;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(HotFeedFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentHotFeedBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20141a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/HotFeedFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, HotFeedFragment.class, null);
        }
    }

    public HotFeedFragment() {
        super(R.layout.fragment_hot_feed);
        this.f20142c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<HotFeedFragment, FragmentHotFeedBinding>() { // from class: com.blued.community.ui.square.fragment.HotFeedFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentHotFeedBinding invoke(HotFeedFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentHotFeedBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<HotFeedFragment, FragmentHotFeedBinding>() { // from class: com.blued.community.ui.square.fragment.HotFeedFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentHotFeedBinding invoke(HotFeedFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentHotFeedBinding.a(fragment.requireView());
            }
        });
        this.d = LazyKt.a(new Function0<NoDataAndLoadFailView>() { // from class: com.blued.community.ui.square.fragment.HotFeedFragment$noDataView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final NoDataAndLoadFailView invoke() {
                return new NoDataAndLoadFailView(HotFeedFragment.this.getContext());
            }
        });
        this.e = LazyKt.a(new Function0<FeedListAdapterForRecyclerView>() { // from class: com.blued.community.ui.square.fragment.HotFeedFragment$mAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final FeedListAdapterForRecyclerView invoke() {
                FragmentHotFeedBinding p;
                Context context = HotFeedFragment.this.getContext();
                HotFeedFragment hotFeedFragment = HotFeedFragment.this;
                HotFeedFragment hotFeedFragment2 = hotFeedFragment;
                p = hotFeedFragment.p();
                return new FeedListAdapterForRecyclerView(context, hotFeedFragment2, p == null ? null : p.b, 18);
            }
        });
        this.g = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.square.fragment.HotFeedFragment$onScrollListener$1
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
                r0 = r4.f20147a.p();
             */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r5, int r6) {
                /*
                    r4 = this;
                    r0 = r5
                    java.lang.String r1 = "recyclerView"
                    kotlin.jvm.internal.Intrinsics.e(r0, r1)
                    r0 = r4
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView r0 = com.blued.community.ui.square.fragment.HotFeedFragment.c(r0)
                    androidx.recyclerview.widget.RecyclerView$OnScrollListener r0 = r0.s
                    if (r0 == 0) goto L22
                    r0 = r4
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView r0 = com.blued.community.ui.square.fragment.HotFeedFragment.c(r0)
                    androidx.recyclerview.widget.RecyclerView$OnScrollListener r0 = r0.s
                    r1 = r5
                    r2 = r6
                    r0.onScrollStateChanged(r1, r2)
                L22:
                    r0 = r6
                    if (r0 != 0) goto L6d
                    r0 = r5
                    r1 = -1
                    boolean r0 = r0.canScrollVertically(r1)
                    if (r0 != 0) goto L4a
                    r0 = r4
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.databinding.FragmentHotFeedBinding r0 = com.blued.community.ui.square.fragment.HotFeedFragment.b(r0)
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L3b
                    return
                L3b:
                    r0 = r5
                    com.blued.community.view.FloatFooterView r0 = r0.f18888a
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L45
                    return
                L45:
                    r0 = r5
                    r0.startBtmBtnShow()
                    return
                L4a:
                    r0 = r5
                    r1 = 1
                    boolean r0 = r0.canScrollVertically(r1)
                    if (r0 != 0) goto L6d
                    r0 = r4
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.databinding.FragmentHotFeedBinding r0 = com.blued.community.ui.square.fragment.HotFeedFragment.b(r0)
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L5f
                    return
                L5f:
                    r0 = r5
                    com.blued.community.view.FloatFooterView r0 = r0.f18888a
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L69
                    return
                L69:
                    r0 = r5
                    r0.startBtmBtnHide()
                L6d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.square.fragment.HotFeedFragment$onScrollListener$1.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
                r0 = r5.f20147a.p();
             */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onScrolled(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
                /*
                    r5 = this;
                    r0 = r6
                    java.lang.String r1 = "recyclerView"
                    kotlin.jvm.internal.Intrinsics.e(r0, r1)
                    r0 = r5
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView r0 = com.blued.community.ui.square.fragment.HotFeedFragment.c(r0)
                    androidx.recyclerview.widget.RecyclerView$OnScrollListener r0 = r0.s
                    if (r0 == 0) goto L23
                    r0 = r5
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView r0 = com.blued.community.ui.square.fragment.HotFeedFragment.c(r0)
                    androidx.recyclerview.widget.RecyclerView$OnScrollListener r0 = r0.s
                    r1 = r6
                    r2 = r7
                    r3 = r8
                    r0.onScrolled(r1, r2, r3)
                L23:
                    r0 = r8
                    if (r0 >= 0) goto L43
                    r0 = r5
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.databinding.FragmentHotFeedBinding r0 = com.blued.community.ui.square.fragment.HotFeedFragment.b(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L34
                    return
                L34:
                    r0 = r6
                    com.blued.community.view.FloatFooterView r0 = r0.f18888a
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L3e
                    return
                L3e:
                    r0 = r6
                    r0.startBtmBtnShow()
                    return
                L43:
                    r0 = r8
                    if (r0 <= 0) goto L62
                    r0 = r5
                    com.blued.community.ui.square.fragment.HotFeedFragment r0 = com.blued.community.ui.square.fragment.HotFeedFragment.this
                    com.blued.community.databinding.FragmentHotFeedBinding r0 = com.blued.community.ui.square.fragment.HotFeedFragment.b(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L54
                    return
                L54:
                    r0 = r6
                    com.blued.community.view.FloatFooterView r0 = r0.f18888a
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L5e
                    return
                L5e:
                    r0 = r6
                    r0.startBtmBtnHide()
                L62:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.square.fragment.HotFeedFragment$onScrollListener$1.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HotFeedFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HotFeedFragment this$0, BluedIngSelfFeed bluedIngSelfFeed) {
        List<BluedIngSelfFeed> value;
        Intrinsics.e(this$0, "this$0");
        if (bluedIngSelfFeed == null || (value = this$0.a().d().getValue()) == null) {
            return;
        }
        value.remove(bluedIngSelfFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends BluedIngSelfFeed> list) {
        if (j().e() == 1) {
            r().setNewData(list);
        } else {
            r().addData((Collection<? extends BluedIngSelfFeed>) list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(HotFeedFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentHotFeedBinding p() {
        return (FragmentHotFeedBinding) this.f20142c.b(this, b[0]);
    }

    private final NoDataAndLoadFailView q() {
        return (NoDataAndLoadFailView) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedListAdapterForRecyclerView r() {
        return (FeedListAdapterForRecyclerView) this.e.getValue();
    }

    private final void s() {
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_PLAZA_HOT, false, "");
        FeedAddPostFragment.a(getContext());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void a(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentHotFeedBinding p = p();
        if (p != null && (smartRefreshLayout = p.f18889c) != null) {
            smartRefreshLayout.j();
        }
        r().loadMoreComplete();
        if (z) {
            q().a();
        } else {
            q().b();
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FragmentHotFeedBinding p = p();
        if (p == null) {
            return;
        }
        p.d.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$HotFeedFragment$7ohsBrpD9GYfJCwaBZ3dy7gXfco
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotFeedFragment.a(HotFeedFragment.this, view);
            }
        });
        p.f18888a.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$HotFeedFragment$mLipSc4-AKFBdO3h9dALeSDzc6U
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public final void onPostFeedClick() {
                HotFeedFragment.d(HotFeedFragment.this);
            }
        });
        r().setEmptyView(q());
        HotFeedFragment hotFeedFragment = this;
        FeedMethods.a(hotFeedFragment, r());
        CircleMethods.a(hotFeedFragment, r());
        LiveEventBus.get("feed_delete", BluedIngSelfFeed.class).observe(hotFeedFragment, new Observer() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$HotFeedFragment$l1LemhGr0lAJUl6FtyA4YXCRBEE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HotFeedFragment.a(HotFeedFragment.this, (BluedIngSelfFeed) obj);
            }
        });
        p.b.setAdapter(r());
        View inflate = View.inflate(getContext(), R.layout.layout_load_more_end_footer, null);
        this.f = inflate;
        if (inflate != null) {
            inflate.setVisibility(8);
        }
        r().addFooterView(this.f);
        p.b.setLayoutManager(new LinearLayoutManager(getContext()));
        p.b.addOnScrollListener(this.g);
        p.f18889c.l(false);
        p.f18889c.a(new OnRefreshListener() { // from class: com.blued.community.ui.square.fragment.HotFeedFragment$initView$1$4
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                HotFeedViewModel j;
                Intrinsics.e(refreshLayout, "refreshLayout");
                j = HotFeedFragment.this.j();
                ActivityFragmentActive fragmentActive = HotFeedFragment.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                j.b(fragmentActive);
            }
        });
        r().setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.square.fragment.HotFeedFragment$initView$1$5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                HotFeedViewModel j;
                j = HotFeedFragment.this.j();
                ActivityFragmentActive fragmentActive = HotFeedFragment.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                j.c(fragmentActive);
            }
        }, p.b);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        HotFeedViewModel j = j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive);
        HotFeedViewModel j2 = j();
        ActivityFragmentActive fragmentActive2 = getFragmentActive();
        Intrinsics.c(fragmentActive2, "fragmentActive");
        j2.b(fragmentActive2);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleExtKt.a(this, j().d(), new HotFeedFragment$liveDataObserver$1(this));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void n() {
        r().setEnableLoadMore(true);
        View view = this.f;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void o() {
        r().setEnableLoadMore(false);
        View view = this.f;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        r().e();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        r().d();
    }
}
