package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/TransformedIterator.class */
abstract class TransformedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> backingIterator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformedIterator(Iterator<? extends F> it) {
        this.backingIterator = (Iterator) Preconditions.checkNotNull(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return transform(this.backingIterator.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.backingIterator.remove();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T transform(F f);
}
