package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.c.k;
import com.anythink.core.common.e.j;
import com.anythink.core.common.g.g;
import com.anythink.core.common.i;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/g/a.class */
public final class a extends com.anythink.core.common.g.a {
    String a;
    String b;
    String c;
    int d;
    int e;
    String f;
    String g;

    public a(j jVar) {
        this.a = jVar.a;
        this.b = jVar.d;
        this.c = jVar.b;
        this.d = jVar.h;
        this.e = jVar.i;
        this.f = jVar.k;
        this.g = jVar.l;
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
                a(i, g.k, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i, obj);
            }
        } catch (Throwable th) {
            a(i, g.l, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", obj != null ? obj.toString() : "Adx Service Error."));
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
        if (TextUtils.isEmpty(this.g)) {
            i.a();
            return i.f();
        }
        return this.g;
    }

    @Override // com.anythink.core.common.g.a
    public final void b(AdError adError) {
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
            e.put("pl_id", this.c);
            e.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, n.a().g(this.c));
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
            JSONObject a = com.anythink.core.common.g.c.a(this.c);
            if (a != null) {
                e.put("customs", a);
            }
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

    @Override // com.anythink.core.common.g.a
    public final String g() {
        HashMap hashMap = new HashMap();
        String a = com.anythink.core.common.k.c.a(e().toString());
        String a2 = com.anythink.core.common.k.c.a(f().toString());
        hashMap.put(com.anythink.core.common.g.c.W, a);
        hashMap.put(com.anythink.core.common.g.c.X, a2);
        hashMap.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.b);
        hashMap.put(k.a.b, this.a);
        return new JSONObject(hashMap).toString();
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
