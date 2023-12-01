package com.opos.cmn.biz.monitor.a;

import android.content.Context;
import com.opos.cmn.biz.monitor.a.a;
import com.opos.cmn.biz.monitor.b.e;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24629a = c.class.getSimpleName();
    private static c b;
    private Context d;
    private b e;

    /* renamed from: c  reason: collision with root package name */
    private LinkedBlockingQueue<d> f24630c = new LinkedBlockingQueue<>();
    private Object f = new Object();
    private a g = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.1
        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(final a.InterfaceC0625a interfaceC0625a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.1.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(interfaceC0625a);
                }
            });
        }
    }, Integer.MAX_VALUE, 60000);
    private a h = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.2
        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(final a.InterfaceC0625a interfaceC0625a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.2.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(interfaceC0625a);
                }
            });
        }
    }, Integer.MAX_VALUE, 0);

    private int a(List<d> list) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final AtomicInteger atomicInteger = new AtomicInteger();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                try {
                    break;
                } catch (Exception e) {
                    String str = f24629a;
                    com.opos.cmn.an.f.a.b(str, "send cache request error:" + e);
                    return 0;
                }
            }
            final d dVar = list.get(i2);
            new e(this.d, dVar.f24641c, 3, com.opos.cmn.biz.monitor.a.a().b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.c.5
                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a() {
                    countDownLatch.countDown();
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a(byte[] bArr) {
                    if (!com.opos.cmn.biz.monitor.e.a(dVar.f24641c) || e.a(bArr)) {
                        atomicInteger.incrementAndGet();
                        c.this.c(dVar);
                    }
                    countDownLatch.countDown();
                }
            }).a();
            i = i2 + 1;
        }
        if (countDownLatch.await(60000L, TimeUnit.MILLISECONDS)) {
            return atomicInteger.get();
        }
        return 0;
    }

    public static c a() {
        c cVar;
        c cVar2 = b;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            try {
                if (b == null) {
                    b = new c();
                }
                cVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.InterfaceC0625a interfaceC0625a) {
        c(new a.InterfaceC0625a() { // from class: com.opos.cmn.biz.monitor.a.c.3
            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0625a
            public void a() {
                a.InterfaceC0625a interfaceC0625a2 = interfaceC0625a;
                if (interfaceC0625a2 != null) {
                    interfaceC0625a2.a();
                }
                if (c.this.f24630c.isEmpty()) {
                    return;
                }
                c.this.h.a();
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0625a
            public void b() {
                a.InterfaceC0625a interfaceC0625a2 = interfaceC0625a;
                if (interfaceC0625a2 != null) {
                    interfaceC0625a2.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final a.InterfaceC0625a interfaceC0625a) {
        d(new a.InterfaceC0625a() { // from class: com.opos.cmn.biz.monitor.a.c.4
            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0625a
            public void a() {
                c.this.c();
                a.InterfaceC0625a interfaceC0625a2 = interfaceC0625a;
                if (interfaceC0625a2 != null) {
                    interfaceC0625a2.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0625a
            public void b() {
                c.this.c();
                a.InterfaceC0625a interfaceC0625a2 = interfaceC0625a;
                if (interfaceC0625a2 != null) {
                    interfaceC0625a2.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int a2;
        try {
            synchronized (this.f) {
                a2 = this.e.a(System.currentTimeMillis() - 604800000);
            }
            String str = f24629a;
            com.opos.cmn.an.f.a.b(str, "remove expired data size:" + a2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b(f24629a, "remove expired data fail");
        }
    }

    private void c(a.InterfaceC0625a interfaceC0625a) {
        LinkedList linkedList = new LinkedList();
        while (true) {
            d poll = this.f24630c.poll();
            if (poll == null) {
                break;
            }
            linkedList.add(poll);
        }
        if (linkedList.size() > 0) {
            synchronized (this.f) {
                this.e.a(linkedList);
            }
        }
        if (interfaceC0625a != null) {
            interfaceC0625a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        synchronized (this.f) {
            int a2 = this.e.a(dVar);
            String str = f24629a;
            com.opos.cmn.an.f.a.b(str, "delete num:" + a2);
        }
    }

    private void d(a.InterfaceC0625a interfaceC0625a) {
        List<d> a2;
        int a3;
        com.opos.cmn.an.f.a.b(f24629a, "pickResendMonitorAndSend");
        do {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - 604800000;
            long j2 = currentTimeMillis - 60000;
            String str = f24629a;
            com.opos.cmn.an.f.a.b(str, "pick monitor from:" + j + ",to:" + j2);
            synchronized (this.f) {
                a2 = this.e.a(j, j2, 5);
            }
            if (a2 == null || a2.size() <= 0) {
                com.opos.cmn.an.f.a.b(f24629a, "cacheList empty");
                a(false);
                if (interfaceC0625a != null) {
                    interfaceC0625a.a();
                    return;
                }
                return;
            }
            a(true);
            String str2 = f24629a;
            com.opos.cmn.an.f.a.b(str2, "send cacheNum:" + a2.size());
            a3 = a(a2);
            String str3 = f24629a;
            com.opos.cmn.an.f.a.b(str3, "send cache success num:" + a3);
        } while (a3 > 0);
        if (interfaceC0625a != null) {
            interfaceC0625a.b();
        }
    }

    public void a(Context context) {
        this.d = context.getApplicationContext();
        this.e = new b(context);
    }

    public void a(d dVar) {
        this.f24630c.offer(dVar);
        this.h.a();
    }

    public void a(boolean z) {
        String str = f24629a;
        com.opos.cmn.an.f.a.b(str, "setCacheEnable value:" + z);
        Context context = this.d;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ads_monitor_cache", 4).edit().putBoolean("has_monitor_cache", z).commit();
    }

    public void b() {
        this.g.a();
    }

    public void b(final d dVar) {
        if (this.f24630c.remove(dVar)) {
            return;
        }
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                c.this.c(dVar);
            }
        });
    }
}
