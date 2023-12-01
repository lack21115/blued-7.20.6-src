package com.blued.android.module.player.audio;

import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/audio/TXVodAudioPlayer.class */
public class TXVodAudioPlayer implements IAudioPlayer, ITXVodPlayListener {
    private static int a = 0;
    private static boolean b = true;
    private TXVodPlayer c;
    private TXVodPlayConfig d;
    private IAudioPlayer.OnPreparedListener e;
    private IAudioPlayer.OnCompletionListener f;
    private IAudioPlayer.OnErrorListener g;
    private String h;
    private long i;
    private boolean j;

    public TXVodAudioPlayer() {
        c();
    }

    private void c() {
        TXVodPlayer tXVodPlayer = new TXVodPlayer(AppInfo.d());
        this.c = tXVodPlayer;
        tXVodPlayer.setRequestAudioFocus(b);
        TXVodPlayConfig tXVodPlayConfig = new TXVodPlayConfig();
        this.d = tXVodPlayConfig;
        tXVodPlayConfig.setProgressInterval(1000);
        this.d.setMaxBufferSize(a);
        this.j = false;
    }

    private boolean d() {
        if (TextUtils.isEmpty(this.h)) {
            Log.d("TXVodAudioPlayer", "play url can not empty!");
            return false;
        }
        this.c.setVodListener(this);
        this.c.enableHardwareDecode(false);
        this.c.setConfig(this.d);
        this.c.setAutoPlay(true);
        if (this.c.startPlay(this.h) != 0) {
            return false;
        }
        this.i = System.currentTimeMillis();
        Log.c("TXVodAudioPlayer", "start play");
        return true;
    }

    private void e() {
        TXVodPlayer tXVodPlayer = this.c;
        if (tXVodPlayer != null) {
            tXVodPlayer.setVodListener((ITXVodPlayListener) null);
            this.c.stopPlay(true);
        }
        this.j = false;
    }

    private void f() {
        TXVodPlayer tXVodPlayer = this.c;
        if (tXVodPlayer == null || !this.j || tXVodPlayer.isPlaying()) {
            return;
        }
        this.c.resume();
    }

    @Override // com.blued.android.module.player.audio.IAudioPlayer
    public IAudioPlayer a() {
        Log.c("TXVodAudioPlayer", "start");
        if (this.j) {
            f();
            return this;
        }
        this.j = d();
        return this;
    }

    @Override // com.blued.android.module.player.audio.IAudioPlayer
    public IAudioPlayer a(String str) {
        this.h = str;
        return this;
    }

    @Override // com.blued.android.module.player.audio.IAudioPlayer
    public IAudioPlayer a(boolean z) {
        TXVodPlayer tXVodPlayer = this.c;
        if (tXVodPlayer != null) {
            tXVodPlayer.setLoop(z);
        }
        return this;
    }

    @Override // com.blued.android.module.player.audio.IAudioPlayer
    public void b() {
        Log.c("TXVodAudioPlayer", "stop");
        e();
    }

    public void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle) {
    }

    public void onPlayEvent(TXVodPlayer tXVodPlayer, int i, Bundle bundle) {
        IAudioPlayer.OnErrorListener onErrorListener;
        if (i == 2014) {
            Log.b("TXVodAudioPlayer", "PLAY_EVT_VOD_LOADING_END");
        }
        if (i == 2013) {
            IAudioPlayer.OnPreparedListener onPreparedListener = this.e;
            if (onPreparedListener != null) {
                onPreparedListener.a(null);
            }
            Log.c("TXVodAudioPlayer", "PLAY_EVT_VOD_PLAY_PREPARED");
        }
        if (i == 2004) {
            Log.c("TXVodAudioPlayer", "PLAY_EVT_PLAY_BEGIN, PlayFirstRender, cost=" + (System.currentTimeMillis() - this.i));
        } else if (i == 2005) {
            return;
        } else {
            if (i == -2301 || i == 2006 || i == -2303) {
                IAudioPlayer.OnCompletionListener onCompletionListener = this.f;
                if (onCompletionListener != null) {
                    onCompletionListener.a(null);
                }
                e();
            } else if (i == 2007) {
                Log.b("TXVodAudioPlayer", "PLAY_EVT_PLAY_LOADING");
            } else if (i == 2003) {
                Log.b("TXVodAudioPlayer", "PLAY_EVT_RCV_FIRST_I_FRAME");
            } else if (i == -2305) {
                e();
            } else if (i == 2103) {
                Log.c("TXVodAudioPlayer", "PLAY_WARNING_RECONNECT");
            } else if (i == 2011) {
                return;
            }
        }
        if (i >= 0 || (onErrorListener = this.g) == null) {
            return;
        }
        onErrorListener.a(null, i, 0);
    }
}
