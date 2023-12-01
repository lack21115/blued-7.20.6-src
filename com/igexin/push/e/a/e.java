package com.igexin.push.e.a;

import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/a/e.class */
public class e extends com.igexin.c.a.d.f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9988a = -2147483638;

    /* renamed from: c  reason: collision with root package name */
    private static final String f9989c = "HttpTask";
    private static final int d = 20000;
    private static final int e = 3;
    public d b;
    private HttpURLConnection f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/a/e$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f9990a;
        byte[] b;

        public a(boolean z, byte[] bArr) {
            this.f9990a = z;
            this.b = bArr;
        }
    }

    public e(d dVar) {
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
            a(this.f, (byte[]) null);
            HttpURLConnection httpURLConnection2 = this.f;
            this.f = httpURLConnection2;
            byte[] a2 = a(httpURLConnection2);
            if (a2 != null) {
                return b(this.f, a2);
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
        byte[] a2;
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
            a(this.f, bArr);
            HttpURLConnection httpURLConnection2 = this.f;
            this.f = httpURLConnection2;
            a2 = a(bArr, httpURLConnection2);
        } catch (Throwable th) {
            th = th;
            dataOutputStream = null;
        }
        if (a2 == null) {
            a aVar = new a(true, null);
            com.igexin.c.a.b.g.a((Closeable) null);
            g();
            return aVar;
        }
        this.f.connect();
        dataOutputStream = new DataOutputStream(this.f.getOutputStream());
        try {
            dataOutputStream.write(a2, 0, a2.length);
            dataOutputStream.flush();
            byte[] a3 = a(this.f);
            dataOutputStream2 = dataOutputStream;
            if (a3 != null) {
                a b = b(this.f, a3);
                com.igexin.c.a.b.g.a(dataOutputStream);
                g();
                return b;
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

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        if (httpURLConnection == null) {
            return;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        httpURLConnection.addRequestProperty("GT_C_T", "1");
        httpURLConnection.addRequestProperty("GT_C_K", new String(com.igexin.push.f.g.c()));
        httpURLConnection.addRequestProperty("GT_C_V", com.igexin.push.f.g.f());
        String valueOf = String.valueOf(System.currentTimeMillis());
        String a2 = com.igexin.push.f.g.a(valueOf, bArr);
        httpURLConnection.addRequestProperty("GT_T", valueOf);
        httpURLConnection.addRequestProperty("GT_C_S", a2);
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
        InputStream inputStream2;
        try {
            InputStream inputStream3 = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                inputStream2 = inputStream3;
                if (httpURLConnection.getResponseCode() == 200) {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream3.read(bArr);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.igexin.c.a.b.g.a(inputStream3);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
            } catch (Exception e2) {
                inputStream2 = inputStream3;
            } catch (Throwable th) {
                inputStream = inputStream3;
                th = th;
                com.igexin.c.a.b.g.a(inputStream);
                throw th;
            }
        } catch (Exception e3) {
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        com.igexin.c.a.b.g.a(inputStream2);
        return null;
    }

    private static byte[] a(byte[] bArr, HttpURLConnection httpURLConnection) {
        String requestProperty;
        try {
            if (!httpURLConnection.getRequestProperties().containsKey("GT_C_S") || (requestProperty = httpURLConnection.getRequestProperty("GT_C_S")) == null) {
                return null;
            }
            return com.igexin.push.f.g.a(bArr, com.igexin.push.f.g.c(requestProperty.getBytes()));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private a b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            if (this.b.l && com.igexin.push.f.a.a()) {
                String headerField = httpURLConnection.getHeaderField("GT_ERR");
                if (headerField != null && headerField.equals("0")) {
                    String headerField2 = httpURLConnection.getHeaderField("GT_T");
                    if (headerField2 == null) {
                        com.igexin.c.a.c.a.a(f9989c, "GT_T = null");
                        com.igexin.c.a.c.a.a("HttpTask|GT_T = null", new Object[0]);
                        return new a(true, null);
                    }
                    String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
                    if (headerField3 == null) {
                        com.igexin.c.a.c.a.a(f9989c, "GT_C_S = null");
                        com.igexin.c.a.c.a.a("HttpTask|GT_C_S = null", new Object[0]);
                        return new a(true, null);
                    }
                    byte[] b = com.igexin.push.f.g.b(bArr, com.igexin.push.f.g.c(headerField2.getBytes()));
                    String a2 = com.igexin.push.f.g.a(headerField2, b);
                    if (a2 != null && a2.equals(headerField3)) {
                        return new a(false, b);
                    }
                    com.igexin.c.a.c.a.a(f9989c, "signature = null or error");
                    com.igexin.c.a.c.a.a("HttpTask|signature = null or error", new Object[0]);
                    return new a(true, null);
                }
                com.igexin.c.a.c.a.a(f9989c, "GT_ERR = ".concat(String.valueOf(headerField)));
                com.igexin.c.a.c.a.a("HttpTask|GT_ERR = ".concat(String.valueOf(headerField)), new Object[0]);
                return new a(true, null);
            }
            return new a(false, bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new a(true, null);
        }
    }

    private HttpURLConnection b(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f = httpURLConnection;
        httpURLConnection.setConnectTimeout(20000);
        this.f.setReadTimeout(20000);
        this.f.setRequestMethod("GET");
        this.f.setDoInput(true);
        a(this.f, (byte[]) null);
        return this.f;
    }

    private HttpURLConnection b(String str, byte[] bArr) throws Exception {
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
        a(this.f, bArr);
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
        if (dVar == null || dVar.f == null || (this.b.g != null && this.b.g.length > com.igexin.push.config.d.A * 1024)) {
            g();
            com.igexin.c.a.c.a.a(f9989c, "run return ###");
            com.igexin.c.a.c.a.a("HttpTask|run return ###", new Object[0]);
            return;
        }
        int i = 0;
        if (this.b.g != null) {
            i = 0;
            if (this.b.g.length > 0) {
                d dVar2 = this.b;
                dVar2.g = com.igexin.c.a.b.g.a(dVar2.g);
                i = 0;
            }
        }
        while (i < 3) {
            a a2 = this.b.g == null ? a(this.b.f) : a(this.b.f, this.b.g);
            if (a2.f9990a) {
                com.igexin.c.a.c.a.a(f9989c, "http server resp decode header error");
            } else if (a2.b != null) {
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
                com.igexin.c.a.c.a.a(f9989c, "http request exception, try times = " + (i + 1));
            }
            i++;
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
