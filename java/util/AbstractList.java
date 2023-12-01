package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/AbstractList.class */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    protected transient int modCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/AbstractList$FullListIterator.class */
    public final class FullListIterator extends AbstractList<E>.SimpleListIterator implements ListIterator<E> {
        FullListIterator(int i) {
            super();
            if (i < 0 || i > AbstractList.this.size()) {
                throw new IndexOutOfBoundsException();
            }
            this.pos = i - 1;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            if (this.expectedModCount != AbstractList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            try {
                AbstractList.this.add(this.pos + 1, e);
                this.pos++;
                this.lastPosition = -1;
                if (AbstractList.this.modCount != this.expectedModCount) {
                    this.expectedModCount = AbstractList.this.modCount;
                }
            } catch (IndexOutOfBoundsException e2) {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.pos >= 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.pos + 1;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (this.expectedModCount == AbstractList.this.modCount) {
                try {
                    E e = (E) AbstractList.this.get(this.pos);
                    this.lastPosition = this.pos;
                    this.pos--;
                    return e;
                } catch (IndexOutOfBoundsException e2) {
                    throw new NoSuchElementException();
                }
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.pos;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            if (this.expectedModCount != AbstractList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            try {
                AbstractList.this.set(this.lastPosition, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/AbstractList$SimpleListIterator.class */
    public class SimpleListIterator implements Iterator<E> {
        int expectedModCount;
        int pos = -1;
        int lastPosition = -1;

        SimpleListIterator() {
            this.expectedModCount = AbstractList.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos + 1 < AbstractList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.expectedModCount == AbstractList.this.modCount) {
                try {
                    E e = (E) AbstractList.this.get(this.pos + 1);
                    int i = this.pos + 1;
                    this.pos = i;
                    this.lastPosition = i;
                    return e;
                } catch (IndexOutOfBoundsException e2) {
                    throw new NoSuchElementException();
                }
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastPosition == -1) {
                throw new IllegalStateException();
            }
            if (this.expectedModCount != AbstractList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            try {
                AbstractList.this.remove(this.lastPosition);
                this.expectedModCount = AbstractList.this.modCount;
                if (this.pos == this.lastPosition) {
                    this.pos--;
                }
                this.lastPosition = -1;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/AbstractList$SubAbstractList.class */
    private static class SubAbstractList<E> extends AbstractList<E> {
        private final AbstractList<E> fullList;
        private int offset;
        private int size;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/AbstractList$SubAbstractList$SubAbstractListIterator.class */
        public static final class SubAbstractListIterator<E> implements ListIterator<E> {
            private int end;
            private final ListIterator<E> iterator;
            private int start;
            private final SubAbstractList<E> subList;

            SubAbstractListIterator(ListIterator<E> listIterator, SubAbstractList<E> subAbstractList, int i, int i2) {
                this.iterator = listIterator;
                this.subList = subAbstractList;
                this.start = i;
                this.end = this.start + i2;
            }

            @Override // java.util.ListIterator
            public void add(E e) {
                this.iterator.add(e);
                this.subList.sizeChanged(true);
                this.end++;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.iterator.nextIndex() < this.end;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.iterator.previousIndex() >= this.start;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                if (this.iterator.nextIndex() < this.end) {
                    return this.iterator.next();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.iterator.nextIndex() - this.start;
            }

            @Override // java.util.ListIterator
            public E previous() {
                if (this.iterator.previousIndex() >= this.start) {
                    return this.iterator.previous();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                int previousIndex = this.iterator.previousIndex();
                if (previousIndex >= this.start) {
                    return previousIndex - this.start;
                }
                return -1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                this.iterator.remove();
                this.subList.sizeChanged(false);
                this.end--;
            }

            @Override // java.util.ListIterator
            public void set(E e) {
                this.iterator.set(e);
            }
        }

        SubAbstractList(AbstractList<E> abstractList, int i, int i2) {
            this.fullList = abstractList;
            this.modCount = this.fullList.modCount;
            this.offset = i;
            this.size = i2 - i;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, E e) {
            if (this.modCount != this.fullList.modCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0 || i > this.size) {
                throw new IndexOutOfBoundsException();
            }
            this.fullList.add(this.offset + i, e);
            this.size++;
            this.modCount = this.fullList.modCount;
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            if (this.modCount == this.fullList.modCount) {
                if (i < 0 || i > this.size) {
                    throw new IndexOutOfBoundsException();
                }
                boolean addAll = this.fullList.addAll(this.offset + i, collection);
                if (addAll) {
                    this.size += collection.size();
                    this.modCount = this.fullList.modCount;
                }
                return addAll;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            if (this.modCount == this.fullList.modCount) {
                boolean addAll = this.fullList.addAll(this.offset + this.size, collection);
                if (addAll) {
                    this.size += collection.size();
                    this.modCount = this.fullList.modCount;
                }
                return addAll;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (this.modCount == this.fullList.modCount) {
                if (i < 0 || i >= this.size) {
                    throw new IndexOutOfBoundsException();
                }
                return this.fullList.get(this.offset + i);
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i) {
            if (this.modCount == this.fullList.modCount) {
                if (i < 0 || i > this.size) {
                    throw new IndexOutOfBoundsException();
                }
                return new SubAbstractListIterator(this.fullList.listIterator(this.offset + i), this, this.offset, this.size);
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i) {
            if (this.modCount == this.fullList.modCount) {
                if (i < 0 || i >= this.size) {
                    throw new IndexOutOfBoundsException();
                }
                E remove = this.fullList.remove(this.offset + i);
                this.size--;
                this.modCount = this.fullList.modCount;
                return remove;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i, int i2) {
            if (i != i2) {
                if (this.modCount != this.fullList.modCount) {
                    throw new ConcurrentModificationException();
                }
                this.fullList.removeRange(this.offset + i, this.offset + i2);
                this.size -= i2 - i;
                this.modCount = this.fullList.modCount;
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            if (this.modCount == this.fullList.modCount) {
                if (i < 0 || i >= this.size) {
                    throw new IndexOutOfBoundsException();
                }
                return this.fullList.set(this.offset + i, e);
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            if (this.modCount == this.fullList.modCount) {
                return this.size;
            }
            throw new ConcurrentModificationException();
        }

        void sizeChanged(boolean z) {
            if (z) {
                this.size++;
            } else {
                this.size--;
            }
            this.modCount = this.fullList.modCount;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/AbstractList$SubAbstractListRandomAccess.class */
    private static final class SubAbstractListRandomAccess<E> extends SubAbstractList<E> implements RandomAccess {
        SubAbstractListRandomAccess(AbstractList<E> abstractList, int i, int i2) {
            super(abstractList, i, i2);
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        for (E e : collection) {
            add(i, e);
            i++;
        }
        return !collection.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        removeRange(0, size());
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() != size()) {
                return false;
            }
            Iterator<E> it = iterator();
            Iterator<E> it2 = list.iterator();
            while (it.hasNext()) {
                E next = it.next();
                E next2 = it2.next();
                if (next == null) {
                    if (next2 != null) {
                        return false;
                    }
                } else if (!next.equals(next2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public abstract E get(int i);

    @Override // java.util.Collection
    public int hashCode() {
        int i = 1;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E next = it.next();
            i = (i * 31) + (next == null ? 0 : next.hashCode());
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        ListIterator<E> listIterator = listIterator();
        if (obj != null) {
            while (listIterator.hasNext()) {
                if (obj.equals(listIterator.next())) {
                    return listIterator.previousIndex();
                }
            }
            return -1;
        }
        while (listIterator.hasNext()) {
            if (listIterator.next() == null) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new SimpleListIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        if (obj != null) {
            while (listIterator.hasPrevious()) {
                if (obj.equals(listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() == null) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new FullListIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int i, int i2) {
        ListIterator<E> listIterator = listIterator(i);
        while (i < i2) {
            listIterator.next();
            listIterator.remove();
            i++;
        }
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        if (i < 0 || i2 > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= i2) {
            return this instanceof RandomAccess ? new SubAbstractListRandomAccess(this, i, i2) : new SubAbstractList(this, i, i2);
        }
        throw new IllegalArgumentException();
    }
}
