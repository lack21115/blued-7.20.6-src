package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.BResponse;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/c.class */
public class c implements a<BResponse> {

    /* renamed from: a  reason: collision with root package name */
    private e f21291a;

    public c(e eVar) {
        this.f21291a = eVar;
    }

    public void a(Callback<BResponse> callback) {
        com.tencent.beacon.base.net.c.c().a(this.f21291a, new b(this, callback));
    }
}
