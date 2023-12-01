package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt.class */
public class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static final <T, C extends Collection<? super T>> C a(Sequence<? extends T> sequence, C destination) {
        Intrinsics.e(sequence, "<this>");
        Intrinsics.e(destination, "destination");
        for (T t : sequence) {
            destination.add(t);
        }
        return destination;
    }

    public static final <T> Sequence<T> a(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.e(sequence, "<this>");
        Intrinsics.e(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    public static final <T> T b(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (true) {
            T t = next;
            if (!it.hasNext()) {
                return t;
            }
            next = it.next();
        }
    }

    public static final <T> Sequence<T> b(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.e(sequence, "<this>");
        Intrinsics.e(predicate, "predicate");
        return new FilteringSequence(sequence, false, predicate);
    }

    public static final <T> HashSet<T> c(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        return (HashSet) SequencesKt.a(sequence, new HashSet());
    }

    public static final <T, R> Sequence<R> c(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.e(sequence, "<this>");
        Intrinsics.e(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    public static final <T> List<T> d(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        return CollectionsKt.c(SequencesKt.e(sequence));
    }

    public static final <T> List<T> e(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        return (List) SequencesKt.a(sequence, new ArrayList());
    }

    public static final <T> int f(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            int i2 = i + 1;
            i = i2;
            if (i2 < 0) {
                CollectionsKt.d();
                i = i2;
            }
        }
        return i;
    }

    public static final <T> Iterable<T> g(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }
}
