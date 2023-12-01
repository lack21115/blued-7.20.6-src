package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.c.f.p;
import com.opos.exoplayer.core.c.f.t;
import java.lang.reflect.Constructor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/c.class */
public final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final Constructor<? extends e> f11413a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11414c;
    private int d;
    private int e;
    private int f = 1;
    private int g;

    static {
        Constructor<? extends e> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException e) {
            constructor = null;
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f11413a = constructor;
    }

    @Override // com.opos.exoplayer.core.c.h
    public e[] a() {
        e[] eVarArr;
        synchronized (this) {
            eVarArr = new e[f11413a == null ? 11 : 12];
            eVarArr[0] = new com.opos.exoplayer.core.c.b.a(this.b);
            eVarArr[1] = new com.opos.exoplayer.core.c.d.b(this.d);
            eVarArr[2] = new com.opos.exoplayer.core.c.d.c(this.f11414c);
            eVarArr[3] = new com.opos.exoplayer.core.c.c.a(this.e);
            eVarArr[4] = new com.opos.exoplayer.core.c.f.c();
            eVarArr[5] = new com.opos.exoplayer.core.c.f.a();
            eVarArr[6] = new t(this.f, this.g);
            eVarArr[7] = new com.opos.exoplayer.core.c.a.a();
            eVarArr[8] = new com.opos.exoplayer.core.c.e.a();
            eVarArr[9] = new p();
            eVarArr[10] = new com.opos.exoplayer.core.c.g.a();
            if (f11413a != null) {
                try {
                    eVarArr[11] = f11413a.newInstance(new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                }
            }
        }
        return eVarArr;
    }
}
