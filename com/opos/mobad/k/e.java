package com.opos.mobad.k;

import android.content.Context;
import android.view.View;
import com.opos.mobad.k.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/e.class */
public class e {
    public static final com.opos.mobad.n.d a(f.a aVar, Context context, final com.opos.mobad.ad.e.e eVar) {
        return (!f.a(aVar) || eVar == null || eVar.a() == null || eVar.b().size() <= 0) ? new com.opos.mobad.n.a.d(context) : new com.opos.mobad.n.a.e(eVar.b()) { // from class: com.opos.mobad.k.e.1
            @Override // com.opos.mobad.n.d
            public View a() {
                return eVar.a();
            }

            @Override // com.opos.mobad.n.d
            public void a(int i) {
                eVar.a(i);
            }
        };
    }
}
