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
import io.grpc.internal.GrpcUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/LiveIM.class */
public class LiveIM {
    private static volatile ChannelManager a;
    private static volatile LiveConnector b;
    private static final IMThreadManager c = new IMThreadManager(3, 10);
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
                if (b == null || a == null || !a.a().equals(str)) {
                    if (b != null) {
                        b.f();
                        b = null;
                    }
                    if (a != null) {
                        a.c();
                        a = null;
                    }
                    a = new ChannelManager(context, str, GrpcUtil.DEFAULT_PORT_SSL, dnsManager);
                    b = new LiveConnector(a);
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
        if (a != null) {
            ChannelManager channelManager = a;
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
        return a != null;
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
        if (a == null || d != null) {
            return;
        }
        d = new LiveChat(a, c);
    }
}
