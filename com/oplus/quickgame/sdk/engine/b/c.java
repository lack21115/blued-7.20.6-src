package com.oplus.quickgame.sdk.engine.b;

import java.nio.charset.Charset;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f24391a;

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/c$b.class */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f24392c = !c.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        private int f24393a;
        private byte[] b;

        private b() {
        }

        public b a(int i) {
            this.f24393a = i;
            return this;
        }

        public b a(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        public c a() {
            if (f24392c || this.f24393a <= 0 || this.b == null) {
                return new c(this);
            }
            throw new AssertionError();
        }
    }

    private c(b bVar) {
        int unused = bVar.f24393a;
        this.f24391a = bVar.b;
    }

    public static b b() {
        return new b();
    }

    public String a() {
        return new String(this.f24391a, Charset.defaultCharset());
    }
}
