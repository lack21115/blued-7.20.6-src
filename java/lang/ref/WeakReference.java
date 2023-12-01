package java.lang.ref;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ref/WeakReference.class */
public class WeakReference<T> extends Reference<T> {
    public WeakReference(T t) {
        super(t, null);
    }

    public WeakReference(T t, ReferenceQueue<? super T> referenceQueue) {
        super(t, referenceQueue);
    }
}
