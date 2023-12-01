package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.k;
import com.anythink.expressad.foundation.h.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/c.class */
public class c extends e<JSONArray> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f5045c = c.class.getSimpleName();

    public c(int i, String str, String str2, com.anythink.expressad.foundation.g.f.e<JSONArray> eVar) {
        super(i, str, str2, eVar);
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final k<JSONArray> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return k.a(new JSONArray(new String(cVar.b, com.anythink.expressad.foundation.g.f.g.e.a(cVar.d))), cVar);
        } catch (UnsupportedEncodingException e) {
            o.d(f5045c, e.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        } catch (JSONException e2) {
            o.d(f5045c, e2.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }
}
