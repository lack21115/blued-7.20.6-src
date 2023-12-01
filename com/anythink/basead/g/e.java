package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.k;
import com.anythink.core.common.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/g/e.class */
public class e extends com.anythink.core.common.g.a {
    private static String f = e.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    int f6010a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    aa f6011c;
    Map<String, Object> d;
    boolean e = false;

    public e(int i, String str, aa aaVar, Map<String, Object> map) {
        this.f6010a = i;
        this.b = str;
        this.f6011c = aaVar;
        this.d = map;
    }

    private void p() {
        String jSONObject;
        try {
            jSONObject = new JSONObject(c()).toString();
        } catch (Throwable th) {
            jSONObject = new JSONObject().toString();
        }
        t.a().a(this.o, jSONObject, this.f6011c.O());
    }

    @Override // com.anythink.core.common.g.a
    public final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a
    public final Object a(String str) {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(AdError adError) {
    }

    public final void a(boolean z) {
        this.e = z;
    }

    @Override // com.anythink.core.common.g.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    public final String b() {
        if (this.d != null && !TextUtils.isEmpty(this.b)) {
            try {
                for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                    String key = entry.getKey();
                    String str = this.b;
                    this.b = str.replaceAll("\\{" + key + "\\}", (String) entry.getValue());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    @Override // com.anythink.core.common.g.a
    public final void b(int i) {
        String jSONObject;
        if (this.e) {
            new StringBuilder("handleErrorStatusCode, start to check, url: ").append(this.b);
            t.a();
            if (t.a(i)) {
                try {
                    jSONObject = new JSONObject(c()).toString();
                } catch (Throwable th) {
                    jSONObject = new JSONObject().toString();
                }
                t.a().a(this.o, jSONObject, this.f6011c.O());
            }
        }
    }

    @Override // com.anythink.core.common.g.a
    public final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, String> c() {
        if (this.f6011c != null) {
            HashMap hashMap = new HashMap();
            k k = this.f6011c.k();
            if (k != null && com.anythink.basead.a.b.a(this.f6010a, k)) {
                String i = com.anythink.core.common.k.d.i();
                if (!TextUtils.isEmpty(i)) {
                    hashMap.put("User-Agent", i);
                }
            }
            return hashMap;
        }
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final byte[] d() {
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
