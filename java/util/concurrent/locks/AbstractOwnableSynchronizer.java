package java.util.concurrent.locks;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/AbstractOwnableSynchronizer.class */
public abstract class AbstractOwnableSynchronizer implements Serializable {
    private static final long serialVersionUID = 3737899427754241961L;
    private transient Thread exclusiveOwnerThread;

    /* JADX INFO: Access modifiers changed from: protected */
    public final Thread getExclusiveOwnerThread() {
        return this.exclusiveOwnerThread;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setExclusiveOwnerThread(Thread thread) {
        this.exclusiveOwnerThread = thread;
    }
}
