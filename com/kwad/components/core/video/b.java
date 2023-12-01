package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.kwad.sdk.core.video.kwai.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/b.class */
public final class b {
    private static boolean QB = false;
    private static final AtomicInteger QC = new AtomicInteger(0);
    private com.kwad.sdk.core.video.kwai.c QE;
    private int QF;
    private long QG;
    private Runnable QH;
    private com.kwad.sdk.contentalliance.kwai.kwai.b QI;
    private int Qm;
    private int Qn;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private String TAG = "MediaPlayerImpl";
    private volatile int QD = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private long mStartTime = 0;
    private int QJ = 0;
    private List<c.d> QK = new CopyOnWriteArrayList();
    private final AtomicBoolean QL = new AtomicBoolean(false);
    private boolean QM = false;
    private volatile List<i> QN = new CopyOnWriteArrayList();
    private volatile List<c.e> QO = new CopyOnWriteArrayList();
    private c.e QP = new c.e() { // from class: com.kwad.components.core.video.b.1
        @Override // com.kwad.sdk.core.video.kwai.c.e
        public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
            String str = b.this.TAG;
            com.kwad.sdk.core.d.b.i(str, "onPrepared:" + b.getStateString(b.this.QD) + "->STATE_PREPARED");
            b.this.QD = 2;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            for (c.e eVar : b.this.QO) {
                eVar.a(b.this.QE);
            }
        }
    };
    private c.h QQ = new c.h() { // from class: com.kwad.components.core.video.b.3
        @Override // com.kwad.sdk.core.video.kwai.c.h
        public final void i(int i, int i2) {
            if (b.this.mDetailVideoView != null) {
                b.this.mDetailVideoView.adaptVideoSize(i, i2);
            }
            String str = b.this.TAG;
            com.kwad.sdk.core.d.b.i(str, "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
        }
    };
    private c.b QR = new c.b() { // from class: com.kwad.components.core.video.b.4
        @Override // com.kwad.sdk.core.video.kwai.c.b
        public final void nU() {
            b.this.QD = 9;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoFinishPlay");
        }
    };
    private c.InterfaceC0567c QS = new c.InterfaceC0567c() { // from class: com.kwad.components.core.video.b.5
        @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0567c
        public final boolean j(int i, int i2) {
            if (i != -38) {
                b.this.QD = -1;
                b.this.Qm = i;
                b.this.Qn = i2;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.QD);
                com.kwad.sdk.core.video.kwai.kwai.a.cN("videoPlayError");
                String str = b.this.TAG;
                com.kwad.sdk.core.d.b.i(str, "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                return true;
            }
            return true;
        }
    };
    private c.d QT = new c.d() { // from class: com.kwad.components.core.video.b.6
        @Override // com.kwad.sdk.core.video.kwai.c.d
        public final boolean k(int i, int i2) {
            String str;
            StringBuilder sb;
            String str2;
            String str3;
            String str4;
            if (i != 3) {
                if (i == 701) {
                    if (b.this.QD == 5 || b.this.QD == 7) {
                        b.this.QD = 7;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        b.this.QD = 6;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.b.i(str3, str4);
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.QD);
                } else if (i == 702) {
                    if (b.this.QD == 6) {
                        b.this.QD = 4;
                        b bVar2 = b.this;
                        bVar2.onPlayStateChanged(bVar2.QD);
                        com.kwad.sdk.core.d.b.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.QD == 7) {
                        b.this.QD = 5;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.QD);
                        str = b.this.TAG;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        com.kwad.sdk.core.d.b.i(str, str2);
                    }
                } else if (i != 10001) {
                    if (i == 801) {
                        str = b.this.TAG;
                        str2 = "视频不能seekTo，为直播视频";
                        com.kwad.sdk.core.d.b.i(str, str2);
                    } else {
                        str = b.this.TAG;
                        sb = new StringBuilder("onInfo ——> what：");
                        sb.append(i);
                    }
                }
                b bVar4 = b.this;
                bVar4.a(bVar4.QE, i, i2);
                return true;
            }
            b.this.QD = 4;
            b bVar5 = b.this;
            bVar5.onPlayStateChanged(bVar5.QD);
            str = b.this.TAG;
            sb = new StringBuilder("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
            sb.append(System.currentTimeMillis() - b.this.mStartTime);
            str2 = sb.toString();
            com.kwad.sdk.core.d.b.i(str, str2);
            b bVar42 = b.this;
            bVar42.a(bVar42.QE, i, i2);
            return true;
        }
    };
    private c.a QU = new c.a() { // from class: com.kwad.components.core.video.b.7
        @Override // com.kwad.sdk.core.video.kwai.c.a
        public final void ax(int i) {
            b.this.QF = i;
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/b$a.class */
    public interface a {
        void onReleaseSuccess();
    }

    public b(DetailVideoView detailVideoView) {
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
    }

    private void a(com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, DetailVideoView detailVideoView, com.kwad.sdk.core.video.kwai.c cVar) {
        com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer");
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.QM = z;
        this.QI = bVar;
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.QE != cVar) {
            com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.kwai.c cVar2 = this.QE;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                qg();
                this.QE.release();
            }
            this.QE = cVar;
            reset();
            qf();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            qg();
            qf();
        }
        this.QE.setSurface(detailVideoView.Rc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.sdk.core.video.kwai.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        try {
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    public static String getStateString(int i) {
        switch (i) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.QN != null) {
            for (i iVar : this.QN) {
                iVar.onVideoPlayProgress(duration, currentPosition);
            }
        }
    }

    private void qf() {
        this.QE.b(this.QP);
        this.QE.a(this.QQ);
        this.QE.a(this.QR);
        this.QE.a(this.QS);
        this.QE.c(this.QT);
        this.QE.a(this.QU);
    }

    private void qg() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0567c) null);
        this.QE.a((c.b) null);
        this.QE.b(null);
        this.QE.a((c.h) null);
        this.QE.c(null);
        this.QE.a((c.f) null);
        this.QE.a((c.a) null);
    }

    private void qi() {
        qj();
        if (this.QH == null) {
            this.QH = new Runnable() { // from class: com.kwad.components.core.video.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.qc();
                    if (b.this.QH != null) {
                        b.this.mHandler.postDelayed(b.this.QH, 500L);
                    }
                }
            };
        }
        this.mHandler.post(this.QH);
    }

    private void qj() {
        Runnable runnable = this.QH;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.QH = null;
        }
    }

    private void reset() {
        String str = this.TAG;
        com.kwad.sdk.core.d.b.i(str, "reset:" + getStateString(this.QD) + "->STATE_IDLE");
        this.QE.reset();
        this.QD = 0;
    }

    private void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void setPlayType(int i) {
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.QI;
        if (bVar == null || bVar.videoPlayerStatus == null) {
            return;
        }
        this.QI.videoPlayerStatus.mVideoPlayerType = i;
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    public final void a(final a aVar, boolean z) {
        if (this.QE == null) {
            return;
        }
        setKeepScreenOn(false);
        this.mHandler.removeCallbacksAndMessages(null);
        qj();
        qg();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.video.b.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        b bVar = b.this;
                        b.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.QE = null;
        }
        String str = this.TAG;
        com.kwad.sdk.core.d.b.i(str, "release:" + getStateString(this.QD) + "->STATE_IDLE");
        this.QD = 0;
        this.QJ = 0;
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar instanceof com.kwad.sdk.core.video.kwai.d) {
            ((com.kwad.sdk.core.video.kwai.d) cVar).a(aVar);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        try {
            if (TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.d.b.e(this.TAG, "videoUrl is null");
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.d.b.d(str, "videoUrl=" + bVar.videoUrl);
            this.QE.a(bVar);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.b bVar, DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, boolean z2, DetailVideoView detailVideoView) {
        String str = this.TAG;
        com.kwad.sdk.core.d.b.i(str, "initMediaPlayer enablePreLoad:" + z);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.kwai.c a2 = com.kwad.sdk.core.video.kwai.e.a(this.mContext, z, com.kwad.sdk.core.config.d.sv(), com.kwad.sdk.core.config.d.sw());
        a2.setLooping(false);
        a(bVar, z2, detailVideoView, a2);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.QK.add(dVar);
    }

    public final void a(c.e eVar) {
        this.QO.add(eVar);
    }

    public final void a(com.kwad.sdk.core.video.kwai.c cVar, int i, int i2) {
        Iterator<c.d> it = this.QK.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.k(i, i2);
            }
        }
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.QK.remove(dVar);
    }

    public final void c(i iVar) {
        this.QN.add(iVar);
    }

    public final void clear() {
        this.QN.clear();
    }

    public final void d(i iVar) {
        this.QN.remove(iVar);
    }

    public final int getBufferPercentage() {
        return this.QF;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    public final boolean isPrepared() {
        return this.QD == 2 || this.QD == 3 || this.QD == 5 || this.QD == 8 || this.QD == 9;
    }

    public final boolean isPreparing() {
        return this.QD == 1;
    }

    public final void onPlayStateChanged(int i) {
        if (this.QN == null) {
            return;
        }
        for (i iVar : this.QN) {
            if (iVar != null) {
                switch (i) {
                    case -1:
                        setKeepScreenOn(false);
                        qj();
                        iVar.onVideoPlayError(this.Qm, this.Qn);
                        continue;
                    case 1:
                        iVar.onVideoPreparing();
                        continue;
                    case 2:
                        iVar.onVideoPrepared();
                        continue;
                    case 3:
                        setKeepScreenOn(true);
                        iVar.onVideoPlayStart();
                        continue;
                    case 4:
                        setKeepScreenOn(true);
                        iVar.onVideoPlaying();
                        continue;
                    case 5:
                        setKeepScreenOn(false);
                        iVar.onVideoPlayPaused();
                        continue;
                    case 6:
                        iVar.onVideoPlayBufferingPlaying();
                        continue;
                    case 7:
                        iVar.onVideoPlayBufferingPaused();
                        continue;
                    case 9:
                        try {
                            if (this.QE != null && !this.QE.isLooping()) {
                                setKeepScreenOn(false);
                                qj();
                            }
                            iVar.onVideoPlayCompleted();
                            continue;
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                            break;
                        }
                }
            }
        }
    }

    public final boolean pause() {
        boolean z;
        com.kwad.sdk.core.d.b.i(this.TAG, "pause mCurrentState: " + getStateString(this.QD));
        if (this.QD == 4) {
            this.QE.pause();
            com.kwad.sdk.core.d.b.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.QD = 5;
            onPlayStateChanged(this.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.QD == 6) {
            this.QE.pause();
            com.kwad.sdk.core.d.b.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.QD = 7;
            onPlayStateChanged(this.QD);
            z = true;
        }
        if (this.QD == 3) {
            this.QE.pause();
            com.kwad.sdk.core.d.b.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.QD = 5;
            onPlayStateChanged(this.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoPausePlay");
            z = true;
        }
        if (this.QD == 9 && this.QE.isLooping()) {
            this.QE.pause();
            com.kwad.sdk.core.d.b.i(this.TAG, "pause " + getStateString(this.QD) + "->STATE_PAUSED");
            this.QD = 5;
            onPlayStateChanged(this.QD);
            return true;
        }
        return z;
    }

    public final void prepareAsync() {
        if (this.QE == null) {
            return;
        }
        if (this.QM) {
            if (this.QL.compareAndSet(false, true)) {
                com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.video.b.8
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0110  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void run() {
                        /*
                            Method dump skipped, instructions count: 310
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.video.b.AnonymousClass8.run():void");
                    }
                });
                return;
            }
            return;
        }
        try {
            a(this.QI);
            if (!this.QE.prepareAsync()) {
                com.kwad.sdk.core.d.b.e(this.TAG, "prepareAsync failed");
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.d.b.i(str, "prepareAsync:" + getStateString(this.QD) + "->STATE_PREPARING");
            this.QD = 1;
            onPlayStateChanged(this.QD);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.QJ;
                this.QJ = i + 1;
                if (i <= 4) {
                    qh();
                }
            }
            String str2 = this.TAG;
            com.kwad.sdk.core.d.b.i(str2, "prepareAsync Exception:" + getStateString(this.QD));
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    public final com.kwad.sdk.core.video.kwai.c qe() {
        return this.QE;
    }

    public final void qh() {
        if (this.QE == null) {
            com.kwad.sdk.core.d.b.w("resetAndPlay", "mMediaPlayer is null");
        } else if (this.QD == 2 || this.QD == 3 || this.QD == 4 || this.QD == 5) {
            com.kwad.sdk.core.d.b.w("resetAndPlay", "can not resetAndPlay in sate:" + this.QD);
        } else {
            reset();
            qg();
            qf();
            prepareAsync();
        }
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseSync() {
        a((a) null, false);
    }

    public final void restart() {
        if (this.QE != null && this.QD == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        if (this.QE == null) {
            com.kwad.sdk.core.d.b.e(this.TAG, "resume but mMediaPlayer is null");
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.d.b.i(str, "resume mCurrentState: " + getStateString(this.QD));
        if (this.QD == 2 || this.QD == 0) {
            String str2 = this.TAG;
            com.kwad.sdk.core.d.b.i(str2, "resume:" + getStateString(this.QD) + "->start()");
            start();
        } else if (this.QD == 5) {
            this.QE.start();
            String str3 = this.TAG;
            com.kwad.sdk.core.d.b.i(str3, "resume:" + getStateString(this.QD) + "->STATE_PLAYING");
            this.QD = 4;
            onPlayStateChanged(this.QD);
            setPlayType(2);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoResumePlay");
        } else if (this.QD != 7) {
            if (this.QD != 1) {
                String str4 = this.TAG;
                com.kwad.sdk.core.d.b.w(str4, "resume: " + getStateString(this.QD) + " 此时不能调用resume()方法.");
            }
        } else {
            this.QE.start();
            String str5 = this.TAG;
            com.kwad.sdk.core.d.b.i(str5, "resume:" + getStateString(this.QD) + "->STATE_BUFFERING_PLAYING");
            this.QD = 6;
            onPlayStateChanged(this.QD);
        }
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            cVar.seekTo(j);
        }
    }

    public final void setAudioEnabled(boolean z) {
        float f = z ? 1.0f : 0.0f;
        setVolume(f, f);
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f, f2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0112, code lost:
        if (r5.QD == 9) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void start() {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.video.b.start():void");
    }

    public final void start(long j) {
        this.QG = j;
        start();
    }

    public final void stopAndPrepareAsync() {
        String str = this.TAG;
        com.kwad.sdk.core.d.b.i(str, "stopAndPrepareAsync mCurrentState:" + this.QD);
        if (this.QD == 1 || this.QD == 2) {
            return;
        }
        if (this.QD != 3 && this.QD != 4 && this.QD != 5 && this.QD != 6 && this.QD != 7 && this.QD != 8 && this.QD != 9) {
            release();
            return;
        }
        try {
            this.QE.stop();
            this.QD = 8;
            onPlayStateChanged(this.QD);
            prepareAsync();
        } catch (Exception e) {
            release();
            String str2 = this.TAG;
            com.kwad.sdk.core.d.b.e(str2, "stopAndPrepareAsync mCurrentState:" + this.QD);
        }
    }
}
