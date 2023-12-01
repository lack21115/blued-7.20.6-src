package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/LinkedBlockingQueue.class */
public class LinkedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    private static final long serialVersionUID = -6903933977591709194L;
    private final int capacity;
    private final AtomicInteger count;
    transient Node<E> head;
    private transient Node<E> last;
    private final Condition notEmpty;
    private final Condition notFull;
    private final ReentrantLock putLock;
    private final ReentrantLock takeLock;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/LinkedBlockingQueue$Itr.class */
    private class Itr implements Iterator<E> {
        private Node<E> current;
        private E currentElement;
        private Node<E> lastRet;

        Itr() {
            LinkedBlockingQueue.this.fullyLock();
            try {
                this.current = LinkedBlockingQueue.this.head.next;
                if (this.current != null) {
                    this.currentElement = this.current.item;
                }
            } finally {
                LinkedBlockingQueue.this.fullyUnlock();
            }
        }

        private Node<E> nextNode(Node<E> node) {
            Node<E> node2;
            while (true) {
                Node<E> node3 = node;
                node = node3.next;
                if (node != node3) {
                    node2 = node;
                    if (node == null) {
                        break;
                    }
                    node2 = node;
                    if (node.item != null) {
                        break;
                    }
                } else {
                    node2 = LinkedBlockingQueue.this.head.next;
                    break;
                }
            }
            return node2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // java.util.Iterator
        public E next() {
            LinkedBlockingQueue.this.fullyLock();
            try {
                if (this.current == null) {
                    throw new NoSuchElementException();
                }
                E e = this.currentElement;
                this.lastRet = this.current;
                this.current = nextNode(this.current);
                this.currentElement = this.current == null ? null : this.current.item;
                return e;
            } finally {
                LinkedBlockingQueue.this.fullyUnlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
            r4.this$0.unlink(r5, r6);
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
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r0.lastRet
                if (r0 != 0) goto Lf
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                r1.<init>()
                throw r0
            Lf:
                r0 = r4
                java.util.concurrent.LinkedBlockingQueue r0 = java.util.concurrent.LinkedBlockingQueue.this
                r0.fullyLock()
                r0 = r4
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r0.lastRet     // Catch: java.lang.Throwable -> L51
                r7 = r0
                r0 = r4
                r1 = 0
                r0.lastRet = r1     // Catch: java.lang.Throwable -> L51
                r0 = r4
                java.util.concurrent.LinkedBlockingQueue r0 = java.util.concurrent.LinkedBlockingQueue.this     // Catch: java.lang.Throwable -> L51
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r0.head     // Catch: java.lang.Throwable -> L51
                r6 = r0
                r0 = r6
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r0.next     // Catch: java.lang.Throwable -> L51
                r5 = r0
            L2d:
                r0 = r5
                if (r0 == 0) goto L3f
                r0 = r5
                r1 = r7
                if (r0 != r1) goto L47
                r0 = r4
                java.util.concurrent.LinkedBlockingQueue r0 = java.util.concurrent.LinkedBlockingQueue.this     // Catch: java.lang.Throwable -> L51
                r1 = r5
                r2 = r6
                r0.unlink(r1, r2)     // Catch: java.lang.Throwable -> L51
            L3f:
                r0 = r4
                java.util.concurrent.LinkedBlockingQueue r0 = java.util.concurrent.LinkedBlockingQueue.this
                r0.fullyUnlock()
                return
            L47:
                r0 = r5
                r6 = r0
                r0 = r5
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r0.next     // Catch: java.lang.Throwable -> L51
                r5 = r0
                goto L2d
            L51:
                r5 = move-exception
                r0 = r4
                java.util.concurrent.LinkedBlockingQueue r0 = java.util.concurrent.LinkedBlockingQueue.this
                r0.fullyUnlock()
                r0 = r5
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedBlockingQueue.Itr.remove():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/LinkedBlockingQueue$Node.class */
    public static class Node<E> {
        E item;
        Node<E> next;

        Node(E e) {
            this.item = e;
        }
    }

    public LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingQueue(int i) {
        this.count = new AtomicInteger();
        this.takeLock = new ReentrantLock();
        this.notEmpty = this.takeLock.newCondition();
        this.putLock = new ReentrantLock();
        this.notFull = this.putLock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
        Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
    }

    public LinkedBlockingQueue(Collection<? extends E> collection) {
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
                enqueue(new Node<>(e));
                i++;
            }
            this.count.set(i);
        } finally {
            reentrantLock.unlock();
        }
    }

    private E dequeue() {
        Node<E> node = this.head;
        Node<E> node2 = node.next;
        node.next = node;
        this.head = node2;
        E e = node2.item;
        node2.item = null;
        return e;
    }

    private void enqueue(Node<E> node) {
        this.last.next = node;
        this.last = node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count.set(0);
        Node<E> node = new Node<>(null);
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
            for (Node<E> node = this.head.next; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        fullyLock();
        try {
            Node<E> node = this.head;
            while (true) {
                Node<E> node2 = node;
                Node<E> node3 = node2.next;
                if (node3 == null) {
                    break;
                }
                node2.next = node2;
                node3.item = null;
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
            for (Node<E> node = this.head.next; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    fullyUnlock();
                    return true;
                }
            }
            fullyUnlock();
            return false;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        int i2;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (i <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        boolean z = false;
        try {
            int min = Math.min(i, this.count.get());
            Node<E> node = this.head;
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= min) {
                    break;
                }
                Node<E> node2 = node.next;
                collection.add((E) node2.item);
                node2.item = null;
                node.next = node;
                node = node2;
                i3 = i2 + 1;
            }
            boolean z2 = false;
            if (i2 > 0) {
                this.head = node;
                z = false;
                z2 = this.count.getAndAdd(-i2) == this.capacity;
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
        if (e == null) {
            throw new NullPointerException();
        }
        AtomicInteger atomicInteger = this.count;
        if (atomicInteger.get() == this.capacity) {
            return false;
        }
        int i = -1;
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.capacity) {
                enqueue(node);
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
            return i >= 0;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
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
        enqueue(new Node<>(e));
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

    @Override // java.util.Queue
    public E peek() {
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            Node<E> node = this.head.next;
            if (node == null) {
                reentrantLock.unlock();
                return null;
            }
            return node.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        E e;
        AtomicInteger atomicInteger = this.count;
        if (atomicInteger.get() == 0) {
            e = null;
        } else {
            E e2 = null;
            int i = -1;
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() > 0) {
                    E dequeue = dequeue();
                    int andDecrement = atomicInteger.getAndDecrement();
                    i = andDecrement;
                    e2 = dequeue;
                    if (andDecrement > 1) {
                        this.notEmpty.signal();
                        e2 = dequeue;
                        i = andDecrement;
                    }
                }
                reentrantLock.unlock();
                e = e2;
                if (i == this.capacity) {
                    signalNotFull();
                    return e2;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        r0 = dequeue();
        r0 = r0.getAndDecrement();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r0 <= 1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
        r5.notEmpty.signal();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        r0.unlock();
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r0 != r5.capacity) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        signalNotFull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
        return r8;
     */
    @Override // java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E poll(long r6, java.util.concurrent.TimeUnit r8) throws java.lang.InterruptedException {
        /*
            r5 = this;
            r0 = r8
            r1 = r6
            long r0 = r0.toNanos(r1)
            r6 = r0
            r0 = r5
            java.util.concurrent.atomic.AtomicInteger r0 = r0.count
            r8 = r0
            r0 = r5
            java.util.concurrent.locks.ReentrantLock r0 = r0.takeLock
            r11 = r0
            r0 = r11
            r0.lockInterruptibly()
        L16:
            r0 = r8
            int r0 = r0.get()     // Catch: java.lang.Throwable -> L71
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L3e
            r0 = r6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L30
            r0 = 0
            r8 = r0
            r0 = r11
            r0.unlock()
        L2e:
            r0 = r8
            return r0
        L30:
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0.notEmpty     // Catch: java.lang.Throwable -> L71
            r1 = r6
            long r0 = r0.awaitNanos(r1)     // Catch: java.lang.Throwable -> L71
            r6 = r0
            goto L16
        L3e:
            r0 = r5
            java.lang.Object r0 = r0.dequeue()     // Catch: java.lang.Throwable -> L71
            r10 = r0
            r0 = r8
            int r0 = r0.getAndDecrement()     // Catch: java.lang.Throwable -> L71
            r9 = r0
            r0 = r9
            r1 = 1
            if (r0 <= r1) goto L59
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0.notEmpty     // Catch: java.lang.Throwable -> L71
            r0.signal()     // Catch: java.lang.Throwable -> L71
        L59:
            r0 = r11
            r0.unlock()
            r0 = r10
            r8 = r0
            r0 = r9
            r1 = r5
            int r1 = r1.capacity
            if (r0 != r1) goto L2e
            r0 = r5
            r0.signalNotFull()
            r0 = r10
            return r0
        L71:
            r8 = move-exception
            r0 = r11
            r0.unlock()
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedBlockingQueue.poll(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e);
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
        enqueue(node);
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
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            Node<E> node = this.head;
            for (Node<E> node2 = node.next; node2 != null; node2 = node2.next) {
                if (obj.equals(node2.item)) {
                    unlink(node2, node);
                    fullyUnlock();
                    return true;
                }
                node = node2;
            }
            fullyUnlock();
            return false;
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
        E dequeue = dequeue();
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return dequeue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            Node<E> node = this.head.next;
            int i = 0;
            while (true) {
                int i2 = i;
                if (node == null) {
                    return objArr;
                }
                objArr[i2] = node.item;
                node = node.next;
                i = i2 + 1;
            }
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int i;
        fullyLock();
        try {
            int i2 = this.count.get();
            T[] tArr2 = tArr;
            if (tArr.length < i2) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
            }
            Node<E> node = this.head.next;
            int i3 = 0;
            while (true) {
                i = i3;
                if (node == null) {
                    break;
                }
                tArr2[i] = node.item;
                node = node.next;
                i3 = i + 1;
            }
            if (tArr2.length > i) {
                tArr2[i] = null;
            }
            fullyUnlock();
            return tArr2;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        fullyLock();
        try {
            Node<E> node = this.head.next;
            if (node == null) {
                fullyUnlock();
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                E e = node.item;
                E e2 = e;
                if (e == this) {
                    e2 = "(this Collection)";
                }
                sb.append(e2);
                node = node.next;
                if (node == null) {
                    return sb.append(']').toString();
                }
                sb.append(',').append(' ');
            }
        } finally {
            fullyUnlock();
        }
    }

    void unlink(Node<E> node, Node<E> node2) {
        node.item = null;
        node2.next = node.next;
        if (this.last == node) {
            this.last = node2;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }
}
