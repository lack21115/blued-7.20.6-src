package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.os.BatteryManager;
import android.provider.BrowserContract;
import android.provider.Contacts;
import android.service.notification.Condition;
import android.text.TextUtils;
import android.text.style.SuggestionSpan;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.internal.inputmethod.InputMethodUtils;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.FirstChargeGift;
import com.blued.android.module.live_china.model.LiveAnnounceInfoModel;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveDesireCreateDesireModel;
import com.blued.android.module.live_china.model.LiveFirstChargeInfo;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlJsonModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.blued.android.module.live_china.model.LiveGroupPkUserModel;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveSettingModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.model.ReChargeGift;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.cdo.oaps.ad.Launcher;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveRoomHttpUtils.class */
public class LiveRoomHttpUtils {

    /* renamed from: com.blued.android.module.live_china.utils.LiveRoomHttpUtils$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveRoomHttpUtils$3.class */
    class AnonymousClass3 extends BluedUIHttpResponse<BluedEntityA<LiveFirstChargeInfo>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityFragmentActive f14188a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<LiveFirstChargeInfo> bluedEntityA) {
            if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                return;
            }
            LiveRoomPreferences.e(bluedEntityA.getSingleData().count);
            if (bluedEntityA.getSingleData().pop == 2) {
                LiveRoomHttpUtils.q(new BluedUIHttpResponse<BluedEntityA<ReChargeGift>>(this.f14188a) { // from class: com.blued.android.module.live_china.utils.LiveRoomHttpUtils.3.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<ReChargeGift> bluedEntityA2) {
                        if (bluedEntityA2 == null || bluedEntityA2.getSingleData() == null) {
                            return;
                        }
                        LiveRoomManager.a().a(bluedEntityA2.getSingleData(), true);
                    }
                }, this.f14188a);
            }
        }
    }

    public static void A(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/goods/all/wish/list", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void A(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().m() + "/live/planet-expedition", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void B(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/goods/all/wish/setting", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void B(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/live/planet-expedition/user-rank", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void C(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/wish-list/reset", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void C(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/live/planet-expedition/anchor-rank", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void D(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/privilege", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void D(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/live/goods-random/anchor-status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void E(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", LiveRoomManager.a().g());
        HttpManager.a(LiveRoomInfo.a().k() + "/live/content/notice/task/all", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void E(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("anchor", LiveRoomManager.a().g());
        HttpManager.a(LiveRoomInfo.a().m() + "/live/goods-wall/v2/home", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void F(BluedUIHttpResponse bluedUIHttpResponse) {
        y(bluedUIHttpResponse, (String) null);
    }

    public static void F(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("anchor", LiveRoomManager.a().g());
        HttpManager.a(LiveRoomInfo.a().m() + "/live/goods-wall/v2/stamp", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void G(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/privilege", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void G(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("anchor", LiveRoomManager.a().g());
        HttpManager.a(LiveRoomInfo.a().m() + "/live/goods-wall/v2/tasks", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void H(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/personal/collection", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void H(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("anchor", LiveRoomManager.a().g());
        HttpManager.a(LiveRoomInfo.a().m() + "/live/goods-wall/v2/stamp-rewards", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void I(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/onairlist/bubble", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void I(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/live/user-vip/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void J(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/live/user-vip/close-popup", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(new ArrayMap())).h();
    }

    public static void K(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/live/goods-blind-box/all", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void L(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/rank/guild", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void a() {
        HttpManager.b(LiveRoomInfo.a().m() + "/goods/hongbao/cancel").b(BluedHttpTools.a(true)).h();
    }

    public static void a(int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", String.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/challenge/update").b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(int i, int i2, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("task_id", String.valueOf(i));
        arrayMap.put("lantern_id", String.valueOf(i2));
        HttpManager.a(BluedHttpUrl.q() + "/live/lantern", null, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void a(int i, int i2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", LiveRoomManager.a().e());
        a2.put(WBPageConstants.ParamKey.PAGE, String.valueOf(i));
        a2.put("page_size", String.valueOf(i2));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/recommend", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(int i, int i2, String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("rank_type", String.valueOf(i));
        a2.put("hour_type", String.valueOf(i2));
        a2.put("anchor", String.valueOf(str));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/stars/hour-v2", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(int i, StringHttpResponseHandler stringHttpResponseHandler) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/pk/upgrade", stringHttpResponseHandler).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void a(int i, BluedUIHttpResponse bluedUIHttpResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("source_type", Integer.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/pop-up-tips/pop", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void a(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", String.valueOf(i));
        a2.put("anchor", LiveRoomManager.a().g());
        HttpManager.a(BluedHttpUrl.q() + "/live/room/config/collection", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(int i, String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("lid", str);
        a2.put("type", str2);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/apply/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(int i, List<LiveGroupPkUserModel> list, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str = BluedHttpUrl.q() + "/live/group-pk/operate";
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", String.valueOf(i));
        if (list != null && !list.isEmpty()) {
            arrayMap.put("group", list);
        }
        HttpManager.b(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void a(long j, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", j + "");
        HttpManager.b(LiveRoomInfo.a().k() + "/live/task/new-anchor/use-card", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(long j, String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", j + "");
        a2.put("task_id", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/task/new-anchor/take-reward", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, long j, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().m() + "/activity/buildbox/open?box_id=" + str + "&live_id=" + j, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, Long l, Short sh, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("session_id", String.valueOf(l));
        a2.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, String.valueOf(sh));
        if (!TextUtils.isEmpty(str2)) {
            a2.put("name", str2);
            str = "0";
        }
        HttpManager.b(LiveRoomInfo.a().k() + "/users/" + str + Launcher.Path.CARD, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(Context context, String str, long j, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/stars/" + str + "/consumes/" + j + "?page=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, String str, long j, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/stars/" + str + "/consumes?page=" + i + "&lid=" + j + "&type=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/privilege", new BluedUIHttpResponse<BluedEntityA<LiveSettingModel>>(activityFragmentActive) { // from class: com.blued.android.module.live_china.utils.LiveRoomHttpUtils.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveSettingModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                LiveRoomManager.a().d(bluedEntityA.data);
            }
        }, activityFragmentActive).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/daily-task", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(LiveRoomInfo.a().k());
        sb.append(i == 1 ? "/live/stars/hot" : "/live/stars/rise");
        HttpManager.a(sb.toString(), bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, "" + i);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/user-album-pic/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("lid", str);
        a2.put("activity_id", str2);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/active/rank/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, long j) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/multi/applicants?lid=" + j, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, long j, String str, int i, int i2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", String.valueOf(j));
        a2.put("type", String.valueOf(i));
        a2.put("source", str);
        a2.put("recommended_prop", String.valueOf(i2));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/join", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/goods-mall/setting/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, int i, int i2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("index", String.valueOf(i));
        a2.put("size", String.valueOf(20));
        a2.put("is_sync", String.valueOf(0));
        a2.put("type", String.valueOf(i2));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/v2/" + str + "/members", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/" + str + "/members?lid=" + str + "&type=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, boolean z, String str2, int i, int i2, boolean z2) {
        String str3 = LiveRoomInfo.a().k() + "/live/start";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("show_in_nearby", z ? "1" : "0");
        a2.put("description", str2);
        a2.put("is_matchmaking", z2 ? "1" : "0");
        a2.put("live_type", String.valueOf(i));
        a2.put("screen_pattern", String.valueOf(i2));
        a2.put("zego_stream", "1");
        HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, LiveAnnounceInfoModel liveAnnounceInfoModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("controller", Integer.valueOf(liveAnnounceInfoModel.controller));
        hashMap.put("notice_controller", Integer.valueOf(liveAnnounceInfoModel.notice_controller));
        hashMap.put("notice", liveAnnounceInfoModel.notice);
        hashMap.put("live_time_controller", Integer.valueOf(liveAnnounceInfoModel.live_time_controller));
        hashMap.put("live_week_time", liveAnnounceInfoModel.live_week_time);
        hashMap.put("live_time", Long.valueOf(liveAnnounceInfoModel.live_time));
        hashMap.put("fans_group_controller", Integer.valueOf(liveAnnounceInfoModel.fans_group_controller));
        hashMap.put("fans_group_id", liveAnnounceInfoModel.fans_group_id);
        hashMap.put("fans_group_remind_time", Integer.valueOf(liveAnnounceInfoModel.fans_group_remind_time));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/notice", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, LiveMsgReportModel liveMsgReportModel) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("reason", "0");
        a2.put("contents", liveMsgReportModel.reportContent);
        a2.put("comment", liveMsgReportModel.reportMsg);
        a2.put("publish_date", liveMsgReportModel.time);
        a2.put("report_uid", liveMsgReportModel.uid);
        HttpManager.b(LiveRoomInfo.a().k() + "/blued/newreport/live_comment/" + liveMsgReportModel.lid, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, LiveRewardConfigModel liveRewardConfigModel, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, IRequestHost iRequestHost) {
        String str6 = LiveRoomInfo.a().m() + "/buy/goods/hongbao";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, String.valueOf(liveRewardConfigModel.beans));
        a2.put("count", String.valueOf(liveRewardConfigModel.count));
        a2.put("size", liveRewardConfigModel.size);
        a2.put(Condition.SCHEME, liveRewardConfigModel.condition);
        a2.put("uid", str2);
        a2.put("live_id", str);
        a2.put("platform", "android");
        a2.put("id", String.valueOf(liveRewardConfigModel.hb_beans_id));
        a2.put("pay_code", str3);
        a2.put("pay_token", str4);
        a2.put("remember_me", z ? "1" : "0");
        a2.put("is_mall_packet", z2 ? "1" : "0");
        if (!TextUtils.isEmpty(str5)) {
            a2.put("pwd", str5);
        }
        a2.put("prize_total", liveRewardConfigModel.prize_total + "");
        HttpManager.b(str6, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/room/close", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, float f, float f2, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("proportion_x", f + "");
        a2.put("proportion_y", f2 + "");
        a2.put("image", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/sticker", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put(InputMethodUtils.SUBTYPE_MODE_VOICE, i + "");
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/status", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, long j, long j2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("goods_id", str);
        a2.put(SuggestionSpan.SUGGESTION_SPAN_PICKED_BEFORE, String.valueOf(j));
        a2.put(SuggestionSpan.SUGGESTION_SPAN_PICKED_AFTER, String.valueOf(j2));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/goods-skins/user/wear/change", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, String.valueOf(str));
        a2.put("page_size", String.valueOf(30));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/footprint", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost, int i, String str2, String str3, int i2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("apply", "1");
        a2.put("is_hand_write", i + "");
        a2.put("is_easy_way", i2 + "");
        a2.put("card_name", str2);
        a2.put("card_number", str3);
        HttpManager.b(LiveRoomInfo.a().k() + "/users/" + str + "/applied", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chicken/sync", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("task_id", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/daily-task", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().m() + "/activity/buildbox/conf?target_uid=" + str + "&box_id=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4) {
        String str5 = LiveRoomInfo.a().m() + "/goods/hongbao/open";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("hongbao_id", str);
        a2.put("live_id", str2);
        a2.put("rid", str3);
        if (!TextUtils.isEmpty(str4)) {
            a2.put("pwd", str4);
        }
        HttpManager.b(str5, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(LiveGiftScrawlTransModel liveGiftScrawlTransModel, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str = LiveRoomInfo.a().m() + "/buy/goods/draw";
        LiveGiftScrawlJsonModel liveGiftScrawlJsonModel = new LiveGiftScrawlJsonModel();
        liveGiftScrawlJsonModel.data = liveGiftScrawlTransModel;
        String json = AppInfo.f().toJson(liveGiftScrawlJsonModel);
        if (HttpManager.c()) {
            Log.v("HttpManager", "params string:" + json);
        }
        HttpManager.b(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(json).h();
    }

    public static void a(MuteLiveAudioModel muteLiveAudioModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("source_lid", muteLiveAudioModel.source_lid);
        hashMap.put("source_uid", muteLiveAudioModel.source_uid);
        hashMap.put("target_lid", muteLiveAudioModel.target_lid);
        hashMap.put("target_uid", muteLiveAudioModel.target_uid);
        hashMap.put("target_status", Integer.valueOf(muteLiveAudioModel.target_status));
        a(hashMap);
    }

    public static void a(Integer num, Integer num2, Integer num3, String str, BluedUIHttpResponse bluedUIHttpResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", num);
        hashMap.put("anchor", LiveRoomManager.a().g());
        hashMap.put("type", num2);
        hashMap.put("sub_type", num3);
        hashMap.put("content", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/content/notice/task/verify", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void a(String str) {
        HttpManager.a(LiveRoomInfo.a().k() + "/lives/" + str + "/share", null).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("action", String.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/kiss").b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("sheet_id", str);
        a2.put("is_personal", i + "");
        a2.put(WBPageConstants.ParamKey.PAGE, i2 + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/music/song/list", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, int i, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("goods_id", str);
        a2.put("equip_status", i + "");
        HttpManager.b(LiveRoomInfo.a().m() + "/goods/equip", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("planet_ids", str);
        arrayMap.put("bet_num", Integer.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().m() + "/live/planet-expedition/bet", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void a(String str, int i, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str3 = LiveRoomInfo.a().k() + "/groups/members?http_method_override=PUT";
        Map<String, String> a2 = BluedHttpTools.a();
        if (str2 != null) {
            a2.put("reason", str2);
        }
        a2.put("allow_join", String.valueOf(i));
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        a2.put("without_boost", "1");
        HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, int i, String str2, String str3, boolean z, String str4, int i2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String g = LiveRoomManager.a().g();
        String e = LiveRoomManager.a().e();
        LiveGiftModel liveGiftModel = new LiveGiftModel();
        liveGiftModel.goods_id = str;
        a(g, e, liveGiftModel, "", str2, str3, z, i, false, null, str4, i2, bluedUIHttpResponse, iRequestHost);
    }

    public static void a(String str, int i, boolean z, String str2, String str3, boolean z2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String g = LiveRoomManager.a().g();
        String e = LiveRoomManager.a().e();
        LiveGiftModel liveGiftModel = new LiveGiftModel();
        liveGiftModel.goods_id = str;
        liveGiftModel.is_help_wish_list = z;
        a(g, e, liveGiftModel, "", str2, str3, z2, i, z, null, null, 0, bluedUIHttpResponse, iRequestHost);
    }

    public static void a(String str, long j, String str2, String str3, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        try {
            String str4 = LiveRoomInfo.a().m() + "/buy/liang/renew";
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("liang_id", str);
            a2.put("pay_code", str2);
            if (TextUtils.isEmpty(str2)) {
                a2.put("pay_token", str3);
            }
            a2.put("remember_me", z ? "1" : "0");
            a2.put("expire_time", String.valueOf(j));
            HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure(null);
        }
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/multi-pk/exit", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/share-copywriting", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, String str2) {
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.b(LiveProtos.Event.LIVE_LEAVE_SUCCESS, LiveRoomManager.a().e(), LiveRoomManager.a().g(), LiveRoomManager.a().p().liveFrom, LiveRoomManager.a().p().recommendType, LiveRoomManager.a().p().livePosition);
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("type", "1");
        a2.put("source", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/leave").b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str3 = BluedHttpUrl.r() + "/live/goods-set";
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("goods_set_id", str);
        if (!TextUtils.isEmpty(str2)) {
            arrayMap.put("goods_id", str2);
        }
        arrayMap.put("from", Integer.valueOf(i));
        arrayMap.put("anchor", LiveRoomManager.a().g());
        HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void a(String str, String str2, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("anchor", String.valueOf(str));
        arrayMap.put("tips_id", String.valueOf(str2));
        HttpManager.b(BluedHttpUrl.q() + "/live/room_tips/sign", null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("type", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/kick-out", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("uid", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/chatroom/operate/kick-out", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, String str2, LiveGiftModel liveGiftModel, String str3, String str4, String str5, boolean z, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        a(str, str2, liveGiftModel, str3, str4, str5, z, i, false, null, null, 0, bluedUIHttpResponse, iRequestHost);
    }

    public static void a(String str, String str2, LiveGiftModel liveGiftModel, String str3, String str4, String str5, boolean z, int i, String str6, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        a(str, str2, liveGiftModel, str3, str4, str5, z, i, false, str6, null, 0, bluedUIHttpResponse, iRequestHost);
    }

    public static void a(String str, String str2, LiveGiftModel liveGiftModel, String str3, String str4, String str5, boolean z, int i, boolean z2, String str6, String str7, int i2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HashMap hashMap = new HashMap();
        try {
            String str8 = LiveRoomInfo.a().m() + "/buy/goods";
            if (liveGiftModel.ops == 13) {
                str8 = LiveRoomInfo.a().m() + "/buy/goods/luck-bag";
            }
            String str9 = str8;
            if (liveGiftModel.ops == 19) {
                str9 = str8;
                if (liveGiftModel.gameplay_type == 1) {
                    str9 = LiveRoomInfo.a().m() + "/live/goods-blind-box/buy";
                    hashMap.put("gameplay_type", 1);
                }
            }
            hashMap.put("target_uid", str);
            hashMap.put("live_id", str2);
            hashMap.put("goods_id", liveGiftModel.goods_id);
            hashMap.put("discount_id", str3);
            hashMap.put("pay_code", str4);
            hashMap.put("pay_token", str5);
            hashMap.put("remember_me", z ? "1" : "0");
            hashMap.put("count", i + "");
            hashMap.put("is_help_wish_list", Boolean.valueOf(z2));
            hashMap.put("contents", liveGiftModel.contents);
            hashMap.put("hit_id", liveGiftModel.hit_id + "");
            hashMap.put("custom_rank_title", str6);
            hashMap.put("from", LiveRoomManager.a().p().comeCode);
            if (liveGiftModel.effectModel != null) {
                hashMap.put("effect_id", liveGiftModel.effectModel.effect_id + "");
                hashMap.put("effect_expire", liveGiftModel.effectModel.expire + "");
                hashMap.put("effect_beans", liveGiftModel.effectModel.beans + "");
            }
            if (!TextUtils.isEmpty(str7)) {
                hashMap.put("planet_ids", str7);
                hashMap.put("bet_num", i2 + "");
            }
            HttpManager.b(str9, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure(null);
        }
    }

    public static void a(String str, String str2, String str3, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("target_uid", str);
        arrayMap.put("anchor_uid", str2);
        arrayMap.put("lid", str3);
        arrayMap.put("type", Integer.valueOf(i));
        HttpManager.b(BluedHttpUrl.q() + "/live/user/privilege/behalf/bind_change", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void a(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("uid", str2);
        a2.put("type", str3);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/chatroom/operate/mute", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("pocket_goods_id", str);
        hashMap.put("type", str2);
        hashMap.put(TypedValues.AttributesType.S_TARGET, str4);
        hashMap.put("lid", str3);
        HttpManager.b(LiveRoomInfo.a().m() + "/stock/user-pocket/use", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void a(String str, String str2, String str3, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        try {
            String str4 = LiveRoomInfo.a().m() + "/buy/liang";
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("liang_id", str);
            a2.put("pay_code", str2);
            if (TextUtils.isEmpty(str2)) {
                a2.put("pay_token", str3);
            }
            a2.put("remember_me", z ? "1" : "0");
            HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure(null);
        }
    }

    public static void a(String str, String str2, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str3 = LiveRoomInfo.a().k() + "/live/user/decoration-hold/change-wear";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("change_type", z ? "wear" : "take_off");
        a2.put("decoration_id", str);
        a2.put("decoration_type", str2);
        HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str2 = LiveRoomInfo.a().k() + "/live/avatar-frame-user/change/wear";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("avatar_frame_id", str);
        a2.put("type", z ? "edit" : "remove");
        HttpManager.b(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, boolean z, String str2, BluedUIHttpResponse bluedUIHttpResponse) {
        String str3 = LiveRoomInfo.a().k() + "/live/room/config/tools";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("type", z ? "1" : "0");
        a2.put("anchor", str2);
        HttpManager.a(str3, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(List<LiveDesireCreateDesireModel> list, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HashMap hashMap = new HashMap();
        hashMap.put("wish_list", list);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/wish-list/create", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void a(Map<String, Object> map) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/whole/pk/voice/operated").b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).h();
    }

    public static void a(boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str = BluedHttpUrl.q() + "/live/battle-pass/pre-unlock";
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", z ? "1" : "2");
        HttpManager.a(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void b() {
        HttpManager.b(LiveRoomInfo.a().m() + "/coupons/popup", null).b(BluedHttpTools.a(true)).h();
    }

    public static void b(int i) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("goods_id", Integer.valueOf(i));
        HttpManager.b(BluedHttpUrl.r() + "/live/goods-blind-box/clear-red-point", null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void b(int i, int i2, BluedUIHttpResponse bluedUIHttpResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("privilege_type", String.valueOf(i));
        hashMap.put("privilege_status", String.valueOf(i2));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/privilege", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void b(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/anchor-fans/fans-list/active", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chat-badge/user/wear", new BluedUIHttpResponse<BluedEntityA<LiveChatBadgeModel>>(activityFragmentActive) { // from class: com.blued.android.module.live_china.utils.LiveRoomHttpUtils.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveChatBadgeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveRoomInfo.a().a(bluedEntityA.getSingleData());
            }
        }, activityFragmentActive).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/home", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("cursor", i + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/pk/friends", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, "" + i);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/user-feed-pic/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, long j) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", j + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/sync/chat", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, long j, String str, int i, int i2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", String.valueOf(j));
        a2.put("type", String.valueOf(i));
        a2.put("source", str);
        a2.put("recommended_prop", String.valueOf(i2));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/join/extra", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/stars/hour/config", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("target_uid", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/chatroom/admin/add", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(BrowserContract.Bookmarks.POSITION, String.valueOf(str));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/red-dot/cancel", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("is_video_verified", "1");
        a2.put("from", LiveDataManager.a().g() + "");
        HttpManager.b(LiveRoomInfo.a().k() + "/users/" + str + "/applied?http_method_override=PUT", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("live_id", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/link_type", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        String str3 = LiveRoomInfo.a().k() + "/live/interaction/multi/fan/exit";
        Map<String, String> a2 = BluedHttpTools.a();
        if (TextUtils.isEmpty(str)) {
            a2.put("uid", str2);
        } else {
            a2.put("lid", str);
        }
        HttpManager.b(str3, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        if (!TextUtils.isEmpty(str2)) {
            a2.put("name", str2);
            str = "0";
        }
        HttpManager.b(LiveRoomInfo.a().k() + "/users/" + str + Launcher.Path.CARD, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("hongbao_id", str);
        a2.put("live_id", str2);
        a2.put(WBPageConstants.ParamKey.PAGE, str3);
        a2.put("last_record_id", str4);
        HttpManager.b(LiveRoomInfo.a().m() + "/goods/hongbao/record", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/footprint", null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(String str, int i, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("keyword", str);
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/music/search", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("goods_id", str);
        a2.put("type", String.valueOf(i));
        HttpManager.a(BluedHttpUrl.r() + "/live/goods-banner", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/multi-pk/barrage", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        try {
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("contents", str);
            HttpManager.b(LiveRoomInfo.a().k() + "/blued/live/feedback", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure(null);
        }
    }

    public static void b(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("pic", str);
        a2.put("lid", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/user-pic/use", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", str);
        a2.put("lid", str2);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/anchor-fans/relation/detail", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(String str, String str2, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str3 = LiveRoomInfo.a().k() + "/live/battle-pass";
        Map<String, String> a2 = BluedHttpTools.a();
        if (!z) {
            a2.put("type", str);
            a2.put(BatteryManager.EXTRA_LEVEL, str2);
        }
        a2.put("lid", LiveRoomManager.a().e());
        HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(String str, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str2 = LiveRoomInfo.a().k() + "/live/chat-badge/user/wear/change";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("chat_badge_id", str);
        a2.put("type", z ? "edit" : "remove");
        HttpManager.b(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(List<LiveGroupPkUserModel> list, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str = BluedHttpUrl.q() + "/live/group-pk/start";
        ArrayMap arrayMap = new ArrayMap();
        if (list != null && !list.isEmpty()) {
            arrayMap.put("group", list);
        }
        HttpManager.b(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void c() {
        HttpManager.b(LiveRoomInfo.a().m() + "/coupons/red-notice", null).b(BluedHttpTools.a(true)).h();
    }

    public static void c(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/anchor-fans/fans-list/join-today", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/pk/invitation/cancel", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("disabled", i + "");
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/pk/status", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/challenge/match", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("target_uid", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/chatroom/admin/remove", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/stars/battle/" + str + "/consumes", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("type", String.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/ligature/invitation", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("reason", "0");
        a2.put("contents", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/onair/" + str + "/report", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/cates-v2/" + str + "?page=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", str);
        a2.put("type", String.valueOf(i));
        HttpManager.a(LiveRoomInfo.a().m() + "/live/constellation/top-confirm-info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/user/exit", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("fragment_id", str);
        HttpManager.b(LiveRoomInfo.a().m() + "/live/fragment/exchange", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("pocket_goods_id", str);
        hashMap.put("type", str2);
        HttpManager.b(LiveRoomInfo.a().m() + "/stock/anchor-pocket/use", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void c(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", str);
        a2.put("lid", str2);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/anchor-fans/item", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(String str, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str2 = LiveRoomInfo.a().k() + "/live/chat-frame-user/change/wear";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("chat_frame_id", str);
        a2.put("type", z ? "edit" : "remove");
        HttpManager.b(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d() {
        HttpManager.a(LiveRoomInfo.a().m() + "/sums/android", new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(null) { // from class: com.blued.android.module.live_china.utils.LiveRoomHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveRoomInfo.a().a(bluedEntityA.getSingleData().beans);
                LiveDataManager.a().a(bluedEntityA.getSingleData());
                LiveEventBus.get("gold_remain_result").post(bluedEntityA.getSingleData());
            }
        }, null).b(BluedHttpTools.a(true)).h();
    }

    public static void d(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/anchor-fans/fans-list/all", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", String.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/pk/interrupt", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/challenge/match/cancel", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/multi-pk/rank", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("type", String.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/link/multi/invite", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/onair/" + str + "/share", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("chosen_uid", str);
        a2.put("chooser_uid", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/success", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        String str3 = BluedHttpUrl.q() + "/users/" + LiveRoomInfo.a().f() + "/followed/" + str;
        String str4 = str3;
        if (!TextUtils.isEmpty(str2)) {
            str4 = str3 + "?from=" + str2;
        }
        HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tag", String.valueOf(str));
        a2.put("type", String.valueOf(i));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/rank", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/user/lighting-off", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        d(str, false, bluedUIHttpResponse, iRequestHost);
    }

    public static void d(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("uid", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/apply/resolve", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(String str, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str2 = LiveRoomInfo.a().k() + "/users/" + str + "/medal";
        String str3 = str2;
        if (z) {
            str3 = str2 + "?is_live=1";
        }
        HttpManager.a(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e() {
        p(new BluedUIHttpResponse<BluedEntityA<FirstChargeGift>>(null) { // from class: com.blued.android.module.live_china.utils.LiveRoomHttpUtils.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FirstChargeGift> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveRoomManager.a().a(bluedEntityA.getSingleData());
            }
        }, (IRequestHost) null);
    }

    public static void e(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("from", "" + i);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/two-floor", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/exit", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("cursor", i + "");
        HttpManager.a(LiveRoomInfo.a().k() + "/live/interaction/ligature/friends", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().m() + "/goods/user/skins", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/pk/invitation", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("type", String.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/link/multi/accept", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/users/" + str + "/applied", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("mvp", str);
        hashMap.put("anchor", str2);
        hashMap.put("lid", LiveRoomManager.a().e());
        HttpManager.b(LiveRoomInfo.a().k() + "/live/pk/machines/game/play/lottery/machines", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        String str3 = BluedHttpUrl.q() + "/users/" + LiveRoomInfo.a().f() + "/followed/" + str + "?http_method_override=DELETE";
        String str4 = str3;
        if (!TextUtils.isEmpty(str2)) {
            str4 = str3 + "&from=" + str2;
        }
        HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void e(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("sticker_id", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/level/sticker", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void e(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("name", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/anchor-fans", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void e(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("uid", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/apply/reject", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void f() {
        HttpManager.b(LiveRoomInfo.a().m() + "/live/planet-expedition/leave", null).b(BluedHttpTools.a(true)).h();
    }

    public static void f(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(BatteryManager.EXTRA_LEVEL, String.valueOf(i));
        HttpManager.a(BluedHttpUrl.q() + "/live/battle-pass/bonus", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/goods", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("disabled", i + "");
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/ligature/status", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/admin/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/pk/invitation/ignore", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", LiveRoomManager.a().g());
        a2.put("uid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/user/card", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void f(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/kiss", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void f(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", str);
        HttpManager.b(LiveRoomInfo.a().m() + "/goods/anchor-fans/free-goods", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void f(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        a2.put("type", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/apply", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static String g() {
        return BluedHttpUrl.q() + "/blued/qiniu?filter=token&action=zip";
    }

    public static void g(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", Integer.valueOf(i));
        HttpManager.b(BluedHttpUrl.q() + "/live/user/privilege/behalf/switch_change", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/stock/user-pack", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/access", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/pk/invitation/confirm", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/banner?topic=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", LiveRoomManager.a().e());
        a2.put("goods_id", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/wish-list/verify/status", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void g(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HashMap hashMap = new HashMap();
        hashMap.put(Contacts.GroupMembership.GROUP_ID, Integer.valueOf(str));
        HttpManager.b(LiveRoomInfo.a().k() + "/live/fans/group/upgrade", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void g(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", String.valueOf(str));
        a2.put("contents", String.valueOf(str2));
        HttpManager.b(LiveRoomInfo.a().k() + "/blued/newreport/live-shout-card/report", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static String h() {
        return BluedHttpUrl.q() + "/blued/zip";
    }

    public static void h(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("planet_id", Integer.valueOf(i));
        HttpManager.b(LiveRoomInfo.a().m() + "/live/planet-expedition/cancel", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void h(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/coupons/has-new", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void h(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/anchor-fans/join-ticket", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void h(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/apply", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void h(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("text", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/verify/text/author", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void h(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", "0");
        a2.put("task_id", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/task/new-anchor/take-reward", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void h(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", LiveRoomManager.a().g());
        a2.put("season", str);
        a2.put("constellation_id", str2);
        HttpManager.a(BluedHttpUrl.r() + "/live/constellation/spokesman", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static String i() {
        return BluedHttpUrl.q() + "/live/setting";
    }

    public static void i(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(WBPageConstants.ParamKey.PAGE, String.valueOf(i));
        HttpManager.a(BluedHttpUrl.r() + "/live/planet-expedition/bet-record", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void i(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/coupons/existence", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void i(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/daily-task/login-status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void i(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/apply/cancel", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void i(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("privilege_type", "2");
        a2.put("privilege_status", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/privilege", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void i(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/task/new-anchor/task-list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void j(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("goods_id", Integer.valueOf(i));
        arrayMap.put("lid", Long.valueOf(LiveRoomManager.a().d()));
        HttpManager.b(BluedHttpUrl.r() + "/live/goods-random/rewards", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void j(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/stock/barrage", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void j(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/fans/group/get/anchor", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void j(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/apply/ignore", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void j(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("skill_card_id", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/user-pocket-skill-card", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    public static void j(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/wish-list/delete", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void k(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("goods_id", String.valueOf(i));
        HttpManager.a(LiveRoomInfo.a().m() + "/live/goods-wall/judge", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void k(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/resource", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void k(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/fans/group/create", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void k(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/invitation", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void k(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/user-badge", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void l(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().m() + "/hongbao/config/android", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void l(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor_uid", LiveRoomManager.a().g());
        HttpManager.a(LiveRoomInfo.a().k() + "/live/fans/group/get/user/by_anchor", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void l(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/invitation/confirm", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void l(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str);
        HttpManager.a(LiveRoomInfo.a().m() + "/stock/anchor-pocket/history", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void m(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/whole/pk/match", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void m(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor_uid", LiveRoomManager.a().g());
        HttpManager.a(LiveRoomInfo.a().k() + "/live/fans/group/apply/verify", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void m(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/multi/invitation/ignore", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void m(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", String.valueOf(str));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/stars/hour/history-v2", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void n(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/whole/pk/match/cancel", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void n(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/task/new-anchor/is-token", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void n(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("title", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/chatroom", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void n(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", String.valueOf(str));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/has/target-noble", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void o(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/ligature/invitation/cancel", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void o(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/task/new-anchor/queue-count", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void o(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/ligature/invitation/ignore", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void o(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", str);
        a2.put("lid", LiveRoomManager.a().e());
        HttpManager.b(LiveRoomInfo.a().k() + "/live/battle-pass/unlock", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void p(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/ligature/interrupt", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void p(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/charge/first/config", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void p(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/ligature/invitation/confirm", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void p(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", str);
        a2.put("lid", LiveRoomManager.a().e());
        HttpManager.b(LiveRoomInfo.a().k() + "/live/battle-pass/claim-exp", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void q(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/link/multi/stop", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void q(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/charge/recharge/config", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void q(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/sticker/delete", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void q(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("goods_set_id", str);
        HttpManager.a(BluedHttpUrl.r() + "/live/goods-set", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void r(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/multi-pk/start", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void r(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/charge/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void r(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(LiveRoomInfo.a().k() + "/users/" + str + "/rich", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void r(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("goods_id", str);
        arrayMap.put("lid", LiveRoomManager.a().e());
        HttpManager.a(BluedHttpUrl.r() + "/live/goods-random/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void s(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/multi-pk/end", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void s(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/cates", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void s(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/level/info", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void s(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("goods_id", str);
        arrayMap.put("lid", LiveRoomManager.a().e());
        HttpManager.a(BluedHttpUrl.r() + "/live/goods-random/rewards/history", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void t(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("field", "is_shelves,buy_state,remain,daily_total,daily_sold,background_pic,picture,url");
        HttpManager.a(LiveRoomInfo.a().k() + "/users/gift_bag", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void t(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        e(1, bluedUIHttpResponse, iRequestHost);
    }

    public static void t(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/level/sticker", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void t(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", str);
        HttpManager.a(LiveRoomInfo.a().m() + "/live/goods-wall/v2/hall", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void u(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/close/recommend", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void u(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/cates-v2", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void u(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/level/gesture", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void u(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("constellation_id", str);
        HttpManager.a(LiveRoomInfo.a().m() + "/live/constellation/reward-info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void v(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/callback/share", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void v(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().m() + "/stock/anchor-pocket", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void v(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/user/in", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void v(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", str);
        HttpManager.a(LiveRoomInfo.a().m() + "/live/constellation/honour", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void w(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/reset", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void w(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/last-join-time", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void w(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/apply/cancel", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void w(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str2 = BluedHttpUrl.r() + "/live/constellation/info";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", LiveRoomManager.a().g());
        if (!TextUtils.isEmpty(str)) {
            a2.put("constellation_id", str);
        }
        HttpManager.a(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void x(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/music/sheet/list", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void x(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/battle-pass", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void x(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/interaction/matchmaking/user/reject-in", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void y(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(LiveRoomInfo.a().k() + "/live/liang", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void y(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/battle-pass/buy", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void y(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        String str2 = LiveRoomInfo.a().k() + "/live/notice";
        Map<String, String> a2 = BluedHttpTools.a();
        if (!TextUtils.isEmpty(str)) {
            a2.put("anchor", str);
        }
        HttpManager.a(str2, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void z(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", LiveRoomManager.a().e());
        HttpManager.a(LiveRoomInfo.a().k() + "/live/wish-list", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void z(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lid", LiveRoomManager.a().e());
        HttpManager.b(LiveRoomInfo.a().k() + "/live/battle-pass/buy", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }
}
