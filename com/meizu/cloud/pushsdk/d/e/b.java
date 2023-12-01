package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import com.huawei.openalliance.ad.constant.ao;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24121a = b.class.getSimpleName();
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f24122c;
    private String d;
    private int e;
    private final String f = "SQLITE";
    private final AtomicBoolean g = new AtomicBoolean(false);
    private long h;
    private final long i;
    private final long j;
    private final Context k;

    public b(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f24122c = null;
        this.e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f = f();
        if (f != null) {
            try {
                String obj = f.get(ao.q).toString();
                String obj2 = f.get(TextToSpeech.Engine.KEY_PARAM_SESSION_ID).toString();
                int intValue = ((Integer) f.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.f24122c = obj2;
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.d.f.c.a(f24121a, "Exception occurred retrieving session info from file: %s", e.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.d.f.c.c(f24121a, "Tracker Session Object created.", new Object[0]);
        }
        this.b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.d.f.c.c(f24121a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.d = this.f24122c;
        this.f24122c = e.b();
        this.e++;
        com.meizu.cloud.pushsdk.d.f.c.b(f24121a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.d.f.c.b(f24121a, " + Session ID: %s", this.f24122c);
        com.meizu.cloud.pushsdk.d.f.c.b(f24121a, " + Previous Session ID: %s", this.d);
        com.meizu.cloud.pushsdk.d.f.c.b(f24121a, " + Session Index: %s", Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.d.a.b a() {
        com.meizu.cloud.pushsdk.d.f.c.c(f24121a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.d.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.d.f.c.b(f24121a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.h, System.currentTimeMillis(), this.g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap(8);
        hashMap.put(ao.q, this.b);
        hashMap.put(TextToSpeech.Engine.KEY_PARAM_SESSION_ID, this.f24122c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", Integer.valueOf(this.e));
        getClass();
        hashMap.put("storageMechanism", "SQLITE");
        return hashMap;
    }
}
