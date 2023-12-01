package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$nullsFirst$1.class */
final class ComparisonsKt__ComparisonsKt$nullsFirst$1<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Comparator<? super T> f42430a;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return this.f42430a.compare(t, t2);
    }
}
