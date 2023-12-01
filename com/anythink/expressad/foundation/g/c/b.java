package com.anythink.expressad.foundation.g.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/c/b.class */
public final class b extends f {
    private static final String b = "anythink_template/";

    /* renamed from: c  reason: collision with root package name */
    private static final String f5000c = "anythink_template/res/Movies";
    private static final String d = "anythink_template/res";
    private static final String e = "anythink_template/res/.Anythink_VC";
    private static final String f = "anythink_template/res/.anythink700";
    private static final String g = "anythink_template/res/img";
    private static final String h = "anythink_template/crashinfo";
    private static final String i = "anythink_template/other";
    private static final String j = "anythink_template/res/xml";
    private static final String k = "anythink_template/anythink/config";
    private static final String l = "anythink_template/res/res";
    private static final String m = "anythink_template/res/html";

    public b(String str) {
        super(str);
    }

    @Override // com.anythink.expressad.foundation.g.c.f
    protected final List<e> a() {
        ArrayList arrayList = new ArrayList();
        a(arrayList, a.ANYTHINK_RES_MANAGER_DIR, d);
        a(arrayList, a.AD_MOVIES, f5000c).a(a.ANYTHINK_VC, e);
        e a2 = a(arrayList, a.AD_ANYTHINK_700, f);
        a2.a(a.ANYTHINK_700_IMG, g);
        a2.a(a.ANYTHINK_700_XML, j);
        a2.a(a.MBRIDGE_700_CONFIG, k);
        a2.a(a.ANYTHINK_700_RES, l);
        a2.a(a.ANYTHINK_700_HTML, m);
        a(arrayList, a.ANYTHINK_OTHER, i);
        a(arrayList, a.ANYTHINK_CRASH_INFO, h);
        a(arrayList, a.ANYTHINK_OTHER, i);
        return arrayList;
    }
}
