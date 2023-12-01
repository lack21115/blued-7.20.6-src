package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenDescending$1.class */
final class ComparisonsKt__ComparisonsKt$thenDescending$1<T> implements Comparator {
    final /* synthetic */ Comparator<T> a;
    final /* synthetic */ Comparator<? super T> b;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.a.compare(t, t2);
        return compare != 0 ? compare : this.b.compare(t2, t);
    }
}
