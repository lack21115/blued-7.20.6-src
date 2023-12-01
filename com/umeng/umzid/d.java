package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/d.class */
public class d {
    public static String a(Context context) {
        SharedPreferences a2;
        if (context == null || (a2 = a.a(context)) == null) {
            return null;
        }
        return a2.getString("aaid", null);
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        String b = b(str);
        if (context == null || b == null || TextUtils.isEmpty(b) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("mac", b).commit();
    }

    public static String b(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getMac", Context.class)) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, context);
            return (invoke == null || !(invoke instanceof String)) ? "" : (String) invoke;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        String b = b(str);
        if (context == null || b == null || TextUtils.isEmpty(b) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("oaid", b).commit();
    }

    public static String c(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getOaid", Context.class)) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, context);
            return (invoke == null || !(invoke instanceof String)) ? "" : (String) invoke;
        } catch (Throwable th) {
            return "";
        }
    }

    public static void c(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }

    public static void d(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    public static boolean d(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
            boolean z = true;
            if (cls != null) {
                Method declaredMethod = cls.getDeclaredMethod("isMainProgress", Context.class);
                z = true;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    z = ((Boolean) declaredMethod.invoke(cls, context)).booleanValue();
                }
            }
            return z;
        } catch (Throwable th) {
            return true;
        }
    }

    public static void e(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    public static boolean e(Context context) {
        NetworkInfo networkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(17)) == null) {
                    return false;
                }
                return networkInfo.isConnected();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static void f(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }
}
