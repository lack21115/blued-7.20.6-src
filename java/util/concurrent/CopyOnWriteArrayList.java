package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CopyOnWriteArrayList.class */
public class CopyOnWriteArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 8673264195747942595L;
    private volatile transient Object[] elements;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CopyOnWriteArrayList$CowIterator.class */
    public static class CowIterator<E> implements ListIterator<E> {
        private final int from;
        private int index;
        private final Object[] snapshot;
        private final int to;

        CowIterator(Object[] objArr, int i, int i2) {
            this.index = 0;
            this.snapshot = objArr;
            this.from = i;
            this.to = i2;
            this.index = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.to;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > this.from;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index < this.to) {
                Object[] objArr = this.snapshot;
                int i = this.index;
                this.index = i + 1;
                return (E) objArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (this.index > this.from) {
                Object[] objArr = this.snapshot;
                int i = this.index - 1;
                this.index = i;
                return (E) objArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CopyOnWriteArrayList$CowSubList.class */
    class CowSubList extends AbstractList<E> {
        private volatile Slice slice;

        public CowSubList(Object[] objArr, int i, int i2) {
            this.slice = new Slice(objArr, i, i2);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, E e) {
            synchronized (CopyOnWriteArrayList.this) {
                this.slice.checkPositionIndex(i);
                this.slice.checkConcurrentModification(CopyOnWriteArrayList.this.elements);
                CopyOnWriteArrayList.this.add(this.slice.from + i, e);
                this.slice = new Slice(CopyOnWriteArrayList.this.elements, this.slice.from, this.slice.to + 1);
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            synchronized (CopyOnWriteArrayList.this) {
                add(this.slice.to - this.slice.from, e);
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (CopyOnWriteArrayList.this) {
                this.slice.checkPositionIndex(i);
                this.slice.checkConcurrentModification(CopyOnWriteArrayList.this.elements);
                int length = CopyOnWriteArrayList.this.elements.length;
                addAll = CopyOnWriteArrayList.this.addAll(this.slice.from + i, collection);
                this.slice = new Slice(CopyOnWriteArrayList.this.elements, this.slice.from, this.slice.to + (CopyOnWriteArrayList.this.elements.length - length));
            }
            return addAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (CopyOnWriteArrayList.this) {
                addAll = addAll(size(), collection);
            }
            return addAll;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            synchronized (CopyOnWriteArrayList.this) {
                this.slice.checkConcurrentModification(CopyOnWriteArrayList.this.elements);
                CopyOnWriteArrayList.this.removeRange(this.slice.from, this.slice.to);
                this.slice = new Slice(CopyOnWriteArrayList.this.elements, this.slice.from, this.slice.from);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return indexOf(obj) != -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Slice slice = this.slice;
            Object[] objArr = CopyOnWriteArrayList.this.elements;
            slice.checkConcurrentModification(objArr);
            return CopyOnWriteArrayList.containsAll(collection, objArr, slice.from, slice.to);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            Slice slice = this.slice;
            Object[] objArr = CopyOnWriteArrayList.this.elements;
            slice.checkElementIndex(i);
            slice.checkConcurrentModification(objArr);
            return (E) objArr[slice.from + i];
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int i = -1;
            Slice slice = this.slice;
            Object[] objArr = CopyOnWriteArrayList.this.elements;
            slice.checkConcurrentModification(objArr);
            int indexOf = CopyOnWriteArrayList.indexOf(obj, objArr, slice.from, slice.to);
            if (indexOf != -1) {
                i = indexOf - slice.from;
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            Slice slice = this.slice;
            return slice.from == slice.to;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int i = -1;
            Slice slice = this.slice;
            Object[] objArr = CopyOnWriteArrayList.this.elements;
            slice.checkConcurrentModification(objArr);
            int lastIndexOf = CopyOnWriteArrayList.lastIndexOf(obj, objArr, slice.from, slice.to);
            if (lastIndexOf != -1) {
                i = lastIndexOf - slice.from;
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i) {
            Slice slice = this.slice;
            Object[] objArr = CopyOnWriteArrayList.this.elements;
            slice.checkPositionIndex(i);
            slice.checkConcurrentModification(objArr);
            CowIterator cowIterator = new CowIterator(objArr, slice.from, slice.to);
            cowIterator.index = slice.from + i;
            return cowIterator;
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i) {
            E e;
            synchronized (CopyOnWriteArrayList.this) {
                this.slice.checkElementIndex(i);
                this.slice.checkConcurrentModification(CopyOnWriteArrayList.this.elements);
                e = (E) CopyOnWriteArrayList.this.remove(this.slice.from + i);
                this.slice = new Slice(CopyOnWriteArrayList.this.elements, this.slice.from, this.slice.to - 1);
            }
            return e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            synchronized (CopyOnWriteArrayList.this) {
                int indexOf = indexOf(obj);
                if (indexOf == -1) {
                    return false;
                }
                remove(indexOf);
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            synchronized (CopyOnWriteArrayList.this) {
                this.slice.checkConcurrentModification(CopyOnWriteArrayList.this.elements);
                int removeOrRetain = CopyOnWriteArrayList.this.removeOrRetain(collection, false, this.slice.from, this.slice.to);
                this.slice = new Slice(CopyOnWriteArrayList.this.elements, this.slice.from, this.slice.to - removeOrRetain);
                if (removeOrRetain != 0) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean z = true;
            synchronized (CopyOnWriteArrayList.this) {
                this.slice.checkConcurrentModification(CopyOnWriteArrayList.this.elements);
                int removeOrRetain = CopyOnWriteArrayList.this.removeOrRetain(collection, true, this.slice.from, this.slice.to);
                this.slice = new Slice(CopyOnWriteArrayList.this.elements, this.slice.from, this.slice.to - removeOrRetain);
                if (removeOrRetain == 0) {
                    z = false;
                }
            }
            return z;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            E e2;
            synchronized (CopyOnWriteArrayList.this) {
                this.slice.checkElementIndex(i);
                this.slice.checkConcurrentModification(CopyOnWriteArrayList.this.elements);
                e2 = (E) CopyOnWriteArrayList.this.set(this.slice.from + i, e);
                this.slice = new Slice(CopyOnWriteArrayList.this.elements, this.slice.from, this.slice.to);
            }
            return e2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            Slice slice = this.slice;
            return slice.to - slice.from;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i, int i2) {
            Slice slice = this.slice;
            if (i < 0 || i > i2 || i2 > size()) {
                throw new IndexOutOfBoundsException("from=" + i + ", to=" + i2 + ", list size=" + size());
            }
            return new CowSubList(slice.expectedElements, slice.from + i, slice.from + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CopyOnWriteArrayList$Slice.class */
    public static class Slice {
        private final Object[] expectedElements;
        private final int from;
        private final int to;

        Slice(Object[] objArr, int i, int i2) {
            this.expectedElements = objArr;
            this.from = i;
            this.to = i2;
        }

        void checkConcurrentModification(Object[] objArr) {
            if (this.expectedElements != objArr) {
                throw new ConcurrentModificationException();
            }
        }

        void checkElementIndex(int i) {
            if (i < 0 || i >= this.to - this.from) {
                throw new IndexOutOfBoundsException("index=" + i + ", size=" + (this.to - this.from));
            }
        }

        void checkPositionIndex(int i) {
            if (i < 0 || i > this.to - this.from) {
                throw new IndexOutOfBoundsException("index=" + i + ", size=" + (this.to - this.from));
            }
        }
    }

    public CopyOnWriteArrayList() {
        this.elements = EmptyArray.OBJECT;
    }

    public CopyOnWriteArrayList(Collection<? extends E> collection) {
        this(collection.toArray());
    }

    public CopyOnWriteArrayList(E[] eArr) {
        this.elements = Arrays.copyOf(eArr, eArr.length, Object[].class);
    }

    static boolean containsAll(Collection<?> collection, Object[] objArr, int i, int i2) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (indexOf(it.next(), objArr, i, i2) == -1) {
                return false;
            }
        }
        return true;
    }

    static int indexOf(Object obj, Object[] objArr, int i, int i2) {
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < i2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static int lastIndexOf(Object obj, Object[] objArr, int i, int i2) {
        if (obj == null) {
            while (true) {
                i2--;
                if (i2 < i) {
                    return -1;
                }
                if (objArr[i2] == null) {
                    return i2;
                }
            }
        } else {
            while (true) {
                i2--;
                if (i2 < i) {
                    return -1;
                }
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        synchronized (this) {
            objectInputStream.defaultReadObject();
            Object[] objArr = new Object[objectInputStream.readInt()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < objArr.length) {
                    objArr[i2] = objectInputStream.readObject();
                    i = i2 + 1;
                } else {
                    this.elements = objArr;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int removeOrRetain(Collection<?> collection, boolean z, int i, int i2) {
        int i3;
        while (true) {
            i3 = 0;
            if (i >= i2) {
                break;
            } else if (collection.contains(this.elements[i]) == z) {
                i++;
            } else {
                Object[] objArr = new Object[this.elements.length - 1];
                System.arraycopy(this.elements, 0, objArr, 0, i);
                int i4 = i;
                while (true) {
                    int i5 = i4 + 1;
                    if (i5 >= i2) {
                        break;
                    }
                    if (collection.contains(this.elements[i5]) == z) {
                        objArr[i] = this.elements[i5];
                        i++;
                    }
                    i4 = i5;
                }
                System.arraycopy(this.elements, i2, objArr, i, this.elements.length - i2);
                int length = i + (this.elements.length - i2);
                Object[] objArr2 = objArr;
                if (length < objArr.length) {
                    objArr2 = Arrays.copyOfRange(objArr, 0, length);
                }
                i3 = this.elements.length - objArr2.length;
                this.elements = objArr2;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRange(int i, int i2) {
        Object[] objArr = new Object[this.elements.length - (i2 - i)];
        System.arraycopy(this.elements, 0, objArr, 0, i);
        System.arraycopy(this.elements, i2, objArr, i, this.elements.length - i2);
        this.elements = objArr;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object[] objArr = this.elements;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(objArr.length);
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            objectOutputStream.writeObject(objArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        synchronized (this) {
            Object[] objArr = new Object[this.elements.length + 1];
            System.arraycopy(this.elements, 0, objArr, 0, i);
            objArr[i] = e;
            System.arraycopy(this.elements, i, objArr, i + 1, this.elements.length - i);
            this.elements = objArr;
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean add(E e) {
        synchronized (this) {
            Object[] objArr = new Object[this.elements.length + 1];
            System.arraycopy(this.elements, 0, objArr, 0, this.elements.length);
            objArr[this.elements.length] = e;
            this.elements = objArr;
        }
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean z = false;
        synchronized (this) {
            Object[] array = collection.toArray();
            Object[] objArr = new Object[this.elements.length + array.length];
            System.arraycopy(this.elements, 0, objArr, 0, i);
            System.arraycopy(array, 0, objArr, i, array.length);
            System.arraycopy(this.elements, i, objArr, array.length + i, this.elements.length - i);
            this.elements = objArr;
            if (array.length > 0) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this) {
            addAll = addAll(this.elements.length, collection);
        }
        return addAll;
    }

    public int addAllAbsent(Collection<? extends E> collection) {
        int i;
        synchronized (this) {
            Object[] array = collection.toArray();
            Object[] objArr = new Object[this.elements.length + array.length];
            System.arraycopy(this.elements, 0, objArr, 0, this.elements.length);
            i = 0;
            for (Object obj : array) {
                if (indexOf(obj, objArr, 0, this.elements.length + i) == -1) {
                    objArr[this.elements.length + i] = obj;
                    i++;
                }
            }
            Object[] objArr2 = objArr;
            if (i < array.length) {
                objArr2 = Arrays.copyOfRange(objArr, 0, this.elements.length + i);
            }
            this.elements = objArr2;
        }
        return i;
    }

    public boolean addIfAbsent(E e) {
        boolean z;
        synchronized (this) {
            if (contains(e)) {
                z = false;
            } else {
                add(e);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public void clear() {
        synchronized (this) {
            this.elements = EmptyArray.OBJECT;
        }
    }

    public Object clone() {
        try {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) super.clone();
            copyOnWriteArrayList.elements = (Object[]) copyOnWriteArrayList.elements.clone();
            return copyOnWriteArrayList;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Object[] objArr = this.elements;
        return containsAll(collection, objArr, 0, objArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (java.util.Arrays.equals(r3.elements, ((java.util.concurrent.CopyOnWriteArrayList) r4).elements) != false) goto L10;
     */
    @Override // java.util.List, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 1
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = r4
            boolean r0 = r0 instanceof java.util.concurrent.CopyOnWriteArrayList
            if (r0 == 0) goto L2d
            r0 = r3
            r1 = r4
            if (r0 == r1) goto L27
            r0 = r9
            r7 = r0
            r0 = r3
            java.lang.Object[] r0 = r0.elements
            r1 = r4
            java.util.concurrent.CopyOnWriteArrayList r1 = (java.util.concurrent.CopyOnWriteArrayList) r1
            java.lang.Object[] r1 = r1.elements
            boolean r0 = java.util.Arrays.equals(r0, r1)
            if (r0 == 0) goto L2a
        L27:
            r0 = 1
            r7 = r0
        L2a:
            r0 = r7
            return r0
        L2d:
            r0 = r9
            r7 = r0
            r0 = r4
            boolean r0 = r0 instanceof java.util.List
            if (r0 == 0) goto L2a
            r0 = r3
            java.lang.Object[] r0 = r0.elements
            r10 = r0
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
            r0 = r10
            int r0 = r0.length
            r6 = r0
            r0 = 0
            r5 = r0
        L4e:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L7f
            r0 = r10
            r1 = r5
            r0 = r0[r1]
            r11 = r0
            r0 = r9
            r7 = r0
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L2a
            r0 = r9
            r7 = r0
            r0 = r11
            r1 = r4
            java.lang.Object r1 = r1.next()
            boolean r0 = libcore.util.Objects.equal(r0, r1)
            if (r0 == 0) goto L2a
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L4e
        L7f:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L8f
            r0 = r8
            r7 = r0
        L8c:
            r0 = r7
            return r0
        L8f:
            r0 = 0
            r7 = r0
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.CopyOnWriteArrayList.equals(java.lang.Object):boolean");
    }

    @Override // java.util.List
    public E get(int i) {
        return (E) this.elements[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] getArray() {
        return this.elements;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int hashCode() {
        return Arrays.hashCode(this.elements);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Object[] objArr = this.elements;
        return indexOf(obj, objArr, 0, objArr.length);
    }

    public int indexOf(E e, int i) {
        Object[] objArr = this.elements;
        return indexOf(e, objArr, i, objArr.length);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.elements.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        Object[] objArr = this.elements;
        return new CowIterator(objArr, 0, objArr.length);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        Object[] objArr = this.elements;
        return lastIndexOf(obj, objArr, 0, objArr.length);
    }

    public int lastIndexOf(E e, int i) {
        return lastIndexOf(e, this.elements, 0, i);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        Object[] objArr = this.elements;
        return new CowIterator(objArr, 0, objArr.length);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        Object[] objArr = this.elements;
        if (i < 0 || i > objArr.length) {
            throw new IndexOutOfBoundsException("index=" + i + ", length=" + objArr.length);
        }
        CowIterator cowIterator = new CowIterator(objArr, 0, objArr.length);
        cowIterator.index = i;
        return cowIterator;
    }

    @Override // java.util.List
    public E remove(int i) {
        E e;
        synchronized (this) {
            e = (E) this.elements[i];
            removeRange(i, i + 1);
        }
        return e;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean z;
        synchronized (this) {
            int indexOf = indexOf(obj);
            if (indexOf == -1) {
                z = false;
            } else {
                remove(indexOf);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        synchronized (this) {
            if (removeOrRetain(collection, false, 0, this.elements.length) != 0) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = true;
        synchronized (this) {
            if (removeOrRetain(collection, true, 0, this.elements.length) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // java.util.List
    public E set(int i, E e) {
        E e2;
        synchronized (this) {
            Object[] objArr = (Object[]) this.elements.clone();
            e2 = (E) objArr[i];
            objArr[i] = e;
            this.elements = objArr;
        }
        return e2;
    }

    @Override // java.util.List
    public int size() {
        return this.elements.length;
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        Object[] objArr = this.elements;
        if (i < 0 || i > i2 || i2 > objArr.length) {
            throw new IndexOutOfBoundsException("from=" + i + ", to=" + i2 + ", list size=" + objArr.length);
        }
        return new CowSubList(objArr, i, i2);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return (Object[]) this.elements.clone();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = this.elements;
        if (objArr.length > tArr.length) {
            return (T[]) Arrays.copyOf(objArr, objArr.length, tArr.getClass());
        }
        System.arraycopy(objArr, 0, tArr, 0, objArr.length);
        if (objArr.length < tArr.length) {
            tArr[objArr.length] = null;
        }
        return tArr;
    }

    public String toString() {
        return Arrays.toString(this.elements);
    }
}
