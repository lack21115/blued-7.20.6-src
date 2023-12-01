package com.tencent.map.b;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/b.class */
public class b {
    private static b b;
    private a i;

    /* renamed from: c  reason: collision with root package name */
    private double f23512c = 0.0d;
    private double d = 0.0d;
    private double e = 0.0d;
    private double f = 0.0d;
    private double g = 0.0d;
    private double h = 0.0d;
    private C0774b j = null;
    private boolean k = false;

    /* renamed from: a  reason: collision with root package name */
    public String f23511a = "";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/b$a.class */
    public interface a {
        void a(double d, double d2);
    }

    /* renamed from: com.tencent.map.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/b$b.class */
    public final class C0774b extends Thread {
        public C0774b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                byte[] a2 = j.a(b.this.f23511a.getBytes());
                b.this.k = true;
                n a3 = b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", a2);
                b.this.k = false;
                b.a(b.this, j.b(a3.f23554a), a3.b);
            } catch (Exception e) {
                int i = 0;
                while (true) {
                    i++;
                    if (i > 3) {
                        b.this.k = false;
                        if (b.this.i != null) {
                            b.this.i.a(360.0d, 360.0d);
                            return;
                        }
                        return;
                    }
                    try {
                        sleep(2000L);
                        n a4 = b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", j.a(b.this.f23511a.getBytes()));
                        b.this.k = false;
                        b.a(b.this, j.b(a4.f23554a), a4.b);
                        return;
                    } catch (Exception e2) {
                    }
                }
            }
        }
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public static n a(String str, String str2, byte[] bArr) throws o, r, Exception {
        if (l.b() != null) {
            try {
                return q.a(false, str, str2, null, bArr, false, true);
            } catch (Exception e) {
                throw e;
            }
        }
        throw new o();
    }

    static /* synthetic */ void a(b bVar, byte[] bArr, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(new String(bArr, str));
        } catch (Exception e) {
            a aVar = bVar.i;
            if (aVar != null) {
                aVar.a(360.0d, 360.0d);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(stringBuffer.toString()).getJSONObject("location");
            double d = jSONObject.getDouble("latitude");
            double d2 = jSONObject.getDouble("longitude");
            bVar.g = d - bVar.e;
            bVar.h = d2 - bVar.f;
            bVar.f23512c = bVar.e;
            bVar.d = bVar.f;
            if (bVar.i != null) {
                bVar.i.a(d, d2);
            }
        } catch (JSONException e2) {
            a aVar2 = bVar.i;
            if (aVar2 != null) {
                aVar2.a(360.0d, 360.0d);
            }
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public final void a(double d, double d2, a aVar) {
        this.i = aVar;
        if (this.g != 0.0d && this.h != 0.0d) {
            float[] fArr = new float[10];
            Location.distanceBetween(d, d2, this.f23512c, this.d, fArr);
            if (fArr[0] < 1500.0f) {
                this.i.a(d + this.g, d2 + this.h);
                return;
            }
        }
        if (this.k) {
            return;
        }
        this.f23511a = "{\"source\":101,\"access_token\":\"160e7bd42dec9428721034e0146fc6dd\",\"location\":{\"latitude\":" + d + ",\"longitude\":" + d2 + "}\t}";
        this.e = d;
        this.f = d2;
        C0774b c0774b = new C0774b();
        this.j = c0774b;
        c0774b.start();
    }
}
