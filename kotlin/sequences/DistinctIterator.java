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
    private final Iterator<T> a;
    private final Function1<T, K> b;
    private final HashSet<K> c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctIterator(Iterator<? extends T> source, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.e(source, "source");
        Intrinsics.e(keySelector, "keySelector");
        this.a = source;
        this.b = keySelector;
        this.c = new HashSet<>();
    }

    @Override // kotlin.collections.AbstractIterator
    public void a() {
        while (this.a.hasNext()) {
            T next = this.a.next();
            if (this.c.add(this.b.invoke(next))) {
                a(next);
                return;
            }
        }
        b();
    }
}
