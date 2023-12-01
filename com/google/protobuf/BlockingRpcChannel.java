package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/BlockingRpcChannel.class */
public interface BlockingRpcChannel {
    Message callBlockingMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message message2) throws ServiceException;
}
