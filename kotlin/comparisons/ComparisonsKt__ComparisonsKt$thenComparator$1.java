package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenComparator$1.class */
public final class ComparisonsKt__ComparisonsKt$thenComparator$1<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Comparator<T> f42439a;
    final /* synthetic */ Function2<T, T, Integer> b;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.f42439a.compare(t, t2);
        return compare != 0 ? compare : this.b.invoke(t, t2).intValue();
    }
}
