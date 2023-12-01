package com.soft.blued.ui.find.manager;

import com.soft.blued.ui.msg.model.ChannelModel;
import com.zego.zegoliveroom.ZegoLiveRoom;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/FlashZegoApiManager.class */
public class FlashZegoApiManager {
    private static FlashZegoApiManager d;

    /* renamed from: a  reason: collision with root package name */
    public ChannelModel f30596a;
    private ZegoLiveRoom e;
    private boolean f;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    long b = 3170513794L;

    /* renamed from: c  reason: collision with root package name */
    byte[] f30597c = {-98, -126, -116, 45, -18, -101, -67, 14, 2, 90, -85, 54, -84, 63, 45, -111, -110, 33, -9, -74, -109, -121, 18, 8, -127, 75, -62, 24, -115, -69, -70, -28};

    private FlashZegoApiManager() {
        this.e = null;
        this.e = new ZegoLiveRoom();
    }

    public static FlashZegoApiManager a() {
        if (d == null) {
            synchronized (FlashZegoApiManager.class) {
                try {
                    if (d == null) {
                        d = new FlashZegoApiManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public void a(ChannelModel channelModel) {
        this.f30596a = channelModel;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public ZegoLiveRoom b() {
        return this.e;
    }

    public void c() {
        if (e()) {
            ZegoLiveRoom b = a().b();
            if (b != null) {
                b.enableMic(false);
                b.enableCamera(false);
                b.setPreviewView(null);
                b.setZegoLivePublisherCallback(null);
                b.setZegoLivePlayerCallback(null);
                b.setZegoRoomCallback(null);
                b.setZegoIMCallback(null);
                b.logoutRoom();
                BizLivePresenter.a().a((OnLiveRoomListener) null);
                BizLivePresenter.a().a((OnVideoLiveListener) null);
            }
            a(false);
        }
    }

    public void d() {
        if (!e() || a().b() == null) {
            return;
        }
        this.e.pauseModule(12);
    }

    public boolean e() {
        return this.f;
    }
}
