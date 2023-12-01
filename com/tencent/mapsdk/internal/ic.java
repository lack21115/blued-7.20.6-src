package com.tencent.mapsdk.internal;

import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ic.class */
public abstract class ic {
    private static final String b = "%s-%s-%s,%s-%s-%s,%s-%s-%s";

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f23862a = null;

    public int a(String str, int i) {
        SharedPreferences sharedPreferences = this.f23862a;
        return sharedPreferences == null ? i : sharedPreferences.getInt(str, i);
    }

    public String a() {
        return String.format(b, k4.i, Integer.valueOf(b(m4.f23936a)), d(m4.t), k4.l, Integer.valueOf(b("indoormap_style_version")), d("indoormap_style_md5"), k4.m, Integer.valueOf(b("indoormap_style_night_version")), d("indoormap_style_night_md5"));
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str, str2);
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    public boolean a(String str, long j) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putLong(str, j).commit();
    }

    public boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putBoolean(str, z).commit();
    }

    public boolean a(String[] strArr) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : strArr) {
            edit.remove(str);
        }
        return edit.commit();
    }

    public int b(String str) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(str, -1);
    }

    public boolean b() {
        return a(new String[]{m4.f23936a, m4.f23937c, m4.d, m4.q, m4.r, m4.s, m4.t, m4.u, m4.v, m4.w, m4.x, m4.y});
    }

    public boolean b(String str, int i) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putInt(str, i).commit();
    }

    public boolean b(String str, String str2) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putString(str, str2).commit();
    }

    public long c(String str) {
        SharedPreferences sharedPreferences = this.f23862a;
        if (sharedPreferences == null) {
            return -1L;
        }
        return sharedPreferences.getLong(str, -1L);
    }

    public String d(String str) {
        return a(str, (String) null);
    }
}
