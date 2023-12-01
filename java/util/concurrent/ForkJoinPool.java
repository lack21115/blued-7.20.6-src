package java.util.concurrent;

import java.lang.Thread;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool.class */
public class ForkJoinPool extends AbstractExecutorService {
    private static final int ABASE = 0;
    private static final long AC_MASK = -281474976710656L;
    private static final int AC_SHIFT = 48;
    private static final long AC_UNIT = 281474976710656L;
    private static final int ASHIFT = 0;
    private static final long CTL = 0;
    private static final int EC_SHIFT = 16;
    private static final int EVENMASK = 65534;
    private static final int E_MASK = Integer.MAX_VALUE;
    private static final int E_SEQ = 65536;
    private static final long FAST_IDLE_TIMEOUT = 200000000;
    static final int FIFO_QUEUE = 1;
    private static final long IDLE_TIMEOUT = 2000000000;
    private static final long INDEXSEED = 0;
    private static final int INT_SIGN = Integer.MIN_VALUE;
    static final int LIFO_QUEUE = 0;
    private static final int MAX_CAP = 32767;
    private static final int MAX_HELP = 64;
    private static final long PARKBLOCKER = 0;
    private static final long PLOCK = 0;
    private static final int PL_LOCK = 2;
    private static final int PL_SIGNAL = 1;
    private static final int PL_SPINS = 256;
    private static final long QBASE = 0;
    private static final long QLOCK = 0;
    private static final int SEED_INCREMENT = 1640531527;
    static final int SHARED_QUEUE = -1;
    private static final int SHORT_SIGN = 32768;
    private static final int SHUTDOWN = Integer.MIN_VALUE;
    private static final int SMASK = 65535;
    private static final int SQMASK = 126;
    private static final long STEALCOUNT = 0;
    private static final long STOP_BIT = 2147483648L;
    private static final int ST_SHIFT = 31;
    private static final long TC_MASK = 281470681743360L;
    private static final int TC_SHIFT = 32;
    private static final long TC_UNIT = 4294967296L;
    private static final long TIMEOUT_SLOP = 2000000;
    private static final Unsafe U;
    private static final int UAC_MASK = -65536;
    private static final int UAC_SHIFT = 16;
    private static final int UAC_UNIT = 65536;
    private static final int UTC_MASK = 65535;
    private static final int UTC_SHIFT = 0;
    private static final int UTC_UNIT = 1;
    static final ForkJoinPool common = null;
    static final int commonParallelism = 0;
    public static final ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory = null;
    private static final RuntimePermission modifyThreadPermission = null;
    private static int poolNumberSequence;
    static final ThreadLocal<Submitter> submitters = null;
    volatile long ctl;
    final ForkJoinWorkerThreadFactory factory;
    volatile int indexSeed;
    final short mode;
    volatile long pad00;
    volatile long pad01;
    volatile long pad02;
    volatile long pad03;
    volatile long pad04;
    volatile long pad05;
    volatile long pad06;
    volatile Object pad10;
    volatile Object pad11;
    volatile Object pad12;
    volatile Object pad13;
    volatile Object pad14;
    volatile Object pad15;
    volatile Object pad16;
    volatile Object pad17;
    volatile Object pad18;
    volatile Object pad19;
    volatile Object pad1a;
    volatile Object pad1b;
    final short parallelism;
    volatile int plock;
    volatile long stealCount;
    final Thread.UncaughtExceptionHandler ueh;
    WorkQueue[] workQueues;
    final String workerNamePrefix;

    /* renamed from: java.util.concurrent.ForkJoinPool$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool$1.class */
    static final class AnonymousClass1 implements PrivilegedAction<ForkJoinPool> {
        AnonymousClass1() {
        }

        @Override // java.security.PrivilegedAction
        public ForkJoinPool run() {
            return ForkJoinPool.access$000();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool$DefaultForkJoinWorkerThreadFactory.class */
    static final class DefaultForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        DefaultForkJoinWorkerThreadFactory() {
        }

        @Override // java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory
        public final ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool) {
            return new ForkJoinWorkerThread(forkJoinPool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool$EmptyTask.class */
    public static final class EmptyTask extends ForkJoinTask<Void> {
        private static final long serialVersionUID = -7721805057305804111L;

        EmptyTask() {
            this.status = -268435456;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            return true;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void r2) {
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool$ForkJoinWorkerThreadFactory.class */
    public interface ForkJoinWorkerThreadFactory {
        ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool);
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool$ManagedBlocker.class */
    public interface ManagedBlocker {
        boolean block() throws InterruptedException;

        boolean isReleasable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool$Submitter.class */
    public static final class Submitter {
        int seed;

        Submitter(int i) {
            this.seed = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinPool$WorkQueue.class */
    public static final class WorkQueue {
        private static final int ABASE;
        private static final int ASHIFT;
        static final int INITIAL_QUEUE_CAPACITY = 8192;
        static final int MAXIMUM_QUEUE_CAPACITY = 67108864;
        private static final long QBASE;
        private static final long QLOCK;
        private static final Unsafe U;
        ForkJoinTask<?>[] array;
        volatile ForkJoinTask<?> currentJoin;
        ForkJoinTask<?> currentSteal;
        volatile int eventCount;
        int hint;
        final short mode;
        int nextWait;
        int nsteals;
        final ForkJoinWorkerThread owner;
        volatile long pad00;
        volatile long pad01;
        volatile long pad02;
        volatile long pad03;
        volatile long pad04;
        volatile long pad05;
        volatile long pad06;
        volatile Object pad10;
        volatile Object pad11;
        volatile Object pad12;
        volatile Object pad13;
        volatile Object pad14;
        volatile Object pad15;
        volatile Object pad16;
        volatile Object pad17;
        volatile Object pad18;
        volatile Object pad19;
        volatile Object pad1a;
        volatile Object pad1b;
        volatile Object pad1c;
        volatile Object pad1d;
        volatile Thread parker;
        final ForkJoinPool pool;
        short poolIndex;
        volatile int qlock;
        int top = 4096;
        volatile int base = 4096;

        static {
            try {
                U = Unsafe.getUnsafe();
                QBASE = U.objectFieldOffset(WorkQueue.class.getDeclaredField("base"));
                QLOCK = U.objectFieldOffset(WorkQueue.class.getDeclaredField("qlock"));
                ABASE = U.arrayBaseOffset(ForkJoinTask[].class);
                int arrayIndexScale = U.arrayIndexScale(ForkJoinTask[].class);
                if (((arrayIndexScale - 1) & arrayIndexScale) != 0) {
                    throw new Error("data type scale not a power of two");
                }
                ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        WorkQueue(ForkJoinPool forkJoinPool, ForkJoinWorkerThread forkJoinWorkerThread, int i, int i2) {
            this.pool = forkJoinPool;
            this.owner = forkJoinWorkerThread;
            this.mode = (short) i;
            this.hint = i2;
        }

        final void cancelAll() {
            ForkJoinTask.cancelIgnoringExceptions(this.currentJoin);
            ForkJoinTask.cancelIgnoringExceptions(this.currentSteal);
            while (true) {
                ForkJoinTask<?> poll = poll();
                if (poll == null) {
                    return;
                }
                ForkJoinTask.cancelIgnoringExceptions(poll);
            }
        }

        final boolean externalPopAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i = this.base;
            int i2 = this.top;
            if (i - i2 >= 0 || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            long length = (((forkJoinTaskArr.length - 1) & (i2 - 1)) << ASHIFT) + ABASE;
            Object object = U.getObject(forkJoinTaskArr, length);
            if (object instanceof CountedCompleter) {
                CountedCompleter<?> countedCompleter2 = (CountedCompleter) object;
                CountedCompleter<?> countedCompleter3 = countedCompleter2;
                while (countedCompleter3 != countedCompleter) {
                    CountedCompleter<?> countedCompleter4 = countedCompleter3.completer;
                    countedCompleter3 = countedCompleter4;
                    if (countedCompleter4 == null) {
                        return false;
                    }
                }
                if (U.compareAndSwapInt(this, QLOCK, 0, 1)) {
                    if (this.top != i2 || this.array != forkJoinTaskArr || !U.compareAndSwapObject(forkJoinTaskArr, length, countedCompleter2, null)) {
                        this.qlock = 0;
                        return true;
                    }
                    this.top = i2 - 1;
                    this.qlock = 0;
                    countedCompleter2.doExec();
                    return true;
                }
                return true;
            }
            return false;
        }

        final ForkJoinTask<?>[] growArray() {
            int length;
            int i;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            int length2 = forkJoinTaskArr != null ? forkJoinTaskArr.length << 1 : 8192;
            if (length2 > 67108864) {
                throw new RejectedExecutionException("Queue capacity exceeded");
            }
            ForkJoinTask<?>[] forkJoinTaskArr2 = new ForkJoinTask[length2];
            this.array = forkJoinTaskArr2;
            if (forkJoinTaskArr != null && (length = forkJoinTaskArr.length - 1) >= 0) {
                int i2 = this.top;
                int i3 = this.base;
                if (i2 - i3 > 0) {
                    do {
                        int i4 = ((i3 & length) << ASHIFT) + ABASE;
                        int i5 = ASHIFT;
                        int i6 = ABASE;
                        ForkJoinTask forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, i4);
                        if (forkJoinTask != null && U.compareAndSwapObject(forkJoinTaskArr, i4, forkJoinTask, null)) {
                            U.putObjectVolatile(forkJoinTaskArr2, ((i3 & (length2 - 1)) << i5) + i6, forkJoinTask);
                        }
                        i = i3 + 1;
                        i3 = i;
                    } while (i != i2);
                }
            }
            return forkJoinTaskArr2;
        }

        final boolean internalPopAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i = this.base;
            int i2 = this.top;
            if (i - i2 >= 0 || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            long length = (((forkJoinTaskArr.length - 1) & (i2 - 1)) << ASHIFT) + ABASE;
            Object object = U.getObject(forkJoinTaskArr, length);
            if (object instanceof CountedCompleter) {
                CountedCompleter<?> countedCompleter2 = (CountedCompleter) object;
                CountedCompleter<?> countedCompleter3 = countedCompleter2;
                while (countedCompleter3 != countedCompleter) {
                    CountedCompleter<?> countedCompleter4 = countedCompleter3.completer;
                    countedCompleter3 = countedCompleter4;
                    if (countedCompleter4 == null) {
                        return false;
                    }
                }
                if (U.compareAndSwapObject(forkJoinTaskArr, length, countedCompleter2, null)) {
                    this.top = i2 - 1;
                    countedCompleter2.doExec();
                    return true;
                }
                return true;
            }
            return false;
        }

        final boolean isApparentlyUnblocked() {
            ForkJoinWorkerThread forkJoinWorkerThread;
            Thread.State state;
            return (this.eventCount < 0 || (forkJoinWorkerThread = this.owner) == null || (state = forkJoinWorkerThread.getState()) == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) ? false : true;
        }

        final boolean isEmpty() {
            int length;
            int i = this.base;
            int i2 = this.top;
            int i3 = i - i2;
            if (i3 < 0) {
                if (i3 == -1) {
                    ForkJoinTask<?>[] forkJoinTaskArr = this.array;
                    return forkJoinTaskArr == null || (length = forkJoinTaskArr.length - 1) < 0 || U.getObject(forkJoinTaskArr, ((long) (((i2 - 1) & length) << ASHIFT)) + ((long) ABASE)) == null;
                }
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ForkJoinTask<?> nextLocalTask() {
            return this.mode == 0 ? pop() : poll();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ForkJoinTask<?> peek() {
            int length;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (length = forkJoinTaskArr.length - 1) < 0) {
                return null;
            }
            return (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, (((this.mode == 0 ? this.top - 1 : this.base) & length) << ASHIFT) + ABASE);
        }

        final ForkJoinTask<?> poll() {
            ForkJoinTask<?>[] forkJoinTaskArr;
            while (true) {
                int i = this.base;
                if (i - this.top >= 0 || (forkJoinTaskArr = this.array) == null) {
                    return null;
                }
                int length = (((forkJoinTaskArr.length - 1) & i) << ASHIFT) + ABASE;
                ForkJoinTask<?> forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, length);
                if (forkJoinTask != null) {
                    if (U.compareAndSwapObject(forkJoinTaskArr, length, forkJoinTask, null)) {
                        U.putOrderedInt(this, QBASE, i + 1);
                        return forkJoinTask;
                    }
                } else if (this.base != i) {
                    continue;
                } else if (i + 1 == this.top) {
                    return null;
                } else {
                    Thread.yield();
                }
            }
        }

        final void pollAndExecAll() {
            while (true) {
                ForkJoinTask<?> poll = poll();
                if (poll == null) {
                    return;
                }
                poll.doExec();
            }
        }

        final boolean pollAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i = this.base;
            if (i - this.top >= 0 || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            long length = (((forkJoinTaskArr.length - 1) & i) << ASHIFT) + ABASE;
            Object objectVolatile = U.getObjectVolatile(forkJoinTaskArr, length);
            if (objectVolatile == null) {
                return true;
            }
            if (objectVolatile instanceof CountedCompleter) {
                CountedCompleter<?> countedCompleter2 = (CountedCompleter) objectVolatile;
                CountedCompleter<?> countedCompleter3 = countedCompleter2;
                while (countedCompleter3 != countedCompleter) {
                    CountedCompleter<?> countedCompleter4 = countedCompleter3.completer;
                    countedCompleter3 = countedCompleter4;
                    if (countedCompleter4 == null) {
                        return false;
                    }
                }
                if (this.base == i && U.compareAndSwapObject(forkJoinTaskArr, length, countedCompleter2, null)) {
                    U.putOrderedInt(this, QBASE, i + 1);
                    countedCompleter2.doExec();
                    return true;
                }
                return true;
            }
            return false;
        }

        final ForkJoinTask<?> pollAt(int i) {
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr != null) {
                int length = (((forkJoinTaskArr.length - 1) & i) << ASHIFT) + ABASE;
                ForkJoinTask<?> forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, length);
                if (forkJoinTask != null && this.base == i && U.compareAndSwapObject(forkJoinTaskArr, length, forkJoinTask, null)) {
                    U.putOrderedInt(this, QBASE, i + 1);
                    return forkJoinTask;
                }
                return null;
            }
            return null;
        }

        final ForkJoinTask<?> pop() {
            int length;
            int i;
            long j;
            ForkJoinTask<?> forkJoinTask;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (length = forkJoinTaskArr.length - 1) < 0) {
                return null;
            }
            do {
                i = this.top - 1;
                if (i - this.base < 0) {
                    return null;
                }
                j = ((length & i) << ASHIFT) + ABASE;
                forkJoinTask = (ForkJoinTask) U.getObject(forkJoinTaskArr, j);
                if (forkJoinTask == null) {
                    return null;
                }
            } while (!U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, null));
            this.top = i;
            return forkJoinTask;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void push(ForkJoinTask<?> forkJoinTask) {
            int i = this.top;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr != null) {
                int length = forkJoinTaskArr.length - 1;
                U.putOrderedObject(forkJoinTaskArr, ((length & i) << ASHIFT) + ABASE, forkJoinTask);
                int i2 = i + 1;
                this.top = i2;
                int i3 = i2 - this.base;
                if (i3 <= 2) {
                    ForkJoinPool forkJoinPool = this.pool;
                    forkJoinPool.signalWork(forkJoinPool.workQueues, this);
                } else if (i3 >= length) {
                    growArray();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int queueSize() {
            int i = this.base - this.top;
            if (i >= 0) {
                return 0;
            }
            return -i;
        }

        final void runTask(ForkJoinTask<?> forkJoinTask) {
            this.currentSteal = forkJoinTask;
            if (forkJoinTask == null) {
                return;
            }
            forkJoinTask.doExec();
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            short s = this.mode;
            this.nsteals++;
            this.currentSteal = null;
            if (s != 0) {
                pollAndExecAll();
            } else if (forkJoinTaskArr == null) {
            } else {
                int length = forkJoinTaskArr.length;
                while (true) {
                    int i = this.top - 1;
                    if (i - this.base < 0) {
                        return;
                    }
                    long j = (((length - 1) & i) << ASHIFT) + ABASE;
                    ForkJoinTask forkJoinTask2 = (ForkJoinTask) U.getObject(forkJoinTaskArr, j);
                    if (forkJoinTask2 == null) {
                        return;
                    }
                    if (U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask2, null)) {
                        this.top = i;
                        forkJoinTask2.doExec();
                    }
                }
            }
        }

        final boolean tryRemoveAndExec(ForkJoinTask<?> forkJoinTask) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int length;
            boolean z;
            boolean z2;
            boolean z3;
            if (forkJoinTask == null || (forkJoinTaskArr = this.array) == null || (length = forkJoinTaskArr.length - 1) < 0) {
                return false;
            }
            int i = this.top;
            int i2 = this.base;
            int i3 = i - i2;
            if (i3 > 0) {
                boolean z4 = true;
                while (true) {
                    i--;
                    long j = ((i & length) << ASHIFT) + ABASE;
                    ForkJoinTask<?> forkJoinTask2 = (ForkJoinTask) U.getObject(forkJoinTaskArr, j);
                    if (forkJoinTask2 == null) {
                        z = true;
                        z2 = false;
                        break;
                    } else if (forkJoinTask2 != forkJoinTask) {
                        if (forkJoinTask2.status >= 0) {
                            z3 = false;
                        } else {
                            z3 = z4;
                            if (i + 1 == this.top) {
                                z2 = false;
                                z = true;
                                if (U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask2, null)) {
                                    this.top = i;
                                    z2 = false;
                                    z = true;
                                }
                            }
                        }
                        int i4 = i3 - 1;
                        z4 = z3;
                        i3 = i4;
                        if (i4 == 0) {
                            z2 = false;
                            z = true;
                            if (!z3) {
                                z2 = false;
                                z = true;
                                if (this.base == i2) {
                                    z = false;
                                    z2 = false;
                                }
                            }
                        }
                    } else if (i + 1 == this.top) {
                        z2 = false;
                        z = true;
                        if (U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, null)) {
                            this.top = i;
                            z2 = true;
                            z = true;
                        }
                    } else {
                        z2 = false;
                        z = true;
                        if (this.base == i2) {
                            z2 = U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, new EmptyTask());
                            z = true;
                        }
                    }
                }
                if (z2) {
                    forkJoinTask.doExec();
                }
                return z;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean tryUnpush(ForkJoinTask<?> forkJoinTask) {
            int i;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (i = this.top) == this.base) {
                return false;
            }
            Unsafe unsafe = U;
            int length = forkJoinTaskArr.length;
            int i2 = i - 1;
            if (unsafe.compareAndSwapObject(forkJoinTaskArr, (((length - 1) & i2) << ASHIFT) + ABASE, forkJoinTask, null)) {
                this.top = i2;
                return true;
            }
            return false;
        }
    }

    static {
        try {
            U = Unsafe.getUnsafe();
            Unsafe unsafe = U;
            throw new VerifyError("bad dex opcode");
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ForkJoinPool() {
        this(Math.min(32767, Runtime.getRuntime().availableProcessors()), defaultForkJoinWorkerThreadFactory, null, false);
    }

    public ForkJoinPool(int i) {
        this(i, defaultForkJoinWorkerThreadFactory, null, false);
    }

    private ForkJoinPool(int i, ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, int i2, String str) {
        this.workerNamePrefix = str;
        this.factory = forkJoinWorkerThreadFactory;
        this.ueh = uncaughtExceptionHandler;
        this.mode = (short) i2;
        this.parallelism = (short) i;
        long j = -i;
        this.ctl = ((j << 48) & AC_MASK) | ((j << 32) & TC_MASK);
    }

    public ForkJoinPool(int i, ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        this(checkParallelism(i), checkFactory(forkJoinWorkerThreadFactory), uncaughtExceptionHandler, z ? 1 : 0, "ForkJoinPool-" + nextPoolId() + "-worker-");
        checkPermission();
    }

    static /* synthetic */ ForkJoinPool access$000() {
        return makeCommonPool();
    }

    private int acquirePlock() {
        int i = 256;
        while (true) {
            int i2 = this.plock;
            if ((i2 & 2) == 0) {
                int i3 = i2 + 2;
                if (U.compareAndSwapInt(this, PLOCK, i2, i3)) {
                    return i3;
                }
            }
            if (i >= 0) {
                if (ThreadLocalRandom.current().nextInt() >= 0) {
                    i--;
                }
            } else if (U.compareAndSwapInt(this, PLOCK, i2, i2 | 1)) {
                synchronized (this) {
                    if ((this.plock & 1) != 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            try {
                                Thread.currentThread().interrupt();
                            } catch (SecurityException e2) {
                            }
                        }
                    } else {
                        notifyAll();
                    }
                }
            } else {
                continue;
            }
        }
    }

    private final int awaitWork(WorkQueue workQueue, long j, int i) {
        int i2;
        long j2;
        long j3;
        int i3;
        Unsafe unsafe;
        long j4;
        long j5;
        int i4 = workQueue.qlock;
        int i5 = i4;
        if (i4 >= 0) {
            i5 = i4;
            if (workQueue.eventCount == i) {
                i5 = i4;
                if (this.ctl == j) {
                    i5 = i4;
                    if (!Thread.interrupted()) {
                        int i6 = (int) j;
                        int i7 = (((int) (j >>> 32)) >> 16) + this.parallelism;
                        if (i6 < 0 || (i7 <= 0 && tryTerminate(false, false))) {
                            i5 = -1;
                            workQueue.qlock = -1;
                        } else {
                            int i8 = workQueue.nsteals;
                            if (i8 != 0) {
                                workQueue.nsteals = 0;
                                do {
                                    unsafe = U;
                                    j4 = STEALCOUNT;
                                    j5 = this.stealCount;
                                } while (!unsafe.compareAndSwapLong(this, j4, j5, i8 + j5));
                                return i4;
                            }
                            long j6 = (i7 > 0 || i != (Integer.MIN_VALUE | i6)) ? 0L : (workQueue.nextWait & Integer.MAX_VALUE) | ((65536 + i2) << 32);
                            if (j6 != 0) {
                                long j7 = (-((short) (j >>> 32))) < 0 ? 200000000L : (i3 + 1) * IDLE_TIMEOUT;
                                j3 = j7;
                                j2 = (System.nanoTime() + j7) - TIMEOUT_SLOP;
                            } else {
                                j2 = 0;
                                j3 = 0;
                            }
                            i5 = i4;
                            if (workQueue.eventCount == i) {
                                i5 = i4;
                                if (this.ctl == j) {
                                    Thread currentThread = Thread.currentThread();
                                    U.putObject(currentThread, PARKBLOCKER, this);
                                    workQueue.parker = currentThread;
                                    if (workQueue.eventCount == i && this.ctl == j) {
                                        U.park(false, j3);
                                    }
                                    workQueue.parker = null;
                                    U.putObject(currentThread, PARKBLOCKER, null);
                                    i5 = i4;
                                    if (j3 != 0) {
                                        i5 = i4;
                                        if (this.ctl == j) {
                                            i5 = i4;
                                            if (j2 - System.nanoTime() <= 0) {
                                                i5 = i4;
                                                if (U.compareAndSwapLong(this, CTL, j, j6)) {
                                                    workQueue.qlock = -1;
                                                    return -1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i5;
    }

    private static ForkJoinWorkerThreadFactory checkFactory(ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory) {
        if (forkJoinWorkerThreadFactory == null) {
            throw new NullPointerException();
        }
        return forkJoinWorkerThreadFactory;
    }

    private static int checkParallelism(int i) {
        if (i <= 0 || i > 32767) {
            throw new IllegalArgumentException();
        }
        return i;
    }

    private static void checkPermission() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(modifyThreadPermission);
        }
    }

    public static ForkJoinPool commonPool() {
        return common;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WorkQueue commonSubmitterQueue() {
        ForkJoinPool forkJoinPool;
        WorkQueue[] workQueueArr;
        int length;
        Submitter submitter = submitters.get();
        if (submitter == null || (forkJoinPool = common) == null || (workQueueArr = forkJoinPool.workQueues) == null || (length = workQueueArr.length - 1) < 0) {
            return null;
        }
        return workQueueArr[submitter.seed & length & 126];
    }

    private WorkQueue findNonEmptyStealQueue() {
        int i;
        int length;
        int nextInt = ThreadLocalRandom.current().nextInt();
        do {
            i = this.plock;
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null && (length = workQueueArr.length - 1) >= 0) {
                int i2 = (length + 1) << 2;
                while (true) {
                    int i3 = i2;
                    if (i3 < 0) {
                        break;
                    }
                    WorkQueue workQueue = workQueueArr[(((nextInt - i3) << 1) | 1) & length];
                    if (workQueue != null && workQueue.base - workQueue.top < 0) {
                        return workQueue;
                    }
                    i2 = i3 - 1;
                }
            }
        } while (this.plock != i);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0114, code lost:
        if (java.util.concurrent.ForkJoinPool.U.compareAndSwapInt(r7, java.util.concurrent.ForkJoinPool.PLOCK, r0, r11) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c7, code lost:
        if (r0.length <= ((r0 + 1) - r0.base)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01d3, code lost:
        if (r16 != null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01d6, code lost:
        java.util.concurrent.ForkJoinPool.U.putOrderedObject(r16, (((r16.length - 1) & r0) << java.util.concurrent.ForkJoinPool.ASHIFT) + java.util.concurrent.ForkJoinPool.ABASE, r8);
        r0.top = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0202, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0203, code lost:
        r0.qlock = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020a, code lost:
        if (r9 == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x020d, code lost:
        signalWork(r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0215, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x026e, code lost:
        if (java.util.concurrent.ForkJoinPool.U.compareAndSwapInt(r7, java.util.concurrent.ForkJoinPool.PLOCK, r0, r11) == false) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fullExternalPush(java.util.concurrent.ForkJoinTask<?> r8) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.fullExternalPush(java.util.concurrent.ForkJoinTask):void");
    }

    public static int getCommonPoolParallelism() {
        return commonParallelism;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSurplusQueuedTaskCount() {
        int i;
        int i2 = 0;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            ForkJoinPool forkJoinPool = forkJoinWorkerThread.pool;
            short s = forkJoinPool.parallelism;
            WorkQueue workQueue = forkJoinWorkerThread.workQueue;
            int i3 = workQueue.top;
            int i4 = workQueue.base;
            int i5 = ((int) (forkJoinPool.ctl >> 48)) + s;
            int i6 = s >>> 1;
            if (i5 > i6) {
                i = 0;
            } else {
                int i7 = i6 >>> 1;
                if (i5 > i7) {
                    i = 1;
                } else {
                    int i8 = i7 >>> 1;
                    i = i5 > i8 ? 2 : i5 > (i8 >>> 1) ? 4 : 8;
                }
            }
            i2 = (i3 - i4) - i;
        }
        return i2;
    }

    private int helpComplete(WorkQueue workQueue, CountedCompleter<?> countedCompleter) {
        long j;
        int i;
        WorkQueue[] workQueueArr = this.workQueues;
        int i2 = 0;
        if (workQueueArr != null) {
            int length = workQueueArr.length - 1;
            i2 = 0;
            if (length >= 0) {
                i2 = 0;
                if (workQueue != null) {
                    i2 = 0;
                    if (countedCompleter != null) {
                        short s = workQueue.poolIndex;
                        int i3 = length + length + 1;
                        long j2 = 0;
                        int i4 = i3;
                        while (true) {
                            int i5 = i4;
                            i2 = countedCompleter.status;
                            if (i2 < 0) {
                                break;
                            }
                            if (workQueue.internalPopAndExecCC(countedCompleter)) {
                                i = i3;
                                j = j2;
                            } else {
                                int i6 = countedCompleter.status;
                                i2 = i6;
                                if (i6 < 0) {
                                    break;
                                }
                                WorkQueue workQueue2 = workQueueArr[s & length];
                                if (workQueue2 == null || !workQueue2.pollAndExecCC(countedCompleter)) {
                                    int i7 = i5 - 1;
                                    j = j2;
                                    i = i7;
                                    if (i7 < 0) {
                                        j = this.ctl;
                                        i2 = i6;
                                        if (j2 == j) {
                                            break;
                                        }
                                        i = i3;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    i = i3;
                                    j = j2;
                                }
                            }
                            s += 2;
                            j2 = j;
                            i4 = i;
                        }
                    }
                }
            }
        }
        return i2;
    }

    private final void helpRelease(long j, WorkQueue[] workQueueArr, WorkQueue workQueue, WorkQueue workQueue2, int i) {
        int i2;
        int i3;
        WorkQueue workQueue3;
        if (workQueue == null || workQueue.eventCount >= 0 || (i2 = (int) j) <= 0 || workQueueArr == null || workQueueArr.length <= (i3 = i2 & 65535) || (workQueue3 = workQueueArr[i3]) == null || this.ctl != j) {
            return;
        }
        long j2 = workQueue3.nextWait & Integer.MAX_VALUE;
        long j3 = ((int) (j >>> 32)) + 65536;
        if (workQueue2 != null && workQueue2.base == i && workQueue.eventCount < 0 && workQueue3.eventCount == (Integer.MIN_VALUE | i2) && U.compareAndSwapLong(this, CTL, j, j2 | (j3 << 32))) {
            workQueue3.eventCount = (65536 + i2) & Integer.MAX_VALUE;
            Thread thread = workQueue3.parker;
            if (thread != null) {
                U.unpark(thread);
            }
        }
    }

    private static ForkJoinPool makeCommonPool() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = defaultForkJoinWorkerThreadFactory;
        int i = -1;
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory2 = forkJoinWorkerThreadFactory;
        try {
            String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
            String property2 = System.getProperty("java.util.concurrent.ForkJoinPool.common.threadFactory");
            String property3 = System.getProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            int i2 = -1;
            if (property != null) {
                i2 = Integer.parseInt(property);
            }
            ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory3 = forkJoinWorkerThreadFactory;
            if (property2 != null) {
                forkJoinWorkerThreadFactory3 = (ForkJoinWorkerThreadFactory) ClassLoader.getSystemClassLoader().loadClass(property2).newInstance();
            }
            i = i2;
            forkJoinWorkerThreadFactory2 = forkJoinWorkerThreadFactory3;
            uncaughtExceptionHandler = null;
            if (property3 != null) {
                i = i2;
                forkJoinWorkerThreadFactory2 = forkJoinWorkerThreadFactory3;
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) ClassLoader.getSystemClassLoader().loadClass(property3).newInstance();
                forkJoinWorkerThreadFactory2 = forkJoinWorkerThreadFactory3;
                i = i2;
            }
        } catch (Exception e) {
            uncaughtExceptionHandler = null;
        }
        int i3 = i;
        if (i < 0) {
            int availableProcessors = Runtime.getRuntime().availableProcessors() - 1;
            i3 = availableProcessors;
            if (availableProcessors < 0) {
                i3 = 0;
            }
        }
        int i4 = i3;
        if (i3 > 32767) {
            i4 = 32767;
        }
        return new ForkJoinPool(i4, forkJoinWorkerThreadFactory2, uncaughtExceptionHandler, 0, "ForkJoinPool.commonPool-worker-");
    }

    public static void managedBlock(ManagedBlocker managedBlocker) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof ForkJoinWorkerThread)) {
            while (!managedBlocker.isReleasable() && !managedBlocker.block()) {
            }
            return;
        }
        ForkJoinPool forkJoinPool = ((ForkJoinWorkerThread) currentThread).pool;
        while (!managedBlocker.isReleasable()) {
            if (forkJoinPool.tryCompensate(forkJoinPool.ctl)) {
                do {
                    try {
                        if (managedBlocker.isReleasable()) {
                            break;
                        }
                    } finally {
                        forkJoinPool.incrementActiveCount();
                    }
                } while (!managedBlocker.block());
                return;
            }
        }
    }

    private static final int nextPoolId() {
        int i;
        synchronized (ForkJoinPool.class) {
            try {
                i = poolNumberSequence + 1;
                poolNumberSequence = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void quiesceCommonPool() {
        common.awaitQuiescence(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    private void releasePlock(int i) {
        this.plock = i;
        synchronized (this) {
            notifyAll();
        }
    }

    private final int scan(WorkQueue workQueue, int i) {
        int length;
        int i2;
        ForkJoinTask<?>[] forkJoinTaskArr;
        long j = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null || (length = workQueueArr.length - 1) < 0 || workQueue == null) {
            return 0;
        }
        int i3 = length + length + 1;
        int i4 = workQueue.eventCount;
        do {
            WorkQueue workQueue2 = workQueueArr[(i - i3) & length];
            if (workQueue2 != null) {
                int i5 = workQueue2.base;
                if (i5 - workQueue2.top < 0 && (forkJoinTaskArr = workQueue2.array) != null) {
                    long length2 = (((forkJoinTaskArr.length - 1) & i5) << ASHIFT) + ABASE;
                    ForkJoinTask<?> forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, length2);
                    if (forkJoinTask != null) {
                        if (i4 < 0) {
                            helpRelease(j, workQueueArr, workQueue, workQueue2, i5);
                            return 0;
                        } else if (workQueue2.base == i5 && U.compareAndSwapObject(forkJoinTaskArr, length2, forkJoinTask, null)) {
                            U.putOrderedInt(workQueue2, QBASE, i5 + 1);
                            if ((i5 + 1) - workQueue2.top < 0) {
                                signalWork(workQueueArr, workQueue2);
                            }
                            workQueue.runTask(forkJoinTask);
                            return 0;
                        } else {
                            return 0;
                        }
                    }
                    return 0;
                }
            }
            i2 = i3 - 1;
            i3 = i2;
        } while (i2 >= 0);
        int i6 = (int) j;
        if ((i4 | i6) < 0) {
            return awaitWork(workQueue, j, i4);
        }
        if (this.ctl == j) {
            long j2 = i4;
            workQueue.nextWait = i6;
            workQueue.eventCount = Integer.MIN_VALUE | i4;
            if (U.compareAndSwapLong(this, CTL, j, j2 | ((j - AC_UNIT) & (-4294967296L)))) {
                return 0;
            }
            workQueue.eventCount = i4;
            return 0;
        }
        return 0;
    }

    private void tryAddWorker() {
        long j;
        int i;
        int i2;
        do {
            j = this.ctl;
            i = (int) (j >>> 32);
            if (i >= 0 || (32768 & i) == 0 || (i2 = (int) j) < 0) {
                return;
            }
        } while (!U.compareAndSwapLong(this, CTL, j, ((((i + 1) & 65535) | ((65536 + i) & UAC_MASK)) << 32) | i2));
        ForkJoinWorkerThread forkJoinWorkerThread = null;
        try {
            ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
            th = null;
            forkJoinWorkerThread = null;
            if (forkJoinWorkerThreadFactory != null) {
                ForkJoinWorkerThread newThread = forkJoinWorkerThreadFactory.newThread(this);
                th = null;
                forkJoinWorkerThread = newThread;
                if (newThread != null) {
                    forkJoinWorkerThread = newThread;
                    newThread.start();
                    return;
                }
            }
        } catch (Throwable th) {
            th = th;
        }
        deregisterWorker(forkJoinWorkerThread, th);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
        if (r0.currentSteal != r19) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0029, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0029, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int tryHelpStealer(java.util.concurrent.ForkJoinPool.WorkQueue r8, java.util.concurrent.ForkJoinTask<?> r9) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.tryHelpStealer(java.util.concurrent.ForkJoinPool$WorkQueue, java.util.concurrent.ForkJoinTask):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (java.util.concurrent.ForkJoinPool.U.compareAndSwapInt(r13, java.util.concurrent.ForkJoinPool.PLOCK, r0, r16) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00df, code lost:
        signalWork(r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e8, code lost:
        return false;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x020e -> B:77:0x015f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean tryTerminate(boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.tryTerminate(boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int awaitJoin(WorkQueue workQueue, ForkJoinTask<?> forkJoinTask) {
        Unsafe unsafe;
        long j;
        long j2;
        int i = 0;
        if (forkJoinTask != null) {
            int i2 = forkJoinTask.status;
            i = i2;
            if (i2 >= 0) {
                i = i2;
                if (workQueue != null) {
                    ForkJoinTask<?> forkJoinTask2 = workQueue.currentJoin;
                    workQueue.currentJoin = forkJoinTask;
                    while (true) {
                        if (!workQueue.tryRemoveAndExec(forkJoinTask)) {
                            break;
                        }
                        int i3 = forkJoinTask.status;
                        i2 = i3;
                        if (i3 < 0) {
                            i2 = i3;
                            break;
                        }
                    }
                    int i4 = i2;
                    if (i2 >= 0) {
                        i4 = i2;
                        if (forkJoinTask instanceof CountedCompleter) {
                            i4 = helpComplete(workQueue, (CountedCompleter) forkJoinTask);
                        }
                    }
                    long j3 = 0;
                    int i5 = i4;
                    while (true) {
                        i = i5;
                        if (i5 < 0) {
                            break;
                        }
                        int i6 = forkJoinTask.status;
                        i = i6;
                        if (i6 < 0) {
                            break;
                        }
                        int tryHelpStealer = tryHelpStealer(workQueue, forkJoinTask);
                        i5 = tryHelpStealer;
                        if (tryHelpStealer == 0) {
                            int i7 = forkJoinTask.status;
                            i5 = i7;
                            if (i7 < 0) {
                                continue;
                            } else if (tryCompensate(j3)) {
                                i5 = i7;
                                if (forkJoinTask.trySetSignal()) {
                                    int i8 = forkJoinTask.status;
                                    i5 = i8;
                                    if (i8 >= 0) {
                                        synchronized (forkJoinTask) {
                                            if (forkJoinTask.status >= 0) {
                                                try {
                                                    forkJoinTask.wait();
                                                } catch (InterruptedException e) {
                                                }
                                            } else {
                                                forkJoinTask.notifyAll();
                                            }
                                        }
                                        i5 = i8;
                                    }
                                }
                                do {
                                    unsafe = U;
                                    j = CTL;
                                    j2 = this.ctl;
                                } while (!unsafe.compareAndSwapLong(this, j, j2, (281474976710655L & j2) | ((AC_MASK & j2) + AC_UNIT)));
                            } else {
                                j3 = this.ctl;
                                i5 = i7;
                            }
                        }
                    }
                    workQueue.currentJoin = forkJoinTask2;
                }
            }
        }
        return i;
    }

    public boolean awaitQuiescence(long j, TimeUnit timeUnit) {
        WorkQueue[] workQueueArr;
        int length;
        long nanos = timeUnit.toNanos(j);
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            if (forkJoinWorkerThread.pool == this) {
                helpQuiescePool(forkJoinWorkerThread.workQueue);
                return true;
            }
        }
        long nanoTime = System.nanoTime();
        int i = 0;
        boolean z = true;
        while (!isQuiescent() && (workQueueArr = this.workQueues) != null && (length = workQueueArr.length - 1) >= 0) {
            if (!z) {
                if (System.nanoTime() - nanoTime > nanos) {
                    return false;
                }
                Thread.yield();
            }
            int i2 = (length + 1) << 2;
            while (true) {
                if (i2 < 0) {
                    z = false;
                    break;
                }
                int i3 = i + 1;
                WorkQueue workQueue = workQueueArr[i & length];
                if (workQueue != null) {
                    int i4 = workQueue.base;
                    if (i4 - workQueue.top < 0) {
                        ForkJoinTask<?> pollAt = workQueue.pollAt(i4);
                        z = true;
                        i = i3;
                        if (pollAt != null) {
                            pollAt.doExec();
                            z = true;
                            i = i3;
                        }
                    }
                }
                i2--;
                i = i3;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this == common) {
            awaitQuiescence(j, timeUnit);
            return false;
        }
        long nanos = timeUnit.toNanos(j);
        if (isTerminated()) {
            return true;
        }
        if (nanos <= 0) {
            return false;
        }
        long nanoTime = System.nanoTime();
        synchronized (this) {
            long j2 = nanos;
            while (true) {
                long j3 = j2;
                if (isTerminated()) {
                    return true;
                }
                if (j3 <= 0) {
                    return false;
                }
                long millis = TimeUnit.NANOSECONDS.toMillis(j3);
                if (millis <= 0) {
                    millis = 1;
                }
                wait(millis);
                j2 = (nanoTime + nanos) - System.nanoTime();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (java.util.concurrent.ForkJoinPool.U.compareAndSwapInt(r13, java.util.concurrent.ForkJoinPool.PLOCK, r0, r16) == false) goto L36;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void deregisterWorker(java.util.concurrent.ForkJoinWorkerThread r14, java.lang.Throwable r15) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.deregisterWorker(java.util.concurrent.ForkJoinWorkerThread, java.lang.Throwable):void");
    }

    protected int drainTasksTo(Collection<? super ForkJoinTask<?>> collection) {
        int i = 0;
        int i2 = 0;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            int i3 = 0;
            while (true) {
                i = i2;
                if (i3 >= workQueueArr.length) {
                    break;
                }
                WorkQueue workQueue = workQueueArr[i3];
                int i4 = i2;
                if (workQueue != null) {
                    while (true) {
                        ForkJoinTask<?> poll = workQueue.poll();
                        i4 = i2;
                        if (poll != null) {
                            collection.add(poll);
                            i2++;
                        }
                    }
                }
                i3++;
                i2 = i4;
            }
        }
        return i;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        externalPush(runnable instanceof ForkJoinTask ? (ForkJoinTask) runnable : new ForkJoinTask.RunnableExecuteAction(runnable));
    }

    public void execute(ForkJoinTask<?> forkJoinTask) {
        if (forkJoinTask == null) {
            throw new NullPointerException();
        }
        externalPush(forkJoinTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int externalHelpComplete(CountedCompleter<?> countedCompleter) {
        long j;
        int i;
        Submitter submitter = submitters.get();
        WorkQueue[] workQueueArr = this.workQueues;
        int i2 = 0;
        if (submitter != null) {
            i2 = 0;
            if (workQueueArr != null) {
                int length = workQueueArr.length - 1;
                i2 = 0;
                if (length >= 0) {
                    int i3 = submitter.seed;
                    WorkQueue workQueue = workQueueArr[i3 & length & 126];
                    i2 = 0;
                    if (workQueue != null) {
                        i2 = 0;
                        if (countedCompleter != null) {
                            int i4 = length + length + 1;
                            long j2 = 0;
                            int i5 = i3 | 1;
                            int i6 = i4;
                            while (true) {
                                int i7 = i6;
                                i2 = countedCompleter.status;
                                if (i2 < 0) {
                                    break;
                                }
                                if (workQueue.externalPopAndExecCC(countedCompleter)) {
                                    i = i4;
                                    j = j2;
                                } else {
                                    int i8 = countedCompleter.status;
                                    i2 = i8;
                                    if (i8 < 0) {
                                        break;
                                    }
                                    WorkQueue workQueue2 = workQueueArr[i5 & length];
                                    if (workQueue2 == null || !workQueue2.pollAndExecCC(countedCompleter)) {
                                        int i9 = i7 - 1;
                                        j = j2;
                                        i = i9;
                                        if (i9 < 0) {
                                            j = this.ctl;
                                            i2 = i8;
                                            if (j2 == j) {
                                                break;
                                            }
                                            i = i4;
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        i = i4;
                                        j = j2;
                                    }
                                }
                                i5 += 2;
                                j2 = j;
                                i6 = i;
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void externalPush(ForkJoinTask<?> forkJoinTask) {
        int length;
        int length2;
        int i;
        int i2;
        Submitter submitter = submitters.get();
        int i3 = this.plock;
        WorkQueue[] workQueueArr = this.workQueues;
        if (submitter != null && i3 > 0 && workQueueArr != null && (length = workQueueArr.length - 1) >= 0) {
            int i4 = submitter.seed;
            WorkQueue workQueue = workQueueArr[length & i4 & 126];
            if (workQueue != null && i4 != 0 && U.compareAndSwapInt(workQueue, QLOCK, 0, 1)) {
                ForkJoinTask<?>[] forkJoinTaskArr = workQueue.array;
                if (forkJoinTaskArr != null && (length2 = forkJoinTaskArr.length - 1) > (i2 = (i = workQueue.top) - workQueue.base)) {
                    U.putOrderedObject(forkJoinTaskArr, ((length2 & i) << ASHIFT) + ABASE, forkJoinTask);
                    workQueue.top = i + 1;
                    workQueue.qlock = 0;
                    if (i2 <= 1) {
                        signalWork(workQueueArr, workQueue);
                        return;
                    }
                    return;
                }
                workQueue.qlock = 0;
            }
        }
        fullExternalPush(forkJoinTask);
    }

    public int getActiveThreadCount() {
        int i = this.parallelism + ((int) (this.ctl >> 48));
        int i2 = i;
        if (i <= 0) {
            i2 = 0;
        }
        return i2;
    }

    public boolean getAsyncMode() {
        return this.mode == 1;
    }

    public ForkJoinWorkerThreadFactory getFactory() {
        return this.factory;
    }

    public int getParallelism() {
        short s = this.parallelism;
        if (s > 0) {
            return s;
        }
        return 1;
    }

    public int getPoolSize() {
        return this.parallelism + ((short) (this.ctl >>> 32));
    }

    public int getQueuedSubmissionCount() {
        int i = 0;
        int i2 = 0;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            int i3 = 0;
            while (true) {
                i = i2;
                if (i3 >= workQueueArr.length) {
                    break;
                }
                WorkQueue workQueue = workQueueArr[i3];
                int i4 = i2;
                if (workQueue != null) {
                    i4 = i2 + workQueue.queueSize();
                }
                i3 += 2;
                i2 = i4;
            }
        }
        return i;
    }

    public long getQueuedTaskCount() {
        WorkQueue workQueue;
        long j = 0;
        WorkQueue[] workQueueArr = this.workQueues;
        long j2 = 0;
        if (workQueueArr != null) {
            int i = 1;
            while (true) {
                j2 = j;
                if (i >= workQueueArr.length) {
                    break;
                }
                long j3 = j;
                if (workQueueArr[i] != null) {
                    j3 = j + workQueue.queueSize();
                }
                i += 2;
                j = j3;
            }
        }
        return j2;
    }

    public int getRunningThreadCount() {
        int i = 0;
        int i2 = 0;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            int i3 = 1;
            while (true) {
                i = i2;
                if (i3 >= workQueueArr.length) {
                    break;
                }
                WorkQueue workQueue = workQueueArr[i3];
                int i4 = i2;
                if (workQueue != null) {
                    i4 = i2;
                    if (workQueue.isApparentlyUnblocked()) {
                        i4 = i2 + 1;
                    }
                }
                i3 += 2;
                i2 = i4;
            }
        }
        return i;
    }

    public long getStealCount() {
        WorkQueue workQueue;
        long j = this.stealCount;
        WorkQueue[] workQueueArr = this.workQueues;
        long j2 = j;
        if (workQueueArr != null) {
            int i = 1;
            while (true) {
                j2 = j;
                if (i >= workQueueArr.length) {
                    break;
                }
                long j3 = j;
                if (workQueueArr[i] != null) {
                    j3 = j + workQueue.nsteals;
                }
                i += 2;
                j = j3;
            }
        }
        return j2;
    }

    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.ueh;
    }

    public boolean hasQueuedSubmissions() {
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= workQueueArr.length) {
                return false;
            }
            WorkQueue workQueue = workQueueArr[i2];
            if (workQueue != null && !workQueue.isEmpty()) {
                return true;
            }
            i = i2 + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void helpJoinOnce(WorkQueue workQueue, ForkJoinTask<?> forkJoinTask) {
        if (workQueue == null || forkJoinTask == null) {
            return;
        }
        int i = forkJoinTask.status;
        if (i >= 0) {
            ForkJoinTask<?> forkJoinTask2 = workQueue.currentJoin;
            workQueue.currentJoin = forkJoinTask;
            while (true) {
                if (!workQueue.tryRemoveAndExec(forkJoinTask)) {
                    break;
                }
                int i2 = forkJoinTask.status;
                i = i2;
                if (i2 < 0) {
                    i = i2;
                    break;
                }
            }
            if (i >= 0) {
                if (forkJoinTask instanceof CountedCompleter) {
                    helpComplete(workQueue, (CountedCompleter) forkJoinTask);
                }
                while (forkJoinTask.status >= 0 && tryHelpStealer(workQueue, forkJoinTask) > 0) {
                }
            }
            workQueue.currentJoin = forkJoinTask2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0008 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void helpQuiescePool(java.util.concurrent.ForkJoinPool.WorkQueue r14) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.helpQuiescePool(java.util.concurrent.ForkJoinPool$WorkQueue):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void incrementActiveCount() {
        Unsafe unsafe;
        long j;
        long j2;
        do {
            unsafe = U;
            j = CTL;
            j2 = this.ctl;
        } while (!unsafe.compareAndSwapLong(this, j, j2, (281474976710655L & j2) | ((AC_MASK & j2) + AC_UNIT)));
    }

    public <T> T invoke(ForkJoinTask<T> forkJoinTask) {
        if (forkJoinTask == null) {
            throw new NullPointerException();
        }
        externalPush(forkJoinTask);
        return forkJoinTask.join();
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        try {
            for (Callable<T> callable : collection) {
                ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable(callable);
                arrayList.add(adaptedCallable);
                externalPush(adaptedCallable);
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ForkJoinTask) arrayList.get(i)).quietlyJoin();
            }
            if (1 == 0) {
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((Future) arrayList.get(i2)).cancel(false);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 == 0) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((Future) arrayList.get(i3)).cancel(false);
                }
            }
            throw th;
        }
    }

    public boolean isQuiescent() {
        return this.parallelism + ((int) (this.ctl >> 48)) <= 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.plock < 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        long j = this.ctl;
        return (STOP_BIT & j) != 0 && ((short) ((int) (j >>> 32))) + this.parallelism <= 0;
    }

    public boolean isTerminating() {
        long j = this.ctl;
        return (STOP_BIT & j) != 0 && ((short) ((int) (j >>> 32))) + this.parallelism > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new ForkJoinTask.AdaptedRunnable(runnable, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ForkJoinTask.AdaptedCallable(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ForkJoinTask<?> nextTaskFor(WorkQueue workQueue) {
        ForkJoinTask<?> pollAt;
        while (true) {
            ForkJoinTask<?> nextLocalTask = workQueue.nextLocalTask();
            if (nextLocalTask != null) {
                return nextLocalTask;
            }
            WorkQueue findNonEmptyStealQueue = findNonEmptyStealQueue();
            if (findNonEmptyStealQueue == null) {
                return null;
            }
            int i = findNonEmptyStealQueue.base;
            if (i - findNonEmptyStealQueue.top < 0 && (pollAt = findNonEmptyStealQueue.pollAt(i)) != null) {
                return pollAt;
            }
        }
    }

    protected ForkJoinTask<?> pollSubmission() {
        ForkJoinTask<?> poll;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= workQueueArr.length) {
                return null;
            }
            WorkQueue workQueue = workQueueArr[i2];
            if (workQueue != null && (poll = workQueue.poll()) != null) {
                return poll;
            }
            i = i2 + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0072, code lost:
        if (java.util.concurrent.ForkJoinPool.U.compareAndSwapInt(r7, java.util.concurrent.ForkJoinPool.PLOCK, r0, r10) == false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.concurrent.ForkJoinPool.WorkQueue registerWorker(java.util.concurrent.ForkJoinWorkerThread r8) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.registerWorker(java.util.concurrent.ForkJoinWorkerThread):java.util.concurrent.ForkJoinPool$WorkQueue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void runWorker(WorkQueue workQueue) {
        workQueue.growArray();
        int i = workQueue.hint;
        while (true) {
            int i2 = i;
            if (scan(workQueue, i2) != 0) {
                return;
            }
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >>> 17);
            i = i4 ^ (i4 << 5);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        checkPermission();
        tryTerminate(false, true);
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        checkPermission();
        tryTerminate(true, true);
        return Collections.emptyList();
    }

    final void signalWork(WorkQueue[] workQueueArr, WorkQueue workQueue) {
        int i;
        WorkQueue workQueue2;
        while (true) {
            long j = this.ctl;
            int i2 = (int) (j >>> 32);
            if (i2 >= 0) {
                return;
            }
            int i3 = (int) j;
            if (i3 <= 0) {
                if (((short) i2) < 0) {
                    tryAddWorker();
                    return;
                }
                return;
            } else if (workQueueArr == null || workQueueArr.length <= (i = i3 & 65535) || (workQueue2 = workQueueArr[i]) == null) {
                return;
            } else {
                long j2 = workQueue2.nextWait & Integer.MAX_VALUE;
                long j3 = 65536 + i2;
                if (workQueue2.eventCount == (Integer.MIN_VALUE | i3) && U.compareAndSwapLong(this, CTL, j, j2 | (j3 << 32))) {
                    workQueue2.eventCount = (65536 + i3) & Integer.MAX_VALUE;
                    Thread thread = workQueue2.parker;
                    if (thread != null) {
                        U.unpark(thread);
                        return;
                    }
                    return;
                } else if (workQueue != null && workQueue.base >= workQueue.top) {
                    return;
                }
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ForkJoinTask<?> submit(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        ForkJoinTask.AdaptedRunnableAction adaptedRunnableAction = runnable instanceof ForkJoinTask ? (ForkJoinTask) runnable : new ForkJoinTask.AdaptedRunnableAction(runnable);
        externalPush(adaptedRunnableAction);
        return adaptedRunnableAction;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Runnable runnable, T t) {
        ForkJoinTask.AdaptedRunnable adaptedRunnable = new ForkJoinTask.AdaptedRunnable(runnable, t);
        externalPush(adaptedRunnable);
        return adaptedRunnable;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Callable<T> callable) {
        ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable(callable);
        externalPush(adaptedCallable);
        return adaptedCallable;
    }

    public <T> ForkJoinTask<T> submit(ForkJoinTask<T> forkJoinTask) {
        if (forkJoinTask == null) {
            throw new NullPointerException();
        }
        externalPush(forkJoinTask);
        return forkJoinTask;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    public String toString() {
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        long j3 = this.stealCount;
        long j4 = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        long j5 = 0;
        long j6 = 0;
        long j7 = j3;
        if (workQueueArr != null) {
            int i3 = 0;
            while (true) {
                j5 = j2;
                j6 = j;
                i = i2;
                j7 = j3;
                if (i3 >= workQueueArr.length) {
                    break;
                }
                WorkQueue workQueue = workQueueArr[i3];
                long j8 = j2;
                long j9 = j;
                int i4 = i2;
                long j10 = j3;
                if (workQueue != null) {
                    int queueSize = workQueue.queueSize();
                    if ((i3 & 1) == 0) {
                        j8 = j2 + queueSize;
                        j10 = j3;
                        i4 = i2;
                        j9 = j;
                    } else {
                        long j11 = j + queueSize;
                        long j12 = j3 + workQueue.nsteals;
                        j8 = j2;
                        j9 = j11;
                        i4 = i2;
                        j10 = j12;
                        if (workQueue.isApparentlyUnblocked()) {
                            i4 = i2 + 1;
                            j8 = j2;
                            j9 = j11;
                            j10 = j12;
                        }
                    }
                }
                i3++;
                j2 = j8;
                j = j9;
                i2 = i4;
                j3 = j10;
            }
        }
        short s = this.parallelism;
        int i5 = s + ((short) (j4 >>> 32));
        int i6 = s + ((int) (j4 >> 48));
        int i7 = i6;
        if (i6 < 0) {
            i7 = 0;
        }
        return super.toString() + "[" + ((STOP_BIT & j4) != 0 ? i5 == 0 ? "Terminated" : "Terminating" : this.plock < 0 ? "Shutting down" : "Running") + ", parallelism = " + ((int) s) + ", size = " + i5 + ", active = " + i7 + ", running = " + i + ", steals = " + j7 + ", tasks = " + j6 + ", submissions = " + j5 + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean tryCompensate(long j) {
        int length;
        WorkQueue[] workQueueArr = this.workQueues;
        short s = this.parallelism;
        int i = (int) j;
        if (workQueueArr == null || (length = workQueueArr.length - 1) < 0 || i < 0 || this.ctl != j) {
            return false;
        }
        WorkQueue workQueue = workQueueArr[i & length];
        if (i != 0 && workQueue != null) {
            long j2 = workQueue.nextWait & Integer.MAX_VALUE;
            if (workQueue.eventCount == (Integer.MIN_VALUE | i) && U.compareAndSwapLong(this, CTL, j, j2 | ((-4294967296L) & j))) {
                workQueue.eventCount = (65536 + i) & Integer.MAX_VALUE;
                Thread thread = workQueue.parker;
                if (thread != null) {
                    U.unpark(thread);
                    return true;
                }
                return true;
            }
            return false;
        }
        short s2 = (short) (j >>> 32);
        if (s2 >= 0 && ((int) (j >> 48)) + s > 1) {
            return U.compareAndSwapLong(this, CTL, j, ((j - AC_UNIT) & AC_MASK) | (281474976710655L & j));
        } else if (s2 + s >= 32767 || !U.compareAndSwapLong(this, CTL, j, ((TC_UNIT + j) & TC_MASK) | ((-281470681743361L) & j))) {
            return false;
        } else {
            ForkJoinWorkerThread forkJoinWorkerThread = null;
            try {
                ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
                th = null;
                forkJoinWorkerThread = null;
                if (forkJoinWorkerThreadFactory != null) {
                    ForkJoinWorkerThread newThread = forkJoinWorkerThreadFactory.newThread(this);
                    th = null;
                    forkJoinWorkerThread = newThread;
                    if (newThread != null) {
                        forkJoinWorkerThread = newThread;
                        newThread.start();
                        return true;
                    }
                }
            } catch (Throwable th) {
                th = th;
            }
            deregisterWorker(forkJoinWorkerThread, th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean tryExternalUnpush(ForkJoinTask<?> forkJoinTask) {
        Submitter submitter = submitters.get();
        WorkQueue[] workQueueArr = this.workQueues;
        boolean z = false;
        if (submitter != null) {
            z = false;
            if (workQueueArr != null) {
                int length = workQueueArr.length - 1;
                z = false;
                if (length >= 0) {
                    WorkQueue workQueue = workQueueArr[submitter.seed & length & 126];
                    z = false;
                    if (workQueue != null) {
                        int i = workQueue.base;
                        int i2 = workQueue.top;
                        z = false;
                        if (i != i2) {
                            ForkJoinTask<?>[] forkJoinTaskArr = workQueue.array;
                            z = false;
                            if (forkJoinTaskArr != null) {
                                long length2 = (((forkJoinTaskArr.length - 1) & (i2 - 1)) << ASHIFT) + ABASE;
                                z = false;
                                if (U.getObject(forkJoinTaskArr, length2) == forkJoinTask) {
                                    z = false;
                                    if (U.compareAndSwapInt(workQueue, QLOCK, 0, 1)) {
                                        z = false;
                                        if (workQueue.top == i2) {
                                            z = false;
                                            if (workQueue.array == forkJoinTaskArr) {
                                                z = false;
                                                if (U.compareAndSwapObject(forkJoinTaskArr, length2, forkJoinTask, null)) {
                                                    workQueue.top = i2 - 1;
                                                    z = true;
                                                }
                                            }
                                        }
                                        workQueue.qlock = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }
}
