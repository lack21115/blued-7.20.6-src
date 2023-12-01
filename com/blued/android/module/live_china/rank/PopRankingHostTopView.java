package com.blued.android.module.live_china.rank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.PopWindowRankingListHostBinding;
import com.blued.android.module.live_china.model.RankAllDataModel;
import com.blued.android.module.live_china.model.RankExtraModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.recommend.RecommendRefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/PopRankingHostTopView.class */
public final class PopRankingHostTopView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14085a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final IRequestHost f14086c;
    private final String d;
    private final Lazy e;
    private FreedomAdapter f;
    private ArrayList<FreedomItem> g;
    private String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopRankingHostTopView(Context mContext, int i, IRequestHost requestHost, String str) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(requestHost, "requestHost");
        this.f14085a = mContext;
        this.b = i;
        this.f14086c = requestHost;
        this.d = str;
        this.e = LazyKt.a(new Function0<PopWindowRankingListHostBinding>() { // from class: com.blued.android.module.live_china.rank.PopRankingHostTopView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final PopWindowRankingListHostBinding invoke() {
                PopWindowRankingListHostBinding a2 = PopWindowRankingListHostBinding.a(LayoutInflater.from(PopRankingHostTopView.this.getContext()).inflate(R.layout.pop_window_ranking_list_host, PopRankingHostTopView.this));
                Intrinsics.c(a2, "bind(\n            Layout…ist_host, this)\n        )");
                return a2;
            }
        });
        this.g = new ArrayList<>();
        this.h = "";
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$PopRankingHostTopView$KUdGzISjci58dESrZbRLfjhLhlE
            @Override // java.lang.Runnable
            public final void run() {
                PopRankingHostTopView.f(PopRankingHostTopView.this);
            }
        }, 400L);
        a();
    }

    private final void a() {
        getVb().d.k(false);
        getVb().d.l(false);
        getVb().d.b(new RecommendRefreshHeader(this.f14085a));
        getVb().d.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.rank.PopRankingHostTopView$initListener$1
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                String str;
                Intrinsics.e(refreshLayout, "refreshLayout");
                str = PopRankingHostTopView.this.d;
                if (Intrinsics.a((Object) str, (Object) "union") && PopRankingHostTopView.this.getPosition() == 0) {
                    PopRankingHostTopView.this.c();
                } else {
                    PopRankingHostTopView.this.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<RankAllDataModel> arrayList) {
        int size;
        this.g.clear();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size() < 3 ? arrayList.size() : 3;
        int i = 0;
        while (i < size2) {
            i++;
            if (arrayList.isEmpty()) {
                break;
            }
            arrayList2.add(arrayList.get(0));
            arrayList.remove(0);
        }
        this.g.add(new FitemRankHostFirstThree(arrayList2, this.d, this.b));
        boolean z = true;
        if (arrayList.size() >= 1) {
            this.g.add(new FitemRankHostExtra(this.d, this.b));
        }
        for (RankAllDataModel rankAllDataModel : arrayList) {
            this.g.add(new FitemRankHost(rankAllDataModel, this.d, getPosition()));
        }
        int size3 = arrayList.size();
        if (((1 > size3 || size3 >= 4) ? false : false) && (size = 7 - arrayList.size()) >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                this.g.add(new FitemRankHost(null, this.d, this.b));
                if (i3 == size) {
                    break;
                }
                i2 = i3 + 1;
            }
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        String str = !Intrinsics.a((Object) this.d, (Object) "union") ? this.d : "anchor";
        int i = !Intrinsics.a((Object) this.d, (Object) "union") ? this.b : 3;
        final IRequestHost iRequestHost = this.f14086c;
        LiveRoomHttpUtils.d(str, i, new BluedUIHttpResponse<BluedEntity<RankAllDataModel, RankExtraModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.rank.PopRankingHostTopView$loadData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2) {
                PopWindowRankingListHostBinding vb;
                PopWindowRankingListHostBinding vb2;
                String str3;
                vb = PopRankingHostTopView.this.getVb();
                vb.b.setVisibility(0);
                vb2 = PopRankingHostTopView.this.getVb();
                vb2.f12498c.setVisibility(8);
                str3 = PopRankingHostTopView.this.d;
                LiveEventBusUtil.a(str3, "");
                return super.onUIFailure(i2, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                PopWindowRankingListHostBinding vb;
                PopWindowRankingListHostBinding vb2;
                String str2;
                String str3;
                super.onUIFinish();
                vb = PopRankingHostTopView.this.getVb();
                vb.d.j();
                vb2 = PopRankingHostTopView.this.getVb();
                vb2.d.h();
                str2 = PopRankingHostTopView.this.d;
                str3 = PopRankingHostTopView.this.h;
                LiveEventBusUtil.a(str2, str3);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<RankAllDataModel, RankExtraModel> bluedEntity) {
                Integer valueOf;
                PopWindowRankingListHostBinding vb;
                PopWindowRankingListHostBinding vb2;
                List<RankAllDataModel> list = bluedEntity == null ? null : bluedEntity.data;
                if (list == null || list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    RankAllDataModel rankAllDataModel = new RankAllDataModel();
                    rankAllDataModel.setFake(true);
                    arrayList.add(rankAllDataModel);
                    arrayList.add(rankAllDataModel);
                    arrayList.add(rankAllDataModel);
                    PopRankingHostTopView.this.a(arrayList);
                    vb2 = PopRankingHostTopView.this.getVb();
                    vb2.b.setVisibility(0);
                    return;
                }
                if (bluedEntity == null) {
                    valueOf = null;
                } else {
                    List<RankAllDataModel> list2 = bluedEntity.data;
                    valueOf = list2 == null ? null : Integer.valueOf(list2.size());
                }
                Intrinsics.a(valueOf);
                if (valueOf.intValue() <= 3) {
                    vb = PopRankingHostTopView.this.getVb();
                    vb.b.setVisibility(0);
                }
                if (bluedEntity == null || bluedEntity.data == null) {
                    return;
                }
                PopRankingHostTopView popRankingHostTopView = PopRankingHostTopView.this;
                List<RankAllDataModel> list3 = bluedEntity.data;
                if (list3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.blued.android.module.live_china.model.RankAllDataModel>{ kotlin.collections.TypeAliasesKt.ArrayList<com.blued.android.module.live_china.model.RankAllDataModel> }");
                }
                popRankingHostTopView.a((ArrayList) list3);
                popRankingHostTopView.h = bluedEntity.extra.getDesc_image();
            }
        }, this.f14086c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        final IRequestHost iRequestHost = this.f14086c;
        LiveRoomHttpUtils.L(new BluedUIHttpResponse<BluedEntity<RankAllDataModel, RankExtraModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.rank.PopRankingHostTopView$loadData2$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                PopWindowRankingListHostBinding vb;
                PopWindowRankingListHostBinding vb2;
                String str2;
                vb = PopRankingHostTopView.this.getVb();
                vb.b.setVisibility(0);
                vb2 = PopRankingHostTopView.this.getVb();
                vb2.f12498c.setVisibility(8);
                str2 = PopRankingHostTopView.this.d;
                LiveEventBusUtil.a(str2, "");
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                PopWindowRankingListHostBinding vb;
                PopWindowRankingListHostBinding vb2;
                String str;
                String str2;
                super.onUIFinish();
                vb = PopRankingHostTopView.this.getVb();
                vb.d.j();
                vb2 = PopRankingHostTopView.this.getVb();
                vb2.d.h();
                str = PopRankingHostTopView.this.d;
                str2 = PopRankingHostTopView.this.h;
                LiveEventBusUtil.a(str, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<RankAllDataModel, RankExtraModel> bluedEntity) {
                Integer valueOf;
                PopWindowRankingListHostBinding vb;
                PopWindowRankingListHostBinding vb2;
                List<RankAllDataModel> list = bluedEntity == null ? null : bluedEntity.data;
                if (list == null || list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    RankAllDataModel rankAllDataModel = new RankAllDataModel();
                    rankAllDataModel.setFake(true);
                    arrayList.add(rankAllDataModel);
                    arrayList.add(rankAllDataModel);
                    arrayList.add(rankAllDataModel);
                    PopRankingHostTopView.this.a(arrayList);
                    vb2 = PopRankingHostTopView.this.getVb();
                    vb2.b.setVisibility(0);
                    return;
                }
                if (bluedEntity == null) {
                    valueOf = null;
                } else {
                    List<RankAllDataModel> list2 = bluedEntity.data;
                    valueOf = list2 == null ? null : Integer.valueOf(list2.size());
                }
                Intrinsics.a(valueOf);
                if (valueOf.intValue() <= 3) {
                    vb = PopRankingHostTopView.this.getVb();
                    vb.b.setVisibility(0);
                }
                if (bluedEntity == null || bluedEntity.data == null) {
                    return;
                }
                PopRankingHostTopView popRankingHostTopView = PopRankingHostTopView.this;
                List<RankAllDataModel> list3 = bluedEntity.data;
                if (list3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.blued.android.module.live_china.model.RankAllDataModel>{ kotlin.collections.TypeAliasesKt.ArrayList<com.blued.android.module.live_china.model.RankAllDataModel> }");
                }
                popRankingHostTopView.a((ArrayList) list3);
                popRankingHostTopView.h = bluedEntity.extra.getDesc_image();
            }
        }, this.f14086c);
    }

    private final void d() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        FreedomAdapter freedomAdapter = this.f;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.f = new FreedomAdapter(getContext(), this.f14086c, this.g);
        getVb().f12498c.setLayoutManager(new LinearLayoutManager(getContext()));
        getVb().f12498c.setItemAnimator(new DefaultItemAnimator());
        getVb().f12498c.setAdapter(this.f);
        ViewPropertyAnimator animate = getVb().f12498c.animate();
        if (animate == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PopRankingHostTopView this$0) {
        Intrinsics.e(this$0, "this$0");
        if (Intrinsics.a((Object) this$0.d, (Object) "union") && this$0.b == 0) {
            this$0.c();
        } else {
            this$0.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopWindowRankingListHostBinding getVb() {
        return (PopWindowRankingListHostBinding) this.e.getValue();
    }

    public final Context getMContext() {
        return this.f14085a;
    }

    public final int getPosition() {
        return this.b;
    }

    public final IRequestHost getRequestHost() {
        return this.f14086c;
    }
}
