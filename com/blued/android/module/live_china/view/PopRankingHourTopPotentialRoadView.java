package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.PopWindowRankingListHourBinding;
import com.blued.android.module.live_china.fitem.FitemRankHour;
import com.blued.android.module.live_china.fitem.FitemRankHourFirstThree;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RankHourDataModel;
import com.blued.android.module.live_china.model.RankHourExtraModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingHourTopPotentialRoadView.class */
public final class PopRankingHourTopPotentialRoadView extends FrameLayout {
    private final Context a;
    private final BaseFragment b;
    private final IRequestHost c;
    private final int d;
    private final boolean e;
    private final Lazy f;
    private FreedomAdapter g;
    private ArrayList<FreedomItem> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopRankingHourTopPotentialRoadView(Context mContext, BaseFragment fragment, IRequestHost requestHost, int i, boolean z) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(requestHost, "requestHost");
        this.a = mContext;
        this.b = fragment;
        this.c = requestHost;
        this.d = i;
        this.e = z;
        this.f = LazyKt.a(new Function0<PopWindowRankingListHourBinding>() { // from class: com.blued.android.module.live_china.view.PopRankingHourTopPotentialRoadView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final PopWindowRankingListHourBinding invoke() {
                PopWindowRankingListHourBinding a = PopWindowRankingListHourBinding.a(LayoutInflater.from(PopRankingHourTopPotentialRoadView.this.getContext()).inflate(R.layout.pop_window_ranking_list_hour, PopRankingHourTopPotentialRoadView.this));
                Intrinsics.c(a, "bind(\n            Layout…ist_hour, this)\n        )");
                return a;
            }
        });
        this.h = new ArrayList<>();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourTopPotentialRoadView$m8CGeg6PrO6aSfi0WazSKMkLL_g
            @Override // java.lang.Runnable
            public final void run() {
                PopRankingHourTopPotentialRoadView.b(PopRankingHourTopPotentialRoadView.this);
            }
        }, 400L);
        if (this.e) {
            EventTrackLive.a(this.d == 1 ? LiveProtos.Event.LIVE_HOUR_LIST_TOP_TAB_SHOW : LiveProtos.Event.LIVE_HOUR_LIST_POTENTIAL_TAB_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(RankHourExtraModel rankHourExtraModel) {
        if (this.e) {
            b(rankHourExtraModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<RankHourDataModel> arrayList, long j) {
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (i < 3) {
            i++;
            if (arrayList.isEmpty()) {
                break;
            }
            arrayList2.add(arrayList.get(0));
            arrayList.remove(0);
        }
        this.h.add(new FitemRankHourFirstThree(arrayList2, this.d == 1, this.e, j));
        for (RankHourDataModel rankHourDataModel : arrayList) {
            this.h.add(new FitemRankHour(rankHourDataModel));
        }
        c();
    }

    private final void b() {
        int i = this.d;
        int i2 = this.e ? 1 : 2;
        String g = LiveRoomManager.a().g();
        final IRequestHost iRequestHost = this.c;
        LiveRoomHttpUtils.a(i, i2, g, new BluedUIHttpResponse<BluedEntity<RankHourDataModel, RankHourExtraModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.view.PopRankingHourTopPotentialRoadView$loadDate$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, String str) {
                PopWindowRankingListHourBinding vb;
                PopWindowRankingListHourBinding vb2;
                vb = PopRankingHourTopPotentialRoadView.this.getVb();
                RelativeLayout relativeLayout = vb == null ? null : vb.h;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                vb2 = PopRankingHourTopPotentialRoadView.this.getVb();
                RecyclerView recyclerView = vb2 == null ? null : vb2.i;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                return super.onUIFailure(i3, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<RankHourDataModel, RankHourExtraModel> entity) {
                PopWindowRankingListHourBinding vb;
                PopWindowRankingListHourBinding vb2;
                Intrinsics.e(entity, "entity");
                List<RankHourDataModel> list = entity.data;
                if (list == null || list.isEmpty()) {
                    vb = PopRankingHourTopPotentialRoadView.this.getVb();
                    RelativeLayout relativeLayout = vb == null ? null : vb.h;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    vb2 = PopRankingHourTopPotentialRoadView.this.getVb();
                    RecyclerView recyclerView = vb2 == null ? null : vb2.i;
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                    }
                } else if (entity.data != null) {
                    PopRankingHourTopPotentialRoadView popRankingHourTopPotentialRoadView = PopRankingHourTopPotentialRoadView.this;
                    long j = 0;
                    RankHourExtraModel rankHourExtraModel = entity.extra;
                    if (rankHourExtraModel != null) {
                        j = rankHourExtraModel.getCurrent_time();
                    }
                    List<RankHourDataModel> list2 = entity.data;
                    if (list2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.blued.android.module.live_china.model.RankHourDataModel>{ kotlin.collections.TypeAliasesKt.ArrayList<com.blued.android.module.live_china.model.RankHourDataModel> }");
                    }
                    popRankingHourTopPotentialRoadView.a((ArrayList) list2, j);
                }
                RankHourExtraModel rankHourExtraModel2 = entity.extra;
                if (rankHourExtraModel2 == null) {
                    return;
                }
                PopRankingHourTopPotentialRoadView.this.a(rankHourExtraModel2);
            }
        }, this.c);
    }

    private final void b(RankHourExtraModel rankHourExtraModel) {
        RankHourDataModel anchor_rank = rankHourExtraModel.getAnchor_rank();
        if (anchor_rank == null) {
            return;
        }
        int i = 0;
        if (anchor_rank.getRank() <= 0) {
            getVb().m.setText("99+");
            getVb().m.setVisibility(0);
            getVb().e.setVisibility(8);
        } else if (anchor_rank.getRank() == 1) {
            getVb().e.setImageResource(R.drawable.live_rank_up_one);
            getVb().e.setVisibility(0);
            getVb().m.setVisibility(8);
        } else if (anchor_rank.getRank() == 2) {
            getVb().e.setImageResource(R.drawable.live_rank_up_two);
            getVb().e.setVisibility(0);
            getVb().m.setVisibility(8);
        } else if (anchor_rank.getRank() == 3) {
            getVb().e.setImageResource(R.drawable.live_rank_up_three);
            getVb().e.setVisibility(0);
            getVb().m.setVisibility(8);
        } else {
            getVb().m.setText(String.valueOf(anchor_rank.getRank()));
            getVb().m.setVisibility(0);
            getVb().e.setVisibility(8);
        }
        ImageLoader.a(getRequestHost(), AvatarUtils.a(1, anchor_rank.getAvatar())).c().b(R.drawable.user_bg_round).a(getVb().a);
        if (TextUtils.isEmpty(anchor_rank.getAvatar_frame())) {
            getVb().b.setVisibility(8);
        } else if (anchor_rank.getAvatar_frame_type() == 0) {
            ImageLoader.a(getRequestHost(), anchor_rank.getAvatar_frame()).a(getVb().b);
        } else {
            ImageLoader.a(getRequestHost(), anchor_rank.getAvatar_frame()).g().g(-1).a(getVb().b);
        }
        getVb().k.setText(anchor_rank.getName());
        getVb().l.setText(String.valueOf(anchor_rank.getBonus()));
        if (anchor_rank.is_match() == 1) {
            LinearLayout linearLayout = getVb().f;
            if (!a()) {
                i = 8;
            }
            linearLayout.setVisibility(i);
            if (a()) {
                getVb().f.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingHourTopPotentialRoadView$CyQxQkN5LsD1ov0VMqMEor7qhHM
                    @Override // java.lang.Runnable
                    public final void run() {
                        PopRankingHourTopPotentialRoadView.c(PopRankingHourTopPotentialRoadView.this);
                    }
                });
            }
        } else {
            LinearLayout linearLayout2 = getVb().f;
            Intrinsics.c(linearLayout2, "vb.llAnchorRankLayout");
            BluedViewExKt.a(linearLayout2);
        }
        ImageLoader.c(getRequestHost(), "live_rank_hour_bounce.png").g().g(-1).a(getVb().c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopRankingHourTopPotentialRoadView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    private final void c() {
        RecyclerView recyclerView;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        FreedomAdapter freedomAdapter = this.g;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        FreedomAdapter freedomAdapter2 = new FreedomAdapter(getContext(), this.c, this.h);
        this.g = freedomAdapter2;
        Intrinsics.a(freedomAdapter2);
        freedomAdapter2.b("BaseFragment", this.b);
        PopWindowRankingListHourBinding vb = getVb();
        RecyclerView recyclerView2 = vb == null ? null : vb.i;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        PopWindowRankingListHourBinding vb2 = getVb();
        RecyclerView recyclerView3 = vb2 == null ? null : vb2.i;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(new DefaultItemAnimator());
        }
        PopWindowRankingListHourBinding vb3 = getVb();
        RecyclerView recyclerView4 = vb3 == null ? null : vb3.i;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(this.g);
        }
        PopWindowRankingListHourBinding vb4 = getVb();
        if (vb4 == null || (recyclerView = vb4.i) == null || (animate = recyclerView.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopRankingHourTopPotentialRoadView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().i.setPadding(0, 0, 0, this$0.getVb().f.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopWindowRankingListHourBinding getVb() {
        return (PopWindowRankingListHourBinding) this.f.getValue();
    }

    public final boolean a() {
        return this.e;
    }

    public final int getDataType() {
        return this.d;
    }

    public final BaseFragment getFragment() {
        return this.b;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final IRequestHost getRequestHost() {
        return this.c;
    }
}
