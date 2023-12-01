package com.cmic.gen.sdk.tencent.c;

import com.cmic.gen.sdk.tencent.c.b.d;
import com.cmic.gen.sdk.tencent.c.b.g;
import com.cmic.gen.sdk.tencent.c.c.c;
import com.cmic.gen.sdk.tencent.e.q;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f8012a;
    private String b;

    private c a(String str, String str2, String str3, g gVar) {
        c cVar = new c(str, gVar, str3, str2);
        if (str3.equals("GET")) {
            cVar.a("Content-Type", "application/x-www-form-urlencoded");
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (r0.isEmpty() != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.cmic.gen.sdk.tencent.c.c.c a(com.cmic.gen.sdk.tencent.c.c.c r7, com.cmic.gen.sdk.tencent.c.d.b r8, com.cmic.gen.sdk.tencent.a r9) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.tencent.c.a.a(com.cmic.gen.sdk.tencent.c.c.c, com.cmic.gen.sdk.tencent.c.d.b, com.cmic.gen.sdk.tencent.a):com.cmic.gen.sdk.tencent.c.c.c");
    }

    public String a() {
        return this.f8012a;
    }

    public c b(c cVar, com.cmic.gen.sdk.tencent.c.d.b bVar, com.cmic.gen.sdk.tencent.a aVar) {
        String b = aVar.b("operatortype", "0");
        q.a(aVar, "2".equals(b) ? "getNewUnicomPhoneNumberNotify" : "3".equals(b) ? "getNewTelecomPhoneNumberNotify" : "NONE");
        q.b(aVar, String.valueOf(bVar.a()));
        d dVar = new d(cVar.k().a(), "1.0", bVar.c());
        dVar.c(aVar.b("userCapaid"));
        if (aVar.c("logintype") == 3 || aVar.b("isRisk", false)) {
            dVar.b("pre");
        } else {
            dVar.b("authz");
        }
        c a2 = a(this.f8012a, cVar.f(), "POST", dVar);
        a2.a(cVar.h());
        this.f8012a = null;
        return a2;
    }
}
