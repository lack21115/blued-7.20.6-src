package com.cmic.gen.sdk.tencent.auth;

import android.text.TextUtils;
import com.huawei.hms.ads.fw;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/auth/d.class */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_CODE, "103000");
            jSONObject.put("desc", fw.Code);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str, com.cmic.gen.sdk.tencent.a aVar, JSONObject jSONObject) {
        String str2;
        String[] strArr = {"未知", "移动", "联通", "电信"};
        try {
            String b = aVar.b("operatortype", "0");
            if (!"0".equals(b) && !TextUtils.isEmpty(b)) {
                str2 = strArr[Integer.parseInt(b)];
                jSONObject.put("operatorType", str2);
                return jSONObject;
            }
            str2 = "103000".equals(str) ? strArr[1] : strArr[0];
            jSONObject.put("operatorType", str2);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_CODE, str);
            jSONObject.put("desc", str2);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str, String str2, com.cmic.gen.sdk.tencent.a aVar, JSONObject jSONObject) {
        Object obj;
        Object obj2 = "0";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int parseInt = Integer.parseInt(aVar.b("authType", "0"));
            int c2 = aVar.c("networktype");
            if (parseInt != 3) {
                obj = "其他";
            } else if (c2 == 3) {
                obj = "WIFI下网关鉴权";
                obj2 = "1";
            } else {
                obj = "网关鉴权";
                obj2 = "2";
            }
            jSONObject2.put(ProcessBridgeProvider.KEY_RESULT_CODE, str);
            jSONObject2.put("authType", obj2);
            jSONObject2.put("authTypeDes", obj);
            if ("103000".equals(str)) {
                if (1 == aVar.c("logintype")) {
                    jSONObject2.put("openId", aVar.b("openId"));
                    jSONObject2.put(com.tencent.tendinsv.b.x, aVar.b(com.tencent.tendinsv.b.x));
                }
                jSONObject2.put("token", jSONObject.optString("token"));
                jSONObject2.put("tokenExpiresIn", jSONObject.optString("tokenExpiresIn"));
            } else {
                jSONObject2.put("desc", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.cmic.gen.sdk.tencent.e.c.b("AuthnResult", "返回参数:" + jSONObject2.toString());
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_CODE, str);
            jSONObject.put("desc", str2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
