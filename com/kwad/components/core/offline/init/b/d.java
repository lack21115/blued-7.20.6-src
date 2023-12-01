package com.kwad.components.core.offline.init.b;

import android.media.TimedText;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoPlayStateListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.video.kwai.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/b/d.class */
final class d {
    public static b.a a(final ReleaseCallback releaseCallback) {
        if (releaseCallback == null) {
            return null;
        }
        return new b.a() { // from class: com.kwad.components.core.offline.init.b.d.2
            @Override // com.kwad.components.core.video.b.a
            public final void onReleaseSuccess() {
                ReleaseCallback.this.onReleaseSuccess();
            }
        };
    }

    public static i a(final VideoPlayStateListener videoPlayStateListener) {
        if (videoPlayStateListener == null) {
            return null;
        }
        return new i() { // from class: com.kwad.components.core.offline.init.b.d.10
            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayBufferingPaused() {
                VideoPlayStateListener.this.onVideoPlayBufferingPaused();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayBufferingPlaying() {
                VideoPlayStateListener.this.onVideoPlayBufferingPlaying();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                VideoPlayStateListener.this.onVideoPlayCompleted();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayError(int i, int i2) {
                VideoPlayStateListener.this.onVideoPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayPaused() {
                VideoPlayStateListener.this.onVideoPlayPaused();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j, long j2) {
                VideoPlayStateListener.this.onVideoPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                VideoPlayStateListener.this.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                VideoPlayStateListener.this.onVideoPlaying();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPrepared() {
                VideoPlayStateListener.this.onVideoPrepared();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPreparing() {
                VideoPlayStateListener.this.onVideoPreparing();
            }
        };
    }

    public static com.kwad.sdk.contentalliance.kwai.kwai.a a(KsPlayerLogParams ksPlayerLogParams) {
        if (ksPlayerLogParams == null) {
            return null;
        }
        com.kwad.sdk.contentalliance.kwai.kwai.a aVar = new com.kwad.sdk.contentalliance.kwai.kwai.a();
        aVar.photoId = ksPlayerLogParams.photoId;
        aVar.clickTime = ksPlayerLogParams.clickTime;
        aVar.adStyle = ksPlayerLogParams.adStyle;
        aVar.contentType = ksPlayerLogParams.contentType;
        return aVar;
    }

    public static com.kwad.sdk.contentalliance.kwai.kwai.b a(PlayVideoInfo playVideoInfo) {
        if (playVideoInfo == null) {
            return null;
        }
        return new b.a(playVideoInfo.videoUrl).bt(playVideoInfo.manifest).b(a(playVideoInfo.ksplayerLogParams)).a(playVideoInfo.videoPlayerStatus).aV(playVideoInfo.isNoCache).tR();
    }

    public static c.a a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener == null) {
            return null;
        }
        return new c.a() { // from class: com.kwad.components.core.offline.init.b.d.4
            @Override // com.kwad.sdk.core.video.kwai.c.a
            public final void ax(int i) {
                IMediaPlayer.OnBufferingUpdateListener.this.onBufferingUpdate(iMediaPlayer, i);
            }
        };
    }

    public static c.b a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            return null;
        }
        return new c.b() { // from class: com.kwad.components.core.offline.init.b.d.3
            @Override // com.kwad.sdk.core.video.kwai.c.b
            public final void nU() {
                IMediaPlayer.OnCompletionListener.this.onCompletion(iMediaPlayer);
            }
        };
    }

    public static c.InterfaceC0567c a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            return null;
        }
        return new c.InterfaceC0567c() { // from class: com.kwad.components.core.offline.init.b.d.7
            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0567c
            public final boolean j(int i, int i2) {
                return IMediaPlayer.OnErrorListener.this.onError(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.d a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            return null;
        }
        return new c.d() { // from class: com.kwad.components.core.offline.init.b.d.8
            @Override // com.kwad.sdk.core.video.kwai.c.d
            public final boolean k(int i, int i2) {
                return IMediaPlayer.OnInfoListener.this.onInfo(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.e a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener == null) {
            return null;
        }
        return new c.e() { // from class: com.kwad.components.core.offline.init.b.d.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                IMediaPlayer.OnPreparedListener.this.onPrepared(iMediaPlayer);
            }
        };
    }

    public static c.f a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            return null;
        }
        return new c.f() { // from class: com.kwad.components.core.offline.init.b.d.5
            @Override // com.kwad.sdk.core.video.kwai.c.f
            public final void nV() {
                IMediaPlayer.OnSeekCompleteListener.this.onSeekComplete(iMediaPlayer);
            }
        };
    }

    public static c.g a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener == null) {
            return null;
        }
        return new c.g() { // from class: com.kwad.components.core.offline.init.b.d.9
            @Override // com.kwad.sdk.core.video.kwai.c.g
            public final void a(TimedText timedText) {
                IMediaPlayer.OnTimedTextListener.this.onTimedText(iMediaPlayer, timedText);
            }
        };
    }

    public static c.h a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return null;
        }
        return new c.h() { // from class: com.kwad.components.core.offline.init.b.d.6
            @Override // com.kwad.sdk.core.video.kwai.c.h
            public final void i(int i, int i2) {
                IMediaPlayer.OnVideoSizeChangedListener.this.onVideoSizeChanged(iMediaPlayer, i, i2);
            }
        };
    }
}
