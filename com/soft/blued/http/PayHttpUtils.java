package com.soft.blued.http;

import android.text.TextUtils;
import com.anythink.core.api.ATCustomRuleKeys;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.Gson;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/PayHttpUtils.class */
public class PayHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f29665a = PayHttpUtils.class.getSimpleName();

    public static String a(int i) {
        return i != 2 ? i != 4 ? "alipay" : "huabei" : UserAccountsModel.ACCOUNT_THREE_WEIXIN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (android.text.TextUtils.isEmpty(r11) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.blued.android.core.net.HttpResponseHandler r5, com.blued.android.core.net.IRequestHost r6, int r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L14
            r0 = r11
            r13 = r0
            r0 = r11
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L20
        L14:
            long r0 = java.lang.System.currentTimeMillis()
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r13 = r0
        L20:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            java.lang.String r1 = com.blued.android.module.common.url.BluedHttpUrl.s()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            java.lang.String r1 = "/pay/android/orders?T="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            r1 = r13
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            java.lang.String r1 = "&access_token="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            r1 = r12
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            java.lang.String r0 = r0.toString()
            r14 = r0
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a()
            r11 = r0
            r0 = r11
            java.lang.String r1 = "goods_id"
            r2 = r7
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r14
            r1 = r5
            r2 = r6
            com.blued.android.core.net.HttpRequestWrapper r0 = com.blued.android.core.net.HttpManager.b(r0, r1, r2)
            r6 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L85
            r0 = r10
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a(r0)
            r5 = r0
            goto L90
        L85:
            r0 = r8
            r1 = r9
            r2 = r12
            r3 = r13
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a(r0, r1, r2, r3)
            r5 = r0
        L90:
            r0 = r6
            r1 = r5
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.b(r1)
            r1 = r11
            java.lang.String r1 = com.blued.android.framework.http.BluedHttpTools.a(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.a(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.http.PayHttpUtils.a(com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.IRequestHost, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void a(HttpResponseHandler httpResponseHandler, IRequestHost iRequestHost, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", UserInfo.getInstance().getLoginUserInfo().getUid());
        a2.put("access_token", UserInfo.getInstance().getAccessToken());
        a2.put("appkey", str);
        HttpManager.b(BluedHttpUrl.s() + "/oauth2/access_token", httpResponseHandler, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.blued.android.core.net.HttpResponseHandler r5, com.blued.android.core.net.IRequestHost r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L14
            r0 = r10
            r12 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L20
        L14:
            long r0 = java.lang.System.currentTimeMillis()
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r12 = r0
        L20:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            java.lang.String r1 = com.blued.android.module.common.url.BluedHttpUrl.s()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = "/pay/android/sum?T="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r12
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = "&access_token="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r11
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r0 = r0.toString()
            r1 = r5
            r2 = r6
            com.blued.android.core.net.HttpRequestWrapper r0 = com.blued.android.core.net.HttpManager.a(r0, r1, r2)
            r6 = r0
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6e
            r0 = r9
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a(r0)
            r5 = r0
            goto L78
        L6e:
            r0 = r7
            r1 = r8
            r2 = r11
            r3 = r12
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a(r0, r1, r2, r3)
            r5 = r0
        L78:
            r0 = r6
            r1 = r5
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.b(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.http.PayHttpUtils.a(com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.IRequestHost, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (android.text.TextUtils.isEmpty(r12) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.blued.android.core.net.HttpResponseHandler r5, com.blued.android.core.net.IRequestHost r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r0 = r11
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L14
            r0 = r12
            r15 = r0
            r0 = r12
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L20
        L14:
            long r0 = java.lang.System.currentTimeMillis()
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r15 = r0
        L20:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            java.lang.String r1 = com.blued.android.module.common.url.BluedHttpUrl.s()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            java.lang.String r1 = "/pay/android/consume?T="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            r1 = r15
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            java.lang.String r1 = "&access_token="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            r1 = r13
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            java.lang.String r0 = r0.toString()
            r16 = r0
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a()
            r12 = r0
            r0 = r12
            java.lang.String r1 = "orders_id"
            r2 = r7
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L8a
            r0 = r8
            java.lang.String r0 = com.blued.android.framework.utils.EncryptTool.c(r0)
            r7 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L8a
            r0 = r12
            java.lang.String r1 = "payment"
            r2 = r7
            java.lang.String r2 = r2.toLowerCase()
            java.lang.Object r0 = r0.put(r1, r2)
        L8a:
            r0 = r12
            java.lang.String r1 = "body"
            r2 = r14
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r16
            r1 = r5
            r2 = r6
            com.blued.android.core.net.HttpRequestWrapper r0 = com.blued.android.core.net.HttpManager.b(r0, r1, r2)
            r6 = r0
            r0 = r11
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Laf
            r0 = r11
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a(r0)
            r5 = r0
            goto Lbb
        Laf:
            r0 = r9
            r1 = r10
            r2 = r13
            r3 = r15
            java.util.Map r0 = com.blued.android.framework.http.BluedHttpTools.a(r0, r1, r2, r3)
            r5 = r0
        Lbb:
            r0 = r6
            r1 = r5
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.b(r1)
            r1 = r12
            java.lang.String r1 = com.blued.android.framework.http.BluedHttpTools.a(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.a(r1)
            com.blued.android.core.net.HttpRequestWrapper r0 = r0.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.http.PayHttpUtils.a(com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.IRequestHost, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/live/user-vip/link", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("is_svip", i + "");
        HttpManager.a(BluedHttpUrl.r() + "/pay/config/vip/cancle", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, int i3, int i4, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        a2.put("is_custom", i4 + "");
        a2.put("product_id", i3 + "");
        HttpManager.a(BluedHttpUrl.r() + "/pay/coupons/new", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("coupon_id", String.valueOf(i));
        a2.put("money", String.valueOf(i2));
        HttpManager.b(BluedHttpUrl.r() + "/coupons/employ", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, long j, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("host", WBConstants.ACTION_LOG_TYPE_PAY);
        a2.put("id", String.valueOf(i));
        a2.put("type", "2");
        a2.put("platform", "android");
        a2.put("tt_id", String.valueOf(j));
        a2.put("detail", str);
        a2.put("promotion_type", String.valueOf(str2));
        a2.put("role", str3);
        a2.put(ATCustomRuleKeys.AGE, str4);
        a2.put("area", str5);
        a2.put("from", "exposure");
        HttpManager.b(BluedHttpUrl.r() + "/pay/storage", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/channel?sid=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, long j, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/config/app/tt_promotion?tt_id=" + j, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        try {
            HttpManager.a(BluedHttpUrl.r() + "/paymentcode", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure(null);
        }
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, int i, int i2, String str, String str2, String str3, String str4, String str5, int i3) {
        String str6 = BluedHttpUrl.r() + "/pay/android/unified";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", i2 + "");
        a2.put("type", a(i));
        a2.put("stage", "prepay");
        a2.put("detail", str5);
        if (i3 > 0) {
            a2.put("users_coupons_id", i3 + "");
        }
        if (!StringUtils.d(str3)) {
            a2.put("target_uid", str3);
        }
        if (!StringUtils.d(str2)) {
            a2.put("activity_id", str2);
        }
        if (!StringUtils.d(str4)) {
            a2.put("exchange_id", str4);
        }
        if (!StringUtils.d(str)) {
            a2.put("from", str);
        }
        Gson f = AppInfo.f();
        try {
            Logger.c("PayHttpUtils", "data==" + f.toJson(a2));
            String b = AesCrypto.b(f.toJson(a2));
            Map<String, String> a3 = BluedHttpTools.a();
            a3.put(BridgeUtil.UNDERLINE_STR, b);
            HttpManager.b(str6, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a3)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure((Throwable) null, -1, "");
        }
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, int i, String str) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/config/" + str + "?level_weal=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str) {
        a(bluedUIHttpResponse, iRequestHost, 0, str);
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, int i) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/config/" + str + "?id=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2) {
        String str3 = BluedHttpUrl.r() + "/pay/config/" + str;
        Map<String, String> a2 = BluedHttpTools.a();
        if (!TextUtils.isEmpty(str2)) {
            a2.put("from", str2);
        }
        HttpManager.a(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/super/call/check?uid=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, int i, int i2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("exchange_id", str);
        a2.put("coupon_id", String.valueOf(i));
        a2.put("money", String.valueOf(i2));
        HttpManager.b(BluedHttpUrl.r() + "/coupons/use", new BluedUIHttpResponse<BluedEntityA<CountModel>>(null) { // from class: com.soft.blued.http.PayHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, final String str2) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.http.PayHttpUtils.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastUtils.b(str2);
                    }
                }, 500L);
                return true;
            }
        }, null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        try {
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("type", "modify");
            a2.put("code", BluedHttpTools.b(str));
            String b = AesCrypto.b(AppInfo.f().toJson(a2));
            Map<String, String> a3 = BluedHttpTools.a();
            a3.put(BridgeUtil.UNDERLINE_STR, b);
            HttpManager.b(BluedHttpUrl.r() + "/paymentcode", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a3)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure(null);
        }
    }

    public static void a(String str, Boolean bool, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        try {
            Logger.e("setPayPW", "pwd===" + BluedHttpTools.b(str));
            String str2 = BluedHttpUrl.r() + "/paymentcode/" + i;
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("verify", bool.booleanValue() ? "1" : "0");
            a2.put("code", BluedHttpTools.b(str));
            a2.put("type", "set");
            String b = AesCrypto.b(AppInfo.f().toJson(a2));
            Map<String, String> a3 = BluedHttpTools.a();
            a3.put(BridgeUtil.UNDERLINE_STR, b);
            HttpManager.b(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a3)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure(null);
        }
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/config", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/beans/get_detail?product_id=" + i, bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/coupons/new?page=1&size=20&product_id=" + i + "&is_custom=" + i2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/coupons/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2) {
        String str3 = BluedHttpUrl.r() + "/pay/android/unified";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("stage", "verify");
        if ("alipay".equals(str)) {
            a2.put("result", str2);
        } else if (UserAccountsModel.ACCOUNT_THREE_WEIXIN.equals(str)) {
            a2.put("prepayid", str2);
        }
        a2.put("type", str);
        try {
            String b = AesCrypto.b(AppInfo.f().toJson(a2));
            Map<String, String> a3 = BluedHttpTools.a();
            a3.put(BridgeUtil.UNDERLINE_STR, b);
            HttpManager.b(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a3)).h();
        } catch (Exception e) {
            bluedUIHttpResponse.onFailure((Throwable) null, -1, "");
        }
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/pay/config/upgrade", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }
}
