package java.lang.ref;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ref/FinalizerReference.class */
public final class FinalizerReference<T> extends Reference<T> {
    private FinalizerReference<?> next;
    private FinalizerReference<?> prev;
    private T zombie;
    public static final ReferenceQueue<Object> queue = new ReferenceQueue<>();
    private static final Object LIST_LOCK = new Object();
    private static FinalizerReference<?> head = null;

    /* loaded from: source-2895416-dex2jar.jar:java/lang/ref/FinalizerReference$Sentinel.class */
    private static class Sentinel {
        boolean finalized;

        private Sentinel() {
            this.finalized = false;
        }

        void awaitFinalization() throws InterruptedException {
            synchronized (this) {
                while (!this.finalized) {
                    wait();
                }
            }
        }

        protected void finalize() throws Throwable {
            synchronized (this) {
                if (this.finalized) {
                    throw new AssertionError();
                }
                this.finalized = true;
                notifyAll();
            }
        }
    }

    public FinalizerReference(T t, ReferenceQueue<? super T> referenceQueue) {
        super(t, referenceQueue);
    }

    public static void add(Object obj) {
        FinalizerReference<?> finalizerReference = new FinalizerReference<>(obj, queue);
        synchronized (LIST_LOCK) {
            ((FinalizerReference) finalizerReference).prev = null;
            ((FinalizerReference) finalizerReference).next = head;
            if (head != null) {
                ((FinalizerReference) head).prev = finalizerReference;
            }
            head = finalizerReference;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean enqueueSentinelReference(Sentinel sentinel) {
        synchronized (LIST_LOCK) {
            for (FinalizerReference<?> finalizerReference = head; finalizerReference != null; finalizerReference = ((FinalizerReference) finalizerReference).next) {
                if (finalizerReference.referent == sentinel) {
                    finalizerReference.referent = null;
                    ((FinalizerReference) finalizerReference).zombie = sentinel;
                    if (finalizerReference.makeCircularListIfUnenqueued()) {
                        ReferenceQueue.add(finalizerReference);
                        return true;
                    }
                    return false;
                }
            }
            throw new AssertionError("newly-created live Sentinel not on list!");
        }
    }

    public static void finalizeAllEnqueued() throws InterruptedException {
        Sentinel sentinel;
        do {
            sentinel = new Sentinel();
        } while (!enqueueSentinelReference(sentinel));
        sentinel.awaitFinalization();
    }

    private native boolean makeCircularListIfUnenqueued();

    public static void remove(FinalizerReference<?> finalizerReference) {
        synchronized (LIST_LOCK) {
            FinalizerReference<?> finalizerReference2 = ((FinalizerReference) finalizerReference).next;
            FinalizerReference<?> finalizerReference3 = ((FinalizerReference) finalizerReference).prev;
            ((FinalizerReference) finalizerReference).next = null;
            ((FinalizerReference) finalizerReference).prev = null;
            if (finalizerReference3 != null) {
                ((FinalizerReference) finalizerReference3).next = finalizerReference2;
            } else {
                head = finalizerReference2;
            }
            if (finalizerReference2 != null) {
                ((FinalizerReference) finalizerReference2).prev = finalizerReference3;
            }
        }
    }

    @Override // java.lang.ref.Reference
    public void clear() {
        this.zombie = null;
    }

    @Override // java.lang.ref.Reference
    public T get() {
        return this.zombie;
    }
}
