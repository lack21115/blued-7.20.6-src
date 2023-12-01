package com.blued.community.ui.circle.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.community.ui.circle.model.MyCircleModel;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleInfoSettingFragment_MVP.class */
public final class CircleInfoSettingFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        CircleInfoSettingFragment circleInfoSettingFragment = (CircleInfoSettingFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != -1519155757 || !str.equals("circle_details")) {
                z = true;
            }
            if (!z && MyCircleModel.class.isInstance(obj)) {
                circleInfoSettingFragment.a((MyCircleModel) obj);
            }
        }
    }
}
