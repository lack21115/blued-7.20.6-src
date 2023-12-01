package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/common/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f40909a;
    private static Context b;

    /* renamed from: c  reason: collision with root package name */
    private static String f40910c;
    private static final String d = at.b().b("user");

    public d(Context context) {
    }

    public static d a(Context context) {
        d dVar;
        synchronized (d.class) {
            try {
                b = context.getApplicationContext();
                f40910c = context.getPackageName();
                if (f40909a == null) {
                    f40909a = new d(context);
                }
                dVar = f40909a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    private SharedPreferences f() {
        Context context = b;
        return context.getSharedPreferences(d + f40910c, 0);
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
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
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f = f();
            String string = f.getString("au_p", null);
            String string2 = f.getString("au_u", null);
            if (string == null || string2 == null) {
                return null;
            }
            return new String[]{string, string2};
        } catch (Exception e) {
            return null;
        }
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }
}
