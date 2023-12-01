package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import android.net.wifi.WifiEnterpriseConfig;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.exoplayer.j.s;
import com.anythink.expressad.exoplayer.k.af;
import com.google.common.net.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/p.class */
public final class p implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4758a = 8000;
    public static final int b = 8000;
    private static final String d = "DefaultHttpDataSource";
    private static final int e = 20;
    private static final long f = 2048;
    private static final Pattern g = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> h = new AtomicReference<>();
    private final boolean i;
    private final int j;
    private final int k;
    private final String l;
    private final com.anythink.expressad.exoplayer.k.u<String> m;
    private final s.f n;
    private final s.f o;
    private final aa<? super p> p;
    private k q;
    private HttpURLConnection r;
    private InputStream s;
    private boolean t;
    private long u;
    private long v;
    private long w;
    private long x;

    private p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar) {
        this(str, uVar, null);
    }

    private p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar, aa<? super p> aaVar) {
        this(str, uVar, aaVar, (byte) 0);
    }

    private p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar, aa<? super p> aaVar, byte b2) {
        this(str, uVar, aaVar, 8000, 8000, false, null);
    }

    public p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar, aa<? super p> aaVar, int i, int i2, boolean z, s.f fVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.l = str;
        this.m = uVar;
        this.p = aaVar;
        this.o = new s.f();
        this.j = i;
        this.k = i2;
        this.i = z;
        this.n = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(java.net.HttpURLConnection r5) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.p.a(java.net.HttpURLConnection):long");
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.j);
        httpURLConnection.setReadTimeout(this.k);
        s.f fVar = this.n;
        if (fVar != null) {
            for (Map.Entry<String, String> entry : fVar.b().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.o.b().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str2 = str;
            if (j2 != -1) {
                str2 = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.l);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", WifiEnterpriseConfig.IDENTITY_KEY);
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private static URL a(URL url, String str) {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        if (af.f4793a == 19 || af.f4793a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e2) {
            }
        }
    }

    private int b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.v;
        int i3 = i2;
        if (j != -1) {
            long j2 = j - this.x;
            if (j2 == 0) {
                return -1;
            }
            i3 = (int) Math.min(i2, j2);
        }
        int read = this.s.read(bArr, i, i3);
        if (read == -1) {
            if (this.v == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.x += read;
        aa<? super p> aaVar = this.p;
        if (aaVar != null) {
            aaVar.a(read);
        }
        return read;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.HttpURLConnection b(com.anythink.expressad.exoplayer.j.k r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.p.b(com.anythink.expressad.exoplayer.j.k):java.net.HttpURLConnection");
    }

    private HttpURLConnection e() {
        return this.r;
    }

    private long f() {
        return this.w;
    }

    private long g() {
        return this.x;
    }

    private long h() {
        long j = this.v;
        return j == -1 ? j : j - this.x;
    }

    private void i() {
        if (this.w == this.u) {
            return;
        }
        byte[] andSet = h.getAndSet(null);
        byte[] bArr = andSet;
        if (andSet == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j = this.w;
            long j2 = this.u;
            if (j == j2) {
                h.set(bArr);
                return;
            }
            int read = this.s.read(bArr, 0, (int) Math.min(j2 - j, bArr.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            this.w += read;
            aa<? super p> aaVar = this.p;
            if (aaVar != null) {
                aaVar.a(read);
            }
        }
    }

    private void j() {
        HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e(d, "Unexpected error while disconnecting", e2);
            }
            this.r = null;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        try {
            if (this.w != this.u) {
                byte[] andSet = h.getAndSet(null);
                byte[] bArr2 = andSet;
                if (andSet == null) {
                    bArr2 = new byte[4096];
                }
                while (this.w != this.u) {
                    int read = this.s.read(bArr2, 0, (int) Math.min(this.u - this.w, bArr2.length));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.w += read;
                    if (this.p != null) {
                        this.p.a(read);
                    }
                }
                h.set(bArr2);
            }
            if (i2 == 0) {
                return 0;
            }
            int i3 = i2;
            if (this.v != -1) {
                long j = this.v - this.x;
                if (j == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i2, j);
            }
            int read2 = this.s.read(bArr, i, i3);
            if (read2 == -1) {
                if (this.v == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.x += read2;
            if (this.p != null) {
                this.p.a(read2);
            }
            return read2;
        } catch (IOException e2) {
            throw new s.c(e2, this.q, 2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        HttpURLConnection a2;
        HttpURLConnection httpURLConnection;
        this.q = kVar;
        this.x = 0L;
        this.w = 0L;
        try {
            URL url = new URL(kVar.f4745c.toString());
            byte[] bArr = kVar.d;
            long j = kVar.f;
            long j2 = kVar.g;
            boolean a3 = kVar.a(1);
            if (this.i) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    int i3 = i2 + 1;
                    if (i2 > 20) {
                        throw new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i3)));
                    }
                    a2 = a(url, bArr, j, j2, a3, false);
                    int responseCode = a2.getResponseCode();
                    if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                        bArr = null;
                        String headerField = a2.getHeaderField(HttpHeaders.LOCATION);
                        a2.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        url = new URL(url, headerField);
                        String protocol = url.getProtocol();
                        if (!"https".equals(protocol) && !"http".equals(protocol)) {
                            throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                        }
                        i = i3;
                    }
                }
                httpURLConnection = a2;
            } else {
                httpURLConnection = a(url, bArr, j, j2, a3, true);
            }
            this.r = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.r.getHeaderFields();
                    j();
                    s.e eVar = new s.e(responseCode2, headerFields, kVar);
                    if (responseCode2 == 416) {
                        eVar.initCause(new i());
                    }
                    throw eVar;
                }
                String contentType = this.r.getContentType();
                com.anythink.expressad.exoplayer.k.u<String> uVar = this.m;
                if (uVar != null && !uVar.a(contentType)) {
                    j();
                    throw new s.d(contentType, kVar);
                }
                long j3 = 0;
                if (responseCode2 == 200) {
                    j3 = 0;
                    if (kVar.f != 0) {
                        j3 = kVar.f;
                    }
                }
                this.u = j3;
                if (kVar.a(1)) {
                    this.v = kVar.g;
                } else {
                    long j4 = -1;
                    if (kVar.g != -1) {
                        this.v = kVar.g;
                    } else {
                        long a4 = a(this.r);
                        if (a4 != -1) {
                            j4 = a4 - this.u;
                        }
                        this.v = j4;
                    }
                }
                try {
                    this.s = this.r.getInputStream();
                    this.t = true;
                    aa<? super p> aaVar = this.p;
                    if (aaVar != null) {
                        aaVar.b();
                    }
                    return this.v;
                } catch (IOException e2) {
                    j();
                    throw new s.c(e2, kVar, 1);
                }
            } catch (IOException e3) {
                j();
                throw new s.c("Unable to connect to " + kVar.f4745c.toString(), e3, kVar);
            }
        } catch (IOException e4) {
            throw new s.c("Unable to connect to " + kVar.f4745c.toString(), e4, kVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void a(String str) {
        com.anythink.expressad.exoplayer.k.a.a(str);
        this.o.a(str);
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void a(String str, String str2) {
        com.anythink.expressad.exoplayer.k.a.a(str);
        com.anythink.expressad.exoplayer.k.a.a(str2);
        this.o.a(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0116, code lost:
        if (r8 > 2048) goto L28;
     */
    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.p.b():void");
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final Map<String, List<String>> c() {
        HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void d() {
        this.o.a();
    }
}
