package com.blued.community.ui.topic.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/fragment/SuperTopicFragment_MVP.class */
public final class SuperTopicFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        SuperTopicFragment superTopicFragment = (SuperTopicFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != -363613165 || !str.equals("data_list")) {
                z = true;
            }
            if (!z && BluedTopic.class.isInstance(obj)) {
                superTopicFragment.a(list);
            }
        }
    }
}
