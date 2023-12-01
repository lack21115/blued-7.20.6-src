package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupSearchResultFragment.class */
public class GroupSearchResultFragment extends PreloadFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
    private List<BluedGroupCheck> A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private Dialog G;
    public ListView j;
    public BluedGroupCheck.GroupFailureReason k;
    private RenrenPullToRefreshListView o;
    private LinearLayout p;
    private Button q;
    private GroupListsAdapter v;
    private View w;
    private Context x;
    private int y;
    private String z;
    private String n = GroupSearchResultFragment.class.getSimpleName();
    private List<BluedGroupLists> r = new ArrayList();
    private int s = 1;
    private int t = 10;
    private boolean u = true;
    public BluedUIHttpResponse l = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>() { // from class: com.soft.blued.ui.group.GroupSearchResultFragment.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupLists> bluedEntityA) {
            try {
                if (!bluedEntityA.hasData()) {
                    if (GroupSearchResultFragment.this.s == 1) {
                        GroupSearchResultFragment.this.r.clear();
                        GroupSearchResultFragment.this.v.notifyDataSetChanged();
                    }
                    if (GroupSearchResultFragment.this.s != 1) {
                        GroupSearchResultFragment.g(GroupSearchResultFragment.this);
                    }
                    GroupSearchResultFragment.this.o.p();
                    return;
                }
                GroupSearchResultFragment.this.p.setVisibility(8);
                if (bluedEntityA.data.size() >= GroupSearchResultFragment.this.t) {
                    GroupSearchResultFragment.this.u = true;
                    GroupSearchResultFragment.this.o.o();
                } else {
                    GroupSearchResultFragment.this.u = false;
                    GroupSearchResultFragment.this.o.p();
                }
                if (GroupSearchResultFragment.this.s == 1) {
                    GroupSearchResultFragment.this.r.clear();
                }
                GroupSearchResultFragment.this.r.addAll(bluedEntityA.data);
                GroupSearchResultFragment.this.v.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.a((CharSequence) GroupSearchResultFragment.this.x.getResources().getString(2131887272));
                if (GroupSearchResultFragment.this.s != 1) {
                    GroupSearchResultFragment.g(GroupSearchResultFragment.this);
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            GroupSearchResultFragment.this.o.j();
            GroupSearchResultFragment.this.o.q();
            if (GroupSearchResultFragment.this.r.size() == 0) {
                GroupSearchResultFragment.this.o.setVisibility(8);
                GroupSearchResultFragment.this.p.setVisibility(0);
                GroupSearchResultFragment.this.q.setVisibility(0);
            }
        }
    };
    public BluedUIHttpResponse m = new BluedUIHttpResponse<BluedEntityA<BluedGroupCheck>>() { // from class: com.soft.blued.ui.group.GroupSearchResultFragment.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupCheck> bluedEntityA) {
            try {
                if (bluedEntityA.hasData()) {
                    GroupSearchResultFragment.this.A.clear();
                    GroupSearchResultFragment.this.A.addAll(bluedEntityA.data);
                    if (StringUtils.d(bluedEntityA.data.get(0).toString())) {
                        return;
                    }
                    if ("1".equals(((BluedGroupCheck) GroupSearchResultFragment.this.A.get(0)).getAble())) {
                        TerminalActivity.d(GroupSearchResultFragment.this.getActivity(), GroupCreateFragment.class, null);
                    } else if ("0".equals(((BluedGroupCheck) GroupSearchResultFragment.this.A.get(0)).getAble())) {
                        GroupSearchResultFragment.this.k = ((BluedGroupCheck) GroupSearchResultFragment.this.A.get(0)).getReason();
                        GroupSearchResultFragment.this.B = GroupSearchResultFragment.this.k.getDays().getAble();
                        GroupSearchResultFragment.this.D = GroupSearchResultFragment.this.k.getDays().getReason();
                        GroupSearchResultFragment.this.C = GroupSearchResultFragment.this.k.getNum().getAble();
                        GroupSearchResultFragment.this.E = GroupSearchResultFragment.this.k.getNum().getReason().get(0);
                        GroupSearchResultFragment.this.F = GroupSearchResultFragment.this.k.getNum().getReason().get(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(GroupCreateFragment.f30760c, GroupSearchResultFragment.this.D);
                        bundle.putString(GroupCreateFragment.d, GroupSearchResultFragment.this.E);
                        bundle.putString(GroupCreateFragment.e, GroupSearchResultFragment.this.F);
                        bundle.putString(GroupCreateFragment.f, GroupSearchResultFragment.this.B);
                        bundle.putString(GroupCreateFragment.g, GroupSearchResultFragment.this.C);
                        TerminalActivity.d(GroupSearchResultFragment.this.getActivity(), GroupCreateFragment.class, bundle);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.a((CharSequence) GroupSearchResultFragment.this.getResources().getString(2131887272));
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupSearchResultFragment.this.G);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupSearchResultFragment.this.G);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupSearchResultFragment$MyOnItemClickListener.class */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private MyOnItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemClick(adapterView, view, i, j);
            if (i < 0 || i > GroupSearchResultFragment.this.r.size()) {
                return;
            }
            Bundle bundle = new Bundle();
            int i2 = i - 1;
            if (!StringUtils.d(((BluedGroupLists) GroupSearchResultFragment.this.r.get(i2)).groups_gid)) {
                bundle.putString("gid", ((BluedGroupLists) GroupSearchResultFragment.this.r.get(i2)).groups_gid);
            }
            TerminalActivity.d(GroupSearchResultFragment.this.getActivity(), GroupInfoFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupSearchResultFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            GroupSearchResultFragment.this.s = 1;
            GroupSearchResultFragment.this.a(false);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            GroupSearchResultFragment.q(GroupSearchResultFragment.this);
            GroupSearchResultFragment.this.a(false);
        }
    }

    public static GroupSearchResultFragment a(int i, String str) {
        GroupSearchResultFragment groupSearchResultFragment = new GroupSearchResultFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mFlag", i);
        bundle.putString("mGroupKeywords", str);
        groupSearchResultFragment.setArguments(bundle);
        return groupSearchResultFragment;
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
            AppMethods.a((CharSequence) getResources().getString(2131887275));
        } else if (StringUtils.d(this.z)) {
            AppMethods.a((CharSequence) getResources().getString(R.string.group_search_prompt));
        } else if (this.y == 0) {
            GroupHttpUtils.a(getActivity(), this.l, this.z, UserFindResult.USER_SORT_BY.NEARBY, this.s + "", this.t + "", getFragmentActive());
        } else {
            GroupHttpUtils.a(getActivity(), this.l, this.z, "hot", this.s + "", this.t + "", getFragmentActive());
        }
    }

    static /* synthetic */ int g(GroupSearchResultFragment groupSearchResultFragment) {
        int i = groupSearchResultFragment.s;
        groupSearchResultFragment.s = i - 1;
        return i;
    }

    private void h() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.y = arguments.getInt("mFlag");
            this.z = arguments.getString("mGroupKeywords");
        }
    }

    private void i() {
        this.G = DialogUtils.a(this.x);
        this.A = new ArrayList();
        this.k = new BluedGroupCheck.GroupFailureReason();
        this.p = (LinearLayout) this.w.findViewById(R.id.ll_nodata_show_groups);
        Button button = (Button) this.w.findViewById(R.id.btn_group_create);
        this.q = button;
        button.setOnClickListener(this);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.w.findViewById(R.id.my_grouplist_pullrefresh);
        this.o = renrenPullToRefreshListView;
        ListView listView = (ListView) renrenPullToRefreshListView.getRefreshableView();
        this.j = listView;
        listView.setDivider(null);
        this.j.setSelector(new ColorDrawable(0));
        this.o.setRefreshEnabled(true);
        this.o.postDelayed(new Runnable() { // from class: com.soft.blued.ui.group.GroupSearchResultFragment.1
            @Override // java.lang.Runnable
            public void run() {
                GroupSearchResultFragment.this.o.k();
            }
        }, 100L);
        this.o.setOnPullDownListener(new MyPullDownListener());
        this.j.setOnItemClickListener(new MyOnItemClickListener());
        GroupListsAdapter groupListsAdapter = new GroupListsAdapter(this.x, getFragmentActive(), this.r);
        this.v = groupListsAdapter;
        this.j.setAdapter((ListAdapter) groupListsAdapter);
    }

    static /* synthetic */ int q(GroupSearchResultFragment groupSearchResultFragment) {
        int i = groupSearchResultFragment.s;
        groupSearchResultFragment.s = i + 1;
        return i;
    }

    @Override // com.blued.android.module.common.observer.CommonTitleDoubleClickObserver.ITitleClickObserver
    public void a() {
        this.j.smoothScrollToPosition(0);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.x = activity;
        this.w = LayoutInflater.from(activity).inflate(R.layout.fragment_mygroup_list, (ViewGroup) view, true);
        i();
        h();
        a(false);
        CommonTitleDoubleClickObserver.a().a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131362586) {
            return;
        }
        GroupHttpUtils.b(this.x, this.m, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        CommonTitleDoubleClickObserver.a().b(this);
        super.onDetach();
    }
}
