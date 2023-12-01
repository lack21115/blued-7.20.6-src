package skin.support.utils;

import android.util.Log;

/* loaded from: source-3503164-dex2jar.jar:skin/support/utils/Slog.class */
public class Slog {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f44252a = false;

    public static void a(String str) {
        if (f44252a) {
            Log.i("skin-support", str);
        }
    }

    public static void a(String str, String str2) {
        if (f44252a) {
            Log.i("skin-support", str + ": " + str2);
        }
    }
}
