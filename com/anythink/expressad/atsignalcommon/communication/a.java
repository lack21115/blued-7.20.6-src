package com.anythink.expressad.atsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/communication/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7082a = a.class.getSimpleName();
    public static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f7083c = 1;

    /* renamed from: com.anythink.expressad.atsignalcommon.communication.a$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/communication/a$1.class */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f7084a;

        AnonymousClass1(c cVar) {
            this.f7084a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.a(this.f7084a.K(), this.f7084a);
            } catch (Throwable th) {
                o.b(a.f7082a, th.getMessage(), th);
            }
        }
    }

    private static String a(float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, t.a(com.anythink.expressad.foundation.b.a.b().d(), f));
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, t.a(com.anythink.expressad.foundation.b.a.b().d(), f2));
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cf, 0);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cg, com.anythink.expressad.foundation.b.a.b().d().getResources().getConfiguration().orientation);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.ch, t.c(com.anythink.expressad.foundation.b.a.b().d()));
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable th) {
            o.d(f7082a, "code to string is error");
            return "";
        }
    }

    private static void a(c cVar) {
        new Thread(new AnonymousClass1(cVar)).start();
    }

    private static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f7083c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            o.a(f7082a, e.getMessage());
        }
    }

    private static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            c b2 = c.b(optJSONObject);
            if (b2 == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new AnonymousClass1(b2)).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                a(obj, e.getMessage());
                o.a(f7082a, e.getMessage());
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    static /* synthetic */ void a(String str, c cVar) {
        if (f.n == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "banner");
    }

    private static void b(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            a(obj, e.getMessage());
            o.a(f7082a, e.getMessage());
        }
    }

    private static void b(String str, c cVar) {
        if (f.n == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "banner");
    }
}
