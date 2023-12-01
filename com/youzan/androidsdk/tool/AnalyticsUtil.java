package com.youzan.androidsdk.tool;

import android.content.Context;
import com.youzan.androidsdk.YouzanLog;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/AnalyticsUtil.class */
public class AnalyticsUtil {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean f1109 = false;

    public static void doStatistic(Context context, String str, String str2, Map<String, String> map) {
    }

    public static void initAnalytics(Context context, String str) {
        if (f1109) {
            return;
        }
        try {
            f1109 = true;
        } catch (Exception e) {
            YouzanLog.e("initAnalytics exception" + e);
        }
    }

    public static void statisticWebviewInit(Context context) {
    }

    public static void statisticWebviewLoadPage(Context context, String str) {
    }
}
