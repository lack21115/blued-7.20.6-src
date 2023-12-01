package io.grpc;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Decompressor.class */
public interface Decompressor {
    InputStream decompress(InputStream inputStream) throws IOException;

    String getMessageEncoding();
}
