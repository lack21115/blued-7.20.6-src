package android.util;

import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/util/FastImmutableArraySet.class */
public final class FastImmutableArraySet<T> extends AbstractSet<T> {
    T[] mContents;
    FastIterator<T> mIterator;

    /* loaded from: source-9557208-dex2jar.jar:android/util/FastImmutableArraySet$FastIterator.class */
    private static final class FastIterator<T> implements Iterator<T> {
        private final T[] mContents;
        int mIndex;

        public FastIterator(T[] tArr) {
            this.mContents = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex != this.mContents.length;
        }

        @Override // java.util.Iterator
        public T next() {
            T[] tArr = this.mContents;
            int i = this.mIndex;
            this.mIndex = i + 1;
            return tArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public FastImmutableArraySet(T[] tArr) {
        this.mContents = tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        FastIterator<T> fastIterator = this.mIterator;
        if (fastIterator != null) {
            fastIterator.mIndex = 0;
            return fastIterator;
        }
        FastIterator<T> fastIterator2 = new FastIterator<>(this.mContents);
        this.mIterator = fastIterator2;
        return fastIterator2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.mContents.length;
    }
}
