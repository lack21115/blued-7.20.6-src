package java.util.concurrent;

import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinTask.class */
public abstract class ForkJoinTask<V> implements Future<V>, Serializable {
    static final int CANCELLED = -1073741824;
    static final int DONE_MASK = -268435456;
    static final int EXCEPTIONAL = Integer.MIN_VALUE;
    private static final int EXCEPTION_MAP_CAPACITY = 32;
    static final int NORMAL = -268435456;
    static final int SIGNAL = 65536;
    static final int SMASK = 65535;
    private static final long STATUS;
    private static final Unsafe U;
    private static final long serialVersionUID = -7721805057305804111L;
    volatile int status;
    private static final ReentrantLock exceptionTableLock = new ReentrantLock();
    private static final ReferenceQueue<Object> exceptionTableRefQueue = new ReferenceQueue<>();
    private static final ExceptionNode[] exceptionTable = new ExceptionNode[32];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinTask$AdaptedCallable.class */
    public static final class AdaptedCallable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<? extends T> callable;
        T result;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedCallable(Callable<? extends T> callable) {
            if (callable == null) {
                throw new NullPointerException();
            }
            this.callable = callable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            try {
                this.result = this.callable.call();
                return true;
            } catch (Error e) {
                throw e;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinTask$AdaptedRunnable.class */
    public static final class AdaptedRunnable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 5232453952276885070L;
        T result;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedRunnable(Runnable runnable, T t) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
            this.result = t;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinTask$AdaptedRunnableAction.class */
    public static final class AdaptedRunnableAction extends ForkJoinTask<Void> implements RunnableFuture<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedRunnableAction(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void r2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinTask$ExceptionNode.class */
    public static final class ExceptionNode extends WeakReference<ForkJoinTask<?>> {
        final Throwable ex;
        ExceptionNode next;
        final long thrower;

        ExceptionNode(ForkJoinTask<?> forkJoinTask, Throwable th, ExceptionNode exceptionNode) {
            super(forkJoinTask, ForkJoinTask.exceptionTableRefQueue);
            this.ex = th;
            this.next = exceptionNode;
            this.thrower = Thread.currentThread().getId();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ForkJoinTask$RunnableExecuteAction.class */
    static final class RunnableExecuteAction extends ForkJoinTask<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RunnableExecuteAction(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        void internalPropagateException(Throwable th) {
            rethrow(th);
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void r2) {
        }
    }

    static {
        try {
            U = Unsafe.getUnsafe();
            STATUS = U.objectFieldOffset(ForkJoinTask.class.getDeclaredField("status"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static ForkJoinTask<?> adapt(Runnable runnable) {
        return new AdaptedRunnableAction(runnable);
    }

    public static <T> ForkJoinTask<T> adapt(Runnable runnable, T t) {
        return new AdaptedRunnable(runnable, t);
    }

    public static <T> ForkJoinTask<T> adapt(Callable<? extends T> callable) {
        return new AdaptedCallable(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void cancelIgnoringExceptions(ForkJoinTask<?> forkJoinTask) {
        if (forkJoinTask == null || forkJoinTask.status < 0) {
            return;
        }
        try {
            forkJoinTask.cancel(false);
        } catch (Throwable th) {
        }
    }

    private void clearExceptionalCompletion() {
        int identityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            ExceptionNode[] exceptionNodeArr = exceptionTable;
            int length = identityHashCode & (exceptionNodeArr.length - 1);
            ExceptionNode exceptionNode = exceptionNodeArr[length];
            ExceptionNode exceptionNode2 = null;
            while (true) {
                if (exceptionNode == null) {
                    break;
                }
                ExceptionNode exceptionNode3 = exceptionNode.next;
                if (exceptionNode.get() != this) {
                    exceptionNode2 = exceptionNode;
                    exceptionNode = exceptionNode3;
                } else if (exceptionNode2 == null) {
                    exceptionNodeArr[length] = exceptionNode3;
                } else {
                    exceptionNode2.next = exceptionNode3;
                }
            }
            expungeStaleExceptions();
            this.status = 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    private int doInvoke() {
        int doExec = doExec();
        if (doExec < 0) {
            return doExec;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            return forkJoinWorkerThread.pool.awaitJoin(forkJoinWorkerThread.workQueue, this);
        }
        return externalAwaitDone();
    }

    private int doJoin() {
        int doExec;
        int i = this.status;
        if (i < 0) {
            return i;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            ForkJoinPool.WorkQueue workQueue = forkJoinWorkerThread.workQueue;
            return (!workQueue.tryUnpush(this) || (doExec = doExec()) >= 0) ? forkJoinWorkerThread.pool.awaitJoin(workQueue, this) : doExec;
        }
        return externalAwaitDone();
    }

    private static void expungeStaleExceptions() {
        while (true) {
            Reference<? extends Object> poll = exceptionTableRefQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof ExceptionNode) {
                ForkJoinTask<?> forkJoinTask = ((ExceptionNode) poll).get();
                ExceptionNode[] exceptionNodeArr = exceptionTable;
                int identityHashCode = System.identityHashCode(forkJoinTask) & (exceptionNodeArr.length - 1);
                ExceptionNode exceptionNode = exceptionNodeArr[identityHashCode];
                ExceptionNode exceptionNode2 = null;
                while (true) {
                    if (exceptionNode != null) {
                        ExceptionNode exceptionNode3 = exceptionNode.next;
                        if (exceptionNode != poll) {
                            exceptionNode2 = exceptionNode;
                            exceptionNode = exceptionNode3;
                        } else if (exceptionNode2 == null) {
                            exceptionNodeArr[identityHashCode] = exceptionNode3;
                        } else {
                            exceptionNode2.next = exceptionNode3;
                        }
                    }
                }
            }
        }
    }

    private int externalAwaitDone() {
        boolean z;
        int i;
        ForkJoinPool forkJoinPool = ForkJoinPool.common;
        int i2 = this.status;
        int i3 = i2;
        if (i2 >= 0) {
            int i4 = i2;
            if (forkJoinPool != null) {
                if (this instanceof CountedCompleter) {
                    i4 = forkJoinPool.externalHelpComplete((CountedCompleter) this);
                } else {
                    i4 = i2;
                    if (forkJoinPool.tryExternalUnpush(this)) {
                        i4 = doExec();
                    }
                }
            }
            i3 = i4;
            if (i4 >= 0) {
                int i5 = this.status;
                i3 = i5;
                if (i5 >= 0) {
                    boolean z2 = false;
                    int i6 = i5;
                    do {
                        z = z2;
                        if (U.compareAndSwapInt(this, STATUS, i6, i6 | 65536)) {
                            synchronized (this) {
                                if (this.status >= 0) {
                                    try {
                                        wait();
                                    } catch (InterruptedException e) {
                                        z2 = true;
                                    }
                                } else {
                                    notifyAll();
                                }
                            }
                            z = z2;
                        }
                        i = this.status;
                        i6 = i;
                        z2 = z;
                    } while (i >= 0);
                    i3 = i;
                    if (z) {
                        Thread.currentThread().interrupt();
                        i3 = i;
                    }
                }
            }
        }
        return i3;
    }

    private int externalInterruptibleAwaitDone() throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.common;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.status >= 0 && forkJoinPool != null) {
            if (this instanceof CountedCompleter) {
                forkJoinPool.externalHelpComplete((CountedCompleter) this);
            } else if (forkJoinPool.tryExternalUnpush(this)) {
                doExec();
            }
        }
        while (true) {
            int i = this.status;
            if (i < 0) {
                return i;
            }
            if (U.compareAndSwapInt(this, STATUS, i, i | 65536)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        wait();
                    } else {
                        notifyAll();
                    }
                }
            }
        }
    }

    public static ForkJoinPool getPool() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).pool;
        }
        return null;
    }

    public static int getQueuedTaskCount() {
        Thread currentThread = Thread.currentThread();
        ForkJoinPool.WorkQueue commonSubmitterQueue = currentThread instanceof ForkJoinWorkerThread ? ((ForkJoinWorkerThread) currentThread).workQueue : ForkJoinPool.commonSubmitterQueue();
        if (commonSubmitterQueue == null) {
            return 0;
        }
        return commonSubmitterQueue.queueSize();
    }

    public static int getSurplusQueuedTaskCount() {
        return ForkJoinPool.getSurplusQueuedTaskCount();
    }

    private Throwable getThrowableException() {
        Throwable th;
        if ((this.status & ShareElfFile.SectionHeader.SHF_MASKPROC) != Integer.MIN_VALUE) {
            th = null;
        } else {
            int identityHashCode = System.identityHashCode(this);
            ReentrantLock reentrantLock = exceptionTableLock;
            reentrantLock.lock();
            try {
                expungeStaleExceptions();
                ExceptionNode[] exceptionNodeArr = exceptionTable;
                ExceptionNode exceptionNode = exceptionNodeArr[(exceptionNodeArr.length - 1) & identityHashCode];
                while (exceptionNode != null) {
                    if (exceptionNode.get() == this) {
                        break;
                    }
                    exceptionNode = exceptionNode.next;
                }
                reentrantLock.unlock();
                if (exceptionNode == null) {
                    return null;
                }
                Throwable th2 = exceptionNode.ex;
                th = th2;
                if (th2 == null) {
                    return null;
                }
            } catch (Throwable th3) {
                reentrantLock.unlock();
                throw th3;
            }
        }
        return th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void helpExpungeStaleExceptions() {
        ReentrantLock reentrantLock = exceptionTableLock;
        if (reentrantLock.tryLock()) {
            try {
                expungeStaleExceptions();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void helpQuiesce() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof ForkJoinWorkerThread)) {
            ForkJoinPool.quiesceCommonPool();
            return;
        }
        ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
        forkJoinWorkerThread.pool.helpQuiescePool(forkJoinWorkerThread.workQueue);
    }

    public static boolean inForkJoinPool() {
        return Thread.currentThread() instanceof ForkJoinWorkerThread;
    }

    public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T> collection) {
        NullPointerException nullPointerException;
        if ((collection instanceof RandomAccess) && (collection instanceof List)) {
            List list = (List) collection;
            NullPointerException nullPointerException2 = null;
            int size = list.size() - 1;
            int i = size;
            while (i >= 0) {
                ForkJoinTask forkJoinTask = (ForkJoinTask) list.get(i);
                if (forkJoinTask == null) {
                    nullPointerException = nullPointerException2;
                    if (nullPointerException2 == null) {
                        nullPointerException = new NullPointerException();
                    }
                } else if (i != 0) {
                    forkJoinTask.fork();
                    nullPointerException = nullPointerException2;
                } else {
                    nullPointerException = nullPointerException2;
                    if (forkJoinTask.doInvoke() < -268435456) {
                        nullPointerException = nullPointerException2;
                        if (nullPointerException2 == null) {
                            nullPointerException = forkJoinTask.getException();
                        }
                    }
                }
                i--;
                nullPointerException2 = nullPointerException;
            }
            int i2 = 1;
            while (i2 <= size) {
                ForkJoinTask forkJoinTask2 = (ForkJoinTask) list.get(i2);
                NullPointerException nullPointerException3 = nullPointerException2;
                if (forkJoinTask2 != null) {
                    if (nullPointerException2 != null) {
                        forkJoinTask2.cancel(false);
                        nullPointerException3 = nullPointerException2;
                    } else {
                        nullPointerException3 = nullPointerException2;
                        if (forkJoinTask2.doJoin() < -268435456) {
                            nullPointerException3 = forkJoinTask2.getException();
                        }
                    }
                }
                i2++;
                nullPointerException2 = nullPointerException3;
            }
            if (nullPointerException2 != null) {
                rethrow(nullPointerException2);
                return collection;
            }
        } else {
            invokeAll((ForkJoinTask[]) collection.toArray(new ForkJoinTask[collection.size()]));
        }
        return collection;
    }

    public static void invokeAll(ForkJoinTask<?> forkJoinTask, ForkJoinTask<?> forkJoinTask2) {
        forkJoinTask2.fork();
        int doInvoke = forkJoinTask.doInvoke() & ShareElfFile.SectionHeader.SHF_MASKPROC;
        if (doInvoke != -268435456) {
            forkJoinTask.reportException(doInvoke);
        }
        int doJoin = forkJoinTask2.doJoin() & ShareElfFile.SectionHeader.SHF_MASKPROC;
        if (doJoin != -268435456) {
            forkJoinTask2.reportException(doJoin);
        }
    }

    public static void invokeAll(ForkJoinTask<?>... forkJoinTaskArr) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2 = null;
        int length = forkJoinTaskArr.length - 1;
        int i = length;
        while (i >= 0) {
            ForkJoinTask<?> forkJoinTask = forkJoinTaskArr[i];
            if (forkJoinTask == null) {
                nullPointerException = nullPointerException2;
                if (nullPointerException2 == null) {
                    nullPointerException = new NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
                nullPointerException = nullPointerException2;
            } else {
                nullPointerException = nullPointerException2;
                if (forkJoinTask.doInvoke() < -268435456) {
                    nullPointerException = nullPointerException2;
                    if (nullPointerException2 == null) {
                        nullPointerException = forkJoinTask.getException();
                    }
                }
            }
            i--;
            nullPointerException2 = nullPointerException;
        }
        int i2 = 1;
        while (i2 <= length) {
            ForkJoinTask<?> forkJoinTask2 = forkJoinTaskArr[i2];
            NullPointerException nullPointerException3 = nullPointerException2;
            if (forkJoinTask2 != null) {
                if (nullPointerException2 != null) {
                    forkJoinTask2.cancel(false);
                    nullPointerException3 = nullPointerException2;
                } else {
                    nullPointerException3 = nullPointerException2;
                    if (forkJoinTask2.doJoin() < -268435456) {
                        nullPointerException3 = forkJoinTask2.getException();
                    }
                }
            }
            i2++;
            nullPointerException2 = nullPointerException3;
        }
        if (nullPointerException2 != null) {
            rethrow(nullPointerException2);
        }
    }

    protected static ForkJoinTask<?> peekNextLocalTask() {
        Thread currentThread = Thread.currentThread();
        ForkJoinPool.WorkQueue commonSubmitterQueue = currentThread instanceof ForkJoinWorkerThread ? ((ForkJoinWorkerThread) currentThread).workQueue : ForkJoinPool.commonSubmitterQueue();
        if (commonSubmitterQueue == null) {
            return null;
        }
        return commonSubmitterQueue.peek();
    }

    protected static ForkJoinTask<?> pollNextLocalTask() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).workQueue.nextLocalTask();
        }
        return null;
    }

    protected static ForkJoinTask<?> pollTask() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            return forkJoinWorkerThread.pool.nextTaskFor(forkJoinWorkerThread.workQueue);
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        if (readObject != null) {
            setExceptionalCompletion((Throwable) readObject);
        }
    }

    private void reportException(int i) {
        if (i == -1073741824) {
            throw new CancellationException();
        }
        if (i == Integer.MIN_VALUE) {
            rethrow(getThrowableException());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void rethrow(Throwable th) {
        if (th != null) {
            uncheckedThrow(th);
        }
    }

    private int setCompletion(int i) {
        int i2;
        do {
            i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i2, i2 | i));
        if ((i2 >>> 16) != 0) {
            synchronized (this) {
                notifyAll();
            }
        }
        return i;
    }

    private int setExceptionalCompletion(Throwable th) {
        int recordExceptionalCompletion = recordExceptionalCompletion(th);
        if (((-268435456) & recordExceptionalCompletion) == Integer.MIN_VALUE) {
            internalPropagateException(th);
        }
        return recordExceptionalCompletion;
    }

    static <T extends Throwable> void uncheckedThrow(Throwable th) throws Throwable {
        throw th;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getException());
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return (setCompletion(-1073741824) & ShareElfFile.SectionHeader.SHF_MASKPROC) == -1073741824;
    }

    public final boolean compareAndSetForkJoinTaskTag(short s, short s2) {
        int i;
        do {
            i = this.status;
            if (((short) i) != s) {
                return false;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i, (65535 & s2) | ((-65536) & i)));
        return true;
    }

    public void complete(V v) {
        try {
            setRawResult(v);
            setCompletion(ShareElfFile.SectionHeader.SHF_MASKPROC);
        } catch (Throwable th) {
            setExceptionalCompletion(th);
        }
    }

    public void completeExceptionally(Throwable th) {
        RuntimeException runtimeException = th;
        if (!(th instanceof RuntimeException)) {
            runtimeException = th instanceof Error ? th : new RuntimeException(th);
        }
        setExceptionalCompletion(runtimeException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int doExec() {
        int i = this.status;
        int i2 = i;
        if (i >= 0) {
            try {
                i2 = i;
                if (exec()) {
                    i2 = setCompletion(ShareElfFile.SectionHeader.SHF_MASKPROC);
                }
            } catch (Throwable th) {
                return setExceptionalCompletion(th);
            }
        }
        return i2;
    }

    protected abstract boolean exec();

    public final ForkJoinTask<V> fork() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ((ForkJoinWorkerThread) currentThread).workQueue.push(this);
            return this;
        }
        ForkJoinPool.common.externalPush(this);
        return this;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Throwable throwableException;
        int doJoin = (Thread.currentThread() instanceof ForkJoinWorkerThread ? doJoin() : externalInterruptibleAwaitDone()) & ShareElfFile.SectionHeader.SHF_MASKPROC;
        if (doJoin == -1073741824) {
            throw new CancellationException();
        }
        if (doJoin != Integer.MIN_VALUE || (throwableException = getThrowableException()) == null) {
            return getRawResult();
        }
        throw new ExecutionException(throwableException);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        ForkJoinPool forkJoinPool;
        ForkJoinPool.WorkQueue workQueue;
        boolean z;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        long nanos = timeUnit.toNanos(j);
        int i = this.status;
        int i2 = i;
        if (i >= 0) {
            i2 = i;
            if (nanos > 0) {
                long nanoTime = System.nanoTime();
                Thread currentThread = Thread.currentThread();
                if (currentThread instanceof ForkJoinWorkerThread) {
                    ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
                    forkJoinPool = forkJoinWorkerThread.pool;
                    workQueue = forkJoinWorkerThread.workQueue;
                    forkJoinPool.helpJoinOnce(workQueue, this);
                } else {
                    ForkJoinPool forkJoinPool2 = ForkJoinPool.common;
                    forkJoinPool = null;
                    workQueue = null;
                    if (forkJoinPool2 != null) {
                        if (this instanceof CountedCompleter) {
                            forkJoinPool2.externalHelpComplete((CountedCompleter) this);
                            forkJoinPool = null;
                            workQueue = null;
                        } else {
                            forkJoinPool = null;
                            workQueue = null;
                            if (forkJoinPool2.tryExternalUnpush(this)) {
                                doExec();
                                forkJoinPool = null;
                                workQueue = null;
                            }
                        }
                    }
                }
                boolean z2 = false;
                boolean z3 = false;
                long j2 = nanos;
                while (true) {
                    long j3 = j2;
                    try {
                        int i3 = this.status;
                        i2 = i3;
                        z = z3;
                        if (i3 < 0) {
                            break;
                        } else if (workQueue != null && workQueue.qlock < 0) {
                            cancelIgnoringExceptions(this);
                            j2 = j3;
                        } else if (z2) {
                            long millis = TimeUnit.NANOSECONDS.toMillis(j3);
                            boolean z4 = z3;
                            if (millis > 0) {
                                z4 = z3;
                                if (U.compareAndSwapInt(this, STATUS, i3, i3 | 65536)) {
                                    synchronized (this) {
                                        if (this.status >= 0) {
                                            try {
                                                wait(millis);
                                            } catch (InterruptedException e) {
                                                if (forkJoinPool == null) {
                                                    z3 = true;
                                                }
                                            }
                                        } else {
                                            notifyAll();
                                        }
                                    }
                                    z4 = z3;
                                }
                            }
                            int i4 = this.status;
                            i2 = i4;
                            z = z4;
                            if (i4 < 0) {
                                break;
                            }
                            i2 = i4;
                            z = z4;
                            if (z4) {
                                break;
                            }
                            long nanoTime2 = (nanoTime + nanos) - System.nanoTime();
                            z3 = z4;
                            j2 = nanoTime2;
                            if (nanoTime2 <= 0) {
                                z = z4;
                                i2 = i4;
                                break;
                            }
                        } else {
                            if (forkJoinPool != null) {
                                j2 = j3;
                                if (forkJoinPool.tryCompensate(forkJoinPool.ctl)) {
                                }
                            }
                            z2 = true;
                            j2 = j3;
                        }
                    } finally {
                        if (forkJoinPool != null && z2) {
                            forkJoinPool.incrementActiveCount();
                        }
                    }
                }
                if (z) {
                    throw new InterruptedException();
                }
            }
        }
        int i5 = i2 & ShareElfFile.SectionHeader.SHF_MASKPROC;
        if (i5 != -268435456) {
            if (i5 == -1073741824) {
                throw new CancellationException();
            }
            if (i5 != Integer.MIN_VALUE) {
                throw new TimeoutException();
            }
            Throwable throwableException = getThrowableException();
            if (throwableException != null) {
                throw new ExecutionException(throwableException);
            }
        }
        return getRawResult();
    }

    public final Throwable getException() {
        int i = this.status & ShareElfFile.SectionHeader.SHF_MASKPROC;
        if (i >= -268435456) {
            return null;
        }
        return i == -1073741824 ? new CancellationException() : getThrowableException();
    }

    public final short getForkJoinTaskTag() {
        return (short) this.status;
    }

    public abstract V getRawResult();

    void internalPropagateException(Throwable th) {
    }

    public final V invoke() {
        int doInvoke = doInvoke() & ShareElfFile.SectionHeader.SHF_MASKPROC;
        if (doInvoke != -268435456) {
            reportException(doInvoke);
        }
        return getRawResult();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return (this.status & ShareElfFile.SectionHeader.SHF_MASKPROC) == -1073741824;
    }

    public final boolean isCompletedAbnormally() {
        return this.status < -268435456;
    }

    public final boolean isCompletedNormally() {
        return (this.status & ShareElfFile.SectionHeader.SHF_MASKPROC) == -268435456;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.status < 0;
    }

    public final V join() {
        int doJoin = doJoin() & ShareElfFile.SectionHeader.SHF_MASKPROC;
        if (doJoin != -268435456) {
            reportException(doJoin);
        }
        return getRawResult();
    }

    public final void quietlyComplete() {
        setCompletion(ShareElfFile.SectionHeader.SHF_MASKPROC);
    }

    public final void quietlyInvoke() {
        doInvoke();
    }

    public final void quietlyJoin() {
        doJoin();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
        r0[r0] = new java.util.concurrent.ForkJoinTask.ExceptionNode(r9, r10, r0[r0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int recordExceptionalCompletion(java.lang.Throwable r10) {
        /*
            r9 = this;
            r0 = r9
            int r0 = r0.status
            r12 = r0
            r0 = r12
            r11 = r0
            r0 = r12
            if (r0 < 0) goto L52
            r0 = r9
            int r0 = java.lang.System.identityHashCode(r0)
            r11 = r0
            java.util.concurrent.locks.ReentrantLock r0 = java.util.concurrent.ForkJoinTask.exceptionTableLock
            r14 = r0
            r0 = r14
            r0.lock()
            expungeStaleExceptions()     // Catch: java.lang.Throwable -> L67
            java.util.concurrent.ForkJoinTask$ExceptionNode[] r0 = java.util.concurrent.ForkJoinTask.exceptionTable     // Catch: java.lang.Throwable -> L67
            r15 = r0
            r0 = r11
            r1 = r15
            int r1 = r1.length     // Catch: java.lang.Throwable -> L67
            r2 = 1
            int r1 = r1 - r2
            r0 = r0 & r1
            r11 = r0
            r0 = r15
            r1 = r11
            r0 = r0[r1]
            r13 = r0
        L30:
            r0 = r13
            if (r0 != 0) goto L54
            r0 = r15
            r1 = r11
            java.util.concurrent.ForkJoinTask$ExceptionNode r2 = new java.util.concurrent.ForkJoinTask$ExceptionNode     // Catch: java.lang.Throwable -> L67
            r3 = r2
            r4 = r9
            r5 = r10
            r6 = r15
            r7 = r11
            r6 = r6[r7]     // Catch: java.lang.Throwable -> L67
            r3.<init>(r4, r5, r6)     // Catch: java.lang.Throwable -> L67
            r0[r1] = r2     // Catch: java.lang.Throwable -> L67
        L46:
            r0 = r14
            r0.unlock()
            r0 = r9
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = r0.setCompletion(r1)
            r11 = r0
        L52:
            r0 = r11
            return r0
        L54:
            r0 = r13
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L67
            r1 = r9
            if (r0 == r1) goto L46
            r0 = r13
            java.util.concurrent.ForkJoinTask$ExceptionNode r0 = r0.next     // Catch: java.lang.Throwable -> L67
            r13 = r0
            goto L30
        L67:
            r10 = move-exception
            r0 = r14
            r0.unlock()
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinTask.recordExceptionalCompletion(java.lang.Throwable):int");
    }

    public void reinitialize() {
        if ((this.status & ShareElfFile.SectionHeader.SHF_MASKPROC) == Integer.MIN_VALUE) {
            clearExceptionalCompletion();
        } else {
            this.status = 0;
        }
    }

    public final short setForkJoinTaskTag(short s) {
        Unsafe unsafe;
        long j;
        int i;
        do {
            unsafe = U;
            j = STATUS;
            i = this.status;
        } while (!unsafe.compareAndSwapInt(this, j, i, (65535 & s) | ((-65536) & i)));
        return (short) i;
    }

    protected abstract void setRawResult(V v);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean trySetSignal() {
        int i = this.status;
        return i >= 0 && U.compareAndSwapInt(this, STATUS, i, i | 65536);
    }

    public boolean tryUnfork() {
        Thread currentThread = Thread.currentThread();
        return currentThread instanceof ForkJoinWorkerThread ? ((ForkJoinWorkerThread) currentThread).workQueue.tryUnpush(this) : ForkJoinPool.common.tryExternalUnpush(this);
    }
}
