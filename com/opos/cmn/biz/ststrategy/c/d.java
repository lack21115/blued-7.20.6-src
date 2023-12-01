package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/c/d.class */
public final class d {
    public static long a(Context context) {
        long j = 30;
        if (context != null) {
            SharedPreferences g = g(context);
            long j2 = 30;
            if (g != null) {
                try {
                    j2 = g.getLong("nxLimitNew", 30L);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("SPUtil", "", e);
                    j = 30;
                }
            }
            if (j2 < 15) {
                return 15L;
            }
            j = j2;
            if (j2 > 10080) {
                return 10080L;
            }
        }
        return j;
    }

    public static void a(Context context, int i) {
        SharedPreferences g;
        if (context == null || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putInt("dtLimit", i);
        edit.apply();
    }

    public static void a(Context context, long j) {
        SharedPreferences g;
        if (context == null || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        int i = (j > 15L ? 1 : (j == 15L ? 0 : -1));
        if (i < 0 || j > 10080) {
            j = i < 0 ? 15L : j > 10080 ? 10080L : 30L;
        }
        edit.putLong("nxLimitNew", j);
        edit.apply();
    }

    public static void a(Context context, String str) {
        SharedPreferences g = g(context);
        if (context == null || g == null || str == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("SPUtil", "setLastRegion=" + str);
        SharedPreferences.Editor edit = g.edit();
        edit.putString("lastRegion", str);
        edit.apply();
    }

    public static void a(Context context, String str, long j) {
        SharedPreferences g;
        if (context == null || TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putLong("lastTime_" + str, j);
        edit.apply();
    }

    public static long b(Context context, String str) {
        long j = 0;
        if (context != null) {
            j = 0;
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences g = g(context);
                j = 0;
                if (g != null) {
                    j = g.getLong("lastTime_" + str, 0L);
                }
            }
        }
        return j;
    }

    public static String b(Context context) {
        SharedPreferences g = g(context);
        String string = g != null ? g.getString("lastRegion", "") : "";
        com.opos.cmn.an.f.a.b("SPUtil", "getLastRegion=" + string);
        return string;
    }

    public static void b(Context context, int i) {
        SharedPreferences g;
        if (context == null || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putInt("blackListLimit", i);
        edit.apply();
    }

    public static void b(Context context, String str, long j) {
        SharedPreferences g;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || (g = g(context)) == null) {
                    return;
                }
                SharedPreferences.Editor edit = g.edit();
                edit.putLong("curr_" + str, j);
                edit.apply();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("SPUtil", "", e);
            }
        }
    }

    public static int c(Context context) {
        int i = 60;
        if (context != null) {
            SharedPreferences g = g(context);
            i = 60;
            if (g != null) {
                i = g.getInt("dtLimit", 60);
            }
        }
        return i;
    }

    public static long c(Context context, String str) {
        SharedPreferences g;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || (g = g(context)) == null) {
                    return 0L;
                }
                return g.getLong("curr_" + str, 0L);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("SPUtil", "", e);
                return 0L;
            }
        }
        return 0L;
    }

    public static void c(Context context, String str, long j) {
        SharedPreferences g;
        if (context == null || TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putLong("firReq_" + str, j);
        edit.apply();
    }

    public static int d(Context context) {
        int i = 2880;
        if (context != null) {
            SharedPreferences g = g(context);
            i = 2880;
            if (g != null) {
                i = g.getInt("blackListLimit", 2880);
            }
        }
        return i;
    }

    public static long d(Context context, String str) {
        long j = 0;
        if (context != null) {
            j = 0;
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences g = g(context);
                j = 0;
                if (g != null) {
                    j = g.getLong("firReq_" + str, 0L);
                }
            }
        }
        return j;
    }

    public static void d(Context context, String str, long j) {
        SharedPreferences g;
        if (context == null || TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putLong("firDTLimit_" + str, j);
        edit.apply();
    }

    public static long e(Context context, String str) {
        long j = 0;
        if (context != null) {
            j = 0;
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences g = g(context);
                j = 0;
                if (g != null) {
                    j = g.getLong("firDTLimit_" + str, 0L);
                }
            }
        }
        return j;
    }

    public static void e(Context context) {
        SharedPreferences g;
        if (context == null || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putBoolean("isWbsVer", true);
        edit.apply();
    }

    public static boolean f(Context context) {
        boolean z = false;
        if (context != null) {
            SharedPreferences g = g(context);
            z = false;
            if (g != null) {
                z = g.getBoolean("isWbsVer", false);
            }
        }
        return z;
    }

    private static final SharedPreferences g(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("com.opos.st.strategy.prefs", 0);
    }
}
