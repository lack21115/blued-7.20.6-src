package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.BluedLiveListData;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveListHotFragment_MVP.class */
public final class LiveListHotFragment_MVP implements MvpDispatcher {
    private void a(LiveListHotFragment liveListHotFragment, String str) {
        if ((str.hashCode() == 521559408 && str.equals("HOT_LIST")) ? false : true) {
            return;
        }
        liveListHotFragment.b();
    }

    public void a(MvpFragment mvpFragment, String str, List list) {
        LiveListHotFragment liveListHotFragment = (LiveListHotFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != 521559408 || !str.equals("HOT_LIST")) {
                    z = true;
                }
                if (!z && BluedLiveListData.class.isInstance(obj)) {
                    liveListHotFragment.a(list);
                    return;
                }
            }
        }
        a(liveListHotFragment, str);
    }
}
