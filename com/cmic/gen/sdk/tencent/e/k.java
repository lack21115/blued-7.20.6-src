package com.cmic.gen.sdk.tencent.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static Context f21668a;

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/k$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final SharedPreferences.Editor f21669a;

        a(SharedPreferences.Editor editor) {
            this.f21669a = editor;
        }

        public void a() {
            this.f21669a.apply();
        }

        public void a(String str) {
            this.f21669a.remove(d.a(str));
        }

        public void a(String str, int i) {
            this.f21669a.putInt(d.a(str), i);
        }

        public void a(String str, long j) {
            this.f21669a.putLong(d.a(str), j);
        }

        public void a(String str, String str2) {
            this.f21669a.putString(d.a(str), str2);
        }

        public void b() {
            this.f21669a.commit();
        }

        public void c() {
            this.f21669a.clear();
        }
    }

    public static int a(String str, int i) {
        return f21668a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static int a(String str, String str2, int i) {
        return f21668a.getSharedPreferences(str, 0).getInt(d.a(str2), i);
    }

    public static long a(String str, long j) {
        return f21668a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    public static long a(String str, String str2, long j) {
        return f21668a.getSharedPreferences(str, 0).getLong(d.a(str2), j);
    }

    public static a a() {
        return new a(f21668a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    public static String a(String str, String str2, String str3) {
        return f21668a.getSharedPreferences(str, 0).getString(d.a(str2), str3);
    }

    public static void a(Context context) {
        f21668a = context.getApplicationContext();
    }

    public static void a(String str) {
        SharedPreferences sharedPreferences = f21668a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().remove(d.a(str)).commit();
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f21668a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static void a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = f21668a.getSharedPreferences("ssoconfigs", 0).edit();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            String a2 = d.a(str);
            if (obj instanceof String) {
                edit.putString(a2, (String) obj);
            } else if (obj instanceof Integer) {
                edit.putInt(a2, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(a2, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(a2, ((Boolean) obj).booleanValue());
            }
        }
        edit.commit();
    }

    public static a b(String str) {
        return new a(f21668a.getSharedPreferences(str, 0).edit());
    }

    public static String b(String str, String str2) {
        return f21668a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }
}
