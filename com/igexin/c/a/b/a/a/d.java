package com.igexin.c.a.b.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.igexin.push.c.c;
import com.igexin.push.core.d;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/d.class */
public final class d {
    static final Object i = new Object();
    private static final String n = "GS-M";

    /* renamed from: a  reason: collision with root package name */
    Socket f23224a;
    e b;

    /* renamed from: c  reason: collision with root package name */
    g f23225c;
    b d;
    boolean e;
    protected Lock f;
    protected Condition g;
    final List<f> h;
    final Handler j;
    protected ConcurrentLinkedQueue<f> k;
    long l;
    final Comparator<f> m;
    private com.igexin.c.a.b.d o;
    private final AtomicBoolean p;

    /* renamed from: com.igexin.c.a.b.a.a.d$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/d$1.class */
    final class AnonymousClass1 implements com.igexin.c.a.b.a.a.a.d {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            com.igexin.c.a.c.a.a(d.n, "connect hand INTERRUPT_SUCCESS");
            d.this.j.sendEmptyMessage(j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void a(Exception exc) {
            com.igexin.c.a.c.a.a(d.n, "connect exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|c ex = " + exc.toString(), new Object[0]);
            d.this.c();
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void a(Socket socket) {
            Message obtain = Message.obtain();
            obtain.obj = socket;
            obtain.what = j.f23237c - 1;
            d.this.j.sendMessage(obtain);
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void b() {
            d.this.j.sendEmptyMessage(j.e - 1);
        }
    }

    /* renamed from: com.igexin.c.a.b.a.a.d$2  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/d$2.class */
    final class AnonymousClass2 implements com.igexin.c.a.b.a.a.a.b {
        AnonymousClass2() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            d.this.j.sendEmptyMessage(j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.b
        public final void a(Exception exc) {
            com.igexin.c.a.c.a.a(d.n, "readTask exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|r ex = " + exc.toString(), new Object[0]);
            if (exc.getMessage() == null || !exc.getMessage().equals("end of stream")) {
                d.this.c();
            } else {
                c.b.a().c();
            }
        }

        @Override // com.igexin.c.a.b.a.a.a.b
        public final void b() {
        }
    }

    /* renamed from: com.igexin.c.a.b.a.a.d$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/d$3.class */
    final class AnonymousClass3 implements com.igexin.c.a.b.a.a.a.c {
        AnonymousClass3() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            d.this.j.sendEmptyMessage(j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.c
        public final void a(f fVar) {
            d dVar = d.this;
            if (fVar.B <= 0 || fVar.G == null) {
                fVar.k();
                return;
            }
            fVar.z = System.currentTimeMillis();
            synchronized (d.i) {
                dVar.h.add(fVar);
                Collections.sort(dVar.h, dVar.m);
                fVar.d.getClass().getSimpleName();
                dVar.l = TimeUnit.SECONDS.toMillis(dVar.h.get(0).B);
                if (dVar.l > 0 && dVar.h.size() == 1) {
                    fVar.d.getClass().getSimpleName();
                    com.igexin.c.a.c.a.a("GS-M|add : " + fVar.toString() + " --- " + fVar.d.getClass().getName() + " set response timeout delay = " + dVar.l, new Object[0]);
                    Message obtain = Message.obtain();
                    obtain.what = j.h - 1;
                    obtain.obj = fVar.d.getClass().getSimpleName();
                    dVar.j.sendMessageDelayed(obtain, dVar.l);
                }
                dVar.h.size();
            }
        }

        @Override // com.igexin.c.a.b.a.a.a.c
        public final void a(Exception exc) {
            com.igexin.c.a.c.a.a(d.n, "writeTask exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|w ex = " + exc.toString(), new Object[0]);
            d.this.c();
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/d$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f23230a = new d((byte) 0);

        private a() {
        }
    }

    private d() {
        this.p = new AtomicBoolean(false);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f = reentrantLock;
        this.g = reentrantLock.newCondition();
        this.h = new ArrayList();
        this.k = new ConcurrentLinkedQueue<>();
        this.m = new Comparator<f>() { // from class: com.igexin.c.a.b.a.a.d.4
            private static int a(f fVar, f fVar2) {
                if (fVar == null) {
                    return 1;
                }
                if (fVar2 == null) {
                    return -1;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    return Long.compare(fVar.B + fVar.z, fVar2.B + fVar2.z);
                }
                if (fVar.B + fVar.z > fVar2.B + fVar2.z) {
                    return 1;
                }
                return ((long) fVar.B) + fVar.z < ((long) fVar2.B) + fVar2.z ? -1 : 0;
            }

            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(f fVar, f fVar2) {
                f fVar3 = fVar;
                f fVar4 = fVar2;
                if (fVar3 == null) {
                    return 1;
                }
                if (fVar4 == null) {
                    return -1;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    return Long.compare(fVar3.B + fVar3.z, fVar4.B + fVar4.z);
                }
                if (fVar3.B + fVar3.z > fVar4.B + fVar4.z) {
                    return 1;
                }
                return ((long) fVar3.B) + fVar3.z < ((long) fVar4.B) + fVar4.z ? -1 : 0;
            }
        };
        this.j = d.a.a().e;
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public static d a() {
        return a.f23230a;
    }

    private void a(Object obj) {
        com.igexin.c.a.c.a.b(n, ((String) obj) + " write task response timeout");
        c();
    }

    private void b(f fVar) {
        if (fVar.B <= 0 || fVar.G == null) {
            fVar.k();
            return;
        }
        fVar.z = System.currentTimeMillis();
        synchronized (i) {
            this.h.add(fVar);
            Collections.sort(this.h, this.m);
            fVar.d.getClass().getSimpleName();
            long millis = TimeUnit.SECONDS.toMillis(this.h.get(0).B);
            this.l = millis;
            if (millis > 0 && this.h.size() == 1) {
                fVar.d.getClass().getSimpleName();
                com.igexin.c.a.c.a.a("GS-M|add : " + fVar.toString() + " --- " + fVar.d.getClass().getName() + " set response timeout delay = " + this.l, new Object[0]);
                Message obtain = Message.obtain();
                obtain.what = j.h - 1;
                obtain.obj = fVar.d.getClass().getSimpleName();
                this.j.sendMessageDelayed(obtain, this.l);
            }
            this.h.size();
        }
    }

    private void b(Socket socket) throws Exception {
        e eVar = new e(new h(socket.getInputStream()), this.o);
        this.b = eVar;
        eVar.k = new AnonymousClass2();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.b, true);
    }

    private void c(Socket socket) throws Exception {
        g gVar = new g(new i(socket.getOutputStream()), this.o);
        this.f23225c = gVar;
        gVar.j = new AnonymousClass3();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.f23225c, true);
    }

    private static void k() {
        d.a.a();
        com.igexin.push.d.a.a(j.f23236a);
    }

    private void l() {
        j();
        if ((this.d == null && this.f23225c == null && this.b == null) || i()) {
            b();
        } else {
            h();
        }
    }

    private void m() {
        Socket socket = this.f23224a;
        boolean z = (socket == null || socket.isClosed()) ? false : true;
        if (!z && this.d == null) {
            com.igexin.c.a.c.a.a("GS-M|disconnect = true, reconnect", new Object[0]);
            this.d = new b(new AnonymousClass1());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.d, true);
            return;
        }
        com.igexin.c.a.c.a.a("GS-Mstart connect, isConnected = " + z + ", ctask = " + this.d, new Object[0]);
    }

    private void n() {
        g gVar = this.f23225c;
        if (gVar != null) {
            gVar.l = null;
            this.f23225c = null;
        }
        e eVar = this.b;
        if (eVar != null) {
            eVar.j = null;
            this.b = null;
        }
        this.d = null;
        this.f23224a = null;
    }

    private void o() {
        if (!i() || this.e) {
            return;
        }
        b();
        this.e = true;
    }

    private boolean p() {
        Socket socket = this.f23224a;
        return (socket == null || socket.isClosed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(f fVar) {
        try {
            try {
                this.f.lock();
                this.k.offer(fVar);
                this.g.signalAll();
                try {
                    this.f.unlock();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                }
            } catch (Throwable th) {
                try {
                    this.f.unlock();
                } catch (Exception e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
                throw th;
            }
        } catch (Exception e3) {
            com.igexin.c.a.c.a.a(e3);
            try {
                this.f.unlock();
            } catch (Exception e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
    }

    public final void a(com.igexin.c.a.b.d dVar) {
        this.o = dVar;
        e eVar = this.b;
        if (eVar != null) {
            eVar.l = dVar;
        }
        g gVar = this.f23225c;
        if (gVar != null) {
            gVar.k = dVar;
        }
    }

    public final void a(String str) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (i) {
            com.igexin.c.a.c.a.a("GS-M|" + str + " -- resp,no timeout", new Object[0]);
            this.l = 0L;
            Iterator<f> it = this.h.iterator();
            String str2 = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                f next = it.next();
                if (next.G.a(currentTimeMillis, next)) {
                    next.k();
                    next.G.c();
                    it.remove();
                    z = true;
                    break;
                }
                long b = next.G.b(currentTimeMillis, next);
                if (this.l < 0 || this.l > b) {
                    this.l = b;
                    str2 = next.d.getClass().getSimpleName();
                }
            }
            this.j.removeMessages(j.h - 1);
            if (z) {
                com.igexin.c.a.c.a.a("GS-M|time out", new Object[0]);
                f();
                return;
            }
            if (this.h.size() > 0) {
                f fVar = this.h.get(0);
                fVar.k();
                com.igexin.c.a.b.e.a().a((Object) fVar);
                this.h.remove(fVar);
                fVar.d.getClass().getSimpleName();
                com.igexin.c.a.c.a.a("GS-M|remove : " + fVar.toString() + " -- " + fVar.d.getClass().getSimpleName(), new Object[0]);
            }
            int size = this.h.size();
            com.igexin.c.a.c.a.a("GS-M|r, size = ".concat(String.valueOf(size)), new Object[0]);
            if (size > 0 && this.l > 0 && !TextUtils.isEmpty(str2)) {
                com.igexin.c.a.c.a.a("GS-M|" + str2 + " , set  response timeout = " + this.l, new Object[0]);
                Message obtain = Message.obtain();
                obtain.what = j.h - 1;
                obtain.obj = str2;
                this.j.sendMessageDelayed(obtain, this.l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Socket socket) {
        try {
            if (this.d.g()) {
                return;
            }
            this.f23224a = socket;
            e eVar = new e(new h(socket.getInputStream()), this.o);
            this.b = eVar;
            eVar.k = new AnonymousClass2();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.b, true);
            g gVar = new g(new i(socket.getOutputStream()), this.o);
            this.f23225c = gVar;
            gVar.j = new AnonymousClass3();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.f23225c, true);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a("GS-M|" + e.toString(), new Object[0]);
            com.igexin.c.a.c.a.a(n, "tcpConnect exception =" + e.toString());
            c();
        }
    }

    public final void b() {
        this.p.set(false);
        d.a.a();
        com.igexin.push.d.a.a(j.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (this.p.getAndSet(true)) {
            return;
        }
        this.j.sendEmptyMessage(j.f23236a - 1);
    }

    public final void d() {
        synchronized (this) {
            com.igexin.c.a.c.a.a(n, "disConnect, hand TCP_DISCONNECT");
            this.j.sendEmptyMessage(j.g - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        synchronized (this) {
            this.j.sendEmptyMessage(j.d - 1);
            this.e = false;
        }
    }

    public final void f() {
        synchronized (this) {
            com.igexin.c.a.c.a.a(n, "alarm timeout disconnect");
            com.igexin.c.a.c.a.a("GS-M|alarm timeout disconnect", new Object[0]);
            c();
        }
    }

    public final void g() {
        synchronized (this) {
            com.igexin.c.a.c.a.a(n, "redirect disconnect");
            com.igexin.c.a.c.a.a("GS-M|redirect disconnect", new Object[0]);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() {
        com.igexin.c.a.c.a.a(n, "disconnect");
        com.igexin.c.a.c.a.a("GS-M|disconnect", new Object[0]);
        b bVar = this.d;
        if (bVar != null) {
            bVar.c_();
        }
        g gVar = this.f23225c;
        if (gVar != null) {
            gVar.c_();
        }
        e eVar = this.b;
        if (eVar != null) {
            eVar.c_();
        }
        Socket socket = this.f23224a;
        if (socket != null) {
            try {
                if (socket.isClosed()) {
                    return;
                }
                this.f23224a.close();
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        b bVar = this.d;
        if (bVar == null || bVar.f) {
            e eVar = this.b;
            if (eVar == null || eVar.f) {
                g gVar = this.f23225c;
                if (gVar == null || gVar.f) {
                    n();
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        this.j.removeMessages(j.h - 1);
        com.igexin.c.a.b.e.a().d();
        com.igexin.c.a.c.a.a("GS-M|cancel alrm", new Object[0]);
        synchronized (i) {
            if (!this.h.isEmpty()) {
                for (f fVar : this.h) {
                    fVar.k();
                }
                this.h.clear();
            }
        }
        if (this.k.isEmpty()) {
            return;
        }
        Iterator<f> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
        this.k.clear();
    }
}
