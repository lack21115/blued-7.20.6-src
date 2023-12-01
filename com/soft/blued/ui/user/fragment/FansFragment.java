package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.model.FollowedExtra;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/FansFragment.class */
public class FansFragment extends PreloadFragment {
    private Context k;
    private View l;
    private RenrenPullToRefreshListView m;
    private ListView n;
    private View o;
    private TextView p;
    private LayoutInflater q;
    private RecommendListAdapter r;
    private NoDataAndLoadFailView s;
    private int t;
    private boolean w;
    private String x;
    private int u = 20;
    private boolean v = false;
    BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntity<BluedRecommendUsers, FollowedExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.FansFragment.3

        /* renamed from: a  reason: collision with root package name */
        boolean f33853a;
        int b;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f33853a = true;
            this.b = i;
            if (FansFragment.this.t != 1) {
                FansFragment.f(FansFragment.this);
                return true;
            }
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            FansFragment.this.m.j();
            FansFragment.this.m.q();
            if (this.b == 403903) {
                Log.v("drb", "没有访问权限");
                FansFragment.this.r.a(new ArrayList());
                FansFragment.this.s.setNoDataImg(2131233647);
                FansFragment.this.s.setNoDataStr(R.string.fans_list_hidden);
            } else {
                FansFragment.this.s.setNoDataImg(2131233641);
                if (UserInfo.getInstance().getLoginUserInfo().uid.equals(FansFragment.this.x)) {
                    FansFragment.this.s.setNoDataStr(R.string.no_fans);
                } else {
                    FansFragment.this.s.setNoDataStr(R.string.he_no_fans);
                }
            }
            if (FansFragment.this.r.getCount() != 0) {
                FansFragment.this.s.d();
            } else if (!this.f33853a) {
                FansFragment.this.s.a();
            } else if (this.b == 403903) {
                Log.v("drb", "showNodata");
                FansFragment.this.s.a();
            } else {
                Log.v("drb", "showFail");
                FansFragment.this.s.b();
            }
            if (FansFragment.this.v && FansFragment.this.r.getCount() < 15) {
                FansFragment.a(FansFragment.this);
                FansFragment.this.a(false);
            }
            FansFragment.this.r.notifyDataSetChanged();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedRecommendUsers, FollowedExtra> bluedEntity) {
            if (bluedEntity != null) {
                try {
                    if (bluedEntity.hasMore()) {
                        FansFragment.this.v = true;
                        FansFragment.this.m.o();
                    } else {
                        FansFragment.this.v = false;
                        FansFragment.this.m.p();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) FansFragment.this.k.getResources().getString(2131887272));
                    if (FansFragment.this.t != 1) {
                        FansFragment.f(FansFragment.this);
                        return;
                    }
                    return;
                }
            }
            if (bluedEntity == null || !bluedEntity.hasData()) {
                if (FansFragment.this.t == 1) {
                    FansFragment.this.r.a(bluedEntity.data);
                }
                if (FansFragment.this.t != 1) {
                    FansFragment.f(FansFragment.this);
                    FansFragment.this.v = false;
                    FansFragment.this.m.p();
                    FansFragment.this.m.j();
                    FansFragment.this.m.q();
                }
                AppMethods.a((CharSequence) FansFragment.this.k.getResources().getString(2131887275));
            } else if (FansFragment.this.t == 1) {
                FansFragment.this.r.a(bluedEntity.data);
            } else {
                FansFragment.this.r.b(bluedEntity.data);
            }
            if (bluedEntity == null || bluedEntity.extra == null || bluedEntity.extra.count_repair != 1) {
                FansFragment.this.p.setVisibility(8);
            } else {
                FansFragment.this.p.setVisibility(0);
            }
        }
    };

    static /* synthetic */ int a(FansFragment fansFragment) {
        int i = fansFragment.t;
        fansFragment.t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.t = 1;
        }
        if (this.t == 1) {
            this.v = true;
        }
        if (!this.v && (i = this.t) != 1) {
            this.t = i - 1;
            AppMethods.a((CharSequence) this.k.getResources().getString(2131887275));
            this.m.j();
            this.m.q();
            return;
        }
        MineHttpUtils.d(this.k, this.j, this.x, this.t + "", this.u + "", getFragmentActive());
    }

    static /* synthetic */ int f(FansFragment fansFragment) {
        int i = fansFragment.t;
        fansFragment.t = i - 1;
        return i;
    }

    private void h() {
        this.q = LayoutInflater.from(this.k);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.l.findViewById(2131366898);
        this.m = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        ListView listView = (ListView) this.m.getRefreshableView();
        this.n = listView;
        listView.setClipToPadding(false);
        this.n.setScrollBarStyle(33554432);
        this.n.setHeaderDividersEnabled(false);
        this.n.setDividerHeight(0);
        i();
        if (BluedConstant.d == 1) {
            this.m.k();
            this.w = true;
        }
        RecommendListAdapter recommendListAdapter = new RecommendListAdapter(this.k, 1, j(), getFragmentActive());
        this.r = recommendListAdapter;
        this.n.setAdapter((ListAdapter) recommendListAdapter);
        this.m.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.user.fragment.FansFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                FansFragment.this.t = 1;
                FansFragment.this.a(false);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                FansFragment.a(FansFragment.this);
                FansFragment.this.a(false);
            }
        });
    }

    private void i() {
        View inflate = this.q.inflate(R.layout.layout_normal_followed_header, (ViewGroup) null, false);
        this.o = inflate;
        this.p = (TextView) inflate.findViewById(2131372735);
        String string = getContext().getString(R.string.normal_followed_clean_tip);
        this.p.setText(string);
        TypefaceUtils.a(getContext(), this.p, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.FansFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK);
                MineHttpUtils.e(null, "followers");
                FansFragment.this.p.setVisibility(8);
                AppMethods.d((int) R.string.normal_followed_clean_toast);
            }
        }, new TypefaceUtils.SpannIndex(string.length() - 4, string.length()), new TypefaceUtils.SpannIndex(string.length() - 14, string.length()));
        this.n.addHeaderView(this.o);
        this.p.setVisibility(8);
    }

    private boolean j() {
        return !TextUtils.isEmpty(this.x) && this.x.equals(UserInfo.getInstance().getLoginUserInfo().getUid());
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.k = activity;
        LayoutInflater from = LayoutInflater.from(activity);
        this.l = view;
        ((ViewGroup) view).addView(from.inflate(R.layout.fragment_visit_list, (ViewGroup) null));
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.k);
        this.s = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233641);
        this.s.d();
        if (getArguments() != null) {
            this.x = getArguments().getString("uid");
        }
        if (UserInfo.getInstance().getLoginUserInfo().uid.equals(this.x)) {
            this.s.setNoDataStr(R.string.no_fans);
        } else {
            this.s.setNoDataStr(R.string.he_no_fans);
        }
        ((FrameLayout) this.l.findViewById(2131364048)).addView(this.s);
        h();
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        RenrenPullToRefreshListView renrenPullToRefreshListView;
        super.setUserVisibleHint(z);
        if (!z || this.w || (renrenPullToRefreshListView = this.m) == null) {
            return;
        }
        renrenPullToRefreshListView.k();
        this.w = true;
    }
}
