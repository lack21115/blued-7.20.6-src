package skin.support.utils;

import android.util.Log;

/* loaded from: source-3503164-dex2jar.jar:skin/support/utils/Slog.class */
public class Slog {
    public static boolean a = false;

    public static void a(String str) {
        if (a) {
            Log.i("skin-support", str);
        }
    }

    public static void a(String str, String str2) {
        if (a) {
            Log.i("skin-support", str + ": " + str2);
        }
    }
}
