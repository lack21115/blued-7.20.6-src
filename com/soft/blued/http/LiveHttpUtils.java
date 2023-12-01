package com.soft.blued.http;

import android.content.Context;
import android.text.TextUtils;
import android.text.style.SuggestionSpan;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.RequestLiveRedNoticeModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.live.model.RequestLiveRewardConfigModel;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/LiveHttpUtils.class */
public class LiveHttpUtils {

    /* renamed from: com.soft.blued.http.LiveHttpUtils$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/LiveHttpUtils$1.class */
    class AnonymousClass1 extends BluedUIHttpResponse<BluedEntityA<RequestLiveRedNoticeModel>> {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<RequestLiveRedNoticeModel> bluedEntityA) {
            if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                return;
            }
            LiveEventBusUtil.a(bluedEntityA.getSingleData());
        }
    }

    public static void a() {
        HttpManager.a(LiveRoomInfo.a().m() + "/live/request/is-start-reward", new BluedUIHttpResponse<BluedEntity<CountModel, RequestLiveRewardConfigModel>>(null) { // from class: com.soft.blued.http.LiveHttpUtils.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<CountModel, RequestLiveRewardConfigModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                LiveDataManager.a().b(bluedEntity.extra.is_start_reward);
            }
        }, null).b(BluedHttpTools.a(true)).h();
    }

    public static void a(int i, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, String.valueOf(i));
        HttpManager.a(BluedHttpUrl.q() + "/live/bonuses/list", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        HttpManager.a(BluedHttpUrl.q() + "/live/anchor-fans/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/blued/qiniu?=filter=token&action=idcard", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.a(LiveRoomInfo.a().k() + "/live/chatroom/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/live/recommend/list", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("position_code", "1009");
        HttpManager.b(BluedHttpUrl.q() + "/blued/launch/adms", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("latitude", CommonPreferences.v());
        a2.put("longitude", CommonPreferences.u());
        HttpManager.a(BluedHttpUrl.q() + "/live/nearby", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, int i, String str) {
        String str2 = BluedHttpUrl.q() + "/live/followed/recommend";
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(WBPageConstants.ParamKey.PAGE, i + "");
        if (!TextUtils.isEmpty(str)) {
            arrayMap.put("last", str);
        }
        HttpManager.a(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("goods_id", str);
        a2.put(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, String.valueOf(i));
        a2.put("anchor", str2);
        HttpManager.b(BluedHttpUrl.r() + "/live/request/reward", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, String str3, IRequestHost iRequestHost) {
        String str4 = LiveRoomInfo.a().k() + "/users/" + str + "/live_idcard";
        Map<String, String> a2 = BluedHttpTools.a();
        if (i == 0) {
            a2.put("type", "front");
        } else if (i == 1) {
            a2.put("type", SuggestionSpan.SUGGESTION_SPAN_PICKED_AFTER);
        }
        a2.put("idcard", str2);
        if (!TextUtils.isEmpty(str3)) {
            a2.put("from", str3);
        }
        HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/onairlist?page=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/cates/" + str + "?page=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(TypedValues.AttributesType.S_TARGET, str);
        HttpManager.a(BluedHttpUrl.q() + "/live/followed/recommend/hate").b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(BluedHttpUrl.q() + "/live/anchor-fans/" + str + "/leave", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        HttpManager.a(BluedHttpUrl.q() + "/live/anchor-fans/recommend", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("position_code", "9002");
        HttpManager.b(BluedHttpUrl.q() + "/blued/launch/adms", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, IRequestHost iRequestHost) {
        String str3 = LiveRoomInfo.a().k() + "/users/" + str + "/idcard";
        Map<String, String> a2 = BluedHttpTools.a();
        if (i == 0) {
            a2.put("type", "front");
        } else if (i == 1) {
            a2.put("type", SuggestionSpan.SUGGESTION_SPAN_PICKED_AFTER);
        } else if (i == 2) {
            a2.put("type", "hands");
        }
        a2.put("idcard", str2);
        HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, String str3, IRequestHost iRequestHost) {
        String str4 = LiveRoomInfo.a().k() + "/users/" + str + "/live_idcard?http_method_override=DELETE";
        Map<String, String> a2 = BluedHttpTools.a();
        if (i == 0) {
            a2.put("type", "front");
        } else if (i == 1) {
            a2.put("type", SuggestionSpan.SUGGESTION_SPAN_PICKED_AFTER);
        }
        a2.put("idcard", str2);
        if (!TextUtils.isEmpty(str3)) {
            a2.put("from", str3);
        }
        HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, String.valueOf(str));
        HttpManager.a(LiveRoomInfo.a().k() + "/live/followed-list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/cates/" + str + "/recommend?page=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/users/chatroom/" + str + "/user/invite", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/request/count", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, IRequestHost iRequestHost) {
        String str3 = LiveRoomInfo.a().k() + "/users/" + str + "/idcard?http_method_override=DELETE";
        Map<String, String> a2 = BluedHttpTools.a();
        if (i == 0) {
            a2.put("type", "front");
        } else if (i == 1) {
            a2.put("type", SuggestionSpan.SUGGESTION_SPAN_PICKED_AFTER);
        } else if (i == 2) {
            a2.put("type", "hands");
        }
        a2.put("idcard", str2);
        HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("anchor", str);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/request", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        String str3 = BluedHttpUrl.q() + "/users/" + str + "/applied";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("sign_contract", "1");
        if (!TextUtils.isEmpty(str2)) {
            a2.put("from", str2);
        }
        HttpManager.a(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/live/request/goods-list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, IRequestHost iRequestHost) {
        a(bluedUIHttpResponse, str, i, str2, null, iRequestHost);
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        c(bluedUIHttpResponse, str, "", iRequestHost);
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(LiveRoomInfo.a().k() + "/live/recommend/banner", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, IRequestHost iRequestHost) {
        b(bluedUIHttpResponse, str, i, str2, null, iRequestHost);
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", "2");
        HttpManager.a(BluedHttpUrl.q() + "/live/tab/settings", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", "2");
        HttpManager.b(BluedHttpUrl.q() + "/live/tab/report", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }
}
