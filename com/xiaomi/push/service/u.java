package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.fv;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static t f28012a;

    /* renamed from: a  reason: collision with other field name */
    private static a f1034a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/u$a.class */
    public interface a {
        void a();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static t m9160a(Context context) {
        synchronized (u.class) {
            try {
                if (f28012a != null) {
                    return f28012a;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                String string = sharedPreferences.getString("uuid", null);
                String string2 = sharedPreferences.getString("token", null);
                String string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString("app_id", null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString("package_name", null);
                String string7 = sharedPreferences.getString("device_id", null);
                int i = sharedPreferences.getInt("env_type", 1);
                String str = string7;
                if (!TextUtils.isEmpty(string7)) {
                    str = string7;
                    if (com.xiaomi.push.i.a(string7)) {
                        str = com.xiaomi.push.i.g(context);
                        sharedPreferences.edit().putString("device_id", str).commit();
                    }
                }
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                    return null;
                }
                String g = com.xiaomi.push.i.g(context);
                if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(g) && !TextUtils.isEmpty(str) && !str.equals(g)) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("read_phone_state permission changes.");
                }
                t tVar = new t(string, string2, string3, string4, string5, string6, i);
                f28012a = tVar;
                return tVar;
            } finally {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:3|4|(3:8|9|(27:11|12|(2:14|15)|16|(2:18|19)|20|(2:22|23)(1:144)|24|25|26|27|28|(1:30)(1:139)|31|(14:33|34|35|36|37|(1:39)|40|41|42|43|(4:45|46|47|(1:49))|50|51|(1:53))|54|55|(1:57)|58|59|(8:63|64|65|66|68|69|60|61)|73|74|(4:79|80|81|(3:83|84|85)(12:87|(1:89)|90|91|92|(2:96|(4:98|99|100|(11:102|103|104|(1:106)|107|108|109|110|111|112|113)(1:115)))|124|(1:128)|129|130|131|132))|138|81|(0)(0)))|145|12|(0)|16|(0)|20|(0)(0)|24|25|26|27|28|(0)(0)|31|(0)|54|55|(0)|58|59|(2:60|61)|73|74|(5:76|79|80|81|(0)(0))|138|81|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b9, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bf, code lost:
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x046f A[Catch: all -> 0x048b, TRY_ENTER, TryCatch #5 {all -> 0x048b, blocks: (B:4:0x0003, B:6:0x0021, B:8:0x002d, B:11:0x0050, B:12:0x0062, B:16:0x0078, B:20:0x0085, B:24:0x0093, B:26:0x00aa, B:32:0x00c4, B:33:0x00cf, B:37:0x0118, B:39:0x0120, B:41:0x0126, B:43:0x0145, B:45:0x014d, B:49:0x0157, B:51:0x015f, B:53:0x0188, B:55:0x018e, B:56:0x019a, B:57:0x019d, B:59:0x01d1, B:60:0x01e0, B:61:0x01e3, B:63:0x0233, B:65:0x023b, B:67:0x0248, B:69:0x0262, B:70:0x02b3, B:72:0x02e6, B:75:0x02f0, B:77:0x0303, B:86:0x0327, B:92:0x0346, B:94:0x0350, B:116:0x044a, B:118:0x0456, B:119:0x045c, B:122:0x046f, B:124:0x0476, B:126:0x0483, B:88:0x0333, B:28:0x00ba), top: B:148:0x0003, inners: #2, #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4 A[Catch: all -> 0x048b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x048b, blocks: (B:4:0x0003, B:6:0x0021, B:8:0x002d, B:11:0x0050, B:12:0x0062, B:16:0x0078, B:20:0x0085, B:24:0x0093, B:26:0x00aa, B:32:0x00c4, B:33:0x00cf, B:37:0x0118, B:39:0x0120, B:41:0x0126, B:43:0x0145, B:45:0x014d, B:49:0x0157, B:51:0x015f, B:53:0x0188, B:55:0x018e, B:56:0x019a, B:57:0x019d, B:59:0x01d1, B:60:0x01e0, B:61:0x01e3, B:63:0x0233, B:65:0x023b, B:67:0x0248, B:69:0x0262, B:70:0x02b3, B:72:0x02e6, B:75:0x02f0, B:77:0x0303, B:86:0x0327, B:92:0x0346, B:94:0x0350, B:116:0x044a, B:118:0x0456, B:119:0x045c, B:122:0x046f, B:124:0x0476, B:126:0x0483, B:88:0x0333, B:28:0x00ba), top: B:148:0x0003, inners: #2, #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d1 A[Catch: all -> 0x048b, TRY_ENTER, TryCatch #5 {all -> 0x048b, blocks: (B:4:0x0003, B:6:0x0021, B:8:0x002d, B:11:0x0050, B:12:0x0062, B:16:0x0078, B:20:0x0085, B:24:0x0093, B:26:0x00aa, B:32:0x00c4, B:33:0x00cf, B:37:0x0118, B:39:0x0120, B:41:0x0126, B:43:0x0145, B:45:0x014d, B:49:0x0157, B:51:0x015f, B:53:0x0188, B:55:0x018e, B:56:0x019a, B:57:0x019d, B:59:0x01d1, B:60:0x01e0, B:61:0x01e3, B:63:0x0233, B:65:0x023b, B:67:0x0248, B:69:0x0262, B:70:0x02b3, B:72:0x02e6, B:75:0x02f0, B:77:0x0303, B:86:0x0327, B:92:0x0346, B:94:0x0350, B:116:0x044a, B:118:0x0456, B:119:0x045c, B:122:0x046f, B:124:0x0476, B:126:0x0483, B:88:0x0333, B:28:0x00ba), top: B:148:0x0003, inners: #2, #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x023b A[Catch: all -> 0x048b, TryCatch #5 {all -> 0x048b, blocks: (B:4:0x0003, B:6:0x0021, B:8:0x002d, B:11:0x0050, B:12:0x0062, B:16:0x0078, B:20:0x0085, B:24:0x0093, B:26:0x00aa, B:32:0x00c4, B:33:0x00cf, B:37:0x0118, B:39:0x0120, B:41:0x0126, B:43:0x0145, B:45:0x014d, B:49:0x0157, B:51:0x015f, B:53:0x0188, B:55:0x018e, B:56:0x019a, B:57:0x019d, B:59:0x01d1, B:60:0x01e0, B:61:0x01e3, B:63:0x0233, B:65:0x023b, B:67:0x0248, B:69:0x0262, B:70:0x02b3, B:72:0x02e6, B:75:0x02f0, B:77:0x0303, B:86:0x0327, B:92:0x0346, B:94:0x0350, B:116:0x044a, B:118:0x0456, B:119:0x045c, B:122:0x046f, B:124:0x0476, B:126:0x0483, B:88:0x0333, B:28:0x00ba), top: B:148:0x0003, inners: #2, #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x031c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.push.service.t a(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 1207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.t");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m9161a(Context context) {
        t m9160a = m9160a(context);
        if (m9160a == null || TextUtils.isEmpty(m9160a.f1033a)) {
            return null;
        }
        String[] split = m9160a.f1033a.split("@");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    private static String a(Context context, boolean z) {
        String a2 = com.xiaomi.push.service.a.a(context).a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (!com.xiaomi.push.aa.b()) {
            if (com.xiaomi.push.m.China.name().equals(a2)) {
                return "https://cn.register.xmpush.xiaomi.com".concat(str);
            }
            return null;
        }
        return "http://" + fv.b + ":9085" + str;
    }

    public static void a() {
        a aVar = f1034a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m9162a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f28012a = null;
        a();
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    public static void a(Context context, t tVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", tVar.f1033a);
        edit.putString("security", tVar.f28011c);
        edit.putString("token", tVar.b);
        edit.putString("app_id", tVar.d);
        edit.putString("package_name", tVar.f);
        edit.putString("app_token", tVar.e);
        edit.putString("device_id", com.xiaomi.push.i.g(context));
        edit.putInt("env_type", tVar.f28010a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f1034a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m9163a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
