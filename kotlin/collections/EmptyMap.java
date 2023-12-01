package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/EmptyMap.class */
public final class EmptyMap implements Serializable, Map, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptyMap f42380a = new EmptyMap();
    private static final long serialVersionUID = 8246714829545688274L;

    private EmptyMap() {
    }

    private final Object readResolve() {
        return f42380a;
    }

    public int a() {
        return 0;
    }

    @Override // java.util.Map
    /* renamed from: a */
    public Void get(Object obj) {
        return null;
    }

    public boolean a(Void value) {
        Intrinsics.e(value, "value");
        return false;
    }

    @Override // java.util.Map
    /* renamed from: b */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Set<Map.Entry> b() {
        return EmptySet.f42381a;
    }

    public Set<Object> c() {
        return EmptySet.f42381a;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    public Collection d() {
        return EmptyList.f42379a;
    }

    @Override // java.util.Map
    public final Set<Map.Entry> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final Set<Object> keySet() {
        return c();
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return a();
    }

    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final Collection values() {
        return d();
    }
}
