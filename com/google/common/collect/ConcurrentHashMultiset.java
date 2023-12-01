package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ConcurrentHashMultiset.class */
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ConcurrentHashMultiset$EntrySet.class */
    class EntrySet extends AbstractMultiset<E>.EntrySet {
        private EntrySet() {
            super();
        }

        private List<Multiset.Entry<E>> snapshot() {
            ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(newArrayListWithExpectedSize, iterator());
            return newArrayListWithExpectedSize;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        public ConcurrentHashMultiset<E> multiset() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return snapshot().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) snapshot().toArray(tArr);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ConcurrentHashMultiset$FieldSettersHolder.class */
    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");

        private FieldSettersHolder() {
        }
    }

    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set((Serialization.FieldSetter<ConcurrentHashMultiset>) this, (Object) ((ConcurrentMap) objectInputStream.readObject()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
        for (Multiset.Entry entry : entrySet()) {
            Object element = entry.getElement();
            int count = entry.getCount();
            while (true) {
                int i = count;
                if (i > 0) {
                    newArrayListWithExpectedSize.add(element);
                    count = i - 1;
                }
            }
        }
        return newArrayListWithExpectedSize;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
        r0 = new java.util.concurrent.atomic.AtomicInteger(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
        if (r6.countMap.putIfAbsent(r7, r0) == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return 0;
     */
    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int add(E r7, int r8) {
        /*
            r6 = this;
            r0 = r7
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r8
            if (r0 != 0) goto Lf
            r0 = r6
            r1 = r7
            int r0 = r0.count(r1)
            return r0
        Lf:
            r0 = r8
            java.lang.String r1 = "occurences"
            com.google.common.collect.CollectPreconditions.checkPositive(r0, r1)
        L15:
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            java.lang.Object r0 = com.google.common.collect.Maps.safeGet(r0, r1)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r12 = r0
            r0 = r12
            r11 = r0
            r0 = r12
            if (r0 != 0) goto L4d
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r3 = r2
            r4 = r8
            r3.<init>(r4)
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r12 = r0
            r0 = r12
            r11 = r0
            r0 = r12
            if (r0 != 0) goto L4d
            r0 = 0
            return r0
        L4d:
            r0 = r11
            int r0 = r0.get()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L99
            r0 = r11
            r1 = r9
            r2 = r9
            r3 = r8
            int r2 = com.google.common.math.IntMath.checkedAdd(r2, r3)     // Catch: java.lang.ArithmeticException -> Lc5
            boolean r0 = r0.compareAndSet(r1, r2)     // Catch: java.lang.ArithmeticException -> Lc5
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L4d
            r0 = r9
            return r0
        L6b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "Overflow adding "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = " occurrences to a count of "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r7
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L99:
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r12 = r0
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r12
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 == 0) goto Lc3
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r11
            r3 = r12
            boolean r0 = r0.replace(r1, r2, r3)
            if (r0 == 0) goto L15
        Lc3:
            r0 = 0
            return r0
        Lc5:
            r7 = move-exception
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.add(java.lang.Object, int):int");
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Set<E> createElementSet() {
        final Set<E> keySet = this.countMap.keySet();
        return new ForwardingSet<E>() { // from class: com.google.common.collect.ConcurrentHashMultiset.1
            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return obj != null && Collections2.safeContains(keySet, obj);
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return standardContainsAll(collection);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<E> delegate() {
                return keySet;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return obj != null && Collections2.safeRemove(keySet, obj);
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return standardRemoveAll(collection);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> entryIterator() {
        final AbstractIterator<Multiset.Entry<E>> abstractIterator = new AbstractIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.ConcurrentHashMultiset.2
            private final Iterator<Map.Entry<E, AtomicInteger>> mapEntries;

            {
                this.mapEntries = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            public Multiset.Entry<E> computeNext() {
                while (this.mapEntries.hasNext()) {
                    Map.Entry<E, AtomicInteger> next = this.mapEntries.next();
                    int i = next.getValue().get();
                    if (i != 0) {
                        return Multisets.immutableEntry(next.getKey(), i);
                    }
                }
                return endOfData();
            }
        };
        return new ForwardingIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.ConcurrentHashMultiset.3
            @NullableDecl
            private Multiset.Entry<E> last;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
            public Iterator<Multiset.Entry<E>> delegate() {
                return abstractIterator;
            }

            @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
            public Multiset.Entry<E> next() {
                Multiset.Entry<E> entry = (Multiset.Entry) super.next();
                this.last = entry;
                return entry;
            }

            @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
            public void remove() {
                CollectPreconditions.checkRemove(this.last != null);
                ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
                this.last = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@NullableDecl Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        CollectPreconditions.checkPositive(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    public boolean removeExactly(@NullableDecl Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        CollectPreconditions.checkPositive(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
        if (r8 != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
        r0 = new java.util.concurrent.atomic.AtomicInteger(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (r6.countMap.putIfAbsent(r7, r0) == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return 0;
     */
    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setCount(E r7, int r8) {
        /*
            r6 = this;
            r0 = r7
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r8
            java.lang.String r1 = "count"
            int r0 = com.google.common.collect.CollectPreconditions.checkNonnegative(r0, r1)
        Ld:
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            java.lang.Object r0 = com.google.common.collect.Maps.safeGet(r0, r1)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            if (r0 != 0) goto L4b
            r0 = r8
            if (r0 != 0) goto L29
            r0 = 0
            return r0
        L29:
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r3 = r2
            r4 = r8
            r3.<init>(r4)
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            if (r0 != 0) goto L4b
            r0 = 0
            return r0
        L4b:
            r0 = r10
            int r0 = r0.get()
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L87
            r0 = r8
            if (r0 != 0) goto L5b
            r0 = 0
            return r0
        L5b:
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r11 = r0
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r11
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 == 0) goto L85
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r10
            r3 = r11
            boolean r0 = r0.replace(r1, r2, r3)
            if (r0 == 0) goto Ld
        L85:
            r0 = 0
            return r0
        L87:
            r0 = r10
            r1 = r9
            r2 = r8
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L4b
            r0 = r8
            if (r0 != 0) goto La2
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r10
            boolean r0 = r0.remove(r1, r2)
        La2:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.setCount(java.lang.Object, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (r6.countMap.replace(r7, r0, r0) != false) goto L29;
     */
    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean setCount(E r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = r7
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r8
            java.lang.String r1 = "oldCount"
            int r0 = com.google.common.collect.CollectPreconditions.checkNonnegative(r0, r1)
            r0 = r9
            java.lang.String r1 = "newCount"
            int r0 = com.google.common.collect.CollectPreconditions.checkNonnegative(r0, r1)
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            java.lang.Object r0 = com.google.common.collect.Maps.safeGet(r0, r1)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r13 = r0
            r0 = 0
            r12 = r0
            r0 = 0
            r11 = r0
            r0 = r13
            if (r0 != 0) goto L54
            r0 = r8
            if (r0 == 0) goto L33
            r0 = 0
            return r0
        L33:
            r0 = r9
            if (r0 != 0) goto L39
            r0 = 1
            return r0
        L39:
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r3 = r2
            r4 = r9
            r3.<init>(r4)
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L51
            r0 = 1
            r11 = r0
        L51:
            r0 = r11
            return r0
        L54:
            r0 = r13
            int r0 = r0.get()
            r10 = r0
            r0 = r10
            r1 = r8
            if (r0 != r1) goto Lcb
            r0 = r10
            if (r0 != 0) goto Lad
            r0 = r9
            if (r0 != 0) goto L79
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r13
            boolean r0 = r0.remove(r1, r2)
            r0 = 1
            return r0
        L79:
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r1 = r0
            r2 = r9
            r1.<init>(r2)
            r14 = r0
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r14
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 == 0) goto La7
            r0 = r12
            r11 = r0
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r13
            r3 = r14
            boolean r0 = r0.replace(r1, r2, r3)
            if (r0 == 0) goto Laa
        La7:
            r0 = 1
            r11 = r0
        Laa:
            r0 = r11
            return r0
        Lad:
            r0 = r13
            r1 = r10
            r2 = r9
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto Lcb
            r0 = r9
            if (r0 != 0) goto Lc9
            r0 = r6
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r0.countMap
            r1 = r7
            r2 = r13
            boolean r0 = r0.remove(r1, r2)
        Lc9:
            r0 = 1
            return r0
        Lcb:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.setCount(java.lang.Object, int, int):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        Iterator<AtomicInteger> it = this.countMap.values().iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return Ints.saturatedCast(j2);
            }
            j = j2 + it.next().get();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }
}
