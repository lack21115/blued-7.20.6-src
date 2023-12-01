package com.opos.exoplayer.core.h;

import android.net.Uri;
import android.net.wifi.WifiEnterpriseConfig;
import com.google.common.net.HttpHeaders;
import com.opos.exoplayer.core.h.q;
import com.opos.exoplayer.core.i.u;
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
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/n.class */
public class n implements q {
    private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<byte[]> f25461c = new AtomicReference<>();
    private final boolean d;
    private final int e;
    private final int f;
    private final String g;
    private final com.opos.exoplayer.core.i.o<String> h;
    private final q.f i;
    private final q.f j = new q.f();
    private final t<? super n> k;
    private i l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;

    public n(String str, com.opos.exoplayer.core.i.o<String> oVar, t<? super n> tVar, int i, int i2, boolean z, q.f fVar) {
        this.g = com.opos.exoplayer.core.i.a.a(str);
        this.h = oVar;
        this.k = tVar;
        this.e = i;
        this.f = i2;
        this.d = z;
        this.i = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(java.net.HttpURLConnection r5) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.h.n.a(java.net.HttpURLConnection):long");
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
        q.f fVar = this.i;
        if (fVar != null) {
            for (Map.Entry<String, String> entry : fVar.a().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.j.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            String str2 = str;
            if (j2 != -1) {
                str2 = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.g);
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
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        if (u.f25510a == 19 || u.f25510a == 20) {
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
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    private int b(byte[] bArr, int i, int i2) {
        int read;
        if (i2 == 0) {
            return 0;
        }
        long j = this.q;
        int i3 = i2;
        if (j != -1) {
            long j2 = j - this.s;
            read = -1;
            if (j2 != 0) {
                i3 = (int) Math.min(i2, j2);
            }
            return read;
        }
        read = this.n.read(bArr, i, i3);
        if (read == -1) {
            if (this.q == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.s += read;
        t<? super n> tVar = this.k;
        if (tVar != null) {
            tVar.a((t<? super n>) this, read);
        }
        return read;
    }

    private HttpURLConnection b(i iVar) {
        HttpURLConnection a2;
        URL url = new URL(iVar.f25449a.toString());
        byte[] bArr = iVar.b;
        long j = iVar.d;
        long j2 = iVar.e;
        boolean a3 = iVar.a(1);
        if (this.d) {
            int i = 0;
            URL url2 = url;
            while (true) {
                int i2 = i + 1;
                if (i > 20) {
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
                a2 = a(url2, bArr, j, j2, a3, false);
                int responseCode = a2.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    bArr = null;
                    String headerField = a2.getHeaderField(HttpHeaders.LOCATION);
                    a2.disconnect();
                    url2 = a(url2, headerField);
                    i = i2;
                }
            }
            return a2;
        }
        return a(url, bArr, j, j2, a3, true);
    }

    private void d() {
        if (this.r == this.p) {
            return;
        }
        byte[] andSet = f25461c.getAndSet(null);
        byte[] bArr = andSet;
        if (andSet == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j = this.r;
            long j2 = this.p;
            if (j == j2) {
                f25461c.set(bArr);
                return;
            }
            int read = this.n.read(bArr, 0, (int) Math.min(j2 - j, bArr.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            this.r += read;
            t<? super n> tVar = this.k;
            if (tVar != null) {
                tVar.a((t<? super n>) this, read);
            }
        }
    }

    private void e() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.m = null;
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
        try {
            d();
            return b(bArr, i, i2);
        } catch (IOException e) {
            throw new q.c(e, this.l, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb  */
    @Override // com.opos.exoplayer.core.h.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(com.opos.exoplayer.core.h.i r8) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.h.n.a(com.opos.exoplayer.core.h.i):long");
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        try {
            if (this.n != null) {
                a(this.m, c());
                try {
                    this.n.close();
                } catch (IOException e) {
                    throw new q.c(e, this.l, 3);
                }
            }
        } finally {
            this.n = null;
            e();
            if (this.o) {
                this.o = false;
                t<? super n> tVar = this.k;
                if (tVar != null) {
                    tVar.a(this);
                }
            }
        }
    }

    protected final long c() {
        long j = this.q;
        return j == -1 ? j : j - this.s;
    }
}
