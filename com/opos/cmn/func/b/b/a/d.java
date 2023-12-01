package com.opos.cmn.func.b.b.a;

import com.opos.cmn.func.b.b.a.a;
import com.opos.cmn.func.b.b.a.b;
import com.opos.cmn.func.b.b.a.c;
import com.opos.cmn.func.b.b.a.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f11156a;
    public final c b;

    /* renamed from: c  reason: collision with root package name */
    public final com.opos.cmn.func.b.b.a.a f11157c;
    public final f d;
    public final e e;
    public final boolean f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private b f11158a;
        private c b;

        /* renamed from: c  reason: collision with root package name */
        private f f11159c;
        private com.opos.cmn.func.b.b.a.a d;
        private e e;
        private boolean f = true;

        public d a() {
            if (this.f11158a == null) {
                this.f11158a = new b.C0469b().a();
            }
            if (this.b == null) {
                this.b = new c.a().a();
            }
            if (this.f11159c == null) {
                this.f11159c = new f.a().a();
            }
            if (this.d == null) {
                this.d = new a.C0468a().a();
            }
            return new d(this);
        }
    }

    private d(a aVar) {
        this.f11156a = aVar.f11158a;
        this.b = aVar.b;
        this.d = aVar.f11159c;
        this.f11157c = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "HttpExtConfig{cloudConfig=" + this.f11156a + ", httpDnsConfig=" + this.b + ", appTraceConfig=" + this.f11157c + ", iPv6Config=" + this.d + ", httpStatConfig=" + this.e + ", closeNetLog=" + this.f + '}';
    }
}
