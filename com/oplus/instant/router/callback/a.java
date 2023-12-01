package com.oplus.instant.router.callback;

import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.g.d;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/callback/a.class */
public class a extends Callback {

    /* renamed from: a  reason: collision with root package name */
    private Callback f24282a;

    public void a(Callback callback) {
        b bVar = callback;
        if (callback == null) {
            bVar = new b();
        }
        this.f24282a = bVar;
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        if (1 != response.getCode()) {
            HashMap hashMap = new HashMap();
            hashMap.put("failMsg", response.getMsg());
            com.oplus.instant.router.f.a.a().b().onStat(hashMap);
        }
        d.b("router_response", response.toString());
        Callback callback = this.f24282a;
        if (callback != null) {
            callback.onResponse(response);
            this.f24282a = null;
        }
    }
}
