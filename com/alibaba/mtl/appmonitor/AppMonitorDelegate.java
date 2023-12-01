package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.sign.BaseRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitorDelegate.class */
public final class AppMonitorDelegate {
    public static final String DEFAULT_VALUE = "defaultValue";
    public static boolean IS_DEBUG = false;
    public static final String MAX_VALUE = "maxValue";
    public static final String MIN_VALUE = "minValue";
    public static final String TAG = "AppMonitorDelegate";
    private static Application b;
    static volatile boolean i = false;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitorDelegate$Alarm.class */
    public static class Alarm {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.ALARM, str, str2);
        }

        public static void commitFail(String str, String str2, String str3, String str4) {
            commitFail(str, str2, null, str3, str4);
        }

        public static void commitFail(String str, String str2, String str3, String str4, String str5) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.B();
                    HashMap hashMap = new HashMap();
                    hashMap.put("_status", "0");
                    if (!AppMonitorDelegate.i || !com.alibaba.mtl.log.a.a.h() || !f.ALARM.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(str, str2, (Boolean) false, (Map<String, String>) hashMap))) {
                        i.a("log discard !", "");
                        return;
                    }
                    i.a(AppMonitorDelegate.TAG, "commitFail module:", str, " monitorPoint:", str2, " errorCode:", str4, "errorMsg:", str5);
                    com.alibaba.mtl.log.b.a.C();
                    e.a().a(f.ALARM.m2139a(), str, str2, str3, str4, str5);
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m2144a(th);
            }
        }

        public static void commitSuccess(String str, String str2) {
            commitSuccess(str, str2, null);
        }

        public static void commitSuccess(String str, String str2, String str3) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.B();
                    if (!AppMonitorDelegate.i || !com.alibaba.mtl.log.a.a.h() || !f.ALARM.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(str, str2, (Boolean) true, (Map<String, String>) null))) {
                        i.a("log discard !", "");
                        return;
                    }
                    i.a(AppMonitorDelegate.TAG, "commitSuccess module:", str, " monitorPoint:", str2);
                    com.alibaba.mtl.log.b.a.C();
                    e.a().a(f.ALARM.m2139a(), str, str2, str3);
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m2144a(th);
            }
        }

        public static void setSampling(int i) {
            j.a().a(f.ALARM, i);
        }

        public static void setStatisticsInterval(int i) {
            f.ALARM.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.ALARM, i);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitorDelegate$Counter.class */
    public static class Counter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, null, d);
        }

        public static void commit(String str, String str2, String str3, double d) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.z();
                    if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.h() && f.COUNTER.isOpen()) {
                        if (AppMonitorDelegate.IS_DEBUG || j.a(f.COUNTER, str, str2)) {
                            i.a(AppMonitorDelegate.TAG, "commitCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                            com.alibaba.mtl.log.b.a.A();
                            e.a().a(f.COUNTER.m2139a(), str, str2, str3, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m2144a(th);
            }
        }

        public static void setSampling(int i) {
            j.a().a(f.COUNTER, i);
        }

        public static void setStatisticsInterval(int i) {
            f.COUNTER.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.COUNTER, i);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitorDelegate$OffLineCounter.class */
    public static class OffLineCounter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.OFFLINE_COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.x();
                    if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.h() && f.OFFLINE_COUNTER.isOpen()) {
                        if (AppMonitorDelegate.IS_DEBUG || j.a(f.OFFLINE_COUNTER, str, str2)) {
                            i.a(AppMonitorDelegate.TAG, "commitOffLineCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                            com.alibaba.mtl.log.b.a.y();
                            e.a().a(f.OFFLINE_COUNTER.m2139a(), str, str2, (String) null, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m2144a(th);
            }
        }

        public static void setSampling(int i) {
            j.a().a(f.OFFLINE_COUNTER, i);
        }

        public static void setStatisticsInterval(int i) {
            f.OFFLINE_COUNTER.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.OFFLINE_COUNTER, i);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitorDelegate$Stat.class */
    public static class Stat {
        public static void begin(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.h() && f.STAT.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, str, str2)) {
                        i.a(AppMonitorDelegate.TAG, "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        e.a().a(Integer.valueOf(f.STAT.m2139a()), str, str2, str3);
                    }
                }
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m2144a(th);
            }
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.STAT, str, str2);
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, (DimensionValueSet) null, d);
        }

        public static void commit(String str, String str2, DimensionValueSet dimensionValueSet, double d) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.v();
                    if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.h() && f.STAT.isOpen()) {
                        if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, str, str2)) {
                            i.a(AppMonitorDelegate.TAG, "statEvent commit. module: ", str, " monitorPoint: ", str2);
                            Metric metric = MetricRepo.getRepo().getMetric(str, str2);
                            com.alibaba.mtl.log.b.a.w();
                            if (metric != null) {
                                List<Measure> measures = metric.getMeasureSet().getMeasures();
                                if (measures.size() == 1) {
                                    commit(str, str2, dimensionValueSet, ((MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0])).setValue(measures.get(0).getName(), d));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m2144a(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
            if (com.alibaba.mtl.appmonitor.d.j.a(com.alibaba.mtl.appmonitor.a.f.STAT, r7, r8, r9 != null ? r9.getMap() : null) != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void commit(java.lang.String r7, java.lang.String r8, com.alibaba.mtl.appmonitor.model.DimensionValueSet r9, com.alibaba.mtl.appmonitor.model.MeasureValueSet r10) {
            /*
                r0 = r7
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La4
                if (r0 != 0) goto L9c
                r0 = r8
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La4
                if (r0 == 0) goto L11
                goto L9c
            L11:
                com.alibaba.mtl.log.b.a.v()     // Catch: java.lang.Throwable -> La4
                boolean r0 = com.alibaba.mtl.appmonitor.AppMonitorDelegate.i     // Catch: java.lang.Throwable -> La4
                r11 = r0
                r0 = r11
                if (r0 == 0) goto L80
                boolean r0 = com.alibaba.mtl.log.a.a.h()     // Catch: java.lang.Throwable -> La4
                if (r0 == 0) goto L80
                com.alibaba.mtl.appmonitor.a.f r0 = com.alibaba.mtl.appmonitor.a.f.STAT     // Catch: java.lang.Throwable -> La4
                boolean r0 = r0.isOpen()     // Catch: java.lang.Throwable -> La4
                if (r0 == 0) goto L80
                boolean r0 = com.alibaba.mtl.appmonitor.AppMonitorDelegate.IS_DEBUG     // Catch: java.lang.Throwable -> La4
                if (r0 != 0) goto L51
                com.alibaba.mtl.appmonitor.a.f r0 = com.alibaba.mtl.appmonitor.a.f.STAT     // Catch: java.lang.Throwable -> La4
                r13 = r0
                r0 = r9
                if (r0 == 0) goto Laa
                r0 = r9
                java.util.Map r0 = r0.getMap()     // Catch: java.lang.Throwable -> La4
                r12 = r0
                goto L45
            L45:
                r0 = r13
                r1 = r7
                r2 = r8
                r3 = r12
                boolean r0 = com.alibaba.mtl.appmonitor.d.j.a(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> La4
                if (r0 == 0) goto L80
            L51:
                java.lang.String r0 = "statEvent commit success"
                r1 = 4
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 0
                java.lang.String r4 = "statEvent commit. module: "
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 2
                java.lang.String r4 = " monitorPoint: "
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 3
                r4 = r8
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                com.alibaba.mtl.log.e.i.a(r0, r1)     // Catch: java.lang.Throwable -> La4
                com.alibaba.mtl.log.b.a.w()     // Catch: java.lang.Throwable -> La4
                com.alibaba.mtl.appmonitor.a.e r0 = com.alibaba.mtl.appmonitor.a.e.a()     // Catch: java.lang.Throwable -> La4
                com.alibaba.mtl.appmonitor.a.f r1 = com.alibaba.mtl.appmonitor.a.f.STAT     // Catch: java.lang.Throwable -> La4
                int r1 = r1.m2139a()     // Catch: java.lang.Throwable -> La4
                r2 = r7
                r3 = r8
                r4 = r10
                r5 = r9
                r0.a(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La4
                return
            L80:
                java.lang.String r0 = "statEvent commit failed,log discard"
                r1 = 4
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 0
                java.lang.String r4 = " ,. module: "
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 2
                java.lang.String r4 = " monitorPoint: "
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                r2 = r1
                r3 = 3
                r4 = r8
                r2[r3] = r4     // Catch: java.lang.Throwable -> La4
                com.alibaba.mtl.log.e.i.a(r0, r1)     // Catch: java.lang.Throwable -> La4
                return
            L9c:
                java.lang.String r0 = "AppMonitorDelegate"
                java.lang.String r1 = "module & monitorPoint must not null"
                com.alibaba.mtl.log.e.i.a(r0, r1)     // Catch: java.lang.Throwable -> La4
                return
            La4:
                r7 = move-exception
                r0 = r7
                com.alibaba.mtl.appmonitor.b.b.m2144a(r0)
                return
            Laa:
                r0 = 0
                r12 = r0
                goto L45
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitorDelegate.Stat.commit(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet):void");
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(f.STAT.m2139a()), str, str2, dimensionValueSet);
        }

        public static void end(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.h() && f.STAT.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, str, str2)) {
                        i.a(AppMonitorDelegate.TAG, "statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        e.a().a(str, str2, str3);
                    }
                }
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m2144a(th);
            }
        }

        public static void setSampling(int i) {
            j.a().a(f.STAT, i);
        }

        public static void setStatisticsInterval(int i) {
            f.STAT.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.STAT, i);
        }
    }

    public static void destroy() {
        synchronized (AppMonitorDelegate.class) {
            try {
                i.a(TAG, "start destory");
                if (i) {
                    c.e();
                    c.destroy();
                    b.destroy();
                    if (b != null) {
                        l.b(b.getApplicationContext());
                    }
                    i = false;
                }
            } catch (Throwable th) {
                try {
                    com.alibaba.mtl.appmonitor.b.b.m2144a(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void enableLog(boolean z) {
        i.a(TAG, "[enableLog]");
        i.d(z);
    }

    public static void init(Application application) {
        synchronized (AppMonitorDelegate.class) {
            try {
                i.a(TAG, "start init");
                if (!i) {
                    b = application;
                    com.alibaba.mtl.log.a.init(application.getApplicationContext());
                    b.init();
                    c.init();
                    a.init(application);
                    l.a(application.getApplicationContext());
                    i = true;
                }
            } finally {
            }
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet) {
        register(str, str2, measureSet, (DimensionSet) null);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        register(str, str2, measureSet, dimensionSet, false);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (i) {
                if (!com.alibaba.mtl.appmonitor.f.b.isBlank(str) && !com.alibaba.mtl.appmonitor.f.b.isBlank(str2)) {
                    MetricRepo.getRepo().add(new Metric(str, str2, measureSet, dimensionSet, z));
                    return;
                }
                i.a(TAG, "register stat event. module: ", str, " monitorPoint: ", str2);
                if (IS_DEBUG) {
                    throw new com.alibaba.mtl.appmonitor.b.a("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m2144a(th);
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet, boolean z) {
        register(str, str2, measureSet, null, z);
    }

    public static void setChannel(String str) {
        com.alibaba.mtl.log.a.setChannel(str);
    }

    public static void setRequestAuthInfo(boolean z, String str, String str2, String str3) {
        com.alibaba.mtl.log.a.a(z ? new SecurityRequestAuth(str, str3) : new BaseRequestAuth(str, str2));
        com.alibaba.mtl.log.a.a.init(b);
    }

    public static void setSampling(int i2) {
        f[] values;
        i.a(TAG, "[setSampling]");
        for (f fVar : f.values()) {
            fVar.c(i2);
            j.a().a(fVar, i2);
        }
    }

    public static void setStatisticsInterval(int i2) {
        f[] values = f.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            f fVar = values[i4];
            fVar.setStatisticsInterval(i2);
            setStatisticsInterval(fVar, i2);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setStatisticsInterval(f fVar, int i2) {
        try {
            if (!i || fVar == null) {
                return;
            }
            c.a(fVar.m2139a(), i2);
            if (i2 > 0) {
                fVar.b(true);
            } else {
                fVar.b(false);
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m2144a(th);
        }
    }

    public static void triggerUpload() {
        synchronized (AppMonitorDelegate.class) {
            try {
                i.a(TAG, "triggerUpload");
                if (i && com.alibaba.mtl.log.a.a.h()) {
                    c.e();
                }
            } catch (Throwable th) {
                try {
                    com.alibaba.mtl.appmonitor.b.b.m2144a(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void turnOffRealTimeDebug() {
        i.a(TAG, "[turnOffRealTimeDebug]");
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        com.alibaba.mtl.log.a.a.turnOnRealTimeDebug(map);
    }

    public static void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) {
        Metric metric;
        i.a(TAG, "[updateMeasure]");
        try {
            if (!i || com.alibaba.mtl.appmonitor.f.b.isBlank(str) || com.alibaba.mtl.appmonitor.f.b.isBlank(str2) || (metric = MetricRepo.getRepo().getMetric(str, str2)) == null || metric.getMeasureSet() == null) {
                return;
            }
            metric.getMeasureSet().upateMeasure(new Measure(str3, Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
        } catch (Exception e) {
        }
    }
}
