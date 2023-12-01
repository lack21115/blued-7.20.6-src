package com.opos.cmn.an.f.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f24536a;
    public final boolean b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/b/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f24537a;
        private boolean b = true;

        public a a(String str) {
            this.f24537a = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private c(a aVar) {
        this.f24536a = aVar.f24537a;
        this.b = aVar.b;
    }

    public String toString() {
        return "UploadParams{, businessType=" + this.f24536a + ", onlyWifi=" + this.b + '}';
    }
}
