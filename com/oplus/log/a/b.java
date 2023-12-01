package com.oplus.log.a;

import com.oplus.log.core.c;
import com.oplus.log.core.e;
import com.oplus.log.d;
import com.oplus.log.e;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/a/b.class */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private d f24310a;

    public b(c cVar) {
        e eVar = new e();
        this.f24310a = eVar;
        eVar.a(cVar);
    }

    @Override // com.oplus.log.a.a
    public final void a() {
        d dVar = this.f24310a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.oplus.log.a.a
    public final void a(e.b bVar) {
        d dVar = this.f24310a;
        if (dVar != null) {
            dVar.a(bVar);
        }
    }

    @Override // com.oplus.log.a.a
    public final void a(String str, String str2, byte b, int i) {
        d dVar = this.f24310a;
        if (dVar != null) {
            dVar.a(str, str2, b, i);
        }
    }
}
