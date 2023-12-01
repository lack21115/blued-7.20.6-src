package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.group.GroupInfoModel;
import com.umeng.analytics.pro.d;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupManagerFragment_MVP.class */
public final class GroupManagerFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        GroupManagerFragment groupManagerFragment = (GroupManagerFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != 1282170478 || !str.equals(d.K)) {
                z = true;
            }
            if (!z && GroupInfoModel.class.isInstance(obj)) {
                groupManagerFragment.a((GroupInfoModel) obj);
            }
        }
    }
}
