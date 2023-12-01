package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.tencent.thumbplayer.core.common.TPSystemInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/as.class */
public final class as {
    private static String aAk;
    private static String aAl;

    public static boolean DQ() {
        return aV(com.tencent.tendinsv.utils.r.b);
    }

    public static boolean DR() {
        return aV(com.tencent.tendinsv.utils.r.f39112a);
    }

    public static boolean DS() {
        return aV(com.tencent.tendinsv.utils.r.f39113c);
    }

    private static boolean aV(String str) {
        String upperCase;
        String str2 = aAk;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bc.get("ro.build.version.opporom");
        aAl = str3;
        if (TextUtils.isEmpty(str3)) {
            String str4 = bc.get("ro.vivo.os.version");
            aAl = str4;
            if (TextUtils.isEmpty(str4)) {
                String str5 = bc.get("ro.build.version.emui");
                aAl = str5;
                if (TextUtils.isEmpty(str5)) {
                    String str6 = bc.get(XmSystemUtils.KEY_VERSION_MIUI);
                    aAl = str6;
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = bc.get("ro.product.system.manufacturer");
                        aAl = str7;
                        if (TextUtils.isEmpty(str7)) {
                            String str8 = bc.get("ro.smartisan.version");
                            aAl = str8;
                            if (TextUtils.isEmpty(str8)) {
                                String str9 = "SAMSUNG";
                                if (!bc.get(TPSystemInfo.KEY_PROPERTY_MANUFACTURER).toUpperCase().contains("SAMSUNG")) {
                                    String str10 = Build.DISPLAY;
                                    aAl = str10;
                                    String upperCase2 = str10.toUpperCase();
                                    str9 = com.tencent.tendinsv.utils.r.f39113c;
                                    if (!upperCase2.contains(com.tencent.tendinsv.utils.r.f39113c)) {
                                        aAl = "unknown";
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                aAk = str9;
                                return aAk.contains(str);
                            }
                            upperCase = com.tencent.tendinsv.utils.r.e;
                        } else {
                            upperCase = "OnePlus";
                        }
                    } else {
                        upperCase = com.tencent.tendinsv.utils.r.f39112a;
                    }
                } else {
                    upperCase = com.tencent.tendinsv.utils.r.b;
                }
            } else {
                upperCase = com.tencent.tendinsv.utils.r.f;
            }
        } else {
            upperCase = com.tencent.tendinsv.utils.r.d;
        }
        aAk = upperCase;
        return aAk.contains(str);
    }

    public static String getName() {
        if (aAk == null) {
            aV("");
        }
        return aAk;
    }

    public static String getVersion() {
        if (aAl == null) {
            aV("");
        }
        return aAl;
    }
}
