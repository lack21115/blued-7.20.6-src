package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.LiveFansGoodsModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansTaskFragment_MVP.class */
public final class LiveFansTaskFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        LiveFansTaskFragment liveFansTaskFragment = (LiveFansTaskFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != 1845895978 || !str.equals("LIVE_FANS_GOODS")) {
                z = true;
            }
            if (!z && LiveFansGoodsModel.class.isInstance(obj)) {
                liveFansTaskFragment.a((LiveFansGoodsModel) obj);
            }
        }
    }
}
