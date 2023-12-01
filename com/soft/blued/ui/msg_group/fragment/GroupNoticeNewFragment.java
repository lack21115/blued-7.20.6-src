package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;
import com.soft.blued.ui.msg_group.model.GroupNoticeViewModel;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupNoticeNewFragment.class */
public final class GroupNoticeNewFragment extends BaseListFragment<GroupNoticeViewModel, GroupNoticeModel> {
    /* renamed from: C */
    public GroupNoticeAdapter i() {
        return new GroupNoticeAdapter(getFragmentActive());
    }

    public void m() {
        super.m();
        CommonTopTitleNoTrans b = b();
        if (b != null) {
            b.setCenterText(getString(R.string.group_notification));
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataImg(2131233626);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 == null) {
            return;
        }
        c3.setNoDataStr((int) R.string.no_chats);
    }
}
