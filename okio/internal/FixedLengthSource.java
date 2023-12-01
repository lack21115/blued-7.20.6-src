package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/FixedLengthSource.class */
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(Source delegate, long j, boolean z) {
        super(delegate);
        Intrinsics.e(delegate, "delegate");
        this.size = j;
        this.truncate = z;
    }

    private final void truncateToSize(Buffer buffer, long j) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j);
        buffer2.clear();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer sink, long j) {
        long j2;
        Intrinsics.e(sink, "sink");
        long j3 = this.bytesReceived;
        long j4 = this.size;
        if (j3 > j4) {
            j2 = 0;
        } else {
            j2 = j;
            if (this.truncate) {
                long j5 = j4 - j3;
                if (j5 == 0) {
                    return -1L;
                }
                j2 = Math.min(j, j5);
            }
        }
        long read = super.read(sink, j2);
        int i = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
        if (i != 0) {
            this.bytesReceived += read;
        }
        if ((this.bytesReceived >= this.size || i != 0) && this.bytesReceived <= this.size) {
            return read;
        }
        if (read > 0 && this.bytesReceived > this.size) {
            truncateToSize(sink, sink.size() - (this.bytesReceived - this.size));
        }
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    }
}
