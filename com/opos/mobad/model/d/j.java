package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.cmn.func.b.b.d;
import com.opos.mobad.c.a.a;
import com.opos.mobad.i.a;
import com.opos.mobad.model.data.CustomInfoData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/j.class */
public class j implements o {

    /* renamed from: a  reason: collision with root package name */
    private Context f26435a;
    private com.opos.mobad.model.a.c b;

    public j(Context context) {
        this.f26435a = context;
        this.b = new com.opos.mobad.model.a.a.c(context);
    }

    private com.opos.mobad.i.a a(com.opos.mobad.model.b.e eVar) {
        try {
            return new a.C0699a().a(new d.a().a("GET").b(eVar.a()).a()).a(eVar.b()).b(eVar.c()).a(0).a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, q qVar) {
        if (qVar == null) {
            return;
        }
        int i2 = 1;
        if (i != 0) {
            if (i == 1) {
                qVar.a(str, 2);
                return;
            }
            i2 = 3;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return;
                }
            }
        }
        qVar.a(str, i2);
    }

    private boolean a(com.opos.mobad.model.b.f fVar, com.opos.mobad.model.b.g gVar, q qVar) {
        if (fVar == null || gVar == null) {
            return false;
        }
        try {
            ConcurrentHashMap<String, com.opos.mobad.i.a> a2 = fVar.a();
            ConcurrentHashMap<String, com.opos.mobad.i.b> a3 = gVar.a();
            if (a2 == null || a2.size() <= 0 || a3 == null || a3.size() <= 0) {
                return false;
            }
            int i = 0;
            for (String str : a2.keySet()) {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    com.opos.mobad.i.a aVar = a2.get(str);
                    com.opos.mobad.i.b bVar = a3.get(str);
                    if (bVar == null || !bVar.f26218a) {
                        if (qVar != null && aVar != null && aVar.f26207a != null) {
                            qVar.a(aVar.f26207a.b, 3);
                        }
                        com.opos.cmn.an.f.a.c("FetchMaterialTask", "downloadResponse fail=", bVar);
                    } else {
                        if (qVar != null && aVar != null && aVar.f26207a != null) {
                            qVar.a(aVar.f26207a.b, 1);
                        }
                        i++;
                    }
                }
            }
            return a2.size() == i;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e);
            return false;
        }
    }

    private boolean a(Set<com.opos.mobad.model.b.e> set, final q qVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (com.opos.mobad.model.b.e eVar : set) {
            if (!hashSet.contains(eVar.a())) {
                hashSet.add(eVar.a());
                arrayList.add(new a.b(eVar.a(), z ? eVar.b() : ""));
            }
        }
        if (hashSet.size() <= 0) {
            return true;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.opos.mobad.d.d.a().a(arrayList, new a.InterfaceC0677a() { // from class: com.opos.mobad.model.d.j.1
            @Override // com.opos.mobad.c.a.a.InterfaceC0677a
            public void a() {
                countDownLatch.countDown();
            }

            @Override // com.opos.mobad.c.a.a.InterfaceC0677a
            public void a(String str) {
            }

            @Override // com.opos.mobad.c.a.a.InterfaceC0677a
            public void a(String str, int i) {
                com.opos.cmn.an.f.a.b("FetchMaterialTask", "load:" + str + "," + i);
                if (i == 1 || i == 0) {
                    atomicInteger.incrementAndGet();
                }
                j.this.a(str, i, qVar);
            }
        });
        try {
            countDownLatch.await(30L, TimeUnit.SECONDS);
            return atomicInteger.get() == hashSet.size();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("FetchMaterialTask", "fetch" + e);
            return false;
        }
    }

    private com.opos.mobad.model.b.f b(Set<com.opos.mobad.model.b.e> set) {
        com.opos.mobad.model.b.f fVar;
        com.opos.mobad.model.b.f fVar2 = null;
        if (set != null) {
            fVar2 = null;
            if (set.size() > 0) {
                ConcurrentHashMap<String, com.opos.mobad.i.a> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    for (com.opos.mobad.model.b.e eVar : set) {
                        if (eVar != null && !com.opos.cmn.an.c.a.a(eVar.a())) {
                            concurrentHashMap.put(com.opos.cmn.d.c.a(eVar.a()), a(eVar));
                        }
                    }
                    fVar2 = null;
                } catch (Exception e) {
                    e = e;
                    fVar = null;
                }
                if (concurrentHashMap.size() > 0) {
                    fVar = new com.opos.mobad.model.b.f();
                    try {
                        fVar.a(concurrentHashMap);
                    } catch (Exception e2) {
                        e = e2;
                        com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e);
                        fVar2 = fVar;
                        return fVar2;
                    }
                    fVar2 = fVar;
                }
            }
        }
        return fVar2;
    }

    public boolean a(Set<com.opos.mobad.model.b.e> set) {
        return a(set, null);
    }

    @Override // com.opos.mobad.model.d.o
    public boolean a(Set<com.opos.mobad.model.b.e> set, q qVar) {
        return a(set, qVar, (CustomInfoData) null);
    }

    @Override // com.opos.mobad.model.d.o
    public boolean a(Set<com.opos.mobad.model.b.e> set, q qVar, CustomInfoData customInfoData) {
        if (set == null || set.size() <= 0) {
            return false;
        }
        if (customInfoData != null) {
            try {
                boolean z = true;
                if (customInfoData.b() == 1 || customInfoData.b() == 2) {
                    if (customInfoData.b() != 1) {
                        z = false;
                    }
                    return a(set, qVar, z);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("FetchMaterialTask", "fetchMaterial", (Throwable) e);
                return false;
            }
        }
        com.opos.mobad.model.b.f b = b(set);
        if (b != null) {
            return a(b, this.b.a(b), qVar);
        }
        return false;
    }
}
