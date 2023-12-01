package com.heytap.nearx.a.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.b.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/c.class */
final class c<M extends b<M, B>, B extends b.a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f8652a;
    private final Class<M> b;

    public c(byte[] bArr, Class<M> cls) {
        this.f8652a = bArr;
        this.b = cls;
    }

    Object readResolve() throws ObjectStreamException {
        try {
            return e.b((Class) this.b).a(this.f8652a);
        } catch (IOException e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
