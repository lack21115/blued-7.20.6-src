package com.opos.cmn.biz.web.a.b;

import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f24714a;
    public final String b;

    /* renamed from: com.opos.cmn.biz.web.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/b/a$a.class */
    public static class C0633a {

        /* renamed from: a  reason: collision with root package name */
        private String f24715a;
        private String b;

        public C0633a a(String str) {
            this.f24715a = str;
            return this;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f24715a)) {
                throw new Exception("url is null.");
            }
            return new a(this);
        }

        public C0633a b(String str) {
            this.b = str;
            return this;
        }
    }

    private a(C0633a c0633a) {
        this.f24714a = c0633a.f24715a;
        this.b = c0633a.b;
    }

    public String toString() {
        return "CacheResourceRequest{url=" + this.f24714a + ", md5=" + this.b + '}';
    }
}
