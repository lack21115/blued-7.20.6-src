package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c.class */
public interface c {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$a.class */
    public interface a {
        void ax(int i);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$b.class */
    public interface b {
        void nU();
    }

    /* renamed from: com.kwad.sdk.core.video.kwai.c$c  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$c.class */
    public interface InterfaceC0567c {
        boolean j(int i, int i2);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$d.class */
    public interface d {
        boolean k(int i, int i2);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$e.class */
    public interface e {
        void a(c cVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$f.class */
    public interface f {
        void nV();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$g.class */
    public interface g {
        void a(TimedText timedText);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/c$h.class */
    public interface h {
        void i(int i, int i2);
    }

    void a(com.kwad.sdk.contentalliance.kwai.kwai.b bVar);

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0567c interfaceC0567c);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void b(e eVar);

    void c(d dVar);

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

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void setVolume(float f2, float f3);

    void start();

    void stop();
}
