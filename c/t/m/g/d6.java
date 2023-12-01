package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d6.class */
public class d6 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f3740a;

    public static int a(String str, String str2, int i) {
        Context context = f3740a;
        return context == null ? i : context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static long a(String str, String str2, long j) {
        Context context = f3740a;
        return context == null ? j : context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    public static String a(String str, String str2, String str3) {
        Context context = f3740a;
        return context == null ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void a(Context context) {
        f3740a = context;
    }

    public static void b(String str, String str2, int i) {
        SharedPreferences.Editor edit = f3740a.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i);
        edit.apply();
    }

    public static void b(String str, String str2, long j) {
        SharedPreferences.Editor edit = f3740a.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j);
        edit.apply();
    }

    public static void b(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f3740a.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }
}
