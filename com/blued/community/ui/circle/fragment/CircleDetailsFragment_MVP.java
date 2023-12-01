package com.blued.community.ui.circle.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.community.ui.circle.model.CircleBubble;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleDetailsFragment_MVP.class */
public final class CircleDetailsFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        CircleDetailsFragment circleDetailsFragment = (CircleDetailsFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != 46525147 || !str.equals("circle_bubble")) {
                z = true;
            }
            if (!z && CircleBubble.class.isInstance(obj)) {
                circleDetailsFragment.a((CircleBubble) obj);
            }
        }
    }
}
