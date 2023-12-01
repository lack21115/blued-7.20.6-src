package java.util.concurrent.locks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/AbstractQueuedLongSynchronizer.class */
public abstract class AbstractQueuedLongSynchronizer extends AbstractOwnableSynchronizer implements Serializable {
    private static final long headOffset;
    private static final long nextOffset;
    private static final long serialVersionUID = 7373984972572414692L;
    static final long spinForTimeoutThreshold = 1000;
    private static final long stateOffset;
    private static final long tailOffset;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long waitStatusOffset;
    private volatile transient Node head;
    private volatile long state;
    private volatile transient Node tail;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/AbstractQueuedLongSynchronizer$ConditionObject.class */
    public class ConditionObject implements Condition, Serializable {
        private static final int REINTERRUPT = 1;
        private static final int THROW_IE = -1;
        private static final long serialVersionUID = 1173984872572414699L;
        private transient Node firstWaiter;
        private transient Node lastWaiter;

        public ConditionObject() {
        }

        private Node addConditionWaiter() {
            Node node = this.lastWaiter;
            Node node2 = node;
            if (node != null) {
                node2 = node;
                if (node.waitStatus != -2) {
                    unlinkCancelledWaiters();
                    node2 = this.lastWaiter;
                }
            }
            Node node3 = new Node(Thread.currentThread(), -2);
            if (node2 == null) {
                this.firstWaiter = node3;
            } else {
                node2.nextWaiter = node3;
            }
            this.lastWaiter = node3;
            return node3;
        }

        private int checkInterruptWhileWaiting(Node node) {
            if (Thread.interrupted()) {
                return AbstractQueuedLongSynchronizer.this.transferAfterCancelledWait(node) ? -1 : 1;
            }
            return 0;
        }

        private void doSignal(Node node) {
            Node node2;
            do {
                Node node3 = node.nextWaiter;
                this.firstWaiter = node3;
                if (node3 == null) {
                    this.lastWaiter = null;
                }
                node.nextWaiter = null;
                if (AbstractQueuedLongSynchronizer.this.transferForSignal(node)) {
                    return;
                }
                node2 = this.firstWaiter;
                node = node2;
            } while (node2 != null);
        }

        private void doSignalAll(Node node) {
            Node node2;
            this.firstWaiter = null;
            this.lastWaiter = null;
            do {
                node2 = node.nextWaiter;
                node.nextWaiter = null;
                AbstractQueuedLongSynchronizer.this.transferForSignal(node);
                node = node2;
            } while (node2 != null);
        }

        private void reportInterruptAfterWait(int i) throws InterruptedException {
            if (i == -1) {
                throw new InterruptedException();
            }
            if (i == 1) {
                AbstractQueuedLongSynchronizer.selfInterrupt();
            }
        }

        private void unlinkCancelledWaiters() {
            Node node;
            Node node2 = this.firstWaiter;
            Node node3 = null;
            while (true) {
                Node node4 = node3;
                if (node2 == null) {
                    return;
                }
                Node node5 = node2.nextWaiter;
                if (node2.waitStatus != -2) {
                    node2.nextWaiter = null;
                    if (node4 == null) {
                        this.firstWaiter = node5;
                    } else {
                        node4.nextWaiter = node5;
                    }
                    node = node4;
                    if (node5 == null) {
                        this.lastWaiter = node4;
                        node = node4;
                    }
                } else {
                    node = node2;
                }
                node2 = node5;
                node3 = node;
            }
        }

        @Override // java.util.concurrent.locks.Condition
        public final void await() throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Node addConditionWaiter = addConditionWaiter();
            long fullyRelease = AbstractQueuedLongSynchronizer.this.fullyRelease(addConditionWaiter);
            int i = 0;
            while (true) {
                if (!AbstractQueuedLongSynchronizer.this.isOnSyncQueue(addConditionWaiter)) {
                    LockSupport.park(this);
                    int checkInterruptWhileWaiting = checkInterruptWhileWaiting(addConditionWaiter);
                    i = checkInterruptWhileWaiting;
                    if (checkInterruptWhileWaiting != 0) {
                        i = checkInterruptWhileWaiting;
                        break;
                    }
                } else {
                    break;
                }
            }
            int i2 = i;
            if (AbstractQueuedLongSynchronizer.this.acquireQueued(addConditionWaiter, fullyRelease)) {
                i2 = i;
                if (i != -1) {
                    i2 = 1;
                }
            }
            if (addConditionWaiter.nextWaiter != null) {
                unlinkCancelledWaiters();
            }
            if (i2 != 0) {
                reportInterruptAfterWait(i2);
            }
        }

        @Override // java.util.concurrent.locks.Condition
        public final boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            int i;
            boolean z;
            long nanos = timeUnit.toNanos(j);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Node addConditionWaiter = addConditionWaiter();
            long fullyRelease = AbstractQueuedLongSynchronizer.this.fullyRelease(addConditionWaiter);
            long nanoTime = System.nanoTime();
            int i2 = 0;
            long j2 = nanos;
            while (true) {
                long j3 = j2;
                i = i2;
                z = false;
                if (!AbstractQueuedLongSynchronizer.this.isOnSyncQueue(addConditionWaiter)) {
                    if (j3 > 0) {
                        if (j3 >= 1000) {
                            LockSupport.parkNanos(this, j3);
                        }
                        i2 = checkInterruptWhileWaiting(addConditionWaiter);
                        i = i2;
                        z = false;
                        if (i2 != 0) {
                            break;
                        }
                        j2 = (nanoTime + nanos) - System.nanoTime();
                    } else {
                        z = AbstractQueuedLongSynchronizer.this.transferAfterCancelledWait(addConditionWaiter);
                        i = i2;
                        break;
                    }
                } else {
                    break;
                }
            }
            int i3 = i;
            if (AbstractQueuedLongSynchronizer.this.acquireQueued(addConditionWaiter, fullyRelease)) {
                i3 = i;
                if (i != -1) {
                    i3 = 1;
                }
            }
            if (addConditionWaiter.nextWaiter != null) {
                unlinkCancelledWaiters();
            }
            if (i3 != 0) {
                reportInterruptAfterWait(i3);
            }
            return !z;
        }

        @Override // java.util.concurrent.locks.Condition
        public final long awaitNanos(long j) throws InterruptedException {
            int i;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Node addConditionWaiter = addConditionWaiter();
            long fullyRelease = AbstractQueuedLongSynchronizer.this.fullyRelease(addConditionWaiter);
            long nanoTime = System.nanoTime() + j;
            int i2 = 0;
            while (true) {
                i = i2;
                if (!AbstractQueuedLongSynchronizer.this.isOnSyncQueue(addConditionWaiter)) {
                    if (j > 0) {
                        if (j >= 1000) {
                            LockSupport.parkNanos(this, j);
                        }
                        i2 = checkInterruptWhileWaiting(addConditionWaiter);
                        i = i2;
                        if (i2 != 0) {
                            break;
                        }
                        j = nanoTime - System.nanoTime();
                    } else {
                        AbstractQueuedLongSynchronizer.this.transferAfterCancelledWait(addConditionWaiter);
                        i = i2;
                        break;
                    }
                } else {
                    break;
                }
            }
            int i3 = i;
            if (AbstractQueuedLongSynchronizer.this.acquireQueued(addConditionWaiter, fullyRelease)) {
                i3 = i;
                if (i != -1) {
                    i3 = 1;
                }
            }
            if (addConditionWaiter.nextWaiter != null) {
                unlinkCancelledWaiters();
            }
            if (i3 != 0) {
                reportInterruptAfterWait(i3);
            }
            return nanoTime - System.nanoTime();
        }

        @Override // java.util.concurrent.locks.Condition
        public final void awaitUninterruptibly() {
            Node addConditionWaiter = addConditionWaiter();
            long fullyRelease = AbstractQueuedLongSynchronizer.this.fullyRelease(addConditionWaiter);
            boolean z = false;
            while (!AbstractQueuedLongSynchronizer.this.isOnSyncQueue(addConditionWaiter)) {
                LockSupport.park(this);
                if (Thread.interrupted()) {
                    z = true;
                }
            }
            if (AbstractQueuedLongSynchronizer.this.acquireQueued(addConditionWaiter, fullyRelease) || z) {
                AbstractQueuedLongSynchronizer.selfInterrupt();
            }
        }

        @Override // java.util.concurrent.locks.Condition
        public final boolean awaitUntil(Date date) throws InterruptedException {
            int i;
            boolean z;
            long time = date.getTime();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Node addConditionWaiter = addConditionWaiter();
            long fullyRelease = AbstractQueuedLongSynchronizer.this.fullyRelease(addConditionWaiter);
            int i2 = 0;
            while (true) {
                i = i2;
                z = false;
                if (!AbstractQueuedLongSynchronizer.this.isOnSyncQueue(addConditionWaiter)) {
                    if (System.currentTimeMillis() <= time) {
                        LockSupport.parkUntil(this, time);
                        i = checkInterruptWhileWaiting(addConditionWaiter);
                        i2 = i;
                        if (i != 0) {
                            z = false;
                            break;
                        }
                    } else {
                        z = AbstractQueuedLongSynchronizer.this.transferAfterCancelledWait(addConditionWaiter);
                        i = i2;
                        break;
                    }
                } else {
                    break;
                }
            }
            int i3 = i;
            if (AbstractQueuedLongSynchronizer.this.acquireQueued(addConditionWaiter, fullyRelease)) {
                i3 = i;
                if (i != -1) {
                    i3 = 1;
                }
            }
            if (addConditionWaiter.nextWaiter != null) {
                unlinkCancelledWaiters();
            }
            if (i3 != 0) {
                reportInterruptAfterWait(i3);
            }
            return !z;
        }

        protected final int getWaitQueueLength() {
            if (AbstractQueuedLongSynchronizer.this.isHeldExclusively()) {
                int i = 0;
                Node node = this.firstWaiter;
                while (node != null) {
                    int i2 = i;
                    if (node.waitStatus == -2) {
                        i2 = i + 1;
                    }
                    node = node.nextWaiter;
                    i = i2;
                }
                return i;
            }
            throw new IllegalMonitorStateException();
        }

        protected final Collection<Thread> getWaitingThreads() {
            Thread thread;
            if (!AbstractQueuedLongSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            ArrayList arrayList = new ArrayList();
            Node node = this.firstWaiter;
            while (true) {
                Node node2 = node;
                if (node2 == null) {
                    return arrayList;
                }
                if (node2.waitStatus == -2 && (thread = node2.thread) != null) {
                    arrayList.add(thread);
                }
                node = node2.nextWaiter;
            }
        }

        protected final boolean hasWaiters() {
            if (!AbstractQueuedLongSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            Node node = this.firstWaiter;
            while (true) {
                Node node2 = node;
                if (node2 == null) {
                    return false;
                }
                if (node2.waitStatus == -2) {
                    return true;
                }
                node = node2.nextWaiter;
            }
        }

        final boolean isOwnedBy(AbstractQueuedLongSynchronizer abstractQueuedLongSynchronizer) {
            return abstractQueuedLongSynchronizer == AbstractQueuedLongSynchronizer.this;
        }

        @Override // java.util.concurrent.locks.Condition
        public final void signal() {
            if (!AbstractQueuedLongSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            Node node = this.firstWaiter;
            if (node != null) {
                doSignal(node);
            }
        }

        @Override // java.util.concurrent.locks.Condition
        public final void signalAll() {
            if (!AbstractQueuedLongSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            Node node = this.firstWaiter;
            if (node != null) {
                doSignalAll(node);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/AbstractQueuedLongSynchronizer$Node.class */
    public static final class Node {
        static final int CANCELLED = 1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;
        static final int SIGNAL = -1;
        volatile Node next;
        Node nextWaiter;
        volatile Node prev;
        volatile Thread thread;
        volatile int waitStatus;
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;

        Node() {
        }

        Node(Thread thread, int i) {
            this.waitStatus = i;
            this.thread = thread;
        }

        Node(Thread thread, Node node) {
            this.nextWaiter = node;
            this.thread = thread;
        }

        final boolean isShared() {
            return this.nextWaiter == SHARED;
        }

        final Node predecessor() throws NullPointerException {
            Node node = this.prev;
            if (node == null) {
                throw new NullPointerException();
            }
            return node;
        }
    }

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(AbstractQueuedLongSynchronizer.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset(AbstractQueuedLongSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(AbstractQueuedLongSynchronizer.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("waitStatus"));
            nextOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("next"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    protected AbstractQueuedLongSynchronizer() {
    }

    private Node addWaiter(Node node) {
        Node node2 = new Node(Thread.currentThread(), node);
        Node node3 = this.tail;
        if (node3 != null) {
            node2.prev = node3;
            if (compareAndSetTail(node3, node2)) {
                node3.next = node2;
                return node2;
            }
        }
        enq(node2);
        return node2;
    }

    private void cancelAcquire(Node node) {
        int i;
        if (node == null) {
            return;
        }
        node.thread = null;
        Node node2 = node.prev;
        while (node2.waitStatus > 0) {
            node2 = node2.prev;
            node.prev = node2;
        }
        Node node3 = node2.next;
        node.waitStatus = 1;
        if (node == this.tail && compareAndSetTail(node, node2)) {
            compareAndSetNext(node2, node3, null);
            return;
        }
        if (node2 == this.head || (((i = node2.waitStatus) != -1 && (i > 0 || !compareAndSetWaitStatus(node2, i, -1))) || node2.thread == null)) {
            unparkSuccessor(node);
        } else {
            Node node4 = node.next;
            if (node4 != null && node4.waitStatus <= 0) {
                compareAndSetNext(node2, node3, node4);
            }
        }
        node.next = node;
    }

    private final boolean compareAndSetHead(Node node) {
        return unsafe.compareAndSwapObject(this, headOffset, null, node);
    }

    private static final boolean compareAndSetNext(Node node, Node node2, Node node3) {
        return unsafe.compareAndSwapObject(node, nextOffset, node2, node3);
    }

    private final boolean compareAndSetTail(Node node, Node node2) {
        return unsafe.compareAndSwapObject(this, tailOffset, node, node2);
    }

    private static final boolean compareAndSetWaitStatus(Node node, int i, int i2) {
        return unsafe.compareAndSwapInt(node, waitStatusOffset, i, i2);
    }

    private void doAcquireInterruptibly(long j) throws InterruptedException {
        Node addWaiter = addWaiter(Node.EXCLUSIVE);
        while (true) {
            try {
                Node predecessor = addWaiter.predecessor();
                if (predecessor == this.head && tryAcquire(j)) {
                    setHead(addWaiter);
                    predecessor.next = null;
                    if (0 != 0) {
                        cancelAcquire(addWaiter);
                        return;
                    }
                    return;
                } else if (shouldParkAfterFailedAcquire(predecessor, addWaiter) && parkAndCheckInterrupt()) {
                    throw new InterruptedException();
                }
            } catch (Throwable th) {
                if (1 != 0) {
                    cancelAcquire(addWaiter);
                }
                throw th;
            }
        }
    }

    private boolean doAcquireNanos(long j, long j2) throws InterruptedException {
        boolean z = false;
        if (j2 > 0) {
            long nanoTime = System.nanoTime();
            Node addWaiter = addWaiter(Node.EXCLUSIVE);
            do {
                try {
                    Node predecessor = addWaiter.predecessor();
                    if (predecessor == this.head && tryAcquire(j)) {
                        setHead(addWaiter);
                        predecessor.next = null;
                        z = true;
                        if (0 != 0) {
                            cancelAcquire(addWaiter);
                            return true;
                        }
                    } else {
                        long nanoTime2 = (nanoTime + j2) - System.nanoTime();
                        if (nanoTime2 <= 0) {
                            if (1 != 0) {
                                cancelAcquire(addWaiter);
                                return false;
                            }
                        } else if (shouldParkAfterFailedAcquire(predecessor, addWaiter) && nanoTime2 > 1000) {
                            LockSupport.parkNanos(this, nanoTime2);
                        }
                    }
                } catch (Throwable th) {
                    if (1 != 0) {
                        cancelAcquire(addWaiter);
                    }
                    throw th;
                }
            } while (!Thread.interrupted());
            throw new InterruptedException();
        }
        return z;
    }

    private void doAcquireShared(long j) {
        Node predecessor;
        long tryAcquireShared;
        Node addWaiter = addWaiter(Node.SHARED);
        boolean z = false;
        while (true) {
            try {
                predecessor = addWaiter.predecessor();
                if (predecessor == this.head) {
                    tryAcquireShared = tryAcquireShared(j);
                    if (tryAcquireShared >= 0) {
                        break;
                    }
                }
                if (shouldParkAfterFailedAcquire(predecessor, addWaiter) && parkAndCheckInterrupt()) {
                    z = true;
                }
            } catch (Throwable th) {
                if (1 != 0) {
                    cancelAcquire(addWaiter);
                }
                throw th;
            }
        }
        setHeadAndPropagate(addWaiter, tryAcquireShared);
        predecessor.next = null;
        if (z) {
            selfInterrupt();
        }
        if (0 != 0) {
            cancelAcquire(addWaiter);
        }
    }

    private void doAcquireSharedInterruptibly(long j) throws InterruptedException {
        Node addWaiter = addWaiter(Node.SHARED);
        while (true) {
            try {
                Node predecessor = addWaiter.predecessor();
                if (predecessor == this.head) {
                    long tryAcquireShared = tryAcquireShared(j);
                    if (tryAcquireShared >= 0) {
                        setHeadAndPropagate(addWaiter, tryAcquireShared);
                        predecessor.next = null;
                        if (0 != 0) {
                            cancelAcquire(addWaiter);
                            return;
                        }
                        return;
                    }
                }
                if (shouldParkAfterFailedAcquire(predecessor, addWaiter) && parkAndCheckInterrupt()) {
                    throw new InterruptedException();
                }
            } catch (Throwable th) {
                if (1 != 0) {
                    cancelAcquire(addWaiter);
                }
                throw th;
            }
        }
    }

    private boolean doAcquireSharedNanos(long j, long j2) throws InterruptedException {
        boolean z;
        if (j2 > 0) {
            long nanoTime = System.nanoTime();
            Node addWaiter = addWaiter(Node.SHARED);
            do {
                try {
                    Node predecessor = addWaiter.predecessor();
                    if (predecessor == this.head) {
                        long tryAcquireShared = tryAcquireShared(j);
                        if (tryAcquireShared >= 0) {
                            setHeadAndPropagate(addWaiter, tryAcquireShared);
                            predecessor.next = null;
                            z = true;
                            if (0 != 0) {
                                cancelAcquire(addWaiter);
                                return true;
                            }
                        }
                    }
                    long nanoTime2 = (nanoTime + j2) - System.nanoTime();
                    if (nanoTime2 <= 0) {
                        z = false;
                        if (1 != 0) {
                            cancelAcquire(addWaiter);
                            return false;
                        }
                    } else if (shouldParkAfterFailedAcquire(predecessor, addWaiter) && nanoTime2 > 1000) {
                        LockSupport.parkNanos(this, nanoTime2);
                    }
                } catch (Throwable th) {
                    if (1 != 0) {
                        cancelAcquire(addWaiter);
                    }
                    throw th;
                }
            } while (!Thread.interrupted());
            throw new InterruptedException();
        }
        z = false;
        return z;
    }

    private void doReleaseShared() {
        while (true) {
            Node node = this.head;
            if (node != null && node != this.tail) {
                int i = node.waitStatus;
                if (i == -1) {
                    if (compareAndSetWaitStatus(node, -1, 0)) {
                        unparkSuccessor(node);
                    } else {
                        continue;
                    }
                } else if (i == 0 && !compareAndSetWaitStatus(node, 0, -3)) {
                }
            }
            if (node == this.head) {
                return;
            }
        }
    }

    private Node enq(Node node) {
        while (true) {
            Node node2 = this.tail;
            if (node2 != null) {
                node.prev = node2;
                if (compareAndSetTail(node2, node)) {
                    node2.next = node;
                    return node2;
                }
            } else if (compareAndSetHead(new Node())) {
                this.tail = this.head;
            }
        }
    }

    private boolean findNodeFromTail(Node node) {
        Node node2 = this.tail;
        while (true) {
            Node node3 = node2;
            if (node3 == node) {
                return true;
            }
            if (node3 == null) {
                return false;
            }
            node2 = node3.prev;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r4 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Thread fullGetFirstQueuedThread() {
        /*
            r3 = this;
            r0 = r3
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.head
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L28
            r0 = r4
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.next
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L28
            r0 = r4
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.prev
            r1 = r3
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r1 = r1.head
            if (r0 != r1) goto L28
            r0 = r4
            java.lang.Thread r0 = r0.thread
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r5
            if (r0 != 0) goto L4e
        L28:
            r0 = r3
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.head
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L52
            r0 = r4
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.next
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L52
            r0 = r4
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.prev
            r1 = r3
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r1 = r1.head
            if (r0 != r1) goto L52
            r0 = r4
            java.lang.Thread r0 = r0.thread
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L52
        L4e:
            r0 = r4
            r6 = r0
        L50:
            r0 = r6
            return r0
        L52:
            r0 = r3
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.tail
            r5 = r0
            r0 = 0
            r4 = r0
        L59:
            r0 = r4
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L50
            r0 = r4
            r6 = r0
            r0 = r5
            r1 = r3
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r1 = r1.head
            if (r0 == r1) goto L50
            r0 = r5
            java.lang.Thread r0 = r0.thread
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L74
            r0 = r6
            r4 = r0
        L74:
            r0 = r5
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.prev
            r5 = r0
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.AbstractQueuedLongSynchronizer.fullGetFirstQueuedThread():java.lang.Thread");
    }

    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        return Thread.interrupted();
    }

    static void selfInterrupt() {
        Thread.currentThread().interrupt();
    }

    private void setHead(Node node) {
        this.head = node;
        node.thread = null;
        node.prev = null;
    }

    private void setHeadAndPropagate(Node node, long j) {
        Node node2 = this.head;
        setHead(node);
        if (j > 0 || node2 == null || node2.waitStatus < 0) {
            Node node3 = node.next;
            if (node3 == null || node3.isShared()) {
                doReleaseShared();
            }
        }
    }

    private static boolean shouldParkAfterFailedAcquire(Node node, Node node2) {
        Node node3;
        int i = node.waitStatus;
        if (i == -1) {
            return true;
        }
        if (i <= 0) {
            compareAndSetWaitStatus(node, i, -1);
            return false;
        }
        do {
            node3 = node.prev;
            node2.prev = node3;
            node = node3;
        } while (node3.waitStatus > 0);
        node3.next = node2;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (r0.waitStatus > 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void unparkSuccessor(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.Node r5) {
        /*
            r4 = this;
            r0 = r5
            int r0 = r0.waitStatus
            r6 = r0
            r0 = r6
            if (r0 >= 0) goto L10
            r0 = r5
            r1 = r6
            r2 = 0
            boolean r0 = compareAndSetWaitStatus(r0, r1, r2)
        L10:
            r0 = r5
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.next
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L23
            r0 = r7
            r9 = r0
            r0 = r7
            int r0 = r0.waitStatus
            if (r0 <= 0) goto L4e
        L23:
            r0 = 0
            r8 = r0
            r0 = r4
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.tail
            r7 = r0
        L2b:
            r0 = r8
            r9 = r0
            r0 = r7
            if (r0 == 0) goto L4e
            r0 = r8
            r9 = r0
            r0 = r7
            r1 = r5
            if (r0 == r1) goto L4e
            r0 = r7
            int r0 = r0.waitStatus
            if (r0 > 0) goto L46
            r0 = r7
            r8 = r0
        L46:
            r0 = r7
            java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node r0 = r0.prev
            r7 = r0
            goto L2b
        L4e:
            r0 = r9
            if (r0 == 0) goto L5b
            r0 = r9
            java.lang.Thread r0 = r0.thread
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.AbstractQueuedLongSynchronizer.unparkSuccessor(java.util.concurrent.locks.AbstractQueuedLongSynchronizer$Node):void");
    }

    public final void acquire(long j) {
        if (tryAcquire(j) || !acquireQueued(addWaiter(Node.EXCLUSIVE), j)) {
            return;
        }
        selfInterrupt();
    }

    public final void acquireInterruptibly(long j) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (tryAcquire(j)) {
            return;
        }
        doAcquireInterruptibly(j);
    }

    final boolean acquireQueued(Node node, long j) {
        Node predecessor;
        boolean z = false;
        while (true) {
            try {
                predecessor = node.predecessor();
                if (predecessor == this.head && tryAcquire(j)) {
                    break;
                } else if (shouldParkAfterFailedAcquire(predecessor, node) && parkAndCheckInterrupt()) {
                    z = true;
                }
            } catch (Throwable th) {
                if (1 != 0) {
                    cancelAcquire(node);
                }
                throw th;
            }
        }
        setHead(node);
        predecessor.next = null;
        if (0 != 0) {
            cancelAcquire(node);
        }
        return z;
    }

    public final void acquireShared(long j) {
        if (tryAcquireShared(j) < 0) {
            doAcquireShared(j);
        }
    }

    public final void acquireSharedInterruptibly(long j) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (tryAcquireShared(j) < 0) {
            doAcquireSharedInterruptibly(j);
        }
    }

    final boolean apparentlyFirstQueuedIsExclusive() {
        Node node;
        Node node2 = this.head;
        return (node2 == null || (node = node2.next) == null || node.isShared() || node.thread == null) ? false : true;
    }

    protected final boolean compareAndSetState(long j, long j2) {
        return unsafe.compareAndSwapLong(this, stateOffset, j, j2);
    }

    final long fullyRelease(Node node) {
        try {
            long state = getState();
            if (!release(state)) {
                throw new IllegalMonitorStateException();
            }
            if (0 != 0) {
                node.waitStatus = 1;
            }
            return state;
        } catch (Throwable th) {
            if (1 != 0) {
                node.waitStatus = 1;
            }
            throw th;
        }
    }

    public final Collection<Thread> getExclusiveQueuedThreads() {
        Thread thread;
        ArrayList arrayList = new ArrayList();
        Node node = this.tail;
        while (true) {
            Node node2 = node;
            if (node2 == null) {
                return arrayList;
            }
            if (!node2.isShared() && (thread = node2.thread) != null) {
                arrayList.add(thread);
            }
            node = node2.prev;
        }
    }

    public final Thread getFirstQueuedThread() {
        if (this.head == this.tail) {
            return null;
        }
        return fullGetFirstQueuedThread();
    }

    public final int getQueueLength() {
        int i = 0;
        Node node = this.tail;
        while (node != null) {
            int i2 = i;
            if (node.thread != null) {
                i2 = i + 1;
            }
            node = node.prev;
            i = i2;
        }
        return i;
    }

    public final Collection<Thread> getQueuedThreads() {
        ArrayList arrayList = new ArrayList();
        Node node = this.tail;
        while (true) {
            Node node2 = node;
            if (node2 == null) {
                return arrayList;
            }
            Thread thread = node2.thread;
            if (thread != null) {
                arrayList.add(thread);
            }
            node = node2.prev;
        }
    }

    public final Collection<Thread> getSharedQueuedThreads() {
        Thread thread;
        ArrayList arrayList = new ArrayList();
        Node node = this.tail;
        while (true) {
            Node node2 = node;
            if (node2 == null) {
                return arrayList;
            }
            if (node2.isShared() && (thread = node2.thread) != null) {
                arrayList.add(thread);
            }
            node = node2.prev;
        }
    }

    protected final long getState() {
        return this.state;
    }

    public final int getWaitQueueLength(ConditionObject conditionObject) {
        if (owns(conditionObject)) {
            return conditionObject.getWaitQueueLength();
        }
        throw new IllegalArgumentException("Not owner");
    }

    public final Collection<Thread> getWaitingThreads(ConditionObject conditionObject) {
        if (owns(conditionObject)) {
            return conditionObject.getWaitingThreads();
        }
        throw new IllegalArgumentException("Not owner");
    }

    public final boolean hasContended() {
        return this.head != null;
    }

    public final boolean hasQueuedPredecessors() {
        Node node = this.tail;
        Node node2 = this.head;
        if (node2 != node) {
            Node node3 = node2.next;
            return node3 == null || node3.thread != Thread.currentThread();
        }
        return false;
    }

    public final boolean hasQueuedThreads() {
        return this.head != this.tail;
    }

    public final boolean hasWaiters(ConditionObject conditionObject) {
        if (owns(conditionObject)) {
            return conditionObject.hasWaiters();
        }
        throw new IllegalArgumentException("Not owner");
    }

    protected boolean isHeldExclusively() {
        throw new UnsupportedOperationException();
    }

    final boolean isOnSyncQueue(Node node) {
        if (node.waitStatus == -2 || node.prev == null) {
            return false;
        }
        if (node.next != null) {
            return true;
        }
        return findNodeFromTail(node);
    }

    public final boolean isQueued(Thread thread) {
        if (thread == null) {
            throw new NullPointerException();
        }
        Node node = this.tail;
        while (true) {
            Node node2 = node;
            if (node2 == null) {
                return false;
            }
            if (node2.thread == thread) {
                return true;
            }
            node = node2.prev;
        }
    }

    public final boolean owns(ConditionObject conditionObject) {
        return conditionObject.isOwnedBy(this);
    }

    public final boolean release(long j) {
        if (tryRelease(j)) {
            Node node = this.head;
            if (node == null || node.waitStatus == 0) {
                return true;
            }
            unparkSuccessor(node);
            return true;
        }
        return false;
    }

    public final boolean releaseShared(long j) {
        if (tryReleaseShared(j)) {
            doReleaseShared();
            return true;
        }
        return false;
    }

    protected final void setState(long j) {
        this.state = j;
    }

    public String toString() {
        return super.toString() + "[State = " + getState() + ", " + (hasQueuedThreads() ? "non" : "") + "empty queue]";
    }

    final boolean transferAfterCancelledWait(Node node) {
        boolean z;
        if (!compareAndSetWaitStatus(node, -2, 0)) {
            while (true) {
                z = false;
                if (isOnSyncQueue(node)) {
                    break;
                }
                Thread.yield();
            }
        } else {
            enq(node);
            z = true;
        }
        return z;
    }

    final boolean transferForSignal(Node node) {
        if (compareAndSetWaitStatus(node, -2, 0)) {
            Node enq = enq(node);
            int i = enq.waitStatus;
            if (i > 0 || !compareAndSetWaitStatus(enq, i, -1)) {
                LockSupport.unpark(node.thread);
                return true;
            }
            return true;
        }
        return false;
    }

    protected boolean tryAcquire(long j) {
        throw new UnsupportedOperationException();
    }

    public final boolean tryAcquireNanos(long j, long j2) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return tryAcquire(j) || doAcquireNanos(j, j2);
    }

    protected long tryAcquireShared(long j) {
        throw new UnsupportedOperationException();
    }

    public final boolean tryAcquireSharedNanos(long j, long j2) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return tryAcquireShared(j) >= 0 || doAcquireSharedNanos(j, j2);
    }

    protected boolean tryRelease(long j) {
        throw new UnsupportedOperationException();
    }

    protected boolean tryReleaseShared(long j) {
        throw new UnsupportedOperationException();
    }
}
