package com.tencent.qimei.u;

import com.tencent.qimei.shellapi.IDependency;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/u/a.class */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f38418a;
    public b b;

    public a(String str) {
        this.f38418a = str;
    }

    @Override // com.tencent.qimei.u.b
    public String H() {
        return a() == null ? "" : a().H();
    }

    @Override // com.tencent.qimei.u.b
    public String I() {
        return a() == null ? "" : a().I();
    }

    @Override // com.tencent.qimei.u.b
    public String K() {
        return a() == null ? "" : a().K();
    }

    @Override // com.tencent.qimei.u.b
    public String L() {
        return a() == null ? "" : a().L();
    }

    @Override // com.tencent.qimei.u.b
    public void M() {
        if (a() == null) {
            return;
        }
        a().M();
    }

    @Override // com.tencent.qimei.u.b
    public String N() {
        return a() == null ? "" : a().N();
    }

    public final b a() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar;
        }
        com.tencent.qimei.t.b a2 = com.tencent.qimei.t.b.a();
        IDependency a3 = a2.a("BizInfo" + this.f38418a);
        if (a3 instanceof b) {
            b bVar2 = (b) a3;
            this.b = bVar2;
            return bVar2;
        }
        return null;
    }
}
