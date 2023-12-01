package java.lang.ref;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ref/SoftReference.class */
public class SoftReference<T> extends Reference<T> {
    public SoftReference(T t) {
        super(t, null);
    }

    public SoftReference(T t, ReferenceQueue<? super T> referenceQueue) {
        super(t, referenceQueue);
    }
}
