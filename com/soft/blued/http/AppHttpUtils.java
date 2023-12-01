package com.soft.blued.http;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.anythink.pd.ExHandler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.statistics.BluedStatistics;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.soft.blued.tinker.util.TinkerTools;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.tencent.ugc.datereport.UGCDataReportDef;
import com.umeng.analytics.pro.bh;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/AppHttpUtils.class */
public class AppHttpUtils {
    public static void a() {
        String bB = BluedPreferences.bB();
        String str = DeviceUtils.b() + "_" + TinkerTools.a();
        if (StringUtils.d(str) || str.equalsIgnoreCase(bB)) {
            return;
        }
        BluedPreferences.O(str);
        Map a2 = BluedHttpTools.a();
        a2.put("version_code", "" + DeviceUtils.b());
        a2.put("patch_code", TinkerTools.a());
        a2.put("channel", AppInfo.c);
        a2.put("app", "1");
        try {
            BluedStatistics.c().a("PATCH_CODE", 0L, Integer.parseInt(TinkerTools.a()), a2.toString());
        } catch (Exception e) {
        }
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/qiniu?filter=token&action=videos&ops=auth", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        HttpManager.a(BluedHttpUrl.q() + "/users/terms", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        String g = DeviceUtils.g();
        if (!TextUtils.isEmpty(g)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, g);
        }
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        if (!TextUtils.isEmpty(BluedPreferences.bh())) {
            arrayMap.put(RemoteMessageConst.DEVICE_TOKEN, BluedPreferences.bh());
        }
        arrayMap.put(bh.x, "0");
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            arrayMap.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
            arrayMap.put("mac", AppInfo.e);
            arrayMap.put(ExHandler.JSON_REQUEST_IMEI, AppInfo.d);
        }
        arrayMap.put("channel", AppInfo.c);
        try {
            a2.put("_", AesCrypto.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/biotrack/a", bluedUIHttpResponse).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, boolean z, String str, String str2) {
        String str3 = BluedHttpUrl.q() + "/blued/verification";
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ops", z ? "1" : "0");
        try {
            arrayMap.put("url", URLEncoder.encode(str, "UTF-8"));
            arrayMap.put("destination", URLEncoder.encode(str2, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            arrayMap.put("url", URLEncoder.encode(str));
            arrayMap.put("destination", URLEncoder.encode(str2));
        } catch (Exception e2) {
        }
        arrayMap.put("domain", Uri.parse(str).getHost());
        HttpManager.a(HttpUtils.a(arrayMap, str3), bluedUIHttpResponse, (IRequestHost) null).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map a2 = BluedHttpTools.a();
        a2.put("plan_key", str);
        HttpManager.a(BluedHttpUrl.q() + "/blued/alink/config", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, String str2, StringHttpResponseHandler stringHttpResponseHandler) {
        int b = DeviceUtils.b();
        Map a2 = BluedHttpTools.a();
        a2.put("version_code", "" + b);
        a2.put("patch_code", str);
        a2.put("channel", str2);
        a2.put("app", "1");
        String str3 = BluedHttpUrl.q() + "/blued/patch";
        Log.i("PTH", "version_code:" + b);
        Log.i("PTH", "patch_code:" + str);
        Log.i("PTH", "channel:" + str2);
        Log.i("PTH", "url:" + str3);
        HttpManager.b(str3, stringHttpResponseHandler).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    public static String b() {
        return BluedHttpUrl.q() + "/live/setting";
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse) {
        Map a2 = BluedHttpTools.a();
        a2.put("longitude", "" + CommonPreferences.u());
        a2.put("latitude", "" + CommonPreferences.v());
        HttpManager.a(BluedHttpUrl.q() + "/blued/config", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c() {
        Map a2 = BluedHttpTools.a();
        a2.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        HttpManager.b(BluedHttpUrl.q() + "/users/call/period/push", (HttpResponseHandler) null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/config/client", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/users/ecological_officer/send_task", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }
}
