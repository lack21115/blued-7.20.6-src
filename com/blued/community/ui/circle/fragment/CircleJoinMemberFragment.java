package com.blued.community.ui.circle.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.adapter.CircleMemberAdapter;
import com.blued.community.ui.circle.model.CircleBaseMember;
import com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.brandongogetap.stickyheaders.StickyLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleJoinMemberFragment.class */
public class CircleJoinMemberFragment<T extends CircleJoinMemberPresenter> extends MvpFragment<CircleJoinMemberPresenter> {
    protected CircleMemberAdapter a;
    protected NoDataAndLoadFailView b;
    private RecyclerView c;
    private SmartRefreshLayout d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BasePopupView basePopupView, CircleBaseMember.Member member, String str, int i, DialogInterface dialogInterface, int i2) {
        if (basePopupView != null) {
            basePopupView.p();
        }
        if (member.isManager()) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK, j().m(), str);
        } else {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK, j().m(), str);
        }
        j().c(member, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BasePopupView basePopupView, String str, CircleBaseMember.Member member, int i, DialogInterface dialogInterface, int i2) {
        if (basePopupView != null) {
            basePopupView.p();
        }
        EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK, j().m(), str);
        j().b(member, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CircleBaseMember.Member member, String str, BasePopupView basePopupView, int i, View view) {
        if (member.is_mute == 0) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK, j().m(), str);
        }
        if (basePopupView != null) {
            basePopupView.p();
        }
        j().a(member, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final String str, final BasePopupView basePopupView, final CircleBaseMember.Member member, final int i, View view) {
        EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK, j().m(), str);
        if (basePopupView != null) {
            basePopupView.p();
        }
        CommonAlertDialog.a(getContext(), "", getString(R.string.circle_member_dialog_remove_member), getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleJoinMemberFragment$JlhHPUdAlEHqmw9h0_JphwuS6Ag
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                CircleJoinMemberFragment.this.a(basePopupView, str, member, i, dialogInterface, i2);
            }
        }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private void b() {
        this.c = this.i.findViewById(R.id.recycler_view);
        this.d = this.i.findViewById(R.id.refresh_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final CircleBaseMember.Member member, final String str, final BasePopupView basePopupView, final int i, View view) {
        if (member.isManager()) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK, j().m(), str);
        } else {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK, j().m(), str);
        }
        if (basePopupView != null) {
            basePopupView.p();
        }
        CommonAlertDialog.a(getContext(), "", getString(member.isManager() ? R.string.circle_member_dialog_relieve_asst_manager : R.string.circle_member_dialog_appoint_asst_manager), getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleJoinMemberFragment$ASrBVZ8ur1s8fhNdjfsuzNcieB8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                CircleJoinMemberFragment.this.a(basePopupView, member, str, i, dialogInterface, i2);
            }
        }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private void b(boolean z) {
        this.d.g();
        this.d.h();
        if (this.a.getData().size() <= 0) {
            if (z) {
                this.b.a();
            } else {
                this.b.b();
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
        this.a = new CircleMemberAdapter(getFragmentActive(), j().n());
        this.b = new NoDataAndLoadFailView(getContext());
        j().a(this.a);
        this.a.setEmptyView(this.b);
        this.d.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.CircleJoinMemberFragment.1
            public void onLoadMore(RefreshLayout refreshLayout) {
                CircleJoinMemberFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                CircleJoinMemberFragment.this.j().e();
            }
        });
        this.c.setLayoutManager(new StickyLayoutManager(getContext(), this.a));
        this.c.setAdapter(this.a);
        this.a.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleJoinMemberFragment.2
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CircleBaseMember.Member member = (CircleBaseMember.Member) CircleJoinMemberFragment.this.a.getItem(i);
                int id = view.getId();
                if (id == R.id.cl_root) {
                    if (member.is_locked == 1) {
                        AppMethods.a((CharSequence) CircleJoinMemberFragment.this.getString(R.string.circle_member_list_removed_account_toast));
                    } else {
                        CommunityServiceManager.b().a(CircleJoinMemberFragment.this.getContext(), member.uid, "CIRCLE_MEMBERS", MessageProtos.StrangerSource.CIRCLE_USERS);
                    }
                } else if (id == R.id.iv_more) {
                    CircleJoinMemberFragment.this.a(member, i);
                    if (member.isManager()) {
                        EventTrackFeed.a(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_CLICK, CircleJoinMemberFragment.this.j().m(), member.uid, FeedProtos.UserType.VICE_CAPTAIN);
                    } else {
                        EventTrackFeed.a(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_CLICK, CircleJoinMemberFragment.this.j().m(), member.uid, FeedProtos.UserType.COMMON_USER);
                    }
                }
            }
        });
    }

    protected void a(final CircleBaseMember.Member member, final int i) {
        final String str = member.uid;
        ArrayList arrayList = new ArrayList();
        final BasePopupView a = CommonShowBottomWindow.a(getContext(), arrayList);
        BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
        menuItemInfo.a = getResources().getString(member.isManager() ? R.string.circle_member_relieve_asst_manager : R.string.circle_member_appoint_asst_manager);
        BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
        menuItemInfo2.a = getResources().getString(R.string.circle_member_remove);
        BottomMenuPop.MenuItemInfo menuItemInfo3 = new BottomMenuPop.MenuItemInfo();
        menuItemInfo3.a = getResources().getString(member.is_mute == 1 ? R.string.circle_member_mute_cancel : R.string.circle_member_mute);
        menuItemInfo3.b = R.color.syc_g;
        menuItemInfo.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleJoinMemberFragment$PpeZayo77J082GKeiFtN2Q2eOf4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleJoinMemberFragment.this.b(member, str, a, i, view);
            }
        };
        menuItemInfo2.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleJoinMemberFragment$ZwwbBrRzfGcOnhLGRwbVAEqQF00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleJoinMemberFragment.this.a(str, a, member, i, view);
            }
        };
        menuItemInfo3.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleJoinMemberFragment$yMaGEB6-Lg7vQltR82K2JzoSmrM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleJoinMemberFragment.this.a(member, str, a, i, view);
            }
        };
        if (j().n() == 1) {
            arrayList.add(menuItemInfo);
            arrayList.add(menuItemInfo2);
            arrayList.add(menuItemInfo3);
        }
        if (j().n() == 2) {
            arrayList.add(menuItemInfo2);
            arrayList.add(menuItemInfo3);
        }
        a.h();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        super.a(str, list);
        if ((str.hashCode() == -1515158321 && str.equals("data_member")) ? false : true) {
            return;
        }
        MvpUtils.a(list, CircleBaseMember.Member.class, new MvpUtils.DataListHandler<CircleBaseMember.Member>() { // from class: com.blued.community.ui.circle.fragment.CircleJoinMemberFragment.3
            @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
            public void a() {
            }

            @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
            public void a(List<CircleBaseMember.Member> list2) {
                CircleJoinMemberFragment.this.a.setNewData(list2);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2 || z2) {
            b(z);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.b = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_member_list;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.d.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.d.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.d.b(false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean r() {
        return true;
    }
}
