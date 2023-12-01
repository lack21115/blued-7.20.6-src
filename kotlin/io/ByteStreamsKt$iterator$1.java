package kotlin.io;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/ByteStreamsKt$iterator$1.class */
public final class ByteStreamsKt$iterator$1 extends ByteIterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BufferedInputStream f42483a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42484c;
    private boolean d;

    private final void b() {
        if (this.f42484c || this.d) {
            return;
        }
        int read = this.f42483a.read();
        this.b = read;
        boolean z = true;
        this.f42484c = true;
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
        this.f42484c = false;
        return b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        b();
        return !this.d;
    }
}
