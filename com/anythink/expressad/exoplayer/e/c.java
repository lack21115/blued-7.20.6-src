package com.anythink.expressad.exoplayer.e;

import java.lang.reflect.Constructor;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/c.class */
public final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final Constructor<? extends e> f7314a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7315c;

    static {
        Constructor<? extends e> constructor;
        try {
            constructor = Class.forName("com.anythink.expressad.exoplayer.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException e) {
            constructor = null;
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f7314a = constructor;
    }

    private c a(int i) {
        synchronized (this) {
            this.b = i;
        }
        return this;
    }

    private c b(int i) {
        synchronized (this) {
            this.f7315c = i;
        }
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.e.h
    public final e[] a() {
        e[] eVarArr;
        synchronized (this) {
            eVarArr = new e[f7314a == null ? 2 : 3];
            eVarArr[0] = new com.anythink.expressad.exoplayer.e.a.e(this.f7315c);
            eVarArr[1] = new com.anythink.expressad.exoplayer.e.a.g(this.b);
            if (f7314a != null) {
                try {
                    eVarArr[2] = f7314a.newInstance(new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                }
            }
        }
        return eVarArr;
    }
}
