package com.anythink.basead.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.o;
import com.anythink.core.common.e.s;
import com.anythink.core.common.u;
import com.efs.sdk.base.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/g/b.class */
public final class b extends com.anythink.core.common.g.a {
    String a;
    JSONObject b;

    public b(int i, s sVar, String str) {
        String str2 = "";
        try {
            switch (i) {
                case 1:
                    str2 = sVar.Q();
                    break;
                case 2:
                    str2 = sVar.R();
                    break;
                case 3:
                    str2 = sVar.S();
                    break;
                case 4:
                    str2 = sVar.T();
                    break;
                case 5:
                    str2 = sVar.U();
                    break;
                case 6:
                    str2 = sVar.V();
                    break;
                case 7:
                    str2 = sVar.W();
                    break;
                case 8:
                    str2 = sVar.X();
                    break;
                case 9:
                    str2 = sVar.Y();
                    break;
            }
            Uri parse = Uri.parse(sVar.R(str2));
            this.a = parse.getScheme() + "://" + parse.getAuthority() + parse.getPath();
            this.b = new JSONObject();
            for (String str3 : parse.getQueryParameterNames()) {
                this.b.put(str3, URLEncoder.encode(parse.getQueryParameter(str3)));
            }
            this.b.put("req_id", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.g.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final Object a(String str) {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> c = c();
        if (c != null) {
            try {
                for (String str : c.keySet()) {
                    jSONObject.put(str, c.get(str));
                }
            } catch (Exception e) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        JSONObject jSONObject3 = this.b;
        u.a().a(1, b(), jSONObject2, jSONObject3 != null ? jSONObject3.toString() : "", o.a(1000));
        com.anythink.core.common.j.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), this.a, "", "1", "");
    }

    @Override // com.anythink.core.common.g.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    public final String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.g.a
    public final void b(AdError adError) {
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b.put("scenario", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", Constants.CP_GZIP);
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    public final byte[] d() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            try {
                jSONObject.put("t", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
            }
            return c(this.b.toString());
        }
        return new byte[0];
    }

    @Override // com.anythink.core.common.g.a
    public final String g() {
        return "";
    }

    @Override // com.anythink.core.common.g.a
    public final String h() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final String j() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final String k() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, Object> l() {
        return null;
    }
}
