package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/stats/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static HiAnalyticsInstance f9261a;

    public static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f9261a = analyticsInstance;
        return analyticsInstance;
    }

    public static void a(Context context, int i) {
        if (a(context) != null) {
            f9261a.onReport(i);
        }
    }

    public static void a(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f9261a.onEvent(i, str, linkedHashMap);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (a(context) != null) {
            f9261a.onEvent(context, str, str2);
        }
    }

    public static void b(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f9261a.onStreamEvent(i, str, linkedHashMap);
        }
    }
}
