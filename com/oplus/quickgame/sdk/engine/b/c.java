package com.oplus.quickgame.sdk.engine.b;

import java.nio.charset.Charset;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f10704a;

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/c$b.class */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f10705c = !c.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        private int f10706a;
        private byte[] b;

        private b() {
        }

        public b a(int i) {
            this.f10706a = i;
            return this;
        }

        public b a(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        public c a() {
            if (f10705c || this.f10706a <= 0 || this.b == null) {
                return new c(this);
            }
            throw new AssertionError();
        }
    }

    private c(b bVar) {
        int unused = bVar.f10706a;
        this.f10704a = bVar.b;
    }

    public static b b() {
        return new b();
    }

    public String a() {
        return new String(this.f10704a, Charset.defaultCharset());
    }
}
