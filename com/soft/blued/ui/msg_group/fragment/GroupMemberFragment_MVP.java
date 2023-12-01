package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.group.GroupMemberModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupMemberFragment_MVP.class */
public final class GroupMemberFragment_MVP implements MvpDispatcher {
    private void a(GroupMemberFragment groupMemberFragment, String str) {
        if ((str.hashCode() == -1772847136 && str.equals("data_delete")) ? false : true) {
            return;
        }
        groupMemberFragment.b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        GroupMemberFragment groupMemberFragment = (GroupMemberFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != -1515158321 || !str.equals("data_member")) {
                    z = true;
                }
                if (!z && GroupMemberModel.class.isInstance(obj)) {
                    groupMemberFragment.a(list);
                    return;
                }
            }
        }
        a(groupMemberFragment, str);
    }
}
