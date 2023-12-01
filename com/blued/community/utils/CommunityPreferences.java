package com.blued.community.utils;

import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.community.manager.CommunityManager;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/CommunityPreferences.class */
public final class CommunityPreferences {

    /* renamed from: a  reason: collision with root package name */
    public static String f20462a = "IS_YY_ROOM_FIRST_SHOW";
    public static String b = "GUIDE_PUBLISH_FEED_CODE";

    /* renamed from: c  reason: collision with root package name */
    public static String f20463c = "GUIDE_OPERATE_BUBBLE_CODE";
    public static String d = "JOIN_CIRCLE_OUT_OF_CIRCLE_DETAILS";
    public static String e = "SHOW_DIALOG_ONLY_ONCE";
    public static String f = "setting_join_circle";
    public static String g = "IS_SHOW_FEED_POST_DRAG_PHOTO_TIP";
    public static String h = "OPEN_FEED_CUSTOM_RECOMMEND";
    public static String i = "IS_SHOW_FEED_LIKE_COMMENT_TIP";
    public static String j = "EVENT_SIGN_UP_DIALOG_CHECKED";
    public static String k = "SUPER_TOPIC_ANONYMOUS_TIP";
    @Deprecated
    private static volatile BluedSharedPreferences l;
    private static volatile BluedSharedPreferences m;

    private CommunityPreferences() {
    }

    public static long A() {
        return as().a("SHOW_ATTENTION_MY_FEED_SUPER_EXPOSE_GUIDE_TIME", 0L);
    }

    public static String B() {
        return as().a("SHOW_ATTENTION_MY_FEED_SUPER_EXPOSE_GUIDE_ID", "");
    }

    public static long C() {
        BluedSharedPreferences as = as();
        return as.a("ENTER_FEED_TAB_DATE" + UserInfoUtils.c(), 0L);
    }

    public static void D() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("ENTER_FEED_TAB_DATE" + UserInfoUtils.c(), TimeAndDateUtils.a()).a();
    }

    public static int E() {
        BluedSharedPreferences as = as();
        return as.b("ENTER_FEED_TAB_COUNT" + UserInfoUtils.c(), 0);
    }

    public static void F() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("ENTER_FEED_TAB_COUNT" + UserInfoUtils.c(), 0).a();
    }

    public static void G() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("ENTER_FEED_TAB_COUNT" + UserInfoUtils.c(), E() + 1).a();
    }

    public static long H() {
        BluedSharedPreferences as = as();
        return as.a("NEARBY_GUIDE_SHOW_DATE" + UserInfoUtils.c(), 0L);
    }

    public static long I() {
        BluedSharedPreferences as = as();
        return as.a("NEARBY_GUIDE_NOT_SHOW_DATE" + UserInfoUtils.c(), 0L);
    }

    public static long J() {
        BluedSharedPreferences as = as();
        return as.a("NEARBY_GUIDE_SHOW_WEEK" + UserInfoUtils.c(), 0L);
    }

    public static int K() {
        BluedSharedPreferences as = as();
        return as.b("NEARBY_GUIDE_SHOW_COUNT" + UserInfoUtils.c(), 0);
    }

    public static void L() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_SHOW_COUNT" + UserInfoUtils.c(), 0).a();
    }

    public static void M() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_SHOW_COUNT" + UserInfoUtils.c(), K() + 1).a();
    }

    public static int N() {
        BluedSharedPreferences as = as();
        return as.b("NEARBY_GUIDE_SHOW_TYPE" + UserInfoUtils.c(), 0);
    }

    public static Boolean O() {
        BluedSharedPreferences as = as();
        return Boolean.valueOf(as.a("loop_live_chatRoom_" + UserInfoUtils.c(), false));
    }

    public static String P() {
        BluedSharedPreferences as = as();
        return as.a("SVIP_BUY_CANCEL_DIALOG_SHOW_DATE" + UserInfoUtils.c(), "");
    }

    public static String Q() {
        BluedSharedPreferences as = as();
        return as.a("VIP_BUY_CANCEL_DIALOG_SHOW_DATE" + UserInfoUtils.c(), "");
    }

    public static float R() {
        BluedSharedPreferences as = as();
        return as.a("LAST_USE_LOCATION_LAT_" + UserInfoUtils.c(), 0.0f);
    }

    public static float S() {
        BluedSharedPreferences as = as();
        return as.a("LAST_USE_LOCATION_LON_" + UserInfoUtils.c(), 0.0f);
    }

    public static String T() {
        BluedSharedPreferences as = as();
        return as.a("LAST_RECOMMEND_SUBJECT_ID_" + UserInfoUtils.c(), "");
    }

    public static long U() {
        BluedSharedPreferences as = as();
        return as.a("FEED_BUBBLE_PROFILE_SHINE_DATE_" + UserInfoUtils.c(), 0L);
    }

    public static boolean V() {
        BluedSharedPreferences as = as();
        return as.a("FEED_BUBBLE_PROFILE_GUEST_GUIDE_SHOW_" + UserInfoUtils.c(), true);
    }

    public static boolean W() {
        BluedSharedPreferences as = as();
        return as.a("FEED_BUBBLE_PROFILE_GUEST_POKE_GUIDE_SHOW_" + UserInfoUtils.c(), true);
    }

    public static int X() {
        BluedSharedPreferences as = as();
        return as.b("FEED_BUBBLE_V2_GUIDE_SHOW_COUNT_" + UserInfoUtils.c(), 0);
    }

    public static int Y() {
        BluedSharedPreferences as = as();
        return as.b("FEED_TEMPLATE_TITLE_" + UserInfoUtils.c(), -1);
    }

    public static void Z() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_ADD_TOOLS_GUIDE_COUNT_INTRODUCE_" + UserInfoUtils.c(), aa() + 1).a();
    }

    public static void a(float f2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("LAST_USE_LOCATION_LAT_" + UserInfoUtils.c(), f2).a();
    }

    public static void a(int i2) {
        as().c().a("RECOMMEND_FEED_TYPE", i2).b();
    }

    public static void a(int i2, int i3) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_DIVERSION_INSERT_COUNT_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + i2, i3).a();
    }

    public static void a(int i2, long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_PROMOTION_POPUP_" + i2 + BridgeUtil.UNDERLINE_STR + UserInfoUtils.c(), j2).a();
    }

    public static void a(long j2) {
        as().c().a("SHOW_ATTENTION_MY_FEED_SUPER_EXPOSE_GUIDE_TIME", j2).b();
    }

    public static void a(String str, int i2) {
        LogUtils.c(str + ": " + i2);
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("OPERATION_COUNT_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, i2).a();
    }

    public static void a(String str, long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("GUIDE_WEEK_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, j2).a();
    }

    public static void a(String str, String str2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_GUIDE_NEXT_TEMPLATE_TITLE_PIDS_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, str2).a();
    }

    public static void a(String str, boolean z) {
        BluedSharedPreferences.Editor c2 = ar().c();
        c2.a(str + d, z).b();
    }

    public static void a(boolean z) {
        ar().c().a(f, z).b();
    }

    public static boolean a() {
        return ar().a("IS_SHOW_CIRCLE_DETAIL_INPUT_GUIDE", false);
    }

    public static boolean a(String str) {
        BluedSharedPreferences ar2 = ar();
        return ar2.a(str + d, false);
    }

    public static int aa() {
        BluedSharedPreferences as = as();
        return as.b("FEED_ADD_TOOLS_GUIDE_COUNT_INTRODUCE_" + UserInfoUtils.c(), 0);
    }

    public static boolean ab() {
        BluedSharedPreferences as = as();
        return as.a("FEED_ADD_INTRODUCE_CHANGE_TOAST_" + UserInfoUtils.c(), true);
    }

    public static void ac() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_ADD_INTRODUCE_CHANGE_TOAST_" + UserInfoUtils.c(), false).a();
    }

    public static boolean ad() {
        BluedSharedPreferences as = as();
        return as.a("FEED_ADD_INTRODUCE_CHANGE_GUIDE_" + UserInfoUtils.c(), true);
    }

    public static void ae() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_ADD_INTRODUCE_CHANGE_GUIDE_" + UserInfoUtils.c(), false).a();
    }

    public static int af() {
        BluedSharedPreferences as = as();
        return as.b("FEED_ADD_INTRODUCE_INDEX_" + UserInfoUtils.c(), 0);
    }

    public static void ag() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_INTRODUCE_POP_GUIDE_" + UserInfoUtils.c(), false).a();
    }

    public static boolean ah() {
        BluedSharedPreferences as = as();
        return as.a("FEED_INTRODUCE_POP_GUIDE_" + UserInfoUtils.c(), true);
    }

    public static long ai() {
        BluedSharedPreferences as = as();
        return as.a("USER_ENTER_NEARBY_FEED_DATE_" + UserInfoUtils.c(), 0L);
    }

    public static boolean aj() {
        BluedSharedPreferences as = as();
        return as.a("FEED_BUBBLE_STATE_GUIDE_" + UserInfoUtils.c(), true);
    }

    public static void ak() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_BUBBLE_STATE_GUIDE_" + UserInfoUtils.c(), false).a();
    }

    public static int al() {
        BluedSharedPreferences as = as();
        return as.b("NEARBY_GUIDE_MODE_LEAVE_ONE_" + UserInfoUtils.c(), 0);
    }

    public static String am() {
        BluedSharedPreferences as = as();
        return as.a("NEARBY_GUIDE_TEMPLATE_TITLE_" + UserInfoUtils.c(), "");
    }

    public static String an() {
        BluedSharedPreferences as = as();
        return as.a("NEARBY_GUIDE_TEMPLATE_TOPIC_" + UserInfoUtils.c(), "");
    }

    public static String ao() {
        BluedSharedPreferences as = as();
        return as.a("FEED_ATTENTION_GUIDE_SHOW_Date_" + UserInfoUtils.c(), "");
    }

    public static String ap() {
        BluedSharedPreferences as = as();
        return as.a("FEED_ATTENTION_GUIDE_TEMPLATE_SHOWING_MODEL_" + UserInfoUtils.c(), "");
    }

    public static String aq() {
        BluedSharedPreferences as = as();
        return as.a("FEED_ATTENTION_GUIDE_TOPIC_SHOWING_MODEL_" + UserInfoUtils.c(), "");
    }

    @Deprecated
    private static BluedSharedPreferences ar() {
        BluedSharedPreferences bluedSharedPreferences;
        synchronized (CommunityPreferences.class) {
            try {
                if (l == null) {
                    synchronized (CommunityPreferences.class) {
                        if (l == null) {
                            l = BluedSharedPreferences.a();
                        }
                    }
                }
                bluedSharedPreferences = l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bluedSharedPreferences;
    }

    private static BluedSharedPreferences as() {
        BluedSharedPreferences bluedSharedPreferences;
        synchronized (CommunityPreferences.class) {
            try {
                if (m == null) {
                    synchronized (CommunityPreferences.class) {
                        if (m == null) {
                            m = BluedSharedPreferences.a("Community");
                        }
                    }
                }
                bluedSharedPreferences = m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bluedSharedPreferences;
    }

    public static void b() {
        ar().c().a("IS_SHOW_CIRCLE_DETAIL_INPUT_GUIDE", true).b();
    }

    public static void b(float f2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("LAST_USE_LOCATION_LON_" + UserInfoUtils.c(), f2).a();
    }

    public static void b(int i2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_SHOW_TYPE" + UserInfoUtils.c(), i2).a();
    }

    public static void b(int i2, long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_DIVERSION_INSERT_DATE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + i2, j2).a();
    }

    public static void b(long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_SHOW_DATE" + UserInfoUtils.c(), j2).a();
    }

    public static void b(String str, long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("LAST_DATE_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, j2).a();
    }

    public static void b(String str, String str2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_GUIDE_NEXT_TOPIC_PIDS_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, str2).a();
    }

    public static void b(String str, boolean z) {
        BluedSharedPreferences.Editor c2 = ar().c();
        c2.a(str + e, z).b();
    }

    public static void b(boolean z) {
        ar().c().a(h, z).b();
    }

    public static boolean b(String str) {
        BluedSharedPreferences ar2 = ar();
        return ar2.a(str + e, true);
    }

    public static long c(int i2) {
        BluedSharedPreferences as = as();
        return as.a("NEARBY_PROMOTION_POPUP_" + i2 + BridgeUtil.UNDERLINE_STR + UserInfoUtils.c(), 0L);
    }

    public static void c(long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_NOT_SHOW_DATE" + UserInfoUtils.c(), j2).a();
    }

    public static void c(String str, String str2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("OPERATION_CONTENT_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, str2).a();
    }

    public static void c(String str, boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FLAG_BOOLEAN_DEFAULT_TRUE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, z).a();
    }

    public static void c(boolean z) {
        BluedSharedPreferences.Editor c2 = ar().c();
        c2.a(j + UserInfo.getInstance().getLoginUserInfo().uid, z).b();
    }

    public static boolean c() {
        return ar().a(f, true);
    }

    public static boolean c(String str) {
        return ar().a(str, true);
    }

    public static void d() {
        ar().c().a(g, false).b();
    }

    public static void d(int i2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_PROMOTION_POPUP_COUNT_" + i2 + BridgeUtil.UNDERLINE_STR + UserInfoUtils.c(), 0).a();
    }

    public static void d(long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_SHOW_WEEK" + UserInfoUtils.c(), j2).a();
    }

    public static void d(String str) {
        ar().c().a(str, false).b();
    }

    public static boolean d(boolean z) {
        BluedSharedPreferences as = as();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_DOUBLE_CLICK_AVATAR");
        sb.append(z ? "stagger" : "single");
        return as.a(sb.toString(), true);
    }

    public static int e(int i2) {
        BluedSharedPreferences as = as();
        return as.b("NEARBY_PROMOTION_POPUP_COUNT_" + i2 + BridgeUtil.UNDERLINE_STR + UserInfoUtils.c(), 0);
    }

    public static void e(long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_BUBBLE_PROFILE_SHINE_DATE_" + UserInfoUtils.c(), j2).a();
    }

    public static void e(String str) {
        as().c().a("MSG_CHAT_FLASH_MODEL", str).b();
    }

    public static void e(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_DOUBLE_CLICK_AVATAR");
        sb.append(z ? "stagger" : "single");
        c2.a(sb.toString(), false).a();
    }

    public static boolean e() {
        return ar().a(g, true);
    }

    public static void f(int i2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_PROMOTION_POPUP_COUNT_" + i2 + BridgeUtil.UNDERLINE_STR + UserInfoUtils.c(), e(i2) + 1).a();
    }

    public static void f(long j2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("USER_ENTER_NEARBY_FEED_DATE_" + UserInfoUtils.c(), j2).a();
    }

    public static void f(String str) {
        as().c().a("MSG_FLASH_VIDEO_TOAST_CONTENT", str).b();
    }

    public static boolean f() {
        return ar().a(h, false);
    }

    public static boolean f(boolean z) {
        return TimeAndDateUtils.a() - h(z) > 2 && TimeAndDateUtils.a() > j(z);
    }

    public static void g(int i2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_TEMPLATE_TITLE_" + UserInfoUtils.c(), i2).a();
    }

    public static void g(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_DOUBLE_CLICK_POKE_BTN");
        sb.append(z ? "stagger" : "single");
        c2.a(sb.toString(), TimeAndDateUtils.a()).a();
    }

    public static boolean g() {
        return ar().a(h, true);
    }

    public static boolean g(String str) {
        BluedSharedPreferences as = as();
        return as.a("EVENT_SIGN_DLG_GUIDE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, true);
    }

    public static long h(boolean z) {
        BluedSharedPreferences as = as();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_DOUBLE_CLICK_POKE_BTN");
        sb.append(z ? "stagger" : "single");
        return as.a(sb.toString(), 0L);
    }

    public static void h() {
        ar().c().a(h, false).b();
    }

    public static void h(int i2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_ADD_INTRODUCE_INDEX_" + UserInfoUtils.c(), i2).a();
    }

    public static void h(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("EVENT_SIGN_DLG_GUIDE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, false).a();
    }

    public static long i(int i2) {
        BluedSharedPreferences as = as();
        return as.a("FEED_DIVERSION_INSERT_DATE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + i2, 0L);
    }

    public static void i(String str) {
        as().c().a("SHOW_ATTENTION_MY_FEED_SUPER_EXPOSE_GUIDE_ID", str).b();
    }

    public static void i(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_DOUBLE_CLICK_POKE_BTN_TIME");
        sb.append(z ? "stagger" : "single");
        c2.a(sb.toString(), TimeAndDateUtils.a()).a();
    }

    public static boolean i() {
        BluedSharedPreferences ar2 = ar();
        return ar2.a(j + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static int j(int i2) {
        BluedSharedPreferences as = as();
        return as.b("FEED_DIVERSION_INSERT_COUNT_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + i2, 0);
    }

    public static long j(boolean z) {
        BluedSharedPreferences as = as();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_DOUBLE_CLICK_POKE_BTN_TIME");
        sb.append(z ? "stagger" : "single");
        return as.a(sb.toString(), 0L);
    }

    public static String j() {
        return as().a("MSG_CHAT_FLASH_MODEL", "");
    }

    public static void j(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("SVIP_BUY_CANCEL_DIALOG_SHOW_DATE" + UserInfoUtils.c(), str).a();
    }

    public static String k() {
        return as().a("MSG_FLASH_VIDEO_TOAST_CONTENT", "");
    }

    public static void k(int i2) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_MODE_LEAVE_ONE_" + UserInfoUtils.c(), i2).a();
    }

    public static void k(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("VIP_BUY_CANCEL_DIALOG_SHOW_DATE" + UserInfoUtils.c(), str).a();
    }

    public static boolean k(boolean z) {
        long a2 = TimeAndDateUtils.a();
        BluedSharedPreferences as = as();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_CLICK_POKE_BTN_TOAST");
        sb.append(z ? "stagger" : "single");
        return a2 > as.a(sb.toString(), 0L);
    }

    public static int l() {
        return as().b("RECOMMEND_FEED_TYPE", 3);
    }

    public static void l(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("LAST_RECOMMEND_SUBJECT_ID_" + UserInfoUtils.c(), str).a();
    }

    public static void l(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_CLICK_POKE_BTN_TOAST");
        sb.append(z ? "stagger" : "single");
        c2.a(sb.toString(), TimeAndDateUtils.a()).a();
    }

    public static void m(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_TEMPLATE_TITLE_" + UserInfoUtils.c(), str).a();
    }

    public static boolean m() {
        return TimeAndDateUtils.a() > as().a("SIGN_FEED_SEND_ANIM_TIME", 0L);
    }

    public static boolean m(boolean z) {
        BluedSharedPreferences as = as();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_POST_SET_GUIDE_IN_FEED_LIST");
        sb.append(z ? "stagger" : "single");
        return as.a(sb.toString(), true);
    }

    public static void n() {
        as().c().a("SIGN_FEED_SEND_ANIM_TIME", TimeAndDateUtils.a()).b();
    }

    public static void n(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("NEARBY_GUIDE_TEMPLATE_TOPIC_" + UserInfoUtils.c(), str).a();
    }

    public static void n(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        StringBuilder sb = new StringBuilder();
        sb.append("SIGN_FEED_POST_SET_GUIDE_IN_FEED_LIST");
        sb.append(z ? "stagger" : "single");
        c2.a(sb.toString(), false).a();
    }

    public static void o(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_ATTENTION_GUIDE_SHOW_Date_" + UserInfoUtils.c(), str).a();
    }

    public static void o(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("loop_live_chatRoom_" + UserInfoUtils.c(), z).a();
    }

    public static boolean o() {
        return as().a("SIGN_FEED_POST_GUIDE_IN_LIST", true);
    }

    public static void p() {
        as().c().a("SIGN_FEED_POST_GUIDE_IN_LIST", false).a();
    }

    public static void p(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_ATTENTION_GUIDE_TEMPLATE_SHOWING_MODEL_" + UserInfoUtils.c(), str).a();
    }

    public static void p(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_BUBBLE_PROFILE_GUEST_GUIDE_SHOW_" + UserInfoUtils.c(), z).a();
    }

    public static long q() {
        BluedSharedPreferences as = as();
        return as.a("FEED_DETAIL_LIKE_GUIDE_DATE_" + UserInfoUtils.c(), 0L);
    }

    public static String q(String str) {
        BluedSharedPreferences as = as();
        return as.a("FEED_GUIDE_NEXT_TEMPLATE_TITLE_PIDS_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, "");
    }

    public static void q(boolean z) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_BUBBLE_PROFILE_GUEST_POKE_GUIDE_SHOW_" + UserInfoUtils.c(), z).a();
    }

    public static String r(String str) {
        BluedSharedPreferences as = as();
        return as.a("FEED_GUIDE_NEXT_TOPIC_PIDS_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, "");
    }

    public static void r() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_DETAIL_LIKE_GUIDE_DATE_" + UserInfoUtils.c(), TimeAndDateUtils.a()).a();
    }

    public static int s() {
        BluedSharedPreferences as = as();
        return as.b("FEED_DETAIL_LIKE_GUIDE_COUNT_" + UserInfoUtils.c(), 0);
    }

    public static void s(String str) {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_ATTENTION_GUIDE_TOPIC_SHOWING_MODEL_" + UserInfoUtils.c(), str).a();
    }

    public static long t(String str) {
        BluedSharedPreferences as = as();
        return as.a("GUIDE_WEEK_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, 0L);
    }

    public static void t() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_DETAIL_LIKE_GUIDE_COUNT_" + UserInfoUtils.c(), 0).a();
    }

    public static long u(String str) {
        BluedSharedPreferences as = as();
        return as.a("LAST_DATE_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, 0L);
    }

    public static void u() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("FEED_DETAIL_LIKE_GUIDE_COUNT_" + UserInfoUtils.c(), s() + 1).a();
    }

    public static int v(String str) {
        BluedSharedPreferences as = as();
        return as.b("OPERATION_COUNT_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, 0);
    }

    public static long v() {
        BluedSharedPreferences as = as();
        return as.a("SIGN_FEED_LIST_BTN_ANIM_DATE_" + CommunityManager.f19086a.a().e(), 0L);
    }

    public static int w(String str) {
        int v = v(str) + 1;
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("OPERATION_COUNT_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, v).a();
        return v;
    }

    public static void w() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("SIGN_FEED_LIST_BTN_ANIM_DATE_" + CommunityManager.f19086a.a().e(), TimeAndDateUtils.a()).a();
    }

    public static int x() {
        BluedSharedPreferences as = as();
        return as.b("SIGN_FEED_LIST_BTN_ANIM_COUNT_" + CommunityManager.f19086a.a().e(), 0);
    }

    public static boolean x(String str) {
        BluedSharedPreferences as = as();
        return as.a("FLAG_BOOLEAN_DEFAULT_TRUE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, true);
    }

    public static String y(String str) {
        BluedSharedPreferences as = as();
        return as.a("OPERATION_CONTENT_BY_TYPE_" + UserInfoUtils.c() + BridgeUtil.UNDERLINE_STR + str, "");
    }

    public static void y() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("SIGN_FEED_LIST_BTN_ANIM_COUNT_" + CommunityManager.f19086a.a().e(), 0).a();
    }

    public static void z() {
        BluedSharedPreferences.Editor c2 = as().c();
        c2.a("SIGN_FEED_LIST_BTN_ANIM_COUNT_" + CommunityManager.f19086a.a().e(), x() + 1).a();
    }
}
