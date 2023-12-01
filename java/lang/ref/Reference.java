package java.lang.ref;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ref/Reference.class */
public abstract class Reference<T> {
    private static boolean disableIntrinsic = false;
    private static boolean slowPathEnabled = false;
    public volatile Reference<?> pendingNext;
    volatile ReferenceQueue<? super T> queue;
    volatile Reference queueNext;
    volatile T referent;

    Reference() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Reference(T t, ReferenceQueue<? super T> referenceQueue) {
        this.referent = t;
        this.queue = referenceQueue;
    }

    private final native T getReferent();

    public void clear() {
        this.referent = null;
    }

    public boolean enqueue() {
        return enqueueInternal();
    }

    public final boolean enqueueInternal() {
        boolean z;
        synchronized (this) {
            if (this.queue == null || this.queueNext != null) {
                z = false;
            } else {
                this.queue.enqueue(this);
                this.queue = null;
                z = true;
            }
        }
        return z;
    }

    public T get() {
        return getReferent();
    }

    public boolean isEnqueued() {
        return this.queueNext != null;
    }
}
