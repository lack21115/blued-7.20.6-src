package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f0.class */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private m0 f37424a;

    public f0(m0 m0Var) {
        this.f37424a = null;
        this.f37424a = m0Var;
    }

    public void a() {
        if (this.f37424a != null) {
            this.f37424a = null;
        }
    }

    public x1 b() {
        m0 m0Var = this.f37424a;
        if (m0Var == null) {
            return null;
        }
        return m0Var.getView();
    }
}
