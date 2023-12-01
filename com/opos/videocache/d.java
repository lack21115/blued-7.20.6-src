package com.opos.videocache;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/d.class */
public class d implements i {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.videocache.c.b f27442a;
    private final com.opos.videocache.b.b b;

    /* renamed from: c  reason: collision with root package name */
    private j f27443c;
    private HttpURLConnection d;
    private InputStream e;

    public d(d dVar) {
        this.f27443c = dVar.f27443c;
        this.f27442a = dVar.f27442a;
        this.b = dVar.b;
    }

    public d(String str) {
        this(str, com.opos.videocache.c.c.a());
    }

    public d(String str, com.opos.videocache.c.b bVar) {
        this(str, bVar, new com.opos.videocache.b.a());
    }

    public d(String str, com.opos.videocache.c.b bVar, com.opos.videocache.b.b bVar2) {
        this.f27442a = (com.opos.videocache.c.b) f.a(bVar);
        this.b = (com.opos.videocache.b.b) f.a(bVar2);
        j a2 = bVar.a(str);
        this.f27443c = a2 != null ? a2 : new j(str, -2147483648L, h.a(str));
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long a2 = a(httpURLConnection);
        return i == 200 ? a2 : i == 206 ? a2 + j : this.f27443c.b;
    }

    private HttpURLConnection a(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f27443c.f27444a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.opos.cmn.an.f.a.b("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            a(httpURLConnection, str2);
            if (i3 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            int i4 = i2;
            if (z) {
                str2 = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                i4 = i2 + 1;
                httpURLConnection.disconnect();
            }
            if (i4 > 5) {
                throw new g("Too many redirects: " + i4);
            }
            i2 = i4;
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.videocache.d.e():void");
    }

    @Override // com.opos.videocache.i
    public int a(byte[] bArr) {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new g("Error reading data from " + this.f27443c.f27444a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new e("Reading source " + this.f27443c.f27444a + " is interrupted", e);
        } catch (IOException e2) {
            throw new g("Error reading data from " + this.f27443c.f27444a, e2);
        }
    }

    @Override // com.opos.videocache.i
    public long a() {
        long j;
        synchronized (this) {
            if (this.f27443c.b == -2147483648L) {
                e();
            }
            j = this.f27443c.b;
        }
        return j;
    }

    @Override // com.opos.videocache.i
    public void a(long j) {
        try {
            HttpURLConnection a2 = a(j, -1);
            this.d = a2;
            String contentType = a2.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), 8192);
            j jVar = new j(this.f27443c.f27444a, a(this.d, j, this.d.getResponseCode()), contentType);
            this.f27443c = jVar;
            this.f27442a.a(jVar.f27444a, this.f27443c);
        } catch (IOException e) {
            throw new g("Error opening connection for " + this.f27443c.f27444a + " with offset " + j, e);
        }
    }

    @Override // com.opos.videocache.i
    public void b() {
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                com.opos.cmn.an.f.a.d("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit. Until good solution is not know, just ignore this issue :(", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing .If you read it on your device log, please, notify me danikula@gmail.com or create issue here.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing .If you read it on your device log, please, notify me danikula@gmail.com or create issue here.", e);
            }
        }
    }

    public String c() {
        String str;
        synchronized (this) {
            if (TextUtils.isEmpty(this.f27443c.f27445c)) {
                e();
            }
            str = this.f27443c.f27445c;
        }
        return str;
    }

    public String d() {
        return this.f27443c.f27444a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f27443c + com.alipay.sdk.util.i.d;
    }
}
