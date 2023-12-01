package com.igexin.assist.control.xiaomi;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/xiaomi/XmSystemUtils.class */
public class XmSystemUtils {
    public static final String KEY_VERSION_CODE = "ro.miui.ui.version.code";
    public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String XIAOMI = "Xiaomi".toLowerCase();
    private static Boolean isXiaoMi;

    private static String getProp(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Exception e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
                return readLine;
            } catch (IOException e2) {
                e2.printStackTrace();
                return readLine;
            }
        } catch (Exception e3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            bufferedReader2 = bufferedReader;
            th = th2;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isBrandXiaoMi() {
        try {
            if (isXiaoMi != null) {
                return isXiaoMi.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(isMIUI());
            isXiaoMi = valueOf;
            return valueOf.booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean isMIUI() {
        return (TextUtils.isEmpty(getProp(KEY_VERSION_MIUI)) && TextUtils.isEmpty(getProp(KEY_VERSION_CODE))) ? false : true;
    }
}
