package kotlin.io;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/ByteStreamsKt$iterator$1.class */
public final class ByteStreamsKt$iterator$1 extends ByteIterator {
    final /* synthetic */ BufferedInputStream a;
    private int b;
    private boolean c;
    private boolean d;

    private final void b() {
        if (this.c || this.d) {
            return;
        }
        int read = this.a.read();
        this.b = read;
        boolean z = true;
        this.c = true;
        if (read != -1) {
            z = false;
        }
        this.d = z;
    }

    @Override // kotlin.collections.ByteIterator
    public byte a() {
        b();
        if (this.d) {
            throw new NoSuchElementException("Input stream is over.");
        }
        byte b = (byte) this.b;
        this.c = false;
        return b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        b();
        return !this.d;
    }
}
