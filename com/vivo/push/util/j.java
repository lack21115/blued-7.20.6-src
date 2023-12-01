package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/j.class */
public final class j {
    private static Method e;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41136a = b("rom_1.0");
    public static final boolean b = b("rom_2.0");

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41137c = b("rom_2.5");
    public static final boolean d = b("rom_3.0");
    private static String f = null;
    private static String g = null;

    public static String a() {
        synchronized (j.class) {
            try {
                if (f == null && g == null) {
                    try {
                        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
                        e = declaredMethod;
                        declaredMethod.setAccessible(true);
                        f = (String) e.invoke(null, "ro.vivo.rom", "@><@");
                        g = (String) e.invoke(null, "ro.vivo.rom.version", "@><@");
                    } catch (Exception e2) {
                        p.b("Device", "getRomCode error");
                    }
                }
                p.d("Device", "sRomProperty1 : " + f + " ; sRomProperty2 : " + g);
                String a2 = a(f);
                if (TextUtils.isEmpty(a2)) {
                    String a3 = a(g);
                    boolean isEmpty = TextUtils.isEmpty(a3);
                    if (isEmpty) {
                        return null;
                    }
                    return a3;
                }
                return a2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append(matcher.group(1));
            sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
            return sb.toString();
        }
        return null;
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        String str4 = str2;
        if (str3 != null) {
            if (str3.length() == 0) {
                return str2;
            }
            str4 = str3;
        }
        return str4;
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        p.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith(AssistUtils.BRAND_VIVO);
    }

    private static boolean b(String str) {
        String b2 = z.b("ro.vivo.rom", "");
        String b3 = z.b("ro.vivo.rom.version", "");
        p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }
}
