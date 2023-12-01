package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/RecursiveAction.class */
public abstract class RecursiveAction extends ForkJoinTask<Void> {
    private static final long serialVersionUID = 5232453952276485070L;

    protected abstract void compute();

    @Override // java.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        compute();
        return true;
    }

    @Override // java.util.concurrent.ForkJoinTask
    public final Void getRawResult() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.ForkJoinTask
    public final void setRawResult(Void r2) {
    }
}
