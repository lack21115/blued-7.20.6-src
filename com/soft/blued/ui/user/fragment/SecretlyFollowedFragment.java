package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.model.SecretlyFollowedExtra;
import com.soft.blued.ui.user.observer.SecretlyFollowedObserver;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/SecretlyFollowedFragment.class */
public class SecretlyFollowedFragment extends BaseFragment implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f33962c;
    private NoDataAndLoadFailView d;
    private RenrenPullToRefreshListView e;
    private ListView f;
    private LayoutInflater g;
    private RecommendListAdapter h;
    private int i;
    private String m;
    private TextView n;
    private TextView o;
    private LinearLayout p;
    private ConstraintLayout q;
    private ImageView r;
    private int j = 20;
    private boolean k = true;
    private boolean l = false;

    /* renamed from: a  reason: collision with root package name */
    BluedUIHttpResponse f33961a = new BluedUIHttpResponse<BluedEntity<BluedRecommendUsers, SecretlyFollowedExtra>>() { // from class: com.soft.blued.ui.user.fragment.SecretlyFollowedFragment.2
        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            SecretlyFollowedFragment.this.l = true;
            if (SecretlyFollowedFragment.this.i != 1) {
                SecretlyFollowedFragment.e(SecretlyFollowedFragment.this);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            SecretlyFollowedFragment.this.e.j();
            SecretlyFollowedFragment.this.e.q();
            if (SecretlyFollowedFragment.this.l) {
                if (SecretlyFollowedFragment.this.h.getCount() == 0) {
                    SecretlyFollowedFragment.this.d.b();
                } else {
                    SecretlyFollowedFragment.this.d.d();
                }
            } else if (SecretlyFollowedFragment.this.h.getCount() == 0) {
                SecretlyFollowedFragment.this.d.a();
            } else {
                SecretlyFollowedFragment.this.d.d();
            }
            SecretlyFollowedFragment.this.h.notifyDataSetChanged();
            SecretlyFollowedFragment.this.l = false;
            if (SecretlyFollowedFragment.this.h.getCount() != 0) {
                SecretlyFollowedFragment.this.q.setVisibility(8);
                if (BluedConfig.a().g().is_secretly_followed == 1 || UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) {
                    SecretlyFollowedFragment.this.p.setVisibility(8);
                } else {
                    SecretlyFollowedFragment.this.p.setVisibility(0);
                }
            } else if (BluedConfig.a().g().is_secretly_followed == 1 || UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) {
                SecretlyFollowedFragment.this.q.setVisibility(8);
                SecretlyFollowedFragment.this.p.setVisibility(8);
            } else {
                ImageLoader.a(SecretlyFollowedFragment.this.getFragmentActive(), ImgURLMap.f10885a.a("cover_follow_secret")).a(SecretlyFollowedFragment.this.r);
                SecretlyFollowedFragment.this.q.setVisibility(0);
                SecretlyFollowedFragment.this.p.setVisibility(8);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedRecommendUsers, SecretlyFollowedExtra> bluedEntity) {
            if (bluedEntity != null) {
                if (bluedEntity.data == null || !bluedEntity.hasData()) {
                    if (SecretlyFollowedFragment.this.i == 1) {
                        SecretlyFollowedFragment.this.h.a(bluedEntity.data);
                    }
                    if (SecretlyFollowedFragment.this.i > 1) {
                        SecretlyFollowedFragment.e(SecretlyFollowedFragment.this);
                        SecretlyFollowedFragment.this.k = false;
                        SecretlyFollowedFragment.this.e.p();
                        AppMethods.a((CharSequence) SecretlyFollowedFragment.this.b.getResources().getString(2131887275));
                    }
                } else {
                    if (bluedEntity.hasMore()) {
                        SecretlyFollowedFragment.this.k = true;
                        SecretlyFollowedFragment.this.e.o();
                    } else {
                        SecretlyFollowedFragment.this.k = false;
                        SecretlyFollowedFragment.this.e.p();
                    }
                    if (SecretlyFollowedFragment.this.i == 1) {
                        SecretlyFollowedFragment.this.h.a(bluedEntity.data);
                    } else {
                        SecretlyFollowedFragment.this.h.b(bluedEntity.data);
                    }
                }
                if (bluedEntity.extra != null) {
                    SecretlyFollowedFragment.this.h.a(bluedEntity.extra);
                    SecretlyFollowedObserver.a().a(bluedEntity.extra.secretly_count, bluedEntity.extra.secretly_followed_limit);
                }
            }
        }
    };

    static /* synthetic */ int a(SecretlyFollowedFragment secretlyFollowedFragment) {
        int i = secretlyFollowedFragment.i;
        secretlyFollowedFragment.i = i + 1;
        return i;
    }

    private void a() {
        if (getArguments() != null) {
            this.m = getArguments().getString("uid");
        }
        this.g = LayoutInflater.from(this.b);
        TextView textView = (TextView) this.f33962c.findViewById(R.id.tv_buy_btn_1);
        this.n = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.f33962c.findViewById(R.id.tv_buy_btn_2);
        this.o = textView2;
        textView2.setOnClickListener(this);
        this.p = (LinearLayout) this.f33962c.findViewById(R.id.ll_buy_area_with_data);
        this.q = (ConstraintLayout) this.f33962c.findViewById(R.id.ll_buy_area_no_data);
        this.r = (ImageView) this.f33962c.findViewById(R.id.iv_cover_follow_secret);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.f33962c.findViewById(2131366898);
        this.e = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        ListView listView = (ListView) this.e.getRefreshableView();
        this.f = listView;
        listView.setClipToPadding(false);
        this.f.setScrollBarStyle(33554432);
        this.f.setHeaderDividersEnabled(false);
        this.f.setDividerHeight(0);
        this.f.setEmptyView(this.d);
        this.e.k();
        RecommendListAdapter recommendListAdapter = new RecommendListAdapter(this.b, 3, b(), getFragmentActive());
        this.h = recommendListAdapter;
        this.f.setAdapter((ListAdapter) recommendListAdapter);
        this.e.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.user.fragment.SecretlyFollowedFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                SecretlyFollowedFragment.this.i = 1;
                SecretlyFollowedFragment.this.a(false);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                SecretlyFollowedFragment.a(SecretlyFollowedFragment.this);
                SecretlyFollowedFragment.this.a(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.i = 1;
        }
        if (this.i == 1) {
            this.k = true;
        }
        if (!this.k && (i = this.i) != 1) {
            this.i = i - 1;
            AppMethods.a((CharSequence) this.b.getResources().getString(2131887275));
            this.e.j();
            this.e.q();
            return;
        }
        MineHttpUtils.f(this.b, this.f33961a, this.m, this.i + "", this.j + "", getFragmentActive());
    }

    private boolean b() {
        return !TextUtils.isEmpty(this.m) && this.m.equals(UserInfo.getInstance().getLoginUserInfo().getUid());
    }

    static /* synthetic */ int e(SecretlyFollowedFragment secretlyFollowedFragment) {
        int i = secretlyFollowedFragment.i;
        secretlyFollowedFragment.i = i - 1;
        return i;
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (z) {
            a(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.tv_buy_btn_1 /* 2131371034 */:
            case R.id.tv_buy_btn_2 /* 2131371035 */:
                InstantLog.a("secretly_follow_buy_btn_click");
                PayUtils.a(this.b, 22, "follow_secret_list");
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        this.g = layoutInflater;
        View view = this.f33962c;
        if (view == null) {
            this.f33962c = layoutInflater.inflate(R.layout.fragment_secretly_followed_list, viewGroup, false);
            NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.b);
            this.d = noDataAndLoadFailView;
            noDataAndLoadFailView.setNoDataImg(2131233641);
            this.d.setNoDataStr(R.string.no_secretly_follow_yet);
            this.d.d();
            a();
            VIPBuyResultObserver.a().a(this, getLifecycle());
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f33962c.getParent()).removeView(this.f33962c);
        }
        return this.f33962c;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
