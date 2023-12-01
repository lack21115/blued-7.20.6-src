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
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/LinkedTransferQueue.class */
public class LinkedTransferQueue<E> extends AbstractQueue<E> implements TransferQueue<E>, Serializable {
    private static final int ASYNC = 1;
    private static final int CHAINED_SPINS = 64;
    private static final int FRONT_SPINS = 128;
    private static final boolean MP;
    private static final int NOW = 0;
    static final int SWEEP_THRESHOLD = 32;
    private static final int SYNC = 2;
    private static final int TIMED = 3;
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long serialVersionUID = -3223113410248163686L;
    private static final long sweepVotesOffset;
    private static final long tailOffset;
    volatile transient Node head;
    private volatile transient int sweepVotes;
    private volatile transient Node tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/LinkedTransferQueue$Itr.class */
    public final class Itr implements Iterator<E> {
        private Node lastPred;
        private Node lastRet;
        private E nextItem;
        private Node nextNode;

        Itr() {
            advance(null);
        }

        private void advance(Node node) {
            Node node2;
            Node node3 = this.lastRet;
            if (node3 == null || node3.isMatched()) {
                Node node4 = this.lastPred;
                if (node4 != null && !node4.isMatched()) {
                    while (true) {
                        Node node5 = node4.next;
                        if (node5 == null || node5 == node4 || !node5.isMatched() || (node2 = node5.next) == null || node2 == node5) {
                            break;
                        }
                        node4.casNext(node5, node2);
                    }
                } else {
                    this.lastPred = null;
                }
            } else {
                this.lastPred = node3;
            }
            this.lastRet = node;
            while (true) {
                Node node6 = node == null ? LinkedTransferQueue.this.head : node.next;
                if (node6 == null) {
                    break;
                } else if (node6 != node) {
                    Object obj = node6.item;
                    if (!node6.isData) {
                        if (obj == null) {
                            break;
                        }
                    } else if (obj != null && obj != node6) {
                        this.nextItem = (E) LinkedTransferQueue.cast(obj);
                        this.nextNode = node6;
                        return;
                    }
                    if (node != null) {
                        Node node7 = node6.next;
                        if (node7 == null) {
                            break;
                        } else if (node6 == node7) {
                            node = null;
                        } else {
                            node.casNext(node6, node7);
                        }
                    } else {
                        node = node6;
                    }
                } else {
                    node = null;
                }
            }
            this.nextNode = null;
            this.nextItem = null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.nextNode != null;
        }

        @Override // java.util.Iterator
        public final E next() {
            Node node = this.nextNode;
            if (node == null) {
                throw new NoSuchElementException();
            }
            E e = this.nextItem;
            advance(node);
            return e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            if (node.tryMatchData()) {
                LinkedTransferQueue.this.unsplice(this.lastPred, node);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/LinkedTransferQueue$Node.class */
    public static final class Node {
        private static final Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;
        private static final long serialVersionUID = -3375979862319811754L;
        private static final long waiterOffset;
        final boolean isData;
        volatile Object item;
        volatile Node next;
        volatile Thread waiter;

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                itemOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("item"));
                nextOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("next"));
                waiterOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("waiter"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        Node(Object obj, boolean z) {
            UNSAFE.putObject(this, itemOffset, obj);
            this.isData = z;
        }

        final boolean cannotPrecede(boolean z) {
            Object obj;
            boolean z2 = this.isData;
            if (z2 == z || (obj = this.item) == this) {
                return false;
            }
            return (obj != null) == z2;
        }

        final boolean casItem(Object obj, Object obj2) {
            return UNSAFE.compareAndSwapObject(this, itemOffset, obj, obj2);
        }

        final boolean casNext(Node node, Node node2) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, node, node2);
        }

        final void forgetContents() {
            UNSAFE.putObject(this, itemOffset, this);
            UNSAFE.putObject(this, waiterOffset, null);
        }

        final void forgetNext() {
            UNSAFE.putObject(this, nextOffset, this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            if ((r0 == null) == r3.isData) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final boolean isMatched() {
            /*
                r3 = this;
                r0 = 0
                r5 = r0
                r0 = r3
                java.lang.Object r0 = r0.item
                r6 = r0
                r0 = r6
                r1 = r3
                if (r0 == r1) goto L1a
                r0 = r6
                if (r0 != 0) goto L1e
                r0 = 1
                r4 = r0
            L12:
                r0 = r4
                r1 = r3
                boolean r1 = r1.isData
                if (r0 != r1) goto L1c
            L1a:
                r0 = 1
                r5 = r0
            L1c:
                r0 = r5
                return r0
            L1e:
                r0 = 0
                r4 = r0
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedTransferQueue.Node.isMatched():boolean");
        }

        final boolean isUnmatchedRequest() {
            return !this.isData && this.item == null;
        }

        final boolean tryMatchData() {
            Object obj = this.item;
            if (obj == null || obj == this || !casItem(obj, null)) {
                return false;
            }
            LockSupport.unpark(this.waiter);
            return true;
        }
    }

    static {
        boolean z = true;
        if (Runtime.getRuntime().availableProcessors() <= 1) {
            z = false;
        }
        MP = z;
        try {
            UNSAFE = Unsafe.getUnsafe();
            headOffset = UNSAFE.objectFieldOffset(LinkedTransferQueue.class.getDeclaredField("head"));
            tailOffset = UNSAFE.objectFieldOffset(LinkedTransferQueue.class.getDeclaredField("tail"));
            sweepVotesOffset = UNSAFE.objectFieldOffset(LinkedTransferQueue.class.getDeclaredField("sweepVotes"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public LinkedTransferQueue() {
    }

    public LinkedTransferQueue(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    private E awaitMatch(Node node, Node node2, E e, boolean z, long j) {
        long nanoTime = z ? System.nanoTime() + j : 0L;
        Thread currentThread = Thread.currentThread();
        int i = -1;
        ThreadLocalRandom threadLocalRandom = null;
        while (true) {
            Object obj = node.item;
            if (obj != e) {
                node.forgetContents();
                return (E) cast(obj);
            } else if ((currentThread.isInterrupted() || (z && j <= 0)) && node.casItem(e, node)) {
                unsplice(node2, node);
                return e;
            } else if (i < 0) {
                int spinsFor = spinsFor(node2, node.isData);
                i = spinsFor;
                if (spinsFor > 0) {
                    threadLocalRandom = ThreadLocalRandom.current();
                    i = spinsFor;
                }
            } else if (i > 0) {
                int i2 = i - 1;
                i = i2;
                if (threadLocalRandom.nextInt(64) == 0) {
                    Thread.yield();
                    i = i2;
                }
            } else if (node.waiter == null) {
                node.waiter = currentThread;
            } else if (z) {
                long nanoTime2 = nanoTime - System.nanoTime();
                j = nanoTime2;
                if (nanoTime2 > 0) {
                    LockSupport.parkNanos(this, nanoTime2);
                    j = nanoTime2;
                }
            } else {
                LockSupport.park(this);
            }
        }
    }

    private boolean casHead(Node node, Node node2) {
        return UNSAFE.compareAndSwapObject(this, headOffset, node, node2);
    }

    private boolean casSweepVotes(int i, int i2) {
        return UNSAFE.compareAndSwapInt(this, sweepVotesOffset, i, i2);
    }

    private boolean casTail(Node node, Node node2) {
        return UNSAFE.compareAndSwapObject(this, tailOffset, node, node2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> E cast(Object obj) {
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int countOfMode(boolean r4) {
        /*
            r3 = this;
            r0 = 0
            r5 = r0
            r0 = r3
            java.util.concurrent.LinkedTransferQueue$Node r0 = r0.head
            r7 = r0
        L8:
            r0 = r5
            r6 = r0
            r0 = r7
            if (r0 == 0) goto L32
            r0 = r5
            r6 = r0
            r0 = r7
            boolean r0 = r0.isMatched()
            if (r0 != 0) goto L34
            r0 = r7
            boolean r0 = r0.isData
            r1 = r4
            if (r0 == r1) goto L24
            r0 = 0
            return r0
        L24:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            r0 = r5
            r6 = r0
            r0 = r5
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L34
            r0 = r5
            r6 = r0
        L32:
            r0 = r6
            return r0
        L34:
            r0 = r7
            java.util.concurrent.LinkedTransferQueue$Node r0 = r0.next
            r8 = r0
            r0 = r8
            r1 = r7
            if (r0 == r1) goto L4b
            r0 = r8
            r7 = r0
            r0 = r6
            r5 = r0
            goto L8
        L4b:
            r0 = 0
            r5 = r0
            r0 = r3
            java.util.concurrent.LinkedTransferQueue$Node r0 = r0.head
            r7 = r0
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedTransferQueue.countOfMode(boolean):int");
    }

    private boolean findAndRemove(Object obj) {
        if (obj != null) {
            Node node = null;
            Node node2 = this.head;
            while (node2 != null) {
                Object obj2 = node2.item;
                if (node2.isData) {
                    if (obj2 != null && obj2 != node2 && obj.equals(obj2) && node2.tryMatchData()) {
                        unsplice(node, node2);
                        return true;
                    }
                } else if (obj2 == null) {
                    return false;
                }
                Node node3 = node2;
                Node node4 = node2.next;
                node2 = node4;
                node = node3;
                if (node4 == node3) {
                    node = null;
                    node2 = this.head;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private E firstDataItem() {
        E e;
        Node node = this.head;
        while (true) {
            Node node2 = node;
            e = null;
            if (node2 == null) {
                break;
            }
            Object obj = node2.item;
            if (!node2.isData) {
                e = null;
                if (obj == null) {
                    break;
                }
                node = succ(node2);
            } else {
                if (obj != null && obj != node2) {
                    e = cast(obj);
                    break;
                }
                node = succ(node2);
            }
        }
        return e;
    }

    private Node firstOfMode(boolean z) {
        Node node = this.head;
        while (true) {
            Node node2 = node;
            if (node2 == null) {
                return null;
            }
            if (!node2.isMatched()) {
                if (node2.isData == z) {
                    return node2;
                }
                return null;
            }
            node = succ(node2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            offer(readObject);
        }
    }

    private static int spinsFor(Node node, boolean z) {
        if (!MP || node == null) {
            return 0;
        }
        if (node.isData != z) {
            return 192;
        }
        if (node.isMatched()) {
            return 128;
        }
        return node.waiter == null ? 64 : 0;
    }

    private void sweep() {
        Node node;
        Node node2 = this.head;
        while (node2 != null && (node = node2.next) != null) {
            if (node.isMatched()) {
                Node node3 = node.next;
                if (node3 == null) {
                    return;
                }
                if (node == node3) {
                    node2 = this.head;
                } else {
                    node2.casNext(node, node3);
                }
            } else {
                node2 = node;
            }
        }
    }

    private Node tryAppend(Node node, boolean z) {
        Node node2;
        Node node3;
        Node node4;
        Node node5;
        Node node6 = this.tail;
        Node node7 = node6;
        while (true) {
            Node node8 = node7;
            if (node7 == null) {
                node7 = this.head;
                node8 = node7;
                if (node7 == null) {
                    if (casHead(null, node)) {
                        node2 = node;
                        break;
                    }
                }
            }
            node2 = null;
            if (node8.cannotPrecede(z)) {
                break;
            }
            Node node9 = node8.next;
            if (node9 != null) {
                if (node8 != node6) {
                    node7 = this.tail;
                    if (node6 != node7) {
                        node6 = node7;
                    }
                }
                node7 = node8 != node9 ? node9 : null;
            } else if (node8.casNext(null, node)) {
                if (node8 != node6) {
                    do {
                        if ((this.tail == node6 && casTail(node6, node)) || (node3 = this.tail) == null || (node4 = node3.next) == null || (node5 = node4.next) == null) {
                            break;
                        }
                        node6 = node3;
                        node = node5;
                    } while (node5 != node3);
                }
                return node8;
            } else {
                node7 = node8.next;
            }
        }
        return node2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeObject(null);
    }

    private E xfer(E e, boolean z, int i, long j) {
        E e2;
        Node node;
        if (z && e == null) {
            throw new NullPointerException();
        }
        Node node2 = null;
        while (true) {
            Node node3 = this.head;
            Node node4 = node3;
            while (true) {
                Node node5 = node4;
                if (node5 == null) {
                    break;
                }
                boolean z2 = node5.isData;
                Object obj = node5.item;
                if (obj != node5) {
                    if ((obj != null) == z2) {
                        if (z2 == z) {
                            break;
                        } else if (node5.casItem(obj, e)) {
                            Node node6 = node5;
                            while (true) {
                                if (node6 == node3) {
                                    break;
                                }
                                Node node7 = node6.next;
                                if (this.head == node3) {
                                    Node node8 = node7;
                                    if (node7 == null) {
                                        node8 = node6;
                                    }
                                    if (casHead(node3, node8)) {
                                        node3.forgetNext();
                                        break;
                                    }
                                }
                                node3 = this.head;
                                if (node3 != null && (node = node3.next) != null) {
                                    node6 = node;
                                    if (!node.isMatched()) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            LockSupport.unpark(node5.waiter);
                            return (E) cast(obj);
                        }
                    }
                }
                Node node9 = node5.next;
                if (node5 != node9) {
                    node4 = node9;
                } else {
                    node3 = this.head;
                    node4 = node3;
                }
            }
            e2 = e;
            if (i == 0) {
                break;
            }
            Node node10 = node2;
            if (node2 == null) {
                node10 = new Node(e, z);
            }
            Node tryAppend = tryAppend(node10, z);
            node2 = node10;
            if (tryAppend != null) {
                e2 = e;
                if (i != 1) {
                    e2 = awaitMatch(node10, tryAppend, e, i == 3, j);
                }
            }
        }
        return e2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        xfer(e, true, 1, 0L);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Node node = this.head;
        while (true) {
            Node node2 = node;
            if (node2 == null) {
                return false;
            }
            Object obj2 = node2.item;
            if (node2.isData) {
                if (obj2 != null && obj2 != node2 && obj.equals(obj2)) {
                    return true;
                }
            } else if (obj2 == null) {
                return false;
            }
            node = succ(node2);
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

    @Override // java.util.concurrent.TransferQueue
    public int getWaitingConsumerCount() {
        return countOfMode(false);
    }

    @Override // java.util.concurrent.TransferQueue
    public boolean hasWaitingConsumer() {
        boolean z = false;
        if (firstOfMode(false) != null) {
            z = true;
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        Node node = this.head;
        while (true) {
            Node node2 = node;
            if (node2 == null) {
                return true;
            }
            if (!node2.isMatched()) {
                return !node2.isData;
            }
            node = succ(node2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        xfer(e, true, 1, 0L);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        xfer(e, true, 1, 0L);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return firstDataItem();
    }

    @Override // java.util.Queue
    public E poll() {
        return xfer(null, false, 0, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        E xfer = xfer(null, false, 3, timeUnit.toNanos(j));
        if (xfer == null && Thread.interrupted()) {
            throw new InterruptedException();
        }
        return xfer;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) {
        xfer(e, true, 1, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return findAndRemove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return countOfMode(true);
    }

    final Node succ(Node node) {
        Node node2 = node.next;
        Node node3 = node2;
        if (node == node2) {
            node3 = this.head;
        }
        return node3;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        E xfer = xfer(null, false, 2, 0L);
        if (xfer != null) {
            return xfer;
        }
        Thread.interrupted();
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.TransferQueue
    public void transfer(E e) throws InterruptedException {
        if (xfer(e, true, 2, 0L) != null) {
            Thread.interrupted();
            throw new InterruptedException();
        }
    }

    @Override // java.util.concurrent.TransferQueue
    public boolean tryTransfer(E e) {
        return xfer(e, true, 0, 0L) == null;
    }

    @Override // java.util.concurrent.TransferQueue
    public boolean tryTransfer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (xfer(e, true, 3, timeUnit.toNanos(j)) == null) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return false;
    }

    final void unsplice(Node node, Node node2) {
        node2.forgetContents();
        if (node == null || node == node2 || node.next != node2) {
            return;
        }
        Node node3 = node2.next;
        if (node3 != null && (node3 == node2 || !node.casNext(node2, node3) || !node.isMatched())) {
            return;
        }
        while (true) {
            Node node4 = this.head;
            if (node4 == node || node4 == node2 || node4 == null) {
                return;
            }
            if (node4.isMatched()) {
                Node node5 = node4.next;
                if (node5 == null) {
                    return;
                }
                if (node5 != node4 && casHead(node4, node5)) {
                    node4.forgetNext();
                }
            } else if (node.next == node || node2.next == node2) {
                return;
            } else {
                while (true) {
                    int i = this.sweepVotes;
                    if (i < 32) {
                        if (casSweepVotes(i, i + 1)) {
                            return;
                        }
                    } else if (casSweepVotes(i, 0)) {
                        sweep();
                        return;
                    }
                }
            }
        }
    }
}
