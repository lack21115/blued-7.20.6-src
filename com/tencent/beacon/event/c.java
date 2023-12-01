package com.tencent.beacon.event;

import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/c.class */
public class c implements Callback<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventBean f21350a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f21351c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, EventBean eventBean, String str) {
        this.f21351c = dVar;
        this.f21350a = eventBean;
        this.b = str;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) {
        com.tencent.beacon.base.util.c.a("[EventManager]", "convert to report by beacon socket success, eventCode = %s, logId = %s", this.f21350a.getEventCode(), this.b);
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        com.tencent.beacon.base.util.c.e("convert to report by beacon socket also fail, failure = %s", dVar.toString());
        com.tencent.beacon.a.b.g.e().a("464", dVar.toString());
        this.f21351c.b(this.b, this.f21350a);
    }
}
