package com.tencent.tmsbeacon.base.net.call;

import com.tencent.tmsbeacon.base.net.BResponse;
import com.tencent.tmsbeacon.base.net.NetException;
import com.tencent.tmsbeacon.base.net.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/c.class */
public class c implements com.tencent.tmsbeacon.base.net.call.a<BResponse> {

    /* renamed from: a  reason: collision with root package name */
    private e f25821a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/c$a.class */
    public class a implements Callback<BResponse> {
        public final /* synthetic */ Callback b;

        public a(Callback callback) {
            this.b = callback;
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        /* renamed from: a */
        public void onResponse(BResponse bResponse) throws NetException {
            Callback callback = this.b;
            if (callback != null) {
                callback.onResponse(bResponse);
            }
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        public void onFailure(d dVar) {
            Callback callback = this.b;
            if (callback != null) {
                callback.onFailure(dVar);
            }
        }
    }

    public c(e eVar) {
        this.f25821a = eVar;
    }

    public void a(Callback<BResponse> callback) {
        com.tencent.tmsbeacon.base.net.c.c().a(this.f25821a, new a(callback));
    }
}
