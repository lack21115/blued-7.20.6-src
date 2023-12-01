package com.cmic.gen.sdk.tencent.c.c;

import com.cmic.gen.sdk.tencent.c.b.e;
import com.cmic.gen.sdk.tencent.e.p;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/c/b.class */
public class b extends c {
    private final e b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21645c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.f21645c = false;
        this.b = eVar;
    }

    public void a(com.cmic.gen.sdk.tencent.a aVar) {
        if (this.f21645c) {
            return;
        }
        com.cmic.gen.sdk.tencent.c.b.a c2 = this.b.c();
        String[] strArr = null;
        if (!aVar.b("isCloseIpv4", false)) {
            strArr = p.a(true);
            c2.q(strArr[0]);
        }
        if (!aVar.b("isCloseIpv6", false)) {
            String[] strArr2 = strArr;
            if (strArr == null) {
                strArr2 = p.a(true);
            }
            c2.r(strArr2[1]);
        }
        c2.n(c2.u(aVar.b("appkey")));
        this.b.a(c2);
        this.b.a(true);
        this.f21646a = this.b.b().toString();
        this.f21645c = true;
    }
}
