package com.youzan.spiderman.d;

import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Charset f41815a = Charset.forName("UTF-8");
    private Charset b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f41816c;
    private Reader d;

    public d(Charset charset, InputStream inputStream, Reader reader) {
        this.b = charset;
        this.f41816c = inputStream;
        this.d = reader;
    }

    public final InputStream a() {
        return this.f41816c;
    }

    public final Reader b() {
        return this.d;
    }

    public final boolean c() {
        Charset charset = this.b;
        return charset == null || charset.equals(f41815a);
    }
}
