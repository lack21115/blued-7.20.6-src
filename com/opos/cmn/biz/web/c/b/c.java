package com.opos.cmn.biz.web.c.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/c/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f11053a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11054c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/c/b/c$a.class */
    public static class a {
        private String b;

        /* renamed from: a  reason: collision with root package name */
        private boolean f11055a = true;

        /* renamed from: c  reason: collision with root package name */
        private String f11056c = "";

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(boolean z) {
            this.f11055a = z;
            return this;
        }

        public c a() {
            if (this.f11056c == null) {
                this.f11056c = "";
            }
            return new c(this);
        }

        public a b(String str) {
            this.f11056c = str;
            return this;
        }
    }

    private c(a aVar) {
        this.b = aVar.f11055a;
        this.f11054c = aVar.b;
        this.f11053a = aVar.f11056c;
    }

    public String toString() {
        return "JsCommonInitParams{, businessType=" + this.f11053a + "forceJsInit=" + this.b + ", jsSign=" + this.f11054c + '}';
    }
}
