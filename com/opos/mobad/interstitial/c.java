package com.opos.mobad.interstitial;

import android.app.Activity;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.interstitial.a.j;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/c.class */
public class c {
    private static com.opos.mobad.activity.webview.b a(Activity activity, String str, a.C0707a c0707a) {
        if (c0707a.b.R() == 0 || !com.opos.mobad.o.e.b.a(c0707a.f26483c.b())) {
            return null;
        }
        String m = c0707a.f26483c.m();
        return new com.opos.mobad.activity.webview.b(activity, new WebDataHepler(c0707a.b, str, -1 != f.c(m) ? f.a(c0707a.b, m, str) : "", m, "", null, 1, false, false));
    }

    public static final a a(Activity activity, String str, com.opos.mobad.q.a.b.c cVar, h hVar, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.q.a.b.d dVar, a.C0707a c0707a, int i) {
        if (c0707a == null) {
            return null;
        }
        if (c0707a.b.S() == 1 && hVar.a(activity)) {
            com.opos.cmn.an.f.a.b("PresenterFactory", "do show as activity");
            return new e(activity.getApplicationContext(), str, hVar, aVar, dVar, cVar, c0707a, i);
        }
        com.opos.cmn.an.f.a.b("PresenterFactory", "do show as dialog");
        return new d(activity, str, aVar, new j(), dVar, a(activity, str, c0707a), cVar, c0707a, i);
    }
}
