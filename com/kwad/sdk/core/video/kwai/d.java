package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/d.class */
public final class d extends com.kwad.sdk.core.video.kwai.a {
    private static volatile boolean ana = false;
    private static final Queue<d> anb = new ConcurrentLinkedQueue();
    private com.kwad.sdk.contentalliance.kwai.kwai.b QI;
    private String amS;
    private MediaDataSource amT;
    private final Object amU;
    private boolean amV;
    private final KSVodPlayerWrapper amW;
    private final a amX;
    private boolean amY;
    private boolean amZ;
    private boolean anc;
    private int mSarDen;
    private int mSarNum;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/d$a.class */
    public static final class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final WeakReference<d> mWeakMediaPlayer;

        a(d dVar) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
        }

        private d ym() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i) {
            d ym = ym();
            if (ym != null) {
                ym.notifyOnBufferingUpdate(i);
            }
        }

        public final void onError(int i, int i2) {
            d ym = ym();
            if (ym != null) {
                d.a(ym, false);
                ym.notifyOnError(i, i2);
            }
        }

        public final void onEvent(int i, int i2) {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onEvent, what: " + i);
            d ym = ym();
            if (ym != null) {
                if (i == 10100) {
                    ym.notifyOnSeekComplete();
                } else if (i == 10101) {
                    ym.notifyOnCompletion();
                } else {
                    if (i == 10209) {
                        ym.yl();
                    }
                    ym.notifyOnInfo(i, i2);
                }
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onPrepared");
            d ym = ym();
            if (ym != null) {
                ym.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d ym = ym();
            if (ym != null) {
                ym.r(i, i2);
                ym.mSarNum = i3;
                ym.mSarDen = i4;
            }
        }
    }

    public d() {
        Object obj = new Object();
        this.amU = obj;
        this.amZ = false;
        this.anc = true;
        synchronized (obj) {
            this.amW = new KSVodPlayerWrapper(k.FP());
        }
        this.amX = new a(this);
        yi();
        setLooping(false);
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.amZ = false;
        return false;
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.amS = str;
        this.amW.setDataSource(str, (Map) null);
    }

    private void yh() {
        MediaDataSource mediaDataSource = this.amT;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.amT = null;
        }
    }

    private void yi() {
        this.amW.setOnPreparedListener(this.amX);
        this.amW.setBufferingUpdateListener(this.amX);
        this.amW.setOnEventListener(this.amX);
        this.amW.setVideoSizeChangedListener(this.amX);
        this.amW.setOnErrorListener(this.amX);
    }

    private void yj() {
        this.amW.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.amW.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.amW.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.amW.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.amW.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    private void yk() {
        if (this.amZ) {
            return;
        }
        try {
            int prepareAsync = this.amW.prepareAsync();
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "realPrepare: ret: " + prepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.d.b.e("KwaiMediaPlayer", "realPrepare failed", e);
        }
        this.amZ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl() {
        int i;
        Queue<d> queue;
        Iterator<d> it = anb.iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                i = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i);
        int i3 = i + 1;
        if (i3 < anb.size()) {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
            int i4 = 0;
            while (true) {
                int i5 = i4;
                queue = anb;
                if (i5 >= i3) {
                    break;
                }
                queue.poll();
                i4 = i5 + 1;
            }
            d poll = queue.poll();
            anb.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        if (this.amW == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.tQ();
        this.amW.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        this.QI = bVar;
        a(bVar.abv);
        f fVar = (f) ServiceProvider.get(f.class);
        setDataSource((TextUtils.isEmpty(bVar.manifest) || fVar == null || !fVar.rI()) ? bVar.videoUrl : bVar.manifest, (Map<String, String>) null);
    }

    public final void aX(boolean z) {
        this.anc = z;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getAudioSessionId() {
        return this.amW.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.amW;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getCurrentPosition() {
        try {
            return this.amW.getCurrentPosition();
        } catch (IllegalStateException e) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getDataSource() {
        return this.amS;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getDuration() {
        try {
            return this.amW.getDuration();
        } catch (IllegalStateException e) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoHeight() {
        return this.amW.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoWidth() {
        return this.amW.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isLooping() {
        return this.amY;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isPlaying() {
        try {
            return this.amW.isPlaying();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void pause() {
        this.amW.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean prepareAsync() {
        if (!this.anc) {
            yk();
            return true;
        }
        if (!anb.contains(this)) {
            anb.offer(this);
        }
        if (anb.size() == 1) {
            yk();
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "prepareAsync first");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void release() {
        boolean remove = anb.remove(this);
        com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + anb.size());
        this.amV = true;
        this.amW.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.kwai.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onPlayerRelease");
            }
        });
        yh();
        resetListeners();
        yj();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void reset() {
        this.amZ = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.amW.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException e) {
        }
        yh();
        resetListeners();
        yi();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void seekTo(long j) {
        this.amW.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.amU) {
            if (!this.amV) {
                this.amW.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setLooping(boolean z) {
        this.amY = z;
        this.amW.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setSpeed(float f) {
        this.amW.setSpeed(f);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setSurface(Surface surface) {
        this.amW.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setVolume(float f, float f2) {
        this.amW.setVolume(f, f2);
        f(f);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void start() {
        com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "start");
        yk();
        this.amW.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void stop() {
        this.amW.stop();
    }
}
