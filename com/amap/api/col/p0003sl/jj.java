package com.amap.api.col.p0003sl;

import android.app.backup.FullBackup;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.d;
import java.util.Arrays;

/* renamed from: com.amap.api.col.3sl.jj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jj.class */
public final class jj {

    /* renamed from: a  reason: collision with root package name */
    static byte[] f5211a;
    static byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private String f5212c;

    public jj(String str) {
        this.f5212c = hw.b(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static int a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            iw.c(th, d.r, "giv");
            return i;
        }
    }

    public static SharedPreferences.Editor a(Context context, String str) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return context.getSharedPreferences(str, 0).edit();
            } catch (Throwable th) {
                it.a(th, FullBackup.SHAREDPREFS_TREE_TOKEN, "ge");
                return null;
            }
        }
        return null;
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return ib.a(b(context, ib.d(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable th) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, ib.g(a(context, ib.a(str3))));
            a(edit);
        } catch (Throwable th) {
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            it.a(th, FullBackup.SHAREDPREFS_TREE_TOKEN, "cm");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                it.a(th, FullBackup.SHAREDPREFS_TREE_TOKEN, "rk");
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            iw.c(th, d.r, "putPrefsInt");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            iw.c(th, d.r, "plv");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                editor.putString(str, str2);
            } catch (Throwable th) {
                it.a(th, FullBackup.SHAREDPREFS_TREE_TOKEN, "ps");
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            iw.c(th, d.r, "setPrefsStr");
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            iw.c(th, d.r, "gbv");
            return z;
        }
    }

    private static byte[] a(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f5211a;
        if (bArr == null || bArr.length <= 0) {
            byte[] bytes = ho.f(context).getBytes();
            f5211a = bytes;
            return bytes;
        }
        return bArr;
    }

    public static byte[] a(Context context, byte[] bArr) {
        try {
            return ht.b(a(context), bArr, b(context));
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    public static long b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, 0L);
        } catch (Throwable th) {
            iw.c(th, d.r, "glv");
            return 0L;
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            iw.c(th, d.r, "gsv");
            return str3;
        }
    }

    private static byte[] b(Context context) {
        byte[] bArr = b;
        if (bArr == null || bArr.length <= 0) {
            int i = 0;
            if (Build.VERSION.SDK_INT < 9) {
                b = new byte[a(context).length / 2];
                while (true) {
                    byte[] bArr2 = b;
                    if (i >= bArr2.length) {
                        break;
                    }
                    bArr2[i] = a(context)[i];
                    i++;
                }
            } else {
                b = Arrays.copyOfRange(a(context), 0, a(context).length / 2);
            }
            return b;
        }
        return bArr;
    }

    public static byte[] b(Context context, byte[] bArr) {
        try {
            return ht.a(a(context), bArr, b(context));
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
