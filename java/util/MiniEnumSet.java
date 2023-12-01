package java.util;

import java.lang.Enum;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/MiniEnumSet.class */
public final class MiniEnumSet<E extends Enum<E>> extends EnumSet<E> {
    private static final int MAX_ELEMENTS = 64;
    private long bits;
    private final E[] enums;
    private int size;

    /* loaded from: source-2895416-dex2jar.jar:java/util/MiniEnumSet$MiniEnumSetIterator.class */
    private class MiniEnumSetIterator implements Iterator<E> {
        private long currentBits;
        private E last;
        private long mask;

        private MiniEnumSetIterator() {
            this.currentBits = MiniEnumSet.this.bits;
            this.mask = this.currentBits & (-this.currentBits);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mask != 0;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.mask == 0) {
                throw new NoSuchElementException();
            }
            this.last = (E) MiniEnumSet.this.enums[Long.numberOfTrailingZeros(this.mask)];
            this.currentBits &= this.mask ^ (-1);
            this.mask = this.currentBits & (-this.currentBits);
            return this.last;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == null) {
                throw new IllegalStateException();
            }
            MiniEnumSet.this.remove(this.last);
            this.last = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniEnumSet(Class<E> cls, E[] eArr) {
        super(cls);
        this.enums = eArr;
    }

    public boolean add(E e) {
        this.elementClass.cast(e);
        long j = this.bits;
        long ordinal = j | (1 << e.ordinal());
        if (j != ordinal) {
            this.bits = ordinal;
            this.size++;
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((MiniEnumSet<E>) ((Enum) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) collection;
            enumSet.elementClass.asSubclass((Class<E>) this.elementClass);
            MiniEnumSet miniEnumSet = (MiniEnumSet) enumSet;
            long j = this.bits;
            long j2 = j | miniEnumSet.bits;
            this.bits = j2;
            this.size = Long.bitCount(j2);
            return j != j2;
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.bits = 0L;
        this.size = 0;
    }

    @Override // java.util.EnumSet
    void complement() {
        if (this.enums.length != 0) {
            this.bits ^= -1;
            this.bits &= (-1) >>> (64 - this.enums.length);
            this.size = this.enums.length - this.size;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null || !isValidType(obj.getClass())) {
            return false;
        }
        return (this.bits & (1 << ((Enum) obj).ordinal())) != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        if (!(collection instanceof MiniEnumSet)) {
            return !(collection instanceof EnumSet) && super.containsAll(collection);
        }
        MiniEnumSet miniEnumSet = (MiniEnumSet) collection;
        long j = miniEnumSet.bits;
        return isValidType(miniEnumSet.elementClass) && (this.bits & j) == j;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) obj;
            if (isValidType(enumSet.elementClass)) {
                if (this.bits != ((MiniEnumSet) enumSet).bits) {
                    return false;
                }
            } else if (this.size != 0 || !enumSet.isEmpty()) {
                return false;
            }
        } else {
            z = super.equals(obj);
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new MiniEnumSetIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (obj == null || !isValidType(obj.getClass())) {
            return false;
        }
        int ordinal = ((Enum) obj).ordinal();
        long j = this.bits;
        long j2 = j & ((1 << ordinal) ^ (-1));
        if (j != j2) {
            this.bits = j2;
            this.size--;
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) collection;
            if (isValidType(enumSet.elementClass)) {
                MiniEnumSet miniEnumSet = (MiniEnumSet) enumSet;
                long j = this.bits;
                long j2 = j & (miniEnumSet.bits ^ (-1));
                if (j != j2) {
                    this.bits = j2;
                    this.size = Long.bitCount(j2);
                    return true;
                }
                return false;
            }
            return false;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        if (collection instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) collection;
            if (!isValidType(enumSet.elementClass)) {
                if (this.size > 0) {
                    clear();
                    return true;
                }
                return false;
            }
            MiniEnumSet miniEnumSet = (MiniEnumSet) enumSet;
            long j = this.bits;
            long j2 = j & miniEnumSet.bits;
            if (j != j2) {
                this.bits = j2;
                this.size = Long.bitCount(j2);
                return true;
            }
            return false;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.EnumSet
    void setRange(E e, E e2) {
        this.bits |= ((-1) >>> (64 - ((e2.ordinal() - e.ordinal()) + 1))) << e.ordinal();
        this.size = Long.bitCount(this.bits);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
