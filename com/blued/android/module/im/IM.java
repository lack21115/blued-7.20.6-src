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

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/IM.class */
public final class IM {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ChannelManager f11329a;
    private static volatile IMConnector b;

    /* renamed from: c  reason: collision with root package name */
    private static final IMThreadManager f11330c = new IMThreadManager(4, 10);

    private IM() {
    }

    public static void a() {
        if (b != null) {
            b.e();
        }
    }

    public static void a(int i, int i2, int i3, int i4, Any any, OnPrivateChatResponseListener onPrivateChatResponseListener) {
        if (f11329a != null) {
            new PrivateChat(f11329a, f11330c).a(i, i2, i3, i4, any, onPrivateChatResponseListener);
        }
    }

    public static void a(Context context, String str, DnsManager dnsManager) {
        synchronized (IM.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (b == null || f11329a == null || !f11329a.a().equals(str)) {
                    if (b != null) {
                        b.f();
                        b = null;
                    }
                    if (f11329a != null) {
                        f11329a.c();
                        f11329a = null;
                    }
                    f11329a = new ChannelManager(context, str, 443, dnsManager);
                    b = new IMConnector(f11329a);
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
        if (f11329a != null) {
            new AudioChatroom(f11329a, f11330c).a(builder, onAudioChatroomResponseListener);
        }
    }

    public static void a(Chat1V1.Chat1v1Request chat1v1Request, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new Chat1v1(f11329a, f11330c).a(chat1v1Request, onFinishListener);
        }
    }

    public static void a(ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new DeleteAllSession(f11329a, f11330c).a(receiptRequest, onFinishListener);
        }
    }

    public static void a(SyncOuterClass.SyncRequest syncRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new Sync(f11329a, f11330c).a(syncRequest, onFinishListener);
        }
    }

    public static void a(String str) {
        String str2;
        if (f11329a != null) {
            ChannelManager channelManager = f11329a;
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = "Bearer " + str;
            }
            channelManager.a("Authorization", str2);
        }
    }

    public static void a(short s, int i, int i2, long j, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new DeleteBurnMessage(f11329a, f11330c).a(s, i, i2, j, onFinishListener);
        }
    }

    public static void a(short s, int i, int i2, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new GetSessionInfo(f11329a, f11330c).a(s, i, i2, onFinishListener);
        }
    }

    public static void a(boolean z) {
        IMConfig.a(z);
    }

    public static void a(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new ReceiptGot(f11329a, f11330c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static void b() {
        if (b != null) {
            b.f();
        }
    }

    public static void b(int i, int i2, int i3, int i4, Any any, OnPrivateChatResponseListener onPrivateChatResponseListener) {
        if (f11329a != null) {
            new GroupChat(f11329a, f11330c).a(i, i2, i3, i4, any, onPrivateChatResponseListener);
        }
    }

    public static void b(OnConnectStateListener onConnectStateListener) {
        if (b != null) {
            b.b(onConnectStateListener);
        }
    }

    public static void b(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new ReceiptRead(f11329a, f11330c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static Common c() {
        return Common.a();
    }

    public static void c(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new ReceiptRetract(f11329a, f11330c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static void d(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new DeleteMessage(f11329a, f11330c, z).a(receiptRequest, onFinishListener);
        }
    }

    public static void e(boolean z, ReceiptOuterClass.ReceiptRequest receiptRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        if (f11329a != null) {
            new DeleteSession(f11329a, f11330c, z).a(receiptRequest, onFinishListener);
        }
    }
}
