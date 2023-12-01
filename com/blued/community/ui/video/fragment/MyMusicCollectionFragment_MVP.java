package com.blued.community.ui.video.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.community.ui.video.model.VideoScanMusic;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/fragment/MyMusicCollectionFragment_MVP.class */
public final class MyMusicCollectionFragment_MVP implements MvpDispatcher {
    public void a(MvpFragment mvpFragment, String str, List list) {
        MyMusicCollectionFragment myMusicCollectionFragment = (MyMusicCollectionFragment) mvpFragment;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Object obj = list.get(0);
        if (obj != null) {
            if (str.hashCode() != 1060253087 || !str.equals("collection_list")) {
                z = true;
            }
            if (!z && VideoScanMusic.class.isInstance(obj)) {
                myMusicCollectionFragment.a(list);
            }
        }
    }
}
