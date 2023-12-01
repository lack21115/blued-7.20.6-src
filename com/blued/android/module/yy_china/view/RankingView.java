package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.EndAnchorAdapter;
import com.blued.android.module.yy_china.adapter.EndMemberAdapter;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/RankingView.class */
public class RankingView extends LinearLayout {
    private ImageView a;
    private TextView b;
    private LinearLayout c;
    private ImageView d;
    private TextView e;
    private LinearLayout f;
    private ImageView g;
    private TextView h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private SmartRefreshLayout l;
    private RecyclerView m;
    private EndMemberAdapter n;
    private int o;
    private int p;
    private String q;
    private MvpFragment r;
    private LinearLayout s;
    private RecyclerView t;
    private EndAnchorAdapter u;

    public RankingView(Context context) {
        super(context);
        this.p = 1;
        a();
    }

    public RankingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 1;
        a();
    }

    public RankingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = 1;
        a();
    }

    private void a() {
        this.o = DensityUtils.a(getContext(), 10.0f);
        LayoutInflater.from(getContext()).inflate(R.layout.view_ranking_layoug, (ViewGroup) this, true);
        this.m = findViewById(R.id.member_list_view);
        SmartRefreshLayout findViewById = findViewById(R.id.refresh_view);
        this.l = findViewById;
        findViewById.c(false);
        this.j = (LinearLayout) findViewById(R.id.layout_no);
        this.k = (LinearLayout) findViewById(R.id.layout_no_title);
        this.i = (LinearLayout) findViewById(R.id.ll_no3_layout);
        this.g = (ImageView) findViewById(R.id.iv_no_3);
        this.h = (TextView) findViewById(R.id.tv_name_no3);
        this.f = (LinearLayout) findViewById(R.id.ll_no1_layout);
        this.e = (TextView) findViewById(R.id.tv_name_no1);
        this.d = (ImageView) findViewById(R.id.iv_no_1);
        this.c = (LinearLayout) findViewById(R.id.ll_no2_layout);
        this.b = (TextView) findViewById(R.id.tv_name_no2);
        this.a = (ImageView) findViewById(R.id.iv_no_2);
        this.s = (LinearLayout) findViewById(R.id.ll_yy_end_recommend);
        RecyclerView findViewById2 = findViewById(R.id.rcv_yy_end);
        this.t = findViewById2;
        findViewById2.setLayoutManager(new GridLayoutManager(getContext(), 4));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.m.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.RankingView.1
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = RankingView.this.o;
                }
                rect.bottom = RankingView.this.o;
            }
        });
        this.m.setLayoutManager(linearLayoutManager);
        this.l.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.view.RankingView.2
            public void onLoadMore(RefreshLayout refreshLayout) {
                RankingView.b(RankingView.this);
                RankingView.this.getMembers();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                RankingView.this.p = 1;
                RankingView.this.getMembers();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<YYRoomModel> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() || i2 >= 4) {
                break;
            }
            arrayList.add(list.get(i2));
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_END_PAGE_LIVING_USER_SHOW, list.get(i2).room_id, list.get(i2).uid);
            i = i2 + 1;
        }
        this.s.setVisibility(0);
        this.u.setNewData(arrayList);
    }

    static /* synthetic */ int b(RankingView rankingView) {
        int i = rankingView.p;
        rankingView.p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.l.h();
        this.l.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(YYUserInfo yYUserInfo) {
        if (yYUserInfo == null) {
            return;
        }
        YYRoomInfoManager.e().c().a(getContext(), yYUserInfo.getUid(), yYUserInfo.getName(), yYUserInfo.getAvatar(), yYUserInfo.vbadge, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMembers() {
        YYRoomHttpUtils.g(this.q, this.p, new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(this.r.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.RankingView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYUserInfo> bluedEntityA) {
                if (RankingView.this.p == 1) {
                    RankingView.this.l.b(false);
                    RankingView.this.n.a(bluedEntityA);
                    return;
                }
                RankingView.this.n.addData(bluedEntityA.data);
                if (bluedEntityA.hasMore()) {
                    RankingView.this.l.b(true);
                } else {
                    RankingView.this.l.b(false);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                RankingView.this.b();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                RankingView.this.b();
            }
        }, this.r.getFragmentActive());
    }

    private void getRooms() {
        YYRoomHttpUtils.g(this.q, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYRoomModel, YYRoomExtraModel>>(this.r.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.RankingView.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<YYRoomModel, YYRoomExtraModel> bluedEntity) {
                super.onUICache(bluedEntity);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYRoomModel, YYRoomExtraModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null) {
                    return;
                }
                RankingView.this.a(bluedEntity.data);
            }
        }, (IRequestHost) this.r.getFragmentActive());
    }

    public void a(MvpFragment mvpFragment, String str, boolean z) {
        this.r = mvpFragment;
        this.q = str;
        EndMemberAdapter endMemberAdapter = new EndMemberAdapter(mvpFragment, this.l, this);
        this.n = endMemberAdapter;
        this.m.setAdapter(endMemberAdapter);
        EndAnchorAdapter endAnchorAdapter = new EndAnchorAdapter(mvpFragment);
        this.u = endAnchorAdapter;
        this.t.setAdapter(endAnchorAdapter);
        getMembers();
        if (z) {
            this.s.setVisibility(8);
        } else {
            getRooms();
        }
    }

    public void a(final YYUserInfo yYUserInfo) {
        this.k.setVisibility(0);
        this.j.setVisibility(0);
        this.f.setVisibility(0);
        ImageLoader.a(this.r.getFragmentActive(), yYUserInfo.getAvatar()).b(R.drawable.user_bg_round).a(this.d);
        this.e.setText(yYUserInfo.getName());
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.RankingView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RankingView.this.d(yYUserInfo);
            }
        });
    }

    public void b(final YYUserInfo yYUserInfo) {
        this.c.setVisibility(0);
        ImageLoader.a(this.r.getFragmentActive(), yYUserInfo.getAvatar()).b(R.drawable.user_bg_round).a(this.a);
        this.b.setText(yYUserInfo.getName());
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.RankingView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RankingView.this.d(yYUserInfo);
            }
        });
    }

    public void c(final YYUserInfo yYUserInfo) {
        this.i.setVisibility(0);
        ImageLoader.a(this.r.getFragmentActive(), yYUserInfo.getAvatar()).b(R.drawable.user_bg_round).a(this.g);
        this.h.setText(yYUserInfo.getName());
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.RankingView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RankingView.this.d(yYUserInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        YYObserverManager.a().b(this.n);
    }
}
