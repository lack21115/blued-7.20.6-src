package com.heytap.nearx.a.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.b.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import okio.Buffer;
import okio.ByteString;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/b.class */
public abstract class b<M extends b<M, B>, B extends a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    transient int f8649a = 0;
    protected transient int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final transient e<M> f8650c;
    private final transient ByteString d;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/b$a.class */
    public static abstract class a<T extends b<T, B>, B extends a<T, B>> {

        /* renamed from: a  reason: collision with root package name */
        Buffer f8651a;
        g b;

        public final a<T, B> a(int i, com.heytap.nearx.a.a.a aVar, Object obj) {
            if (this.b == null) {
                Buffer buffer = new Buffer();
                this.f8651a = buffer;
                this.b = new g(buffer);
            }
            try {
                aVar.a().a(this.b, i, obj);
                return this;
            } catch (IOException e) {
                throw new AssertionError();
            }
        }

        public final a<T, B> a(ByteString byteString) {
            if (byteString.size() > 0) {
                if (this.b == null) {
                    Buffer buffer = new Buffer();
                    this.f8651a = buffer;
                    this.b = new g(buffer);
                }
                try {
                    this.b.a(byteString);
                    return this;
                } catch (IOException e) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final ByteString a() {
            Buffer buffer = this.f8651a;
            return buffer != null ? buffer.clone().readByteString() : ByteString.EMPTY;
        }
    }

    public b(e<M> eVar, ByteString byteString) {
        if (eVar == null) {
            throw new NullPointerException("adapter == null");
        }
        if (byteString == null) {
            throw new NullPointerException("unknownFields == null");
        }
        this.f8650c = eVar;
        this.d = byteString;
    }

    public final ByteString a() {
        ByteString byteString = this.d;
        return byteString != null ? byteString : ByteString.EMPTY;
    }

    public final byte[] b() {
        return this.f8650c.b((e<M>) this);
    }

    public String toString() {
        return this.f8650c.c(this);
    }

    protected final Object writeReplace() throws ObjectStreamException {
        return new c(b(), getClass());
    }
}
