package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$2.class */
public final class ComparisonsKt__ComparisonsKt$thenByDescending$2<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Comparator<T> f42437a;
    final /* synthetic */ Comparator<? super K> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function1<T, K> f42438c;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.f42437a.compare(t, t2);
        if (compare != 0) {
            return compare;
        }
        Comparator<? super K> comparator = this.b;
        Function1<T, K> function1 = this.f42438c;
        return comparator.compare(function1.invoke(t2), function1.invoke(t));
    }
}
