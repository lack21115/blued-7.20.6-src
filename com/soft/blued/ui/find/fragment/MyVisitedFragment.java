package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.find.adapter.VisitorListAdapter;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MyVisitedFragment.class */
public class MyVisitedFragment extends PreloadFragment {
    private Context k;
    private View l;
    private RenrenPullToRefreshListView m;
    private ListView n;
    private View o;
    private ToggleButton p;
    private boolean q;
    private LayoutInflater r;
    private VisitorListAdapter s;
    private int t;
    private boolean v;
    private NoDataAndLoadFailView w;
    private boolean u = true;
    private BluedUIHttpResponse x = new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>("my_privacy_setting", getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.MyVisitedFragment.4
        private void c(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
            MyVisitedFragment myVisitedFragment = MyVisitedFragment.this;
            boolean z = false;
            if (bluedEntityA.data.get(0).is_traceless_access == 1) {
                z = true;
            }
            myVisitedFragment.q = z;
            MyVisitedFragment.this.p.setChecked(MyVisitedFragment.this.q);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedBlackList.privacySettingEntity> parseData(String str) {
            return (BluedEntityA) super.parseData(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUICache(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
            super.onUICache(bluedEntityA);
            c(bluedEntityA);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: b */
        public void onUIUpdate(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
            c(bluedEntityA);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
        }
    };
    BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntityA<BluedMyVisitorList>>() { // from class: com.soft.blued.ui.find.fragment.MyVisitedFragment.6

        /* renamed from: a  reason: collision with root package name */
        boolean f30372a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedMyVisitorList> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                        if (bluedEntityA.hasMore()) {
                            MyVisitedFragment.this.u = true;
                            MyVisitedFragment.this.m.o();
                        } else {
                            MyVisitedFragment.this.u = false;
                            MyVisitedFragment.this.m.p();
                        }
                        if (MyVisitedFragment.this.t == 1) {
                            MyVisitedFragment.this.s.a(bluedEntityA.data, 0);
                            return;
                        } else {
                            MyVisitedFragment.this.s.b(bluedEntityA.data, 0);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) MyVisitedFragment.this.k.getResources().getString(2131887272));
                    if (MyVisitedFragment.this.t != 1) {
                        MyVisitedFragment.i(MyVisitedFragment.this);
                        return;
                    }
                    return;
                }
            }
            if (MyVisitedFragment.this.t == 1) {
                MyVisitedFragment.this.s.a(bluedEntityA.data, 0);
            }
            if (MyVisitedFragment.this.t != 1) {
                MyVisitedFragment.i(MyVisitedFragment.this);
                MyVisitedFragment.this.u = false;
            }
            MyVisitedFragment.this.m.p();
            AppMethods.a((CharSequence) MyVisitedFragment.this.k.getResources().getString(2131887275));
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f30372a = true;
            if (MyVisitedFragment.this.t != 1) {
                MyVisitedFragment.i(MyVisitedFragment.this);
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            MyVisitedFragment.this.m.j();
            MyVisitedFragment.this.m.q();
            if (MyVisitedFragment.this.s.getCount() != 0) {
                MyVisitedFragment.this.w.d();
            } else if (this.f30372a) {
                MyVisitedFragment.this.w.b();
            } else {
                MyVisitedFragment.this.w.a();
            }
            MyVisitedFragment.this.s.notifyDataSetChanged();
            this.f30372a = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("is_traceless_access", z ? "1" : "0");
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.MyVisitedFragment.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (bluedEntityA == null) {
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                    return;
                }
                AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.lock_pattern_success_set));
                if (z) {
                    BluedConfig.a().g().is_traceless_access = 1;
                } else {
                    BluedConfig.a().g().is_traceless_access = 0;
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i;
        if (z) {
            this.t = 1;
        }
        if (this.t == 1) {
            this.u = true;
        }
        if (!this.u && (i = this.t) != 1) {
            this.t = i - 1;
            AppMethods.a((CharSequence) this.k.getResources().getString(2131887275));
            this.m.j();
            this.m.q();
            return;
        }
        Context context = this.k;
        BluedUIHttpResponse bluedUIHttpResponse = this.j;
        String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
        MineHttpUtils.c(context, bluedUIHttpResponse, uid, this.t + "", BaseWrapper.ENTER_ID_SYSTEM_HELPER, getFragmentActive());
    }

    static /* synthetic */ int d(MyVisitedFragment myVisitedFragment) {
        int i = myVisitedFragment.t;
        myVisitedFragment.t = i + 1;
        return i;
    }

    static /* synthetic */ int i(MyVisitedFragment myVisitedFragment) {
        int i = myVisitedFragment.t;
        myVisitedFragment.t = i - 1;
        return i;
    }

    private void i() {
        this.r = LayoutInflater.from(this.k);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.l.findViewById(2131366898);
        this.m = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        ListView listView = (ListView) this.m.getRefreshableView();
        this.n = listView;
        listView.setClipToPadding(false);
        this.n.setScrollBarStyle(33554432);
        this.n.setHeaderDividersEnabled(false);
        this.n.setDividerHeight(0);
        View inflate = this.r.inflate(R.layout.layout_my_visited_header, (ViewGroup) null);
        this.o = inflate;
        ToggleButton toggleButton = (ToggleButton) inflate.findViewById(R.id.tglbtn_incognito_visitor_onoff);
        this.p = toggleButton;
        toggleButton.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitedFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 && !MyVisitedFragment.this.q) {
                    MyVisitedFragment.this.p.setChecked(false);
                    MyVisitedFragment.this.j();
                } else if (MyVisitedFragment.this.p.isChecked()) {
                    MyVisitedFragment.this.a(true);
                } else {
                    MyVisitedFragment.this.a(false);
                }
                EventTrackVIP.b(VipProtos.Event.VISIT_PAGE_NO_TRACE_BTN_CLICK, MyVisitedFragment.this.p.isChecked());
            }
        });
        this.n.addHeaderView(this.o);
        VisitorListAdapter visitorListAdapter = new VisitorListAdapter(this.k, getFragmentActive());
        this.s = visitorListAdapter;
        this.n.setAdapter((ListAdapter) visitorListAdapter);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.k);
        this.w = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233632);
        this.w.setNoDataStr(R.string.no_data_for_my_visited);
        this.n.setEmptyView(this.w);
        this.m.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitedFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                MyVisitedFragment.this.t = 1;
                MyVisitedFragment.this.b(false);
                MyVisitedFragment.this.h();
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                MyVisitedFragment.d(MyVisitedFragment.this);
                MyVisitedFragment.this.b(false);
            }
        });
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipUpgradeModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.MyVisitedFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipUpgradeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    PayUtils.a(MyVisitedFragment.this.k, 11, "visit_page_no_trace_visit");
                } else {
                    VipUpgradeDialogFragment.f34178a.a(MyVisitedFragment.this.getContext(), MyVisitedFragment.this.getParentFragmentManager(), bluedEntityA.data, 2, "visit_page_no_trace_visit", 11);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                PayUtils.a(MyVisitedFragment.this.k, 11, "visit_page_no_trace_visit");
                return true;
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.k = activity;
        this.l = view;
        LayoutInflater from = LayoutInflater.from(activity);
        this.r = from;
        ((ViewGroup) view).addView(from.inflate(R.layout.fragment_visit_list, (ViewGroup) null));
        i();
        EventTrackGuy.b(GuyProtos.Event.NEARBY_VISIT_LOOK_SHOW);
    }

    public void h() {
        ProfileHttpUtils.a(this.k, this.x, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        RenrenPullToRefreshListView renrenPullToRefreshListView;
        super.setUserVisibleHint(z);
        if (!z || this.v || (renrenPullToRefreshListView = this.m) == null) {
            return;
        }
        renrenPullToRefreshListView.k();
        this.v = true;
    }
}
