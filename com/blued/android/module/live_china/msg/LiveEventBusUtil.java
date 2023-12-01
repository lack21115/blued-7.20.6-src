package com.blued.android.module.live_china.msg;

import android.util.Pair;
import android.view.View;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.model.DefinedRankInfo;
import com.blued.android.module.live_china.model.GiftConstellationBuyInfoModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveEntranceData;
import com.blued.android.module.live_china.model.LiveGiftConstellationModel;
import com.blued.android.module.live_china.model.LiveGiftSkinItemModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayResultEvent;
import com.blued.android.module.live_china.model.PlanetDataExtraModel;
import com.blued.android.module.live_china.model.RequestLiveRedNoticeModel;
import com.blued.android.module.live_china.observer.PushGuideObserver;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/LiveEventBusUtil.class */
public class LiveEventBusUtil {
    public static String A = "custom_rank_end";
    public static String B = "show_live_webview";
    public static String C = "live_room_function";
    public static String D = "live_group_pk_dot_gone";
    public static String E = "live_battle_buy_top_battle";
    public static String F = "live_battle_get_single";
    public static String G = "live_battle_get_all";
    public static String H = "live_battle_update_exp";
    public static String I = "live_battle_complete_task_get_exp";
    public static String J = "live_battle_dismiss";
    public static String K = "live_planet_show_Loading";
    public static String L = "live_planet_area_click";
    public static String M = "live_planet_area_reset";
    public static String N = "live_planet_start_lottery";
    public static String O = "live_planet_lottery_result";
    public static String P = "live_planet_update_data";
    public static String Q = "live_random_gift_update_remain_count";
    public static String R = "live_start_vip_dialog";
    public static String S = "live_goodswall_dismiss";
    public static String T = "live_lucky_bag_show_give_btn";
    public static String U = "live_lucky_bag_buy_good";
    public static String V = "live_buy_good";
    public static String W = "live_lucky_bag_dismiss_dialog";
    public static String X = "key_event_live_constellation_bar_update";
    public static String Y = "live_constellation_buy_failure";
    public static String Z = "live_constellation_summit_succeed";
    public static String a = "live_beans_update";
    public static String aa = "live_start_rank_dialog";
    public static String ab = "live_rank_loaded_dialog";
    public static String ac = "live_rank_current_position_dialog";
    public static String b = "live_new_msg";
    public static String c = "live_entrance_data";
    public static String d = "pay_result";
    public static String e = "start_first_charge_success_anim";
    public static String f = "live_msg_hot_word";
    public static String g = "hot_word_right_margin";
    public static String h = "request_live_red_notice";
    public static String i = "live_activity_show";
    public static String j = "show_recharge_gift_bag_icon";
    public static String k = "live_hidn_operation_child";
    public static String l = "live_update_treasure_box_index";
    public static String m = "live_screen_record_start";
    public static String n = "live_screen_record_stop";
    public static String o = "live_start_record_complete";
    public static String p = "force_request_live_count";
    public static String q = "live_announce";
    public static String r = "live_gift_avatar_qa";
    public static String s = "live_gift_bag_avatar_qa";
    public static String t = "live_charge_with_coupon";
    public static String u = "live_use_gift_skin";
    public static String v = "live_background_play_dialog";
    public static String w = "live_gift_count";
    public static String x = "show_live_gift_count_input";
    public static String y = "live_activity_pos";
    public static String z = "custom_rank_title";

    public static void a() {
        LiveEventBus.get(a).post((Object) null);
    }

    public static void a(int i2) {
        LiveEventBus.get(j).post(Integer.valueOf(i2));
    }

    public static void a(int i2, int i3) {
        Observable observable = LiveEventBus.get(r);
        observable.post(i2 + BridgeUtil.UNDERLINE_STR + i3);
    }

    public static void a(long j2, long j3) {
        LiveEventBus.get(Z).post(new Pair(Long.valueOf(j2), Long.valueOf(j3)));
    }

    public static void a(DefinedRankInfo definedRankInfo) {
        LiveEventBus.get(A).post(definedRankInfo);
    }

    public static void a(GiftConstellationBuyInfoModel giftConstellationBuyInfoModel) {
        LiveEventBus.get(V).post(giftConstellationBuyInfoModel);
    }

    public static void a(LiveChattingModel liveChattingModel) {
        a(liveChattingModel, true);
    }

    public static void a(LiveChattingModel liveChattingModel, boolean z2) {
        if (liveChattingModel != null) {
            LiveEventBus.get(b).post(liveChattingModel);
        }
    }

    public static void a(LiveEntranceData liveEntranceData) {
        if (liveEntranceData != null) {
            LiveEventBus.get(c).post(liveEntranceData);
        }
    }

    public static void a(LiveGiftConstellationModel liveGiftConstellationModel) {
        LiveEventBus.get(X).post(liveGiftConstellationModel);
    }

    public static void a(LiveGiftSkinItemModel liveGiftSkinItemModel) {
        LiveEventBus.get(u).post(liveGiftSkinItemModel);
    }

    public static void a(LiveRoomFunctionItemModel liveRoomFunctionItemModel) {
        LiveEventBus.get(C).postDelay(liveRoomFunctionItemModel, 200L);
    }

    public static void a(LiveZanExtraModel liveZanExtraModel) {
        boolean z2 = (liveZanExtraModel == null || liveZanExtraModel.emoji == null || liveZanExtraModel.emoji.size() <= 0) ? false : true;
        if (liveZanExtraModel != null && liveZanExtraModel.hot_words != null && liveZanExtraModel.hot_words.size() > 0) {
            z2 = true;
        }
        if (z2) {
            LiveEventBus.get(f).post(liveZanExtraModel);
        } else {
            PushGuideObserver.d().a((View) null);
        }
    }

    public static void a(PlanetDataExtraModel planetDataExtraModel) {
        LiveEventBus.get(O).post(planetDataExtraModel);
    }

    public static void a(RequestLiveRedNoticeModel requestLiveRedNoticeModel) {
        if (requestLiveRedNoticeModel == null) {
            return;
        }
        LiveEventBus.get(h).post(requestLiveRedNoticeModel);
    }

    public static void a(String str) {
        LiveEventBus.get(z).post(str);
    }

    public static void a(String str, LiveProtos.Status status) {
        LiveEventBus.get(ac).post(new Pair(str, status));
    }

    public static void a(String str, String str2) {
        LiveEventBus.get(ab).post(new Pair(str, str2));
    }

    public static void a(boolean z2) {
        LiveEventBus.get(e).post(Boolean.valueOf(z2));
    }

    public static void a(boolean z2, int i2, String str) {
        LogUtils.c("notifyPayResult: " + z2);
        if (z2) {
            LiveRoomPreferences.e(1);
        }
        PayResultEvent payResultEvent = new PayResultEvent();
        payResultEvent.money = i2;
        payResultEvent.from = str;
        payResultEvent.flag = z2;
        LiveEventBus.get(d).post(payResultEvent);
    }

    public static void a(boolean z2, boolean z3) {
        LiveEventBus.get(K).post(new Pair(Boolean.valueOf(z2), Boolean.valueOf(z3)));
    }

    public static void b() {
        LiveEventBus.get(p).post((Object) null);
    }

    public static void b(int i2) {
        LiveEventBus.get(g).post(Integer.valueOf(i2));
    }

    public static void b(int i2, int i3) {
        LiveEventBus.get(F).post(new Pair(Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    public static void b(String str) {
        LiveEventBus.get(B).post(str);
    }

    public static void b(boolean z2) {
        LiveEventBus.get(T).post(Boolean.valueOf(z2));
    }

    public static void c() {
        LiveEventBus.get(t).post(true);
    }

    public static void c(int i2) {
        if (i2 <= 0) {
            return;
        }
        LiveEventBus.get(w).post(Integer.valueOf(i2));
    }

    public static void c(int i2, int i3) {
        LiveEventBus.get(M).post(new Pair(Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    public static void d() {
        LiveEventBus.get(D).post(0);
    }

    public static void d(int i2) {
        LiveEventBus.get(H).post(Integer.valueOf(i2));
    }

    public static void e() {
        LiveEventBus.get(E).post(0);
    }

    public static void e(int i2) {
        LiveEventBus.get(I).post(Integer.valueOf(i2));
    }

    public static void f() {
        LiveEventBus.get(G).post(0);
    }

    public static void f(int i2) {
        LiveEventBus.get(Q).post(Integer.valueOf(i2));
    }

    public static void g() {
        LiveEventBus.get(J).post(0);
    }

    public static void g(int i2) {
        LiveEventBus.get(U).post(Integer.valueOf(i2));
    }

    public static void h() {
        LiveEventBus.get(L).post(0);
    }

    public static void h(int i2) {
        LiveEventBus.get(W).post(Integer.valueOf(i2));
    }

    public static void i() {
        LiveEventBus.get(N).post(10);
    }

    public static void j() {
        LiveEventBus.get(P).post(0);
    }

    public static void k() {
        LiveEventBus.get(R).post(0);
    }

    public static void l() {
        LiveEventBus.get(S).post(0);
    }

    public static void m() {
        LiveEventBus.get(aa).post(0);
    }
}
