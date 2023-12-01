package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ByteIterator.class */
public abstract class ByteIterator implements Iterator<Byte>, KMappedMarker {
    public abstract byte a();

    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
