package com.blued.android.module.player.txplayer.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.module.player.Config;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;
import com.blued.android.module.player.media.view.AbBaseVideoView;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.File;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/txplayer/view/BLTxPlayView.class */
public class BLTxPlayView extends AbBaseVideoView implements ITXVodPlayListener {
    private TXCloudVideoView g;
    private TXVodPlayer h;
    private TXVodPlayConfig i;
    private Context j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private PlayerState o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/txplayer/view/BLTxPlayView$PlayerState.class */
    public enum PlayerState {
        IDLE,
        PREPARED,
        PLAYING,
        PAUSED,
        STOPPED
    }

    public BLTxPlayView(Context context) {
        this(context, null);
    }

    public BLTxPlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BLTxPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 0;
        this.n = 0;
        this.o = PlayerState.IDLE;
        h();
    }

    private void h() {
        this.j = AppInfo.d();
        if (TextUtils.isEmpty(this.b)) {
            File externalCacheDir = this.j.getExternalCacheDir();
            if (externalCacheDir == null || !externalCacheDir.exists()) {
                this.b = Config.b;
            } else {
                this.b = externalCacheDir.getAbsolutePath() + "/TX/PLDroidPlayer";
            }
        }
        Utils.b(this.b);
        Log.c("BLTxPlayView", "init " + this);
        i();
    }

    private void i() {
        this.g = new TXCloudVideoView(this.j);
        this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Log.b("BLTxPlayView", "init mPlayerView");
        addView(this.g);
    }

    private void j() {
        if (this.h == null) {
            TXVodPlayer tXVodPlayer = new TXVodPlayer(this.j);
            this.h = tXVodPlayer;
            tXVodPlayer.setRequestAudioFocus(false);
            this.h.setLoop(true);
            this.h.setVodListener(this);
        }
        if (this.i == null) {
            this.i = new TXVodPlayConfig();
            Log.c("BLTxPlayView", "initPlayer: cache dir = " + this.b);
            this.i.setCacheFolderPath(this.b);
            this.i.setMaxCacheItems(30);
        }
        this.o = PlayerState.IDLE;
        this.h.setConfig(this.i);
        this.h.enableHardwareDecode(this.f15659c.v);
    }

    private boolean k() {
        return this.o == PlayerState.PAUSED;
    }

    private boolean l() {
        return (this.d == null || this.d.equals(getSetUrl())) ? false : true;
    }

    private void m() {
        if (this.h == null || this.f15659c == null) {
            Log.d("BLTxPlayView", "something is null, startTxPlayer discard");
            return;
        }
        String setUrl = getSetUrl();
        if (TextUtils.isEmpty(setUrl)) {
            Log.e("BLTxPlayView", "error, play url is empty");
            return;
        }
        Log.c("BLTxPlayView", "startTxPlayer: url = " + setUrl);
        int startPlay = this.h.startPlay(setUrl);
        this.d = setUrl;
        Log.c("BLTxPlayView", "startPlay result=" + startPlay);
    }

    private void n() {
        TXVodPlayer tXVodPlayer = this.h;
        if (tXVodPlayer != null) {
            tXVodPlayer.setVodListener(null);
            this.h.stopPlay(true);
            this.h = null;
            this.o = PlayerState.IDLE;
            Log.c("BLTxPlayView", "releasePlayer " + getPlayUrl());
        }
    }

    private void o() {
        TXCloudVideoView tXCloudVideoView = this.g;
        if (tXCloudVideoView != null) {
            removeView(tXCloudVideoView);
            this.g.onDestroy();
            this.g = null;
            Log.c("BLTxPlayView", "releaseRenderView: " + getPlayUrl());
        }
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void a() {
        synchronized (this) {
            Log.c("BLTxPlayView", "preloadVideo: url = " + getSetUrl() + ", " + this);
            this.l = false;
            if (this.h != null && this.h.isPlaying()) {
                if (!l()) {
                    Log.d("BLTxPlayView", "already start play, so discard preload.");
                    return;
                }
                f();
            }
            if (this.g == null) {
                i();
            }
            if (this.h == null) {
                j();
            }
            this.h.setAutoPlay(false);
            m();
        }
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void a(float f, float f2) {
        if (this.h == null) {
            Log.c("BLTxPlayView", "setVolume error, mPlayer is null");
            return;
        }
        super.a(f, f2);
        if (f == 0.0f || f2 == 0.0f) {
            this.h.setAudioPlayoutVolume(0);
            return;
        }
        this.h.setAudioPlayoutVolume(100);
        AudioManagerUtils.a().b();
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void a(long j) {
        TXVodPlayer tXVodPlayer = this.h;
        if (tXVodPlayer != null) {
            tXVodPlayer.seek((float) (j / 1000));
        }
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void a(VideoPlayConfig videoPlayConfig) {
        if (videoPlayConfig == null) {
            return;
        }
        super.a(videoPlayConfig);
        Log.b("BLTxPlayView", "loadVideoSource " + getSetUrl());
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void a(boolean z) {
        j();
        Log.b("BLTxPlayView", "initVideoViewOptions ");
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void b() {
        synchronized (this) {
            if (k()) {
                g();
                return;
            }
            Log.b("BLTxPlayView", "startPlay setPlayer() " + getSetUrl() + ", " + this);
            this.l = false;
            if (this.g == null) {
                Log.b("BLTxPlayView", "startPlay mVideoView = null");
                i();
            }
            if (this.h == null) {
                j();
            }
            if (this.f15659c.j) {
                a(1.0f, 1.0f);
            } else {
                a(0.0f, 0.0f);
            }
            this.h.setPlayerView(this.g);
            this.h.setAutoPlay(true);
            m();
        }
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void c() {
        f();
        n();
        o();
        if (this.e != null) {
            this.e = null;
        }
        Log.b("BLTxPlayView", "release url = " + getPlayUrl());
        super.c();
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void d() {
        this.l = true;
        if (e()) {
            Log.c("BLTxPlayView", "pause: " + getPlayUrl());
            this.o = PlayerState.PAUSED;
            this.h.pause();
        } else {
            Log.d("BLTxPlayView", "mPlayer == null, so discard pause");
        }
        AudioManagerUtils.a().a(false);
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public boolean e() {
        TXVodPlayer tXVodPlayer = this.h;
        if (tXVodPlayer != null) {
            return tXVodPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void f() {
        if (this.h != null) {
            Log.c("BLTxPlayView", "stop: " + getPlayUrl());
            this.o = PlayerState.STOPPED;
            this.h.stopPlay(true);
        }
    }

    public void g() {
        if (!k()) {
            b();
            return;
        }
        this.o = PlayerState.PLAYING;
        this.h.resume();
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public long getCurrentPosition() {
        TXVodPlayer tXVodPlayer = this.h;
        return tXVodPlayer != null ? tXVodPlayer.getCurrentPlaybackTime() * 1000 : super.getCurrentPosition();
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public long getDuration() {
        TXVodPlayer tXVodPlayer = this.h;
        return tXVodPlayer != null ? tXVodPlayer.getDuration() * 1000 : super.getDuration();
    }

    @Override // com.tencent.rtmp.ITXVodPlayListener
    public void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle) {
    }

    @Override // com.tencent.rtmp.ITXVodPlayListener
    public void onPlayEvent(TXVodPlayer tXVodPlayer, int i, Bundle bundle) {
        String str;
        if (i != 2005) {
            str = "TXVodPlayer onPlayEvent event: " + i + ", " + bundle.getString("EVT_MSG");
            Log.b("BLTxPlayView", str);
        } else {
            str = "";
        }
        if (i != 2003) {
            if (i == 2004) {
                this.o = PlayerState.PLAYING;
                if (this.e != null) {
                    this.e.d();
                }
            } else if (i != 2007) {
                if (i == 2009) {
                    this.m = bundle.getInt("EVT_PARAM1");
                    this.n = bundle.getInt("EVT_PARAM2");
                    int i2 = this.k;
                    boolean z = i2 == 90 || i2 == 270;
                    int i3 = z ? this.n : this.m;
                    int i4 = z ? this.m : this.n;
                    Log.b("BLTxPlayView", "width" + i3 + "height " + i4);
                    a(i3, i4, this);
                } else if (i == 2011) {
                    this.k = bundle.getInt("EVT_PARAM1");
                } else if (i == 2013) {
                    this.o = PlayerState.PREPARED;
                } else if (i == 2014 && this.e != null) {
                    this.e.c();
                }
            } else if (this.e != null) {
                this.e.a();
            }
        } else if (this.l && this.h != null) {
            this.l = false;
            this.o = PlayerState.PAUSED;
            this.h.pause();
            Log.c("BLTxPlayView", "paused by user request");
        }
        if (i < 0) {
            Log.e("BLTxPlayView", str);
            TXVodPlayer tXVodPlayer2 = this.h;
            if (tXVodPlayer2 != null) {
                tXVodPlayer2.stopPlay(false);
            }
            if (this.e != null) {
                this.e.b();
            }
        }
    }

    @Override // com.blued.android.module.player.media.view.AbBaseVideoView
    public void setMute(boolean z) {
        TXVodPlayer tXVodPlayer = this.h;
        if (tXVodPlayer != null) {
            tXVodPlayer.setMute(z);
        }
    }
}
