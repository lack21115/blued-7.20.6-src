package java.util.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Phaser.class */
public class Phaser {
    private static final long COUNTS_MASK = 4294967295L;
    private static final int EMPTY = 1;
    private static final int MAX_PARTIES = 65535;
    private static final int MAX_PHASE = Integer.MAX_VALUE;
    private static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final int ONE_ARRIVAL = 1;
    private static final int ONE_DEREGISTER = 65537;
    private static final int ONE_PARTY = 65536;
    private static final long PARTIES_MASK = 4294901760L;
    private static final int PARTIES_SHIFT = 16;
    private static final int PHASE_SHIFT = 32;
    static final int SPINS_PER_ARRIVAL;
    private static final long TERMINATION_BIT = Long.MIN_VALUE;
    private static final int UNARRIVED_MASK = 65535;
    private static final Unsafe UNSAFE;
    private static final long stateOffset;
    private final AtomicReference<QNode> evenQ;
    private final AtomicReference<QNode> oddQ;
    private final Phaser parent;
    private final Phaser root;
    private volatile long state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Phaser$QNode.class */
    public static final class QNode implements ForkJoinPool.ManagedBlocker {
        final long deadline;
        final boolean interruptible;
        long nanos;
        QNode next;
        final int phase;
        final Phaser phaser;
        volatile Thread thread;
        final boolean timed;
        boolean wasInterrupted;

        QNode(Phaser phaser, int i, boolean z, boolean z2, long j) {
            this.phaser = phaser;
            this.phase = i;
            this.interruptible = z;
            this.nanos = j;
            this.timed = z2;
            this.deadline = z2 ? System.nanoTime() + j : 0L;
            this.thread = Thread.currentThread();
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public boolean block() {
            if (isReleasable()) {
                return true;
            }
            if (!this.timed) {
                LockSupport.park(this);
            } else if (this.nanos > 0) {
                LockSupport.parkNanos(this, this.nanos);
            }
            return isReleasable();
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public boolean isReleasable() {
            if (this.thread == null) {
                return true;
            }
            if (this.phaser.getPhase() != this.phase) {
                this.thread = null;
                return true;
            }
            if (Thread.interrupted()) {
                this.wasInterrupted = true;
            }
            if (this.wasInterrupted && this.interruptible) {
                this.thread = null;
                return true;
            } else if (this.timed) {
                if (this.nanos > 0) {
                    this.nanos = this.deadline - System.nanoTime();
                }
                if (this.nanos <= 0) {
                    this.thread = null;
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }
    }

    static {
        SPINS_PER_ARRIVAL = NCPU < 2 ? 1 : 256;
        try {
            UNSAFE = Unsafe.getUnsafe();
            stateOffset = UNSAFE.objectFieldOffset(Phaser.class.getDeclaredField("state"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public Phaser() {
        this(null, 0);
    }

    public Phaser(int i) {
        this(null, i);
    }

    public Phaser(Phaser phaser) {
        this(phaser, 0);
    }

    public Phaser(Phaser phaser, int i) {
        if ((i >>> 16) != 0) {
            throw new IllegalArgumentException("Illegal number of parties");
        }
        int i2 = 0;
        this.parent = phaser;
        if (phaser != null) {
            Phaser phaser2 = phaser.root;
            this.root = phaser2;
            this.evenQ = phaser2.evenQ;
            this.oddQ = phaser2.oddQ;
            if (i != 0) {
                i2 = phaser.doRegister(1);
            }
        } else {
            this.root = this;
            this.evenQ = new AtomicReference<>();
            this.oddQ = new AtomicReference<>();
        }
        this.state = i == 0 ? 1L : (i2 << 32) | (i << 16) | i;
    }

    private int abortWait(int i) {
        int i2;
        Thread thread;
        AtomicReference<QNode> atomicReference = (i & 1) == 0 ? this.evenQ : this.oddQ;
        while (true) {
            QNode qNode = atomicReference.get();
            i2 = (int) (this.root.state >>> 32);
            if (qNode == null || ((thread = qNode.thread) != null && qNode.phase == i2)) {
                break;
            } else if (atomicReference.compareAndSet(qNode, qNode.next) && thread != null) {
                qNode.thread = null;
                LockSupport.unpark(thread);
            }
        }
        return i2;
    }

    private static int arrivedOf(long j) {
        int i = (int) j;
        if (i == 1) {
            return 0;
        }
        return (i >>> 16) - (65535 & i);
    }

    private String badArrive(long j) {
        return "Attempted arrival of unregistered party for " + stateToString(j);
    }

    private String badRegister(long j) {
        return "Attempt to register more than 65535 parties for " + stateToString(j);
    }

    private int doArrive(int i) {
        long reconcileState;
        int i2;
        int i3;
        long j;
        Phaser phaser = this.root;
        do {
            reconcileState = phaser == this ? this.state : reconcileState();
            i2 = (int) (reconcileState >>> 32);
            if (i2 < 0) {
                return i2;
            }
            int i4 = (int) reconcileState;
            i3 = i4 == 1 ? 0 : i4 & 65535;
            if (i3 <= 0) {
                throw new IllegalStateException(badArrive(reconcileState));
            }
            j = reconcileState - i;
        } while (!UNSAFE.compareAndSwapLong(this, stateOffset, reconcileState, j));
        int i5 = i2;
        if (i3 == 1) {
            long j2 = j & PARTIES_MASK;
            int i6 = ((int) j2) >>> 16;
            if (phaser == this) {
                UNSAFE.compareAndSwapLong(this, stateOffset, j, (onAdvance(i2, i6) ? j2 | Long.MIN_VALUE : i6 == 0 ? j2 | 1 : j2 | i6) | (((i2 + 1) & Integer.MAX_VALUE) << 32));
                releaseWaiters(i2);
                i5 = i2;
            } else if (i6 == 0) {
                i5 = this.parent.doArrive(ONE_DEREGISTER);
                UNSAFE.compareAndSwapLong(this, stateOffset, j, j | 1);
            } else {
                i5 = this.parent.doArrive(1);
            }
        }
        return i5;
    }

    private int doRegister(int i) {
        long j = (i << 16) | i;
        Phaser phaser = this.parent;
        while (true) {
            long reconcileState = phaser == null ? this.state : reconcileState();
            int i2 = (int) reconcileState;
            if (i > 65535 - (i2 >>> 16)) {
                throw new IllegalStateException(badRegister(reconcileState));
            }
            int i3 = (int) (reconcileState >>> 32);
            if (i3 < 0) {
                return i3;
            }
            if (i2 != 1) {
                if (phaser == null || reconcileState() == reconcileState) {
                    if ((i2 & 65535) == 0) {
                        this.root.internalAwaitAdvance(i3, null);
                    } else if (UNSAFE.compareAndSwapLong(this, stateOffset, reconcileState, reconcileState + j)) {
                        return i3;
                    }
                }
            } else if (phaser == null) {
                if (UNSAFE.compareAndSwapLong(this, stateOffset, reconcileState, (i3 << 32) | j)) {
                    return i3;
                }
            } else {
                synchronized (this) {
                    if (this.state == reconcileState) {
                        int doRegister = phaser.doRegister(1);
                        int i4 = doRegister;
                        if (doRegister < 0) {
                            return doRegister;
                        }
                        while (!UNSAFE.compareAndSwapLong(this, stateOffset, reconcileState, (i4 << 32) | j)) {
                            reconcileState = this.state;
                            i4 = (int) (this.root.state >>> 32);
                        }
                        return i4;
                    }
                }
            }
        }
    }

    private int internalAwaitAdvance(int i, QNode qNode) {
        int i2;
        releaseWaiters(i - 1);
        boolean z = false;
        int i3 = 0;
        int i4 = SPINS_PER_ARRIVAL;
        while (true) {
            long j = this.state;
            i2 = (int) (j >>> 32);
            if (i2 != i) {
                break;
            } else if (qNode == null) {
                int i5 = ((int) j) & 65535;
                int i6 = i3;
                int i7 = i4;
                if (i5 != i3) {
                    i6 = i5;
                    i7 = i4;
                    if (i5 < NCPU) {
                        i7 = i4 + SPINS_PER_ARRIVAL;
                        i6 = i5;
                    }
                }
                boolean interrupted = Thread.interrupted();
                i4 = i7;
                if (!interrupted) {
                    int i8 = i7 - 1;
                    i3 = i6;
                    i4 = i8;
                    if (i8 < 0) {
                        i4 = i8;
                    }
                }
                qNode = new QNode(this, i, false, false, 0L);
                qNode.wasInterrupted = interrupted;
                i3 = i6;
            } else if (qNode.isReleasable()) {
                break;
            } else if (z) {
                try {
                    ForkJoinPool.managedBlock(qNode);
                } catch (InterruptedException e) {
                    qNode.wasInterrupted = true;
                }
            } else {
                AtomicReference<QNode> atomicReference = (i & 1) == 0 ? this.evenQ : this.oddQ;
                QNode qNode2 = atomicReference.get();
                qNode.next = qNode2;
                if (qNode2 == null || qNode2.phase == i) {
                    if (((int) (this.state >>> 32)) == i) {
                        z = atomicReference.compareAndSet(qNode2, qNode);
                    }
                }
            }
        }
        int i9 = i2;
        if (qNode != null) {
            if (qNode.thread != null) {
                qNode.thread = null;
            }
            if (qNode.wasInterrupted && !qNode.interruptible) {
                Thread.currentThread().interrupt();
            }
            i9 = i2;
            if (i2 == i) {
                int i10 = (int) (this.state >>> 32);
                i9 = i10;
                if (i10 == i) {
                    return abortWait(i);
                }
            }
        }
        releaseWaiters(i);
        return i9;
    }

    private static int partiesOf(long j) {
        return ((int) j) >>> 16;
    }

    private static int phaseOf(long j) {
        return (int) (j >>> 32);
    }

    private AtomicReference<QNode> queueFor(int i) {
        return (i & 1) == 0 ? this.evenQ : this.oddQ;
    }

    private long reconcileState() {
        long j;
        Phaser phaser = this.root;
        long j2 = this.state;
        long j3 = j2;
        if (phaser != this) {
            while (true) {
                int i = (int) (phaser.state >>> 32);
                j3 = j2;
                if (i == ((int) (j2 >>> 32))) {
                    break;
                }
                Unsafe unsafe = UNSAFE;
                long j4 = stateOffset;
                long j5 = i;
                if (i < 0) {
                    j = 4294967295L & j2;
                } else {
                    int i2 = ((int) j2) >>> 16;
                    j = i2 == 0 ? 1L : (PARTIES_MASK & j2) | i2;
                }
                j3 = (j5 << 32) | j;
                if (unsafe.compareAndSwapLong(this, j4, j2, j3)) {
                    break;
                }
                j2 = this.state;
            }
        }
        return j3;
    }

    private void releaseWaiters(int i) {
        Thread thread;
        AtomicReference<QNode> atomicReference = (i & 1) == 0 ? this.evenQ : this.oddQ;
        while (true) {
            QNode qNode = atomicReference.get();
            if (qNode == null || qNode.phase == ((int) (this.root.state >>> 32))) {
                return;
            }
            if (atomicReference.compareAndSet(qNode, qNode.next) && (thread = qNode.thread) != null) {
                qNode.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    private String stateToString(long j) {
        return super.toString() + "[phase = " + phaseOf(j) + " parties = " + partiesOf(j) + " arrived = " + arrivedOf(j) + "]";
    }

    private static int unarrivedOf(long j) {
        int i = (int) j;
        if (i == 1) {
            return 0;
        }
        return 65535 & i;
    }

    public int arrive() {
        return doArrive(1);
    }

    public int arriveAndAwaitAdvance() {
        long reconcileState;
        int i;
        int i2;
        long j;
        Phaser phaser = this.root;
        do {
            reconcileState = phaser == this ? this.state : reconcileState();
            i = (int) (reconcileState >>> 32);
            if (i < 0) {
                return i;
            }
            int i3 = (int) reconcileState;
            i2 = i3 == 1 ? 0 : i3 & 65535;
            if (i2 <= 0) {
                throw new IllegalStateException(badArrive(reconcileState));
            }
            j = reconcileState - 1;
        } while (!UNSAFE.compareAndSwapLong(this, stateOffset, reconcileState, j));
        if (i2 > 1) {
            return phaser.internalAwaitAdvance(i, null);
        }
        if (phaser != this) {
            return this.parent.arriveAndAwaitAdvance();
        }
        long j2 = j & PARTIES_MASK;
        int i4 = ((int) j2) >>> 16;
        long j3 = onAdvance(i, i4) ? j2 | Long.MIN_VALUE : i4 == 0 ? j2 | 1 : j2 | i4;
        int i5 = (i + 1) & Integer.MAX_VALUE;
        if (UNSAFE.compareAndSwapLong(this, stateOffset, j, j3 | (i5 << 32))) {
            releaseWaiters(i);
            return i5;
        }
        return (int) (this.state >>> 32);
    }

    public int arriveAndDeregister() {
        return doArrive(ONE_DEREGISTER);
    }

    public int awaitAdvance(int i) {
        Phaser phaser = this.root;
        int reconcileState = (int) ((phaser == this ? this.state : reconcileState()) >>> 32);
        return i < 0 ? i : reconcileState == i ? phaser.internalAwaitAdvance(i, null) : reconcileState;
    }

    public int awaitAdvanceInterruptibly(int i) throws InterruptedException {
        Phaser phaser = this.root;
        int reconcileState = (int) ((phaser == this ? this.state : reconcileState()) >>> 32);
        if (i < 0) {
            return i;
        }
        int i2 = reconcileState;
        if (reconcileState == i) {
            QNode qNode = new QNode(this, i, true, false, 0L);
            i2 = phaser.internalAwaitAdvance(i, qNode);
            if (qNode.wasInterrupted) {
                throw new InterruptedException();
            }
        }
        return i2;
    }

    public int awaitAdvanceInterruptibly(int i, long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        Phaser phaser = this.root;
        int reconcileState = (int) ((phaser == this ? this.state : reconcileState()) >>> 32);
        if (i < 0) {
            return i;
        }
        int i2 = reconcileState;
        if (reconcileState == i) {
            QNode qNode = new QNode(this, i, true, true, nanos);
            int internalAwaitAdvance = phaser.internalAwaitAdvance(i, qNode);
            if (qNode.wasInterrupted) {
                throw new InterruptedException();
            }
            i2 = internalAwaitAdvance;
            if (internalAwaitAdvance == i) {
                throw new TimeoutException();
            }
        }
        return i2;
    }

    public int bulkRegister(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return i == 0 ? getPhase() : doRegister(i);
    }

    public void forceTermination() {
        long j;
        Phaser phaser = this.root;
        do {
            j = phaser.state;
            if (j < 0) {
                return;
            }
        } while (!UNSAFE.compareAndSwapLong(phaser, stateOffset, j, Long.MIN_VALUE | j));
        releaseWaiters(0);
        releaseWaiters(1);
    }

    public int getArrivedParties() {
        return arrivedOf(reconcileState());
    }

    public Phaser getParent() {
        return this.parent;
    }

    public final int getPhase() {
        return (int) (this.root.state >>> 32);
    }

    public int getRegisteredParties() {
        return partiesOf(this.state);
    }

    public Phaser getRoot() {
        return this.root;
    }

    public int getUnarrivedParties() {
        return unarrivedOf(reconcileState());
    }

    public boolean isTerminated() {
        return this.root.state < 0;
    }

    protected boolean onAdvance(int i, int i2) {
        return i2 == 0;
    }

    public int register() {
        return doRegister(1);
    }

    public String toString() {
        return stateToString(reconcileState());
    }
}
