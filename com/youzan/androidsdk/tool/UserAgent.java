package com.youzan.androidsdk.tool;

import android.content.Context;
import android.os.Build;
import com.anythink.expressad.d.a.b;
import com.youzan.androidsdk.CheckCallback;
import com.youzan.androidsdk.LoginCallback;
import com.youzan.androidsdk.YouzanLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/UserAgent.class */
public final class UserAgent {
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    public static String appClintId;
    public static String clintId;
    public static String httpUA;

    public static String buildYouzanHttpUA(Context context, String str) {
        String format = String.format("Dalvik/%s (%s; %s %s; %s Build/%s; %s)", System.getProperty("java.vm.version"), "Linux", "Android", Build.VERSION.RELEASE, Build.MODEL, Build.DISPLAY, Environment.m9190(context));
        return format + " " + str;
    }

    public static void checkCertification(String str, String str2, String str3, String str4, boolean z, final CheckCallback checkCallback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody build = new FormBody.Builder().add("client_id", str).add("type", "1").add("security_code", str4).add("unique_key", str2).add("extra_code", str3).build();
        okHttpClient.newCall(z ? new Request.Builder().url("https://open-pre.youzanyun.com/api/auth_exempt/youzan.cloud.secutity.code.query/1.0.0").post(build).build() : new Request.Builder().url("https://open.youzanyun.com/api/auth_exempt/youzan.cloud.secutity.code.query/1.0.0").post(build).build()).enqueue(new Callback() { // from class: com.youzan.androidsdk.tool.UserAgent.2
            public final void onFailure(Call call, IOException iOException) {
                CheckCallback.this.checkBack(0, null);
                YouzanLog.e("❌❌❌❌❌❌" + iOException.getMessage());
            }

            public final void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                YouzanLog.e("✅✅✅  ----" + string);
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.optJSONObject("data") == null) {
                        CheckCallback.this.checkBack(0, null);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject.optJSONArray("domain_name_list") == null) {
                        CheckCallback.this.checkBack(1, null);
                        return;
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("domain_name_list");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= optJSONArray.length()) {
                                break;
                            }
                            arrayList.add(optJSONArray.getString(i2));
                            i = i2 + 1;
                        }
                    }
                    CheckCallback.this.checkBack(1, arrayList);
                } catch (JSONException e) {
                    CheckCallback.this.checkBack(0, null);
                    e.printStackTrace();
                }
            }
        });
    }

    public static void login(boolean z, Map<String, String> map, final LoginCallback loginCallback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        map.put(b.d, AESUtils.encoder(map));
        String mapToJson = JsonUtil.mapToJson(map);
        try {
            mapToJson = Base64.encode(mapToJson.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        FormBody build = new FormBody.Builder().add("user_info", mapToJson).build();
        okHttpClient.newCall(z ? new Request.Builder().url("https://open-pre.youzanyun.com/api/auth_exempt/youzan.cloud.app.shop.apply.login/1.0.0").post(build).build() : new Request.Builder().url("https://open.youzanyun.com/api/auth_exempt/youzan.cloud.app.shop.apply.login/1.0.0").post(build).build()).enqueue(new Callback() { // from class: com.youzan.androidsdk.tool.UserAgent.1
            public final void onFailure(Call call, IOException iOException) {
                LoginCallback.this.loginBack(iOException.getMessage());
                YouzanLog.e("❌❌❌❌❌❌" + iOException.getMessage());
            }

            public final void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                YouzanLog.e("✅✅✅  ----" + string);
                LoginCallback.this.loginBack(string);
            }
        });
    }

    public static void setupUA(Context context, String str, boolean z) {
        if (str != null) {
            appClintId = str;
            String str2 = str;
            if (z) {
                str2 = str;
                if (!str.toLowerCase().startsWith("kdtUnion_".toLowerCase())) {
                    str2 = "kdtUnion_" + str;
                }
            }
            clintId = str2;
            httpUA = buildYouzanHttpUA(context, str2);
        }
    }
}
