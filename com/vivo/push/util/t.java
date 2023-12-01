package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.text.TextUtils;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/t.class */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f41144a;
    private static String b;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
        if (r5.d() != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d9 A[EDGE_INSN: B:93:0x01d9->B:79:0x01d9 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.push.model.b a(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.t.a(android.content.Context):com.vivo.push.model.b");
    }

    private static boolean a(Context context, long j) {
        com.vivo.push.cache.d a2 = com.vivo.push.cache.b.a().a(context);
        if (a2 != null) {
            return a2.isInBlackList(j);
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            p.a("PushPackageUtils", "isEnablePush error: can not find push service.");
            return false;
        }
        int size = queryIntentServices.size();
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (i >= size) {
                return z2;
            }
            ResolveInfo resolveInfo = queryIntentServices.get(i);
            boolean z3 = z2;
            if (resolveInfo != null) {
                z3 = z2;
                if (resolveInfo.serviceInfo != null) {
                    String str2 = resolveInfo.serviceInfo.name;
                    boolean z4 = resolveInfo.serviceInfo.exported;
                    z3 = z2;
                    if ("com.vivo.push.sdk.service.PushService".equals(str2)) {
                        z3 = z2;
                        if (z4) {
                            boolean z5 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z3 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z5);
                        }
                    }
                }
            }
            i++;
            z = z3;
        }
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception e) {
            list = null;
        }
        return list != null && list.size() > 0;
    }

    public static int b(Context context, String str) {
        int i = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            i = 1;
        }
        return i;
    }

    public static String b(Context context) {
        String str;
        Cursor cursor;
        Exception exc;
        String str2;
        if (TextUtils.isEmpty(b)) {
            Cursor cursor2 = null;
            try {
                try {
                    try {
                        cursor = context.getContentResolver().query(com.vivo.push.p.f41113a, null, null, null, null);
                        try {
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e) {
                                    p.a("PushPackageUtils", "close", e);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    str = null;
                    cursor = null;
                    exc = e2;
                }
                if (cursor != null) {
                    boolean z = false;
                    String str3 = null;
                    while (true) {
                        str = str3;
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            } else if ("pushPkgName".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                                str3 = cursor.getString(cursor.getColumnIndex("value"));
                            } else {
                                str3 = str;
                                if ("pushEnable".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                                    z = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("value")));
                                    str3 = str;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                    b = str;
                    if (TextUtils.isEmpty(str)) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return null;
                            } catch (Exception e4) {
                                p.a("PushPackageUtils", "close", e4);
                                return null;
                            }
                        }
                        return null;
                    } else if (z) {
                        str2 = str;
                        if (cursor != null) {
                            cursor.close();
                            return str;
                        }
                        return str2;
                    } else if (cursor != null) {
                        try {
                            cursor.close();
                            return null;
                        } catch (Exception e5) {
                            p.a("PushPackageUtils", "close", e5);
                            return null;
                        }
                    } else {
                        return null;
                    }
                }
                try {
                    p.a("PushPackageUtils", "cursor is null");
                    if (cursor != null) {
                        try {
                            cursor.close();
                            return null;
                        } catch (Exception e6) {
                            p.a("PushPackageUtils", "close", e6);
                            return null;
                        }
                    }
                    return null;
                } catch (Exception e7) {
                    e = e7;
                    str = null;
                }
                exc = e;
                cursor2 = cursor;
                p.a("PushPackageUtils", "getSystemPush", exc);
                str2 = str;
                if (cursor != null) {
                    cursor.close();
                    str2 = str;
                }
                return str2;
            } catch (Exception e8) {
                p.a("PushPackageUtils", "close", e8);
                return null;
            }
        }
        return b;
    }

    public static boolean c(Context context) {
        Boolean bool = f41144a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null) {
            if (TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig")) {
                str = null;
            } else {
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128);
                str = null;
                if (resolveContentProvider != null) {
                    str = resolveContentProvider.packageName;
                }
            }
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        f41144a = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    private static com.vivo.push.model.b d(Context context) {
        String b2 = b(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(b2);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b2, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(z.a(context, b2));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, b2));
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            p.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    private static List<String> e(Context context) {
        List<ResolveInfo> list;
        g.a("findAllCoreClientPush");
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception e) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ResolveInfo resolveInfo = list.get(i2);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
                i = i2 + 1;
            }
        }
        if (arrayList.size() <= 0) {
            p.d("PushPackageUtils", "get all push packages is null");
        }
        return arrayList;
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
            com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                if (packageInfo != null) {
                    bVar.a(packageInfo.versionCode);
                    bVar.a(packageInfo.versionName);
                    applicationInfo = packageInfo.applicationInfo;
                } else {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    bVar.a(z.a(context, str));
                }
                bVar.b(a(context, str));
                bVar.a(a(context, bVar.b()));
                return bVar;
            } catch (Exception e) {
                p.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                return null;
            }
        }
        return null;
    }

    private static String g(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance(AppSigning.SHA256).digest(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            p.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e)));
            return null;
        }
    }
}
