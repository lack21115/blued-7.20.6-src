package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$1.class */
final class ComparisonsKt__ComparisonsKt$compareBy$1<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<T, Comparable<?>>[] f42425a;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int b;
        b = ComparisonsKt__ComparisonsKt.b(t, t2, this.f42425a);
        return b;
    }
}
