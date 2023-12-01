package com.tencent.tmsqmsp.sdk.c;

import com.tencent.tmsqmsp.sdk.c.f;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/n.class */
public class n implements d, e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f26043a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/n$a.class */
    public class a implements f.InterfaceC0874f {
        public a() {
        }

        @Override // com.tencent.tmsqmsp.sdk.c.f.InterfaceC0874f
        public int a(long j, long j2, long j3, Object obj, Object obj2, Object[] objArr, Object[] objArr2) {
            if (obj == null || !(obj instanceof String)) {
                return 0;
            }
            String str = (String) obj;
            com.tencent.tmsqmsp.sdk.f.g.a("QSec.Rpt", 1, String.format("Op: %d, Rid: %d, val: %s", Long.valueOf(j), Long.valueOf(j2), str));
            n.this.a(j, j2, str);
            return 0;
        }
    }

    private n() {
        f.a(3L, new a());
    }

    public static n b() {
        if (f26043a == null) {
            synchronized (n.class) {
                try {
                    if (f26043a == null) {
                        f26043a = new n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f26043a;
    }

    @Override // com.tencent.tmsqmsp.sdk.c.e
    public String a() {
        return "Rpt";
    }

    public void a(long j, long j2, String str) {
        new JSONObject();
        if (j == 1 || j == 2) {
            com.tencent.tmsqmsp.sdk.a.f.a(str, (int) j2);
        }
    }
}
