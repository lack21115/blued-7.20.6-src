package com.android.internal.util;

import java.util.Arrays;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/Predicates.class */
public class Predicates {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/Predicates$AndPredicate.class */
    public static class AndPredicate<T> implements Predicate<T> {
        private final Iterable<? extends Predicate<? super T>> components;

        private AndPredicate(Iterable<? extends Predicate<? super T>> iterable) {
            this.components = iterable;
        }

        @Override // com.android.internal.util.Predicate
        public boolean apply(T t) {
            for (Predicate<? super T> predicate : this.components) {
                if (!predicate.apply(t)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/Predicates$NotPredicate.class */
    private static class NotPredicate<T> implements Predicate<T> {
        private final Predicate<? super T> predicate;

        private NotPredicate(Predicate<? super T> predicate) {
            this.predicate = predicate;
        }

        @Override // com.android.internal.util.Predicate
        public boolean apply(T t) {
            return !this.predicate.apply(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/Predicates$OrPredicate.class */
    public static class OrPredicate<T> implements Predicate<T> {
        private final Iterable<? extends Predicate<? super T>> components;

        private OrPredicate(Iterable<? extends Predicate<? super T>> iterable) {
            this.components = iterable;
        }

        @Override // com.android.internal.util.Predicate
        public boolean apply(T t) {
            for (Predicate<? super T> predicate : this.components) {
                if (predicate.apply(t)) {
                    return true;
                }
            }
            return false;
        }
    }

    private Predicates() {
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new AndPredicate(iterable);
    }

    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return and(Arrays.asList(predicateArr));
    }

    public static <T> Predicate<T> not(Predicate<? super T> predicate) {
        return new NotPredicate(predicate);
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> iterable) {
        return new OrPredicate(iterable);
    }

    public static <T> Predicate<T> or(Predicate<? super T>... predicateArr) {
        return or(Arrays.asList(predicateArr));
    }
}
