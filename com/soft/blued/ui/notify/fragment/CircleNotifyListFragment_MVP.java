package com.soft.blued.ui.notify.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.notify.model.CircleNotify;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/CircleNotifyListFragment_MVP.class */
public final class CircleNotifyListFragment_MVP implements MvpDispatcher {
    public void a(MvpFragment mvpFragment, String str, List list) {
        CircleNotifyListFragment circleNotifyListFragment = (CircleNotifyListFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != -1742866476 || !str.equals("notify_list")) {
                z = true;
            }
            if (!z && CircleNotify.class.isInstance(obj)) {
                circleNotifyListFragment.a(list);
            }
        }
    }
}
