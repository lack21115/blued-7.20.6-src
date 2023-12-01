package com.blued.android.modules;

import com.blued.android.module.base.data_statistics.IStatistics;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.soft.blued.log.InstantLog;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/StatisticsModule.class */
public class StatisticsModule {

    /* renamed from: a  reason: collision with root package name */
    protected static IStatistics f18642a = new IStatistics() { // from class: com.blued.android.modules.StatisticsModule.1
        @Override // com.blued.android.module.base.data_statistics.IStatistics
        public void a(int i, String str, int i2) {
        }

        @Override // com.blued.android.module.base.data_statistics.IStatistics
        public void a(String str) {
            InstantLog.a(str);
        }

        @Override // com.blued.android.module.base.data_statistics.IStatistics
        public void a(String str, int i) {
            InstantLog.b(str, i);
        }

        @Override // com.blued.android.module.base.data_statistics.IStatistics
        public void a(String str, Object obj) {
            InstantLog.a(str, obj);
        }

        @Override // com.blued.android.module.base.data_statistics.IStatistics
        public void a(String str, String str2) {
            InstantLog.f(str, str2);
        }
    };

    public static void a() {
        StatisticsProxy.a().a((StatisticsProxy) f18642a);
    }
}
