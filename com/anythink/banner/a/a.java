package com.anythink.banner.a;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.h;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/a/a.class */
public class a extends com.anythink.core.common.f<c> {
    public static final String a = g.C0060g.c + a.class.getSimpleName();

    private a(Context context, String str) {
        super(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r0 instanceof com.anythink.banner.a.a) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.banner.a.a a(android.content.Context r5, java.lang.String r6) {
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
            boolean r0 = r0 instanceof com.anythink.banner.a.a
            if (r0 != 0) goto L27
        L15:
            com.anythink.banner.a.a r0 = new com.anythink.banner.a.a
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
            com.anythink.banner.a.a r0 = (com.anythink.banner.a.a) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.banner.a.a.a(android.content.Context, java.lang.String):com.anythink.banner.a.a");
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static h a2(c cVar) {
        f fVar = new f(cVar.a());
        fVar.a(cVar.d);
        return fVar;
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(c cVar) {
        c cVar2 = cVar;
        f fVar = new f(cVar2.a());
        fVar.a(cVar2.d);
        return fVar;
    }

    @Override // com.anythink.core.common.f
    public final String a() {
        return "2";
    }

    public final void a(Context context, int i, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        c cVar = new c();
        cVar.e = bVar;
        cVar.a(context);
        cVar.d = i;
        cVar.g = map;
        super.a(this.b, "2", this.c, (String) cVar, aVar);
    }
}
