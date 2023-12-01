package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a.class */
public class a implements Callback<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JceRequestEntity f21268a;
    final /* synthetic */ boolean b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Callback f21269c;
    final /* synthetic */ c d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar, JceRequestEntity jceRequestEntity, boolean z, Callback callback) {
        this.d = cVar;
        this.f21268a = jceRequestEntity;
        this.b = z;
        this.f21269c = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            onFailure(new d(this.f21268a.getType().name(), this.b ? "402" : "452", 200, "raw response == null", null));
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("jceRequest: ");
            sb.append(this.f21268a.getType());
            sb.append(" request success!");
            com.tencent.beacon.base.util.c.a("[BeaconNet]", sb.toString(), new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mode: ");
            sb2.append(this.b ? "socket" : "http");
            com.tencent.beacon.base.util.c.a("[BeaconNet]", sb2.toString(), new Object[0]);
            this.f21269c.onResponse(bArr);
            this.d.f();
        } catch (Exception e) {
            onFailure(new d(this.f21268a.getType().name(), this.b ? "403" : "453", 200, e.getMessage(), e));
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(d dVar) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "jceRequest: " + dVar.toString(), new Object[0]);
        this.d.a(dVar);
        this.f21269c.onFailure(dVar);
        this.d.f();
    }
}
