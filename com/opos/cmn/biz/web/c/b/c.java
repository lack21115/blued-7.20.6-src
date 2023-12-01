package com.opos.cmn.biz.web.c.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/c/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f24741a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24742c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/c/b/c$a.class */
    public static class a {
        private String b;

        /* renamed from: a  reason: collision with root package name */
        private boolean f24743a = true;

        /* renamed from: c  reason: collision with root package name */
        private String f24744c = "";

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(boolean z) {
            this.f24743a = z;
            return this;
        }

        public c a() {
            if (this.f24744c == null) {
                this.f24744c = "";
            }
            return new c(this);
        }

        public a b(String str) {
            this.f24744c = str;
            return this;
        }
    }

    private c(a aVar) {
        this.b = aVar.f24743a;
        this.f24742c = aVar.b;
        this.f24741a = aVar.f24744c;
    }

    public String toString() {
        return "JsCommonInitParams{, businessType=" + this.f24741a + "forceJsInit=" + this.b + ", jsSign=" + this.f24742c + '}';
    }
}
