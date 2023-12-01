package com.google.common.util.concurrent;

import com.alipay.sdk.util.i;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/SequentialExecutor.class */
public final class SequentialExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor executor;
    private final Deque<Runnable> queue = new ArrayDeque();
    private WorkerRunningState workerRunningState = WorkerRunningState.IDLE;
    private long workerRunCount = 0;
    private final QueueWorker worker = new QueueWorker();

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/SequentialExecutor$QueueWorker.class */
    final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
            if (r6 == false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
            r0 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
            r6 = r6 | java.lang.Thread.interrupted();
            r9 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
            r0.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
            r7 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
            r0 = com.google.common.util.concurrent.SequentialExecutor.log;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a7, code lost:
            r0 = java.util.logging.Level.SEVERE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00af, code lost:
            r0 = new java.lang.StringBuilder();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00bb, code lost:
            r0.append("Exception while executing runnable ");
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c6, code lost:
            r0.append(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00d1, code lost:
            r0.log(r0, r0.toString(), (java.lang.Throwable) r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00e0, code lost:
            r7 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void workOnQueue() {
            /*
                Method dump skipped, instructions count: 255
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.queue) {
                    SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/SequentialExecutor$WorkerRunningState.class */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequentialExecutor(Executor executor) {
        this.executor = (Executor) Preconditions.checkNotNull(executor);
    }

    static /* synthetic */ long access$308(SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.workerRunCount;
        sequentialExecutor.workerRunCount = 1 + j;
        return j;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.queue) {
            if (this.workerRunningState != WorkerRunningState.RUNNING && this.workerRunningState != WorkerRunningState.QUEUED) {
                long j = this.workerRunCount;
                Runnable runnable2 = new Runnable() { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                };
                this.queue.add(runnable2);
                this.workerRunningState = WorkerRunningState.QUEUING;
                boolean z = true;
                try {
                    this.executor.execute(this.worker);
                    if (this.workerRunningState == WorkerRunningState.QUEUING) {
                        z = false;
                    }
                    if (z) {
                        return;
                    }
                    synchronized (this.queue) {
                        if (this.workerRunCount == j && this.workerRunningState == WorkerRunningState.QUEUING) {
                            this.workerRunningState = WorkerRunningState.QUEUED;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.queue) {
                        boolean z2 = (this.workerRunningState == WorkerRunningState.IDLE || this.workerRunningState == WorkerRunningState.QUEUING) && this.queue.removeLastOccurrence(runnable2);
                        if (!(e instanceof RejectedExecutionException) || z2) {
                            throw e;
                        }
                    }
                    return;
                }
            }
            this.queue.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.executor + i.d;
    }
}
