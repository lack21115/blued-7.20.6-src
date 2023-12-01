package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.g.g;
import com.anythink.core.common.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/g/d.class */
public final class d extends com.anythink.core.common.g.a {

    /* renamed from: a  reason: collision with root package name */
    String f6008a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f6009c;
    int d;
    int e;
    int f;
    int g;
    String[] h;
    int i;
    int j;
    String k;
    String l = "OnlineOfferLoader";

    public d(j jVar, int i, int i2, String[] strArr, String str) {
        this.f6008a = jVar.d;
        this.b = jVar.b;
        this.f6009c = jVar.f6664c;
        this.i = jVar.e;
        this.f = i;
        this.g = i2;
        this.h = strArr;
        this.d = jVar.h;
        this.e = jVar.i;
        this.j = jVar.j;
        this.k = str;
    }

    @Override // com.anythink.core.common.g.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final Object a(String str) {
        return str;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(int i, Object obj) {
        if (obj == null) {
            a(i, g.j, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", ""));
            return;
        }
        try {
            if (TextUtils.isEmpty(new JSONObject(obj.toString()).optString("data"))) {
                a(i, g.k, obj.toString(), ErrorCode.getErrorCode(ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i, obj);
            }
        } catch (Throwable th) {
            a(i, -99999, obj != null ? obj.toString() : th.getMessage(), ErrorCode.getErrorCode(ErrorCode.noADError, "", obj != null ? obj.toString() : "Online Api Service Error."));
        }
    }

    @Override // com.anythink.core.common.g.a
    public final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    public final String b() {
        i.a();
        return i.h();
    }

    @Override // com.anythink.core.common.g.a
    public final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    public final byte[] d() {
        try {
            return g().getBytes("utf-8");
        } catch (Exception e) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.g.a
    public final JSONObject e() {
        JSONObject e = super.e();
        try {
            e.put("app_id", n.a().p());
            e.put("pl_id", this.b);
            e.put("session_id", n.a().g(this.b));
            e.put("t_g_id", this.d);
            e.put("gro_id", this.e);
            String y = n.a().y();
            if (!TextUtils.isEmpty(y)) {
                e.put("sy_id", y);
            }
            String z = n.a().z();
            if (TextUtils.isEmpty(z)) {
                n.a().j(n.a().x());
                e.put("bk_id", n.a().x());
            } else {
                e.put("bk_id", z);
            }
            if (n.a().b() != null) {
                e.put("deny", com.anythink.core.common.k.d.o(n.a().g()));
            }
            e.put(com.anythink.core.common.g.c.ap, com.anythink.core.common.n.a().c());
            JSONObject a2 = com.anythink.core.common.g.c.a(this.b);
            if (a2 != null) {
                e.put("customs", a2);
            }
            com.anythink.core.common.g.c.a(e);
            return e;
        } catch (Exception e2) {
            return e;
        }
    }

    @Override // com.anythink.core.common.g.a
    public final JSONObject f() {
        JSONObject f = super.f();
        try {
            if (n.a().b() != null) {
                f.put("btts", com.anythink.core.common.k.d.g());
            }
            return f;
        } catch (JSONException e) {
            return f;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.anythink.core.common.g.a
    public final String g() {
        boolean z;
        HashMap hashMap = new HashMap();
        String a2 = com.anythink.core.common.k.c.a(e().toString());
        String a3 = com.anythink.core.common.k.c.a(f().toString());
        hashMap.put("p", a2);
        hashMap.put(com.anythink.core.common.g.c.X, a3);
        hashMap.put("request_id", this.f6008a);
        hashMap.put("ad_source_id", Integer.valueOf(Integer.parseInt(this.f6009c)));
        hashMap.put(com.anythink.expressad.a.g, Integer.valueOf(this.i));
        String[] strArr = this.h;
        if (strArr != null && strArr.length > 0) {
            JSONArray jSONArray = new JSONArray();
            String[] strArr2 = this.h;
            int length = strArr2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                jSONArray.put(strArr2[i2]);
                i = i2 + 1;
            }
            hashMap.put("exclude_offers", jSONArray);
        }
        if (n.a().l() != null) {
            hashMap.put(com.anythink.core.b.a.a.f6343c, com.anythink.core.common.k.c.a(n.a().l().toString()));
        }
        int i3 = this.f;
        if (i3 > 0 && this.g > 0) {
            hashMap.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, Integer.valueOf(i3));
            hashMap.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, Integer.valueOf(this.g));
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        try {
            String valueOf = String.valueOf(this.j);
            switch (valueOf.hashCode()) {
                case 49:
                    if (valueOf.equals("1")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 50:
                    if (valueOf.equals("2")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 51:
                    if (valueOf.equals("3")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 52:
                    if (valueOf.equals("4")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z || z || z || z) {
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY));
            }
        } catch (Throwable th) {
        }
        return jSONObject.toString();
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

    @Override // com.anythink.core.common.g.a
    public final int m() {
        return 2;
    }
}
