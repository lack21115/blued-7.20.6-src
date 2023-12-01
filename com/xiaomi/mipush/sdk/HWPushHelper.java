package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bj;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/HWPushHelper.class */
public class HWPushHelper {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f41187a = false;

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return i.m11482a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String a2 = i.a(context, e.ASSEMBLE_PUSH_HUAWEI, false);
        String a3 = af.a(context).a(au.UPLOAD_HUAWEI_TOKEN);
        return (TextUtils.isEmpty(a2) || TextUtils.isEmpty(a3) || !"synced".equals(a3)) ? false : true;
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return f41187a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        r5 = r0.getString("pushMsg");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void notifyHmsNotificationMessageClicked(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L49
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Exception -> L41
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: java.lang.Exception -> L41
            r5 = r0
            r0 = r5
            int r0 = r0.length()     // Catch: java.lang.Exception -> L41
            if (r0 <= 0) goto L49
            r0 = 0
            r6 = r0
        L19:
            r0 = r6
            r1 = r5
            int r1 = r1.length()     // Catch: java.lang.Exception -> L41
            if (r0 >= r1) goto L49
            r0 = r5
            r1 = r6
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch: java.lang.Exception -> L41
            r7 = r0
            r0 = r7
            java.lang.String r1 = "pushMsg"
            boolean r0 = r0.has(r1)     // Catch: java.lang.Exception -> L41
            if (r0 == 0) goto L3a
            r0 = r7
            java.lang.String r1 = "pushMsg"
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> L41
            r5 = r0
            goto L4c
        L3a:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L19
        L41:
            r5 = move-exception
            r0 = r5
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
        L49:
            java.lang.String r0 = ""
            r5 = r0
        L4c:
            r0 = r4
            com.xiaomi.mipush.sdk.PushMessageReceiver r0 = com.xiaomi.mipush.sdk.i.a(r0)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L6f
            r0 = r5
            com.xiaomi.mipush.sdk.MiPushMessage r0 = com.xiaomi.mipush.sdk.i.a(r0)
            r5 = r0
            r0 = r5
            java.util.Map r0 = r0.getExtra()
            java.lang.String r1 = "notify_effect"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L69
            return
        L69:
            r0 = r7
            r1 = r4
            r2 = r5
            r0.onNotificationMessageClicked(r1, r2)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.HWPushHelper.notifyHmsNotificationMessageClicked(android.content.Context, java.lang.String):void");
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                str2 = "";
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            str2 = "";
        }
        PushMessageReceiver a2 = i.a(context);
        if (a2 != null) {
            a2.onReceivePassThroughMessage(context, i.a(str2));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager a2 = f.a(context).a(e.ASSEMBLE_PUSH_HUAWEI);
        if (a2 != null) {
            a2.register();
        }
    }

    public static void reportError(String str, int i) {
        i.a(str, i);
    }

    public static void setConnectTime(Context context) {
        synchronized (HWPushHelper.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setGetTokenTime(Context context) {
        synchronized (HWPushHelper.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setNeedConnect(boolean z) {
        f41187a = z;
    }

    public static boolean shouldGetToken(Context context) {
        synchronized (HWPushHelper.class) {
            try {
                return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L)) > bj.e;
            } finally {
            }
        }
    }

    public static boolean shouldTryConnect(Context context) {
        synchronized (HWPushHelper.class) {
            try {
                return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > 5000;
            } finally {
            }
        }
    }

    public static void uploadToken(Context context, String str) {
        i.m11481a(context, e.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
