package com.soft.blued.ui.msg.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/UserGiftPackageFragment_MVP.class */
public final class UserGiftPackageFragment_MVP implements MvpDispatcher {
    private void a(UserGiftPackageFragment userGiftPackageFragment, String str) {
        if ((str.hashCode() == -1784691660 && str.equals("DATA_BUY_SUCCEED")) ? false : true) {
            return;
        }
        userGiftPackageFragment.v();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        UserGiftPackageFragment userGiftPackageFragment = (UserGiftPackageFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != 771425425 || !str.equals("DATA_PACKAGE")) {
                    z = true;
                }
                if (!z && UserGiftPackageModel.class.isInstance(obj)) {
                    userGiftPackageFragment.c(list);
                    return;
                }
            }
        }
        a(userGiftPackageFragment, str);
    }
}
