package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/q2.class */
public class q2 implements p2 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f37715a;
    private List<HttpProxyRule> b;

    @Override // com.tencent.mapsdk.internal.p2
    public List<HttpProxyRule> a() {
        return this.b;
    }

    public void a(o2 o2Var) {
        this.f37715a = o2Var.f37673a;
        this.b = o2Var.b;
    }

    public void a(List<HttpProxyRule> list) {
        this.b = list;
    }

    public void a(boolean z) {
        this.f37715a = z;
    }

    @Override // com.tencent.mapsdk.internal.p2
    public boolean b() {
        return this.f37715a;
    }
}
