package com.xiaomi.mipush.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.oplus.quickgame.sdk.hall.Constant;
import com.tencent.mapsdk.internal.k4;
import com.xiaomi.push.bh;
import com.xiaomi.push.bi;
import com.xiaomi.push.bm;
import com.xiaomi.push.ic;
import com.xiaomi.push.s;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/i.class */
public class i {
    public static int a() {
        Integer num = (Integer) bi.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int a(Context context, e eVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(eVar);
        String string = sharedPreferences.getString(a2, "");
        String m8415c = b.m8407a(context).m8415c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        } else if (TextUtils.isEmpty(string)) {
            return 1;
        } else {
            if (string.equals(str)) {
                if (TextUtils.equals(m8415c, string2)) {
                    if (m8434a(eVar)) {
                        return a() != sharedPreferences.getInt(b(eVar), 0) ? 4 : 0;
                    }
                    return 0;
                }
                return 3;
            }
            return 2;
        }
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has(Constant.Param.TOPIC)) {
                    miPushMessage.setTopic(jSONObject.getString(Constant.Param.TOPIC));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                        return miPushMessage;
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    resolveInfo = it.next();
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo != null) {
                return (PushMessageReceiver) com.xiaomi.push.r.a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return null;
        }
    }

    static String a(Context context, e eVar) {
        return a(context, eVar, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context, e eVar, boolean z) {
        synchronized (i.class) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
                if (z) {
                    String string = sharedPreferences.getString("syncingToken", "");
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                }
                String a2 = a(eVar);
                if (TextUtils.isEmpty(a2)) {
                    return "";
                }
                return sharedPreferences.getString(a2, "");
            } finally {
            }
        }
    }

    public static String a(e eVar) {
        int i = k.f27536a[eVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token_v2";
        }
        return "hms_push_token";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HashMap<String, String> m8428a(Context context, e eVar) {
        s.a a2;
        String aVar;
        int a3;
        HashMap<String, String> hashMap = new HashMap<>();
        int i = k.f27536a[eVar.ordinal()];
        ApplicationInfo applicationInfo = null;
        if (i != 1) {
            if (i == 2) {
                a2 = new s.a(":", Constants.WAVE_SEPARATOR).a("brand", ag.FCM.name()).a("token", a(context, eVar, false)).a("package_name", context.getPackageName());
                a3 = a();
                if (a3 == 0) {
                    a3 = 50010;
                }
            } else if (i == 3) {
                a2 = new s.a(":", Constants.WAVE_SEPARATOR).a("brand", ag.OPPO.name()).a("token", a(context, eVar, true)).a("package_name", context.getPackageName());
            } else if (i != 4) {
                aVar = null;
                hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, aVar);
                return hashMap;
            } else {
                s.a a4 = new s.a(":", Constants.WAVE_SEPARATOR).a("brand", ag.VIVO.name()).a("token", a(context, eVar, true)).a("package_name", context.getPackageName());
                a3 = a();
                a2 = a4;
                if (a3 != 0) {
                    a2 = a4;
                }
            }
            a2.a("version", Integer.valueOf(a3));
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
            int i2 = -1;
            if (applicationInfo != null) {
                i2 = applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID);
            }
            a2 = new s.a(":", Constants.WAVE_SEPARATOR).a("brand", ag.HUAWEI.name()).a("token", a(context, eVar, true)).a("package_name", context.getPackageName()).a("app_id", Integer.valueOf(i2));
        }
        aVar = a2.toString();
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, aVar);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m8429a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(e.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(e.ASSEMBLE_PUSH_FCM);
        boolean z = false;
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, ""))) {
            z = false;
            if (TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
                z = true;
            }
        }
        if (z) {
            ao.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8430a(Context context, e eVar) {
        String a2 = a(eVar);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        com.xiaomi.push.p.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8431a(Context context, e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int a2 = a(context, eVar, str);
        if (a2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : send token upload, check:".concat(String.valueOf(a2)));
        a(context, str);
        au a3 = l.a(eVar);
        if (a3 == null) {
            return;
        }
        ao.a(context).a((String) null, a3, eVar, ContentResolver.SYNC_EXTRAS_UPLOAD);
    }

    private static void a(Context context, String str) {
        synchronized (i.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putString("syncingToken", str);
                edit.apply();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = ".concat(String.valueOf(i)));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8432a(Context context) {
        if (context == null) {
            return false;
        }
        return bh.b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8433a(Context context, e eVar) {
        if (l.m8438a(eVar) != null) {
            return ba.a(context).a(l.m8438a(eVar).a(), true);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8434a(e eVar) {
        return eVar == e.ASSEMBLE_PUSH_FTOS || eVar == e.ASSEMBLE_PUSH_FCM;
    }

    public static boolean a(ic icVar, e eVar) {
        if (icVar == null || icVar.m8895a() == null || icVar.m8895a().m8846a() == null) {
            return false;
        }
        return (eVar == e.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(icVar.m8895a().m8846a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, ic icVar, e eVar) {
        if (a(icVar, eVar)) {
            return bm.m8497a(a(context, eVar));
        }
        return null;
    }

    public static String b(e eVar) {
        return a(eVar) + k4.t;
    }

    public static void b(Context context) {
        f.a(context).register();
    }

    public static void b(Context context, e eVar, String str) {
        com.xiaomi.push.ai.a(context).a(new j(str, context, eVar));
    }

    public static String c(e eVar) {
        int i = k.f27536a[eVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_error";
                }
                return "cos_push_error";
            }
            return "fcm_push_error";
        }
        return "hms_push_error";
    }

    public static void c(Context context) {
        f.a(context).unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, e eVar, String str) {
        synchronized (i.class) {
            try {
                String a2 = a(eVar);
                if (TextUtils.isEmpty(a2)) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                    return;
                }
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putString(a2, str).putString("last_check_token", b.m8407a(context).m8415c());
                if (m8434a(eVar)) {
                    edit.putInt(b(eVar), a());
                }
                edit.putString("syncingToken", "");
                com.xiaomi.push.p.a(edit);
                com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : update sp file success!  ".concat(String.valueOf(str)));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
