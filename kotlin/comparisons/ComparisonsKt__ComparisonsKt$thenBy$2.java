package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$2.class */
public final class ComparisonsKt__ComparisonsKt$thenBy$2<T> implements Comparator {
    final /* synthetic */ Comparator<T> a;
    final /* synthetic */ Comparator<? super K> b;
    final /* synthetic */ Function1<T, K> c;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.a.compare(t, t2);
        if (compare != 0) {
            return compare;
        }
        Comparator<? super K> comparator = this.b;
        Function1<T, K> function1 = this.c;
        return comparator.compare(function1.invoke(t), function1.invoke(t2));
    }
}
