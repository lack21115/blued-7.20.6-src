package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupNoticeFragment_ViewBinding.class */
public class GroupNoticeFragment_ViewBinding implements Unbinder {
    private GroupNoticeFragment b;

    public GroupNoticeFragment_ViewBinding(GroupNoticeFragment groupNoticeFragment, View view) {
        this.b = groupNoticeFragment;
        groupNoticeFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        groupNoticeFragment.notice_list = (RecyclerView) Utils.a(view, R.id.notice_list, "field 'notice_list'", RecyclerView.class);
        groupNoticeFragment.refresh_layout = (SmartRefreshLayout) Utils.a(view, 2131369119, "field 'refresh_layout'", SmartRefreshLayout.class);
        groupNoticeFragment.noDataView = (NoDataAndLoadFailView) Utils.a(view, 2131368721, "field 'noDataView'", NoDataAndLoadFailView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        GroupNoticeFragment groupNoticeFragment = this.b;
        if (groupNoticeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        groupNoticeFragment.title = null;
        groupNoticeFragment.notice_list = null;
        groupNoticeFragment.refresh_layout = null;
        groupNoticeFragment.noDataView = null;
    }
}
