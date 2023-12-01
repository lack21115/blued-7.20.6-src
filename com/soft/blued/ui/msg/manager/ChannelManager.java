package com.soft.blued.ui.msg.manager;

import android.app.Activity;
import com.blued.android.chat.VideoChatHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.ChannelFragment;
import com.soft.blued.ui.msg.VideoChat.BD1V1Config;
import com.soft.blued.ui.msg.VideoChat.IVideoChatListener;
import com.soft.blued.ui.msg.VideoChat.VideoChatTools;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/ChannelManager.class */
public class ChannelManager implements VideoChatHelper.CallInfoListener, VideoChatHelper.CallListener {

    /* renamed from: a  reason: collision with root package name */
    public VideoChatHelper f18699a;
    private Activity d;
    private ChannelModel e;
    private int f;
    private String g;
    private int h;
    private int i;
    private String j;
    private ChannelFragment k;
    private VideoChatTools l;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public long f18700c = 0;
    private String m = "434b4c6598e4427a8a15ab18f08780e6";
    private long n = 3170513794L;
    private byte[] o = {-98, -126, -116, 45, -18, -101, -67, 14, 2, 90, -85, 54, -84, 63, 45, -111, -110, 33, -9, -74, -109, -121, 18, 8, -127, 75, -62, 24, -115, -69, -70, -28};

    public ChannelManager(ChannelFragment channelFragment, ChannelModel channelModel) {
        this.g = "";
        this.k = channelFragment;
        this.e = channelModel;
        this.d = channelFragment.getActivity();
        this.f = channelModel.callType;
        this.g = channelModel.channelId;
        this.i = channelModel.remoteUid;
        this.j = "stream_" + this.g + "_" + (System.currentTimeMillis() / 1000);
        try {
            this.h = Integer.parseInt(UserInfo.getInstance().getLoginUserInfo().getUid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.l = new VideoChatTools(this.d, new BD1V1Config(channelModel.chat_sdk_type, this.o, this.n, this.m, channelFragment.b, channelFragment.f17972c), new IVideoChatListener() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.1

            /* renamed from: com.soft.blued.ui.msg.manager.ChannelManager$1$5  reason: invalid class name */
            /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/ChannelManager$1$5.class */
            class AnonymousClass5 implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ AnonymousClass1 f18706a;

                @Override // java.lang.Runnable
                public void run() {
                    ChannelManager.this.k.a(false);
                }
            }

            @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatListener
            public void a() {
                ChannelManager.this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelManager.this.k.f17972c.performClick();
                    }
                });
            }

            @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatListener
            public void b() {
                ChannelManager.this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelManager.this.k.b();
                        ChannelManager.this.k.f17972c.performClick();
                    }
                });
            }

            @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatListener
            public void c() {
                ChannelManager.this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelManager.this.k.a();
                    }
                });
            }

            @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatListener
            public void d() {
                ChannelManager.this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelManager.this.k.f();
                    }
                });
            }
        });
        int i = this.f;
        if (i == 0) {
            this.f18699a = new VideoChatHelper(VideoChatHelper.ROLE.CALLER, this.i, this.g, 2, channelModel.chat_sdk_type, this, (VideoChatHelper.CallMsgListener) null);
        } else if (i == 1) {
            this.f18699a = new VideoChatHelper(VideoChatHelper.ROLE.CALLER, this.i, this.g, 1, channelModel.chat_sdk_type, this, (VideoChatHelper.CallMsgListener) null);
        } else if (i == 2) {
            this.f18699a = new VideoChatHelper(VideoChatHelper.ROLE.RECEIVER, this.i, this.g, 2, channelModel.chat_sdk_type, this, (VideoChatHelper.CallMsgListener) null);
        } else if (i == 3) {
            this.f18699a = new VideoChatHelper(VideoChatHelper.ROLE.RECEIVER, this.i, this.g, 1, channelModel.chat_sdk_type, this, (VideoChatHelper.CallMsgListener) null);
        }
        int i2 = this.f;
        if (i2 == 0) {
            a();
        } else if (i2 == 1) {
            b();
        }
    }

    private void k() {
        VideoChatHelper videoChatHelper = this.f18699a;
        if (videoChatHelper != null) {
            videoChatHelper.report(this.j);
        }
        this.l.a(this.g, this.h, this.j);
    }

    public void a() {
        c();
        this.f18700c = System.currentTimeMillis() / 1000;
        this.b = "video";
        if (this.k.f17972c.getChildCount() == 0) {
            k();
        }
    }

    public void a(Activity activity) {
        this.l.e();
    }

    public void a(boolean z) {
        this.l.a(z);
    }

    public void b() {
        d();
        this.f18700c = System.currentTimeMillis() / 1000;
        this.b = "voice";
        if (this.k.f17972c.getChildCount() == 0) {
            k();
        }
    }

    public void b(Activity activity) {
        this.l.f();
    }

    public void b(boolean z) {
        this.l.b(z);
    }

    public void c() {
        this.l.c();
    }

    public void c(Activity activity) {
        this.l.g();
    }

    public void call() {
        this.f18699a.call(this);
    }

    public void d() {
        this.l.i();
    }

    public void e() {
        this.l.d();
    }

    public void f() {
        this.l.j();
    }

    public void g() {
        h();
        this.l.a();
    }

    public void h() {
        if (this.f18700c > 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            EventTrackMessage.a(MessageProtos.Event.MSG_1V1_END, String.valueOf(this.i), this.f18700c, currentTimeMillis, currentTimeMillis - this.f18700c, this.b);
            this.f18700c = 0L;
        }
    }

    public void i() {
        this.l.b();
    }

    public void j() {
        this.l.h();
    }

    public void onCallClose(final int i) {
        this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.b(ChannelFragment.f17971a, "onCallClose===");
                ChannelManager.this.k.a(i);
            }
        });
    }

    public void onCallFailed(final VideoChatHelper.CallFailed callFailed, final String str, int i) {
        this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.b(ChannelFragment.f17971a, "onCallFailed===");
                ChannelManager.this.k.a(callFailed, str);
            }
        });
    }

    public void onCallLeftTime(final int i, int i2) {
        this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.6
            @Override // java.lang.Runnable
            public void run() {
                Logger.b(ChannelFragment.f17971a, "onCallLeftTime===");
                ChannelManager.this.k.b(i);
            }
        });
    }

    public void onCallLeftTimeFail() {
    }

    public void onCallSuccess(int i, int i2, boolean z, String str, int i3) {
        this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.b(ChannelFragment.f17971a, "onCallSuccess===");
                ChannelManager.this.k.c();
            }
        });
    }

    public void onSwitchToAudio() {
        this.k.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.manager.ChannelManager.5
            @Override // java.lang.Runnable
            public void run() {
                Logger.b(ChannelFragment.f17971a, "onSwitchToAudio===");
                ChannelManager.this.k.b(true);
            }
        });
    }
}
