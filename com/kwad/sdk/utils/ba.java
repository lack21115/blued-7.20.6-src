package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ba.class */
public class ba {
    static final String TAG = ba.class.getSimpleName();

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, long j) {
        eN(str).edit().putLong(str2, j).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, String str3, boolean z) {
        String str4 = str3;
        if (z) {
            str4 = str3;
            if (!com.kwad.sdk.core.kwai.c.bY(str3)) {
                str4 = com.kwad.sdk.core.kwai.c.bW(str3);
            }
        }
        eN(str).edit().putString(str2, str4).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences.Editor edit = eN(str).edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ae(String str, String str2) {
        eN(str).edit().remove(str2).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(String str, String str2, long j) {
        return eN(str).getLong(str2, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, int i) {
        eN(str).edit().putInt(str2, i).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(String str, String str2, int i) {
        return eN(str).getInt(str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SharedPreferences eN(String str) {
        return ServiceProvider.CA().getSharedPreferences(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(String str, String str2, String str3) {
        String string = eN(str).getString(str2, str3);
        if (string != null && !TextUtils.isEmpty(string)) {
            String str4 = string;
            if (!TextUtils.equals(string, str3)) {
                str4 = string;
                if (com.kwad.sdk.core.kwai.c.bY(string)) {
                    str4 = com.kwad.sdk.core.kwai.c.bX(string);
                }
            }
            return str4;
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(String str, String str2, boolean z) {
        eN(str).edit().putBoolean(str2, z).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(String str, String str2, String str3) {
        if (com.kwad.sdk.core.kwai.c.bY(str)) {
            return;
        }
        g(str2, str3, com.kwad.sdk.core.kwai.c.bW(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(String str, String str2, boolean z) {
        return eN(str).getBoolean(str2, z);
    }
}
