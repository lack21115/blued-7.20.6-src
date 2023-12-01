package com.tencent.tendinsv.tool;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f25399a = "ssoconfigs";
    private static Context b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/m$a.class */
    static class a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f25400a;

        private a() {
            this.f25400a = m.b.getSharedPreferences(m.f25399a, 0).edit();
        }

        private String a(String str) {
            return com.tencent.tendinsv.utils.i.a(str);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.f25400a.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            return this.f25400a.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.f25400a.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            return this.f25400a.putBoolean(a(str), z);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            return this.f25400a.putFloat(a(str), f);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            return this.f25400a.putInt(a(str), i);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            return this.f25400a.putLong(a(str), j);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            return this.f25400a.putString(a(str), str2);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return this.f25400a.putStringSet(a(str), set);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            return this.f25400a.remove(a(str));
        }
    }

    public static int a(String str, int i) {
        return b.getSharedPreferences(f25399a, 0).getInt(com.tencent.tendinsv.utils.i.a(str), i);
    }

    public static SharedPreferences.Editor a() {
        return new a();
    }

    public static void a(Context context) {
        b = context.getApplicationContext();
    }

    static void a(String str) {
        b.getSharedPreferences(f25399a, 0).edit().remove(com.tencent.tendinsv.utils.i.a(str)).apply();
    }

    public static void a(String str, long j) {
        b.getSharedPreferences(f25399a, 0).edit().putLong(com.tencent.tendinsv.utils.i.a(str), j).apply();
    }

    public static void a(String str, String str2) {
        b.getSharedPreferences(f25399a, 0).edit().putString(com.tencent.tendinsv.utils.i.a(str), str2).apply();
    }

    public static void a(String str, boolean z) {
        b.getSharedPreferences(f25399a, 0).edit().putBoolean(com.tencent.tendinsv.utils.i.a(str), z).apply();
    }

    public static long b(String str, long j) {
        return b.getSharedPreferences(f25399a, 0).getLong(com.tencent.tendinsv.utils.i.a(str), j);
    }

    public static String b(String str, String str2) {
        return b.getSharedPreferences(f25399a, 0).getString(com.tencent.tendinsv.utils.i.a(str), str2);
    }
}
