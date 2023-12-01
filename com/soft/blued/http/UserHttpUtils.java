package com.soft.blued.http;

import android.content.Context;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.chat.manager.SessionDataManager;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.cdo.oaps.ad.OapsKey;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.msg.model.GiftVoucherModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/UserHttpUtils.class */
public class UserHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f15977a = 1;
    public static boolean b = BluedPreferences.H();

    /* renamed from: c  reason: collision with root package name */
    public static FilterEntity f15978c;
    public static boolean d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/UserHttpUtils$MARKET_GUIDE_TYPE.class */
    public interface MARKET_GUIDE_TYPE {
    }

    public static void a() {
        g(new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>() { // from class: com.soft.blued.http.UserHttpUtils.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                try {
                    double i = (TimeAndDateUtils.i(System.currentTimeMillis()) - Long.parseLong(AesCrypto.e(((UserInfoEntity) bluedEntityA.getSingleData()).registration_time_encrypt))) / 86400;
                    if (i <= 29.0d || i >= 91.0d || UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                        return;
                    }
                    String str = BluedHttpUrl.r() + "/pay/procedure/user/nmt";
                    Map b2 = BluedHttpTools.b();
                    b2.put("dev_dna", BluedDeviceIdentity.a().d());
                    b2.put("dev_dna_label", BluedDeviceIdentity.a().e());
                    b2.put("smid", BluedDeviceIdentity.a().f());
                    String g = DeviceUtils.g();
                    if (!TextUtils.isEmpty(g)) {
                        b2.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
                    }
                    HttpManager.b(str).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b2)).h();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, null);
    }

    public static void a(Context context, BinaryHttpResponseHandler binaryHttpResponseHandler, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/passport/qrcode", binaryHttpResponseHandler, iRequestHost).b(BluedHttpTools.c(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        try {
            if (StringUtils.d(str)) {
                return;
            }
            HttpManager.a(((BluedHttpUrl.q() + "/users/name?name=" + URLEncoder.encode(str)) + "&is_shadow=" + i) + "&is_call=" + i2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
        } catch (Exception e) {
        }
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        a(context, bluedUIHttpResponse, str, 0, 0, iRequestHost);
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str);
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        HttpManager.a(BluedHttpUrl.q() + "/users/search", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    private static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        String str4 = BluedHttpUrl.q() + "/users/" + str + "/followed/" + str2;
        String str5 = str4;
        if (!TextUtils.isEmpty(str3)) {
            str5 = str4 + "?from=" + str3;
        }
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost) {
        String str6 = BluedHttpUrl.q() + "/users/call";
        Map a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str);
        a2.put(OapsKey.KEY_SIZE, str2);
        if (!TextUtils.isEmpty(str3)) {
            a2.put("rank_by", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            a2.put("role", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            a2.put("filters", str5);
        }
        HttpManager.a(str6, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, boolean z, int i, int i2, int i3, IRequestHost iRequestHost) {
        HttpManager.a((((((BluedHttpUrl.q() + "/users/" + str) + "?from=" + str2) + "&is_living=" + z) + "&is_vip_page=" + i) + "&is_shadow=" + i2) + "&is_call=" + i3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, Map<String, String> map, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).h();
    }

    public static void a(Context context, final UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, final String str, String str2, IRequestHost iRequestHost) {
        b(context, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(iRequestHost) { // from class: com.soft.blued.http.UserHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                int i = 0;
                String str3 = ((UserInfoEntity) bluedEntityA.data.get(0)).relationship;
                if ("1".equals(str3) || "3".equals(str3)) {
                    i = 1;
                }
                try {
                    SessionDataManager.getInstance().updateFollower(Long.valueOf(str).longValue(), i);
                } catch (Exception e) {
                }
                iAddOrRemoveAttentionDone.b(str3);
                ((UserInfoEntity) bluedEntityA.getSingleData()).uid = str;
                LiveEventBus.get("feed_relation_ship").post(bluedEntityA.getSingleData());
                LiveEventBus.get("common_clear_group_member_state").post(str);
            }

            public void onUIFinish() {
                super.onUIFinish();
                iAddOrRemoveAttentionDone.b();
            }

            public void onUIStart() {
                super.onUIStart();
                iAddOrRemoveAttentionDone.a();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, str2, iRequestHost);
    }

    public static void a(Context context, String str, BinaryHttpResponseHandler binaryHttpResponseHandler, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/passport/qrcode/" + EncryptTool.b(str), binaryHttpResponseHandler, iRequestHost).b(BluedHttpTools.c(true)).h();
    }

    public static void a(IRequestHost iRequestHost, String str, String str2, BluedUIHttpResponse bluedUIHttpResponse) {
        String str3 = BluedHttpUrl.r() + "/pay/android/entrust";
        Map a2 = BluedHttpTools.a();
        a2.put("contract_code", str);
        a2.put("stage", "verify");
        a2.put("type", str2);
        try {
            String b2 = AesCrypto.b(AppInfo.f().toJson(a2));
            Map a3 = BluedHttpTools.a();
            a3.put("_", b2);
            HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a3)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure((Throwable) null);
        }
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, String str, double d2, int i2, int i3, String str2, String str3, String str4, boolean z, int i4, IRequestHost iRequestHost) {
        String str5 = BluedHttpUrl.r() + "/pay/android/entrust";
        Map b2 = BluedHttpTools.b();
        b2.put("id", i + "");
        b2.put("type", str);
        b2.put("money", String.valueOf(d2));
        b2.put("stage", "prepay");
        b2.put("detail", str4);
        b2.put("is_entrust_giver", Integer.valueOf(i4));
        b2.put("vip_type", i2 == 2 ? "svip" : "vip");
        b2.put("month", i3 + "");
        if (!StringUtils.d(str2)) {
            b2.put("target_uid", str2);
        }
        if (z) {
            b2.put("is_change", "1");
        }
        if (!StringUtils.d(str3)) {
            b2.put("activity_id", str3);
        }
        try {
            String b3 = AesCrypto.b(AppInfo.f().toJson(b2));
            Map a2 = BluedHttpTools.a();
            a2.put("_", b3);
            HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure((Throwable) null);
        }
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/eco/vote", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, int i) {
        Map b2 = BluedHttpTools.b();
        b2.put("personal_display", Integer.valueOf(i));
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/setting?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2, String str3) {
        Map a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("page_size", str3);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/index/recommend", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/config/new_gift?target_uid=" + EncryptTool.b(str), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, GiftVoucherModel giftVoucherModel, IRequestHost iRequestHost) {
        String str4 = BluedHttpUrl.r() + "/pay/gift/free";
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str);
        a2.put("gift_id", str2);
        a2.put("detail", str3);
        if (giftVoucherModel != null) {
            a2.put("coupons_id", giftVoucherModel.coupons_id + "");
            a2.put("coupons_money", giftVoucherModel.money + "");
        }
        HttpManager.b(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str3);
        a2.put(OapsKey.KEY_SIZE, str4);
        a2.put("ttid", str2);
        HttpManager.a(BluedHttpUrl.q() + "/ticktocks/users/" + str + "/photowall", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost, String str6, String str7, boolean z, String str8, int i, String str9, String str10, String str11, String str12, String str13) {
        String str14 = BluedHttpUrl.r() + "/pay/beans";
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str);
        a2.put("id", str2);
        a2.put("detail", str4);
        a2.put("from", str5);
        a2.put("pay_code", str6);
        a2.put("pay_token", str7);
        a2.put("tt_id", str3);
        a2.put("trade_type", str8);
        a2.put("beans", i + "");
        a2.put("aim", str9);
        a2.put("promotion_type", str10);
        a2.put("role", str11);
        a2.put("age", str12);
        a2.put("area", str13);
        a2.put("rememberMe", z ? "1" : "0");
        HttpManager.b(str14, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, List<String> list, IRequestHost iRequestHost) {
        Map b2 = BluedHttpTools.b();
        b2.put("target_id", list);
        HttpManager.b(BluedHttpUrl.q() + "/users/stealth/cancel", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b2)).h();
    }

    public static void a(String str, int i, int i2) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", str);
        a2.put("is_praise", i + "");
        a2.put("code", i2 + "");
        HttpManager.a(BluedHttpUrl.q() + "/blued/praise", (HttpResponseHandler) null, (IRequestHost) null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("result", i + "");
        HttpManager.b(BluedHttpUrl.q() + "/users/eco/vote", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, IRequestHost iRequestHost, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().uid + "/secretly_followed/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/chatroom/switch?uid=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str);
        a2.put("bag_id", str4);
        a2.put("detail", str2);
        a2.put("from", str3);
        HttpManager.b(BluedHttpUrl.r() + "/pay/gift/bag", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/blacklist/" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    private static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        String str4 = BluedHttpUrl.q() + "/users/" + str + "/followed/" + str2 + "?http_method_override=DELETE";
        String str5 = str4;
        if (!StringUtils.d(str3)) {
            str5 = str4 + "&from=" + str3;
        }
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(Context context, final UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, final String str, String str2, IRequestHost iRequestHost) {
        a(context, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(iRequestHost) { // from class: com.soft.blued.http.UserHttpUtils.2

            /* renamed from: a  reason: collision with root package name */
            boolean f15980a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                int i = 0;
                String str3 = ((UserInfoEntity) bluedEntityA.data.get(0)).relationship;
                if ("1".equals(str3) || "3".equals(str3)) {
                    i = 1;
                }
                try {
                    SessionDataManager.getInstance().updateFollower(Long.valueOf(str).longValue(), i);
                } catch (Exception e) {
                }
                UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.a(str3);
                }
                ((UserInfoEntity) bluedEntityA.getSingleData()).uid = str;
                LiveEventBus.get("feed_relation_ship").post(bluedEntityA.getSingleData());
            }

            public boolean onUIFailure(int i, String str3) {
                this.f15980a = true;
                return super.onUIFailure(i, str3);
            }

            public void onUIFinish() {
                super.onUIFinish();
                UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    if (this.f15980a) {
                        iAddOrRemoveAttentionDone2.c();
                    } else {
                        iAddOrRemoveAttentionDone2.b();
                    }
                }
                this.f15980a = false;
            }

            public void onUIStart() {
                super.onUIStart();
                UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.a();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, str2, iRequestHost);
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/gift/bag", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str);
        HttpManager.a(BluedHttpUrl.r() + "/pay/gift", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str);
        a2.put("gift_id", str2);
        a2.put("detail", str3);
        a2.put("from", str4);
        HttpManager.b(BluedHttpUrl.r() + "/pay/gift/reduce_stock", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/special/friend", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/blacklist/" + str2 + "?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/photos/background?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", str);
        HttpManager.a(BluedHttpUrl.q() + "/blued/theme", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/special/friend/delete", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/face/delete", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/messages/unread", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/photos/dilatation?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/menu", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void h(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_id", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/stealth/set", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }
}
