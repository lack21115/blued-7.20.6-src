package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView;
import com.blued.android.module.common.db.model.MsgExtra;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.MyGroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedMyGroupLists;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.utils.CommonDataRefreshObserver;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/UserGroupListsFragment.class */
public class UserGroupListsFragment extends BaseFragment implements View.OnClickListener, CommonDataRefreshObserver.IDataRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f30878a = new BluedUIHttpResponse<BluedEntityA<BluedMyGroupLists>>() { // from class: com.soft.blued.ui.group.UserGroupListsFragment.1

        /* renamed from: a  reason: collision with root package name */
        boolean f30880a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedMyGroupLists> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    BluedMyGroupLists singleData = bluedEntityA.getSingleData();
                    if (singleData != null) {
                        if (singleData.created.size() <= 0 && singleData.admin.size() <= 0 && singleData.joined.size() <= 0) {
                            UserGroupListsFragment.this.m.clear();
                            UserGroupListsFragment.this.g.setVisibility(8);
                            UserGroupListsFragment.this.f30879c.setVisibility(0);
                            UserGroupListsFragment.this.e.setVisibility(0);
                            UserGroupListsFragment.this.b.a();
                        }
                        UserGroupListsFragment.this.f30879c.setVisibility(8);
                        UserGroupListsFragment.this.l.clear();
                        UserGroupListsFragment.this.l.addAll(bluedEntityA.data);
                        List<BluedCreatedGroupInfo> list = ((BluedMyGroupLists) UserGroupListsFragment.this.l.get(0)).created;
                        List<BluedCreatedGroupInfo> list2 = ((BluedMyGroupLists) UserGroupListsFragment.this.l.get(0)).admin;
                        List<BluedCreatedGroupInfo> list3 = ((BluedMyGroupLists) UserGroupListsFragment.this.l.get(0)).joined;
                        UserGroupListsFragment.this.m.clear();
                        if (list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                list.get(i2).type = 0;
                                list.get(i2).header_name = UserGroupListsFragment.this.getResources().getString(R.string.my_created_groups);
                                UserGroupListsFragment.this.m.add(list.get(i2));
                                i = i2 + 1;
                            }
                        }
                        if (list2 != null) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= list2.size()) {
                                    break;
                                }
                                list2.get(i4).type = 1;
                                list2.get(i4).header_name = UserGroupListsFragment.this.getResources().getString(R.string.my_managed_groups);
                                UserGroupListsFragment.this.m.add(list2.get(i4));
                                i3 = i4 + 1;
                            }
                        }
                        if (list3 != null) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= list3.size()) {
                                    break;
                                }
                                list3.get(i6).type = 2;
                                list3.get(i6).header_name = UserGroupListsFragment.this.getResources().getString(R.string.my_joined_groups);
                                UserGroupListsFragment.this.m.add(list3.get(i6));
                                i5 = i6 + 1;
                            }
                        }
                        UserGroupListsFragment.this.b.setRightImg(R.drawable.icon_title_create_group);
                    } else {
                        UserGroupListsFragment.this.m.clear();
                        UserGroupListsFragment.this.g.setVisibility(8);
                        UserGroupListsFragment.this.f30879c.setVisibility(0);
                        UserGroupListsFragment.this.e.setVisibility(0);
                        UserGroupListsFragment.this.b.a();
                    }
                    UserGroupListsFragment.this.h.notifyDataSetChanged();
                } catch (Exception e) {
                    this.f30880a = true;
                    e.printStackTrace();
                    AppMethods.a((CharSequence) UserGroupListsFragment.this.j.getResources().getString(2131887272));
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f30880a = true;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(UserGroupListsFragment.this.k);
            if (this.f30880a) {
                this.f30880a = false;
                UserGroupListsFragment.this.m.clear();
                UserGroupListsFragment.this.g.setVisibility(8);
                UserGroupListsFragment.this.f30879c.setVisibility(8);
                UserGroupListsFragment.this.e.setVisibility(8);
                UserGroupListsFragment.this.b.a();
                UserGroupListsFragment.this.d.b();
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(UserGroupListsFragment.this.k);
        }
    };
    private CommonTopTitleNoTrans b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f30879c;
    private NoDataAndLoadFailView d;
    private TextView e;
    private TextView f;
    private StickyListHeadersListView g;
    private MyGroupListsAdapter h;
    private View i;
    private Context j;
    private Dialog k;
    private List<BluedMyGroupLists> l;
    private List<BluedGroupLists> m;
    private boolean n;
    private BluedGroupCheck.GroupFailureReason o;
    private String p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/UserGroupListsFragment$MyOnItemClickListener.class */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private MyOnItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BluedGroupLists bluedGroupLists;
            Tracker.onItemClick(adapterView, view, i, j);
            if (i < 0 || i > UserGroupListsFragment.this.m.size() || (bluedGroupLists = (BluedGroupLists) UserGroupListsFragment.this.m.get(i)) == null) {
                return;
            }
            Bundle arguments = UserGroupListsFragment.this.getArguments();
            String string = arguments != null ? arguments.getString("fragment_name_key") : "";
            if (StringUtils.d(string) || !string.equals(MsgChattingFragment.class.getSimpleName())) {
                GroupInfoFragment.a(UserGroupListsFragment.this, bluedGroupLists.groups_gid, 100);
                return;
            }
            MsgExtra msgExtra = new MsgExtra();
            msgExtra.setGroups_avatar(bluedGroupLists.groups_avatar);
            msgExtra.setGroups_city(bluedGroupLists.groups_city);
            msgExtra.setGroups_members_count(bluedGroupLists.groups_members_count);
            msgExtra.setGroups_name(bluedGroupLists.groups_name);
            msgExtra.setGroups_gid(bluedGroupLists.groups_gid);
            msgExtra.setGroups_description(bluedGroupLists.groups_description);
            String str = bluedGroupLists.groups_gid;
            String str2 = bluedGroupLists.groups_is_created;
            String str3 = bluedGroupLists.groups_is_admins;
            String str4 = "";
            if (!StringUtils.d(str2)) {
                str4 = "";
                if (!StringUtils.d(str3)) {
                    str4 = (str2.equals("1") || str3.equals("1")) ? "1" : "0";
                }
            }
            String json = AppInfo.f().toJson(msgExtra);
            Intent intent = new Intent(UserGroupListsFragment.this.j, MsgChattingFragment.class);
            intent.putExtra("group_extra_json", json);
            intent.putExtra("gid", str);
            intent.putExtra("flag", str4);
            UserGroupListsFragment.this.getActivity().setResult(-1, intent);
            UserGroupListsFragment.this.getActivity().finish();
        }
    }

    public static void a(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("UID", UserInfo.getInstance().getLoginUserInfo().getUid());
        TerminalActivity.d(context, UserGroupListsFragment.class, bundle);
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.i.findViewById(2131370749);
        this.b = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setRightClickListener(this);
        if (getArguments() == null || StringUtils.d(getArguments().getString("UID")) || getArguments().getString("UID").equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().getUid())) {
            this.b.setCenterText(getString(R.string.mygroup_list));
            this.b.setRightImg(R.drawable.icon_title_create_group);
            this.b.setRightClickListener(this);
        } else {
            this.b.setCenterText(getString(R.string.group_lists));
            this.b.a();
        }
        this.b.setLeftClickListener(this);
    }

    private void c() {
        this.k = DialogUtils.a(this.j);
        this.o = new BluedGroupCheck.GroupFailureReason();
        this.f30879c = (LinearLayout) this.i.findViewById(R.id.ll_nodata_show_groups);
        this.d = (NoDataAndLoadFailView) this.i.findViewById(R.id.nodataview);
        TextView textView = (TextView) this.i.findViewById(R.id.tv_group_create);
        this.e = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.i.findViewById(R.id.tv_group_look);
        this.f = textView2;
        textView2.setOnClickListener(this);
        this.l = new ArrayList();
        this.m = new ArrayList();
        StickyListHeadersListView stickyListHeadersListView = (StickyListHeadersListView) this.i.findViewById(R.id.my_grouplist_pullrefresh);
        this.g = stickyListHeadersListView;
        stickyListHeadersListView.setDivider(null);
        this.g.setSelector(new ColorDrawable(0));
        this.g.setOnItemClickListener(new MyOnItemClickListener());
        MyGroupListsAdapter myGroupListsAdapter = new MyGroupListsAdapter(this.j, getFragmentActive(), this.m, UserInfo.getInstance().getLoginUserInfo().getUid().equalsIgnoreCase(this.p));
        this.h = myGroupListsAdapter;
        this.g.setAdapter(myGroupListsAdapter);
    }

    private void d() {
        GroupHttpUtils.g(this.j, this.f30878a, this.p, getFragmentActive());
        if (this.n) {
            this.i.findViewById(2131370749).setVisibility(8);
        }
    }

    @Override // com.soft.blued.utils.CommonDataRefreshObserver.IDataRefreshObserver
    public void a() {
        d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            d();
        } else if (StringUtils.d(this.p)) {
        } else {
            GroupHttpUtils.g(this.j, this.f30878a, this.p, getFragmentActive());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case 2131363126:
                if (PopMenuUtils.a(this.j)) {
                    return;
                }
                TerminalActivity.d(getActivity(), GroupCreateFragment.class, null);
                return;
            case R.id.tv_group_create /* 2131371585 */:
                if (PopMenuUtils.a(this.j)) {
                    return;
                }
                TerminalActivity.d(getActivity(), GroupCreateFragment.class, null);
                return;
            case R.id.tv_group_look /* 2131371613 */:
                TerminalActivity.d(getActivity(), GroupFragment.class, null);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = getActivity();
        View view = this.i;
        if (view == null) {
            this.i = layoutInflater.inflate(R.layout.fragment_my_group_lists, viewGroup, false);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.p = arguments.getString("UID");
                this.n = arguments.getBoolean("hidetitle", false);
            } else {
                this.p = UserInfo.getInstance().getLoginUserInfo().getUid();
                this.n = false;
            }
            c();
            b();
            d();
            if (this.n) {
                CommonDataRefreshObserver.a().a(this);
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        return this.i;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.n) {
            CommonDataRefreshObserver.a().b(this);
        }
        super.onDestroy();
    }
}
