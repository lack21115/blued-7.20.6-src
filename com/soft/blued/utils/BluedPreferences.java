package com.soft.blued.utils;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelProviders;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinPreferences;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.login.utils.LoginPreferences;
import com.soft.blued.R;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.user.BluedConfig;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/BluedPreferences.class */
public class BluedPreferences {
    public static String A = "filter722";
    public static String B = "invisible";
    public static String C = "typechoice";
    public static String D = "modelchoice1";
    public static String E = "age_choice";
    public static String F = "height_choice";
    public static String G = "height_choice_in";
    public static String H = "weight_choice";
    public static String I = "weight_choice_lbs";
    public static String J = "avatarchoice";
    public static String K = "AIPHOTOCHOICE";
    public static String L = "verifychoice";
    public static String M = "RELATIONCHOICE";
    public static String N = "racechoice";
    public static String O = "TAGCHOICE";
    public static String P = "TAGCHOICETEXT_HEIS";
    public static String Q = "TAGCHOICETEXT_LOOKFOR";
    public static String R = "VIP_ONLY_CHOICE";
    public static String S = "DISTANCE_RANGE";
    public static String T = "TIME_RANGE";
    public static String U = "INVISIBLE_DISTANCE_RANGE";
    public static String V = "receivemessage";
    public static String W = "personalized";
    public static String X = "chatDefaultBgUri";
    public static String Y = "chatvoice";
    public static String Z = "chatshake";

    /* renamed from: a  reason: collision with root package name */
    public static BluedSharedPreferences f34719a;
    public static String aA = "VERSION_FROM_UPDATE";
    public static String aB = "USER_CONSENT_CLAUSE";
    public static String aC = "SHOWED_DIALOG_DOWNLOAD_INTERNATIONAL";
    public static String aD = "SHOWED_FOLLOW_TO_VIEW_LIVE";
    public static String aE = "SHOWED_FILTER_DOT_722";
    public static String aF = "SHOWED_LIVE_CAMERA_REMIND";
    public static String aG = "FIREST_LIVE_CACEL";
    public static String aH = "VERIFYED_TIME";
    public static String aI = "new_feature_group_notify";
    public static String aJ = "new_feature_live_list";
    public static String aK = "SHOWED_NEWFEATURE_WECHAT_BIND";
    public static String aL = "NEW_EMOTION_CODE";
    public static String aM = "SHOWED_SETTING_REMIND";
    public static String aN = "select_photo_new";
    public static String aO = "zan_res";
    public static String aP = "SHOWED_MY_GIFT_DOT";
    public static String aQ = "LAST_SPLASH_ID";
    public static String aR = "SPLASH_NEXT_INTERVAL_FLOAT";
    public static String aS = "first_msg_sight";
    public static String aT = "mode_listen";
    public static String aU = "lock";
    public static String aV = "pattern";
    public static String aW = "back";
    public static String aX = "app_back";
    public static String aY = "SHOW_CHAT_BG_RED_DOT";
    public static String aZ = "visitor_record_remind";
    public static String aa = "groupchatvoice";
    public static String ab = "groupchatshake";
    public static String ac = "pushmessage";
    public static String ad = "remindsystem";
    public static String ae = "livepushstate";
    public static String af = "REMIND_OTHER_PUSH";
    public static String ag = "remindmessage";
    public static String ah = "remindfollowed";
    public static String ai = "receivegroupmsg";
    public static String aj = "remindcomments";
    public static String ak = "feed_praise";
    public static String al = "FEED_AT";
    public static String am = "visited_push";
    public static String an = "recommend_live";
    public static String ao = "SHOWED_SHARE_HINT";
    public static String ap = "ignore";
    public static String aq = "secrets_look";

    /* renamed from: ar  reason: collision with root package name */
    public static String f34720ar = "TIPS_VIDEO_CHAT";
    public static String as = "LAST_APPLIST_POSTED_TIME";
    public static String at = "OPEN_CUSTOM_RECOMMEND";
    public static String au = "OPEN_FEED_CUSTOM_RECOMMEND";
    public static String av = "screen_wide";
    public static String aw = "screen_hight";
    public static String ax = "deskapp_created";
    public static String ay = "guide_version";
    public static String az = "NEARBY_PEOPLE_DATA_CHOOSE_SORT_BY";
    public static BluedSharedPreferences b;
    public static String bA = "IS_CAN_VOICE_TURN_TEXT";
    public static String bB = "GROUP_TIPS_TIME";
    public static String bC = "IS_SHOW_MSG_PIC_PIN_GUIDE";
    public static String bD = "IS_FIRST_OP_MAP_SEARCH";
    public static String bE = "IS_SHOW_MSG_GROUP_NEW_CIRCLE_GUIDE";
    public static String bF = "SHOW_NEARBY_FEED_SORT";
    public static String bG = "MAP_DIALOG_SHOW_TIME";
    public static String bH = "ISCHECKED_NOT_SHOW_DIALOG";
    public static String bI = "MSG_GROUP_NEW_CIRCLE_REMIND_TIME";
    public static String bJ = "MSG_GROUP_ANNOUNCEMENT";
    public static String bK = "IS_SHOW_MAP_DOT";
    public static String bL = "SHOW_MSG_MY_GROUP_GUIDE_TIME";
    public static String bM = "SHOW_MSG_MY_GROUP_SECOND_GUIDE_TME";
    public static String bN = "IS_SHOW_CREATE_GROUP_GUIDE";
    public static String bO = "IS_SHOW_RED_PACK_GUIDE_ANIMATION";
    public static String bP = "RED_PACK_SIGN_DATE";
    public static String bQ = "MSG_LIST_CHEET_TIME";
    public static String bR = "IS_SHOW_HOME_MINE_MAP_TIP";
    public static String bS = "IS_SHOW_MINE_TIP";
    public static String bT = "GROUP_SUPER_RED";
    public static String bU = "GROUP_SHOW_RECOVER_PRIVILEGE";
    public static String bV = "NEARBY_HOME_MAP_FIND_TIP_NEED_SHOW";
    public static String bW = "OPERATORS_NAME";
    public static String bX = "SHOW_REGISTER_USER_VIP_DIALOG";
    public static String bY = "SHOW_ABUSE_TIME";
    private static String bZ = "CITY_FEED_NEW_CHECKED";
    public static String ba = "SHOW_MAP_VIP_PRIVILEGE_TIP";
    public static String bb = "blued_ad_close";
    public static String bc = "boot_advert_shown";
    public static String bd = "download_id";
    public static String be = "version code";
    public static String bf = "new_game_remind";
    public static String bg = "login_protection_status";
    public static String bh = "new_feature_my";
    public static String bi = "new_feature_setting";
    public static String bj = "SHOW_CHAT_BUBBLE_RED_DOT";
    public static String bk = "SWITCH_UNREAD_MSG_TYPE";
    public static String bl = "SHOW_TAB_UNREAD_MSG_RED_DOT";
    public static String bm = "IS_SHOW_UNREAD_MSG_GUIDE";
    public static String bn = "SHOW_CHAT_BUBBLE_RED_DOT_IN_VIP_CENTER";
    public static String bo = "SHOW_FEED_BG_RED_DOT_IN_VIP_CENTER";
    public static String bp = "SHOWED_AVATAR_WIDGET_RED_DOT_IN_VIP_CENTER";
    public static String bq = "SHOWED_GROUP_LIMIT_RED_DOT_IN_VIP_CENTER";
    public static String br = "SP_DEBUG_CONFIG_JSON";
    public static String bs = "IS_FIRST_SHOW";
    public static String bt = "USER_REGISTER_TIME";
    public static String bu = "NEW_GIFT_GUIDE";
    public static String bv = "BOX_SESSION_ID";
    public static String bw = "EXPOSURE_PAID_ORDER_ID";
    public static String bx = "IS_SHOW_GIFT_PACKAGE_RED";
    public static String by = "first_send_dynamic";
    public static String bz = "IS_FIRST_VOICE_TURN_TEXT";

    /* renamed from: c  reason: collision with root package name */
    public static BluedSharedPreferences f34721c;
    private static String ca = "MAP_SEARCH_HISTORY";
    private static String cb = "MAP_SHADOW_SEARCH_HISTORY";
    private static String cc = "MAP_SHADOW_SET_HISTORY";
    private static String cd = "MARK_YELLOW_HISTORY";
    private static String ce = "CONFIRM_YELLOW_HISTORY";
    private static String cf = "club_hot_push";
    private static String cg = "followed_new_feed_push";
    private static String ch = "chat_room_starts_notification";
    private static String ci = "SHOWED_INVISIBLE_RED_DOT_IN_VIP_CENTER";
    private static String cj = "IS_SHOW_MSG_MY_GROUP_NEW_GUIDE";
    private static String ck = "MSG_MY_GROUP_ANIMATION_SHOW_TIME";
    private static String cl = "STOCK_CALL_TIP_SHOW_TIME";
    public static BluedSharedPreferences d;
    public static BluedSharedPreferences e;
    public static BluedSharedPreferences f;
    public static BluedSharedPreferences g;
    public static BluedSharedPreferences h;
    public static String i = "LAUNCHER_ACTIVITY_CLASS_NAME";
    public static String j = "APP_LAUNCH_COUNT";
    public static String k = "AUTO_REFRESH_LOCATION_PEOPLE_CHECKED";
    public static String l = "AUTO_REFRESH_LOCATION_FEED_CHECKED";
    public static String m = "display_term";
    public static String n = "adress";
    public static String o = "adressdetail";
    public static String p = "PATTERN_LOCK_STATUS_POSTED";
    public static String q = "FIND_RECOMMEND_TYPE";
    public static String r = "NEARBY_FRIEND_DRAW_MAX_NUM";
    public static String s = "NEARBY_FRIEND_DRAW_SOURCE";
    public static String t = "NEARBY_FRIEND_DRAW_TYPE";
    public static String u = "BLUED_CONFIG";
    public static String v = "AV_CONFIG";
    public static String w = "PAY_EXPERIMENT_CONFIG";
    public static String x = "SPLASH_TEST_SHOW";
    public static String y = "SPLASH_TEST_OPEN";
    public static String z = "UTETOOLS_SHOW";

    public static String A() {
        return c().a(s, "DISTANCE_SORT");
    }

    public static void A(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("NEARBY_RECOMMEND_DAY_OF_YEAR" + UserInfo.getInstance().getLoginUserInfo().uid, i2).a();
    }

    public static void A(long j2) {
        a().c().a(cl, j2).b();
    }

    public static void A(String str) {
        a().c().a(az, str).a();
    }

    public static void A(boolean z2) {
        e().c().a(ch, z2).b();
    }

    public static String B() {
        return c().a(t, "DISTANCE_SORT");
    }

    public static void B(long j2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("SEND_LAST_MSG_TIME" + UserInfo.getInstance().getLoginUserInfo().uid, j2).b();
    }

    public static void B(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + aH, str).a();
    }

    public static void B(boolean z2) {
        e().c().a(aq, z2 ? "yes" : "no").a();
    }

    public static String C() {
        BluedSharedPreferences c2 = c();
        return c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + u, "");
    }

    public static void C(long j2) {
        a().c().a("ECOLOGY_MSG_TIME", j2).b();
    }

    public static void C(String str) {
        c().c().a(aN, str).a();
    }

    public static void C(boolean z2) {
        a().c().a(at, z2).a();
    }

    public static String D() {
        return c().a(w, "");
    }

    public static void D(long j2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("GUESS_LIKE_USER_SHOW_TIME" + UserInfo.getInstance().getLoginUserInfo().uid, j2).a();
    }

    public static void D(String str) {
        BluedSharedPreferences.Editor c2 = b().c();
        c2.a(aQ + AppInfo.g, str).a();
    }

    public static void D(boolean z2) {
        a().c().a(aT, z2).a();
    }

    public static void E(long j2) {
        a().c().a("SELF_USERINFO_SUPER_EXPOSE_GUIDE_TIME", j2).b();
    }

    public static void E(String str) {
        g().c().a(aV, str).a();
    }

    public static void E(boolean z2) {
        f().c().a(aU, z2).a();
    }

    public static boolean E() {
        return d().a(x, false);
    }

    public static void F(long j2) {
        a().c().a("RESOURCE_PROMOTION_TIME", j2).b();
    }

    public static void F(String str) {
        g().c().a("pattern_code_" + UserInfo.getInstance().getLoginUserInfo().getUid(), str).a();
    }

    public static void F(boolean z2) {
        f().c().a("lock_onoff_" + UserInfo.getInstance().getLoginUserInfo().getUid(), z2).a();
    }

    public static boolean F() {
        return d().a(y, false);
    }

    public static long G(long j2) {
        BluedSharedPreferences a2 = a();
        return a2.a("PRIVATE_CHAT_3_DAYS_TO_SET_SPEICAL_CARE_MSG_ID" + UserInfo.getInstance().getLoginUserInfo().uid + j2, 0L);
    }

    public static String G(String str) {
        return a().a("pay_token", str);
    }

    public static void G(boolean z2) {
        a().c().a(aZ, z2).a();
    }

    public static boolean G() {
        return d().a(z, false);
    }

    public static void H(String str) {
        a().c().a("pay_token", str).a();
    }

    public static void H(boolean z2) {
        a().c().a("privacy_photo_onoff", z2).a();
    }

    public static boolean H() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + A, true);
    }

    public static String I() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + C, "");
    }

    public static void I(String str) {
        a().c().a(be, str).a();
    }

    public static void I(boolean z2) {
        a().c().a(bc, z2).a();
    }

    public static int J() {
        BluedSharedPreferences d2 = d();
        return d2.b(UserInfo.getInstance().getLoginUserInfo().getUid() + D, 1);
    }

    public static void J(String str) {
        a().c().a("login_out_msg", str).a();
    }

    public static void J(boolean z2) {
        a().c().a(bg, z2).a();
    }

    public static String K() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + E, "");
    }

    public static void K(String str) {
        a().c().a("live_classify_tab", str).a();
    }

    public static void K(boolean z2) {
        a().c().a("CHAT_SETTING_ENTER_SEND", z2).b();
    }

    public static String L() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + F, "");
    }

    public static void L(String str) {
        a().c().a("live_classify_tab_new", str).a();
    }

    public static void L(boolean z2) {
        a().c().a("blued_skin", z2).b();
    }

    public static String M() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + G, "");
    }

    public static String M(String str) {
        return a().a(str, "");
    }

    public static void M(boolean z2) {
        a().c().a("SETTING_TEXT_SIZE_DOT", z2).b();
    }

    public static String N() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + H, "");
    }

    public static void N(String str) {
        a().c().a("UPDATE_TIPS_DATA", str).a();
    }

    public static void N(boolean z2) {
        a().c().a("welcome_anim", z2).b();
    }

    public static String O() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + I, "");
    }

    public static void O(String str) {
        a().c().a("POSTED_PATCH_CODE", str).a();
    }

    public static void O(boolean z2) {
        a().c().a("change_skin", z2).b();
    }

    public static void P(boolean z2) {
        a().c().a("IS_NEED_SYNC_REMIND_SETTING", z2).b();
    }

    public static boolean P() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + J, false);
    }

    public static boolean P(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BluedSharedPreferences a2 = a();
        return a2.a("IS_SHOW_MINE_ENTRY_DOT_OR_NEW" + str, true);
    }

    public static void Q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("IS_SHOW_MINE_ENTRY_DOT_OR_NEW" + str, false).a();
    }

    public static void Q(boolean z2) {
        a().c().a("IS_NEED_SYNC_GROUP_REMIND_SETTING", z2).b();
    }

    public static boolean Q() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + "FILTER_NEW_HAS_ABLUM", false);
    }

    public static void R(String str) {
        a().c().a("IS_SHOW_SELECT_GUIDE_CODE", str).b();
    }

    public static void R(boolean z2) {
        a().c().a("remind_login_mobile", z2).b();
    }

    public static boolean R() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + K, false);
    }

    public static void S(String str) {
        a().c().a("CALL_TIP_SHOW_TIME_UID", str).b();
    }

    public static void S(boolean z2) {
        a().c().a("remind_common_mobile", z2).b();
    }

    public static boolean S() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + L, false);
    }

    public static String T() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + M, "");
    }

    public static void T(String str) {
        a().c().a("MSG_BOX_SOURCE_STRING", str).b();
    }

    public static void T(boolean z2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("has_verify_mobile" + UserInfo.getInstance().getLoginUserInfo().uid, z2).b();
    }

    public static String U() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + N, "");
    }

    public static void U(String str) {
        a().c().a("MSG_BOX_DISTANCE", str).b();
    }

    public static void U(boolean z2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("has_used_mobile" + UserInfo.getInstance().getLoginUserInfo().uid, z2).b();
    }

    public static String V() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + O, "");
    }

    public static void V(String str) {
        a().c().a("NEARBY_CITY_CODE", str).b();
    }

    public static void V(boolean z2) {
        a().c().a("MSG_BOX_TG", z2).b();
    }

    public static String W() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + P, "");
    }

    public static void W(String str) {
        a().c().a("dynamic_skin", str).b();
    }

    public static void W(boolean z2) {
        BluedSkinPreferences.a(z2);
        if (z2) {
            s((int) R.string.msg_to_system);
        } else {
            s(cK() ? 2131886811 : 2131886815);
        }
    }

    public static String X() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + Q, "");
    }

    public static void X(String str) {
        a().c().a("avatar_widget", str).b();
    }

    public static void X(boolean z2) {
        a().c().a("install_and_login", z2).b();
    }

    public static void Y(String str) {
        a().c().a("blued_version_introduce", str).b();
    }

    public static void Y(boolean z2) {
        a().c().a("IS_SHOW_SECRET_HINT", z2).b();
    }

    public static boolean Y() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + R, false);
    }

    public static String Z() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + S, "");
    }

    public static void Z(String str) {
        a().c().a("HELLO_RANK_BY", str).b();
    }

    public static void Z(boolean z2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(bl + UserInfo.getInstance().getLoginUserInfo().uid, z2).b();
    }

    public static BluedSharedPreferences a() {
        if (f34719a == null) {
            f34719a = BluedSharedPreferences.a();
        }
        return f34719a;
    }

    public static String a(int i2, long j2) {
        BluedSharedPreferences a2 = a();
        return a2.a(UserInfo.getInstance().getLoginUserInfo().uid + PhoneConstants.APN_TYPE_ALL + i2 + PhoneConstants.APN_TYPE_ALL + j2, "");
    }

    public static String a(String str) {
        return c().a(i, str);
    }

    public static void a(float f2) {
        b().c().a(aR, f2).a();
    }

    public static void a(int i2) {
        c().c().a(r, i2).a();
    }

    public static void a(int i2, long j2, String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().uid + PhoneConstants.APN_TYPE_ALL + i2 + PhoneConstants.APN_TYPE_ALL + j2, str).b();
    }

    public static void a(int i2, String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("VIRTUAL_IMAGE_CAT_TAB_RED_DOT_" + i2, str).b();
    }

    public static void a(long j2) {
        a().c().a(as, j2).a();
    }

    public static void a(long j2, long j3) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(bB + j2, j3).b();
    }

    public static void a(long j2, String str) {
        a().c().a("download_id_" + j2, str).a();
    }

    public static void a(String str, int i2) {
        a().c().a(str, i2).b();
    }

    public static void a(String str, long j2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("VIRTUAL_IMAGE_DOUBLE_TAP_TIME_" + str, j2).b();
    }

    public static void a(String str, long j2, long j3) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("PRIVATE_CHAT_MAP_CHANCE_ENCOUNTER_TIPS_SHOW_DAY_OF_YEAR" + j2 + str + UserInfo.getInstance().getLoginUserInfo().uid, j3).a();
    }

    public static void a(String str, String str2) {
        BluedSharedPreferences.Editor c2 = e().c();
        c2.a(X + str, str2).a();
    }

    public static void a(boolean z2) {
        d().c().a(x, z2).a();
    }

    public static void aA(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("NEW_CALL_BUBBLE" + UserInfo.getInstance().getLoginUserInfo().uid, str).a();
    }

    public static boolean aA() {
        return a().a(at, false);
    }

    public static String aB() {
        return a().a(az, (String) null);
    }

    public static void aB(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("FILTER_NEW_CONSTELLATION" + UserInfo.getInstance().getLoginUserInfo().uid, str).a();
    }

    public static int aC() {
        BluedSharedPreferences a2 = a();
        return a2.b(aA + AppInfo.h, -1);
    }

    public static boolean aD() {
        return a().a(aB, false);
    }

    public static void aE() {
        a().c().a(aB, true).b();
        LoginPreferences.g();
    }

    public static int aF() {
        return CommonPreferences.c();
    }

    public static boolean aG() {
        return a().a(aC, true);
    }

    public static void aH() {
        a().c().a(aC, false).a();
    }

    public static boolean aI() {
        return a().a(aE, false);
    }

    public static void aJ() {
        a().c().a(aE, true).a();
    }

    public static void aK() {
        a().c().a(aF, false).a();
    }

    public static boolean aL() {
        return a().a(aG, true);
    }

    public static void aM() {
        a().c().a(aG, false).a();
    }

    public static String aN() {
        BluedSharedPreferences a2 = a();
        return a2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + aH, "");
    }

    public static boolean aO() {
        return a().a(aJ, true);
    }

    public static void aP() {
        a().c().a(aJ, false).a();
    }

    public static String aQ() {
        return c().a(aN, "");
    }

    public static boolean aR() {
        return a().a(aP, false);
    }

    public static void aS() {
        a().c().a(aP, true).a();
    }

    public static String aT() {
        BluedSharedPreferences b2 = b();
        return b2.a(aQ + AppInfo.g, "");
    }

    public static float aU() {
        return b().a(aR, 0.0f);
    }

    public static boolean aV() {
        return a().a(aT, false);
    }

    public static boolean aW() {
        return f().a(aU, false);
    }

    public static boolean aX() {
        return f().a("lock_onoff_" + UserInfo.getInstance().getLoginUserInfo().getUid(), false);
    }

    public static boolean aY() {
        if (aW()) {
            E(false);
            F(true);
        }
        return aX();
    }

    public static String aZ() {
        return g().a(aV, "");
    }

    public static String aa() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + T, "");
    }

    public static void aa(String str) {
        a().c().a("HELLO_ROLE", str).b();
    }

    public static void aa(boolean z2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(bx + UserInfo.getInstance().getLoginUserInfo().uid, z2).b();
    }

    public static String ab() {
        BluedSharedPreferences d2 = d();
        return d2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + U, "0-max");
    }

    public static void ab(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(br + UserInfo.getInstance().getLoginUserInfo().uid, str).b();
    }

    public static void ab(boolean z2) {
        a().c().a(cj, z2).b();
    }

    public static void ac(boolean z2) {
        a().c().a("NEARBY_PEOPLE_LIST_IS_NEED_VIP_TO_SHOW", z2).b();
    }

    public static boolean ac() {
        return e().a(W, true);
    }

    public static boolean ac(String str) {
        BluedSharedPreferences a2 = a();
        return a2.a(str + bs, false);
    }

    @Deprecated
    public static String ad() {
        return e().a(X, "");
    }

    public static void ad(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(str + bs, true).a();
    }

    public static void ad(boolean z2) {
        a().c().a("VIRTUAL_IMAGE_FIRST_GUIDE_SHOWN", z2).b();
    }

    public static void ae(String str) {
        a().c().a(bt, str).a();
    }

    public static void ae(boolean z2) {
        a().c().a("VIRTUAL_IMAGE_DOUBLE_TAP_GUIDE_SHOWN", z2).b();
    }

    public static boolean ae() {
        return e().a(Y, true);
    }

    public static String af(String str) {
        BluedSharedPreferences a2 = a();
        return a2.a(bv + str, "");
    }

    public static void af(boolean z2) {
        a().c().a("FORGOT_PASSWORD_MARK", z2).b();
    }

    public static boolean af() {
        return e().a(Z, false);
    }

    public static void ag(String str) {
        a().c().a(bw, str).b();
    }

    public static void ag(boolean z2) {
        a().c().a("CLOSE_RESOURCE_PROMOTION", z2).b();
    }

    public static boolean ag() {
        return e().a(ac, true);
    }

    public static boolean ah() {
        return e().a(ad, true);
    }

    public static boolean ah(String str) {
        BluedSharedPreferences a2 = a();
        return a2.a(str + bD, true);
    }

    public static void ai(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(str + bD, false).a();
    }

    public static boolean ai() {
        return e().a(ae, true);
    }

    public static boolean aj() {
        return e().a(af, true);
    }

    public static boolean aj(String str) {
        BluedSharedPreferences a2 = a();
        return a2.a(str + bH, true);
    }

    public static void ak(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(str + bH, false).a();
    }

    public static boolean ak() {
        return e().a(ag, true);
    }

    public static int al(String str) {
        return a().b(str, 1);
    }

    public static boolean al() {
        return e().a(ah, true);
    }

    public static void am(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(bO + UserInfo.getInstance().getLoginUserInfo().uid, Long.valueOf(str).longValue()).b();
    }

    public static boolean am() {
        return e().a(ai, true);
    }

    public static void an(String str) {
        a().c().a(bW, str).b();
    }

    public static boolean an() {
        return e().a(aj, true);
    }

    public static void ao(String str) {
        a().c().a("STOCK_CALL_TIP_SHOW_TIME_UID", str).b();
    }

    public static boolean ao() {
        return e().a(ak, true);
    }

    public static void ap(String str) {
        a().c().a("UNCAUGHT_EXCEPTION", str).b();
    }

    public static boolean ap() {
        return e().a(al, true);
    }

    public static void aq(String str) {
        a().c().a("WM_ACCESS_TOKEN", str).b();
    }

    public static boolean aq() {
        return e().a(am, true);
    }

    public static void ar(String str) {
        a().c().a("WM_WID", str).b();
    }

    public static boolean ar() {
        return e().a(an, true);
    }

    public static void as(String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().uid + "GLOBAL_SEARCH_RECENT", str).b();
    }

    public static boolean as() {
        return e().a(cf, true);
    }

    public static void at(String str) {
        a().c().a("VIRTUAL_IMAGE_EVENT_SHOWN", str).b();
    }

    public static boolean at() {
        return e().a(cg, true);
    }

    public static Long au(String str) {
        BluedSharedPreferences a2 = a();
        return Long.valueOf(a2.a("VIRTUAL_IMAGE_DOUBLE_TAP_TIME_" + str, 0L));
    }

    public static boolean au() {
        return e().a(ch, true);
    }

    public static void av(String str) {
        a().c().a("FEED_SIGN_TOP_GUIDE_LAST_CITY", str).a();
    }

    public static boolean av() {
        if (UserInfo.getInstance().getLoginUserInfo() != null && (UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 || BluedConfig.a().g().is_view_secretly == 0)) {
            B(false);
        }
        return TextUtils.equals(e().a(aq, ""), "yes");
    }

    public static void aw() {
        e().c().a(aq, "").a();
    }

    public static void aw(String str) {
        a().c().a("MINE_PAGE_GROUP_ENTER_DOT_CONTENT", str).a();
    }

    public static String ax(String str) {
        BluedSharedPreferences a2 = a();
        return a2.a("CHAT_USER_PRIVILEGE_SOURCE_TIPS" + str, "");
    }

    public static boolean ax() {
        return TextUtils.isEmpty(e().a(aq, ""));
    }

    public static void ay(String str) {
        a().c().a("LAST_INSERT_OPERATE_ARRAY", str).a();
    }

    public static boolean ay() {
        return a().a(f34720ar, true);
    }

    public static long az(String str) {
        BluedSharedPreferences a2 = a();
        return a2.a("LAST_SHOW_MESSAGE_TAB_BUBBLE_TIME" + str, 0L);
    }

    public static void az() {
        a().c().a(f34720ar, false).a();
    }

    public static BluedSharedPreferences b() {
        if (e == null) {
            e = BluedSharedPreferences.a("blued_sf_common", 0);
        }
        return e;
    }

    public static void b(int i2) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + D, i2).a();
    }

    public static void b(long j2) {
        h().c().a(aW, j2).a();
    }

    public static void b(long j2, long j3) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("PRIVATE_CHAT_3_DAYS_TO_SET_SPEICAL_CARE_MSG_ID" + UserInfo.getInstance().getLoginUserInfo().uid + j2, j3).a();
    }

    public static void b(long j2, String str) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(j2 + bJ, str).b();
    }

    public static void b(String str) {
        c().c().a(i, str).a();
    }

    public static void b(String str, long j2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("LAST_SHOW_MESSAGE_TAB_BUBBLE_TIME" + str, j2).a();
    }

    public static void b(String str, String str2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(bv + str, str2).b();
    }

    public static void b(boolean z2) {
        d().c().a(y, z2).a();
    }

    public static final long bA() {
        return a().a("FEED_PROMOTION_TIME", 0L);
    }

    public static final String bB() {
        return a().a("POSTED_PATCH_CODE", "");
    }

    public static int bC() {
        BluedSharedPreferences a2 = a();
        return a2.b("PRIVILEGE_BUY_PAY_TYPE" + UserInfo.getInstance().getLoginUserInfo().uid, 0);
    }

    public static boolean bD() {
        return a().a("SYNC_AVATAR_TIP", true);
    }

    public static void bE() {
        a().c().a("SYNC_AVATAR_TIP", false).a();
    }

    public static boolean bF() {
        return a().a("SYNC_AVATAR_DOT_TIP", true);
    }

    public static void bG() {
        a().c().a("SYNC_AVATAR_DOT_TIP", false).a();
    }

    public static void bH() {
        a().c().a("HAS_SHOW_MSG_MENU_RED_POINT_716", true).a();
    }

    public static boolean bI() {
        return a().a("HAS_SHOW_MSG_MENU_RED_POINT_716", false);
    }

    public static void bJ() {
        a().c().a("HAS_SHOW_MSG_BOX_TV_HINT", true).a();
    }

    public static final boolean bK() {
        return a().a("HAS_SHOW_MSG_BOX_TV_HINT", false);
    }

    public static int bL() {
        return a().b("CALL_HELLO_BTN_STATUS", 0);
    }

    public static void bM() {
        a().c().a("IS_SHOW_FILTER_GREATER_SIX", true).b();
    }

    public static boolean bN() {
        return a().a("IS_SHOW_FILTER_GREATER_SIX", false);
    }

    public static void bO() {
        a().c().a("IS_SHOW_HOME_GUIDE_7112", true).b();
    }

    public static boolean bP() {
        return a().a("IS_SHOW_HOME_GUIDE_7112", false);
    }

    public static void bQ() {
        a().c().a("IS_CLEAR_FILTER_H_W_A", true).b();
    }

    public static boolean bR() {
        return a().a("IS_CLEAR_FILTER_H_W_A", false);
    }

    public static String bS() {
        return a().a("IS_SHOW_SELECT_GUIDE_CODE", "");
    }

    public static boolean bT() {
        return a().a("NEARBY_SORT_BY_FIRST_OPEN", true);
    }

    public static void bU() {
        a().c().a("NEARBY_SORT_BY_FIRST_OPEN", false).a();
    }

    public static boolean bV() {
        return a().a("CHAT_LIE_TOP_REMIND", false);
    }

    public static void bW() {
        a().c().a("CHAT_LIE_TOP_REMIND", true).b();
    }

    public static boolean bX() {
        return a().a("CHAT_SETTING_LIE_TOP_REMIND", false);
    }

    public static void bY() {
        a().c().a("CHAT_SETTING_LIE_TOP_REMIND", true).b();
    }

    public static boolean bZ() {
        return a().a("CHAT_SETTING_ENTER_SEND", false);
    }

    public static String ba() {
        return g().a("pattern_code_" + UserInfo.getInstance().getLoginUserInfo().getUid(), "");
    }

    public static String bb() {
        if (!"".equals(aZ())) {
            F(aZ());
            E("");
        }
        return ba();
    }

    public static Long bc() {
        return Long.valueOf(h().a(aW, 0L));
    }

    public static Long bd() {
        return Long.valueOf(h().a(aX, 0L));
    }

    public static boolean be() {
        return a().a(aZ, false);
    }

    public static boolean bf() {
        return a().a(ba, true);
    }

    public static void bg() {
        a().c().a(ba, false).a();
    }

    public static String bh() {
        return a().a("push_token", "");
    }

    public static int bi() {
        return a().b("modify_user_info_bg", 0);
    }

    public static int bj() {
        return a().b("image_gesture_guide_53", 0);
    }

    public static int bk() {
        return a().b("album_gesture_guide_53", 0);
    }

    public static int bl() {
        return a().b("live_xiaomi_status", 0);
    }

    public static boolean bm() {
        return a().a("app_active", false);
    }

    public static void bn() {
        a().c().a("app_active", true).a();
    }

    public static boolean bo() {
        return a().a("privacy_photo_onoff", true);
    }

    public static boolean bp() {
        return a().a(bc, false);
    }

    public static long bq() {
        return a().a(bd, -1L);
    }

    public static String br() {
        return a().a(be, "");
    }

    public static boolean bs() {
        return f34719a.a(bg, false);
    }

    public static boolean bt() {
        return f34719a.a(bh, true);
    }

    public static int bu() {
        return a().b("live_is_soft", 0);
    }

    public static int bv() {
        return a().b("live_is_beauty", 0);
    }

    public static String bw() {
        return a().a("login_out_msg", "");
    }

    public static String bx() {
        return a().a("live_classify_tab_new", (String) null);
    }

    public static String by() {
        return a().a("UPDATE_TIPS_DATA", "");
    }

    public static int bz() {
        return a().b("UPDATE_TIPS_TIMES", 0);
    }

    public static long c(String str, long j2) {
        BluedSharedPreferences a2 = a();
        return a2.a("PRIVATE_CHAT_MAP_CHANCE_ENCOUNTER_TIPS_SHOW_DAY_OF_YEAR" + j2 + str + UserInfo.getInstance().getLoginUserInfo().uid, -1L);
    }

    public static BluedSharedPreferences c() {
        if (b == null) {
            b = BluedSharedPreferences.a("blued_sf", 0);
        }
        return b;
    }

    public static void c(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(aA + AppInfo.h, i2).a();
    }

    public static void c(long j2) {
        h().c().a(aX, j2).a();
    }

    public static void c(String str) {
        c().c().a(ca, str).a();
    }

    public static void c(String str, String str2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("CHAT_USER_PRIVILEGE_SOURCE_TIPS" + str, str2).a();
    }

    public static void c(boolean z2) {
        d().c().a(z, z2).a();
    }

    public static boolean cA() {
        return a().a("IS_CLOSE_IM_PROFILE_REMIND", false);
    }

    public static void cB() {
        a().c().a("IS_CLOSE_IM_PROFILE_REMIND", true).b();
    }

    public static int cC() {
        return a().b("VISITOR_EDIT_TIP_SHOW_TIMES", 0);
    }

    public static long cD() {
        return a().a("VISITOR_EDIT_TIP_SHOW_TIME", 0L);
    }

    public static long cE() {
        return a().a("CALL_TIP_SHOW_TIME", 0L);
    }

    public static String cF() {
        return a().a("CALL_TIP_SHOW_TIME_UID", "");
    }

    public static String cG() {
        return a().a("MSG_BOX_SOURCE_STRING", "");
    }

    public static String cH() {
        return a().a("MSG_BOX_DISTANCE", "");
    }

    public static boolean cI() {
        return a().a("IS_REQUEST_OPPO_MSG_PERMISSION", false);
    }

    public static void cJ() {
        a().c().a("IS_REQUEST_OPPO_MSG_PERMISSION", true).b();
    }

    public static final boolean cK() {
        return a().a("change_skin", false);
    }

    public static boolean cL() {
        return a().a("IS_NEED_SYNC_REMIND_SETTING", true);
    }

    public static void cM() {
        a().c().a("IS_SHOW_MSG_BOX_FULL_GUIDE", true).b();
    }

    public static boolean cN() {
        return a().a("remind_login_mobile", true);
    }

    public static boolean cO() {
        return a().a("remind_common_mobile", true);
    }

    public static boolean cP() {
        return a().a("health_tips", false);
    }

    public static void cQ() {
        a().c().a("health_tips", true).b();
    }

    public static boolean cR() {
        return a().a("set_avatar_widget", false);
    }

    public static void cS() {
        a().c().a("set_avatar_widget", true).b();
    }

    public static boolean cT() {
        return a().a("set_avatar_widget_click", false);
    }

    public static void cU() {
        a().c().a("set_avatar_widget_click", true).b();
    }

    public static boolean cV() {
        return a().a("set_avatar_widget_long", false);
    }

    public static void cW() {
        a().c().a("set_avatar_widget_long", true).b();
    }

    public static void cX() {
        a().c().a("fans_list_dot", true).b();
    }

    public static boolean cY() {
        return a().a("group_list_dot", false);
    }

    public static void cZ() {
        a().c().a("group_list_dot", true).b();
    }

    public static boolean ca() {
        return a().a("CHAT_SETTING_LISTEN_MODEL_REMIND", false);
    }

    public static void cb() {
        a().c().a("CHAT_SETTING_LISTEN_MODEL_REMIND", true).b();
    }

    public static boolean cc() {
        return a().a("blued_skin", false);
    }

    public static boolean cd() {
        return a().a("SETTING_TEXT_SIZE_DOT", false);
    }

    public static int ce() {
        return a().b("SETTING_TEXT_SIZE", 1);
    }

    public static boolean cf() {
        return a().a("SETTING_LIVE_REMIND", false);
    }

    public static void cg() {
        a().c().a("SETTING_LIVE_REMIND", true).b();
    }

    public static boolean ch() {
        return a().a("SETTING_COMMON_NEW_706_REMIND", false);
    }

    public static void ci() {
        a().c().a("SETTING_COMMON_NEW_706_REMIND", true).b();
    }

    public static boolean cj() {
        return a().a("SETTING_COMMON_RETURN_SEND_REMIND", false);
    }

    public static void ck() {
        a().c().a("SETTING_COMMON_RETURN_SEND_REMIND", true).b();
    }

    public static boolean cl() {
        return a().a("SETTING_SWITCH_ACCOUNT_REMIND", false);
    }

    public static void cm() {
        a().c().a("SETTING_SWITCH_ACCOUNT_REMIND", true).b();
    }

    public static boolean cn() {
        return a().a("MINE_FEED_NEW_SHOW", true);
    }

    public static void co() {
        a().c().a("MINE_FEED_NEW_SHOW", false).b();
    }

    public static boolean cp() {
        return a().a("svip_dot_show", true);
    }

    public static void cq() {
        a().c().a("svip_dot_show", false).b();
    }

    public static boolean cr() {
        return a().a("welcome_anim", false);
    }

    public static boolean cs() {
        return a().a("shadow_set_tips", true);
    }

    public static void ct() {
        a().c().a("shadow_set_tips", false).b();
    }

    public static long cu() {
        return a().a("PUSH_CHECK_TIME", 0L);
    }

    public static long cv() {
        return a().a("PERMANENT_PUSH_CHECK_TIME", 0L);
    }

    public static long cw() {
        return a().a("LIVE_ATTENTION_CHECK_TIME", 0L);
    }

    public static long cx() {
        return a().a("MSG_CHECK_TIME", 0L);
    }

    public static boolean cy() {
        return a().a("VIP_COUPON_DOT_SHOWED1", false);
    }

    public static void cz() {
        a().c().a("VIP_COUPON_DOT_SHOWED1", true).b();
    }

    public static BluedSharedPreferences d() {
        if (f34721c == null) {
            f34721c = BluedSharedPreferences.a("blued_sf_find_sift", 0);
        }
        return f34721c;
    }

    public static void d(int i2) {
        CommonPreferences.f(i2);
    }

    public static void d(long j2) {
        a().c().a(bd, j2).a();
    }

    public static void d(String str) {
        BluedSharedPreferences.Editor c2 = c().c();
        c2.a(cc + UserInfo.getInstance().getLoginUserInfo().uid, str).a();
    }

    public static void d(boolean z2) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + A, z2).a();
        if (HomeActivity.f30985c != null) {
            ((NearbyViewModel) ViewModelProviders.of(HomeActivity.f30985c).get(NearbyViewModel.class)).f30626c.postValue(null);
        }
    }

    public static void dA() {
        a().c().a("IS_SHOWED_AVATAR_WIDGET", true).b();
    }

    public static boolean dB() {
        BluedSharedPreferences a2 = a();
        return a2.a("IS_SHOWED_CALL_OPEN" + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static void dC() {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("IS_SHOWED_CALL_OPEN" + UserInfo.getInstance().getLoginUserInfo().uid, true).b();
    }

    public static boolean dD() {
        return a().a("IS_SHOWED_CUSTOMIZED_FEED_BG", false);
    }

    public static void dE() {
        a().c().a("IS_SHOWED_CUSTOMIZED_FEED_BG", true).b();
    }

    public static boolean dF() {
        return a().a(bj, true);
    }

    public static void dG() {
        a().c().a(bj, false).b();
    }

    public static int dH() {
        return a().b(bk, 0);
    }

    public static boolean dI() {
        BluedSharedPreferences a2 = a();
        return a2.a(bl + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static boolean dJ() {
        return a().a(bm, false);
    }

    public static void dK() {
        a().c().a(bm, true).b();
    }

    public static boolean dL() {
        return a().a(bn, false);
    }

    public static void dM() {
        a().c().a(bn, true).a();
    }

    public static boolean dN() {
        return a().a(bo, false);
    }

    public static void dO() {
        a().c().a(bo, true).a();
    }

    public static boolean dP() {
        return a().a(bp, false);
    }

    public static void dQ() {
        a().c().a(bp, true).a();
    }

    public static boolean dR() {
        return a().a(bq, false);
    }

    public static void dS() {
        a().c().a(bq, true).b();
    }

    public static boolean dT() {
        return a().a(ci, false);
    }

    public static void dU() {
        a().c().a(ci, true).b();
    }

    public static boolean dV() {
        return a().a("SHOWED_SPECIAL_CARE_RED_DOT_IN_VIP_CENTER", false);
    }

    public static void dW() {
        a().c().a("SHOWED_SPECIAL_CARE_RED_DOT_IN_VIP_CENTER", true).b();
    }

    public static String dX() {
        BluedSharedPreferences a2 = a();
        return a2.a(br + UserInfo.getInstance().getLoginUserInfo().uid, "");
    }

    public static String dY() {
        return a().a(bt, "");
    }

    public static String dZ() {
        return a().a(bw, "");
    }

    public static int da() {
        BluedSharedPreferences a2 = a();
        return a2.b("USER_GIFT_PAY_TYPE" + UserInfo.getInstance().getLoginUserInfo().uid, 0);
    }

    public static boolean db() {
        return a().a("IS_REQUEST_OPPO_MSG_PERMISSION", false);
    }

    public static void dc() {
        a().c().a("IS_REQUEST_OPPO_MSG_PERMISSION", true).b();
    }

    public static String dd() {
        return a().a("NEARBY_CITY_CODE", "");
    }

    public static boolean de() {
        BluedSharedPreferences a2 = a();
        return a2.a("has_verify_mobile" + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static boolean df() {
        BluedSharedPreferences a2 = a();
        return a2.a("has_used_mobile" + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static void dg() {
        a().c().a("NEARBY_HOME_TIP_NEED_SHOW", false).b();
    }

    public static String dh() {
        return a().a("dynamic_skin", "");
    }

    public static String di() {
        return a().a("avatar_widget", "");
    }

    public static boolean dj() {
        return a().a("NEARBY_HOME_DOT_NEED_SHOW", true);
    }

    public static void dk() {
        a().c().a("NEARBY_HOME_DOT_NEED_SHOW", false).b();
    }

    public static boolean dl() {
        return a().a("IS_SHOWED_FILTER_DOT", false);
    }

    public static void dm() {
        a().c().a("IS_SHOWED_FILTER_DOT", true).b();
    }

    public static String dn() {
        return a().a("blued_version_introduce", "");
    }

    /* renamed from: do  reason: not valid java name */
    public static boolean m9667do() {
        return a().a("MSG_BOX_TG", false);
    }

    public static long dp() {
        return a().a("MSG_BOX_OPEN_TIME", 0L);
    }

    public static int dq() {
        return a().b("blued_skin_name", R.string.blued_light_mode);
    }

    public static boolean dr() {
        return BluedSkinPreferences.a();
    }

    public static String ds() {
        return a().a("HELLO_RANK_BY", "intelligent");
    }

    public static String dt() {
        return a().a("HELLO_ROLE", "");
    }

    public static long du() {
        BluedSharedPreferences a2 = a();
        return a2.a("IM_GIFT_GUIDE_TIME" + UserInfo.getInstance().getLoginUserInfo().uid, 0L);
    }

    public static boolean dv() {
        return a().a("IS_SHOW_SECRET_HINT", true);
    }

    public static void dw() {
        a().c().a("IS_SHOW_IM_PIC_HINT", true).b();
    }

    public static boolean dx() {
        return a().a("IS_SHOWED_CUSTOMIZED_BUBBLE", false);
    }

    public static void dy() {
        a().c().a("IS_SHOWED_CUSTOMIZED_BUBBLE", true).b();
    }

    public static boolean dz() {
        return a().a("IS_SHOWED_AVATAR_WIDGET", false);
    }

    public static BluedSharedPreferences e() {
        if (d == null) {
            d = BluedSharedPreferences.a("blued_sf_setting", 0);
        }
        return d;
    }

    public static String e(long j2) {
        return a().a("download_id_" + j2, "");
    }

    public static void e(String str) {
        c().c().a(cd, str).a();
    }

    public static void e(boolean z2) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + J, z2).a();
    }

    public static boolean e(int i2) {
        BluedSharedPreferences a2 = a();
        return a2.a(aY + i2, true);
    }

    public static void eA() {
        a().c().a(bR, false).b();
    }

    public static boolean eB() {
        return a().a(bS, true);
    }

    public static void eC() {
        a().c().a(bS, false).b();
    }

    public static boolean eD() {
        return a().a(bT, false);
    }

    public static void eE() {
        a().c().a(bT, true).b();
    }

    public static long eF() {
        return a().a(bU, 0L);
    }

    public static boolean eG() {
        return a().a(bV, true);
    }

    public static void eH() {
        a().c().a(bV, false).b();
    }

    public static String eI() {
        return a().a(bW, "");
    }

    public static boolean eJ() {
        BluedSharedPreferences a2 = a();
        return a2.a(UserInfo.getInstance().getLoginUserInfo().uid + bX, true);
    }

    public static void eK() {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().uid + bX, false).b();
    }

    public static long eL() {
        return a().a(bY, 0L);
    }

    public static long eM() {
        return a().a(cl, 0L);
    }

    public static String eN() {
        return a().a("STOCK_CALL_TIP_SHOW_TIME_UID", "");
    }

    public static String eO() {
        return a().a("UNCAUGHT_EXCEPTION", "");
    }

    public static long eP() {
        BluedSharedPreferences a2 = a();
        return a2.a("SEND_LAST_MSG_TIME" + UserInfo.getInstance().getLoginUserInfo().uid, 0L);
    }

    public static boolean eQ() {
        BluedSharedPreferences a2 = a();
        return a2.a("SERVICE_MSG_SHOW_GUIDE" + UserInfo.getInstance().getLoginUserInfo().uid, true);
    }

    public static void eR() {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("SERVICE_MSG_SHOW_GUIDE" + UserInfo.getInstance().getLoginUserInfo().uid, false).b();
    }

    public static boolean eS() {
        BluedSharedPreferences a2 = a();
        return a2.a("MSG_CHAT_SHOW_GUIDE" + UserInfo.getInstance().getLoginUserInfo().uid, true);
    }

    public static void eT() {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("MSG_CHAT_SHOW_GUIDE" + UserInfo.getInstance().getLoginUserInfo().uid, false).b();
    }

    public static boolean eU() {
        BluedSharedPreferences a2 = a();
        return a2.a("SKIP_TAG_SETTING" + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static void eV() {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("SKIP_TAG_SETTING" + UserInfo.getInstance().getLoginUserInfo().uid, true);
    }

    public static boolean eW() {
        return a().a("MSG_CHAT_BACKUP_NEW", false);
    }

    public static void eX() {
        a().c().a("MSG_CHAT_BACKUP_NEW", true).b();
    }

    public static int eY() {
        return a().b("NEARBY_PEOPLE_LIST_VIP_FLOOR", 0);
    }

    public static boolean eZ() {
        return a().a("NEARBY_PEOPLE_LIST_IS_NEED_VIP_TO_SHOW", false);
    }

    public static boolean ea() {
        BluedSharedPreferences a2 = a();
        return a2.a(bx + UserInfo.getInstance().getLoginUserInfo().uid, false);
    }

    public static boolean eb() {
        return a().a(by, true);
    }

    public static void ec() {
        a().c().a(by, false).b();
    }

    public static boolean ed() {
        return a().a(bz, true);
    }

    public static void ee() {
        a().c().a(bz, false).a();
    }

    public static boolean ef() {
        return aC() == 1 && a().a(bA, true);
    }

    public static void eg() {
        a().c().a(bA, false).a();
    }

    public static void eh() {
        a().c().a(bC, true).b();
    }

    public static boolean ei() {
        return a().a(bC, false);
    }

    public static boolean ej() {
        return a().a(bE, false);
    }

    public static long ek() {
        return a().a(bG, 0L);
    }

    public static void el() {
        a().c().a(bE, true).b();
    }

    public static long em() {
        return a().a(bI, 0L);
    }

    public static boolean en() {
        return a().a(bK, true);
    }

    public static void eo() {
        a().c().a(bK, false).b();
    }

    public static long ep() {
        return a().a(bL, 0L);
    }

    public static long eq() {
        return a().a(bM, 0L);
    }

    public static boolean er() {
        return a().a(cj, true);
    }

    public static long es() {
        return a().a(ck, 0L);
    }

    public static boolean et() {
        return a().a(bN, false);
    }

    public static void eu() {
        a().c().a(bN, true).b();
    }

    public static Boolean ev() {
        return Boolean.valueOf(a().a(bO, true));
    }

    public static void ew() {
        a().c().a(bO, false).b();
    }

    public static Long ex() {
        BluedSharedPreferences a2 = a();
        return Long.valueOf(a2.a(bO + UserInfo.getInstance().getLoginUserInfo().uid, 0L));
    }

    public static long ey() {
        return a().a(bQ, 0L);
    }

    public static boolean ez() {
        return a().a(bR, true);
    }

    public static BluedSharedPreferences f() {
        if (f == null) {
            f = BluedSharedPreferences.a("blued_sf_pattern_lock", 0);
        }
        return f;
    }

    public static void f(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(aY + i2, false).a();
    }

    public static void f(long j2) {
        a().c().a("FEED_PROMOTION_TIME", j2).a();
    }

    public static void f(String str) {
        c().c().a(ce, str).a();
    }

    public static void f(boolean z2) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + "FILTER_NEW_HAS_ABLUM", z2).a();
    }

    public static boolean fA() {
        return a().a("SELF_USER_FACE_FIRST_GUIDE", true);
    }

    public static void fB() {
        a().c().a("SELF_USER_FACE_FIRST_GUIDE", false).b();
    }

    public static boolean fC() {
        return a().a("CLOSE_RESOURCE_PROMOTION", false);
    }

    public static long fD() {
        return a().a("SELF_USERINFO_SUPER_EXPOSE_GUIDE_TIME", 0L);
    }

    public static long fE() {
        return a().a("RESOURCE_PROMOTION_TIME", 0L);
    }

    public static String fF() {
        return a().a("FEED_SIGN_TOP_GUIDE_LAST_CITY", "");
    }

    public static String fG() {
        return a().a("MINE_PAGE_GROUP_ENTER_DOT_CONTENT", "");
    }

    public static String fH() {
        return a().a("LAST_INSERT_OPERATE_ARRAY", "");
    }

    public static String fI() {
        BluedSharedPreferences a2 = a();
        return a2.a("NEW_CALL_BUBBLE" + UserInfo.getInstance().getLoginUserInfo().uid, "");
    }

    public static String fJ() {
        BluedSharedPreferences a2 = a();
        return a2.a("FILTER_NEW_CONSTELLATION" + UserInfo.getInstance().getLoginUserInfo().uid, "");
    }

    public static int fK() {
        BluedSharedPreferences a2 = a();
        return a2.b("NEARBY_RECOMMEND_DAY_OF_YEAR" + UserInfo.getInstance().getLoginUserInfo().uid, 0);
    }

    public static void fL() {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("IS_SHOW_BUBBLE_FEED_GUIDE" + UserInfo.getInstance().getLoginUserInfo().uid, false).a();
    }

    public static boolean fM() {
        BluedSharedPreferences a2 = a();
        return a2.a("IS_SHOW_BUBBLE_FEED_GUIDE" + UserInfo.getInstance().getLoginUserInfo().uid, true);
    }

    public static String fa() {
        return a().a("NEARBY_PEOPLE_LIST_VIP_DIALOG_TITLE", "");
    }

    public static String fb() {
        return a().a("NEARBY_PEOPLE_LIST_VIP_DIALOG_DESC", "");
    }

    public static String fc() {
        return a().a("WM_ACCESS_TOKEN", "");
    }

    public static String fd() {
        BluedSharedPreferences a2 = a();
        return a2.a(UserInfo.getInstance().getLoginUserInfo().uid + "GLOBAL_SEARCH_RECENT", "");
    }

    public static long fe() {
        return a().a("ECOLOGY_MSG_TIME", 0L);
    }

    public static boolean ff() {
        return TimeAndDateUtils.a() > a().a("FEED_SIGN_CITY_TOP_COMMON_GUIDE", 0L);
    }

    public static void fg() {
        a().c().a("FEED_SIGN_CITY_TOP_COMMON_GUIDE", TimeAndDateUtils.a()).a();
    }

    public static long fh() {
        return a().a("ENTER_CITY_TAB_TIME", 0L);
    }

    public static void fi() {
        LogUtils.c("setEnterCityDate:" + TimeAndDateUtils.a());
        a().c().a("ENTER_CITY_TAB_TIME", TimeAndDateUtils.a()).a();
    }

    public static long fj() {
        BluedSharedPreferences a2 = a();
        return a2.a("GUESS_LIKE_USER_SHOW_TIME" + UserInfo.getInstance().getLoginUserInfo().uid, 0L);
    }

    public static void fk() {
        a().c().a("GROUP_CATEGORY_RED_DOT", true).b();
    }

    public static boolean fl() {
        return a().a("GROUP_CATEGORY_RED_DOT", false);
    }

    public static boolean fm() {
        return a().a("VIP_PROTOCOL_CLAUSE_DIALOG_SHOWED", true);
    }

    public static void fn() {
        a().c().a("VIP_PROTOCOL_CLAUSE_DIALOG_SHOWED", false).b();
    }

    public static void fo() {
        a().c().a("VIRTUAL_IMAGE_DIALOG", true).b();
    }

    public static boolean fp() {
        return a().a("VIRTUAL_IMAGE_DIALOG", false);
    }

    public static boolean fq() {
        return a().a("VIRTUAL_IMAGE_FIRST_GUIDE_SHOWN", false);
    }

    public static boolean fr() {
        return a().a("VIRTUAL_IMAGE_DOUBLE_TAP_GUIDE_SHOWN", false);
    }

    public static void fs() {
        a().c().a("VIRTUAL_IMAGE_GUIDE_SHOWN_SECOND", false).b();
    }

    public static boolean ft() {
        return a().a("VIRTUAL_IMAGE_GUIDE_SHOWN_SECOND", true);
    }

    public static String fu() {
        return a().a("VIRTUAL_IMAGE_EVENT_SHOWN", "");
    }

    public static int fv() {
        BluedSharedPreferences a2 = a();
        return a2.b("DAY_OF_YEAR" + UserInfo.getInstance().getLoginUserInfo().uid, 0);
    }

    public static int fw() {
        BluedSharedPreferences a2 = a();
        return a2.b("SPLASH_LOCAL_ID" + UserInfo.getInstance().getLoginUserInfo().uid, 0);
    }

    public static boolean fx() {
        return a().a("FORGOT_PASSWORD_MARK", false);
    }

    public static boolean fy() {
        return a().a("USER_FACE_FIRST_GUIDE", true);
    }

    public static void fz() {
        a().c().a("USER_FACE_FIRST_GUIDE", false).b();
    }

    public static BluedSharedPreferences g() {
        if (g == null) {
            g = BluedSharedPreferences.a("blued_sf_gesture_pattern", 0);
        }
        return g;
    }

    public static void g(int i2) {
        a().c().a("modify_user_info_bg", i2).a();
    }

    public static void g(long j2) {
        a().c().a("PUSH_CHECK_TIME", j2).b();
    }

    public static void g(String str) {
        c().c().a(s, str).a();
    }

    public static void g(boolean z2) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + K, z2).a();
    }

    public static BluedSharedPreferences h() {
        if (h == null) {
            h = BluedSharedPreferences.a("blued_sf_exit", 0);
        }
        return h;
    }

    public static void h(int i2) {
        a().c().a("image_gesture_guide_53", i2).a();
    }

    public static void h(long j2) {
        a().c().a("PERMANENT_PUSH_CHECK_TIME", j2).b();
    }

    public static void h(String str) {
        c().c().a(t, str).a();
    }

    public static void h(boolean z2) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + L, z2).a();
    }

    public static void i() {
        c().c().a(j, c().b(j, 0) + 1).a();
    }

    public static void i(int i2) {
        a().c().a("album_gesture_guide_53", i2).a();
    }

    public static void i(long j2) {
        a().c().a("LIVE_ATTENTION_CHECK_TIME", j2).b();
    }

    public static void i(String str) {
        BluedSharedPreferences.Editor c2 = c().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + u, str).a();
    }

    public static void i(boolean z2) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + R, z2).a();
    }

    public static int j() {
        return c().b(j, 0);
    }

    public static void j(int i2) {
        a().c().a("live_xiaomi_status", i2).a();
    }

    public static void j(long j2) {
        a().c().a("MSG_CHECK_TIME", j2).b();
    }

    public static void j(String str) {
        c().c().a(w, str).a();
    }

    public static void j(boolean z2) {
        e().c().a(W, z2).a();
    }

    public static void k(int i2) {
        a().c().a("live_is_soft", i2).a();
    }

    public static void k(long j2) {
        a().c().a("VISITOR_EDIT_TIP_SHOW_TIME", j2).b();
    }

    public static void k(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + C, str).a();
    }

    public static void k(boolean z2) {
        e().c().a(Y, z2).a();
    }

    public static boolean k() {
        return c().a(k, false);
    }

    public static void l() {
        c().c().a(l, true).a();
    }

    public static void l(int i2) {
        a().c().a("live_is_beauty", i2).a();
    }

    public static void l(long j2) {
        a().c().a("CALL_TIP_SHOW_TIME", j2).b();
    }

    public static void l(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + E, str).a();
    }

    public static void l(boolean z2) {
        e().c().a(Z, z2).a();
    }

    public static void m(int i2) {
        a().c().a("UPDATE_TIPS_TIMES", i2).a();
    }

    public static void m(long j2) {
        a().c().a("MSG_BOX_GUIDE_TIME", j2).b();
    }

    public static void m(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + F, str).a();
    }

    public static void m(boolean z2) {
        e().c().a(ac, z2).a();
    }

    public static boolean m() {
        return c().a(l, false);
    }

    public static void n() {
        BluedSharedPreferences.Editor c2 = c().c();
        c2.a(bZ + j(), true).a();
    }

    public static void n(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("PRIVILEGE_BUY_PAY_TYPE" + UserInfo.getInstance().getLoginUserInfo().uid, i2).a();
    }

    public static void n(long j2) {
        a().c().a("MSG_BOX_OPEN_TIME", j2).b();
    }

    public static void n(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + G, str).a();
    }

    public static void n(boolean z2) {
        e().c().a(ad, z2).a();
    }

    public static String o() {
        return c().a(n, "");
    }

    public static void o(int i2) {
        a().c().a("CALL_HELLO_BTN_STATUS", i2).b();
    }

    public static void o(long j2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("IM_GIFT_GUIDE_TIME" + UserInfo.getInstance().getLoginUserInfo().uid, j2).b();
    }

    public static void o(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + H, str).a();
    }

    public static void o(boolean z2) {
        e().c().a(ae, z2).a();
    }

    public static long p(long j2) {
        BluedSharedPreferences a2 = a();
        return a2.a(bB + j2, 0L);
    }

    public static String p() {
        return c().a(ca, "");
    }

    public static void p(int i2) {
        a().c().a("SETTING_TEXT_SIZE", i2).b();
    }

    public static void p(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + I, str).a();
    }

    public static void p(boolean z2) {
        e().c().a(af, z2).a();
    }

    public static void q() {
        c().c().a(ca).a();
    }

    public static void q(int i2) {
        a().c().a("VISITOR_EDIT_TIP_SHOW_TIMES", i2).b();
    }

    public static void q(long j2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(bB + j2).b();
    }

    public static void q(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + M, str).a();
    }

    public static void q(boolean z2) {
        e().c().a(ag, z2).a();
    }

    public static String r() {
        BluedSharedPreferences c2 = c();
        return c2.a(cb + UserInfo.getInstance().getLoginUserInfo().uid, "");
    }

    public static void r(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("USER_GIFT_PAY_TYPE" + UserInfo.getInstance().getLoginUserInfo().uid, i2).b();
    }

    public static void r(long j2) {
        a().c().a(bG, j2).a();
    }

    public static void r(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + N, str).a();
    }

    public static void r(boolean z2) {
        e().c().a(ah, z2).a();
    }

    public static String s() {
        BluedSharedPreferences c2 = c();
        return c2.a(cc + UserInfo.getInstance().getLoginUserInfo().uid, "");
    }

    public static void s(int i2) {
        a().c().a("blued_skin_name", i2).b();
    }

    public static void s(long j2) {
        a().c().a(bI, j2).b();
    }

    public static void s(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + O, str).a();
    }

    public static void s(boolean z2) {
        e().c().a(ai, z2).a();
    }

    public static String t(long j2) {
        BluedSharedPreferences a2 = a();
        return a2.a(j2 + bJ, "");
    }

    public static void t() {
        BluedSharedPreferences.Editor c2 = c().c();
        c2.a(cc + UserInfo.getInstance().getLoginUserInfo().uid).a();
    }

    public static void t(int i2) {
        a().c().a(bk, i2).b();
    }

    public static void t(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + P, str).a();
    }

    public static void t(boolean z2) {
        e().c().a(aj, z2).a();
    }

    public static String u() {
        return c().a(cd, "");
    }

    public static void u(long j2) {
        a().c().a(bL, j2).b();
    }

    public static void u(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + Q, str).a();
    }

    public static void u(boolean z2) {
        e().c().a(ak, z2).b();
    }

    public static boolean u(int i2) {
        BluedSharedPreferences a2 = a();
        return a2.a(bu + i2, false);
    }

    public static String v() {
        return c().a(ce, "");
    }

    public static void v(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(bu + i2, true).b();
    }

    public static void v(long j2) {
        a().c().a(bM, j2).b();
    }

    public static void v(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + S, str).a();
    }

    public static void v(boolean z2) {
        e().c().a(al, z2).b();
    }

    public static void w(int i2) {
        a().c().a("NEARBY_PEOPLE_LIST_VIP_FLOOR", i2).b();
    }

    public static void w(long j2) {
        a().c().a(ck, j2).b();
    }

    public static void w(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + T, str).a();
    }

    public static void w(boolean z2) {
        e().c().a(am, z2).b();
    }

    public static boolean w() {
        return c().a(p, false);
    }

    public static void x() {
        c().c().a(p, true).a();
    }

    public static void x(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("DAY_OF_YEAR" + UserInfo.getInstance().getLoginUserInfo().uid, i2).b();
    }

    public static void x(long j2) {
        a().c().a(bQ, j2).b();
    }

    public static void x(String str) {
        BluedSharedPreferences.Editor c2 = d().c();
        c2.a(UserInfo.getInstance().getLoginUserInfo().getUid() + U, str).a();
    }

    public static void x(boolean z2) {
        e().c().a(an, z2).b();
    }

    public static int y() {
        return c().b(q, 0);
    }

    public static void y(int i2) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a("SPLASH_LOCAL_ID" + UserInfo.getInstance().getLoginUserInfo().uid, i2).b();
    }

    public static void y(long j2) {
        a().c().a(bU, j2).b();
    }

    @Deprecated
    public static void y(String str) {
        e().c().a(X, str).a();
    }

    public static void y(boolean z2) {
        e().c().a(cf, z2).b();
    }

    public static int z() {
        return c().b(r, 0);
    }

    public static String z(int i2) {
        BluedSharedPreferences a2 = a();
        return a2.a("VIRTUAL_IMAGE_CAT_TAB_RED_DOT_" + i2, "");
    }

    public static String z(String str) {
        BluedSharedPreferences e2 = e();
        return e2.a(X + str, "");
    }

    public static void z(long j2) {
        a().c().a(bY, j2).b();
    }

    public static void z(boolean z2) {
        e().c().a(cg, z2).b();
    }
}
