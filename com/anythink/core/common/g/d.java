package com.anythink.core.common.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/d.class */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6723a = "custom";
    private static final String e = d.class.getSimpleName();
    long b;

    /* renamed from: c  reason: collision with root package name */
    long f6724c;
    Map<String, Object> d = n.a().m();
    private String f;
    private String g;
    private Context h;

    public d(Context context, String str, String str2) {
        this.f = str;
        this.g = str2;
        this.h = context;
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
            if (this.d != null) {
                jSONObject.put("custom", new JSONObject(this.d));
            }
            trim = jSONObject.toString();
        } catch (Exception e2) {
        }
        com.anythink.core.common.j.c.a("app", (String) null, this.b, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.f6724c);
        return trim;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(int i, i iVar) {
        this.b = System.currentTimeMillis();
        this.f6724c = SystemClock.elapsedRealtime();
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
        return com.anythink.core.common.i.b();
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        com.anythink.core.common.j.c.a("app", adError.getPlatformCode(), adError.getPlatformMSG(), (String) null, "", "", "");
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
        } catch (Exception e2) {
            return g().getBytes();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.common.g.a
    public final JSONObject e() {
        JSONObject e2 = super.e();
        try {
            e2.put("app_id", this.f);
            e2.put("nw_ver", com.anythink.core.common.k.d.h());
            String y = n.a().y();
            if (!TextUtils.isEmpty(y)) {
                e2.put("sy_id", y);
            }
            String z = n.a().z();
            if (TextUtils.isEmpty(z)) {
                n.a().j(n.a().x());
                e2.put("bk_id", n.a().x());
            } else {
                e2.put("bk_id", z);
            }
            JSONObject b = c.b();
            if (b != null) {
                e2.put("custom", b);
            }
            if (n.a().b() != null) {
                e2.put("deny", com.anythink.core.common.k.d.o(n.a().g()));
            }
            e2.put(c.R, n.a().H() ? 1 : 2);
            if (n.a().v()) {
                e2.put("is_test", 1);
            }
            e2.put(c.ap, com.anythink.core.common.n.a().c());
            com.anythink.core.common.n.a();
            e2.put("pil_offset", com.anythink.core.common.n.b());
            return e2;
        } catch (JSONException e3) {
            return e2;
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
        } catch (JSONException e2) {
            return f;
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return this.f;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.h;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.g;
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
