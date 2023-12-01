package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.adapter.RecommendGroupAdapter;
import com.soft.blued.ui.msg_group.event.RecommendRefreshEvent;
import com.soft.blued.ui.msg_group.event.ScrollEvent;
import com.soft.blued.ui.msg_group.viewmodel.GroupRecommendViewModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/RecommendGroupFragment.class */
public final class RecommendGroupFragment extends BaseListFragment<GroupRecommendViewModel, GroupInfoModel> {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private boolean f32772c;
    private RecommendType d;
    private NoDataAndLoadFailView e;
    private boolean f;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/RecommendGroupFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, RecommendGroupFragment.class, null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/RecommendGroupFragment$RecommendType.class */
    public enum RecommendType {
        NEARBY,
        RECOMMEND
    }

    public RecommendGroupFragment() {
        this.f32772c = true;
        this.d = RecommendType.NEARBY;
        this.f = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendGroupFragment(RecommendType type) {
        this();
        Intrinsics.e(type, "type");
        this.f32772c = false;
        this.d = type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecommendGroupFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = (GroupInfoModel) obj;
        boolean z = true;
        if (groupInfoModel.allow_join != 1 || view.getId() != 2131370829) {
            z = false;
        }
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_CLICK, groupInfoModel.label, this$0.d == RecommendType.RECOMMEND ? SocialNetWorkProtos.SourceType.RECOMMEND : SocialNetWorkProtos.SourceType.NEARBY, String.valueOf(groupInfoModel.group_id));
        GroupInfoFragment.a(this$0.getContext(), groupInfoModel.group_id + "", groupInfoModel, SocialNetWorkProtos.SourceType.MYGROUP, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecommendGroupFragment this$0, RecommendRefreshEvent recommendRefreshEvent) {
        Intrinsics.e(this$0, "this$0");
        if (recommendRefreshEvent.getType() == ((GroupRecommendViewModel) this$0.y()).getType()) {
            BluedStructureExtKt.a(this$0, BaseListAction.RefreshData.f10668a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecommendGroupFragment this$0, ScrollEvent scrollEvent) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(scrollEvent.a());
    }

    private final void a(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public GridLayoutManager g() {
        final Context context = getContext();
        return new GridLayoutManager(context) { // from class: com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment$getLayoutManager$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                boolean z;
                z = RecommendGroupFragment.this.f;
                return z;
            }
        };
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: D */
    public RecommendGroupAdapter i() {
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new RecommendGroupAdapter(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void a(boolean z, boolean z2) {
        super.a(z, z2);
        NoDataAndLoadFailView noDataAndLoadFailView = this.e;
        NoDataAndLoadFailView noDataAndLoadFailView2 = noDataAndLoadFailView;
        if (noDataAndLoadFailView == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView2 = null;
        }
        if (noDataAndLoadFailView2.getVisibility() == 8) {
            NoDataAndLoadFailView noDataAndLoadFailView3 = this.e;
            if (noDataAndLoadFailView3 == null) {
                Intrinsics.c("noDataView");
                noDataAndLoadFailView3 = null;
            }
            noDataAndLoadFailView3.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().b(false).d(this.f32772c).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void j() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.e = noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2 = noDataAndLoadFailView;
        if (noDataAndLoadFailView == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView2 = null;
        }
        noDataAndLoadFailView2.a();
        NoDataAndLoadFailView noDataAndLoadFailView3 = this.e;
        NoDataAndLoadFailView noDataAndLoadFailView4 = noDataAndLoadFailView3;
        if (noDataAndLoadFailView3 == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView4 = null;
        }
        noDataAndLoadFailView4.d();
        BaseQuickAdapter<GroupInfoModel, BaseViewHolder> f = f();
        NoDataAndLoadFailView noDataAndLoadFailView5 = this.e;
        if (noDataAndLoadFailView5 == null) {
            Intrinsics.c("noDataView");
            noDataAndLoadFailView5 = null;
        }
        f.setEmptyView(noDataAndLoadFailView5);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        FrameLayout d = d();
        if (d != null) {
            d.setBackgroundResource(2131102360);
        }
        RecyclerView a2 = a();
        if (a2 != null) {
            a2.setPadding(BluedViewExtKt.a(5), BluedViewExtKt.a(5), BluedViewExtKt.a(5), BluedViewExtKt.a(5));
        }
        RecyclerView a3 = a();
        if (a3 != null) {
            a3.setClipToPadding(false);
        }
        CommonTopTitleNoTrans b2 = b();
        String str = null;
        TextView centerTextView = b2 == null ? null : b2.getCenterTextView();
        if (centerTextView != null) {
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.group_nearby_group_list);
            }
            centerTextView.setText(str);
        }
        f().setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$RecommendGroupFragment$wv49NM8a4ydOvQg0gdv__61-zmU
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RecommendGroupFragment.a(RecommendGroupFragment.this, baseQuickAdapter, view, i);
            }
        });
        if (f() instanceof RecommendGroupAdapter) {
            ((RecommendGroupAdapter) f()).a(this.d);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        super.o();
        RecommendGroupFragment recommendGroupFragment = this;
        LiveEventBus.get("group_refresh_recommend_List", RecommendRefreshEvent.class).observe(recommendGroupFragment, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$RecommendGroupFragment$64KkJjuwFHly71LYcHL3xVMLiUI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendGroupFragment.a(RecommendGroupFragment.this, (RecommendRefreshEvent) obj);
            }
        });
        LiveEventBus.get("group_recommend_List_scroll", ScrollEvent.class).observe(recommendGroupFragment, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$RecommendGroupFragment$HpS11UPMR1w5fGCCwDVAHwUYST8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendGroupFragment.a(RecommendGroupFragment.this, (ScrollEvent) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("type")) {
            GroupRecommendViewModel groupRecommendViewModel = (GroupRecommendViewModel) y();
            Serializable serializable = bundle.getSerializable("type");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment.RecommendType");
            }
            groupRecommendViewModel.a((RecommendType) serializable);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.e(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putSerializable("type", ((GroupRecommendViewModel) y()).getType());
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void v() {
        super.v();
        ((GroupRecommendViewModel) y()).a(this.d);
    }
}
