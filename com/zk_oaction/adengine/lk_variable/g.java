package com.zk_oaction.adengine.lk_variable;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_variable/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f42011a;
    private HashMap<String, d> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_variable/g$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f42012a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.f42012a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = (d) g.this.b.get(this.f42012a);
            d dVar2 = dVar;
            if (dVar == null) {
                dVar2 = new d(g.this.f42011a, this.f42012a);
                g.this.a(dVar2);
            }
            dVar2.b(this.b);
        }
    }

    public g(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f42011a = cVar;
    }

    public d a(String str) {
        d dVar;
        synchronized (this) {
            dVar = this.b.get(str);
        }
        return dVar;
    }

    public void a() {
        synchronized (this) {
            this.b.clear();
        }
    }

    public void a(d dVar) {
        synchronized (this) {
            if (this.b.get(dVar.c()) == null) {
                this.b.put(dVar.c(), dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        synchronized (this) {
            d dVar = this.b.get(str);
            d dVar2 = dVar;
            if (dVar == null) {
                dVar2 = new d(this.f42011a, str);
                a(dVar2);
            }
            dVar2.a(fVar);
        }
    }

    public void a(String str, String str2) {
        synchronized (this) {
            a aVar = new a(str, str2);
            if (this.f42011a != null) {
                Thread currentThread = Thread.currentThread();
                com.zk_oaction.adengine.lk_sdk.c cVar = this.f42011a;
                if (currentThread != cVar.w) {
                    cVar.y.post(aVar);
                }
            }
            aVar.run();
        }
    }

    public String b(String str) {
        String b;
        StringBuilder sb;
        synchronized (this) {
            if ("screen_height".equals(str) && this.f42011a.g() != 0.0f) {
                sb = new StringBuilder();
                sb.append(this.f42011a.g());
                sb.append("");
            } else if (!"screen_width".equals(str) || this.f42011a.h() == 0.0f) {
                d dVar = this.b.get(str);
                d dVar2 = dVar;
                if (dVar == null) {
                    dVar2 = new d(this.f42011a, str);
                    a(dVar2);
                }
                b = dVar2.b();
            } else {
                sb = new StringBuilder();
                sb.append(this.f42011a.h());
                sb.append("");
            }
            b = sb.toString();
        }
        return b;
    }
}
