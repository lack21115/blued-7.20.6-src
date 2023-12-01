package com.igexin.push.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/o.class */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23663a = "us";
    public static final String b = "ups";

    /* renamed from: c  reason: collision with root package name */
    public static final String f23664c = "uis";
    public static final String d = "ua";
    public static final String e = "sc";
    public static final String f = "it";
    public static final String g = "logkey2";
    public static final String h = "hwBadgeNum";
    public static final String i = "vivoBadgeNum";
    public static final String j = "oppoBadgeNum";
    private static final String k = "SpUtils";
    private static final String l = "getui_sp";

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081 A[Catch: all -> 0x016c, TryCatch #2 {all -> 0x016c, blocks: (B:2:0x0000, B:14:0x004c, B:16:0x0079, B:18:0x0081, B:20:0x0097, B:22:0x00a2, B:24:0x00a9, B:25:0x00b4, B:27:0x00bd, B:29:0x00c5, B:31:0x00e7, B:33:0x00f1, B:35:0x00f9, B:36:0x0104, B:38:0x010c, B:40:0x0114, B:42:0x0136, B:44:0x013f, B:46:0x0147, B:48:0x0164), top: B:57:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5 A[Catch: all -> 0x016c, TryCatch #2 {all -> 0x016c, blocks: (B:2:0x0000, B:14:0x004c, B:16:0x0079, B:18:0x0081, B:20:0x0097, B:22:0x00a2, B:24:0x00a9, B:25:0x00b4, B:27:0x00bd, B:29:0x00c5, B:31:0x00e7, B:33:0x00f1, B:35:0x00f9, B:36:0x0104, B:38:0x010c, B:40:0x0114, B:42:0x0136, B:44:0x013f, B:46:0x0147, B:48:0x0164), top: B:57:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0114 A[Catch: all -> 0x016c, TryCatch #2 {all -> 0x016c, blocks: (B:2:0x0000, B:14:0x004c, B:16:0x0079, B:18:0x0081, B:20:0x0097, B:22:0x00a2, B:24:0x00a9, B:25:0x00b4, B:27:0x00bd, B:29:0x00c5, B:31:0x00e7, B:33:0x00f1, B:35:0x00f9, B:36:0x0104, B:38:0x010c, B:40:0x0114, B:42:0x0136, B:44:0x013f, B:46:0x0147, B:48:0x0164), top: B:57:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0147 A[Catch: all -> 0x016c, TryCatch #2 {all -> 0x016c, blocks: (B:2:0x0000, B:14:0x004c, B:16:0x0079, B:18:0x0081, B:20:0x0097, B:22:0x00a2, B:24:0x00a9, B:25:0x00b4, B:27:0x00bd, B:29:0x00c5, B:31:0x00e7, B:33:0x00f1, B:35:0x00f9, B:36:0x0104, B:38:0x010c, B:40:0x0114, B:42:0x0136, B:44:0x013f, B:46:0x0147, B:48:0x0164), top: B:57:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r4, android.content.Intent r5) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.o.a(android.content.Context, android.content.Intent):void");
    }

    public static void a(Context context, String str, Object obj) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(l, 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.apply();
    }

    public static boolean a(Context context) {
        try {
            String str = (String) b(context, f23663a, "");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Class.forName(str);
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(k, e2.toString());
            com.igexin.c.a.c.a.a("SpUtils|" + e2.toString(), new Object[0]);
            return false;
        }
    }

    public static Object b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(l, 0);
        return obj instanceof String ? sharedPreferences.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }
}
