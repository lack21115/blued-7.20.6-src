package com.kwad.components.offline.api.core.video;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IVideo.class */
public interface IVideo {
    IKsMediaPlayer createMediaPlayer(IKsMediaPlayerView iKsMediaPlayerView);

    BaseKsMediaPlayerView createMediaPlayerView(Context context);
}
