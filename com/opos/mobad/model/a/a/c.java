package com.opos.mobad.model.a.a;

import android.content.Context;
import com.opos.mobad.model.b.f;
import com.opos.mobad.model.b.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/a/a/c.class */
public class c implements com.opos.mobad.model.a.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f26378a;

    public c(Context context) {
        this.f26378a = context.getApplicationContext();
    }

    private void a(final g gVar, final CountDownLatch countDownLatch, final String str, final com.opos.mobad.i.a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        gVar.a(str, com.opos.mobad.i.c.a(c.this.f26378a, aVar));
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("FetchMaterialEngine", "", (Throwable) e);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
    }

    @Override // com.opos.mobad.model.a.c
    public g a(f fVar) {
        g gVar;
        g gVar2 = null;
        if (fVar != null) {
            try {
                ConcurrentHashMap<String, com.opos.mobad.i.a> a2 = fVar.a();
                gVar2 = null;
                if (a2 != null) {
                    gVar2 = null;
                    if (a2.size() > 0) {
                        gVar = new g();
                        try {
                            CountDownLatch countDownLatch = new CountDownLatch(a2.size());
                            for (Map.Entry<String, com.opos.mobad.i.a> entry : a2.entrySet()) {
                                if (entry != null) {
                                    a(gVar, countDownLatch, entry.getKey(), entry.getValue());
                                } else {
                                    countDownLatch.countDown();
                                }
                            }
                            countDownLatch.await(30L, TimeUnit.MINUTES);
                            return gVar;
                        } catch (Exception e) {
                            e = e;
                            com.opos.cmn.an.f.a.c("FetchMaterialEngine", "fetchMaterial", e);
                            gVar2 = gVar;
                            return gVar2;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                gVar = null;
            }
        }
        return gVar2;
    }
}
