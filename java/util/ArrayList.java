package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/util/ArrayList.class */
public class ArrayList<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {
    private static final int MIN_CAPACITY_INCREMENT = 12;
    private static final long serialVersionUID = 8683452581122892189L;
    transient Object[] array;
    int size;

    /* loaded from: source-2895416-dex2jar.jar:java/util/ArrayList$ArrayListIterator.class */
    private class ArrayListIterator implements Iterator<E> {
        private int expectedModCount;
        private int remaining;
        private int removalIndex;

        private ArrayListIterator() {
            this.remaining = ArrayList.this.size;
            this.removalIndex = -1;
            this.expectedModCount = ArrayList.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.remaining != 0;
        }

        @Override // java.util.Iterator
        public E next() {
            ArrayList arrayList = ArrayList.this;
            int i = this.remaining;
            if (arrayList.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (i == 0) {
                throw new NoSuchElementException();
            }
            this.remaining = i - 1;
            Object[] objArr = arrayList.array;
            int i2 = arrayList.size - i;
            this.removalIndex = i2;
            return (E) objArr[i2];
        }

        @Override // java.util.Iterator
        public void remove() {
            Object[] objArr = ArrayList.this.array;
            int i = this.removalIndex;
            if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0) {
                throw new IllegalStateException();
            }
            System.arraycopy(objArr, i + 1, objArr, i, this.remaining);
            ArrayList arrayList = ArrayList.this;
            int i2 = arrayList.size - 1;
            arrayList.size = i2;
            objArr[i2] = null;
            this.removalIndex = -1;
            ArrayList arrayList2 = ArrayList.this;
            int i3 = arrayList2.modCount + 1;
            arrayList2.modCount = i3;
            this.expectedModCount = i3;
        }
    }

    public ArrayList() {
        this.array = EmptyArray.OBJECT;
    }

    public ArrayList(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        this.array = i == 0 ? EmptyArray.OBJECT : new Object[i];
    }

    public ArrayList(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("collection == null");
        }
        Object[] array = collection.toArray();
        Object[] objArr = array;
        if (array.getClass() != Object[].class) {
            objArr = new Object[array.length];
            System.arraycopy(array, 0, objArr, 0, array.length);
        }
        this.array = objArr;
        this.size = objArr.length;
    }

    private static int newCapacity(int i) {
        return i + (i < 6 ? 12 : i >> 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < this.size) {
            throw new InvalidObjectException("Capacity: " + readInt + " < size: " + this.size);
        }
        this.array = readInt == 0 ? EmptyArray.OBJECT : new Object[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return;
            }
            this.array[i2] = objectInputStream.readObject();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IndexOutOfBoundsException throwIndexOutOfBoundsException(int i, int i2) {
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + i2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.array.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return;
            }
            objectOutputStream.writeObject(this.array[i2]);
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        Object[] objArr = this.array;
        int i2 = this.size;
        if (i > i2 || i < 0) {
            throwIndexOutOfBoundsException(i, i2);
        }
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[newCapacity(i2)];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(objArr, i, objArr2, i + 1, i2 - i);
            objArr = objArr2;
            this.array = objArr2;
        }
        objArr[i] = e;
        this.size = i2 + 1;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        Object[] objArr = this.array;
        int i = this.size;
        Object[] objArr2 = objArr;
        if (i == objArr.length) {
            Object[] objArr3 = new Object[(i < 6 ? 12 : i >> 1) + i];
            System.arraycopy(objArr, 0, objArr3, 0, i);
            objArr2 = objArr3;
            this.array = objArr3;
        }
        objArr2[i] = e;
        this.size = i + 1;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        int i2 = this.size;
        if (i > i2 || i < 0) {
            throwIndexOutOfBoundsException(i, i2);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        if (length == 0) {
            return false;
        }
        Object[] objArr = this.array;
        int i3 = i2 + length;
        if (i3 <= objArr.length) {
            System.arraycopy(objArr, i, objArr, i + length, i2 - i);
        } else {
            Object[] objArr2 = new Object[newCapacity(i3 - 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(objArr, i, objArr2, i + length, i2 - i);
            objArr = objArr2;
            this.array = objArr2;
        }
        System.arraycopy(array, 0, objArr, i, length);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        Object[] array = collection.toArray();
        int length = array.length;
        if (length == 0) {
            return false;
        }
        Object[] objArr = this.array;
        int i = this.size;
        int i2 = i + length;
        Object[] objArr2 = objArr;
        if (i2 > objArr.length) {
            Object[] objArr3 = new Object[newCapacity(i2 - 1)];
            System.arraycopy(objArr, 0, objArr3, 0, i);
            objArr2 = objArr3;
            this.array = objArr3;
        }
        System.arraycopy(array, 0, objArr2, i, length);
        this.size = i2;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            Arrays.fill(this.array, 0, this.size, (Object) null);
            this.size = 0;
            this.modCount++;
        }
    }

    public Object clone() {
        try {
            ArrayList arrayList = (ArrayList) super.clone();
            arrayList.array = (Object[]) this.array.clone();
            return arrayList;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.array;
        int i = this.size;
        if (obj != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return false;
                }
                if (obj.equals(objArr[i3])) {
                    return true;
                }
                i2 = i3 + 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i) {
                    return false;
                }
                if (objArr[i5] == null) {
                    return true;
                }
                i4 = i5 + 1;
            }
        }
    }

    public void ensureCapacity(int i) {
        Object[] objArr = this.array;
        if (objArr.length < i) {
            Object[] objArr2 = new Object[i];
            System.arraycopy(objArr, 0, objArr2, 0, this.size);
            this.array = objArr2;
            this.modCount++;
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int i = this.size;
        if (list.size() != i) {
            return false;
        }
        Object[] objArr = this.array;
        if (list instanceof RandomAccess) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return true;
                }
                Object obj2 = objArr[i3];
                Object obj3 = list.get(i3);
                if (obj2 == null) {
                    if (obj3 != null) {
                        return false;
                    }
                } else if (!obj2.equals(obj3)) {
                    return false;
                }
                i2 = i3 + 1;
            }
        } else {
            Iterator<E> it = list.iterator();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i) {
                    return true;
                }
                Object obj4 = objArr[i5];
                E next = it.next();
                if (obj4 == null) {
                    if (next != null) {
                        return false;
                    }
                } else if (!obj4.equals(next)) {
                    return false;
                }
                i4 = i5 + 1;
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (i >= this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        return (E) this.array[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public int hashCode() {
        Object[] objArr = this.array;
        int i = 1;
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[i3];
            i = (i * 31) + (obj == null ? 0 : obj.hashCode());
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        Object[] objArr = this.array;
        int i = this.size;
        if (obj != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return -1;
                }
                if (obj.equals(objArr[i3])) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i) {
                    return -1;
                }
                if (objArr[i5] == null) {
                    return i5;
                }
                i4 = i5 + 1;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        Object[] objArr = this.array;
        if (obj != null) {
            int i = this.size;
            while (true) {
                int i2 = i - 1;
                if (i2 < 0) {
                    return -1;
                }
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i = i2;
            }
        } else {
            int i3 = this.size;
            while (true) {
                int i4 = i3 - 1;
                if (i4 < 0) {
                    return -1;
                }
                if (objArr[i4] == null) {
                    return i4;
                }
                i3 = i4;
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        Object[] objArr = this.array;
        int i2 = this.size;
        if (i >= i2) {
            throwIndexOutOfBoundsException(i, i2);
        }
        E e = (E) objArr[i];
        int i3 = i2 - 1;
        System.arraycopy(objArr, i + 1, objArr, i, i3 - i);
        objArr[i3] = null;
        this.size = i3;
        this.modCount++;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Object[] objArr = this.array;
        int i = this.size;
        if (obj != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return false;
                }
                if (obj.equals(objArr[i3])) {
                    int i4 = i - 1;
                    System.arraycopy(objArr, i3 + 1, objArr, i3, i4 - i3);
                    objArr[i4] = null;
                    this.size = i4;
                    this.modCount++;
                    return true;
                }
                i2 = i3 + 1;
            }
        } else {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= i) {
                    return false;
                }
                if (objArr[i6] == null) {
                    int i7 = i - 1;
                    System.arraycopy(objArr, i6 + 1, objArr, i6, i7 - i6);
                    objArr[i7] = null;
                    this.size = i7;
                    this.modCount++;
                    return true;
                }
                i5 = i6 + 1;
            }
        }
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        if (i == i2) {
            return;
        }
        Object[] objArr = this.array;
        int i3 = this.size;
        if (i >= i3) {
            throw new IndexOutOfBoundsException("fromIndex " + i + " >= size " + this.size);
        }
        if (i2 > i3) {
            throw new IndexOutOfBoundsException("toIndex " + i2 + " > size " + this.size);
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException("fromIndex " + i + " > toIndex " + i2);
        }
        System.arraycopy(objArr, i2, objArr, i, i3 - i2);
        int i4 = i2 - i;
        Arrays.fill(objArr, i3 - i4, i3, (Object) null);
        this.size = i3 - i4;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        Object[] objArr = this.array;
        if (i >= this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        E e2 = (E) objArr[i];
        objArr[i] = e;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.size;
        Object[] objArr = new Object[i];
        System.arraycopy(this.array, 0, objArr, 0, i);
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int i = this.size;
        T[] tArr2 = tArr;
        if (tArr.length < i) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
        }
        System.arraycopy(this.array, 0, tArr2, 0, i);
        if (tArr2.length > i) {
            tArr2[i] = null;
        }
        return tArr2;
    }

    public void trimToSize() {
        int i = this.size;
        if (i == this.array.length) {
            return;
        }
        if (i == 0) {
            this.array = EmptyArray.OBJECT;
        } else {
            Object[] objArr = new Object[i];
            System.arraycopy(this.array, 0, objArr, 0, i);
            this.array = objArr;
        }
        this.modCount++;
    }
}
