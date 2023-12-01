package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.opos.cmn.func.dl.base.exception.DlException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/c/f.class */
public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11216a = f.class.getSimpleName();
    private String b;

    @Override // com.opos.cmn.func.dl.base.c.e
    public final String a() {
        return this.b;
    }

    @Override // com.opos.cmn.func.dl.base.c.e
    public final void a(Context context, d dVar, String str, b bVar) {
        com.opos.cmn.an.f.a.b(f11216a, "RedirectHandler process ,url=".concat(String.valueOf(str)));
        int d = dVar.d();
        c cVar = dVar;
        int i = 0;
        while (true) {
            if (!(d == 301 || d == 302 || d == 303 || d == 300 || d == 307 || d == 308)) {
                if (TextUtils.isEmpty(this.b) || !com.opos.cmn.func.dl.base.h.a.a(d)) {
                    return;
                }
                ((a) dVar).b = cVar;
                return;
            }
            com.opos.cmn.an.f.a.b(f11216a, "Deal redirect !");
            cVar.c();
            i++;
            if (i > 5) {
                throw new DlException(1002);
            }
            String a2 = cVar.a(HttpHeaders.LOCATION);
            if (a2 == null) {
                throw new DlException(1002);
            }
            this.b = a2;
            cVar = new c();
            cVar.a(context, this.b, bVar);
            d = cVar.d();
        }
    }
}
