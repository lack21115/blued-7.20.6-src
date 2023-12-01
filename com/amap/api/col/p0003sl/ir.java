package com.amap.api.col.p0003sl;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.amap.api.col.3sl.ir  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ir.class */
public final class ir {

    /* renamed from: a  reason: collision with root package name */
    private static volatile iq f5177a;
    private static Properties b = b();

    private ir() {
    }

    public static iq a() {
        if (f5177a == null) {
            synchronized (ir.class) {
                try {
                    if (f5177a == null) {
                        try {
                            iq a2 = a(Build.MANUFACTURER);
                            if ("".equals(a2.a())) {
                                Iterator it = Arrays.asList(iq.MIUI.a(), iq.Flyme.a(), iq.EMUI.a(), iq.ColorOS.a(), iq.FuntouchOS.a(), iq.SmartisanOS.a(), iq.AmigoOS.a(), iq.Sense.a(), iq.LG.a(), iq.Google.a(), iq.NubiaUI.a()).iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        a2 = iq.Other;
                                        break;
                                    }
                                    a2 = a((String) it.next());
                                    if (!"".equals(a2.a())) {
                                        break;
                                    }
                                }
                            }
                            f5177a = a2;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5177a;
    }

    private static iq a(String str) {
        if (str == null || str.length() <= 0) {
            return iq.Other;
        }
        if (str.equals(iq.MIUI.a())) {
            iq iqVar = iq.MIUI;
            if (a(iqVar)) {
                return iqVar;
            }
        } else if (str.equals(iq.Flyme.a())) {
            iq iqVar2 = iq.Flyme;
            if (b(iqVar2)) {
                return iqVar2;
            }
        } else if (str.equals(iq.EMUI.a())) {
            iq iqVar3 = iq.EMUI;
            if (c(iqVar3)) {
                return iqVar3;
            }
        } else if (str.equals(iq.ColorOS.a())) {
            iq iqVar4 = iq.ColorOS;
            if (d(iqVar4)) {
                return iqVar4;
            }
        } else if (str.equals(iq.FuntouchOS.a())) {
            iq iqVar5 = iq.FuntouchOS;
            if (e(iqVar5)) {
                return iqVar5;
            }
        } else if (str.equals(iq.SmartisanOS.a())) {
            iq iqVar6 = iq.SmartisanOS;
            if (f(iqVar6)) {
                return iqVar6;
            }
        } else if (str.equals(iq.AmigoOS.a())) {
            iq iqVar7 = iq.AmigoOS;
            if (g(iqVar7)) {
                return iqVar7;
            }
        } else if (str.equals(iq.EUI.a())) {
            iq iqVar8 = iq.EUI;
            if (h(iqVar8)) {
                return iqVar8;
            }
        } else if (str.equals(iq.Sense.a())) {
            iq iqVar9 = iq.Sense;
            if (i(iqVar9)) {
                return iqVar9;
            }
        } else if (str.equals(iq.LG.a())) {
            iq iqVar10 = iq.LG;
            if (j(iqVar10)) {
                return iqVar10;
            }
        } else if (str.equals(iq.Google.a())) {
            iq iqVar11 = iq.Google;
            if (k(iqVar11)) {
                return iqVar11;
            }
        } else if (str.equals(iq.NubiaUI.a())) {
            iq iqVar12 = iq.NubiaUI;
            if (l(iqVar12)) {
                return iqVar12;
            }
        }
        return iq.Other;
    }

    private static void a(iq iqVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                iqVar.a(group);
                iqVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(iq iqVar) {
        if (TextUtils.isEmpty(b(XmSystemUtils.KEY_VERSION_MIUI))) {
            return false;
        }
        String b2 = b("ro.build.version.incremental");
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static String b(String str) {
        Properties properties = b;
        String property = properties.getProperty("[" + str + "]", null);
        return TextUtils.isEmpty(property) ? c(str) : property.replace("[", "").replace("]", "");
    }

    private static Properties b() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return properties;
        }
    }

    private static boolean b(iq iqVar) {
        String b2 = b("ro.flyme.published");
        String b3 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(b2) && TextUtils.isEmpty(b3)) {
            return false;
        }
        String b4 = b("ro.build.display.id");
        a(iqVar, b4);
        iqVar.b(b4);
        return true;
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (IOException e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
                return readLine;
            } catch (IOException e2) {
                return readLine;
            }
        } catch (IOException e3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e4) {
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
                }
            }
            throw th;
        }
    }

    private static boolean c(iq iqVar) {
        String b2 = b("ro.build.version.emui");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean d(iq iqVar) {
        String b2 = b("ro.build.version.opporom");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean e(iq iqVar) {
        String b2 = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean f(iq iqVar) {
        String b2 = b("ro.smartisan.version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean g(iq iqVar) {
        String b2 = b("ro.build.display.id");
        if (TextUtils.isEmpty(b2) || !b2.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean h(iq iqVar) {
        String b2 = b("ro.letv.release.version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean i(iq iqVar) {
        String b2 = b("ro.build.sense.version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean j(iq iqVar) {
        String b2 = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }

    private static boolean k(iq iqVar) {
        if ("android-google".equals(b("ro.com.google.clientidbase"))) {
            String b2 = b(TPSystemInfo.KEY_PROPERTY_VERSION_RELEASE);
            iqVar.a(Build.VERSION.SDK_INT);
            iqVar.b(b2);
            return true;
        }
        return false;
    }

    private static boolean l(iq iqVar) {
        String b2 = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(iqVar, b2);
        iqVar.b(b2);
        return true;
    }
}
