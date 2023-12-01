package com.blued.android.module.im.biz.privatechat;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.im.private_chat.Chat1V1;
import com.blued.im.private_chat.HermesChat1v1Grpc;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.MethodDescriptor;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/privatechat/Chat1v1.class */
public class Chat1v1 extends GrpcUnaryCall {
    public Chat1v1(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        super(channelManager, iMThreadManager);
    }

    @Override // com.blued.android.module.im.grpc.GrpcUnaryCall
    public MethodDescriptor a() {
        return HermesChat1v1Grpc.getChat1v1SendMethod();
    }

    public void a(Chat1V1.Chat1v1Request chat1v1Request, GrpcUnaryCall.OnFinishListener onFinishListener) {
        b().b = chat1v1Request.getReqType().name();
        super.a((GeneratedMessageV3) chat1v1Request, onFinishListener);
    }
}
