package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/DistinctIterator.class */
final class DistinctIterator<T, K> extends AbstractIterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Iterator<T> f42615a;
    private final Function1<T, K> b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<K> f42616c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctIterator(Iterator<? extends T> source, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.e(source, "source");
        Intrinsics.e(keySelector, "keySelector");
        this.f42615a = source;
        this.b = keySelector;
        this.f42616c = new HashSet<>();
    }

    @Override // kotlin.collections.AbstractIterator
    public void a() {
        while (this.f42615a.hasNext()) {
            T next = this.f42615a.next();
            if (this.f42616c.add(this.b.invoke(next))) {
                a(next);
                return;
            }
        }
        b();
    }
}
