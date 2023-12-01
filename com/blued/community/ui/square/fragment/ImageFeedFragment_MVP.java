package com.blued.community.ui.square.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.community.model.BluedIngSelfFeed;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/ImageFeedFragment_MVP.class */
public final class ImageFeedFragment_MVP implements MvpDispatcher {
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        ImageFeedFragment imageFeedFragment = (ImageFeedFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != -1644013921 || !str.equals("feed_list")) {
                z = true;
            }
            if (!z && BluedIngSelfFeed.class.isInstance(obj)) {
                imageFeedFragment.a(list);
            }
        }
    }
}
