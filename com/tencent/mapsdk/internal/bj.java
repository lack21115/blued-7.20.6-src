package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bj.class */
public class bj implements yd {

    /* renamed from: a  reason: collision with root package name */
    private de f37332a;
    private gj b;

    /* renamed from: c  reason: collision with root package name */
    private zd f37333c;
    private boolean d;

    public bj(yi yiVar, String str) {
        this.b = yiVar;
        this.f37332a = new ej(yiVar.getContext(), str);
        this.f37333c = new cj(yiVar.getContext(), str);
    }

    @Override // com.tencent.mapsdk.internal.yd
    public void a(boolean z) {
        this.d = z;
    }

    @Override // com.tencent.mapsdk.internal.yd
    public boolean a() {
        return this.d;
    }

    @Override // com.tencent.mapsdk.internal.yd
    public zd b() {
        return this.f37333c;
    }

    @Override // com.tencent.mapsdk.internal.yd
    public ib c() {
        return new aj(this.b);
    }

    @Override // com.tencent.mapsdk.internal.yd
    public de d() {
        return this.f37332a;
    }
}
