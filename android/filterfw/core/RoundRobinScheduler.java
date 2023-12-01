package android.filterfw.core;

import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/RoundRobinScheduler.class */
public class RoundRobinScheduler extends Scheduler {
    private int mLastPos;

    public RoundRobinScheduler(FilterGraph filterGraph) {
        super(filterGraph);
        this.mLastPos = -1;
    }

    @Override // android.filterfw.core.Scheduler
    public void reset() {
        this.mLastPos = -1;
    }

    @Override // android.filterfw.core.Scheduler
    public Filter scheduleNextNode() {
        Set<Filter> filters = getGraph().getFilters();
        if (this.mLastPos >= filters.size()) {
            this.mLastPos = -1;
        }
        int i = 0;
        Filter filter = null;
        int i2 = -1;
        for (Filter filter2 : filters) {
            Filter filter3 = filter;
            int i3 = i2;
            if (filter2.canProcess()) {
                if (i > this.mLastPos) {
                    this.mLastPos = i;
                    return filter2;
                }
                filter3 = filter;
                i3 = i2;
                if (filter == null) {
                    filter3 = filter2;
                    i3 = i;
                }
            }
            i++;
            filter = filter3;
            i2 = i3;
        }
        if (filter != null) {
            this.mLastPos = i2;
            return filter;
        }
        return null;
    }
}
