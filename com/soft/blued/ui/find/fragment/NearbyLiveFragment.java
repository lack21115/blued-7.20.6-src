package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.find.adapter.NearbyLiveAdapter;
import com.soft.blued.ui.home.HomeArgumentHelper;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyLiveFragment.class */
public class NearbyLiveFragment extends BaseFragment implements LiveListPositionObserver.ILiveListPositionObserver {

    /* renamed from: a  reason: collision with root package name */
    public boolean f30425a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f30426c;
    public NoDataAndLoadFailView d;
    public boolean e;
    BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>() { // from class: com.soft.blued.ui.find.fragment.NearbyLiveFragment.5
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedLiveListData> bluedEntityA) {
            try {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    if (NearbyLiveFragment.this.b != 1) {
                        NearbyLiveFragment.this.b--;
                        AppMethods.a((CharSequence) NearbyLiveFragment.this.g.getResources().getString(2131887275));
                        return;
                    }
                    return;
                }
                if (bluedEntityA.extra == 0 || !bluedEntityA.hasMore()) {
                    NearbyLiveFragment.this.j.p();
                    NearbyLiveFragment.this.f30425a = false;
                } else {
                    NearbyLiveFragment.this.f30425a = true;
                    NearbyLiveFragment.this.j.o();
                }
                if (NearbyLiveFragment.this.b == 1) {
                    NearbyLiveFragment.this.k.b(bluedEntityA.data);
                } else {
                    NearbyLiveFragment.this.k.a(bluedEntityA.data);
                }
                if (NearbyLiveFragment.this.f30425a) {
                    return;
                }
                NearbyLiveFragment.this.k.a();
            } catch (Exception e) {
                if (NearbyLiveFragment.this.b != 1) {
                    NearbyLiveFragment.this.b--;
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            NearbyLiveFragment.this.e = true;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            NearbyLiveFragment.this.l.setEmptyView(NearbyLiveFragment.this.d);
            NearbyLiveFragment.this.j.j();
            NearbyLiveFragment.this.j.q();
            if (NearbyLiveFragment.this.e) {
                NearbyLiveFragment.this.d.b();
            } else if (NearbyLiveFragment.this.k.getCount() == 0) {
                NearbyLiveFragment.this.d.a();
            }
            NearbyLiveFragment.this.k.notifyDataSetChanged();
            NearbyLiveFragment.this.e = false;
        }
    };
    private Context g;
    private View h;
    private CommonTopTitleNoTrans i;
    private RenrenPullToRefreshListView j;
    private NearbyLiveAdapter k;
    private ListView l;

    public static void a(Context context) {
        TerminalActivity.d(context, NearbyLiveFragment.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.b = 1;
        } else if (!this.f30425a) {
            return;
        } else {
            this.b++;
        }
        LiveHttpUtils.a(this.f, getFragmentActive(), this.b);
    }

    public void a() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.g);
        this.d = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataStr(R.string.no_nearby_live);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.h.findViewById(2131366898);
        this.j = renrenPullToRefreshListView;
        this.l = (ListView) renrenPullToRefreshListView.getRefreshableView();
        this.j.setRefreshEnabled(true);
        this.l.setClipToPadding(false);
        this.l.setScrollBarStyle(33554432);
        this.l.setHeaderDividersEnabled(false);
        this.l.setDividerHeight(0);
        NearbyLiveAdapter nearbyLiveAdapter = new NearbyLiveAdapter(this.g, getFragmentActive());
        this.k = nearbyLiveAdapter;
        this.l.setAdapter((ListAdapter) nearbyLiveAdapter);
        this.j.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.find.fragment.NearbyLiveFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                NearbyLiveFragment.this.a(true);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                NearbyLiveFragment.this.a(false);
            }
        });
        this.j.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyLiveFragment.2
            @Override // java.lang.Runnable
            public void run() {
                NearbyLiveFragment.this.j.k();
            }
        }, 100L);
    }

    @Override // com.blued.android.module.live_china.observer.LiveListPositionObserver.ILiveListPositionObserver
    public void a(int i, long j) {
        if (i != -1) {
            this.l.setSelectionFromTop(((int) Math.floor(i / 3.0f)) + 1, 0);
        }
    }

    public void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.h.findViewById(2131370694);
        this.i = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setCenterText(this.g.getResources().getString(R.string.view_live_only));
        this.i.setRightText(this.g.getResources().getString(2131886202));
        this.i.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyLiveFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyLiveFragment.this.getActivity().finish();
            }
        });
        this.i.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyLiveFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveListPositionObserver.a().b(NearbyLiveFragment.this);
                InstantLog.a("live_nearby_hot");
                HomeArgumentHelper.a(NearbyLiveFragment.this.g, "live", (Bundle) null);
                NearbyLiveFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyLiveFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveListSetSelectedTab.a().a(1);
                    }
                }, 300L);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        this.f30426c = 60;
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_nearby_live, viewGroup, false);
            LiveListPositionObserver.a().a(this);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        LiveListPositionObserver.a().b(this);
        super.onDestroy();
    }
}
