package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.FileCache;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.FilterInfo;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedGroupTypeTags;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragmentNear.class */
public class GroupFragmentNear extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {

    /* renamed from: a  reason: collision with root package name */
    public static String f30784a = "NEARBYGROUP1";
    public static String b = "NEARBYGROUP2";

    /* renamed from: c  reason: collision with root package name */
    public static int f30785c = 0;
    public static String f = "ISNEARBY";
    private List<BluedGroupTypeTags> A;
    private LinearLayout B;
    private SearchView C;
    private List<BluedGroupCheck> D;
    private LayoutInflater E;
    private Bundle F;
    private BluedGroupLists G;
    private BluedGroupLists H;
    private NoDataAndLoadFailView I;
    public BluedGroupCheck.GroupFailureReason e;
    boolean h;
    private RenrenPullToRefreshPinnedSectionListView k;
    private ListView l;
    private List<BluedGroupLists> m;
    private List<BluedGroupLists> n;
    private GroupListsAdapter r;
    private View s;
    private Context t;
    private LayoutInflater u;
    private View v;
    private TextView w;
    private TextView x;
    private String j = GroupFragmentNear.class.getSimpleName();
    private int o = 1;
    private int p = 20;
    private boolean q = true;
    private List<FilterInfo> y = new ArrayList();
    private List<FilterInfo> z = new ArrayList();
    List<String> d = new ArrayList();
    int g = 1;
    public BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>() { // from class: com.soft.blued.ui.group.GroupFragmentNear.4

        /* renamed from: a  reason: collision with root package name */
        boolean f30789a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupLists> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                if (GroupFragmentNear.this.o == 1) {
                    GroupFragmentNear.this.m.clear();
                    GroupFragmentNear.this.r.notifyDataSetChanged();
                }
                if (GroupFragmentNear.this.o != 1) {
                    GroupFragmentNear.j(GroupFragmentNear.this);
                }
                GroupFragmentNear.this.k.p();
                return;
            }
            if (bluedEntityA.data.size() >= GroupFragmentNear.this.p) {
                GroupFragmentNear.this.q = true;
                GroupFragmentNear.this.k.o();
            } else {
                GroupFragmentNear.this.q = false;
                GroupFragmentNear.this.k.p();
            }
            if (GroupFragmentNear.this.o == 1) {
                GroupFragmentNear.this.m.clear();
                GroupFragmentNear.this.n.clear();
                if (GroupFragment.f30779a == 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(GroupFragmentNear.this.G);
                    arrayList.add(GroupFragmentNear.this.H);
                    arrayList.addAll(bluedEntityA.data);
                    GroupFragmentNear.this.m.addAll(arrayList);
                } else {
                    GroupFragmentNear.this.m.addAll(bluedEntityA.data);
                }
            } else {
                GroupFragmentNear.this.m.addAll(bluedEntityA.data);
            }
            GroupFragmentNear.this.r.notifyDataSetChanged();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onSuccess(String str) {
            super.onSuccess(str);
            if (GroupFragmentNear.this.o == 1) {
                FileCache.a("default_group_list", str);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f30789a = true;
            if (GroupFragmentNear.this.o != 1) {
                GroupFragmentNear.j(GroupFragmentNear.this);
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            GroupFragmentNear.this.k.j();
            GroupFragmentNear.this.k.q();
            if (GroupFragmentNear.this.r.getCount() != 0) {
                GroupFragmentNear.this.I.d();
            } else if (!this.f30789a) {
                GroupFragmentNear.this.I.a();
            } else {
                this.f30789a = false;
                GroupFragmentNear.this.I.b();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragmentNear$MyOnItemClickListener.class */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private MyOnItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BluedGroupLists bluedGroupLists;
            Tracker.onItemClick(adapterView, view, i, j);
            if (i <= 1 || i > GroupFragmentNear.this.m.size() + 1 || (bluedGroupLists = (BluedGroupLists) GroupFragmentNear.this.m.get(i - 2)) == null || bluedGroupLists.is_title == 1) {
                return;
            }
            GroupInfoFragment.a(GroupFragmentNear.this, bluedGroupLists.groups_gid, UserFindResult.USER_SORT_BY.NEARBY, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragmentNear$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshPinnedSectionListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView.OnPullDownListener
        public void a() {
            GroupFragmentNear.this.o = 1;
            GroupFragmentNear.this.h = false;
            GroupFragmentNear.this.g = 1;
            GroupFragmentNear.this.a(false);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView.OnPullDownListener
        public void b() {
            GroupFragmentNear.l(GroupFragmentNear.this);
            GroupFragmentNear.this.a(false);
        }
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
            AppMethods.a((CharSequence) this.t.getResources().getString(2131887275));
            this.k.j();
        } else if (f30785c == 0) {
            GroupHttpUtils.e(this.t, this.i, this.o + "", this.p + "", getFragmentActive());
        } else {
            GroupHttpUtils.d(this.t, this.i, "hot", this.o + "", this.p + "", "", "", getFragmentActive());
        }
    }

    private void b() {
        Bundle arguments = getArguments();
        this.F = arguments;
        if (arguments != null) {
            BluedGroupLists bluedGroupLists = (BluedGroupLists) arguments.getSerializable(f30784a);
            this.G = bluedGroupLists;
            bluedGroupLists.is_title = 2;
            BluedGroupLists bluedGroupLists2 = (BluedGroupLists) this.F.getSerializable(b);
            this.H = bluedGroupLists2;
            bluedGroupLists2.is_title = 2;
        }
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(FileCache.a("default_group_list"), new TypeToken<BluedEntityA<BluedGroupLists>>() { // from class: com.soft.blued.ui.group.GroupFragmentNear.1
            }.getType());
            if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                return;
            }
            if (GroupFragment.f30779a == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.G);
                arrayList.add(this.H);
                arrayList.addAll(bluedEntityA.data);
                this.m.addAll(arrayList);
            } else {
                this.m.addAll(bluedEntityA.data);
            }
            this.r.notifyDataSetChanged();
            this.g = 1;
            this.h = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        LayoutInflater layoutInflater = (LayoutInflater) this.t.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.u = layoutInflater;
        f30785c = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_group_lists_header, (ViewGroup) null);
        this.v = inflate;
        this.w = (TextView) inflate.findViewById(R.id.tv_same_city);
        this.x = (TextView) this.v.findViewById(R.id.tv_recommended_category);
        SearchView searchView = (SearchView) this.v.findViewById(R.id.group_search);
        this.C = searchView;
        searchView.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.GroupFragmentNear.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TerminalActivity.d(GroupFragmentNear.this.t, GroupSearchFragment.class, null);
            }
        });
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.v.findViewById(R.id.ll_group_options);
        this.B = linearLayout;
        linearLayout.setVisibility(8);
    }

    private void d() {
        this.E = LayoutInflater.from(this.t);
        this.I = (NoDataAndLoadFailView) this.s.findViewById(R.id.nodataview);
        this.D = new ArrayList();
        this.e = new BluedGroupCheck.GroupFailureReason();
        this.A = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        RenrenPullToRefreshPinnedSectionListView renrenPullToRefreshPinnedSectionListView = (RenrenPullToRefreshPinnedSectionListView) this.s.findViewById(R.id.my_grouplist_pullrefresh);
        this.k = renrenPullToRefreshPinnedSectionListView;
        renrenPullToRefreshPinnedSectionListView.setRefreshEnabled(true);
        this.k.postDelayed(new Runnable() { // from class: com.soft.blued.ui.group.GroupFragmentNear.3
            @Override // java.lang.Runnable
            public void run() {
                GroupFragmentNear.this.k.k();
            }
        }, 100L);
        this.k.setOnPullDownListener(new MyPullDownListener());
        ListView listView = (ListView) this.k.getRefreshableView();
        this.l = listView;
        listView.setDivider(null);
        this.l.setSelector(new ColorDrawable(0));
        this.l.setOnItemClickListener(new MyOnItemClickListener());
        this.r = new GroupListsAdapter(this.t, getFragmentActive(), this.m);
        this.l.addHeaderView(this.v);
        this.l.setAdapter((ListAdapter) this.r);
    }

    static /* synthetic */ int j(GroupFragmentNear groupFragmentNear) {
        int i = groupFragmentNear.o;
        groupFragmentNear.o = i - 1;
        return i;
    }

    static /* synthetic */ int l(GroupFragmentNear groupFragmentNear) {
        int i = groupFragmentNear.o;
        groupFragmentNear.o = i + 1;
        return i;
    }

    @Override // com.blued.android.module.common.observer.CommonTitleDoubleClickObserver.ITitleClickObserver
    public void a() {
        this.l.smoothScrollToPosition(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 100) {
            return;
        }
        a(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.t = getActivity();
        View view = this.s;
        if (view == null) {
            this.s = layoutInflater.inflate(R.layout.fragment_groups_list, viewGroup, false);
            c();
            d();
            b();
            CommonTitleDoubleClickObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.s.getParent()).removeView(this.s);
        }
        return this.s;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        CommonTitleDoubleClickObserver.a().b(this);
        super.onDestroy();
    }
}
