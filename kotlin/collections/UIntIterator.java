package kotlin.collections;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/UIntIterator.class */
public abstract class UIntIterator implements Iterator<UInt>, KMappedMarker {
    public abstract int a();

    public final int b() {
        return a();
    }

    @Override // java.util.Iterator
    public /* synthetic */ UInt next() {
        return UInt.d(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
