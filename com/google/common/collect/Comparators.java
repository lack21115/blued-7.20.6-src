package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/Comparators.class */
public final class Comparators {
    private Comparators() {
    }

    public static <T> boolean isInOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (true) {
            T t = next;
            if (!it.hasNext()) {
                return true;
            }
            T next2 = it.next();
            if (comparator.compare(t, next2) > 0) {
                return false;
            }
            next = next2;
        }
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (true) {
            T t = next;
            if (!it.hasNext()) {
                return true;
            }
            T next2 = it.next();
            if (comparator.compare(t, next2) >= 0) {
                return false;
            }
            next = next2;
        }
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(comparator));
    }
}
