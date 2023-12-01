package com.opos.cmn.an.g.a.b;

import android.content.Context;
import com.opos.cmn.an.g.b;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/a/b/a.class */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private Map<Long, com.opos.cmn.an.g.a.a.b> f10856a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.b
    public g a(Context context, long j, f fVar) throws Exception {
        g gVar;
        if (context == null || fVar == null) {
            gVar = null;
        } else {
            com.opos.cmn.an.g.a.a.b bVar = new com.opos.cmn.an.g.a.a.b(context, fVar);
            this.f10856a.put(Long.valueOf(j), bVar);
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
        com.opos.cmn.an.f.a.b("HttpExecutorImpl", sb.toString());
        return gVar;
    }

    @Override // com.opos.cmn.an.g.b
    public void a(long j) throws Exception {
        com.opos.cmn.an.f.a.b("HttpExecutorImpl", "shutDown taskCode=" + j);
        Map<Long, com.opos.cmn.an.g.a.a.b> map = this.f10856a;
        if (map == null || !map.containsKey(Long.valueOf(j))) {
            return;
        }
        com.opos.cmn.an.g.a.a.b bVar = this.f10856a.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.b();
        }
        this.f10856a.remove(Long.valueOf(j));
    }
}
