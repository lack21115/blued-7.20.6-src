package com.igexin.push.e.a;

import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/a/b.class */
public class b extends com.igexin.c.a.d.f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23593a = b.class.getName();
    public static final int b = -2147483639;
    private static final int d = 20000;

    /* renamed from: c  reason: collision with root package name */
    public d f23594c;
    private HttpURLConnection e;

    public b(d dVar) {
        super(0);
        this.f23594c = dVar;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0128: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:61:0x0128 */
    private byte[] a(String str) {
        AutoCloseable autoCloseable;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                this.e = httpURLConnection;
                httpURLConnection.setConnectTimeout(20000);
                this.e.setReadTimeout(20000);
                this.e.setRequestMethod("GET");
                this.e.setDoInput(true);
                inputStream = this.e.getInputStream();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    autoCloseable = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                        }
                    }
                    if (autoCloseable != null) {
                        try {
                            autoCloseable.close();
                        } catch (Exception e3) {
                            com.igexin.c.a.c.a.a(e3);
                        }
                    }
                    g();
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                autoCloseable = null;
                inputStream = null;
            }
            try {
            } catch (Exception e5) {
                e = e5;
                com.igexin.c.a.c.a.a(e);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e7) {
                        e = e7;
                        com.igexin.c.a.c.a.a(e);
                        g();
                        return null;
                    }
                }
                g();
                return null;
            }
            if (this.e.getResponseCode() != 200) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e8) {
                        com.igexin.c.a.c.a.a(e8);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e9) {
                    e = e9;
                    com.igexin.c.a.c.a.a(e);
                    g();
                    return null;
                }
                g();
                return null;
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e10) {
                    com.igexin.c.a.c.a.a(e10);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e11) {
                com.igexin.c.a.c.a.a(e11);
            }
            g();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            inputStream = inputStream2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(java.lang.String r6, byte[] r7) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.a.b.a(java.lang.String, byte[]):byte[]");
    }

    private void g() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.e = null;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        g();
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        Process.setThreadPriority(10);
        d dVar = this.f23594c;
        if (dVar == null || dVar.f == null || (this.f23594c.g != null && this.f23594c.g.length > com.igexin.push.config.d.A * 1024)) {
            k();
            com.igexin.c.a.c.a.a(f23593a, "run return ###");
            com.igexin.c.a.c.a.a(f23593a + "|run return ###", new Object[0]);
            return;
        }
        try {
            byte[] a2 = this.f23594c.g == null ? a(this.f23594c.f) : a(this.f23594c.f, this.f23594c.g);
            if (a2 == null) {
                Exception exc = new Exception("Http response ＝＝ null");
                this.f23594c.a(exc);
                throw exc;
            }
            try {
                this.f23594c.a(a2);
                com.igexin.c.a.b.e.a().a(this.f23594c);
                com.igexin.c.a.b.e.a().b();
            } catch (Exception e) {
                this.f23594c.a(e);
                throw e;
            }
        } catch (Exception e2) {
            this.f23594c.a(e2);
            throw e2;
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483639;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        this.o = true;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
        g();
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
