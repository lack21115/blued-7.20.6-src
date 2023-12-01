package com.tencent.cloud.huiyansdkface.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/AsyncTimeout.class */
public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/AsyncTimeout$Watchdog.class */
    public static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
            r0.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L30
                com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.awaitTimeout()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L30
                r4 = r0
                r0 = r4
                if (r0 != 0) goto L11
                java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
                goto L0
            L11:
                r0 = r4
                com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L2a
                if (r0 != r1) goto L20
                r0 = 0
                com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head = r0     // Catch: java.lang.Throwable -> L2a
                java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
                return
            L20:
                java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
                r0 = r4
                r0.timedOut()     // Catch: java.lang.InterruptedException -> L30
                goto L0
            L2a:
                r4 = move-exception
                java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
                r0 = r4
                throw r0     // Catch: java.lang.InterruptedException -> L30
            L30:
                r4 = move-exception
                goto L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout asyncTimeout = head.next;
        long nanoTime = System.nanoTime();
        if (asyncTimeout == null) {
            AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            AsyncTimeout asyncTimeout2 = null;
            if (head.next == null) {
                asyncTimeout2 = null;
                if (System.nanoTime() - nanoTime >= IDLE_TIMEOUT_NANOS) {
                    asyncTimeout2 = head;
                }
            }
            return asyncTimeout2;
        }
        long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            AsyncTimeout.class.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        r5.next = r3.next;
        r3.next = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean cancelScheduledTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r3) {
        /*
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-enter(r0)
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L34
            r5 = r0
        L7:
            r0 = r5
            if (r0 == 0) goto L2f
            r0 = r5
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = r0.next     // Catch: java.lang.Throwable -> L34
            r1 = r3
            if (r0 != r1) goto L27
            r0 = r5
            r1 = r3
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = r1.next     // Catch: java.lang.Throwable -> L34
            r0.next = r1     // Catch: java.lang.Throwable -> L34
            r0 = r3
            r1 = 0
            r0.next = r1     // Catch: java.lang.Throwable -> L34
            r0 = 0
            r4 = r0
        L22:
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-exit(r0)
            r0 = r4
            return r0
        L27:
            r0 = r5
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = r0.next     // Catch: java.lang.Throwable -> L34
            r5 = r0
            goto L7
        L2f:
            r0 = 1
            r4 = r0
            goto L22
        L34:
            r3 = move-exception
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-exit(r0)
            r0 = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.cancelScheduledTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout):boolean");
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009a A[Catch: all -> 0x00ab, TryCatch #0 {all -> 0x00ab, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x001d, B:7:0x001d, B:13:0x0030, B:15:0x003d, B:20:0x0054, B:22:0x0061, B:24:0x0067, B:27:0x0079, B:28:0x0083, B:30:0x009a, B:18:0x004b, B:34:0x00a3, B:35:0x00aa), top: B:44:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void scheduleTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r7, long r8, boolean r10) {
        /*
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-enter(r0)
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> Lab
            if (r0 != 0) goto L1d
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = new com.tencent.cloud.huiyansdkface.okio.AsyncTimeout     // Catch: java.lang.Throwable -> Lab
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lab
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head = r0     // Catch: java.lang.Throwable -> Lab
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout$Watchdog r0 = new com.tencent.cloud.huiyansdkface.okio.AsyncTimeout$Watchdog     // Catch: java.lang.Throwable -> Lab
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lab
            r0.start()     // Catch: java.lang.Throwable -> Lab
        L1d:
            long r0 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> Lab java.lang.Throwable -> Lab
            r12 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r11 = r0
            r0 = r11
            if (r0 == 0) goto Lb1
            r0 = r10
            if (r0 == 0) goto Lb1
            r0 = r8
            r1 = r7
            long r1 = r1.deadlineNanoTime()     // Catch: java.lang.Throwable -> Lab
            r2 = r12
            long r1 = r1 - r2
            long r0 = java.lang.Math.min(r0, r1)     // Catch: java.lang.Throwable -> Lab
            r8 = r0
        L3c:
            r0 = r7
            r1 = r8
            r2 = r12
            long r1 = r1 + r2
            r0.timeoutAt = r1     // Catch: java.lang.Throwable -> Lab
            goto L53
        L47:
            r0 = r10
            if (r0 == 0) goto La3
            r0 = r7
            r1 = r7
            long r1 = r1.deadlineNanoTime()     // Catch: java.lang.Throwable -> Lab
            r0.timeoutAt = r1     // Catch: java.lang.Throwable -> Lab
        L53:
            r0 = r7
            r1 = r12
            long r0 = r0.remainingNanos(r1)     // Catch: java.lang.Throwable -> Lab
            r8 = r0
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> Lab
            r14 = r0
        L5f:
            r0 = r14
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = r0.next     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L83
            r0 = r8
            r1 = r14
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = r1.next     // Catch: java.lang.Throwable -> Lab
            r2 = r12
            long r1 = r1.remainingNanos(r2)     // Catch: java.lang.Throwable -> Lab
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L79
            goto L83
        L79:
            r0 = r14
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r0 = r0.next     // Catch: java.lang.Throwable -> Lab
            r14 = r0
            goto L5f
        L83:
            r0 = r7
            r1 = r14
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = r1.next     // Catch: java.lang.Throwable -> Lab
            r0.next = r1     // Catch: java.lang.Throwable -> Lab
            r0 = r14
            r1 = r7
            r0.next = r1     // Catch: java.lang.Throwable -> Lab
            r0 = r14
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> Lab
            if (r0 != r1) goto L9f
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            r0.notify()     // Catch: java.lang.Throwable -> Lab
        L9f:
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-exit(r0)
            return
        La3:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> Lab
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lab
            throw r0     // Catch: java.lang.Throwable -> Lab
        Lab:
            r7 = move-exception
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-exit(r0)
            r0 = r7
            throw r0
        Lb1:
            r0 = r11
            if (r0 == 0) goto L47
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.scheduleTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout, long, boolean):void");
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    final IOException exit(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final boolean exit() {
        if (this.inQueue) {
            this.inQueue = false;
            return cancelScheduledTimeout(this);
        }
        return false;
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        return new Sink() { // from class: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.1
            @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.exit(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.exit(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                long j2;
                Util.checkOffsetAndCount(buffer.size, 0L, j);
                while (true) {
                    long j3 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment = buffer.head;
                    while (true) {
                        Segment segment2 = segment;
                        j2 = j3;
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += segment2.limit - segment2.pos;
                        if (j3 >= j) {
                            j2 = j;
                            break;
                        }
                        segment = segment2.next;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j2);
                            j -= j2;
                            AsyncTimeout.this.exit(true);
                        } catch (IOException e) {
                            throw AsyncTimeout.this.exit(e);
                        }
                    } catch (Throwable th) {
                        AsyncTimeout.this.exit(false);
                        throw th;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() { // from class: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.2
            @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.exit(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        long read = source.read(buffer, j);
                        AsyncTimeout.this.exit(true);
                        return read;
                    } catch (IOException e) {
                        throw AsyncTimeout.this.exit(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Source
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    protected void timedOut() {
    }
}
