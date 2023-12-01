package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/Scheduler.class */
public abstract class Scheduler {
    private FilterGraph mGraph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scheduler(FilterGraph filterGraph) {
        this.mGraph = filterGraph;
    }

    boolean finished() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilterGraph getGraph() {
        return this.mGraph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void reset();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Filter scheduleNextNode();
}
