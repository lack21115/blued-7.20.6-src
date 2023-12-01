package io.grpc.internal;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/SerializeReentrantCallsDirectExecutor.class */
class SerializeReentrantCallsDirectExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SerializeReentrantCallsDirectExecutor.class.getName());
    private boolean executing;
    private ArrayDeque<Runnable> taskQueue;

    private void completeQueuedTasks() {
        while (true) {
            Runnable poll = this.taskQueue.poll();
            if (poll == null) {
                return;
            }
            try {
                poll.run();
            } catch (Throwable th) {
                Logger logger = log;
                Level level = Level.SEVERE;
                logger.log(level, "Exception while executing runnable " + poll, th);
            }
        }
    }

    private void enqueue(Runnable runnable) {
        if (this.taskQueue == null) {
            this.taskQueue = new ArrayDeque<>(4);
        }
        this.taskQueue.add(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
        if (r5.taskQueue == null) goto L9;
     */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void execute(java.lang.Runnable r6) {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "'task' must not be null."
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0, r1)
            r0 = r5
            boolean r0 = r0.executing
            if (r0 != 0) goto L75
            r0 = r5
            r1 = 1
            r0.executing = r1
            r0 = r6
            r0.run()     // Catch: java.lang.Throwable -> L2a
            r0 = r5
            java.util.ArrayDeque<java.lang.Runnable> r0 = r0.taskQueue
            if (r0 == 0) goto L24
        L20:
            r0 = r5
            r0.completeQueuedTasks()
        L24:
            r0 = r5
            r1 = 0
            r0.executing = r1
            return
        L2a:
            r7 = move-exception
            java.util.logging.Logger r0 = io.grpc.internal.SerializeReentrantCallsDirectExecutor.log     // Catch: java.lang.Throwable -> L62
            r8 = r0
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L62
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L62
            r10 = r0
            r0 = r10
            java.lang.String r1 = "Exception while executing runnable "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L62
            r0 = r10
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L62
            r0 = r8
            r1 = r9
            r2 = r10
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L62
            r3 = r7
            r0.log(r1, r2, r3)     // Catch: java.lang.Throwable -> L62
            r0 = r5
            java.util.ArrayDeque<java.lang.Runnable> r0 = r0.taskQueue
            if (r0 == 0) goto L24
            goto L20
        L62:
            r6 = move-exception
            r0 = r5
            java.util.ArrayDeque<java.lang.Runnable> r0 = r0.taskQueue
            if (r0 == 0) goto L6e
            r0 = r5
            r0.completeQueuedTasks()
        L6e:
            r0 = r5
            r1 = 0
            r0.executing = r1
            r0 = r6
            throw r0
        L75:
            r0 = r5
            r1 = r6
            r0.enqueue(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.SerializeReentrantCallsDirectExecutor.execute(java.lang.Runnable):void");
    }
}
