package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/PriorityQueue.class */
public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int DEFAULT_CAPACITY_RATIO = 2;
    private static final double DEFAULT_INIT_CAPACITY_RATIO = 1.1d;
    private static final long serialVersionUID = -7720805057305804111L;
    private Comparator<? super E> comparator;
    private transient E[] elements;
    private int size;

    /* loaded from: source-2895416-dex2jar.jar:java/util/PriorityQueue$PriorityIterator.class */
    private class PriorityIterator implements Iterator<E> {
        private boolean allowRemove;
        private int currentIndex;

        private PriorityIterator() {
            this.currentIndex = -1;
            this.allowRemove = false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex < PriorityQueue.this.size - 1;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                this.allowRemove = true;
                Object[] objArr = PriorityQueue.this.elements;
                int i = this.currentIndex + 1;
                this.currentIndex = i;
                return (E) objArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.allowRemove) {
                throw new IllegalStateException();
            }
            this.allowRemove = false;
            PriorityQueue priorityQueue = PriorityQueue.this;
            int i = this.currentIndex;
            this.currentIndex = i - 1;
            priorityQueue.removeAt(i);
        }
    }

    public PriorityQueue() {
        this(11);
    }

    public PriorityQueue(int i) {
        this(i, null);
    }

    public PriorityQueue(int i, Comparator<? super E> comparator) {
        if (i < 1) {
            throw new IllegalArgumentException("initialCapacity < 1: " + i);
        }
        this.elements = newElementArray(i);
        this.comparator = comparator;
    }

    public PriorityQueue(Collection<? extends E> collection) {
        if (collection instanceof PriorityQueue) {
            getFromPriorityQueue((PriorityQueue) collection);
        } else if (collection instanceof SortedSet) {
            getFromSortedSet((SortedSet) collection);
        } else {
            initSize(collection);
            addAll(collection);
        }
    }

    public PriorityQueue(PriorityQueue<? extends E> priorityQueue) {
        getFromPriorityQueue(priorityQueue);
    }

    public PriorityQueue(SortedSet<? extends E> sortedSet) {
        getFromSortedSet(sortedSet);
    }

    private int compare(E e, E e2) {
        return this.comparator != null ? this.comparator.compare(e, e2) : ((Comparable) e).compareTo(e2);
    }

    private void getFromPriorityQueue(PriorityQueue<? extends E> priorityQueue) {
        initSize(priorityQueue);
        this.comparator = (Comparator<? super Object>) priorityQueue.comparator();
        System.arraycopy(priorityQueue.elements, 0, this.elements, 0, priorityQueue.size());
        this.size = priorityQueue.size();
    }

    private void getFromSortedSet(SortedSet<? extends E> sortedSet) {
        initSize(sortedSet);
        this.comparator = (Comparator<? super Object>) sortedSet.comparator();
        for (E e : sortedSet) {
            E[] eArr = this.elements;
            int i = this.size;
            this.size = i + 1;
            eArr[i] = e;
        }
    }

    private void growToSize(int i) {
        if (i > this.elements.length) {
            E[] newElementArray = newElementArray(i * 2);
            System.arraycopy(this.elements, 0, newElementArray, 0, this.elements.length);
            this.elements = newElementArray;
        }
    }

    private void initSize(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("c == null");
        }
        if (collection.isEmpty()) {
            this.elements = newElementArray(1);
        } else {
            this.elements = newElementArray((int) Math.ceil(collection.size() * DEFAULT_INIT_CAPACITY_RATIO));
        }
    }

    private E[] newElementArray(int i) {
        return (E[]) new Object[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.elements = newElementArray(objectInputStream.readInt());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return;
            }
            this.elements[i2] = objectInputStream.readObject();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAt(int i) {
        this.size--;
        E e = this.elements[this.size];
        this.elements[i] = e;
        siftDown(i);
        this.elements[this.size] = null;
        if (e == this.elements[i]) {
            siftUp(i);
        }
    }

    private void siftDown(int i) {
        int i2;
        E e = this.elements[i];
        while (true) {
            i2 = i;
            int i3 = (i2 * 2) + 1;
            if (i3 >= this.size) {
                break;
            }
            i = i3;
            if (i3 + 1 < this.size) {
                i = i3;
                if (compare(this.elements[i3 + 1], this.elements[i3]) < 0) {
                    i = i3 + 1;
                }
            }
            if (compare(e, this.elements[i]) <= 0) {
                break;
            }
            this.elements[i2] = this.elements[i];
        }
        this.elements[i2] = e;
    }

    private void siftUp(int i) {
        E e = this.elements[i];
        while (i > 0) {
            int i2 = (i - 1) / 2;
            E e2 = this.elements[i2];
            if (compare(e2, e) <= 0) {
                break;
            }
            this.elements[i] = e2;
            i = i2;
        }
        this.elements[i] = e;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.elements.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return;
            }
            objectOutputStream.writeObject(this.elements[i2]);
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return offer(e);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Arrays.fill(this.elements, (Object) null);
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new PriorityIterator();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("o == null");
        }
        growToSize(this.size + 1);
        this.elements[this.size] = e;
        int i = this.size;
        this.size = i + 1;
        siftUp(i);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.elements[0];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = this.elements[0];
        removeAt(0);
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return false;
            }
            if (obj.equals(this.elements[i2])) {
                removeAt(i2);
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
