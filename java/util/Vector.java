package java.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collections;

/* loaded from: source-2895416-dex2jar.jar:java/util/Vector.class */
public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final int DEFAULT_SIZE = 10;
    private static final long serialVersionUID = -2767605614048989439L;
    protected int capacityIncrement;
    protected int elementCount;
    protected Object[] elementData;

    public Vector() {
        this(10, 0);
    }

    public Vector(int i) {
        this(i, 0);
    }

    public Vector(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        this.elementData = newElementArray(i);
        this.elementCount = 0;
        this.capacityIncrement = i2;
    }

    public Vector(Collection<? extends E> collection) {
        this(collection.size(), 0);
        for (E e : collection) {
            Object[] objArr = this.elementData;
            int i = this.elementCount;
            this.elementCount = i + 1;
            objArr[i] = e;
        }
    }

    private static ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException(int i, int i2) {
        throw new ArrayIndexOutOfBoundsException(i2, i);
    }

    private void grow(int i) {
        E[] newElementArray = newElementArray(i);
        System.arraycopy(this.elementData, 0, newElementArray, 0, this.elementCount);
        this.elementData = newElementArray;
    }

    private void growBy(int i) {
        int i2;
        if (this.capacityIncrement <= 0) {
            int length = this.elementData.length;
            int i3 = length;
            if (length == 0) {
                i3 = i;
            }
            while (true) {
                i2 = i3;
                if (i3 >= i) {
                    break;
                }
                i3 += i3;
            }
        } else {
            int i4 = (i / this.capacityIncrement) * this.capacityIncrement;
            i2 = i4;
            if (i4 < i) {
                i2 = i4 + this.capacityIncrement;
            }
        }
        E[] newElementArray = newElementArray(this.elementData.length + i2);
        System.arraycopy(this.elementData, 0, newElementArray, 0, this.elementCount);
        this.elementData = newElementArray;
    }

    private void growByOne() {
        int i;
        if (this.capacityIncrement <= 0) {
            int length = this.elementData.length;
            i = length;
            if (length == 0) {
                i = 1;
            }
        } else {
            i = this.capacityIncrement;
        }
        E[] newElementArray = newElementArray(this.elementData.length + i);
        System.arraycopy(this.elementData, 0, newElementArray, 0, this.elementCount);
        this.elementData = newElementArray;
    }

    private E[] newElementArray(int i) {
        return (E[]) new Object[i];
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this) {
            objectOutputStream.defaultWriteObject();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        insertElementAt(e, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        synchronized (this) {
            if (this.elementCount == this.elementData.length) {
                growByOne();
            }
            Object[] objArr = this.elementData;
            int i = this.elementCount;
            this.elementCount = i + 1;
            objArr[i] = e;
            this.modCount++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean z;
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (i <= this.elementCount) {
                        int size = collection.size();
                        if (size == 0) {
                            z = false;
                        } else {
                            int length = size - (this.elementData.length - this.elementCount);
                            if (length > 0) {
                                growBy(length);
                            }
                            int i2 = this.elementCount - i;
                            if (i2 > 0) {
                                System.arraycopy(this.elementData, i, this.elementData, i + size, i2);
                            }
                            for (E e : collection) {
                                try {
                                    this.elementData[i] = e;
                                    i++;
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                            this.elementCount += size;
                            this.modCount++;
                            z = true;
                        }
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            throw arrayIndexOutOfBoundsException(i, this.elementCount);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this) {
            addAll = addAll(this.elementCount, collection);
        }
        return addAll;
    }

    public void addElement(E e) {
        synchronized (this) {
            if (this.elementCount == this.elementData.length) {
                growByOne();
            }
            Object[] objArr = this.elementData;
            int i = this.elementCount;
            this.elementCount = i + 1;
            objArr[i] = e;
            this.modCount++;
        }
    }

    public int capacity() {
        int length;
        synchronized (this) {
            length = this.elementData.length;
        }
        return length;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        removeAllElements();
    }

    public Object clone() {
        Vector vector;
        synchronized (this) {
            try {
                vector = (Vector) super.clone();
                vector.elementData = (Object[]) this.elementData.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
        return vector;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean z = false;
        if (indexOf(obj, 0) != -1) {
            z = true;
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this) {
            containsAll = super.containsAll(collection);
        }
        return containsAll;
    }

    public void copyInto(Object[] objArr) {
        synchronized (this) {
            System.arraycopy(this.elementData, 0, objArr, 0, this.elementCount);
        }
    }

    public E elementAt(int i) {
        E e;
        synchronized (this) {
            if (i >= this.elementCount) {
                throw arrayIndexOutOfBoundsException(i, this.elementCount);
            }
            e = (E) this.elementData[i];
        }
        return e;
    }

    public Enumeration<E> elements() {
        return new Enumeration<E>() { // from class: java.util.Vector.1
            int pos = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.pos < Vector.this.elementCount;
            }

            @Override // java.util.Enumeration
            public E nextElement() {
                synchronized (Vector.this) {
                    if (this.pos < Vector.this.elementCount) {
                        Object[] objArr = Vector.this.elementData;
                        int i = this.pos;
                        this.pos = i + 1;
                        return (E) objArr[i];
                    }
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public void ensureCapacity(int i) {
        synchronized (this) {
            if (this.elementData.length < i) {
                int length = (this.capacityIncrement <= 0 ? this.elementData.length : this.capacityIncrement) + this.elementData.length;
                if (i <= length) {
                    i = length;
                }
                grow(i);
            }
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        boolean z;
        synchronized (this) {
            if (this == obj) {
                z = true;
            } else if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() != this.elementCount) {
                    z = false;
                } else {
                    Iterator<E> it = list.iterator();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        z = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = this.elementData[i2];
                        E next = it.next();
                        if (obj2 == null) {
                            if (next != null) {
                                break;
                            }
                            i = i2 + 1;
                        } else if (!obj2.equals(next)) {
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                    z = false;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public E firstElement() {
        E e;
        synchronized (this) {
            if (this.elementCount <= 0) {
                throw new NoSuchElementException();
            }
            e = (E) this.elementData[0];
        }
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return elementAt(i);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public int hashCode() {
        int i;
        synchronized (this) {
            i = 1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.elementCount) {
                    i = (i * 31) + (this.elementData[i3] == null ? 0 : this.elementData[i3].hashCode());
                    i2 = i3 + 1;
                }
            }
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return indexOf(obj, 0);
    }

    public int indexOf(Object obj, int i) {
        synchronized (this) {
            if (obj != null) {
                while (i < this.elementCount) {
                    if (obj.equals(this.elementData[i])) {
                        break;
                    }
                    i++;
                }
                i = -1;
            } else {
                while (i < this.elementCount) {
                    if (this.elementData[i] == null) {
                        break;
                    }
                    i++;
                }
                i = -1;
            }
        }
        return i;
    }

    public void insertElementAt(E e, int i) {
        synchronized (this) {
            if (i >= 0) {
                if (i <= this.elementCount) {
                    if (this.elementCount == this.elementData.length) {
                        growByOne();
                    }
                    int i2 = this.elementCount - i;
                    if (i2 > 0) {
                        System.arraycopy(this.elementData, i, this.elementData, i + 1, i2);
                    }
                    this.elementData[i] = e;
                    this.elementCount++;
                    this.modCount++;
                }
            }
            throw arrayIndexOutOfBoundsException(i, this.elementCount);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        boolean z;
        synchronized (this) {
            z = this.elementCount == 0;
        }
        return z;
    }

    public E lastElement() {
        E e;
        synchronized (this) {
            try {
                e = (E) this.elementData[this.elementCount - 1];
            } catch (IndexOutOfBoundsException e2) {
                throw new NoSuchElementException();
            }
        }
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this) {
            lastIndexOf = lastIndexOf(obj, this.elementCount - 1);
        }
        return lastIndexOf;
    }

    public int lastIndexOf(Object obj, int i) {
        synchronized (this) {
            if (i >= this.elementCount) {
                throw arrayIndexOutOfBoundsException(i, this.elementCount);
            }
            if (obj != null) {
                while (i >= 0) {
                    if (obj.equals(this.elementData[i])) {
                        break;
                    }
                    i--;
                }
                i = -1;
            } else {
                while (i >= 0) {
                    if (this.elementData[i] == null) {
                        break;
                    }
                    i--;
                }
                i = -1;
            }
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        E e;
        synchronized (this) {
            if (i >= this.elementCount) {
                throw arrayIndexOutOfBoundsException(i, this.elementCount);
            }
            e = (E) this.elementData[i];
            this.elementCount--;
            int i2 = this.elementCount - i;
            if (i2 > 0) {
                System.arraycopy(this.elementData, i + 1, this.elementData, i, i2);
            }
            this.elementData[this.elementCount] = null;
            this.modCount++;
        }
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return removeElement(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this) {
            removeAll = super.removeAll(collection);
        }
        return removeAll;
    }

    public void removeAllElements() {
        synchronized (this) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.elementCount) {
                    this.elementData[i2] = null;
                    i = i2 + 1;
                } else {
                    this.modCount++;
                    this.elementCount = 0;
                }
            }
        }
    }

    public boolean removeElement(Object obj) {
        boolean z = false;
        synchronized (this) {
            int indexOf = indexOf(obj, 0);
            if (indexOf != -1) {
                removeElementAt(indexOf);
                z = true;
            }
        }
        return z;
    }

    public void removeElementAt(int i) {
        synchronized (this) {
            if (i >= 0) {
                if (i < this.elementCount) {
                    this.elementCount--;
                    int i2 = this.elementCount - i;
                    if (i2 > 0) {
                        System.arraycopy(this.elementData, i + 1, this.elementData, i, i2);
                    }
                    this.elementData[this.elementCount] = null;
                    this.modCount++;
                }
            }
            throw arrayIndexOutOfBoundsException(i, this.elementCount);
        }
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.elementCount) {
            throw new IndexOutOfBoundsException();
        }
        if (i == i2) {
            return;
        }
        if (i2 != this.elementCount) {
            System.arraycopy(this.elementData, i2, this.elementData, i, this.elementCount - i2);
            int i3 = this.elementCount - (i2 - i);
            Arrays.fill(this.elementData, i3, this.elementCount, (Object) null);
            this.elementCount = i3;
        } else {
            Arrays.fill(this.elementData, i, this.elementCount, (Object) null);
            this.elementCount = i;
        }
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this) {
            retainAll = super.retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        E e2;
        synchronized (this) {
            if (i >= this.elementCount) {
                throw arrayIndexOutOfBoundsException(i, this.elementCount);
            }
            e2 = (E) this.elementData[i];
            this.elementData[i] = e;
        }
        return e2;
    }

    public void setElementAt(E e, int i) {
        synchronized (this) {
            if (i >= this.elementCount) {
                throw arrayIndexOutOfBoundsException(i, this.elementCount);
            }
            this.elementData[i] = e;
        }
    }

    public void setSize(int i) {
        synchronized (this) {
            if (i != this.elementCount) {
                ensureCapacity(i);
                if (this.elementCount > i) {
                    Arrays.fill(this.elementData, i, this.elementCount, (Object) null);
                }
                this.elementCount = i;
                this.modCount++;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int i;
        synchronized (this) {
            i = this.elementCount;
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i2) {
        Collections.SynchronizedRandomAccessList synchronizedRandomAccessList;
        synchronized (this) {
            synchronizedRandomAccessList = new Collections.SynchronizedRandomAccessList(super.subList(i, i2), this);
        }
        return synchronizedRandomAccessList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr;
        synchronized (this) {
            objArr = new Object[this.elementCount];
            System.arraycopy(this.elementData, 0, objArr, 0, this.elementCount);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this) {
            tArr2 = tArr;
            if (this.elementCount > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.elementCount);
            }
            System.arraycopy(this.elementData, 0, tArr2, 0, this.elementCount);
            if (this.elementCount < tArr2.length) {
                tArr2[this.elementCount] = null;
            }
        }
        return tArr2;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String sb;
        synchronized (this) {
            if (this.elementCount == 0) {
                sb = "[]";
            } else {
                int i = this.elementCount - 1;
                StringBuilder sb2 = new StringBuilder(this.elementCount * 16);
                sb2.append('[');
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        break;
                    }
                    if (this.elementData[i3] == this) {
                        sb2.append("(this Collection)");
                    } else {
                        sb2.append(this.elementData[i3]);
                    }
                    sb2.append(", ");
                    i2 = i3 + 1;
                }
                if (this.elementData[i] == this) {
                    sb2.append("(this Collection)");
                } else {
                    sb2.append(this.elementData[i]);
                }
                sb2.append(']');
                sb = sb2.toString();
            }
        }
        return sb;
    }

    public void trimToSize() {
        synchronized (this) {
            if (this.elementData.length != this.elementCount) {
                grow(this.elementCount);
            }
        }
    }
}
