package com.soft.blued.http;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.NetworkUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.welcome.model.ADClickCoordinate;
import com.soft.blued.utils.StringUtils;
import java.net.URLDecoder;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/FindHttpUtils.class */
public class FindHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f29656a = FindHttpUtils.class.getSimpleName();

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/tags", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lot", CommonPreferences.u());
        a2.put("lat", CommonPreferences.v());
        a2.put(RemoteMessageConst.MessageBody.PARAM, "text");
        HttpManager.a(BluedHttpUrl.q() + "/users/chatroom/nearby/num", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/notification/count", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("latitude", CommonPreferences.v());
        a2.put("longitude", CommonPreferences.u());
        a2.put("source", str);
        HttpManager.a(BluedHttpUrl.q() + "/users/guess-like/push", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("from", i + "");
        HttpManager.a(BluedHttpUrl.q() + "/users/map/pass/by/status", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, int i, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        a2.put("is_switch_open", String.valueOf(i));
        a2.put("filters", str2);
        HttpManager.a(BluedHttpUrl.q() + "/users/map/pass/by/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("filter", str);
        arrayMap.put("max_id", str2);
        HttpManager.b(HttpUtils.a(arrayMap, BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/notification?http_method_override=DELETE"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("filter", str);
        arrayMap.put(WBPageConstants.ParamKey.PAGE, i + "");
        arrayMap.put("size", i2 + "");
        HttpManager.a(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/notification", bluedUIHttpResponse, iRequestHost).a(arrayMap).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/notification/count?filter=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("filter", str);
        arrayMap.put("max_id", str2);
        HttpManager.b(HttpUtils.a(arrayMap, BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/notification/count"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str) {
        a(str, (ADClickCoordinate) null);
    }

    public static void a(String str, int i, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("url", str);
        a2.put("http_code", i + "");
        a2.put("other", "http_message:" + str2 + "  v:" + AppInfo.h);
        a2.put("platform", "android");
        HttpManager.b(BluedHttpUrl.q() + "/blued/adms/status").a(a2).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, ADClickCoordinate aDClickCoordinate) {
        if (StringUtils.d(str)) {
            return;
        }
        String str2 = str;
        if (str.contains("__CONN_TYPE__")) {
            str2 = str.replace("__CONN_TYPE__", NetworkUtils.d());
        }
        String str3 = str2;
        if (str2.contains("__RESPONSE_TIME__")) {
            str3 = str2.replace("__RESPONSE_TIME__", System.currentTimeMillis() + "");
        }
        String str4 = str3;
        if (aDClickCoordinate != null) {
            String str5 = str3;
            if (str3.contains("__DOWN_X__")) {
                str5 = str3;
                if (!TextUtils.isEmpty(aDClickCoordinate.down_x)) {
                    str5 = str3.replace("__DOWN_X__", aDClickCoordinate.down_x);
                }
            }
            String str6 = str5;
            if (str5.contains("__DOWN_Y__")) {
                str6 = str5;
                if (!TextUtils.isEmpty(aDClickCoordinate.down_y)) {
                    str6 = str5.replace("__DOWN_Y__", aDClickCoordinate.down_y);
                }
            }
            String str7 = str6;
            if (str6.contains("__UP_X__")) {
                str7 = str6;
                if (!TextUtils.isEmpty(aDClickCoordinate.up_x)) {
                    str7 = str6.replace("__UP_X__", aDClickCoordinate.up_x);
                }
            }
            str4 = str7;
            if (str7.contains("__UP_Y__")) {
                str4 = str7;
                if (!TextUtils.isEmpty(aDClickCoordinate.up_y)) {
                    str4 = str7.replace("__UP_Y__", aDClickCoordinate.up_y);
                }
            }
        }
        try {
            Log.v("drb", "postSplashUrl decode:" + URLDecoder.decode(str4, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        final String str8 = str4;
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse() { // from class: com.soft.blued.http.FindHttpUtils.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str9) {
                Log.v("drb", "onUIFailure:" + i + " -- errorMessage" + str9 + " -- url:" + String.this);
                FindHttpUtils.a(String.this, i, str9);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        };
        if (UserInfo.getInstance().isLogin()) {
            HttpManager.a(str4, bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
        } else {
            HttpManager.a(str4, bluedUIHttpResponse).b(BluedHttpTools.a(false)).h();
        }
    }

    public static void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            b(strArr[i2]);
            i = i2 + 1;
        }
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/recommend", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("uid", str);
        HttpManager.a(BluedHttpUrl.q() + "/users/call/bubble", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lot", str);
        a2.put("lat", str2);
        HttpManager.a(BluedHttpUrl.q() + "/blued/city_code", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(String str) {
        if (StringUtils.d(str)) {
            return;
        }
        if (UserInfo.getInstance().isLogin()) {
            HttpManager.b(str).b(BluedHttpTools.a(true)).h();
        } else {
            HttpManager.b(str).b(BluedHttpTools.a(false)).h();
        }
    }

    public static void b(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            a(strArr[i2]);
            i = i2 + 1;
        }
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/call/state", bluedUIHttpResponse, iRequestHost).b("detail", "1").b(BluedHttpTools.a(true)).h();
    }
}
