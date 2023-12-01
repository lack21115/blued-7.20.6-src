package com.ss.android.ttmd5;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/ttmd5/IRandomAccess.class */
public interface IRandomAccess {
    void close() throws IOException;

    long length() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    void seek(long j, long j2) throws IOException;
}
