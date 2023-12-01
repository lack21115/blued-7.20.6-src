package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/statistic/LogBuilder.class */
class LogBuilder {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$sina$weibo$sdk$statistic$LogType;
    private static final String APPKEY = "WEIBO_APPKEY";
    private static final String CHANNEL = "WEIBO_CHANNEL";
    public static final String KEY_AID = "aid";
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_CHANNEL = "channel";
    private static final String KEY_DURATION = "duration";
    public static final String KEY_END_TIME = "endtime";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_EXTEND = "extend";
    public static final String KEY_HASH = "key_hash";
    public static final String KEY_PACKAGE_NAME = "packagename";
    private static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_START_TIME = "starttime";
    private static final String KEY_TIME = "time";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VERSION = "version";
    private static final int MAX_COUNT = 500;
    public static final long MAX_INTERVAL = 86400000;

    static /* synthetic */ int[] $SWITCH_TABLE$com$sina$weibo$sdk$statistic$LogType() {
        int[] iArr = $SWITCH_TABLE$com$sina$weibo$sdk$statistic$LogType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[LogType.valuesCustom().length];
        try {
            iArr2[LogType.ACTIVITY.ordinal()] = 5;
        } catch (NoSuchFieldError e) {
        }
        try {
            iArr2[LogType.APP_AD_START.ordinal()] = 6;
        } catch (NoSuchFieldError e2) {
        }
        try {
            iArr2[LogType.EVENT.ordinal()] = 4;
        } catch (NoSuchFieldError e3) {
        }
        try {
            iArr2[LogType.FRAGMENT.ordinal()] = 3;
        } catch (NoSuchFieldError e4) {
        }
        try {
            iArr2[LogType.SESSION_END.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            iArr2[LogType.SESSION_START.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        $SWITCH_TABLE$com$sina$weibo$sdk$statistic$LogType = iArr2;
        return iArr2;
    }

    LogBuilder() {
    }

    private static JSONObject addEventData(JSONObject jSONObject, EventLog eventLog) {
        try {
            jSONObject.put("event_id", eventLog.getEvent_id());
            if (eventLog.getExtend() != null) {
                Map<String, String> extend = eventLog.getExtend();
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (String str : extend.keySet()) {
                    if (i >= 10) {
                        break;
                    } else if (!TextUtils.isEmpty(extend.get(str))) {
                        if (sb.length() > 0) {
                            sb.append("|");
                        }
                        sb.append(str);
                        sb.append(":");
                        sb.append(extend.get(str));
                        i++;
                    }
                }
                jSONObject.put(KEY_EXTEND, sb.toString());
                return jSONObject;
            }
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "add event log error." + e);
        }
        return jSONObject;
    }

    private static String buildUploadLogs(String str) {
        String appLogs = LogFileUtil.getAppLogs(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME));
        if (TextUtils.isEmpty(appLogs) && TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{applogs:[");
        if (!TextUtils.isEmpty(appLogs)) {
            sb.append(appLogs);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        sb.append("]}");
        return sb.toString();
    }

    public static String getAppKey(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get(APPKEY);
                if (obj == null) {
                    LogUtil.e(WBAgent.TAG, "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
                    return null;
                }
                LogUtil.i(WBAgent.TAG, "APPKEY: " + String.valueOf(obj));
                return String.valueOf(obj);
            }
            return null;
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml." + e);
            return null;
        }
    }

    public static String getChannel(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString(CHANNEL);
                if (string == null) {
                    LogUtil.e(WBAgent.TAG, "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
                    return null;
                }
                LogUtil.i(WBAgent.TAG, "CHANNEL: " + string.trim());
                return string.trim();
            }
            return null;
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml." + e);
            return null;
        }
    }

    private static JSONObject getLogInfo(PageLog pageLog) {
        JSONObject jSONObject = new JSONObject();
        try {
            switch ($SWITCH_TABLE$com$sina$weibo$sdk$statistic$LogType()[pageLog.getType().ordinal()]) {
                case 1:
                    jSONObject.put("type", 0);
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    return jSONObject;
                case 2:
                    jSONObject.put("type", 1);
                    jSONObject.put("time", pageLog.getEndTime() / 1000);
                    jSONObject.put("duration", pageLog.getDuration() / 1000);
                    return jSONObject;
                case 3:
                    jSONObject.put("type", 2);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    jSONObject.put("duration", pageLog.getDuration() / 1000);
                    return jSONObject;
                case 4:
                    jSONObject.put("type", 3);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    addEventData(jSONObject, (EventLog) pageLog);
                    return jSONObject;
                case 5:
                    jSONObject.put("type", 4);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    jSONObject.put("duration", pageLog.getDuration() / 1000);
                    return jSONObject;
                case 6:
                    AdEventLog adEventLog = (AdEventLog) pageLog;
                    jSONObject.put("type", 0);
                    jSONObject.put(KEY_PAGE_ID, adEventLog.getmImei());
                    jSONObject.put("time", adEventLog.getStartTime());
                    jSONObject.put("aid", adEventLog.getmAid());
                    addEventData(jSONObject, adEventLog);
                    return jSONObject;
                default:
                    return jSONObject;
            }
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "get page log error." + e);
            return jSONObject;
        }
    }

    public static String getPageLogs(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<PageLog> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            sb.append(getLogInfo(it.next()).toString());
            sb.append(",");
        }
        return sb.toString();
    }

    public static List<JSONArray> getValidUploadLogs(String str) {
        String buildUploadLogs = buildUploadLogs(str);
        if (TextUtils.isEmpty(buildUploadLogs)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONArray jSONArray2 = new JSONObject(buildUploadLogs).getJSONArray("applogs");
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= jSONArray2.length()) {
                    break;
                }
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                JSONArray jSONArray3 = jSONArray;
                int i4 = i3;
                if (isDataValid(currentTimeMillis, jSONObject.getLong("time") * 1000)) {
                    if (i3 < 500) {
                        jSONArray.put(jSONObject);
                        i4 = i3 + 1;
                        jSONArray3 = jSONArray;
                    } else {
                        arrayList.add(jSONArray);
                        jSONArray3 = new JSONArray();
                        i4 = 0;
                    }
                }
                i++;
                jSONArray = jSONArray3;
                i2 = i4;
            }
            if (jSONArray.length() > 0) {
                arrayList.add(jSONArray);
                return arrayList;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String getVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            LogUtil.i(WBAgent.TAG, "versionName: " + packageInfo.versionName);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(WBAgent.TAG, "Could not read versionName from AndroidManifest.xml." + e);
            return null;
        }
    }

    private static boolean isDataValid(long j, long j2) {
        return j - j2 < 86400000;
    }
}
