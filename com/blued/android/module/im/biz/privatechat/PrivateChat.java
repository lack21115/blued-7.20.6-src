package com.blued.android.module.im.biz.privatechat;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.das.apm.ApmProtos;
import com.blued.im.private_chat.PrivateChatGrpc;
import com.blued.im.private_chat.PrivateChatOuterClass;
import java.util.concurrent.TimeUnit;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/privatechat/PrivateChat.class */
public final class PrivateChat extends PrivateChatBase {
    public PrivateChat(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        super(channelManager, iMThreadManager);
    }

    @Override // com.blued.android.module.im.biz.privatechat.PrivateChatBase
    protected ApmProtos.GrpcRequestTypeProto.BUSINESS a() {
        return ApmProtos.GrpcRequestTypeProto.BUSINESS.PRIVATE_CHAT;
    }

    @Override // com.blued.android.module.im.biz.privatechat.PrivateChatBase
    public PrivateChatOuterClass.Response a(PrivateChatOuterClass.Request request) {
        return ((PrivateChatGrpc.PrivateChatBlockingStub) ((PrivateChatGrpc.PrivateChatBlockingStub) ((PrivateChatGrpc.PrivateChatBlockingStub) this.f11340a.a((ChannelManager) PrivateChatGrpc.newBlockingStub(this.f11340a.d()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS)).send(request);
    }
}
