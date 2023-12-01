package com.soft.blued.ui.find.manager;

import com.soft.blued.utils.Logger;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/BizLivePresenter.class */
public class BizLivePresenter {

    /* renamed from: a  reason: collision with root package name */
    private static BizLivePresenter f30556a;

    /* renamed from: c  reason: collision with root package name */
    private volatile OnVideoLiveListener f30557c = null;
    private volatile OnLiveRoomListener d = null;
    private volatile boolean e = false;
    private volatile boolean f = false;
    private ZegoLiveRoom b = FlashZegoApiManager.a().b();

    /* renamed from: com.soft.blued.ui.find.manager.BizLivePresenter$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/BizLivePresenter$1.class */
    class AnonymousClass1 implements IZegoLivePublisherCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BizLivePresenter f30558a;

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
            OnVideoLiveListener onVideoLiveListener = this.f30558a.f30557c;
            if (onVideoLiveListener != null) {
                if (i == 0) {
                    onVideoLiveListener.a(str, hashMap);
                    return;
                }
                Logger.b("xpf", "stateCode is 0 to stop publish");
                onVideoLiveListener.a(i, str);
            }
        }
    }

    /* renamed from: com.soft.blued.ui.find.manager.BizLivePresenter$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/BizLivePresenter$2.class */
    class AnonymousClass2 implements IZegoLivePlayerCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BizLivePresenter f30559a;

        @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onInviteJoinLiveRequest(int i, String str, String str2, String str3) {
        }

        @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality) {
        }

        @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayStateUpdate(int i, String str) {
            OnVideoLiveListener onVideoLiveListener = this.f30559a.f30557c;
            if (onVideoLiveListener != null) {
                if (i == 0) {
                    onVideoLiveListener.a(str);
                } else {
                    onVideoLiveListener.b(i, str);
                }
            }
        }

        @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onRecvEndJoinLiveCommand(String str, String str2, String str3) {
        }

        @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onVideoSizeChangedTo(String str, int i, int i2) {
        }
    }

    /* renamed from: com.soft.blued.ui.find.manager.BizLivePresenter$3  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/BizLivePresenter$3.class */
    class AnonymousClass3 implements IZegoRoomCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BizLivePresenter f30560a;

        @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
        public void onDisconnect(int i, String str) {
            OnLiveRoomListener onLiveRoomListener = this.f30560a.d;
            if (onLiveRoomListener != null) {
                onLiveRoomListener.a(i, str);
            }
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
            OnLiveRoomListener onLiveRoomListener = this.f30560a.d;
            if (onLiveRoomListener != null) {
                if (i == 2001) {
                    onLiveRoomListener.a(zegoStreamInfoArr, str);
                } else if (i == 2002) {
                    onLiveRoomListener.b(zegoStreamInfoArr, str);
                }
            }
        }

        @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
        public void onTempBroken(int i, String str) {
        }

        @Override // com.zego.zegoliveroom.callback.IZegoRoomCallback
        public void onTokenWillExpired(String str, int i) {
        }
    }

    private BizLivePresenter() {
    }

    public static BizLivePresenter a() {
        if (f30556a == null) {
            synchronized (BizLivePresenter.class) {
                try {
                    if (f30556a == null) {
                        f30556a = new BizLivePresenter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f30556a;
    }

    public void a(OnLiveRoomListener onLiveRoomListener) {
        this.d = onLiveRoomListener;
    }

    public void a(OnVideoLiveListener onVideoLiveListener) {
        this.f30557c = onVideoLiveListener;
    }
}
