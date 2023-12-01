package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.adapter.RecommendedGroupAdapter;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.group.GroupSearchFragment;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupExtra;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.home.HomeTabClick;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyGroupFragment.class */
public class NearbyGroupFragment extends PreloadFragment implements HomeTabClick.TabClickListener {
    private View A;
    private View j;
    private View k;
    private Context l;
    private NoDataAndLoadFailView m;
    private SearchView n;
    private View o;
    private RenrenPullToRefreshListView p;
    private RecyclerView q;
    private TextView r;
    private ListView s;
    private GroupListsAdapter t;
    private RecommendedGroupAdapter u;
    private List<BluedGroupLists> v;
    private int w = 1;
    private int x = 20;
    private boolean y = true;
    private boolean z = false;

    static /* synthetic */ int b(NearbyGroupFragment nearbyGroupFragment) {
        int i = nearbyGroupFragment.w;
        nearbyGroupFragment.w = i + 1;
        return i;
    }

    private void h() {
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.j.findViewById(2131366898);
        this.p = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        ListView listView = (ListView) this.p.getRefreshableView();
        this.s = listView;
        listView.setClipToPadding(false);
        this.s.setScrollBarStyle(33554432);
        this.s.setHeaderDividersEnabled(false);
        this.s.setDividerHeight(0);
        GroupListsAdapter groupListsAdapter = new GroupListsAdapter(this.l);
        this.t = groupListsAdapter;
        this.s.setAdapter((ListAdapter) groupListsAdapter);
        this.s.addHeaderView(this.k);
        this.p.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.find.fragment.NearbyGroupFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                NearbyGroupFragment.this.w = 1;
                NearbyGroupFragment.this.i();
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                NearbyGroupFragment.b(NearbyGroupFragment.this);
                NearbyGroupFragment.this.i();
            }
        });
        this.s.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyGroupFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (i <= 1 || i > NearbyGroupFragment.this.t.getCount() + 1) {
                    return;
                }
                GroupInfoFragment.a(NearbyGroupFragment.this.l, ((BluedGroupLists) NearbyGroupFragment.this.t.getItem(i - 2)).groups_gid, UserFindResult.USER_SORT_BY.NEARBY);
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyGroupFragment.3
            @Override // java.lang.Runnable
            public void run() {
                NearbyGroupFragment.this.p.k();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.w == 1 || this.y) {
            GroupHttpUtils.e(this.l, new BluedUIHttpResponse<BluedEntity<BluedGroupLists, BluedGroupExtra>>() { // from class: com.soft.blued.ui.find.fragment.NearbyGroupFragment.4
                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i, String str) {
                    super.onFailure(th, i, str);
                    NearbyGroupFragment.this.z = true;
                    NearbyGroupFragment.k(NearbyGroupFragment.this);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    if (NearbyGroupFragment.this.t.getCount() == 0) {
                        if (NearbyGroupFragment.this.z) {
                            NearbyGroupFragment.this.m.b();
                        } else {
                            NearbyGroupFragment.this.m.a();
                        }
                        NearbyGroupFragment.this.o.setVisibility(8);
                        NearbyGroupFragment.this.A.setVisibility(8);
                        NearbyGroupFragment.this.r.setVisibility(8);
                        NearbyGroupFragment.this.p.p();
                    } else {
                        NearbyGroupFragment.this.m.d();
                        if (NearbyGroupFragment.this.y) {
                            NearbyGroupFragment.this.p.o();
                        } else {
                            NearbyGroupFragment.this.p.p();
                        }
                    }
                    NearbyGroupFragment.this.p.q();
                    NearbyGroupFragment.this.p.j();
                    NearbyGroupFragment.this.z = false;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedGroupLists, BluedGroupExtra> bluedEntity) {
                    if (bluedEntity != null && bluedEntity.data != null && bluedEntity.data.size() > 0) {
                        if (NearbyGroupFragment.this.w == 1) {
                            NearbyGroupFragment.this.t.a(bluedEntity.data);
                        } else {
                            NearbyGroupFragment.this.t.b(bluedEntity.data);
                        }
                    }
                    if (bluedEntity != null) {
                        NearbyGroupFragment.this.y = bluedEntity.hasMore();
                    } else {
                        NearbyGroupFragment.this.y = false;
                    }
                    if (NearbyGroupFragment.this.w == 1) {
                        if (bluedEntity == null || bluedEntity.extra == null || bluedEntity.extra.recommend_groups == null || bluedEntity.extra.recommend_groups.size() < 2) {
                            NearbyGroupFragment.this.o.setVisibility(8);
                            NearbyGroupFragment.this.A.setVisibility(8);
                            NearbyGroupFragment.this.r.setVisibility(8);
                            NearbyGroupFragment.this.u.a((List<BluedGroupLists>) null);
                            return;
                        }
                        NearbyGroupFragment.this.o.setVisibility(0);
                        NearbyGroupFragment.this.A.setVisibility(0);
                        NearbyGroupFragment.this.r.setVisibility(0);
                        NearbyGroupFragment.this.u.a(bluedEntity.extra.recommend_groups);
                    }
                }
            }, this.w + "", this.x + "", getFragmentActive());
        }
    }

    private void j() {
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) this.k.findViewById(R.id.nodataview);
        this.m = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233642);
        this.m.a();
        SearchView searchView = (SearchView) this.k.findViewById(R.id.group_search);
        this.n = searchView;
        searchView.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyGroupFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TerminalActivity.d(NearbyGroupFragment.this.l, GroupSearchFragment.class, null);
            }
        });
        View findViewById = this.k.findViewById(R.id.ll_group_list);
        this.o = findViewById;
        findViewById.setOnClickListener(null);
        this.A = this.k.findViewById(R.id.line_nearby_top);
        TextView textView = (TextView) this.k.findViewById(R.id.tv_nearby_title);
        this.r = textView;
        textView.setVisibility(8);
        this.r.setOnClickListener(null);
        this.v = new ArrayList();
        this.q = (RecyclerView) this.k.findViewById(R.id.rv_recommended_groups);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.l);
        linearLayoutManager.setOrientation(0);
        this.u = new RecommendedGroupAdapter(this.l, getFragmentActive(), this.v);
        this.q.setLayoutManager(linearLayoutManager);
        this.q.setAdapter(this.u);
    }

    static /* synthetic */ int k(NearbyGroupFragment nearbyGroupFragment) {
        int i = nearbyGroupFragment.w;
        nearbyGroupFragment.w = i - 1;
        return i;
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.l = activity;
        LayoutInflater from = LayoutInflater.from(activity);
        this.j = from.inflate(R.layout.fragment_nearby_group, (ViewGroup) view, true);
        this.k = from.inflate(R.layout.header_find_group, (ViewGroup) null, false);
        h();
        j();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        RenrenPullToRefreshListView renrenPullToRefreshListView;
        if (!"find".equals(str) || (renrenPullToRefreshListView = this.p) == null) {
            return;
        }
        renrenPullToRefreshListView.k();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        HomeTabClick.b("find", this);
        super.onDestroy();
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            HomeTabClick.a("find", this);
        }
    }
}
