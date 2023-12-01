package com.blued.android.module.im;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.im.biz.AudioChatroom;
import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.biz.IMConnector;
import com.blued.android.module.im.biz.IMConnectorDebuger;
import com.blued.android.module.im.biz.privatechat.Chat1v1;
import com.blued.android.module.im.biz.privatechat.GroupChat;
import com.blued.android.module.im.biz.privatechat.OnPrivateChatResponseListener;
import com.blued.android.module.im.biz.privatechat.PrivateChat;
import com.blued.android.module.im.biz.receipt.DeleteAllSession;
import com.blued.android.module.im.biz.receipt.DeleteMessage;
import com.blued.android.module.im.biz.receipt.DeleteSession;
import com.blued.android.module.im.biz.receipt.ReceiptGot;
import com.blued.android.module.im.biz.receipt.ReceiptRead;
import com.blued.android.module.im.biz.receipt.ReceiptRetract;
import com.blued.android.module.im.biz.req.DeleteBurnMessage;
import com.blued.android.module.im.biz.req.GetSessionInfo;
import com.blued.android.module.im.biz.sync.Sync;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.blued.im.private_chat.Chat1V1;
import com.blued.im.private_chat.ReceiptOuterClass;
import com.blued.im.sync.SyncOuterClass;
import com.google.protobuf.Any;
import com.qiniu.android.dns.DnsManager;
import io.grpc.internal.GrpcUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/IM.class */
public final class IM {
    private static volatile ChannelManager a;
    private static volatile IMConnector b;
    private static final IMThreadManager c = new IMThreadManager(4, 10);

    private IM() {
    }

    public static void a() {
        if (b != null) {
            b.e();
        }
    }

    public static void a(int i, int i2, int i3, int i4, Any any, OnPrivateChatResponseListener onPrivateChatResponseListener) {
        if (a != null) {
            new PrivateChat(a, c).a(i, i2, i3, i4, any, onPrivateChatResponseListener);
        }
    }

    public static void a(Context context, String str, DnsManager dnsManager) {
        synchronized (IM.class) {
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
                    b = new IMConnector(a);
                    b.a("blued-grpc-im");
                    b.b(true);
                    b.a(true);
                    b.a(IMConnectorDebuger.a());
                }
            } finally {
            }
        }
    }

    public static void a(OnConnectStateListener onConnectStateListener) {
        if (b != null) {
            b.a(onConnectStateListener);
        }
    }

    public static void a(AudioChatroomOuterClass.Request.Builder builder, AudioChatroom.OnAudioChatroomResponseListener onAudioChatroomResponseListener) {
        if (a != null) {
            new AudioChatroom(a, c).a(builder, onAudioChatroomResponseListener);
        }
    }

    public static void a(Chat1V1.Chat1v1Request chat1v1Request, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new Chat1v1(a, c).a(chat1v1Request, onFinishListener);
        }
    }

    public static void a(ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new DeleteAllSession(a, c).a(receiptRequest, onFinishListener);
        }
    }

    public static void a(SyncOuterClass.SyncRequest syncRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new Sync(a, c).a(syncRequest, onFinishListener);
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

    public static void a(short s, int i, int i2, long j, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new DeleteBurnMessage(a, c).a(s, i, i2, j, onFinishListener);
        }
    }

    public static void a(short s, int i, int i2, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new GetSessionInfo(a, c).a(s, i, i2, onFinishListener);
        }
    }

    public static void a(boolean z) {
        IMConfig.a(z);
    }

    public static void a(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new ReceiptGot(a, c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static void b() {
        if (b != null) {
            b.f();
        }
    }

    public static void b(int i, int i2, int i3, int i4, Any any, OnPrivateChatResponseListener onPrivateChatResponseListener) {
        if (a != null) {
            new GroupChat(a, c).a(i, i2, i3, i4, any, onPrivateChatResponseListener);
        }
    }

    public static void b(OnConnectStateListener onConnectStateListener) {
        if (b != null) {
            b.b(onConnectStateListener);
        }
    }

    public static void b(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new ReceiptRead(a, c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static Common c() {
        return Common.a();
    }

    public static void c(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new ReceiptRetract(a, c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static void d(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new DeleteMessage(a, c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static void e(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (a != null) {
            new DeleteSession(a, c, z).a(receiptRequest, onFinishListener);
        }
    }
}
