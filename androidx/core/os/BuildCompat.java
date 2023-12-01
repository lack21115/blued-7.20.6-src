package androidx.core.os;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/BuildCompat.class */
public class BuildCompat {

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/BuildCompat$PrereleaseSdkCheck.class */
    public @interface PrereleaseSdkCheck {
    }

    private BuildCompat() {
    }

    protected static boolean a(String str, String str2) {
        boolean z = false;
        if ("REL".equals(str2)) {
            return false;
        }
        if (str2.compareTo(str) >= 0) {
            z = true;
        }
        return z;
    }

    @Deprecated
    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Deprecated
    public static boolean isAtLeastNMR1() {
        return Build.VERSION.SDK_INT >= 25;
    }

    @Deprecated
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Deprecated
    public static boolean isAtLeastOMR1() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @Deprecated
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @Deprecated
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Deprecated
    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31 || a(ExifInterface.LATITUDE_SOUTH, Build.VERSION.CODENAME);
    }

    public static boolean isAtLeastT() {
        return a(ExifInterface.GPS_DIRECTION_TRUE, Build.VERSION.CODENAME);
    }
}
