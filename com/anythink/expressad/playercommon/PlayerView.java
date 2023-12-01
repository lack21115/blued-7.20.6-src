package com.anythink.expressad.playercommon;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.anythink.expressad.foundation.f.b;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/playercommon/PlayerView.class */
public class PlayerView extends LinearLayout {
    public static final String TAG = "PlayerView";
    private boolean isBTVideo;
    private boolean isBTVideoPlaying;
    private boolean mInitState;
    private boolean mIsCovered;
    private boolean mIsFirstCreateHolder;
    private boolean mIsNeedToRepeatPrepare;
    private boolean mIsSurfaceHolderDestoryed;
    private LinearLayout mLlSurContainer;
    private LinearLayout mLoadingView;
    private String mPlayUrl;
    private SurfaceHolder mSurfaceHolder;
    private VideoFeedsPlayer mVideoFeedsPlayer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/playercommon/PlayerView$MySurfaceHoldeCallback.class */
    public class MySurfaceHoldeCallback implements SurfaceHolder.Callback {
        private MySurfaceHoldeCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            try {
                o.b(PlayerView.TAG, "surfaceChanged");
                if (PlayerView.this.mIsSurfaceHolderDestoryed && !PlayerView.this.mIsCovered && !PlayerView.this.isComplete() && !b.f7818c) {
                    if (PlayerView.this.isBTVideo) {
                        if (PlayerView.this.isBTVideoPlaying) {
                            if (!PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                                PlayerView.this.mVideoFeedsPlayer.prepare();
                            }
                            PlayerView.this.mVideoFeedsPlayer.start(false);
                        } else {
                            PlayerView.this.pause();
                        }
                    } else if (PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                        o.b(PlayerView.TAG, "surfaceChanged  start====");
                        PlayerView.this.resumeStart();
                    } else {
                        o.b(PlayerView.TAG, "surfaceChanged  PLAY====");
                        PlayerView.this.playVideo(0);
                    }
                }
                PlayerView.this.mIsSurfaceHolderDestoryed = false;
            } catch (Exception e) {
                o.d(PlayerView.TAG, e.getMessage());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            try {
                o.b(PlayerView.TAG, "surfaceCreated");
                if (PlayerView.this.mVideoFeedsPlayer != null && surfaceHolder != null) {
                    PlayerView.this.mSurfaceHolder = surfaceHolder;
                    PlayerView.this.mVideoFeedsPlayer.setDisplay(surfaceHolder);
                }
                PlayerView.this.mIsFirstCreateHolder = false;
            } catch (Exception e) {
                o.d(PlayerView.TAG, e.getMessage());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            try {
                o.b(PlayerView.TAG, "surfaceDestroyed ");
                PlayerView.this.mIsSurfaceHolderDestoryed = true;
                PlayerView.this.mIsNeedToRepeatPrepare = true;
                PlayerView.this.mVideoFeedsPlayer.pause();
            } catch (Exception e) {
                o.d(PlayerView.TAG, e.getMessage());
            }
        }
    }

    public PlayerView(Context context) {
        super(context);
        this.mInitState = false;
        this.mIsFirstCreateHolder = true;
        this.mIsSurfaceHolderDestoryed = false;
        this.mIsCovered = false;
        this.mIsNeedToRepeatPrepare = false;
        this.isBTVideo = false;
        this.isBTVideoPlaying = false;
        init();
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInitState = false;
        this.mIsFirstCreateHolder = true;
        this.mIsSurfaceHolderDestoryed = false;
        this.mIsCovered = false;
        this.mIsNeedToRepeatPrepare = false;
        this.isBTVideo = false;
        this.isBTVideoPlaying = false;
        init();
    }

    private void init() {
        try {
            initView();
            initPlayer();
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    private void initPlayer() {
        this.mVideoFeedsPlayer = new VideoFeedsPlayer();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(i.a(getContext(), "anythink_playercommon_player_view", "layout"), (ViewGroup) null);
        if (inflate != null) {
            this.mLlSurContainer = (LinearLayout) inflate.findViewById(i.a(getContext(), "anythink_playercommon_ll_sur_container", "id"));
            this.mLoadingView = (LinearLayout) inflate.findViewById(i.a(getContext(), "anythink_playercommon_ll_loading", "id"));
            addSurfaceView();
            addView(inflate, -1, -1);
        }
    }

    public void addSurfaceView() {
        try {
            o.b(TAG, "addSurfaceView");
            SurfaceView surfaceView = new SurfaceView(getContext().getApplicationContext());
            SurfaceHolder holder = surfaceView.getHolder();
            this.mSurfaceHolder = holder;
            holder.setType(3);
            this.mSurfaceHolder.setKeepScreenOn(true);
            this.mSurfaceHolder.addCallback(new MySurfaceHoldeCallback());
            this.mLlSurContainer.addView(surfaceView, -1, -1);
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void closeSound() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.closeSound();
        }
    }

    public void coverUnlockResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            if (this.mVideoFeedsPlayer != null) {
                o.b(TAG, "coverUnlockResume========");
                if (this.mVideoFeedsPlayer.hasPrepare() && !this.mIsNeedToRepeatPrepare) {
                    start(true);
                    return;
                }
                playVideo(0);
            }
        } catch (Throwable th) {
            o.d(TAG, th.getMessage());
        }
    }

    public int getCurPosition() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                return this.mVideoFeedsPlayer.getCurPosition();
            }
            return 0;
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
            return 0;
        }
    }

    public int getDuration() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            return videoFeedsPlayer.getDuration();
        }
        return 0;
    }

    public void initBufferIngParam(int i) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.initBufferIngParam(i);
        }
    }

    public boolean initVFPData(String str, String str2, int i, VideoPlayerStatusListener videoPlayerStatusListener) {
        if (TextUtils.isEmpty(str)) {
            o.b(TAG, "playUrl==null");
            return false;
        }
        this.mPlayUrl = str;
        this.mVideoFeedsPlayer.initPlayer(getContext(), this.mLoadingView, str, str2, i, videoPlayerStatusListener);
        this.mInitState = true;
        return true;
    }

    public boolean isComplete() {
        boolean z = false;
        try {
            if (this.mVideoFeedsPlayer != null) {
                z = false;
                if (this.mVideoFeedsPlayer.isComplete()) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
            return false;
        }
    }

    public boolean isPlayIng() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                return this.mVideoFeedsPlayer.isPlayIng();
            }
            return false;
        } catch (Throwable th) {
            o.d(TAG, th.getMessage());
            return false;
        }
    }

    public boolean isSilent() {
        return this.mVideoFeedsPlayer.isSilent();
    }

    public void justSeekTo(int i) {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.justSeekTo(i);
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void onPause() {
        try {
            pause();
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.setIsFrontDesk(false);
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void onResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            if (this.mVideoFeedsPlayer == null || this.mIsSurfaceHolderDestoryed || isComplete() || this.mIsCovered) {
                return;
            }
            o.b(TAG, "onresume========");
            if (this.mVideoFeedsPlayer.hasPrepare()) {
                resumeStart();
            } else {
                playVideo(0);
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void openSound() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.openSound();
        }
    }

    public void pause() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.pause();
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public boolean playVideo() {
        return playVideo(0);
    }

    public boolean playVideo(int i) {
        try {
            if (this.mVideoFeedsPlayer == null) {
                o.b(TAG, "player init error 播放失败");
                return false;
            } else if (!this.mInitState) {
                o.b(TAG, "vfp init failed 播放失败");
                return false;
            } else {
                this.mVideoFeedsPlayer.play(this.mPlayUrl, i);
                this.mIsNeedToRepeatPrepare = false;
                return true;
            }
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
            return false;
        }
    }

    public void prepare() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.prepare();
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void release() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.releasePlayer();
            }
            if (this.mSurfaceHolder != null) {
                o.d(TAG, "mSurfaceHolder release");
                this.mSurfaceHolder.getSurface().release();
            }
        } catch (Throwable th) {
            o.d(TAG, th.getMessage());
        }
    }

    public void removeSurface() {
        try {
            o.b(TAG, "removeSurface");
            this.mLlSurContainer.removeAllViews();
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void resumeStart() {
        try {
            start(true);
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void seekTo(int i) {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.seekTo(i);
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void setDataSource() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.showLoading();
                this.mVideoFeedsPlayer.setDataSource();
                this.mIsNeedToRepeatPrepare = false;
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void setDesk(boolean z) {
        this.mVideoFeedsPlayer.setIsFrontDesk(z);
    }

    public void setIsBTVideo(boolean z) {
        this.isBTVideo = z;
    }

    public void setIsBTVideoPlaying(boolean z) {
        this.isBTVideoPlaying = z;
    }

    public void setIsCovered(boolean z) {
        try {
            this.mIsCovered = z;
            o.d(TAG, "mIsCovered:".concat(String.valueOf(z)));
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void setPlaybackParams(float f) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setPlaybackParams(f);
        }
    }

    public void setVolume(float f, float f2) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setVolume(f, f2);
        }
    }

    public void start(int i) {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.start(i);
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void start(boolean z) {
        try {
            if (this.mVideoFeedsPlayer == null || this.mIsCovered) {
                return;
            }
            this.mVideoFeedsPlayer.start(z);
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void stop() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.stop();
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }
}
