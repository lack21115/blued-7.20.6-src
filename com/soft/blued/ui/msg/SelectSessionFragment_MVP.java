package com.soft.blued.ui.msg;

import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SelectSessionFragment_MVP.class */
public final class SelectSessionFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        SelectSessionFragment selectSessionFragment = (SelectSessionFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != 1310838529 || !str.equals("data_session")) {
                z = true;
            }
            if (!z && SessionModel.class.isInstance(obj)) {
                selectSessionFragment.a(list);
            }
        }
    }
}
