package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/b.class */
public class b implements Callback<BResponse> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.base.net.call.e f21279a;
    final /* synthetic */ Callback b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f21280c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, com.tencent.beacon.base.net.call.e eVar, Callback callback) {
        this.f21280c = cVar;
        this.f21279a = eVar;
        this.b = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(BResponse bResponse) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("httpRequest: ");
            sb.append(this.f21279a.h());
            sb.append(" request success!");
            com.tencent.beacon.base.util.c.a("[BeaconNet]", sb.toString(), new Object[0]);
            this.b.onResponse(bResponse);
            this.f21280c.f();
        } catch (Exception e) {
            onFailure(new d(this.f21279a.h(), "453", 200, e.getMessage(), e));
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(d dVar) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "httpRequest: " + dVar.toString(), new Object[0]);
        this.f21280c.a(dVar);
        this.b.onFailure(dVar);
        this.f21280c.f();
    }
}
