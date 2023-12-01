package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.kuaishou.weapon.p0.do  reason: invalid class name */
/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/do.class */
public class Cdo {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10221a = "plc001_t_re";
    public static final String b = "wlpauct2";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10222c = "plc001_pd_ptip_pi";
    public static final String d = "wiipaot";
    public static final int e = 1;
    public static final String f = "a1_p_s_p_s";
    public static final String g = "a1_p_s_p_s_c_b";
    private static Cdo j;
    private SharedPreferences h;
    private SharedPreferences.Editor i;

    private Cdo(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(bh.r, 4);
            this.h = sharedPreferences;
            this.i = sharedPreferences.edit();
        } catch (Throwable th) {
        }
    }

    public static Cdo a() {
        return j;
    }

    public static Cdo a(Context context) {
        Cdo cdo;
        synchronized (Cdo.class) {
            try {
                if (j == null) {
                    j = new Cdo(context);
                }
                cdo = j;
            } catch (Exception e2) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cdo;
    }

    public int a(String str, int i) {
        try {
            return this.h.getInt(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    public long a(String str) {
        return this.h.getLong(str, 0L);
    }

    public String a(String str, String str2) {
        return this.h.getString(str, str2);
    }

    public void a(String str, int i, boolean z) {
        try {
            this.i.putInt(str, i);
            if (z) {
                this.i.apply();
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, long j2, boolean z) {
        try {
            this.i.putLong(str, j2);
            if (z) {
                this.i.apply();
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, Boolean bool, boolean z) {
        try {
            if (this.i != null) {
                this.i.putBoolean(str, bool.booleanValue());
                if (z) {
                    this.i.apply();
                }
            }
        } catch (Exception e2) {
        }
    }

    public void b(String str, String str2) {
        try {
            this.i.putString(str, str2);
            this.i.apply();
        } catch (Exception e2) {
        }
    }

    public boolean b(String str) {
        return this.h.getBoolean(str, false);
    }
}
