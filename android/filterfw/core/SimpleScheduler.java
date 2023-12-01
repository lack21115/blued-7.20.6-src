package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/SimpleScheduler.class */
public class SimpleScheduler extends Scheduler {
    public SimpleScheduler(FilterGraph filterGraph) {
        super(filterGraph);
    }

    @Override // android.filterfw.core.Scheduler
    public void reset() {
    }

    @Override // android.filterfw.core.Scheduler
    public Filter scheduleNextNode() {
        for (Filter filter : getGraph().getFilters()) {
            if (filter.canProcess()) {
                return filter;
            }
        }
        return null;
    }
}
