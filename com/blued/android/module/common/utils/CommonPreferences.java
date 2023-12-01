package com.blued.android.module.common.utils;

import com.amap.api.services.core.LatLonPoint;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.statistics.BluedStatistics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/CommonPreferences.class */
public class CommonPreferences {

    /* renamed from: a  reason: collision with root package name */
    public static BluedSharedPreferences f10875a;
    public static BluedSharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    public static BluedSharedPreferences f10876c;
    public static BluedSharedPreferences d;
    public static String e = "unit_setting";
    public static String f = "binding_account";
    public static String g = "binding_account_type";
    public static int h = 200;
    public static String i = "binding_start_num";
    public static String j = "download_time_";
    public static String k = "default_emotion_packs";
    public static String l = "emotions_pack";
    public static String m = "SHOW_SWITCH_UNREAD_MSG_RED_DOT";
    public static String n = "AV_CONFIG";
    public static String o = "longitude";
    public static String p = "latitude";
    public static String q = "current_city";
    public static String r = "current_province";
    public static String s = "current_address";

    public static void A(String str) {
        a().c().a(r, str).a();
    }

    public static void B(String str) {
        a().c().a(s, str).a();
    }

    public static int a(int i2) {
        return a().b("blued_chat_host_port", i2);
    }

    public static int a(int i2, Locale locale) {
        int i3 = i2;
        if (i2 == 0) {
            i3 = 1;
        }
        return i3;
    }

    public static BluedSharedPreferences a() {
        if (f10875a == null) {
            f10875a = BluedSharedPreferences.a();
        }
        return f10875a;
    }

    public static String a(String str) {
        return a().a("blued_http_host", str);
    }

    public static void a(double d2, double d3) {
        String u = u();
        String v = v();
        BluedSharedPreferences.Editor c2 = a().c();
        String str = o;
        c2.a(str, d2 + "").a();
        BluedSharedPreferences.Editor c3 = a().c();
        String str2 = p;
        c3.a(str2, d3 + "").a();
        BluedStatistics.a().d(String.valueOf(d2));
        BluedStatistics.a().c(String.valueOf(d3));
        try {
            a(Double.parseDouble(u), Double.parseDouble(v), d2, d3);
        } catch (Exception e2) {
        }
    }

    private static void a(double d2, double d3, double d4, double d5) {
        double a2 = DistanceUtils.a(d2, d3, d4, d5);
        long a3 = a().a("LAST_LOCATION_TIME_STAMP", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        double d6 = (currentTimeMillis - a3) / 3600000.0d;
        double d7 = a2 / d6;
        if ((d7 > 300.0d && a2 > 10.0d) || AppInfo.m()) {
            BluedStatistics.c().a("SPEED_OVER_GT", 0L, 0, "longLast=" + d2 + ",latLast=" + d3 + ",longNew=" + d4 + ",latNew=" + d5 + ",timeLast=" + a3 + ",timeCurrent=" + currentTimeMillis + ",distanceKM=" + a2 + ",timeHours=" + d6 + "，speed=" + d7);
        }
        a().c().a("LAST_LOCATION_TIME_STAMP", currentTimeMillis);
    }

    public static void a(long j2) {
        i().c().a(l, j2).a();
    }

    public static void a(String str, long j2) {
        BluedSharedPreferences.Editor c2 = i().c();
        c2.a(j + str, j2).a();
    }

    public static void a(boolean z) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(m + UserInfo.getInstance().getLoginUserInfo().uid, z).b();
    }

    public static BluedSharedPreferences b() {
        if (d == null) {
            d = BluedSharedPreferences.a("blued_sf_general_set", 0);
        }
        return d;
    }

    public static void b(int i2) {
        a().c().a("blued_chat_host_port", i2).a();
    }

    public static void b(String str) {
        a().c().a("blued_http_host", str).a();
    }

    public static int c() {
        if (d() != 1) {
            f(d());
            e(0);
        }
        return e();
    }

    public static int c(int i2) {
        return a().b("blued_chat_backup_port", i2);
    }

    public static String c(String str) {
        return a().a("blued_pay_host", str);
    }

    public static int d() {
        return a(a().b(e, 0), BlueAppLocal.c());
    }

    public static void d(int i2) {
        a().c().a("blued_chat_backup_port", i2).a();
    }

    public static void d(String str) {
        a().c().a("blued_pay_host", str).a();
    }

    public static int e() {
        return a(a().b("unit_setting_" + UserInfo.getInstance().getLoginUserInfo().getUid(), 0), BlueAppLocal.c());
    }

    public static String e(String str) {
        return a().a("blued_sdk_host", str);
    }

    public static void e(int i2) {
        a().c().a(e, i2).a();
    }

    public static String f() {
        return b().a(f, "");
    }

    public static void f(int i2) {
        a().c().a("unit_setting_" + UserInfo.getInstance().getLoginUserInfo().getUid(), i2).a();
    }

    public static void f(String str) {
        a().c().a("blued_sdk_host", str).a();
    }

    public static int g() {
        return b().b(g, 0);
    }

    public static String g(String str) {
        return a().a("blued_http_host_addr", str);
    }

    public static void g(int i2) {
        b().c().a(g, i2).a();
    }

    public static int h() {
        return b().b(i, 0);
    }

    public static void h(int i2) {
        b().c().a(i, i2).a();
    }

    public static void h(String str) {
        a().c().a("blued_http_host_addr", str).a();
    }

    public static BluedSharedPreferences i() {
        if (b == null) {
            b = BluedSharedPreferences.a("blued_sf_emotions_pack", 0);
        }
        return b;
    }

    public static String i(String str) {
        return a().a("blued_health_host", str);
    }

    public static BluedSharedPreferences j() {
        if (f10876c == null) {
            f10876c = BluedSharedPreferences.a("removed_def_emotion_packs", 0);
        }
        return f10876c;
    }

    public static void j(String str) {
        a().c().a("blued_health_host", str).a();
    }

    public static String k() {
        return j().a(k, "");
    }

    public static String k(String str) {
        return a().a("blued_data_host_addr", str);
    }

    public static Long l() {
        return Long.valueOf(i().a(l, 0L));
    }

    public static void l(String str) {
        a().c().a("blued_data_host_addr", str).a();
    }

    public static String m(String str) {
        return a().a("WEB_BLUED_HOST", str);
    }

    public static boolean m() {
        BluedSharedPreferences a2 = a();
        return a2.a(m + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static void n(String str) {
        a().c().a("WEB_BLUED_HOST", str).a();
    }

    public static boolean n() {
        return a().a("set_avatar_widget_long_click", false);
    }

    public static String o(String str) {
        return a().a("M_BLUED_HOST", str);
    }

    public static void o() {
        a().c().a("set_avatar_widget_long_click", true).b();
    }

    public static void p(String str) {
        a().c().a("M_BLUED_HOST", str).a();
    }

    public static boolean p() {
        return a().a("IS_SHOW_EVENT_SEND_DIALOG", true);
    }

    public static String q(String str) {
        return a().a("LIVE_IM_HOST", str);
    }

    public static void q() {
        a().c().a("IS_SHOW_EVENT_SEND_DIALOG", false).b();
    }

    public static void r(String str) {
        a().c().a("LIVE_IM_HOST", str).a();
    }

    public static boolean r() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        BluedSharedPreferences a2 = a();
        return a2.a("AD_CLOSE_POP" + format, false);
    }

    public static String s(String str) {
        return a().a("GRPC_IM_HOST", str);
    }

    public static void s() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("AD_CLOSE_POP" + format, true).b();
    }

    public static String t() {
        return a().a(n, "");
    }

    public static void t(String str) {
        a().c().a("GRPC_IM_HOST", str).b();
    }

    public static String u() {
        return a().a(o, "0");
    }

    public static void u(String str) {
        b().c().a(f, str).a();
    }

    public static long v(String str) {
        BluedSharedPreferences i2 = i();
        return i2.a(j + str, 0L);
    }

    public static String v() {
        return a().a(p, "0");
    }

    public static LatLonPoint w() {
        String u = u();
        String v = v();
        try {
            return new LatLonPoint(Double.parseDouble(v), Double.parseDouble(u));
        } catch (Exception e2) {
            return new LatLonPoint(0.0d, 0.0d);
        }
    }

    public static void w(String str) {
        BluedSharedPreferences.Editor c2 = i().c();
        c2.a(j + str).a();
    }

    public static String x() {
        return a().a(q, "");
    }

    public static void x(String str) {
        j().c().a(k, str).a();
    }

    public static String y() {
        return a().a(r, "");
    }

    public static void y(String str) {
        a().c().a(n, str).a();
    }

    public static String z() {
        return a().a(s, "");
    }

    public static void z(String str) {
        a().c().a(q, str).a();
    }
}
