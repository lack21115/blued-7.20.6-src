package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.opos.acs.st.STManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f27853a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, m> f841a;
    private static int b = -1;

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a() {
        /*
            int r0 = com.xiaomi.push.j.f27853a
            if (r0 != 0) goto L4e
            java.lang.String r0 = "ro.miui.ui.version.code"
            java.lang.String r0 = m8995a(r0)     // Catch: java.lang.Throwable -> L2a
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L2a
            r6 = r0
            r0 = 1
            r5 = r0
            r0 = r6
            if (r0 == 0) goto L57
            java.lang.String r0 = "ro.miui.ui.version.name"
            java.lang.String r0 = m8995a(r0)     // Catch: java.lang.Throwable -> L2a
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L52
            goto L57
        L23:
            r0 = r4
            com.xiaomi.push.j.f27853a = r0     // Catch: java.lang.Throwable -> L2a
            goto L35
        L2a:
            r7 = move-exception
            java.lang.String r0 = "get isMIUI failed"
            r1 = r7
            com.xiaomi.channel.commonutils.logger.b.a(r0, r1)
            r0 = 0
            com.xiaomi.push.j.f27853a = r0
        L35:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "isMIUI's value is: "
            r1.<init>(r2)
            r7 = r0
            r0 = r7
            int r1 = com.xiaomi.push.j.f27853a
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.b(r0)
        L4e:
            int r0 = com.xiaomi.push.j.f27853a
            return r0
        L52:
            r0 = 0
            r4 = r0
            goto L59
        L57:
            r0 = 1
            r4 = r0
        L59:
            r0 = r4
            if (r0 == 0) goto L62
            r0 = r5
            r4 = r0
            goto L23
        L62:
            r0 = 2
            r4 = r0
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.j.a():int");
    }

    public static int a(Context context) {
        String m8995a = m8995a(XmSystemUtils.KEY_VERSION_CODE);
        if (TextUtils.isEmpty(m8995a) || !TextUtils.isDigitsOnly(m8995a)) {
            return 0;
        }
        return Integer.parseInt(m8995a);
    }

    public static m a(String str) {
        m b2 = b(str);
        m mVar = b2;
        if (b2 == null) {
            mVar = m.Global;
        }
        return mVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m8994a() {
        int a2 = r.a();
        return (!m8997a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        String a2;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a2 = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a2 = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a2 = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a2 = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a2 = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a2 = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a2 = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    a2 = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    a2 = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    a2 = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    a2 = a((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a2);
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m8995a(String str) {
        try {
            try {
                return (String) bi.a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. ".concat(String.valueOf(e)));
                return null;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m8996a() {
        if (f841a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f841a = hashMap;
        hashMap.put("CN", m.China);
        f841a.put("FI", m.Europe);
        f841a.put("SE", m.Europe);
        f841a.put("NO", m.Europe);
        f841a.put("FO", m.Europe);
        f841a.put("EE", m.Europe);
        f841a.put("LV", m.Europe);
        f841a.put("LT", m.Europe);
        f841a.put("BY", m.Europe);
        f841a.put("MD", m.Europe);
        f841a.put("UA", m.Europe);
        f841a.put("PL", m.Europe);
        f841a.put("CZ", m.Europe);
        f841a.put("SK", m.Europe);
        f841a.put("HU", m.Europe);
        f841a.put("DE", m.Europe);
        f841a.put("AT", m.Europe);
        f841a.put("CH", m.Europe);
        f841a.put("LI", m.Europe);
        f841a.put("GB", m.Europe);
        f841a.put("IE", m.Europe);
        f841a.put("NL", m.Europe);
        f841a.put("BE", m.Europe);
        f841a.put("LU", m.Europe);
        f841a.put("FR", m.Europe);
        f841a.put("RO", m.Europe);
        f841a.put("BG", m.Europe);
        f841a.put("RS", m.Europe);
        f841a.put("MK", m.Europe);
        f841a.put("AL", m.Europe);
        f841a.put("GR", m.Europe);
        f841a.put("SI", m.Europe);
        f841a.put("HR", m.Europe);
        f841a.put("IT", m.Europe);
        f841a.put("SM", m.Europe);
        f841a.put("MT", m.Europe);
        f841a.put("ES", m.Europe);
        f841a.put(AssistPushConsts.MSG_VALUE_PAYLOAD, m.Europe);
        f841a.put("AD", m.Europe);
        f841a.put("CY", m.Europe);
        f841a.put("DK", m.Europe);
        f841a.put("IS", m.Europe);
        f841a.put("UK", m.Europe);
        f841a.put("EL", m.Europe);
        f841a.put("RU", m.Russia);
        f841a.put(STManager.REGION_OF_IN, m.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8997a() {
        return a() == 1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8998a(Context context) {
        return context != null && m8999a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8999a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    private static m b(String str) {
        m8996a();
        return f841a.get(str.toUpperCase());
    }

    public static String b() {
        String a2 = q.a("ro.miui.region", "");
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = q.a("persist.sys.oppo.region", "");
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = q.a("ro.oppo.regionmark", "");
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = q.a("ro.vendor.oplus.regionmark", "");
        }
        String str4 = str3;
        if (TextUtils.isEmpty(str3)) {
            str4 = q.a(com.huawei.openalliance.ad.utils.j.Code, "");
        }
        String str5 = str4;
        if (TextUtils.isEmpty(str4)) {
            str5 = q.a("ro.csc.countryiso_code", "");
        }
        String str6 = str5;
        if (TextUtils.isEmpty(str5)) {
            str6 = m9000b(q.a("ro.product.country.region", ""));
        }
        String str7 = str6;
        if (TextUtils.isEmpty(str6)) {
            str7 = q.a("gsm.vivo.countrycode", "");
        }
        String str8 = str7;
        if (TextUtils.isEmpty(str7)) {
            str8 = q.a("persist.sys.oem.region", "");
        }
        String str9 = str8;
        if (TextUtils.isEmpty(str8)) {
            str9 = q.a("ro.product.locale.region", "");
        }
        String str10 = str9;
        if (TextUtils.isEmpty(str9)) {
            str10 = q.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(str10)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("get region from system, region = ".concat(String.valueOf(str10)));
        }
        String str11 = str10;
        if (TextUtils.isEmpty(str10)) {
            str11 = Locale.getDefault().getCountry();
            com.xiaomi.channel.commonutils.logger.b.m8344a("locale.default.country = ".concat(String.valueOf(str11)));
        }
        return str11;
    }

    /* renamed from: b  reason: collision with other method in class */
    private static String m9000b(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            str2 = str;
            if (split.length > 0) {
                str2 = split[0];
            }
        }
        return str2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m9001b() {
        return a() == 2;
    }

    public static String c() {
        return m8995a(XmSystemUtils.KEY_VERSION_MIUI);
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m9002c() {
        if (b < 0) {
            b = !m9004e() ? 1 : 0;
        }
        return b > 0;
    }

    public static String d() {
        return m8995a("ro.build.characteristics");
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m9003d() {
        return !m.China.name().equalsIgnoreCase(a(b()).name());
    }

    public static String e() {
        return m8995a(TPSystemInfo.KEY_PROPERTY_MANUFACTURER);
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m9004e() {
        String str = "";
        try {
            str = q.a(XmSystemUtils.KEY_VERSION_CODE, "");
        } catch (Exception e) {
        }
        return !TextUtils.isEmpty(str);
    }
}
