package com.bytedance.bdtracker;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i0.class */
public abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f21229a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21230c;
    public boolean d;

    public i0(boolean z, boolean z2) {
        this.b = z;
        this.f21230c = z2;
        this.d = false;
    }

    public i0(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.f21230c = z2;
        this.d = z3;
    }

    public abstract boolean a(JSONObject jSONObject);
}
