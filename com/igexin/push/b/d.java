package com.igexin.push.b;

import android.security.KeyChain;
import com.tencent.tendinsv.a.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/d.class */
public final class d {
    private static final String f = "DT_DetectResult";

    /* renamed from: a  reason: collision with root package name */
    String f23308a;
    int b;
    private String g;
    private int h;
    private int i;

    /* renamed from: c  reason: collision with root package name */
    long f23309c = 2147483647L;
    long d = -1;
    boolean e = true;
    private final int j = 1;

    public d() {
    }

    public d(String str, int i) {
        this.g = str;
        this.b = i;
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(long j) {
        this.f23309c = j;
    }

    private void b(long j) {
        this.d = j;
    }

    private void b(String str) {
        this.f23308a = str;
    }

    private void b(boolean z) {
        this.e = z;
    }

    private String g() {
        return this.f23308a;
    }

    private int h() {
        return this.b;
    }

    private void i() {
        this.f23308a = null;
        this.h = 0;
        this.e = true;
    }

    private boolean j() {
        return this.f23308a != null && System.currentTimeMillis() - this.d <= b.d && this.h <= 0;
    }

    public final String a() {
        String str;
        synchronized (this) {
            str = this.g;
        }
        return str;
    }

    public final String a(boolean z) {
        synchronized (this) {
            if (j()) {
                if (z) {
                    this.h++;
                }
                this.e = false;
                return this.f23308a;
            }
            this.f23308a = null;
            this.h = 0;
            this.e = true;
            com.igexin.c.a.c.a.a("DT_DetectResult|disc, ip is invalid, use domain = " + this.g, new Object[0]);
            if (z) {
                this.i++;
            }
            return this.g;
        }
    }

    public final void a(String str) {
        synchronized (this) {
            this.g = str;
        }
    }

    public final void a(String str, long j, long j2) {
        synchronized (this) {
            this.f23308a = str;
            this.f23309c = j;
            this.d = j2;
            this.h = 0;
            this.i = 0;
            this.e = false;
        }
    }

    public final void b() {
        synchronized (this) {
            this.f23308a = null;
            this.f23309c = 2147483647L;
            this.d = -1L;
            this.e = true;
            this.h = 0;
        }
    }

    public final long c() {
        long j;
        synchronized (this) {
            j = this.f23309c;
        }
        return j;
    }

    public final boolean d() {
        synchronized (this) {
            if (j()) {
                return true;
            }
            if (this.i <= 0) {
                return true;
            }
            this.i = 0;
            return false;
        }
    }

    public final void e() {
        synchronized (this) {
            this.h = 0;
            this.i = 0;
        }
    }

    public final JSONObject f() {
        if (this.g == null || this.f23308a == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("domain", this.g);
            jSONObject.put(b.a.q, this.f23308a);
            if (this.f23309c != 2147483647L) {
                jSONObject.put("consumeTime", this.f23309c);
            }
            jSONObject.put(KeyChain.EXTRA_PORT, this.b);
            if (this.d != -1) {
                jSONObject.put("detectSuccessTime", this.d);
            }
            jSONObject.put("isDomain", this.e);
            jSONObject.put("connectTryCnt", 1);
            return jSONObject;
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(f, e.toString());
            return null;
        }
    }
}
