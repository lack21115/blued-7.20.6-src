package io.grpc.internal;

import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/TransportProvider.class */
interface TransportProvider {
    @Nullable
    ClientTransport obtainActiveTransport();
}
