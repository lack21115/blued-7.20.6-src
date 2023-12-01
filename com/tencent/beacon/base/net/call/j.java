package com.tencent.beacon.base.net.call;

import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/j.class */
public class j implements a<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final JceRequestEntity f21300a;
    private long b;

    public j(JceRequestEntity jceRequestEntity) {
        this.f21300a = jceRequestEntity;
    }

    public void a(Callback<byte[]> callback) {
        com.tencent.beacon.a.b.a.a().a(new g(this, callback));
    }

    public void a(Callback<byte[]> callback, com.tencent.beacon.a.b.a aVar) {
        aVar.a(new h(this, callback));
    }

    public void b(Callback<byte[]> callback) {
        this.b = new Date().getTime();
        com.tencent.beacon.base.net.c.c().a(this.f21300a, new i(this, callback));
    }
}
