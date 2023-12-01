package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Object.class */
public class Object {
    private transient Class<?> shadow$_klass_;
    private transient int shadow$_monitor_;

    private native Object internalClone();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return internalClone();
        }
        throw new CloneNotSupportedException("Class " + getClass().getName() + " doesn't implement Cloneable");
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @FindBugsSuppressWarnings({"FI_EMPTY"})
    public void finalize() throws Throwable {
    }

    public final Class<?> getClass() {
        return this.shadow$_klass_;
    }

    public int hashCode() {
        int i = this.shadow$_monitor_;
        return ((-1073741824) & i) == Integer.MIN_VALUE ? 1073741823 & i : System.identityHashCode(this);
    }

    public final native void notify();

    public final native void notifyAll();

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }

    public final native void wait() throws InterruptedException;

    public final void wait(long j) throws InterruptedException {
        wait(j, 0);
    }

    public final native void wait(long j, int i) throws InterruptedException;
}
