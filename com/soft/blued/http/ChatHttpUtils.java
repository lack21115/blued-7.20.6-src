package com.soft.blued.http;

import android.app.Instrumentation;
import android.content.Context;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.android.internal.inputmethod.InputMethodUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.chat.http.IModuleChatHttp;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.community.utils.UserInfoUtils;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.cdo.oaps.ad.Launcher;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.R;
import com.soft.blued.constant.QiniuConstant;
import com.soft.blued.ui.msg.fragment.EmotionDataManager;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/ChatHttpUtils.class */
public class ChatHttpUtils implements IModuleChatHttp {
    public static String a(ChattingModel chattingModel) {
        Object obj;
        short s = chattingModel.msgType;
        Object obj2 = "1";
        if (s == 2) {
            obj = "images";
        } else if (s != 3) {
            obj = "videos";
            if (s != 5) {
                if (s != 24) {
                    obj = "videos";
                    if (s != 25) {
                        obj2 = "";
                        obj = obj2;
                    }
                } else {
                    obj = "images";
                }
                return String.format(QiniuConstant.a(), obj, obj2);
            }
        } else {
            obj = InputMethodUtils.SUBTYPE_MODE_VOICE;
        }
        obj2 = "0";
        return String.format(QiniuConstant.a(), obj, obj2);
    }

    public static void a() {
        if (((int) ((System.currentTimeMillis() - BluedPreferences.eP()) / 86400000)) > 7 || BluedConfig.a().b().has_buy_call == 1) {
            return;
        }
        Map<String, Object> b = BluedHttpTools.b();
        b.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        HttpManager.b(BluedHttpUrl.q() + "/users/call/guide").b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(int i, String str, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpRequestWrapper b = HttpManager.a(BluedHttpUrl.q() + "/blued/emotions/" + i, bluedUIHttpResponse, null).b(BluedHttpTools.a(true));
        if (i == 0) {
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("name", str);
            b.a(a2);
        }
        b.h();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(long j, long j2, boolean z, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(long j, IRequestHost iRequestHost, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/users/message_pair/is_exit_chat/" + j, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(final long j, List<String> list, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tags", StringUtils.a(list));
        HttpManager.b(BluedHttpUrl.q() + "/users/message_pair/user_evaluation/" + j, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.http.ChatHttpUtils.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                AppMethods.d((int) R.string.date_today_impressions_submitted);
                DateTodayManager.f32404a.g(j);
            }
        }, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, String str3, IRequestHost iRequestHost) {
        String str4;
        Map<String, Object> b = BluedHttpTools.b();
        b.put("reason", Integer.valueOf(i));
        b.put(TTLiveConstants.ROOMID_KEY, str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Instrumentation.REPORT_KEY_STREAMRESULT, str3);
            str4 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            str4 = "";
        }
        b.put("attachments", str4);
        HttpManager.b(BluedHttpUrl.q() + "/blued/report/sparkchat/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/basic", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String[] strArr, int i, String str2, String str3, long j, int i2, String str4, String str5, String str6, int i3, IRequestHost iRequestHost) {
        String str7;
        Map<String, Object> b = BluedHttpTools.b();
        b.put("reason", i2 + "");
        b.put("contents", str);
        b.put("lid", Long.valueOf(j));
        if (strArr != null && strArr.length > 0) {
            b.put("attachments", strArr);
        }
        String str8 = "user";
        switch (i) {
            case 1:
                break;
            case 2:
            case 9:
                str8 = IAdInterListener.AdProdType.PRODUCT_FEEDS;
                break;
            case 3:
            case 7:
            case 8:
            default:
                str8 = "user";
                break;
            case 4:
                str8 = "group";
                break;
            case 5:
            case 10:
                str8 = "feed_comment";
                break;
            case 6:
                b.put("check_attachments", 1);
                b.put("reason_desc", str4);
                str8 = "chat";
                break;
            case 11:
                b.put("img", str2);
                if (!TextUtils.isEmpty(str3) && str3.contains(",")) {
                    String[] split = str3.split(",");
                    if (split.length == 2) {
                        b.put("pid", split[0]);
                        b.put("uid", split[1]);
                    }
                }
                str8 = "private-album";
                break;
            case 12:
                b.put("report_uid", str6);
                b.put("report_reason", str4);
                b.put("activity_id", str5);
                String[] strArr2 = strArr;
                if (strArr == null) {
                    strArr2 = new String[0];
                }
                b.put("attachments", strArr2);
                str8 = "activity/create";
                break;
            case 13:
                b.put("report_uid", str6);
                b.put("report_reason", str4);
                String[] strArr3 = strArr;
                if (strArr == null) {
                    strArr3 = new String[0];
                }
                b.put("attachments", strArr3);
                b.put("sign_id", String.valueOf(i3));
                str8 = "activity/sign/create";
                break;
        }
        try {
            b.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (Exception e) {
        }
        if (i != 5) {
            switch (i) {
                case 10:
                    break;
                case 11:
                    str7 = BluedHttpUrl.q() + "/blued/newreport/" + str8;
                    break;
                case 12:
                    str7 = BluedHttpUrl.q() + "/blued/newreport/activity/create";
                    break;
                case 13:
                    str7 = BluedHttpUrl.q() + "/blued/newreport/activity/sign/create";
                    break;
                default:
                    str7 = BluedHttpUrl.q() + "/blued/newreport/" + str8 + BridgeUtil.SPLIT_MARK + str2;
                    break;
            }
            Map<String, String> a2 = BluedHttpTools.a();
            if (i != 2 || i == 5) {
                a2.put("source", "ticktock");
            }
            if (i != 9 || i == 10) {
                a2.put("source", "posting");
            }
            HttpManager.b(HttpUtils.a(a2, str7), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
        }
        str7 = BluedHttpUrl.q() + "/blued/newreport/" + str8 + BridgeUtil.SPLIT_MARK + str3 + BridgeUtil.SPLIT_MARK + str2;
        Map<String, String> a22 = BluedHttpTools.a();
        if (i != 2) {
        }
        a22.put("source", "ticktock");
        if (i != 9) {
        }
        a22.put("source", "posting");
        HttpManager.b(HttpUtils.a(a22, str7), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("uid", UserInfoUtils.c());
        HttpManager.b(BluedHttpUrl.q() + "/push/getui/cid?http_method_override=DELETE", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("time", Integer.valueOf(i));
        HttpManager.b(BluedHttpUrl.q() + "/live/sign-hongbao/watch-time", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().uid + "/background", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, long j) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("location", "" + UserInfo.getInstance().getLoginUserInfo().getLatitude() + "," + UserInfo.getInstance().getLoginUserInfo().getLongitude());
        b.put("exclude_room_id", Long.valueOf(j));
        HttpManager.b(BluedHttpUrl.q() + "/users/chatroom/im/recommend", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("content", str);
        HttpManager.b(BluedHttpUrl.r() + "/pay/validation/words", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("cid", str);
        b.put("uid", UserInfoUtils.c());
        b.put("huawei_icon", Integer.valueOf(i));
        HttpManager.b(BluedHttpUrl.q() + "/push/getui/cid", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, int i3, String str2, ChattingModel chattingModel) {
        String str3;
        String str4 = BluedHttpUrl.q() + "/users/" + str + "/reply";
        Map<String, Object> b = BluedHttpTools.b();
        b.put("is_menu", Integer.valueOf(i));
        b.put("first_level", Integer.valueOf(i2));
        b.put("second_level", Integer.valueOf(i3));
        b.put("keyword", str2);
        if (chattingModel != null) {
            b.put("user_id", Long.valueOf(UserInfo.getInstance().getLoginUserInfo().uid));
            b.put("from", Long.valueOf(chattingModel.fromId));
            b.put("to", Long.valueOf(chattingModel.toId));
            b.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(chattingModel.sessionType));
            b.put("msg_type", Short.valueOf(chattingModel.msgType));
            b.put("local_id", Long.valueOf(chattingModel.msgLocalId));
            if (TextUtils.isEmpty(chattingModel.getMsgExtra())) {
                str3 = "";
            } else {
                str3 = ",\"extra\":" + chattingModel.getMsgExtra();
            }
            b.put("msg_body", "{ \"contents\":\"" + chattingModel.msgContent + "\"" + str3 + i.d);
        }
        HttpManager.b(str4, bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(BluedHttpUrl.q());
        sb.append("/users/super/call/status?uid=");
        sb.append(str);
        sb.append("&msg_time=");
        long j2 = 0;
        if (j > 0) {
            j2 = j / 1000;
        }
        sb.append(j2);
        HttpManager.a(sb.toString(), bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("from", "auto");
        a2.put("to", LocaleUtils.b());
        a2.put("contents", str);
        HttpManager.b(BluedHttpUrl.q() + "/blued/translator", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str2);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/friends/search?page=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, ChattingModel chattingModel) {
        String str3 = BluedHttpUrl.q() + "/users/" + str + "/messages/attachments";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("sessionType", ((int) chattingModel.sessionType) + "");
        if (chattingModel.msgType == 24) {
            a2.put("isBurn", "1");
        }
        HttpManager.a(str3, str2, "pic[]", bluedUIHttpResponse).b(BluedHttpTools.b(true)).a(a2).h();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, boolean z, IRequestHost iRequestHost) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, List<String> list, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uids", StringUtils.a(list));
        HttpManager.b(BluedHttpUrl.q() + "/users/social/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String[] strArr, String[] strArr2, String str) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("image", strArr);
        b.put("video", strArr2);
        b.put("action", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/chat/private/audit", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("name", str);
        HttpManager.a(BluedHttpUrl.q() + "/blued/emotions", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, final String str2) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("eid", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/emotions?http_method_override=DELETE", new BluedUIHttpResponse<BluedEntityA<String>>(null) { // from class: com.soft.blued.http.ChatHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.code != 200) {
                    return;
                }
                EmotionDataManager.a().c(str2);
                EmotionManager.d(str2);
                LiveEventBus.get("EMOTION_RELOAD_DATA").post(true);
            }
        }, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        HttpManager.a(BluedHttpUrl.q() + "/users/poke/" + str, bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", str);
        a2.put("data_id", str2);
        a2.put("deal_with", str3);
        HttpManager.b(BluedHttpUrl.q() + "/users/chatroom/userRelationship/dealWith", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, List<String> list, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tags", StringUtils.a(list));
        a2.put("title", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/message_pair/functional_evaluation", new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.http.ChatHttpUtils.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                AppMethods.d((int) R.string.date_today_satisfied_submitted);
                DateTodayManager.f32404a.c(3);
            }
        }, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(List<String> list, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tags", StringUtils.a(list));
        HttpManager.b(BluedHttpUrl.q() + "/users/message_pair/making_friends_purpose", null, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b() {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        HttpManager.b(BluedHttpUrl.q() + "/users/flash/give").b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/emotions/banners", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/chat_box", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("activity_id", str);
        HttpManager.b(BluedHttpUrl.q() + "/blued/newreport/activity/feedback", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/stimulate/flash", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, List<String> list, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("group_ids", StringUtils.a(list));
        HttpManager.a(BluedHttpUrl.q() + "/groups/info_batch", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", str);
        HttpManager.a(BluedHttpUrl.q() + "/users/chatroom/userRelationship/info", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/emotions/recommend", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/gift/coupons", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("voice_name", str);
        HttpManager.b(BluedHttpUrl.q() + "/blued/voice/transform", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/emotions", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/emotions/sayhi", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/flash", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/users/message_pair/config_message", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/message_pair/qualification", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + Launcher.Path.CARD, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/groups/bubble", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/message_pair/pair", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    @Override // com.blued.android.module.chat.http.IModuleChatHttp
    public void getChatRelationData(StringHttpResponseHandler stringHttpResponseHandler, Long[] lArr) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("uid", lArr);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/chat/detail", stringHttpResponseHandler, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }
}
