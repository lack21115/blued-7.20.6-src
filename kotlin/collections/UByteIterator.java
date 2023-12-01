package kotlin.collections;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.markers.KMappedMarker;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/UByteIterator.class */
public abstract class UByteIterator implements Iterator<UByte>, KMappedMarker {
    public abstract byte a();

    public final byte b() {
        return a();
    }

    @Override // java.util.Iterator
    public /* synthetic */ UByte next() {
        return UByte.d(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
