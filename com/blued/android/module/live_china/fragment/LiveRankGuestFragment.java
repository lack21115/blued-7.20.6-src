package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.model.BluedLiveRankListExtra;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankGuestFragment.class */
public class LiveRankGuestFragment extends BaseFragment {
    public static String a = "ISCOMEHOT";
    public static String b = "LID";
    public static String c = "IF_USER_ANCHOR";
    private boolean A;
    private ProgressBar B;
    private View g;
    private Context h;
    private List<BluedLiveRankListData> i;
    private RenrenPullToRefreshListView j;
    private LayoutInflater k;
    private View l;
    private ListView m;
    private LiveRankGuestListItemAdapter n;
    private View o;
    private LinearLayout p;
    private TextView q;
    private long u;
    private long v;
    private String w;
    private boolean x;
    private boolean y;
    private boolean z;
    private String f = LiveRankGuestFragment.class.getSimpleName();
    private String[] r = new String[2];
    private int s = 1;
    private boolean t = true;
    public BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntity<BluedLiveRankListData, BluedLiveRankListExtra>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestFragment.3
        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            if (LiveRankGuestFragment.this.s == 1) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveRankGuestFragment.this.p.setVisibility(0);
                        LiveRankGuestFragment.this.o.setVisibility(4);
                        LiveRankGuestFragment.this.j.setVisibility(4);
                    }
                });
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            LiveRankGuestFragment.this.j.j();
            LiveRankGuestFragment.this.j.q();
            LiveRankGuestFragment.this.B.setVisibility(8);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedLiveRankListData, BluedLiveRankListExtra> bluedEntity) {
            if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                if (LiveRankGuestFragment.this.s == 1) {
                    LiveRankGuestFragment.this.j.setVisibility(4);
                    LiveRankGuestFragment.this.o.setVisibility(0);
                    LiveRankGuestFragment.this.i.clear();
                    LiveRankGuestFragment.this.n.notifyDataSetChanged();
                }
                if (LiveRankGuestFragment.this.s != 1) {
                    LiveRankGuestFragment.g(LiveRankGuestFragment.this);
                }
                LiveRankGuestFragment.this.j.p();
            } else {
                LiveRankGuestFragment.this.j.setVisibility(0);
                if (bluedEntity.hasMore()) {
                    LiveRankGuestFragment.this.t = true;
                    LiveRankGuestFragment.this.j.o();
                } else {
                    LiveRankGuestFragment.this.t = false;
                    LiveRankGuestFragment.this.j.p();
                }
                if (LiveRankGuestFragment.this.s == 1) {
                    LiveRankGuestFragment.this.o.setVisibility(4);
                    LiveRankGuestFragment.this.i.clear();
                }
                LiveRankGuestFragment.this.i.addAll(bluedEntity.data);
                LiveRankGuestFragment.this.n.notifyDataSetChanged();
            }
            LiveRankGuestFragment.this.p.setVisibility(4);
            if (bluedEntity.extra == null || LiveRankGuestFragment.this.getParentFragment() == null) {
                return;
            }
            LiveRankGuestFragment.this.getParentFragment().a(bluedEntity.extra.notice_text, bluedEntity.extra.notice_title);
        }
    };
    public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntity<BluedLiveRankListData, BluedLiveRankListExtra>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestFragment.4
        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            if (LiveRankGuestFragment.this.s == 1) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveRankGuestFragment.this.p.setVisibility(0);
                        LiveRankGuestFragment.this.o.setVisibility(4);
                        LiveRankGuestFragment.this.j.setVisibility(4);
                    }
                });
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            LiveRankGuestFragment.this.j.j();
            LiveRankGuestFragment.this.j.q();
            LiveRankGuestFragment.this.B.setVisibility(8);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedLiveRankListData, BluedLiveRankListExtra> bluedEntity) {
            if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                if (LiveRankGuestFragment.this.s == 1) {
                    LiveRankGuestFragment.this.i.clear();
                    LiveRankGuestFragment.this.n.notifyDataSetChanged();
                    LiveRankGuestFragment.this.j.setVisibility(4);
                    LiveRankGuestFragment.this.o.setVisibility(0);
                }
                if (LiveRankGuestFragment.this.s != 1) {
                    LiveRankGuestFragment.g(LiveRankGuestFragment.this);
                }
                LiveRankGuestFragment.this.j.p();
            } else {
                LiveRankGuestFragment.this.j.setVisibility(0);
                if (bluedEntity.hasMore()) {
                    LiveRankGuestFragment.this.t = true;
                    LiveRankGuestFragment.this.j.o();
                } else {
                    LiveRankGuestFragment.this.t = false;
                    LiveRankGuestFragment.this.j.p();
                }
                if (LiveRankGuestFragment.this.s == 1) {
                    LiveRankGuestFragment.this.o.setVisibility(4);
                    LiveRankGuestFragment.this.i.clear();
                }
                LiveRankGuestFragment.this.i.addAll(bluedEntity.data);
                LiveRankGuestFragment.this.n.notifyDataSetChanged();
            }
            LiveRankGuestFragment.this.p.setVisibility(4);
            if (bluedEntity.extra == null || LiveRankGuestFragment.this.getParentFragment() == null) {
                return;
            }
            LiveRankGuestFragment.this.getParentFragment().a(bluedEntity.extra.notice_text, bluedEntity.extra.notice_title);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankGuestFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            LiveRankGuestFragment.this.b();
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            LiveRankGuestFragment.b(LiveRankGuestFragment.this);
            LiveRankGuestFragment.this.a();
        }
    }

    static /* synthetic */ int b(LiveRankGuestFragment liveRankGuestFragment) {
        int i = liveRankGuestFragment.s;
        liveRankGuestFragment.s = i + 1;
        return i;
    }

    private void c() {
        if (getArguments() != null) {
            this.y = getArguments().getBoolean(a);
            this.w = getArguments().getString("UID");
            this.v = getArguments().getLong(b);
            this.x = getArguments().getBoolean(c);
        }
    }

    private void d() {
        LayoutInflater layoutInflater = (LayoutInflater) this.h.getSystemService("layout_inflater");
        this.k = layoutInflater;
        this.l = layoutInflater.inflate(R.layout.fragment_live_list_header, (ViewGroup) null);
        this.B = (ProgressBar) this.g.findViewById(R.id.loading_view);
        this.i = new ArrayList();
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.g.findViewById(R.id.rptrlv_live_list);
        this.j = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(false);
        if (this.z) {
            this.A = true;
            this.j.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    LiveRankGuestFragment.this.j.k();
                }
            }, 100L);
        }
        this.j.setOnPullDownListener(new MyPullDownListener());
        ListView listView = (ListView) this.j.getRefreshableView();
        this.m = listView;
        listView.setDivider(null);
        this.m.setSelector(new ColorDrawable(0));
        this.p = (LinearLayout) this.g.findViewById(R.id.ll_nodata_error);
        TextView textView = (TextView) this.g.findViewById(R.id.tv_live_reload);
        this.q = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRankGuestFragment.this.b();
            }
        });
        this.o = this.g.findViewById(R.id.ll_nodata_rank);
        LiveRankGuestListItemAdapter liveRankGuestListItemAdapter = new LiveRankGuestListItemAdapter(this, this.i, this.x, this.y, getFragmentActive());
        this.n = liveRankGuestListItemAdapter;
        liveRankGuestListItemAdapter.a(this.x);
        this.m.setAdapter((ListAdapter) this.n);
    }

    static /* synthetic */ int g(LiveRankGuestFragment liveRankGuestFragment) {
        int i = liveRankGuestFragment.s;
        liveRankGuestFragment.s = i - 1;
        return i;
    }

    public void a() {
        int i;
        if (this.s == 1) {
            this.t = true;
        }
        if (!this.t && (i = this.s) != 1) {
            this.s = i - 1;
            AppMethods.a((CharSequence) this.h.getResources().getString(R.string.common_nomore_data));
            this.j.j();
        } else if (this.y) {
            LiveRoomHttpUtils.a(this.h, this.w, this.v, this.s, this.d, getFragmentActive());
        } else {
            LiveRoomHttpUtils.a(this.h, this.w, this.v, "month", this.s, this.e, getFragmentActive());
        }
    }

    public void b() {
        this.s = 1;
        a();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = getActivity();
        View view = this.g;
        if (view == null) {
            this.g = layoutInflater.inflate(LiveFloatManager.a().C() ? R.layout.fragment_live_rank_list_guest_land : R.layout.fragment_live_rank_list_guest, viewGroup, false);
            c();
            d();
            this.u = 0L;
        } else if (view.getParent() != null) {
            ((ViewGroup) this.g.getParent()).removeView(this.g);
        }
        return this.g;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        this.u = System.currentTimeMillis();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        if (!this.z || this.u == 0) {
            return;
        }
        if (System.currentTimeMillis() - this.u > 300000) {
            this.j.setRefreshing(true);
        }
        this.u = 0L;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.z = z;
        if (this.A || !z || this.g == null) {
            return;
        }
        this.A = true;
        this.j.setRefreshing(true);
    }
}
