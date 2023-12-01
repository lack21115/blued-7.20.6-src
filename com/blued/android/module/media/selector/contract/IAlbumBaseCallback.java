package com.blued.android.module.media.selector.contract;

import android.content.Context;
import com.blued.android.module.player.media.model.MediaInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/contract/IAlbumBaseCallback.class */
public interface IAlbumBaseCallback {
    int a();

    int a(MediaInfo mediaInfo);

    MediaInfo a(int i);

    void a(int i, MediaInfo mediaInfo);

    boolean a(MediaInfo mediaInfo, int i);

    int b();

    boolean c();

    Context getContext();
}
