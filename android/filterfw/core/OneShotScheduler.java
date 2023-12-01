package android.filterfw.core;

import android.util.Log;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/OneShotScheduler.class */
public class OneShotScheduler extends RoundRobinScheduler {
    private static final String TAG = "OneShotScheduler";
    private final boolean mLogVerbose;
    private HashMap<String, Integer> scheduled;

    public OneShotScheduler(FilterGraph filterGraph) {
        super(filterGraph);
        this.scheduled = new HashMap<>();
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    @Override // android.filterfw.core.RoundRobinScheduler, android.filterfw.core.Scheduler
    public void reset() {
        super.reset();
        this.scheduled.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        return r6;
     */
    @Override // android.filterfw.core.RoundRobinScheduler, android.filterfw.core.Scheduler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.filterfw.core.Filter scheduleNextNode() {
        /*
            r4 = this;
            r0 = 0
            r6 = r0
        L2:
            r0 = r4
            android.filterfw.core.Filter r0 = super.scheduleNextNode()
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L1e
            r0 = r4
            boolean r0 = r0.mLogVerbose
            if (r0 == 0) goto L1a
            java.lang.String r0 = "OneShotScheduler"
            java.lang.String r1 = "No filters available to run."
            int r0 = android.util.Log.v(r0, r1)
        L1a:
            r0 = 0
            r6 = r0
        L1c:
            r0 = r6
            return r0
        L1e:
            r0 = r4
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.scheduled
            r1 = r5
            java.lang.String r1 = r1.getName()
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L76
            r0 = r5
            int r0 = r0.getNumberOfConnectedInputs()
            if (r0 != 0) goto L43
            r0 = r4
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.scheduled
            r1 = r5
            java.lang.String r1 = r1.getName()
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
        L43:
            r0 = r5
            r6 = r0
            r0 = r4
            boolean r0 = r0.mLogVerbose
            if (r0 == 0) goto L1c
            java.lang.String r0 = "OneShotScheduler"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "Scheduling filter \""
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r5
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "\" of type "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r5
            java.lang.String r2 = r2.getFilterClassName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.v(r0, r1)
            r0 = r5
            return r0
        L76:
            r0 = r6
            r1 = r5
            if (r0 != r1) goto L8c
            r0 = r4
            boolean r0 = r0.mLogVerbose
            if (r0 == 0) goto L8a
            java.lang.String r0 = "OneShotScheduler"
            java.lang.String r1 = "One pass through graph completed."
            int r0 = android.util.Log.v(r0, r1)
        L8a:
            r0 = 0
            return r0
        L8c:
            r0 = r6
            if (r0 != 0) goto L2
            r0 = r5
            r6 = r0
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.filterfw.core.OneShotScheduler.scheduleNextNode():android.filterfw.core.Filter");
    }
}
