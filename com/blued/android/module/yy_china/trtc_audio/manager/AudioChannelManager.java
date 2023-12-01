package com.blued.android.module.yy_china.trtc_audio.manager;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.TrtcMusicModel;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.trtc.TRTCSEIMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendLrcMsg;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.trtc.TRTCCloudDef;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager.class */
public class AudioChannelManager implements IAudioContract.IAudioControl {
    private static volatile AudioChannelManager b;
    private IAudioContract.IAudioControl f;
    private IAudioContract.AppHandoverListener g;
    private AudioFloatWindow h;
    private boolean c = false;
    private float d = 0.0f;
    private int e = 0;
    public boolean a = false;

    private AudioChannelManager() {
    }

    private void b(Context context) {
        AudioFloatWindow audioFloatWindow = this.h;
        if (audioFloatWindow != null) {
            audioFloatWindow.b();
        }
        AudioManagerUtils.a().b();
        AudioFloatWindow audioFloatWindow2 = new AudioFloatWindow(AppInfo.d());
        this.h = audioFloatWindow2;
        audioFloatWindow2.a();
    }

    public static AudioChannelManager j() {
        AudioChannelManager audioChannelManager;
        synchronized (AudioChannelManager.class) {
            try {
                if (b == null) {
                    synchronized (AudioChannelManager.class) {
                        if (b == null) {
                            b = new AudioChannelManager();
                        }
                    }
                }
                audioChannelManager = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return audioChannelManager;
    }

    private void s() {
        k();
        this.a = false;
        this.g = null;
        this.c = false;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a() {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a();
        IAudioContract.AppHandoverListener appHandoverListener = this.g;
        if (appHandoverListener != null) {
            appHandoverListener.b();
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, float f) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            this.d = f;
            iAudioControl.a(i, f);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, int i2) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.a(i, i2);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, int i2, boolean z) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.a(i, i2, z);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, IAudioContract.IMusicCallback iMusicCallback) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(i, iMusicCallback);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(final int i, String str) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(i, new IAudioContract.IMusicCallback() { // from class: com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager.1
            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void a(int i2, int i3) {
                if (i2 != 1) {
                    return;
                }
                LiveEventBus.get("live_music_changed").post("");
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void a(TrtcMusicModel trtcMusicModel) {
                if (i != 1) {
                    return;
                }
                LiveEventBus.get("live_music_play_progress").post(trtcMusicModel);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void b(int i2, int i3) {
                if (i2 != 1) {
                    return;
                }
                LiveMusicModel a = YYMusicManager.a.c().a();
                if (a != null) {
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 != null) {
                        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK, b2.room_id, a.sheet_id, a.music_id, (int) a.duration);
                    }
                    a.playStatus = 3;
                }
                LiveEventBus.get("live_music_changed").post("");
            }
        });
        this.f.a(i, str);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(final int i, String str, final int i2, String str2, long j) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(i, (int) j);
        this.f.a(i, new IAudioContract.IMusicCallback() { // from class: com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager.2
            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void a(int i3, int i4) {
                if (i3 != 4443) {
                    return;
                }
                LiveEventBus.get("ktv_music_start").post("");
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void a(TrtcMusicModel trtcMusicModel) {
                if (i != 4443 || trtcMusicModel == null || trtcMusicModel.durationMS == trtcMusicModel.curPtsMS) {
                    return;
                }
                if (YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().b().music != null) {
                    YYRoomInfoManager.e().b().music.currentTime = trtcMusicModel.curPtsMS;
                }
                LiveEventBus.get("ktv_music_progress").post(trtcMusicModel);
                AudioChannelManager audioChannelManager = AudioChannelManager.this;
                audioChannelManager.b(4, trtcMusicModel.curPtsMS + "");
                TRTCSendLrcMsg tRTCSendLrcMsg = new TRTCSendLrcMsg();
                tRTCSendLrcMsg.cmdID = 4;
                tRTCSendLrcMsg.progressMs = trtcMusicModel.curPtsMS + "";
                AudioChannelManager.this.a(tRTCSendLrcMsg);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void b(int i3, int i4) {
                if (i3 != 4443) {
                    return;
                }
                LogUtils.d("TRTC", "onPlayComplete errorCode: " + i4);
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 == null) {
                    return;
                }
                YYMsgKtvMusic yYMsgKtvMusic = b2.music;
                if (i4 == -4002) {
                    ToastUtils.a("网络异常，已进行断网重联，继续播放音乐");
                    AudioChannelManager.this.f.d(i);
                    AudioChannelManager.this.f.d(i2);
                    if (yYMsgKtvMusic != null) {
                        AudioChannelManager.this.f.a(i, yYMsgKtvMusic.musicUrl, i2, yYMsgKtvMusic.accompanyUrl, yYMsgKtvMusic.currentTime);
                        AudioChannelManager.this.f.a(i3, (int) yYMsgKtvMusic.currentTime);
                    }
                } else if (yYMsgKtvMusic == null || yYMsgKtvMusic.duration <= yYMsgKtvMusic.currentTime || i4 != 0) {
                    if (yYMsgKtvMusic != null) {
                        yYMsgKtvMusic.currentTime = 0L;
                    }
                    LiveEventBus.get("ktv_music_play_finish").post("");
                }
            }
        });
        this.f.a(i, str, i2, str2, j);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(final int i, final boolean z, final String str, final int i2, final String str2, long j) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(i, (int) j);
        this.f.a(i, new IAudioContract.IMusicCallback() { // from class: com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager.3
            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void a(int i3, int i4) {
                if (i3 != 4443) {
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void a(TrtcMusicModel trtcMusicModel) {
                if (i != 4443 || trtcMusicModel == null || trtcMusicModel.durationMS == trtcMusicModel.curPtsMS) {
                    return;
                }
                if (YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().b().robMus != null) {
                    YYRoomInfoManager.e().b().robMus.setCurrentTime(trtcMusicModel.curPtsMS);
                }
                LiveEventBus.get("rob_music_progress").post(trtcMusicModel);
                TRTCSendLrcMsg tRTCSendLrcMsg = new TRTCSendLrcMsg();
                tRTCSendLrcMsg.cmdID = 10;
                tRTCSendLrcMsg.progressMs = trtcMusicModel.curPtsMS + "";
                tRTCSendLrcMsg.type = z ? 1 : 2;
                if (YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().b().robMus != null) {
                    tRTCSendLrcMsg.musicId = YYRoomInfoManager.e().b().robMus.getMusicId();
                }
                AudioChannelManager.this.a(tRTCSendLrcMsg);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IMusicCallback
            public void b(int i3, int i4) {
                if (i3 != 4443) {
                    return;
                }
                LogUtils.d("TRTC", "onPlayComplete errorCode: " + i4);
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 == null) {
                    return;
                }
                YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode = b2.robMus;
                if (i4 != -4002) {
                    if ((yYBorImJsonBodyInfoMode == null || yYBorImJsonBodyInfoMode.getDuration() <= yYBorImJsonBodyInfoMode.getCurrentTime() || i4 != 0) && yYBorImJsonBodyInfoMode != null) {
                        yYBorImJsonBodyInfoMode.setCurrentTime(0L);
                        return;
                    }
                    return;
                }
                ToastUtils.a("网络异常，已进行断网重联，继续播放音乐");
                AudioChannelManager.this.f.d(i);
                AudioChannelManager.this.f.d(i2);
                if (yYBorImJsonBodyInfoMode != null) {
                    AudioChannelManager.this.f.a(i, z, str, i2, str2, yYBorImJsonBodyInfoMode.getCurrentTime());
                    AudioChannelManager.this.f.a(i3, (int) yYBorImJsonBodyInfoMode.getCurrentTime());
                }
            }
        });
        this.f.a(i, z, str, i2, str2, j);
    }

    public void a(Context context) {
        LiveLogUtils.a("AudioChannelManager --> showFloatViewIfNeeded --> needShowFloatView：" + j().a);
        if (j().a) {
            b(context);
        } else {
            s();
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(TRTCSEIMsg tRTCSEIMsg) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null || tRTCSEIMsg == null) {
            return;
        }
        iAudioControl.a(tRTCSEIMsg);
    }

    public void a(IAudioContract.AppHandoverListener appHandoverListener) {
        this.g = appHandoverListener;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(IAudioContract.IAudioCallback iAudioCallback) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.b(iAudioCallback);
            return;
        }
        AudioChannelManagerForTencent audioChannelManagerForTencent = new AudioChannelManagerForTencent();
        this.f = audioChannelManagerForTencent;
        audioChannelManagerForTencent.a(iAudioCallback);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(YYAudioConfig yYAudioConfig) {
        if (this.f == null || yYAudioConfig == null || TextUtils.isEmpty(yYAudioConfig.c)) {
            return;
        }
        this.f.a(yYAudioConfig);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(tRTCPublishCDNParam);
    }

    public void a(String str) {
        if (this.h == null) {
            YYRoomInfoManager.e().d(str);
            return;
        }
        LiveLogUtils.a("AudioChannelManager --> closeLiveRoom --> newRoomId：" + str);
        this.h.b(str);
        this.h = null;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(String str, int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(str, i);
    }

    public void a(String str, String str2) {
        if (this.f != null) {
            Logger.e("sdk", "connectOtherRoom ==> self_uid: " + YYRoomInfoManager.e().k() + "; pk_room_id: " + str + "; pk_room_ownerUid: " + str2);
            LiveLogUtils.a("AudioChannelManager --> connectOtherRoom --> user_id：" + YYRoomInfoManager.e().k() + ", pk_room_id：" + str + ", pk_room_ownerUid：" + str2);
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 == null) {
                return;
            }
            b2.pk_has_connected = true;
            YYAudioConfig yYAudioConfig = new YYAudioConfig();
            yYAudioConfig.c = YYRoomInfoManager.e().k();
            yYAudioConfig.b = str;
            yYAudioConfig.a = b2.user_sig;
            this.f.b(yYAudioConfig);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(boolean z) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.a(z);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(boolean z, int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.a(z, i);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b() {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.b();
        IAudioContract.AppHandoverListener appHandoverListener = this.g;
        if (appHandoverListener != null) {
            appHandoverListener.a();
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.b(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(int i, String str) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.b(i, str);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(IAudioContract.IAudioCallback iAudioCallback) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.b(iAudioCallback);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(YYAudioConfig yYAudioConfig) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.b(yYAudioConfig);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(boolean z) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            this.c = z;
            iAudioControl.b(z);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void c() {
        if (this.f == null) {
            return;
        }
        s();
        this.f.c();
        this.f = null;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void c(int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.c(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void d() {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.d();
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void d(int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl == null) {
            return;
        }
        iAudioControl.d(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void e() {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.e();
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void e(int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.e(i);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public int f() {
        return this.f.f();
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void f(int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.f(i);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public int g() {
        return this.f.g();
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void g(int i) {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            this.e = i;
            iAudioControl.g(i);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public int h() {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            return iAudioControl.h();
        }
        return 0;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void i() {
        IAudioContract.IAudioControl iAudioControl = this.f;
        if (iAudioControl != null) {
            iAudioControl.i();
        }
    }

    public void k() {
        AudioFloatWindow audioFloatWindow = this.h;
        if (audioFloatWindow != null) {
            audioFloatWindow.b();
            this.h = null;
        }
    }

    public void l() {
        if (this.f != null) {
            Logger.e("sdk", "disconnectOtherRoom ==> self_uid: " + YYRoomInfoManager.e().k() + "; pk_room_id: " + YYRoomInfoManager.e().D() + "; pk_room_ownerUid: " + YYRoomInfoManager.e().E());
            LiveLogUtils.a("AudioChannelManager --> disconnectOtherRoom --> user_id：" + YYRoomInfoManager.e().k() + ", pk_room_id：" + YYRoomInfoManager.e().D() + ", pk_room_ownerUid：" + YYRoomInfoManager.e().E());
            this.f.e();
        }
    }

    public void m() {
        if (this.h != null) {
            this.h = null;
        }
    }

    public boolean n() {
        return this.h != null;
    }

    public boolean o() {
        if (this.h != null) {
            AppMethods.a((CharSequence) AppUtils.a(R.string.yy_in_use));
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.c;
    }

    public float q() {
        return this.d;
    }

    public int r() {
        return this.e;
    }
}
