package com.blued.android.module.im.biz.req;

import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.im.private_chat.ReqTypeOuterClass;
import com.blued.im.req.ReqGrpc;
import com.blued.im.req.ReqOuterClass;
import io.grpc.MethodDescriptor;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/req/DeleteBurnMessage.class */
public class DeleteBurnMessage extends GrpcUnaryCall {
    public DeleteBurnMessage(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        super(channelManager, iMThreadManager);
        b().b = ReqTypeOuterClass.ReqType.ReqDelBurnMsg.name();
    }

    @Override // com.blued.android.module.im.grpc.GrpcUnaryCall
    public MethodDescriptor a() {
        return ReqGrpc.getDelBurnMsgMethod();
    }

    public void a(short s, int i, int i2, long j, GrpcUnaryCall.OnFinishListener onFinishListener) {
        a(ReqOuterClass.Request.newBuilder().setCommon(Common.a().b()).setUserId(i).setLocalId(i2).setReqType(ReqTypeOuterClass.ReqType.ReqDelBurnMsg.getNumber()).setBody(ReqOuterClass.RequestBody.newBuilder().setSessionId(i).setSessionType(s).setMsgId(j).build()).build(), onFinishListener);
    }
}
