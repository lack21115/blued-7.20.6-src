package com.opos.cmn.biz.web.b.a;

import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/b/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.opos.cmn.biz.web.b.a.a.b f24721a;
    public final Map<String, Object> b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f24722c;
    public final com.opos.cmn.biz.web.b.a.a.a d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/b/a/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private com.opos.cmn.biz.web.b.a.a.b f24723a;
        private Map<String, Object> b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f24724c = true;
        private com.opos.cmn.biz.web.b.a.a.a d;

        public a a(com.opos.cmn.biz.web.b.a.a.a aVar) {
            this.d = aVar;
            return this;
        }

        public a a(com.opos.cmn.biz.web.b.a.a.b bVar) {
            this.f24723a = bVar;
            return this;
        }

        public a a(Map<String, Object> map) {
            this.b = map;
            return this;
        }

        public a a(boolean z) {
            this.f24724c = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.f24721a = aVar.f24723a;
        this.b = aVar.b;
        this.f24722c = aVar.f24724c;
        this.d = aVar.d;
    }

    public String toString() {
        return "WebViewInitParams{iWebActionListener=" + this.f24721a + ", jsInterfaceMap=" + this.b + ", isShowTitle=" + this.f24722c + ", iReceivedSslErrorHandler=" + this.d + '}';
    }
}
