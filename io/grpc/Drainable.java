package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Drainable.class */
public interface Drainable {
    int drainTo(OutputStream outputStream) throws IOException;
}
