package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue.class */
public class SynchronousQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    static final int NCPUS = Runtime.getRuntime().availableProcessors();
    static final int maxTimedSpins;
    static final int maxUntimedSpins;
    private static final long serialVersionUID = -3223113410248163686L;
    static final long spinForTimeoutThreshold = 1000;
    private ReentrantLock qlock;
    private volatile transient Transferer<E> transferer;
    private WaitQueue waitingConsumers;
    private WaitQueue waitingProducers;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$EmptyIterator.class */
    private static class EmptyIterator<E> implements Iterator<E> {
        static final EmptyIterator<Object> EMPTY_ITERATOR = new EmptyIterator<>();

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$FifoWaitQueue.class */
    static class FifoWaitQueue extends WaitQueue {
        private static final long serialVersionUID = -3623113410248163686L;

        FifoWaitQueue() {
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$LifoWaitQueue.class */
    static class LifoWaitQueue extends WaitQueue {
        private static final long serialVersionUID = -3633113410248163686L;

        LifoWaitQueue() {
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$TransferQueue.class */
    static final class TransferQueue<E> extends Transferer<E> {
        private static final Unsafe UNSAFE;
        private static final long cleanMeOffset;
        private static final long headOffset;
        private static final long tailOffset;
        volatile transient QNode cleanMe;
        volatile transient QNode head;
        volatile transient QNode tail;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$TransferQueue$QNode.class */
        public static final class QNode {
            private static final Unsafe UNSAFE;
            private static final long itemOffset;
            private static final long nextOffset;
            final boolean isData;
            volatile Object item;
            volatile QNode next;
            volatile Thread waiter;

            static {
                try {
                    UNSAFE = Unsafe.getUnsafe();
                    itemOffset = UNSAFE.objectFieldOffset(QNode.class.getDeclaredField("item"));
                    nextOffset = UNSAFE.objectFieldOffset(QNode.class.getDeclaredField("next"));
                } catch (Exception e) {
                    throw new Error(e);
                }
            }

            QNode(Object obj, boolean z) {
                this.item = obj;
                this.isData = z;
            }

            boolean casItem(Object obj, Object obj2) {
                return this.item == obj && UNSAFE.compareAndSwapObject(this, itemOffset, obj, obj2);
            }

            boolean casNext(QNode qNode, QNode qNode2) {
                return this.next == qNode && UNSAFE.compareAndSwapObject(this, nextOffset, qNode, qNode2);
            }

            boolean isCancelled() {
                return this.item == this;
            }

            boolean isOffList() {
                return this.next == this;
            }

            void tryCancel(Object obj) {
                UNSAFE.compareAndSwapObject(this, itemOffset, obj, this);
            }
        }

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                headOffset = UNSAFE.objectFieldOffset(TransferQueue.class.getDeclaredField("head"));
                tailOffset = UNSAFE.objectFieldOffset(TransferQueue.class.getDeclaredField("tail"));
                cleanMeOffset = UNSAFE.objectFieldOffset(TransferQueue.class.getDeclaredField("cleanMe"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        TransferQueue() {
            QNode qNode = new QNode(null, false);
            this.head = qNode;
            this.tail = qNode;
        }

        void advanceHead(QNode qNode, QNode qNode2) {
            if (qNode == this.head && UNSAFE.compareAndSwapObject(this, headOffset, qNode, qNode2)) {
                qNode.next = qNode;
            }
        }

        void advanceTail(QNode qNode, QNode qNode2) {
            if (this.tail == qNode) {
                UNSAFE.compareAndSwapObject(this, tailOffset, qNode, qNode2);
            }
        }

        Object awaitFulfill(QNode qNode, E e, boolean z, long j) {
            long nanoTime = z ? System.nanoTime() + j : 0L;
            Thread currentThread = Thread.currentThread();
            int i = this.head.next == qNode ? z ? SynchronousQueue.maxTimedSpins : SynchronousQueue.maxUntimedSpins : 0;
            while (true) {
                if (currentThread.isInterrupted()) {
                    qNode.tryCancel(e);
                }
                Object obj = qNode.item;
                if (obj != e) {
                    return obj;
                }
                long j2 = j;
                if (z) {
                    j = nanoTime - System.nanoTime();
                    j2 = j;
                    if (j <= 0) {
                        qNode.tryCancel(e);
                    }
                }
                if (i > 0) {
                    i--;
                    j = j2;
                } else if (qNode.waiter == null) {
                    qNode.waiter = currentThread;
                    j = j2;
                } else if (z) {
                    j = j2;
                    if (j2 > 1000) {
                        LockSupport.parkNanos(this, j2);
                        j = j2;
                    }
                } else {
                    LockSupport.park(this);
                    j = j2;
                }
            }
        }

        boolean casCleanMe(QNode qNode, QNode qNode2) {
            return this.cleanMe == qNode && UNSAFE.compareAndSwapObject(this, cleanMeOffset, qNode, qNode2);
        }

        void clean(QNode qNode, QNode qNode2) {
            QNode qNode3;
            QNode qNode4;
            qNode2.waiter = null;
            while (qNode.next == qNode2) {
                QNode qNode5 = this.head;
                QNode qNode6 = qNode5.next;
                if (qNode6 == null || !qNode6.isCancelled()) {
                    QNode qNode7 = this.tail;
                    if (qNode7 == qNode5) {
                        return;
                    }
                    QNode qNode8 = qNode7.next;
                    if (qNode7 != this.tail) {
                        continue;
                    } else if (qNode8 != null) {
                        advanceTail(qNode7, qNode8);
                    } else if (qNode2 != qNode7 && ((qNode4 = qNode2.next) == qNode2 || qNode.casNext(qNode2, qNode4))) {
                        return;
                    } else {
                        QNode qNode9 = this.cleanMe;
                        if (qNode9 != null) {
                            QNode qNode10 = qNode9.next;
                            if (qNode10 == null || qNode10 == qNode9 || !qNode10.isCancelled() || (qNode10 != qNode7 && (qNode3 = qNode10.next) != null && qNode3 != qNode10 && qNode9.casNext(qNode10, qNode3))) {
                                casCleanMe(qNode9, null);
                            }
                            if (qNode9 == qNode) {
                                return;
                            }
                        } else if (casCleanMe(null, qNode)) {
                            return;
                        }
                    }
                } else {
                    advanceHead(qNode5, qNode6);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.SynchronousQueue.Transferer
        E transfer(E e, boolean z, long j) {
            Object obj;
            Object obj2 = null;
            boolean z2 = e != null;
            while (true) {
                QNode qNode = this.tail;
                QNode qNode2 = this.head;
                if (qNode != null && qNode2 != null) {
                    if (qNode2 == qNode || qNode.isData == z2) {
                        QNode qNode3 = qNode.next;
                        if (qNode == this.tail) {
                            if (qNode3 == null) {
                                if (z && j <= 0) {
                                    obj = null;
                                    break;
                                }
                                Object obj3 = obj2;
                                if (obj2 == null) {
                                    obj3 = new QNode(e, z2);
                                }
                                obj2 = obj3;
                                if (qNode.casNext(null, obj3)) {
                                    advanceTail(qNode, obj3);
                                    Object awaitFulfill = awaitFulfill(obj3, e, z, j);
                                    if (awaitFulfill == obj3) {
                                        clean(qNode, obj3);
                                        return null;
                                    }
                                    if (!obj3.isOffList()) {
                                        advanceHead(qNode, obj3);
                                        if (awaitFulfill != null) {
                                            obj3.item = obj3;
                                        }
                                        obj3.waiter = null;
                                    }
                                    obj = awaitFulfill;
                                    if (awaitFulfill == null) {
                                        return e;
                                    }
                                }
                            } else {
                                advanceTail(qNode, qNode3);
                            }
                        } else {
                            continue;
                        }
                    } else {
                        QNode qNode4 = qNode2.next;
                        if (qNode == this.tail && qNode4 != null && qNode2 == this.head) {
                            Object obj4 = qNode4.item;
                            if (z2 == (obj4 != null) || obj4 == qNode4 || !qNode4.casItem(obj4, e)) {
                                advanceHead(qNode2, qNode4);
                            } else {
                                advanceHead(qNode2, qNode4);
                                LockSupport.unpark(qNode4.waiter);
                                obj = obj4;
                                if (obj4 == null) {
                                    return e;
                                }
                            }
                        }
                    }
                }
            }
            return obj;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$TransferStack.class */
    static final class TransferStack<E> extends Transferer<E> {
        static final int DATA = 1;
        static final int FULFILLING = 2;
        static final int REQUEST = 0;
        private static final Unsafe UNSAFE;
        private static final long headOffset;
        volatile SNode head;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$TransferStack$SNode.class */
        public static final class SNode {
            private static final Unsafe UNSAFE;
            private static final long matchOffset;
            private static final long nextOffset;
            Object item;
            volatile SNode match;
            int mode;
            volatile SNode next;
            volatile Thread waiter;

            static {
                try {
                    UNSAFE = Unsafe.getUnsafe();
                    matchOffset = UNSAFE.objectFieldOffset(SNode.class.getDeclaredField("match"));
                    nextOffset = UNSAFE.objectFieldOffset(SNode.class.getDeclaredField("next"));
                } catch (Exception e) {
                    throw new Error(e);
                }
            }

            SNode(Object obj) {
                this.item = obj;
            }

            boolean casNext(SNode sNode, SNode sNode2) {
                return sNode == this.next && UNSAFE.compareAndSwapObject(this, nextOffset, sNode, sNode2);
            }

            boolean isCancelled() {
                return this.match == this;
            }

            void tryCancel() {
                UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
            }

            boolean tryMatch(SNode sNode) {
                if (this.match != null || !UNSAFE.compareAndSwapObject(this, matchOffset, null, sNode)) {
                    return this.match == sNode;
                }
                Thread thread = this.waiter;
                if (thread != null) {
                    this.waiter = null;
                    LockSupport.unpark(thread);
                    return true;
                }
                return true;
            }
        }

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                headOffset = UNSAFE.objectFieldOffset(TransferStack.class.getDeclaredField("head"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        TransferStack() {
        }

        static boolean isFulfilling(int i) {
            return (i & 2) != 0;
        }

        static SNode snode(SNode sNode, Object obj, SNode sNode2, int i) {
            SNode sNode3 = sNode;
            if (sNode == null) {
                sNode3 = new SNode(obj);
            }
            sNode3.mode = i;
            sNode3.next = sNode2;
            return sNode3;
        }

        SNode awaitFulfill(SNode sNode, boolean z, long j) {
            long nanoTime = z ? System.nanoTime() + j : 0L;
            Thread currentThread = Thread.currentThread();
            int i = shouldSpin(sNode) ? z ? SynchronousQueue.maxTimedSpins : SynchronousQueue.maxUntimedSpins : 0;
            while (true) {
                if (currentThread.isInterrupted()) {
                    sNode.tryCancel();
                }
                SNode sNode2 = sNode.match;
                if (sNode2 != null) {
                    return sNode2;
                }
                long j2 = j;
                if (z) {
                    j = nanoTime - System.nanoTime();
                    j2 = j;
                    if (j <= 0) {
                        sNode.tryCancel();
                    }
                }
                if (i > 0) {
                    i = shouldSpin(sNode) ? i - 1 : 0;
                    j = j2;
                } else if (sNode.waiter == null) {
                    sNode.waiter = currentThread;
                    j = j2;
                } else if (z) {
                    j = j2;
                    if (j2 > 1000) {
                        LockSupport.parkNanos(this, j2);
                        j = j2;
                    }
                } else {
                    LockSupport.park(this);
                    j = j2;
                }
            }
        }

        boolean casHead(SNode sNode, SNode sNode2) {
            return sNode == this.head && UNSAFE.compareAndSwapObject(this, headOffset, sNode, sNode2);
        }

        void clean(SNode sNode) {
            SNode sNode2;
            sNode.item = null;
            sNode.waiter = null;
            SNode sNode3 = sNode.next;
            SNode sNode4 = sNode3;
            if (sNode3 != null) {
                sNode4 = sNode3;
                if (sNode3.isCancelled()) {
                    sNode4 = sNode3.next;
                }
            }
            while (true) {
                SNode sNode5 = this.head;
                sNode2 = sNode5;
                if (sNode5 == null) {
                    break;
                }
                sNode2 = sNode5;
                if (sNode5 == sNode4) {
                    break;
                }
                sNode2 = sNode5;
                if (!sNode5.isCancelled()) {
                    break;
                }
                casHead(sNode5, sNode5.next);
            }
            while (sNode2 != null && sNode2 != sNode4) {
                SNode sNode6 = sNode2.next;
                if (sNode6 == null || !sNode6.isCancelled()) {
                    sNode2 = sNode6;
                } else {
                    sNode2.casNext(sNode6, sNode6.next);
                }
            }
        }

        boolean shouldSpin(SNode sNode) {
            SNode sNode2 = this.head;
            return sNode2 == sNode || sNode2 == null || isFulfilling(sNode2.mode);
        }

        @Override // java.util.concurrent.SynchronousQueue.Transferer
        E transfer(E e, boolean z, long j) {
            SNode sNode = null;
            int i = e == null ? 0 : 1;
            while (true) {
                SNode sNode2 = this.head;
                if (sNode2 == null || sNode2.mode == i) {
                    if (!z || j > 0) {
                        SNode snode = snode(sNode, e, sNode2, i);
                        sNode = snode;
                        if (casHead(sNode2, snode)) {
                            SNode awaitFulfill = awaitFulfill(snode, z, j);
                            if (awaitFulfill == snode) {
                                clean(snode);
                                return null;
                            }
                            SNode sNode3 = this.head;
                            if (sNode3 != null && sNode3.next == snode) {
                                casHead(sNode3, snode.next);
                            }
                            return i == 0 ? (E) awaitFulfill.item : (E) snode.item;
                        }
                    } else if (sNode2 == null || !sNode2.isCancelled()) {
                        return null;
                    } else {
                        casHead(sNode2, sNode2.next);
                    }
                } else if (isFulfilling(sNode2.mode)) {
                    SNode sNode4 = sNode2.next;
                    if (sNode4 == null) {
                        casHead(sNode2, null);
                    } else {
                        SNode sNode5 = sNode4.next;
                        if (sNode4.tryMatch(sNode2)) {
                            casHead(sNode2, sNode5);
                        } else {
                            sNode2.casNext(sNode4, sNode5);
                        }
                    }
                } else if (sNode2.isCancelled()) {
                    casHead(sNode2, sNode2.next);
                } else {
                    SNode snode2 = snode(sNode, e, sNode2, i | 2);
                    sNode = snode2;
                    if (casHead(sNode2, snode2)) {
                        while (true) {
                            SNode sNode6 = snode2.next;
                            if (sNode6 == null) {
                                casHead(snode2, null);
                                sNode = null;
                                break;
                            }
                            SNode sNode7 = sNode6.next;
                            if (sNode6.tryMatch(snode2)) {
                                casHead(snode2, sNode7);
                                return i == 0 ? (E) sNode6.item : (E) snode2.item;
                            }
                            snode2.casNext(sNode6, sNode7);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$Transferer.class */
    public static abstract class Transferer<E> {
        Transferer() {
        }

        abstract E transfer(E e, boolean z, long j);
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/SynchronousQueue$WaitQueue.class */
    static class WaitQueue implements Serializable {
        WaitQueue() {
        }
    }

    static {
        maxTimedSpins = NCPUS < 2 ? 0 : 32;
        maxUntimedSpins = maxTimedSpins * 16;
    }

    public SynchronousQueue() {
        this(false);
    }

    public SynchronousQueue(boolean z) {
        this.transferer = z ? new TransferQueue() : new TransferStack();
    }

    static long objectFieldOffset(Unsafe unsafe, String str, Class<?> cls) {
        try {
            return unsafe.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            NoSuchFieldError noSuchFieldError = new NoSuchFieldError(str);
            noSuchFieldError.initCause(e);
            throw noSuchFieldError;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.waitingProducers instanceof FifoWaitQueue) {
            this.transferer = new TransferQueue();
        } else {
            this.transferer = new TransferStack();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.transferer instanceof TransferQueue) {
            this.qlock = new ReentrantLock(true);
            this.waitingProducers = new FifoWaitQueue();
            this.waitingConsumers = new FifoWaitQueue();
        } else {
            this.qlock = new ReentrantLock();
            this.waitingProducers = new LifoWaitQueue();
            this.waitingConsumers = new LifoWaitQueue();
        }
        objectOutputStream.defaultWriteObject();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            E poll = poll();
            if (poll == null) {
                return i2;
            }
            collection.add(poll);
            i = i2 + 1;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        int i2;
        E poll;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= i || (poll = poll()) == null) {
                break;
            }
            collection.add(poll);
            i3 = i2 + 1;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return EmptyIterator.EMPTY_ITERATOR;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        return this.transferer.transfer(e, true, 0L) != null;
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        if (this.transferer.transfer(e, true, timeUnit.toNanos(j)) != null) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return false;
    }

    @Override // java.util.Queue
    public E peek() {
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        return this.transferer.transfer(null, true, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        E transfer = this.transferer.transfer(null, true, timeUnit.toNanos(j));
        if (transfer == null && Thread.interrupted()) {
            throw new InterruptedException();
        }
        return transfer;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        if (this.transferer.transfer(e, false, 0L) == null) {
            Thread.interrupted();
            throw new InterruptedException();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 0;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        E transfer = this.transferer.transfer(null, false, 0L);
        if (transfer != null) {
            return transfer;
        }
        Thread.interrupted();
        throw new InterruptedException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
