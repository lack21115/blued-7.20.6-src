package com.oplus.quickgame.sdk.engine.callback;

import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.i;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/callback/a.class */
public class a extends Callback {

    /* renamed from: a  reason: collision with root package name */
    private Callback f24401a;

    public void a(Callback callback) {
        b bVar = callback;
        if (callback == null) {
            bVar = new b();
        }
        this.f24401a = bVar;
    }

    @Override // com.oplus.quickgame.sdk.engine.callback.Callback
    public void onResponse(Callback.Response response) {
        if (1 != response.getCode()) {
            HashMap hashMap = new HashMap();
            hashMap.put("failMsg", response.getMsg());
            com.oplus.quickgame.sdk.engine.d.a.b().a().onStat(hashMap);
        }
        i.c("router_response", response.toString());
        Callback callback = this.f24401a;
        if (callback != null) {
            callback.onResponse(response);
            this.f24401a = null;
        }
    }
}
