package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.PopWindowRankingListHourBinding;
import com.blued.android.module.live_china.fitem.FitemRankHourHistory;
import com.blued.android.module.live_china.fitem.FitemRankHourHistoryTitle;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RankHourDataModel;
import com.blued.android.module.live_china.model.RankHourExtraModel;
import com.blued.android.module.live_china.model.RankHourHistoryDataModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingHourPreviousView.class */
public final class PopRankingHourPreviousView extends FrameLayout {
    private final Context a;
    private final BaseFragment b;
    private final IRequestHost c;
    private final Lazy d;
    private FreedomAdapter e;
    private ArrayList<FreedomItem> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopRankingHourPreviousView(Context mContext, BaseFragment fragment, IRequestHost requestHost) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(requestHost, "requestHost");
        this.a = mContext;
        this.b = fragment;
        this.c = requestHost;
        this.d = LazyKt.a(new Function0<PopWindowRankingListHourBinding>() { // from class: com.blued.android.module.live_china.view.PopRankingHourPreviousView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final PopWindowRankingListHourBinding invoke() {
                PopWindowRankingListHourBinding a = PopWindowRankingListHourBinding.a(LayoutInflater.from(PopRankingHourPreviousView.this.getContext()).inflate(R.layout.pop_window_ranking_list_hour, PopRankingHourPreviousView.this));
                Intrinsics.c(a, "bind(\n            Layout…ist_hour, this)\n        )");
                return a;
            }
        });
        this.f = new ArrayList<>();
        LiveRoomHttpUtils.m(LiveRoomManager.a().g(), new BluedUIHttpResponse<BluedEntity<RankHourHistoryDataModel, RankHourExtraModel>>(this.c) { // from class: com.blued.android.module.live_china.view.PopRankingHourPreviousView.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                PopWindowRankingListHourBinding vb = PopRankingHourPreviousView.this.getVb();
                RelativeLayout relativeLayout = vb == null ? null : vb.h;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                PopWindowRankingListHourBinding vb2 = PopRankingHourPreviousView.this.getVb();
                RecyclerView recyclerView = vb2 == null ? null : vb2.i;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<RankHourHistoryDataModel, RankHourExtraModel> entity) {
                Intrinsics.e(entity, "entity");
                List<RankHourHistoryDataModel> list = entity.data;
                if (list == null || list.isEmpty()) {
                    PopWindowRankingListHourBinding vb = PopRankingHourPreviousView.this.getVb();
                    RelativeLayout relativeLayout = vb == null ? null : vb.h;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    PopWindowRankingListHourBinding vb2 = PopRankingHourPreviousView.this.getVb();
                    RecyclerView recyclerView = vb2 == null ? null : vb2.i;
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                    }
                } else if (entity.data != null) {
                    PopRankingHourPreviousView popRankingHourPreviousView = PopRankingHourPreviousView.this;
                    List<RankHourHistoryDataModel> list2 = entity.data;
                    if (list2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.blued.android.module.live_china.model.RankHourHistoryDataModel>{ kotlin.collections.TypeAliasesKt.ArrayList<com.blued.android.module.live_china.model.RankHourHistoryDataModel> }");
                    }
                    popRankingHourPreviousView.a((ArrayList) list2);
                }
                RankHourExtraModel rankHourExtraModel = entity.extra;
                if (rankHourExtraModel == null) {
                    return;
                }
                PopRankingHourPreviousView.this.a(rankHourExtraModel);
            }
        }, this.c);
        EventTrackLive.a(LiveProtos.Event.LIVE_HOUR_LIST_TIME_TAB_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    private final String a(RankHourHistoryDataModel rankHourHistoryDataModel) {
        if (rankHourHistoryDataModel.getTop() != null) {
            RankHourDataModel top = rankHourHistoryDataModel.getTop();
            Intrinsics.a(top);
            return top.getDaytime();
        } else if (rankHourHistoryDataModel.getPotential() != null) {
            RankHourDataModel potential = rankHourHistoryDataModel.getPotential();
            Intrinsics.a(potential);
            return potential.getDaytime();
        } else {
            return null;
        }
    }

    private final void a() {
        RecyclerView recyclerView;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        FreedomAdapter freedomAdapter = this.e;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        FreedomAdapter freedomAdapter2 = new FreedomAdapter(getContext(), this.c, this.f);
        this.e = freedomAdapter2;
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
            recyclerView4.setAdapter(this.e);
        }
        PopWindowRankingListHourBinding vb4 = getVb();
        if (vb4 == null || (recyclerView = vb4.i) == null || (animate = recyclerView.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(RankHourExtraModel rankHourExtraModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<RankHourHistoryDataModel> arrayList) {
        String str;
        Iterator<RankHourHistoryDataModel> it = arrayList.iterator();
        String str2 = "";
        while (true) {
            String str3 = str2;
            if (!it.hasNext()) {
                a();
                return;
            }
            RankHourHistoryDataModel next = it.next();
            String a = a(next);
            if (a == null) {
                str = str3;
            } else {
                str = str3;
                if (!Intrinsics.a((Object) str3, (Object) a)) {
                    this.f.add(new FitemRankHourHistoryTitle(a, str3.length() == 0));
                    str = a;
                }
            }
            this.f.add(new FitemRankHourHistory(next));
            str2 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopWindowRankingListHourBinding getVb() {
        return (PopWindowRankingListHourBinding) this.d.getValue();
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
