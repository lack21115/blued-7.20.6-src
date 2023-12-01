package com.tencent.tmsbeacon.base.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter;
import com.tencent.tmsbeacon.base.net.adapter.f;
import com.tencent.tmsbeacon.base.net.b.e;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.base.net.call.j;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/c.class */
public final class c implements e.a, e, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f39506a;
    private final AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f39507c = new AtomicInteger();
    public com.tencent.tmsbeacon.base.net.a.a d;
    public com.tencent.tmsbeacon.base.net.a.b e;
    private Context f;
    private AbstractNetAdapter g;
    private AbstractNetAdapter h;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/c$a.class */
    public class a implements Callback<byte[]> {
        public final /* synthetic */ JceRequestEntity b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f39508c;
        public final /* synthetic */ Callback d;

        public a(JceRequestEntity jceRequestEntity, boolean z, Callback callback) {
            this.b = jceRequestEntity;
            this.f39508c = z;
            this.d = callback;
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        /* renamed from: a */
        public void onResponse(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                onFailure(new d(this.b.getType().name(), this.f39508c ? "402" : "452", 200, "raw response == null", null));
                return;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("jceRequest: ");
                sb.append(this.b.getType());
                sb.append(" request success!");
                com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", sb.toString(), new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("mode: ");
                sb2.append(this.f39508c ? "socket" : "http");
                com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", sb2.toString(), new Object[0]);
                this.d.onResponse(bArr);
                c.this.f();
            } catch (Exception e) {
                onFailure(new d(this.b.getType().name(), this.f39508c ? "403" : "453", 200, e.getMessage(), e));
            }
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        public void onFailure(d dVar) {
            com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "jceRequest: " + dVar.toString(), new Object[0]);
            c.this.a(dVar);
            this.d.onFailure(dVar);
            c.this.f();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/c$b.class */
    public class b implements Callback<BResponse> {
        public final /* synthetic */ com.tencent.tmsbeacon.base.net.call.e b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Callback f39509c;

        public b(com.tencent.tmsbeacon.base.net.call.e eVar, Callback callback) {
            this.b = eVar;
            this.f39509c = callback;
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        /* renamed from: a */
        public void onResponse(BResponse bResponse) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("httpRequest: ");
                sb.append(this.b.h());
                sb.append(" request success!");
                com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", sb.toString(), new Object[0]);
                this.f39509c.onResponse(bResponse);
                c.this.f();
            } catch (Exception e) {
                onFailure(new d(this.b.h(), "453", 200, e.getMessage(), e));
            }
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        public void onFailure(d dVar) {
            com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "httpRequest: " + dVar.toString(), new Object[0]);
            c.this.a(dVar);
            this.f39509c.onFailure(dVar);
            c.this.f();
        }
    }

    private c() {
    }

    public static c c() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f39506a == null) {
                    f39506a = new c();
                }
                cVar = f39506a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", Integer.valueOf(this.f39507c.decrementAndGet()));
    }

    private void g() {
        com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", Integer.valueOf(this.f39507c.incrementAndGet()));
    }

    public AbstractNetAdapter a(JceRequestEntity jceRequestEntity) {
        if (jceRequestEntity.getType() == RequestType.EVENT && !com.tencent.tmsbeacon.d.b.a().h()) {
            return this.h;
        }
        return this.g;
    }

    public com.tencent.tmsbeacon.base.net.call.c a(com.tencent.tmsbeacon.base.net.call.e eVar) {
        return new com.tencent.tmsbeacon.base.net.call.c(eVar);
    }

    @Override // com.tencent.tmsbeacon.base.net.b.e.a
    public void a() {
        this.b.set(false);
        com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "network recovery. open BeaconNet.", new Object[0]);
    }

    public void a(Context context, AbstractNetAdapter abstractNetAdapter) {
        this.f = context;
        com.tencent.tmsbeacon.base.net.adapter.b bVar = abstractNetAdapter;
        if (abstractNetAdapter == null) {
            bVar = new com.tencent.tmsbeacon.base.net.adapter.b();
        }
        this.g = f.a();
        this.h = bVar;
        this.d = com.tencent.tmsbeacon.base.net.a.a.a();
        this.e = com.tencent.tmsbeacon.base.net.a.b.a();
        com.tencent.tmsbeacon.base.net.b.e.a(context, this);
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
        a2.request(jceRequestEntity, new a(jceRequestEntity, z, callback));
    }

    public void a(com.tencent.tmsbeacon.base.net.call.e eVar, Callback<BResponse> callback) {
        if (this.b.get()) {
            callback.onFailure(new d(eVar.h(), null, 0, "BeaconNet close."));
            return;
        }
        g();
        this.h.request(eVar, new b(eVar, callback));
    }

    public void a(d dVar) {
        if (dVar.f39523a.equals("atta") || TextUtils.isEmpty(dVar.b)) {
            return;
        }
        com.tencent.tmsbeacon.a.b.d.b().a(dVar.b, dVar.toString(), dVar.e);
    }

    public j b(JceRequestEntity jceRequestEntity) {
        return new j(jceRequestEntity);
    }

    @Override // com.tencent.tmsbeacon.base.net.b.e.a
    public void b() {
        this.b.set(true);
        com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.set(true);
        com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
    }

    public boolean d() {
        return this.f39507c.get() >= 5;
    }

    public void e() {
        this.b.set(false);
    }
}
