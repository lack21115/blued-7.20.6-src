package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupMemberListAdapter;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.group.model.BluedGroupMemberForJson;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupMembersListFragment.class */
public class GroupMembersListFragment extends KeyBoardFragment implements View.OnClickListener {
    public static List<String> j = new ArrayList();
    public static int k = 0;
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    private List<BluedGroupMemberForJson> A;
    private List<BluedGroupAllMembers> B;
    private RenrenPullToRefreshListView C;
    private ListView D;
    private GroupMemberListAdapter E;
    private String[] F;
    private String G;
    private String K;
    private boolean L;
    private LayoutInflater M;
    private SearchView N;
    private int P;
    public Dialog b;

    /* renamed from: c  reason: collision with root package name */
    public List<BluedGroupAllMembers> f30818c;
    public List<BluedGroupAllMembers> l;
    public List<BluedGroupAllMembers> m;
    private KeyboardListenLinearLayout u;
    private Context v;
    private EditText w;
    private LinearLayout x;
    private TextView y;
    private TextView z;
    private String t = GroupMembersListFragment.class.getSimpleName();
    private String[] H = new String[4];
    private String[] I = new String[3];
    private String[] J = new String[2];
    private String O = "";
    private int Q = 1;
    private final int R = 30;
    private String S = "desc";
    public BluedUIHttpResponse r = new BluedUIHttpResponse<BluedEntityA<BluedGroupMemberForJson>>() { // from class: com.soft.blued.ui.group.GroupMembersListFragment.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedGroupMemberForJson> parseData(String str) {
            Logger.a(GroupMembersListFragment.this.t, "onSuccess, content:", str);
            return (BluedEntityA) super.parseData(str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupMemberForJson> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (GroupMembersListFragment.this.L) {
                        GroupMembersListFragment.this.C.p();
                    } else if (bluedEntityA.extra != 0) {
                        GroupMembersListFragment.this.P = bluedEntityA.extra.hasmore;
                        if (GroupMembersListFragment.this.P == 1) {
                            GroupMembersListFragment.this.C.o();
                        } else {
                            GroupMembersListFragment.this.C.p();
                        }
                    }
                    if (!bluedEntityA.hasData()) {
                        if (GroupMembersListFragment.this.Q != 1) {
                            GroupMembersListFragment.l(GroupMembersListFragment.this);
                            return;
                        }
                        GroupMembersListFragment.this.l.clear();
                        GroupMembersListFragment.this.E.a(GroupMembersListFragment.this.l);
                        return;
                    }
                    GroupMembersListFragment.this.A.clear();
                    GroupMembersListFragment.this.A.addAll(bluedEntityA.data);
                    GroupMembersListFragment.this.B.clear();
                    GroupMembersListFragment.this.f30818c.clear();
                    if (((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).members != null) {
                        GroupMembersListFragment.this.B.addAll(((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).members);
                    }
                    if (((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).admins != null) {
                        GroupMembersListFragment.this.f30818c.addAll(((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).admins);
                        GroupMembersListFragment.k = GroupMembersListFragment.this.f30818c.size();
                    }
                    GroupMembersListFragment.this.l.clear();
                    if (((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).created != null) {
                        GroupMembersListFragment.this.l.add(((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).created);
                        GroupMembersListFragment.this.K = ((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).created.uid;
                    }
                    if (((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).admins != null) {
                        GroupMembersListFragment.this.l.addAll(GroupMembersListFragment.this.f30818c);
                    }
                    if (GroupMembersListFragment.o.equals("1") && GroupMembersListFragment.q.equals("0") && ((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).self != null) {
                        GroupMembersListFragment.this.l.add(((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).self);
                    }
                    GroupMembersListFragment.this.l.addAll(GroupMembersListFragment.this.B);
                    if (((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).admins != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= ((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).admins.size()) {
                                break;
                            }
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < GroupMembersListFragment.this.l.size()) {
                                    if (((BluedGroupMemberForJson) GroupMembersListFragment.this.A.get(0)).admins.get(i2).uid.equals(GroupMembersListFragment.this.l.get(i4).uid)) {
                                        GroupMembersListFragment.this.l.get(i4).is_admin = "1";
                                    }
                                    i3 = i4 + 1;
                                }
                            }
                            i = i2 + 1;
                        }
                    }
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= GroupMembersListFragment.this.l.size()) {
                            break;
                        }
                        if (GroupMembersListFragment.this.K.equals(GroupMembersListFragment.this.l.get(i6).uid)) {
                            GroupMembersListFragment.this.l.get(i6).is_creator = "1";
                        } else {
                            GroupMembersListFragment.this.l.get(i6).is_creator = "0";
                        }
                        i5 = i6 + 1;
                    }
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= GroupMembersListFragment.this.l.size()) {
                            break;
                        }
                        GroupMembersListFragment.this.l.get(i8).height = StringUtils.a(GroupMembersListFragment.this.l.get(i8).height, BlueAppLocal.c(), false);
                        GroupMembersListFragment.this.l.get(i8).weight = StringUtils.b(GroupMembersListFragment.this.l.get(i8).weight, BlueAppLocal.c(), false);
                        i7 = i8 + 1;
                    }
                    if (GroupMembersListFragment.this.L) {
                        GroupMembersListFragment.this.E.a();
                    } else if (GroupMembersListFragment.this.Q == 1) {
                        GroupMembersListFragment.this.E.a();
                    }
                    GroupMembersListFragment.this.E.a(GroupMembersListFragment.this.l);
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) GroupMembersListFragment.this.v.getResources().getString(2131887272));
                    if (GroupMembersListFragment.this.Q != 1) {
                        GroupMembersListFragment.l(GroupMembersListFragment.this);
                    }
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            if (GroupMembersListFragment.this.Q != 1) {
                GroupMembersListFragment.l(GroupMembersListFragment.this);
            }
            super.onFailure(th, i, str);
            Logger.a(GroupMembersListFragment.this.t, "onFailure, error:", th);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            Logger.a(GroupMembersListFragment.this.t, "onUIFinish");
            GroupMembersListFragment.this.C.j();
            GroupMembersListFragment.this.C.q();
        }
    };
    public BluedUIHttpResponse s = new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.group.GroupMembersListFragment.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<Object> parseData(String str) {
            Logger.a(GroupMembersListFragment.this.t, "onSuccess, content:", str);
            return (BluedEntityA) super.parseData(str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data != null) {
                        AppMethods.d((int) R.string.group_remove_member);
                        GroupMembersListFragment.n = String.valueOf(StringUtils.c(GroupMembersListFragment.n) - GroupMembersListFragment.j.size());
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= GroupMembersListFragment.this.l.size()) {
                                break;
                            }
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < GroupMembersListFragment.this.F.length) {
                                    if (GroupMembersListFragment.this.l.get(i2).uid.equals(GroupMembersListFragment.this.F[i4])) {
                                        GroupMembersListFragment.this.l.remove(GroupMembersListFragment.this.l.get(i2));
                                        GroupMembersListFragment.j.clear();
                                    }
                                    i3 = i4 + 1;
                                }
                            }
                            i = i2 + 1;
                        }
                        if (GroupMembersListFragment.this.L) {
                            GroupMembersListFragment.this.i();
                        } else {
                            GroupMembersListFragment.this.h();
                        }
                        GroupMembersListFragment.this.x.setVisibility(8);
                        GroupMembersListFragment.this.E.f30909a = false;
                        GroupMembersListFragment.this.z.setText(GroupMembersListFragment.this.v.getResources().getString(2131886885));
                        GroupMembersListFragment.this.E.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            Logger.a(GroupMembersListFragment.this.t, "onFailure, error:", th);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            Logger.a(GroupMembersListFragment.this.t, "onUIFinish");
            DialogUtils.b(GroupMembersListFragment.this.b);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(GroupMembersListFragment.this.b);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupMembersListFragment$CommonOnDoubleClick.class */
    public class CommonOnDoubleClick implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        int f30826a = 0;
        int b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f30827c = 0;

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
            int i = this.f30826a + 1;
            this.f30826a = i;
            if (i == 1) {
                this.b = (int) System.currentTimeMillis();
                return true;
            } else if (i == 2) {
                int currentTimeMillis = (int) System.currentTimeMillis();
                this.f30827c = currentTimeMillis;
                if (currentTimeMillis - this.b < 1000) {
                    GroupMembersListFragment.this.D.smoothScrollToPosition(0);
                }
                this.f30826a = 0;
                this.b = 0;
                this.f30827c = 0;
                return true;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupMembersListFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            GroupMembersListFragment.this.Q = 1;
            if (GroupMembersListFragment.this.L) {
                GroupMembersListFragment.this.i();
            } else {
                GroupMembersListFragment.this.h();
            }
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            GroupMembersListFragment.e(GroupMembersListFragment.this);
            if (GroupMembersListFragment.this.L || GroupMembersListFragment.this.P != 1) {
                return;
            }
            GroupMembersListFragment.this.h();
        }
    }

    static /* synthetic */ int e(GroupMembersListFragment groupMembersListFragment) {
        int i = groupMembersListFragment.Q;
        groupMembersListFragment.Q = i + 1;
        return i;
    }

    private void j() {
        this.H[0] = this.v.getResources().getString(R.string.group_members_sort_desc);
        this.H[1] = this.v.getResources().getString(R.string.group_members_sort_asc);
        this.H[2] = this.v.getResources().getString(R.string.group_members_invite);
        this.H[3] = this.v.getResources().getString(2131888467);
        this.I[0] = this.v.getResources().getString(R.string.group_members_sort_desc);
        this.I[1] = this.v.getResources().getString(R.string.group_members_sort_asc);
        this.I[2] = this.v.getResources().getString(R.string.group_members_invite);
        this.J[0] = this.v.getResources().getString(R.string.group_members_sort_desc);
        this.J[1] = this.v.getResources().getString(R.string.group_members_sort_asc);
    }

    private void k() {
        this.b = DialogUtils.a(this.v);
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.f30818c = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.u.findViewById(R.id.rptrlv_group_member_list);
        this.C = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        this.C.postDelayed(new Runnable() { // from class: com.soft.blued.ui.group.GroupMembersListFragment.1
            @Override // java.lang.Runnable
            public void run() {
                GroupMembersListFragment.this.C.k();
            }
        }, 100L);
        this.C.setOnPullDownListener(new MyPullDownListener());
        ListView listView = (ListView) this.C.getRefreshableView();
        this.D = listView;
        listView.setDivider(null);
        this.D.setSelector(new ColorDrawable(0));
        this.x = (LinearLayout) this.u.findViewById(2131367859);
        this.y = (TextView) this.u.findViewById(2131371941);
        TextView textView = (TextView) this.u.findViewById(2131371940);
        this.z = textView;
        textView.setOnClickListener(this);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        n = arguments.getString("membersCount");
        this.G = arguments.getString("gid");
        o = arguments.getString("member");
        p = arguments.getString("admin");
        q = arguments.getString("creator");
        this.O = arguments.getString("group_info_json");
        j.clear();
        TextView textView2 = this.y;
        textView2.setText(" (" + j.size() + BridgeUtil.SPLIT_MARK + n + ") ");
        this.E = new GroupMemberListAdapter(this.v, getFragmentActive(), this.m, this.y, this.z);
    }

    static /* synthetic */ int l(GroupMembersListFragment groupMembersListFragment) {
        int i = groupMembersListFragment.Q;
        groupMembersListFragment.Q = i - 1;
        return i;
    }

    private void l() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.u.findViewById(2131370749);
        commonTopTitleNoTrans.setCenterText(R.string.group_member_list);
        commonTopTitleNoTrans.setRightImg(2131233917);
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.setRightClickListener(this);
        ((TextView) commonTopTitleNoTrans.findViewById(2131363108)).setOnTouchListener(new CommonOnDoubleClick());
    }

    private void m() {
        LayoutInflater layoutInflater = (LayoutInflater) this.v.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.M = layoutInflater;
        SearchView searchView = (SearchView) layoutInflater.inflate(R.layout.search_layout, (ViewGroup) this.D, false);
        this.N = searchView;
        SearchEditText editView = searchView.getEditView();
        this.w = editView;
        editView.setHint(R.string.group_member_search);
        this.N.setDelaymillis(0L);
        this.N.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.group.GroupMembersListFragment.2
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                KeyboardUtils.a(GroupMembersListFragment.this.getActivity());
                GroupMembersListFragment.this.L = false;
                GroupMembersListFragment.this.l.clear();
                GroupMembersListFragment.this.E.notifyDataSetChanged();
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String str) {
                if (StringUtils.d(str)) {
                    GroupMembersListFragment.this.h();
                    GroupMembersListFragment.this.L = false;
                    return;
                }
                GroupMembersListFragment.this.i();
                GroupMembersListFragment.this.L = true;
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
        this.D.addHeaderView(this.N);
        this.D.setAdapter((ListAdapter) this.E);
    }

    public void h() {
        if (StringUtils.d(this.G)) {
            return;
        }
        Context context = this.v;
        BluedUIHttpResponse bluedUIHttpResponse = this.r;
        String str = this.G;
        String str2 = this.S;
        GroupHttpUtils.c(context, bluedUIHttpResponse, str, str2, this.Q + "", BaseWrapper.ENTER_ID_TOOLKIT, "", getFragmentActive());
    }

    public void i() {
        if (StringUtils.d(this.G)) {
            return;
        }
        GroupHttpUtils.b(this.v, this.r, this.G, this.w.getText().toString(), "desc", getFragmentActive());
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        SearchView searchView;
        if (i != -3) {
            if (i == -2 && (searchView = this.N) != null) {
                searchView.a(false);
                return;
            }
            return;
        }
        SearchView searchView2 = this.N;
        if (searchView2 != null) {
            searchView2.a(true);
        }
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
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().setResult(-1);
            getActivity().finish();
        } else if (id == 2131363126) {
            if (this.l.size() > 0) {
                if (!o.equals("1")) {
                    CommonShowBottomWindow.a(getActivity(), this.J, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.group.GroupMembersListFragment.7
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            if (i == 0) {
                                if (StringUtils.d(GroupMembersListFragment.this.G)) {
                                    return;
                                }
                                if (GroupMembersListFragment.this.L) {
                                    GroupHttpUtils.b(GroupMembersListFragment.this.v, GroupMembersListFragment.this.r, GroupMembersListFragment.this.G, GroupMembersListFragment.this.w.getText().toString(), "desc", GroupMembersListFragment.this.getFragmentActive());
                                    return;
                                }
                                GroupMembersListFragment.this.Q = 1;
                                GroupMembersListFragment.this.S = "desc";
                                GroupMembersListFragment.this.C.k();
                            } else if (StringUtils.d(GroupMembersListFragment.this.G)) {
                            } else {
                                if (GroupMembersListFragment.this.L) {
                                    GroupHttpUtils.b(GroupMembersListFragment.this.v, GroupMembersListFragment.this.r, GroupMembersListFragment.this.G, GroupMembersListFragment.this.w.getText().toString(), "asc", GroupMembersListFragment.this.getFragmentActive());
                                    return;
                                }
                                GroupMembersListFragment.this.Q = 1;
                                GroupMembersListFragment.this.S = "asc";
                                GroupMembersListFragment.this.C.k();
                            }
                        }

                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                } else if (q.equals("1") || p.equals("1")) {
                    CommonShowBottomWindow.a(getActivity(), this.H, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.group.GroupMembersListFragment.5
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            if (i == 0) {
                                if (StringUtils.d(GroupMembersListFragment.this.G)) {
                                    return;
                                }
                                if (GroupMembersListFragment.this.L) {
                                    GroupHttpUtils.b(GroupMembersListFragment.this.v, GroupMembersListFragment.this.r, GroupMembersListFragment.this.G, GroupMembersListFragment.this.w.getText().toString(), "desc", GroupMembersListFragment.this.getFragmentActive());
                                    return;
                                }
                                GroupMembersListFragment.this.Q = 1;
                                GroupMembersListFragment.this.S = "desc";
                                GroupMembersListFragment.this.C.k();
                            } else if (i == 1) {
                                if (StringUtils.d(GroupMembersListFragment.this.G)) {
                                    return;
                                }
                                if (GroupMembersListFragment.this.L) {
                                    GroupHttpUtils.b(GroupMembersListFragment.this.v, GroupMembersListFragment.this.r, GroupMembersListFragment.this.G, GroupMembersListFragment.this.w.getText().toString(), "asc", GroupMembersListFragment.this.getFragmentActive());
                                    return;
                                }
                                GroupMembersListFragment.this.Q = 1;
                                GroupMembersListFragment.this.S = "asc";
                                GroupMembersListFragment.this.C.k();
                            } else if (i == 2) {
                                GroupMemberInviteFragment.a(GroupMembersListFragment.this.v, GroupMembersListFragment.this.O);
                            } else {
                                GroupMembersListFragment.this.x.setVisibility(0);
                                TextView textView = GroupMembersListFragment.this.y;
                                textView.setText(" (" + GroupMembersListFragment.j.size() + BridgeUtil.SPLIT_MARK + GroupMembersListFragment.n + ") ");
                                GroupMembersListFragment.this.E.f30909a = true;
                                GroupMembersListFragment.this.E.notifyDataSetChanged();
                            }
                        }

                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                } else {
                    CommonShowBottomWindow.a(getActivity(), this.J, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.group.GroupMembersListFragment.6
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            if (i == 0) {
                                if (StringUtils.d(GroupMembersListFragment.this.G)) {
                                    return;
                                }
                                if (GroupMembersListFragment.this.L) {
                                    GroupHttpUtils.b(GroupMembersListFragment.this.v, GroupMembersListFragment.this.r, GroupMembersListFragment.this.G, GroupMembersListFragment.this.w.getText().toString(), "desc", GroupMembersListFragment.this.getFragmentActive());
                                    return;
                                }
                                GroupMembersListFragment.this.Q = 1;
                                GroupMembersListFragment.this.S = "desc";
                                GroupMembersListFragment.this.C.k();
                            } else if (i != 1 || StringUtils.d(GroupMembersListFragment.this.G)) {
                            } else {
                                if (GroupMembersListFragment.this.L) {
                                    GroupHttpUtils.b(GroupMembersListFragment.this.v, GroupMembersListFragment.this.r, GroupMembersListFragment.this.G, GroupMembersListFragment.this.w.getText().toString(), "asc", GroupMembersListFragment.this.getFragmentActive());
                                    return;
                                }
                                GroupMembersListFragment.this.Q = 1;
                                GroupMembersListFragment.this.S = "asc";
                                GroupMembersListFragment.this.C.k();
                            }
                        }

                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                }
            }
        } else if (id != 2131371940) {
        } else {
            String[] strArr = new String[j.size()];
            this.F = strArr;
            String[] strArr2 = (String[]) j.toArray(strArr);
            this.F = strArr2;
            if (strArr2.length != 0) {
                GroupHttpUtils.a(getActivity(), this.s, this.G, this.F, getFragmentActive());
            } else {
                this.x.setVisibility(8);
                this.E.f30909a = false;
            }
            this.E.notifyDataSetChanged();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.v = getActivity();
        KeyboardListenLinearLayout keyboardListenLinearLayout = this.u;
        if (keyboardListenLinearLayout == null) {
            KeyboardListenLinearLayout keyboardListenLinearLayout2 = (KeyboardListenLinearLayout) layoutInflater.inflate(R.layout.fragment_group_members_list, viewGroup, false);
            this.u = keyboardListenLinearLayout2;
            super.a(keyboardListenLinearLayout2);
            k();
            m();
            l();
            j();
        } else if (keyboardListenLinearLayout.getParent() != null) {
            ((ViewGroup) this.u.getParent()).removeView(this.u);
        }
        return this.u;
    }
}
