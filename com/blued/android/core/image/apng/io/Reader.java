package com.blued.android.core.image.apng.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/Reader.class */
public interface Reader {
    int available() throws IOException;

    int b();

    void close() throws IOException;

    byte n_() throws IOException;

    InputStream o_() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    void reset() throws IOException;

    long skip(long j) throws IOException;
}
