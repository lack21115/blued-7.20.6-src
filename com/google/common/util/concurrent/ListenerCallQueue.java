package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/ListenerCallQueue.class */
public final class ListenerCallQueue<L> {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/ListenerCallQueue$Event.class */
    public interface Event<L> {
        void call(L l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/ListenerCallQueue$PerListenerQueue.class */
    public static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final L listener;
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();
        final Queue<Object> labelQueue = Queues.newArrayDeque();

        PerListenerQueue(L l, Executor executor) {
            this.listener = (L) Preconditions.checkNotNull(l);
            this.executor = (Executor) Preconditions.checkNotNull(executor);
        }

        void add(Event<L> event, Object obj) {
            synchronized (this) {
                this.waitQueue.add(event);
                this.labelQueue.add(obj);
            }
        }

        void dispatch() {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.isThreadScheduled) {
                    z = false;
                } else {
                    this.isThreadScheduled = true;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        Logger logger = ListenerCallQueue.logger;
                        logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
            r0.call(r5.listener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
            com.google.common.util.concurrent.ListenerCallQueue.logger.log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r5.listener + " " + r0, (java.lang.Throwable) r8);
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
            L0:
                r0 = 1
                r6 = r0
                r0 = r5
                monitor-enter(r0)     // Catch: java.lang.Throwable -> L97
                r0 = r5
                boolean r0 = r0.isThreadScheduled     // Catch: java.lang.Throwable -> L88
                com.google.common.base.Preconditions.checkState(r0)     // Catch: java.lang.Throwable -> L88
                r0 = r5
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r0 = r0.waitQueue     // Catch: java.lang.Throwable -> L88
                java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L88
                com.google.common.util.concurrent.ListenerCallQueue$Event r0 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r0     // Catch: java.lang.Throwable -> L88
                r8 = r0
                r0 = r5
                java.util.Queue<java.lang.Object> r0 = r0.labelQueue     // Catch: java.lang.Throwable -> L88
                java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L88
                r7 = r0
                r0 = r8
                if (r0 != 0) goto L34
                r0 = r5
                r1 = 0
                r0.isThreadScheduled = r1     // Catch: java.lang.Throwable -> L88
                r0 = r5
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
                return
            L2e:
                r7 = move-exception
                r0 = 0
                r6 = r0
                goto L8b
            L34:
                r0 = r5
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L88
                r0 = r8
                r1 = r5
                L r1 = r1.listener     // Catch: java.lang.RuntimeException -> L43 java.lang.Throwable -> L97
                r0.call(r1)     // Catch: java.lang.RuntimeException -> L43 java.lang.Throwable -> L97
                goto L0
            L43:
                r8 = move-exception
                java.util.logging.Logger r0 = com.google.common.util.concurrent.ListenerCallQueue.access$000()     // Catch: java.lang.Throwable -> L97
                r9 = r0
                java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L97
                r10 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
                r1 = r0
                r1.<init>()     // Catch: java.lang.Throwable -> L97
                r11 = r0
                r0 = r11
                java.lang.String r1 = "Exception while executing callback: "
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L97
                r0 = r11
                r1 = r5
                L r1 = r1.listener     // Catch: java.lang.Throwable -> L97
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L97
                r0 = r11
                java.lang.String r1 = " "
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L97
                r0 = r11
                r1 = r7
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L97
                r0 = r9
                r1 = r10
                r2 = r11
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L97
                r3 = r8
                r0.log(r1, r2, r3)     // Catch: java.lang.Throwable -> L97
                goto L0
            L88:
                r7 = move-exception
                r0 = 1
                r6 = r0
            L8b:
                r0 = r5
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
                r0 = r7
                throw r0     // Catch: java.lang.Throwable -> L8f
            L8f:
                r7 = move-exception
                goto L98
            L93:
                r7 = move-exception
                goto L8b
            L97:
                r7 = move-exception
            L98:
                r0 = r6
                if (r0 == 0) goto Lad
                r0 = r5
                monitor-enter(r0)
                r0 = r5
                r1 = 0
                r0.isThreadScheduled = r1     // Catch: java.lang.Throwable -> La8
                r0 = r5
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                goto Lad
            La8:
                r7 = move-exception
                r0 = r5
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                r0 = r7
                throw r0
            Lad:
                r0 = r7
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, "event");
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            for (PerListenerQueue<L> perListenerQueue : this.listeners) {
                perListenerQueue.add(event, obj);
            }
        }
    }

    public void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue<>(l, executor));
    }

    public void dispatch() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.listeners.size()) {
                return;
            }
            this.listeners.get(i2).dispatch();
            i = i2 + 1;
        }
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }
}
