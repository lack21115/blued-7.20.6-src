package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.model.FollowedExtra;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/NormalFollowedFragment.class */
public class NormalFollowedFragment extends PreloadFragment {
    private Context k;
    private View l;
    private NoDataAndLoadFailView m;
    private RenrenPullToRefreshListView n;
    private ListView o;
    private View p;
    private TextView q;
    private LayoutInflater r;
    private RecommendListAdapter s;
    private int t;
    private String x;
    private int u = 20;
    private boolean v = false;
    private boolean w = false;
    BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntity<BluedRecommendUsers, FollowedExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.NormalFollowedFragment.3

        /* renamed from: a  reason: collision with root package name */
        int f33879a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str, String str2) {
            this.f33879a = i;
            NormalFollowedFragment.this.w = true;
            if (NormalFollowedFragment.this.t != 1) {
                NormalFollowedFragment.f(NormalFollowedFragment.this);
                return true;
            }
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            NormalFollowedFragment.this.n.j();
            NormalFollowedFragment.this.n.q();
            if (TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, NormalFollowedFragment.this.x)) {
                if (this.f33879a == 403903) {
                    NormalFollowedFragment.this.s.a(new ArrayList());
                    NormalFollowedFragment.this.m.setNoDataImg(2131233647);
                    NormalFollowedFragment.this.m.setNoDataStr(R.string.fans_list_hidden);
                } else {
                    NormalFollowedFragment.this.m.setNoDataImg(2131233641);
                    if (UserInfo.getInstance().getLoginUserInfo().uid.equals(NormalFollowedFragment.this.x)) {
                        NormalFollowedFragment.this.m.setNoDataStr(R.string.no_follows);
                    } else {
                        NormalFollowedFragment.this.m.setNoDataStr(R.string.he_no_follows);
                    }
                }
            }
            if (NormalFollowedFragment.this.w) {
                NormalFollowedFragment.this.w = false;
                if (NormalFollowedFragment.this.s.getCount() != 0) {
                    NormalFollowedFragment.this.m.d();
                } else if (this.f33879a == 403903) {
                    NormalFollowedFragment.this.m.a();
                } else {
                    NormalFollowedFragment.this.m.b();
                }
            } else if (NormalFollowedFragment.this.s.getCount() == 0) {
                NormalFollowedFragment.this.m.a();
            } else {
                NormalFollowedFragment.this.m.d();
            }
            if (NormalFollowedFragment.this.v && NormalFollowedFragment.this.s.getCount() < 15) {
                NormalFollowedFragment.a(NormalFollowedFragment.this);
                NormalFollowedFragment.this.a(false);
            }
            NormalFollowedFragment.this.s.notifyDataSetChanged();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedRecommendUsers, FollowedExtra> bluedEntity) {
            if (bluedEntity != null) {
                try {
                    if (bluedEntity.data != null && bluedEntity.hasData()) {
                        if (bluedEntity.hasMore()) {
                            NormalFollowedFragment.this.v = true;
                            NormalFollowedFragment.this.n.o();
                        } else {
                            NormalFollowedFragment.this.v = false;
                            NormalFollowedFragment.this.n.p();
                        }
                        if (NormalFollowedFragment.this.t == 1) {
                            NormalFollowedFragment.this.s.a(bluedEntity.data);
                        } else {
                            NormalFollowedFragment.this.s.b(bluedEntity.data);
                        }
                        if (bluedEntity == null && bluedEntity.extra != null && bluedEntity.extra.count_repair == 1) {
                            NormalFollowedFragment.this.q.setVisibility(0);
                            return;
                        } else {
                            NormalFollowedFragment.this.q.setVisibility(8);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) NormalFollowedFragment.this.k.getResources().getString(2131887272));
                    if (NormalFollowedFragment.this.t != 1) {
                        NormalFollowedFragment.f(NormalFollowedFragment.this);
                        return;
                    }
                    return;
                }
            }
            if (bluedEntity != null && NormalFollowedFragment.this.t == 1) {
                NormalFollowedFragment.this.s.a(bluedEntity.data);
            }
            if (NormalFollowedFragment.this.t > 1) {
                NormalFollowedFragment.f(NormalFollowedFragment.this);
                NormalFollowedFragment.this.v = false;
                NormalFollowedFragment.this.n.p();
                NormalFollowedFragment.this.n.j();
                NormalFollowedFragment.this.n.q();
                AppMethods.a((CharSequence) NormalFollowedFragment.this.k.getResources().getString(2131887275));
            }
            if (bluedEntity == null) {
            }
            NormalFollowedFragment.this.q.setVisibility(8);
        }
    };

    static /* synthetic */ int a(NormalFollowedFragment normalFollowedFragment) {
        int i = normalFollowedFragment.t;
        normalFollowedFragment.t = i + 1;
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
            this.n.j();
            this.n.q();
            return;
        }
        MineHttpUtils.e(this.k, this.j, this.x, this.t + "", this.u + "", getFragmentActive());
    }

    static /* synthetic */ int f(NormalFollowedFragment normalFollowedFragment) {
        int i = normalFollowedFragment.t;
        normalFollowedFragment.t = i - 1;
        return i;
    }

    private void h() {
        this.r = LayoutInflater.from(this.k);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.l.findViewById(2131366898);
        this.n = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        ListView listView = (ListView) this.n.getRefreshableView();
        this.o = listView;
        listView.setClipToPadding(false);
        this.o.setScrollBarStyle(33554432);
        this.o.setHeaderDividersEnabled(false);
        this.o.setDividerHeight(0);
        i();
        this.n.k();
        RecommendListAdapter recommendListAdapter = new RecommendListAdapter(this.k, 2, j(), getFragmentActive());
        this.s = recommendListAdapter;
        this.o.setAdapter((ListAdapter) recommendListAdapter);
        this.n.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.user.fragment.NormalFollowedFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                NormalFollowedFragment.this.t = 1;
                NormalFollowedFragment.this.a(false);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                NormalFollowedFragment.a(NormalFollowedFragment.this);
                NormalFollowedFragment.this.a(false);
            }
        });
    }

    private void i() {
        View inflate = this.r.inflate(R.layout.layout_normal_followed_header, (ViewGroup) null, false);
        this.p = inflate;
        this.q = (TextView) inflate.findViewById(2131372735);
        String string = getContext().getString(R.string.normal_followed_clean_tip);
        this.q.setText(string);
        TypefaceUtils.a(getContext(), this.q, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.NormalFollowedFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK);
                MineHttpUtils.e(null, "followed");
                NormalFollowedFragment.this.q.setVisibility(8);
                AppMethods.d((int) R.string.normal_followed_clean_toast);
            }
        }, new TypefaceUtils.SpannIndex(string.length() - 4, string.length()), new TypefaceUtils.SpannIndex(string.length() - 14, string.length()));
        this.o.addHeaderView(this.p);
        this.q.setVisibility(8);
    }

    private boolean j() {
        return !TextUtils.isEmpty(this.x) && this.x.equals(UserInfo.getInstance().getLoginUserInfo().getUid());
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        this.l = view;
        FragmentActivity activity = getActivity();
        this.k = activity;
        LayoutInflater from = LayoutInflater.from(activity);
        this.r = from;
        from.inflate(R.layout.fragment_visit_list, (ViewGroup) this.l, true);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.k);
        this.m = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233641);
        this.m.d();
        if (getArguments() != null) {
            this.x = getArguments().getString("uid");
        }
        if (UserInfo.getInstance().getLoginUserInfo().uid.equals(this.x)) {
            this.m.setNoDataStr(R.string.no_follows);
        } else {
            this.m.setNoDataStr(R.string.he_no_follows);
        }
        ((FrameLayout) this.l.findViewById(2131364048)).addView(this.m);
        h();
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
