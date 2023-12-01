package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/stats/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f9262a = new Object();
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9263c = false;

    public static boolean a() {
        boolean z;
        synchronized (f9262a) {
            if (!b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException e) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException e2) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    f9263c = true;
                }
                b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f9263c);
            }
        }
        return f9263c;
    }
}
