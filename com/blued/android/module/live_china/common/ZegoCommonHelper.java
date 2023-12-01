package com.blued.android.module.live_china.common;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.ZipUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioAux;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioAuxCallbackEx;
import com.zego.zegoavkit2.ZegoMediaPlayer;
import com.zego.zegoavkit2.audioaux.ZegoAudioAux;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLogHookCallback;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import java.io.File;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/common/ZegoCommonHelper.class */
public class ZegoCommonHelper {
    public static String a = "BluedSolutionRoom_1";
    public static String b = "zego-joinlive-stream-anchor-1";
    public static String c = "zego-joinlive-stream-anchor-2";
    public static String d = "zego-joinlive-stream-anchor";
    public static String e = "zego-joinlive-stream-audience1";
    private static ZegoCommonHelper o;
    private static boolean t = false;
    public int j;
    public int k;
    private ZegoLiveRoom n = null;
    private ZegoMediaPlayer p = null;
    public String f = "";
    public String g = "";
    public int h = 544;
    public int i = 960;
    private int q = 0;
    public int l = 15;
    public int m = 368640;
    private ZegoAudioAux r = null;
    private ITXCMZegoAudioAux s = null;
    private InitProccessState u = InitProccessState.WaitInitState;
    private boolean v = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/common/ZegoCommonHelper$InitProccessState.class */
    public enum InitProccessState {
        WaitInitState,
        InitSuccessState,
        InitFailState
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/common/ZegoCommonHelper$OnZegoSdkInitEvent.class */
    public interface OnZegoSdkInitEvent {
    }

    public static void a() {
        try {
            b().a((String) null, (String) null, 10485760L, (Application) AppInfo.d());
            t = true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static ZegoCommonHelper b() {
        synchronized (ZegoCommonHelper.class) {
            try {
                if (o == null) {
                    o = new ZegoCommonHelper();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return o;
    }

    public void a(int i) {
        if (LiveRoomManager.a().p() != null) {
            this.q = LiveRoomManager.a().p().stream_level;
            Log.i("==record", "set level:" + this.q);
        }
        Log.i("==record", "state:" + i);
        Log.i("==record", "level:" + this.q);
        if (i == 0) {
            int i2 = this.q;
            if (i2 == 0) {
                this.j = 544;
                this.k = 960;
                this.l = 15;
                this.m = 1024000;
            } else if (i2 == 1) {
                this.j = 544;
                this.k = 960;
                this.l = 15;
                this.m = 1228800;
            } else if (i2 == 2) {
                this.j = 544;
                this.k = 960;
                this.l = 18;
                this.m = 1228800;
            } else if (i2 == 3) {
                this.j = 544;
                this.k = 960;
                this.l = 20;
                this.m = 1228800;
            } else if (i2 == 4) {
                this.j = 720;
                this.k = GL10.GL_INVALID_ENUM;
                this.l = 20;
                this.m = 1843200;
            }
            this.h = this.j;
            this.i = this.k;
        } else if (1 == i) {
            int i3 = this.q;
            if (i3 == 0) {
                this.j = 480;
                this.k = 848;
                this.l = 15;
                this.m = 819200;
            } else if (i3 == 1) {
                this.j = 480;
                this.k = 848;
                this.l = 15;
                this.m = 1024000;
            } else if (i3 == 2) {
                this.j = 480;
                this.k = 848;
                this.l = 15;
                this.m = 1024000;
            } else if (i3 == 3) {
                this.j = 480;
                this.k = 848;
                this.l = 20;
                this.m = 1024000;
            } else if (i3 == 4) {
                this.j = 480;
                this.k = 848;
                this.l = 20;
                this.m = 1024000;
            }
        } else if (2 == i || 3 == i || 4 == i) {
            int i4 = this.q;
            if (i4 == 0) {
                this.j = 240;
                this.k = 424;
                this.l = 15;
                this.m = 368640;
            } else if (i4 == 1) {
                this.j = 240;
                this.k = 424;
                this.l = 15;
                this.m = 409600;
            } else if (i4 == 2) {
                this.j = 240;
                this.k = 424;
                this.l = 18;
                this.m = 409600;
            } else if (i4 == 3) {
                this.j = 240;
                this.k = 424;
                this.l = 20;
                this.m = 409600;
            } else if (i4 == 4) {
                this.j = 240;
                this.k = 424;
                this.l = 20;
                this.m = 409600;
            }
        } else if (5 == i || 6 == i) {
            int i5 = this.q;
            if (i5 == 0) {
                this.j = 272;
                this.k = 240;
                this.l = 15;
                this.m = 368640;
            } else if (i5 == 1) {
                this.j = 272;
                this.k = 240;
                this.l = 15;
                this.m = 409600;
            } else if (i5 == 2) {
                this.j = 272;
                this.k = 240;
                this.l = 18;
                this.m = 460800;
            } else if (i5 == 3) {
                this.j = 272;
                this.k = 240;
                this.l = 20;
                this.m = 460800;
            } else if (i5 == 4) {
                this.j = 272;
                this.k = 240;
                this.l = 20;
                this.m = 460800;
            }
        } else if (8 == i || 9 == i) {
            int i6 = this.q;
            if (i6 == 0) {
                this.j = 240;
                this.k = 240;
                this.l = 15;
                this.m = 368640;
            } else if (i6 == 1) {
                this.j = 240;
                this.k = 240;
                this.l = 15;
                this.m = 409600;
            } else if (i6 == 2) {
                this.j = 240;
                this.k = 240;
                this.l = 18;
                this.m = 460800;
            } else if (i6 == 3) {
                this.j = 240;
                this.k = 240;
                this.l = 20;
                this.m = 460800;
            } else if (i6 == 4) {
                this.j = 240;
                this.k = 240;
                this.l = 20;
                this.m = 460800;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        Log.i("==record", "setZegoAvConfig:" + i + " height:" + i2 + " outputFps: " + i3 + " outputBitrate: " + (i4 / 1024));
        ZegoAvConfig zegoAvConfig = new ZegoAvConfig(2);
        zegoAvConfig.setVideoCaptureResolution(i, i2);
        zegoAvConfig.setVideoEncodeResolution(i, i2);
        zegoAvConfig.setVideoBitrate(i4);
        zegoAvConfig.setVideoFPS(i3);
        ZegoLiveRoom zegoLiveRoom = this.n;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setAVConfig(zegoAvConfig);
        }
    }

    public void a(ITXCMZegoAudioAux iTXCMZegoAudioAux) {
        this.s = iTXCMZegoAudioAux;
    }

    public void a(final String str, final String str2, final long j, final Application application) {
        ZegoLiveRoom.setSDKContext(new ZegoLiveRoom.SDKContextEx() { // from class: com.blued.android.module.live_china.common.ZegoCommonHelper.1
            public Application getAppContext() {
                return application;
            }

            public long getLogFileSize() {
                return j;
            }

            public IZegoLogHookCallback getLogHookCallback() {
                return null;
            }

            public String getLogPath() {
                return str;
            }

            public String getSoFullPath() {
                return str2;
            }

            public String getSubLogFolder() {
                return null;
            }
        });
    }

    public void a(boolean z) {
        this.v = z;
    }

    public boolean a(long j, byte[] bArr, boolean z, int i, final IZegoInitSDKCompletionCallback iZegoInitSDKCompletionCallback) {
        Log.d("==record", "initZegoSDK:" + t + "  testEnv:" + z + "  isDebuging:" + AppInfo.m());
        if (!t) {
            a();
        }
        c();
        b(i);
        if (this.u == InitProccessState.InitSuccessState) {
            Log.d("==record", "SDK已初始化, 无需重复初始化");
            return false;
        }
        ZegoLiveRoom.setTestEnv(z);
        ZegoLiveRoom.setBusinessType(0);
        Log.d("==record", "onInitSDK version:" + ZegoLiveRoom.version() + " version2:" + ZegoLiveRoom.version2());
        return this.n.initSDK(j, bArr, new IZegoInitSDKCompletionCallback() { // from class: com.blued.android.module.live_china.common.ZegoCommonHelper.2
            public void onInitSDK(int i2) {
                Log.d("==record", "onInitSDK:" + i2);
                if (i2 == 0) {
                    if (ZegoCommonHelper.this.n != null) {
                        ZegoCommonHelper.this.n.enableAEC(true);
                        ZegoCommonHelper.this.n.setAECMode(2);
                        ZegoCommonHelper.this.n.setLatencyMode(2);
                    }
                    ZegoCommonHelper.this.u = InitProccessState.InitSuccessState;
                } else {
                    ZegoCommonHelper.this.u = InitProccessState.InitFailState;
                    ZegoCommonHelper.this.i();
                }
                ZegoCommonHelper.this.f();
                IZegoInitSDKCompletionCallback iZegoInitSDKCompletionCallback2 = iZegoInitSDKCompletionCallback;
                if (iZegoInitSDKCompletionCallback2 != null) {
                    iZegoInitSDKCompletionCallback2.onInitSDK(i2);
                }
            }
        });
    }

    public void b(int i) {
        a(i);
        a(this.j, this.k, this.l, this.m);
    }

    public ZegoLiveRoom c() {
        if (this.n == null) {
            this.n = new ZegoLiveRoom();
        }
        return this.n;
    }

    public void c(int i) {
        a(i);
        int i2 = this.j;
        int i3 = this.k;
        this.j = i3;
        this.k = i2;
        a(i3, i2, this.l, this.m);
    }

    public void d() {
        ZegoLiveRoom.setUser(LiveRoomInfo.a().f(), LiveRoomInfo.a().c());
        ZegoLiveRoom.setConfig("play_clear_last_frame=true");
        ZegoLiveRoom.setConfig("room_retry_time=90");
        ZegoLiveRoom.setConfig("av_retry_time=90");
        ZegoLiveRoom.setAudioDeviceMode(6);
    }

    public ZegoMediaPlayer e() {
        if (this.p == null) {
            ZegoMediaPlayer zegoMediaPlayer = new ZegoMediaPlayer();
            this.p = zegoMediaPlayer;
            zegoMediaPlayer.init(1, 0);
            this.p.setProcessInterval(1000L);
        }
        return this.p;
    }

    public ZegoAudioAux f() {
        if (this.r == null) {
            this.r = new ZegoAudioAux();
        }
        return this.r;
    }

    public boolean g() {
        boolean z = false;
        if (LiveRoomManager.a().p() != null) {
            int i = LiveRoomManager.a().p().stream_level;
            Log.i("==record", "level:" + this.q + "  remoteLevel:" + i);
            z = false;
            if (this.q != i) {
                z = true;
            }
        }
        return z;
    }

    public void h() {
        ZegoAvConfig zegoAvConfig = new ZegoAvConfig(2);
        int i = (int) (((AppInfo.m * 544) * 1.0f) / AppInfo.l);
        zegoAvConfig.setVideoCaptureResolution(544, i);
        zegoAvConfig.setVideoEncodeResolution(544, i);
        Log.i("xpm", "setZegoAvConfigScreen width:544");
        Log.i("xpm", "setZegoAvConfigScreen height:" + i);
        zegoAvConfig.setVideoBitrate(1024000);
        zegoAvConfig.setVideoFPS(15);
        ZegoLiveRoom zegoLiveRoom = this.n;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setAVConfig(zegoAvConfig, 1);
        }
    }

    public boolean i() {
        boolean z;
        Log.i("==record", "unInitZegoSDK");
        this.q = 0;
        if (this.n != null) {
            e().uninit();
            this.u = InitProccessState.WaitInitState;
            z = this.n.unInitSDK();
            this.n = null;
            this.p = null;
            this.r = null;
        } else {
            z = false;
        }
        ZegoAudioAux zegoAudioAux = this.r;
        if (zegoAudioAux != null) {
            zegoAudioAux.enableAux(false);
            this.r = null;
        }
        return z;
    }

    public void j() {
        f().enableAux(true);
        LiveEventBus.get("live_music_changed").post("");
    }

    public void k() {
        f().enableAux(false);
        LiveEventBus.get("live_music_changed").post("");
    }

    public void l() {
        m();
        f().enableAux(false);
        YYMusicManager.a.c().a((LiveMusicModel) null);
        YYMusicManager.a.c().a((YYKtvMusicModel) null);
        YYMusicManager.a.c().a((List<? extends YYKtvMusicModel>) null);
    }

    public void m() {
        ITXCMZegoAudioAux iTXCMZegoAudioAux = this.s;
        if (iTXCMZegoAudioAux != null) {
            iTXCMZegoAudioAux.setZegoAuxCallbackEx((ITXCMZegoAudioAuxCallbackEx) null);
        }
        this.s = null;
    }

    public String n() {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(null);
        if (externalFilesDir.exists() && externalFilesDir.canRead()) {
            String a2 = ZipUtil.a.a().a();
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            File file = new File(externalFilesDir, "zegoavlog1.txt");
            File file2 = file;
            if (!file.exists()) {
                file2 = new File(externalFilesDir, "zegoavlog.txt");
            }
            if (file2.exists()) {
                FileUtils.a(file2.getAbsolutePath(), new File(a2, "zego_av_log.txt").getAbsolutePath());
                File file3 = new File(externalFilesDir, "live_log.zip");
                ZipUtil.a.a().a(a2, file3.getAbsolutePath());
                return file3.getAbsolutePath();
            }
            return "";
        }
        return "";
    }
}
