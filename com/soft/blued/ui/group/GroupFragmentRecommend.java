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
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedGroupTypeTags;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragmentRecommend.class */
public class GroupFragmentRecommend extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {

    /* renamed from: c  reason: collision with root package name */
    public static String f17102c = "ISNEARBY";
    private static int y;
    private LinearLayout A;
    private List<BluedGroupCheck> B;
    private LayoutInflater C;
    private Bundle D;
    private boolean E;
    private NoDataAndLoadFailView F;
    public BluedGroupCheck.GroupFailureReason b;
    boolean e;
    private RenrenPullToRefreshPinnedSectionListView h;
    private ListView i;
    private List<BluedGroupLists> j;
    private List<BluedGroupLists> k;
    private GroupListsAdapter o;
    private View p;
    private Context q;
    private LayoutInflater r;
    private View s;
    private SearchView t;
    private TextView u;
    private TextView v;
    private List<BluedGroupTypeTags> z;
    private String g = GroupFragmentRecommend.class.getSimpleName();
    private int l = 1;
    private int m = 20;
    private boolean n = true;
    private List<FilterInfo> w = new ArrayList();
    private List<FilterInfo> x = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    List<String> f17103a = new ArrayList();
    int d = 1;
    public BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>() { // from class: com.soft.blued.ui.group.GroupFragmentRecommend.4

        /* renamed from: a  reason: collision with root package name */
        boolean f17107a;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupLists> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                if (GroupFragmentRecommend.this.l == 1) {
                    GroupFragmentRecommend.this.j.clear();
                    GroupFragmentRecommend.this.o.notifyDataSetChanged();
                }
                if (GroupFragmentRecommend.this.l != 1) {
                    GroupFragmentRecommend.h(GroupFragmentRecommend.this);
                }
                GroupFragmentRecommend.this.h.p();
                return;
            }
            if (bluedEntityA.data.size() >= GroupFragmentRecommend.this.m) {
                GroupFragmentRecommend.this.n = true;
                GroupFragmentRecommend.this.h.o();
            } else {
                GroupFragmentRecommend.this.n = false;
                GroupFragmentRecommend.this.h.p();
            }
            if (GroupFragmentRecommend.this.l == 1) {
                GroupFragmentRecommend.this.j.clear();
                GroupFragmentRecommend.this.k.clear();
            }
            GroupFragmentRecommend.this.j.addAll(bluedEntityA.data);
            GroupFragmentRecommend.this.o.notifyDataSetChanged();
        }

        public void onSuccess(String str) {
            super.onSuccess(str);
            FileCache.a("default_group_list", str);
        }

        public boolean onUIFailure(int i, String str) {
            this.f17107a = true;
            if (GroupFragmentRecommend.this.l != 1) {
                GroupFragmentRecommend.h(GroupFragmentRecommend.this);
            }
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            super.onUIFinish();
            GroupFragmentRecommend.this.h.j();
            GroupFragmentRecommend.this.h.q();
            if (GroupFragmentRecommend.this.o.getCount() != 0) {
                GroupFragmentRecommend.this.F.d();
            } else if (!this.f17107a) {
                GroupFragmentRecommend.this.F.a();
            } else {
                this.f17107a = false;
                GroupFragmentRecommend.this.F.b();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragmentRecommend$MyOnItemClickListener.class */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private MyOnItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BluedGroupLists bluedGroupLists;
            Tracker.onItemClick(adapterView, view, i, j);
            if (i <= 1 || i > GroupFragmentRecommend.this.j.size() + 1 || (bluedGroupLists = (BluedGroupLists) GroupFragmentRecommend.this.j.get(i - 2)) == null || bluedGroupLists.is_title == 1) {
                return;
            }
            GroupInfoFragment.a(GroupFragmentRecommend.this, bluedGroupLists.groups_gid, "recommend", 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragmentRecommend$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshPinnedSectionListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        public void a() {
            GroupFragmentRecommend.this.l = 1;
            GroupFragmentRecommend.this.e = false;
            GroupFragmentRecommend.this.d = 1;
            GroupFragmentRecommend.this.a(false);
        }

        public void b() {
            GroupFragmentRecommend.j(GroupFragmentRecommend.this);
            GroupFragmentRecommend.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.l = 1;
        }
        if (this.l == 1) {
            this.n = true;
        }
        if (!this.n && (i = this.l) != 1) {
            this.l = i - 1;
            AppMethods.a(this.q.getResources().getString(2131887275));
            this.h.j();
        } else if (y == 0) {
            GroupHttpUtils.e(this.q, this.f, this.l + "", this.m + "", getFragmentActive());
        } else {
            GroupHttpUtils.d(this.q, this.f, "hot", this.l + "", this.m + "", "", "", getFragmentActive());
        }
    }

    private void b() {
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(FileCache.a("default_group_list"), new TypeToken<BluedEntityA<BluedGroupLists>>() { // from class: com.soft.blued.ui.group.GroupFragmentRecommend.1
            }.getType());
            if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                return;
            }
            this.j.addAll(bluedEntityA.data);
            this.o.notifyDataSetChanged();
            this.d = 1;
            this.e = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        Bundle arguments = getArguments();
        this.D = arguments;
        if (arguments != null) {
            this.E = arguments.getBoolean(f17102c);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.q.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.r = layoutInflater;
        y = 1;
        View inflate = layoutInflater.inflate(R.layout.fragment_group_lists_header, (ViewGroup) null);
        this.s = inflate;
        this.u = (TextView) inflate.findViewById(R.id.tv_same_city);
        this.v = (TextView) this.s.findViewById(R.id.tv_recommended_category);
        this.t = this.s.findViewById(R.id.group_search);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.t.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.GroupFragmentRecommend.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TerminalActivity.d(GroupFragmentRecommend.this.q, GroupSearchFragment.class, (Bundle) null);
            }
        });
        LinearLayout linearLayout = (LinearLayout) this.s.findViewById(R.id.ll_group_options);
        this.A = linearLayout;
        linearLayout.setVisibility(8);
    }

    private void d() {
        this.F = this.p.findViewById(R.id.nodataview);
        this.C = LayoutInflater.from(this.q);
        this.B = new ArrayList();
        this.b = new BluedGroupCheck.GroupFailureReason();
        this.z = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        RenrenPullToRefreshPinnedSectionListView findViewById = this.p.findViewById(R.id.my_grouplist_pullrefresh);
        this.h = findViewById;
        findViewById.setRefreshEnabled(true);
        this.h.postDelayed(new Runnable() { // from class: com.soft.blued.ui.group.GroupFragmentRecommend.3
            @Override // java.lang.Runnable
            public void run() {
                GroupFragmentRecommend.this.h.k();
            }
        }, 100L);
        this.h.setOnPullDownListener(new MyPullDownListener());
        ListView listView = (ListView) this.h.getRefreshableView();
        this.i = listView;
        listView.setDivider(null);
        this.i.setSelector(new ColorDrawable(0));
        this.i.setOnItemClickListener(new MyOnItemClickListener());
        this.o = new GroupListsAdapter(this.q, getFragmentActive(), this.j);
        this.i.addHeaderView(this.s);
        this.i.setAdapter((ListAdapter) this.o);
    }

    static /* synthetic */ int h(GroupFragmentRecommend groupFragmentRecommend) {
        int i = groupFragmentRecommend.l;
        groupFragmentRecommend.l = i - 1;
        return i;
    }

    static /* synthetic */ int j(GroupFragmentRecommend groupFragmentRecommend) {
        int i = groupFragmentRecommend.l;
        groupFragmentRecommend.l = i + 1;
        return i;
    }

    public void a() {
        this.i.smoothScrollToPosition(0);
    }

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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q = getActivity();
        View view = this.p;
        if (view == null) {
            this.p = layoutInflater.inflate(R.layout.fragment_groups_list, viewGroup, false);
            c();
            d();
            b();
            CommonTitleDoubleClickObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.p.getParent()).removeView(this.p);
        }
        return this.p;
    }

    public void onDestroy() {
        CommonTitleDoubleClickObserver.a().b(this);
        super.onDestroy();
    }
}
