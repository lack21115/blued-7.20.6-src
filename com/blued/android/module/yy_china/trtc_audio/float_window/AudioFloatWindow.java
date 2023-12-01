package com.blued.android.module.yy_china.trtc_audio.float_window;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.TrtcAudioFrameModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.NotificationService;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGlobalMsgModel;
import com.blued.android.module.yy_china.model.YYHeartModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYKtvStageModel;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYMsgMuteExtra;
import com.blued.android.module.yy_china.model.YYMsgPkRoomExtra;
import com.blued.android.module.yy_china.model.YYRetryRoomModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.trtc.TRTCSendLeaveMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendPKMicrophoneStatusMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendPKMuteMsg;
import com.blued.android.module.yy_china.observer.RoleStatusObserver;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.float_window.IFloatWindow;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.FloatPermissionEvent;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcSongScoreModel;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.trtc_audio.permission.FloatPermissionDialogActivity;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.trtc.TRTCCloudDef;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/float_window/AudioFloatWindow.class */
public class AudioFloatWindow implements Observer<FloatPermissionEvent>, RoleStatusObserver {
    public static int a;
    private Context b;
    private FloatWindow c;
    private FrameLayout d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private String h = "";
    private Observer<YYMsgKickInfoExtra> i = new Observer<YYMsgKickInfoExtra>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.1
        /* renamed from: a */
        public void onChanged(YYMsgKickInfoExtra yYMsgKickInfoExtra) {
            if (yYMsgKickInfoExtra == null) {
                ToastUtils.a("你被房主移出了房间", 0);
                LiveLogUtils.a("AudioFloatWindow --> eventObserver --> 你被房主移出了房间");
            } else {
                ToastUtils.a("房间已关闭", 0);
                LiveLogUtils.a("AudioFloatWindow --> eventObserver --> 房间已关闭");
            }
            Logger.e("AudioFloatWindow", "关闭直播间");
            AudioFloatWindow.this.b("");
        }
    };
    private Observer<YYImModel> j = new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.2
        /* renamed from: a */
        public void onChanged(YYImModel yYImModel) {
            if (yYImModel == null) {
                return;
            }
            YYImMsgManager.a().v(yYImModel);
        }
    };
    private Observer<YYMsgPkRoomExtra> k = new Observer<YYMsgPkRoomExtra>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.3
        /* renamed from: a */
        public void onChanged(YYMsgPkRoomExtra yYMsgPkRoomExtra) {
            if (yYMsgPkRoomExtra == null) {
                return;
            }
            YYRoomInfoManager.e().a(yYMsgPkRoomExtra.countdown, YYConstants.AnchormanPKStatus.Fighting);
        }
    };
    private Observer<YYMsgPkRoomExtra> l = new Observer<YYMsgPkRoomExtra>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.4
        /* renamed from: a */
        public void onChanged(YYMsgPkRoomExtra yYMsgPkRoomExtra) {
            if (yYMsgPkRoomExtra == null) {
                return;
            }
            YYRoomInfoManager.e().a(yYMsgPkRoomExtra.countdown, YYConstants.AnchormanPKStatus.Punish);
        }
    };
    private Observer<YYGlobalMsgModel> m = new Observer<YYGlobalMsgModel>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.5
        /* renamed from: a */
        public void onChanged(YYGlobalMsgModel yYGlobalMsgModel) {
            YYMsgMuteExtra yYMsgMuteExtra;
            if (yYGlobalMsgModel == null) {
                return;
            }
            LiveLogUtils.a("AudioFloatWindow --> globalObserver --> 收到全局消息 ... type：" + yYGlobalMsgModel.type);
            if (yYGlobalMsgModel.type == 7 && (yYMsgMuteExtra = (YYMsgMuteExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, YYMsgMuteExtra.class)) != null) {
                if (TextUtils.equals(yYMsgMuteExtra.target_uid, YYRoomInfoManager.e().k())) {
                    if (YYRoomInfoManager.e().a != null) {
                        YYRoomInfoManager.e().a.is_mic = "0";
                        YYRoomInfoManager.e().a.is_open_mic = 0;
                    }
                    YYObserverManager.a().a("0");
                    return;
                }
                YYAudioConfig yYAudioConfig = new YYAudioConfig();
                yYAudioConfig.c = yYMsgMuteExtra.target_uid;
                AudioChannelManager.j().b(5, AppInfo.f().toJson(yYAudioConfig));
                if (AppInfo.h >= 713040) {
                    TRTCSendLeaveMsg tRTCSendLeaveMsg = new TRTCSendLeaveMsg();
                    tRTCSendLeaveMsg.cmdID = 5;
                    tRTCSendLeaveMsg.uid = yYMsgMuteExtra.target_uid;
                    AudioChannelManager.j().a(tRTCSendLeaveMsg);
                }
            }
        }
    };
    private Observer<String> n = new Observer<String>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.6
        /* renamed from: a */
        public void onChanged(String str) {
            Logger.e("xpm", "KEY_EVENT_LIVE_MUSIC_CHANGED");
            LiveMusicModel a2 = YYMusicManager.a.c().a();
            if (a2 == null || a2.playStatus != 3) {
                return;
            }
            YYKtvMusicModel a3 = YYMusicManager.a.c().a(a2.music_id);
            if (a3 != null) {
                AudioFloatWindow.this.a(a3);
                return;
            }
            YYMusicManager.a.c().a((List<? extends YYKtvMusicModel>) null);
            YYMusicManager.a.c().a((YYKtvMusicModel) null);
            YYMusicManager.a.c().a((LiveMusicModel) null);
        }
    };
    private Observer<TrtcSongScoreModel> o = new Observer<TrtcSongScoreModel>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.7
        /* renamed from: a */
        public void onChanged(TrtcSongScoreModel trtcSongScoreModel) {
            YYRoomInfoManager.e().a(trtcSongScoreModel);
            AudioFloatWindow audioFloatWindow = AudioFloatWindow.this;
            audioFloatWindow.b(ATAdConst.ATDevFrameworkType.ADOBIE_AIR, trtcSongScoreModel.gotTotalScore + "");
        }
    };
    private long p = 0;

    public AudioFloatWindow(Context context) {
        this.b = context;
        d();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveMusicModel liveMusicModel) {
        Logger.e("xpm", "onUIUpdate");
        liveMusicModel.playStatus = 2;
        YYMusicManager.a.c().a(liveMusicModel);
        AudioChannelManager.j().a(1, liveMusicModel.file_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYKtvMusicModel yYKtvMusicModel) {
        if (yYKtvMusicModel == null) {
            return;
        }
        Logger.e("xpm", "playMusic");
        YYMusicManager.a.c().a(yYKtvMusicModel);
        a(yYKtvMusicModel.sheetId, yYKtvMusicModel.musicId, yYKtvMusicModel.musicName, yYKtvMusicModel.artist, yYKtvMusicModel.duration, yYKtvMusicModel.coverUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final YYUserInfo yYUserInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.p;
        if (j <= 0 || currentTimeMillis - j < 120000) {
            return;
        }
        YYRoomHttpUtils.r(str, new BluedUIHttpResponse<BluedEntityA<YYHeartModel>>(null) { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYHeartModel> bluedEntityA) {
                YYHeartModel singleData;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                if (singleData.in_room != 1) {
                    LiveLogUtils.a("AudioFloatWindow --> 在小窗场景中 --> 调用/mics/confirm接口检查房间状态 --> 调用关播接口");
                    AudioFloatWindow.this.b("");
                }
                if (singleData.is_mics != 1) {
                    yYUserInfo.is_mic = "0";
                    yYUserInfo.is_open_mic = 0;
                    AudioFloatWindow.this.a("0");
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                AudioFloatWindow.this.p = System.currentTimeMillis();
            }
        }, (IRequestHost) null);
    }

    private void a(String str, String str2) {
        LiveLogUtils.a("AudioFloatWindow --> leaveChannel --> leaveRoom --> room_id：" + str);
        YYRoomInfoManager.e().a(str, e(str2), (IRequestHost) null);
        m();
    }

    private void a(final String str, String str2, final String str3, final String str4, final long j, final String str5) {
        YYRoomHttpUtils.u(str2, new BluedUIHttpResponse<BluedEntityA<LiveMusicModel>>(null) { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveMusicModel> bluedEntityA) {
                LiveMusicModel singleData;
                Logger.e("xpm", "onUIUpdate");
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                singleData.sheet_id = str;
                singleData.name = str3;
                singleData.artist = str4;
                singleData.duration = j;
                singleData.cover = str5;
                AudioFloatWindow.this.a(singleData);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str6) {
                AppMethods.a((CharSequence) str6);
                YYMusicManager.a.c().a((YYKtvMusicModel) null);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, (IRequestHost) null);
    }

    private boolean a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = AppInfo.d().getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        YYRoomHttpUtils.a(YYRoomInfoManager.e().b().room_id, str, str2, "", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(null) { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, (ActivityFragmentActive) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Logger.e("cdn_stream", "start ... " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.e("cdn_stream", "pushCdnStream url: " + str);
        TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam = new TRTCCloudDef.TRTCPublishCDNParam();
        tRTCPublishCDNParam.appId = GenerateTestUserSig.a();
        tRTCPublishCDNParam.bizId = GenerateTestUserSig.c();
        tRTCPublishCDNParam.url = str;
        AudioChannelManager.j().a(tRTCPublishCDNParam);
    }

    private void d() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.b).inflate(R.layout.view_audio_float_layout, (ViewGroup) null);
        this.d = frameLayout;
        this.e = (ImageView) frameLayout.findViewById(R.id.iv_talking_view);
        this.f = (ImageView) this.d.findViewById(R.id.iv_header);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.float_colse);
        this.g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MINIMIZED_WINDOW_CLICK, b.room_id, b.uid);
                }
                LiveLogUtils.a("AudioFloatWindow --> 在小窗场景 --> 主播点击 X号 进行关播");
                AudioFloatWindow.this.b("");
            }
        });
    }

    private void d(String str) {
        LiveLogUtils.a("AudioFloatWindow --> closeChannel --> closeRoom --> room_id：" + str);
        m();
        YYRoomInfoManager.e().C();
        YYRoomHttpUtils.m(str, e(""), (IRequestHost) null);
    }

    private BluedUIHttpResponse e(final String str) {
        return new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                LiveLogUtils.a("AudioFloatWindow --> EVENT_INTO_NEW_YYROOM --> 进入新的直播间 room_id：" + str);
                LiveEventBus.get("into_new_yy_room").post(str);
            }
        };
    }

    private void e() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            ImageLoader.a((IRequestHost) null, b.avatar).b(R.drawable.user_bg_round).a(this.f);
            ImageLoader.a((IRequestHost) null, RecyclingUtils.Scheme.FILE.b(AssetsUtils.a("live_talking_window.png", false))).g(-1).f().a(this.e);
            if (TextUtils.equals(b.uid, YYRoomInfoManager.e().k())) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
            }
        }
    }

    private void f() {
        Logger.e("AudioFloatWindow", "showFloatView() ... ");
        if (a > 0) {
            return;
        }
        a = 0;
        YYObserverManager.a().a(this);
        AudioChannelManager.j().b(j());
        AudioChannelManager.j().a(l());
        LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).observeForever(this.i);
        LiveEventBus.get("display_emoji_image", YYImModel.class).observeForever(this.j);
        LiveEventBus.get("show_room_pk_start", YYMsgPkRoomExtra.class).observeForever(this.k);
        LiveEventBus.get("show_room_pk_punish", YYMsgPkRoomExtra.class).observeForever(this.l);
        LiveEventBus.get("EVENT_PRIZE_MESSAGE", YYGlobalMsgModel.class).observeForever(this.m);
        LiveEventBus.get("live_music_changed", String.class).observeForever(this.n);
        LiveEventBus.get("event_update_song_score", TrtcSongScoreModel.class).observeForever(this.o);
        FloatWindow floatWindow = new FloatWindow(this.b, 0, 800, 60, 60, false, new IFloatWindow.IFloatWindowCallback() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.9
            @Override // com.blued.android.module.yy_china.trtc_audio.float_window.IFloatWindow.IFloatWindowCallback
            public View a() {
                return AudioFloatWindow.this.d;
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.float_window.IFloatWindow.IFloatWindowCallback
            public void b() {
                LiveLogUtils.a("AudioFloatWindow --> onClicked --> 关闭悬浮窗 ---> room_id：" + AudioFloatWindow.this.h);
                AudioFloatWindow.this.g();
                YYRoomInfoManager.e().b(AudioFloatWindow.this.b);
            }
        });
        this.c = floatWindow;
        floatWindow.a(true);
        this.c.a();
        this.c.a(0);
        Logger.e("AudioFloatWindow", "showFloatView() ... 1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LiveLogUtils.a("AudioFloatWindow --> hideFloatView --> 隐藏悬浮窗 ---> room_id：" + this.h);
        i();
        FloatWindow floatWindow = this.c;
        if (floatWindow != null) {
            floatWindow.b();
            this.c = null;
        }
        YYObserverManager.a().b(this);
        AudioChannelManager.j().a((IAudioContract.AppHandoverListener) null);
        AudioChannelManager.j().m();
        AudioChannelManager.j().a = false;
    }

    private void h() {
        LiveEventBus.get("event_request_float_permission", FloatPermissionEvent.class).observeForever(this);
    }

    private void i() {
        Logger.e("window", "unRegisterBus ... ");
        LiveEventBus.get("event_request_float_permission", FloatPermissionEvent.class).removeObserver(this);
        LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).removeObserver(this.i);
        LiveEventBus.get("display_emoji_image", YYImModel.class).removeObserver(this.j);
        LiveEventBus.get("show_room_pk_start", YYMsgPkRoomExtra.class).removeObserver(this.k);
        LiveEventBus.get("show_room_pk_punish", YYMsgPkRoomExtra.class).removeObserver(this.l);
        LiveEventBus.get("EVENT_PRIZE_MESSAGE", YYGlobalMsgModel.class).removeObserver(this.m);
        LiveEventBus.get("live_music_changed", String.class).removeObserver(this.n);
        LiveEventBus.get("event_update_song_score", TrtcSongScoreModel.class).removeObserver(this.o);
    }

    private IAudioContract.IAudioCallback j() {
        return new IAudioContract.IAudioCallback() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.11
            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a() {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(int i) {
                Logger.e("cdn_stream", "float 用户切换身份 ==> errorCode : " + i);
                LiveLogUtils.a("AudioFloatWindow --> onSwitchRole --> 用户切换身份 ... errorCode: " + i);
                if (i != 0) {
                    return;
                }
                if (!YYRoomInfoManager.e().i()) {
                    Logger.e("cdn_stream", "onSwitchRole stop cdnStream url ... ");
                    AudioChannelManager.j().d();
                    LiveLogUtils.a("AudioFloatWindow --> onSwitchRole --> 用户停止推流 ... uid: " + YYRoomInfoManager.e().k());
                } else if (YYRoomInfoManager.e().y()) {
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b == null) {
                        return;
                    }
                    Logger.e("cdn_stream", "onSwitchRole publish url: " + b.publish_url);
                    AudioFloatWindow.this.c(b.publish_url);
                    LiveLogUtils.a("AudioFloatWindow --> onSwitchRole -->  主播开始推流 ... publish url: " + b.publish_url);
                } else {
                    YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
                    if (yYUserInfo == null) {
                        return;
                    }
                    Logger.e("cdn_stream", "onSwitchRole publish cdnStream url: " + yYUserInfo.push_url);
                    AudioFloatWindow.this.c(yYUserInfo.push_url);
                    LiveLogUtils.a("AudioFloatWindow --> onSwitchRole --> 麦上用户开始推流 ... userInfo: " + AppInfo.f().toJson(yYUserInfo));
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(int i, String str) {
                Logger.e("cdn_stream", "float window onStartPublishCDNStream call back errCode: " + i + "; errMsg: " + str);
                AudioFloatWindow.this.n();
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                LiveLogUtils.a("AudioFloatWindow --> onStartPublishCDNStream --> 用户推流成功 上报接口 ... room_id: " + b.room_id);
                YYRoomHttpUtils.a(b.room_id);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(long j) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(TrtcAudioFrameModel trtcAudioFrameModel) {
                if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().music == null || YYRoomInfoManager.e().b().getNormalKtv().booleanValue()) {
                    return;
                }
                YYMusicManager.a.c().a(trtcAudioFrameModel, StringUtils.a(YYRoomInfoManager.e().b().music.uid, YYRoomInfoManager.e().k()));
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(TRTCCloudDef.TRTCQuality tRTCQuality) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str, int i, int i2, String str2) {
                YYAudioConfig yYAudioConfig;
                if (YYRoomInfoManager.e().b() == null) {
                    return;
                }
                LiveLogUtils.a("AudioFloatWindow --> onRecvCustomCmdMsg --> userId：" + str + "；cmdID：" + i);
                if (TextUtils.equals(str, YYRoomInfoManager.e().b().uid)) {
                    if (i == 1) {
                        if (TextUtils.isEmpty(str2) || (yYAudioConfig = (YYAudioConfig) AppInfo.f().fromJson(str2, YYAudioConfig.class)) == null) {
                            return;
                        }
                        AudioChannelManager.j().a(yYAudioConfig.b, yYAudioConfig.a);
                    } else if (i == 2) {
                        AudioChannelManager.j().l();
                    } else if (i == 3) {
                        YYAudioConfig yYAudioConfig2 = (YYAudioConfig) AppInfo.f().fromJson(str2, YYAudioConfig.class);
                        if (yYAudioConfig2 != null && TextUtils.equals(YYRoomInfoManager.e().k(), yYAudioConfig2.c)) {
                            if (YYRoomInfoManager.e().i()) {
                                LiveLogUtils.a("AudioFloatWindow --> onRecvCustomCmdMsg --> EXIT_ROOM --> 用户停止推流 ... uid: " + yYAudioConfig2.c);
                                AudioChannelManager.j().d();
                            }
                            AudioFloatWindow.this.m();
                        }
                    } else if (i != 5) {
                    } else {
                        LiveLogUtils.a("AudioFloatWindow --> onRecvCustomCmdMsg --> LEAVE_MIC ... 麦上用户被抱下麦 uid：" + YYRoomInfoManager.e().k());
                        YYAudioConfig yYAudioConfig3 = (YYAudioConfig) AppInfo.f().fromJson(str2, YYAudioConfig.class);
                        if (yYAudioConfig3 != null && TextUtils.equals(yYAudioConfig3.c, YYRoomInfoManager.e().k())) {
                            if (YYRoomInfoManager.e().a != null) {
                                YYRoomInfoManager.e().a.is_mic = "0";
                                YYRoomInfoManager.e().a.is_open_mic = 0;
                            }
                            AudioFloatWindow.this.a("0");
                        }
                    }
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str, int i, String str2) {
                TRTCSendPKMuteMsg tRTCSendPKMuteMsg;
                LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> userId：" + str + "；cmdID：" + i + "; message：" + str2);
                switch (i) {
                    case 1:
                        if (TextUtils.isEmpty(str2) || (tRTCSendPKMuteMsg = (TRTCSendPKMuteMsg) AppInfo.f().fromJson(str2, TRTCSendPKMuteMsg.class)) == null) {
                            return;
                        }
                        if (YYRoomInfoManager.e().b() == null || !YYRoomInfoManager.e().b().pk_has_connected) {
                            LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> 小窗 connectOtherRoom 房间PK连接");
                            AudioChannelManager.j().a(tRTCSendPKMuteMsg.roomId, tRTCSendPKMuteMsg.userSig);
                            return;
                        }
                        return;
                    case 2:
                        LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> 小窗 disconnectOtherRoom 房间PK断开连接");
                        AudioChannelManager.j().l();
                        return;
                    case 3:
                        LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> EXIT_ROOM ... 用户被踢出房间 uid：" + YYRoomInfoManager.e().k());
                        TRTCSendLeaveMsg tRTCSendLeaveMsg = (TRTCSendLeaveMsg) AppInfo.f().fromJson(str2, TRTCSendLeaveMsg.class);
                        if (tRTCSendLeaveMsg != null && TextUtils.equals(YYRoomInfoManager.e().k(), tRTCSendLeaveMsg.uid)) {
                            AudioFloatWindow.this.k();
                            if (YYRoomInfoManager.e().i()) {
                                LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> EXIT_ROOM --> 用户停止推流 ... uid: " + tRTCSendLeaveMsg.uid);
                                AudioChannelManager.j().d();
                            }
                            AudioFloatWindow.this.m();
                            return;
                        }
                        return;
                    case 4:
                    default:
                        return;
                    case 5:
                        LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> LEAVE_MIC ... 麦上用户被抱下麦 uid：" + YYRoomInfoManager.e().k());
                        TRTCSendLeaveMsg tRTCSendLeaveMsg2 = (TRTCSendLeaveMsg) AppInfo.f().fromJson(str2, TRTCSendLeaveMsg.class);
                        if (tRTCSendLeaveMsg2 != null && TextUtils.equals(tRTCSendLeaveMsg2.uid, YYRoomInfoManager.e().k())) {
                            if (YYRoomInfoManager.e().a != null) {
                                YYRoomInfoManager.e().a.is_mic = "0";
                                YYRoomInfoManager.e().a.is_open_mic = 0;
                            }
                            AudioFloatWindow.this.k();
                            AudioFloatWindow.this.a("0");
                            return;
                        }
                        return;
                    case 6:
                        TrtcSongScoreModel trtcSongScoreModel = (TrtcSongScoreModel) AppInfo.f().fromJson(str2, TrtcSongScoreModel.class);
                        if (trtcSongScoreModel == null) {
                            return;
                        }
                        LogUtils.d("ktv", "FloatWindow KTV_SONG_SCORE: " + str2);
                        if (YYRoomInfoManager.e().b() != null) {
                            YYMsgKtvMusic yYMsgKtvMusic = YYRoomInfoManager.e().b().music;
                            if (yYMsgKtvMusic != null) {
                                yYMsgKtvMusic.hitCount = trtcSongScoreModel.hitCount;
                            }
                            YYKtvStageModel yYKtvStageModel = YYRoomInfoManager.e().b().stage_info;
                            if (yYKtvStageModel == null) {
                                return;
                            }
                            yYKtvStageModel.total_score = (trtcSongScoreModel.totalScore / (StringUtils.a(yYKtvStageModel.lowest_score, 0) / 100.0d)) + "";
                            yYKtvStageModel.score = trtcSongScoreModel.gotTotalScore + "";
                            return;
                        }
                        return;
                    case 7:
                        Logger.e("AudioFloatWindow", "收到TRTC信令 userId：" + str + "；cmdID：" + i);
                        AudioFloatWindow.this.c();
                        return;
                    case 8:
                        TRTCSendPKMicrophoneStatusMsg tRTCSendPKMicrophoneStatusMsg = (TRTCSendPKMicrophoneStatusMsg) AppInfo.f().fromJson(str2, TRTCSendPKMicrophoneStatusMsg.class);
                        if (tRTCSendPKMicrophoneStatusMsg == null) {
                            return;
                        }
                        LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> 房间PK 静音全员 --> extra: " + str2);
                        if (YYRoomInfoManager.e().i()) {
                            YYRoomModel b = YYRoomInfoManager.e().b();
                            if (b != null) {
                                b.updateMicStatus(YYRoomInfoManager.e().k(), tRTCSendPKMicrophoneStatusMsg.status);
                            }
                            if (tRTCSendPKMicrophoneStatusMsg.status == 0) {
                                AudioChannelManager.j().a(true);
                                return;
                            } else {
                                AudioChannelManager.j().a(false);
                                return;
                            }
                        }
                        return;
                    case 9:
                        TRTCSendPKMicrophoneStatusMsg tRTCSendPKMicrophoneStatusMsg2 = (TRTCSendPKMicrophoneStatusMsg) AppInfo.f().fromJson(str2, TRTCSendPKMicrophoneStatusMsg.class);
                        if (tRTCSendPKMicrophoneStatusMsg2 != null && YYRoomInfoManager.e().i() && TextUtils.equals(tRTCSendPKMicrophoneStatusMsg2.userId, YYRoomInfoManager.e().k())) {
                            LiveLogUtils.a("AudioFloatWindow --> onRecvSEIMsg --> MICROPHONE_ENABLE --> 房主禁、解 麦上用户麦克风状态：" + str2);
                            if (tRTCSendPKMicrophoneStatusMsg2.status == 0) {
                                AudioChannelManager.j().a(true);
                                return;
                            } else {
                                AudioChannelManager.j().a(false);
                                return;
                            }
                        }
                        return;
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str, boolean z) {
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null || !YYRoomInfoManager.e().i() || TextUtils.equals(b.uid, yYUserInfo.getUid())) {
                    return;
                }
                AudioFloatWindow.this.a(b.room_id, yYUserInfo);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(Set<String> set, boolean z) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b() {
                Logger.e("sdk", "float window onConnectionRecovery ... ");
                LiveLogUtils.a("AudioFloatWindow --> onConnectionRecovery -->retryConnect");
                AudioFloatWindow.this.n();
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b(int i) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b(int i, String str) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                LiveLogUtils.a("AudioFloatWindow --> onStopPublishCDNStream --> 停止推流回调 ... room_id: " + b.room_id);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b(String str) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void c() {
                Logger.e("sdk", "float window onSendFirstLocalAudioFrame ... ");
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null || TextUtils.isEmpty(b.publish_url)) {
                    return;
                }
                LiveLogUtils.a("AudioFloatWindow --> onSendFirstLocalAudioFrame --> 用户开始推流 ... publish url: " + b.publish_url);
                AudioFloatWindow.this.c(b.publish_url);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void c(String str) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || b.music == null || !TextUtils.equals(YYRoomInfoManager.e().k(), b.music.uid)) {
            return;
        }
        AudioChannelManager.j().d(4443);
        AudioChannelManager.j().d(4444);
    }

    private IAudioContract.AppHandoverListener l() {
        return new IAudioContract.AppHandoverListener() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.13
            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.AppHandoverListener
            public void a() {
                if (AudioFloatWindow.this.c != null) {
                    Logger.e("window", "onAppBack ... ");
                    LiveLogUtils.a("AudioFloatWindow --> setHandoverListener --> 直播间进入 后台 ... ");
                    AudioManagerUtils.a().a(false);
                    AudioFloatWindow.this.c.b();
                }
                NotificationService.a(AudioFloatWindow.this.b, YYRoomInfoManager.e().a);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.AppHandoverListener
            public void b() {
                if (AudioFloatWindow.this.c != null) {
                    Logger.e("window", "onAppFore ... ");
                    LiveLogUtils.a("AudioFloatWindow --> setHandoverListener --> 直播间恢复 前台 ... ");
                    AudioManagerUtils.a().b();
                    AudioFloatWindow.this.c.a();
                }
                AudioFloatWindow.this.n();
                NotificationService.a(AudioFloatWindow.this.b);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        YYRoomInfoManager.e().x();
        AudioChannelManager.j().c();
        this.b.stopService(new Intent(this.b, NotificationService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.p(b.room_id, new BluedUIHttpResponse<BluedEntityA<YYRetryRoomModel>>() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRetryRoomModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYRetryRoomModel singleData = bluedEntityA.getSingleData();
                if (!TextUtils.equals(b.room_name, singleData.room_name)) {
                    b.room_name = singleData.room_name;
                }
                if (!TextUtils.equals(b.relationship, singleData.relationship)) {
                    b.relationship = singleData.relationship;
                }
                List<YYSeatMemberModel> list = singleData.mics;
                if (TextUtils.equals(singleData.chat_type, "4")) {
                    list.get(0).itemType = 2;
                    list.get(1).itemType = 3;
                }
                b.setSeatList(list);
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
                if (yYUserInfo == null) {
                    return;
                }
                yYUserInfo.push_url = singleData.publish_url;
                if (!TextUtils.equals(yYUserInfo.chat_anchor, singleData.chat_anchor)) {
                    yYUserInfo.chat_anchor = singleData.chat_anchor;
                }
                if (yYUserInfo.is_open_mic != singleData.is_open_mic) {
                    yYUserInfo.is_open_mic = singleData.is_open_mic;
                    if (singleData.is_open_mic == 0) {
                        AudioChannelManager.j().a(true);
                    } else {
                        AudioChannelManager.j().a(false);
                    }
                    AudioFloatWindow.this.a(singleData.is_open_mic);
                }
                if (!TextUtils.equals(yYUserInfo.is_mic, singleData.is_mic)) {
                    yYUserInfo.is_mic = singleData.is_mic;
                    if (TextUtils.equals(singleData.is_mic, "1")) {
                        AudioFloatWindow.this.a("1");
                    } else {
                        AudioFloatWindow.this.a(yYUserInfo.chat_anchor);
                    }
                }
                yYUserInfo.mute = singleData.mute;
                if (!singleData.isPking() || TextUtils.isEmpty(YYRoomInfoManager.e().D())) {
                    return;
                }
                YYRoomInfoManager.e().w();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveLogUtils.a("AudioFloatWindow --> onUIFailure --> errorCode：" + i);
                if (i == 40380002) {
                    ToastUtils.a("房间已关闭", 0);
                    AudioFloatWindow.this.m();
                } else if (i == 40380030) {
                    ToastUtils.a("你已被房主移出了房间", 0);
                    AudioFloatWindow.this.m();
                } else if (i == 40380022) {
                    AudioFloatWindow.this.m();
                }
                return super.onUIFailure(i, str);
            }
        }, (IRequestHost) null);
    }

    public void a() {
        Logger.e("AudioFloatWindow", "show() ... ");
        if (YYRoomInfoManager.e().b() != null) {
            this.h = YYRoomInfoManager.e().b().room_id;
        }
        LiveLogUtils.a("AudioFloatWindow --> show --> 显示悬浮窗 ---> room_id：" + this.h);
        if (Build.VERSION.SDK_INT < 23) {
            f();
        } else if (Settings.canDrawOverlays(AppInfo.d())) {
            f();
        } else {
            if (!a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + AppInfo.d().getPackageManager())))) {
                AppMethods.d(R.string.live_float_toast);
                return;
            }
            h();
            Intent intent = new Intent(AppInfo.d(), FloatPermissionDialogActivity.class);
            intent.putExtra("flag", 2);
            intent.addFlags(268435456);
            AppInfo.d().startActivity(intent);
        }
    }

    @Override // com.blued.android.module.yy_china.observer.RoleStatusObserver
    public void a(int i) {
        Logger.e("sdk", "AudioFloatWindow notifyMicStatus status ---> " + i);
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo != null) {
            LiveLogUtils.a("AudioFloatWindow --> notifyMicStatus --> is_open_mic：" + i + "；uid：" + yYUserInfo.getUid());
            yYUserInfo.is_open_mic = i;
        }
    }

    /* renamed from: a */
    public void onChanged(FloatPermissionEvent floatPermissionEvent) {
        int i = floatPermissionEvent.status;
        if (i == 0) {
            f();
        } else if (i != 1) {
        } else {
            LiveLogUtils.a("AudioFloatWindow --> 在申请小窗权限时被拒绝 --> 调用关播接口 ---> room_id：" + this.h);
            b("");
            i();
            AppMethods.d(R.string.live_float_toast);
        }
    }

    @Override // com.blued.android.module.yy_china.observer.RoleStatusObserver
    public void a(String str) {
        Logger.e("sdk", "AudioFloatWindow notifyStatus roleCode ---> " + str);
        LiveLogUtils.a("AudioFloatWindow --> notifyStatus --> roleCode：" + str);
        if (!TextUtils.equals("2", str) && !TextUtils.equals("0", str)) {
            if (TextUtils.equals("1", str)) {
                AudioChannelManager.j().a(20);
                c(YYRoomInfoManager.e().a.push_url);
                return;
            }
            return;
        }
        AudioChannelManager.j().d();
        AudioChannelManager.j().a(21);
        if (YYRoomInfoManager.e().a != null) {
            YYRoomInfoManager.e().a.push_url = "";
        }
        c();
    }

    public void b() {
        g();
    }

    public void b(String str) {
        LiveLogUtils.a("AudioFloatWindow --> closeRoom --> newRoomId：" + str);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            YYRoomInfoManager.e().x();
            AudioChannelManager.j().c();
            return;
        }
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo != null) {
            if (!TextUtils.equals(yYUserInfo.chat_anchor, "1")) {
                LiveLogUtils.a("AudioFloatWindow --> closeRoom --> 非主播 --> leaveChannel --> room_id：" + b.room_id);
                a(b.room_id, str);
            } else if (TextUtils.equals(b.chat_type, "9")) {
                LiveLogUtils.a("AudioFloatWindow --> closeRoom --> 娱乐厅 --> room_id：" + b.room_id);
                a(b.room_id, str);
            } else {
                LiveLogUtils.a("AudioFloatWindow --> closeRoom --> 非娱乐厅 --> room_id：" + b.room_id);
                d(b.room_id);
            }
        }
    }

    public void c() {
        YYMusicManager.a.c().a((LiveMusicModel) null);
        AudioChannelManager.j().d(1);
        LiveEventBus.get("live_music_changed").post("");
        LiveEventBus.get("live_music_exit").post("");
    }
}
