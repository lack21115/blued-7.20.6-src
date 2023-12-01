package com.kwad.sdk.core.imageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/core/assist/FlushedInputStream.class */
public class FlushedInputStream extends FilterInputStream {
    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long j2;
        long j3 = 0;
        while (true) {
            j2 = j3;
            if (j2 >= j) {
                break;
            }
            long skip = this.in.skip(j - j2);
            long j4 = skip;
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                j4 = 1;
            }
            j3 = j2 + j4;
        }
        return j2;
    }
}
