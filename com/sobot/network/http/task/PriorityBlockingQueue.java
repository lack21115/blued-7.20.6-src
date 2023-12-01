package com.sobot.network.http.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/task/PriorityBlockingQueue.class */
public class PriorityBlockingQueue<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
    private static final long serialVersionUID = -6903933977591709194L;
    private final int capacity;
    private final AtomicInteger count;
    transient PriorityBlockingQueue<E>.Node<E> head;
    private transient PriorityBlockingQueue<E>.Node<E> last;
    private final Condition notEmpty;
    private final Condition notFull;
    private final ReentrantLock putLock;
    private final ReentrantLock takeLock;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/task/PriorityBlockingQueue$Itr.class */
    class Itr implements Iterator<E> {
        private PriorityBlockingQueue<E>.Node<E> current;
        private E currentElement;
        private PriorityBlockingQueue<E>.Node<E> lastRet;

        Itr() {
            PriorityBlockingQueue.this.fullyLock();
            try {
                PriorityBlockingQueue<E>.Node<E> node = PriorityBlockingQueue.this.head.next;
                this.current = node;
                if (node != null) {
                    this.currentElement = node.getValue();
                }
            } finally {
                PriorityBlockingQueue.this.fullyUnlock();
            }
        }

        private PriorityBlockingQueue<E>.Node<E> nextNode(PriorityBlockingQueue<E>.Node<E> node) {
            while (true) {
                PriorityBlockingQueue<E>.Node<E> node2 = node.next;
                if (node2 == node) {
                    return PriorityBlockingQueue.this.head.next;
                }
                if (node2 != null && node2.getValue() == null) {
                    node = node2;
                }
                return node2;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // java.util.Iterator
        public E next() {
            PriorityBlockingQueue.this.fullyLock();
            try {
                if (this.current != null) {
                    E e = this.currentElement;
                    this.lastRet = this.current;
                    PriorityBlockingQueue<E>.Node<E> nextNode = nextNode(this.current);
                    this.current = nextNode;
                    this.currentElement = nextNode == null ? null : nextNode.getValue();
                    return e;
                }
                throw new NoSuchElementException();
            } finally {
                PriorityBlockingQueue.this.fullyUnlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
            r4.this$0.unlink(r0, r0);
         */
        @Override // java.util.Iterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void remove() {
            /*
                r4 = this;
                r0 = r4
                com.sobot.network.http.task.PriorityBlockingQueue<E>$Node<E> r0 = r0.lastRet
                if (r0 == 0) goto L4f
                r0 = r4
                com.sobot.network.http.task.PriorityBlockingQueue r0 = com.sobot.network.http.task.PriorityBlockingQueue.this
                r0.fullyLock()
                r0 = r4
                com.sobot.network.http.task.PriorityBlockingQueue<E>$Node<E> r0 = r0.lastRet     // Catch: java.lang.Throwable -> L45
                r8 = r0
                r0 = r4
                r1 = 0
                r0.lastRet = r1     // Catch: java.lang.Throwable -> L45
                r0 = r4
                com.sobot.network.http.task.PriorityBlockingQueue r0 = com.sobot.network.http.task.PriorityBlockingQueue.this     // Catch: java.lang.Throwable -> L45
                com.sobot.network.http.task.PriorityBlockingQueue<E>$Node<E> r0 = r0.head     // Catch: java.lang.Throwable -> L45
                r5 = r0
            L21:
                r0 = r5
                r6 = r0
                r0 = r6
                com.sobot.network.http.task.PriorityBlockingQueue<E>$Node<T> r0 = r0.next     // Catch: java.lang.Throwable -> L45
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L3d
                r0 = r7
                r5 = r0
                r0 = r7
                r1 = r8
                if (r0 != r1) goto L21
                r0 = r4
                com.sobot.network.http.task.PriorityBlockingQueue r0 = com.sobot.network.http.task.PriorityBlockingQueue.this     // Catch: java.lang.Throwable -> L45
                r1 = r7
                r2 = r6
                r0.unlink(r1, r2)     // Catch: java.lang.Throwable -> L45
            L3d:
                r0 = r4
                com.sobot.network.http.task.PriorityBlockingQueue r0 = com.sobot.network.http.task.PriorityBlockingQueue.this
                r0.fullyUnlock()
                return
            L45:
                r5 = move-exception
                r0 = r4
                com.sobot.network.http.task.PriorityBlockingQueue r0 = com.sobot.network.http.task.PriorityBlockingQueue.this
                r0.fullyUnlock()
                r0 = r5
                throw r0
            L4f:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                r1.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sobot.network.http.task.PriorityBlockingQueue.Itr.remove():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/task/PriorityBlockingQueue$Node.class */
    public class Node<T> {
        PriorityBlockingQueue<E>.Node<T> next;
        private PriorityObject<?> value;
        private boolean valueAsT = false;

        Node(T t) {
            setValue(t);
        }

        public int getPriority() {
            return this.value.priority;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, com.sobot.network.http.task.PriorityObject, com.sobot.network.http.task.PriorityObject<?>] */
        /* JADX WARN: Type inference failed for: r0v6, types: [T, E] */
        public T getValue() {
            ?? r0 = (T) this.value;
            if (r0 == 0) {
                return null;
            }
            return this.valueAsT ? r0 : r0.obj;
        }

        public void setValue(T t) {
            if (t == null) {
                this.value = null;
            } else if (!(t instanceof PriorityObject)) {
                this.value = new PriorityObject<>(0, t);
            } else {
                this.value = (PriorityObject) t;
                this.valueAsT = true;
            }
        }
    }

    public PriorityBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public PriorityBlockingQueue(int i) {
        this.count = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.takeLock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.putLock = reentrantLock2;
        this.notFull = reentrantLock2.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
    }

    public PriorityBlockingQueue(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        int i = 0;
        try {
            for (E e : collection) {
                if (e == null) {
                    throw new NullPointerException();
                }
                if (i == this.capacity) {
                    throw new IllegalStateException("Queue full");
                }
                opQueue(new Node<>(e));
                i++;
            }
            this.count.set(i);
        } finally {
            reentrantLock.unlock();
        }
    }

    private E _dequeue() {
        Node node = (PriorityBlockingQueue<E>.Node<E>) this.head;
        PriorityBlockingQueue<E>.Node<E> node2 = (PriorityBlockingQueue<E>.Node<E>) node.next;
        node.next = node;
        this.head = node2;
        E value = node2.getValue();
        node2.setValue(null);
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void _enqueue(PriorityBlockingQueue<E>.Node<E> node) {
        boolean z;
        Node node2 = this.head;
        while (true) {
            Node node3 = node2;
            if (node3.next == null) {
                z = false;
                break;
            }
            PriorityBlockingQueue<E>.Node<T> node4 = node3.next;
            if (node4.getPriority() < node.getPriority()) {
                node3.next = node;
                node.next = node4;
                z = true;
                break;
            }
            node2 = node3.next;
        }
        if (z) {
            return;
        }
        this.last.next = node;
        this.last = node;
    }

    private E opQueue(PriorityBlockingQueue<E>.Node<E> node) {
        synchronized (this) {
            if (node == null) {
                return _dequeue();
            }
            _enqueue(node);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count.set(0);
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    private void signalNotEmpty() {
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            this.notFull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        fullyLock();
        try {
            objectOutputStream.defaultWriteObject();
            PriorityBlockingQueue<E>.Node<E> node = this.head;
            while (true) {
                node = node.next;
                if (node == null) {
                    objectOutputStream.writeObject(null);
                    return;
                }
                objectOutputStream.writeObject(node.getValue());
            }
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        fullyLock();
        try {
            Node node = this.head;
            while (true) {
                Node node2 = node;
                Node node3 = node2.next;
                if (node3 == null) {
                    break;
                }
                node2.next = node2;
                node3.setValue(null);
                node = node3;
            }
            this.head = this.last;
            if (this.count.getAndSet(0) == this.capacity) {
                this.notFull.signal();
            }
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            PriorityBlockingQueue<E>.Node<E> node = this.head;
            do {
                node = node.next;
                if (node == null) {
                    fullyUnlock();
                    return false;
                }
            } while (!obj.equals(node.getValue()));
            fullyUnlock();
            return true;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection != null) {
            if (collection != this) {
                if (i <= 0) {
                    return 0;
                }
                ReentrantLock reentrantLock = this.takeLock;
                reentrantLock.lock();
                boolean z = false;
                try {
                    int min = Math.min(i, this.count.get());
                    PriorityBlockingQueue<E>.Node<E> node = this.head;
                    int i2 = 0;
                    while (i2 < min) {
                        PriorityBlockingQueue<E>.Node<E> node2 = node.next;
                        collection.add((E) node2.getValue());
                        node2.setValue(null);
                        node.next = node;
                        i2++;
                        node = node2;
                    }
                    boolean z2 = false;
                    if (i2 > 0) {
                        this.head = node;
                        z = false;
                        z2 = false;
                        if (this.count.getAndAdd(-i2) == this.capacity) {
                            z2 = true;
                        }
                    }
                    reentrantLock.unlock();
                    if (z2) {
                        signalNotFull();
                    }
                    return min;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    if (z) {
                        signalNotFull();
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        if (e != null) {
            AtomicInteger atomicInteger = this.count;
            boolean z = false;
            if (atomicInteger.get() == this.capacity) {
                return false;
            }
            int i = -1;
            PriorityBlockingQueue<E>.Node<E> node = new Node<>(e);
            ReentrantLock reentrantLock = this.putLock;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() < this.capacity) {
                    opQueue(node);
                    int andIncrement = atomicInteger.getAndIncrement();
                    i = andIncrement;
                    if (andIncrement + 1 < this.capacity) {
                        this.notFull.signal();
                        i = andIncrement;
                    }
                }
                reentrantLock.unlock();
                if (i == 0) {
                    signalNotEmpty();
                }
                if (i >= 0) {
                    z = true;
                }
                return z;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        throw null;
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e != null) {
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.putLock;
            AtomicInteger atomicInteger = this.count;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.capacity) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            opQueue(new Node<>(e));
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.capacity) {
                this.notFull.signal();
            }
            if (andIncrement == 0) {
                signalNotEmpty();
                return true;
            }
            return true;
        }
        throw null;
    }

    @Override // java.util.Queue
    public E peek() {
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            PriorityBlockingQueue<E>.Node<E> node = this.head.next;
            if (node == null) {
                reentrantLock.unlock();
                return null;
            }
            return node.getValue();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        AtomicInteger atomicInteger = this.count;
        E e = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i = -1;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                E opQueue = opQueue(null);
                int andDecrement = atomicInteger.getAndDecrement();
                i = andDecrement;
                e = opQueue;
                if (andDecrement > 1) {
                    this.notEmpty.signal();
                    e = opQueue;
                    i = andDecrement;
                }
            }
            reentrantLock.unlock();
            if (i == this.capacity) {
                signalNotFull();
            }
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E opQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        if (e == null) {
            throw null;
        }
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        opQueue(node);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        if (andIncrement == 0) {
            signalNotEmpty();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        PriorityBlockingQueue<E>.Node<E> node;
        PriorityBlockingQueue<E>.Node<E> node2;
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            PriorityBlockingQueue<E>.Node<E> node3 = this.head;
            do {
                node = node3;
                node2 = node.next;
                if (node2 == null) {
                    fullyUnlock();
                    return false;
                }
                node3 = node2;
            } while (!obj.equals(node2.getValue()));
            unlink(node2, node);
            fullyUnlock();
            return true;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.count.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E opQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            int i = 0;
            PriorityBlockingQueue<E>.Node<E> node = this.head.next;
            while (node != null) {
                objArr[i] = node.getValue();
                node = node.next;
                i++;
            }
            return objArr;
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i = this.count.get();
            T[] tArr2 = tArr;
            if (tArr.length < i) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            int i2 = 0;
            PriorityBlockingQueue<E>.Node<E> node = this.head.next;
            while (node != null) {
                tArr2[i2] = node.getValue();
                node = node.next;
                i2++;
            }
            if (tArr2.length > i2) {
                tArr2[i2] = null;
            }
            fullyUnlock();
            return tArr2;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    void unlink(PriorityBlockingQueue<E>.Node<E> node, PriorityBlockingQueue<E>.Node<E> node2) {
        node.setValue(null);
        node2.next = (PriorityBlockingQueue<E>.Node<E>) node.next;
        if (this.last == node) {
            this.last = node2;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }
}
