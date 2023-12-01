package com.blued.android.module.im.biz.receipt;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.im.private_chat.ReceiptGrpc;
import io.grpc.MethodDescriptor;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/receipt/DeleteSession.class */
public class DeleteSession extends GrpcUnaryCall {
    public DeleteSession(ChannelManager channelManager, IMThreadManager iMThreadManager, boolean z) {
        super(channelManager, iMThreadManager, z);
        b().b = DeleteSession.class.getName();
    }

    @Override // com.blued.android.module.im.grpc.GrpcUnaryCall
    public MethodDescriptor a() {
        return ReceiptGrpc.getDelSessionMethod();
    }
}
