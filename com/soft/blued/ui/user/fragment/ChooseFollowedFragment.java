package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.adapter.ChooseFollowedListAdapter;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ChooseFollowedFragment.class */
public class ChooseFollowedFragment extends KeyBoardFragment {
    private Context j;
    private View k;
    private View l;
    private KeyboardListenLinearLayout m;
    private View n;
    private SmartRefreshLayout o;
    private ListView p;
    private NoDataAndLoadFailView q;
    private ChooseFollowedListAdapter r;
    private int s;
    private boolean v;
    private SearchView w;
    private int t = 10;
    private boolean u = true;
    private boolean x = false;
    private int y = 0;
    private boolean z = false;
    BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>() { // from class: com.soft.blued.ui.user.fragment.ChooseFollowedFragment.6
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedRecommendUsers> bluedEntityA) {
            if (bluedEntityA.data == null || !bluedEntityA.hasData()) {
                if (ChooseFollowedFragment.this.s == 1) {
                    ChooseFollowedFragment.this.r.a();
                } else {
                    AppMethods.a(ChooseFollowedFragment.this.j.getResources().getString(2131887275));
                }
            } else if (ChooseFollowedFragment.this.s == 1) {
                ChooseFollowedFragment.this.r.a(bluedEntityA.data);
            } else {
                ChooseFollowedFragment.this.r.b(bluedEntityA.data);
            }
            if (bluedEntityA.extra == null || bluedEntityA.extra.hasmore != 1) {
                ChooseFollowedFragment.this.u = false;
                ChooseFollowedFragment.this.o.l(false);
                return;
            }
            ChooseFollowedFragment.this.u = true;
            ChooseFollowedFragment.this.o.l(true);
        }

        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            ChooseFollowedFragment.this.x = true;
        }

        public void onUIFinish() {
            if (ChooseFollowedFragment.this.x) {
                ChooseFollowedFragment.this.x = false;
                if (ChooseFollowedFragment.this.s != 1) {
                    ChooseFollowedFragment.i(ChooseFollowedFragment.this);
                }
                if (ChooseFollowedFragment.this.r.getCount() == 0) {
                    ChooseFollowedFragment.this.q.b();
                    ChooseFollowedFragment.this.o.l(false);
                } else {
                    ChooseFollowedFragment.this.q.d();
                }
            } else if (ChooseFollowedFragment.this.r.getCount() == 0) {
                ChooseFollowedFragment.this.q.setNoDataStr((int) R.string.no_follows);
                ChooseFollowedFragment.this.q.setNoDataImg(2131233641);
                ChooseFollowedFragment.this.q.a();
                ChooseFollowedFragment.this.o.l(false);
            } else {
                ChooseFollowedFragment.this.q.d();
            }
            ChooseFollowedFragment.this.r.notifyDataSetChanged();
            ChooseFollowedFragment.this.o.j();
            ChooseFollowedFragment.this.o.h();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    BluedUIHttpResponse f20141c = new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>() { // from class: com.soft.blued.ui.user.fragment.ChooseFollowedFragment.7
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedRecommendUsers> bluedEntityA) {
            if (bluedEntityA.data == null || !bluedEntityA.hasData()) {
                if (ChooseFollowedFragment.this.s == 1) {
                    ChooseFollowedFragment.this.r.a();
                } else {
                    AppMethods.a(ChooseFollowedFragment.this.j.getResources().getString(2131887275));
                }
            } else if (ChooseFollowedFragment.this.s == 1) {
                ChooseFollowedFragment.this.r.a(bluedEntityA.data);
            } else {
                ChooseFollowedFragment.this.r.b(bluedEntityA.data);
            }
            if (bluedEntityA.extra == null || bluedEntityA.extra.hasmore != 1) {
                ChooseFollowedFragment.this.u = false;
                ChooseFollowedFragment.this.o.l(false);
                return;
            }
            ChooseFollowedFragment.this.u = true;
            ChooseFollowedFragment.this.o.l(true);
        }

        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            ChooseFollowedFragment.this.x = true;
        }

        public void onUIFinish() {
            if (ChooseFollowedFragment.this.x) {
                ChooseFollowedFragment.this.x = false;
                if (ChooseFollowedFragment.this.s != 1) {
                    ChooseFollowedFragment.i(ChooseFollowedFragment.this);
                }
                if (ChooseFollowedFragment.this.r.getCount() == 0) {
                    ChooseFollowedFragment.this.q.b();
                    ChooseFollowedFragment.this.o.l(false);
                } else {
                    ChooseFollowedFragment.this.q.d();
                }
            } else if (ChooseFollowedFragment.this.r.getCount() == 0) {
                ChooseFollowedFragment.this.q.setNoDataStr(2131891064);
                ChooseFollowedFragment.this.q.setNoDataImg(2131233638);
                ChooseFollowedFragment.this.q.a();
                ChooseFollowedFragment.this.o.l(false);
            } else {
                ChooseFollowedFragment.this.q.d();
            }
            ChooseFollowedFragment.this.r.notifyDataSetChanged();
            ChooseFollowedFragment.this.o.j();
            ChooseFollowedFragment.this.o.h();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("UID", str);
        intent.putExtra("USER_NAME", str2);
        getActivity().setResult(i, intent);
        getActivity().finish();
        ActivityChangeAnimationUtils.c(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.s = 1;
        }
        if (this.s == 1) {
            this.u = true;
        }
        if (!this.u && (i = this.s) != 1) {
            this.s = i - 1;
            AppMethods.a(this.j.getResources().getString(2131887275));
            this.o.j();
            this.o.h();
            return;
        }
        MineHttpUtils.e(this.j, this.b, UserInfo.getInstance().getLoginUserInfo().getUid(), this.s + "", this.t + "", getFragmentActive());
    }

    static /* synthetic */ int f(ChooseFollowedFragment chooseFollowedFragment) {
        int i = chooseFollowedFragment.s;
        chooseFollowedFragment.s = i + 1;
        return i;
    }

    private void h() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.y = arguments.getInt("from");
        }
    }

    static /* synthetic */ int i(ChooseFollowedFragment chooseFollowedFragment) {
        int i = chooseFollowedFragment.s;
        chooseFollowedFragment.s = i - 1;
        return i;
    }

    private void i() {
        CommonTopTitleNoTrans findViewById = this.k.findViewById(2131370694);
        findViewById.a();
        findViewById.setLeftText(2131886885);
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ChooseFollowedFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChooseFollowedFragment.this.a(0, "", "");
            }
        });
        findViewById.setCenterText((int) R.string.at_attention_list);
        SearchView findViewById2 = this.l.findViewById(R.id.search_view);
        this.w = findViewById2;
        findViewById2.getEditView().setHint((int) R.string.at_attention_list_search_hint);
        this.w.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.user.fragment.ChooseFollowedFragment.3
            public void a() {
                KeyboardUtils.a(ChooseFollowedFragment.this.getActivity());
            }

            public void a(String str) {
                if (ChooseFollowedFragment.this.r != null) {
                    ChooseFollowedFragment.this.r.a(str);
                }
                if (StringUtils.d(str)) {
                    ChooseFollowedFragment.this.a(true);
                } else {
                    MineHttpUtils.a(ChooseFollowedFragment.this.j, ChooseFollowedFragment.this.f20141c, str, ChooseFollowedFragment.this.s, ChooseFollowedFragment.this.t, (IRequestHost) ChooseFollowedFragment.this.getFragmentActive());
                }
            }

            public void b() {
            }
        });
        this.m = this.k.findViewById(R.id.keyboardRelativeLayout);
        this.n = this.k.findViewById(R.id.keyboard_view);
        NoDataAndLoadFailView findViewById3 = this.l.findViewById(R.id.no_data_view);
        this.q = findViewById3;
        findViewById3.d();
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.k.findViewById(R.id.refresh_layout);
        this.o = smartRefreshLayout;
        smartRefreshLayout.setBackgroundColor(BluedSkinUtils.a(this.j, 2131101780));
        ListView listView = (ListView) this.k.findViewById(R.id.list_view);
        this.p = listView;
        listView.setBackgroundColor(BluedSkinUtils.a(this.j, 2131101780));
        this.p.setClipToPadding(false);
        this.p.setScrollBarStyle(33554432);
        this.p.setHeaderDividersEnabled(false);
        this.p.setDividerHeight(0);
        this.v = true;
        ChooseFollowedListAdapter chooseFollowedListAdapter = new ChooseFollowedListAdapter(getFragmentActive(), this.j);
        this.r = chooseFollowedListAdapter;
        this.p.setAdapter((ListAdapter) chooseFollowedListAdapter);
        this.p.addHeaderView(this.l);
        this.p.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.ChooseFollowedFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                int i2 = i - 1;
                if (i2 < 0 || i2 >= ChooseFollowedFragment.this.r.getCount()) {
                    return;
                }
                BluedRecommendUsers item = ChooseFollowedFragment.this.r.getItem(i2);
                ChooseFollowedFragment.this.a(-1, item.uid, item.name);
            }
        });
        this.o.a(new OnRefreshLoadMoreListener() { // from class: com.soft.blued.ui.user.fragment.ChooseFollowedFragment.5
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                ChooseFollowedFragment.f(ChooseFollowedFragment.this);
                ChooseFollowedFragment.this.a(false);
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                ChooseFollowedFragment.this.s = 1;
                ChooseFollowedFragment.this.a(false);
            }
        });
        this.o.i();
    }

    public void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void j_(int i) {
        if (BluedConstant.e == BluedConstant.g || BluedConstant.e == BluedConstant.f) {
            return;
        }
        if (i == -3) {
            this.n.setVisibility(0);
            this.n.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.user.fragment.ChooseFollowedFragment.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    Rect rect = new Rect();
                    ChooseFollowedFragment.this.w.getFocusedRect(rect);
                    if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        return false;
                    }
                    KeyboardUtils.a(ChooseFollowedFragment.this.getActivity());
                    return false;
                }
            });
            SearchView searchView = this.w;
            if (searchView != null) {
                searchView.a(true);
            }
        } else if (i != -2) {
        } else {
            this.n.setVisibility(8);
            this.n.setOnTouchListener(null);
            SearchView searchView2 = this.w;
            if (searchView2 != null) {
                searchView2.a(false);
            }
        }
    }

    public boolean onBackPressed() {
        if (this.y == 1) {
            this.z = true;
        }
        a(0, "", "");
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = getActivity();
        View view = this.k;
        if (view == null) {
            this.k = layoutInflater.inflate(R.layout.fragment_choose_followed_list, viewGroup, false);
            this.l = layoutInflater.inflate(R.layout.header_choose_followed_list, (ViewGroup) null, false);
            h();
            i();
            b(this.m);
            ShortVideoProxy.e().a(getClass().getSimpleName());
        } else if (view.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    public void onDestroyView() {
        ShortVideoProxy.e().b(getClass().getSimpleName());
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        if (this.y == 1) {
            AudioManagerUtils.a().a(this.z);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.y == 1) {
            this.z = false;
            AudioManagerUtils.a().b();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        super.setUserVisibleHint(z);
        if (!z || this.v || (smartRefreshLayout = this.o) == null) {
            return;
        }
        smartRefreshLayout.i();
        this.v = true;
    }
}
