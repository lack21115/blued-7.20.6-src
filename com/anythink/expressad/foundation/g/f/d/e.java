package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/e.class */
public abstract class e<T> extends i<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f7887c = e.class.getSimpleName();
    private final String d;

    public e(int i, String str, String str2, com.anythink.expressad.foundation.g.f.e<T> eVar) {
        super(i, str, eVar);
        this.d = str2;
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
