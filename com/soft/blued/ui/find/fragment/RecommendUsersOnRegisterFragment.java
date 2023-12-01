package com.soft.blued.ui.find.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.swipecard.SwipeFlingAdapterView;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.RecommendGridAdapter;
import com.soft.blued.ui.find.adapter.SwipeCardAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.home.HomeArgumentHelper;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/RecommendUsersOnRegisterFragment.class */
public class RecommendUsersOnRegisterFragment extends KeyBoardFragment implements View.OnClickListener, SwipeFlingAdapterView.onFlingListener {

    /* renamed from: c  reason: collision with root package name */
    private Context f30540c;
    private View j;
    private RenrenPullToRefreshListView k;
    private SwipeFlingAdapterView l;
    private ListView m;
    private LayoutInflater n;
    private int o;
    private RecommendGridAdapter r;
    private SwipeCardAdapter s;
    private Dialog t;
    private int p = 30;
    private boolean q = true;
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>() { // from class: com.soft.blued.ui.find.fragment.RecommendUsersOnRegisterFragment.1
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedRecommendUsers> bluedEntityA) {
            RecommendUsersOnRegisterFragment.this.s.a(false);
            if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                RecommendUsersOnRegisterFragment.this.q = false;
                RecommendUsersOnRegisterFragment.this.k.p();
                AppMethods.a((CharSequence) RecommendUsersOnRegisterFragment.this.f30540c.getResources().getString(2131887275));
                RecommendUsersOnRegisterFragment.g(RecommendUsersOnRegisterFragment.this);
                return;
            }
            if (bluedEntityA.data.size() == RecommendUsersOnRegisterFragment.this.p) {
                RecommendUsersOnRegisterFragment.this.q = true;
                RecommendUsersOnRegisterFragment.this.k.o();
            } else {
                RecommendUsersOnRegisterFragment.this.k.p();
                if (RecommendUsersOnRegisterFragment.this.o != 1) {
                    AppMethods.a((CharSequence) RecommendUsersOnRegisterFragment.this.f30540c.getResources().getString(2131887275));
                }
                RecommendUsersOnRegisterFragment.this.q = false;
            }
            if (RecommendUsersOnRegisterFragment.this.o == 1) {
                RecommendUsersOnRegisterFragment.this.r.a(bluedEntityA.data);
                RecommendUsersOnRegisterFragment.this.s.a(bluedEntityA.data);
                return;
            }
            RecommendUsersOnRegisterFragment.this.r.b(bluedEntityA.data);
            RecommendUsersOnRegisterFragment.this.s.b(bluedEntityA.data);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            RecommendUsersOnRegisterFragment.this.s.a(false);
            super.onFailure(th, i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            RecommendUsersOnRegisterFragment.this.k.j();
            RecommendUsersOnRegisterFragment.this.k.q();
            RecommendUsersOnRegisterFragment.this.s.a(false);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
        }
    };

    public static void a(Context context) {
        TerminalActivity.d(context, RecommendUsersOnRegisterFragment.class, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.o = 1;
        }
        if (this.o == 1) {
            this.q = true;
        }
        if (!this.q && (i = this.o) != 1) {
            this.o = i - 1;
            AppMethods.a((CharSequence) this.f30540c.getResources().getString(2131887275));
            this.k.j();
            this.k.q();
            return;
        }
        this.s.a(true);
        LoginRegisterHttpUtils.a(0, this.f30540c, this.b, UserInfo.getInstance().getLoginUserInfo().getUid(), this.o + "", this.p + "", getFragmentActive());
    }

    static /* synthetic */ int g(RecommendUsersOnRegisterFragment recommendUsersOnRegisterFragment) {
        int i = recommendUsersOnRegisterFragment.o;
        recommendUsersOnRegisterFragment.o = i - 1;
        return i;
    }

    static /* synthetic */ int h(RecommendUsersOnRegisterFragment recommendUsersOnRegisterFragment) {
        int i = recommendUsersOnRegisterFragment.o;
        recommendUsersOnRegisterFragment.o = i + 1;
        return i;
    }

    private void h() {
        this.n = LayoutInflater.from(this.f30540c);
        this.t = DialogUtils.a(getActivity());
        this.j.findViewById(R.id.go_home).setOnClickListener(this);
        Context context = this.f30540c;
        this.r = new RecommendGridAdapter(context, PeopleGridQuickAdapter.a(context), this, getFragmentActive(), this.t);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.j.findViewById(2131366898);
        this.k = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        this.k.p();
        ListView listView = (ListView) this.k.getRefreshableView();
        this.m = listView;
        listView.setClipToPadding(false);
        this.m.setScrollBarStyle(33554432);
        this.m.setHeaderDividersEnabled(false);
        this.m.setDividerHeight(0);
        this.m.setAdapter((ListAdapter) this.r);
        this.k.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.find.fragment.RecommendUsersOnRegisterFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                RecommendUsersOnRegisterFragment.this.o = 1;
                RecommendUsersOnRegisterFragment.this.a(false);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                RecommendUsersOnRegisterFragment.h(RecommendUsersOnRegisterFragment.this);
                RecommendUsersOnRegisterFragment.this.a(false);
            }
        });
        this.k.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.RecommendUsersOnRegisterFragment.3
            @Override // java.lang.Runnable
            public void run() {
                RecommendUsersOnRegisterFragment.this.k.k();
            }
        }, 100L);
        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) this.j.findViewById(R.id.swipe_view);
        this.l = swipeFlingAdapterView;
        swipeFlingAdapterView.setFlingListener(this);
        SwipeCardAdapter swipeCardAdapter = new SwipeCardAdapter(this.f30540c, this.l, this, getFragmentActive(), this.t);
        this.s = swipeCardAdapter;
        this.l.setAdapter(swipeCardAdapter);
        this.l.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.find.fragment.RecommendUsersOnRegisterFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((motionEvent.getRawY() < RecommendUsersOnRegisterFragment.this.l.b || motionEvent.getRawY() > RecommendUsersOnRegisterFragment.this.l.e) && RecommendUsersOnRegisterFragment.this.l.f28663a != null && RecommendUsersOnRegisterFragment.this.l.f28663a.getX() == RecommendUsersOnRegisterFragment.this.l.f28664c) {
                    RecommendUsersOnRegisterFragment.this.r.notifyDataSetChanged();
                    RecommendUsersOnRegisterFragment.this.l.setVisibility(8);
                    return true;
                }
                return true;
            }
        });
        this.s.a(new SwipeCardAdapter.SwipeCardListener() { // from class: com.soft.blued.ui.find.fragment.RecommendUsersOnRegisterFragment.5
            @Override // com.soft.blued.ui.find.adapter.SwipeCardAdapter.SwipeCardListener
            public void a() {
                RecommendUsersOnRegisterFragment.h(RecommendUsersOnRegisterFragment.this);
                RecommendUsersOnRegisterFragment.this.a(false);
            }
        });
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a() {
        this.s.a(0);
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a(float f, float f2) {
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a(int i) {
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a(Object obj) {
        this.s.c();
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void b(Object obj) {
        this.s.b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        getActivity().setResult(-1);
        Bundle bundle = new Bundle();
        bundle.putString("from_tag_page", "from_tag_register");
        HomeArgumentHelper.a(getActivity(), (Bundle) null, bundle);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131362970) {
            this.r.notifyDataSetChanged();
            this.l.setVisibility(8);
        } else if (id == 2131364106) {
            onBackPressed();
        } else {
            switch (id) {
                case R.id.header_view1 /* 2131364233 */:
                case R.id.header_view2 /* 2131364234 */:
                case R.id.header_view3 /* 2131364235 */:
                case R.id.header_view4 /* 2131364236 */:
                    this.s.b(((Integer) view.getTag()).intValue());
                    this.l.f28663a = null;
                    this.s.c(((Integer) view.getTag()).intValue());
                    this.l.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30540c = getActivity();
        View view = this.j;
        if (view == null) {
            this.j = layoutInflater.inflate(R.layout.fragment_recommend_user_on_register, viewGroup, false);
            h();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        return this.j;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
