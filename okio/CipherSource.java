package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/CipherSource.class */
public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;

    /* renamed from: final  reason: not valid java name */
    private boolean f1211final;
    private final BufferedSource source;

    public CipherSource(BufferedSource source, Cipher cipher) {
        Intrinsics.e(source, "source");
        Intrinsics.e(cipher, "cipher");
        this.source = source;
        this.cipher = cipher;
        this.blockSize = cipher.getBlockSize();
        this.buffer = new Buffer();
        if (!(this.blockSize > 0)) {
            throw new IllegalArgumentException(Intrinsics.a("Block cipher required ", (Object) getCipher()).toString());
        }
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
        writableSegment$okio.limit += doFinal;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + doFinal);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0) {
            if (this.source.exhausted()) {
                this.f1211final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        Intrinsics.a(segment);
        int i = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i);
        while (true) {
            int i2 = outputSize;
            if (i2 <= 8192) {
                Segment writableSegment$okio = this.buffer.writableSegment$okio(i2);
                int update = this.cipher.update(segment.data, segment.pos, i, writableSegment$okio.data, writableSegment$okio.pos);
                this.source.skip(i);
                writableSegment$okio.limit += update;
                Buffer buffer = this.buffer;
                buffer.setSize$okio(buffer.size() + update);
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return;
                }
                return;
            }
            if (!(i > this.blockSize)) {
                throw new IllegalStateException(("Unexpected output size " + i2 + " for input size " + i).toString());
            }
            i -= this.blockSize;
            outputSize = this.cipher.getOutputSize(i);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) throws IOException {
        Intrinsics.e(sink, "sink");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (true ^ this.closed) {
                if (i == 0) {
                    return 0L;
                }
                if (this.f1211final) {
                    return this.buffer.read(sink, j);
                }
                refill();
                return this.buffer.read(sink, j);
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount < 0: ", (Object) Long.valueOf(j)).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
