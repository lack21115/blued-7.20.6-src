package io.grpc.inprocess;

import io.grpc.Attributes;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/inprocess/InternalInProcess.class */
public final class InternalInProcess {
    private InternalInProcess() {
    }

    public static ConnectionClientTransport createInProcessTransport(String str, int i, String str2, String str3, Attributes attributes, ObjectPool<ScheduledExecutorService> objectPool, List<ServerStreamTracer.Factory> list, ServerListener serverListener) {
        return new InProcessTransport(str, i, str2, str3, attributes, objectPool, list, serverListener);
    }
}
