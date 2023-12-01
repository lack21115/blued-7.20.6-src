package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupMemberFragment_ViewBinding.class */
public class GroupMemberFragment_ViewBinding implements Unbinder {
    private GroupMemberFragment b;

    public GroupMemberFragment_ViewBinding(GroupMemberFragment groupMemberFragment, View view) {
        this.b = groupMemberFragment;
        groupMemberFragment.ctt_left_img = (ImageView) Utils.a(view, 2131363123, "field 'ctt_left_img'", ImageView.class);
        groupMemberFragment.iv_delete = (ImageView) Utils.a(view, R.id.iv_delete, "field 'iv_delete'", ImageView.class);
        groupMemberFragment.iv_sort = (ImageView) Utils.a(view, R.id.iv_sort, "field 'iv_sort'", ImageView.class);
        groupMemberFragment.mListViewWrapper = (RenrenPullToRefreshListView) Utils.a(view, R.id.member_list, "field 'mListViewWrapper'", RenrenPullToRefreshListView.class);
        groupMemberFragment.frame_layout = (FrameLayout) Utils.a(view, 2131364048, "field 'frame_layout'", FrameLayout.class);
        groupMemberFragment.rl_bottom = (RelativeLayout) Utils.a(view, R.id.rl_bottom, "field 'rl_bottom'", RelativeLayout.class);
        groupMemberFragment.tv_delete = (TextView) Utils.a(view, R.id.tv_delete, "field 'tv_delete'", TextView.class);
        groupMemberFragment.search_view = (SearchView) Utils.a(view, R.id.search_view, "field 'search_view'", SearchView.class);
        groupMemberFragment.fm_search_list = (FrameLayout) Utils.a(view, R.id.fm_search_list, "field 'fm_search_list'", FrameLayout.class);
        groupMemberFragment.searchNoDataView = (NoDataAndLoadFailView) Utils.a(view, 2131368721, "field 'searchNoDataView'", NoDataAndLoadFailView.class);
        groupMemberFragment.search_list = (RenrenPullToRefreshListView) Utils.a(view, R.id.search_list, "field 'search_list'", RenrenPullToRefreshListView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        GroupMemberFragment groupMemberFragment = this.b;
        if (groupMemberFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        groupMemberFragment.ctt_left_img = null;
        groupMemberFragment.iv_delete = null;
        groupMemberFragment.iv_sort = null;
        groupMemberFragment.mListViewWrapper = null;
        groupMemberFragment.frame_layout = null;
        groupMemberFragment.rl_bottom = null;
        groupMemberFragment.tv_delete = null;
        groupMemberFragment.search_view = null;
        groupMemberFragment.fm_search_list = null;
        groupMemberFragment.searchNoDataView = null;
        groupMemberFragment.search_list = null;
    }
}
