package com.alibaba.mtl.log.c;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f4487a;
    private List<com.alibaba.mtl.log.model.a> l = new CopyOnWriteArrayList();
    private Runnable b = new Runnable() { // from class: com.alibaba.mtl.log.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.G();
        }
    };

    /* renamed from: a  reason: collision with other field name */
    private com.alibaba.mtl.log.c.a f33a = new b(com.alibaba.mtl.log.a.getContext());

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/c/c$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.H();
            if (c.this.f33a.g() > 9000) {
                c.this.I();
            }
        }
    }

    private c() {
        com.alibaba.mtl.log.d.a.a().start();
        r.a().b(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -3);
        this.f33a.c("time", String.valueOf(calendar.getTimeInMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.f33a.e(1000);
    }

    public static c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f4487a == null) {
                    f4487a = new c();
                }
                cVar = f4487a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public void G() {
        synchronized (this) {
            i.a("LogStoreMgr", "[store]");
            ArrayList arrayList = null;
            try {
                synchronized (this.l) {
                    if (this.l.size() > 0) {
                        arrayList = new ArrayList(this.l);
                        this.l.clear();
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    this.f33a.mo2170a((List<com.alibaba.mtl.log.model.a>) arrayList);
                }
            } catch (Throwable th) {
            }
        }
    }

    public int a(List<com.alibaba.mtl.log.model.a> list) {
        i.a("LogStoreMgr", list);
        return this.f33a.a(list);
    }

    public List<com.alibaba.mtl.log.model.a> a(String str, int i) {
        List<com.alibaba.mtl.log.model.a> a2 = this.f33a.a(str, i);
        i.a("LogStoreMgr", "[get]", a2);
        return a2;
    }

    public void a(com.alibaba.mtl.log.model.a aVar) {
        i.a("LogStoreMgr", "[add] :", aVar.X);
        com.alibaba.mtl.log.b.a.m(aVar.T);
        this.l.add(aVar);
        if (this.l.size() >= 100) {
            r.a().f(1);
            r.a().a(1, this.b, 0L);
        } else if (r.a().b(1)) {
        } else {
            r.a().a(1, this.b, 5000L);
        }
    }

    public void clear() {
        i.a("LogStoreMgr", "[clear]");
        this.f33a.clear();
        this.l.clear();
    }
}
