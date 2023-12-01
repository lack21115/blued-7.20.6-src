package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Source.class */
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(Buffer buffer, long j) throws IOException;

    Timeout timeout();
}
