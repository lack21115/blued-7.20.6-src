package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$2.class */
public final class ComparisonsKt__ComparisonsKt$compareByDescending$2<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Comparator<? super K> f42429a;
    final /* synthetic */ Function1<T, K> b;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Comparator<? super K> comparator = this.f42429a;
        Function1<T, K> function1 = this.b;
        return comparator.compare(function1.invoke(t2), function1.invoke(t));
    }
}
