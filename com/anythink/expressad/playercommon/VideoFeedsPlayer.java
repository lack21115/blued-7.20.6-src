package com.anythink.expressad.playercommon;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import com.anythink.core.common.a.j;
import com.anythink.core.common.b.n;
import com.anythink.expressad.exoplayer.ad;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.d;
import com.anythink.expressad.exoplayer.f;
import com.anythink.expressad.exoplayer.g;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.h.o;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.i;
import com.anythink.expressad.exoplayer.i.c;
import com.anythink.expressad.exoplayer.v;
import com.anythink.expressad.exoplayer.w;
import com.anythink.expressad.foundation.h.o;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/playercommon/VideoFeedsPlayer.class */
public class VideoFeedsPlayer implements w.c {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final String TAG = "VideoFeedsPlayer";
    private ad exoPlayer;
    private Timer mBufferTimeoutTimer;
    private Context mContext;
    private long mCurrentPosition;
    private View mFullScreenLoadingView;
    private volatile VideoPlayerStatusListener mInnerVFPLisener;
    private boolean mIsSilent;
    private WeakReference<View> mLoadingView;
    private volatile VideoPlayerStatusListener mOutterVFListener;
    private String mPlayUrl;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoReadyRate;
    private s mediaSource;
    private boolean mIsComplete = false;
    private boolean mIsPlaying = false;
    private boolean mHasPrepare = false;
    private boolean mIsBuffering = false;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsFrontDesk = true;
    private int mBufferTime = 5;
    private Object mLock = new Object();
    private boolean isStart = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };
    private boolean needPrepareVideoPlayAgain = false;
    private String mNetVideoUrl = "";
    private String mMediaSourceUrl = "";
    private Runnable playProgressRunnable = new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.2
        @Override // java.lang.Runnable
        public void run() {
            long j;
            int i;
            try {
                if (VideoFeedsPlayer.this.exoPlayer == null || !VideoFeedsPlayer.this.exoPlayerIsPlaying()) {
                    return;
                }
                VideoFeedsPlayer.this.mCurrentPosition = VideoFeedsPlayer.this.exoPlayer.t();
                float f = ((float) VideoFeedsPlayer.this.mCurrentPosition) / 1000.0f;
                float f2 = (float) (VideoFeedsPlayer.this.mCurrentPosition % 1000);
                int round = Math.round(f);
                o.b(VideoFeedsPlayer.TAG, "currentPosition:" + round + " mCurrentPosition:" + VideoFeedsPlayer.this.mCurrentPosition);
                if (VideoFeedsPlayer.this.exoPlayer == null || VideoFeedsPlayer.this.exoPlayer.s() <= 0) {
                    j = 0;
                    i = round;
                } else {
                    long s = VideoFeedsPlayer.this.exoPlayer.s() / 1000;
                    i = round;
                    j = s;
                    if (f2 > 0.0f) {
                        i = round;
                        j = s;
                        if (f2 < 500.0f) {
                            i = round + 1;
                            j = s;
                        }
                    }
                }
                if (i >= 0 && j > 0 && i < 1 + j) {
                    VideoFeedsPlayer.this.postOnPlayProgressOnMainThread(i, (int) j);
                }
                VideoFeedsPlayer.this.mIsComplete = false;
                if (!VideoFeedsPlayer.this.mIsBuffering) {
                    VideoFeedsPlayer.this.hideLoading();
                }
                VideoFeedsPlayer.this.mHandler.postDelayed(this, 1000L);
            } catch (Exception e) {
                o.d(VideoFeedsPlayer.TAG, e.getMessage());
            }
        }
    };

    private void cancelBufferTimeoutTimer() {
        try {
            if (this.mBufferTimeoutTimer != null) {
                this.mBufferTimeoutTimer.cancel();
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void cancelPlayProgressTimer() {
        try {
            this.mHandler.removeCallbacks(this.playProgressRunnable);
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        try {
            if (this.mHandler == null) {
                return;
            }
            this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoFeedsPlayer.this.mLoadingView != null && VideoFeedsPlayer.this.mLoadingView.get() != 0) {
                        ((View) VideoFeedsPlayer.this.mLoadingView.get()).setVisibility(8);
                    }
                    if (VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                        VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(8);
                    }
                }
            });
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void postOnBufferinEndOnMainThread() {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onBufferingEnd();
                            } catch (Exception e) {
                                o.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingEnd();
                            } catch (Exception e2) {
                                o.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnBufferingStarOnMainThread(final String str) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onBufferingStart(str);
                            } catch (Exception e) {
                                o.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingStart(str);
                            } catch (Exception e2) {
                                o.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayCompletedOnMainThread() {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayCompleted();
                            } catch (Exception e) {
                                o.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayCompleted();
                            } catch (Exception e2) {
                                o.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayErrorOnMainThread(final String str) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayError(str);
                            } catch (Exception e) {
                                o.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayError(str);
                            } catch (Exception e2) {
                                o.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayProgressOnMainThread(final int i, final int i2) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayProgress(i, i2);
                            } catch (Exception e) {
                                o.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayProgress(i, i2);
                            } catch (Exception e2) {
                                o.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void postOnPlaySetDataSourceError2MainThread(final String str) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(str);
                            } catch (Exception e) {
                                o.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlaySetDataSourceError(str);
                            } catch (Exception e2) {
                                o.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayStartOnMainThread(final long j) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.9
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = (int) j;
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayStarted(i);
                            } catch (Exception e) {
                                o.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayStarted(i);
                            } catch (Exception e2) {
                                o.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void rePrepareVideoSourceAgain() {
        if (this.mOutterVFListener != null) {
            this.mOutterVFListener.onVideoDownloadResume();
        }
        s sVar = this.mediaSource;
        if (sVar != null) {
            this.exoPlayer.a(sVar);
        }
    }

    private void startBufferIngTimer(final String str) {
        if (!this.mIsNeedBufferingTimeout) {
            o.d(TAG, "不需要缓冲超时功能");
            return;
        }
        cancelBufferTimeoutTimer();
        Timer timer = new Timer();
        this.mBufferTimeoutTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    if (!VideoFeedsPlayer.this.mHasPrepare || VideoFeedsPlayer.this.mIsBuffering) {
                        o.d(VideoFeedsPlayer.TAG, "缓冲超时");
                        VideoFeedsPlayer.this.postOnBufferingStarOnMainThread(str);
                    }
                } catch (Exception e) {
                    o.d(VideoFeedsPlayer.TAG, e.getMessage());
                }
            }
        }, this.mBufferTime * 1000);
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void closeSound() {
        try {
            if (this.exoPlayer == null) {
                return;
            }
            this.exoPlayer.a(0.0f);
            this.mIsSilent = true;
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public boolean exoPlayerIsPlaying() {
        return this.exoPlayer.d() == 3 && this.exoPlayer.f();
    }

    public boolean fullScreenLoadingViewisVisible() {
        try {
            if (this.mFullScreenLoadingView != null) {
                return this.mFullScreenLoadingView.getVisibility() == 0;
            }
            return false;
        } catch (Throwable th) {
            o.d(TAG, th.getMessage());
            return false;
        }
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public int getDuration() {
        ad adVar = this.exoPlayer;
        if (adVar != null) {
            adVar.s();
            return 0;
        }
        return 0;
    }

    public boolean halfLoadingViewisVisible() {
        try {
            if (this.mLoadingView == null || this.mLoadingView.get() == null) {
                return false;
            }
            return this.mLoadingView.get().getVisibility() == 0;
        } catch (Throwable th) {
            o.d(TAG, th.getMessage());
            return false;
        }
    }

    public boolean hasPrepare() {
        return this.mHasPrepare;
    }

    public void initBufferIngParam(int i) {
        if (i > 0) {
            this.mBufferTime = i;
        }
        this.mIsNeedBufferingTimeout = true;
        o.b(TAG, "mIsNeedBufferingTimeout:" + this.mIsNeedBufferingTimeout + "  mMaxBufferTime:" + this.mBufferTime);
    }

    public boolean initPlayer(Context context, View view, String str, String str2, int i, VideoPlayerStatusListener videoPlayerStatusListener) {
        try {
            if (view == null) {
                o.b(TAG, "loadingView is NULL");
                postOnPlayErrorOnMainThread("MediaPlayer init error");
                return false;
            }
            o.b(TAG, "videoUrl:".concat(String.valueOf(str)));
            this.needPrepareVideoPlayAgain = !TextUtils.equals(str, str2);
            this.mMediaSourceUrl = str;
            this.mNetVideoUrl = str2;
            this.mVideoReadyRate = i;
            this.mContext = context;
            this.mOutterVFListener = videoPlayerStatusListener;
            this.mLoadingView = new WeakReference<>(view);
            this.exoPlayer = i.a(new f(context), new c(), new d());
            this.mediaSource = new o.c(new com.anythink.expressad.exoplayer.j.o(context, "AnyThink_ExoPlayer")).b(Uri.parse(str));
            this.exoPlayer.a(0);
            this.exoPlayer.a(this.mediaSource);
            this.exoPlayer.a(this);
            return true;
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
            return false;
        }
    }

    public boolean isComplete() {
        return this.mIsComplete;
    }

    public boolean isPlayIng() {
        try {
            if (this.exoPlayer != null) {
                return exoPlayerIsPlaying();
            }
            return false;
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
            return false;
        }
    }

    public boolean isSilent() {
        return this.mIsSilent;
    }

    public void justSeekTo(int i) {
        try {
            this.mCurrentPosition = i;
            if (this.mHasPrepare) {
                return;
            }
            com.anythink.expressad.foundation.h.o.a(TAG, "seekTo return mHasPrepare false");
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void onBufferingUpdate(int i) {
    }

    public void onCompletion() {
        try {
            this.mIsComplete = true;
            this.mIsPlaying = false;
            this.mCurrentPosition = 0L;
            hideLoading();
            postOnPlayCompletedOnMainThread();
            com.anythink.expressad.foundation.h.o.b(TAG, "======onCompletion");
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public boolean onError(int i, String str) {
        try {
            com.anythink.expressad.foundation.h.o.d(TAG, "onError what: " + i + " extra: " + str);
            hideLoading();
            if (!this.mIsFrontDesk && "MIX 3".equalsIgnoreCase(com.anythink.core.common.k.d.a()) && com.anythink.core.common.k.d.b().equalsIgnoreCase("Xiaomi")) {
                return true;
            }
            this.mHasPrepare = false;
            postOnPlayErrorOnMainThread(str);
            return true;
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
            return true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPlaybackParametersChanged(v vVar) {
        com.anythink.expressad.foundation.h.o.d(TAG, "onPlaybackParametersChanged : " + vVar.b);
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPlayerError(g gVar) {
        boolean z;
        String str;
        String str2 = "Play error and ExoPlayer have not message.";
        if (gVar != null) {
            int i = gVar.d;
            boolean z2 = true;
            if (i != 0) {
                if (i == 1) {
                    str2 = "Play error, because have a RendererException.";
                } else if (i == 2) {
                    str2 = "Play error, because have a UnexpectedException.";
                }
                z2 = false;
                str = str2;
            } else {
                str = "Play error, because have a SourceException.";
            }
            str2 = str;
            z = z2;
            if (gVar.getCause() != null) {
                str2 = str;
                z = z2;
                if (!TextUtils.isEmpty(gVar.getCause().getMessage())) {
                    str2 = gVar.getCause().getMessage();
                    z = z2;
                }
            }
        } else {
            z = false;
        }
        com.anythink.expressad.foundation.h.o.d(TAG, "onPlayerError : ".concat(String.valueOf(str2)));
        if (this.needPrepareVideoPlayAgain && z) {
            this.needPrepareVideoPlayAgain = false;
            rePrepareVideoSourceAgain();
            return;
        }
        long j = 0;
        try {
            j = this.exoPlayer.t();
        } catch (Throwable th) {
        }
        int i2 = gVar.d;
        onError(i2, str2 + "," + ("videoUrl" + this.mNetVideoUrl + ",readyRate:" + this.mVideoReadyRate + ",cdRate:0,play process:" + j));
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPlayerStateChanged(boolean z, int i) {
        com.anythink.expressad.foundation.h.o.d(TAG, "onPlaybackStateChanged : ".concat(String.valueOf(i)));
        if (i == 1) {
            com.anythink.expressad.foundation.h.o.d(TAG, "onPlaybackStateChanged : IDLE");
        } else if (i == 2) {
            com.anythink.expressad.foundation.h.o.d(TAG, "onPlaybackStateChanged : Buffering");
            this.mIsBuffering = true;
            showLoading();
            startBufferIngTimer("play buffering tiemout");
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            com.anythink.expressad.foundation.h.o.d(TAG, "onPlaybackStateChanged : Ended : PLAY ENDED");
            cancelPlayProgressTimer();
            onCompletion();
        } else {
            com.anythink.expressad.foundation.h.o.d(TAG, "onPlaybackStateChanged : READY");
            this.mIsBuffering = false;
            hideLoading();
            postOnBufferinEndOnMainThread();
            onPrepared();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPositionDiscontinuity(int i) {
    }

    public void onPrepared() {
        try {
            com.anythink.expressad.foundation.h.o.b(TAG, "onPrepared:" + this.mHasPrepare);
            this.mHasPrepare = true;
            if (!this.mIsFrontDesk && this.exoPlayer != null) {
                pause();
            }
            if (!this.mIsFrontDesk) {
                com.anythink.expressad.foundation.h.o.d(TAG, "At background, Do not process");
            } else if (this.mIsFrontDesk) {
                hideLoading();
                this.mHasPrepare = true;
                if (this.exoPlayer != null) {
                    this.mIsPlaying = true;
                    if (!this.isStart) {
                        postOnPlayStartOnMainThread(this.exoPlayer.s() / 1000);
                        com.anythink.expressad.foundation.h.o.b(TAG, "onPlayStarted()，getCurrentPosition:" + this.exoPlayer.t());
                        this.isStart = true;
                    }
                }
                postOnBufferinEndOnMainThread();
                startPlayProgressTimer();
                com.anythink.expressad.foundation.h.o.b(TAG, "onPrepare mCurrentPosition:" + this.mCurrentPosition + " onPrepare mHasPrepare：" + this.mHasPrepare);
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onSeekProcessed() {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onTimelineChanged(ae aeVar, Object obj, int i) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onTracksChanged(af afVar, com.anythink.expressad.exoplayer.i.g gVar) {
    }

    public void openSound() {
        try {
            if (this.exoPlayer == null) {
                return;
            }
            this.exoPlayer.a(1.0f);
            this.mIsSilent = false;
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void pause() {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && exoPlayerIsPlaying()) {
                com.anythink.expressad.foundation.h.o.b(TAG, "pause isPalying:" + exoPlayerIsPlaying() + " mIsPlaying:" + this.mIsPlaying);
                hideLoading();
                this.exoPlayer.a(false);
                this.mIsPlaying = false;
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void play() {
        this.exoPlayer.a(true);
    }

    public void play(String str, int i) {
        try {
            synchronized (this.mLock) {
                com.anythink.expressad.foundation.h.o.d(TAG, "Start Play currentionPosition:" + this.mCurrentPosition);
                if (i > 0) {
                    this.mCurrentPosition = i;
                }
                if (TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread("play url is null");
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                showLoading();
                setDataSource();
                com.anythink.expressad.foundation.h.o.b(TAG, "mPlayUrl:" + this.mPlayUrl);
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread("mediaplayer cannot play");
        }
    }

    public void play(String str, SurfaceHolder surfaceHolder) {
        try {
            synchronized (this.mLock) {
                if (TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread("play url is null");
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                this.mSurfaceHolder = surfaceHolder;
                showLoading();
                setDataSource();
                com.anythink.expressad.foundation.h.o.b(TAG, "mPlayUrl:" + this.mPlayUrl);
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread("mediaplayer cannot play");
        }
    }

    public void prepare() {
        try {
            if (this.mHasPrepare || this.exoPlayer == null) {
                return;
            }
            this.exoPlayer.a(this.mediaSource);
            this.mHasPrepare = true;
            this.mIsPlaying = false;
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void releasePlayer() {
        try {
            com.anythink.expressad.foundation.h.o.b(TAG, "release");
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.b(this);
                this.exoPlayer.n();
                this.mInnerVFPLisener = null;
                this.mOutterVFListener = null;
            }
            hideLoading();
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(TAG, th.getMessage());
        }
    }

    public void seekTo(int i) {
        long j = i;
        try {
            this.mCurrentPosition = j;
            if (!this.mHasPrepare) {
                com.anythink.expressad.foundation.h.o.a(TAG, "seekTo return mHasPrepare false");
            } else if (this.exoPlayer != null) {
                this.exoPlayer.a(j);
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void setDataSource() {
        try {
            com.anythink.expressad.foundation.h.o.b(TAG, "setDataSource");
            if (this.exoPlayer != null) {
                if (this.mSurfaceHolder != null) {
                    setDisplay(this.mSurfaceHolder);
                }
                boolean z = false;
                this.mHasPrepare = false;
                if (!TextUtils.equals(this.mMediaSourceUrl, this.mNetVideoUrl)) {
                    try {
                        z = new File(this.mMediaSourceUrl).exists();
                    } catch (Throwable th) {
                    }
                    if (!z) {
                        this.mediaSource = new o.c(new com.anythink.expressad.exoplayer.j.o(this.mContext, "AnyThink_ExoPlayer")).b(Uri.parse(this.mNetVideoUrl));
                        this.mMediaSourceUrl = this.mNetVideoUrl;
                    }
                }
                if (TextUtils.equals(this.mMediaSourceUrl, this.mNetVideoUrl) && this.mVideoReadyRate > 0) {
                    com.anythink.core.common.j.c.a("Video Play Fail：Play Network Url", "AdxExpress videoUrl:" + this.mPlayUrl + ",readyRate:" + this.mVideoReadyRate + ",maxVideoCacheSize:" + j.a().c() + ",lastRecycleCheckDownloadedFileSize:" + j.a().d(), n.a().r());
                }
                com.anythink.expressad.foundation.h.o.b(TAG, "Real Play Url:" + this.mMediaSourceUrl);
                this.exoPlayer.a(this.mediaSource);
                this.exoPlayer.a(true);
                startBufferIngTimer(PlayerErrorConstant.PREPARE_TIMEOUT);
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
            postOnPlaySetDataSourceError2MainThread(PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            this.exoPlayer.a(surfaceHolder);
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
        }
    }

    public void setFullScreenLoadingView(View view) {
        if (view != null) {
            try {
                this.mFullScreenLoadingView = view;
            } catch (Exception e) {
                com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
            }
        }
    }

    public void setIsComplete(boolean z) {
        this.mIsComplete = z;
    }

    public void setIsFrontDesk(boolean z) {
        try {
            this.mIsFrontDesk = z;
            StringBuilder sb = new StringBuilder("isFrontDesk: ");
            sb.append(z ? "frontStage" : "backStage");
            com.anythink.expressad.foundation.h.o.d(TAG, sb.toString());
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void setPlaybackParams(float f) {
        try {
            if (exoPlayerIsPlaying()) {
                this.exoPlayer.a(new v(f));
                return;
            }
            this.exoPlayer.a(new v(f));
            this.exoPlayer.m();
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(TAG, th.getMessage());
        }
    }

    public void setSelfVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void setVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public void setVolume(float f, float f2) {
        try {
            if (this.exoPlayer != null) {
                this.exoPlayer.a(f2);
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(TAG, th.getMessage());
        }
    }

    public void showLoading() {
        try {
            if (this.mHandler == null) {
                return;
            }
            this.mHandler.post(new Runnable() { // from class: com.anythink.expressad.playercommon.VideoFeedsPlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                        VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(0);
                    }
                }
            });
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void start(int i) {
        try {
            if (!this.mHasPrepare || this.exoPlayer == null || exoPlayerIsPlaying()) {
                return;
            }
            if (i > 0) {
                this.exoPlayer.a(i);
                play();
                return;
            }
            play();
            this.mIsPlaying = true;
            com.anythink.expressad.foundation.h.o.b(TAG, "=========start 指定进度");
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void start(boolean z) {
        try {
            if (!this.mHasPrepare) {
                com.anythink.expressad.foundation.h.o.b(TAG, "!mHasPrepare");
            } else if (this.exoPlayer == null || exoPlayerIsPlaying()) {
            } else {
                showLoading();
                play();
                this.mIsPlaying = true;
                if (z) {
                    startPlayProgressTimer();
                }
                com.anythink.expressad.foundation.h.o.b(TAG, "start");
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }

    public void stop() {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && exoPlayerIsPlaying()) {
                hideLoading();
                this.exoPlayer.m();
                this.mHasPrepare = false;
                this.mIsPlaying = false;
                this.mIsComplete = true;
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(TAG, e.getMessage());
        }
    }
}
