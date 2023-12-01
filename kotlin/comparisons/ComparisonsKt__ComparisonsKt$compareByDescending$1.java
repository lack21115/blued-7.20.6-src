package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1.class */
public final class ComparisonsKt__ComparisonsKt$compareByDescending$1<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<T, Comparable<?>> f42428a;

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Function1<T, Comparable<?>> function1 = this.f42428a;
        return ComparisonsKt.a(function1.invoke(t2), function1.invoke(t));
    }
}
