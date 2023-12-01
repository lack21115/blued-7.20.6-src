package android.app.usage;

import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.os.RemoteException;
import android.util.ArrayMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/app/usage/UsageStatsManager.class */
public final class UsageStatsManager {
    public static final int INTERVAL_BEST = 4;
    public static final int INTERVAL_COUNT = 4;
    public static final int INTERVAL_DAILY = 0;
    public static final int INTERVAL_MONTHLY = 2;
    public static final int INTERVAL_WEEKLY = 1;
    public static final int INTERVAL_YEARLY = 3;
    private static final UsageEvents sEmptyResults = new UsageEvents();
    private final Context mContext;
    private final IUsageStatsManager mService;

    public UsageStatsManager(Context context, IUsageStatsManager iUsageStatsManager) {
        this.mContext = context;
        this.mService = iUsageStatsManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.Map] */
    public Map<String, UsageStats> queryAndAggregateUsageStats(long j, long j2) {
        ArrayMap arrayMap;
        List<UsageStats> queryUsageStats = queryUsageStats(4, j, j2);
        if (!queryUsageStats.isEmpty()) {
            ArrayMap arrayMap2 = new ArrayMap();
            int size = queryUsageStats.size();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayMap = arrayMap2;
                if (i2 >= size) {
                    break;
                }
                UsageStats usageStats = queryUsageStats.get(i2);
                UsageStats usageStats2 = (UsageStats) arrayMap2.get(usageStats.getPackageName());
                if (usageStats2 == null) {
                    arrayMap2.put(usageStats.mPackageName, usageStats);
                } else {
                    usageStats2.add(usageStats);
                }
                i = i2 + 1;
            }
        } else {
            arrayMap = Collections.emptyMap();
        }
        return arrayMap;
    }

    public List<ConfigurationStats> queryConfigurations(int i, long j, long j2) {
        try {
            ParceledListSlice queryConfigurationStats = this.mService.queryConfigurationStats(i, j, j2, this.mContext.getOpPackageName());
            if (queryConfigurationStats != null) {
                return queryConfigurationStats.getList();
            }
        } catch (RemoteException e) {
        }
        return Collections.emptyList();
    }

    public UsageEvents queryEvents(long j, long j2) {
        try {
            UsageEvents queryEvents = this.mService.queryEvents(j, j2, this.mContext.getOpPackageName());
            if (queryEvents != null) {
                return queryEvents;
            }
        } catch (RemoteException e) {
        }
        return sEmptyResults;
    }

    public List<UsageStats> queryUsageStats(int i, long j, long j2) {
        try {
            ParceledListSlice queryUsageStats = this.mService.queryUsageStats(i, j, j2, this.mContext.getOpPackageName());
            if (queryUsageStats != null) {
                return queryUsageStats.getList();
            }
        } catch (RemoteException e) {
        }
        return Collections.emptyList();
    }
}
