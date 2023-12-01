package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/vchannel/Sender.class */
public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    public static final String VCHANNEL_VERSION = "1.0.0";
    private static Map<String, String> customHeader;
    private static long lastTriggerTime;

    public static void handleEvent(Context context, b bVar) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(bh.aS, "1.0.0");
                if (customHeader != null && customHeader.size() > 0) {
                    for (String str : customHeader.keySet()) {
                        jSONObject.put(str, customHeader.get(str));
                    }
                }
            } catch (Throwable th) {
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("analytics", bVar.d());
            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, a.f40970c, "v", "1.0.0");
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007b -> B:24:0x0074). Please submit an issue!!! */
    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
        } else if (TextUtils.isEmpty(str)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
        } else if (map == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
        } else if (!UMFrUtils.isOnline(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
        } else if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
        } else {
            b bVar = new b(context);
            bVar.a(str);
            bVar.a(System.currentTimeMillis());
            bVar.a(map);
            try {
                UMWorkDispatch.sendEvent(context, 32779, com.umeng.commonsdk.internal.b.a(context).a(), bVar);
            } catch (Throwable th) {
            }
            lastTriggerTime = System.currentTimeMillis();
        }
    }

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
