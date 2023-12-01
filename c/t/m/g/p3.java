package c.t.m.g;

import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p3.class */
public class p3 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SharedPreferences f3921a;

    public static SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (p3.class) {
            try {
                if (f3921a == null) {
                    f3921a = q2.a().getSharedPreferences("LocationSDK", 0);
                }
                sharedPreferences = f3921a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }

    public static SharedPreferences a(String str) {
        if ("LocationSDK".equals(str)) {
            return a();
        }
        int i = 0;
        if ("com.tencent.mobileqq".equals(q2.a().getPackageName())) {
            i = 4;
        }
        return q2.a().getSharedPreferences(str, i);
    }

    public static Object a(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static Object a(String str, String str2, Object obj) {
        return a(a(str), str2, obj);
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        String str3 = (String) a(sharedPreferences, str, (Object) "");
        if (m3.a(str3)) {
            return str2;
        }
        String a2 = u2.a(str3);
        if (m3.a(a2)) {
            b(sharedPreferences, str, (Object) "");
        }
        return m3.a(a2) ? str2 : a2;
    }

    public static void b(SharedPreferences sharedPreferences, String str, Object obj) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
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
        } else {
            edit.putString(str, obj.toString());
        }
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public static void b(SharedPreferences sharedPreferences, String str, String str2) {
        b(sharedPreferences, str, (Object) u2.b(str2));
    }

    public static void b(String str, String str2, Object obj) {
        b(a(str), str2, obj);
    }
}
