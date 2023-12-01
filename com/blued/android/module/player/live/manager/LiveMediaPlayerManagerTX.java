package com.blued.android.module.player.live.manager;

import android.graphics.Bitmap;
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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX.class */
public class LiveMediaPlayerManagerTX extends AbsLiveManager {
    private static String b = "LiveMediaPlayerManagerTX";

    /* renamed from: c  reason: collision with root package name */
    private static int f15630c = 10;
    private static String d = "rtmp://";
    private static String e = "http://";
    private static String f = "https://";
    private static String g = ".flv";
    private String i;
    private TXLivePlayer j;
    private TXLivePlayConfig k;
    private TXCloudVideoView l;
    private int h = 1;
    private ITXLivePlayListener m = new ITXLivePlayListener() { // from class: com.blued.android.module.player.live.manager.LiveMediaPlayerManagerTX.2
        @Override // com.tencent.rtmp.ITXLivePlayListener
        public void onNetStatus(Bundle bundle) {
        }

        @Override // com.tencent.rtmp.ITXLivePlayListener
        public void onPlayEvent(int i, Bundle bundle) {
            Log.b(LiveMediaPlayerManagerTX.b, "receive event: " + i + ", " + bundle.getString("EVT_MSG"));
            if (i != -2301) {
                if (i != 2009) {
                    if (i != 2013) {
                        if (i == 2003) {
                            Log.b(LiveMediaPlayerManagerTX.b, "PLAY_EVT_RCV_FIRST_I_FRAME");
                            if (LiveMediaPlayerManagerTX.this.f15626a != null) {
                                LiveMediaPlayerManagerTX.this.f15626a.c();
                            }
                        } else if (i != 2004) {
                            if (i != 2006) {
                                if (i == 2007) {
                                    Log.c(LiveMediaPlayerManagerTX.b, "onMediaBufferStart");
                                    if (LiveMediaPlayerManagerTX.this.f15626a != null) {
                                        LiveMediaPlayerManagerTX.this.f15626a.a();
                                    }
                                }
                            }
                        } else if (LiveMediaPlayerManagerTX.this.f15626a != null) {
                            LiveMediaPlayerManagerTX.this.f15626a.b();
                        }
                    } else if (LiveMediaPlayerManagerTX.this.j != null) {
                        LiveMediaPlayerManagerTX.this.j.resumeLive();
                    }
                } else if (LiveMediaPlayerManagerTX.this.f15626a != null) {
                    LiveMediaPlayerManagerTX.this.f15626a.a(bundle.getInt("EVT_PARAM1"), bundle.getInt("EVT_PARAM2"));
                }
                if (i < 0 || LiveMediaPlayerManagerTX.this.f15626a == null) {
                }
                LiveMediaPlayerManagerTX.this.f15626a.d();
                return;
            }
            Log.c(LiveMediaPlayerManagerTX.b, "onCompletion");
            if (LiveMediaPlayerManagerTX.this.f15626a != null) {
                LiveMediaPlayerManagerTX.this.f15626a.e();
            }
            if (i < 0) {
            }
        }
    };

    /* renamed from: com.blued.android.module.player.live.manager.LiveMediaPlayerManagerTX$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX$1.class */
    class AnonymousClass1 implements TXLivePlayer.ITXSnapshotListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveMediaPlayerManagerTX f15631a;

        @Override // com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener
        public void onSnapshot(Bitmap bitmap) {
            if (this.f15631a.f15626a != null) {
                this.f15631a.f15626a.a(bitmap);
            }
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str) || !(str.startsWith("http://") || str.startsWith(f) || str.startsWith(d) || str.startsWith(BridgeUtil.SPLIT_MARK))) {
            Log.c(b, "url is invalide");
            return false;
        } else if (str.startsWith(d)) {
            this.h = 0;
            return true;
        } else if ((str.startsWith(e) || str.startsWith(f)) && str.contains(g)) {
            this.h = 1;
            return true;
        } else {
            Log.c(b, "url is invalide");
            return false;
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public /* bridge */ /* synthetic */ void a(OnMediaPlayerListener onMediaPlayerListener) {
        super.a(onMediaPlayerListener);
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void a(String str, BlLiveView blLiveView) throws Exception {
        String str2 = b;
        Log.c(str2, "prepare videoPath = " + str);
        if (TextUtils.isEmpty(str)) {
            Log.c(b, "prepare videoPath empty");
        } else if (blLiveView == null) {
            Log.c(b, "surfaceView is null");
        } else {
            this.i = str;
            if (blLiveView.getChildAt(0) != null && (blLiveView.getChildAt(0) instanceof TXCloudVideoView)) {
                this.l = (TXCloudVideoView) blLiveView.getChildAt(0);
            }
            if (this.l == null) {
                Log.c(b, "TXCloudVideoView is null");
                return;
            }
            if (this.j == null) {
                this.j = new TXLivePlayer(AppInfo.d());
                TXLivePlayConfig tXLivePlayConfig = new TXLivePlayConfig();
                this.k = tXLivePlayConfig;
                tXLivePlayConfig.setConnectRetryCount(f15630c);
                this.j.setConfig(this.k);
                this.j.enableHardwareDecode(false);
            }
            this.j.setPlayerView(this.l);
            if (a(this.i)) {
                this.j.startPlay(this.i, this.h);
                this.j.setPlayListener(this.m);
            }
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public boolean a() {
        TXLivePlayer tXLivePlayer = this.j;
        return tXLivePlayer != null && tXLivePlayer.isPlaying();
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void b() {
        TXLivePlayer tXLivePlayer = this.j;
        if (tXLivePlayer == null || this.l == null) {
            Log.d(b, "can not reconnect, mPlayer or mVideoView is null.");
            return;
        }
        try {
            tXLivePlayer.stopPlay(false);
            this.j.setPlayerView(this.l);
            if (a(this.i)) {
                this.j.startPlay(this.i, this.h);
                this.j.setPlayListener(this.m);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void c() {
        TXLivePlayer tXLivePlayer = this.j;
        if (tXLivePlayer != null) {
            tXLivePlayer.resume();
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void d() {
        TXLivePlayer tXLivePlayer = this.j;
        if (tXLivePlayer != null) {
            tXLivePlayer.pause();
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void e() {
        TXLivePlayer tXLivePlayer = this.j;
        if (tXLivePlayer != null) {
            tXLivePlayer.setMute(false);
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void f() {
        TXLivePlayer tXLivePlayer = this.j;
        if (tXLivePlayer != null) {
            tXLivePlayer.setMute(true);
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void g() {
        if (this.j != null) {
            Log.b(b, "releaseWithoutStop");
            this.j.setPlayerView(null);
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void h() {
        Log.b(b, "release");
        TXLivePlayer tXLivePlayer = this.j;
        if (tXLivePlayer != null) {
            tXLivePlayer.setPlayListener(null);
            this.j.stopPlay(true);
        }
        this.f15626a = null;
        this.j = null;
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void i() {
        if (this.j != null) {
            Log.c(b, "setMediaEmpty");
            this.j.pause();
            this.j.setPlayListener(null);
            this.j.stopPlay(true);
            this.j = null;
        }
    }

    @Override // com.blued.android.module.player.live.manager.AbsLiveManager
    public void j() {
    }
}
