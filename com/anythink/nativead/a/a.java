package com.anythink.nativead.a;

import android.content.Context;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.e;
import com.anythink.core.common.f;
import com.anythink.core.common.h;
import com.anythink.core.common.j;
import com.anythink.core.common.k.s;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/a/a.class */
public class a extends f<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5985a = a.class.getSimpleName();

    private a(Context context, String str) {
        super(context, str);
    }

    private static h a(d dVar) {
        c cVar = new c(dVar.a());
        cVar.a(dVar.d);
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r0 instanceof com.anythink.nativead.a.a) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.nativead.a.a a(android.content.Context r5, java.lang.String r6) {
        /*
            com.anythink.core.common.v r0 = com.anythink.core.common.v.a()
            r1 = r6
            com.anythink.core.common.f r0 = r0.b(r1)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L15
            r0 = r8
            r7 = r0
            r0 = r8
            boolean r0 = r0 instanceof com.anythink.nativead.a.a
            if (r0 != 0) goto L27
        L15:
            com.anythink.nativead.a.a r0 = new com.anythink.nativead.a.a
            r1 = r0
            r2 = r5
            r3 = r6
            r1.<init>(r2, r3)
            r7 = r0
            com.anythink.core.common.v r0 = com.anythink.core.common.v.a()
            r1 = r6
            r2 = r7
            r0.a(r1, r2)
        L27:
            r0 = r7
            com.anythink.nativead.a.a r0 = (com.anythink.nativead.a.a) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.nativead.a.a.a(android.content.Context, java.lang.String):com.anythink.nativead.a.a");
    }

    public final com.anythink.core.common.e.b a(String str, Map<String, Object> map) {
        com.anythink.core.common.e.b a2 = com.anythink.core.common.a.a().a(this.b, this.c);
        if (a2 != null && (a2.f() instanceof com.anythink.nativead.unitgroup.a) && (a2.e() instanceof CustomNativeAdapter)) {
            BaseAd f = a2.f();
            ATBaseAdAdapter e = a2.e();
            e detail = f.getDetail();
            detail.C = str;
            com.anythink.core.common.a.a().a(this.c, detail.x(), a2);
            com.anythink.core.common.a.a();
            com.anythink.core.common.a.b(this.c, e.getUnitGroupInfo());
            s.a(map, detail);
            return a2;
        }
        return null;
    }

    public final /* synthetic */ h a(j jVar) {
        d dVar = (d) jVar;
        c cVar = new c(dVar.a());
        cVar.a(dVar.d);
        return cVar;
    }

    public final String a() {
        return "0";
    }

    public final void a(Context context, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        d dVar = new d();
        dVar.a(context);
        dVar.e = bVar;
        dVar.d = 0;
        dVar.g = map;
        super.a(this.b, "0", this.c, dVar, aVar);
    }
}
