package com.opos.cmn.biz.web.a.b;

import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f11026a;
    public final String b;

    /* renamed from: com.opos.cmn.biz.web.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/b/a$a.class */
    public static class C0463a {

        /* renamed from: a  reason: collision with root package name */
        private String f11027a;
        private String b;

        public C0463a a(String str) {
            this.f11027a = str;
            return this;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f11027a)) {
                throw new Exception("url is null.");
            }
            return new a(this);
        }

        public C0463a b(String str) {
            this.b = str;
            return this;
        }
    }

    private a(C0463a c0463a) {
        this.f11026a = c0463a.f11027a;
        this.b = c0463a.b;
    }

    public String toString() {
        return "CacheResourceRequest{url=" + this.f11026a + ", md5=" + this.b + '}';
    }
}
