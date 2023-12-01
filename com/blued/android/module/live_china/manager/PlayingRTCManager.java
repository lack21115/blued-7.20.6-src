package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.GetAppIDConfig;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback;
import com.zego.zegoavkit2.soundlevel.ZegoSoundLevelInfo;
import com.zego.zegoavkit2.soundlevel.ZegoSoundLevelMonitor;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLiveEventCallback;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingRTCManager.class */
public class PlayingRTCManager {

    /* renamed from: c  reason: collision with root package name */
    public long f13727c;
    public long d;
    public long e;
    private TextureView f;
    private View g;
    private View h;
    private PlayingOnliveFragment i;
    private boolean k;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13726a = true;
    private boolean j = false;
    private List<String> l = new ArrayList();
    private boolean m = false;
    private boolean n = false;
    private boolean o = true;
    int b = -1;
    private int p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.manager.PlayingRTCManager$14  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingRTCManager$14.class */
    public static /* synthetic */ class AnonymousClass14 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13735a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[JoinLiveResult.values().length];
            f13735a = iArr;
            try {
                iArr[JoinLiveResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13735a[JoinLiveResult.FAILED_UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13735a[JoinLiveResult.FAILED_JOINLIVE_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13735a[JoinLiveResult.FAILED_JOINLIVE_FULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13735a[JoinLiveResult.FAILED_JOINLIVE_INVITE_OVERDUE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public PlayingRTCManager(PlayingOnliveFragment playingOnliveFragment, TextureView textureView) {
        this.i = playingOnliveFragment;
        this.f = textureView;
        s();
        this.g = LayoutInflater.from(AppInfo.d()).inflate(R.layout.live_mark_make_lover, (ViewGroup) null);
        this.h = LayoutInflater.from(AppInfo.d()).inflate(R.layout.live_mark_make_friend, (ViewGroup) null);
        if (this.i.Y == 1) {
            ViewGroup.LayoutParams layoutParams = this.i.aj.getLayoutParams();
            layoutParams.width = DensityUtils.a(this.i.getContext(), 280.0f);
            layoutParams.height = DensityUtils.a(this.i.getContext(), 157.0f);
            this.i.aj.setLayoutParams(layoutParams);
        }
    }

    public static void a(Context context, final TextView textView, String str, short s, long j, IRequestHost iRequestHost) {
        LiveRoomHttpUtils.a(context, new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                LiveRoomUserModel liveRoomUserModel;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (liveRoomUserModel = bluedEntityA.data.get(0)) == null || TextUtils.isEmpty(liveRoomUserModel.name)) {
                    return;
                }
                textView.setVisibility(0);
                textView.setText(liveRoomUserModel.name);
            }
        }, str, "", Long.valueOf(j), Short.valueOf(s), iRequestHost);
    }

    private void a(String str, final FileHttpResponseHandler fileHttpResponseHandler) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(AppInfo.d().getExternalCacheDir(), "pushPhoto");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, Md5.a(str));
        final String path = file2.getPath();
        if (!file2.exists()) {
            Log.i("==record", "downloadPhotoResource:" + str);
            FileDownloader.a(str, path, new FileHttpResponseHandler() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.13
                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                /* renamed from: a */
                public void onSuccess(final File file3) {
                    if (file3 == null || !file3.exists()) {
                        Log.i("==record", "downloadPhotoResource fail");
                        return;
                    }
                    Log.i("==record", "downloadPhotoResource complete:" + path);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fileHttpResponseHandler != null) {
                                fileHttpResponseHandler.onSuccess(file3);
                            }
                        }
                    });
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFinish() {
                }
            }, null);
            return;
        }
        Log.i("==record", "has downloadPhotoResource:" + str);
        if (fileHttpResponseHandler != null) {
            fileHttpResponseHandler.onSuccess(file2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d();
        j();
        if (this.i.aC()) {
            Log.i("==record", "make lover startZegoPublish");
            ZegoCommonHelper.b().c().enableCamera(false);
            this.k = false;
        }
        if (this.i.aA()) {
            Log.i("==record", "make friend startZegoPublish");
            c();
        }
        Log.v("==record", "startZegoPublish");
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        a2.d("开始推流：" + str);
        this.f.setVisibility(0);
        ZegoCommonHelper.b().c().setPreviewView(this.f);
        ZegoCommonHelper.b().c().setPreviewViewMode(1);
        ZegoCommonHelper.b().c().startPreview();
        ZegoCommonHelper.b().c().startPublishing(str, "", 0);
        Log.v("==record", "startZegoPublish end --- ");
        if (this.i.aC()) {
            b(this.i.bY.i);
        }
    }

    private void o() {
        Log.i("==record", "initZego:" + this.j);
        if (this.j) {
            ZegoCommonHelper.b().b(this.i.M_());
            return;
        }
        s();
        ZegoCommonHelper.b().d();
        ZegoCommonHelper.b().a(846434966L, GetAppIDConfig.f11724a, !LiveRoomInfo.a().j(), this.i.M_(), new IZegoInitSDKCompletionCallback() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.1
            @Override // com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback
            public void onInitSDK(int i) {
                Log.i("==record", "onInitSDK:" + i);
                if (i != 0) {
                    AppMethods.a((CharSequence) ("zego SDK 初始化失败" + i));
                }
            }
        });
        Log.i("==record", "initZego enableBeautifying");
        ZegoCommonHelper.b().c().enableBeautifying(3);
        Log.i("==record", "initZego set callback");
        p();
        this.j = true;
    }

    private void p() {
        ZegoCommonHelper.b().c().setZegoRoomCallback(new IZegoRoomCallback() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.5
            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onDisconnect(int i, String str) {
                Log.v("==record", "onDisconnect");
                if (PlayingRTCManager.this.i.az()) {
                    PlayingRTCManager.this.i.h(false);
                } else if (PlayingRTCManager.this.i.aB()) {
                    PlayingRTCManager.this.i.I_();
                    PlayingRTCManager.this.i.k.b();
                    PlayingRTCManager.this.i.cb.setState(0);
                    PlayingRTCManager.this.i.k.a(1);
                } else if (PlayingRTCManager.this.i.aD()) {
                    PlayingRTCManager.this.i.aa();
                    PlayingRTCManager.this.i.P();
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
                long j = 0;
                if (PlayingRTCManager.this.i.K != null) {
                    j = PlayingRTCManager.this.i.K.b;
                }
                if (j == LiveRoomManager.a().f()) {
                    Log.i("==record", "onStreamUpdated 2002 exit");
                    if (PlayingRTCManager.this.i.az()) {
                        PlayingRTCManager.this.i.a(0, false);
                        PlayingRTCManager.this.i.h(false);
                    } else if (!PlayingRTCManager.this.i.aB()) {
                        PlayingRTCManager.this.i.aD();
                    } else {
                        PlayingRTCManager.this.i.a(0, false);
                        PlayingRTCManager.this.i.I_();
                        PlayingRTCManager.this.i.k.b();
                        PlayingRTCManager.this.i.cb.setState(0);
                        PlayingRTCManager.this.i.k.a(1);
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
        ZegoCommonHelper.b().c().setZegoLiveEventCallback(new IZegoLiveEventCallback() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.6
            @Override // com.zego.zegoliveroom.callback.IZegoLiveEventCallback
            public void onLiveEvent(int i, HashMap<String, String> hashMap) {
                if (i == 2) {
                    PlayingRTCManager.this.i.a(8, false);
                } else if (i != 3) {
                } else {
                    PlayingRTCManager.this.i.a(0, false);
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLiveEventCallback
            public void onStreamEvent(int i, String str, HashMap<String, String> hashMap) {
            }
        });
        ZegoCommonHelper.b().c().setZegoLivePublisherCallback(new IZegoLivePublisherCallback() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.7
            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onCaptureAudioFirstFrame() {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onCaptureVideoFirstFrame() {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onCaptureVideoSizeChangedTo(int i, int i2) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onJoinLiveRequest(int i, String str, String str2, String str3) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onPublishQualityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality) {
                if (zegoPublishStreamQuality != null) {
                    Log.i("==record", "onPublishQualityUpdate:" + zegoPublishStreamQuality.width + " : " + zegoPublishStreamQuality.height + " : " + zegoPublishStreamQuality.vkbps + "  : " + zegoPublishStreamQuality.vcapFps);
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onPublishStateUpdate(int i, String str, HashMap<String, Object> hashMap) {
                if (i != 0) {
                    AppMethods.a((CharSequence) ("推流失败，err:" + i));
                    return;
                }
                PlayingRTCManager.this.n = true;
                if (!PlayingRTCManager.this.i.aB() || PlayingRTCManager.this.i.ca.a()) {
                    return;
                }
                PlayingRTCManager.this.i.aX();
            }
        });
        ZegoCommonHelper.b().c().setZegoLivePlayerCallback(new IZegoLivePlayerCallback() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.8
            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onInviteJoinLiveRequest(int i, String str, String str2, String str3) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onPlayStateUpdate(int i, String str) {
                if (i != 0) {
                    LiveMsgSendManager a2 = LiveMsgSendManager.a();
                    a2.d("拉流失败，err:" + i);
                    return;
                }
                PlayingRTCManager.this.m = true;
                if (PlayingRTCManager.this.i.az() || PlayingRTCManager.this.i.ax() || PlayingRTCManager.this.i.ay()) {
                    PlayingRTCManager.this.i.as();
                    String valueOf = PlayingRTCManager.this.i.K != null ? String.valueOf(PlayingRTCManager.this.i.K.b) : "";
                    if (!PlayingRTCManager.this.i.aQ) {
                        PlayingRTCManager.this.i.h(false);
                    }
                    PlayingRTCManager.a(PlayingRTCManager.this.i.getContext(), PlayingRTCManager.this.i.aD, valueOf, PlayingRTCManager.this.i.s, PlayingRTCManager.this.i.t, PlayingRTCManager.this.i.getFragmentActive());
                    if (CommonStringUtils.c(valueOf) == LiveRoomManager.a().f()) {
                        PlayingRTCManager.this.i.aB.setVisibility(0);
                    } else {
                        PlayingRTCManager.this.i.aB.setVisibility(8);
                    }
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onRecvEndJoinLiveCommand(String str, String str2, String str3) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onVideoSizeChangedTo(String str, int i, int i2) {
            }
        });
        ZegoSoundLevelMonitor.getInstance().setCycle(300);
        ZegoSoundLevelMonitor.getInstance().setCallback(new IZegoSoundLevelCallback() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.9
            @Override // com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback
            public void onCaptureSoundLevelUpdate(ZegoSoundLevelInfo zegoSoundLevelInfo) {
                if (PlayingRTCManager.this.i == null || zegoSoundLevelInfo == null) {
                    return;
                }
                if (PlayingRTCManager.this.i.aD()) {
                    if (zegoSoundLevelInfo.soundLevel <= 1.0f || !PlayingRTCManager.this.o) {
                        PlayingRTCManager.this.i.ac();
                    } else {
                        PlayingRTCManager.this.i.ab();
                    }
                } else if (PlayingRTCManager.this.i.aB()) {
                    if (zegoSoundLevelInfo.soundLevel <= 1.0f || !PlayingRTCManager.this.o) {
                        PlayingRTCManager.this.i.ae();
                    } else {
                        PlayingRTCManager.this.i.ad();
                    }
                }
            }

            @Override // com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback
            public void onSoundLevelUpdate(ZegoSoundLevelInfo[] zegoSoundLevelInfoArr) {
            }
        });
        ZegoSoundLevelMonitor.getInstance().start();
    }

    private void q() {
        Bitmap createBitmap;
        try {
            this.g.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.g.layout(0, 0, this.g.getMeasuredWidth(), this.g.getMeasuredHeight());
            createBitmap = Bitmap.createBitmap(this.g.getWidth(), this.g.getHeight(), Bitmap.Config.ARGB_8888);
            this.g.draw(new Canvas(createBitmap));
        } catch (Exception e) {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            e.printStackTrace();
        }
        String m = m();
        LiveBitmapUtils.a(createBitmap, m, 100);
        if (createBitmap != null) {
            createBitmap.recycle();
        }
        Rect rect = new Rect(0, 0, ZegoCommonHelper.b().j, ZegoCommonHelper.b().k);
        ZegoLiveRoom.setWaterMarkImagePath(RecyclingUtils.Scheme.FILE.b(m));
        ZegoLiveRoom.setPreviewWaterMarkRect(rect);
        ZegoLiveRoom.setPublishWaterMarkRect(rect);
    }

    private void r() {
        Bitmap createBitmap;
        try {
            this.h.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.h.layout(0, 0, this.h.getMeasuredWidth(), this.h.getMeasuredHeight());
            createBitmap = Bitmap.createBitmap(this.h.getWidth(), this.h.getHeight(), Bitmap.Config.ARGB_8888);
            this.h.draw(new Canvas(createBitmap));
        } catch (Exception e) {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            e.printStackTrace();
        }
        String m = m();
        LiveBitmapUtils.a(createBitmap, m, 100);
        if (createBitmap != null) {
            createBitmap.recycle();
        }
        Rect rect = new Rect(0, 0, ZegoCommonHelper.b().j, ZegoCommonHelper.b().k);
        ZegoLiveRoom.setWaterMarkImagePath(RecyclingUtils.Scheme.FILE.b(m));
        ZegoLiveRoom.setPreviewWaterMarkRect(rect);
        ZegoLiveRoom.setPublishWaterMarkRect(rect);
    }

    private void s() {
        ImageFileLoader.a((IRequestHost) null).a(AvatarUtils.a(0, LiveRoomInfo.a().e())).a();
    }

    public void a() {
        b(true, 2);
    }

    public void a(JoinLiveResult joinLiveResult, final String str, final String str2, final String str3, final int i) {
        Logger.a("==record", "onJoinLive result = ", joinLiveResult.toString(), "--", "joinLiveId = ", str);
        int i2 = AnonymousClass14.f13735a[joinLiveResult.ordinal()];
        if (i2 != 1) {
            if (i2 == 4) {
                AppMethods.d(R.string.no_extra_quota);
            } else if (i2 != 5) {
            } else {
                AppMethods.d(R.string.audio_request_expired);
            }
        } else if (TextUtils.isEmpty(str)) {
        } else {
            if (this.i.cu) {
                this.i.cu = false;
            } else if (!this.i.aA() && !this.i.aC()) {
                this.i.U();
                this.i.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PlayingRTCManager.this.i.ai();
                        PlayingRTCManager.this.a(str, str2, str3, i);
                    }
                });
            } else {
                a(str, str2, str3, i);
                if (!this.i.aB() || this.i.ca.a()) {
                    return;
                }
                this.i.cd.i();
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f(str);
        LiveMsgSendManager.a().d("开始拉主播流");
        this.i.aj.setVisibility(0);
        this.i.av.setVisibility(0);
        ZegoCommonHelper.b().c().startPlayingStream(str, this.i.av);
        ZegoCommonHelper.b().c().setViewMode(1, str);
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f(str);
        n();
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        a2.d("开始拉流 playId：" + str + " -- index:" + i);
        Log.v("==record", "使用zego拉流 playId:" + str + " -- index:" + i);
        if (i == 1) {
            if ((this.i.aw.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.i.aw.getTag(R.id.zego_texture_id), str)) {
                Log.v("==record", "playId not equal C:" + str);
                this.i.ao();
            }
            this.i.ak.setVisibility(0);
            this.i.aw.setVisibility(0);
            this.i.aw.setTag(R.id.zego_texture_id, str);
            ZegoCommonHelper.b().c().startPlayingStream(str, this.i.aw);
            ZegoCommonHelper.b().c().setViewMode(1, str);
        } else if (i == 2) {
            if ((this.i.ax.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.i.ax.getTag(R.id.zego_texture_id), str)) {
                Log.v("==record", "playId not equal D:" + str);
                this.i.ap();
            }
            this.i.al.setVisibility(0);
            this.i.ax.setVisibility(0);
            this.i.ax.setTag(R.id.zego_texture_id, str);
            ZegoCommonHelper.b().c().startPlayingStream(str, this.i.ax);
            ZegoCommonHelper.b().c().setViewMode(1, str);
        } else if (i == 3) {
            if ((this.i.ay.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.i.ay.getTag(R.id.zego_texture_id), str)) {
                Log.v("==record", "playId not equal E:" + str);
                this.i.aq();
            }
            this.i.am.setVisibility(0);
            this.i.ay.setVisibility(0);
            this.i.ay.setTag(R.id.zego_texture_id, str);
            ZegoCommonHelper.b().c().startPlayingStream(str, this.i.ay);
            ZegoCommonHelper.b().c().setViewMode(1, str);
        } else if (i != 4) {
        } else {
            if ((this.i.az.getTag(R.id.zego_texture_id) instanceof String) && !TextUtils.equals((String) this.i.az.getTag(R.id.zego_texture_id), str)) {
                Log.v("==record", "playId not equal F:" + str);
                this.i.ar();
            }
            this.i.an.setVisibility(0);
            this.i.az.setVisibility(0);
            this.i.az.setTag(R.id.zego_texture_id, str);
            ZegoCommonHelper.b().c().startPlayingStream(str, this.i.az);
            ZegoCommonHelper.b().c().setViewMode(1, str);
        }
    }

    public void a(String str, String str2) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.l.size()) {
                i = -1;
                break;
            } else if (TextUtils.equals(str, this.l.get(i))) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= 0) {
            this.l.remove(i);
        }
        ZegoMixStreamHelper.a().b(str2, "");
        n();
        ZegoCommonHelper.b().c().stopPlayingStream(str);
    }

    public void a(String str, final String str2, final String str3, int i) {
        Log.v("==record", "startJoinLiveAnchor");
        o();
        ZegoCommonHelper.b().c().setVideoMirrorMode(0, 0);
        ZegoCommonHelper.b().c().loginRoom(str, 1, new IZegoLoginCompletionCallback() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.4
            @Override // com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback
            public void onLoginCompletion(int i2, ZegoStreamInfo[] zegoStreamInfoArr) {
                Log.v("==record", "onLoginCompletion err:" + i2);
                if (i2 != 0) {
                    AppMethods.a((CharSequence) "登录zego房间失败");
                    return;
                }
                PlayingRTCManager.this.g(str2);
                if (PlayingRTCManager.this.i.aA() || PlayingRTCManager.this.i.aC()) {
                    Log.v("==record", "make friend or make lover");
                    return;
                }
                PlayingRTCManager.this.a(str3);
                if (PlayingRTCManager.this.i.L != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList.add(LiveRoomInfo.a().f());
                    arrayList.add(LiveRoomManager.a().g());
                    arrayList2.add(LiveRoomManager.a().e());
                    ZegoMixStreamHelper.a().a(arrayList, arrayList2);
                    PlayingRTCManager.this.i.L.n();
                }
            }
        });
    }

    public void a(short s, long j, int i) {
        ChatManager.getInstance().applyJoinLive(s, j, i);
    }

    public void a(boolean z, int i) {
        Log.i("record", "markMakeLoverMic:" + z + "mMicOpen:" + this.o);
        ImageView imageView = (ImageView) this.g.findViewById(R.id.iv_mic);
        if (this.o) {
            imageView.setVisibility(0);
            if (z) {
                int i2 = i % 3;
                if (i2 == 0) {
                    imageView.setImageResource(R.drawable.live_mic_voice_1);
                } else if (i2 == 1) {
                    imageView.setImageResource(R.drawable.live_mic_voice_2);
                } else if (i2 == 2) {
                    imageView.setImageResource(R.drawable.live_mic_voice_3);
                }
            } else {
                imageView.setImageResource(R.drawable.live_mic_voice_3);
            }
        } else {
            imageView.setVisibility(8);
        }
        q();
    }

    public void b() {
        b(false, 2);
    }

    public void b(String str) {
        Log.i("==record", "markMakeLoverAvatarIfNetUrl" + str);
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            c(str);
            return;
        }
        Log.i("==record", "markMakeLoverAvatar from http");
        a(str, new FileHttpResponseHandler() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.11
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(File file) {
                PlayingRTCManager.this.c(file.getAbsolutePath());
            }
        });
    }

    public void b(boolean z, int i) {
        ImageView imageView = (ImageView) this.h.findViewById(R.id.iv_mic);
        if (this.o) {
            imageView.setVisibility(0);
            if (z) {
                int i2 = i % 3;
                if (i2 == 0) {
                    imageView.setImageResource(R.drawable.live_mic_voice_1);
                } else if (i2 == 1) {
                    imageView.setImageResource(R.drawable.live_mic_voice_2);
                } else if (i2 == 2) {
                    imageView.setImageResource(R.drawable.live_mic_voice_3);
                }
            } else {
                imageView.setImageResource(R.drawable.live_mic_voice_3);
            }
        } else {
            imageView.setVisibility(8);
        }
        r();
    }

    public void c() {
        this.o = false;
        ZegoCommonHelper.b().c().enableMic(false);
        if (this.i.aD()) {
            a(false, 0);
        } else if (this.i.aB()) {
            b(false, 0);
        }
    }

    public void c(String str) {
        Log.i("==record", "markMakeLoverAvatar:" + str);
        ImageView imageView = (ImageView) this.g.findViewById(R.id.iv_avatar);
        Bitmap decodeResource = TextUtils.isEmpty(str) ? BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.user_bg_round) : LiveBitmapUtils.a(str, 360);
        if (decodeResource == null) {
            Log.i("==record==", "bitmap is null");
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageBitmap(decodeResource);
        }
        ImageView imageView2 = (ImageView) this.g.findViewById(R.id.iv_mic);
        if (this.o) {
            imageView2.setVisibility(0);
            imageView2.setImageResource(R.drawable.live_mic_voice_3);
        } else {
            imageView2.setVisibility(8);
        }
        q();
        if (this.k) {
            return;
        }
        Log.i("==record", "enableCamera true");
        ZegoCommonHelper.b().c().enableCamera(true);
        this.k = true;
    }

    public void d() {
        this.o = true;
        ZegoCommonHelper.b().c().enableMic(true);
        if (this.i.aD()) {
            a(false, 0);
        } else if (this.i.aB()) {
            b(false, 0);
        }
    }

    public void d(String str) {
        Log.i("==record", "markMakeFriendAvatarIfNetUrl" + str);
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            e(str);
        } else {
            a(str, new FileHttpResponseHandler() { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.12
                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                /* renamed from: a */
                public void onSuccess(File file) {
                    PlayingRTCManager.this.e(file.getAbsolutePath());
                }
            });
        }
    }

    public void e() {
        LiveRoomHttpUtils.p(new BluedUIHttpResponse(this.i.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.PlayingRTCManager.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        });
    }

    public void e(String str) {
        Log.i("==record", "markMakeFriendAvatar:" + str);
        ImageView imageView = (ImageView) this.h.findViewById(R.id.iv_avatar);
        imageView.setVisibility(0);
        Bitmap decodeResource = TextUtils.isEmpty(str) ? BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.user_bg_round) : LiveBitmapUtils.a(str, 360);
        if (decodeResource != null) {
            imageView.setImageBitmap(decodeResource);
        }
        ImageView imageView2 = (ImageView) this.h.findViewById(R.id.iv_mic);
        if (this.o) {
            imageView2.setVisibility(0);
            imageView2.setImageResource(R.drawable.live_mic_voice_3);
        } else {
            imageView2.setVisibility(8);
        }
        r();
        if (this.k) {
            return;
        }
        Log.i("==record", "enableCamera true");
        ZegoCommonHelper.b().c().enableCamera(true);
        this.k = true;
    }

    public void f() {
        if (this.m) {
            for (String str : this.l) {
                ZegoCommonHelper.b().c().stopPlayingStream(str);
                Log.v("==record", "停止拉流id:" + str);
            }
            this.l.clear();
            n();
            this.m = false;
        }
    }

    public void f(String str) {
        boolean z = false;
        for (String str2 : this.l) {
            if (TextUtils.equals(str2, str)) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        this.l.add(str);
    }

    public void g() {
        ZegoCommonHelper.b().c().logoutRoom();
        ZegoSoundLevelMonitor.getInstance().stop();
        f();
        if (this.n) {
            ZegoCommonHelper.b().c().stopPreview();
            ZegoCommonHelper.b().c().stopPublishing();
        }
        ZegoCommonHelper.b().i();
    }

    public void h() {
        j();
        ZegoCommonHelper.b().c().stopPreview();
        ZegoCommonHelper.b().c().stopPublishing();
        this.n = false;
        f();
        ZegoCommonHelper.b().c().logoutRoom();
    }

    public void i() {
        Log.i("==record", "markMakeFriendVideo");
        ((ImageView) this.h.findViewById(R.id.iv_avatar)).setVisibility(8);
        ImageView imageView = (ImageView) this.h.findViewById(R.id.iv_mic);
        if (this.o) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.live_mic_voice_3);
        } else {
            imageView.setVisibility(8);
        }
        r();
        if (this.k) {
            return;
        }
        Log.i("==makelover", "enableCamera true");
        ZegoCommonHelper.b().c().enableCamera(true);
        this.k = true;
    }

    public void j() {
        Log.i("==record", "clearMark");
        Rect rect = new Rect(0, 0, 0, 0);
        ZegoLiveRoom.setWaterMarkImagePath("");
        ZegoLiveRoom.setPreviewWaterMarkRect(rect);
        ZegoLiveRoom.setPublishWaterMarkRect(rect);
    }

    public void k() {
        Log.i("==record", "switchVideoStreaming");
        i();
    }

    public void l() {
        Log.i("==record", "switchPictureStreaming");
        d(this.i.bY.i);
    }

    public String m() {
        int i = this.b + 1;
        this.b = i;
        if (i >= 10000) {
            this.b = 0;
        }
        File externalFilesDir = AppInfo.d().getExternalFilesDir(null);
        String str = "push_image_" + (this.b % 4);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "img");
            if (file.exists() || file.mkdirs()) {
                return new File(file, str).getAbsolutePath();
            }
        }
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file2 = new File(filesDir, "img");
            if (file2.exists() || file2.mkdirs()) {
                return new File(file2, str).getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public void n() {
        Log.i("==iop", "reportZegoRtcTime0 mPlayStreamIDList size:" + this.l.size() + "  uid:" + ZegoMixStreamHelper.a().d() + " lid:" + ZegoMixStreamHelper.a().e() + "  startTime:" + this.f13727c + " endTime:" + this.d);
        if (this.p > 0 && this.f13727c != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.d = currentTimeMillis;
            long j = currentTimeMillis - this.f13727c;
            int i = this.p + 1;
            this.e = ((i - 1) * j) + (i * j);
            Log.i("==iop", "reportZegoRtcTime1 value:" + j + " size:" + i + " duration:" + this.e + "  uid:" + ZegoMixStreamHelper.a().d() + " lid:" + ZegoMixStreamHelper.a().e() + "  startTime:" + this.f13727c + " endTime:" + this.d);
            if (this.e > 2) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_CALL_END, ZegoMixStreamHelper.a().d(), ZegoMixStreamHelper.a().e(), this.f13727c, this.d, this.e);
            }
        }
        if (this.l.size() > 0) {
            this.f13727c = System.currentTimeMillis() / 1000;
            ZegoMixStreamHelper.a().f();
        } else {
            this.f13727c = 0L;
            ZegoMixStreamHelper.a().g();
        }
        this.p = this.l.size();
    }
}
