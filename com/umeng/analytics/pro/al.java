package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.iu;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/al.class */
public class al {
    public static JSONObject a(Context context, int i, JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                jSONObject2 = jSONObject3;
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject3.put("atoken", zid);
                    String deviceToken = UMUtils.getDeviceToken(context);
                    if (!TextUtils.isEmpty(deviceToken)) {
                        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, deviceToken);
                    }
                    jSONObject3.put("model", Build.MODEL);
                    jSONObject3.put(bh.x, "android");
                    jSONObject3.put("os_version", Build.VERSION.RELEASE);
                    jSONObject3.put(com.umeng.ccg.a.o, str);
                    jSONObject3.put("sdk", jSONArray);
                    jSONObject3.put(iu.h, i);
                    return jSONObject3;
                }
            } catch (Throwable th) {
                jSONObject = jSONObject3;
                jSONObject2 = jSONObject;
                return jSONObject2;
            }
        } catch (Throwable th2) {
            jSONObject = null;
        }
        return jSONObject2;
    }

    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            ak akVar = new ak();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            akVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            akVar.b(appkey);
            akVar.c(UMUtils.getAppVersionName(context));
            akVar.d("9.6.3");
            akVar.e(UMUtils.getChannel(context));
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            sb.append("");
            akVar.f(sb.toString());
            akVar.g(Build.BRAND);
            akVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            akVar.i(localeInfo[1]);
            akVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            akVar.b(Integer.valueOf(resolutionArray[1]));
            akVar.a(Integer.valueOf(resolutionArray[0]));
            akVar.k(ap.a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(ak.f40621a, akVar.a());
                    jSONObject3.put(ak.f40622c, akVar.c());
                    jSONObject3.put(ak.b, akVar.b());
                    jSONObject3.put(ak.d, akVar.d());
                    jSONObject3.put(ak.e, akVar.e());
                    jSONObject3.put(ak.f, akVar.f());
                    jSONObject3.put(ak.g, akVar.g());
                    jSONObject3.put(ak.h, akVar.h());
                    jSONObject3.put(ak.k, akVar.k());
                    jSONObject3.put(ak.j, akVar.j());
                    jSONObject3.put(ak.l, akVar.l());
                    jSONObject3.put(ak.i, akVar.i());
                    jSONObject3.put(ak.m, akVar.m());
                    jSONObject3.put(bh.al, UMUtils.getZid(context));
                    jSONObject3.put("platform", "android");
                    jSONObject3.put("optional", new JSONObject(ap.a()));
                    String[] split = str.split("@");
                    if (split.length == 4) {
                        try {
                            long parseLong = Long.parseLong(split[0]);
                            String str2 = split[1];
                            jSONObject3.put("s1", parseLong);
                            jSONObject3.put("s2", str2);
                        } catch (Throwable th) {
                            return jSONObject3;
                        }
                    }
                    return jSONObject3;
                } catch (JSONException e) {
                    e = e;
                    jSONObject = jSONObject3;
                    StringBuilder sb2 = new StringBuilder();
                    JSONObject jSONObject4 = jSONObject;
                    sb2.append("[getCloudConfigParam] error ");
                    JSONObject jSONObject5 = jSONObject;
                    sb2.append(e.getMessage());
                    jSONObject2 = jSONObject;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, sb2.toString());
                    return jSONObject;
                } catch (Throwable th2) {
                    th = th2;
                    jSONObject2 = jSONObject3;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                    return jSONObject2;
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
