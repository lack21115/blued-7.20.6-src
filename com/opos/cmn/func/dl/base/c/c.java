package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.func.dl.base.c.d;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/c/c.class */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24902a = c.class.getSimpleName();
    private com.opos.cmn.func.b.b.e b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f24903c = new HashMap();

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/c/c$a.class */
    public static final class a implements d.a {
        @Override // com.opos.cmn.func.dl.base.c.d.a
        public final d a() {
            return new c();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a() {
        com.opos.cmn.func.b.b.e eVar = this.b;
        if (eVar != null) {
            return eVar.f24863c;
        }
        return null;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a(Context context, String str, b bVar) {
        if (bVar.f24901a != null) {
            this.f24903c.putAll(bVar.f24901a);
        }
        this.b = com.opos.cmn.func.b.b.b.a().a(context, new d.a().b(str).a(this.f24903c).a("GET").a());
        return a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String a(String str) {
        com.opos.cmn.func.b.b.e eVar = this.b;
        return eVar != null ? eVar.f.a(str) : "";
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void a(String str, String str2) {
        this.f24903c.put(str, str2);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String b() {
        com.opos.cmn.func.b.b.e eVar = this.b;
        return eVar != null ? eVar.b : "";
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void c() {
        com.opos.cmn.func.b.b.e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final int d() {
        com.opos.cmn.func.b.b.e eVar = this.b;
        if (eVar != null) {
            return eVar.f24862a;
        }
        return -1;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final long e() {
        com.opos.cmn.func.b.b.e eVar = this.b;
        if (eVar != null) {
            return eVar.d;
        }
        return -1L;
    }
}
