package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/a/a.class */
public final class a {
    private Context a;
    private com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    private int c = 4;

    public a(Context context) {
        this.a = context;
    }

    public static String a(Context context) {
        String b = b(context);
        String str = b;
        if (com.alipay.security.mobile.module.a.a.a(b)) {
            str = h.f(context);
        }
        return str;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a = i.a(str);
            if (com.alipay.security.mobile.module.a.a.a(a)) {
                String a2 = g.a(context, str);
                i.a(str, a2);
                return !com.alipay.security.mobile.module.a.a.a(a2) ? a2 : "";
            }
            return a;
        } catch (Throwable th) {
            return "";
        }
    }

    private static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int random = (int) (Math.random() * 24.0d * 60.0d * 60.0d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return false;
            }
            try {
                String[] split = new String[]{"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"}[i2].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random * 1);
                    Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
                i = i2 + 1;
            } catch (Exception e) {
                return false;
            }
        }
    }

    private c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            Context context = this.a;
            d dVar = new d();
            String a = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
            String a2 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
            String a3 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", "");
            String a4 = a(context, a);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d = h.d(context);
            if (com.alipay.security.mobile.module.a.a.b(a2)) {
                dVar.c = a2;
            } else {
                dVar.c = a4;
            }
            dVar.d = securityToken;
            dVar.e = d;
            dVar.a = MsgBackupManager.PLATFORM_ANDROID;
            com.alipay.apmobilesecuritysdk.e.c c = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (c != null) {
                str2 = c.a;
                str = c.c;
            } else {
                str = "";
                str2 = str;
            }
            String str5 = str;
            String str6 = str2;
            if (com.alipay.security.mobile.module.a.a.a(str2)) {
                b c2 = com.alipay.apmobilesecuritysdk.e.a.c(context);
                str5 = str;
                str6 = str2;
                if (c2 != null) {
                    str6 = c2.a;
                    str5 = c2.c;
                }
            }
            com.alipay.apmobilesecuritysdk.e.c b = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b != null) {
                str4 = b.a;
                str3 = b.c;
            } else {
                str3 = "";
                str4 = "";
            }
            String str7 = str4;
            String str8 = str3;
            if (com.alipay.security.mobile.module.a.a.a(str4)) {
                b b2 = com.alipay.apmobilesecuritysdk.e.a.b();
                str7 = str4;
                str8 = str3;
                if (b2 != null) {
                    str7 = b2.a;
                    str8 = b2.c;
                }
            }
            dVar.h = str6;
            dVar.g = str7;
            dVar.j = a3;
            if (com.alipay.security.mobile.module.a.a.a(str6)) {
                dVar.b = str7;
                dVar.i = str8;
            } else {
                dVar.b = str6;
                dVar.i = str5;
            }
            dVar.f = e.a(context, map);
            return com.alipay.security.mobile.module.http.d.b(this.a, this.b.c()).a(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    private static String b(Context context) {
        try {
            String b = i.b();
            if (com.alipay.security.mobile.module.a.a.a(b)) {
                com.alipay.apmobilesecuritysdk.e.c b2 = com.alipay.apmobilesecuritysdk.e.d.b(context);
                if (b2 != null) {
                    i.a(b2);
                    String str = b2.a;
                    if (com.alipay.security.mobile.module.a.a.b(str)) {
                        return str;
                    }
                }
                b b3 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                if (b3 != null) {
                    i.a(b3);
                    String str2 = b3.a;
                    return com.alipay.security.mobile.module.a.a.b(str2) ? str2 : "";
                }
                return "";
            }
            return b;
        } catch (Throwable th) {
            return "";
        }
    }

    private static void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return;
            }
            try {
                String str = new String[]{"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"}[i2];
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
                i = i2 + 1;
            } catch (Throwable th) {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0125 A[Catch: Exception -> 0x0335, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:5:0x004e, B:8:0x005b, B:36:0x0109, B:39:0x0125, B:41:0x0147, B:48:0x015f, B:50:0x017a, B:51:0x0180, B:70:0x02a9, B:72:0x02c6, B:74:0x02d8, B:79:0x02e6, B:83:0x02ef, B:89:0x02fd, B:91:0x0305, B:55:0x0194, B:57:0x0214, B:59:0x021f, B:62:0x022e, B:64:0x0242, B:66:0x024c, B:69:0x0258, B:67:0x0253, B:60:0x0227, B:11:0x0074, B:13:0x0092, B:16:0x00a0, B:18:0x00a8, B:21:0x00b6, B:24:0x00c5, B:27:0x00d7, B:30:0x00e7, B:33:0x00f9), top: B:102:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d8 A[Catch: Exception -> 0x0335, TRY_ENTER, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:5:0x004e, B:8:0x005b, B:36:0x0109, B:39:0x0125, B:41:0x0147, B:48:0x015f, B:50:0x017a, B:51:0x0180, B:70:0x02a9, B:72:0x02c6, B:74:0x02d8, B:79:0x02e6, B:83:0x02ef, B:89:0x02fd, B:91:0x0305, B:55:0x0194, B:57:0x0214, B:59:0x021f, B:62:0x022e, B:64:0x0242, B:66:0x024c, B:69:0x0258, B:67:0x0253, B:60:0x0227, B:11:0x0074, B:13:0x0092, B:16:0x00a0, B:18:0x00a8, B:21:0x00b6, B:24:0x00c5, B:27:0x00d7, B:30:0x00e7, B:33:0x00f9), top: B:102:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02fd A[Catch: Exception -> 0x0335, TRY_ENTER, TryCatch #0 {Exception -> 0x0335, blocks: (B:2:0x0000, B:5:0x004e, B:8:0x005b, B:36:0x0109, B:39:0x0125, B:41:0x0147, B:48:0x015f, B:50:0x017a, B:51:0x0180, B:70:0x02a9, B:72:0x02c6, B:74:0x02d8, B:79:0x02e6, B:83:0x02ef, B:89:0x02fd, B:91:0x0305, B:55:0x0194, B:57:0x0214, B:59:0x021f, B:62:0x022e, B:64:0x0242, B:66:0x024c, B:69:0x0258, B:67:0x0253, B:60:0x0227, B:11:0x0074, B:13:0x0092, B:16:0x00a0, B:18:0x00a8, B:21:0x00b6, B:24:0x00c5, B:27:0x00d7, B:30:0x00e7, B:33:0x00f9), top: B:102:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 863
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a(java.util.Map):int");
    }
}
