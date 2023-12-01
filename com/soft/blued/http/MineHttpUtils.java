package com.soft.blued.http;

import android.content.Context;
import android.os.Build;
import android.provider.SearchIndexablesContract;
import android.provider.Settings;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.anythink.core.api.ErrorCode;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.community.utils.UserInfoUtils;
import com.qq.e.comm.managers.GDTAdSdk;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.mine.model.MinePageModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.utils.ADUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.WeChatUtils;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tendinsv.a.b;
import com.umeng.analytics.pro.bh;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/MineHttpUtils.class */
public class MineHttpUtils {
    public static void a() {
        final String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
        String str = BluedHttpUrl.q() + "/users/" + uid + "/more/android?v=2";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("channel", AppInfo.f9487c);
        HttpManager.a(str, new BluedUIHttpResponse<BluedEntityA<MinePageModel>>(null) { // from class: com.soft.blued.http.MineHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MinePageModel> bluedEntityA) {
                UserInfoEntity userInfoEntity;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (userInfoEntity = bluedEntityA.getSingleData().user) == null || UserInfo.getInstance().getLoginUserInfo() == null || !uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
                    return;
                }
                UserInfo.getInstance().getLoginUserInfo().setName(userInfoEntity.name);
                UserInfo.getInstance().getLoginUserInfo().setAvatar(userInfoEntity.avatar);
                UserInfo.getInstance().getLoginUserInfo().avatar_frame = userInfoEntity.avatar_frame;
                UserInfo.getInstance().getLoginUserInfo().avatar_frame_type = userInfoEntity.avatar_frame_type;
                UserInfo.getInstance().getLoginUserInfo().avatar_audited = userInfoEntity.avatar_audited;
                UserInfo.getInstance().getLoginUserInfo().is_audited = userInfoEntity.is_audited;
                UserInfo.getInstance().getLoginUserInfo().auditing_profile = userInfoEntity.auditing_profile;
            }
        }, null).a(a2).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/report/attachments", str, "pic[]", bluedUIHttpResponse).b(BluedHttpTools.b(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str);
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        a2.put("filter", "followed");
        HttpManager.a(BluedHttpUrl.q() + "/users/search?filter=followed", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        if (NetworkUtils.c()) {
            HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/visitors_count", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
        }
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str);
        a2.put("size", str2);
        HttpManager.a(BluedHttpUrl.q() + "/ticktocks/liked/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        String str4 = BluedHttpUrl.q() + "/users/" + str + "/visitors";
        a2.put("android_model", Build.MANUFACTURER + Build.MODEL);
        a2.put("android_version", Build.VERSION.RELEASE);
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            a2.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
        }
        a2.put("android_oaid", BluedDeviceIdentity.a().h());
        String d = DeviceUtils.d();
        boolean z = true;
        switch (d.hashCode()) {
            case -840190066:
                if (d.equals("China Telecom")) {
                    z = true;
                    break;
                }
                break;
            case -357112885:
                if (d.equals("China Mobile")) {
                    z = true;
                    break;
                }
                break;
            case -128800326:
                if (d.equals("China Unicom")) {
                    z = true;
                    break;
                }
                break;
            case 618558396:
                if (d.equals("中国电信")) {
                    z = true;
                    break;
                }
                break;
            case 618596989:
                if (d.equals("中国移动")) {
                    z = false;
                    break;
                }
                break;
            case 618663094:
                if (d.equals("中国联通")) {
                    z = true;
                    break;
                }
                break;
        }
        a2.put(bh.P, ((!z || z) ? 1 : (z || z) ? 2 : (z || z) ? 3 : 0) + "");
        String buyerId = GDTAdSdk.getGDTAdManger().getBuyerId(new ArrayMap());
        String sDKInfo = GDTAdSdk.getGDTAdManger().getSDKInfo(ErrorCode.networkError);
        Log.v("drb", "buyerId:" + buyerId + " -- sdkInfo:" + sDKInfo);
        a2.put("gdt_buyer_id", buyerId);
        a2.put("gdt_sdk_info", sDKInfo);
        a2.put("conn_type", com.soft.blued.utils.NetworkUtils.b() + "");
        a2.put("make", Build.MANUFACTURER);
        a2.put("model", Build.MODEL);
        a2.put(b.a.q, DeviceUtils.k());
        a2.put("ipv6", DeviceUtils.l());
        a2.put("h", AppInfo.m + "");
        a2.put(IAdInterListener.AdReqParam.WIDTH, AppInfo.l + "");
        a2.put("imei", AppInfo.d);
        a2.put("didmd5", Md5.a(AppInfo.d).toLowerCase());
        a2.put(bh.x, "Android");
        a2.put("country", Locale.getDefault().getCountry());
        a2.put("latitude", CommonPreferences.v());
        a2.put("longitude", CommonPreferences.u());
        a2.put("wx", WeChatUtils.a(AppInfo.d()) ? "1" : "0");
        a2.put("wx_sdk", "5.5.8");
        a2.put("channel", AppInfo.f9487c);
        a2.put("req_id", ADUtils.b());
        HttpManager.a(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, String str, HttpResponseHandler httpResponseHandler) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("platform", "Android");
        a2.put("platform_version", Build.VERSION.RELEASE);
        a2.put("version", DeviceUtils.c());
        a2.put("version_code", "" + DeviceUtils.b());
        a2.put("channel", AppInfo.f9487c);
        a2.put("update_app", str);
        String str2 = BluedHttpUrl.q() + "/blued";
        if (UserInfo.getInstance().isLogin()) {
            HttpManager.a(str2, httpResponseHandler).b(BluedHttpTools.a(true)).a(a2).h();
        } else {
            HttpManager.a(str2, httpResponseHandler).b(BluedHttpTools.a(false)).a(a2).h();
        }
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/users/shadow", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("status", i + "");
        HttpManager.b(BluedHttpUrl.q() + "/users/avatar_map/status", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("channel", AppInfo.f9487c);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/more/android?v=2", bluedUIHttpResponse, iRequestHost).a(a2).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, LatLng latLng, LatLng latLng2, String str, String str2, LatLng latLng3, LatLng latLng4) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("a", latLng);
        b.put("b", latLng2);
        b.put("zoom_scale", str);
        b.put("avatar_span", str2);
        if (latLng3 != null) {
            b.put("self_location", latLng3);
        }
        if (latLng4 != null) {
            b.put("shadow_location", latLng4);
        }
        HttpManager.b(BluedHttpUrl.q() + "/users/avatar_map/index", bluedUIHttpResponse).a(BluedHttpTools.a(b)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", str);
        HttpManager.a(BluedHttpUrl.q() + "/blued/theme", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("channel", AppInfo.f9487c);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/more/android", bluedUIHttpResponse, iRequestHost).a(a2).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", str);
        HttpManager.b(BluedHttpUrl.q() + "/blued/theme?type=" + str2, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/photos/private/" + str2 + "?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("location", str);
        b.put("longitude", str2);
        b.put("latitude", str3);
        b.put("is_open_shadow", str4);
        HttpManager.b(BluedHttpUrl.q() + "/users/shadow?http_method_override=PUT", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, Map<String, String> map, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/setting?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        a(str, "apply", bluedUIHttpResponse, iRequestHost);
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("stage", str2);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().uid + "/privacy/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        try {
            if (StringUtils.d(str)) {
                return;
            }
            String encode = URLEncoder.encode(str);
            HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/friends/search?keywords=" + encode, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
        } catch (Exception e) {
        }
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str);
        a2.put("size", str2);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/friends", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        HttpManager.a(BluedHttpUrl.q() + "/ticktocks/users/" + str + "/timeline", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.b(BluedHttpUrl.q() + "/users/shadow?http_method_override=DELETE", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("position_code", "10002");
        HttpManager.b(BluedHttpUrl.q() + "/blued/launch/adms", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("watchword", str);
        HttpManager.b(BluedHttpUrl.q() + "/blued/watchword", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("card_name", str);
        a2.put("card_number", str2);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfoUtils.c() + "/applied/finance", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("pid", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/vip_avatar?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        if (StringUtils.d(str)) {
            return;
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("photo", str);
        a2.put("pid", str2);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/vip_avatar?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            a2.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
        }
        a2.put("req_id", ADUtils.b());
        a2.put("android_model", Build.MANUFACTURER + Build.MODEL);
        a2.put("android_version", Build.VERSION.RELEASE);
        a2.put("android_oaid", BluedDeviceIdentity.a().h());
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/visited", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/users/avatar_map/status", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/ticktocks/waterfall/classify", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("code", str);
        HttpManager.a(BluedHttpUrl.q() + "/groups/boost", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("background", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/photos/background?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void d(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/followers", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfoUtils.c() + "/applied/finance", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.r() + "/sums/android", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("code", str);
        HttpManager.b(BluedHttpUrl.q() + "/groups/boost", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void e(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/lang?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/followed", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/count/repair", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void f(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/secretly_followed", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void g(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("offset", str2);
        a2.put("size", str3);
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/blacklist", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void h(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str3);
        a2.put(ReqAckPackage.REQ_RESPONSE_KEY.NOTE, str2);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/notes", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void i(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        try {
            a2.put("current", BluedHttpTools.b(str2));
            a2.put("new", BluedHttpTools.b(str3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/password?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void j(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, Object> b = BluedHttpTools.b();
        if (!StringUtils.d(str2)) {
            b.put("pid", str2);
        }
        b.put(ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, str3);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/avatar?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }
}
