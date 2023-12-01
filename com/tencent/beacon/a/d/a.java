package com.tencent.beacon.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/d/a.class */
public class a implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f21259a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private g f21260c;
    private SharedPreferences$EditorC0725a d;
    private SharedPreferences e;

    /* renamed from: com.tencent.beacon.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/d/a$a.class */
    public static class SharedPreferences$EditorC0725a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private g f21261a;

        SharedPreferences$EditorC0725a(g gVar) {
            this.f21261a = gVar;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f21261a.a();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f21261a.b(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.f21261a.b(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.f21261a.b(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.f21261a.b(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.f21261a.b(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            this.f21261a.b(str, (Set) set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f21261a.b(str);
            return this;
        }
    }

    private a() {
    }

    public static a a() {
        if (f21259a == null) {
            synchronized (a.class) {
                try {
                    if (f21259a == null) {
                        f21259a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21259a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r8 == r7) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> java.lang.Object a(java.lang.String r6, T r7) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.a.d.a.a(java.lang.String, java.lang.Object):java.lang.Object");
    }

    public void a(Context context) {
        synchronized (this) {
            if (this.b || context == null) {
                return;
            }
            try {
                String replace = com.tencent.beacon.a.c.b.c(context).replace(context.getPackageName(), "");
                StringBuilder sb = new StringBuilder();
                sb.append("prop_");
                sb.append(replace);
                g a2 = g.a(context, sb.toString());
                this.f21260c = a2;
                this.d = new SharedPreferences$EditorC0725a(a2);
                this.b = true;
            } catch (IOException e) {
                com.tencent.beacon.base.util.c.a(e);
                com.tencent.beacon.a.b.g.e().a("504", "[properties] PropertiesFile create error!", e);
                this.b = false;
            }
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f21260c.a(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences$EditorC0725a edit() {
        if (!this.b) {
            com.tencent.beacon.base.util.e.a("BeaconProperties has not init!");
            a(com.tencent.beacon.a.c.c.d().c());
        }
        return this.d;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f21260c.b();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object a2 = a(str, Boolean.valueOf(z));
        if (a2 instanceof Boolean) {
            z = ((Boolean) a2).booleanValue();
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object a2 = a(str, Float.valueOf(f));
        if (a2 instanceof Number) {
            f = ((Number) a2).floatValue();
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object a2 = a(str, Integer.valueOf(i));
        if (a2 instanceof Number) {
            i = ((Number) a2).intValue();
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object a2 = a(str, Long.valueOf(j));
        if (a2 instanceof Number) {
            j = ((Number) a2).longValue();
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object a2 = a(str, str2);
        if (a2 instanceof String) {
            str2 = (String) a2;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return !this.b ? set : this.f21260c.a(str, (Set) set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
