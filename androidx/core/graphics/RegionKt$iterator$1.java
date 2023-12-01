package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/RegionKt$iterator$1.class */
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Region f2454a;
    private final RegionIterator b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f2455c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegionKt$iterator$1(Region region) {
        this.f2454a = region;
        this.b = new RegionIterator(this.f2454a);
        Rect rect = new Rect();
        this.f2455c = rect;
        this.d = this.b.next(rect);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Rect next() {
        if (this.d) {
            Rect rect = new Rect(this.f2455c);
            this.d = this.b.next(this.f2455c);
            return rect;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
