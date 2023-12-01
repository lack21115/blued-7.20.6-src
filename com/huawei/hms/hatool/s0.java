package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/s0.class */
public class s0 {
    public static void a(String str, String str2) {
        c0 c0Var;
        String str3;
        String replace = "{url}/getPublicKey?keytype=2".replace("{url}", c.f(str, str2));
        String f = b.f();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", f);
        try {
            c0Var = b0.a(replace, new byte[0], hashMap);
        } catch (Exception e) {
            z.e("GetPublicKey", "get pubKey response Exception :" + e.getMessage());
            c0Var = null;
        }
        if (c0Var == null) {
            str3 = "get pubKey response is null";
        } else if (c0Var.b() == 200) {
            if (TextUtils.isEmpty(c0Var.a())) {
                return;
            }
            c(c0Var.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + c0Var.b();
        }
        z.e("GetPublicKey", str3);
    }

    public static boolean a() {
        String a2 = b.a();
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = h0.a(b.i(), "Privacy_MY", "public_key_time_interval", "");
            b.f(str);
        }
        String m = b.m();
        String str2 = m;
        if (TextUtils.isEmpty(m)) {
            str2 = h0.a(b.i(), "Privacy_MY", "public_key_time_last", "");
            b.c(str2);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        try {
            return System.currentTimeMillis() - Long.parseLong(str2) > ((long) Integer.parseInt(str));
        } catch (NumberFormatException e) {
            z.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e.getMessage());
            return true;
        }
    }

    public static String b(String str, String str2) {
        String str3;
        String c2 = b.c();
        String str4 = c2;
        if (TextUtils.isEmpty(c2)) {
            str4 = h0.a(b.i(), "Privacy_MY", "public_key_version", "");
            b.g(str4);
        }
        if ("maint".equals(str2)) {
            String n = b.n();
            str3 = n;
            if (TextUtils.isEmpty(n)) {
                str3 = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", h0.a(b.i(), "Privacy_MY", "public_key_maint", ""));
                b.d(str3);
            }
        } else {
            String o = b.o();
            str3 = o;
            if (TextUtils.isEmpty(o)) {
                str3 = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", h0.a(b.i(), "Privacy_MY", "public_key_oper", ""));
                b.e(str3);
            }
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || a()) {
            p0.a().a(new n0(str, str2));
            return null;
        }
        return str3;
    }

    public static void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString("timeInterval");
            h0.b(b.i(), "Privacy_MY", "public_key_oper", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString));
            h0.b(b.i(), "Privacy_MY", "public_key_maint", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            h0.b(b.i(), "Privacy_MY", "public_key_time_interval", optString4);
            h0.b(b.i(), "Privacy_MY", "public_key_version", optString3);
            h0.b(b.i(), "Privacy_MY", "public_key_time_last", str3);
            b.e(optString);
            b.d(optString2);
            b.g(optString3);
            b.c(str3);
            b.f(optString4);
        } catch (JSONException e) {
            z.e("GetPublicKey", "get pubKey parse json JSONException :" + e.getMessage());
        }
    }
}
