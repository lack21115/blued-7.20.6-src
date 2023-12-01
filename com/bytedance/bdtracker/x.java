package com.bytedance.bdtracker;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/x.class */
public class x extends t {
    public static final long[] h = {60000, 60000, 60000, com.igexin.push.config.c.l, com.igexin.push.config.c.l, 180000, 180000, 360000, 360000, 540000, 540000};
    public static final long[] i = {180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    public static final long[] j = {10000, 10000, 20000, 20000, 60000, 60000, com.igexin.push.config.c.l, com.igexin.push.config.c.l, 180000, 180000, 360000, 360000, 540000, 540000};
    public String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(v vVar) {
        super(vVar);
        long optLong = vVar.h.d.optLong("register_time", 0L);
        this.f7701c = optLong;
        this.g = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.json.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 745
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.x.a(org.json.JSONObject):boolean");
    }

    @Override // com.bytedance.bdtracker.t
    public boolean c() {
        JSONObject jSONObject = new JSONObject();
        j1.a(jSONObject, this.e.h.d());
        return a(jSONObject);
    }

    @Override // com.bytedance.bdtracker.t
    public String d() {
        return "register";
    }

    @Override // com.bytedance.bdtracker.t
    public long[] e() {
        int h2 = this.e.h.h();
        if (h2 != 0) {
            if (h2 != 1) {
                if (h2 == 2) {
                    return h;
                }
                z2.c("U SHALL NOT PASS!", (Throwable) null);
            }
            return i;
        }
        return j;
    }

    @Override // com.bytedance.bdtracker.t
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.t
    public long h() {
        if (this.e.m.i) {
            return com.anythink.expressad.d.a.b.aD;
        }
        return 43200000L;
    }
}
