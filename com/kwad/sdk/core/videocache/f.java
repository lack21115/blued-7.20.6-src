package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ao;
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

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/f.class */
public final class f {
    private final Object anF;
    private final ExecutorService anG;
    private final Map<String, g> anH;
    private final ServerSocket anI;
    private final Thread anJ;
    private final com.kwad.sdk.core.videocache.c anK;
    private final int port;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/f$a.class */
    public static final class a {
        private File ant;
        private com.kwad.sdk.core.videocache.c.b anw;
        private com.kwad.sdk.core.videocache.kwai.a anv = new com.kwad.sdk.core.videocache.kwai.g(536870912);
        private com.kwad.sdk.core.videocache.kwai.c anu = new com.kwad.sdk.core.videocache.kwai.f();
        private com.kwad.sdk.core.videocache.a.b anx = new com.kwad.sdk.core.videocache.a.a();

        public a(Context context) {
            this.anw = com.kwad.sdk.core.videocache.c.c.bc(context);
            this.ant = n.aZ(context);
        }

        private com.kwad.sdk.core.videocache.c yA() {
            return new com.kwad.sdk.core.videocache.c(this.ant, this.anu, this.anv, this.anw, this.anx);
        }

        public final a U(long j) {
            this.anv = new com.kwad.sdk.core.videocache.kwai.g(104857600L);
            return this;
        }

        public final f yz() {
            return new f(yA(), (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/f$b.class */
    public final class b implements Runnable {
        private final Socket anL;

        public b(Socket socket) {
            this.anL = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.anL);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/f$c.class */
    final class c implements Runnable {
        private final CountDownLatch anN;

        public c(CountDownLatch countDownLatch) {
            this.anN = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.anN.countDown();
                f.this.yx();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.anF = new Object();
        this.anG = GlobalThreadPools.xS();
        this.anH = new ConcurrentHashMap();
        this.anK = (com.kwad.sdk.core.videocache.c) ao.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.anI = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.anJ = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.anG.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.StringBuilder] */
    public void a(Socket socket) {
        try {
            try {
                d b2 = d.b(socket.getInputStream());
                com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Request to cache proxy:" + b2);
                cY(k.decode(b2.uri)).a(b2, socket);
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            }
            socket.append(yy());
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", socket.toString());
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Opened connections: " + yy());
            throw th;
        }
    }

    private File aW(String str) {
        return new File(this.anK.ant, this.anK.anu.generate(str));
    }

    private String b(String str, boolean z) {
        if (aW(str).exists()) {
            File aW = aW(str);
            m(aW);
            return Uri.fromFile(aW).toString();
        }
        return cW(str);
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException e) {
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket input stream", e2));
        }
    }

    private boolean cT(String str) {
        ao.ah(str, "Url can't be null!");
        return aW(str).exists();
    }

    private String cW(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), k.encode(str));
    }

    private File cX(String str) {
        File file = this.anK.ant;
        return new File(file, this.anK.anu.generate(str) + ".download");
    }

    private g cY(String str) {
        g gVar;
        synchronized (this.anF) {
            g gVar2 = this.anH.get(str);
            gVar = gVar2;
            if (gVar2 == null) {
                gVar = new g(str, this.anK);
                this.anH.put(str, gVar);
            }
        }
        return gVar;
    }

    private static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private void m(File file) {
        try {
            this.anK.anv.n(file);
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.anI.accept();
                com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.anG.submit(new b(accept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private int yy() {
        int i;
        synchronized (this.anF) {
            i = 0;
            for (g gVar : this.anH.values()) {
                i += gVar.yy();
            }
        }
        return i;
    }

    public final boolean a(String str, int i, a.C0564a c0564a) {
        com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (cT(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.kwai.a.a(cW(str), null, c0564a, i);
    }

    public final String cS(String str) {
        return b(str, true);
    }

    public final boolean cU(String str) {
        ao.ah(str, "Url can't be null!");
        return cX(str).exists() || aW(str).exists();
    }

    public final boolean cV(String str) {
        g gVar = this.anH.get(str);
        if (gVar != null) {
            gVar.shutdown();
            this.anH.remove(str);
            return true;
        }
        return false;
    }
}
