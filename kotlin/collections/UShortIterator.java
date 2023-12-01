package kotlin.collections;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.markers.KMappedMarker;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/UShortIterator.class */
public abstract class UShortIterator implements Iterator<UShort>, KMappedMarker {
    public abstract short a();

    public final short b() {
        return a();
    }

    @Override // java.util.Iterator
    public /* synthetic */ UShort next() {
        return UShort.d(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
