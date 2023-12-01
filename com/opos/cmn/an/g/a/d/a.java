package com.opos.cmn.an.g.a.d;

import android.content.Context;
import com.opos.cmn.an.g.a.a.b;
import com.opos.cmn.an.g.c;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/a/d/a.class */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private Map<Long, b> f24544a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.c
    public g a(Context context, long j, f fVar) throws Exception {
        g gVar;
        if (context == null || fVar == null) {
            gVar = null;
        } else {
            b bVar = new b(context, fVar);
            this.f24544a.put(Long.valueOf(j), bVar);
            gVar = bVar.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("execute taskCode=");
        sb.append(j);
        sb.append(",netRequest=");
        sb.append(fVar != null ? fVar.toString() : com.igexin.push.core.b.l);
        sb.append(",netResponse=");
        String str = com.igexin.push.core.b.l;
        if (gVar != null) {
            str = gVar.toString();
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("HttpsExecutorImpl", sb.toString());
        return gVar;
    }

    @Override // com.opos.cmn.an.g.c
    public void a(long j) throws Exception {
        com.opos.cmn.an.f.a.b("HttpsExecutorImpl", "shutDown taskCode=" + j);
        Map<Long, b> map = this.f24544a;
        if (map == null || !map.containsKey(Long.valueOf(j))) {
            return;
        }
        b bVar = this.f24544a.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.b();
        }
        this.f24544a.remove(Long.valueOf(j));
    }
}
