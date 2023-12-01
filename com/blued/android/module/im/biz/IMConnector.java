package com.blued.android.module.im.biz;

import com.blued.android.module.im.IMConfig;
import com.blued.android.module.im.grpc.BaseConnector;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.das.apm.ApmProtos;
import com.blued.im.ConnectorGrpc;
import com.blued.im.ConnectorOuterClass;
import com.google.protobuf.Any;
import io.grpc.MethodDescriptor;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/IMConnector.class */
public final class IMConnector extends BaseConnector {
    public IMConnector(ChannelManager channelManager) {
        super(channelManager);
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public ApmProtos.GrpcConnectTypeProto.BUSINESS a() {
        return ApmProtos.GrpcConnectTypeProto.BUSINESS.PRIVATE_CHAT;
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public Any a(Any any) {
        IMConnectorDebuger.a("connector receive ok");
        IMConnectorDebuger.b();
        Any any2 = any;
        if (any.is(ConnectorOuterClass.PingPackage.class)) {
            b(Any.pack(ConnectorOuterClass.PongPackage.newBuilder().build()));
            any2 = null;
        }
        return any2;
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public boolean b() {
        return IMConfig.b();
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public MethodDescriptor c() {
        return ConnectorGrpc.getConnectMethod();
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public void d() {
        b(Any.pack(ConnectorOuterClass.PingPackage.newBuilder().build()));
    }
}
