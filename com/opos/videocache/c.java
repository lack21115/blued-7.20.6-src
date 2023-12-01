package com.opos.videocache;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f13747a;
    private final ExecutorService b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, o> f13748c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final l g;
    private final q h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private File f13749a;
        private com.opos.videocache.c.b d;

        /* renamed from: c  reason: collision with root package name */
        private com.opos.videocache.a.a f13750c = new com.opos.videocache.a.g(536870912);
        private com.opos.videocache.a.c b = new com.opos.videocache.a.e();
        private com.opos.videocache.b.b e = new com.opos.videocache.b.a();

        public a(Context context) {
            this.d = com.opos.videocache.c.c.a(context);
        }

        private l b() {
            File file = this.f13749a;
            return file == null ? new k(this.b, this.f13750c, this.d, this.e) : new l(file, this.b, this.f13750c, this.d, this.e);
        }

        public a a(int i) {
            this.f13750c = new com.opos.videocache.a.f(i);
            return this;
        }

        public a a(long j) {
            this.f13750c = new com.opos.videocache.a.g(j);
            return this;
        }

        public a a(com.opos.videocache.a.c cVar) {
            this.b = (com.opos.videocache.a.c) f.a(cVar);
            return this;
        }

        public a a(com.opos.videocache.b.b bVar) {
            this.e = (com.opos.videocache.b.b) f.a(bVar);
            return this;
        }

        public c a() {
            return new c(b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/c$b.class */
    public final class b implements Runnable {
        private final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.b);
        }
    }

    /* renamed from: com.opos.videocache.c$c  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/c$c.class */
    final class RunnableC0569c implements Runnable {
        private final CountDownLatch b;

        public RunnableC0569c(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.countDown();
            c.this.b();
        }
    }

    private c(l lVar) {
        this.f13747a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.f13748c = new ConcurrentHashMap();
        this.g = (l) f.a(lVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            p.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new RunnableC0569c(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new q("127.0.0.1", this.e);
            com.opos.cmn.an.f.a.a("HttpProxyCacheServer", "Proxy cache server started. Is it alive? " + a());
        } catch (IOException | InterruptedException e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void a(File file) {
        try {
            this.g.f13759c.a(file);
        } catch (IOException e) {
            com.opos.cmn.an.f.a.d("HttpProxyCacheServer", "Error touching file " + file, e);
        }
    }

    private void a(Throwable th) {
        com.opos.cmn.an.f.a.d("HttpProxyCacheServer", "HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        StringBuilder sb;
        try {
            try {
                m a2 = m.a(socket.getInputStream());
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Request to cache proxy:" + a2);
                String c2 = h.c(a2.f13760a);
                if (this.h.a(c2)) {
                    this.h.a(socket);
                } else {
                    e(c2).a(a2, socket);
                }
                b(socket);
                sb = new StringBuilder();
            } catch (g e) {
                e = e;
                a(new g("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            } catch (SocketException e2) {
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                b(socket);
                sb = new StringBuilder();
            } catch (IOException e3) {
                e = e3;
                a(new g("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(c());
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", sb.toString());
        } catch (Throwable th) {
            b(socket);
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Opened connections: " + c());
            throw th;
        }
    }

    private boolean a() {
        return this.h.a(3, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.d.accept();
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Accept new socket " + accept);
                this.b.submit(new b(accept));
            } catch (IOException e) {
                a(new g("Error during waiting connection", e));
                return;
            }
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private int c() {
        int i;
        synchronized (this.f13747a) {
            i = 0;
            for (o oVar : this.f13748c.values()) {
                i += oVar.a();
            }
        }
        return i;
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.e), h.b(str));
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException e) {
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            a(new g("Error closing socket input stream", e2));
        }
    }

    private File d(String str) {
        return this.g.a(str);
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            com.opos.cmn.an.f.a.a("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.", (Throwable) e);
        }
    }

    private o e(String str) {
        o oVar;
        synchronized (this.f13747a) {
            o oVar2 = this.f13748c.get(str);
            oVar = oVar2;
            if (oVar2 == null) {
                oVar = new o(str, this.g);
                this.f13748c.put(str, oVar);
            }
        }
        return oVar;
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            a(new g("Error closing socket", e));
        }
    }

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z) {
        if (z && b(str)) {
            File d = d(str);
            a(d);
            return Uri.fromFile(d).toString();
        }
        String str2 = str;
        if (a()) {
            str2 = c(str);
        }
        return str2;
    }

    public boolean b(String str) {
        f.a(str, "Url can't be null!");
        return d(str).exists();
    }
}
