package com.blued.android.module.yy_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.yy_china.model.YYLiveState;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYApplyFragment_MVP.class */
public final class YYApplyFragment_MVP implements MvpDispatcher {
    private void a(YYApplyFragment yYApplyFragment, String str) {
        if ((str.hashCode() == -1102999352 && str.equals("yy_apply_submit")) ? false : true) {
            return;
        }
        yYApplyFragment.b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        YYApplyFragment yYApplyFragment = (YYApplyFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != -35611167 || !str.equals("yy_apply_state")) {
                    z = true;
                }
                if (!z && YYLiveState.class.isInstance(obj)) {
                    yYApplyFragment.a((YYLiveState) obj);
                    return;
                }
            }
        }
        a(yYApplyFragment, str);
    }
}
