package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Contacts;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.adapter.SearchMemberAdapter;
import com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/SearchMemberFragment.class */
public class SearchMemberFragment extends MvpFragment<GroupMemberPresenter> implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private SearchMemberAdapter f19086a;
    private SearchMemberAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private String f19087c;
    private int d = 0;
    @BindView
    NoDataAndLoadFailView noDataView;
    @BindView
    SmartRefreshLayout refresh_layout;
    @BindView
    RecyclerView search_list;
    @BindView
    SearchView search_view;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    RecyclerView user_list;

    public static void a(Context context, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(Contacts.GroupMembership.GROUP_ID, str);
        bundle.putInt("page_type", i);
        TerminalActivity.d(context, SearchMemberFragment.class, bundle);
    }

    public static void a(Context context, int i, String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString(Contacts.GroupMembership.GROUP_ID, str);
        bundle.putInt("page_type", i);
        bundle.putInt("group_role", i2);
        TerminalActivity.d(context, SearchMemberFragment.class, bundle);
    }

    public static void a(Context context, int i, String str, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString(Contacts.GroupMembership.GROUP_ID, str);
        bundle.putInt("page_type", i);
        bundle.putInt("group_role", i2);
        TerminalActivity.a(context, SearchMemberFragment.class, bundle, i3);
    }

    private List<GroupMemberModel> c(List<GroupMemberModel> list) {
        int i = this.d;
        if (i == 0) {
            while (list.size() > 0 && list.get(0).group_role != 3) {
                list.remove(0);
            }
        } else {
            int i2 = 0;
            if (1 != i) {
                if (2 == i) {
                    i2 = 0;
                }
            }
            while (i2 < list.size()) {
                if (list.get(i2).uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
                    list.remove(i2);
                    return list;
                }
                i2++;
            }
        }
        return list;
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (getArguments() != null) {
            int i = getArguments().getInt("page_type");
            this.d = i;
            if (i == 0) {
                this.title.setCenterText(getString(R.string.group_admins_add));
            } else if (i == 1) {
                this.title.setCenterText(getString(R.string.group_at_member));
            } else if (i == 2) {
                this.title.setCenterText(getString(R.string.group_transfer));
            }
        }
        this.title.getLeftImg().setVisibility(8);
        this.title.setLeftText(getResources().getString(2131886885));
        this.title.getLeftTextView().setTextColor(getResources().getColor(2131102264));
        this.title.getLeftTextView().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SearchMemberFragment.this.t();
            }
        });
        this.noDataView.d();
        this.noDataView.setNoDataImg(2131233627);
        this.noDataView.setNoDataStr((int) R.string.no_data);
        this.search_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.user_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f19086a = new SearchMemberAdapter(getFragmentActive());
        this.b = new SearchMemberAdapter(getFragmentActive());
        if (this.d == 1 && (((GroupMemberPresenter) j()).o == 1 || ((GroupMemberPresenter) j()).o == 2)) {
            View inflate = View.inflate(getContext(), R.layout.header_group_choose_at, null);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    GroupMemberModel groupMemberModel = new GroupMemberModel();
                    groupMemberModel.uid = "000000";
                    groupMemberModel.name = SearchMemberFragment.this.getResources().getString(R.string.group_at_all);
                    LiveEventBus.get("choose_at_user", GroupMemberModel.class).post(groupMemberModel);
                    SearchMemberFragment.this.t();
                }
            });
            this.b.addHeaderView(inflate);
        }
        this.search_list.setAdapter(this.f19086a);
        this.user_list.setAdapter(this.b);
        this.b.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.b.disableLoadMoreIfNotFullPage(this.user_list);
        this.b.setOnItemClickListener(this);
        this.f19086a.setOnItemClickListener(this);
        this.refresh_layout.l(false);
        this.refresh_layout.a(new OnRefreshListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.3
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                SearchMemberFragment.this.b.setEnableLoadMore(true);
                SearchMemberFragment.this.l();
            }
        });
        this.b.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                ((GroupMemberPresenter) SearchMemberFragment.this.j()).f();
            }
        }, this.user_list);
        this.search_view.clearFocus();
        this.search_view.getEditView().setHint(getString(R.string.group_search_member_hint));
        this.search_view.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.5
            public void a() {
                SearchMemberFragment.this.b();
            }

            public void a(String str) {
                if (TextUtils.isEmpty(str)) {
                    SearchMemberFragment.this.b();
                    return;
                }
                SearchMemberFragment.this.refresh_layout.c(false);
                SearchMemberFragment.this.f19087c = str;
                SearchMemberFragment.this.f19086a.getData().clear();
                SearchMemberFragment.this.f19086a.notifyDataSetChanged();
                SearchMemberFragment.this.search_list.setVisibility(0);
                SearchMemberFragment.this.user_list.setVisibility(8);
                ((GroupMemberPresenter) SearchMemberFragment.this.j()).e(SearchMemberFragment.this.f19087c);
            }

            public void b() {
                SearchMemberFragment.this.b();
            }
        });
    }

    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            this.noDataView.b();
        } else if (this.f19086a.getData().size() <= 0) {
            this.noDataView.a();
        } else {
            this.noDataView.d();
        }
    }

    public void a(Integer num) {
        GroupMemberModel groupMemberModel = this.b.getData().get(num.intValue());
        groupMemberModel.group_role = 2;
        LiveEventBus.get("set_manager", GroupMemberModel.class).post(groupMemberModel);
        t();
    }

    public void a(String str, boolean z) {
        super.a(str, z);
        if (z || ((GroupMemberPresenter) j()).i == 1) {
            return;
        }
        this.b.loadMoreFail();
    }

    public void a(List<GroupMemberModel> list) {
        this.f19086a.a(c(list), this.f19087c);
    }

    public void b() {
        this.f19087c = "";
        this.f19086a.getData().clear();
        this.f19086a.notifyDataSetChanged();
        this.search_list.setVisibility(8);
        this.refresh_layout.c(true);
        this.noDataView.d();
        this.user_list.setVisibility(0);
    }

    public void b(List<GroupMemberModel> list) {
        this.refresh_layout.j();
        this.b.loadMoreComplete();
        this.b.setNewData(c(list));
    }

    public int g() {
        return R.layout.fm_search_member;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        KeyboardUtils.a(getActivity());
        final GroupMemberModel groupMemberModel = (GroupMemberModel) baseQuickAdapter.getData().get(i);
        int i2 = this.d;
        if (i2 == 0) {
            if (groupMemberModel.group_role != 3) {
                return;
            }
            CommonAlertDialog.a(getContext(), getString(R.string.group_admins_add), String.format(getString(R.string.group_admin_add_hint), groupMemberModel.name), getContext().getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    Tracker.onClick(dialogInterface, i3);
                    ((GroupMemberPresenter) SearchMemberFragment.this.j()).a(groupMemberModel.uid, 2, i);
                }
            }, getContext().getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    Tracker.onClick(dialogInterface, i3);
                }
            }, (DialogInterface.OnDismissListener) null);
        } else if (i2 == 1) {
            LiveEventBus.get("choose_at_user", GroupMemberModel.class).post(groupMemberModel);
            t();
        } else if (i2 == 2 && ((GroupMemberPresenter) j()).o == 1 && groupMemberModel.group_role != 1) {
            CommonAlertDialog.a(getContext(), getString(R.string.group_transfer_title), String.format(getString(R.string.group_dialog_transfer_hint), groupMemberModel.name), getContext().getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    Tracker.onClick(dialogInterface, i3);
                    ((GroupMemberPresenter) SearchMemberFragment.this.j()).a(groupMemberModel.uid, 1, i);
                }
            }, getContext().getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    Tracker.onClick(dialogInterface, i3);
                }
            }, (DialogInterface.OnDismissListener) null);
        }
    }

    public void p() {
        super.p();
        this.b.loadMoreEnd();
    }
}
