package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.contract.IHandActionListener;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.manager.FilterDataManager;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeZegoFlashManger;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.GetAppIDConfig;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.PopBeautyNewView;
import com.blued.android.module.live_china.zegoVideoCapture.VideoFilterFactory;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.sdk.PushConsts;
import com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback;
import com.zego.zegoavkit2.ZegoExternalVideoCapture;
import com.zego.zegoavkit2.audiodevice.ZegoExternalAudioDevice;
import com.zego.zegoavkit2.mediarecorder.ZegoMediaRecorder;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamInfo;
import com.zego.zegoavkit2.mixstream.ZegoSoundLevelInMixStreamInfo;
import com.zego.zegoavkit2.screencapture.ZegoScreenCaptureFactory;
import com.zego.zegoavkit2.videofilter.ZegoExternalVideoFilter;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLiveEventCallback;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.callback.IZegoUpdatePublishTargetCallback;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingOnliveManager.class */
public class RecordingOnliveManager implements IHandActionListener {
    public static ZegoScreenCaptureFactory f;

    /* renamed from: a  reason: collision with root package name */
    public Context f13794a;
    public SenseTimeZegoFlashManger b;
    public boolean e;
    private RecordingOnliveFragment h;
    private ZegoMediaRecorder t;
    private ExecutorService g = Executors.newSingleThreadExecutor();
    private int i = 1;
    private StopConnecting j = new StopConnecting();
    private StartMixStream k = new StartMixStream();
    private volatile boolean l = true;
    private int m = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f13795c = "";
    private List<String> n = new ArrayList();
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private String r = "";
    public boolean d = false;
    private int s = 0;
    private String u = "";
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private ZegoMixStreamHelper.MixStreamCallback y = new ZegoMixStreamHelper.MixStreamCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.9
        @Override // com.blued.android.module.live_china.common.ZegoMixStreamHelper.MixStreamCallback
        public void a(int i) {
            if (i != 0) {
                RecordingOnliveManager.this.B();
            } else {
                AppInfo.n().removeCallbacks(RecordingOnliveManager.this.k);
            }
            LiveMsgSendManager a2 = LiveMsgSendManager.a();
            a2.d("混流回调errorcode：" + i);
        }

        @Override // com.blued.android.module.live_china.common.ZegoMixStreamHelper.MixStreamCallback
        public void a(ArrayList<ZegoSoundLevelInMixStreamInfo> arrayList) {
        }
    };
    private Handler z = new Handler() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.13
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 150) {
                return;
            }
            ByteBuffer byteBuffer = (ByteBuffer) message.obj;
            Bundle data = message.getData();
            RecordingOnliveManager.this.a(byteBuffer, FileUtils.a(message.arg1), data.getInt("imageWidth"), data.getInt("imageHeight"));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingOnliveManager$StartMixStream.class */
    public class StartMixStream implements Runnable {
        private StartMixStream() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RecordingOnliveManager.this.h.bb()) {
                Log.i("==makelover==", "isLiveConnecting:" + RecordingOnliveManager.this.f13795c);
                ZegoMixStreamHelper.a().a(RecordingOnliveManager.this.f13795c);
                RecordingOnliveManager.this.B();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingOnliveManager$StopConnecting.class */
    public class StopConnecting implements Runnable {
        private StopConnecting() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordingOnliveManager.this.b();
            if (RecordingOnliveManager.this.h != null) {
                RecordingOnliveManager.this.h.G_();
                RecordingOnliveManager.this.h.k(8);
                RecordingOnliveManager.this.h.f(true);
            }
            if (RecordingOnliveManager.this.g != null) {
                RecordingOnliveManager.this.g.shutdownNow();
                RecordingOnliveManager.this.g = null;
            }
        }
    }

    public RecordingOnliveManager(RecordingOnliveFragment recordingOnliveFragment, boolean z) {
        this.f13794a = recordingOnliveFragment.getContext();
        this.h = recordingOnliveFragment;
        FilterDataManager.getInstance().getFilters();
        E();
        D();
        F();
        G();
        LiveGiftManager.a().a(true);
    }

    private void A() {
        ZegoCommonHelper.b().c().setZegoRoomCallback(new IZegoRoomCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.4
            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onDisconnect(int i, String str) {
                Log.v("==record", "onDisconnect");
                if (RecordingOnliveManager.this.h.ba()) {
                    RecordingOnliveManager.this.h.au();
                } else if (RecordingOnliveManager.this.h.r()) {
                    RecordingOnliveManager.this.h.bc();
                } else if (RecordingOnliveManager.this.h.aS() || RecordingOnliveManager.this.h.aT()) {
                    RecordingOnliveManager.this.h.M();
                } else if (RecordingOnliveManager.this.h.aU()) {
                    RecordingOnliveManager.this.h.I_();
                    RecordingOnliveManager.this.h.k.b();
                } else if (RecordingOnliveManager.this.h.aV()) {
                    RecordingOnliveManager.this.h.be();
                    RecordingOnliveManager.this.h.an();
                } else if (RecordingOnliveManager.this.h.aW() || RecordingOnliveManager.this.h.aX() || RecordingOnliveManager.this.h.aY()) {
                    RecordingOnliveManager.this.h.bf();
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onKickOut(int i, String str, String str2) {
                Log.v("==record", "onKickOut");
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onNetworkQuality(String str, int i, int i2) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onReconnect(int i, String str) {
                Log.v("==record", "onReconnect");
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onRecvCustomCommand(String str, String str2, String str3, String str4) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onRoomInfoUpdated(ZegoRoomInfo zegoRoomInfo, String str) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfoArr, String str) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onStreamUpdated(int i, ZegoStreamInfo[] zegoStreamInfoArr, String str) {
                int length = zegoStreamInfoArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    ZegoStreamInfo zegoStreamInfo = zegoStreamInfoArr[i3];
                    Log.v("==record", "onStreamUpdated i:" + i + " -- s:" + str + " -- streamid:" + zegoStreamInfo.streamID);
                    i2 = i3 + 1;
                }
                if (i != 2002 || zegoStreamInfoArr == null || zegoStreamInfoArr.length <= 0 || zegoStreamInfoArr[0] == null) {
                    return;
                }
                if (TextUtils.equals(RecordingOnliveManager.this.h.ad != null ? String.valueOf(RecordingOnliveManager.this.h.ad.f13761a) : "", LiveRoomInfo.a().f())) {
                    if (RecordingOnliveManager.this.h.r()) {
                        RecordingOnliveManager.this.h.bc();
                    } else if (RecordingOnliveManager.this.h.aS() || RecordingOnliveManager.this.h.aT()) {
                        RecordingOnliveManager.this.h.M();
                    } else if (RecordingOnliveManager.this.h.aU()) {
                        RecordingOnliveManager.this.h.I_();
                        RecordingOnliveManager.this.h.k.b();
                    } else if (RecordingOnliveManager.this.h.aV()) {
                        RecordingOnliveManager.this.h.be();
                        RecordingOnliveManager.this.h.an();
                    } else if (RecordingOnliveManager.this.h.aW() || RecordingOnliveManager.this.h.aX() || RecordingOnliveManager.this.h.aY()) {
                        RecordingOnliveManager.this.h.bf();
                    }
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onTempBroken(int i, String str) {
                Log.v("==record", "onTempBroken");
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onTokenWillExpired(String str, int i) {
            }
        });
        ZegoMixStreamHelper.a().a(this.y);
        ZegoCommonHelper.b().c().setZegoLiveEventCallback(new IZegoLiveEventCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.5
            @Override // com.zego.zegoliveroom.callback.IZegoLiveEventCallback
            public void onLiveEvent(int i, HashMap<String, String> hashMap) {
                Log.v("==record", "onLiveEvent:" + i);
                if (i == 3) {
                    RecordingOnliveManager.this.h.k(0);
                } else if (i == 4) {
                    RecordingOnliveManager.this.h.k(8);
                } else if (i != 6) {
                } else {
                    RecordingOnliveManager.this.h.k(0);
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLiveEventCallback
            public void onStreamEvent(int i, String str, HashMap<String, String> hashMap) {
            }
        });
        ZegoCommonHelper.b().c().setZegoLivePublisherCallback(new IZegoLivePublisherCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.6
            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onCaptureAudioFirstFrame() {
                Log.v("==record", "onCaptureAudioFirstFrame");
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onCaptureVideoFirstFrame() {
                Log.v("==record", "onCaptureVideoFirstFrame");
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onCaptureVideoSizeChangedTo(int i, int i2) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onJoinLiveRequest(int i, String str, String str2, String str3) {
                Log.v("==record", "onJoinLiveRequest i:" + i + " -- s:" + str + " -- s1:" + str2 + " -- s2:" + str3);
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onPublishQualityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality) {
                if (zegoPublishStreamQuality != null) {
                    Log.i("record", "onPublishQualityUpdate:" + zegoPublishStreamQuality.width + " : " + zegoPublishStreamQuality.height + " : " + zegoPublishStreamQuality.vkbps + "  : " + zegoPublishStreamQuality.vcapFps);
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onPublishStateUpdate(int i, String str, HashMap<String, Object> hashMap) {
                if (i != 0) {
                    AppMethods.a((CharSequence) ("推流失败，err:" + i));
                }
            }
        });
        ZegoCommonHelper.b().c().setZegoLivePlayerCallback(new IZegoLivePlayerCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.7
            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onInviteJoinLiveRequest(int i, String str, String str2, String str3) {
                Log.v("==record", "onInviteJoinLiveRequest i:" + i + " -- s:" + str + " -- s1:" + str2 + " -- s2:" + str3);
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality) {
                Log.v("==record", "onPlayQualityUpdate s:" + str);
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onPlayStateUpdate(int i, String str) {
                if (i != 0) {
                    AppMethods.a((CharSequence) ("拉流失败，err:" + i));
                    return;
                }
                RecordingOnliveManager.this.o = true;
                Log.v("==record", "拉流成功：" + str);
                if (RecordingOnliveManager.this.h.r() || RecordingOnliveManager.this.h.aR() || RecordingOnliveManager.this.h.aS() || RecordingOnliveManager.this.h.aT()) {
                    RecordingOnliveManager.this.h.aI();
                    String valueOf = RecordingOnliveManager.this.h.ad != null ? String.valueOf(RecordingOnliveManager.this.h.ad.f13761a) : "";
                    Log.i("==xpm", "uid:" + valueOf);
                    if (RecordingOnliveManager.this.h.aR() || RecordingOnliveManager.this.h.r()) {
                        LiveMsgSendManager.a().d("对方窗口已准备好");
                    } else {
                        RecordingOnliveManager.this.h.aW.setVisibility(0);
                        PlayingRTCManager.a(RecordingOnliveManager.this.h.getContext(), RecordingOnliveManager.this.h.aY, valueOf, RecordingOnliveManager.this.h.s, RecordingOnliveManager.this.h.t, RecordingOnliveManager.this.h.getFragmentActive());
                    }
                    final String str2 = valueOf;
                    RecordingOnliveManager.this.h.aQ.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.7.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            RecordingOnliveManager.this.h.dd.a(str2, RecordingOnliveManager.this.h.aR() || RecordingOnliveManager.this.h.r() ? 3 : 2);
                            InstantLog.a("live_connect_area_click");
                        }
                    });
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onRecvEndJoinLiveCommand(String str, String str2, String str3) {
                Log.v("==record", "onRecvEndJoinLiveCommand s:" + str + " -- s1:" + str2 + " -- s2:" + str3);
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onVideoSizeChangedTo(String str, int i, int i2) {
            }
        });
        ZegoCommonHelper.b().e().setEventWithIndexCallback(new IZegoMediaPlayerWithIndexCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.8
            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onAudioBegin(int i) {
                Log.i("==record", "onAudioBegin");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onBufferBegin(int i) {
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onBufferEnd(int i) {
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onLoadComplete(int i) {
                Log.i("==record", "onLoadComplete");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onPlayEnd(int i) {
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onPlayError(int i, int i2) {
                Log.i("==record", "onPlayError");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onPlayPause(int i) {
                Log.i("==record", "onPlayPause");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onPlayResume(int i) {
                Log.i("==record", "onPlayResume");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onPlayStart(int i) {
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onPlayStop(int i) {
                Log.i("==record", "onPlayStop");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onProcessInterval(long j, int i) {
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onReadEOF(int i) {
                Log.i("==record", "onReadEOF");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onSeekComplete(int i, long j, int i2) {
                Log.i("==record", "onSeekComplete");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onSnapshot(Bitmap bitmap, int i) {
                Log.i("==record", "onSnapshot");
            }

            @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
            public void onVideoBegin(int i) {
                Log.i("==record", "onVideoBegin");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        AppInfo.n().removeCallbacks(this.k);
        AppInfo.n().postDelayed(this.k, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        f = new ZegoScreenCaptureFactory(this.f13794a);
        new ZegoExternalVideoCapture();
        ZegoExternalVideoCapture.setVideoCaptureFactory(f, 1);
    }

    private void D() {
        ZegoCommonHelper.b().d();
        ZegoCommonHelper.b().a(846434966L, GetAppIDConfig.f11724a, !LiveRoomInfo.a().j(), 0, new IZegoInitSDKCompletionCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.10
            @Override // com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback
            public void onInitSDK(int i) {
                if (i != 0) {
                    AppMethods.a((CharSequence) ("zego SDK 初始化失败" + i));
                    return;
                }
                Log.i("==record", "initZegoSDK ok");
                RecordingOnliveManager recordingOnliveManager = RecordingOnliveManager.this;
                recordingOnliveManager.b(recordingOnliveManager.h.V);
                ZegoExternalAudioDevice.setAudioSource(1, 0);
                RecordingOnliveManager.this.C();
                ZegoCommonHelper.b().c().setPreviewView(RecordingOnliveManager.this.h.N);
                ZegoCommonHelper.b().c().setPreviewViewMode(1);
                ZegoCommonHelper.b().c().startPreview();
            }
        });
        this.t = new ZegoMediaRecorder();
        A();
    }

    private void E() {
        Log.v("drb", "美颜：" + LiveRoomPreferences.u());
        if (LiveRoomPreferences.u() == 1) {
            return;
        }
        try {
            if (this.b != null) {
                this.b.onSurfaceDestroyed();
                this.b.onDestroy();
            }
            SenseTimeZegoFlashManger senseTimeZegoFlashManger = (SenseTimeZegoFlashManger) SenseTimeFactory.createInstance(this.h.getActivity(), 3);
            this.b = senseTimeZegoFlashManger;
            senseTimeZegoFlashManger.setHandActionListener(this);
            this.b.setHandler(this.z);
            this.b.enableBeautify(true);
            this.b.setCameraFacing(this.l);
            a(this.f13794a, this.b);
        } catch (Exception e) {
            Logger.a("rrrb", "initKiwi ", e.toString());
            m();
        }
    }

    private void F() {
        RecordingOnliveFragment recordingOnliveFragment = this.h;
        recordingOnliveFragment.au = new PopBeautyNewView(recordingOnliveFragment, this);
    }

    private void G() {
        this.h.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.16
            @Override // java.lang.Runnable
            public void run() {
                if (RecordingOnliveManager.this.h.au != null) {
                    Log.v("==record", "mBeautyView initData");
                    RecordingOnliveManager.this.h.au.c();
                }
                if (RecordingOnliveManager.this.h.dc != null) {
                    Log.v("==record", "mPopGestureView initData");
                    RecordingOnliveManager.this.h.dc.d();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.io.File r7, android.graphics.Bitmap r8) {
        /*
            r6 = this;
            r0 = 0
            r11 = r0
            r0 = 0
            r9 = r0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            r1 = r0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            r3 = r2
            r4 = r7
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            r10 = r0
            r0 = r8
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L2a java.io.FileNotFoundException -> L31
            r2 = 90
            r3 = r10
            boolean r0 = r0.compress(r1, r2, r3)     // Catch: java.lang.Throwable -> L2a java.io.FileNotFoundException -> L31
            r0 = r10
            r0.close()     // Catch: java.io.IOException -> L56
            goto L5b
        L2a:
            r7 = move-exception
            r0 = r10
            r9 = r0
            goto L70
        L31:
            r9 = move-exception
            r0 = r10
            r8 = r0
            r0 = r9
            r10 = r0
            goto L44
        L3b:
            r7 = move-exception
            goto L70
        L3f:
            r10 = move-exception
            r0 = r11
            r8 = r0
        L44:
            r0 = r8
            r9 = r0
            r0 = r10
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L3b
            r0 = r8
            if (r0 == 0) goto L5b
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L56
            goto L5b
        L56:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        L5b:
            r0 = r6
            android.os.Handler r0 = r0.z
            if (r0 == 0) goto L6f
            r0 = r7
            java.lang.String r0 = r0.getAbsolutePath()
            r7 = r0
            android.content.Context r0 = com.blued.android.core.AppInfo.d()
            r1 = r7
            r2 = 0
            com.blued.android.framework.utils.AppUtils.a(r0, r1, r2)
        L6f:
            return
        L70:
            r0 = r9
            if (r0 == 0) goto L80
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L7b
            goto L80
        L7b:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        L80:
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.manager.RecordingOnliveManager.a(java.io.File, android.graphics.Bitmap):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ByteBuffer byteBuffer, File file, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        byteBuffer.position(0);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        a(file, createBitmap);
        createBitmap.recycle();
    }

    public int a(String str) {
        Log.i("==record", "setLocalWindowPosition:" + str + " getLiveState:" + this.h.M_());
        ZegoMixStreamInfo zegoMixStreamInfo = new ZegoMixStreamInfo();
        zegoMixStreamInfo.streamID = str;
        if (this.h.aS() || this.h.aT()) {
            Log.i("==record", "normal");
            if (this.h.x) {
                zegoMixStreamInfo.left = 0;
                zegoMixStreamInfo.top = 0;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().i;
                zegoMixStreamInfo.bottom = ZegoCommonHelper.b().h;
            } else {
                zegoMixStreamInfo.left = 0;
                zegoMixStreamInfo.top = 0;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                zegoMixStreamInfo.bottom = ZegoCommonHelper.b().i;
            }
        } else if (this.h.aR()) {
            if (!this.h.x) {
                Log.i("==record", "pk");
                int i = ZegoCommonHelper.b().h / 2;
                int i2 = (ZegoCommonHelper.b().h / 4) * 3;
                zegoMixStreamInfo.left = 0;
                zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i2) / 2;
                zegoMixStreamInfo.right = i;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i2;
            }
        } else if (this.h.aU()) {
            if (!this.h.x) {
                Log.i("==record", "makefriends");
                int i3 = ZegoCommonHelper.b().h / 2;
                int i4 = (int) (i3 * RecordingMakeFriendManager.f13753c);
                zegoMixStreamInfo.left = 0;
                zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - (i4 * 2)) / 2;
                zegoMixStreamInfo.right = i3;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i4;
            }
        } else if (this.h.aV()) {
            if (this.h.x) {
                return 0;
            }
            Log.i("==record", "makelover");
            int i5 = ZegoCommonHelper.b().h / 3;
            int i6 = (int) (i5 * RecordingMakeLoverManager.d);
            zegoMixStreamInfo.left = 0;
            zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - (i6 * 2)) / 2;
            zegoMixStreamInfo.right = i5;
            zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i6;
        } else if (this.h.aW() || this.h.aX() || this.h.aY()) {
            if (this.h.x) {
                return 0;
            }
            int i7 = ZegoCommonHelper.b().h / 2;
            int i8 = (int) (i7 * RecordingMultiConnectionManager.e);
            zegoMixStreamInfo.left = 0;
            int i9 = i8 * 2;
            zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i9) / 2;
            zegoMixStreamInfo.right = i7;
            zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i9;
        }
        return ZegoMixStreamHelper.a().a(zegoMixStreamInfo, str);
    }

    public void a() {
        if (TextUtils.isEmpty(this.f13795c)) {
            Log.i("==record", "mStreamID is empty");
        } else if (this.p) {
        } else {
            this.p = true;
            Log.i("==record", "startPublish");
            ZegoCommonHelper.b().c().startPublishing(this.f13795c, "", 0);
        }
    }

    public void a(float f2) {
        if (this.b == null) {
            return;
        }
        Log.i("==record", "strength:" + f2);
        this.b.setFilterStrength(f2);
    }

    public void a(float f2, float f3, String str) {
        BluedUIHttpResponse<BluedEntityA<LiveRoomData>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>(this.h.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomData> bluedEntityA) {
            }
        };
        LiveRoomHttpUtils.a(bluedUIHttpResponse, this.h.t + "", f2, f3, str);
    }

    public void a(int i) {
        if (this.s == i) {
            return;
        }
        Log.i("==record", "switchScreen:" + i);
        this.s = i;
        if (i == 0) {
            ZegoCommonHelper.b().c().stopPreview();
            ZegoCommonHelper.b().c().setAppOrientation(0);
            ZegoCommonHelper.b().b(0);
            ZegoCommonHelper.b().c().startPreview();
            return;
        }
        ZegoCommonHelper.b().c().stopPreview();
        ZegoCommonHelper.b().c().setAppOrientation(1);
        ZegoCommonHelper.b().c(0);
        ZegoCommonHelper.b().c().startPreview();
    }

    public void a(int i, String str) {
        Log.i("==record", "startConferenceInternal mode:" + i);
        Log.i("==record", "startConferenceInternal playId:" + str);
        Log.i("==record", "startConferenceInternal loginRoomSuccess:" + this.q);
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        a2.d("我的拉流id:" + str);
        if (i == 0) {
            j();
        }
        if (f() > 0) {
            e();
        }
        if (i == 3 || i == 4 || i == 5) {
            Log.v("==record", "startConferenceInternal playId ignore");
        } else {
            a(this.f13795c, str, 1);
        }
    }

    public void a(long j) {
        AppInfo.n().removeCallbacks(this.j);
        AppInfo.n().postDelayed(this.j, j);
    }

    public void a(Context context, ISenseTimeProcessor iSenseTimeProcessor) {
        try {
            VideoFilterFactory videoFilterFactory = new VideoFilterFactory(VideoFilterFactory.FilterType.FilterType_SurfaceTexture, this.b);
            videoFilterFactory.a(this.f13794a);
            ZegoExternalVideoFilter.setVideoFilterFactory(videoFilterFactory, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(BluedBeautifyKey.KEY key, float f2) {
        SenseTimeZegoFlashManger senseTimeZegoFlashManger = this.b;
        if (senseTimeZegoFlashManger == null) {
            return;
        }
        senseTimeZegoFlashManger.setBeautyParam(key, f2);
    }

    public void a(BluedFilterType.FILER filer) {
        SenseTimeZegoFlashManger senseTimeZegoFlashManger = this.b;
        if (senseTimeZegoFlashManger == null) {
            return;
        }
        if (filer == null) {
            senseTimeZegoFlashManger.setFilterStyle(null);
            return;
        }
        Log.i("==record", "setFilter");
        this.b.setFilterStyle(filer);
    }

    public void a(LiveGiftModel liveGiftModel, ISetStickerListener iSetStickerListener) {
        if (this.b == null) {
            if (iSetStickerListener != null) {
                iSetStickerListener.onFailed(ErrorCode.PlayStickerCode.DATA_ERROR, "STManager is null");
                return;
            }
            return;
        }
        Log.i("==record", "setSticker");
        if (liveGiftModel == null) {
            this.b.enableSticker(false);
            return;
        }
        Log.i("==record", "setSticker:" + liveGiftModel.anim_code);
        Log.i("==record", "setSticker:" + liveGiftModel.resource_url);
        this.b.changeSticker(liveGiftModel.anim_code, liveGiftModel.resource_url, iSetStickerListener);
        this.b.enableSticker(true);
        Log.v("pk", "setSticker--");
    }

    public void a(String str, String str2, int i) {
        Log.i("==record", "startZegoPlay:" + str + "  :" + str2 + "  :" + i);
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        StringBuilder sb = new StringBuilder();
        sb.append("拉流index：");
        sb.append(i);
        sb.append(" -- playId：");
        sb.append(str2);
        a2.d(sb.toString());
        this.n.add(str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (i == 1) {
            if ((this.h.aQ.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aQ.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal B:" + str2);
                this.h.aK();
            }
            this.h.aE.setVisibility(0);
            this.h.aQ.setVisibility(0);
            this.h.aQ.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aQ);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        } else if (i == 2) {
            if ((this.h.aR.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aR.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal C:" + str2);
                this.h.aL();
            }
            this.h.aF.setVisibility(0);
            this.h.aR.setVisibility(0);
            this.h.aR.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aR);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        } else if (i == 3) {
            if ((this.h.aS.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aS.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal D:" + str2);
                this.h.aM();
            }
            this.h.aG.setVisibility(0);
            this.h.aS.setVisibility(0);
            this.h.aS.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aS);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        }
        c(str, str2, i);
    }

    public void a(String str, final boolean z) {
        Logger.a("==record", "startLiveConnecting:");
        if (LiveRoomManager.a().p() == null || this.q) {
            return;
        }
        Log.v("==record", "conference_id:" + LiveRoomManager.a().p().conference_id);
        Log.v("==record", "streamId:" + str);
        this.f13795c = str;
        if (this.h.x) {
            this.h.getActivity().setRequestedOrientation(0);
            a(1);
        } else {
            a(0);
            if (ZegoCommonHelper.b().g() || z) {
                ZegoCommonHelper.b().c().stopPreview();
                ZegoCommonHelper.b().b(this.h.w);
                ZegoCommonHelper.b().c().setPreviewView(this.h.aJ());
                ZegoCommonHelper.b().c().setPreviewViewMode(1);
                ZegoCommonHelper.b().c().startPreview();
            }
        }
        ZegoCommonHelper.b().c().loginRoom(LiveRoomManager.a().p().conference_id, 1, new IZegoLoginCompletionCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.1
            @Override // com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback
            public void onLoginCompletion(int i, ZegoStreamInfo[] zegoStreamInfoArr) {
                if (i != 0) {
                    RecordingOnliveManager.this.q = false;
                    AppMethods.a((CharSequence) "登录zego房间失败");
                    return;
                }
                RecordingOnliveManager.this.q = true;
                if (TextUtils.isEmpty(RecordingOnliveManager.this.f13795c)) {
                    return;
                }
                ZegoCommonHelper.b().c().enableMicDevice(true);
                RecordingOnliveManager.this.a();
                if (!z) {
                    RecordingOnliveManager.this.a(false);
                    return;
                }
                RecordingOnliveManager.this.f();
                if (LiveRoomManager.a().p().matchmaking == null || LiveRoomManager.a().p().matchmaking.fans == null) {
                    return;
                }
                RecordingOnliveManager.this.h.bm.b(LiveRoomManager.a().p().matchmaking.fans);
                int i2 = 0;
                for (LiveMakeLoverFansModel liveMakeLoverFansModel : LiveRoomManager.a().p().matchmaking.fans) {
                    Log.i("==record", "sync info:" + i2 + "   :" + liveMakeLoverFansModel.stream);
                    i2++;
                    RecordingOnliveManager.this.h.ac.b(LiveRoomManager.a().p().stream, liveMakeLoverFansModel.stream, i2);
                }
            }
        });
    }

    public void a(final boolean z) {
        this.d = false;
        this.v = System.currentTimeMillis() / 1000;
        this.m++;
        this.r = (LiveRoomManager.a().p().publish_url + "&serialnum=") + String.valueOf(this.m);
        Log.v("==record", "startSingleStream:" + this.r);
        ZegoCommonHelper.b().c().addPublishTarget(this.r, this.f13795c, new IZegoUpdatePublishTargetCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.2
            @Override // com.zego.zegoliveroom.callback.IZegoUpdatePublishTargetCallback
            public void onUpdatePublishTargetState(int i, String str) {
                Log.v("==record", "addPublishTarget:" + i);
                if (z) {
                    ZegoMixStreamHelper.a().c(RecordingOnliveManager.this.f13795c);
                } else {
                    ZegoMixStreamHelper.a().b();
                }
            }
        });
    }

    public void b() {
        if (this.p) {
            this.p = false;
            Log.i("==record", "stopPublishing");
            ZegoCommonHelper.b().c().stopPublishing();
        }
    }

    public void b(int i) {
    }

    public void b(int i, String str) {
        ZegoCommonHelper.b().c().setPlayVolume(i, str);
    }

    public void b(long j) {
        LiveRoomManager.a().p();
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("loading_time", String.valueOf(j));
        a2.put("session_id", String.valueOf(this.h.t));
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = "live_loading";
        instantLogBody.event = PushConsts.SETTAG_ERROR_COUNT;
        InstantLog.a(instantLogBody, a2);
    }

    public void b(String str) {
        this.n.add(str);
    }

    public void b(String str, String str2, int i) {
        Log.i("==record", "startZegoPlayForMakeLover:" + str + "  :" + str2 + "  :" + i);
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        StringBuilder sb = new StringBuilder();
        sb.append("拉流index：");
        sb.append(i);
        sb.append(" -- playId：");
        sb.append(str2);
        a2.d(sb.toString());
        this.n.add(str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (i == 1) {
            if ((this.h.aQ.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aQ.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal B:" + str2);
                this.h.aK();
            }
            this.h.aE.setVisibility(0);
            this.h.aQ.setVisibility(0);
            this.h.aQ.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aQ);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        } else if (i == 2) {
            if ((this.h.aR.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aR.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal C:" + str2);
                this.h.aL();
            }
            this.h.aF.setVisibility(0);
            this.h.aR.setVisibility(0);
            this.h.aR.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aR);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        } else if (i == 3) {
            if ((this.h.aS.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aS.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal D:" + str2);
                this.h.aM();
            }
            this.h.aG.setVisibility(0);
            this.h.aS.setVisibility(0);
            this.h.aS.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aS);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        } else if (i == 4) {
            if ((this.h.aT.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aT.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal E:" + str2);
                this.h.aN();
            }
            this.h.aH.setVisibility(0);
            this.h.aT.setVisibility(0);
            this.h.aT.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aT);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        } else if (i == 5) {
            if ((this.h.aU.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.h.aU.getTag(R.id.zego_texture_id), str2)) {
                Log.v("==record", "playId not equal F:" + str2);
                this.h.aO();
            }
            this.h.aI.setVisibility(0);
            this.h.aU.setVisibility(0);
            this.h.aU.setTag(R.id.zego_texture_id, str2);
            ZegoCommonHelper.b().c().startPlayingStream(str2, this.h.aU);
            ZegoCommonHelper.b().c().setViewMode(1, str2);
        }
        c(str, str2, i);
    }

    public void b(String str, boolean z) {
        b(z ? 0 : 100, str);
    }

    public void b(boolean z) {
        if (z) {
            ZegoCommonHelper.b().c().setVideoMirrorMode(1, 0);
        } else {
            ZegoCommonHelper.b().c().setVideoMirrorMode(0, 0);
        }
    }

    public void c() {
        if (this.o) {
            for (String str : this.n) {
                ZegoCommonHelper.b().c().stopPlayingStream(str);
                Log.v("==record", "停止拉流id:" + str);
            }
            this.n.clear();
            this.o = false;
        }
    }

    public void c(String str, String str2, int i) {
        Log.i("==record", "setRemoteWindowPosition:" + str + " getLiveState:" + this.h.M_() + " index：" + i);
        ZegoMixStreamInfo zegoMixStreamInfo = new ZegoMixStreamInfo();
        zegoMixStreamInfo.streamID = str2;
        if (this.h.aS() || this.h.aT()) {
            int i2 = (int) (((ZegoCommonHelper.b().h * 1.0f) / 544.0f) * 145.0f);
            int i3 = (int) (((ZegoCommonHelper.b().i * 1.0f) / 960.0f) * 255.0f);
            if (this.h.x) {
                zegoMixStreamInfo.left = (ZegoCommonHelper.b().i - i2) - 60;
                zegoMixStreamInfo.top = (ZegoCommonHelper.b().h - i3) - 50;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().i - 60;
                zegoMixStreamInfo.bottom = ZegoCommonHelper.b().h - 50;
            } else {
                zegoMixStreamInfo.left = ZegoCommonHelper.b().h - i2;
                zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i3) - 80;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                zegoMixStreamInfo.bottom = ZegoCommonHelper.b().i - 80;
            }
        } else if (this.h.aR()) {
            if (!this.h.x) {
                int i4 = ZegoCommonHelper.b().h / 2;
                int i5 = (ZegoCommonHelper.b().h / 4) * 3;
                zegoMixStreamInfo.left = i4;
                zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i5) / 2;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i5;
            }
        } else if (this.h.aU()) {
            if (!this.h.x) {
                int i6 = ZegoCommonHelper.b().h / 2;
                int i7 = (int) (i6 * RecordingMakeFriendManager.f13753c);
                if (i == 1) {
                    zegoMixStreamInfo.left = i6;
                    int i8 = i7 * 2;
                    zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i8) / 2;
                    zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i7;
                    zegoMixStreamInfo.left = i6;
                    zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i8) / 2;
                    zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i7;
                } else if (i == 2) {
                    zegoMixStreamInfo.left = 0;
                    zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i7 * 2)) / 2) + i7;
                    zegoMixStreamInfo.right = i6;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i7;
                } else if (i == 3) {
                    zegoMixStreamInfo.left = i6;
                    zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i7 * 2)) / 2) + i7;
                    zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i7;
                }
            }
        } else if (this.h.aV()) {
            if (this.h.x) {
                return;
            }
            int i9 = ZegoCommonHelper.b().h / 3;
            int i10 = (int) (i9 * RecordingMakeLoverManager.d);
            if (i == 1) {
                zegoMixStreamInfo.left = i9;
                zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - (i10 * 2)) / 2;
                zegoMixStreamInfo.right = i9 * 2;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i10;
            } else if (i == 2) {
                zegoMixStreamInfo.left = i9 * 2;
                zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - (i10 * 2)) / 2;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i10;
            } else if (i == 3) {
                zegoMixStreamInfo.left = 0;
                zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i10 * 2)) / 2) + i10;
                zegoMixStreamInfo.right = i9;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i10;
            } else if (i == 4) {
                zegoMixStreamInfo.left = i9;
                zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i10 * 2)) / 2) + i10;
                zegoMixStreamInfo.right = i9 * 2;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i10;
            } else if (i == 5) {
                zegoMixStreamInfo.left = i9 * 2;
                zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i10 * 2)) / 2) + i10;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i10;
            }
        } else if ((this.h.aW() || this.h.aX() || this.h.aY()) && !this.h.x) {
            int i11 = ZegoCommonHelper.b().h / 2;
            int i12 = (int) (i11 * RecordingMultiConnectionManager.e);
            zegoMixStreamInfo.left = i11;
            int i13 = i12 * 2;
            zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i13) / 2;
            zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
            zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i13;
        }
        ZegoMixStreamHelper.a().a(zegoMixStreamInfo, str);
    }

    public void d() {
        if (this.h.getContext() == null) {
            return;
        }
        ZegoCommonHelper.b().c().setPreviewView(null);
        this.h.N = new TextureView(this.h.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.h.M.removeAllViews();
        this.h.M.addView(this.h.N, layoutParams);
        ZegoCommonHelper.b().c().setPreviewView(this.h.N);
    }

    public void e() {
        Log.v("==record", "stopSingleStream:" + this.r);
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        z();
        ZegoCommonHelper.b().c().deletePublishTarget(this.r, this.f13795c, new IZegoUpdatePublishTargetCallback() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.3
            @Override // com.zego.zegoliveroom.callback.IZegoUpdatePublishTargetCallback
            public void onUpdatePublishTargetState(int i, String str) {
                Log.v("==record", "stopSingleStream:" + i);
            }
        });
    }

    public int f() {
        Log.v("==record", "startMixStream");
        this.d = true;
        this.m++;
        ZegoMixStreamHelper.a().b((LiveRoomManager.a().p().publish_url + "&serialnum=") + String.valueOf(this.m));
        return a(this.f13795c);
    }

    public void g() {
        this.e = !this.e;
        ZegoCommonHelper.b().a(this.e);
    }

    public void h() {
        Log.v("==record", "stopConference");
        this.h.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.11
            @Override // java.lang.Runnable
            public void run() {
                RecordingOnliveManager.this.c();
                RecordingOnliveManager.this.h.aQ.setVisibility(8);
                if (RecordingOnliveManager.this.d) {
                    RecordingOnliveManager.this.a(true);
                }
            }
        });
    }

    public void i() {
        LiveRoomHttpUtils.p(new BluedUIHttpResponse(this.h.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.12
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        });
    }

    public void j() {
        ZegoCommonHelper.b().c().enableMicDevice(false);
    }

    public void k() {
        ZegoCommonHelper.b().c().enableMicDevice(true);
    }

    public boolean l() {
        return this.l;
    }

    public void m() {
        this.h.aa();
    }

    public void n() {
        SenseTimeZegoFlashManger senseTimeZegoFlashManger;
        this.l = !this.l;
        if (this.l) {
            b(this.h.V);
        } else {
            b(false);
        }
        if (this.l) {
            this.h.l(8);
        } else {
            this.h.l(0);
        }
        boolean frontCam = ZegoCommonHelper.b().c().setFrontCam(this.l);
        if (!frontCam || (senseTimeZegoFlashManger = this.b) == null) {
            return;
        }
        senseTimeZegoFlashManger.switchCamera();
        Log.v("==record", "switchCamera:" + frontCam);
    }

    public void o() {
        if (this.b != null) {
            Log.v("==record", "onStart");
            this.b.onStart();
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.IHandActionListener
    public void onHandAction(long j) {
        if (AppInfo.m()) {
            if (j == 131072) {
                AppMethods.a((CharSequence) "检测到抱拳手势");
            } else if (j == 262144) {
                AppMethods.a((CharSequence) "检测到单手比爱心手势");
            } else if (j == 8192) {
                AppMethods.a((CharSequence) "检测到单枪手势");
            } else if (j == 2048) {
                AppMethods.a((CharSequence) "检测到大拇哥手势");
            } else if (j == 16384) {
                AppMethods.a((CharSequence) "检测到爱心手势");
            }
        }
    }

    public void p() {
        if (this.b != null) {
            Log.v("==record", "onStop");
            this.b.onStop();
        }
    }

    public void q() {
        a();
        ZegoCommonHelper.b().j();
        if (this.b != null) {
            Log.v("==record", "onResume");
            this.b.onResume();
        }
        ChatManager.getInstance().resumeLive(this.h.s, this.h.t);
    }

    public void r() {
        b();
        ZegoCommonHelper.b().k();
        if (this.b != null) {
            Log.v("==record", "onPause");
            this.b.onPause();
        }
        if (this.h.br) {
            return;
        }
        ChatManager.getInstance().pauseLive(this.h.s, this.h.t);
    }

    public void s() {
        Log.v("==record", "------------onDestroy------------");
        SenseTimeZegoFlashManger senseTimeZegoFlashManger = this.b;
        if (senseTimeZegoFlashManger != null) {
            senseTimeZegoFlashManger.onDestroy();
        }
        f = null;
        ZegoCommonHelper.b().c().logoutRoom();
        c();
        ZegoCommonHelper.b().c().stopPreview();
        b();
        ZegoCommonHelper.b().l();
        if (this.d) {
            ZegoMixStreamHelper.a().c(this.f13795c);
        }
        ZegoMixStreamHelper.a().c();
        ZegoExternalVideoCapture.setVideoCaptureFactory(null, 0);
        ZegoCommonHelper.b().i();
        this.q = false;
    }

    public void t() {
        z();
        b();
        this.h.J_();
        this.h.G_();
        this.h.k(8);
    }

    public void u() {
        AppInfo.n().removeCallbacks(this.j);
    }

    public void v() {
        BluedUIHttpResponse<BluedEntityA<LiveRoomData>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>(this.h.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.RecordingOnliveManager.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomData> bluedEntityA) {
            }
        };
        LiveRoomHttpUtils.q(bluedUIHttpResponse, this.h.t + "");
    }

    public void w() {
        n();
    }

    public void x() {
        ZegoCommonHelper.b().c().enableTorch(true);
    }

    public void y() {
        ZegoCommonHelper.b().c().enableTorch(false);
    }

    public void z() {
        if (this.v > 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.w = currentTimeMillis;
            long j = currentTimeMillis - this.v;
            this.x = j;
            if (j > 1) {
                EventTrackLive.a(LiveProtos.Event.LIVE_SINGLE_END, LiveRoomManager.a().e(), this.v, this.w, this.x);
            }
            this.v = 0L;
        }
    }
}
