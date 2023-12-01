package com.meizu.cloud.pushsdk.c.g;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/m.class */
public interface m extends Closeable {
    long b(b bVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
