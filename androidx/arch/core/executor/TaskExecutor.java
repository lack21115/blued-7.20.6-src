package androidx.arch.core.executor;

/* loaded from: source-8756600-dex2jar.jar:androidx/arch/core/executor/TaskExecutor.class */
public abstract class TaskExecutor {
    public abstract void executeOnDiskIO(Runnable runnable);

    public void executeOnMainThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            postToMainThread(runnable);
        }
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(Runnable runnable);
}
