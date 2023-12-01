package com.tencent.beacon.base.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.b.g;
import com.tencent.beacon.base.net.adapter.AbstractNetAdapter;
import com.tencent.beacon.base.net.adapter.f;
import com.tencent.beacon.base.net.b.e;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.j;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/c.class */
public final class c implements e.a, e, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f21286a;
    private final AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f21287c = new AtomicInteger();
    public com.tencent.beacon.base.net.a.a d;
    public com.tencent.beacon.base.net.a.b e;
    private Context f;
    private AbstractNetAdapter g;
    private AbstractNetAdapter h;

    private c() {
    }

    public static c c() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f21286a == null) {
                    f21286a = new c();
                }
                cVar = f21286a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", Integer.valueOf(this.f21287c.decrementAndGet()));
    }

    private void g() {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", Integer.valueOf(this.f21287c.incrementAndGet()));
    }

    public AbstractNetAdapter a(JceRequestEntity jceRequestEntity) {
        if (jceRequestEntity.getType() == RequestType.EVENT && !com.tencent.beacon.e.b.a().m()) {
            return this.h;
        }
        return this.g;
    }

    public com.tencent.beacon.base.net.call.c a(com.tencent.beacon.base.net.call.e eVar) {
        return new com.tencent.beacon.base.net.call.c(eVar);
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void a() {
        this.b.set(false);
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "network recovery. open BeaconNet.", new Object[0]);
    }

    public void a(Context context, AbstractNetAdapter abstractNetAdapter) {
        this.f = context;
        com.tencent.beacon.base.net.adapter.b bVar = abstractNetAdapter;
        if (abstractNetAdapter == null) {
            bVar = new com.tencent.beacon.base.net.adapter.b();
        }
        this.g = f.a();
        this.h = bVar;
        this.d = com.tencent.beacon.base.net.a.a.a();
        this.e = com.tencent.beacon.base.net.a.b.a();
        com.tencent.beacon.base.net.b.e.a(context, this);
    }

    public void a(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        boolean z = false;
        if (this.b.get()) {
            callback.onFailure(new d(jceRequestEntity.getType().name(), null, 0, "BeaconNet close."));
            return;
        }
        AbstractNetAdapter a2 = a(jceRequestEntity);
        g();
        if (a2 == this.g) {
            z = true;
        }
        a2.request(jceRequestEntity, new a(this, jceRequestEntity, z, callback));
    }

    public void a(com.tencent.beacon.base.net.call.e eVar, Callback<BResponse> callback) {
        if (this.b.get()) {
            callback.onFailure(new d(eVar.h(), null, 0, "BeaconNet close."));
            return;
        }
        g();
        this.h.request(eVar, new b(this, eVar, callback));
    }

    public void a(d dVar) {
        if (dVar.f21301a.equals("atta") || TextUtils.isEmpty(dVar.b)) {
            return;
        }
        g.e().a(dVar.b, dVar.toString(), dVar.e);
    }

    public j b(JceRequestEntity jceRequestEntity) {
        return new j(jceRequestEntity);
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void b() {
        this.b.set(true);
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.set(true);
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
    }

    public boolean d() {
        return this.f21287c.get() >= 5;
    }

    public void e() {
        this.b.set(false);
    }
}
