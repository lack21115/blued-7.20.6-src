package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/RpcChannel.class */
public interface RpcChannel {
    void callMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message message2, RpcCallback<Message> rpcCallback);
}
