package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansMemberFragment_MVP.class */
public final class LiveFansMemberFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        LiveFansMemberFragment liveFansMemberFragment = (LiveFansMemberFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != -728878545 || !str.equals("MEMBER_DATA")) {
                z = true;
            }
            if (!z && LiveFansMemberModel.class.isInstance(obj)) {
                liveFansMemberFragment.a(list);
            }
        }
    }
}
