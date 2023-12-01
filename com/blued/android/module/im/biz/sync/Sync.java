package com.blued.android.module.im.biz.sync;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.im.sync.SyncGrpc;
import com.blued.im.sync.SyncOuterClass;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.MethodDescriptor;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/sync/Sync.class */
public class Sync extends GrpcUnaryCall {
    public Sync(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        super(channelManager, iMThreadManager);
    }

    @Override // com.blued.android.module.im.grpc.GrpcUnaryCall
    public MethodDescriptor a() {
        return SyncGrpc.getSyncMethod();
    }

    public void a(SyncOuterClass.SyncRequest syncRequest, GrpcUnaryCall.OnFinishListener onFinishListener) {
        b().b = syncRequest.getSyncType().name();
        super.a((GeneratedMessageV3) syncRequest, onFinishListener);
    }
}
