package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bb.class */
public final class bb {
    private static final SimpleDateFormat aAC = new SimpleDateFormat("MM/dd", Locale.US);
    private static final SimpleDateFormat aAD = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    private static final SimpleDateFormat aAE = new SimpleDateFormat("MM月dd日", Locale.US);
    private static final SimpleDateFormat aAF = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    private static final SimpleDateFormat aAG = new SimpleDateFormat("HH:mm", Locale.US);
    private static final SimpleDateFormat aAH = new SimpleDateFormat("MM-dd", Locale.US);
    private static final SimpleDateFormat aAI = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static boolean eO(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean eP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || com.igexin.push.core.b.l.equalsIgnoreCase(str);
    }
}
