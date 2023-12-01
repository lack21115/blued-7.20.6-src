package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.group.adapter.GroupUserInviteAdapter;
import com.soft.blued.ui.group.model.BluedUserInviteList;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupUserInviteFragment.class */
public class GroupUserInviteFragment extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {

    /* renamed from: a  reason: collision with root package name */
    public GroupUserInviteAdapter f30866a;

    /* renamed from: c  reason: collision with root package name */
    private RenrenPullToRefreshListView f30867c;
    private NoDataAndLoadFailView d;
    private ListView e;
    private List<BluedUserInviteList> f;
    private View j;
    private Context k;
    private int l;
    private int g = 1;
    private int h = 10;
    private boolean i = true;
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedUserInviteList>>() { // from class: com.soft.blued.ui.group.GroupUserInviteFragment.1

        /* renamed from: a  reason: collision with root package name */
        boolean f30868a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedUserInviteList> bluedEntityA) {
            try {
                if (!bluedEntityA.hasData()) {
                    if (GroupUserInviteFragment.this.g == 1) {
                        GroupUserInviteFragment.this.f.clear();
                        GroupUserInviteFragment.this.f30866a.notifyDataSetChanged();
                    }
                    if (GroupUserInviteFragment.this.g != 1) {
                        GroupUserInviteFragment.e(GroupUserInviteFragment.this);
                    }
                    GroupUserInviteFragment.this.f30867c.p();
                    return;
                }
                if (bluedEntityA.hasMore()) {
                    GroupUserInviteFragment.this.i = true;
                    GroupUserInviteFragment.this.f30867c.o();
                } else {
                    GroupUserInviteFragment.this.i = false;
                    GroupUserInviteFragment.this.f30867c.p();
                }
                if (GroupUserInviteFragment.this.g == 1) {
                    GroupUserInviteFragment.this.f.clear();
                }
                GroupUserInviteFragment.this.f.addAll(bluedEntityA.data);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= GroupUserInviteFragment.this.f.size()) {
                        GroupUserInviteFragment.this.f30866a.notifyDataSetChanged();
                        return;
                    }
                    ((BluedUserInviteList) GroupUserInviteFragment.this.f.get(i2)).height = StringUtils.a(((BluedUserInviteList) GroupUserInviteFragment.this.f.get(i2)).height, BlueAppLocal.c(), false);
                    ((BluedUserInviteList) GroupUserInviteFragment.this.f.get(i2)).weight = StringUtils.b(((BluedUserInviteList) GroupUserInviteFragment.this.f.get(i2)).weight, BlueAppLocal.c(), false);
                    i = i2 + 1;
                }
            } catch (Exception e) {
                this.f30868a = true;
                e.printStackTrace();
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f30868a = true;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            GroupUserInviteFragment.this.f30867c.j();
            GroupUserInviteFragment.this.f30867c.q();
            if (GroupUserInviteFragment.this.f30866a.getCount() != 0) {
                GroupUserInviteFragment.this.d.d();
            } else if (!this.f30868a) {
                GroupUserInviteFragment.this.d.a();
            } else {
                this.f30868a = false;
                GroupUserInviteFragment.this.d.b();
            }
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupUserInviteFragment$DATA_TYPE.class */
    interface DATA_TYPE {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupUserInviteFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            GroupUserInviteFragment.this.g = 1;
            GroupUserInviteFragment.this.a(false);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            GroupUserInviteFragment.a(GroupUserInviteFragment.this);
            GroupUserInviteFragment.this.a(false);
        }
    }

    static /* synthetic */ int a(GroupUserInviteFragment groupUserInviteFragment) {
        int i = groupUserInviteFragment.g;
        groupUserInviteFragment.g = i + 1;
        return i;
    }

    public static GroupUserInviteFragment a(int i) {
        GroupUserInviteFragment groupUserInviteFragment = new GroupUserInviteFragment();
        groupUserInviteFragment.b(i);
        return groupUserInviteFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.g = 1;
        }
        if (this.g == 1) {
            this.i = true;
        }
        if (!this.i && (i = this.g) != 1) {
            this.g = i - 1;
            AppMethods.a((CharSequence) getResources().getString(2131887275));
            return;
        }
        int i2 = this.l;
        if (i2 == 0) {
            int i3 = this.h;
            int i4 = this.g;
            FilterEntity filterEntity = new FilterEntity();
            filterEntity.latitude = CommonPreferences.v();
            filterEntity.longitude = CommonPreferences.u();
            filterEntity.sort_by = "index";
            filterEntity.start = (i3 * (i4 - 1)) + "";
            filterEntity.limit = this.h + "";
            filterEntity.source = "group";
            filterEntity.column = PeopleGridQuickAdapter.a(this.k);
        } else if (i2 == 1) {
            MineHttpUtils.c(this.k, this.b, UserInfo.getInstance().getLoginUserInfo().getUid(), this.g + "", this.h + "", getFragmentActive());
        } else if (i2 != 2) {
        } else {
            MineHttpUtils.e(this.k, this.b, UserInfo.getInstance().getLoginUserInfo().getUid(), this.g + "", this.h + "", getFragmentActive());
        }
    }

    private void b() {
        this.d = (NoDataAndLoadFailView) this.j.findViewById(R.id.ll_nodata_visited);
        this.f = new ArrayList();
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.j.findViewById(R.id.group_visit_pullrefresh);
        this.f30867c = renrenPullToRefreshListView;
        ListView listView = (ListView) renrenPullToRefreshListView.getRefreshableView();
        this.e = listView;
        listView.setDivider(null);
        this.e.setSelector(new ColorDrawable(0));
        this.f30867c.setRefreshEnabled(true);
        this.f30867c.k();
        this.f30867c.setOnPullDownListener(new MyPullDownListener());
        GroupUserInviteAdapter groupUserInviteAdapter = new GroupUserInviteAdapter(this.k, getFragmentActive(), this.f);
        this.f30866a = groupUserInviteAdapter;
        this.e.setAdapter((ListAdapter) groupUserInviteAdapter);
    }

    static /* synthetic */ int e(GroupUserInviteFragment groupUserInviteFragment) {
        int i = groupUserInviteFragment.g;
        groupUserInviteFragment.g = i - 1;
        return i;
    }

    @Override // com.blued.android.module.common.observer.CommonTitleDoubleClickObserver.ITitleClickObserver
    public void a() {
        this.e.smoothScrollToPosition(0);
    }

    public void b(int i) {
        this.l = i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = getActivity();
        View view = this.j;
        if (view == null) {
            this.j = layoutInflater.inflate(R.layout.fragment_invite_visit_list, viewGroup, false);
            b();
            a(false);
            CommonTitleDoubleClickObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        return this.j;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        CommonTitleDoubleClickObserver.a().b(this);
        super.onDetach();
    }
}
