package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/IndexedValue.class */
public final class IndexedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f42382a;
    private final T b;

    public IndexedValue(int i, T t) {
        this.f42382a = i;
        this.b = t;
    }

    public final int a() {
        return this.f42382a;
    }

    public final T b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IndexedValue) {
            IndexedValue indexedValue = (IndexedValue) obj;
            return this.f42382a == indexedValue.f42382a && Intrinsics.a(this.b, indexedValue.b);
        }
        return false;
    }

    public int hashCode() {
        int i = this.f42382a;
        T t = this.b;
        return (i * 31) + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f42382a + ", value=" + this.b + ')';
    }
}
