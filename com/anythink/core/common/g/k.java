package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/k.class */
public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    w f6731a;

    public k(w wVar) {
        this.f6731a = wVar;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return this.f6731a.b;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        return this.f6731a.d;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        String str = this.f6731a.f6681c;
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean o() {
        return true;
    }
}
