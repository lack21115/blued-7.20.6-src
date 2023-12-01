package com.cmic.gen.sdk.tencent.d;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.e.f;
import com.cmic.gen.sdk.tencent.e.m;
import com.cmic.gen.sdk.tencent.e.n;
import com.cmic.gen.sdk.tencent.e.o;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static C0161a<String, String> f8045a = new C0161a<>();

    /* renamed from: com.cmic.gen.sdk.tencent.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/d/a$a.class */
    static class C0161a<K, V> extends HashMap<K, V> {
        private C0161a() {
        }

        public V a(Object obj, V v) {
            return (!containsKey(obj) || get(obj) == null) ? v : get(obj);
        }
    }

    public static void a() {
        String valueOf = String.valueOf(0);
        f8045a.put("authPageIn", valueOf);
        f8045a.put("authPageOut", valueOf);
        f8045a.put("authClickFailed", valueOf);
        f8045a.put("authClickSuccess", valueOf);
        f8045a.put("timeOnAuthPage", valueOf);
        f8045a.put("authPrivacyState", valueOf);
    }

    public static void a(Context context, final com.cmic.gen.sdk.tencent.a aVar) {
        try {
            if (aVar.b().j()) {
                return;
            }
            com.cmic.gen.sdk.tencent.view.a aVar2 = new com.cmic.gen.sdk.tencent.view.a();
            String valueOf = String.valueOf(0);
            aVar2.e(!f8045a.a("authPageIn", valueOf).equals(valueOf) ? f8045a.get("authPageIn") : null);
            aVar2.f(!f8045a.a("authPageOut", valueOf).equals(valueOf) ? f8045a.get("authPageOut") : null);
            aVar2.c(!f8045a.a("authClickSuccess", valueOf).equals(valueOf) ? f8045a.get("authClickSuccess") : null);
            aVar2.b(!f8045a.a("authClickFailed", valueOf).equals(valueOf) ? f8045a.get("authClickFailed") : null);
            String str = null;
            if (!f8045a.a("timeOnAuthPage", valueOf).equals(valueOf)) {
                str = f8045a.get("timeOnAuthPage");
            }
            aVar2.d(str);
            aVar2.a(f8045a.a("authPrivacyState", valueOf));
            JSONObject a2 = aVar2.a();
            final c cVar = new c();
            cVar.b(aVar.b("appid", ""));
            cVar.s(aVar.b("traceId"));
            cVar.b(aVar.b("appid"));
            cVar.j(f.a(context));
            cVar.k(f.b(context));
            cVar.l(aVar.b("timeOut"));
            cVar.t(f8045a.a("authPageInTime", ""));
            cVar.w(f8045a.a("authPageOutTime", ""));
            cVar.x("eventTracking5");
            cVar.o(aVar.b("operatortype", ""));
            cVar.y(aVar.b("networktype", 0) + "");
            cVar.v(aVar.b("networkClass"));
            cVar.f(m.a());
            cVar.p(m.b());
            cVar.q(m.c());
            cVar.n(aVar.b("simCardNum"));
            cVar.c(aVar.b("hsaReadPhoneStatePermission", false) ? "1" : "0");
            cVar.a(a2);
            cVar.d(aVar.b("imsiState", "0"));
            cVar.m((System.currentTimeMillis() - aVar.b("methodTimes", 0L)) + "");
            com.cmic.gen.sdk.tencent.e.c.a("EventUtils", "埋点日志上报" + cVar.b());
            n.a(new n.a() { // from class: com.cmic.gen.sdk.tencent.d.a.1
                @Override // com.cmic.gen.sdk.tencent.e.n.a
                public void a() {
                    new d().a(c.this.b(), aVar);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str) {
        try {
            String str2 = f8045a.get(str);
            int i = 0;
            if (!TextUtils.isEmpty(str2)) {
                i = Integer.parseInt(str2);
            }
            f8045a.put(str, String.valueOf(i + 1));
            f8045a.put(str + "Time", o.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        f8045a.put(str, str2);
    }
}
