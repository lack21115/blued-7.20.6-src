package com.kwai.filedownloader.d;

import java.io.Closeable;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/d/a.class */
public interface a extends Closeable {
    void IX();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j);

    void setLength(long j);

    void write(byte[] bArr, int i, int i2);
}
