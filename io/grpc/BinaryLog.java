package io.grpc;

import java.io.Closeable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/BinaryLog.class */
public abstract class BinaryLog implements Closeable {
    public abstract Channel wrapChannel(Channel channel);

    public abstract <ReqT, RespT> ServerMethodDefinition<?, ?> wrapMethodDefinition(ServerMethodDefinition<ReqT, RespT> serverMethodDefinition);
}
