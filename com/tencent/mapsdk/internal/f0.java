package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f0.class */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private m0 f23733a;

    public f0(m0 m0Var) {
        this.f23733a = null;
        this.f23733a = m0Var;
    }

    public void a() {
        if (this.f23733a != null) {
            this.f23733a = null;
        }
    }

    public x1 b() {
        m0 m0Var = this.f23733a;
        if (m0Var == null) {
            return null;
        }
        return m0Var.getView();
    }
}
