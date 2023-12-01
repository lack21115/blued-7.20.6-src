package com.anythink.expressad.exoplayer.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.exoplayer.d.b;
import com.anythink.expressad.exoplayer.d.c;
import com.anythink.expressad.exoplayer.d.e;
import com.anythink.expressad.exoplayer.d.f;
import com.anythink.expressad.exoplayer.d.i;
import com.anythink.expressad.exoplayer.d.j;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/d.class */
public final class d<T extends i> implements b.c<T>, g<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7249a = "PRCustomData";
    public static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7250c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 3;
    private static final String h = "DefaultDrmSessionMgr";
    volatile d<T>.c g;
    private final UUID i;
    private final j<T> j;
    private final n k;
    private final HashMap<String, String> l;
    private final c.a m;
    private final boolean n;
    private final int o;
    private final List<com.anythink.expressad.exoplayer.d.b<T>> p;
    private final List<com.anythink.expressad.exoplayer.d.b<T>> q;
    private Looper r;
    private int s;
    private byte[] t;

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/d$a.class */
    public interface a extends com.anythink.expressad.exoplayer.d.c {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/d$b.class */
    final class b implements j.f<T> {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.d.j.f
        public final void a(byte[] bArr, int i) {
            if (d.this.s == 0) {
                d.this.g.obtainMessage(i, bArr).sendToTarget();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/d$c.class */
    final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (com.anythink.expressad.exoplayer.d.b bVar : d.this.p) {
                if (bVar.b(bArr)) {
                    bVar.a(message.what);
                    return;
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.d.d$d  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/d$d.class */
    public static final class C0124d extends Exception {
        private C0124d(UUID uuid) {
            super("Media does not support uuid: ".concat(String.valueOf(uuid)));
        }

        /* synthetic */ C0124d(UUID uuid, byte b) {
            this(uuid);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/d$e.class */
    public @interface e {
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> hashMap) {
        this(uuid, (j) jVar, nVar, hashMap, false, 3);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> hashMap, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        this(uuid, jVar, nVar, hashMap);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> hashMap, Handler handler, com.anythink.expressad.exoplayer.d.c cVar, boolean z) {
        this(uuid, jVar, nVar, hashMap, z);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> hashMap, Handler handler, com.anythink.expressad.exoplayer.d.c cVar, boolean z, int i) {
        this(uuid, jVar, nVar, hashMap, z, i);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> hashMap, boolean z) {
        this(uuid, jVar, nVar, hashMap, z, 3);
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> hashMap, boolean z, int i) {
        com.anythink.expressad.exoplayer.k.a.a(uuid);
        com.anythink.expressad.exoplayer.k.a.a(jVar);
        com.anythink.expressad.exoplayer.k.a.a(!com.anythink.expressad.exoplayer.b.bi.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.i = uuid;
        this.j = jVar;
        this.k = nVar;
        this.l = hashMap;
        this.m = new c.a();
        this.n = z;
        this.o = i;
        this.s = 0;
        this.p = new ArrayList();
        this.q = new ArrayList();
        if (z) {
            jVar.a("sessionSharing", "enable");
        }
        jVar.a(new b(this, (byte) 0));
    }

    private static d<k> a(n nVar, String str) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            hashMap = null;
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(f7249a, str);
            hashMap = hashMap2;
        }
        return a(com.anythink.expressad.exoplayer.b.bl, nVar, hashMap);
    }

    @Deprecated
    private static d<k> a(n nVar, String str, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            hashMap = null;
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(f7249a, str);
            hashMap = hashMap2;
        }
        d<k> a2 = a(com.anythink.expressad.exoplayer.b.bl, nVar, hashMap);
        if (handler != null && cVar != null) {
            a2.a(handler, cVar);
        }
        return a2;
    }

    private static d<k> a(n nVar, HashMap<String, String> hashMap) {
        return a(com.anythink.expressad.exoplayer.b.bk, nVar, hashMap);
    }

    @Deprecated
    private static d<k> a(n nVar, HashMap<String, String> hashMap, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        d<k> a2 = a(com.anythink.expressad.exoplayer.b.bk, nVar, hashMap);
        if (handler != null && cVar != null) {
            a2.a(handler, cVar);
        }
        return a2;
    }

    private static d<k> a(UUID uuid, n nVar, HashMap<String, String> hashMap) {
        return new d<>(uuid, (j<k>) l.a(uuid), nVar, hashMap, false, 3);
    }

    @Deprecated
    private static d<k> a(UUID uuid, n nVar, HashMap<String, String> hashMap, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        d<k> a2 = a(uuid, nVar, hashMap);
        if (handler != null && cVar != null) {
            a2.a(handler, cVar);
        }
        return a2;
    }

    private static e.a a(com.anythink.expressad.exoplayer.d.e eVar, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(eVar.b);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= eVar.b) {
                break;
            }
            e.a a2 = eVar.a(i2);
            boolean z2 = true;
            if (!a2.a(uuid)) {
                z2 = com.anythink.expressad.exoplayer.b.bj.equals(uuid) && a2.a(com.anythink.expressad.exoplayer.b.bi);
            }
            if (z2 && (a2.f7256c != null || z)) {
                arrayList.add(a2);
            }
            i = i2 + 1;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (com.anythink.expressad.exoplayer.b.bk.equals(uuid)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    break;
                }
                e.a aVar = (e.a) arrayList.get(i4);
                int b2 = aVar.a() ? com.anythink.expressad.exoplayer.e.a.h.b(aVar.f7256c) : -1;
                if (af.f7632a < 23 && b2 == 0) {
                    return aVar;
                }
                if (af.f7632a >= 23 && b2 == 1) {
                    return aVar;
                }
                i3 = i4 + 1;
            }
        }
        return (e.a) arrayList.get(0);
    }

    private String a(String str) {
        return this.j.a(str);
    }

    private void a(int i, byte[] bArr) {
        com.anythink.expressad.exoplayer.k.a.b(this.p.isEmpty());
        if (i == 1 || i == 3) {
            com.anythink.expressad.exoplayer.k.a.a(bArr);
        }
        this.s = i;
        this.t = bArr;
    }

    private void a(com.anythink.expressad.exoplayer.d.c cVar) {
        this.m.a(cVar);
    }

    private void a(String str, String str2) {
        this.j.a(str, str2);
    }

    private void a(String str, byte[] bArr) {
        this.j.a(str, bArr);
    }

    private byte[] b(String str) {
        return this.j.b(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final f<T> a(Looper looper, com.anythink.expressad.exoplayer.d.e eVar) {
        e.a aVar;
        com.anythink.expressad.exoplayer.d.b<T> bVar;
        Looper looper2 = this.r;
        com.anythink.expressad.exoplayer.k.a.b(looper2 == null || looper2 == looper);
        if (this.p.isEmpty()) {
            this.r = looper;
            if (this.g == null) {
                this.g = new c(looper);
            }
        }
        if (this.t == null) {
            aVar = a(eVar, this.i, false);
            if (aVar == null) {
                C0124d c0124d = new C0124d(this.i, (byte) 0);
                this.m.a(c0124d);
                return new h(new f.a(c0124d));
            }
        } else {
            aVar = null;
        }
        if (this.n) {
            byte[] bArr = aVar != null ? aVar.f7256c : null;
            Iterator<com.anythink.expressad.exoplayer.d.b<T>> it = this.p.iterator();
            do {
                bVar = null;
                if (!it.hasNext()) {
                    break;
                }
                bVar = it.next();
            } while (!bVar.a(bArr));
        } else {
            bVar = this.p.isEmpty() ? null : this.p.get(0);
        }
        com.anythink.expressad.exoplayer.d.b<T> bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new com.anythink.expressad.exoplayer.d.b<>(this.i, this.j, this, aVar, this.s, this.t, this.l, this.k, looper, this.m, this.o);
            this.p.add(bVar2);
        }
        bVar2.a();
        return bVar2;
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a() {
        for (com.anythink.expressad.exoplayer.d.b<T> bVar : this.q) {
            bVar.d();
        }
        this.q.clear();
    }

    public final void a(Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        this.m.a(handler, cVar);
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a(com.anythink.expressad.exoplayer.d.b<T> bVar) {
        this.q.add(bVar);
        if (this.q.size() == 1) {
            bVar.c();
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final void a(f<T> fVar) {
        if (fVar instanceof h) {
            return;
        }
        com.anythink.expressad.exoplayer.d.b<T> bVar = (com.anythink.expressad.exoplayer.d.b) fVar;
        if (bVar.b()) {
            this.p.remove(bVar);
            if (this.q.size() > 1 && this.q.get(0) == bVar) {
                this.q.get(1).c();
            }
            this.q.remove(bVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a(Exception exc) {
        for (com.anythink.expressad.exoplayer.d.b<T> bVar : this.q) {
            bVar.a(exc);
        }
        this.q.clear();
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final boolean a(com.anythink.expressad.exoplayer.d.e eVar) {
        if (this.t != null) {
            return true;
        }
        if (a(eVar, this.i, true) == null) {
            if (eVar.b != 1 || !eVar.a(0).a(com.anythink.expressad.exoplayer.b.bi)) {
                return false;
            }
            Log.w(h, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.i);
        }
        String str = eVar.f7253a;
        if (str == null || com.anythink.expressad.exoplayer.b.bd.equals(str)) {
            return true;
        }
        return !(com.anythink.expressad.exoplayer.b.be.equals(str) || com.anythink.expressad.exoplayer.b.bg.equals(str) || com.anythink.expressad.exoplayer.b.bf.equals(str)) || af.f7632a >= 25;
    }
}
