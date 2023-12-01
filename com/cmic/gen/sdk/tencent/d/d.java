package com.cmic.gen.sdk.tencent.d;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.e.f;
import com.cmic.gen.sdk.tencent.e.k;
import com.cmic.gen.sdk.tencent.e.m;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/d/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private com.cmic.gen.sdk.tencent.a f21656a;

    private static void a(b bVar, com.cmic.gen.sdk.tencent.a aVar) {
        if (bVar == null || aVar == null) {
            return;
        }
        bVar.b(aVar.b("appid", ""));
        bVar.f(m.a());
        bVar.i(aVar.b("interfaceType", ""));
        bVar.h(aVar.b("interfaceCode", ""));
        bVar.g(aVar.b("interfaceElasped", ""));
        bVar.l(aVar.b("timeOut"));
        bVar.s(aVar.b("traceId"));
        bVar.v(aVar.b("networkClass"));
        bVar.n(aVar.b("simCardNum"));
        bVar.o(aVar.b("operatortype"));
        bVar.p(m.b());
        bVar.q(m.c());
        bVar.y(String.valueOf(aVar.b("networktype", 0)));
        bVar.t(aVar.b(LogBuilder.KEY_START_TIME));
        bVar.w(aVar.b(LogBuilder.KEY_END_TIME));
        bVar.m(String.valueOf(aVar.b("systemEndTime", 0L) - aVar.b("systemStartTime", 0L)));
        bVar.d(aVar.b("imsiState"));
        bVar.z(k.b("AID", ""));
        bVar.A(aVar.b("operatortype"));
        bVar.B(aVar.b("scripType"));
        com.cmic.gen.sdk.tencent.e.c.a("SendLog", "traceId" + aVar.b("traceId"));
    }

    private void a(JSONObject jSONObject) {
        com.cmic.gen.sdk.tencent.c.c.a.a().a(jSONObject, this.f21656a, new com.cmic.gen.sdk.tencent.c.c.d() { // from class: com.cmic.gen.sdk.tencent.d.d.1
            @Override // com.cmic.gen.sdk.tencent.c.c.d
            public void a(String str, String str2, JSONObject jSONObject2) {
                long j;
                com.cmic.gen.sdk.tencent.a.a b = d.this.f21656a.b();
                HashMap hashMap = new HashMap();
                if (!str.equals("103000")) {
                    if (b.l() != 0 && b.k() != 0) {
                        int a2 = k.a("logFailTimes", 0) + 1;
                        if (a2 >= b.k()) {
                            hashMap.put("logFailTimes", 0);
                            j = System.currentTimeMillis();
                        } else {
                            hashMap.put("logFailTimes", Integer.valueOf(a2));
                        }
                    }
                    k.a(hashMap);
                }
                hashMap.put("logFailTimes", 0);
                j = 0;
                hashMap.put("logCloseTime", Long.valueOf(j));
                k.a(hashMap);
            }
        });
    }

    public void a(Context context, String str, com.cmic.gen.sdk.tencent.a aVar) {
        try {
            b a2 = aVar.a();
            String b = f.b(context);
            a2.e(str);
            a2.x(aVar.b("loginMethod", ""));
            a2.r(aVar.b("isCacheScrip", false) ? "scrip" : "pgw");
            a2.j(f.a(context));
            a2.k(TextUtils.isEmpty(b) ? "" : b);
            a2.c(aVar.b("hsaReadPhoneStatePermission", false) ? "1" : "0");
            a(a2, aVar);
            JSONArray jSONArray = null;
            if (a2.f21653a.size() > 0) {
                jSONArray = new JSONArray();
                Iterator<Throwable> it = a2.f21653a.iterator();
                while (it.hasNext()) {
                    Throwable next = it.next();
                    StringBuffer stringBuffer = new StringBuffer();
                    JSONObject jSONObject = new JSONObject();
                    StackTraceElement[] stackTrace = next.getStackTrace();
                    int length = stackTrace.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < length) {
                            StackTraceElement stackTraceElement = stackTrace[i2];
                            stringBuffer.append("\n");
                            stringBuffer.append(stackTraceElement.toString());
                            i = i2 + 1;
                        }
                    }
                    jSONObject.put("message", next.toString());
                    jSONObject.put("stack", stringBuffer.toString());
                    jSONArray.put(jSONObject);
                }
                a2.f21653a.clear();
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                a2.a(jSONArray);
            }
            com.cmic.gen.sdk.tencent.e.c.a("SendLog", "登录日志");
            a(a2.b(), aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSONObject jSONObject, com.cmic.gen.sdk.tencent.a aVar) {
        this.f21656a = aVar;
        a(jSONObject);
    }
}
