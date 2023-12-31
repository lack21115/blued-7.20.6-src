package com.soft.blued.ui.msg.VideoChat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.sobot.chat.camera.StCameraView;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.util.HashMap;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/VideoChat/VideoChatToolsForZego.class */
public class VideoChatToolsForZego implements IVideoChatTools {

    /* renamed from: a  reason: collision with root package name */
    private static VideoChatToolsForZego f18259a;
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private ZegoLiveRoom f18260c;
    private boolean d = true;
    private ViewGroup e;
    private ViewGroup f;
    private IVideoChatListener g;
    private String h;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this) {
            this.h = str;
            if (this.e != null && this.e.getChildCount() == 0) {
                this.e.addView(new SurfaceView(this.e.getContext()));
            }
            this.f18260c.startPlayingStream(str, this.e.getChildAt(0));
            this.f18260c.setViewMode(1, str);
            if (this.g != null) {
                this.g.b();
                this.g.a();
            }
        }
    }

    public static VideoChatToolsForZego i() {
        if (f18259a == null) {
            f18259a = new VideoChatToolsForZego();
        }
        return f18259a;
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a() {
        this.f18260c.logoutRoom();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a(Activity activity, BD1V1Config bD1V1Config, final IVideoChatListener iVideoChatListener) {
        this.b = activity;
        this.g = iVideoChatListener;
        ZegoLiveRoom.setUser(UserInfo.getInstance().getLoginUserInfo().getUid(), UserInfo.getInstance().getLoginUserInfo().getName());
        ZegoLiveRoom.setTestEnv(!BluedHttpUrl.h());
        ZegoLiveRoom.setBusinessType(0);
        ZegoLiveRoom zegoLiveRoom = new ZegoLiveRoom();
        this.f18260c = zegoLiveRoom;
        if (!zegoLiveRoom.initSDK(bD1V1Config.f18256c, bD1V1Config.b, AppInfo.d())) {
            AppMethods.a("Zego SDK初始化失败!");
        }
        ZegoAvConfig zegoAvConfig = new ZegoAvConfig(2);
        zegoAvConfig.setVideoFPS(15);
        zegoAvConfig.setVideoBitrate(StCameraView.MEDIA_QUALITY_POOR);
        this.f18260c.setAVConfig(zegoAvConfig);
        this.f18260c.enableTrafficControl(0, false);
        ZegoLiveRoom.requireHardwareEncoder(false);
        ZegoLiveRoom.requireHardwareDecoder(false);
        this.f18260c.enableBeautifying(3);
        this.f18260c.setPolishStep(7.0f);
        this.f18260c.setZegoLivePublisherCallback(new IZegoLivePublisherCallback() { // from class: com.soft.blued.ui.msg.VideoChat.VideoChatToolsForZego.1
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
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
            public void onPublishStateUpdate(int i, String str, HashMap<String, Object> hashMap) {
                if (i == 0) {
                    return;
                }
                iVideoChatListener.d();
            }
        });
        this.f18260c.setZegoLivePlayerCallback(new IZegoLivePlayerCallback() { // from class: com.soft.blued.ui.msg.VideoChat.VideoChatToolsForZego.2
            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onInviteJoinLiveRequest(int i, String str, String str2, String str3) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onPlayStateUpdate(int i, String str) {
                if (i == 0) {
                    return;
                }
                iVideoChatListener.d();
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onRecvEndJoinLiveCommand(String str, String str2, String str3) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
            public void onVideoSizeChangedTo(String str, int i, int i2) {
            }
        });
        this.f18260c.setZegoRoomCallback(new IZegoRoomCallback() { // from class: com.soft.blued.ui.msg.VideoChat.VideoChatToolsForZego.3
            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onDisconnect(int i, String str) {
                iVideoChatListener.c();
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onKickOut(int i, String str, String str2) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onNetworkQuality(String str, int i, int i2) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onReconnect(int i, String str) {
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
                if (i == 2001) {
                    VideoChatToolsForZego.this.a(zegoStreamInfoArr[0].streamID);
                } else if (i == 2002) {
                    iVideoChatListener.c();
                }
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onTempBroken(int i, String str) {
            }

            @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
            public void onTokenWillExpired(String str, int i) {
            }
        });
        a(bD1V1Config.e);
        b(bD1V1Config.f);
    }

    public void a(ViewGroup viewGroup) {
        viewGroup.removeAllViews();
        SurfaceView surfaceView = new SurfaceView(viewGroup.getContext());
        viewGroup.addView(surfaceView);
        this.f = viewGroup;
        this.f18260c.setPreviewView(surfaceView);
        this.f18260c.setPreviewViewMode(1);
        this.f18260c.startPreview();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a(String str, int i, final String str2) {
        this.f18260c.loginRoom(str, 2, new IZegoLoginCompletionCallback() { // from class: com.soft.blued.ui.msg.VideoChat.VideoChatToolsForZego.4
            @Override // com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback
            public void onLoginCompletion(int i2, ZegoStreamInfo[] zegoStreamInfoArr) {
                if (i2 != 0) {
                    VideoChatToolsForZego.this.g.d();
                    return;
                }
                VideoChatToolsForZego.this.f18260c.startPublishing(str2, "", 0);
                if (zegoStreamInfoArr == null || zegoStreamInfoArr.length <= 0) {
                    return;
                }
                for (ZegoStreamInfo zegoStreamInfo : zegoStreamInfoArr) {
                    VideoChatToolsForZego.this.a(zegoStreamInfo.streamID);
                }
            }
        });
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a(boolean z) {
        this.f18260c.enableSpeaker(!z);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void b() {
        boolean z = !this.d;
        this.d = z;
        this.f18260c.setFrontCam(z);
    }

    public void b(ViewGroup viewGroup) {
        viewGroup.removeAllViews();
        this.e = viewGroup;
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void b(boolean z) {
        this.f18260c.setBuiltInSpeakerOn(z);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void c() {
        this.f18260c.enableCamera(true);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void d() {
        this.f18260c.enableCamera(false);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void e() {
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void f() {
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void g() {
        if (this.f18260c != null) {
            if (!TextUtils.isEmpty(this.h)) {
                this.f18260c.stopPlayingStream(this.h);
            }
            this.f18260c.setPreviewView(null);
            this.f18260c.stopPreview();
            this.f18260c.stopPublishing();
            this.f18260c.unInitSDK();
            this.f18260c.setZegoLivePublisherCallback(null);
            this.f18260c.setZegoLivePlayerCallback(null);
            this.f18260c.setZegoRoomCallback(null);
        }
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.e.removeAllViews();
        }
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void h() {
    }
}
