package com.blued.android.module.yy_china.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.e;
import com.anythink.core.common.l;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPayRemaining;
import com.blued.android.module.yy_china.model.YYReportMsg;
import com.blued.android.module.yy_china.model.YYWishRequestModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYRoomHttpUtils.class */
public class YYRoomHttpUtils {
    public static void A(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/pk/close", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void B(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/wish/choose", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void C(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/wish/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void D(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/wish/rank_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void E(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/wish/reset", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void F(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/game/goods_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void G(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/teammate/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void H(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/punishment/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void I(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/pilfer/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void J(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/battle/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void K(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/game/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void L(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/game/prize", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void M(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/game/delete", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void N(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/auction_room/confirm/mic", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void O(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/auction_room/relation/detail", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void P(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/auction_room/judge/level", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void Q(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/auction_room/list/relation", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void R(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/single_room/all/turnover", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void S(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/single_room/list/gift", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void T(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/random/set", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void U(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/rob", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void V(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/goodsList", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void W(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("relation_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/getList", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void X(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("data_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/getTask", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void Y(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void Z(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/custom_activity/result", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a() {
        HttpManager.a(YYRoomInfoManager.e().c().f() + "/sums/android", new BluedUIHttpResponse<BluedEntityA<YYPayRemaining>>(null) { // from class: com.blued.android.module.yy_china.utils.YYRoomHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPayRemaining> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveDataManager.a().a(bluedEntityA.getSingleData());
                if (bluedEntityA.getSingleData().text != null) {
                    bluedEntityA.getSingleData().text.sums = "充值";
                    bluedEntityA.getSingleData().text.goods = "充值";
                }
                bluedEntityA.getSingleData().bonus = 0L;
                LiveEventBus.get("gold_remain_result").post(bluedEntityA.getSingleData());
            }
        }, null).b(BluedHttpTools.a(true)).h();
    }

    public static void a(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/square/lists", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a(int i, String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i + "");
        a.put("topic_id", str + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/topic/getHotLists", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/blued/qiniu?filter=token&action=photos", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/all/theme_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/daily/tasks", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("step_id", i + "");
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cproom/step", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/" + str + "/applied", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/user?uid=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/mics/stream_report", new BluedUIHttpResponse<BluedEntityA<Object>>(null) { // from class: com.blued.android.module.yy_china.utils.YYRoomHttpUtils.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void a(String str, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("status", i + "");
        a.put("mic_position", i2 + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/mics/lock", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        String str2 = YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/info/set";
        Map<String, String> a = BluedHttpTools.a();
        if (i > 0) {
            a.put("lasted", i + "");
        }
        if (i2 >= 0) {
            a.put("recommended", i2 + "");
        }
        HttpManager.b(str2, bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, int i, int i2, List<String> list, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("vote_type", i + "");
        b.put("ageing", i2 + "");
        b.put("uids", list);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/vote/create", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/new/room_list?label_id=" + str + "&page=" + i + "&page_size=30", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("page", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/wait/to/sing/lists", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a(String str, int i, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str4 = YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/single_room/set/gift";
        Map<String, String> a = BluedHttpTools.a();
        a.put("para", i + "");
        if (i == 1) {
            a.put(l.y, str2);
        }
        if (i == 2) {
            a.put("goods_id", str3);
        }
        HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/room_info/manager_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("keywords", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/search/user", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a(String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        a.put("mic_position", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/invite", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("image", str2 + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cover/update", null, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put(l.y, str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/report/music", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("keywords", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/nickname/search", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str12 = YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str4 + "/gift/send";
        Map<String, String> a = BluedHttpTools.a();
        a.put("is_master", str);
        a.put("hit_id", str2);
        a.put("goods_id", str3);
        a.put(SpamFilter.SpamContract.NotificationTable.COUNT, i + "");
        a.put("hit_batch", i2 + "");
        a.put("platform", MsgBackupManager.PLATFORM_ANDROID);
        a.put("room_id", str4);
        a.put("target_uid", str5);
        a.put(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, str6);
        a.put("pay_code", str7);
        a.put("pay_token", str8);
        a.put("rememberMe", z ? "1" : "0");
        a.put("goods_from", str9);
        a.put("redPacket_group_id", str10);
        a.put("extra_contents", str11);
        HttpManager.b(str12, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("uid", str2);
        a.put("target_uid", str3);
        a.put("is_callback", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/banter", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, int i, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("source_uid", str3);
        a.put("source_room_id", str2);
        a.put(com.alipay.sdk.util.l.c, i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/invitation/handle", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("apply", "1");
        a.put("card_name", str2);
        a.put("card_number", str3);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/" + str + "/applied/chatroom", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str3);
        a.put("target_room_id", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/invitation/send", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, String str4, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str5 = YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/auction_room/set/relation";
        Map<String, String> a = BluedHttpTools.a();
        if (!TextUtils.isEmpty(str3)) {
            a.put("relation_id", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            a.put("goods_id", str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            a.put("duration_id", str4);
        }
        a.put("para", i + "");
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_name", str2);
        a.put("room_desc", str3);
        a.put("type_id", str4);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/update", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        b(str, str2, str3, str4, "", bluedUIHttpResponse, activityFragmentActive);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("musicId", str2);
        a.put("musicName", str3);
        a.put("artst", str4);
        a.put("coverUrl", str5);
        a.put("duration", j + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/ktv/choose_song", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, String str4, String str5, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str6 = YYRoomInfoManager.e().c().e() + "/users/chatroom/room_info/set";
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str + "");
        if (!StringUtils.b(str2)) {
            a.put("label_id", str2 + "");
        }
        if (!StringUtils.b(str3)) {
            a.put("bg_id", str3 + "");
        }
        if (!StringUtils.b(str4)) {
            a.put("mic_bean", str4 + "");
        }
        if (!StringUtils.b(str5)) {
            a.put("is_fans_notice", str5 + "");
        }
        HttpManager.b(str6, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, String str4, String str5, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        b(str, str2, str3, str4, str5, bluedUIHttpResponse, activityFragmentActive);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("event_a_id", str2);
        b.put("event_b_id", str3);
        b.put("pk_gift_a_id", str4);
        b.put("pk_gift_b_id", str5);
        b.put("target_uid", str6);
        b.put("lasted", Integer.valueOf(i));
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/pk/create", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("room_id", Integer.valueOf(StringUtils.a(str, 0)));
        b.put("name", str2);
        b.put("type", Integer.valueOf(StringUtils.a(str3, 0)));
        b.put("description", str4);
        b.put("notice_type", Integer.valueOf(StringUtils.a(str5, 0)));
        b.put(e.a, Integer.valueOf(StringUtils.a(str6, 0)));
        b.put(e.b, Integer.valueOf(StringUtils.a(str7, 0)));
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/custom_activity/add", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(String str, String str2, String str3, String str4, List<String> list, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("uid", str3);
        a.put("reason", str4);
        a.put("anchor", str2);
        a.put("members", Arrays.toString(list.toArray(new String[list.size()])));
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/blued/newreport/chat-room/user", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, String str4, List<String> list, List<YYReportMsg> list2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str5 = YYRoomInfoManager.e().c().e() + "/blued/newreport/chat-room/msg";
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("anchor", str2);
        a.put("reason", str4);
        if (!TextUtils.isEmpty(str3)) {
            a.put("uid", str3);
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(a);
        hashMap.put("members", list);
        hashMap.put(c.b, list2);
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x004d, code lost:
        if ("null".equals(r5) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, int r9, com.blued.android.framework.http.BluedUIHttpResponse r10, com.blued.android.core.net.IRequestHost r11) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r1 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            com.blued.android.module.yy_china.IYYRoomInfoCallback r1 = r1.c()
            java.lang.String r1 = r1.e()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            java.lang.String r1 = "/users/chatroom/create"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            java.lang.String r0 = r0.toString()
            r13 = r0
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a()
            r14 = r0
            r0 = r14
            java.lang.String r1 = "type_id"
            r2 = r4
            java.lang.Object r0 = r0.put(r1, r2)
            java.lang.String r0 = "1"
            r12 = r0
            r0 = r5
            if (r0 == 0) goto L50
            r0 = r5
            r4 = r0
            java.lang.String r0 = "null"
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
        L50:
            java.lang.String r0 = "1"
            r4 = r0
        L54:
            r0 = r4
            r5 = r0
            r0 = r4
            int r0 = java.lang.Integer.parseInt(r0)
            if (r0 > 0) goto L61
            java.lang.String r0 = "1"
            r5 = r0
        L61:
            r0 = r14
            java.lang.String r1 = "label_id"
            r2 = r5
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r14
            java.lang.String r1 = "bg_id"
            r2 = r6
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r14
            java.lang.String r1 = "room_name"
            r2 = r7
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r8
            if (r0 == 0) goto L90
            r0 = r12
            r4 = r0
            goto L94
        L90:
            java.lang.String r0 = "0"
            r4 = r0
        L94:
            r0 = r14
            java.lang.String r1 = "is_fans_notice"
            r2 = r4
            java.lang.Object r0 = r0.put(r1, r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r14
            java.lang.String r1 = "is_veiled"
            r2 = r4
            java.lang.String r2 = r2.toString()
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r13
            r1 = r10
            r2 = r11
            com.blued.android.core.net.HttpRequestWrapper r0 = com.blued.android.core.net.HttpManager.b(r0, r1, r2)
            r1 = 1
            java.util.Map r1 = com.blued.android.framework.http.BluedHttpTools.a(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.b(r1)
            r1 = r14
            java.lang.String r1 = com.blued.android.framework.http.BluedHttpTools.a(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.a(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.utils.YYRoomHttpUtils.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.IRequestHost):void");
    }

    public static void a(String str, String str2, String str3, String str4, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str5 = YYRoomInfoManager.e().c().e() + "/users/chatroom/props/buy";
        Map<String, String> a = BluedHttpTools.a();
        a.put("prop_id", str);
        a.put("day", str2);
        a.put("pay_code", str3);
        a.put("pay_token", str4);
        a.put("rememberMe", z ? "1" : "0");
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, String str2, String str3, List<String> list, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("anchor", str2);
        a.put("reason", str3);
        a.put("members", Arrays.toString(list.toArray(new String[list.size()])));
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/blued/newreport/chat-room/room", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void a(String str, List<YYWishRequestModel> list, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("goods", list);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/wish/create", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void b(int i, String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i + "");
        a.put("theme_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/hall/room/lists", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/hall/room/theme/lists", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/daily/tasks/config", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/anchor", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/kickout", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i2 + "");
        a.put("page_size", "20");
        a.put("type", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/send_rank", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void b(String str, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        String str2 = YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/info";
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        if (i > 0) {
            a.put("pk_duration", i + "");
        }
        if (i2 >= 0) {
            a.put("is_open_recommend", i2 + "");
        }
        HttpManager.b(str2, bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str + "");
        a.put("type_id", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/recommend/room_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/relation/is_follow", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/recall/list", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void b(String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        a.put("status", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/mics/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("type", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/invalid_show", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("choosed_id", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/ktv/applause", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void b(String str, String str2, String str3, int i, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("source_uid", str3);
        a.put("source_room_id", str2);
        a.put(com.alipay.sdk.util.l.c, i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/invite/reply", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        a.put("status", str3);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/users/mute", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str3);
        a.put("target_room_id", str2);
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/invite/send", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uids", str2);
        a.put("room_id", str);
        a.put("goods_ids", str3 + "");
        a.put("parameters", str4 + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/gifts/batch/send", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void b(String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("PlaylistId", str);
        a.put("ScrollToken", str2);
        a.put("RoomId", str3);
        a.put("type", str4);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/ktv/musiclist", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void b(String str, String str2, String str3, String str4, String str5, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("relation_id", str2);
        a.put("target_uid", str);
        a.put("day", str3);
        a.put("goods_id", str4);
        a.put("room_id", str5);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/invite", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    private static void b(String str, String str2, String str3, String str4, String str5, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        String str6 = YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/ktv/sing_report";
        Map<String, String> a = BluedHttpTools.a();
        a.put(com.alipay.sdk.util.l.c, str2);
        if (TextUtils.equals("1", str2)) {
            a.put("dynamicLyricUrl", str3);
            a.put("staticLyricUrl", str4);
        }
        if (TextUtils.equals(ATAdConst.ATDevFrameworkType.ADOBIE_AIR, str2)) {
            a.put("score", str3);
            a.put("sentence", str4);
            a.put("total_score", str5);
        }
        HttpManager.b(str6, bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void c(int i, String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put(com.alipay.sdk.util.l.c, i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/apply/confirm", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/hall/card/config", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/cp/vip_goods", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/mine/history_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("target_uid", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cproom/choose", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void c(String str, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i2 + "");
        a.put("page_size", "20");
        a.put("type", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/receive_rank", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void c(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/members_all?page=" + i + "&page_size=20", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void c(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/room_info/setting", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void c(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/recall/recommend", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void c(String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        a.put(com.alipay.sdk.util.l.c, i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/apply/handle", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void c(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("source_from", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/into_room", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void c(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", str2);
        a.put("page_size", "20");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/record/list", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void c(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uids", str2);
        a.put("room_id", str);
        a.put("goods_ids", str3 + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/gifts/batch/send", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void c(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("hongbao_id", str2);
        a.put("room_id", str);
        a.put("is_need_follow", str3);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/redPacket/grab", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void c(String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str5 = YYRoomInfoManager.e().c().e() + "/users/chatroom/topic/setInfo";
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("theme_id", str2);
        a.put("topic", str3);
        if (!StringUtils.b(str4)) {
            a.put("topic_id", str4);
        }
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void d(int i, String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("relation_id", str);
        a.put("page", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/rankList", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/index/guide", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/activity/draw", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void d(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("mic_position", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/apply", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void d(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/toolkit", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void d(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/ktv/top_songs", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void d(String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("uid", str2);
        a.put("status", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/manager", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void d(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/mics/leave", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void d(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("page", str2);
        a.put("page_size", "20");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/history", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void d(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/vote/" + str2 + BridgeUtil.SPLIT_MARK + str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void d(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("KeyWord", str);
        a.put("ScrollToken", str2);
        a.put("type", str3);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/ktv/search", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/create/type_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/redPacket/groups", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void e(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/apply?page=" + i + "&page_size=20", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("type", str + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/confession/score_rank", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void e(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/info/set", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void e(String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        a.put("status", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/mics/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void e(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("source_from", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/leave", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void e(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("status", str2);
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/connect", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void e(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str4 = YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/auction_room/relation/gotten?uid=" + str2;
        String str5 = str4;
        if (!StringUtils.b(str3)) {
            str5 = str4 + "&type=" + str3;
        }
        HttpManager.a(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void e(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("music_id", str2);
        a.put("exec", str3);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/want/to/sing/action", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/recharge/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void f(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put(com.alipay.sdk.util.l.c, i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/invited/handle", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void f(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("type", str + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/confession/occupy_rank", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void f(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/info", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void f(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/users/follow", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void f(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("status", str2);
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/mics/status", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void f(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("type", str2);
        a.put("sentence_scores", str3);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/report", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/get_randroom", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/end/members?page=" + i + "&page_size=20", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/end/guide?room_id=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/cr_pk/level/list", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void g(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/emoji/" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", str);
        a.put("page_size", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/redPacket/room_list", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void h(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/newcomer/gifts", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void h(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("page", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/confession/users_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void h(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/source", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void h(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/level", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void h(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/effects/" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void h(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("task_type", str);
        a.put("current_level", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/daily/tasks/receive_reward", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void i(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/newcomer/receive_gift", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void i(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("section", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/activity_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void i(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("anchor_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/rank_activity/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void i(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/random/cancel", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void i(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/vote/" + str2 + "/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void i(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("type", str);
        a.put("level", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/daily/tasks/receive_gift", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void j(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/confession/index", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void j(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("ended", i + "");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/pk/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void j(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("source_from", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/index/right_menu", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void j(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/ktv/choosed", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void j(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/vote/" + str2 + "/close", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void j(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("anchor_uid", str);
        a.put("page", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/fans/list", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void k(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/banner", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void k(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("step_id", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/auction_room/update/step", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void k(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/members", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void k(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/ktv/sing_limit", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void k(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("goods_id", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/game/start", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void k(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("target_uid", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/firstMeet/getGifts", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void l(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/topic/getHotSetInfo", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void l(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("pk_duration", i + "");
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/pk/random/join", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void l(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/single/out", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void l(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/last_message", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void l(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("target_uid", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/teammate/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void l(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("music_id", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/want/to/sing", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void m(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().f() + "/pay/goods", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void m(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i + "");
        a.put("target_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/customCar/getReceived", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void m(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/close", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void m(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("finish_time", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/daily/tasks/speak_report", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void m(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("event_id", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/punishment/choose", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void n(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/veiledRoom/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void n(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/end/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void n(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("anchor_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/fans/info", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void n(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/battle/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void o(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().f() + "/sums/android", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void o(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/reportOnline", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void o(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("anchor_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/fans/me", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void o(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("id", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/game_room/game/play", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void p(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("_module", "trueLoveBox");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/s/trueLoveBox/sent/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void p(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/users/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void p(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("anchor_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/fans/benefit", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void p(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("status", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/mode", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void q(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/topic/lists", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void q(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/desc", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void q(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/ktv/playlist", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void q(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("music_id", str2);
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/startRob", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void r(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/basic", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void r(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/mics/confirm", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void r(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("musicId", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/ktv/musicInfo", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void r(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("music_id", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/robSing/wait/to/sing/delete", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void s(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/getBasicInfo", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void s(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/emoji", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void s(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/treasure/box/basic", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void s(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str);
        a.put("relation_id", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/respondInvite", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void t(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/customCar/getConfig", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void t(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/effects", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void t(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/treasure/box/grab", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void t(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        a.put("relation_id", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/getInviteLists", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void u(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/customCar/getSkins", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void u(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("music_id", str);
        a.put("from", "1");
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/live/music/song/item", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void u(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/ktv/stage/resources", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void u(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("task_id", str);
        a.put("id", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/taskIncrement", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void v(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/customCar/getColors", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void v(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/goodsWall", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void v(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/ktv/is_top", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(BluedHttpTools.a())).h();
    }

    public static void v(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("deal_with", str2);
        a.put("id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/userRelationship/dealWith", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void w(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/s/custom_activity/config", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void w(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/goodsExhibit", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void w(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("name", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/fans/name/update", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void w(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("skin_id", str);
        a.put("color_id", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/customCar/getPreview", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void x(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/romanticTrip/myLight", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void x(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/starGoods", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void x(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/flexible_bar", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void x(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("word", str);
        a.put("from", str2);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/risk_words", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public static void y(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/subinfo", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void y(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("target_uid", str);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/firstMeet", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void y(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("uid", str);
        a.put("type", str2);
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/romanticTrip/receive", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void z(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(YYRoomInfoManager.e().c().e() + "/users/chatroom/" + str + "/gift/goods_list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a()).h();
    }

    public static void z(String str, BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("room_id", str);
        HttpManager.b(YYRoomInfoManager.e().c().e() + "/users/chatroom/robSing/flickering", bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }
}
