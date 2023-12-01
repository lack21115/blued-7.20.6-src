package java.util;

import java.lang.Enum;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/HugeEnumSet.class */
public final class HugeEnumSet<E extends Enum<E>> extends EnumSet<E> {
    private static final int BIT_IN_LONG = 64;
    private long[] bits;
    private final E[] enums;
    private int size;

    /* loaded from: source-2895416-dex2jar.jar:java/util/HugeEnumSet$HugeEnumSetIterator.class */
    private class HugeEnumSetIterator implements Iterator<E> {
        private long currentBits;
        private int index;
        private E last;
        private long mask;

        private HugeEnumSetIterator() {
            this.currentBits = HugeEnumSet.this.bits[0];
            computeNextElement();
        }

        void computeNextElement() {
            while (this.currentBits == 0) {
                int i = this.index + 1;
                this.index = i;
                if (i >= HugeEnumSet.this.bits.length) {
                    this.mask = 0L;
                    return;
                }
                this.currentBits = HugeEnumSet.this.bits[this.index];
            }
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
            this.last = (E) HugeEnumSet.this.enums[Long.numberOfTrailingZeros(this.mask) + (this.index * 64)];
            this.currentBits &= this.mask ^ (-1);
            computeNextElement();
            return this.last;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == null) {
                throw new IllegalStateException();
            }
            HugeEnumSet.this.remove(this.last);
            this.last = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HugeEnumSet(Class<E> cls, E[] eArr) {
        super(cls);
        this.enums = eArr;
        this.bits = new long[((eArr.length + 64) - 1) / 64];
    }

    public boolean add(E e) {
        this.elementClass.cast(e);
        int ordinal = e.ordinal();
        int i = ordinal / 64;
        long j = this.bits[i];
        long j2 = j | (1 << (ordinal % 64));
        if (j != j2) {
            this.bits[i] = j2;
            this.size++;
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((HugeEnumSet<E>) ((Enum) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        boolean z;
        if (collection.isEmpty() || collection == this) {
            z = false;
        } else if (!(collection instanceof EnumSet)) {
            return super.addAll(collection);
        } else {
            EnumSet enumSet = (EnumSet) collection;
            enumSet.elementClass.asSubclass((Class<E>) this.elementClass);
            HugeEnumSet hugeEnumSet = (HugeEnumSet) enumSet;
            boolean z2 = false;
            int i = 0;
            while (true) {
                int i2 = i;
                z = z2;
                if (i2 >= this.bits.length) {
                    break;
                }
                long j = this.bits[i2];
                long j2 = j | hugeEnumSet.bits[i2];
                if (j != j2) {
                    this.bits[i2] = j2;
                    this.size += Long.bitCount(j2) - Long.bitCount(j);
                    z2 = true;
                }
                i = i2 + 1;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Arrays.fill(this.bits, 0L);
        this.size = 0;
    }

    @Override // java.util.EnumSet
    /* renamed from: clone */
    public HugeEnumSet<E> mo12752clone() {
        HugeEnumSet<E> hugeEnumSet = (HugeEnumSet) super.clone();
        hugeEnumSet.bits = (long[]) this.bits.clone();
        return hugeEnumSet;
    }

    @Override // java.util.EnumSet
    protected void complement() {
        this.size = 0;
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            long j = this.bits[i] ^ (-1);
            long j2 = j;
            if (i == length - 1) {
                j2 = j & ((-1) >>> (64 - (this.enums.length % 64)));
            }
            this.size += Long.bitCount(j2);
            this.bits[i] = j2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null || !isValidType(obj.getClass())) {
            return false;
        }
        int ordinal = ((Enum) obj).ordinal();
        return (this.bits[ordinal / 64] & (1 << (ordinal % 64))) != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        if (collection instanceof HugeEnumSet) {
            HugeEnumSet hugeEnumSet = (HugeEnumSet) collection;
            if (isValidType(hugeEnumSet.elementClass)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bits.length) {
                        return true;
                    }
                    long j = hugeEnumSet.bits[i2];
                    if ((this.bits[i2] & j) != j) {
                        return false;
                    }
                    i = i2 + 1;
                }
            }
        }
        return !(collection instanceof EnumSet) && super.containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return !isValidType(obj.getClass()) ? super.equals(obj) : Arrays.equals(this.bits, ((HugeEnumSet) obj).bits);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new HugeEnumSetIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (obj == null || !isValidType(obj.getClass())) {
            return false;
        }
        int ordinal = ((Enum) obj).ordinal();
        int i = ordinal / 64;
        long j = this.bits[i];
        long j2 = j & ((1 << (ordinal % 64)) ^ (-1));
        if (j != j2) {
            this.bits[i] = j2;
            this.size--;
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        if (!collection.isEmpty()) {
            if (!(collection instanceof EnumSet)) {
                return super.removeAll(collection);
            }
            EnumSet enumSet = (EnumSet) collection;
            if (isValidType(enumSet.elementClass)) {
                HugeEnumSet hugeEnumSet = (HugeEnumSet) enumSet;
                boolean z2 = false;
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = z2;
                    if (i2 >= this.bits.length) {
                        break;
                    }
                    long j = this.bits[i2];
                    long j2 = j & (hugeEnumSet.bits[i2] ^ (-1));
                    if (j != j2) {
                        this.bits[i2] = j2;
                        this.size += Long.bitCount(j2) - Long.bitCount(j);
                        z2 = true;
                    }
                    i = i2 + 1;
                }
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z;
        if (collection instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) collection;
            if (isValidType(enumSet.elementClass)) {
                HugeEnumSet hugeEnumSet = (HugeEnumSet) enumSet;
                boolean z2 = false;
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = z2;
                    if (i2 >= this.bits.length) {
                        break;
                    }
                    long j = this.bits[i2];
                    long j2 = j & hugeEnumSet.bits[i2];
                    if (j != j2) {
                        this.bits[i2] = j2;
                        this.size += Long.bitCount(j2) - Long.bitCount(j);
                        z2 = true;
                    }
                    i = i2 + 1;
                }
            } else if (this.size <= 0) {
                return false;
            } else {
                clear();
                z = true;
            }
            return z;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.EnumSet
    void setRange(E e, E e2) {
        int ordinal = e.ordinal();
        int i = ordinal / 64;
        int i2 = ordinal % 64;
        int ordinal2 = e2.ordinal();
        int i3 = ordinal2 / 64;
        int i4 = ordinal2 % 64;
        if (i == i3) {
            this.size -= Long.bitCount(this.bits[i]);
            long[] jArr = this.bits;
            jArr[i] = jArr[i] | (((-1) >>> (64 - ((i4 - i2) + 1))) << i2);
            this.size += Long.bitCount(this.bits[i]);
            return;
        }
        this.size -= Long.bitCount(this.bits[i]);
        long[] jArr2 = this.bits;
        jArr2[i] = jArr2[i] | (((-1) >>> i2) << i2);
        this.size += Long.bitCount(this.bits[i]);
        this.size -= Long.bitCount(this.bits[i3]);
        long[] jArr3 = this.bits;
        jArr3[i3] = jArr3[i3] | ((-1) >>> (64 - (i4 + 1)));
        this.size += Long.bitCount(this.bits[i3]);
        while (true) {
            i++;
            if (i > i3 - 1) {
                return;
            }
            this.size -= Long.bitCount(this.bits[i]);
            this.bits[i] = -1;
            this.size += Long.bitCount(this.bits[i]);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
