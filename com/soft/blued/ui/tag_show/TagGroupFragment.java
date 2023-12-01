package com.soft.blued.ui.tag_show;

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
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.FilterInfo;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.group.GroupSearchFragment;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedGroupTypeTags;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/tag_show/TagGroupFragment.class */
public class TagGroupFragment extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
    private LinearLayout A;
    private SearchView B;
    private List<BluedGroupCheck> C;
    private LayoutInflater D;
    private Bundle E;
    private boolean F;
    private String G;

    /* renamed from: c  reason: collision with root package name */
    public BluedGroupCheck.GroupFailureReason f20022c;
    boolean f;
    private RenrenPullToRefreshPinnedSectionListView j;
    private ListView k;
    private List<BluedGroupLists> l;
    private List<BluedGroupLists> m;
    private GroupListsAdapter q;
    private View r;
    private Context s;
    private LayoutInflater t;
    private View u;
    private TextView v;
    private TextView w;
    private List<BluedGroupTypeTags> z;
    private static final String i = TagGroupFragment.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static int f20021a = 0;
    public static String d = "ISNEARBY";
    public static String g = "TAG";
    private int n = 1;
    private int o = 20;
    private boolean p = true;
    private List<FilterInfo> x = new ArrayList();
    private List<FilterInfo> y = new ArrayList();
    List<String> b = new ArrayList();
    int e = 1;
    public BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>() { // from class: com.soft.blued.ui.tag_show.TagGroupFragment.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupLists> bluedEntityA) {
            if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                if (TagGroupFragment.this.n == 1) {
                    TagGroupFragment.this.l.clear();
                    TagGroupFragment.this.q.notifyDataSetChanged();
                }
                if (TagGroupFragment.this.n != 1) {
                    TagGroupFragment.h(TagGroupFragment.this);
                }
                TagGroupFragment.this.j.p();
                return;
            }
            if (bluedEntityA.data.size() >= TagGroupFragment.this.o) {
                TagGroupFragment.this.p = true;
                TagGroupFragment.this.j.o();
            } else {
                TagGroupFragment.this.p = false;
                TagGroupFragment.this.j.p();
            }
            if (TagGroupFragment.this.n == 1) {
                TagGroupFragment.this.l.clear();
                TagGroupFragment.this.m.clear();
            }
            TagGroupFragment.this.l.addAll(bluedEntityA.data);
            TagGroupFragment.this.q.notifyDataSetChanged();
        }

        public void onUIFinish() {
            TagGroupFragment.this.j.j();
            TagGroupFragment.this.j.q();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/tag_show/TagGroupFragment$MyOnItemClickListener.class */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private MyOnItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemClick(adapterView, view, i, j);
            BluedGroupLists bluedGroupLists = (BluedGroupLists) TagGroupFragment.this.l.get(i - 1);
            if (bluedGroupLists == null || bluedGroupLists.is_title == 1) {
                return;
            }
            GroupInfoFragment.a((Fragment) TagGroupFragment.this, bluedGroupLists.groups_gid, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/tag_show/TagGroupFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshPinnedSectionListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        public void a() {
            TagGroupFragment.this.n = 1;
            TagGroupFragment.this.f = false;
            TagGroupFragment.this.e = 1;
            TagGroupFragment.this.a(false);
        }

        public void b() {
            TagGroupFragment.i(TagGroupFragment.this);
            TagGroupFragment.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i2;
        if (z) {
            this.n = 1;
        }
        if (this.n == 1) {
            this.p = true;
        }
        if (!this.p && (i2 = this.n) != 1) {
            this.n = i2 - 1;
            AppMethods.a(this.s.getResources().getString(2131887275));
            this.j.j();
        } else if (StringUtils.d(this.G)) {
            AppMethods.a(getResources().getString(R.string.group_search_prompt));
        } else {
            GroupHttpUtils.a(getActivity(), this.h, this.G, UserFindResult.USER_SORT_BY.NEARBY, this.n + "", this.o + "", getFragmentActive());
        }
    }

    private void b() {
        Bundle arguments = getArguments();
        this.E = arguments;
        if (arguments != null) {
            this.F = arguments.getBoolean(d);
            this.G = this.E.getString(g);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.s.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.t = layoutInflater;
        f20021a = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_group_lists_header, (ViewGroup) null);
        this.u = inflate;
        this.v = (TextView) inflate.findViewById(R.id.tv_same_city);
        this.w = (TextView) this.u.findViewById(R.id.tv_recommended_category);
        SearchView findViewById = this.u.findViewById(R.id.group_search);
        this.B = findViewById;
        findViewById.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.tag_show.TagGroupFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TerminalActivity.d(TagGroupFragment.this.s, GroupSearchFragment.class, (Bundle) null);
            }
        });
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.ll_group_options);
        this.A = linearLayout;
        linearLayout.setVisibility(8);
    }

    private void c() {
        this.D = LayoutInflater.from(this.s);
        this.C = new ArrayList();
        this.f20022c = new BluedGroupCheck.GroupFailureReason();
        this.z = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        RenrenPullToRefreshPinnedSectionListView findViewById = this.r.findViewById(R.id.my_grouplist_pullrefresh);
        this.j = findViewById;
        findViewById.setRefreshEnabled(true);
        this.j.postDelayed(new Runnable() { // from class: com.soft.blued.ui.tag_show.TagGroupFragment.2
            @Override // java.lang.Runnable
            public void run() {
                TagGroupFragment.this.j.k();
            }
        }, 100L);
        this.j.setOnPullDownListener(new MyPullDownListener());
        ListView listView = (ListView) this.j.getRefreshableView();
        this.k = listView;
        listView.setDivider(null);
        this.k.setSelector(new ColorDrawable(0));
        this.k.setOnItemClickListener(new MyOnItemClickListener());
        GroupListsAdapter groupListsAdapter = new GroupListsAdapter(this.s, getFragmentActive(), this.l);
        this.q = groupListsAdapter;
        this.k.setAdapter((ListAdapter) groupListsAdapter);
    }

    static /* synthetic */ int h(TagGroupFragment tagGroupFragment) {
        int i2 = tagGroupFragment.n;
        tagGroupFragment.n = i2 - 1;
        return i2;
    }

    static /* synthetic */ int i(TagGroupFragment tagGroupFragment) {
        int i2 = tagGroupFragment.n;
        tagGroupFragment.n = i2 + 1;
        return i2;
    }

    public void a() {
        this.k.smoothScrollToPosition(0);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 100) {
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
        this.s = getActivity();
        View view = this.r;
        if (view == null) {
            this.r = layoutInflater.inflate(R.layout.fragment_groups_list, viewGroup, false);
            b();
            c();
            CommonTitleDoubleClickObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.r.getParent()).removeView(this.r);
        }
        return this.r;
    }

    public void onDestroy() {
        CommonTitleDoubleClickObserver.a().b(this);
        super.onDestroy();
    }
}
