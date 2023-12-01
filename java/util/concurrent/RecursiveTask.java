package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/RecursiveTask.class */
public abstract class RecursiveTask<V> extends ForkJoinTask<V> {
    private static final long serialVersionUID = 5232453952276485270L;
    V result;

    protected abstract V compute();

    @Override // java.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        this.result = compute();
        return true;
    }

    @Override // java.util.concurrent.ForkJoinTask
    public final V getRawResult() {
        return this.result;
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected final void setRawResult(V v) {
        this.result = v;
    }
}
