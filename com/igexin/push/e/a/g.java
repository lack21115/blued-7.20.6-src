package com.igexin.push.e.a;

import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/a/g.class */
public final class g extends com.igexin.c.a.d.f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9992a = -2147483638;

    /* renamed from: c  reason: collision with root package name */
    private static final String f9993c = "SimpleHttpTask";
    private static final int d = 20000;
    private static final int e = 3;
    public d b;
    private HttpURLConnection f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/a/g$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f9994a;
        byte[] b;

        public a(boolean z, byte[] bArr) {
            this.f9994a = z;
            this.b = bArr;
        }
    }

    private g(d dVar) {
        super(0);
        this.b = dVar;
    }

    private a a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            this.f = httpURLConnection;
            httpURLConnection.setConnectTimeout(20000);
            this.f.setReadTimeout(20000);
            this.f.setRequestMethod("GET");
            this.f.setDoInput(true);
            HttpURLConnection httpURLConnection2 = this.f;
            this.f = httpURLConnection2;
            byte[] a2 = a(httpURLConnection2);
            if (a2 != null) {
                return b(a2);
            }
        } finally {
            try {
                g();
                return new a(false, null);
            } finally {
            }
        }
        g();
        return new a(false, null);
    }

    private a a(String str, byte[] bArr) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            this.f = httpURLConnection;
            httpURLConnection.setDoInput(true);
            this.f.setDoOutput(true);
            this.f.setRequestMethod("POST");
            this.f.setUseCaches(false);
            this.f.setInstanceFollowRedirects(true);
            this.f.setRequestProperty("Content-Type", "application/octet-stream");
            this.f.setConnectTimeout(20000);
            this.f.setReadTimeout(20000);
            this.f = this.f;
        } catch (Throwable th) {
            th = th;
            dataOutputStream = null;
        }
        if (bArr == null) {
            a aVar = new a(true, null);
            com.igexin.c.a.b.g.a((Closeable) null);
            g();
            return aVar;
        }
        byte[] b = com.igexin.c.b.a.b(bArr);
        this.f.connect();
        dataOutputStream = new DataOutputStream(this.f.getOutputStream());
        try {
            dataOutputStream.write(b, 0, b.length);
            dataOutputStream.flush();
            byte[] a2 = a(this.f);
            dataOutputStream2 = dataOutputStream;
            if (a2 != null) {
                a b2 = b(a2);
                com.igexin.c.a.b.g.a(dataOutputStream);
                g();
                return b2;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                com.igexin.c.a.c.a.a(th);
                dataOutputStream2 = dataOutputStream;
                com.igexin.c.a.b.g.a(dataOutputStream2);
                g();
                return new a(false, null);
            } catch (Throwable th3) {
                com.igexin.c.a.b.g.a(dataOutputStream);
                g();
                throw th3;
            }
        }
        com.igexin.c.a.b.g.a(dataOutputStream2);
        g();
        return new a(false, null);
    }

    private void a(byte[] bArr) {
        try {
            this.b.a(bArr);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static byte[] a(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream2 = httpURLConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.igexin.c.a.b.g.a(inputStream2);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e2) {
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    com.igexin.c.a.b.g.a(inputStream);
                    throw th;
                }
            } else {
                inputStream2 = httpURLConnection.getErrorStream();
            }
        } catch (Exception e3) {
            inputStream2 = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
        com.igexin.c.a.b.g.a(inputStream2);
        return null;
    }

    private a b(byte[] bArr) {
        try {
            return new a(false, bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new a(true, null);
        }
    }

    private HttpURLConnection b(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f = httpURLConnection;
        httpURLConnection.setDoInput(true);
        this.f.setDoOutput(true);
        this.f.setRequestMethod("POST");
        this.f.setUseCaches(false);
        this.f.setInstanceFollowRedirects(true);
        this.f.setRequestProperty("Content-Type", "application/octet-stream");
        this.f.setConnectTimeout(20000);
        this.f.setReadTimeout(20000);
        return this.f;
    }

    private HttpURLConnection c(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f = httpURLConnection;
        httpURLConnection.setConnectTimeout(20000);
        this.f.setReadTimeout(20000);
        this.f.setRequestMethod("GET");
        this.f.setDoInput(true);
        return this.f;
    }

    private void g() {
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.f = null;
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
    }

    private boolean h() {
        return this.b.l && com.igexin.push.f.a.a();
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        Process.setThreadPriority(10);
        d dVar = this.b;
        if (dVar == null || dVar.f == null) {
            g();
            com.igexin.c.a.c.a.a(f9993c, "run return ###");
            com.igexin.c.a.c.a.a("SimpleHttpTask|run return ###", new Object[0]);
            return;
        }
        for (int i = 0; i < 3; i++) {
            a a2 = this.b.g == null ? a(this.b.f) : a(this.b.f, this.b.g);
            if (a2.b != null) {
                try {
                    this.b.a(a2.b);
                    return;
                } catch (Exception e2) {
                    com.igexin.c.a.c.a.a(e2);
                    return;
                }
            }
            if (i == 2) {
                this.b.a(new Exception("try up to limit"));
                com.igexin.c.a.c.a.a(f9993c, "http request exception, try times = " + (i + 1));
            }
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483638;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
        g();
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
