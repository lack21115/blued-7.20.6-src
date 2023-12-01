package com.anythink.core.common.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.core.common.s;
import com.huawei.openalliance.ad.constant.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/j.class */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6729a = "sdk_custom";
    private static final String d = j.class.getSimpleName();
    long b;

    /* renamed from: c  reason: collision with root package name */
    long f6730c;
    private String e = n.a().r();
    private String f;
    private String g;
    private Context h;
    private String i;
    private String j;
    private String k;
    private Map<String, Object> l;
    private JSONObject p;
    private Map<String, Object> q;

    public j(Context context, String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2) {
        this.i = str;
        this.j = str2;
        this.h = context;
        this.g = str3;
        this.f = n.a().g(str3);
        this.k = str4;
        this.l = map;
        this.q = map2;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        String trim = str.trim();
        try {
            JSONObject jSONObject = new JSONObject(trim);
            if (this.l != null) {
                jSONObject.put(f6729a, new JSONObject(this.l));
            }
            trim = jSONObject.toString();
        } catch (Exception e) {
        }
        com.anythink.core.common.j.c.a(t.j, this.g, this.b, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.f6730c);
        return trim;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(int i, i iVar) {
        this.b = System.currentTimeMillis();
        this.f6730c = SystemClock.elapsedRealtime();
        super.a(i, iVar);
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.c();
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        com.anythink.core.common.j.c.a(t.j, adError.getPlatformCode(), adError.getPlatformMSG(), (String) null, this.g, "", "");
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        try {
            return g().getBytes("utf-8");
        } catch (Exception e) {
            return g().getBytes();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.common.g.a
    public final JSONObject e() {
        Object obj;
        JSONObject e = super.e();
        try {
            e.put("app_id", this.i);
            e.put("pl_id", this.g);
            e.put("session_id", this.f);
            e.put("nw_ver", com.anythink.core.common.k.d.h());
            e.put("exclude_myofferid", s.a().a(this.h));
            if (n.a().l() != null) {
                e.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, n.a().l());
            }
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
            JSONObject a2 = c.a(this.l);
            if (a2 != null) {
                e.put("custom", a2);
            }
            if (n.a().b() != null) {
                e.put("deny", com.anythink.core.common.k.d.o(n.a().g()));
            }
            if (n.a().v()) {
                n.a().w().fillRequestParam(e);
            }
            e.put(c.ap, com.anythink.core.common.n.a().c());
            if (this.q != null && (obj = this.q.get(ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                e.put(c.am, obj.toString());
            }
            return e;
        } catch (JSONException e2) {
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
    protected final String h() {
        return this.i;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.h;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.j;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return "1.0";
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final int m() {
        return 3;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean n() {
        return true;
    }
}
