package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.SearchTaskTool;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter;
import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/FriendslistFragment.class */
public class FriendslistFragment extends PreloadFragment implements View.OnClickListener, SearchTaskTool.TaskListener {
    private Context k;
    private View l;
    private RenrenPullToRefreshListView m;
    private ListView n;
    private List<BluedBlackList> o;
    private LayoutInflater p;
    private GoodFriendsListAdapter q;
    private int r;
    private TextView u;
    private TextView v;
    private SearchEditText w;
    private NoDataAndLoadFailView x;
    private int s = 20;
    private boolean t = true;
    BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>() { // from class: com.soft.blued.ui.setting.fragment.FriendslistFragment.4

        /* renamed from: a  reason: collision with root package name */
        boolean f33362a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedBlackList> parseData(String str) {
            return (BluedEntityA) super.parseData(str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedBlackList> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.hasMore()) {
                        FriendslistFragment.this.t = true;
                        FriendslistFragment.this.m.o();
                    } else {
                        FriendslistFragment.this.t = false;
                        FriendslistFragment.this.m.p();
                    }
                } catch (Exception e) {
                    this.f33362a = true;
                    e.printStackTrace();
                    AppMethods.a((CharSequence) FriendslistFragment.this.k.getResources().getString(2131887272));
                    if (FriendslistFragment.this.r != 1) {
                        FriendslistFragment.g(FriendslistFragment.this);
                        return;
                    }
                    return;
                }
            }
            if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                if (FriendslistFragment.this.r != 1) {
                    FriendslistFragment.this.q.b(bluedEntityA.data, "");
                    FriendslistFragment.this.o.addAll(bluedEntityA.data);
                    return;
                }
                FriendslistFragment.this.q.a(bluedEntityA.data, "");
                FriendslistFragment.this.o = bluedEntityA.data;
                return;
            }
            if (FriendslistFragment.this.r == 1) {
                FriendslistFragment.this.q.a(bluedEntityA.data, "");
                FriendslistFragment.this.o = bluedEntityA.data;
            }
            if (FriendslistFragment.this.r != 1) {
                FriendslistFragment.g(FriendslistFragment.this);
                FriendslistFragment.this.t = false;
                FriendslistFragment.this.m.p();
                FriendslistFragment.this.m.j();
                FriendslistFragment.this.m.q();
            }
            if (FriendslistFragment.this.o.size() != 0) {
                AppMethods.a((CharSequence) FriendslistFragment.this.k.getResources().getString(2131887275));
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f33362a = true;
            if (FriendslistFragment.this.r != 1) {
                FriendslistFragment.g(FriendslistFragment.this);
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            FriendslistFragment.this.m.j();
            FriendslistFragment.this.m.q();
            if (FriendslistFragment.this.o == null || FriendslistFragment.this.o.size() == 0) {
                FriendslistFragment.this.m.setVisibility(8);
                if (this.f33362a) {
                    FriendslistFragment.this.x.b();
                } else {
                    FriendslistFragment.this.x.a();
                }
            } else {
                FriendslistFragment.this.m.setVisibility(0);
                FriendslistFragment.this.x.d();
            }
            FriendslistFragment.this.q.notifyDataSetChanged();
            this.f33362a = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.r = 1;
        }
        if (this.r == 1) {
            this.t = true;
        }
        if (!this.t && (i = this.r) != 1) {
            this.r = i - 1;
            AppMethods.a((CharSequence) this.k.getResources().getString(2131887275));
            this.m.j();
            this.m.q();
            return;
        }
        MineHttpUtils.b(this.k, this.j, this.r + "", this.s + "", getFragmentActive());
    }

    static /* synthetic */ int b(FriendslistFragment friendslistFragment) {
        int i = friendslistFragment.r;
        friendslistFragment.r = i + 1;
        return i;
    }

    private void b(String str) {
        MineHttpUtils.b(this.k, new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>() { // from class: com.soft.blued.ui.setting.fragment.FriendslistFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedBlackList> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    FriendslistFragment.this.q.a((List<BluedBlackList>) null, "");
                } else {
                    GoodFriendsListAdapter goodFriendsListAdapter = FriendslistFragment.this.q;
                    List<BluedBlackList> list = bluedEntityA.data;
                    goodFriendsListAdapter.a(list, ((Object) FriendslistFragment.this.w.getText()) + "");
                }
                FriendslistFragment.this.m.p();
            }
        }, str, getFragmentActive());
    }

    static /* synthetic */ int g(FriendslistFragment friendslistFragment) {
        int i = friendslistFragment.r;
        friendslistFragment.r = i - 1;
        return i;
    }

    private void h() {
        this.x = (NoDataAndLoadFailView) this.l.findViewById(2131368079);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.l.findViewById(2131366898);
        this.m = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        ListView listView = (ListView) this.m.getRefreshableView();
        this.n = listView;
        listView.setClipToPadding(false);
        this.n.setScrollBarStyle(33554432);
        this.n.setHeaderDividersEnabled(false);
        this.n.setDividerHeight(0);
        this.m.postDelayed(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.FriendslistFragment.1
            @Override // java.lang.Runnable
            public void run() {
                FriendslistFragment.this.m.k();
            }
        }, 100L);
        this.q = new GoodFriendsListAdapter(this.k, getFragmentActive());
        this.m.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.setting.fragment.FriendslistFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                FriendslistFragment.this.r = 1;
                FriendslistFragment.this.a(false);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                FriendslistFragment.b(FriendslistFragment.this);
                FriendslistFragment.this.a(false);
            }
        });
        this.n.setAdapter((ListAdapter) this.q);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.k = activity;
        this.l = view;
        LayoutInflater from = LayoutInflater.from(activity);
        this.p = from;
        ((ViewGroup) view).addView(from.inflate(R.layout.fragment_my_friend, (ViewGroup) null));
        h();
    }

    @Override // com.blued.android.framework.utils.SearchTaskTool.TaskListener
    public void a(String str) {
        try {
            if (str.length() == 0) {
                this.r = 1;
                a(false);
                return;
            }
            this.v.setVisibility(0);
            this.u.setVisibility(0);
            b(str + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
