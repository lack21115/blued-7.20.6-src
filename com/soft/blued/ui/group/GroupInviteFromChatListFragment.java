package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.group.adapter.BluedMyChatFriendListAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupInviteFromChatListFragment.class */
public class GroupInviteFromChatListFragment extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {

    /* renamed from: c  reason: collision with root package name */
    public static String f30800c;

    /* renamed from: a  reason: collision with root package name */
    public BluedMyChatFriendListAdapter f30801a;
    private RenrenPullToRefreshListView d;
    private ListView e;
    private View h;
    private Context i;
    private NoDataAndLoadFailView j;
    private int f = 1;
    private boolean g = true;
    public List<SessionModel> b = new ArrayList();
    private GroupInviteSessionListener k = new GroupInviteSessionListener();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupInviteFromChatListFragment$GroupInviteSessionListener.class */
    class GroupInviteSessionListener extends StableSessionListListener {
        private GroupInviteSessionListener() {
        }

        @Override // com.blued.android.chat.StableSessionListListener
        public void onUISessionDataChanged(List<SessionModel> list) {
            if (list == null) {
                list = new ArrayList();
            } else {
                ChatHelperV4.b(list);
            }
            GroupInviteFromChatListFragment.this.b = list;
            GroupInviteFromChatListFragment.this.f30801a.notifyDataSetChanged();
            if (GroupInviteFromChatListFragment.this.b.size() > 0) {
                if (GroupInviteFromChatListFragment.this.j != null) {
                    GroupInviteFromChatListFragment.this.j.d();
                }
            } else if (GroupInviteFromChatListFragment.this.j != null) {
                GroupInviteFromChatListFragment.this.j.a();
            }
            GroupInviteFromChatListFragment.this.c();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupInviteFromChatListFragment$MyOnItemClickListener.class */
    class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GroupInviteFromChatListFragment f30803a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemClick(adapterView, view, i, j);
            if (i < 0 || i > this.f30803a.b.size()) {
                return;
            }
            int i2 = i - 1;
            if (this.f30803a.b.get(i2).sessionType == 2) {
                UserInfoFragmentNew.a(this.f30803a.i, String.valueOf(this.f30803a.b.get(i2).sessionId), "");
            } else if (this.f30803a.b.get(i2).sessionType == 3) {
                GroupInfoFragment.a(this.f30803a.i, String.valueOf(this.f30803a.b.get(i2).sessionId));
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupInviteFromChatListFragment$MyPullDownListener.class */
    class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GroupInviteFromChatListFragment f30804a;

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            this.f30804a.f = 1;
            this.f30804a.a(false);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            GroupInviteFromChatListFragment.a(this.f30804a);
            this.f30804a.a(false);
        }
    }

    static /* synthetic */ int a(GroupInviteFromChatListFragment groupInviteFromChatListFragment) {
        int i = groupInviteFromChatListFragment.f;
        groupInviteFromChatListFragment.f = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.f = 1;
        }
        if (this.f == 1) {
            this.g = true;
        }
        if (this.g || (i = this.f) == 1) {
            return;
        }
        this.f = i - 1;
        AppMethods.a((CharSequence) getResources().getString(2131887275));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        RenrenPullToRefreshListView renrenPullToRefreshListView = this.d;
        if (renrenPullToRefreshListView != null) {
            renrenPullToRefreshListView.j();
        }
    }

    @Override // com.blued.android.module.common.observer.CommonTitleDoubleClickObserver.ITitleClickObserver
    public void a() {
        this.e.smoothScrollToPosition(0);
    }

    public void a(String str) {
        f30800c = str;
    }

    public void b() {
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
        this.i = getActivity();
        return this.h;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        CommonTitleDoubleClickObserver.a().b(this);
        super.onDetach();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ChatManager.getInstance().registerSessionListener(this.k);
        b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ChatManager.getInstance().unregisterSessionListener(this.k);
    }
}
