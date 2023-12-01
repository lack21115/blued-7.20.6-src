package java.lang;

import java.lang.ThreadLocal;

/* loaded from: source-2895416-dex2jar.jar:java/lang/InheritableThreadLocal.class */
public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public T childValue(T t) {
        return t;
    }

    @Override // java.lang.ThreadLocal
    ThreadLocal.Values initializeValues(Thread thread) {
        ThreadLocal.Values values = new ThreadLocal.Values();
        thread.inheritableValues = values;
        return values;
    }

    @Override // java.lang.ThreadLocal
    ThreadLocal.Values values(Thread thread) {
        return thread.inheritableValues;
    }
}
