package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/PriorityBlockingQueue.class */
public class PriorityBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final Unsafe UNSAFE;
    private static final long allocationSpinLockOffset;
    private static final long serialVersionUID = 5595510919245408276L;
    private volatile transient int allocationSpinLock;
    private transient Comparator<? super E> comparator;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private PriorityQueue<E> q;
    private transient Object[] queue;
    private transient int size;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/PriorityBlockingQueue$Itr.class */
    final class Itr implements Iterator<E> {
        final Object[] array;
        int cursor;
        int lastRet = -1;

        Itr(Object[] objArr) {
            this.array = objArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor < this.array.length;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.cursor >= this.array.length) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.cursor;
            Object[] objArr = this.array;
            int i = this.cursor;
            this.cursor = i + 1;
            return (E) objArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            PriorityBlockingQueue.this.removeEQ(this.array[this.lastRet]);
            this.lastRet = -1;
        }
    }

    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            allocationSpinLockOffset = UNSAFE.objectFieldOffset(PriorityBlockingQueue.class.getDeclaredField("allocationSpinLock"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public PriorityBlockingQueue() {
        this(11, null);
    }

    public PriorityBlockingQueue(int i) {
        this(i, null);
    }

    public PriorityBlockingQueue(int i, Comparator<? super E> comparator) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.comparator = comparator;
        this.queue = new Object[i];
    }

    public PriorityBlockingQueue(Collection<? extends E> collection) {
        boolean z;
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        boolean z2 = true;
        if (collection instanceof SortedSet) {
            this.comparator = ((SortedSet) collection).comparator();
            z = false;
        } else {
            z = true;
            if (collection instanceof PriorityBlockingQueue) {
                PriorityBlockingQueue priorityBlockingQueue = (PriorityBlockingQueue) collection;
                this.comparator = priorityBlockingQueue.comparator();
                z = true;
                z2 = false;
                if (priorityBlockingQueue.getClass() == PriorityBlockingQueue.class) {
                    z = false;
                    z2 = false;
                }
            }
        }
        Object[] array = collection.toArray();
        int length = array.length;
        Object[] copyOf = array.getClass() != Object[].class ? Arrays.copyOf(array, length, Object[].class) : array;
        if (z2 && (length == 1 || this.comparator != null)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                } else if (copyOf[i2] == null) {
                    throw new NullPointerException();
                } else {
                    i = i2 + 1;
                }
            }
        }
        this.queue = copyOf;
        this.size = length;
        if (z) {
            heapify();
        }
    }

    private E dequeue() {
        int i = this.size - 1;
        if (i < 0) {
            return null;
        }
        Object[] objArr = this.queue;
        E e = (E) objArr[0];
        Object obj = objArr[i];
        objArr[i] = null;
        Comparator<? super E> comparator = this.comparator;
        if (comparator == null) {
            siftDownComparable(0, obj, objArr, i);
        } else {
            siftDownUsingComparator(0, obj, objArr, i, comparator);
        }
        this.size = i;
        return e;
    }

    private void heapify() {
        Object[] objArr = this.queue;
        int i = this.size;
        int i2 = (i >>> 1) - 1;
        Comparator<? super E> comparator = this.comparator;
        if (comparator == null) {
            while (i2 >= 0) {
                siftDownComparable(i2, objArr[i2], objArr, i);
                i2--;
            }
            return;
        }
        while (i2 >= 0) {
            siftDownUsingComparator(i2, objArr[i2], objArr, i, comparator);
            i2--;
        }
    }

    private int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        Object[] objArr = this.queue;
        int i = this.size;
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
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            objectInputStream.defaultReadObject();
            this.queue = new Object[this.q.size()];
            this.comparator = this.q.comparator();
            addAll(this.q);
        } finally {
            this.q = null;
        }
    }

    private void removeAt(int i) {
        Object[] objArr = this.queue;
        int i2 = this.size - 1;
        if (i2 == i) {
            objArr[i] = null;
        } else {
            Object obj = objArr[i2];
            objArr[i2] = null;
            Comparator<? super E> comparator = this.comparator;
            if (comparator == null) {
                siftDownComparable(i, obj, objArr, i2);
            } else {
                siftDownUsingComparator(i, obj, objArr, i2, comparator);
            }
            if (objArr[i] == obj) {
                if (comparator == null) {
                    siftUpComparable(i, obj, objArr);
                } else {
                    siftUpUsingComparator(i, obj, objArr, comparator);
                }
            }
        }
        this.size = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    private static <T> void siftDownComparable(int i, T t, Object[] objArr, int i2) {
        int i3;
        if (i2 > 0) {
            Comparable comparable = (Comparable) t;
            while (true) {
                i3 = i;
                if (i3 >= (i2 >>> 1)) {
                    break;
                }
                int i4 = (i3 << 1) + 1;
                ?? r0 = objArr[i4];
                int i5 = i4 + 1;
                T t2 = r0;
                i = i4;
                if (i5 < i2) {
                    t2 = r0;
                    i = i4;
                    if (((Comparable) r0).compareTo(objArr[i5]) > 0) {
                        i = i5;
                        t2 = objArr[i5];
                    }
                }
                if (comparable.compareTo(t2) <= 0) {
                    break;
                }
                objArr[i3] = t2;
            }
            objArr[i3] = comparable;
        }
    }

    private static <T> void siftDownUsingComparator(int i, T t, Object[] objArr, int i2, Comparator<? super T> comparator) {
        int i3;
        if (i2 > 0) {
            while (true) {
                i3 = i;
                if (i3 >= (i2 >>> 1)) {
                    break;
                }
                int i4 = (i3 << 1) + 1;
                Object obj = objArr[i4];
                int i5 = i4 + 1;
                Object obj2 = obj;
                i = i4;
                if (i5 < i2) {
                    obj2 = obj;
                    i = i4;
                    if (comparator.compare(obj, objArr[i5]) > 0) {
                        i = i5;
                        obj2 = objArr[i5];
                    }
                }
                if (comparator.compare(t, obj2) <= 0) {
                    break;
                }
                objArr[i3] = obj2;
            }
            objArr[i3] = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void siftUpComparable(int i, T t, Object[] objArr) {
        Comparable comparable = (Comparable) t;
        while (i > 0) {
            int i2 = (i - 1) >>> 1;
            Object[] objArr2 = objArr[i2];
            if (comparable.compareTo(objArr2) >= 0) {
                break;
            }
            objArr[i] = objArr2;
            i = i2;
        }
        objArr[i] = comparable;
    }

    private static <T> void siftUpUsingComparator(int i, T t, Object[] objArr, Comparator<? super T> comparator) {
        while (i > 0) {
            int i2 = (i - 1) >>> 1;
            Object obj = objArr[i2];
            if (comparator.compare(t, obj) >= 0) {
                break;
            }
            objArr[i] = obj;
            i = i2;
        }
        objArr[i] = t;
    }

    private void tryGrow(Object[] objArr, int i) {
        this.lock.unlock();
        Object[] objArr2 = null;
        if (this.allocationSpinLock == 0) {
            objArr2 = null;
            if (UNSAFE.compareAndSwapInt(this, allocationSpinLockOffset, 0, 1)) {
                int i2 = i + (i < 64 ? i + 2 : i >> 1);
                int i3 = i2;
                try {
                    if (i2 - MAX_ARRAY_SIZE > 0) {
                        int i4 = i + 1;
                        if (i4 < 0 || i4 > MAX_ARRAY_SIZE) {
                            throw new OutOfMemoryError();
                        }
                        i3 = MAX_ARRAY_SIZE;
                    }
                    objArr2 = null;
                    if (i3 > i) {
                        objArr2 = null;
                        if (this.queue == objArr) {
                            objArr2 = new Object[i3];
                        }
                    }
                } finally {
                    this.allocationSpinLock = 0;
                }
            }
        }
        if (objArr2 == null) {
            Thread.yield();
        }
        this.lock.lock();
        if (objArr2 == null || this.queue != objArr) {
            return;
        }
        this.queue = objArr2;
        System.arraycopy(objArr, 0, objArr2, 0, i);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        this.lock.lock();
        try {
            this.q = new PriorityQueue<>(Math.max(this.size, 1), this.comparator);
            this.q.addAll(this);
            objectOutputStream.defaultWriteObject();
        } finally {
            this.q = null;
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        return offer(e);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = this.queue;
            int i = this.size;
            this.size = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return;
                }
                objArr[i3] = null;
                i2 = i3 + 1;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z = indexOf(obj) != -1;
            reentrantLock.unlock();
            return z;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (i <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(this.size, i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= min) {
                    return min;
                }
                collection.add(this.queue[0]);
                dequeue();
                i2 = i3 + 1;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr(toArray());
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        int i;
        Object[] objArr;
        if (e == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            i = this.size;
            objArr = this.queue;
            int length = objArr.length;
            if (i < length) {
                try {
                    break;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            tryGrow(objArr, length);
        }
        Comparator<? super E> comparator = this.comparator;
        if (comparator == null) {
            siftUpComparable(i, e, objArr);
        } else {
            siftUpUsingComparator(i, e, objArr, comparator);
        }
        this.size = i + 1;
        this.notEmpty.signal();
        reentrantLock.unlock();
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offer(e);
    }

    @Override // java.util.Queue
    public E peek() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.size == 0 ? null : this.queue[0];
            reentrantLock.unlock();
            return (E) obj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.Queue
    public E poll() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return dequeue();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        E dequeue;
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                dequeue = dequeue();
                if (dequeue != null || nanos <= 0) {
                    break;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return dequeue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) {
        offer(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int indexOf = indexOf(obj);
            if (indexOf == -1) {
                reentrantLock.unlock();
                return false;
            }
            removeAt(indexOf);
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        removeAt(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void removeEQ(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = r4
            java.util.concurrent.locks.ReentrantLock r0 = r0.lock
            r8 = r0
            r0 = r8
            r0.lock()
            r0 = r4
            java.lang.Object[] r0 = r0.queue     // Catch: java.lang.Throwable -> L37
            r9 = r0
            r0 = 0
            r6 = r0
            r0 = r4
            int r0 = r0.size     // Catch: java.lang.Throwable -> L37
            r7 = r0
        L18:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L2a
            r0 = r5
            r1 = r9
            r2 = r6
            r1 = r1[r2]
            if (r0 != r1) goto L30
            r0 = r4
            r1 = r6
            r0.removeAt(r1)     // Catch: java.lang.Throwable -> L37
        L2a:
            r0 = r8
            r0.unlock()
            return
        L30:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L18
        L37:
            r5 = move-exception
            r0 = r8
            r0.unlock()
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.PriorityBlockingQueue.removeEQ(java.lang.Object):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.size;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E dequeue = dequeue();
                if (dequeue != null) {
                    return dequeue;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return Arrays.copyOf(this.queue, this.size);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (tArr.length < i) {
                return (T[]) Arrays.copyOf(this.queue, this.size, tArr.getClass());
            }
            System.arraycopy(this.queue, 0, tArr, 0, i);
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                reentrantLock.unlock();
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return sb.append(']').toString();
                }
                Object obj = this.queue[i3];
                Object obj2 = obj;
                if (obj == this) {
                    obj2 = "(this Collection)";
                }
                sb.append(obj2);
                if (i3 != i - 1) {
                    sb.append(',').append(' ');
                }
                i2 = i3 + 1;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
