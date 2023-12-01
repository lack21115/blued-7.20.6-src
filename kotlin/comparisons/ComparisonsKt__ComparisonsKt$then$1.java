package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$then$1.class */
final class ComparisonsKt__ComparisonsKt$then$1<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Comparator<T> f42432a;
    final /* synthetic */ Comparator<? super T> b;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.f42432a.compare(t, t2);
        return compare != 0 ? compare : this.b.compare(t, t2);
    }
}
