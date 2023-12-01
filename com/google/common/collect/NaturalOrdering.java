package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/NaturalOrdering.class */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private static final long serialVersionUID = 0;
    @NullableDecl
    private transient Ordering<Comparable> nullsFirst;
    @NullableDecl
    private transient Ordering<Comparable> nullsLast;

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<Comparable> ordering = this.nullsFirst;
        Ordering<Comparable> ordering2 = ordering;
        if (ordering == null) {
            ordering2 = super.nullsFirst();
            this.nullsFirst = ordering2;
        }
        return (Ordering<S>) ordering2;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<Comparable> ordering = this.nullsLast;
        Ordering<Comparable> ordering2 = ordering;
        if (ordering == null) {
            ordering2 = super.nullsLast();
            this.nullsLast = ordering2;
        }
        return (Ordering<S>) ordering2;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
