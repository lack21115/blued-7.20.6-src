package java.lang.ref;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ref/PhantomReference.class */
public class PhantomReference<T> extends Reference<T> {
    public PhantomReference(T t, ReferenceQueue<? super T> referenceQueue) {
        super(t, referenceQueue);
    }

    @Override // java.lang.ref.Reference
    public T get() {
        return null;
    }
}
