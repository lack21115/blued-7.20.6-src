package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.NetException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/b.class */
class b implements Callback<BResponse> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callback f21290a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, Callback callback) {
        this.b = cVar;
        this.f21290a = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(BResponse bResponse) throws NetException {
        Callback callback = this.f21290a;
        if (callback != null) {
            callback.onResponse(bResponse);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        Callback callback = this.f21290a;
        if (callback != null) {
            callback.onFailure(dVar);
        }
    }
}
