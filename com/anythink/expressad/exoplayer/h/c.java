package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/c.class */
public abstract class c implements s {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<s.b> f4598a = new ArrayList<>(1);
    private final t.a b = new t.a();

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.exoplayer.h f4599c;
    private com.anythink.expressad.exoplayer.ae d;
    private Object e;

    private t.a a(s.a aVar, long j) {
        com.anythink.expressad.exoplayer.k.a.a(aVar != null);
        return this.b.a(0, aVar, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t.a a(int i, s.a aVar) {
        return this.b.a(i, aVar, 0L);
    }

    public final t.a a(s.a aVar) {
        return this.b.a(0, aVar, 0L);
    }

    protected abstract void a();

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(Handler handler, t tVar) {
        this.b.a(handler, tVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        this.d = aeVar;
        this.e = obj;
        Iterator<s.b> it = this.f4598a.iterator();
        while (it.hasNext()) {
            it.next().a(this, aeVar, obj);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(s.b bVar) {
        this.f4598a.remove(bVar);
        if (this.f4598a.isEmpty()) {
            this.f4599c = null;
            this.d = null;
            this.e = null;
            a();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(t tVar) {
        this.b.a(tVar);
    }

    protected abstract void a(com.anythink.expressad.exoplayer.h hVar, boolean z);

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z, s.b bVar) {
        com.anythink.expressad.exoplayer.h hVar2 = this.f4599c;
        com.anythink.expressad.exoplayer.k.a.a(hVar2 == null || hVar2 == hVar);
        this.f4598a.add(bVar);
        if (this.f4599c == null) {
            this.f4599c = hVar;
            a(hVar, z);
            return;
        }
        com.anythink.expressad.exoplayer.ae aeVar = this.d;
        if (aeVar != null) {
            bVar.a(this, aeVar, this.e);
        }
    }
}
