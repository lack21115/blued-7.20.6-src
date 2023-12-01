package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/CountingSink.class */
public class CountingSink extends ForwardingSink {
    private long bytesTotal;
    private long bytesWritten;
    private QCloudProgressListener progressListener;
    private long recentReportBytes;

    public CountingSink(Sink sink, long j, QCloudProgressListener qCloudProgressListener) {
        super(sink);
        this.bytesWritten = 0L;
        this.bytesTotal = 0L;
        this.recentReportBytes = 0L;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.http.CountingSink.reportProgress():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getTotalTransferred() {
        return this.bytesWritten;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        super.write(buffer, j);
        writeBytesInternal(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeBytesInternal(long j) {
        this.bytesWritten += j;
        reportProgress();
    }
}
