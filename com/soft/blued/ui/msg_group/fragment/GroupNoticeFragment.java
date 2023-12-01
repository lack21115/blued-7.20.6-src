package com.soft.blued.ui.msg_group.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;
import com.soft.blued.ui.msg_group.presenter.GroupNoticePresenter;
import com.soft.blued.utils.RecyclerViewUtil;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupNoticeFragment.class */
public class GroupNoticeFragment extends MvpFragment<GroupNoticePresenter> {

    /* renamed from: a  reason: collision with root package name */
    private GroupNoticeAdapter f19072a;
    @BindView
    NoDataAndLoadFailView noDataView;
    @BindView
    RecyclerView notice_list;
    @BindView
    SmartRefreshLayout refresh_layout;
    @BindView
    CommonTopTitleNoTrans title;

    public void a(Bundle bundle) {
        super.a(bundle);
        this.refresh_layout.c(true);
        this.refresh_layout.l(false);
        this.refresh_layout.a(new OnRefreshListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupNoticeFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                ((GroupNoticePresenter) GroupNoticeFragment.this.j()).e();
            }
        });
        RecyclerViewUtil.a(this.notice_list);
        this.notice_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f19072a = new GroupNoticeAdapter(getFragmentActive());
        this.noDataView.d();
        this.noDataView.setNoDataImg(2131233626);
        this.noDataView.setNoDataStr((int) R.string.no_chats);
        this.f19072a.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.f19072a.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupNoticeFragment.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                ((GroupNoticePresenter) GroupNoticeFragment.this.j()).f();
            }
        }, this.notice_list);
        this.notice_list.setAdapter(this.f19072a);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupNoticeFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupNoticeFragment.this.t();
            }
        });
        this.title.setCenterText(getString(R.string.group_notification));
        this.title.setRightImg((int) R.drawable.ignore_unread_delete);
        this.title.getRightImg().setVisibility(8);
        this.title.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupNoticeFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
    }

    public void a(String str, boolean z) {
        super.a(str, z);
        this.refresh_layout.j();
        this.f19072a.loadMoreComplete();
        if (!z && ((GroupNoticePresenter) j()).h != 1) {
            this.f19072a.loadMoreFail();
        }
        if (this.f19072a.getData().size() > 0) {
            this.noDataView.d();
        } else if (z) {
            this.noDataView.a();
        } else {
            this.noDataView.b();
        }
    }

    public void a(List<GroupNoticeModel> list) {
        this.f19072a.setNewData(list);
    }

    public int g() {
        return R.layout.fm_group_notice;
    }

    public void o() {
        super.o();
        this.f19072a.setEnableLoadMore(true);
    }

    public void p() {
        super.p();
        this.f19072a.loadMoreEnd();
    }
}
