package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/d.class */
public class d implements Callback<BResponse> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f21236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f21236a = eVar;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(BResponse bResponse) {
        if (bResponse != null) {
            com.tencent.beacon.base.util.c.a("AttaReport", "oversea net ret: " + bResponse.toString(), new Object[0]);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
    }
}
