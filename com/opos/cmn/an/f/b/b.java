package com.opos.cmn.an.f.b;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f24530a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24531c;
    public final int d;
    public final int e;
    public final String f;
    public final Context g;
    public final InterfaceC0621b h;
    public final c i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/b/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f24532a;
        private InterfaceC0621b g;
        private c h;
        private int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private int f24533c = 1;
        private int d = 7;
        private String e = "";
        private String f = "cmn_log";
        private int i = 2;

        private void a() {
            if (com.opos.cmn.an.c.a.a(this.e)) {
                this.e = this.f24532a.getPackageName();
            }
            if (this.g == null) {
                this.g = new InterfaceC0621b() { // from class: com.opos.cmn.an.f.b.b.a.1
                    @Override // com.opos.cmn.an.f.b.b.InterfaceC0621b
                    public String a() {
                        return com.opos.cmn.an.f.c.b.a(a.this.f24532a);
                    }
                };
            }
            if (this.h == null) {
                this.h = new c() { // from class: com.opos.cmn.an.f.b.b.a.2
                    @Override // com.opos.cmn.an.f.b.b.c
                    public String a() {
                        return com.opos.cmn.an.f.c.a.a(a.this.f24532a);
                    }
                };
            }
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public b a(Context context) {
            if (context != null) {
                this.f24532a = context.getApplicationContext();
                a();
                return new b(this);
            }
            throw new NullPointerException("context is null.");
        }

        public a b(int i) {
            this.f24533c = i;
            return this;
        }

        public a b(String str) {
            if (!com.opos.cmn.an.c.a.a(str)) {
                this.e = str;
            }
            return this;
        }

        public a c(int i) {
            if (i > 0) {
                this.d = i;
            }
            return this;
        }
    }

    /* renamed from: com.opos.cmn.an.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/b/b$b.class */
    public interface InterfaceC0621b {
        String a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/b/b$c.class */
    public interface c {
        String a();
    }

    private b(a aVar) {
        this.f24530a = aVar.f;
        this.b = aVar.b;
        this.f24531c = aVar.f24533c;
        this.d = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f24532a;
        this.h = aVar.g;
        this.i = aVar.h;
        this.e = aVar.i;
    }

    public String toString() {
        return "LogInitParams{, context=" + this.g + ", baseTag=" + this.f24530a + ", fileLogLevel=" + this.b + ", consoleLogLevel=" + this.f24531c + ", fileExpireDays=" + this.d + ", pkgName=" + this.f + ", imeiProvider=" + this.h + ", openIdProvider=" + this.i + ", logImplType=" + this.e + '}';
    }
}
