package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/CipherSink.class */
public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink sink, Cipher cipher) {
        Intrinsics.e(sink, "sink");
        Intrinsics.e(cipher, "cipher");
        this.sink = sink;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        if (!(blockSize > 0)) {
            throw new IllegalArgumentException(Intrinsics.a("Block cipher required ", (Object) getCipher()).toString());
        }
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        Buffer buffer = this.sink.getBuffer();
        Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
        try {
            int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
            writableSegment$okio.limit += doFinal;
            buffer.setSize$okio(buffer.size() + doFinal);
        } catch (Throwable th2) {
            th = th2;
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        return th;
    }

    private final int update(Buffer buffer, long j) {
        Segment segment = buffer.head;
        Intrinsics.a(segment);
        int min = (int) Math.min(j, segment.limit - segment.pos);
        Buffer buffer2 = this.sink.getBuffer();
        int outputSize = this.cipher.getOutputSize(min);
        while (true) {
            int i = outputSize;
            if (i <= 8192) {
                Segment writableSegment$okio = buffer2.writableSegment$okio(i);
                int update = this.cipher.update(segment.data, segment.pos, min, writableSegment$okio.data, writableSegment$okio.limit);
                writableSegment$okio.limit += update;
                buffer2.setSize$okio(buffer2.size() + update);
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer2.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                this.sink.emitCompleteSegments();
                buffer.setSize$okio(buffer.size() - min);
                segment.pos += min;
                if (segment.pos == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return min;
            }
            if (!(min > this.blockSize)) {
                throw new IllegalStateException(("Unexpected output size " + i + " for input size " + min).toString());
            }
            min -= this.blockSize;
            outputSize = this.cipher.getOutputSize(min);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th;
        if (this.closed) {
            return;
        }
        this.closed = true;
        Throwable doFinal = doFinal();
        try {
            this.sink.close();
            th = doFinal;
        } catch (Throwable th2) {
            th = doFinal;
            if (doFinal == null) {
                th = th2;
            }
        }
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) throws IOException {
        Intrinsics.e(source, "source");
        _UtilKt.checkOffsetAndCount(source.size(), 0L, j);
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            j -= update(source, j);
        }
    }
}
