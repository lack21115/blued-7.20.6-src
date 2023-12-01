package com.opos.cmn.func.b.b.a;

import com.opos.cmn.func.b.b.a.a;
import com.opos.cmn.func.b.b.a.b;
import com.opos.cmn.func.b.b.a.c;
import com.opos.cmn.func.b.b.a.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f24844a;
    public final c b;

    /* renamed from: c  reason: collision with root package name */
    public final com.opos.cmn.func.b.b.a.a f24845c;
    public final f d;
    public final e e;
    public final boolean f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private b f24846a;
        private c b;

        /* renamed from: c  reason: collision with root package name */
        private f f24847c;
        private com.opos.cmn.func.b.b.a.a d;
        private e e;
        private boolean f = true;

        public d a() {
            if (this.f24846a == null) {
                this.f24846a = new b.C0639b().a();
            }
            if (this.b == null) {
                this.b = new c.a().a();
            }
            if (this.f24847c == null) {
                this.f24847c = new f.a().a();
            }
            if (this.d == null) {
                this.d = new a.C0638a().a();
            }
            return new d(this);
        }
    }

    private d(a aVar) {
        this.f24844a = aVar.f24846a;
        this.b = aVar.b;
        this.d = aVar.f24847c;
        this.f24845c = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "HttpExtConfig{cloudConfig=" + this.f24844a + ", httpDnsConfig=" + this.b + ", appTraceConfig=" + this.f24845c + ", iPv6Config=" + this.d + ", httpStatConfig=" + this.e + ", closeNetLog=" + this.f + '}';
    }
}
