package com.blued.android.module.live.im;

import android.content.Context;
import android.text.TextUtils;
import cn.irisgw.live.LiveChatOuterClass;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.android.module.live.im.biz.LiveChat;
import com.blued.android.module.live.im.biz.LiveConnector;
import com.qiniu.android.dns.DnsManager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/LiveIM.class */
public class LiveIM {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ChannelManager f11582a;
    private static volatile LiveConnector b;

    /* renamed from: c  reason: collision with root package name */
    private static final IMThreadManager f11583c = new IMThreadManager(3, 10);
    private static LiveChat d;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/LiveIM$OnSendLikeFinishListener.class */
    public interface OnSendLikeFinishListener {
        void onFinish(LiveChatOuterClass.LiveLikeResponse liveLikeResponse);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/LiveIM$OnSendMessageFinishListener.class */
    public interface OnSendMessageFinishListener {
        void onFinish(LiveChatOuterClass.LiveMsgResponse liveMsgResponse);
    }

    private LiveIM() {
    }

    public static void a(Context context, String str, DnsManager dnsManager) {
        synchronized (LiveIM.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (b == null || f11582a == null || !f11582a.a().equals(str)) {
                    if (b != null) {
                        b.f();
                        b = null;
                    }
                    if (f11582a != null) {
                        f11582a.c();
                        f11582a = null;
                    }
                    f11582a = new ChannelManager(context, str, 443, dnsManager);
                    b = new LiveConnector(f11582a);
                    b.a("blued-grpc-live-im");
                    b.a(false);
                    b.b(false);
                    d = null;
                }
            } finally {
            }
        }
    }

    public static void a(LiveChatOuterClass.LiveLikeRequest liveLikeRequest, OnSendLikeFinishListener onSendLikeFinishListener) {
        d();
        LiveChat liveChat = d;
        if (liveChat != null) {
            liveChat.a(liveLikeRequest, onSendLikeFinishListener);
        }
    }

    public static void a(LiveChatOuterClass.LiveMsgRequest liveMsgRequest, OnSendMessageFinishListener onSendMessageFinishListener) {
        d();
        LiveChat liveChat = d;
        if (liveChat != null) {
            liveChat.a(liveMsgRequest, onSendMessageFinishListener);
        }
    }

    public static void a(OnConnectStateListener onConnectStateListener) {
        if (b != null) {
            b.a(onConnectStateListener);
        }
    }

    public static void a(String str) {
        String str2;
        if (f11582a != null) {
            ChannelManager channelManager = f11582a;
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = "Bearer " + str;
            }
            channelManager.a("Authorization", str2);
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        if (b != null) {
            b.a(str, str2, str3, str4);
        }
    }

    public static void a(boolean z) {
        LiveIMConfig.a(z);
    }

    public static boolean a() {
        return f11582a != null;
    }

    public static void b() {
        if (b != null) {
            b.e();
        }
    }

    public static void b(OnConnectStateListener onConnectStateListener) {
        if (b != null) {
            b.b(onConnectStateListener);
        }
    }

    public static void c() {
        if (b != null) {
            b.f();
        }
    }

    private static void d() {
        if (f11582a == null || d != null) {
            return;
        }
        d = new LiveChat(f11582a, f11583c);
    }
}
