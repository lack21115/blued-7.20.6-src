package java.io;

import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/io/InputStream.class */
public abstract class InputStream implements Closeable {
    public int available() throws IOException {
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public abstract int read() throws IOException;

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r5, int r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            r0 = r5
            int r0 = r0.length
            r1 = r6
            r2 = r7
            java.util.Arrays.checkOffsetAndCount(r0, r1, r2)
            r0 = 0
            r8 = r0
        La:
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L45
            r0 = r4
            int r0 = r0.read()     // Catch: java.io.IOException -> L28
            r9 = r0
            r0 = r9
            r1 = -1
            if (r0 != r1) goto L33
            r0 = r8
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L26
            r0 = -1
            r6 = r0
        L26:
            r0 = r6
            return r0
        L28:
            r5 = move-exception
            r0 = r8
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L26
            r0 = r5
            throw r0
        L33:
            r0 = r5
            r1 = r6
            r2 = r8
            int r1 = r1 + r2
            r2 = r9
            byte r2 = (byte) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto La
        L45:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.InputStream.read(byte[], int, int):int");
    }

    public void reset() throws IOException {
        synchronized (this) {
            throw new IOException();
        }
    }

    public long skip(long j) throws IOException {
        return Streams.skipByReading(this, j);
    }
}
