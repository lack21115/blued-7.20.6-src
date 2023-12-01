package com.opos.mobad.h;

import android.content.Context;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.l.g;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/e.class */
public class e extends g {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private s f26203c;
    private Context d;
    private String e;
    private com.opos.mobad.cmn.a.a f;
    private com.opos.mobad.cmn.b.c g;
    private o h;

    public e(Context context, String str, s sVar, com.opos.mobad.cmn.a.d dVar, o oVar, com.opos.mobad.cmn.b.c cVar) {
        super(oVar);
        this.b = 0;
        this.h = new o() { // from class: com.opos.mobad.h.e.2
            @Override // com.opos.mobad.ad.c.a
            public void a(int i, String str2) {
            }

            @Override // com.opos.mobad.ad.c.o
            public void a(p pVar) {
                e.this.a(pVar);
            }

            @Override // com.opos.mobad.ad.c.o
            public void a(q qVar, p pVar) {
                e.this.a(qVar, pVar);
            }

            @Override // com.opos.mobad.ad.c.a
            public void a(List<p> list) {
            }

            @Override // com.opos.mobad.ad.c.o
            public void b(p pVar) {
                e.this.b(pVar);
            }

            @Override // com.opos.mobad.ad.c.o
            public void c(p pVar) {
                e.this.c(pVar);
            }

            @Override // com.opos.mobad.ad.c.o
            public void d(p pVar) {
                e.this.d(pVar);
            }
        };
        this.d = context;
        this.f26203c = sVar;
        this.e = str;
        this.f = new com.opos.mobad.cmn.a.a(context, str, dVar);
        this.g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<p> a(a.C0707a c0707a) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        if (c0707a != null) {
            ArrayList arrayList3 = null;
            try {
                List<AdItemData> f = c0707a.f26482a.f();
                arrayList2 = null;
                if (f != null) {
                    arrayList2 = null;
                    if (f.size() > 0) {
                        Iterator<AdItemData> it = f.iterator();
                        while (true) {
                            arrayList3 = arrayList;
                            arrayList2 = arrayList;
                            if (!it.hasNext()) {
                                break;
                            }
                            ArrayList arrayList4 = arrayList;
                            if (it.next() != null) {
                                ArrayList arrayList5 = arrayList;
                                p b = b(c0707a);
                                if (b != null) {
                                    ArrayList arrayList6 = arrayList;
                                    if (arrayList == null) {
                                        arrayList6 = new ArrayList();
                                    }
                                    ArrayList arrayList7 = arrayList6;
                                    arrayList6.add(b);
                                    arrayList = arrayList6;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterNativeTempletAd", "", (Throwable) e);
                arrayList2 = arrayList3;
            }
        }
        return arrayList2;
    }

    private p b(a.C0707a c0707a) {
        try {
            com.opos.mobad.n.a a2 = com.opos.mobad.h.d.e.a(this.d, c0707a, null);
            if (a2 == null) {
                return null;
            }
            return new com.opos.mobad.h.b.e(this.d, c0707a, this.e, this.f, a2, this.h, this.g);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterNativeTempletAd", "", (Throwable) e);
            return null;
        }
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str, int i) {
        this.b = 0;
        com.opos.mobad.model.b.a(this.d.getApplicationContext()).a(this.d, this.e, 4, str, i, new b.a() { // from class: com.opos.mobad.h.e.1
            @Override // com.opos.mobad.model.b.a
            public void a(int i2, a.C0707a c0707a) {
                String str2;
                String c2;
                String a2;
                String str3;
                if (c0707a != null && c0707a.f26482a.a() == 1) {
                    com.opos.mobad.service.a.a().a(e.this.e, 4, c0707a.b.f(), c0707a.b.b(), c0707a.f26483c.aa(), c0707a.b.a(), c0707a.b.J());
                    e.this.b = c0707a.f26482a.c();
                    e.this.a(-1, com.opos.cmn.a.a(-1));
                    return;
                }
                e.this.b = i2;
                List a3 = e.this.a(c0707a);
                if (a3 != null) {
                    e.this.a(a3);
                    return;
                }
                Context context = e.this.d;
                if (c0707a == null) {
                    str2 = e.this.e;
                    str3 = "";
                    c2 = "";
                    a2 = "";
                } else {
                    String b = c0707a.b.b();
                    str2 = e.this.e;
                    c2 = c0707a.b.c();
                    a2 = c0707a.b.a();
                    str3 = b;
                }
                com.opos.mobad.cmn.a.b.d.a(context, str3, str2, "4", c2, a2, (Map<String, String>) null);
                e.this.a(10301, "render ad failed,ad item data is null.");
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    e.this.b = adData.c();
                }
                e.this.a(i2, str2);
            }
        }, com.opos.mobad.model.b.f26382c);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.b;
    }
}
