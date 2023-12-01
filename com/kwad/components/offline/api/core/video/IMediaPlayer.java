package com.kwad.components.offline.api.core.video;

import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer.class */
public interface IMediaPlayer {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnBufferingUpdateListener.class */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnCompletionListener.class */
    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnErrorListener.class */
    public interface OnErrorListener {
        boolean onError(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnInfoListener.class */
    public interface OnInfoListener {
        boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnPreparedListener.class */
    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnSeekCompleteListener.class */
    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnTimedTextListener.class */
    public interface OnTimedTextListener {
        void onTimedText(IMediaPlayer iMediaPlayer, TimedText timedText);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/IMediaPlayer$OnVideoSizeChangedListener.class */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getMediaPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setAudioStreamType(int i);

    void setDataSource(Context context, Uri uri);

    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(PlayVideoInfo playVideoInfo);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnTimedTextListener(OnTimedTextListener onTimedTextListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start();

    void stop();
}
