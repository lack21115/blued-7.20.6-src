package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/CountingInputStream.class */
class CountingInputStream extends FilterInputStream {
    private long bytesTotal;
    private long bytesWritten;
    private long mark;
    private QCloudProgressListener progressListener;
    private long recentReportBytes;

    public CountingInputStream(InputStream inputStream, long j, QCloudProgressListener qCloudProgressListener) {
        super(inputStream);
        this.bytesWritten = 0L;
        this.bytesTotal = 0L;
        this.recentReportBytes = 0L;
        this.mark = -1L;
        this.bytesTotal = j;
        this.progressListener = qCloudProgressListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void reportProgress() {
        /*
            r6 = this;
            r0 = r6
            com.tencent.qcloud.core.common.QCloudProgressListener r0 = r0.progressListener
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r6
            long r0 = r0.bytesWritten
            r8 = r0
            r0 = r8
            r1 = r6
            long r1 = r1.recentReportBytes
            long r0 = r0 - r1
            r10 = r0
            r0 = r10
            r1 = 51200(0xc800, double:2.5296E-319)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L3f
            r0 = r6
            long r0 = r0.bytesTotal
            r12 = r0
            r0 = r10
            r1 = 10
            long r0 = r0 * r1
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L3f
            r0 = r8
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L3a
            goto L3f
        L3a:
            r0 = 0
            r7 = r0
            goto L41
        L3f:
            r0 = 1
            r7 = r0
        L41:
            r0 = r7
            if (r0 == 0) goto L5d
            r0 = r6
            long r0 = r0.bytesWritten
            r8 = r0
            r0 = r6
            r1 = r8
            r0.recentReportBytes = r1
            r0 = r6
            com.tencent.qcloud.core.common.QCloudProgressListener r0 = r0.progressListener
            r1 = r8
            r2 = r6
            long r2 = r2.bytesTotal
            r0.onProgress(r1, r2)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.http.CountingInputStream.reportProgress():void");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        QCloudLogger.i("Test", "CountingInputStream is closed", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getBytesTotal() {
        return this.bytesTotal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getTotalTransferred() {
        return this.bytesWritten;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            super.mark(i);
            this.mark = this.bytesWritten;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            readBytesInternal(read);
        }
        return read;
    }

    void readBytesInternal(long j) {
        this.bytesWritten += j;
        reportProgress();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            this.in.reset();
            this.bytesWritten = this.mark;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        readBytesInternal(skip);
        return skip;
    }
}
