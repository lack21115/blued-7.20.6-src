package com.blued.android.module.media.selector.contract;

import android.content.Context;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/contract/IAlbumPreviewBaseCallback.class */
public interface IAlbumPreviewBaseCallback {
    int a();

    BaseFragment a(VideoPlayConfig videoPlayConfig);

    MediaInfo a(int i);

    Context getContext();
}
