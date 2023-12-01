package com.zx.a.I8b7;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import com.umeng.analytics.pro.bh;
import com.youzan.androidsdk.tool.AppSigning;
import com.zx.a.I8b7.b1;
import com.zx.a.I8b7.u1;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/z.class */
public class z extends e {
    public static void b() throws Exception {
        String str;
        b1.a aVar = new b1.a();
        HashMap<String, String> b = a0.b(e.a());
        aVar.f42107c.clear();
        aVar.f42107c.putAll(b);
        b1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/module/getCoreModule");
        a2.b = "POST";
        n0 b2 = n0.b("application/json; charset=utf-8");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lid", t2.a(t2.h));
        jSONObject2.put(bh.al, t2.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put("sdkInfo", a0.d());
        a2.d = d1.a(b2, new String(Base64.encode(k.a(jSONObject.toString(), e.f42118a, "UDID_ENC_AUTHTAG"), 2), StandardCharsets.UTF_8));
        a2.e = "request getCoreModule api";
        w1 w1Var = a0.f42098a;
        b1 b1Var = new b1(aVar);
        w1Var.getClass();
        e1 a3 = new u0(w1Var, b1Var).a();
        if (a3.b != 200) {
            String a4 = a3.a("Udid-Error-Code");
            String a5 = a3.a("Udid-Error-Message");
            throw new RuntimeException("response errCode: " + a4 + ", errMsg: " + a5);
        }
        JSONObject jSONObject3 = new JSONObject(k.a(Base64.decode(new JSONObject(a3.e.b()).getString("data"), 2), e.f42118a, "UDID_ENC_AUTHTAG"));
        if (!jSONObject3.getBoolean("enable")) {
            b3 b3Var = u1.a.f42208a.f42207a;
            if (b3Var.b == null) {
                b3Var.b = b3Var.d();
            }
            try {
                SQLiteDatabase sQLiteDatabase = b3Var.b;
                sQLiteDatabase.delete("zx_table", "key in(17,18)", null);
                t2.C = null;
                z1.a("clearCoreModule success");
            } catch (Exception e) {
                StringBuilder a6 = m2.a("clearCoreModule error:");
                a6.append(e.getMessage());
                z1.b(a6.toString());
            }
            z1.a("coreModule enable is false");
            return;
        }
        JSONObject jSONObject4 = jSONObject3.getJSONObject(bh.e);
        jSONObject4.getString("version");
        String string = jSONObject4.getString("checksum");
        byte[] decode = Base64.decode(jSONObject4.getString("data"), 0);
        if (!TextUtils.equals(string, k.a(k.a(AppSigning.SHA256, decode)))) {
            throw new IOException("zx checksum1 exception");
        }
        z1.a("verify checksum finished");
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("mainVersion", t2.b);
        jSONObject5.put("coreVersion", t2.d);
        jSONObject5.put("checksum", string);
        u1.a.f42208a.f42207a.getClass();
        String string2 = jSONObject5.getString("coreVersion");
        try {
            str = t2.C.getString("coreVersion");
        } catch (Exception e2) {
            str = "";
        }
        if (!TextUtils.isEmpty(string2) && !TextUtils.equals(string2, str)) {
            b3 b3Var2 = u1.a.f42208a.f42207a;
            if (b3Var2.b == null) {
                b3Var2.b = b3Var2.d();
            }
            try {
                String str2 = new String(Base64.encode(k.b(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, t2.s, t2.t, decode), 0), StandardCharsets.UTF_8);
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", (Integer) 17);
                contentValues.put("value", str2);
                long replace = b3Var2.b.replace("zx_table", null, contentValues);
                z1.a("replace resultId = " + replace);
            } catch (Exception e3) {
                z1.b("ZXID updateDBValue valueID:17,value:" + decode + ",error:" + e3.toString());
            }
            u1.a.f42208a.f42207a.a(18, jSONObject5.toString(), true);
            t2.C = jSONObject5;
        }
        z1.a("decrypt and checksum finished");
    }
}
