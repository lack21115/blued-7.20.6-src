package kotlin.collections;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ULongIterator.class */
public abstract class ULongIterator implements Iterator<ULong>, KMappedMarker {
    public abstract long a();

    public final long b() {
        return a();
    }

    @Override // java.util.Iterator
    public /* synthetic */ ULong next() {
        return ULong.d(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
