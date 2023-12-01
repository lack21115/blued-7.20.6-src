package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverReleationModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverMatchFragment_MVP.class */
public final class LiveMakeLoverMatchFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        LiveMakeLoverMatchFragment liveMakeLoverMatchFragment = (LiveMakeLoverMatchFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != 1038681772 || !str.equals("MAKE_LOVER_RELATION")) {
                z = true;
            }
            if (!z && LiveMakeLoverReleationModel.class.isInstance(obj)) {
                liveMakeLoverMatchFragment.a((LiveMakeLoverReleationModel) obj);
            }
        }
    }
}
