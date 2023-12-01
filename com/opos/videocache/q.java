package com.opos.videocache;

import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f27457a = Executors.newSingleThreadExecutor();
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27458c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/q$a.class */
    class a implements Callable<Boolean> {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(q.this.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str, int i) {
        this.b = (String) f.a(str);
        this.f27458c = i;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        boolean z;
        d dVar = new d(c());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                dVar.a(0L);
                byte[] bArr = new byte[bytes.length];
                dVar.a(bArr);
                z = Arrays.equals(bytes, bArr);
                com.opos.cmn.an.f.a.a("Pinger", "Ping response: `" + new String(bArr) + "`, pinged? " + z);
            } catch (g e) {
                com.opos.cmn.an.f.a.d("Pinger", "Error reading ping response", e);
                z = false;
            }
            dVar.b();
            return z;
        } catch (Throwable th) {
            dVar.b();
            throw th;
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.b, Integer.valueOf(this.f27458c), "ping");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2) {
        f.a(i >= 1);
        f.a(i2 > 0);
        int i3 = i2;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at. Default proxies are: %s", Integer.valueOf(i5), Integer.valueOf(i3 / 2), a());
                com.opos.cmn.an.f.a.d("Pinger", format, new g(format));
                return false;
            }
            try {
            } catch (InterruptedException e) {
                e = e;
                com.opos.cmn.an.f.a.d("Pinger", "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                com.opos.cmn.an.f.a.d("Pinger", "Error pinging server due to unexpected error", e);
            } catch (TimeoutException e3) {
                com.opos.cmn.an.f.a.c("Pinger", "Error pinging server (attempt: " + i5 + ", timeout: " + i3 + "). ");
            }
            if (((Boolean) this.f27457a.submit(new a()).get(i3, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3 *= 2;
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return "ping".equals(str);
    }
}
