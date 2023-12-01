package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/BrittleContainsOptimizationKt.class */
public final class BrittleContainsOptimizationKt {
    public static final <T> Collection<T> a(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return CollectionSystemProperties.b ? CollectionsKt.e(iterable) : CollectionsKt.f(iterable);
        }
        Collection<T> collection = (Collection) iterable;
        return a((Collection) collection) ? CollectionsKt.e(iterable) : collection;
    }

    public static final <T> Collection<T> a(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        return CollectionSystemProperties.b ? SequencesKt.c(sequence) : SequencesKt.d(sequence);
    }

    public static final <T> Collection<T> a(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        return CollectionSystemProperties.b ? ArraysKt.e(tArr) : ArraysKt.a(tArr);
    }

    private static final <T> boolean a(Collection<? extends T> collection) {
        return CollectionSystemProperties.b && collection.size() > 2 && (collection instanceof ArrayList);
    }
}
