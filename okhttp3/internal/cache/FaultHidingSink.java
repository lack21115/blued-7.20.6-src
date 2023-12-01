package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/FaultHidingSink.class */
class FaultHidingSink extends ForwardingSink {

    /* renamed from: a  reason: collision with root package name */
    private boolean f43862a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    protected void a(IOException iOException) {
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f43862a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.f43862a = true;
            a(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f43862a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.f43862a = true;
            a(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.f43862a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.f43862a = true;
            a(e);
        }
    }
}
