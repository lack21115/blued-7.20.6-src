package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Compressor.class */
public interface Compressor {
    OutputStream compress(OutputStream outputStream) throws IOException;

    String getMessageEncoding();
}
