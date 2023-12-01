package com.tencent.cloud.huiyansdkface.facelight.c;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.tendinsv.utils.r;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f35538a = "";
    private static String b = "";

    public static String a(String str) {
        if (TextUtils.isEmpty(f35538a)) {
            d(str);
        }
        return f35538a + b;
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void d(String str) {
        String str2;
        try {
            String b2 = b(str);
            boolean z = true;
            switch (b2.hashCode()) {
                case -1881642058:
                    if (b2.equals("REALME")) {
                        z = true;
                        break;
                    }
                    break;
                case -1706170181:
                    if (b2.equals("XIAOMI")) {
                        z = true;
                        break;
                    }
                    break;
                case -602397472:
                    if (b2.equals("ONEPLUS")) {
                        z = true;
                        break;
                    }
                    break;
                case 2432928:
                    if (b2.equals(r.d)) {
                        z = true;
                        break;
                    }
                    break;
                case 2634924:
                    if (b2.equals(r.f)) {
                        z = true;
                        break;
                    }
                    break;
                case 68924490:
                    if (b2.equals("HONOR")) {
                        z = true;
                        break;
                    }
                    break;
                case 73239724:
                    if (b2.equals("MEIZU")) {
                        z = true;
                        break;
                    }
                    break;
                case 74632627:
                    if (b2.equals("NUBIA")) {
                        z = true;
                        break;
                    }
                    break;
                case 77852109:
                    if (b2.equals("REDMI")) {
                        z = true;
                        break;
                    }
                    break;
                case 2141820391:
                    if (b2.equals("HUAWEI")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (!a()) {
                        f35538a = r.b;
                        str2 = c("ro.build.version.emui");
                        break;
                    } else {
                        b = c("hw_sc.build.platform.version");
                        f35538a = "HarmonyOS";
                        return;
                    }
                case true:
                    if (!a()) {
                        if (!TextUtils.isEmpty(c("ro.build.version.magic"))) {
                            f35538a = "MagicUI";
                            str2 = c("ro.build.version.magic");
                            break;
                        } else {
                            f35538a = r.b;
                            str2 = c("ro.build.version.emui");
                            break;
                        }
                    } else {
                        f35538a = "HarmonyOS";
                        if (!TextUtils.isEmpty(c("hw_sc.build.platform.version"))) {
                            str2 = c("hw_sc.build.platform.version");
                            break;
                        } else {
                            str2 = "";
                            break;
                        }
                    }
                case true:
                case true:
                    f35538a = r.f39112a;
                    str2 = c(XmSystemUtils.KEY_VERSION_MIUI) + " " + c("ro.build.version.incremental");
                    break;
                case true:
                case true:
                    f35538a = "ColorOS";
                    str2 = c("ro.build.version.opporom");
                    break;
                case true:
                    f35538a = "Funtouch";
                    str2 = c("ro.vivo.os.version");
                    break;
                case true:
                    f35538a = "HydrogenOS";
                    str2 = c("ro.rom.version");
                    break;
                case true:
                    f35538a = "Flyme";
                    str2 = c("ro.build.display.id");
                    break;
                case true:
                    f35538a = c("ro.build.nubia.rom.name");
                    str2 = c("ro.build.nubia.rom.code");
                    break;
                default:
                    f35538a = "Android";
                    str2 = Build.VERSION.RELEASE;
                    break;
            }
            b = str2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
