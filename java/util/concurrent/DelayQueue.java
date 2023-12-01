package java.util.concurrent;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/DelayQueue.class */
public class DelayQueue<E extends Delayed> extends AbstractQueue<E> implements BlockingQueue<E> {
    private final transient ReentrantLock lock = new ReentrantLock();
    private final PriorityQueue<E> q = new PriorityQueue<>();
    private Thread leader = null;
    private final Condition available = this.lock.newCondition();

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/DelayQueue$Itr.class */
    private class Itr implements Iterator<E> {
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
            DelayQueue.this.removeEQ(this.array[this.lastRet]);
            this.lastRet = -1;
        }
    }

    public DelayQueue() {
    }

    public DelayQueue(Collection<? extends E> collection) {
        addAll(collection);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r0.getDelay(java.util.concurrent.TimeUnit.NANOSECONDS) > 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private E peekExpired() {
        /*
            r5 = this;
            r0 = r5
            java.util.PriorityQueue<E extends java.util.concurrent.Delayed> r0 = r0.q
            java.lang.Object r0 = r0.peek()
            java.util.concurrent.Delayed r0 = (java.util.concurrent.Delayed) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L1f
            r0 = r7
            r6 = r0
            r0 = r7
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.getDelay(r1)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L21
        L1f:
            r0 = 0
            r6 = r0
        L21:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.DelayQueue.peekExpired():java.util.concurrent.Delayed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((DelayQueue<E>) ((Delayed) obj));
    }

    public boolean add(E e) {
        return offer((DelayQueue<E>) e);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.q.clear();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                E peekExpired = peekExpired();
                if (peekExpired == null) {
                    return i2;
                }
                collection.add(peekExpired);
                this.q.poll();
                i = i2 + 1;
            } finally {
                reentrantLock.unlock();
            }
        }
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
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= i) {
                break;
            }
            try {
                E peekExpired = peekExpired();
                if (peekExpired == null) {
                    break;
                }
                collection.add(peekExpired);
                this.q.poll();
                i3 = i2 + 1;
            } finally {
                reentrantLock.unlock();
            }
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr(toArray());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return offer((DelayQueue<E>) ((Delayed) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.BlockingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj, long j, TimeUnit timeUnit) throws InterruptedException {
        return offer((DelayQueue<E>) ((Delayed) obj), j, timeUnit);
    }

    public boolean offer(E e) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.q.offer(e);
            if (this.q.peek() == e) {
                this.leader = null;
                this.available.signal();
            }
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offer((DelayQueue<E>) e);
    }

    @Override // java.util.Queue
    public E peek() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.q.peek();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            E peek = this.q.peek();
            if (peek == null || peek.getDelay(TimeUnit.NANOSECONDS) > 0) {
                reentrantLock.unlock();
                return null;
            }
            return this.q.poll();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
        r0 = r7.q.poll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r7.leader != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
        if (r7.q.peek() == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
        r7.available.signal();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
        r0.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0093, code lost:
        return r0;
     */
    /* JADX WARN: Finally extract failed */
    @Override // java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E poll(long r8, java.util.concurrent.TimeUnit r10) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.DelayQueue.poll(long, java.util.concurrent.TimeUnit):java.util.concurrent.Delayed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.BlockingQueue
    public /* bridge */ /* synthetic */ void put(Object obj) throws InterruptedException {
        put((DelayQueue<E>) ((Delayed) obj));
    }

    public void put(E e) {
        offer((DelayQueue<E>) e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.q.remove(obj);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void removeEQ(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = r3
            java.util.concurrent.locks.ReentrantLock r0 = r0.lock
            r5 = r0
            r0 = r5
            r0.lock()
            r0 = r3
            java.util.PriorityQueue<E extends java.util.concurrent.Delayed> r0 = r0.q     // Catch: java.lang.Throwable -> L2f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L2f
            r6 = r0
        L11:
            r0 = r6
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L2a
            r0 = r4
            r1 = r6
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L2f
            if (r0 != r1) goto L11
            r0 = r6
            r0.remove()     // Catch: java.lang.Throwable -> L2f
        L2a:
            r0 = r5
            r0.unlock()
            return
        L2f:
            r4 = move-exception
            r0 = r5
            r0.unlock()
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.DelayQueue.removeEQ(java.lang.Object):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.q.size();
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
                E peek = this.q.peek();
                if (peek == null) {
                    this.available.await();
                } else {
                    long delay = peek.getDelay(TimeUnit.NANOSECONDS);
                    if (delay <= 0) {
                        break;
                    } else if (this.leader != null) {
                        this.available.await();
                    } else {
                        Thread currentThread = Thread.currentThread();
                        this.leader = currentThread;
                        this.available.awaitNanos(delay);
                        if (this.leader == currentThread) {
                            this.leader = null;
                        }
                    }
                }
            } finally {
                if (this.leader == null && this.q.peek() != null) {
                    this.available.signal();
                }
                reentrantLock.unlock();
            }
        }
        return this.q.poll();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.q.toArray();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return (T[]) this.q.toArray(tArr);
        } finally {
            reentrantLock.unlock();
        }
    }
}
