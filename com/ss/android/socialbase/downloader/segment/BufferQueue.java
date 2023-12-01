package com.ss.android.socialbase.downloader.segment;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/BufferQueue.class */
class BufferQueue implements IBufferPool, IInput, IOutput {
    private static final int MIN_BUFFER_COUNT = 64;
    private static final int MIN_BUFFER_SIZE = 8192;
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final int maxBufferCount;
    private Buffer rHead;
    private Buffer rSafe;
    private Buffer rTail;
    private Buffer wHead;
    private Buffer wTail;
    private final Object wLock = new Object();
    private final Object rLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BufferQueue(int i, int i2) {
        int i3 = i < 64 ? 64 : i;
        int i4 = i2 < 8192 ? 8192 : i2;
        this.maxBufferCount = i3;
        this.bufferSize = i4;
    }

    public void close() {
        this.closed = true;
        synchronized (this.wLock) {
            this.wLock.notifyAll();
        }
        synchronized (this.rLock) {
            this.rLock.notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0072 A[Catch: all -> 0x008a, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000e, B:9:0x0019, B:11:0x0024, B:12:0x003b, B:15:0x003e, B:17:0x004c, B:20:0x0058, B:21:0x0061, B:23:0x0063, B:25:0x0072, B:27:0x0078, B:28:0x007d, B:31:0x0080, B:32:0x0089), top: B:38:0x0007 }] */
    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ss.android.socialbase.downloader.segment.Buffer obtain() throws com.ss.android.socialbase.downloader.segment.StreamClosedException, java.lang.InterruptedException {
        /*
            r4 = this;
            r0 = r4
            java.lang.Object r0 = r0.wLock
            r7 = r0
            r0 = r7
            monitor-enter(r0)
            r0 = r4
            boolean r0 = r0.closed     // Catch: java.lang.Throwable -> L8a
            if (r0 != 0) goto L80
            r0 = r4
            com.ss.android.socialbase.downloader.segment.Buffer r0 = r0.wHead     // Catch: java.lang.Throwable -> L8a
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            if (r0 != 0) goto L62
            r0 = r4
            int r0 = r0.bufferCount     // Catch: java.lang.Throwable -> L8a
            r1 = r4
            int r1 = r1.maxBufferCount     // Catch: java.lang.Throwable -> L8a
            if (r0 >= r1) goto L3e
            r0 = r4
            r1 = r4
            int r1 = r1.bufferCount     // Catch: java.lang.Throwable -> L8a
            r2 = 1
            int r1 = r1 + r2
            r0.bufferCount = r1     // Catch: java.lang.Throwable -> L8a
            com.ss.android.socialbase.downloader.segment.Buffer r0 = new com.ss.android.socialbase.downloader.segment.Buffer     // Catch: java.lang.Throwable -> L8a
            r1 = r0
            r2 = r4
            int r2 = r2.bufferSize     // Catch: java.lang.Throwable -> L8a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8a
            r5 = r0
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8a
            r0 = r5
            return r0
        L3e:
            r0 = r4
            java.lang.Object r0 = r0.wLock     // Catch: java.lang.Throwable -> L8a
            r0.wait()     // Catch: java.lang.Throwable -> L8a
            r0 = r4
            boolean r0 = r0.closed     // Catch: java.lang.Throwable -> L8a
            if (r0 != 0) goto L58
            r0 = r4
            com.ss.android.socialbase.downloader.segment.Buffer r0 = r0.wHead     // Catch: java.lang.Throwable -> L8a
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L3e
            goto L62
        L58:
            com.ss.android.socialbase.downloader.segment.StreamClosedException r0 = new com.ss.android.socialbase.downloader.segment.StreamClosedException     // Catch: java.lang.Throwable -> L8a
            r1 = r0
            java.lang.String r2 = "obtain"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8a
            throw r0     // Catch: java.lang.Throwable -> L8a
        L62:
            r0 = r4
            r1 = r5
            com.ss.android.socialbase.downloader.segment.Buffer r1 = r1.next     // Catch: java.lang.Throwable -> L8a
            r0.wHead = r1     // Catch: java.lang.Throwable -> L8a
            r0 = r5
            r1 = r4
            com.ss.android.socialbase.downloader.segment.Buffer r1 = r1.wTail     // Catch: java.lang.Throwable -> L8a
            if (r0 != r1) goto L77
            r0 = r4
            r1 = 0
            r0.wTail = r1     // Catch: java.lang.Throwable -> L8a
        L77:
            r0 = r5
            r1 = 0
            r0.next = r1     // Catch: java.lang.Throwable -> L8a
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8a
            r0 = r5
            return r0
        L80:
            com.ss.android.socialbase.downloader.segment.StreamClosedException r0 = new com.ss.android.socialbase.downloader.segment.StreamClosedException     // Catch: java.lang.Throwable -> L8a
            r1 = r0
            java.lang.String r2 = "obtain"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8a
            throw r0     // Catch: java.lang.Throwable -> L8a
        L8a:
            r5 = move-exception
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8a
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.BufferQueue.obtain():com.ss.android.socialbase.downloader.segment.Buffer");
    }

    @Override // com.ss.android.socialbase.downloader.segment.IInput
    public Buffer read() throws StreamClosedException, InterruptedException {
        Buffer buffer;
        Buffer buffer2 = this.rSafe;
        if (buffer2 != null) {
            this.rSafe = buffer2.next;
            buffer2.next = null;
            return buffer2;
        }
        synchronized (this.rLock) {
            buffer = this.rHead;
            while (buffer == null) {
                if (this.closed) {
                    throw new StreamClosedException("read");
                }
                this.rLock.wait();
                buffer = this.rHead;
            }
            this.rSafe = buffer.next;
            this.rTail = null;
            this.rHead = null;
            buffer.next = null;
        }
        return buffer;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    public void recycle(Buffer buffer) {
        synchronized (this.wLock) {
            Buffer buffer2 = this.wTail;
            if (buffer2 == null) {
                this.wTail = buffer;
                this.wHead = buffer;
            } else {
                buffer2.next = buffer;
                this.wTail = buffer;
            }
            this.wLock.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer buffer) {
        synchronized (this.rLock) {
            Buffer buffer2 = this.rTail;
            if (buffer2 == null) {
                this.rTail = buffer;
                this.rHead = buffer;
                this.rLock.notify();
            } else {
                buffer2.next = buffer;
                this.rTail = buffer;
            }
        }
    }
}
