package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupAdminSelectAdapter;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.group.model.BluedGroupMemberForJson;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupAdminSelectFragment.class */
public class GroupAdminSelectFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static int f30745a;
    private View d;
    private Context e;
    private EditText f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private List<BluedGroupMemberForJson> j;
    private List<BluedGroupAllMembers> k;
    private List<BluedGroupAllMembers> l;
    private RenrenPullToRefreshListView m;
    private ListView n;
    private GroupAdminSelectAdapter o;
    private String p;
    private boolean q;
    private LayoutInflater r;
    private SearchView s;
    private int u;
    private Runnable v;
    private String w;

    /* renamed from: c  reason: collision with root package name */
    private String f30746c = GroupAdminSelectFragment.class.getSimpleName();
    private int t = 1;
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedGroupMemberForJson>>() { // from class: com.soft.blued.ui.group.GroupAdminSelectFragment.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedGroupMemberForJson> parseData(String str) {
            Logger.a(GroupAdminSelectFragment.this.f30746c, "onSuccess, content:", str);
            return (BluedEntityA) super.parseData(str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupMemberForJson> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (GroupAdminSelectFragment.this.q) {
                        GroupAdminSelectFragment.this.m.p();
                    } else if (bluedEntityA.extra != 0) {
                        GroupAdminSelectFragment.this.u = bluedEntityA.extra.hasmore;
                        if (GroupAdminSelectFragment.this.u == 1) {
                            GroupAdminSelectFragment.this.m.o();
                        } else {
                            GroupAdminSelectFragment.this.m.p();
                        }
                    }
                    if (!bluedEntityA.hasData()) {
                        if (GroupAdminSelectFragment.this.t == 1) {
                            GroupAdminSelectFragment.this.k.clear();
                            GroupAdminSelectFragment.this.o.a(GroupAdminSelectFragment.this.k);
                        } else {
                            GroupAdminSelectFragment.k(GroupAdminSelectFragment.this);
                        }
                        AppMethods.a((CharSequence) GroupAdminSelectFragment.this.e.getResources().getString(2131887275));
                        return;
                    }
                    GroupAdminSelectFragment.this.j.clear();
                    GroupAdminSelectFragment.this.j.addAll(bluedEntityA.data);
                    if (GroupAdminSelectFragment.this.t == 1) {
                        GroupAdminSelectFragment.this.k.clear();
                    }
                    if (((BluedGroupMemberForJson) GroupAdminSelectFragment.this.j.get(0)).members != null) {
                        GroupAdminSelectFragment.this.k.addAll(((BluedGroupMemberForJson) GroupAdminSelectFragment.this.j.get(0)).members);
                    }
                    int size = GroupAdminSelectFragment.this.k.size();
                    if (GroupAdminSelectFragment.this.q && GroupAdminSelectFragment.this.k != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            }
                            if (((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i2)).is_admin.equals("1") || ((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i2)).uid.equals(UserInfo.getInstance().getLoginUserInfo().getUid())) {
                                GroupAdminSelectFragment.this.k.remove(i2);
                            }
                            i = i2 + 1;
                        }
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= GroupAdminSelectFragment.this.k.size()) {
                            break;
                        }
                        ((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i4)).height = StringUtils.a(((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i4)).height, BlueAppLocal.c(), false);
                        ((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i4)).weight = StringUtils.b(((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i4)).weight, BlueAppLocal.c(), false);
                        i3 = i4 + 1;
                    }
                    if (GroupAdminSelectFragment.this.q) {
                        GroupAdminSelectFragment.this.o.a();
                    } else {
                        GroupAdminSelectFragment.this.o.a();
                    }
                    GroupAdminSelectFragment.this.o.a(GroupAdminSelectFragment.this.k);
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) GroupAdminSelectFragment.this.e.getResources().getString(2131887272));
                    if (GroupAdminSelectFragment.this.t != 1) {
                        GroupAdminSelectFragment.k(GroupAdminSelectFragment.this);
                    }
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            if (GroupAdminSelectFragment.this.t != 1) {
                GroupAdminSelectFragment.k(GroupAdminSelectFragment.this);
            }
            super.onFailure(th, i, str);
            Logger.a(GroupAdminSelectFragment.this.f30746c, "onFailure, error:", th);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            Logger.a(GroupAdminSelectFragment.this.f30746c, "onUIFinish");
            GroupAdminSelectFragment.this.m.j();
            GroupAdminSelectFragment.this.m.q();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupAdminSelectFragment$CommonOnDoubleClick.class */
    public class CommonOnDoubleClick implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        int f30751a = 0;
        int b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f30752c = 0;

        CommonOnDoubleClick() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return true;
                }
                view.performClick();
                return true;
            }
            int i = this.f30751a + 1;
            this.f30751a = i;
            if (i == 1) {
                this.b = (int) System.currentTimeMillis();
                return true;
            } else if (i == 2) {
                int currentTimeMillis = (int) System.currentTimeMillis();
                this.f30752c = currentTimeMillis;
                if (currentTimeMillis - this.b < 1000) {
                    GroupAdminSelectFragment.this.n.smoothScrollToPosition(0);
                }
                this.f30751a = 0;
                this.b = 0;
                this.f30752c = 0;
                return true;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupAdminSelectFragment$MyOnItemClickListener.class */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private MyOnItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemClick(adapterView, view, i, j);
            if (i <= 1 || i > GroupAdminSelectFragment.this.k.size() + 2) {
                return;
            }
            String str = null;
            int i2 = i - 2;
            if (!StringUtils.d(((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i2)).uid)) {
                str = ((BluedGroupAllMembers) GroupAdminSelectFragment.this.k.get(i2)).uid;
            }
            Intent intent = new Intent();
            intent.putExtra("uid", str);
            GroupAdminSelectFragment.this.getActivity().setResult(-1, intent);
            GroupAdminSelectFragment.this.getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupAdminSelectFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            GroupAdminSelectFragment.this.t = 1;
            if (GroupAdminSelectFragment.this.q) {
                GroupAdminSelectFragment.this.b();
            } else {
                GroupAdminSelectFragment.this.a();
            }
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            GroupAdminSelectFragment.f(GroupAdminSelectFragment.this);
            if (GroupAdminSelectFragment.this.q || GroupAdminSelectFragment.this.u != 1) {
                return;
            }
            GroupAdminSelectFragment.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.w)) {
            return;
        }
        this.f.removeCallbacks(this.v);
        Runnable runnable = new Runnable() { // from class: com.soft.blued.ui.group.GroupAdminSelectFragment.3
            @Override // java.lang.Runnable
            public void run() {
                GroupAdminSelectFragment.this.b();
            }
        };
        this.v = runnable;
        this.f.postDelayed(runnable, 500L);
    }

    private void c() {
        this.j = new ArrayList();
        this.k = new ArrayList();
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.d.findViewById(R.id.rptrlv_group_member_list);
        this.m = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        this.m.postDelayed(new Runnable() { // from class: com.soft.blued.ui.group.GroupAdminSelectFragment.1
            @Override // java.lang.Runnable
            public void run() {
                GroupAdminSelectFragment.this.m.k();
            }
        }, 100L);
        this.m.setOnPullDownListener(new MyPullDownListener());
        ListView listView = (ListView) this.m.getRefreshableView();
        this.n = listView;
        listView.setDivider(null);
        this.n.setSelector(new ColorDrawable(0));
        this.n.setOnItemClickListener(new MyOnItemClickListener());
        this.g = (LinearLayout) this.d.findViewById(2131367859);
        this.h = (TextView) this.d.findViewById(2131371941);
        TextView textView = (TextView) this.d.findViewById(2131371940);
        this.i = textView;
        textView.setOnClickListener(this);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.p = arguments.getString("gid");
        this.l = new ArrayList();
        this.o = new GroupAdminSelectAdapter(this.e, getFragmentActive(), this.l);
        this.n.addHeaderView(this.s);
        this.n.setAdapter((ListAdapter) this.o);
    }

    private void d() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.d.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setCenterText(getString(R.string.group_admins_select));
        commonTopTitleNoTrans.setLeftClickListener(this);
        ((TextView) commonTopTitleNoTrans.findViewById(2131363108)).setOnTouchListener(new CommonOnDoubleClick());
    }

    private void e() {
        LayoutInflater layoutInflater = (LayoutInflater) this.e.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.r = layoutInflater;
        SearchView searchView = (SearchView) layoutInflater.inflate(R.layout.search_layout, (ViewGroup) null);
        this.s = searchView;
        SearchEditText editView = searchView.getEditView();
        this.f = editView;
        editView.setHint(R.string.group_member_search);
        this.s.setDelaymillis(0L);
        this.s.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.group.GroupAdminSelectFragment.2
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                GroupAdminSelectFragment.this.q = false;
                GroupAdminSelectFragment.this.k.clear();
                GroupAdminSelectFragment.this.o.notifyDataSetChanged();
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String str) {
                if (StringUtils.d(str)) {
                    GroupAdminSelectFragment.this.a();
                    GroupAdminSelectFragment.this.q = false;
                    return;
                }
                GroupAdminSelectFragment.this.a(str);
                GroupAdminSelectFragment.this.q = true;
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
    }

    static /* synthetic */ int f(GroupAdminSelectFragment groupAdminSelectFragment) {
        int i = groupAdminSelectFragment.t;
        groupAdminSelectFragment.t = i + 1;
        return i;
    }

    static /* synthetic */ int k(GroupAdminSelectFragment groupAdminSelectFragment) {
        int i = groupAdminSelectFragment.t;
        groupAdminSelectFragment.t = i - 1;
        return i;
    }

    public void a() {
        if (StringUtils.d(this.p)) {
            return;
        }
        Context context = this.e;
        BluedUIHttpResponse bluedUIHttpResponse = this.b;
        String str = this.p;
        GroupHttpUtils.c(context, bluedUIHttpResponse, str, "desc", this.t + "", "", "", getFragmentActive());
    }

    public void b() {
        if (StringUtils.d(this.p)) {
            return;
        }
        GroupHttpUtils.b(this.e, this.b, this.p, this.f.getText().toString(), "desc", getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        getActivity().setResult(-1);
        getActivity().finish();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().setResult(-1);
        getActivity().finish();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_group_members_list, viewGroup, false);
            e();
            c();
            d();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }
}
