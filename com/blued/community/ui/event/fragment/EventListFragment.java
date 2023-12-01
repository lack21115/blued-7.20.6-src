package com.blued.community.ui.event.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.BlueAppLocal;
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
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.FragmentEventListBinding;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.adapter.EventListAdapter;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.vm.EventListViewModel;
import com.blued.community.ui.send.fragment.EventAddPostFragment;
import com.blued.community.utils.CityHelper;
import com.blued.community.view.FloatFooterView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventListFragment.class */
public final class EventListFragment extends MVVMBaseFragment<EventListViewModel> {
    private final ViewBindingProperty c;
    private EventListAdapter d;
    private boolean e;
    private View f;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(EventListFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentEventListBinding;", 0))};
    public static final Companion a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, EventListFragment.class, null);
        }
    }

    public EventListFragment() {
        super(R.layout.fragment_event_list);
        this.c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<EventListFragment, FragmentEventListBinding>() { // from class: com.blued.community.ui.event.fragment.EventListFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventListBinding invoke(EventListFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventListBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<EventListFragment, FragmentEventListBinding>() { // from class: com.blued.community.ui.event.fragment.EventListFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventListBinding invoke(EventListFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventListBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventListFragment this$0, EventDetailsModel eventDetailsModel) {
        Intrinsics.e(this$0, "this$0");
        this$0.j().a(true, this$0.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventListFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        EventListAdapter eventListAdapter = this$0.d;
        EventListAdapter eventListAdapter2 = eventListAdapter;
        if (eventListAdapter == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter2 = null;
        }
        int size = eventListAdapter2.getData().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            EventListAdapter eventListAdapter3 = this$0.d;
            EventListAdapter eventListAdapter4 = eventListAdapter3;
            if (eventListAdapter3 == null) {
                Intrinsics.c("eventListAdapter");
                eventListAdapter4 = null;
            }
            if (str.equals(((EventDetailsModel) eventListAdapter4.getData().get(i2)).id)) {
                EventListAdapter eventListAdapter5 = this$0.d;
                EventListAdapter eventListAdapter6 = eventListAdapter5;
                if (eventListAdapter5 == null) {
                    Intrinsics.c("eventListAdapter");
                    eventListAdapter6 = null;
                }
                ((EventDetailsModel) eventListAdapter6.getData().get(i2)).is_sign_in = 1;
                EventListAdapter eventListAdapter7 = this$0.d;
                if (eventListAdapter7 == null) {
                    Intrinsics.c("eventListAdapter");
                    eventListAdapter7 = null;
                }
                eventListAdapter7.notifyItemChanged(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends EventDetailsModel> list) {
        FloatFooterView floatFooterView;
        NoDataAndLoadFailView noDataAndLoadFailView;
        if (list.isEmpty()) {
            FragmentEventListBinding p = p();
            NoDataAndLoadFailView noDataAndLoadFailView2 = p == null ? null : p.b;
            if (noDataAndLoadFailView2 != null) {
                noDataAndLoadFailView2.setVisibility(0);
            }
            FragmentEventListBinding p2 = p();
            if (p2 != null && (noDataAndLoadFailView = p2.b) != null) {
                noDataAndLoadFailView.a();
            }
            FragmentEventListBinding p3 = p();
            if (p3 != null && (floatFooterView = p3.a) != null) {
                floatFooterView.startBtmBtnShow();
            }
        } else {
            FragmentEventListBinding p4 = p();
            NoDataAndLoadFailView noDataAndLoadFailView3 = p4 == null ? null : p4.b;
            if (noDataAndLoadFailView3 != null) {
                noDataAndLoadFailView3.setVisibility(8);
            }
        }
        EventListAdapter eventListAdapter = this.d;
        if (eventListAdapter == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter = null;
        }
        eventListAdapter.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventListFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        EventAddPostFragment.a.a(context);
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_AGG_PAGE_PUBLISH_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        MineEventFragment.a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        List data;
        EventListAdapter eventListAdapter = null;
        if (z) {
            EventListAdapter eventListAdapter2 = this.d;
            if (eventListAdapter2 == null) {
                Intrinsics.c("eventListAdapter");
            } else {
                eventListAdapter = eventListAdapter2;
            }
            eventListAdapter.removeAllHeaderView();
            return;
        }
        EventListAdapter eventListAdapter3 = this.d;
        EventListAdapter eventListAdapter4 = eventListAdapter3;
        if (eventListAdapter3 == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter4 = null;
        }
        Intrinsics.c(eventListAdapter4.getData(), "eventListAdapter.data");
        if (!(!data.isEmpty())) {
            EventListAdapter eventListAdapter5 = this.d;
            if (eventListAdapter5 == null) {
                Intrinsics.c("eventListAdapter");
                eventListAdapter5 = null;
            }
            eventListAdapter5.removeAllHeaderView();
            return;
        }
        EventListAdapter eventListAdapter6 = this.d;
        EventListAdapter eventListAdapter7 = eventListAdapter6;
        if (eventListAdapter6 == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter7 = null;
        }
        if (eventListAdapter7.getHeaderLayoutCount() == 0) {
            View inflate = View.inflate(getContext(), R.layout.layout_event_list_header, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_city_info);
            if (BlueAppLocal.d()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String string = requireContext().getString(R.string.event_nearby_cities_no_event);
                Intrinsics.c(string, "requireContext().getStri…t_nearby_cities_no_event)");
                String format = String.format(string, Arrays.copyOf(new Object[]{CityHelper.a().c(requireContext())}, 1));
                Intrinsics.c(format, "format(format, *args)");
                textView.setText(format);
            } else {
                textView.setText(R.string.event_nearby_cities_no_event);
            }
            EventListAdapter eventListAdapter8 = this.d;
            if (eventListAdapter8 == null) {
                Intrinsics.c("eventListAdapter");
                eventListAdapter8 = null;
            }
            eventListAdapter8.addHeaderView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.j().a(true, this$0.getFragmentActive());
    }

    private final FragmentEventListBinding p() {
        return (FragmentEventListBinding) this.c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void a(boolean z) {
        super.a(z);
        FragmentEventListBinding p = p();
        if (p == null) {
            return;
        }
        p.d.g();
        EventListAdapter eventListAdapter = this.d;
        EventListAdapter eventListAdapter2 = eventListAdapter;
        if (eventListAdapter == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter2 = null;
        }
        eventListAdapter2.loadMoreComplete();
        if (z) {
            p.b.setVisibility(8);
            return;
        }
        p.b.setVisibility(0);
        p.b.b();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        Resources resources;
        Resources resources2;
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        ActivityFragmentActive activityFragmentActive = fragmentActive;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        EventListAdapter eventListAdapter = new EventListAdapter(activityFragmentActive, parentFragmentManager, this, 0, 8, null);
        this.d = eventListAdapter;
        EventListAdapter eventListAdapter2 = eventListAdapter;
        if (eventListAdapter == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter2 = null;
        }
        eventListAdapter2.a(true);
        View inflate = View.inflate(getContext(), R.layout.layout_load_more_end_footer, null);
        this.f = inflate;
        if (inflate != null) {
            inflate.setVisibility(8);
        }
        EventListAdapter eventListAdapter3 = this.d;
        EventListAdapter eventListAdapter4 = eventListAdapter3;
        if (eventListAdapter3 == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter4 = null;
        }
        eventListAdapter4.addFooterView(this.f);
        final FragmentEventListBinding p = p();
        if (p == null) {
            return;
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans = p.e;
        Context context = getContext();
        commonTopTitleNoTrans.setCenterText((context == null || (resources = context.getResources()) == null) ? null : resources.getString(R.string.event_events));
        CommonTopTitleNoTrans commonTopTitleNoTrans2 = p.e;
        Context context2 = getContext();
        commonTopTitleNoTrans2.setRightText((context2 == null || (resources2 = context2.getResources()) == null) ? null : resources2.getString(R.string.event_mine_events));
        p.e.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventListFragment$R0QX6_yqr7ZPF1wcdC2TC3sAzaQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventListFragment.a(EventListFragment.this, view);
            }
        });
        p.e.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventListFragment$7mrse-OYDjdm5_NudDedoCx4Nkg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventListFragment.b(EventListFragment.this, view);
            }
        });
        p.b.setFailBtnVisibility(0);
        p.b.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventListFragment$M9MF789cdFXI5vdS14dJ-FvkhDU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventListFragment.c(EventListFragment.this, view);
            }
        });
        p.c.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = p.c;
        RecyclerView.Adapter adapter = this.d;
        EventListAdapter eventListAdapter5 = adapter;
        if (adapter == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter5 = null;
        }
        recyclerView.setAdapter(eventListAdapter5);
        p.d.b(false);
        p.d.a(new OnRefreshListener() { // from class: com.blued.community.ui.event.fragment.EventListFragment$initView$1$4
            public void onRefresh(RefreshLayout refreshLayout) {
                EventListViewModel j;
                Intrinsics.e(refreshLayout, "refreshLayout");
                j = EventListFragment.this.j();
                j.a(true, EventListFragment.this.getFragmentActive());
            }
        });
        EventListAdapter eventListAdapter6 = this.d;
        if (eventListAdapter6 == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter6 = null;
        }
        eventListAdapter6.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.event.fragment.EventListFragment$initView$1$5
            public void onLoadMoreRequested() {
                EventListViewModel j;
                j = EventListFragment.this.j();
                j.a(false, EventListFragment.this.getFragmentActive());
            }
        }, p.c);
        if (CommunityServiceManager.a().x() == 1) {
            p.a.setVisibility(0);
        } else {
            p.a.setVisibility(8);
        }
        p.a.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventListFragment$NEzfrb231WuoFupGDaWBFry2HHQ
            public final void onPostFeedClick() {
                EventListFragment.b(EventListFragment.this);
            }
        });
        p.c.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.event.fragment.EventListFragment$initView$1$7
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                Intrinsics.e(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, i);
                FloatFooterView floatFooterView = FragmentEventListBinding.this.a;
                if (i == 0) {
                    if (!recyclerView2.canScrollVertically(-1)) {
                        floatFooterView.startBtmBtnShow();
                    } else if (recyclerView2.canScrollVertically(1)) {
                    } else {
                        floatFooterView.startBtmBtnHide();
                    }
                }
            }

            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.e(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, i, i2);
                FloatFooterView floatFooterView = FragmentEventListBinding.this.a;
                if (i2 < 0) {
                    floatFooterView.startBtmBtnShow();
                } else if (i2 > 0) {
                    floatFooterView.startBtmBtnHide();
                }
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        super.k();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SIGN_IN_SUCCESS", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventListFragment$tEwnx-TMoTuSIgAwoSVxkPl72yU
            public final void onChanged(Object obj) {
                EventListFragment.a(EventListFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_EVENT_APPLY_SUCC", EventDetailsModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventListFragment$Bo0mUl1RuVT1x_CR8ROOSTZujRY
            public final void onChanged(Object obj) {
                EventListFragment.a(EventListFragment.this, (EventDetailsModel) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LifecycleExtKt.a(lifecycleOwner, j().d(), new EventListFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(lifecycleOwner, j().f(), new EventListFragment$liveDataObserver$2(this));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void n() {
        super.n();
        EventListAdapter eventListAdapter = this.d;
        EventListAdapter eventListAdapter2 = eventListAdapter;
        if (eventListAdapter == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter2 = null;
        }
        eventListAdapter2.setEnableLoadMore(true);
        View view = this.f;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void o() {
        super.o();
        EventListAdapter eventListAdapter = this.d;
        EventListAdapter eventListAdapter2 = eventListAdapter;
        if (eventListAdapter == null) {
            Intrinsics.c("eventListAdapter");
            eventListAdapter2 = null;
        }
        eventListAdapter2.setEnableLoadMore(false);
        View view = this.f;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.e) {
            j().a(true, getFragmentActive());
            this.e = false;
        }
    }
}
