package com.kwai.filedownloader.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a/c.class */
public final class c implements a {
    private volatile Thread aGB;
    private Handler handler;
    private volatile List<Integer> aGz = new CopyOnWriteArrayList();
    private AtomicInteger aGA = new AtomicInteger();
    private final b aGw = new b();
    private final d aGx = new d();
    private final long aGy = com.kwai.filedownloader.e.e.Jb().aJs;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.fE("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.a.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.aGB != null) {
                        LockSupport.unpark(c.this.aGB);
                        c.a(c.this, (Thread) null);
                        return false;
                    }
                    return false;
                }
                try {
                    c.this.aGA.set(i);
                    c.this.cN(i);
                    c.this.aGz.add(Integer.valueOf(i));
                } finally {
                    c.this.aGA.set(0);
                    if (c.this.aGB != null) {
                        LockSupport.unpark(c.this.aGB);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.aGB = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i) {
        this.aGx.b(this.aGw.cI(i));
        List<com.kwai.filedownloader.c.a> cJ = this.aGw.cJ(i);
        this.aGx.cK(i);
        for (com.kwai.filedownloader.c.a aVar : cJ) {
            this.aGx.a(aVar);
        }
    }

    private boolean cO(int i) {
        return !this.aGz.contains(Integer.valueOf(i));
    }

    private void cP(int i) {
        this.handler.removeMessages(i);
        if (this.aGA.get() != i) {
            cN(i);
            return;
        }
        this.aGB = Thread.currentThread();
        this.handler.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void A(int i, int i2) {
        this.aGw.A(i, i2);
        if (cO(i)) {
            return;
        }
        this.aGx.A(i, i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0414a Hx() {
        return this.aGx.a(this.aGw.aGt, this.aGw.aGu);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2, long j) {
        this.aGw.a(i, i2, j);
        if (cO(i)) {
            return;
        }
        this.aGx.a(i, i2, j);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j, String str, String str2) {
        this.aGw.a(i, j, str, str2);
        if (cO(i)) {
            return;
        }
        this.aGx.a(i, j, str, str2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, String str, long j, long j2, int i2) {
        this.aGw.a(i, str, j, j2, i2);
        if (cO(i)) {
            return;
        }
        this.aGx.a(i, str, j, j2, i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th) {
        this.aGw.a(i, th);
        if (cO(i)) {
            return;
        }
        this.aGx.a(i, th);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th, long j) {
        this.aGw.a(i, th, j);
        if (cO(i)) {
            cP(i);
        }
        this.aGx.a(i, th, j);
        this.aGz.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        this.aGw.a(aVar);
        if (cO(aVar.getId())) {
            return;
        }
        this.aGx.a(aVar);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        this.aGw.b(cVar);
        if (cO(cVar.getId())) {
            return;
        }
        this.aGx.b(cVar);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i) {
        this.handler.sendEmptyMessageDelayed(i, this.aGy);
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cI(int i) {
        return this.aGw.cI(i);
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cJ(int i) {
        return this.aGw.cJ(i);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cK(int i) {
        this.aGw.cK(i);
        if (cO(i)) {
            return;
        }
        this.aGx.cK(i);
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cL(int i) {
        this.aGx.cL(i);
        return this.aGw.cL(i);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cM(int i) {
        this.aGw.cM(i);
        if (cO(i)) {
            return;
        }
        this.aGx.cM(i);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        this.aGw.clear();
        this.aGx.clear();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i, long j) {
        this.aGw.e(i, j);
        if (cO(i)) {
            return;
        }
        this.aGx.e(i, j);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i, long j) {
        this.aGw.f(i, j);
        if (cO(i)) {
            this.handler.removeMessages(i);
            if (this.aGA.get() == i) {
                this.aGB = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.aGz.remove(Integer.valueOf(i));
        }
        this.aGx.f(i, j);
        this.aGz.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.a.a
    public final void g(int i, long j) {
        this.aGw.g(i, j);
        if (cO(i)) {
            cP(i);
        }
        this.aGx.g(i, j);
        this.aGz.remove(Integer.valueOf(i));
    }
}
