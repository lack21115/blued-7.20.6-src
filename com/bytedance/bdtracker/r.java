package com.bytedance.bdtracker;

import com.bytedance.applog.Level;
import com.bytedance.bdtracker.z2;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/r.class */
public class r extends t {
    public r(v vVar) {
        super(vVar);
    }

    public static /* synthetic */ String a(boolean z, JSONObject jSONObject) {
        return "getAbConfig (changed:" + z + ") " + jSONObject;
    }

    @Override // com.bytedance.bdtracker.t
    public boolean c() {
        v vVar = this.e;
        m0 m0Var = vVar.d;
        n0 n0Var = vVar.h;
        JSONObject d = n0Var.d();
        if (n0Var.h() == 0 || d == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", n0Var.d());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        final JSONObject a2 = this.f.j.a(q1.a(this.f.i.a(n0Var.d(), this.e.c().getAbUri(), true, Level.L1), p2.b), jSONObject);
        if (a2 != null) {
            final boolean z = !j1.b(m0Var.a(), a2);
            z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$RWIvapdCEO89H8lRy7hJDzjYQFc
                @Override // com.bytedance.bdtracker.z2.a
                public final String a() {
                    return r.a(z, a2);
                }
            });
            n0Var.f21265c.a(a2);
            n0Var.b(a2);
            d0 d0Var = this.f.w;
            if (d0Var != null) {
                d0Var.onRemoteAbConfigGet(z, a2);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.bytedance.bdtracker.t
    public String d() {
        return "AbConfigure";
    }

    @Override // com.bytedance.bdtracker.t
    public long[] e() {
        return x.i;
    }

    @Override // com.bytedance.bdtracker.t
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.t
    public long h() {
        long j = this.e.d.e.getLong("abtest_fetch_interval", 0L);
        long j2 = j;
        if (j < 600000) {
            j2 = 600000;
        }
        return j2;
    }
}
