package com.soft.blued.http;

import android.content.Context;
import android.hardware.Camera;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.SearchIndexablesContract;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.anythink.pd.ExHandler;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.login.model.BannerADRequest;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.cdo.oaps.ad.OapsKey;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.assist.util.AssistUtils;
import com.libyuv.util.YuvUtil;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.model.App;
import com.soft.blued.model.Banner;
import com.soft.blued.model.Deals;
import com.soft.blued.model.Device;
import com.soft.blued.model.Ext;
import com.soft.blued.model.Imp;
import com.soft.blued.model.Pmp;
import com.soft.blued.model.ReachMaxRequest;
import com.soft.blued.model.Video;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.third.model.OneLoginResult;
import com.soft.blued.utils.third.model.TXOneLoginResult;
import com.tencent.ugc.datereport.UGCDataReportDef;
import com.umeng.analytics.pro.bh;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/LoginRegisterHttpUtils.class */
public class LoginRegisterHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15970a = LoginRegisterHttpUtils.class.getSimpleName();

    /* renamed from: com.soft.blued.http.LoginRegisterHttpUtils$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/LoginRegisterHttpUtils$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15971a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[PHONE_CODE_LOGIN_STAGE.values().length];
            f15971a = iArr;
            try {
                iArr[PHONE_CODE_LOGIN_STAGE.IDENTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15971a[PHONE_CODE_LOGIN_STAGE.VERIFY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15971a[PHONE_CODE_LOGIN_STAGE.IDENTIFY_UP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15971a[PHONE_CODE_LOGIN_STAGE.VERIFY_UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/LoginRegisterHttpUtils$PHONE_CODE_LOGIN_STAGE.class */
    public enum PHONE_CODE_LOGIN_STAGE {
        IDENTIFY,
        VERIFY,
        IDENTIFY_UP,
        VERIFY_UP
    }

    public static float a(float[] fArr, float f) {
        int i = 0;
        float abs = Math.abs(f - fArr[0]);
        float f2 = fArr[0];
        int length = fArr.length;
        while (i < length) {
            float f3 = fArr[i];
            float abs2 = Math.abs(f - f3);
            float f4 = abs;
            if (abs2 <= abs) {
                f2 = f3;
                f4 = abs2;
            }
            i++;
            abs = f4;
        }
        return f2;
    }

    public static void a(int i, Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put(OapsKey.KEY_SIZE, str3);
        if (i == 0) {
            a2.put("type", "recommend");
        }
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/interest", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str = BluedHttpUrl.q() + "/blued/qiniu?filter=token&action=avatar";
        if (iRequestHost != null) {
            HttpManager.a(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
        } else {
            HttpManager.a(str, bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
        }
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, String str, BluedUIHttpResponse bluedUIHttpResponse, String str2, IRequestHost iRequestHost) {
        String str3 = BluedHttpUrl.q() + "/blued/splash?exclude_id=" + str;
        String upperCase = NetworkUtils.d().toUpperCase();
        String str4 = upperCase;
        if (!upperCase.equalsIgnoreCase("2G")) {
            str4 = upperCase;
            if (!upperCase.equalsIgnoreCase("3G")) {
                str4 = upperCase;
                if (!upperCase.equalsIgnoreCase("4G")) {
                    str4 = upperCase;
                    if (!upperCase.equalsIgnoreCase("wifi")) {
                        str4 = "unknown".toUpperCase();
                    }
                }
            }
        }
        String str5 = str3 + "&conn_type=" + str4 + "&longitude=" + CommonPreferences.u() + "&latitude=" + CommonPreferences.v();
        Map a2 = BluedHttpTools.a();
        String update = !Build.MANUFACTURER.toLowerCase().equals(AssistUtils.BRAND_HW) ? YuvUtil.getUpdate() : "";
        a2.put(ExHandler.JSON_REQUEST_BOOT_MARK, "");
        a2.put(ExHandler.JSON_REQUEST_UPDATE_MARK, update);
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
        a2.put("android_model", Build.MANUFACTURER + Build.MODEL);
        a2.put("android_version", Build.VERSION.RELEASE);
        a2.put("make", Build.MANUFACTURER);
        a2.put("model", Build.MODEL);
        a2.put("req_id", str2);
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            a2.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
        }
        a2.put("android_oaid", BluedDeviceIdentity.a().h());
        a2.put(IAdInterListener.AdReqParam.WIDTH, AppInfo.l + "");
        a2.put("h", AppInfo.m + "");
        HttpManager.a(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(HttpResponseHandler<?> httpResponseHandler, String str) {
        String b = EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid);
        String str2 = UserInfo.getInstance().getLoginUserInfo().avatar;
        String str3 = UserInfo.getInstance().getLoginUserInfo().name;
        Map a2 = BluedHttpTools.a();
        a2.put("openUserId", b);
        a2.put(ContactsContract.Contacts.AggregationSuggestions.PARAMETER_MATCH_NICKNAME, str3);
        a2.put("headurl", str2);
        HttpManager.b("https://dopen.weimob.com/api/1_0/janus/core/login?accesstoken=" + str, httpResponseHandler).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(IRequestHost iRequestHost, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/passport/config", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).h();
    }

    public static void a(IRequestHost iRequestHost, PHONE_CODE_LOGIN_STAGE phone_code_login_stage, String str, String str2, String str3, String str4, BluedUIHttpResponse bluedUIHttpResponse) {
        ArrayMap arrayMap = new ArrayMap();
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str);
        arrayMap.put("type", "mobile");
        int i = AnonymousClass1.f15971a[phone_code_login_stage.ordinal()];
        arrayMap.put("stage", i != 2 ? i != 3 ? i != 4 ? "identify" : "verify-up" : "identify-up" : "verify");
        arrayMap.put("captcha", str2);
        if (!TextUtils.isEmpty(str4)) {
            arrayMap.put("rid", str4);
        }
        if (phone_code_login_stage == PHONE_CODE_LOGIN_STAGE.VERIFY) {
            arrayMap.put("authcode", str3);
        }
        arrayMap.put("channel", AppInfo.c);
        Map a2 = BluedHttpTools.a();
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/3rd/message/auth", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(StringHttpResponseHandler stringHttpResponseHandler, String str, String str2) {
        Integer[] a2 = a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Deals(str2));
        Pmp pmp = new Pmp(arrayList);
        Banner banner = new Banner(a2[1].intValue(), a2[0].intValue());
        Video video = new Video(a2[1].intValue(), a2[0].intValue());
        Imp imp = new Imp(str + System.currentTimeMillis(), pmp, "RMkaipingJT", banner, video);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(imp);
        ReachMaxRequest reachMaxRequest = new ReachMaxRequest(str, new App("Blued"), arrayList2, new Device(DeviceUtils.j(), AppInfo.d, "", BluedDeviceIdentity.a().h(), com.soft.blued.utils.NetworkUtils.b(), 1, new Ext(AppInfo.l, AppInfo.m)));
        Log.v("HttpManager", "params string:" + AppInfo.f().toJson(reachMaxRequest));
        Log.v("drb", "params string:" + AppInfo.f().toJson(reachMaxRequest));
        HttpManager.b("http://s2.reachmax.cn/core/run.php?x=blued", stringHttpResponseHandler).b(BluedHttpTools.a(true)).a(AppInfo.f().toJson(reachMaxRequest)).a(false).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(MediaStore.Video.Thumbnails.VIDEO_ID, System.currentTimeMillis() + "");
        try {
            a2.put("encrypt_data", AesCrypto.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/blued/adms/video", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, String str, IRequestHost iRequestHost) {
        String str2;
        ArrayMap arrayMap = new ArrayMap();
        if (i == 0) {
            str2 = "identify";
        } else if (i == 1) {
            String str3 = DeviceUtils.f() ? "tw_binding" : "binding";
            arrayMap.put("code", str);
            str2 = str3;
        } else {
            str2 = i == 2 ? "unbinding" : "";
        }
        arrayMap.put("stage", str2);
        HttpManager.b(BluedHttpUrl.q() + "/passport/3rd/weixin/binding", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/qiniu?filter=token&action=faceplus_face", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str) {
        Map a2 = BluedHttpTools.a();
        a2.put("images", str);
        a2.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        HttpManager.b(BluedHttpUrl.q() + "/blued/faceplus/ocidcard", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2, String str3) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("stage", str);
        arrayMap.put("mobile", str2);
        arrayMap.put("code", str3);
        arrayMap.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        HttpManager.b(BluedHttpUrl.q() + "/users/relation", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, int... iArr) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(BluedHttpUrl.q());
        sb.append("/passport/auth?http_method_override=DELETE&is_switch=");
        sb.append(iArr.length > 0 ? Integer.valueOf(iArr[0]) : "0");
        HttpManager.b(sb.toString(), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, BluedADExtra bluedADExtra) {
        Map a2 = BluedHttpTools.a();
        Gson f = AppInfo.f();
        long j = bluedADExtra.ads_id;
        try {
            a2.put("encrypt_data", AesCrypto.b(f.toJson(new BannerADRequest(1, j, System.currentTimeMillis() + "", bluedADExtra.extra_json.excitation))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.r() + "/pay/procedure/excitation_ad/video", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("code", str);
        if (i == 0) {
            arrayMap.put("stage", "verify");
        } else if (i == 1) {
            arrayMap.put("stage", "pre_verify");
        } else if (i == 2) {
            arrayMap.put("stage", "pre-up");
        } else if (i == 3) {
            arrayMap.put("stage", "pre_verify-up");
        }
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity/binding", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("stage", "send");
        arrayMap.put("captcha", str);
        arrayMap.put("confirm_identity", Integer.valueOf(i));
        arrayMap.put("email", str2);
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/safe/email", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", str);
        arrayMap.put("stage", "token_sm");
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2) {
        Integer[] a2 = a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Deals(str2));
        Pmp pmp = new Pmp(arrayList);
        Banner banner = new Banner(a2[1].intValue(), a2[0].intValue());
        Video video = new Video(a2[1].intValue(), a2[0].intValue());
        Imp imp = new Imp(str + System.currentTimeMillis(), pmp, "RMkaipingJT", banner, video);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(imp);
        ReachMaxRequest reachMaxRequest = new ReachMaxRequest(str, new App("Blued"), arrayList2, new Device(DeviceUtils.j(), AppInfo.d, "", BluedDeviceIdentity.a().h(), com.soft.blued.utils.NetworkUtils.b(), 1, new Ext(AppInfo.l, AppInfo.m)));
        Log.v("HttpManager", "params string:" + AppInfo.f().toJson(reachMaxRequest));
        Log.v("drb", "params string:" + AppInfo.f().toJson(reachMaxRequest));
        HttpManager.b("http://s2.reachmax.cn/core/run.php?x=blued", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(AppInfo.f().toJson(reachMaxRequest)).a(false).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("stage", "change_send");
        arrayMap.put("type", str);
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str2);
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/safe/email", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3) {
        Logger.c(f15970a, "UserRenew: type: " + str, " access_token: " + str2 + " uid : " + str3 + " ua : " + UserInfo.getInstance().getLoginUserInfo());
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", str);
        arrayMap.put("access_token", str2);
        arrayMap.put("uid", str3);
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        String h = DeviceUtils.h();
        if (!TextUtils.isEmpty(h)) {
            arrayMap.put("dev_id_safe", h);
        }
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        arrayMap.put("lat", CommonPreferences.v());
        arrayMap.put("lon", CommonPreferences.u());
        arrayMap.put("mac", AppInfo.e);
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, AppInfo.d);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/renew", bluedUIHttpResponse, (IRequestHost) null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("stage", str);
        a2.put("code", str2);
        a2.put("id", str3);
        if (!"close".equals(str)) {
            String h = DeviceUtils.h();
            if (!TextUtils.isEmpty(h)) {
                a2.put("dev_id_safe", h);
            }
        }
        HttpManager.b(BluedHttpUrl.q() + "/users/device_safe", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost, String str4, String str5, String str6, boolean z) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", str);
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str2);
        arrayMap.put("password", str3);
        arrayMap.put("login_token", UserInfo.getInstance().getAccessToken());
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        String h = DeviceUtils.h();
        if (!TextUtils.isEmpty(h)) {
            arrayMap.put("dev_id_safe", h);
        }
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        arrayMap.put("lat", CommonPreferences.v());
        arrayMap.put("lon", CommonPreferences.u());
        arrayMap.put("token", str4);
        arrayMap.put("captcha", str5);
        if (!TextUtils.isEmpty(str6)) {
            arrayMap.put("rid", str6);
        }
        arrayMap.put("mac", AppInfo.e);
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, AppInfo.d);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        if (z) {
            arrayMap.put("from", "auto");
        } else {
            arrayMap.put("from", Camera.Parameters.FOCUS_MODE_MANUAL_POSITION);
        }
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/auth", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, int i, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str);
        arrayMap.put("type", str2);
        if (i == 0) {
            arrayMap.put("stage", "identify");
        } else if (i == 1) {
            arrayMap.put("stage", "pre");
        } else if (i == 2) {
            arrayMap.put("stage", "pre-up");
        } else if (i == 3) {
            arrayMap.put("stage", "pre_verify-up");
        }
        arrayMap.put("confirm_identity", str3);
        try {
            arrayMap.put("password", BluedHttpTools.b(str4));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity/binding", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", str);
        arrayMap.put("stage", str2);
        arrayMap.put("authcode", str3);
        arrayMap.put("type", str4);
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/safe/device", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, String str6, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str);
        arrayMap.put("token", str2);
        arrayMap.put("captcha", str3);
        arrayMap.put("type", str4);
        arrayMap.put("stage", str5);
        arrayMap.put("rid", str6);
        arrayMap.put("confirm_identity", str5);
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", str);
        arrayMap.put("password", str3);
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        arrayMap.put("name", str2);
        arrayMap.put("height", str4);
        arrayMap.put("weight", str5);
        arrayMap.put("role", str6);
        arrayMap.put("birthday", str7);
        arrayMap.put("city_settled", BluedPreferences.o());
        arrayMap.put("ethnicity", str8);
        arrayMap.put("lat", CommonPreferences.v());
        arrayMap.put("lon", CommonPreferences.u());
        arrayMap.put("no_height_weight", i + "");
        arrayMap.put("health_test_result", str9);
        arrayMap.put("health_test_time", str10);
        arrayMap.put("health_prpe_use_situation", str11);
        arrayMap.put("mac", AppInfo.e);
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, AppInfo.d);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        arrayMap.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
        arrayMap.put("bddid", ByteDanceLogUtils.a());
        Logger.b(f15970a, "mac,imei,channel==", AppInfo.e, ",", AppInfo.d, ",", AppInfo.c);
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/binding", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, boolean z) {
        String str5;
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        if (TextUtils.equals(str4, "weixin")) {
            if (TextUtils.isEmpty(str3)) {
                arrayMap.put("access_token", str);
                arrayMap.put(SearchIndexablesContract.RawData.COLUMN_USER_ID, str2);
            } else {
                arrayMap.put("code", str3);
            }
            str5 = BluedHttpUrl.q() + "/passport/3rd/weixin/auth";
        } else {
            str5 = "";
        }
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        arrayMap.put("mac", AppInfo.e);
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, AppInfo.d);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        if (z) {
            arrayMap.put("from", "auto");
        } else {
            arrayMap.put("from", Camera.Parameters.FOCUS_MODE_MANUAL_POSITION);
        }
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(str5, bluedUIHttpResponse).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public static void a(OneLoginResult oneLoginResult, IRequestHost iRequestHost, BluedUIHttpResponse bluedUIHttpResponse) {
        ArrayMap arrayMap = new ArrayMap();
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("token", oneLoginResult.token);
        arrayMap.put(CrashHianalyticsData.PROCESS_ID, oneLoginResult.process_id);
        arrayMap.put("authcode", oneLoginResult.authcode);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("phone", oneLoginResult.security_phone);
        arrayMap.put("channel", AppInfo.c);
        Map a2 = BluedHttpTools.a();
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/3rd/oneclick/auth", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(TXOneLoginResult tXOneLoginResult, IRequestHost iRequestHost, BluedUIHttpResponse bluedUIHttpResponse) {
        ArrayMap arrayMap = new ArrayMap();
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("token", tXOneLoginResult.getToken());
        arrayMap.put("app_id", BluedApplicationLike.TX_LOGIN_APPKEY);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("phone", tXOneLoginResult.getNumber());
        Map a2 = BluedHttpTools.a();
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/3rd/oneclick/auth_tencent", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str) {
        b(str, "reg");
    }

    public static void a(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("openUserId", str);
        HttpManager.b("https://dopen.weimob.com/api/1_0/janus/core/logout?accesstoken=" + str2).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("yz_open_id", str2);
        arrayMap.put("blued_encode_uid", str);
        HttpManager.b(BluedHttpUrl.o() + "/yz/register", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static Integer[] a() {
        ArrayMap arrayMap = new ArrayMap();
        Float valueOf = Float.valueOf(2.0f);
        arrayMap.put(valueOf, new Integer[]{2436, 1124});
        arrayMap.put(valueOf, new Integer[]{2265, 1080});
        arrayMap.put(valueOf, new Integer[]{2160, 1080});
        Float valueOf2 = Float.valueOf(1.0f);
        arrayMap.put(valueOf2, new Integer[]{2208, 1242});
        arrayMap.put(valueOf2, new Integer[]{1334, 750});
        arrayMap.put(valueOf2, new Integer[]{1136, 640});
        arrayMap.put(valueOf2, new Integer[]{960, 640});
        float a2 = a(new float[]{2.0f, 2.0f, 2.0f, 1.0f, 1.0f, 1.0f, 1.0f}, AppInfo.m / AppInfo.l);
        Log.v("drb", "----scale:" + a2);
        return (Integer[]) arrayMap.get(Float.valueOf(a2));
    }

    public static void b() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, AppInfo.d);
        arrayMap.put("channel", AppInfo.c);
        HttpManager.b(BluedHttpUrl.q() + "/blued/device/upload").b(BluedHttpTools.a(true)).a(BluedHttpTools.a(arrayMap)).h();
    }

    public static void b(HttpResponseHandler<?> httpResponseHandler, String str) {
        String b = EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid);
        Map a2 = BluedHttpTools.a();
        a2.put("source", "10");
        a2.put("sourceAppid", "D3C7E07F9568346DD574079B635386B7");
        a2.put("sourceOpenid", b);
        HttpManager.b("https://dopen.weimob.com/api/1_0/uc/user/getSuperWidBySource?accesstoken=" + str, httpResponseHandler).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/passport/logout", bluedUIHttpResponse, (IRequestHost) null).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, int i, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        if (i == 1) {
            arrayMap.put("stage", "change_verify");
        } else {
            arrayMap.put("stage", "verify");
        }
        arrayMap.put("code", str);
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/safe/email", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/qiniu?filter=token&action=faceplus_ocidcard", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str) {
        Map a2 = BluedHttpTools.a();
        a2.put("images", str);
        a2.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        HttpManager.b(BluedHttpUrl.q() + "/blued/faceplus/baidu", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/setting?type=inform", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", str);
        arrayMap.put("name", str2);
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/name", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", str);
        arrayMap.put("type", str2);
        try {
            arrayMap.put("password", BluedHttpTools.b(str3));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        arrayMap.put("stage", "reset");
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", str);
        arrayMap.put("code", str2);
        arrayMap.put("captcha", str3);
        arrayMap.put("type", str4);
        arrayMap.put("stage", "verify");
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        arrayMap.put("oaid", BluedDeviceIdentity.a().h());
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public static void b(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        arrayMap.put("mac", AppInfo.e);
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, AppInfo.d);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("event", str);
        arrayMap.put("type", str2);
        try {
            a2.put("_", AesCrypto.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/biotrack/e", (HttpResponseHandler) null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/health_info", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("stage", "transfer");
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity/binding", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/groups/users/" + str + "/setting", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("stage", "captcha");
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/safe/email", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }
}
