package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/common/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f27135a;
    private static Context b;

    /* renamed from: c  reason: collision with root package name */
    private static String f27136c;
    private static final String d = at.b().b("user");

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/common/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f27137a = new b();

        private a() {
        }
    }

    public static b a(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (b == null && context != null) {
                    b = context.getApplicationContext();
                }
                if (b != null) {
                    f27136c = context.getPackageName();
                }
                bVar = a.f27137a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        edit.remove("debugkey");
        edit.remove("period");
        edit.remove("startTime");
        edit.clear();
        edit.commit();
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    private SharedPreferences e() {
        Context context = b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(d + f27136c, 0);
    }

    public void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String[] a() {
        SharedPreferences e = e();
        String[] strArr = null;
        if (e != null) {
            String string = e.getString("au_p", null);
            String string2 = e.getString("au_u", null);
            strArr = null;
            if (!TextUtils.isEmpty(string)) {
                strArr = null;
                if (!TextUtils.isEmpty(string2)) {
                    strArr = new String[]{string, string2};
                }
            }
        }
        return strArr;
    }

    public void b() {
        SharedPreferences e = e();
        if (e != null) {
            e.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }
}
