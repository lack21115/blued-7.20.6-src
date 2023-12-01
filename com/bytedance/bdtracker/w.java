package com.bytedance.bdtracker;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w.class */
public class w extends t {
    public final String g;
    public int h;

    public w(v vVar, String str) {
        super(vVar);
        this.h = 0;
        this.g = str;
    }

    @Override // com.bytedance.bdtracker.t
    public boolean c() {
        int i = this.f.j.a((JSONObject) null, this.g) ? 0 : this.h + 1;
        this.h = i;
        if (i > 3) {
            this.f.setRangersEventVerifyEnable(false, this.g);
            return true;
        }
        return true;
    }

    @Override // com.bytedance.bdtracker.t
    public String d() {
        return "RangersEventVerify";
    }

    @Override // com.bytedance.bdtracker.t
    public long[] e() {
        return new long[]{1000};
    }

    @Override // com.bytedance.bdtracker.t
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.t
    public long h() {
        return 1000L;
    }
}
