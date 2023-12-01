package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.k;
import com.anythink.expressad.foundation.h.o;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/g.class */
public class g extends i<String> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f7889c = g.class.getSimpleName();
    private String d;

    public g(int i, String str, String str2, com.anythink.expressad.foundation.g.f.e<String> eVar) {
        super(i, str, eVar);
        this.d = str2;
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final k<String> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return k.a(new String(cVar.b, com.anythink.expressad.foundation.g.f.g.e.a(cVar.d)), cVar);
        } catch (UnsupportedEncodingException e) {
            o.d(f7889c, e.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final byte[] h() {
        try {
            if (this.d == null) {
                return null;
            }
            return this.d.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
