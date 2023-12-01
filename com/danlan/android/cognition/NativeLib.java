package com.danlan.android.cognition;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/NativeLib.class */
public class NativeLib {
    private static boolean initSuccess = false;

    public static native String ac(Method method);

    public static native String ce(Context context);

    public static native int cf(String str);

    public static boolean checkLoadSo() {
        if (initSuccess) {
            return true;
        }
        loadSo();
        return initSuccess;
    }

    public static native String ck();

    public static native String cr();

    public static native String ft(String str);

    public static boolean getSoLoadStatus() {
        return initSuccess;
    }

    public static native String gm();

    public static native String[] gn();

    public static void loadSo() {
        try {
            System.loadLibrary(StringFog.decrypt("UkZHfEdKSkZEUQ=="));
            initSuccess = true;
        } catch (Throwable th) {
            initSuccess = false;
            th.printStackTrace();
        }
    }

    public static native String pg(String str, String str2);

    public static native String pi();
}
