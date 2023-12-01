package com.blued.android.module.base.data_statistics;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/data_statistics/StatisticsProxy.class */
public class StatisticsProxy extends BaseProxy<IStatistics> implements IStatistics {
    private static StatisticsProxy b;

    private StatisticsProxy() {
    }

    public static StatisticsProxy a() {
        if (b == null) {
            synchronized (StatisticsProxy.class) {
                try {
                    if (b == null) {
                        b = new StatisticsProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.data_statistics.IStatistics
    public void a(int i, String str, int i2) {
        if (this.f10426a != 0) {
            ((IStatistics) this.f10426a).a(i, str, i2);
        }
    }

    @Override // com.blued.android.module.base.data_statistics.IStatistics
    public void a(String str) {
        if (this.f10426a != 0) {
            ((IStatistics) this.f10426a).a(str);
        }
    }

    @Override // com.blued.android.module.base.data_statistics.IStatistics
    public void a(String str, int i) {
        if (this.f10426a != 0) {
            ((IStatistics) this.f10426a).a(str, i);
        }
    }

    @Override // com.blued.android.module.base.data_statistics.IStatistics
    public void a(String str, Object obj) {
        if (this.f10426a != 0) {
            ((IStatistics) this.f10426a).a(str, obj);
        }
    }

    @Override // com.blued.android.module.base.data_statistics.IStatistics
    public void a(String str, String str2) {
        if (this.f10426a != 0) {
            ((IStatistics) this.f10426a).a(str, str2);
        }
    }
}
