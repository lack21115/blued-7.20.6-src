package com.cmic.gen.sdk.tencent.c.c;

import android.os.SystemClock;
import com.cmic.gen.sdk.tencent.b;
import com.cmic.gen.sdk.tencent.c.b.e;
import com.cmic.gen.sdk.tencent.c.b.f;
import com.cmic.gen.sdk.tencent.c.b.h;
import com.cmic.gen.sdk.tencent.e.i;
import com.cmic.gen.sdk.tencent.e.k;
import com.cmic.gen.sdk.tencent.e.m;
import com.cmic.gen.sdk.tencent.e.o;
import com.cmic.gen.sdk.tencent.e.p;
import com.cmic.gen.sdk.tencent.e.q;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f8036a;

    private a() {
    }

    public static a a() {
        if (f8036a == null) {
            synchronized (a.class) {
                try {
                    if (f8036a == null) {
                        f8036a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8036a;
    }

    private void a(final c cVar, final d dVar, final com.cmic.gen.sdk.tencent.a aVar) {
        com.cmic.gen.sdk.tencent.c.a.d dVar2 = new com.cmic.gen.sdk.tencent.c.a.d();
        com.cmic.gen.sdk.tencent.c.a.c cVar2 = new com.cmic.gen.sdk.tencent.c.a.c();
        com.cmic.gen.sdk.tencent.c.a.a aVar2 = new com.cmic.gen.sdk.tencent.c.a.a();
        dVar2.a(cVar2);
        cVar2.a(aVar2);
        cVar.a(SystemClock.elapsedRealtime());
        dVar2.a(cVar, new com.cmic.gen.sdk.tencent.c.d.c() { // from class: com.cmic.gen.sdk.tencent.c.c.a.1
            private void a() {
                if (cVar.a().contains("uniConfig")) {
                    return;
                }
                q.c(aVar, String.valueOf(SystemClock.elapsedRealtime() - cVar.i()));
            }

            @Override // com.cmic.gen.sdk.tencent.c.d.c
            public void a(com.cmic.gen.sdk.tencent.c.d.a aVar3) {
                if (cVar.g()) {
                    a();
                    q.b(aVar, String.valueOf(aVar3.a()));
                    dVar.a(String.valueOf(aVar3.a()), aVar3.b(), com.cmic.gen.sdk.tencent.auth.d.a(String.valueOf(aVar3.a()), aVar3.b()));
                }
            }

            @Override // com.cmic.gen.sdk.tencent.c.d.c
            public void a(com.cmic.gen.sdk.tencent.c.d.b bVar) {
                if (cVar.g()) {
                    try {
                        a();
                        JSONObject jSONObject = new JSONObject(bVar.c());
                        String string = jSONObject.has("resultcode") ? jSONObject.getString("resultcode") : jSONObject.getString(ProcessBridgeProvider.KEY_RESULT_CODE);
                        q.b(aVar, string);
                        dVar.a(string, jSONObject.optString("desc"), jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                        a(com.cmic.gen.sdk.tencent.c.d.a.a(102223));
                    }
                }
            }
        }, aVar);
    }

    public void a(com.cmic.gen.sdk.tencent.a aVar, d dVar) {
        String str;
        b cVar;
        String a2;
        int c2 = aVar.c("networktype");
        h hVar = new h();
        hVar.b("1.0");
        hVar.c(com.cmic.gen.sdk.tencent.auth.c.SDK_VERSION);
        hVar.d(aVar.b("appid"));
        hVar.e(aVar.b("operatortype"));
        hVar.f(c2 + "");
        hVar.g(m.a());
        hVar.h(m.b());
        hVar.i(m.c());
        hVar.j("0");
        hVar.k("3.0");
        hVar.l(q.b());
        hVar.m(o.a());
        hVar.o(aVar.b("apppackage"));
        hVar.p(aVar.b("appsign"));
        hVar.a_(k.b("AID", ""));
        if (aVar.c("logintype") == 3 || aVar.b("isRisk", false)) {
            str = "pre";
        } else {
            hVar.w(aVar.b("userCapaid"));
            hVar.w(aVar.c("logintype") == 1 ? BasicPushStatus.SUCCESS_CODE : "50");
            str = "authz";
        }
        hVar.s(str);
        q.a(aVar, "scripAndTokenForHttps");
        com.cmic.gen.sdk.tencent.a.a b = aVar.b();
        if (aVar.b("isCacheScrip", false) || aVar.c("logintype") == 1 || aVar.b("isGotScrip", false)) {
            String[] a3 = p.a(false);
            hVar.q(a3[0]);
            hVar.r(a3[1]);
            hVar.v(aVar.b("phonescrip"));
            hVar.n(hVar.u(aVar.b("appkey")));
            cVar = new c("https://" + b.a() + "/unisdk/rs/scripAndTokenForHttps", hVar, "POST", aVar.b("traceId"));
            cVar.a("defendEOF", "0");
        } else {
            e eVar = new e();
            eVar.a(aVar.a(b.a.f8006a));
            eVar.b(aVar.a(b.a.b));
            eVar.a(hVar);
            eVar.a(false);
            aVar.a("isCloseIpv4", b.h());
            aVar.a("isCloseIpv6", b.i());
            String str2 = "https://" + b.b() + "/unisdk/rs/scripAndTokenForHttps";
            if (aVar.b("use2048PublicKey", false)) {
                com.cmic.gen.sdk.tencent.e.c.a("BaseRequest", "使用2对应的编码");
                eVar.b("2");
                a2 = i.a().b(aVar.a(b.a.f8006a));
            } else {
                a2 = i.a().a(aVar.a(b.a.f8006a));
            }
            eVar.c(a2);
            cVar = new b(str2, eVar, "POST", aVar.b("traceId"));
            cVar.a("defendEOF", "1");
            if (c2 == 3) {
                cVar.a(true);
                aVar.a("doNetworkSwitch", true);
            } else {
                cVar.a(false);
                aVar.a("doNetworkSwitch", false);
            }
        }
        cVar.a("interfaceVersion", "3.0");
        a(cVar, dVar, aVar);
    }

    public void a(JSONObject jSONObject, com.cmic.gen.sdk.tencent.a aVar, d dVar) {
        f fVar = new f();
        f.a aVar2 = new f.a();
        f.b bVar = new f.b();
        bVar.e(q.b());
        bVar.f(o.a());
        bVar.b("2.0");
        bVar.c(aVar.b("appid", ""));
        bVar.d(bVar.u(""));
        aVar2.a(jSONObject);
        fVar.a(aVar2);
        fVar.a(bVar);
        com.cmic.gen.sdk.tencent.a.a b = aVar.b();
        a(new c("https://" + b.d() + "/log/logReport", fVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(boolean z, com.cmic.gen.sdk.tencent.a aVar, d dVar) {
        com.cmic.gen.sdk.tencent.c.b.b bVar = new com.cmic.gen.sdk.tencent.c.b.b();
        bVar.b("1.0");
        bVar.c("Android");
        bVar.d(k.b("AID", ""));
        bVar.e(z ? "1" : "0");
        bVar.f(com.cmic.gen.sdk.tencent.auth.c.SDK_VERSION);
        bVar.g(aVar.b("appid"));
        bVar.h(bVar.u("iYm0HAnkxQtpvN44"));
        com.cmic.gen.sdk.tencent.a.a b = aVar.b();
        a(new c("https://" + b.c() + "/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
    }
}
