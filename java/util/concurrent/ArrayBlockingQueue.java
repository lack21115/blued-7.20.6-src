package java.util.concurrent;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ArrayBlockingQueue.class */
public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    private static final long serialVersionUID = -817911632652898426L;
    int count;
    final Object[] items;
    transient ArrayBlockingQueue<E>.Itrs itrs;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    int putIndex;
    int takeIndex;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ArrayBlockingQueue$Itr.class */
    public class Itr implements Iterator<E> {
        private static final int DETACHED = -3;
        private static final int NONE = -1;
        private static final int REMOVED = -2;
        private int cursor;
        private E lastItem;
        private int lastRet = -1;
        private int nextIndex;
        private E nextItem;
        private int prevCycles;
        private int prevTakeIndex;

        Itr() {
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                if (ArrayBlockingQueue.this.count == 0) {
                    this.cursor = -1;
                    this.nextIndex = -1;
                    this.prevTakeIndex = -3;
                } else {
                    int i = ArrayBlockingQueue.this.takeIndex;
                    this.prevTakeIndex = i;
                    this.nextIndex = i;
                    this.nextItem = (E) ArrayBlockingQueue.this.itemAt(i);
                    this.cursor = incCursor(i);
                    if (ArrayBlockingQueue.this.itrs == null) {
                        ArrayBlockingQueue.this.itrs = new Itrs(this);
                    } else {
                        ArrayBlockingQueue.this.itrs.register(this);
                        ArrayBlockingQueue.this.itrs.doSomeSweeping(false);
                    }
                    this.prevCycles = ArrayBlockingQueue.this.itrs.cycles;
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        private void detach() {
            if (this.prevTakeIndex >= 0) {
                this.prevTakeIndex = -3;
                ArrayBlockingQueue.this.itrs.doSomeSweeping(true);
            }
        }

        private int distance(int i, int i2, int i3) {
            int i4 = i - i2;
            int i5 = i4;
            if (i4 < 0) {
                i5 = i4 + i3;
            }
            return i5;
        }

        private int incCursor(int i) {
            int inc = ArrayBlockingQueue.this.inc(i);
            int i2 = inc;
            if (inc == ArrayBlockingQueue.this.putIndex) {
                i2 = -1;
            }
            return i2;
        }

        private void incorporateDequeues() {
            int i = ArrayBlockingQueue.this.itrs.cycles;
            int i2 = ArrayBlockingQueue.this.takeIndex;
            int i3 = this.prevCycles;
            int i4 = this.prevTakeIndex;
            if (i == i3 && i2 == i4) {
                return;
            }
            int length = ArrayBlockingQueue.this.items.length;
            long j = ((i - i3) * length) + (i2 - i4);
            if (invalidated(this.lastRet, i4, j, length)) {
                this.lastRet = -2;
            }
            if (invalidated(this.nextIndex, i4, j, length)) {
                this.nextIndex = -2;
            }
            if (invalidated(this.cursor, i4, j, length)) {
                this.cursor = i2;
            }
            if (this.cursor < 0 && this.nextIndex < 0 && this.lastRet < 0) {
                detach();
                return;
            }
            this.prevCycles = i;
            this.prevTakeIndex = i2;
        }

        private boolean invalidated(int i, int i2, long j, int i3) {
            if (i < 0) {
                return false;
            }
            int i4 = i - i2;
            int i5 = i4;
            if (i4 < 0) {
                i5 = i4 + i3;
            }
            return j > ((long) i5);
        }

        private void noNext() {
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                if (!isDetached()) {
                    incorporateDequeues();
                    if (this.lastRet >= 0) {
                        this.lastItem = (E) ArrayBlockingQueue.this.itemAt(this.lastRet);
                        detach();
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextItem != null) {
                return true;
            }
            noNext();
            return false;
        }

        boolean isDetached() {
            return this.prevTakeIndex < 0;
        }

        @Override // java.util.Iterator
        public E next() {
            E e = this.nextItem;
            if (e == null) {
                throw new NoSuchElementException();
            }
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                if (!isDetached()) {
                    incorporateDequeues();
                }
                this.lastRet = this.nextIndex;
                int i = this.cursor;
                if (i >= 0) {
                    ArrayBlockingQueue arrayBlockingQueue = ArrayBlockingQueue.this;
                    this.nextIndex = i;
                    this.nextItem = (E) arrayBlockingQueue.itemAt(i);
                    this.cursor = incCursor(i);
                } else {
                    this.nextIndex = -1;
                    this.nextItem = null;
                }
                return e;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                if (!isDetached()) {
                    incorporateDequeues();
                }
                int i = this.lastRet;
                this.lastRet = -1;
                if (i >= 0) {
                    if (isDetached()) {
                        E e = this.lastItem;
                        this.lastItem = null;
                        if (ArrayBlockingQueue.this.itemAt(i) == e) {
                            ArrayBlockingQueue.this.removeAt(i);
                        }
                    } else {
                        ArrayBlockingQueue.this.removeAt(i);
                    }
                } else if (i == -1) {
                    throw new IllegalStateException();
                }
                if (this.cursor < 0 && this.nextIndex < 0) {
                    detach();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        boolean removedAt(int i) {
            if (isDetached()) {
                return true;
            }
            int i2 = ArrayBlockingQueue.this.itrs.cycles;
            int i3 = ArrayBlockingQueue.this.takeIndex;
            int i4 = this.prevCycles;
            int i5 = this.prevTakeIndex;
            int length = ArrayBlockingQueue.this.items.length;
            int i6 = i2 - i4;
            int i7 = i6;
            if (i < i3) {
                i7 = i6 + 1;
            }
            int i8 = (i7 * length) + (i - i5);
            int i9 = this.cursor;
            int i10 = i9;
            if (i9 >= 0) {
                int distance = distance(i9, i5, length);
                if (distance == i8) {
                    i10 = i9;
                    if (i9 == ArrayBlockingQueue.this.putIndex) {
                        i10 = -1;
                        this.cursor = -1;
                    }
                } else {
                    i10 = i9;
                    if (distance > i8) {
                        i10 = ArrayBlockingQueue.this.dec(i9);
                        this.cursor = i10;
                    }
                }
            }
            int i11 = this.lastRet;
            int i12 = i11;
            if (i11 >= 0) {
                int distance2 = distance(i11, i5, length);
                if (distance2 == i8) {
                    i12 = -2;
                    this.lastRet = -2;
                } else {
                    i12 = i11;
                    if (distance2 > i8) {
                        i12 = ArrayBlockingQueue.this.dec(i11);
                        this.lastRet = i12;
                    }
                }
            }
            int i13 = this.nextIndex;
            if (i13 < 0) {
                if (i10 >= 0 || i13 >= 0 || i12 >= 0) {
                    return false;
                }
                this.prevTakeIndex = -3;
                return true;
            }
            int distance3 = distance(i13, i5, length);
            if (distance3 == i8) {
                this.nextIndex = -2;
                return false;
            } else if (distance3 > i8) {
                this.nextIndex = ArrayBlockingQueue.this.dec(i13);
                return false;
            } else {
                return false;
            }
        }

        void shutdown() {
            this.cursor = -1;
            if (this.nextIndex >= 0) {
                this.nextIndex = -2;
            }
            if (this.lastRet >= 0) {
                this.lastRet = -2;
                this.lastItem = null;
            }
            this.prevTakeIndex = -3;
        }

        boolean takeIndexWrapped() {
            if (isDetached()) {
                return true;
            }
            if (ArrayBlockingQueue.this.itrs.cycles - this.prevCycles > 1) {
                shutdown();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ArrayBlockingQueue$Itrs.class */
    public class Itrs {
        private static final int LONG_SWEEP_PROBES = 16;
        private static final int SHORT_SWEEP_PROBES = 4;
        private ArrayBlockingQueue<E>.Itrs.Node head;
        int cycles = 0;
        private ArrayBlockingQueue<E>.Itrs.Node sweeper = null;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ArrayBlockingQueue$Itrs$Node.class */
        public class Node extends WeakReference<ArrayBlockingQueue<E>.Itr> {
            ArrayBlockingQueue<E>.Itrs.Node next;

            Node(ArrayBlockingQueue<E>.Itr itr, ArrayBlockingQueue<E>.Itrs.Node node) {
                super(itr);
                this.next = node;
            }
        }

        Itrs(ArrayBlockingQueue<E>.Itr itr) {
            register(itr);
        }

        void doSomeSweeping(boolean z) {
            ArrayBlockingQueue<E>.Itrs.Node node;
            boolean z2;
            int i = z ? 16 : 4;
            ArrayBlockingQueue<E>.Itrs.Node node2 = this.sweeper;
            if (node2 == null) {
                node2 = null;
                node = this.head;
                z2 = true;
            } else {
                node = node2.next;
                z2 = false;
            }
            while (true) {
                boolean z3 = z2;
                if (i <= 0) {
                    break;
                }
                ArrayBlockingQueue<E>.Itrs.Node node3 = node2;
                ArrayBlockingQueue<E>.Itrs.Node node4 = node;
                boolean z4 = z3;
                if (node == null) {
                    if (z3) {
                        break;
                    }
                    node3 = null;
                    node4 = this.head;
                    z4 = true;
                }
                ArrayBlockingQueue<E>.Itr itr = node4.get();
                node = node4.next;
                if (itr == null || itr.isDetached()) {
                    i = 16;
                    node4.clear();
                    node4.next = null;
                    if (node3 == null) {
                        this.head = node;
                        node2 = node3;
                        if (node == null) {
                            ArrayBlockingQueue.this.itrs = null;
                            return;
                        }
                    } else {
                        node3.next = node;
                        node2 = node3;
                    }
                } else {
                    node2 = node4;
                }
                i--;
                z2 = z4;
            }
            if (node == null) {
                node2 = null;
            }
            this.sweeper = node2;
        }

        void elementDequeued() {
            if (ArrayBlockingQueue.this.count == 0) {
                queueIsEmpty();
            } else if (ArrayBlockingQueue.this.takeIndex == 0) {
                takeIndexWrapped();
            }
        }

        void queueIsEmpty() {
            ArrayBlockingQueue<E>.Itrs.Node node = this.head;
            while (true) {
                ArrayBlockingQueue<E>.Itrs.Node node2 = node;
                if (node2 == null) {
                    this.head = null;
                    ArrayBlockingQueue.this.itrs = null;
                    return;
                }
                ArrayBlockingQueue<E>.Itr itr = node2.get();
                if (itr != null) {
                    node2.clear();
                    itr.shutdown();
                }
                node = node2.next;
            }
        }

        void register(ArrayBlockingQueue<E>.Itr itr) {
            this.head = new Node(itr, this.head);
        }

        void removedAt(int i) {
            ArrayBlockingQueue<E>.Itrs.Node node = null;
            ArrayBlockingQueue<E>.Itrs.Node node2 = this.head;
            while (true) {
                ArrayBlockingQueue<E>.Itrs.Node node3 = node2;
                if (node3 == null) {
                    break;
                }
                ArrayBlockingQueue<E>.Itr itr = node3.get();
                ArrayBlockingQueue<E>.Itrs.Node node4 = node3.next;
                if (itr == null || itr.removedAt(i)) {
                    node3.clear();
                    node3.next = null;
                    if (node == null) {
                        this.head = node4;
                    } else {
                        node.next = node4;
                    }
                } else {
                    node = node3;
                }
                node2 = node4;
            }
            if (this.head == null) {
                ArrayBlockingQueue.this.itrs = null;
            }
        }

        void takeIndexWrapped() {
            this.cycles++;
            ArrayBlockingQueue<E>.Itrs.Node node = null;
            ArrayBlockingQueue<E>.Itrs.Node node2 = this.head;
            while (true) {
                ArrayBlockingQueue<E>.Itrs.Node node3 = node2;
                if (node3 == null) {
                    break;
                }
                ArrayBlockingQueue<E>.Itr itr = node3.get();
                ArrayBlockingQueue<E>.Itrs.Node node4 = node3.next;
                if (itr == null || itr.takeIndexWrapped()) {
                    node3.clear();
                    node3.next = null;
                    if (node == null) {
                        this.head = node4;
                    } else {
                        node.next = node4;
                    }
                } else {
                    node = node3;
                }
                node2 = node4;
            }
            if (this.head == null) {
                ArrayBlockingQueue.this.itrs = null;
            }
        }
    }

    public ArrayBlockingQueue(int i) {
        this(i, false);
    }

    public ArrayBlockingQueue(int i, boolean z) {
        this.itrs = null;
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = new Object[i];
        this.lock = new ReentrantLock(z);
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
    }

    public ArrayBlockingQueue(int i, boolean z, Collection<? extends E> collection) {
        this(i, z);
        int i2;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            try {
                Iterator<? extends E> it = collection.iterator();
                int i3 = 0;
                while (true) {
                    try {
                        try {
                            i2 = i3;
                            if (!it.hasNext()) {
                                break;
                            }
                            E next = it.next();
                            checkNotNull(next);
                            this.items[i2] = next;
                            i3 = i2 + 1;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new IllegalArgumentException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                this.count = i2;
                this.putIndex = i2 == i ? 0 : i2;
                reentrantLock.unlock();
            } catch (ArrayIndexOutOfBoundsException e2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    private E dequeue() {
        Object[] objArr = this.items;
        E e = (E) objArr[this.takeIndex];
        objArr[this.takeIndex] = null;
        this.takeIndex = inc(this.takeIndex);
        this.count--;
        if (this.itrs != null) {
            this.itrs.elementDequeued();
        }
        this.notFull.signal();
        return e;
    }

    private void enqueue(E e) {
        this.items[this.putIndex] = e;
        this.putIndex = inc(this.putIndex);
        this.count++;
        this.notEmpty.signal();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return super.add(e);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        int inc;
        Object[] objArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            if (i > 0) {
                int i2 = this.putIndex;
                int i3 = this.takeIndex;
                do {
                    objArr[i3] = null;
                    inc = inc(i3);
                    i3 = inc;
                } while (inc != i2);
                this.takeIndex = i2;
                this.count = 0;
                int i4 = i;
                if (this.itrs != null) {
                    this.itrs.queueIsEmpty();
                    i4 = i;
                }
                while (i4 > 0) {
                    if (!reentrantLock.hasWaiters(this.notFull)) {
                        break;
                    }
                    this.notFull.signal();
                    i4--;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        int inc;
        if (obj == null) {
            return false;
        }
        Object[] objArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count <= 0) {
                reentrantLock.unlock();
                return false;
            }
            int i = this.putIndex;
            int i2 = this.takeIndex;
            do {
                if (obj.equals(objArr[i2])) {
                    reentrantLock.unlock();
                    return true;
                }
                inc = inc(i2);
                i2 = inc;
            } while (inc != i);
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    final int dec(int i) {
        int i2 = i;
        if (i == 0) {
            i2 = this.items.length;
        }
        return i2 - 1;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        int i2;
        checkNotNull(collection);
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (i <= 0) {
            return 0;
        }
        Object[] objArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.count);
            int i3 = this.takeIndex;
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (i2 >= min) {
                    break;
                }
                collection.add(objArr[i3]);
                objArr[i3] = null;
                i3 = inc(i3);
                i4 = i2 + 1;
            }
            if (i2 > 0) {
                this.count -= i2;
                this.takeIndex = i3;
                int i5 = i2;
                if (this.itrs != null) {
                    if (this.count == 0) {
                        this.itrs.queueIsEmpty();
                        i5 = i2;
                    } else {
                        i5 = i2;
                        if (i2 > i3) {
                            this.itrs.takeIndexWrapped();
                            i5 = i2;
                        }
                    }
                }
                while (i5 > 0) {
                    if (!reentrantLock.hasWaiters(this.notFull)) {
                        break;
                    }
                    this.notFull.signal();
                    i5--;
                }
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    final int inc(int i) {
        int i2 = i + 1;
        int i3 = i2;
        if (i2 == this.items.length) {
            i3 = 0;
        }
        return i3;
    }

    final E itemAt(int i) {
        return (E) this.items[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        checkNotNull(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count == this.items.length) {
                reentrantLock.unlock();
                return false;
            }
            enqueue(e);
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        checkNotNull(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == this.items.length) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        enqueue(e);
        reentrantLock.unlock();
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return itemAt(this.takeIndex);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            E dequeue = this.count == 0 ? null : dequeue();
            reentrantLock.unlock();
            return dequeue;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == 0) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return dequeue();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == this.items.length) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        enqueue(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int length = this.items.length;
            int i = this.count;
            reentrantLock.unlock();
            return length - i;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int inc;
        if (obj == null) {
            return false;
        }
        Object[] objArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count <= 0) {
                reentrantLock.unlock();
                return false;
            }
            int i = this.putIndex;
            int i2 = this.takeIndex;
            do {
                if (obj.equals(objArr[i2])) {
                    removeAt(i2);
                    reentrantLock.unlock();
                    return true;
                }
                inc = inc(i2);
                i2 = inc;
            } while (inc != i);
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    void removeAt(int i) {
        int i2;
        Object[] objArr = this.items;
        if (i == this.takeIndex) {
            objArr[this.takeIndex] = null;
            this.takeIndex = inc(this.takeIndex);
            this.count--;
            if (this.itrs != null) {
                this.itrs.elementDequeued();
            }
        } else {
            int i3 = this.putIndex;
            int i4 = i;
            while (true) {
                i2 = i4;
                int inc = inc(i2);
                if (inc == i3) {
                    break;
                }
                objArr[i2] = objArr[inc];
                i4 = inc;
            }
            objArr[i2] = null;
            this.putIndex = i2;
            this.count--;
            if (this.itrs != null) {
                this.itrs.removedAt(i);
            }
        }
        this.notFull.signal();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == 0) {
            try {
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        return dequeue();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            Object[] objArr2 = new Object[i];
            int length = objArr.length - this.takeIndex;
            if (i <= length) {
                System.arraycopy(objArr, this.takeIndex, objArr2, 0, i);
            } else {
                System.arraycopy(objArr, this.takeIndex, objArr2, 0, length);
                System.arraycopy(objArr, 0, objArr2, length, i - length);
            }
            return objArr2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            int length = tArr.length;
            T[] tArr2 = tArr;
            if (length < i) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            int length2 = objArr.length - this.takeIndex;
            if (i <= length2) {
                System.arraycopy(objArr, this.takeIndex, tArr2, 0, i);
            } else {
                System.arraycopy(objArr, this.takeIndex, tArr2, 0, length2);
                System.arraycopy(objArr, 0, tArr2, length2, i - length2);
            }
            if (length > i) {
                tArr2[i] = null;
            }
            reentrantLock.unlock();
            return tArr2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            if (i == 0) {
                reentrantLock.unlock();
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            int i2 = this.takeIndex;
            while (true) {
                Object obj = this.items[i2];
                Object obj2 = obj;
                if (obj == this) {
                    obj2 = "(this Collection)";
                }
                sb.append(obj2);
                i--;
                if (i == 0) {
                    return sb.append(']').toString();
                }
                sb.append(',').append(' ');
                i2 = inc(i2);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
