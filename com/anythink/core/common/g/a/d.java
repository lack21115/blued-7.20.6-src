package com.anythink.core.common.g.a;

import com.anythink.core.common.b.n;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.k.h;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a/d.class */
public final class d {
    private static d g;
    private String h;
    private int i;
    private Socket j;

    /* renamed from: c  reason: collision with root package name */
    private final int f6714c = 0;
    private final int d = 7;
    private final int e = 1;
    private final String f = getClass().getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    byte[] f6713a = null;
    byte[] b = new byte[1];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.g.a.d$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a/d$1.class */
    public final class AnonymousClass1 extends com.anythink.core.common.k.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f6715a;
        final /* synthetic */ c.a b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1(c cVar, c.a aVar) {
            this.f6715a = cVar;
            this.b = aVar;
        }

        @Override // com.anythink.core.common.k.b.b
        public final void a() {
            try {
                try {
                    d.this.a(this.f6715a);
                    int e = d.this.e();
                    if (e != 1) {
                        throw new Exception("Response Error Code:".concat(String.valueOf(e)));
                    }
                    if (this.b != null) {
                        this.b.a(this.f6715a);
                    }
                } catch (SocketException e2) {
                    d.b(d.this);
                    d.this.a(this.f6715a);
                    int e3 = d.this.e();
                    if (e3 != 1) {
                        throw new Exception("Response Error Code:".concat(String.valueOf(e3)));
                    }
                    if (this.b != null) {
                        this.b.a(this.f6715a);
                    }
                }
            } catch (Throwable th) {
                c cVar = this.f6715a;
                cVar.a("", th.getMessage() + "," + h.a(th.getStackTrace()), d.this.h, d.this.i);
                c.a aVar = this.b;
                if (aVar != null) {
                    aVar.a(th);
                }
            }
        }
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (g == null) {
                    g = new d();
                }
                dVar = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        synchronized (this) {
            if (!((this.j == null || !this.j.isConnected() || this.j.isClosed()) ? false : true)) {
                synchronized (this) {
                    if (this.j == null) {
                        Socket socket = new Socket();
                        this.j = socket;
                        socket.setSoTimeout(60000);
                    }
                    com.anythink.core.c.a b = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                    if (b != null) {
                        this.h = b.v();
                        this.i = b.w();
                        this.j.connect(new InetSocketAddress(this.h, this.i), 30000);
                    }
                }
            }
            byte[] e = cVar.e();
            if (e != null) {
                int length = e.length;
                if (e.length == 0) {
                    return;
                }
                int i = length + 7;
                if (this.f6713a == null || this.f6713a.length < i) {
                    this.f6713a = new byte[i];
                }
                this.f6713a[0] = 0;
                this.f6713a[1] = 3;
                this.f6713a[2] = (byte) cVar.c();
                this.f6713a[3] = (byte) ((length >>> 24) & 255);
                this.f6713a[4] = (byte) ((length >>> 16) & 255);
                this.f6713a[5] = (byte) ((length >>> 8) & 255);
                this.f6713a[6] = (byte) ((length >>> 0) & 255);
                System.arraycopy((Object) e, 0, (Object) this.f6713a, 7, e.length);
                OutputStream outputStream = this.j.getOutputStream();
                outputStream.write(this.f6713a, 0, i);
                outputStream.flush();
            }
        }
    }

    private void a(c cVar, c.a aVar) {
        com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) new AnonymousClass1(cVar, aVar), 4);
    }

    private void b() {
        synchronized (this) {
            if (this.j == null) {
                Socket socket = new Socket();
                this.j = socket;
                socket.setSoTimeout(60000);
            }
            com.anythink.core.c.a b = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
            if (b != null) {
                this.h = b.v();
                this.i = b.w();
                this.j.connect(new InetSocketAddress(this.h, this.i), 30000);
            }
        }
    }

    static /* synthetic */ void b(d dVar) {
        synchronized (dVar) {
            try {
                if (dVar.j != null) {
                    dVar.j.close();
                    dVar.j = null;
                }
            } catch (Exception e) {
            }
        }
    }

    private void c() {
        synchronized (this) {
            try {
                if (this.j != null) {
                    this.j.close();
                    this.j = null;
                }
            } catch (Exception e) {
            }
        }
    }

    private boolean d() {
        Socket socket = this.j;
        return (socket == null || !socket.isConnected() || this.j.isClosed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        byte b;
        synchronized (this) {
            if (this.j.getInputStream().read(this.b, 0, 1) == -1) {
                throw new SocketException("Socket.InputStream read length = -1!");
            }
            b = this.b[0];
            this.b[0] = 0;
        }
        return b;
    }
}
