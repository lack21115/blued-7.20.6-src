package com.ss.android.socialbase.appdownloader.u;

import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.af;
import com.huawei.openalliance.ad.constant.t;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.ss.android.socialbase.appdownloader.ko;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.tendinsv.utils.r;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/hj.class */
public class hj {
    public static String b;
    private static String h;
    private static String hj = "";
    private static String ko;
    public static String mb;
    public static String ox = "";
    private static String u;

    public static String b(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
    }

    public static boolean b() {
        return mb(r.f);
    }

    public static boolean h() {
        return mb(r.f25422c);
    }

    public static String hj(String str) {
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.ENABLE_REFLECT_SYSTEM_PROPERTIES, true)) {
            try {
                return b(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return ox(str);
            }
        }
        return ox(str);
    }

    public static boolean hj() {
        lc();
        return mb(mb);
    }

    private static void io() {
        if (ko == null) {
            try {
                ko = hj(XmSystemUtils.KEY_VERSION_MIUI);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = ko;
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            ko = str2;
        }
    }

    public static String jb() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
    }

    public static boolean je() {
        io();
        return "V10".equals(ko);
    }

    public static String ko() {
        if (h == null) {
            mb("");
        }
        return h;
    }

    private static void lc() {
        if (TextUtils.isEmpty(mb)) {
            DownloadComponentManager.ensureOPPO();
            mb = DownloadConstants.UPPER_OPPO;
            hj = "ro.build.version." + DownloadConstants.LOWER_OPPO + "rom";
            ox = "com." + DownloadConstants.LOWER_OPPO + ".market";
        }
    }

    public static String lz() {
        if (b == null) {
            mb("");
        }
        return b;
    }

    public static boolean mb() {
        return mb(r.b);
    }

    public static boolean mb(String str) {
        lc();
        String str2 = h;
        if (str2 != null) {
            return str2.equals(str);
        }
        String hj2 = hj(XmSystemUtils.KEY_VERSION_MIUI);
        u = hj2;
        if (TextUtils.isEmpty(hj2)) {
            String hj3 = hj("ro.build.version.emui");
            u = hj3;
            if (TextUtils.isEmpty(hj3)) {
                String hj4 = hj(hj);
                u = hj4;
                if (TextUtils.isEmpty(hj4)) {
                    String hj5 = hj("ro.vivo.os.version");
                    u = hj5;
                    if (TextUtils.isEmpty(hj5)) {
                        String hj6 = hj("ro.smartisan.version");
                        u = hj6;
                        if (TextUtils.isEmpty(hj6)) {
                            String hj7 = hj("ro.gn.sv.version");
                            u = hj7;
                            if (TextUtils.isEmpty(hj7)) {
                                String hj8 = hj("ro.lenovo.lvp.version");
                                u = hj8;
                                if (!TextUtils.isEmpty(hj8)) {
                                    h = "LENOVO";
                                    b = "com.lenovo.leos.appstore";
                                } else if (x().toUpperCase().contains("SAMSUNG")) {
                                    h = "SAMSUNG";
                                    b = "com.sec.android.app.samsungapps";
                                } else if (x().toUpperCase().contains("ZTE")) {
                                    h = "ZTE";
                                    b = "zte.com.market";
                                } else if (x().toUpperCase().contains("NUBIA")) {
                                    h = "NUBIA";
                                    b = "cn.nubia.neostore";
                                } else if (jb().toUpperCase().contains(r.f25422c)) {
                                    h = r.f25422c;
                                    b = "com.meizu.mstore";
                                    u = jb();
                                } else if (x().toUpperCase().contains("ONEPLUS")) {
                                    h = "ONEPLUS";
                                    u = hj("ro.rom.version");
                                    if (ko.mb(ox) > -1) {
                                        b = ox;
                                    } else {
                                        b = af.e;
                                    }
                                } else {
                                    h = x().toUpperCase();
                                    b = "";
                                    u = "";
                                }
                            } else {
                                h = "QIONEE";
                                b = "com.gionee.aora.market";
                            }
                        } else {
                            h = r.e;
                            b = "com.smartisanos.appstore";
                        }
                    } else {
                        h = r.f;
                        b = "com.bbk.appstore";
                    }
                } else {
                    h = mb;
                    if (ko.mb(ox) > -1) {
                        b = ox;
                    } else {
                        b = af.e;
                    }
                }
            } else {
                h = r.b;
                b = t.W;
            }
        } else {
            h = r.f25421a;
            b = "com.xiaomi.market";
            ko = u;
        }
        return h.equals(str);
    }

    public static boolean nk() {
        io();
        return "V11".equals(ko);
    }

    public static boolean o() {
        io();
        return "V12".equals(ko);
    }

    public static String ox(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                DownloadUtils.safeClose(bufferedReader);
                return readLine;
            } catch (Throwable th) {
                DownloadUtils.safeClose(bufferedReader);
                return null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
    }

    public static boolean ox() {
        return mb(r.f25421a);
    }

    public static boolean u() {
        return mb("SAMSUNG");
    }

    public static String ww() {
        if (u == null) {
            mb("");
        }
        return u;
    }

    public static String x() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }
}
