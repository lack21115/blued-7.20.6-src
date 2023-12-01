package com.blued.android.module.live_china.utils;

import android.text.TextUtils;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveRoomPreferences.class */
public class LiveRoomPreferences {
    public static String A = "live_planet_dispatch_dialog";
    public static String B = "live_planet_gift_dialog";
    public static String C = "live_planet_show_guide";

    /* renamed from: a  reason: collision with root package name */
    public static BluedSharedPreferences f14190a;
    public static BluedSharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    public static BluedSharedPreferences f14191c;
    public static String d = "recommend_live";
    public static String e = "SHOWED_LIVE_TIPS_REMIND";
    public static String f = "SHOWED_LIVE_TIPS_REMIND";
    public static String g = "show_pre_pay_dialog_guide";
    public static String h = "show_onekey_rank_tips_count";
    public static String i = "SHOWED_LIVE_CONNECTION_TIPS_REMIND";
    public static String j = "SHOWED_LIVE_CONNECTION_PK_REMIND";
    public static String k = "FIREST_LIVE_CACEL";
    public static String l = "select_photo_new";
    public static String m = "zan_res";
    public static String n = "SHOWED_USER_TAB_DOT1";
    public static String o = "SHOWED_MY_GIFT_DOT";
    public static String p = "SHOWED_SHARE_HINT";
    public static String q = "SHOWED_LIVE_WISH_TIPS_REMIND";
    public static String r = "JION_LIVE_ROOM_COUNT";
    public static String s = "CLOSE_FLOAT_LIVE_DIALOG";
    public static String t = "SHOW_WISHING_WELL_RED_DOT";
    public static String u = "LAST_AUTO_SHOW_RECOMMEND_DATE";
    public static String v = "LAST_SHOW_LIVE_PUSH_GUIDE_DATE";
    public static String w = "LIVE_COMMON_POP_";
    public static String x = "live_online_user_tips_pop";
    public static String y = "live_group_dot";
    public static String z = "live_battle_award_guide";

    public static void A(String str) {
        a().c().a(u, str).a();
    }

    public static boolean A() {
        return a().a("live_recommend_tips2", true);
    }

    public static String B(String str) {
        return !TextUtils.isEmpty(str) ? a().a(str, "0") : "0";
    }

    public static void B() {
        a().c().a("live_recommend_tips2", false).a();
    }

    public static boolean C() {
        return c().a(p, true);
    }

    public static boolean C(String str) {
        BluedSharedPreferences a2 = a();
        return a2.a(x + str, true);
    }

    public static boolean D() {
        return a().a("LIVE_FANS_REOPEN_GUIDE", false);
    }

    public static void E() {
        a().c().a("LIVE_FANS_REOPEN_GUIDE", true).b();
    }

    public static boolean F() {
        return System.currentTimeMillis() - a().a("LIVE_GIFT_TASK_TODAY", 0L) > 86400000;
    }

    public static void G() {
        a().c().a("LIVE_GIFT_TASK_TODAY", System.currentTimeMillis()).b();
    }

    public static boolean H() {
        return System.currentTimeMillis() - a().a("LIVE_GIFT_TASK_YING_GUANG", 0L) > 86400000;
    }

    public static void I() {
        a().c().a("LIVE_GIFT_TASK_YING_GUANG", System.currentTimeMillis()).b();
    }

    public static boolean J() {
        return a().a("LIVE_REWARD_TIP", false);
    }

    public static void K() {
        a().c().a("LIVE_REWARD_TIP", true).b();
    }

    public static boolean L() {
        return a().a("LIVE_LIANG_EXPIRE", false);
    }

    public static int M() {
        return a().b(r, 0);
    }

    public static boolean N() {
        return a().a(s, true);
    }

    public static void O() {
        a().c().a(s, false).a();
    }

    public static String P() {
        return a().a(u, "");
    }

    public static boolean Q() {
        return a().a(y, true);
    }

    public static void R() {
        a().c().a(y, false).a();
    }

    public static boolean S() {
        return a().a(z, true);
    }

    public static void T() {
        a().c().a(z, false).a();
    }

    public static boolean U() {
        return a().a(A, true);
    }

    public static void V() {
        a().c().a(A, false).a();
    }

    public static boolean W() {
        return a().a(B, true);
    }

    public static void X() {
        a().c().a(B, false).a();
    }

    public static boolean Y() {
        return a().a(C, true);
    }

    public static void Z() {
        a().c().a(C, false).a();
    }

    public static BluedSharedPreferences a() {
        if (f14190a == null) {
            f14190a = BluedSharedPreferences.a();
        }
        return f14190a;
    }

    public static void a(int i2) {
        a().c().a(h, i2).a();
    }

    public static void a(String str) {
        b().c().a(m, str).a();
    }

    public static void a(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a().c().a(str, str2).a();
    }

    public static void a(boolean z2) {
        a().c().a("live_set_nearby", z2).a();
    }

    public static void a(boolean z2, String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(x + str, z2).a();
    }

    public static BluedSharedPreferences b() {
        if (b == null) {
            b = BluedSharedPreferences.a("blued_sf", 0);
        }
        return b;
    }

    public static String b(String str) {
        return LiveBasePreferences.a(str);
    }

    public static void b(int i2) {
        a().c().a("live_reward_condition", i2).a();
    }

    public static void b(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static void b(boolean z2) {
        a().c().a("live_switch_clear_cue", z2).a();
    }

    public static BluedSharedPreferences c() {
        if (f14191c == null) {
            f14191c = BluedSharedPreferences.a("blued_sf_setting", 0);
        }
        return f14191c;
    }

    public static void c(int i2) {
        a().c().a("live_pk_new_icon", i2).a();
    }

    public static void c(String str) {
        LiveBasePreferences.b(str);
    }

    public static void c(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static void c(boolean z2) {
        c().c().a(p, z2).a();
    }

    public static void d(int i2) {
        a().c().a("live_xiaomi_status", i2).a();
    }

    public static void d(String str) {
        a().c().a("live_share", str).a();
    }

    public static void d(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static void d(boolean z2) {
        a().c().a("LIVE_LIANG_EXPIRE", z2).b();
    }

    public static boolean d() {
        return a().a(f, true);
    }

    public static int e(String str) {
        return a().b(str, 5);
    }

    public static void e() {
        a().c().a(f, false).a();
    }

    public static void e(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("live_first_charge_" + LiveRoomInfo.a().f(), i2).a();
    }

    public static void e(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int f(String str) {
        return a().b(str, 40);
    }

    public static void f(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("live_first_charge_time_" + LiveRoomInfo.a().f(), i2).a();
    }

    public static void f(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static boolean f() {
        return a().a(g, true);
    }

    public static int g(String str) {
        return a().b(str, 75);
    }

    public static void g() {
        a().c().a(g, false).a();
    }

    public static void g(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("live_first_charge_room_time_" + LiveRoomInfo.a().f(), i2).a();
    }

    public static void g(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int h() {
        return a().b(h, 0);
    }

    public static int h(String str) {
        return a().b(str, 0);
    }

    public static void h(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("live_first_charge_icon_time_" + LiveRoomInfo.a().f(), i2).a();
    }

    public static void h(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int i(String str) {
        return a().b(str, 10);
    }

    public static String i() {
        return b().a(m, "");
    }

    public static void i(int i2) {
        a().c().a(r, i2).a();
    }

    public static void i(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int j(String str) {
        return a().b(str, 15);
    }

    public static String j() {
        return a().a("live_share", "");
    }

    public static void j(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int k() {
        return a().b("live_reward_condition", 0);
    }

    public static int k(String str) {
        return a().b(str, 10);
    }

    public static void k(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int l() {
        return a().b("live_beauty_dreamy", 0);
    }

    public static int l(String str) {
        return a().b(str, 0);
    }

    public static void l(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int m() {
        return a().b("live_beauty_purple", 0);
    }

    public static int m(String str) {
        return a().b(str, 0);
    }

    public static void m(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int n() {
        return a().b("live_beauty_cold", 0);
    }

    public static int n(String str) {
        return a().b(str, 0);
    }

    public static void n(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int o(String str) {
        return a().b(str, 0);
    }

    public static String o() {
        return a().a("live_beauty_code_sense", "");
    }

    public static void o(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int p(String str) {
        return a().b(str, 0);
    }

    public static String p() {
        BluedSharedPreferences a2 = a();
        return a2.a("live_record_level_sticker" + LiveRoomInfo.a().f(), "");
    }

    public static void p(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int q(String str) {
        return a().b(str, 0);
    }

    public static String q() {
        BluedSharedPreferences a2 = a();
        return a2.a("live_record_level_gesture" + LiveRoomInfo.a().f(), "");
    }

    public static void q(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int r(String str) {
        return a().b(str, 0);
    }

    public static String r() {
        BluedSharedPreferences a2 = a();
        return a2.a("live_record_level_sticker_location" + LiveRoomInfo.a().f(), "");
    }

    public static void r(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int s() {
        return a().b("live_xiaomi_status", 0);
    }

    public static int s(String str) {
        return a().b(str, 60);
    }

    public static void s(String str, int i2) {
        a().c().a(str, i2).a();
    }

    public static int t(String str) {
        return a().b(str, 60);
    }

    public static boolean t() {
        return a().a("live_set_nearby", true);
    }

    public static int u() {
        return a().b("live_is_beauty", 0);
    }

    public static int u(String str) {
        return a().b(str, 60);
    }

    public static int v() {
        BluedSharedPreferences a2 = a();
        return a2.b("live_first_charge_" + LiveRoomInfo.a().f(), -2);
    }

    public static int v(String str) {
        return a().b(str, 60);
    }

    public static int w() {
        BluedSharedPreferences a2 = a();
        return a2.b("live_first_charge_time_" + LiveRoomInfo.a().f(), 0);
    }

    public static void w(String str) {
        a().c().a("live_beauty_code_sense", str).a();
    }

    public static int x() {
        BluedSharedPreferences a2 = a();
        return a2.b("live_first_charge_room_time_" + LiveRoomInfo.a().f(), 0);
    }

    public static void x(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("live_record_level_sticker" + LiveRoomInfo.a().f(), str).a();
    }

    public static int y() {
        BluedSharedPreferences a2 = a();
        return a2.b("live_first_charge_icon_time_" + LiveRoomInfo.a().f(), 0);
    }

    public static void y(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("live_record_level_gesture" + LiveRoomInfo.a().f(), str).a();
    }

    public static void z(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("live_record_level_sticker_location" + LiveRoomInfo.a().f(), str).a();
    }

    public static boolean z() {
        return a().a("live_switch_clear_cue", false);
    }
}
