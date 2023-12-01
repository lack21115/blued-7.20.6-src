package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupNoticeFragment_MVP.class */
public final class GroupNoticeFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        GroupNoticeFragment groupNoticeFragment = (GroupNoticeFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != -1477078771 || !str.equals("data_notice")) {
                z = true;
            }
            if (!z && GroupNoticeModel.class.isInstance(obj)) {
                groupNoticeFragment.a(list);
            }
        }
    }
}
