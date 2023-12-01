package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.k;
import com.anythink.expressad.foundation.h.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/d.class */
public class d extends e<JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f7886c = d.class.getSimpleName();

    public d(int i, String str, String str2, com.anythink.expressad.foundation.g.f.e<JSONObject> eVar) {
        super(i, str, str2, eVar);
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final k<JSONObject> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return cVar.f7899a == 204 ? k.a(new JSONObject(), cVar) : k.a(new JSONObject(new String(cVar.b, com.anythink.expressad.foundation.g.f.g.e.a(cVar.d))), cVar);
        } catch (UnsupportedEncodingException e) {
            o.d(f7886c, e.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        } catch (JSONException e2) {
            o.d(f7886c, e2.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }
}
