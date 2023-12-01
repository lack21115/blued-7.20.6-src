package java.lang.ref;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ref/ReferenceQueue.class */
public class ReferenceQueue<T> {
    private static final int NANOS_PER_MILLI = 1000000;
    public static Reference<?> unenqueued = null;
    private Reference<? extends T> head;
    private Reference<? extends T> tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(Reference<?> reference) {
        synchronized (ReferenceQueue.class) {
            try {
                if (unenqueued == null) {
                    unenqueued = reference;
                } else {
                    Reference<?> reference2 = unenqueued;
                    while (reference2.pendingNext != unenqueued) {
                        reference2 = reference2.pendingNext;
                    }
                    reference2.pendingNext = reference;
                    Reference<?> reference3 = reference;
                    while (reference3.pendingNext != reference) {
                        reference3 = reference3.pendingNext;
                    }
                    reference3.pendingNext = unenqueued;
                }
                ReferenceQueue.class.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(Reference<? extends T> reference) {
        synchronized (this) {
            if (this.tail == null) {
                this.head = reference;
            } else {
                this.tail.queueNext = reference;
            }
            this.tail = reference;
            this.tail.queueNext = reference;
            notify();
        }
    }

    public Reference<? extends T> poll() {
        Reference<? extends T> reference = null;
        synchronized (this) {
            if (this.head != null) {
                reference = this.head;
                if (this.head == this.tail) {
                    this.tail = null;
                    this.head = null;
                } else {
                    this.head = this.head.queueNext;
                }
                reference.queueNext = null;
            }
        }
        return reference;
    }

    public Reference<? extends T> remove() throws InterruptedException {
        return remove(0L);
    }

    public Reference<? extends T> remove(long j) throws InterruptedException {
        Reference<? extends T> poll;
        synchronized (this) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0: " + j);
            }
            if (this.head != null) {
                poll = poll();
            } else if (j == 0 || j > 9223372036854L) {
                do {
                    wait(0L);
                } while (this.head == null);
                poll = poll();
            } else {
                int i = 0;
                long nanoTime = System.nanoTime();
                long j2 = j;
                while (true) {
                    wait(j2, i);
                    if (this.head == null) {
                        long nanoTime2 = (j * 1000000) - (System.nanoTime() - nanoTime);
                        if (nanoTime2 <= 0) {
                            break;
                        }
                        j2 = nanoTime2 / 1000000;
                        i = (int) (nanoTime2 - (1000000 * j2));
                    } else {
                        break;
                    }
                }
                poll = poll();
            }
        }
        return poll;
    }
}
