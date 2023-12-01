package com.opos.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/o.class */
final class o {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private volatile n f27453c;
    private final b e;
    private final l f;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f27452a = new AtomicInteger(0);
    private final List<b> d = new CopyOnWriteArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/o$a.class */
    static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f27454a;
        private final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f27454a = str;
            this.b = list;
        }

        @Override // com.opos.videocache.b
        public void a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (b bVar : this.b) {
                bVar.a((File) message.obj, this.f27454a, message.arg1);
            }
        }
    }

    public o(String str, l lVar) {
        this.b = (String) f.a(str);
        this.f = (l) f.a(lVar);
        this.e = new a(str, this.d);
    }

    private void b() {
        synchronized (this) {
            this.f27453c = this.f27453c == null ? d() : this.f27453c;
        }
    }

    private void c() {
        synchronized (this) {
            if (this.f27452a.decrementAndGet() <= 0) {
                this.f27453c.a();
                this.f27453c = null;
            }
        }
    }

    private n d() {
        n nVar = new n(new d(this.b, this.f.d, this.f.e), new com.opos.videocache.a.b(this.f.a(this.b), this.f.f27447c));
        nVar.a(this.e);
        return nVar;
    }

    public int a() {
        return this.f27452a.get();
    }

    public void a(m mVar, Socket socket) {
        b();
        try {
            this.f27452a.incrementAndGet();
            this.f27453c.a(mVar, socket);
        } finally {
            c();
        }
    }
}
