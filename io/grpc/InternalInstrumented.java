package io.grpc;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/InternalInstrumented.class */
public interface InternalInstrumented<T> extends InternalWithLogId {
    ListenableFuture<T> getStats();
}
