package com.blued.android.module.player.live.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.player.txplayer.view.BlLiveView;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager.class */
public class BaseLiveMediaPlayerManager extends AbsLiveManager {
    private static String h = "BaseLiveMediaPlayerManager";
    protected TXLivePlayer b;
    protected TXLivePlayConfig d;
    protected String e;
    protected TXCloudVideoView f;

    /* renamed from: c  reason: collision with root package name */
    protected int f15627c = 1;
    protected ITXLivePlayListener g = new ITXLivePlayListener() { // from class: com.blued.android.module.player.live.manager.BaseLiveMediaPlayerManager.1
        @Override // com.tencent.rtmp.ITXLivePlayListener
        public void onNetStatus(Bundle bundle) {
        }

        @Override // com.tencent.rtmp.ITXLivePlayListener
        public void onPlayEvent(int i, Bundle bundle) {
            Log.b(BaseLiveMediaPlayerManager.h, "receive event: " + i + ", " + bundle.getString("EVT_MSG"));
            if (i != -2301) {
                if (i != 2009) {
                    if (i == 2013) {
                        Log.c(BaseLiveMediaPlayerManager.h, "PLAY_EVT_VOD_PLAY_PREPARED resumeLive");
                        if (BaseLiveMediaPlayerManager.this.b != null) {
                            BaseLiveMediaPlayerManager.this.b.resumeLive();
                        }
                    } else if (i == 2003) {
                        Log.b(BaseLiveMediaPlayerManager.h, "PLAY_EVT_RCV_FIRST_I_FRAME");
                        if (BaseLiveMediaPlayerManager.this.f15626a != null) {
                            BaseLiveMediaPlayerManager.this.f15626a.c();
                        }
                    } else if (i != 2004) {
                        if (i != 2006) {
                            if (i == 2007 && BaseLiveMediaPlayerManager.this.f15626a != null) {
                                BaseLiveMediaPlayerManager.this.f15626a.a();
                            }
                        }
                    } else if (BaseLiveMediaPlayerManager.this.f15626a != null) {
                        BaseLiveMediaPlayerManager.this.f15626a.b();
                    }
                } else if (BaseLiveMediaPlayerManager.this.f15626a != null) {
                    int i2 = bundle.getInt("EVT_PARAM1");
                    int i3 = bundle.getInt("EVT_PARAM2");
                    BaseLiveMediaPlayerManager.this.f15626a.a(i2, i3);
                    String str = BaseLiveMediaPlayerManager.h;
                    Log.c(str, "PLAY_EVT_CHANGE_RESOLUTION, sizechange, width =" + i2 + "height=" + i3);
                }
                if (i < 0 || BaseLiveMediaPlayerManager.this.f15626a == null) {
                }
                BaseLiveMediaPlayerManager.this.f15626a.d();
                return;
            }
            Log.c(BaseLiveMediaPlayerManager.h, "onCompletion");
            if (BaseLiveMediaPlayerManager.this.f15626a != null) {
                BaseLiveMediaPlayerManager.this.f15626a.e();
            }
            if (i < 0) {
            }
        }
    };

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public /* bridge */ /* synthetic */ void a(OnMediaPlayerListener onMediaPlayerListener) {
        super.a(onMediaPlayerListener);
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void a(String str, BlLiveView blLiveView) throws Exception {
        TXCloudVideoView tXCloudVideoView;
        String str2 = h;
        Log.c(str2, "prepare videoPath = " + str);
        if (TextUtils.isEmpty(str)) {
            Log.c(h, "prepare videoPath empty");
        } else if (blLiveView == null) {
            Log.c(h, "surfaceView is null");
        } else {
            if (blLiveView.getChildAt(0) != null && (blLiveView.getChildAt(0) instanceof TXCloudVideoView)) {
                this.f = (TXCloudVideoView) blLiveView.getChildAt(0);
            }
            this.e = str;
            TXLivePlayer tXLivePlayer = this.b;
            if (tXLivePlayer != null && (tXCloudVideoView = this.f) != null) {
                tXLivePlayer.setPlayerView(tXCloudVideoView);
                String str3 = h;
                Log.c(str3, "prepare mMediaPlayer.setPlayerView(mBLliveView) return" + this.f.getWidth() + "," + this.f.getHeight());
                return;
            }
            if (this.b == null) {
                this.b = new TXLivePlayer(AppInfo.d());
                TXLivePlayConfig tXLivePlayConfig = new TXLivePlayConfig();
                this.d = tXLivePlayConfig;
                tXLivePlayConfig.setAutoAdjustCacheTime(false);
                this.d.setCacheTime(3.0f);
                this.d.setConnectRetryCount(10);
                this.b.setConfig(this.d);
                this.b.enableHardwareDecode(false);
            }
            this.b.setPlayerView(this.f);
            if (a(this.e)) {
                this.b.startPlay(this.e, this.f15627c);
                this.b.setPlayListener(this.g);
            }
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public boolean a() {
        return this.b != null;
    }

    protected boolean a(String str) {
        if (TextUtils.isEmpty(str) || !(str.startsWith("http://") || str.startsWith("https://") || str.startsWith("rtmp://") || str.startsWith(BridgeUtil.SPLIT_MARK))) {
            Log.c(h, "url is invalid");
            return false;
        } else if (str.startsWith("rtmp://")) {
            this.f15627c = 0;
            return true;
        } else if ((str.startsWith("http://") || str.startsWith("https://")) && str.contains(".flv")) {
            this.f15627c = 1;
            return true;
        } else {
            Log.c(h, "url is invalid");
            return false;
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void b() {
        TXLivePlayer tXLivePlayer = this.b;
        if (tXLivePlayer == null || this.f == null) {
            return;
        }
        try {
            tXLivePlayer.stopPlay(false);
            this.b.setPlayerView(this.f);
            if (a(this.e)) {
                this.b.startPlay(this.e, this.f15627c);
                this.b.setPlayListener(this.g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void c() {
        TXLivePlayer tXLivePlayer = this.b;
        if (tXLivePlayer != null) {
            tXLivePlayer.resume();
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void d() {
        TXLivePlayer tXLivePlayer = this.b;
        if (tXLivePlayer != null) {
            tXLivePlayer.pause();
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void e() {
        TXLivePlayer tXLivePlayer = this.b;
        if (tXLivePlayer != null) {
            tXLivePlayer.setMute(false);
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void f() {
        TXLivePlayer tXLivePlayer = this.b;
        if (tXLivePlayer != null) {
            tXLivePlayer.setMute(true);
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void g() {
        TXCloudVideoView tXCloudVideoView = this.f;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.onDestroy();
            this.f = null;
        }
        Log.c(h, "releaseWithoutStop");
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void h() {
        TXCloudVideoView tXCloudVideoView = this.f;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.onDestroy();
            this.f = null;
        }
        TXLivePlayer tXLivePlayer = this.b;
        if (tXLivePlayer != null) {
            tXLivePlayer.setPlayListener(null);
            this.b.stopPlay(true);
        }
        this.f15626a = null;
        this.b = null;
        Log.c(h, "release");
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void i() {
        if (this.b != null) {
            Log.c(h, "setMediaEmpty");
            this.b.pause();
            this.b.setPlayListener(null);
            this.b.stopPlay(true);
            this.b = null;
        }
        TXCloudVideoView tXCloudVideoView = this.f;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.onDestroy();
            this.f = null;
        }
        Log.c(h, "setMediaEmpty");
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void j() {
    }
}
